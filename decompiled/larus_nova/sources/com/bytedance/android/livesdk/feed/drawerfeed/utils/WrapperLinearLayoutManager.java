package com.bytedance.android.livesdk.feed.drawerfeed.utils;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ew1.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/utils/WrapperLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WrapperLinearLayoutManager extends LinearLayoutManager {
    public WrapperLinearLayoutManager(Context r100) {
        super(r100, 0, false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        b.a("onLayoutChildren", th);
    }
}
