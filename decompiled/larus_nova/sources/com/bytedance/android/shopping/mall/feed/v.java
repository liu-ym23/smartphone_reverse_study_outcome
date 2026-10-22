package com.bytedance.android.shopping.mall.feed;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.feed.holder.ECMallDoublePlaceholderCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public v(Class r100) {
        super(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.r0
    public final BaseViewHolder n(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r101 = ECMallDoublePlaceholderCard.f177038r;
        Intrinsics.checkNotNullParameter(r100, "parent");
        LinearLayout r102 = new LinearLayout(r100.getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r102.setOrientation(1);
        return new ECMallDoublePlaceholderCard(r102);
    }
}
