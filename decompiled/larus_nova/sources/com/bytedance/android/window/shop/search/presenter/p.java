package com.bytedance.android.window.shop.search.presenter;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchResultTopBarPresenter f189753a;

    public p(WindowSearchResultTopBarPresenter r100) {
        this.f189753a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f189753a.F().isFormSearchActivity() == false) goto L5;
        WindowSearchResultTopBarPresenter.E(this.f189753a, 10);
        return;
    L5:
        WindowSearchResultTopBarPresenter.D(this.f189753a);
    }
}
