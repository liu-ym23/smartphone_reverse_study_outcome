package com.bytedance.android.shopping.store.home.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopBackgroundPresenterBrand f184376a;

    public r(ECShopBackgroundPresenterBrand r100) {
        this.f184376a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopBackgroundPresenterBrand.q0(this.f184376a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
