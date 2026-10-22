package com.bytedance.android.livesdk.drawer.history;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i extends me.drakeet.multitype.b<PlaceHolder, PlaceViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f122491b;

    public i(boolean r100) {
        this.f122491b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, PlaceHolder r101) {
        PlaceViewHolder r102 = (PlaceViewHolder) r100;
        PlaceHolder r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f122483a.setText(r103.getMsg());
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new PlaceViewHolder(r100.inflate(R.layout.ttlive_history_placeholder_layout, r101, false), this.f122491b);
    }
}
