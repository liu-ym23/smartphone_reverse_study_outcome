package p1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;
import p1.j;

/* loaded from: classes.dex */
public abstract class G extends j {

    /* renamed from: Q, reason: collision with root package name */
    public static final String[] f38062Q = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: P, reason: collision with root package name */
    public int f38063P = 3;

    public static class a extends AnimatorListenerAdapter implements j.h {

        /* renamed from: a, reason: collision with root package name */
        public final View f38064a;

        /* renamed from: b, reason: collision with root package name */
        public final int f38065b;

        /* renamed from: c, reason: collision with root package name */
        public final ViewGroup f38066c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f38067d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f38068e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f38069f = false;

        public a(View view, int i10, boolean z10) {
            this.f38064a = view;
            this.f38065b = i10;
            this.f38066c = (ViewGroup) view.getParent();
            this.f38067d = z10;
            b(true);
        }

        public final void a() {
            if (!this.f38069f) {
                C5038A.f(this.f38064a, this.f38065b);
                ViewGroup viewGroup = this.f38066c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            b(false);
        }

        public final void b(boolean z10) {
            ViewGroup viewGroup;
            if (!this.f38067d || this.f38068e == z10 || (viewGroup = this.f38066c) == null) {
                return;
            }
            this.f38068e = z10;
            z.a(viewGroup, z10);
        }

        @Override // p1.j.h
        public void c(j jVar) {
        }

        @Override // p1.j.h
        public void e(j jVar) {
        }

        @Override // p1.j.h
        public void f(j jVar) {
            jVar.g0(this);
        }

        @Override // p1.j.h
        public void i(j jVar) {
            b(false);
            if (this.f38069f) {
                return;
            }
            C5038A.f(this.f38064a, this.f38065b);
        }

        @Override // p1.j.h
        public void k(j jVar) {
            b(true);
            if (this.f38069f) {
                return;
            }
            C5038A.f(this.f38064a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f38069f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            if (z10) {
                C5038A.f(this.f38064a, 0);
                ViewGroup viewGroup = this.f38066c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }
    }

    public class b extends AnimatorListenerAdapter implements j.h {

        /* renamed from: a, reason: collision with root package name */
        public final ViewGroup f38070a;

        /* renamed from: b, reason: collision with root package name */
        public final View f38071b;

        /* renamed from: c, reason: collision with root package name */
        public final View f38072c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f38073d = true;

        public b(ViewGroup viewGroup, View view, View view2) {
            this.f38070a = viewGroup;
            this.f38071b = view;
            this.f38072c = view2;
        }

        public final void a() {
            this.f38072c.setTag(R$id.save_overlay_view, null);
            this.f38070a.getOverlay().remove(this.f38071b);
            this.f38073d = false;
        }

        @Override // p1.j.h
        public void c(j jVar) {
            if (this.f38073d) {
                a();
            }
        }

        @Override // p1.j.h
        public void e(j jVar) {
        }

        @Override // p1.j.h
        public void f(j jVar) {
            jVar.g0(this);
        }

        @Override // p1.j.h
        public void i(j jVar) {
        }

        @Override // p1.j.h
        public void k(j jVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f38070a.getOverlay().remove(this.f38071b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f38071b.getParent() == null) {
                this.f38070a.getOverlay().add(this.f38071b);
            } else {
                G.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            if (z10) {
                this.f38072c.setTag(R$id.save_overlay_view, this.f38071b);
                this.f38070a.getOverlay().add(this.f38071b);
                this.f38073d = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            a();
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f38075a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f38076b;

        /* renamed from: c, reason: collision with root package name */
        public int f38077c;

        /* renamed from: d, reason: collision with root package name */
        public int f38078d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f38079e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f38080f;
    }

    private void u0(w wVar) {
        wVar.f38221a.put("android:visibility:visibility", Integer.valueOf(wVar.f38222b.getVisibility()));
        wVar.f38221a.put("android:visibility:parent", wVar.f38222b.getParent());
        int[] iArr = new int[2];
        wVar.f38222b.getLocationOnScreen(iArr);
        wVar.f38221a.put("android:visibility:screenLocation", iArr);
    }

    public void A0(int i10) {
        if ((i10 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f38063P = i10;
    }

    @Override // p1.j
    public String[] P() {
        return f38062Q;
    }

    @Override // p1.j
    public boolean T(w wVar, w wVar2) {
        if (wVar == null && wVar2 == null) {
            return false;
        }
        if (wVar != null && wVar2 != null && wVar2.f38221a.containsKey("android:visibility:visibility") != wVar.f38221a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarV0 = v0(wVar, wVar2);
        return cVarV0.f38075a && (cVarV0.f38077c == 0 || cVarV0.f38078d == 0);
    }

    @Override // p1.j
    public void k(w wVar) {
        u0(wVar);
    }

    @Override // p1.j
    public void p(w wVar) {
        u0(wVar);
    }

    @Override // p1.j
    public Animator t(ViewGroup viewGroup, w wVar, w wVar2) {
        c cVarV0 = v0(wVar, wVar2);
        if (!cVarV0.f38075a) {
            return null;
        }
        if (cVarV0.f38079e == null && cVarV0.f38080f == null) {
            return null;
        }
        return cVarV0.f38076b ? x0(viewGroup, wVar, cVarV0.f38077c, wVar2, cVarV0.f38078d) : z0(viewGroup, wVar, cVarV0.f38077c, wVar2, cVarV0.f38078d);
    }

    public final c v0(w wVar, w wVar2) {
        c cVar = new c();
        cVar.f38075a = false;
        cVar.f38076b = false;
        if (wVar == null || !wVar.f38221a.containsKey("android:visibility:visibility")) {
            cVar.f38077c = -1;
            cVar.f38079e = null;
        } else {
            cVar.f38077c = ((Integer) wVar.f38221a.get("android:visibility:visibility")).intValue();
            cVar.f38079e = (ViewGroup) wVar.f38221a.get("android:visibility:parent");
        }
        if (wVar2 == null || !wVar2.f38221a.containsKey("android:visibility:visibility")) {
            cVar.f38078d = -1;
            cVar.f38080f = null;
        } else {
            cVar.f38078d = ((Integer) wVar2.f38221a.get("android:visibility:visibility")).intValue();
            cVar.f38080f = (ViewGroup) wVar2.f38221a.get("android:visibility:parent");
        }
        if (wVar != null && wVar2 != null) {
            int i10 = cVar.f38077c;
            int i11 = cVar.f38078d;
            if (i10 != i11 || cVar.f38079e != cVar.f38080f) {
                if (i10 != i11) {
                    if (i10 == 0) {
                        cVar.f38076b = false;
                        cVar.f38075a = true;
                        return cVar;
                    }
                    if (i11 == 0) {
                        cVar.f38076b = true;
                        cVar.f38075a = true;
                        return cVar;
                    }
                } else {
                    if (cVar.f38080f == null) {
                        cVar.f38076b = false;
                        cVar.f38075a = true;
                        return cVar;
                    }
                    if (cVar.f38079e == null) {
                        cVar.f38076b = true;
                        cVar.f38075a = true;
                        return cVar;
                    }
                }
            }
        } else {
            if (wVar == null && cVar.f38078d == 0) {
                cVar.f38076b = true;
                cVar.f38075a = true;
                return cVar;
            }
            if (wVar2 == null && cVar.f38077c == 0) {
                cVar.f38076b = false;
                cVar.f38075a = true;
            }
        }
        return cVar;
    }

    public abstract Animator w0(ViewGroup viewGroup, View view, w wVar, w wVar2);

    public Animator x0(ViewGroup viewGroup, w wVar, int i10, w wVar2, int i11) {
        if ((this.f38063P & 1) != 1 || wVar2 == null) {
            return null;
        }
        if (wVar == null) {
            View view = (View) wVar2.f38222b.getParent();
            if (v0(B(view, false), Q(view, false)).f38075a) {
                return null;
            }
        }
        return w0(viewGroup, wVar2.f38222b, wVar, wVar2);
    }

    public abstract Animator y0(ViewGroup viewGroup, View view, w wVar, w wVar2);

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
    public android.animation.Animator z0(android.view.ViewGroup r11, p1.w r12, int r13, p1.w r14, int r15) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.G.z0(android.view.ViewGroup, p1.w, int, p1.w, int):android.animation.Animator");
    }
}
