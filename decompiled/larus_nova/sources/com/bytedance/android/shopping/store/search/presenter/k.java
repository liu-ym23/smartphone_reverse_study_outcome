package com.bytedance.android.shopping.store.search.presenter;

import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchHotViewPresenter f186093a;

    public k(ShopSearchHotViewPresenter r100) {
        this.f186093a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ShopSearchHotViewPresenter r101 = this.f186093a;
        int r102 = ShopSearchHotViewPresenter.f186015l;
        ((LinearLayout) r101.w().b(R.id.commerce_store_hot_search_refresh_click).f()).setVisibility(((Integer) r100).intValue());
    }
}
