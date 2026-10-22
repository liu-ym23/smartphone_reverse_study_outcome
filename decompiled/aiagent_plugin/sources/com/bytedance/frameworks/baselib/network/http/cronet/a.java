package com.bytedance.frameworks.baselib.network.http.cronet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: JavaInterceptorCallbackRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "JavaInterceptorCallback";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile IJavaInterceptorCallback f8196a;

    public static void a(IJavaInterceptorCallback r2) {
        f8196a = (IJavaInterceptorCallback) ZeusTransformUtils.wrapperContextForParams(r2, IJavaInterceptorCallback.class, "com.obric.aiagent.plugin");
    }

    public static String a(String r2, Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        IJavaInterceptorCallback r0 = f8196a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.onRequestInterceptorJava(r2, r4);
    }
}
