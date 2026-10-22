package com.bytedance.android.livesdk.feed.ui;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes8.dex */
public class FixEmptyItemInStaggeredLayoutScrollListener extends RecyclerView.OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        super.onScrollStateChanged(r100, r101);
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();     // Catch: Exception -> L8
        if ((r102 instanceof StaggeredGridLayoutManager) == true) goto L6;
        return;
    L6:
        ((StaggeredGridLayoutManager) r102).findFirstVisibleItemPositions(null);     // Catch: Exception -> L8
        throw null;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
