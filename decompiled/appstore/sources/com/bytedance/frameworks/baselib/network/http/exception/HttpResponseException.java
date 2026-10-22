package com.bytedance.frameworks.baselib.network.http.exception;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final int statusCode;

    public HttpResponseException(int r10, String r11) {
        super(r11);
        this.statusCode = r10;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
