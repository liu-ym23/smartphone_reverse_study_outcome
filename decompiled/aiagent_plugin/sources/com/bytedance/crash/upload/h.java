package com.bytedance.crash.upload;

import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.p;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;

/* JADX INFO: compiled from: LaunchScanner.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f7802a;

    public h() {
    }

    public static void a() {
        r.b("LaunchScanner start");
        if (com.bytedance.crash.o.b.b() == false) goto L6;
        DefaultWorkThread.postDelayed(new h(), 0);
        return;
    }

    public static void a(long r0) {
        f7802a = r0;
    }

    @Override // java.lang.Runnable
    public void run() {
        r.b("LaunchScanner run");     // Catch: Throwable -> L12
        if (p.b() == false) goto L10;
        r.b("net available");     // Catch: Throwable -> L12
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();     // Catch: Throwable -> L12
        if (r0 == null) goto L7;
        com.bytedance.crash.n.d.b();     // Catch: Throwable -> L12
        r.b("upload crash");     // Catch: Throwable -> L12
        com.bytedance.crash.crash.b.a(r0, f7802a);     // Catch: Throwable -> L12
        com.bytedance.crash.anr.e.a(r0, f7802a);     // Catch: Throwable -> L12
        com.bytedance.crash.n.d.a();     // Catch: Throwable -> L12
        n.a().c();     // Catch: Throwable -> L12
        com.bytedance.crash.alog.a.a(r0);     // Catch: Throwable -> L12
    L7:
        NativeBridge.e();     // Catch: Throwable -> L12
        if (f7802a <= 0) goto L16;
        DefaultWorkThread.postDelayed(new AnonymousClass1(this), f7802a);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L10:
        r.b("LaunchScanner, network is unavailable");     // Catch: Throwable -> L12
        j.a(new AnonymousClass2(this));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        com.bytedance.crash.c.b.a("NPTH_ANR_ERROR_LaunchScanner", th);
        r.b(th);
    }
}
