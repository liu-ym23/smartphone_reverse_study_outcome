package com.bytedance.android.gamecp.common.paging.builder;

import androidx.paging.PagedList;

/* JADX INFO: loaded from: classes44.dex */
public class DefaultBoundaryCallback<V> extends PagedList.BoundaryCallback<V> {
    @Override // androidx.paging.PagedList.BoundaryCallback
    public final void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        throw null;
    }

    @Override // androidx.paging.PagedList.BoundaryCallback
    public final void onItemAtEndLoaded(V r100) {
        super.onItemAtEndLoaded(r100);
        throw null;
    }
}
