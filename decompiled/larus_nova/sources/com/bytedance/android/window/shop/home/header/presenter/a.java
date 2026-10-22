package com.bytedance.android.window.shop.home.header.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.holder.ECDefLoadMoreViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends l0 {
    public a() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.l0
    public final ECLoadMoreViewHolder a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        FrameLayout r101 = new FrameLayout(r100.getContext());
        TextView r102 = new TextView(r101.getContext());
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, 1);
        r103.gravity = 17;
        Unit r104 = Unit.INSTANCE;
        r101.addView(r102, r103);
        return new ECDefLoadMoreViewHolder(r101);
    }
}
