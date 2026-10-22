package com.bytedance.android.livesdk.interactivity.comment.input.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/view/LiveVideoCommentSearchVideoFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVideoCommentSearchVideoFooterViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveDoubleColorBallAnimationView f135185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f135186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f135187c;

    public LiveVideoCommentSearchVideoFooterViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f135185a = (LiveDoubleColorBallAnimationView) r100.findViewById(R.id.video_search_footer_loading);
        this.f135186b = (TextView) r100.findViewById(R.id.video_search_footer_hint);
    }
}
