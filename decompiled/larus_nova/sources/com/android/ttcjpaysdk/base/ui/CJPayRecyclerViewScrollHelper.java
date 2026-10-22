package com.android.ttcjpaysdk.base.ui;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayRecyclerViewScrollHelper {

    public static class CJPaySmoothScroller extends LinearSmoothScroller {
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getHorizontalSnapPreference() {
            return -1;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getVerticalSnapPreference() {
            return -1;
        }

        public CJPaySmoothScroller(Context r100) {
            super(r100);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics r100) {
            return 500.0f / r100.densityDpi;
        }
    }

    public CJPayRecyclerViewScrollHelper() {
    }

    public static void scrollToPosition(RecyclerView r100, int r101) {
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L6;
        CJPaySmoothScroller r103 = new CJPaySmoothScroller(r100.getContext());
        r103.setTargetPosition(r101);
        ((LinearLayoutManager) r102).startSmoothScroll(r103);
        return;
    }
}
