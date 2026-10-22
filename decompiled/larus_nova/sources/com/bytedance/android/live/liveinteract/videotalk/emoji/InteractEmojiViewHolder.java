package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/InteractEmojiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractEmojiViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f79319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f79320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f79321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f79322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f79323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TalkRoomBaseDynamicEmoji f79324f;

    public InteractEmojiViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f79319a = (HSImageView) this.itemView.findViewById(R.id.emoji_icon);
        this.f79320b = (ImageView) this.itemView.findViewById(R.id.emoji_lock_icon);
        this.f79321c = (TextView) this.itemView.findViewById(R.id.interact_emoji_tip);
        this.f79322d = (TextView) this.itemView.findViewById(R.id.random_emoji_tip);
        this.f79323e = (TextView) this.itemView.findViewById(R.id.tv_interact_emoji_bottom_tip);
    }
}
