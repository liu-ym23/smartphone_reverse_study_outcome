package com.bytedance.android.shopping.store.shopfeed.fragment;

import android.view.View;
import com.bytedance.android.shopping.store.shopfeed.d;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/fragment/ECShopMomentFlowFragment;", "Lcom/bytedance/android/shopping/store/shopfeed/fragment/AbsShopFeedFragment;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopMomentFlowFragment extends AbsShopFeedFragment {
    @Override // com.bytedance.android.shopping.store.shopfeed.fragment.AbsShopFeedFragment
    public final int S90() {
        return -16777216;
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.fragment.AbsShopFeedFragment
    public final String T90() {
        return "a1.b687415";
    }

    public ECShopMomentFlowFragment() {
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.fragment.AbsShopFeedFragment
    public final Class<d> U90() {
        return d.class;
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.fragment.AbsShopFeedFragment
    public final QUIModule V90(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        return new d(r100, this);
    }
}
