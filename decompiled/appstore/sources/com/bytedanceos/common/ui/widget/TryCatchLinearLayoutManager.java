package com.bytedanceos.common.ui.widget;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class TryCatchLinearLayoutManager extends LinearLayoutManager {
    public TryCatchLinearLayoutManager(Context r10) {
        super(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        super.onLayoutChildren(r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
