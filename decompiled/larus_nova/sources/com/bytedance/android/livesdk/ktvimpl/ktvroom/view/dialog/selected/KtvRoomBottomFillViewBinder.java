package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvRoomBottomFillViewBinder extends me.drakeet.multitype.b<Object, KtvRoomBottomFillViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/dialog/selected/KtvRoomBottomFillViewBinder$KtvRoomBottomFillViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class KtvRoomBottomFillViewHolder extends RecyclerView.ViewHolder {
        public KtvRoomBottomFillViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public KtvRoomBottomFillViewBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, Object r101) {
        Intrinsics.checkNotNullParameter((KtvRoomBottomFillViewHolder) r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new KtvRoomBottomFillViewHolder(r100.inflate(R.layout.ttlive_ktv_room_selected_bottom_fill_item, r101, false));
    }
}
