package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m0 extends me.drakeet.multitype.b<k0, DrawerHistoryMoreItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDrawerFeedAction f123974b;

    public m0(IDrawerFeedAction r100) {
        this.f123974b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, k0 r101) {
        DrawerHistoryMoreItemViewHolder r102 = (DrawerHistoryMoreItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        DrawerHistoryMoreItemViewHolder.T3();
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new DrawerHistoryMoreItemViewHolder(r100.inflate(R.layout.ttlive_feed_drawer_more_history_layout, r101, false), this.f123974b);
    }
}
