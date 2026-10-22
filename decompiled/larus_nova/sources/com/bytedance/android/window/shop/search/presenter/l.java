package com.bytedance.android.window.shop.search.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchResultProductListPresenter.c f189748a;

    public l(WindowSearchResultProductListPresenter.c r100) {
        this.f189748a = r100;
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
        if (WindowSearchResultProductListPresenter.e0(this.f189748a.f189714b).isPlayingVideo() == true) goto L9;
        WindowSearchResultProductListPresenter.d0(this.f189748a.f189714b);     // Catch: Throwable -> L6
        return;
    }
}
