package com.bytedance.android.live.uikit.recyclerview;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes7.dex */
public abstract class RecyclerViewWithFooterAdapter extends RecyclerView.Adapter {
    private static final int TYPE_FOOTER = Integer.MIN_VALUE;
    protected boolean mShowFooter;

    public abstract int getBasicItemCount();

    public int getBasicItemViewType(int r100) {
        return 0;
    }

    public abstract void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101);

    public abstract void onBindFooterViewHolder(RecyclerView.ViewHolder r100);

    public abstract RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101);

    public abstract RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mShowFooter == false) goto L6;
        return getBasicItemCount() + 1;
    L6:
        return getBasicItemCount();
    }

    public RecyclerViewWithFooterAdapter() {
        this.mShowFooter = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.mShowFooter == false) goto L9;
        if (r100 != getBasicItemCount()) goto L9;
        return Integer.MIN_VALUE;
    L9:
        return getBasicItemViewType(r100);
    }

    public void setShowFooter(boolean r100) {
        this.mShowFooter = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if (getItemViewType(r101) != Integer.MIN_VALUE) goto L5;
        onBindFooterViewHolder(r100);
        return;
    L5:
        onBindBasicViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (Integer.MIN_VALUE != r101) goto L7;
        return onCreateFooterViewHolder(r100);
    L7:
        return onCreateBasicViewHolder(r100, r101);
    }
}
