package com.bytedance.android.ec.store.search.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/store/search/recyclerview/WrapContentStaggeredGridLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WrapContentStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    public WrapContentStaggeredGridLayoutManager() {
        super(2, 1);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
