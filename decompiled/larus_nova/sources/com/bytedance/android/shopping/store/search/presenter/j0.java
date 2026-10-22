package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;

/* JADX INFO: loaded from: classes14.dex */
public final class j0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchTitlePresenter f186092a;

    public j0(ShopSearchTitlePresenter r100) {
        this.f186092a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ShopSearchTitlePresenter.G(this.f186092a, ShopSearchBasePresenter.SearchMode.BUTTON);
    }
}
