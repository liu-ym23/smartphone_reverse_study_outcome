package com.bytedance.android.live.emoji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.viewholder.BaseEmojiViewHolder;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import t90.a;

/* JADX INFO: loaded from: classes45.dex */
public class EmojiPanelAdapter extends RecyclerView.Adapter<BaseEmojiViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f68891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f68892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<BaseEmoji> f68893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f68896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f68897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f68898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f68899i;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f68893c).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((BaseEmoji) ListProtector.get(this.f68893c, r100)).getType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseEmojiViewHolder r102 = (BaseEmojiViewHolder) r100;
        BaseEmoji r103 = (BaseEmoji) ListProtector.get(this.f68893c, r101);
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.getType() != BaseEmoji.Type.DummyEmoji) goto L8;
        r102.itemView.setVisibility(4);
        return;
    L8:
        r102.T3(r103);
        a r104 = this.f68899i;
        if (r104 == null) goto L13;
        r102.f68955b = r104;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        BaseEmojiViewHolder r102 = new BaseEmojiViewHolder(this.f68892b.inflate(R.layout.ttlive_item_panel_base_emoji, null));
        ViewGroup.LayoutParams r103 = new ViewGroup.LayoutParams(this.f68897g / this.f68895e, (int) t6.a(this.f68891a, 62.0f));
        r102.itemView.setLayoutParams(r103);
        return r102;
    }

    public EmojiPanelAdapter(Context r100, int r101, int r102, int r103) {
        this.f68893c = new ArrayList();
        this.f68891a = r100;
        this.f68892b = LayoutInflater.from(r100);
        this.f68894d = r101;
        this.f68895e = r102;
        this.f68896f = r101 * r102;
        this.f68897g = r103;
        this.f68898h = false;
    }
}
