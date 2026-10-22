package com.bytedance.android.shopping.buynow.controller;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BuyNowElevatorGuideController f170828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.kmp.ec.yata.store.node.c f170829b;

    public c(BuyNowElevatorGuideController r100, com.bytedance.kmp.ec.yata.store.node.c r101) {
        this.f170828a = r100;
        this.f170829b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BuyNowElevatorGuideController r100 = this.f170828a;     // Catch: Throwable -> L6
        if (r100.f170794a == false) goto L9;
        r100.f170795b.setVisibility(8);     // Catch: Throwable -> L6
        this.f170828a.c(this.f170829b, "hide_elevator_event_name", "onAutoDisappear");     // Catch: Throwable -> L6
        this.f170828a.f170794a = false;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
