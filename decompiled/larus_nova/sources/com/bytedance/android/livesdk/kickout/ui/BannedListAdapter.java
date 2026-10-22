package com.bytedance.android.livesdk.kickout.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.uikit.recyclerview.LoadMoreRecyclerViewAdapter;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class BannedListAdapter extends LoadMoreRecyclerViewAdapter {

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f142270a;

        public a(View r100) {
            super(r100);
            this.f142270a = (TextView) r100.findViewById(R.id.tv_ban_hint);
        }
    }

    @Override // com.bytedance.android.live.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public final int getBasicItemCount() {
        throw null;
    }

    @Override // com.bytedance.android.live.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public final int getBasicItemViewType(int r100) {
        return super.getBasicItemViewType(r100);
    }

    @Override // com.bytedance.android.live.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if (getItemViewType(r101) != 4099) goto L9;
        a r102 = (a) r100;
        if (r102 == null) goto L11;
        TextView r103 = r102.f142270a;
        throw null;
    L11:
        return;
    L9:
        BannedViewHolder r104 = (BannedViewHolder) r100;
    }

    @Override // com.bytedance.android.live.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        if (r101 != 4099) goto L7;
        return new a(LayoutInflater.from(null).inflate(R.layout.ttlive_item_banned_footer, r100, false));
    L7:
        return new BannedViewHolder(null, LayoutInflater.from(null).inflate(R.layout.ttlive_item_banned_list, r100, false), null, 0, null);
    }
}
