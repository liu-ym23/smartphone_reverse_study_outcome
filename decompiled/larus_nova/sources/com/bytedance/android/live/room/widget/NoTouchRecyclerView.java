package com.bytedance.android.live.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes47.dex */
public class NoTouchRecyclerView extends RecyclerView {
    public NoTouchRecyclerView(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public NoTouchRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public NoTouchRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
