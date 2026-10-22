package com.bytedance.android.livesdk.chatroom.replay.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.replay.view.ReplayUnionLiveAvatarImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/widget/UnionLiveAvatarHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnionLiveAvatarHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReplayUnionLiveAvatarImageView f110364a;

    public UnionLiveAvatarHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f110364a = (ReplayUnionLiveAvatarImageView) r100.findViewById(R.id.vs_anchor_avatar);
    }
}
