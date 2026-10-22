package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class HttpResponse {
    private byte[] body;
    private Object extraInfo;
    private List<NameValuePair> headers;
    private String mimeType;
    private String reason;
    private int statusCode;
    private InputStream stream;
    private String url;

    public HttpResponse() {
    }

    public byte[] getBody() {
        return this.body;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public List<NameValuePair> getHeaders() {
        return this.headers;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getReason() {
        return this.reason;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public String getUrl() {
        return this.url;
    }

    public String header(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.headers.size()) goto L10;
        if (r100.equalsIgnoreCase(((NameValuePair) ListProtector.get(this.headers, r101)).getName()) == true) goto L8;
        r101 = r101 + 1;
        goto L4
    L8:
        return ((NameValuePair) ListProtector.get(this.headers, r101)).getValue();
    L10:
        return null;
    }

    public HttpResponse setBody(byte[] r100) {
        this.body = r100;
        return this;
    }

    public void setExtraInfo(Object r100) {
        this.extraInfo = r100;
    }

    public HttpResponse setHeaders(List<NameValuePair> r100) {
        this.headers = r100;
        return this;
    }

    public HttpResponse setMimeType(String r100) {
        this.mimeType = r100;
        return this;
    }

    public HttpResponse setReason(String r100) {
        this.reason = r100;
        return this;
    }

    public HttpResponse setStatusCode(int r100) {
        this.statusCode = r100;
        return this;
    }

    public HttpResponse setStream(InputStream r100) {
        this.stream = r100;
        return this;
    }

    public HttpResponse setUrl(String r100) {
        this.url = r100;
        return this;
    }
}
