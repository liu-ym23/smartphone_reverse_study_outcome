package com.bytedance.android.window.shop.holder;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowBaseViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WindowBaseViewHolder extends BaseViewHolder {
    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final boolean C3() {
        return false;
    }

    public WindowBaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }
}
