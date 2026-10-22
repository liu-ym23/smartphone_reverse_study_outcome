package com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.LiveRoundImageView;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerConstraintLayout;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/adapter/VSMsgBoardSkinViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardSkinViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f137215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f137216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveRoundImageView f137217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f137218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f137219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f137220f;

    public VSMsgBoardSkinViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f137215a = (ImageView) r100.findViewById(R.id.ttlive_vs_skin_item_paid_tag);
        RoundCornerConstraintLayout r101 = (RoundCornerConstraintLayout) r100.findViewById(R.id.skin_card_view);
        this.f137216b = (HSImageView) r100.findViewById(R.id.ttlive_vs_skin_item_bg);
        RoundCornerConstraintLayout r102 = (RoundCornerConstraintLayout) r100.findViewById(R.id.ttlive_vs_skin_item_sub_bg);
        this.f137217c = (LiveRoundImageView) r100.findViewById(R.id.ttlive_vs_skin_item_head);
        this.f137218d = (TextView) r100.findViewById(R.id.ttlive_vs_skin_user_name);
        this.f137219e = (TextView) r100.findViewById(R.id.skin_name);
        this.f137220f = (ImageView) r100.findViewById(R.id.ttlive_ve_skin_item_select_layer);
    }
}
