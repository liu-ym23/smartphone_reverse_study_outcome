package com.bytedance.monitor.collector;

import android.util.Pair;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;

/* JADX INFO: compiled from: ProcMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends b {
    com.bytedance.monitor.a.b.e f;
    private int g;
    private int h;
    private boolean i;

    l(int r2) {
        super(r2, "proc_monitor");
        this.g = 200;
        this.h = 1000;
        this.i = true;
        this.f = com.bytedance.monitor.a.b.c.a("collect-proc", new AnonymousClass1(this));
    }

    public static void d() {
        if (k.f9012a == true) goto L5;
        return;
    L5:
        MonitorJni.doInit();     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public void a() {
        super.a();
        if (k.f9012a == true) goto L6;
        return;
    L6:
        if (this.f8952c == 0) goto L20;
        boolean r0 = this.i;     // Catch: Throwable -> L16
        if (r0 == false) goto L11;
        this.h = DownloadSettingValues.SYNC_INTERVAL_MS_FG;     // Catch: Throwable -> L16
    L12:
        MonitorJni.keepProcHyperOpen(r0);     // Catch: Throwable -> L16
        MonitorJni.doStart();     // Catch: Throwable -> L16
        if (this.f8954e == null) goto L21;
        this.f8954e.a(this.f, 0, this.h);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L11:
        this.h = 1000;     // Catch: Throwable -> L16
        goto L12
    L20:
        return;
    }

    public synchronized void e() {
        monitor-enter(this);
        if (k.f9012a == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        MonitorJni.doCollect();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }

    @Override // com.bytedance.monitor.collector.b
    public void b() {
        super.b();
        if (k.f9012a == true) goto L7;
        return;
    L7:
        if (this.f8954e == null) goto L9;
        this.f8954e.b(this.f);     // Catch: Throwable -> L11
    L9:
        MonitorJni.doStop();     // Catch: Throwable -> L11
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public void b(int r3) {
        if (k.f9012a == true) goto L5;
        return;
    L5:
        b();     // Catch: Throwable -> L18
        if (r3 != 0) goto L8;
        return;
    L8:
        if (r3 != 1) goto L10;
        this.g = 200;     // Catch: Throwable -> L18
        this.h = 1000;     // Catch: Throwable -> L18
        MonitorJni.setBufferSize(200);     // Catch: Throwable -> L18
    L16:
        a();     // Catch: Throwable -> L18
        return;
    L10:
        if (r3 != 2) goto L12;
    L14:
        this.g = 400;     // Catch: Throwable -> L18
        this.h = 1000;     // Catch: Throwable -> L18
        MonitorJni.setBufferSize(400);     // Catch: Throwable -> L18
        goto L16
    L12:
        if (r3 == 3) goto L14;
    }

    @Override // com.bytedance.monitor.collector.b
    public synchronized Pair<String, String> c() {
        monitor-enter(this);
        if (k.f9012a == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r1 = new Pair(this.f8950a, MonitorJni.getProcInfos());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public synchronized Pair<String, String> a(long r4, long r6) {
        monitor-enter(this);
        if (k.f9012a == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r1 = new Pair(this.f8950a, MonitorJni.getProcInfoTimeRange(r4, r6));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L12:
        return null;
    }

    public static long c(int r4) {
    L9:
        return -1;
    L4:
        if (k.f9012a == true) goto L6;
        return -1;
    L6:
        return MonitorJni.doGetCpuTime(r4) * n.a();
    }
}
