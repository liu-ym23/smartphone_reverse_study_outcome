package com.bytedanceos.common.tangram.bouncy;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;

/* JADX INFO: loaded from: classes2.dex */
public class DecelerateSmoothScroller extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PointF f9917g;

    public DecelerateSmoothScroller(Context r10) {
        super(r10);
        this.f9911a = 1.0f;
        this.f9912b = 100;
        this.f9913c = false;
        this.f9914d = false;
        this.f9915e = 0;
        this.f9916f = 0;
        this.f9917g = new PointF();
    }

    public final int c() {
        if (this.f9913c == false) goto L7;
        return this.f9915e;
    L7:
        return getHorizontalSnapPreference();
    }

    @Override // androidx.recyclerview.widget.h
    public int calculateTimeForScrolling(int r10) {
        return (int) Math.ceil(Math.abs(r10) / this.f9911a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public PointF computeScrollVectorForPosition(int r10) {
        return this.f9917g;
    }

    public void d(int r10) {
        this.f9912b = r10;
    }

    public void e(float r10) {
        this.f9911a = r10;
    }

    public void f(PointF r10) {
        this.f9917g = r10;
    }

    @Override // androidx.recyclerview.widget.h, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onTargetFound(View r10, RecyclerView.State r11, RecyclerView.SmoothScroller.a r12) {
        int r13 = calculateDxToMakeVisible(r10, c());
        if (this.f9917g.y <= 0.0f) goto L5;
        int r14 = -this.f9912b;
    L6:
        int r15 = calculateTimeForDeceleration((int) Math.sqrt((r13 * r13) + (r14 * r14)));
        if (r15 <= 0) goto L10;
        r12.d(-r13, -r14, r15, new DecelerateInterpolator(2.0f));
        return;
    L10:
        return;
    L5:
        r14 = this.f9912b;
        goto L6
    }
}
