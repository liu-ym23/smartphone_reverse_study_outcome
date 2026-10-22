package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.interceptor.AddHeaderInterceptor;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventFactory;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes14.dex */
public class OkHttp3Instrumentation {
    public OkHttp3Instrumentation() {
    }

    public static OkHttpClient init() {
        return new OkHttpClient.Builder().addInterceptor(new AddHeaderInterceptor()).eventListenerFactory(new OkHttpEventFactory(null)).build();
    }

    public static OkHttpClient build(OkHttpClient.Builder r100) {
        OkHttpClient r101 = r100.build();
        int r102 = r100.interceptors().size() - 1;
    L3:
        if (r102 < 0) goto L9;
        if ((ListProtector.get(r100.interceptors(), r102) instanceof AddHeaderInterceptor) == true) goto L6;
        r102 = r102 - 1;
        goto L3
    L6:
        return r101;
    L9:
        return r100.addInterceptor(new AddHeaderInterceptor()).eventListenerFactory(new OkHttpEventFactory(r101.eventListenerFactory())).build();
    }
}
