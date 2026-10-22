package com.bytedance.android.shopping.store.shopfeed.presenter;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.bytedance.android.shopping.store.shopfeed.list.ShopMomentFlowListAdapter;

/* JADX INFO: loaded from: classes14.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopMomentFlowListPresenter f186312a;

    public h(ECShopMomentFlowListPresenter r100) {
        this.f186312a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ShopMomentFlowListAdapter r101 = (ShopMomentFlowListAdapter) this.f186312a.f186280g.getValue();
        r101.submitList((PagedList) r100);
    }
}
