package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VisibleLogManager f182101a;

    public i(VisibleLogManager r100) {
        this.f182101a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VisibleLogManager.a(this.f182101a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
