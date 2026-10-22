package com.bytedance.android.live.core.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes45.dex */
public final class r1 {
    public static void a(RecyclerView r100, int r101) {
        if (r101 >= 0) goto L4;
        return;
    L4:
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L8;
        ((LinearLayoutManager) r102).scrollToPositionWithOffset(r101, 0);
        return;
    L8:
        if ((r102 instanceof StaggeredGridLayoutManager) == false) goto L12;
        ((StaggeredGridLayoutManager) r102).scrollToPositionWithOffset(r101, 0);
        return;
    }
}
