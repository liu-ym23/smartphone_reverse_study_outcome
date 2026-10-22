package com.bytedance.android.livesdk.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends me.drakeet.multitype.b<BaseEmoji, BaseEmojiViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jf2.b f159286b;

    public c(jf2.b r100) {
        this.f159286b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, BaseEmoji r101) {
        BaseEmojiViewHolder r102 = (BaseEmojiViewHolder) r100;
        r102.T3(r101);
        r102.f159260b = this.f159286b;
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        return new BaseEmojiViewHolder(r100.inflate(R.layout.ttlive_item_panel_new_emoji, r101, false));
    }
}
