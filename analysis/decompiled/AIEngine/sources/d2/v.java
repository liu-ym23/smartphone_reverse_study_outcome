package d2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.aiengine.R;
import d2.i;
import d2.r;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class v extends i {
    public static final String[] F = {"android:visibility:visibility", "android:visibility:parent"};
    public int E = 3;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends AnimatorListenerAdapter implements i.d {

        /* renamed from: a, reason: collision with root package name */
        public final View f8329a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8330b;

        /* renamed from: c, reason: collision with root package name */
        public final ViewGroup f8331c;

        /* renamed from: e, reason: collision with root package name */
        public boolean f8333e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f8334f = false;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f8332d = true;

        public a(int i10, View view) {
            this.f8329a = view;
            this.f8330b = i10;
            this.f8331c = (ViewGroup) view.getParent();
            h(true);
        }

        @Override // d2.i.d
        public final void b() {
            h(false);
            if (this.f8334f) {
                return;
            }
            r.a aVar = r.f8328a;
            this.f8329a.setTransitionVisibility(this.f8330b);
        }

        @Override // d2.i.d
        public final void c(i iVar) {
            iVar.x(this);
        }

        @Override // d2.i.d
        public final void d() {
            h(true);
            if (this.f8334f) {
                return;
            }
            r.a aVar = r.f8328a;
            this.f8329a.setTransitionVisibility(0);
        }

        public final void h(boolean z) {
            ViewGroup viewGroup;
            if (!this.f8332d || this.f8333e == z || (viewGroup = this.f8331c) == null) {
                return;
            }
            this.f8333e = z;
            q.b(viewGroup, z);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f8334f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (!this.f8334f) {
                r.a aVar = r.f8328a;
                this.f8329a.setTransitionVisibility(this.f8330b);
                ViewGroup viewGroup = this.f8331c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            h(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                r.a aVar = r.f8328a;
                this.f8329a.setTransitionVisibility(0);
                ViewGroup viewGroup = this.f8331c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            if (z) {
                return;
            }
            if (!this.f8334f) {
                r.a aVar = r.f8328a;
                this.f8329a.setTransitionVisibility(this.f8330b);
                ViewGroup viewGroup = this.f8331c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            h(false);
        }

        @Override // d2.i.d
        public final void a(i iVar) {
        }

        @Override // d2.i.d
        public final void e(i iVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends AnimatorListenerAdapter implements i.d {

        /* renamed from: a, reason: collision with root package name */
        public final ViewGroup f8335a;

        /* renamed from: b, reason: collision with root package name */
        public final View f8336b;

        /* renamed from: c, reason: collision with root package name */
        public final View f8337c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f8338d = true;

        public b(ViewGroup viewGroup, View view, View view2) {
            this.f8335a = viewGroup;
            this.f8336b = view;
            this.f8337c = view2;
        }

        @Override // d2.i.d
        public final void c(i iVar) {
            iVar.x(this);
        }

        @Override // d2.i.d
        public final void e(i iVar) {
            if (this.f8338d) {
                h();
            }
        }

        public final void h() {
            this.f8337c.setTag(R.id.save_overlay_view, null);
            this.f8335a.getOverlay().remove(this.f8336b);
            this.f8338d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator animator) {
            this.f8335a.getOverlay().remove(this.f8336b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator animator) {
            View view = this.f8336b;
            if (view.getParent() == null) {
                this.f8335a.getOverlay().add(view);
            } else {
                v.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                View view = this.f8337c;
                View view2 = this.f8336b;
                view.setTag(R.id.save_overlay_view, view2);
                this.f8335a.getOverlay().add(view2);
                this.f8338d = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            if (z) {
                return;
            }
            h();
        }

        @Override // d2.i.d
        public final void b() {
        }

        @Override // d2.i.d
        public final void d() {
        }

        @Override // d2.i.d
        public final void a(i iVar) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f8340a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8341b;

        /* renamed from: c, reason: collision with root package name */
        public int f8342c;

        /* renamed from: d, reason: collision with root package name */
        public int f8343d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f8344e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f8345f;
    }

    public static void J(p pVar) {
        View view = pVar.f8326b;
        int visibility = view.getVisibility();
        HashMap map = pVar.f8325a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d2.v.c L(d2.p r8, d2.p r9) {
        /*
            d2.v$c r0 = new d2.v$c
            r0.<init>()
            r1 = 0
            r0.f8340a = r1
            r0.f8341b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f8325a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f8342c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f8344e = r6
            goto L33
        L2f:
            r0.f8342c = r3
            r0.f8344e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f8325a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f8343d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f8345f = r2
            goto L56
        L52:
            r0.f8343d = r3
            r0.f8345f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f8342c
            int r9 = r0.f8343d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f8344e
            android.view.ViewGroup r4 = r0.f8345f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f8341b = r1
            r0.f8340a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.f8341b = r2
            r0.f8340a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f8345f
            if (r8 != 0) goto L81
            r0.f8341b = r1
            r0.f8340a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.f8344e
            if (r8 != 0) goto L9f
            r0.f8341b = r2
            r0.f8340a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f8343d
            if (r8 != 0) goto L95
            r0.f8341b = r2
            r0.f8340a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f8342c
            if (r8 != 0) goto L9f
            r0.f8341b = r1
            r0.f8340a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.v.L(d2.p, d2.p):d2.v$c");
    }

    @Override // d2.i
    public final void e(p pVar) {
        J(pVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (L(o(r3, false), s(r3, false)).f8340a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f7  */
    @Override // d2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator l(android.view.ViewGroup r24, d2.p r25, d2.p r26) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.v.l(android.view.ViewGroup, d2.p, d2.p):android.animation.Animator");
    }

    @Override // d2.i
    public final String[] r() {
        return F;
    }

    @Override // d2.i
    public final boolean t(p pVar, p pVar2) {
        if (pVar == null && pVar2 == null) {
            return false;
        }
        if (pVar != null && pVar2 != null && pVar2.f8325a.containsKey("android:visibility:visibility") != pVar.f8325a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarL = L(pVar, pVar2);
        if (cVarL.f8340a) {
            return cVarL.f8342c == 0 || cVarL.f8343d == 0;
        }
        return false;
    }
}
