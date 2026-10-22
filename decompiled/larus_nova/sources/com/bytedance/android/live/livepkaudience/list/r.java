package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class r extends me.drakeet.multitype.b<a, SimplePkGuestApplyFootHolder> {
    public r() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        SimplePkGuestApplyFootHolder r102 = (SimplePkGuestApplyFootHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        int r104 = r103.getType();
        View r105 = r102.itemView;
        if (r105 == null) goto L27;
        TextView r106 = (TextView) r105;
        if (r104 != 0) goto L7;
        int r107 = s1.f(60.0f);
        ViewGroup.LayoutParams r108 = r102.itemView.getLayoutParams();
        if (r108 == null) goto L20;
        r108.height = r107;
        r102.itemView.setLayoutParams(r108);
    L20:
        View r109 = r102.itemView;
        if (r109 == null) goto L25;
        ((TextView) r109).setText(R.string.ttlive_pk_rivals_search_result_load_more);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L7:
        if (r104 != 1) goto L29;
        int r110 = s1.f(60.0f);
        ViewGroup.LayoutParams r111 = r102.itemView.getLayoutParams();
        if (r111 == null) goto L12;
        r111.height = r110;
        r102.itemView.setLayoutParams(r111);
    L12:
        View r112 = r102.itemView;
        if (r112 == null) goto L16;
        ((TextView) r112).setText(R.string.ttlive_pk_rivals_search_result_nomore);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L29:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new SimplePkGuestApplyFootHolder(r100.inflate(R.layout.ttlive_item_common_apply_list_foot, r101, false));
    }
}
