package com.bytedance.android.shopping.store.router.hybridpage.holder;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceBaseProductCardHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class HybridPageSliceBaseProductCardHolder extends BaseViewHolder {
    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final boolean C3() {
        return false;
    }

    public abstract void q4(Object r100, String r101);

    public HybridPageSliceBaseProductCardHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r100, String r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        if ((r100 instanceof com.bytedance.android.ec.store.window.b) == true) goto L6;
        super.b4(r100, r101, r102);
        q4(r100, r101);
        return;
    L6:
        ((com.bytedance.android.ec.store.window.b) r100).getClass();
        throw null;
    }
}
