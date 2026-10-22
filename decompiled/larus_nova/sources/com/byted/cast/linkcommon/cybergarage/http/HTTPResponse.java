package com.byted.cast.linkcommon.cybergarage.http;

import com.byted.cast.common.ContextManager;
import java.io.InputStream;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPResponse extends HTTPPacket {
    private int statusCode;

    public String getHeader() {
        StringBuffer r100 = new StringBuffer();
        r100.append(getStatusLineString());
        r100.append(getHeaderString());
        return r100.toString();
    }

    public int getStatusCode() {
        int r100 = this.statusCode;
        if (r100 == 0) goto L6;
        return r100;
    L6:
        return new HTTPStatus(getFirstLine()).getStatusCode();
    }

    public String getStatusLineString() {
        return "HTTP/" + getVersion() + " " + getStatusCode() + " " + HTTPStatus.code2String(this.statusCode) + "\r\n";
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.append(getStatusLineString());
        r100.append(getHeaderString());
        r100.append("\r\n");
        r100.append(getContentString());
        return r100.toString();
    }

    public boolean isSuccessful() {
        return HTTPStatus.isSuccessful(getStatusCode());
    }

    public HTTPResponse(ContextManager.CastContext r100) {
        super(r100);
        this.statusCode = 0;
        setVersion("1.1");
        setContentType(HTML.CONTENT_TYPE);
        setServer(HTTPServer.getName());
        setContent("");
    }

    public void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public HTTPResponse(ContextManager.CastContext r100, HTTPResponse r101) {
        super(r100);
        this.statusCode = 0;
        set(r101);
    }

    public HTTPResponse(ContextManager.CastContext r100, HTTPSocket r101) {
        this(r100, r101.getInputStream());
    }

    public HTTPResponse(ContextManager.CastContext r100, InputStream r101) {
        super(r100, r101);
        this.statusCode = 0;
    }
}
