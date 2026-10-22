package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.interceptor.AddHeaderInterceptor;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventFactory;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3Instrumentation {
    public OkHttp3Instrumentation() {
    }

    public static OkHttpClient build(OkHttpClient.Builder r10) {
        OkHttpClient r11 = r10.c();
        int r12 = r10.l().size() - 1;
    L3:
        if (r12 < 0) goto L9;
        if ((r10.l().get(r12) instanceof AddHeaderInterceptor) == true) goto L6;
        r12 = r12 - 1;
        goto L3
    L6:
        return r11;
    L9:
        return r10.a(new AddHeaderInterceptor()).j(new OkHttpEventFactory(r11.i())).c();
    }

    public static OkHttpClient init() {
        return new OkHttpClient.Builder().a(new AddHeaderInterceptor()).j(new OkHttpEventFactory(null)).c();
    }
}
