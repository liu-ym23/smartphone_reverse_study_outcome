package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m extends me.drakeet.multitype.b<a, PkPreApplyTitleViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public m() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        PkPreApplyTitleViewHolder r102 = (PkPreApplyTitleViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        ((TextView) r102.f82069a.getValue()).setText(R.string.audience_in_waiting_list);
        ((TextView) r102.f82070b.getValue()).setText(R.string.waiting_time);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new PkPreApplyTitleViewHolder(r100.inflate(R.layout.ttlive_item_pk_pre_apply_linkmic_title, r101, false));
    }
}
