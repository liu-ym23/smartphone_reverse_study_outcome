package com.bytedance.android.gamecp.common.monitor_v1;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f56609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f56610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f56611c;

    public h(String r100, String r101, long r102) {
        this.f56609a = r100;
        this.f56610b = r101;
        this.f56611c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.gamecp.base.cache.c<String, FMPMonitorTracker.b> r100 = FMPMonitorTracker.f56549a;     // Catch: Throwable -> L7
        FMPMonitorTracker.b r101 = FMPMonitorTracker.f(this.f56609a, this.f56610b);     // Catch: Throwable -> L7
        if (r101 == null) goto L10;
        r101.f56571l = true;     // Catch: Throwable -> L7
        long r102 = this.f56611c - r101.f56563d;     // Catch: Throwable -> L7
        r101.f56567h.put("fmp_v2_render_begin", String.valueOf(r102));     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
