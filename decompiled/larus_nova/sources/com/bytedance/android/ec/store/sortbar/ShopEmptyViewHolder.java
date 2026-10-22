package com.bytedance.android.ec.store.sortbar;

import android.view.View;
import com.bytedance.android.ec.store.product.holder.ShopItemViewHolder;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/store/sortbar/ShopEmptyViewHolder;", "Lcom/bytedance/android/ec/store/product/holder/ShopItemViewHolder;", "Lcom/ss/android/ugc/aweme/kiwi/model/QModel;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopEmptyViewHolder extends ShopItemViewHolder<QModel> {
    @Override // com.bytedance.android.ec.store.product.holder.ShopItemViewHolder
    public final void T3(QModel r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
    }

    public ShopEmptyViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }
}
