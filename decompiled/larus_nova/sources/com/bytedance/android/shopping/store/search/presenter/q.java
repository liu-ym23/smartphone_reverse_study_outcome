package com.bytedance.android.shopping.store.search.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchResultProductListPresenter.c f186104a;

    public q(ShopSearchResultProductListPresenter.c r100) {
        this.f186104a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (ShopSearchResultProductListPresenter.e0(this.f186104a.f186049b).isPlayingVideo() == true) goto L9;
        ShopSearchResultProductListPresenter.d0(this.f186104a.f186049b);     // Catch: Throwable -> L6
        return;
    }
}
