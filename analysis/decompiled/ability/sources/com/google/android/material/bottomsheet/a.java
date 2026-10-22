package com.google.android.material.bottomsheet;

import android.view.View;
import android.widget.OverScroller;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.v0;

/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2344a;
    public int b;
    public final Object c;
    public final /* synthetic */ Object d;

    public a(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.f2344a = 0;
        this.d = bottomSheetBehavior;
        this.c = view;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2344a) {
            case 0:
                ((BottomSheetBehavior) this.d).p((View) this.c, this.b, false);
                break;
            default:
                StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) this.d;
                OverScroller overScroller = (OverScroller) this.c;
                if (!overScroller.isFinished()) {
                    overScroller.computeScrollOffset();
                    int currY = overScroller.getCurrY();
                    int currY2 = overScroller.getCurrY() - this.b;
                    this.b = currY;
                    if (currY2 != 0) {
                        StepOSRecyclerView.d(stepOSRecyclerView, -currY2, true);
                    }
                    stepOSRecyclerView.invalidate();
                    stepOSRecyclerView.postOnAnimation(this);
                    break;
                } else {
                    stepOSRecyclerView.f6531a = -1;
                    stepOSRecyclerView.removeCallbacks(this);
                    v0.b(stepOSRecyclerView);
                    ((OverScroller) this.c).abortAnimation();
                    break;
                }
        }
    }

    public a(StepOSRecyclerView stepOSRecyclerView) {
        this.f2344a = 1;
        this.d = stepOSRecyclerView;
        this.b = 0;
        this.c = new OverScroller(stepOSRecyclerView.getContext());
    }
}
