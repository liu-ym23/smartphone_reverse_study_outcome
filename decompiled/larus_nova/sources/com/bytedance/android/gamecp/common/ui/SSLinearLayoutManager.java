package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.common.monitor.SafetyGuard;
import com.ss.alog.middleware.ALogService;

/* JADX INFO: loaded from: classes44.dex */
public class SSLinearLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        SafetyGuard.a(e, "SSLinearLayoutManager onLayoutChildren error");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollHorizontallyBy(r100, r101, r102);
    L4:
        e = move-exception;
        ALogService.eSafely("SSLinearLayoutManager", e);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollVerticallyBy(r100, r101, r102);
    L4:
        e = move-exception;
        ALogService.eSafely("SSLinearLayoutManager", e);
        return 0;
    }

    public SSLinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
