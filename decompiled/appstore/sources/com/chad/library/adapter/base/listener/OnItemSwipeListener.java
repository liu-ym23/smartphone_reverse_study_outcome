package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public interface OnItemSwipeListener {
    void clearView(RecyclerView.ViewHolder r10, int r11);

    void onItemSwipeMoving(Canvas r10, RecyclerView.ViewHolder r11, float r12, float r13, boolean r14);

    void onItemSwipeStart(RecyclerView.ViewHolder r10, int r11);

    void onItemSwiped(RecyclerView.ViewHolder r10, int r11);
}
