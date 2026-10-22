package com.bytedance.android.live.room.discovery.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.widget.UnionLiveAvatarImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/discovery/adapter/AnchorTogetherAvatarHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorTogetherAvatarHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnionLiveAvatarImageView f99370a;

    public AnchorTogetherAvatarHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f99370a = (UnionLiveAvatarImageView) r100.findViewById(R.id.together_anchor_avatar);
    }
}
