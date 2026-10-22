package com.bytedance.android.livesdk.feed;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveDrawerGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerGridLayoutManager extends GridLayoutManager {
    public LiveDrawerGridLayoutManager(Context r100) {
        super(r100, 2);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        SafetyGuard.a(null, e, "LiveDrawerGridLayoutManager onLayoutChildren error");
    }
}
