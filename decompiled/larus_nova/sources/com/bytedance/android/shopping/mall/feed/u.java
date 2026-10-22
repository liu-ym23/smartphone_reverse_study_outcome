package com.bytedance.android.shopping.mall.feed;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.feed.holder.ECMallSinglePlaceholderCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public u(Class r100) {
        super(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.r0
    public final BaseViewHolder n(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r101 = ECMallSinglePlaceholderCard.f177061p;
        Intrinsics.checkNotNullParameter(r100, "parent");
        FrameLayout r102 = new FrameLayout(r100.getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new ECMallSinglePlaceholderCard(r102);
    }
}
