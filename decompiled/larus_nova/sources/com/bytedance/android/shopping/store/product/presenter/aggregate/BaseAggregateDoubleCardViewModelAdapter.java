package com.bytedance.android.shopping.store.product.presenter.aggregate;

import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseAggregateDoubleCardViewModelAdapter extends e {
    public BaseAggregateDoubleCardViewModelAdapter(ShopAggregatePageProductViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        super(r100, "ec_shop_aggregate_product_card", AnonymousClass1.INSTANCE);
    }
}
