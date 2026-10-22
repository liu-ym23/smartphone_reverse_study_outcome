package com.bytedance.android.shopping.store.aggregate.presenter;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopAggregatePageProductGroupPresenter f183468a;

    public g(ShopAggregatePageProductGroupPresenter r100) {
        this.f183468a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f183468a.d0().refresh();
    }
}
