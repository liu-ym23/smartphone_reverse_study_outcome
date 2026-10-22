package com.bytedance.android.gamecp.business.download.custommade;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomInstallActivity f52640a;

    public a(CustomInstallActivity r100) {
        this.f52640a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f52640a.f52552f = true;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
