package com.bytedance.framwork.core.monitor.internal;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpResponseException extends Exception {
    public String message;
    public int statusCode;

    public HttpResponseException(int r10, String r11) {
        this.statusCode = r10;
        this.message = r11;
    }

    public String getMsg() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
