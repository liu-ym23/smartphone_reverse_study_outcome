package com.bytedance.android.livesdk.chatroom.replay.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends me.drakeet.multitype.b<EpisodeGroup, ReplayVideoGroupViewHolder> {
    public d() {
    }

    @Override // me.drakeet.multitype.b
    public final void g(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter((ReplayVideoGroupViewHolder) r100, "holder");
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, EpisodeGroup r101) {
        Intrinsics.checkNotNullParameter((ReplayVideoGroupViewHolder) r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ReplayVideoGroupViewHolder(r100.inflate(R.layout.ttlive_replay_list_group_layout, r101, false));
    }
}
