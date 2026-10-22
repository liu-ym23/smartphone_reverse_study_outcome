package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e<V extends View> extends j<V> {

    /* renamed from: a, reason: collision with root package name */
    public a f4587a;

    /* renamed from: b, reason: collision with root package name */
    public OverScroller f4588b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4589c;

    /* renamed from: d, reason: collision with root package name */
    public int f4590d;

    /* renamed from: e, reason: collision with root package name */
    public int f4591e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public VelocityTracker f4592j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f4593a;

        /* renamed from: b, reason: collision with root package name */
        public final V f4594b;

        public a(CoordinatorLayout coordinatorLayout, V v3) {
            this.f4593a = coordinatorLayout;
            this.f4594b = v3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e eVar;
            OverScroller overScroller;
            V v3 = this.f4594b;
            if (v3 == null || (overScroller = (eVar = e.this).f4588b) == null) {
                return;
            }
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            CoordinatorLayout coordinatorLayout = this.f4593a;
            if (!zComputeScrollOffset) {
                eVar.k(coordinatorLayout, v3);
            } else {
                eVar.m(coordinatorLayout, v3, eVar.f4588b.getCurrY());
                v3.postOnAnimation(this);
            }
        }
    }

    public e() {
        this.f4590d = -1;
        this.h = -1;
    }

    public boolean h(V v3) {
        return false;
    }

    public int i(V v3) {
        return -v3.getHeight();
    }

    public int j(V v3) {
        return v3.getHeight();
    }

    public int l(CoordinatorLayout coordinatorLayout, V v3, int i10, int i11, int i12) {
        int iP;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i11 == 0 || topAndBottomOffset < i11 || topAndBottomOffset > i12 || topAndBottomOffset == (iP = y.p(i10, i11, i12))) {
            return 0;
        }
        setTopAndBottomOffset(iP);
        return topAndBottomOffset - iP;
    }

    public final void m(CoordinatorLayout coordinatorLayout, View view, int i10) {
        l(coordinatorLayout, view, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r7, V r8, android.view.MotionEvent r9) {
        /*
            r6 = this;
            int r0 = r6.h
            if (r0 >= 0) goto L12
            android.content.Context r0 = r7.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r6.h = r0
        L12:
            int r0 = r9.getActionMasked()
            r1 = 2
            r2 = 1
            r3 = -1
            r4 = 0
            if (r0 != r1) goto L40
            boolean r0 = r6.f4589c
            if (r0 == 0) goto L40
            int r0 = r6.f4590d
            if (r0 != r3) goto L25
            goto L8e
        L25:
            int r0 = r9.findPointerIndex(r0)
            if (r0 != r3) goto L2c
            goto L8e
        L2c:
            float r0 = r9.getY(r0)
            int r0 = (int) r0
            int r1 = r6.f4591e
            int r1 = r0 - r1
            int r1 = java.lang.Math.abs(r1)
            int r5 = r6.h
            if (r1 <= r5) goto L40
            r6.f4591e = r0
            return r2
        L40:
            int r0 = r9.getActionMasked()
            if (r0 != 0) goto L87
            r6.f4590d = r3
            float r0 = r9.getX()
            int r0 = (int) r0
            float r1 = r9.getY()
            int r1 = (int) r1
            boolean r3 = r6.h(r8)
            if (r3 == 0) goto L60
            boolean r7 = r7.z(r8, r0, r1)
            if (r7 == 0) goto L60
            r7 = r2
            goto L61
        L60:
            r7 = r4
        L61:
            r6.f4589c = r7
            if (r7 == 0) goto L87
            r6.f4591e = r1
            int r7 = r9.getPointerId(r4)
            r6.f4590d = r7
            android.view.VelocityTracker r7 = r6.f4592j
            if (r7 != 0) goto L77
            android.view.VelocityTracker r7 = android.view.VelocityTracker.obtain()
            r6.f4592j = r7
        L77:
            android.widget.OverScroller r7 = r6.f4588b
            if (r7 == 0) goto L87
            boolean r7 = r7.isFinished()
            if (r7 != 0) goto L87
            android.widget.OverScroller r6 = r6.f4588b
            r6.abortAnimation()
            return r2
        L87:
            android.view.VelocityTracker r6 = r6.f4592j
            if (r6 == 0) goto L8e
            r6.addMovement(r9)
        L8e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.e.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d8 A[ADDED_TO_REGION] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r19, V r20, android.view.MotionEvent r21) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.e.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4590d = -1;
        this.h = -1;
    }

    public void k(CoordinatorLayout coordinatorLayout, V v3) {
    }
}
