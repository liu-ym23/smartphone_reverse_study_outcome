package com.bytedance.android.shopping.new_cart.widgets.nest;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CartLinkedScrollViewV2 f179567a;

    public d(CartLinkedScrollViewV2 r100) {
        this.f179567a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CartLinkedScrollViewV2.p(this.f179567a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
