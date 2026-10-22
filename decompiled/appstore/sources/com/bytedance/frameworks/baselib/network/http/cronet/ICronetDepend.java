package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetDepend {
    String getSsCookieKey();

    void loggerD(String r10, String r11);

    boolean loggerDebug();

    void setAdapter(ICronetDepend r10);
}
