package com.bytedance.android.live.core.paging.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;

/* JADX INFO: loaded from: classes45.dex */
public class InvalidItemViewHolder extends BaseViewHolder<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f65026a;

    public InvalidItemViewHolder(ViewGroup r100) {
        super(new View(r100.getContext()));
        this.f65026a = r100;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(Object r100, int r101) {
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(this.f65026a.getMeasuredWidth(), 1));
    }
}
