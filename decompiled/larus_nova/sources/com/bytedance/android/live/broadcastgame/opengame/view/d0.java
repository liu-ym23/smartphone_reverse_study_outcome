package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.broadcastgame.opengame.network.m0;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 extends me.drakeet.multitype.b<m0, TotalDiamondViewHolder> {
    public d0() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, m0 r101) {
        TotalDiamondViewHolder r102 = (TotalDiamondViewHolder) r100;
        m0 r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.f61278a.setText(b.a(r103.a()));
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new TotalDiamondViewHolder(LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_dialog_diamond_pay_rank_total_diamonds, r101, false));
    }
}
