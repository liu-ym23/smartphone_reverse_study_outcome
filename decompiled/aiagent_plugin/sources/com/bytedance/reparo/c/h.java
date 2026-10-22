package com.bytedance.reparo.c;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: NpthService.java */
/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Runnable f9127a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9128b = false;

    static {
    }

    static /* synthetic */ boolean a(boolean r0) {
        f9128b = r0;
        return r0;
    }

    public static void a(Application r2, ExecutorService r3) {
        final Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        final ExecutorService r5 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        Runnable r0 = new AnonymousClass1(r4, r5);
        f9127a = r0;
        r5.execute(r0);
    }

    public static void a(String r1) {
        if (f9128b == false) goto L5;
        return;
    L5:
        com.bytedance.reparo.h.a(r1);
    }

    public static void a(String r1, String r2, Throwable r3) {
        if (f9128b == false) goto L5;
        return;
    L5:
        com.bytedance.reparo.h.a(r1, r2, r3);
    }
}
