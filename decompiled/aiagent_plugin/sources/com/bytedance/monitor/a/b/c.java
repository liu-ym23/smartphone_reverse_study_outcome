package com.bytedance.monitor.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: AsyncTaskUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static d a() {
        return a.a();
    }

    public static String a(e r2) {
        e r3 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return "null";
    L7:
        return r3.a() + ", " + r3.b();
    }

    public static e a(String r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return a(b.f8909c, r2, r4);
    }

    public static e b(String r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return a(b.f8907a, r2, r4);
    }

    public static e a(final b r2, final String r3, Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        return new AnonymousClass1(r3, r2, r5);
    }

    public static void a(f r4, String r5, String r6) {
        f r7 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.a() == false) goto L9;
        String r0 = Thread.currentThread().getName();
        r7.a(r5, String.format(Locale.CHINA, "[callerThread: %s] \n %s", new Object[]{r0, r6}));
        return;
    }
}
