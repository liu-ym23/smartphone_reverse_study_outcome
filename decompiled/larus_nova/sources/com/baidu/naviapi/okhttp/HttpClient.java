package com.baidu.naviapi.okhttp;

/* JADX INFO: loaded from: classes39.dex */
public abstract class HttpClient {
    public abstract void cancelPendingRequest();

    public abstract void cancelPendingRequest(String r100);

    public abstract void sendRequest(RequestEntity r100, HttpResponseListener r101);

    public HttpClient() {
    }
}
