package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends me.drakeet.multitype.b<wq0.a, LinkCastItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkCastItemViewHolder.a f85089b;

    public a(CommonShelfDisplayDialog.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f85089b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, wq0.a r101) {
        LinkCastItemViewHolder r102 = (LinkCastItemViewHolder) r100;
        wq0.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "vh");
        Intrinsics.checkNotNullParameter(r103, "linkCastItemInfo");
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "linkCastItemInfo");
        r102.f85083a.setText(r103.f560682a);
        r102.itemView.setOnClickListener(new b(r102));
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new LinkCastItemViewHolder(r100.inflate(R.layout.ttlive_mini_app_shelf_link_cast_item, r101, false), this.f85089b);
    }
}
