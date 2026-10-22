package com.bytedance.android.gamecp.common.monitor_v1;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f56603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f56604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f56605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f56606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f56607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f56608f;

    public g(String r100, String r101, String r102, long r103, String r104, boolean r105) {
        this.f56603a = r100;
        this.f56604b = r101;
        this.f56605c = r102;
        this.f56606d = r103;
        this.f56607e = r104;
        this.f56608f = r105;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.gamecp.base.cache.c<String, FMPMonitorTracker.b> r100 = FMPMonitorTracker.f56549a;     // Catch: Throwable -> L7
        FMPMonitorTracker.b r101 = FMPMonitorTracker.f(this.f56603a, this.f56604b);     // Catch: Throwable -> L7
        if (r101 == null) goto L10;
        r101.f56566g.put(this.f56605c, new FMPMonitorTracker.a(this.f56606d - r101.f56563d, this.f56607e, this.f56608f));     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
