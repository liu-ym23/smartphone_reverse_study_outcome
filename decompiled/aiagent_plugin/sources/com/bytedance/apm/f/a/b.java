package com.bytedance.apm.f.a;

import android.os.Handler;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.block.trace.f;
import com.bytedance.apm.block.trace.g;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.monitor.collector.h;

/* JADX INFO: compiled from: LaunchEvilMethodManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4605a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4606b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.bytedance.perf.monitor.a f4607c;

    static {
    }

    public static synchronized void a() {
        monitor-enter(b.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (f4605a == false) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f4605a = true;     // Catch: Throwable -> L18
        if (f4606b == true) goto L15;
        f4606b = true;     // Catch: Throwable -> L18
        com.bytedance.perf.monitor.a.a(EvilMethodSwitcher.getLaunchEvilThresholdMs());     // Catch: Throwable -> L18
        com.bytedance.perf.monitor.a.a(true);     // Catch: Throwable -> L18
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L14;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L18
    L14:
        f.a().c();     // Catch: Throwable -> L18
        g.a().b();     // Catch: Throwable -> L18
        com.bytedance.perf.monitor.a.f9044a = true;     // Catch: Throwable -> L18
        com.bytedance.perf.monitor.a r2 = new com.bytedance.perf.monitor.a(EvilMethodSwitcher.isLaunchLimitEvilMethodDepth(), true);     // Catch: Throwable -> L18
        f4607c = r2;     // Catch: Throwable -> L18
        r2.b();     // Catch: Throwable -> L18
        h.a(true, "launch", null);     // Catch: Throwable -> L18
        new Handler().postDelayed(new AnonymousClass1(), 10000);     // Catch: Throwable -> L18
    L15:
        FpsTracer.a("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L18
        monitor-exit(b.class);
    }

    public static synchronized void b() {
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f4605a == true) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f4605a = false;     // Catch: Throwable -> L12
        f4607c.b(EvilMethodSwitcher.isLimitEvilMethodDepth());     // Catch: Throwable -> L12
        com.bytedance.perf.monitor.a.a(EvilMethodSwitcher.getEvilThresholdMs());     // Catch: Throwable -> L12
        FpsTracer.b("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L12
        monitor-exit(b.class);
    }

    public static synchronized void c() {
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f4607c != null) goto L7;
    L9:
        monitor-exit(b.class);
        return;
    L7:
        if (EvilMethodSwitcher.isOpenLaunchEvilMethod() == false) goto L9;
        f4607c.c();     // Catch: Throwable -> L11
        goto L9
    }
}
