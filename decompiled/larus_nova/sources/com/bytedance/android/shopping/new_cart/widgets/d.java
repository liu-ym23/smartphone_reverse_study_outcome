package com.bytedance.android.shopping.new_cart.widgets;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECCartErrorView f179470a;

    public d(ECCartErrorView r100) {
        this.f179470a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f179470a.setVisibility(0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
