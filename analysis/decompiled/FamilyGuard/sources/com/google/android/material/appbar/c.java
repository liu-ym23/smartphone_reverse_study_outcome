package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
abstract class c<V extends View> extends e<V> {

    /* renamed from: a, reason: collision with root package name */
    private Runnable f12174a;

    /* renamed from: b, reason: collision with root package name */
    OverScroller f12175b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12176c;

    /* renamed from: d, reason: collision with root package name */
    private int f12177d;

    /* renamed from: e, reason: collision with root package name */
    private int f12178e;

    /* renamed from: f, reason: collision with root package name */
    private int f12179f;

    /* renamed from: g, reason: collision with root package name */
    private VelocityTracker f12180g;

    private class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final CoordinatorLayout f12181a;

        /* renamed from: b, reason: collision with root package name */
        private final V f12182b;

        a(CoordinatorLayout coordinatorLayout, V v5) {
            this.f12181a = coordinatorLayout;
            this.f12182b = v5;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f12182b == null || (overScroller = c.this.f12175b) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                c.this.i(this.f12181a, this.f12182b);
                return;
            }
            c cVar = c.this;
            cVar.k(this.f12181a, this.f12182b, cVar.f12175b.getCurrY());
            this.f12182b.postOnAnimation(this);
        }
    }

    public c() {
        this.f12177d = -1;
        this.f12179f = -1;
    }

    private void d() {
        if (this.f12180g == null) {
            this.f12180g = VelocityTracker.obtain();
        }
    }

    boolean c(V v5) {
        return false;
    }

    final boolean e(CoordinatorLayout coordinatorLayout, V v5, int i5, int i6, float f5) {
        Runnable runnable = this.f12174a;
        if (runnable != null) {
            v5.removeCallbacks(runnable);
            this.f12174a = null;
        }
        if (this.f12175b == null) {
            this.f12175b = new OverScroller(v5.getContext());
        }
        this.f12175b.fling(0, getTopAndBottomOffset(), 0, Math.round(f5), 0, 0, i5, i6);
        if (!this.f12175b.computeScrollOffset()) {
            i(coordinatorLayout, v5);
            return false;
        }
        a aVar = new a(coordinatorLayout, v5);
        this.f12174a = aVar;
        v5.postOnAnimation(aVar);
        return true;
    }

    int f(V v5) {
        return -v5.getHeight();
    }

    int g(V v5) {
        return v5.getHeight();
    }

    int h() {
        return getTopAndBottomOffset();
    }

    void i(CoordinatorLayout coordinatorLayout, V v5) {
    }

    final int j(CoordinatorLayout coordinatorLayout, V v5, int i5, int i6, int i7) {
        return l(coordinatorLayout, v5, h() - i5, i6, i7);
    }

    int k(CoordinatorLayout coordinatorLayout, V v5, int i5) {
        return l(coordinatorLayout, v5, i5, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int l(CoordinatorLayout coordinatorLayout, V v5, int i5, int i6, int i7) {
        int iB;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i6 == 0 || topAndBottomOffset < i6 || topAndBottomOffset > i7 || topAndBottomOffset == (iB = B.a.b(i5, i6, i7))) {
            return 0;
        }
        setTopAndBottomOffset(iB);
        return topAndBottomOffset - iB;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f12179f < 0) {
            this.f12179f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f12176c) {
            int i5 = this.f12177d;
            if (i5 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i5)) == -1) {
                return false;
            }
            int y5 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y5 - this.f12178e) > this.f12179f) {
                this.f12178e = y5;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f12177d = -1;
            int x5 = (int) motionEvent.getX();
            int y6 = (int) motionEvent.getY();
            boolean z5 = c(v5) && coordinatorLayout.O(v5, x5, y6);
            this.f12176c = z5;
            if (z5) {
                this.f12178e = y6;
                this.f12177d = motionEvent.getPointerId(0);
                d();
                OverScroller overScroller = this.f12175b;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f12175b.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f12180g;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[ADDED_TO_REGION] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            int r1 = r12.getActionMasked()
            r6 = -1
            r7 = 0
            r8 = 1
            if (r1 == r8) goto L4d
            r3 = 2
            if (r1 == r3) goto L2d
            r2 = 3
            if (r1 == r2) goto L71
            r2 = 6
            if (r1 == r2) goto L13
            goto L4b
        L13:
            int r1 = r12.getActionIndex()
            if (r1 != 0) goto L1b
            r1 = r8
            goto L1c
        L1b:
            r1 = r7
        L1c:
            int r2 = r12.getPointerId(r1)
            r9.f12177d = r2
            float r1 = r12.getY(r1)
            r2 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r2
            int r1 = (int) r1
            r9.f12178e = r1
            goto L4b
        L2d:
            int r1 = r9.f12177d
            int r1 = r12.findPointerIndex(r1)
            if (r1 != r6) goto L36
            return r7
        L36:
            float r1 = r12.getY(r1)
            int r1 = (int) r1
            int r3 = r9.f12178e
            int r3 = r3 - r1
            r9.f12178e = r1
            int r4 = r9.f(r11)
            r5 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.j(r1, r2, r3, r4, r5)
        L4b:
            r1 = r7
            goto L80
        L4d:
            android.view.VelocityTracker r1 = r9.f12180g
            if (r1 == 0) goto L71
            r1.addMovement(r12)
            android.view.VelocityTracker r1 = r9.f12180g
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3)
            android.view.VelocityTracker r1 = r9.f12180g
            int r3 = r9.f12177d
            float r5 = r1.getYVelocity(r3)
            int r1 = r9.g(r11)
            int r3 = -r1
            r4 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.e(r1, r2, r3, r4, r5)
            r1 = r8
            goto L72
        L71:
            r1 = r7
        L72:
            r9.f12176c = r7
            r9.f12177d = r6
            android.view.VelocityTracker r2 = r9.f12180g
            if (r2 == 0) goto L80
            r2.recycle()
            r2 = 0
            r9.f12180g = r2
        L80:
            android.view.VelocityTracker r2 = r9.f12180g
            if (r2 == 0) goto L87
            r2.addMovement(r12)
        L87:
            boolean r0 = r9.f12176c
            if (r0 != 0) goto L8f
            if (r1 == 0) goto L8e
            goto L8f
        L8e:
            return r7
        L8f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.c.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12177d = -1;
        this.f12179f = -1;
    }
}
