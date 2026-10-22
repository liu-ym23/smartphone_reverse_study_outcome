package org.apache.http.protocol;

import org.apache.http.HttpConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class HttpCoreContext implements HttpContext {
    public static final String HTTP_CONNECTION = "http.connection";
    public static final String HTTP_REQUEST = "http.request";
    public static final String HTTP_REQ_SENT = "http.request_sent";
    public static final String HTTP_RESPONSE = "http.response";
    public static final String HTTP_TARGET_HOST = "http.target_host";
    private final HttpContext context;

    public HttpCoreContext(HttpContext r10) {
        this.context = r10;
    }

    public static HttpCoreContext adapt(HttpContext r10) {
        Args.notNull(r10, "HTTP context");
        if ((r10 instanceof HttpCoreContext) == false) goto L6;
        return (HttpCoreContext) r10;
    L6:
        return new HttpCoreContext(r10);
    }

    public static HttpCoreContext create() {
        return new HttpCoreContext(new BasicHttpContext());
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object getAttribute(String r10) {
        return this.context.getAttribute(r10);
    }

    public <T extends HttpConnection> T getConnection(Class<T> r10) {
        return (T) getAttribute("http.connection", r10);
    }

    public HttpRequest getRequest() {
        return (HttpRequest) getAttribute("http.request", HttpRequest.class);
    }

    public HttpResponse getResponse() {
        return (HttpResponse) getAttribute("http.response", HttpResponse.class);
    }

    public HttpHost getTargetHost() {
        return (HttpHost) getAttribute("http.target_host", HttpHost.class);
    }

    public boolean isRequestSent() {
        Boolean r10 = (Boolean) getAttribute("http.request_sent", Boolean.class);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.booleanValue() == false) goto L7;
        return true;
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String r10) {
        return this.context.removeAttribute(r10);
    }

    @Override // org.apache.http.protocol.HttpContext
    public void setAttribute(String r10, Object r11) {
        this.context.setAttribute(r10, r11);
    }

    public void setTargetHost(HttpHost r10) {
        setAttribute("http.target_host", r10);
    }

    public <T> T getAttribute(String r10, Class<T> r11) {
        Args.notNull(r11, "Attribute class");
        Object r12 = getAttribute(r10);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r11.cast(r12);
    }

    public HttpConnection getConnection() {
        return (HttpConnection) getAttribute("http.connection", HttpConnection.class);
    }

    public HttpCoreContext() {
        this.context = new BasicHttpContext();
    }
}
