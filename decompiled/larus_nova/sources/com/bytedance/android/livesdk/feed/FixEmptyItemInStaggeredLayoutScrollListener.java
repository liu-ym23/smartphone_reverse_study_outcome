package com.bytedance.android.livesdk.feed;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes8.dex */
public class FixEmptyItemInStaggeredLayoutScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f123438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f123439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f123440c;

    public FixEmptyItemInStaggeredLayoutScrollListener(int r100) {
        this.f123438a = new int[r100];
        this.f123439b = new int[r100];
        this.f123440c = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        super.onScrollStateChanged(r100, r101);
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();     // Catch: Exception -> L13
        if ((r102 instanceof StaggeredGridLayoutManager) == true) goto L6;
        return;
    L6:
        StaggeredGridLayoutManager r103 = (StaggeredGridLayoutManager) r102;     // Catch: Exception -> L13
        r103.findFirstVisibleItemPositions(this.f123438a);     // Catch: Exception -> L13
        if (this.f123438a[0] >= this.f123440c) goto L9;
        r103.invalidateSpanAssignments();     // Catch: Exception -> L13
    L9:
        r103.findLastVisibleItemPositions(this.f123439b);     // Catch: Exception -> L13
        if (this.f123439b[0] < (r103.getItemCount() - this.f123440c)) goto L18;
        r103.invalidateSpanAssignments();     // Catch: Exception -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }
}
