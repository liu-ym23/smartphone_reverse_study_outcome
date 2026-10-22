package com.bytedance.android.live.emoji.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.emoji.SelfEmoji;
import com.bytedance.android.live.emoji.viewholder.SelfEmojiViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public class SelfEmojiPanelAdapter extends RecyclerView.Adapter<SelfEmojiViewHolder> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return 0;
    L8:
        return 1;
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        SelfEmojiViewHolder r102 = (SelfEmojiViewHolder) r100;
        r102.getClass();
        if (r101 != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        r102.T3(null, r101, getItemViewType(r101));
        return;
    L9:
        r102.T3((SelfEmoji) ListProtector.get(null, r101 - 1), r101, getItemViewType(r101));
        return;
    L5:
        r103 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new SelfEmojiViewHolder(LayoutInflater.from(null).inflate(R.layout.ttlive_item_panel_self_emoji, r100, false));
    }
}
