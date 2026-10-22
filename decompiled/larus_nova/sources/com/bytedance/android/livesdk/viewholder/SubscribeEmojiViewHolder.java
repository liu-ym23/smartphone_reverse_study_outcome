package com.bytedance.android.livesdk.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/viewholder/SubscribeEmojiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SubscribeEmojiViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f159278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f159279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f159280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f159281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public jf2.c f159282e;

    public SubscribeEmojiViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f159278a = (HSImageView) r100.findViewById(R.id.subscribe_emoji_icon);
        this.f159279b = (HSImageView) r100.findViewById(R.id.subscribe_emoji_lock);
        this.f159280c = (TextView) r100.findViewById(R.id.subscribe_emoji_new);
        this.f159281d = (ImageView) r100.findViewById(R.id.subscribe_emoji_label);
    }
}
