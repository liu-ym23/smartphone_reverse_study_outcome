package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c1.c;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import m4.h;
import v0.e0;
import w0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public c f4630a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4631b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4632c;

    /* renamed from: d, reason: collision with root package name */
    public int f4633d = 2;

    /* renamed from: e, reason: collision with root package name */
    public final float f4634e = 0.5f;
    public float h = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f4635j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    public final a f4636k = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final View f4640a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f4641b;

        public b(View view, boolean z) {
            this.f4640a = view;
            this.f4641b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = SwipeDismissBehavior.this.f4630a;
            if (cVar == null || !cVar.h()) {
                return;
            }
            this.f4640a.postOnAnimation(this);
        }
    }

    public boolean g(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        boolean z = this.f4631b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.z(v3, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f4631b = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f4631b = false;
        }
        if (z) {
            if (this.f4630a == null) {
                this.f4630a = new c(coordinatorLayout.getContext(), coordinatorLayout, this.f4636k);
            }
            if (!this.f4632c && this.f4630a.t(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i10) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v3, i10);
        if (v3.getImportantForAccessibility() == 0) {
            v3.setImportantForAccessibility(1);
            e0.h(CryptoHeaderParser.MAX_BLOCK_SIZE, v3);
            e0.e(0, v3);
            if (g(v3)) {
                e0.i(v3, b.a.f13539j, new h(this));
            }
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        if (this.f4630a == null) {
            return false;
        }
        if (this.f4632c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f4630a.m(motionEvent);
        return true;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends c.AbstractC0028c {

        /* renamed from: a, reason: collision with root package name */
        public int f4637a;

        /* renamed from: b, reason: collision with root package name */
        public int f4638b = -1;

        public a() {
        }

        @Override // c1.c.AbstractC0028c
        public final int a(int i10, View view) {
            int width;
            int width2;
            int width3;
            boolean z = view.getLayoutDirection() == 1;
            int i11 = SwipeDismissBehavior.this.f4633d;
            if (i11 == 0) {
                if (z) {
                    width = this.f4637a - view.getWidth();
                    width2 = this.f4637a;
                } else {
                    width = this.f4637a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i11 != 1) {
                width = this.f4637a - view.getWidth();
                width2 = this.f4637a + view.getWidth();
            } else if (z) {
                width = this.f4637a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f4637a - view.getWidth();
                width2 = this.f4637a;
            }
            return Math.min(Math.max(width, i10), width2);
        }

        @Override // c1.c.AbstractC0028c
        public final int b(int i10, View view) {
            return view.getTop();
        }

        @Override // c1.c.AbstractC0028c
        public final int c(View view) {
            return view.getWidth();
        }

        @Override // c1.c.AbstractC0028c
        public final void g(int i10, View view) {
            this.f4638b = i10;
            this.f4637a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
                swipeDismissBehavior.f4632c = true;
                parent.requestDisallowInterceptTouchEvent(true);
                swipeDismissBehavior.f4632c = false;
            }
        }

        @Override // c1.c.AbstractC0028c
        public final void i(View view, int i10, int i11) {
            float width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            float f8 = width * swipeDismissBehavior.h;
            float width2 = view.getWidth() * swipeDismissBehavior.f4635j;
            float fAbs = Math.abs(i10 - this.f4637a);
            if (fAbs <= f8) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f8) / (width2 - f8))), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
        @Override // c1.c.AbstractC0028c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void j(android.view.View r9, float r10, float r11) {
            /*
                r8 = this;
                r11 = -1
                r8.f4638b = r11
                int r11 = r9.getWidth()
                r0 = 0
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                r2 = 0
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r4 = 1
                if (r1 == 0) goto L37
                int r5 = r9.getLayoutDirection()
                if (r5 != r4) goto L18
                r5 = r4
                goto L19
            L18:
                r5 = r2
            L19:
                int r6 = r3.f4633d
                r7 = 2
                if (r6 != r7) goto L1f
                goto L50
            L1f:
                if (r6 != 0) goto L2b
                if (r5 == 0) goto L28
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r1 >= 0) goto L65
                goto L50
            L28:
                if (r1 <= 0) goto L65
                goto L50
            L2b:
                if (r6 != r4) goto L65
                if (r5 == 0) goto L32
                if (r1 <= 0) goto L65
                goto L50
            L32:
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r1 >= 0) goto L65
                goto L50
            L37:
                int r1 = r9.getLeft()
                int r5 = r8.f4637a
                int r1 = r1 - r5
                int r5 = r9.getWidth()
                float r5 = (float) r5
                float r6 = r3.f4634e
                float r5 = r5 * r6
                int r5 = java.lang.Math.round(r5)
                int r1 = java.lang.Math.abs(r1)
                if (r1 < r5) goto L65
            L50:
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 < 0) goto L5f
                int r10 = r9.getLeft()
                int r0 = r8.f4637a
                if (r10 >= r0) goto L5d
                goto L5f
            L5d:
                int r0 = r0 + r11
                goto L63
            L5f:
                int r8 = r8.f4637a
                int r0 = r8 - r11
            L63:
                r2 = r4
                goto L67
            L65:
                int r0 = r8.f4637a
            L67:
                c1.c r8 = r3.f4630a
                int r10 = r9.getTop()
                boolean r8 = r8.s(r0, r10)
                if (r8 == 0) goto L7b
                com.google.android.material.behavior.SwipeDismissBehavior$b r8 = new com.google.android.material.behavior.SwipeDismissBehavior$b
                r8.<init>(r9, r2)
                r9.postOnAnimation(r8)
            L7b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.j(android.view.View, float, float):void");
        }

        @Override // c1.c.AbstractC0028c
        public final boolean k(int i10, View view) {
            int i11 = this.f4638b;
            return (i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.g(view);
        }

        @Override // c1.c.AbstractC0028c
        public final void h(int i10) {
        }
    }
}
