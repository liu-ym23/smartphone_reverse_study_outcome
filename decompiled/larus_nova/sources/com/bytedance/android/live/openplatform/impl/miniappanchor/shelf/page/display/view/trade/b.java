package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends me.drakeet.multitype.b<d, AnchorShelfDisplayTradeItemViewHolder> {
    public b() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, d r101) {
        AnchorShelfDisplayTradeItemViewHolder r102 = (AnchorShelfDisplayTradeItemViewHolder) r100;
        d r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "vh");
        Intrinsics.checkNotNullParameter(r103, "unitList");
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "unitList");
        r102.f84559a.a(r103, r102.f84560b);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = r100.inflate(R.layout.ttlive_mini_app_shelf_page_anchor_trade_layout, r101, false);
        if (r102 == null) goto L7;
        return new AnchorShelfDisplayTradeItemViewHolder((AnchorShelfDisplayTradeLayout) r102, new a());
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.AnchorShelfDisplayTradeLayout");
    }
}
