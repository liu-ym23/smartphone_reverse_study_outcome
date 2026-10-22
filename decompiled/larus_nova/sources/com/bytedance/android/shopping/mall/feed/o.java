package com.bytedance.android.shopping.mall.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.feed.card.DeliveryCard;
import com.larus.nova.R;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public o(Class r100) {
        super(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.r0
    public final BaseViewHolder n(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r101 = LayoutInflater.from(r100.getContext());
        Map<Integer, List<View>> r102 = com.bytedance.android.shopping.mall.homepage.opt.i.f178253a;
        return new DeliveryCard(r101.inflate(R.layout.shopping_homepage_layout_native_delivery_card, r100, false));
    }
}
