package com.bytedance.android.livesdk.chatroom.roommanage.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends me.drakeet.multitype.b<c, LoadMoreViewHolder> {
    public d() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, c r101) {
        Intrinsics.checkNotNullParameter((LoadMoreViewHolder) r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new LoadMoreViewHolder(r100.inflate(R.layout.ttlive_viewholder_live_room_load_more, r101, false));
    }
}
