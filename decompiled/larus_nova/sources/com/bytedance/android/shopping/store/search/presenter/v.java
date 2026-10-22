package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class v implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchResultTopBarPresenter f186110a;

    public v(ShopSearchResultTopBarPresenter r100) {
        this.f186110a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f186110a.F().isFormSearchActivity() == false) goto L5;
        ShopSearchResultTopBarPresenter.E(this.f186110a, 10);
        return;
    L5:
        ShopSearchResultTopBarPresenter.D(this.f186110a);
    }
}
