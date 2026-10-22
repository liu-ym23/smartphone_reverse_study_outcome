package com.bytedance.android.ec.hybrid.list.holder;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/holder/ECLoadMoreViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECLoadMoreViewHolder extends BaseViewHolder {
    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final boolean C3() {
        return false;
    }

    public ECLoadMoreViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }
}
