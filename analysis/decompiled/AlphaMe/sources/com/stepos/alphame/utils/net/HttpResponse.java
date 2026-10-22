package com.stepos.alphame.utils.net;

/* loaded from: classes.dex */
public class HttpResponse<T> {
    private T body;
    private ResponseInfo responseInfo;

    public T getBody() {
        return this.body;
    }

    public ResponseInfo getResponseInfo() {
        return this.responseInfo;
    }

    public void setBody(T t4) {
        this.body = t4;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }
}
