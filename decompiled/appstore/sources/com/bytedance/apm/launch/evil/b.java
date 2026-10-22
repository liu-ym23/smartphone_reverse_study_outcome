package com.bytedance.apm.launch.evil;

import android.os.Handler;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.monitor.collector.LooperMonitor;
import g1.d;
import g1.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6515a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6516b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static o5.a f6517c;

    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.c();
        }
    }

    static {
    }

    public static synchronized void a() {
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f6517c != null) goto L7;
    L12:
        monitor-exit(b.class);
        return;
    L7:
        if (EvilMethodSwitcher.isOpenLaunchEvilMethod() == false) goto L12;
        f6517c.g();     // Catch: Throwable -> L10
        goto L12
    }

    public static synchronized void b() {
        monitor-enter(b.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f6515a == false) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f6515a = true;     // Catch: Throwable -> L14
        if (f6516b == true) goto L17;
        f6516b = true;     // Catch: Throwable -> L14
        o5.a.j(EvilMethodSwitcher.getLaunchEvilThresholdMs());     // Catch: Throwable -> L14
        o5.a.k(true);     // Catch: Throwable -> L14
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L16;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L14
    L16:
        d.A().C();     // Catch: Throwable -> L14
        e.E().K();     // Catch: Throwable -> L14
        o5.a.f22500n = true;     // Catch: Throwable -> L14
        o5.a r10 = new o5.a(EvilMethodSwitcher.isLaunchLimitEvilMethodDepth(), true);     // Catch: Throwable -> L14
        f6517c = r10;     // Catch: Throwable -> L14
        r10.m();     // Catch: Throwable -> L14
        LooperMonitor.d(true, "launch", null);     // Catch: Throwable -> L14
        new Handler().postDelayed(new a(), 10000);     // Catch: Throwable -> L14
    L17:
        FpsTracer.q("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L14
        monitor-exit(b.class);
    }

    public static synchronized void c() {
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f6515a == true) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f6515a = false;     // Catch: Throwable -> L12
        f6517c.l(EvilMethodSwitcher.isLimitEvilMethodDepth());     // Catch: Throwable -> L12
        o5.a.j(EvilMethodSwitcher.getEvilThresholdMs());     // Catch: Throwable -> L12
        FpsTracer.A("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L12
        monitor-exit(b.class);
    }
}
