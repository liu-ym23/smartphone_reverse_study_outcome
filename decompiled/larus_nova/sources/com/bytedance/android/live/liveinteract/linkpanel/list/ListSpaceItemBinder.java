package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class ListSpaceItemBinder extends me.drakeet.multitype.b<p, ViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/ListSpaceItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public ListSpaceItemBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, p r101) {
        ViewHolder r102 = (ViewHolder) r100;
        p r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, "data");
        ViewGroup.LayoutParams r104 = r102.itemView.getLayoutParams();
        if (r104 == null) goto L6;
        r104.height = r103.f74963a;
        r102.itemView.setLayoutParams(r104);
        return;
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ViewHolder(r100.inflate(R.layout.ttlive_invite_empty_title_item, r101, false));
    }
}
