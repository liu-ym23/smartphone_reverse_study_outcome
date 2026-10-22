package com.bytedance.mobsec.metasec.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import ms.bd.c.a1;
import ms.bd.c.g1;
import ms.bd.c.q0;
import ms.bd.c.r1;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static volatile long f8863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static volatile long f8864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static volatile long f8865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f8866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap f8867e = null;

    public interface a {
        void a(int r1);

        void a(String r1);

        void a(String r1, String r2);

        void b(String r1);

        void c(String r1);
    }

    static {
        f8867e = new ConcurrentHashMap();
    }

    public static synchronized e a(String r9) {
        monitor-enter(f.class);
        if (r9 == null) goto L23;
        if (f8866d == true) goto L11;
        monitor-exit(f.class);
        return null;
    L11:
        Object r1 = com.bytedance.mobsec.matrix.a.a(67108866, 0, 0, r9, null);     // Catch: Throwable -> L24
        if (r1 != null) goto L15;
        monitor-exit(f.class);
        return null;
    L15:
        c r10 = (c) ZeusTransformUtils.preCheckCast(f8867e.get(r9), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r10 != null) goto L19;
        monitor-exit(f.class);
        return null;
    L19:
        e r2 = new e(r10, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ((Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L24
        monitor-exit(f.class);
        return r2;
    L23:
        throw new NullPointerException("appID must be set");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private static void a(Context r2, final c r3, final String r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        new Thread(new $$Lambda$f$Jte1hfG7QtDo4xMRCJtCw6WAKw(r5, r3, r4)).start();
    }

    private static void b(Context r13, c r14, String r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        a1.a(r16);
        r1.a(r16).a();
        ms.bd.c.e.c();
    L4:
        if (r14.q == null) goto L42;
        String r17 = r14.f8853c;
        if (r17 != null) goto L9;
    L11:
        String r6 = r14.q.a();
        if (r6 == null) goto L30;
        if (r6.isEmpty() == true) goto L30;
        Object r18 = com.bytedance.mobsec.matrix.a.a(67108866, 0, 0, r15, null);
        if (r18 == null) goto L4;
        String r19 = r14.f8853c;
        if (r19 != null) goto L22;
    L24:
        r14.a(r6);
        com.bytedance.mobsec.matrix.a.a(33554446, 0, ((Long) ZeusTransformUtils.preCheckCast(r18, Long.class, "com.obric.aiagent.plugin")).longValue(), r6, 0);
        return;
    L22:
        if (r19.isEmpty() == true) goto L24;
        return;
    L30:
        Thread.sleep(500);     // Catch: InterruptedException -> L29
        goto L4
    L9:
        if (r17.isEmpty() == true) goto L11;
        return;
    }

    /* JADX INFO: renamed from: lambda$J-te1hfG7QtDo4xMRCJtCw6WAKw, reason: not valid java name */
    public static /* synthetic */ void m30lambda$Jte1hfG7QtDo4xMRCJtCw6WAKw(Context r0, c r1, String r2) {
        b(r0, r1, r2);
    }

    public static synchronized boolean a(Context r13, c r14) {
        monitor-enter(f.class);
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if (r15 == null) goto L40;
        if (r14 == null) goto L38;
        String r2 = r14.f8851a;     // Catch: Throwable -> L41
        if (r2 != null) goto L10;
    L12:
        String r3 = r14.g;     // Catch: Throwable -> L41
    L13:
        if (r3 == null) goto L36;
        if (r3.length() <= 0) goto L36;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r14.p.get("kSt"), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if (r4 == null) goto L19;
        r4.equals("1");     // Catch: Throwable -> L41
    L19:
        a(r15, "metasec_ml");     // Catch: Throwable -> L41
        ConcurrentHashMap r1 = f8867e;     // Catch: Throwable -> L41
        if (r1.containsKey(r3) == false) goto L25;
        monitor-exit(f.class);
        return false;
    L25:
        if (r14.j.isEmpty() == true) goto L27;
        com.bytedance.mobsec.matrix.a.a(33554449, 0, 0, r14.j, null);     // Catch: Throwable -> L41
    L27:
        String r9 = r14.a();     // Catch: Throwable -> L41
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L41
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(67108865, 0, 0, r9, null), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L41
        f8864b = System.currentTimeMillis() - r11;     // Catch: Throwable -> L41
        if (r5 == true) goto L31;
        monitor-exit(f.class);
        return false;
    L31:
        r1.put(r3, r14);     // Catch: Throwable -> L41
        a(r15, r14, r3);     // Catch: Throwable -> L41
        monitor-exit(f.class);
        return true;
    L36:
        throw new NullPointerException("appID must be set");     // Catch: Throwable -> L41
    L10:
        if (r2.length() <= 0) goto L12;
        r3 = r14.f8851a;     // Catch: Throwable -> L41
        goto L13
    L38:
        throw new NullPointerException("config could not be null");     // Catch: Throwable -> L41
    L40:
        throw new NullPointerException("context could not be null");     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    static synchronized void a(Context r9, String r10) {
        monitor-enter(f.class);
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (f8866d == true) goto L7;
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L9
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        q0.a().a(r8);     // Catch: Throwable -> L9
        g1.a(r8, r10);     // Catch: Throwable -> L9
        f8865c = System.currentTimeMillis() - r1;     // Catch: Throwable -> L9
        com.bytedance.mobsec.matrix.a.a(16777219, 0, 0, null, r8);     // Catch: Throwable -> L9
        f8863a = System.currentTimeMillis() - r1;     // Catch: Throwable -> L9
        f8866d = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(f.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
