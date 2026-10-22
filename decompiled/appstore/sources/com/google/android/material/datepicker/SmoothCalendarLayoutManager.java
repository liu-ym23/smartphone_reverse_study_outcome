package com.google.android.material.datepicker;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;

/* JADX INFO: loaded from: classes3.dex */
class SmoothCalendarLayoutManager extends LinearLayoutManager {
    private static final float MILLISECONDS_PER_INCH = 100.0f;

    public SmoothCalendarLayoutManager(Context r10, int r11, boolean r12) {
        super(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r10, RecyclerView.State r11, int r12) {
        final Context r13 = r10.getContext();
        h r14 = new AnonymousClass1(this, r13);
        r14.setTargetPosition(r12);
        startSmoothScroll(r14);
    }
}
