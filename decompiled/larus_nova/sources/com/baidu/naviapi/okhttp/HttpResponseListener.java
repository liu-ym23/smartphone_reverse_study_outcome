package com.baidu.naviapi.okhttp;

/* JADX INFO: loaded from: classes39.dex */
public interface HttpResponseListener<T> {
    void onError(String r100);

    void onResponse(T r100);
}
