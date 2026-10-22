package com.bytedance.android.live.recharge.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.recharge.deal.f f90762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RechargeCouponBarWidget.b f90763b;

    public j(com.bytedance.android.live.recharge.deal.f r100, RechargeCouponBarWidget.b r101) {
        this.f90762a = r100;
        this.f90763b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f90763b.f90621a.zq(this.f90762a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
