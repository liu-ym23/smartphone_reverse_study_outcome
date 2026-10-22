package com.bytedance.android.shopping.store.aggregate.presenter;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopAggregatePageProductGroupPresenter f183467a;

    public f(ShopAggregatePageProductGroupPresenter r100) {
        this.f183467a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f183467a.d0().refresh();
    }
}
