package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/view/LiveVideoCommentSelectPanelLoadingMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectPanelLoadingMoreViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveDoubleColorBallAnimationView f71588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f71589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71590c;

    public LiveVideoCommentSelectPanelLoadingMoreViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f71588a = (LiveDoubleColorBallAnimationView) r100.findViewById(R.id.video_comment_panel_list_refresh_progress);
        this.f71589b = (TextView) r100.findViewById(R.id.video_comment_panel_list_not_more_text);
        this.f71590c = 1;
    }
}
