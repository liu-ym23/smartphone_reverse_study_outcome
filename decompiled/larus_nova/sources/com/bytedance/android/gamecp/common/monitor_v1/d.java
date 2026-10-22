package com.bytedance.android.gamecp.common.monitor_v1;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f56593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f56594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f56595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f56596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f56597e;

    public d(String r100, String r101, boolean r102, String r103, String r104) {
        this.f56593a = r100;
        this.f56594b = r101;
        this.f56595c = r102;
        this.f56596d = r103;
        this.f56597e = r104;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.gamecp.base.cache.c<String, FMPMonitorTracker.b> r100 = FMPMonitorTracker.f56549a;     // Catch: Throwable -> L10
        FMPMonitorTracker.b r101 = FMPMonitorTracker.f(this.f56593a, this.f56594b);     // Catch: Throwable -> L10
        if (r101 != null) goto L6;
    L15:
        return;
    L6:
        if (this.f56595c == false) goto L8;
        r101.f56568i.put(this.f56597e, this.f56596d);     // Catch: Throwable -> L10
        goto L15
    L8:
        r101.f56567h.put(this.f56597e, this.f56596d);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
