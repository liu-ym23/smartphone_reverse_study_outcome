package com.bytedance.android.shopping.store.shopfeed.presenter;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListAdapter;

/* JADX INFO: loaded from: classes14.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopFlowShopListPresenter f186306a;

    public c(ECShopFlowShopListPresenter r100) {
        this.f186306a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ShopFeedListAdapter r101 = (ShopFeedListAdapter) this.f186306a.f186251g.getValue();
        r101.submitList((PagedList) r100);
    }
}
