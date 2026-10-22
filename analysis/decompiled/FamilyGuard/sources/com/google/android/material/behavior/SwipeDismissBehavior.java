package com.google.android.material.behavior;

import E.c;
import E.f;
import J.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.H;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    J.c f12228a;

    /* renamed from: b, reason: collision with root package name */
    c f12229b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12230c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12231d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12233f;

    /* renamed from: e, reason: collision with root package name */
    private float f12232e = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    int f12234g = 2;

    /* renamed from: h, reason: collision with root package name */
    float f12235h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    float f12236i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    float f12237j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    private final c.AbstractC0042c f12238k = new a();

    class a extends c.AbstractC0042c {

        /* renamed from: a, reason: collision with root package name */
        private int f12239a;

        /* renamed from: b, reason: collision with root package name */
        private int f12240b = -1;

        a() {
        }

        private boolean n(View view, float f5) {
            if (f5 == 0.0f) {
                return Math.abs(view.getLeft() - this.f12239a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f12235h);
            }
            boolean z5 = view.getLayoutDirection() == 1;
            int i5 = SwipeDismissBehavior.this.f12234g;
            if (i5 == 2) {
                return true;
            }
            if (i5 == 0) {
                return z5 ? f5 < 0.0f : f5 > 0.0f;
            }
            if (i5 == 1) {
                if (z5) {
                    return f5 > 0.0f;
                }
                if (f5 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        @Override // J.c.AbstractC0042c
        public int a(View view, int i5, int i6) {
            int width;
            int width2;
            int width3;
            boolean z5 = view.getLayoutDirection() == 1;
            int i7 = SwipeDismissBehavior.this.f12234g;
            if (i7 == 0) {
                if (z5) {
                    width = this.f12239a - view.getWidth();
                    width2 = this.f12239a;
                } else {
                    width = this.f12239a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i7 != 1) {
                width = this.f12239a - view.getWidth();
                width2 = this.f12239a + view.getWidth();
            } else if (z5) {
                width = this.f12239a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f12239a - view.getWidth();
                width2 = this.f12239a;
            }
            return SwipeDismissBehavior.f(width, i5, width2);
        }

        @Override // J.c.AbstractC0042c
        public int b(View view, int i5, int i6) {
            return view.getTop();
        }

        @Override // J.c.AbstractC0042c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // J.c.AbstractC0042c
        public void i(View view, int i5) {
            this.f12240b = i5;
            this.f12239a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f12231d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f12231d = false;
            }
        }

        @Override // J.c.AbstractC0042c
        public void j(int i5) {
            c cVar = SwipeDismissBehavior.this.f12229b;
            if (cVar != null) {
                cVar.b(i5);
            }
        }

        @Override // J.c.AbstractC0042c
        public void k(View view, int i5, int i6, int i7, int i8) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f12236i;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f12237j;
            float fAbs = Math.abs(i5 - this.f12239a);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.e(0.0f, 1.0f - SwipeDismissBehavior.h(width, width2, fAbs), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @Override // J.c.AbstractC0042c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r3, float r4, float r5) {
            /*
                r2 = this;
                r5 = -1
                r2.f12240b = r5
                int r5 = r3.getWidth()
                boolean r0 = r2.n(r3, r4)
                if (r0 == 0) goto L23
                r0 = 0
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 < 0) goto L1d
                int r4 = r3.getLeft()
                int r0 = r2.f12239a
                if (r4 >= r0) goto L1b
                goto L1d
            L1b:
                int r0 = r0 + r5
                goto L21
            L1d:
                int r4 = r2.f12239a
                int r0 = r4 - r5
            L21:
                r4 = 1
                goto L26
            L23:
                int r0 = r2.f12239a
                r4 = 0
            L26:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                J.c r5 = r5.f12228a
                int r1 = r3.getTop()
                boolean r5 = r5.F(r0, r1)
                if (r5 == 0) goto L3f
                com.google.android.material.behavior.SwipeDismissBehavior$d r5 = new com.google.android.material.behavior.SwipeDismissBehavior$d
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r5.<init>(r3, r4)
                r3.postOnAnimation(r5)
                return
            L3f:
                if (r4 == 0) goto L4a
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$c r2 = r2.f12229b
                if (r2 == 0) goto L4a
                r2.a(r3)
            L4a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.l(android.view.View, float, float):void");
        }

        @Override // J.c.AbstractC0042c
        public boolean m(View view, int i5) {
            int i6 = this.f12240b;
            return (i6 == -1 || i6 == i5) && SwipeDismissBehavior.this.d(view);
        }
    }

    class b implements f {
        b() {
        }

        @Override // E.f
        public boolean a(View view, f.a aVar) {
            if (!SwipeDismissBehavior.this.d(view)) {
                return false;
            }
            boolean z5 = view.getLayoutDirection() == 1;
            int i5 = SwipeDismissBehavior.this.f12234g;
            H.U(view, (!(i5 == 0 && z5) && (i5 != 1 || z5)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f12229b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(View view);

        void b(int i5);
    }

    private class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final View f12243a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f12244b;

        d(View view, boolean z5) {
            this.f12243a = view;
            this.f12244b = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            J.c cVar2 = SwipeDismissBehavior.this.f12228a;
            if (cVar2 != null && cVar2.k(true)) {
                this.f12243a.postOnAnimation(this);
            } else {
                if (!this.f12244b || (cVar = SwipeDismissBehavior.this.f12229b) == null) {
                    return;
                }
                cVar.a(this.f12243a);
            }
        }
    }

    static float e(float f5, float f6, float f7) {
        return Math.min(Math.max(f5, f6), f7);
    }

    static int f(int i5, int i6, int i7) {
        return Math.min(Math.max(i5, i6), i7);
    }

    private void g(ViewGroup viewGroup) {
        if (this.f12228a == null) {
            this.f12228a = this.f12233f ? J.c.l(viewGroup, this.f12232e, this.f12238k) : J.c.m(viewGroup, this.f12238k);
        }
    }

    static float h(float f5, float f6, float f7) {
        return (f7 - f5) / (f6 - f5);
    }

    private void m(View view) {
        H.d0(view, 1048576);
        if (d(view)) {
            H.f0(view, c.a.f1266y, null, new b());
        }
    }

    public boolean d(View view) {
        return true;
    }

    public void i(float f5) {
        this.f12237j = e(0.0f, f5, 1.0f);
    }

    public void j(c cVar) {
        this.f12229b = cVar;
    }

    public void k(float f5) {
        this.f12236i = e(0.0f, f5, 1.0f);
    }

    public void l(int i5) {
        this.f12234g = i5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        boolean zO = this.f12230c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zO = coordinatorLayout.O(v5, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f12230c = zO;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f12230c = false;
        }
        if (zO) {
            g(coordinatorLayout);
            if (!this.f12231d && this.f12228a.G(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v5, int i5) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v5, i5);
        if (v5.getImportantForAccessibility() == 0) {
            v5.setImportantForAccessibility(1);
            m(v5);
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        if (this.f12228a == null) {
            return false;
        }
        if (this.f12231d && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f12228a.z(motionEvent);
        return true;
    }
}
