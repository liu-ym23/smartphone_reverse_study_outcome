package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.k;

/* loaded from: classes.dex */
public abstract class E extends k {

    /* renamed from: Q, reason: collision with root package name */
    private static final String[] f11344Q = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: M, reason: collision with root package name */
    private int f11345M = 3;

    private static class a extends AnimatorListenerAdapter implements k.f {

        /* renamed from: a, reason: collision with root package name */
        private final View f11346a;

        /* renamed from: b, reason: collision with root package name */
        private final int f11347b;

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f11348c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f11349d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f11350e;

        /* renamed from: f, reason: collision with root package name */
        boolean f11351f = false;

        a(View view, int i5, boolean z5) {
            this.f11346a = view;
            this.f11347b = i5;
            this.f11348c = (ViewGroup) view.getParent();
            this.f11349d = z5;
            i(true);
        }

        private void h() {
            if (!this.f11351f) {
                y.f(this.f11346a, this.f11347b);
                ViewGroup viewGroup = this.f11348c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            i(false);
        }

        private void i(boolean z5) {
            ViewGroup viewGroup;
            if (!this.f11349d || this.f11350e == z5 || (viewGroup = this.f11348c) == null) {
                return;
            }
            this.f11350e = z5;
            x.a(viewGroup, z5);
        }

        @Override // androidx.transition.k.f
        public void a(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void b(k kVar) {
            i(false);
            if (this.f11351f) {
                return;
            }
            y.f(this.f11346a, this.f11347b);
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
            kVar.X(this);
        }

        @Override // androidx.transition.k.f
        public void e(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void g(k kVar) {
            i(true);
            if (this.f11351f) {
                return;
            }
            y.f(this.f11346a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f11351f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z5) {
            if (z5) {
                return;
            }
            h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z5) {
            if (z5) {
                y.f(this.f11346a, 0);
                ViewGroup viewGroup = this.f11348c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }
    }

    private class b extends AnimatorListenerAdapter implements k.f {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f11352a;

        /* renamed from: b, reason: collision with root package name */
        private final View f11353b;

        /* renamed from: c, reason: collision with root package name */
        private final View f11354c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f11355d = true;

        b(ViewGroup viewGroup, View view, View view2) {
            this.f11352a = viewGroup;
            this.f11353b = view;
            this.f11354c = view2;
        }

        private void h() {
            this.f11354c.setTag(h.f11417a, null);
            this.f11352a.getOverlay().remove(this.f11353b);
            this.f11355d = false;
        }

        @Override // androidx.transition.k.f
        public void a(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void b(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
            kVar.X(this);
        }

        @Override // androidx.transition.k.f
        public void e(k kVar) {
            if (this.f11355d) {
                h();
            }
        }

        @Override // androidx.transition.k.f
        public void g(k kVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f11352a.getOverlay().remove(this.f11353b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f11353b.getParent() == null) {
                this.f11352a.getOverlay().add(this.f11353b);
            } else {
                E.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z5) {
            if (z5) {
                this.f11354c.setTag(h.f11417a, this.f11353b);
                this.f11352a.getOverlay().add(this.f11353b);
                this.f11355d = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z5) {
            if (z5) {
                return;
            }
            h();
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f11357a;

        /* renamed from: b, reason: collision with root package name */
        boolean f11358b;

        /* renamed from: c, reason: collision with root package name */
        int f11359c;

        /* renamed from: d, reason: collision with root package name */
        int f11360d;

        /* renamed from: e, reason: collision with root package name */
        ViewGroup f11361e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f11362f;

        c() {
        }
    }

    private void k0(v vVar) {
        vVar.f11492a.put("android:visibility:visibility", Integer.valueOf(vVar.f11493b.getVisibility()));
        vVar.f11492a.put("android:visibility:parent", vVar.f11493b.getParent());
        int[] iArr = new int[2];
        vVar.f11493b.getLocationOnScreen(iArr);
        vVar.f11492a.put("android:visibility:screenLocation", iArr);
    }

    private c l0(v vVar, v vVar2) {
        c cVar = new c();
        cVar.f11357a = false;
        cVar.f11358b = false;
        if (vVar == null || !vVar.f11492a.containsKey("android:visibility:visibility")) {
            cVar.f11359c = -1;
            cVar.f11361e = null;
        } else {
            cVar.f11359c = ((Integer) vVar.f11492a.get("android:visibility:visibility")).intValue();
            cVar.f11361e = (ViewGroup) vVar.f11492a.get("android:visibility:parent");
        }
        if (vVar2 == null || !vVar2.f11492a.containsKey("android:visibility:visibility")) {
            cVar.f11360d = -1;
            cVar.f11362f = null;
        } else {
            cVar.f11360d = ((Integer) vVar2.f11492a.get("android:visibility:visibility")).intValue();
            cVar.f11362f = (ViewGroup) vVar2.f11492a.get("android:visibility:parent");
        }
        if (vVar != null && vVar2 != null) {
            int i5 = cVar.f11359c;
            int i6 = cVar.f11360d;
            if (i5 != i6 || cVar.f11361e != cVar.f11362f) {
                if (i5 != i6) {
                    if (i5 == 0) {
                        cVar.f11358b = false;
                        cVar.f11357a = true;
                        return cVar;
                    }
                    if (i6 == 0) {
                        cVar.f11358b = true;
                        cVar.f11357a = true;
                        return cVar;
                    }
                } else {
                    if (cVar.f11362f == null) {
                        cVar.f11358b = false;
                        cVar.f11357a = true;
                        return cVar;
                    }
                    if (cVar.f11361e == null) {
                        cVar.f11358b = true;
                        cVar.f11357a = true;
                        return cVar;
                    }
                }
            }
        } else {
            if (vVar == null && cVar.f11360d == 0) {
                cVar.f11358b = true;
                cVar.f11357a = true;
                return cVar;
            }
            if (vVar2 == null && cVar.f11359c == 0) {
                cVar.f11358b = false;
                cVar.f11357a = true;
            }
        }
        return cVar;
    }

    @Override // androidx.transition.k
    public String[] J() {
        return f11344Q;
    }

    @Override // androidx.transition.k
    public boolean L(v vVar, v vVar2) {
        if (vVar == null && vVar2 == null) {
            return false;
        }
        if (vVar != null && vVar2 != null && vVar2.f11492a.containsKey("android:visibility:visibility") != vVar.f11492a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarL0 = l0(vVar, vVar2);
        return cVarL0.f11357a && (cVarL0.f11359c == 0 || cVarL0.f11360d == 0);
    }

    @Override // androidx.transition.k
    public void i(v vVar) {
        k0(vVar);
    }

    @Override // androidx.transition.k
    public void l(v vVar) {
        k0(vVar);
    }

    public abstract Animator m0(ViewGroup viewGroup, View view, v vVar, v vVar2);

    public Animator n0(ViewGroup viewGroup, v vVar, int i5, v vVar2, int i6) {
        if ((this.f11345M & 1) != 1 || vVar2 == null) {
            return null;
        }
        if (vVar == null) {
            View view = (View) vVar2.f11493b.getParent();
            if (l0(y(view, false), K(view, false)).f11357a) {
                return null;
            }
        }
        return m0(viewGroup, vVar2.f11493b, vVar, vVar2);
    }

    public abstract Animator o0(ViewGroup viewGroup, View view, v vVar, v vVar2);

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[PHI: r2
      0x0069: PHI (r2v3 android.view.View) = 
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v6 android.view.View)
     binds: [B:26:0x003e, B:31:0x004d, B:37:0x0076, B:39:0x0079, B:41:0x007f, B:43:0x0083, B:34:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator p0(android.view.ViewGroup r11, androidx.transition.v r12, int r13, androidx.transition.v r14, int r15) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.E.p0(android.view.ViewGroup, androidx.transition.v, int, androidx.transition.v, int):android.animation.Animator");
    }

    public void q0(int i5) {
        if ((i5 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f11345M = i5;
    }

    @Override // androidx.transition.k
    public Animator s(ViewGroup viewGroup, v vVar, v vVar2) {
        c cVarL0 = l0(vVar, vVar2);
        if (!cVarL0.f11357a) {
            return null;
        }
        if (cVarL0.f11361e == null && cVarL0.f11362f == null) {
            return null;
        }
        return cVarL0.f11358b ? n0(viewGroup, vVar, cVarL0.f11359c, vVar2, cVarL0.f11360d) : p0(viewGroup, vVar, cVarL0.f11359c, vVar2, cVarL0.f11360d);
    }
}
