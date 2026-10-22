package com.bytedance.crash.b;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.o;
import com.bytedance.crash.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: DartCrash.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7254a;

    /* JADX INFO: renamed from: com.bytedance.crash.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DartCrash.java */
    static class RunnableC0160a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f7255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f7256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<? extends String, ? extends String> f7257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<String, String> f7258d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final w f7259e;
        private final String f;

        RunnableC0160a(String r3, long r4, String r6, Map<? extends String, ? extends String> r7, Map<String, String> r8, w r9) {
            Map<? extends String, ? extends String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
            w r12 = (w) ZeusTransformUtils.wrapperContextForParams(r9, w.class, "com.obric.aiagent.plugin");
            this.f7255a = r4;
            this.f7256b = r6;
            this.f7257c = r10;
            this.f7258d = r11;
            this.f7259e = r12;
            this.f = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.crash.monitor.a r0 = h.a();
            if (r0 != null) goto L5;
            return;
        L5:
            boolean r7 = false;
            com.bytedance.crash.entity.a r1 = b.a(r0, this.f, this.f7255a, this.f7256b, this.f7257c, this.f7258d);     // Catch: Throwable -> L11
            r7 = com.bytedance.crash.upload.b.a(o.a(CrashType.DART, r1.a().b()), r1.c());     // Catch: Throwable -> L11
        L7:
            w r8 = this.f7259e;
            if (r8 == null) goto L17;
            r8.a(r7);     // Catch: Throwable -> L12
            return;
        L18:
            return;
        }
    }

    public static void a(String r1) {
        a(r1, null, null, null);
    }

    public static void a(String r10, Map<? extends String, ? extends String> r11, Map<String, String> r12, w r13) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        w r9 = (w) ZeusTransformUtils.wrapperContextForParams(r13, w.class, "com.obric.aiagent.plugin");
        if (f7254a == false) goto L5;
        return;
    L5:
        long r4 = System.currentTimeMillis();
        DefaultWorkThread.post(new RunnableC0160a(Thread.currentThread().getName(), r4, r10, r7, r8, r9));
    }

    public static void a(boolean r0) {
        f7254a = r0;
    }
}
