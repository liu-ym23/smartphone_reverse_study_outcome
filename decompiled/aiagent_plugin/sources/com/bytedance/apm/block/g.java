package com.bytedance.apm.block;

import org.json.JSONObject;

/* JADX INFO: compiled from: FluencyMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f4361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4362b;

    public static int a(int r1) {
        if (r1 != 11) goto L5;
        return 2;
    L5:
        if (r1 != 101) goto L7;
        return 3;
    L7:
        if (r1 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public static g a() {
        if (f4361a != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4361a != null) goto L9;
        f4361a = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f4361a;
    }

    private g() {
        this.f4362b = 0;
    }

    public void b() {
        com.bytedance.apm.i.a.a(new AnonymousClass1(this));
    }

    public void a(int r1, boolean r2) {
        this.f4362b = a(r1);
        com.bytedance.monitor.collector.k.a().a(this.f4362b);
    }

    public static int a(JSONObject r3) {
        int r4 = com.bytedance.apm.util.i.a(r3, "performance_modules", "smooth", "block_monitor_mode");
        if (r4 != 11) goto L5;
        return 2;
    L5:
        if (r4 != 101) goto L7;
        return 3;
    L7:
        if (r4 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public void c() {
        com.bytedance.monitor.collector.k.a().d();
    }
}
