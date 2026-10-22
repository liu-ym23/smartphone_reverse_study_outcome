package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/RankItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RankItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f61248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f61249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f61250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f61251d;

    public RankItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f61248a = (TextView) r100.findViewById(R.id.rank_num);
        this.f61249b = (HSImageView) r100.findViewById(R.id.round_avatar);
        this.f61250c = (TextView) r100.findViewById(R.id.tv_nickname);
        this.f61251d = (TextView) r100.findViewById(R.id.diamond_amount);
    }
}
