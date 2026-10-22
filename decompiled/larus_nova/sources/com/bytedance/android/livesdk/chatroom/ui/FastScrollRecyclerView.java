package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes8.dex */
public class FastScrollRecyclerView extends RecyclerView {
    public FastScrollRecyclerView(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (getScrollState() != 2) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = super.onInterceptTouchEvent(r100);
        if (r100.getActionMasked() != 0) goto L15;
        if (r101 == false) goto L15;
        getParent().requestDisallowInterceptTouchEvent(false);
        if (canScrollVertically(-1) == true) goto L12;
    L13:
        stopScroll();
        return false;
    L12:
        if (canScrollVertically(1) == false) goto L13;
    L15:
        return r102;
    L5:
        r101 = false;
        goto L6
    }

    public FastScrollRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public FastScrollRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
