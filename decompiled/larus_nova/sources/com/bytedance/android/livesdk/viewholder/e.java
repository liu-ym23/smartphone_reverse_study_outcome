package com.bytedance.android.livesdk.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends me.drakeet.multitype.b<com.bytedance.android.livesdk.interactivity.api.emoji.a, FusionEmojiViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jf2.b f159289b;

    public e(jf2.b r100) {
        this.f159289b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, com.bytedance.android.livesdk.interactivity.api.emoji.a r101) {
        final FusionEmojiViewHolder r102 = (FusionEmojiViewHolder) r100;
        final com.bytedance.android.livesdk.interactivity.api.emoji.a r103 = r101;
        if (r103 != null) goto L5;
        r102.getClass();
    L6:
        r102.f159264b = this.f159289b;
        return;
    L5:
        ImageUtil.loadImage(r102.f159263a, r103.a(), 0);
        r102.f159263a.setOnClickListener(new f(r102, r103));
        r3.a(r102.itemView, r103.d());
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        return new FusionEmojiViewHolder(r100.inflate(R.layout.ttlive_item_panel_fusion_emoji, r101, false));
    }
}
