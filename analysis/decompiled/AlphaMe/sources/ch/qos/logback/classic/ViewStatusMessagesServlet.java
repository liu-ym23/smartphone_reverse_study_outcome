package ch.qos.logback.classic;

import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.status.ViewStatusMessagesServletBase;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import n3.AbstractC0782c;

/* loaded from: classes.dex */
public class ViewStatusMessagesServlet extends ViewStatusMessagesServletBase {
    private static final long serialVersionUID = 443878494348593337L;

    @Override // ch.qos.logback.core.status.ViewStatusMessagesServletBase
    public String getPageTitle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "<h2>Status messages for LoggerContext named [" + ((LoggerContext) AbstractC0782c.c()).getName() + "]</h2>\r\n";
    }

    @Override // ch.qos.logback.core.status.ViewStatusMessagesServletBase
    public StatusManager getStatusManager(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return ((LoggerContext) AbstractC0782c.c()).getStatusManager();
    }
}
