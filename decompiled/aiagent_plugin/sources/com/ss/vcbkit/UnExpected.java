package com.ss.vcbkit;

import com.bytedance.crash.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class UnExpected {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f37588a = false;

    static {
    }

    public UnExpected() {
    }

    static void a() {
        if (f37588a == false) goto L9;
        return;
    L9:
        f.a();     // Catch: Throwable -> L7
        f37588a = true;     // Catch: Throwable -> L7
        return;
    L7:
        f37588a = false;
    }

    private static void notReachHereNative(String r2, String r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (f37588a == false) goto L6;
        f.a(r2, "", Thread.currentThread().getName(), r3, r5);
        return;
    }
}
