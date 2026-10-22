package com.bytedance.android.livesdk.drawer.history;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends me.drakeet.multitype.b<a, EndViewHolder> {
    public b() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        Intrinsics.checkNotNullParameter((EndViewHolder) r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new EndViewHolder(r100.inflate(R.layout.ttlive_core_rv_loading_end, r101, false));
    }
}
