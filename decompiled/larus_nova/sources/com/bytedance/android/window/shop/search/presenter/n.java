package com.bytedance.android.window.shop.search.presenter;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchResultTopBarPresenter f189750a;

    public n(WindowSearchResultTopBarPresenter r100) {
        this.f189750a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f189750a.F().isFormSearchActivity() == false) goto L5;
        WindowSearchResultTopBarPresenter.E(this.f189750a, 11);
        return;
    L5:
        WindowSearchResultTopBarPresenter.D(this.f189750a);
    }
}
