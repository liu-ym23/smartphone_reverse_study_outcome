package com.bytedance.android.live.emoji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.viewholder.BaseEmojiViewHolder;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class EmojiPanelWaterfallAdapter extends RecyclerView.Adapter<BaseEmojiViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f68900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f68901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<BaseEmoji> f68902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f68903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f68905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t90.a f68906g;

    public class a extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f68907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EmojiPanelWaterfallAdapter f68908b;

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public final int getSpanSize(int r100) {
            if (r100 != ((ArrayList) this.f68908b.f68902c).size()) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L8;
            return 1;
        L8:
            return this.f68907a.getSpanCount();
        L5:
            r101 = false;
            goto L6
        }

        public a(EmojiPanelWaterfallAdapter r100, GridLayoutManager r101) {
            this.f68908b = r100;
            this.f68907a = r101;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f68903d == null) goto L5;
        int r100 = 1;
    L7:
        return ((ArrayList) this.f68902c).size() + r100;
    L5:
        r100 = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != ((ArrayList) this.f68902c).size()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return -99;
    L10:
        return ((BaseEmoji) ListProtector.get(this.f68902c, r100)).getType().ordinal();
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L6;
        GridLayoutManager r102 = (GridLayoutManager) r101;
        r102.setSpanSizeLookup(new a(this, r102));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseEmojiViewHolder r102 = (BaseEmojiViewHolder) r100;
        if (r101 != ((ArrayList) this.f68902c).size()) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L20;
        BaseEmoji r104 = (BaseEmoji) ListProtector.get(this.f68902c, r101);
        if (r104 != null) goto L12;
        return;
    L12:
        if (r104.getType() != BaseEmoji.Type.DummyEmoji) goto L14;
        r102.itemView.setVisibility(4);
        return;
    L14:
        r102.T3(r104);
        t90.a r105 = this.f68906g;
        if (r105 == null) goto L19;
        r102.f68955b = r105;
        return;
    L19:
        return;
    L20:
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        BaseEmojiViewHolder r102 = new BaseEmojiViewHolder(this.f68901b.inflate(R.layout.ttlive_item_panel_base_emoji, null));
        ViewGroup.LayoutParams r103 = new ViewGroup.LayoutParams(this.f68905f / this.f68904e, (int) t6.a(this.f68900a, 62.0f));
        r102.itemView.setLayoutParams(r103);
        return r102;
    }

    public EmojiPanelWaterfallAdapter(Context r100, int r101, int r102) {
        this.f68902c = new ArrayList();
        this.f68900a = r100;
        this.f68901b = LayoutInflater.from(r100);
        this.f68904e = r101;
        this.f68905f = r102;
    }
}
