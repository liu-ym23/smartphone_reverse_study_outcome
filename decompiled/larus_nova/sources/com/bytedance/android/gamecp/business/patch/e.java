package com.bytedance.android.gamecp.business.patch;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cw.b f56227a;

    public e(cw.b r100) {
        this.f56227a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.gamecp.host_api.a.b().getHostAirCompressService().y(this.f56227a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
