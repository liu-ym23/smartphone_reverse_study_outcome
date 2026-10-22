package ch.qos.logback.core.status;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.helpers.Transform;
import ch.qos.logback.core.util.CachingDateFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public abstract class ViewStatusMessagesServletBase extends HttpServlet {
    private static final long serialVersionUID = -3551928133801157219L;
    int count;
    private static CachingDateFormatter SDF = new CachingDateFormatter("yyyy-MM-dd HH:mm:ss");
    static String SUBMIT = "submit";
    static String CLEAR = "Clear";

    private void printStatus(StringBuilder sb, Status status) {
        AbstractC0831a.h(sb, "  <tr class=\"", this.count % 2 == 0 ? "even" : "odd", "\">\r\n");
        String str = SDF.format(status.getDate().longValue());
        sb.append("    <td class=\"date\">");
        sb.append(str);
        sb.append("</td>\r\n");
        sb.append("    <td class=\"level\">");
        sb.append(statusLevelAsString(status));
        sb.append("</td>\r\n");
        sb.append("    <td>");
        sb.append(abbreviatedOrigin(status));
        sb.append("</td>\r\n");
        sb.append("    <td>");
        sb.append(status.getMessage());
        sb.append("</td>\r\n");
        sb.append("  </tr>\r\n");
        if (status.getThrowable() != null) {
            printThrowable(sb, status.getThrowable());
        }
    }

    private void printThrowable(StringBuilder sb, Throwable th) {
        sb.append("  <tr>\r\n");
        sb.append("    <td colspan=\"4\" class=\"exception\"><pre>");
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        sb.append(Transform.escapeTags(stringWriter.getBuffer()));
        sb.append("    </pre></td>\r\n");
        sb.append("  </tr>\r\n");
    }

    public String abbreviatedOrigin(Status status) {
        Object origin = status.getOrigin();
        if (origin == null) {
            return null;
        }
        String name = origin.getClass().getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf != -1 ? name.substring(iLastIndexOf + 1, name.length()) : name;
    }

    public abstract String getPageTitle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    public abstract StatusManager getStatusManager(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    public void printCSS(String str, PrintWriter printWriter) {
        printWriter.append("  <STYLE TYPE=\"text/css\">\r\n");
        printWriter.append("    .warn  { font-weight: bold; color: #FF6600;} \r\n");
        printWriter.append("    .error { font-weight: bold; color: #CC0000;} \r\n");
        printWriter.append("    table { margin-left: 2em; margin-right: 2em; border-left: 2px solid #AAA; }\r\n");
        printWriter.append("    tr.even { background: #FFFFFF; }\r\n");
        printWriter.append("    tr.odd  { background: #EAEAEA; }\r\n");
        printWriter.append("    td { padding-right: 1ex; padding-left: 1ex; border-right: 2px solid #AAA; }\r\n");
        printWriter.append("    td.date { text-align: right; font-family: courier, monospace; font-size: smaller; }");
        String str2 = CoreConstants.LINE_SEPARATOR;
        printWriter.append((CharSequence) str2);
        printWriter.append("  td.level { text-align: right; }");
        printWriter.append((CharSequence) str2);
        printWriter.append("    tr.header { background: #596ED5; color: #FFF; font-weight: bold; font-size: larger; }");
        printWriter.append((CharSequence) str2);
        printWriter.append("  td.exception { background: #A2AEE8; white-space: pre; font-family: courier, monospace;}");
        printWriter.append((CharSequence) str2);
        printWriter.append("  </STYLE>\r\n");
    }

    public void printHeader(StringBuilder sb) {
        AbstractC0351g.C(sb, "  <tr class=\"header\">\r\n", "    <th>Date </th>\r\n", "    <th>Level</th>\r\n", "    <th>Origin</th>\r\n");
        sb.append("    <th>Message</th>\r\n");
        sb.append("  </tr>\r\n");
    }

    public void printList(StringBuilder sb, StatusManager statusManager) {
        sb.append("<table>\r\n");
        printHeader(sb);
        for (Status status : statusManager.getCopyOfStatusList()) {
            this.count++;
            printStatus(sb, status);
        }
        sb.append("</table>\r\n");
    }

    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.count = 0;
        StatusManager statusManager = getStatusManager(httpServletRequest, httpServletResponse);
        httpServletResponse.setContentType("text/html");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.append("<html>\r\n");
        writer.append("<head>\r\n");
        printCSS(httpServletRequest.getContextPath(), writer);
        writer.append("</head>\r\n");
        writer.append("<body>\r\n");
        writer.append(getPageTitle(httpServletRequest, httpServletResponse));
        writer.append("<form method=\"POST\">\r\n");
        writer.append("<input type=\"submit\" name=\"" + SUBMIT + "\" value=\"" + CLEAR + "\">");
        writer.append("</form>\r\n");
        if (CLEAR.equalsIgnoreCase(httpServletRequest.getParameter(SUBMIT))) {
            statusManager.clear();
            statusManager.add(new InfoStatus("Cleared all status messages", this));
        }
        writer.append("<table>");
        StringBuilder sb = new StringBuilder();
        if (statusManager != null) {
            printList(sb, statusManager);
        } else {
            writer.append("Could not find status manager");
        }
        writer.append((CharSequence) sb);
        writer.append("</table>");
        writer.append("</body>\r\n");
        writer.append("</html>\r\n");
        writer.flush();
        writer.close();
    }

    public String statusLevelAsString(Status status) {
        int effectiveLevel = status.getEffectiveLevel();
        if (effectiveLevel == 0) {
            return "INFO";
        }
        if (effectiveLevel == 1) {
            return "<span class=\"warn\">WARN</span>";
        }
        if (effectiveLevel != 2) {
            return null;
        }
        return "<span class=\"error\">ERROR</span>";
    }
}
