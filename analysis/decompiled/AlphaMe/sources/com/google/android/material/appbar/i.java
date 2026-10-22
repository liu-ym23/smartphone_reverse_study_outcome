package com.google.android.material.appbar;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class i extends m {

    /* renamed from: a, reason: collision with root package name */
    public H.a f10321a;

    /* renamed from: b, reason: collision with root package name */
    public OverScroller f10322b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10323c;

    /* renamed from: d, reason: collision with root package name */
    public int f10324d;

    /* renamed from: e, reason: collision with root package name */
    public int f10325e;

    /* renamed from: f, reason: collision with root package name */
    public int f10326f;

    /* renamed from: g, reason: collision with root package name */
    public VelocityTracker f10327g;

    public abstract int c();

    public abstract int d(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6);

    public final void e(CoordinatorLayout coordinatorLayout, View view, int i4) {
        d(coordinatorLayout, view, i4, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // A.b
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        View view2;
        int iFindPointerIndex;
        if (this.f10326f < 0) {
            this.f10326f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f10323c) {
            int i4 = this.f10324d;
            if (i4 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i4)) == -1) {
                return false;
            }
            int y4 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y4 - this.f10325e) > this.f10326f) {
                this.f10325e = y4;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f10324d = -1;
            int x4 = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            WeakReference weakReference = ((AppBarLayout$BaseBehavior) this).f10263l;
            boolean z4 = (weakReference == null || !((view2 = (View) weakReference.get()) == null || !view2.isShown() || view2.canScrollVertically(-1))) && coordinatorLayout.z(view, x4, y5);
            this.f10323c = z4;
            if (z4) {
                this.f10325e = y5;
                this.f10324d = motionEvent.getPointerId(0);
                if (this.f10327g == null) {
                    this.f10327g = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f10322b;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f10322b.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f10327g;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // A.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r21, android.view.View r22, android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.i.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }
}
