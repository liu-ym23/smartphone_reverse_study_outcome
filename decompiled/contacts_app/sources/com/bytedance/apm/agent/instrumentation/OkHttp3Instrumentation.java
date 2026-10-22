package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.interceptor.AddHeaderInterceptor;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventFactory;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttp3Instrumentation {
    public OkHttp3Instrumentation() {
    }

    public static OkHttpClient init() {
        return new OkHttpClient.Builder().addInterceptor(new AddHeaderInterceptor()).eventListenerFactory(new OkHttpEventFactory(null)).build();
    }

    public static OkHttpClient build(OkHttpClient.Builder r3) {
        OkHttpClient r0 = r3.build();
        int r1 = r3.interceptors().size() - 1;
    L3:
        if (r1 < 0) goto L9;
        if ((r3.interceptors().get(r1) instanceof AddHeaderInterceptor) == true) goto L6;
        r1 = r1 - 1;
        goto L3
    L6:
        return r0;
    L9:
        return r3.addInterceptor(new AddHeaderInterceptor()).eventListenerFactory(new OkHttpEventFactory(r0.eventListenerFactory())).build();
    }
}
