package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import w0.C5715a;

/* loaded from: classes2.dex */
public abstract class c<V extends View> extends e<V> {

    /* renamed from: a, reason: collision with root package name */
    public Runnable f20271a;

    /* renamed from: b, reason: collision with root package name */
    public OverScroller f20272b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20273c;

    /* renamed from: d, reason: collision with root package name */
    public int f20274d;

    /* renamed from: e, reason: collision with root package name */
    public int f20275e;

    /* renamed from: f, reason: collision with root package name */
    public int f20276f;

    /* renamed from: g, reason: collision with root package name */
    public VelocityTracker f20277g;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f20278a;

        /* renamed from: b, reason: collision with root package name */
        public final V f20279b;

        public a(CoordinatorLayout coordinatorLayout, V v10) {
            this.f20278a = coordinatorLayout;
            this.f20279b = v10;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f20279b == null || (overScroller = c.this.f20272b) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                c.this.m(this.f20278a, this.f20279b);
                return;
            }
            c cVar = c.this;
            cVar.o(this.f20278a, this.f20279b, cVar.f20272b.getCurrY());
            this.f20279b.postOnAnimation(this);
        }
    }

    public c() {
        this.f20274d = -1;
        this.f20276f = -1;
    }

    public boolean g(V v10) {
        return false;
    }

    public final void h() {
        if (this.f20277g == null) {
            this.f20277g = VelocityTracker.obtain();
        }
    }

    public final boolean i(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, float f10) {
        Runnable runnable = this.f20271a;
        if (runnable != null) {
            v10.removeCallbacks(runnable);
            this.f20271a = null;
        }
        if (this.f20272b == null) {
            this.f20272b = new OverScroller(v10.getContext());
        }
        this.f20272b.fling(0, getTopAndBottomOffset(), 0, Math.round(f10), 0, 0, i10, i11);
        if (!this.f20272b.computeScrollOffset()) {
            m(coordinatorLayout, v10);
            return false;
        }
        a aVar = new a(coordinatorLayout, v10);
        this.f20271a = aVar;
        v10.postOnAnimation(aVar);
        return true;
    }

    public int j(V v10) {
        return -v10.getHeight();
    }

    public int k(V v10) {
        return v10.getHeight();
    }

    public int l() {
        return getTopAndBottomOffset();
    }

    public void m(CoordinatorLayout coordinatorLayout, V v10) {
    }

    public final int n(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        return p(coordinatorLayout, v10, l() - i10, i11, i12);
    }

    public int o(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        return p(coordinatorLayout, v10, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f20276f < 0) {
            this.f20276f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f20273c) {
            int i10 = this.f20274d;
            if (i10 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y10 - this.f20275e) > this.f20276f) {
                this.f20275e = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f20274d = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            boolean z10 = g(v10) && coordinatorLayout.I(v10, x10, y11);
            this.f20273c = z10;
            if (z10) {
                this.f20275e = y11;
                this.f20274d = motionEvent.getPointerId(0);
                h();
                OverScroller overScroller = this.f20272b;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f20272b.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f20277g;
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
            r9.f20274d = r2
            float r1 = r12.getY(r1)
            r2 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r2
            int r1 = (int) r1
            r9.f20275e = r1
            goto L4b
        L2d:
            int r1 = r9.f20274d
            int r1 = r12.findPointerIndex(r1)
            if (r1 != r6) goto L36
            return r7
        L36:
            float r1 = r12.getY(r1)
            int r1 = (int) r1
            int r3 = r9.f20275e
            int r3 = r3 - r1
            r9.f20275e = r1
            int r4 = r9.j(r11)
            r5 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.n(r1, r2, r3, r4, r5)
        L4b:
            r1 = r7
            goto L80
        L4d:
            android.view.VelocityTracker r1 = r9.f20277g
            if (r1 == 0) goto L71
            r1.addMovement(r12)
            android.view.VelocityTracker r1 = r9.f20277g
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3)
            android.view.VelocityTracker r1 = r9.f20277g
            int r3 = r9.f20274d
            float r5 = r1.getYVelocity(r3)
            int r1 = r9.k(r11)
            int r3 = -r1
            r4 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.i(r1, r2, r3, r4, r5)
            r1 = r8
            goto L72
        L71:
            r1 = r7
        L72:
            r9.f20273c = r7
            r9.f20274d = r6
            android.view.VelocityTracker r2 = r9.f20277g
            if (r2 == 0) goto L80
            r2.recycle()
            r2 = 0
            r9.f20277g = r2
        L80:
            android.view.VelocityTracker r2 = r9.f20277g
            if (r2 == 0) goto L87
            r2.addMovement(r12)
        L87:
            boolean r0 = r9.f20273c
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

    public int p(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        int iB;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i11 == 0 || topAndBottomOffset < i11 || topAndBottomOffset > i12 || topAndBottomOffset == (iB = C5715a.b(i10, i11, i12))) {
            return 0;
        }
        setTopAndBottomOffset(iB);
        return topAndBottomOffset - iB;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20274d = -1;
        this.f20276f = -1;
    }
}
