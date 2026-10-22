package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/TotalDiamondViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TotalDiamondViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f61278a;

    public TotalDiamondViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f61278a = (TextView) r100.findViewById(R.id.tv_total_diamond);
    }
}
