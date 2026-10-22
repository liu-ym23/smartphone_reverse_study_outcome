package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.SafetyGuard;

/* JADX INFO: loaded from: classes8.dex */
public class SmoothLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f112546a;

    public class a extends LinearSmoothScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmoothLinearLayoutManager f112547a;

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final float calculateSpeedPerPixel(DisplayMetrics r100) {
            return this.f112547a.f112546a / r100.densityDpi;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final PointF computeScrollVectorForPosition(int r100) {
            return this.f112547a.computeScrollVectorForPosition(r100);
        }

        public a(SmoothLinearLayoutManager r100, Context r101) {
            this.f112547a = r100;
            super(r101);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return super.canScrollHorizontally();
    }

    public SmoothLinearLayoutManager(Context r100) {
        super(r100, 1, false);
        this.f112546a = 25.0f;
    }

    public final void p(float r100) {
        if (r100 <= 0.0f) goto L6;
        this.f112546a = r100;
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        SafetyGuard.a(null, e, "SmoothLinearLayoutManager onLayoutChildren error");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        if (r102 >= 0) goto L4;
        r102 = 0;
    L4:
        a r103 = new a(this, r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }

    public SmoothLinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.f112546a = 25.0f;
    }
}
