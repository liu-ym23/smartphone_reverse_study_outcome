package com.bytedance.android.shopping.store.shopfeed.list;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopMomentFlowListAdapter;", "Lcom/bytedance/android/shopping/store/shopfeed/list/AbsShopFeedListAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopMomentFlowListAdapter extends AbsShopFeedListAdapter {
    @Override // com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedListAdapter
    public final void z2() {
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedListAdapter
    public final RecyclerView.ViewHolder A2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r101 = ShopMomentFlowLynxCardViewHolder.f186228b;
        final QLiveData<LoadStatus> r102 = this.f186176d;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r102, "loadStatus");
        ShopMomentFlowLynxCardView r103 = new ShopMomentFlowLynxCardView(r100.getContext(), null, 0);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r103.setOnLoadLynxSuccessCallback(new ShopMomentFlowLynxCardViewHolder$Companion$create$$inlined$apply$lambda$1(r102));
        return new ShopMomentFlowLynxCardViewHolder(r103);
    }

    @Override // com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof ShopFlowFooterViewHolder) == true) goto L5;
        r100 = null;
    L5:
        ShopFlowFooterViewHolder r101 = (ShopFlowFooterViewHolder) r100;
        if (r101 == null) goto L9;
        r101.T3(this.f186179g, -1);
        return;
    }

    @Override // com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r101 = ShopFlowFooterViewHolder.f186217c;
        return ShopFlowFooterViewHolder.a.a(r100);
    }

    public ShopMomentFlowListAdapter(QLiveData<LoadStatus> r100, LifecycleOwner r101, Fragment r102, ECShopFeedViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "loadStatus");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "shopFeedViewModel");
        super(r100, r101, r102, r103);
    }
}
