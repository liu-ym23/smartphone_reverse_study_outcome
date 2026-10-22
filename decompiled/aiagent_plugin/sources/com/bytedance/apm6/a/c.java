package com.bytedance.apm6.a;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;

/* JADX INFO: compiled from: MemoryStatistics.java */
/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5035d;

    /* JADX INFO: compiled from: MemoryStatistics.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f5036a = null;

        static /* synthetic */ c a() {
            return f5036a;
        }

        static {
            f5036a = new c();
        }
    }

    c() {
    }

    public static c a() {
        return a.a();
    }

    void b() {
        d();
        e();
        f();
        g();
    }

    com.bytedance.apm6.a.d.a a(com.bytedance.apm6.a.b.a r33) {
        Debug.MemoryInfo r1 = c();
        if (r1 != null) goto L5;
        return null;
    L5:
        long r19 = a(r1);
        if (r19 >= 0) goto L8;
        return null;
    L8:
        com.bytedance.apm6.service.d.a r2 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");
        long r13 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double r25 = a(r13);
        long r4 = d();
        long r6 = e();
        long r8 = f();
        long r10 = g();
        boolean r12 = !r2.isForeground();
        long r21 = ((long) r1.nativePss) * 1024;
        long r17 = 1024 * ((long) r1.getTotalPss());
        long r3 = b(r1);
        long r23 = h();
        if (r25 <= r33.b()) goto L11;
        boolean r27 = true;
    L13:
        return new com.bytedance.apm6.a.d.a(r4, r6, r8, r10, r12, r21, r17, r13, r19, r3, r23, r25, r27, r33.e());
    L11:
        r27 = false;
        goto L13
    }

    private long a(Debug.MemoryInfo r3) {
        return ((long) r3.dalvikPss) * 1024;
    }

    private long d() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count"));
        long r2 = r0 - this.f5032a;
        this.f5032a = r0;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "gcCount:" + r0);
    L9:
        return r2;
    }

    private long e() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-time"));
        long r2 = r0 - this.f5033b;
        this.f5033b = r0;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "gcTime:" + this.f5033b);
    L9:
        return r2;
    }

    private long f() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count"));
        long r2 = r0 - this.f5034c;
        this.f5034c = r0;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "blockingGcCount:" + this.f5034c);
    L9:
        return r2;
    }

    private long g() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time"));
        long r2 = r0 - this.f5035d;
        this.f5035d = r0;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "blockingGcTime:" + this.f5035d);
    L9:
        return r2;
    }

    private double a(long r3) {
        if (r3 > 0) goto L5;
        return -1.0d;
    L5:
        return new BigDecimal(r3).divide(new BigDecimal(Runtime.getRuntime().maxMemory()), 4, 4).doubleValue();
    }

    private long b(Debug.MemoryInfo r4) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return -1;
    L5:
        String r3 = r4.getMemoryStat("summary.graphics");
        if (TextUtils.isEmpty(r3) == false) goto L13;
    L12:
        return -1;
    L13:
        return ((long) Integer.parseInt(r3)) * 1024;
    L10:
        e = move-exception;
        com.bytedance.apm6.util.c.b.b("APM-Memory", "getGraphics", e);
        e.printStackTrace();
        goto L12
    }

    private long h() {
        long r0 = d.a() * 1024;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return -1;
    }

    public static Debug.MemoryInfo c() {
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")) != null) goto L11;
        return null;
    L11:
        ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
    L10:
        return null;
    }
}
