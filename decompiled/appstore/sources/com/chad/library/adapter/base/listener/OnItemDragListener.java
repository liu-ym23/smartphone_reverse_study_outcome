package com.chad.library.adapter.base.listener;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public interface OnItemDragListener {
    void onItemDragEnd(RecyclerView.ViewHolder r10, int r11);

    void onItemDragMoving(RecyclerView.ViewHolder r10, int r11, RecyclerView.ViewHolder r12, int r13);

    void onItemDragStart(RecyclerView.ViewHolder r10, int r11);
}
