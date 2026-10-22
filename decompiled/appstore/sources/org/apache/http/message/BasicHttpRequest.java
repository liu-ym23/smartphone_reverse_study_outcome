package org.apache.http.message;

import org.apache.http.HttpRequest;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    private final String method;
    private RequestLine requestline;
    private final String uri;

    public BasicHttpRequest(String r10, String r11) {
        this.method = (String) Args.notNull(r10, "Method name");
        this.uri = (String) Args.notNull(r11, "Request URI");
        this.requestline = null;
    }

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return getRequestLine().getProtocolVersion();
    }

    @Override // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        if (this.requestline != null) goto L6;
        this.requestline = new BasicRequestLine(this.method, this.uri, HttpVersion.HTTP_1_1);
    L6:
        return this.requestline;
    }

    public String toString() {
        return this.method + TokenParser.SP + this.uri + TokenParser.SP + this.headergroup;
    }

    public BasicHttpRequest(String r10, String r11, ProtocolVersion r12) {
        this(new BasicRequestLine(r10, r11, r12));
    }

    public BasicHttpRequest(RequestLine r10) {
        this.requestline = (RequestLine) Args.notNull(r10, "Request line");
        this.method = r10.getMethod();
        this.uri = r10.getUri();
    }
}
