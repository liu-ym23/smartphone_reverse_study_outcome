package com.google.android.material.behavior;

import C0.c;
import C0.f;
import H0.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.N;

/* loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public H0.c f20352a;

    /* renamed from: b, reason: collision with root package name */
    public c f20353b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20354c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20355d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20357f;

    /* renamed from: e, reason: collision with root package name */
    public float f20356e = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public int f20358g = 2;

    /* renamed from: h, reason: collision with root package name */
    public float f20359h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    public float f20360i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f20361j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    public final c.AbstractC0044c f20362k = new a();

    public class a extends c.AbstractC0044c {

        /* renamed from: a, reason: collision with root package name */
        public int f20363a;

        /* renamed from: b, reason: collision with root package name */
        public int f20364b = -1;

        public a() {
        }

        @Override // H0.c.AbstractC0044c
        public int a(View view, int i10, int i11) {
            int width;
            int width2;
            int width3;
            boolean z10 = view.getLayoutDirection() == 1;
            int i12 = SwipeDismissBehavior.this.f20358g;
            if (i12 == 0) {
                if (z10) {
                    width = this.f20363a - view.getWidth();
                    width2 = this.f20363a;
                } else {
                    width = this.f20363a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i12 != 1) {
                width = this.f20363a - view.getWidth();
                width2 = this.f20363a + view.getWidth();
            } else if (z10) {
                width = this.f20363a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f20363a - view.getWidth();
                width2 = this.f20363a;
            }
            return SwipeDismissBehavior.j(width, i10, width2);
        }

        @Override // H0.c.AbstractC0044c
        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // H0.c.AbstractC0044c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // H0.c.AbstractC0044c
        public void i(View view, int i10) {
            this.f20364b = i10;
            this.f20363a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f20355d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f20355d = false;
            }
        }

        @Override // H0.c.AbstractC0044c
        public void j(int i10) {
            c cVar = SwipeDismissBehavior.this.f20353b;
            if (cVar != null) {
                cVar.b(i10);
            }
        }

        @Override // H0.c.AbstractC0044c
        public void k(View view, int i10, int i11, int i12, int i13) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f20360i;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f20361j;
            float fAbs = Math.abs(i10 - this.f20363a);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.i(0.0f, 1.0f - SwipeDismissBehavior.l(width, width2, fAbs), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @Override // H0.c.AbstractC0044c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r3, float r4, float r5) {
            /*
                r2 = this;
                r5 = -1
                r2.f20364b = r5
                int r5 = r3.getWidth()
                boolean r0 = r2.n(r3, r4)
                if (r0 == 0) goto L23
                r0 = 0
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 < 0) goto L1d
                int r4 = r3.getLeft()
                int r0 = r2.f20363a
                if (r4 >= r0) goto L1b
                goto L1d
            L1b:
                int r0 = r0 + r5
                goto L21
            L1d:
                int r4 = r2.f20363a
                int r0 = r4 - r5
            L21:
                r4 = 1
                goto L26
            L23:
                int r0 = r2.f20363a
                r4 = 0
            L26:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                H0.c r5 = r5.f20352a
                int r1 = r3.getTop()
                boolean r5 = r5.O(r0, r1)
                if (r5 == 0) goto L3f
                com.google.android.material.behavior.SwipeDismissBehavior$d r5 = new com.google.android.material.behavior.SwipeDismissBehavior$d
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r5.<init>(r3, r4)
                r3.postOnAnimation(r5)
                return
            L3f:
                if (r4 == 0) goto L4a
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$c r2 = r2.f20353b
                if (r2 == 0) goto L4a
                r2.a(r3)
            L4a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.l(android.view.View, float, float):void");
        }

        @Override // H0.c.AbstractC0044c
        public boolean m(View view, int i10) {
            int i11 = this.f20364b;
            return (i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.h(view);
        }

        public final boolean n(View view, float f10) {
            if (f10 == 0.0f) {
                return Math.abs(view.getLeft() - this.f20363a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f20359h);
            }
            boolean z10 = view.getLayoutDirection() == 1;
            int i10 = SwipeDismissBehavior.this.f20358g;
            if (i10 == 2) {
                return true;
            }
            if (i10 == 0) {
                return z10 ? f10 < 0.0f : f10 > 0.0f;
            }
            if (i10 == 1) {
                if (z10) {
                    return f10 > 0.0f;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }
    }

    public class b implements f {
        public b() {
        }

        @Override // C0.f
        public boolean a(View view, f.a aVar) {
            if (!SwipeDismissBehavior.this.h(view)) {
                return false;
            }
            boolean z10 = view.getLayoutDirection() == 1;
            int i10 = SwipeDismissBehavior.this.f20358g;
            N.S(view, (!(i10 == 0 && z10) && (i10 != 1 || z10)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f20353b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(View view);

        void b(int i10);
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final View f20367a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f20368b;

        public d(View view, boolean z10) {
            this.f20367a = view;
            this.f20368b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            H0.c cVar2 = SwipeDismissBehavior.this.f20352a;
            if (cVar2 != null && cVar2.m(true)) {
                this.f20367a.postOnAnimation(this);
            } else {
                if (!this.f20368b || (cVar = SwipeDismissBehavior.this.f20353b) == null) {
                    return;
                }
                cVar.a(this.f20367a);
            }
        }
    }

    public static float i(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    public static int j(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    public static float l(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    public boolean h(View view) {
        return true;
    }

    public final void k(ViewGroup viewGroup) {
        if (this.f20352a == null) {
            this.f20352a = this.f20357f ? H0.c.n(viewGroup, this.f20356e, this.f20362k) : H0.c.o(viewGroup, this.f20362k);
        }
    }

    public void m(float f10) {
        this.f20361j = i(0.0f, f10, 1.0f);
    }

    public void n(c cVar) {
        this.f20353b = cVar;
    }

    public void o(float f10) {
        this.f20360i = i(0.0f, f10, 1.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean zI = this.f20354c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zI = coordinatorLayout.I(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f20354c = zI;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f20354c = false;
        }
        if (zI) {
            k(coordinatorLayout);
            if (!this.f20355d && this.f20352a.P(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v10, i10);
        if (v10.getImportantForAccessibility() == 0) {
            v10.setImportantForAccessibility(1);
            q(v10);
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (this.f20352a == null) {
            return false;
        }
        if (this.f20355d && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f20352a.F(motionEvent);
        return true;
    }

    public void p(int i10) {
        this.f20358g = i10;
    }

    public final void q(View view) {
        N.b0(view, 1048576);
        if (h(view)) {
            N.d0(view, c.a.f1670y, null, new b());
        }
    }
}
