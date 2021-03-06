package UAV.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UAV.entity.UAVOnline;
import UAV.service.UAVOnlineInformationService;

public class ModifyUAVOnlineInfoServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("***************ModifyUAVOnlineInfoServlet****************");
		response.setContentType("text/xml");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String ip=request.getParameter("ipaddress");
		String po=request.getParameter("port");
		String lo=request.getParameter("longitude");
		String la=request.getParameter("latitude");
		String el=request.getParameter("elevation");
		String he=request.getParameter("height");
		String ve=request.getParameter("velocity");
				
		UAVOnlineInformationService uis=new UAVOnlineInformationService();
		UAVOnline uo=new UAVOnline();
		uo.setIpaddress(ip);
		uo.setPort(Integer.parseInt(po));
		uo.setElevation(Double.parseDouble(el));
		uo.setHeight(Double.parseDouble(he));
		uo.setLatitude(Double.parseDouble(la));
		uo.setLongitude(Double.parseDouble(lo));
		uo.setVelocity(Double.parseDouble(ve));
		boolean b=uis.modifyUAVOnline(uo);
		StringBuffer xml=new StringBuffer();
		if (b)
		{
			
			 xml.append("SUCCESSED");			
		}
		else
		{
			xml.append("FAILED");
		}		
		System.out.println(xml.toString());
		out.print(xml);
		out.flush();
		out.close();
	}	
}
