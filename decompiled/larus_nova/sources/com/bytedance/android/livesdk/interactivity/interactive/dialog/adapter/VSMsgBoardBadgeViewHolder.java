package com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerConstraintLayout;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/adapter/VSMsgBoardBadgeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardBadgeViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f137211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f137212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f137213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f137214d;

    public VSMsgBoardBadgeViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f137211a = (ImageView) r100.findViewById(R.id.ttlive_vs_badge_item_paid_tag);
        this.f137212b = (HSImageView) r100.findViewById(R.id.ttlive_vs_badge_item_bg);
        this.f137213c = (TextView) r100.findViewById(R.id.badge_name);
        RoundCornerConstraintLayout r101 = (RoundCornerConstraintLayout) r100.findViewById(R.id.badge_card_view);
        this.f137214d = (ImageView) r100.findViewById(R.id.ttlive_ve_badge_item_select_layer);
    }
}
