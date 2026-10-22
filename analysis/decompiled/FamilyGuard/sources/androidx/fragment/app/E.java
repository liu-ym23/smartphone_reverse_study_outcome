package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.M;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.X;

/* loaded from: classes.dex */
class E {

    /* renamed from: a, reason: collision with root package name */
    private final r f10411a;

    /* renamed from: b, reason: collision with root package name */
    private final F f10412b;

    /* renamed from: c, reason: collision with root package name */
    private final ComponentCallbacksC0511f f10413c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10414d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f10415e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f10416a;

        a(View view) {
            this.f10416a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f10416a.removeOnAttachStateChangeListener(this);
            androidx.core.view.H.g0(this.f10416a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10418a;

        static {
            int[] iArr = new int[AbstractC0533m.b.values().length];
            f10418a = iArr;
            try {
                iArr[AbstractC0533m.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10418a[AbstractC0533m.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10418a[AbstractC0533m.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10418a[AbstractC0533m.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    E(r rVar, F f5, ComponentCallbacksC0511f componentCallbacksC0511f) {
        this.f10411a = rVar;
        this.f10412b = f5;
        this.f10413c = componentCallbacksC0511f;
    }

    private boolean l(View view) {
        if (view == this.f10413c.f10613I) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f10413c.f10613I) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f10413c.q1(bundle);
        this.f10411a.j(this.f10413c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f10413c.f10613I != null) {
            s();
        }
        if (this.f10413c.f10632c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f10413c.f10632c);
        }
        if (this.f10413c.f10634d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f10413c.f10634d);
        }
        if (!this.f10413c.f10615K) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f10413c.f10615K);
        }
        return bundle;
    }

    void a() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f10413c);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        componentCallbacksC0511f.W0(componentCallbacksC0511f.f10630b);
        r rVar = this.f10411a;
        ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10413c;
        rVar.a(componentCallbacksC0511f2, componentCallbacksC0511f2.f10630b, false);
    }

    void b() {
        int iJ = this.f10412b.j(this.f10413c);
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        componentCallbacksC0511f.f10612H.addView(componentCallbacksC0511f.f10613I, iJ);
    }

    void c() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f10413c);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        ComponentCallbacksC0511f componentCallbacksC0511f2 = componentCallbacksC0511f.f10639h;
        E eN = null;
        if (componentCallbacksC0511f2 != null) {
            E eN2 = this.f10412b.n(componentCallbacksC0511f2.f10637f);
            if (eN2 == null) {
                throw new IllegalStateException("Fragment " + this.f10413c + " declared target fragment " + this.f10413c.f10639h + " that does not belong to this FragmentManager!");
            }
            ComponentCallbacksC0511f componentCallbacksC0511f3 = this.f10413c;
            componentCallbacksC0511f3.f10640i = componentCallbacksC0511f3.f10639h.f10637f;
            componentCallbacksC0511f3.f10639h = null;
            eN = eN2;
        } else {
            String str = componentCallbacksC0511f.f10640i;
            if (str != null && (eN = this.f10412b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f10413c + " declared target fragment " + this.f10413c.f10640i + " that does not belong to this FragmentManager!");
            }
        }
        if (eN != null) {
            eN.m();
        }
        ComponentCallbacksC0511f componentCallbacksC0511f4 = this.f10413c;
        componentCallbacksC0511f4.f10652u = componentCallbacksC0511f4.f10651t.s0();
        ComponentCallbacksC0511f componentCallbacksC0511f5 = this.f10413c;
        componentCallbacksC0511f5.f10654w = componentCallbacksC0511f5.f10651t.v0();
        this.f10411a.g(this.f10413c, false);
        this.f10413c.X0();
        this.f10411a.b(this.f10413c, false);
    }

    int d() {
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        if (componentCallbacksC0511f.f10651t == null) {
            return componentCallbacksC0511f.f10628a;
        }
        int iMin = this.f10415e;
        int i5 = b.f10418a[componentCallbacksC0511f.f10622U.ordinal()];
        if (i5 != 1) {
            iMin = i5 != 2 ? i5 != 3 ? i5 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10413c;
        if (componentCallbacksC0511f2.f10646o) {
            if (componentCallbacksC0511f2.f10647p) {
                iMin = Math.max(this.f10415e, 2);
                View view = this.f10413c.f10613I;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f10415e < 4 ? Math.min(iMin, componentCallbacksC0511f2.f10628a) : Math.min(iMin, 1);
            }
        }
        if (!this.f10413c.f10643l) {
            iMin = Math.min(iMin, 1);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f3 = this.f10413c;
        ViewGroup viewGroup = componentCallbacksC0511f3.f10612H;
        M.e.b bVarL = viewGroup != null ? M.n(viewGroup, componentCallbacksC0511f3.K()).l(this) : null;
        if (bVarL == M.e.b.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (bVarL == M.e.b.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            ComponentCallbacksC0511f componentCallbacksC0511f4 = this.f10413c;
            if (componentCallbacksC0511f4.f10644m) {
                iMin = componentCallbacksC0511f4.i0() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        ComponentCallbacksC0511f componentCallbacksC0511f5 = this.f10413c;
        if (componentCallbacksC0511f5.f10614J && componentCallbacksC0511f5.f10628a < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (x.F0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f10413c);
        }
        return iMin;
    }

    void e() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f10413c);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        if (componentCallbacksC0511f.f10620S) {
            componentCallbacksC0511f.C1(componentCallbacksC0511f.f10630b);
            this.f10413c.f10628a = 1;
            return;
        }
        this.f10411a.h(componentCallbacksC0511f, componentCallbacksC0511f.f10630b, false);
        ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10413c;
        componentCallbacksC0511f2.a1(componentCallbacksC0511f2.f10630b);
        r rVar = this.f10411a;
        ComponentCallbacksC0511f componentCallbacksC0511f3 = this.f10413c;
        rVar.c(componentCallbacksC0511f3, componentCallbacksC0511f3.f10630b, false);
    }

    void f() throws Resources.NotFoundException {
        String resourceName;
        if (this.f10413c.f10646o) {
            return;
        }
        if (x.F0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f10413c);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        LayoutInflater layoutInflaterG1 = componentCallbacksC0511f.g1(componentCallbacksC0511f.f10630b);
        ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10413c;
        ViewGroup viewGroup = componentCallbacksC0511f2.f10612H;
        if (viewGroup == null) {
            int i5 = componentCallbacksC0511f2.f10656y;
            if (i5 == 0) {
                viewGroup = null;
            } else {
                if (i5 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f10413c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) componentCallbacksC0511f2.f10651t.o0().c(this.f10413c.f10656y);
                if (viewGroup == null) {
                    ComponentCallbacksC0511f componentCallbacksC0511f3 = this.f10413c;
                    if (!componentCallbacksC0511f3.f10648q) {
                        try {
                            resourceName = componentCallbacksC0511f3.Q().getResourceName(this.f10413c.f10656y);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f10413c.f10656y) + " (" + resourceName + ") for fragment " + this.f10413c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    T.c.k(this.f10413c, viewGroup);
                }
            }
        }
        ComponentCallbacksC0511f componentCallbacksC0511f4 = this.f10413c;
        componentCallbacksC0511f4.f10612H = viewGroup;
        componentCallbacksC0511f4.c1(layoutInflaterG1, viewGroup, componentCallbacksC0511f4.f10630b);
        View view = this.f10413c.f10613I;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            ComponentCallbacksC0511f componentCallbacksC0511f5 = this.f10413c;
            componentCallbacksC0511f5.f10613I.setTag(S.b.f5198a, componentCallbacksC0511f5);
            if (viewGroup != null) {
                b();
            }
            ComponentCallbacksC0511f componentCallbacksC0511f6 = this.f10413c;
            if (componentCallbacksC0511f6.f10605A) {
                componentCallbacksC0511f6.f10613I.setVisibility(8);
            }
            if (androidx.core.view.H.P(this.f10413c.f10613I)) {
                androidx.core.view.H.g0(this.f10413c.f10613I);
            } else {
                View view2 = this.f10413c.f10613I;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f10413c.t1();
            r rVar = this.f10411a;
            ComponentCallbacksC0511f componentCallbacksC0511f7 = this.f10413c;
            rVar.m(componentCallbacksC0511f7, componentCallbacksC0511f7.f10613I, componentCallbacksC0511f7.f10630b, false);
            int visibility = this.f10413c.f10613I.getVisibility();
            this.f10413c.M1(this.f10413c.f10613I.getAlpha());
            ComponentCallbacksC0511f componentCallbacksC0511f8 = this.f10413c;
            if (componentCallbacksC0511f8.f10612H != null && visibility == 0) {
                View viewFindFocus = componentCallbacksC0511f8.f10613I.findFocus();
                if (viewFindFocus != null) {
                    this.f10413c.H1(viewFindFocus);
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f10413c);
                    }
                }
                this.f10413c.f10613I.setAlpha(0.0f);
            }
        }
        this.f10413c.f10628a = 2;
    }

    void g() {
        ComponentCallbacksC0511f componentCallbacksC0511fF;
        if (x.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f10413c);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        boolean zIsChangingConfigurations = true;
        boolean z5 = componentCallbacksC0511f.f10644m && !componentCallbacksC0511f.i0();
        if (z5) {
            ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10413c;
            if (!componentCallbacksC0511f2.f10645n) {
                this.f10412b.B(componentCallbacksC0511f2.f10637f, null);
            }
        }
        if (!z5 && !this.f10412b.p().W(this.f10413c)) {
            String str = this.f10413c.f10640i;
            if (str != null && (componentCallbacksC0511fF = this.f10412b.f(str)) != null && componentCallbacksC0511fF.f10607C) {
                this.f10413c.f10639h = componentCallbacksC0511fF;
            }
            this.f10413c.f10628a = 0;
            return;
        }
        p<?> pVar = this.f10413c.f10652u;
        if (pVar instanceof X) {
            zIsChangingConfigurations = this.f10412b.p().T();
        } else if (pVar.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) pVar.f()).isChangingConfigurations();
        }
        if ((z5 && !this.f10413c.f10645n) || zIsChangingConfigurations) {
            this.f10412b.p().L(this.f10413c);
        }
        this.f10413c.d1();
        this.f10411a.d(this.f10413c, false);
        for (E e6 : this.f10412b.k()) {
            if (e6 != null) {
                ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
                if (this.f10413c.f10637f.equals(componentCallbacksC0511fK.f10640i)) {
                    componentCallbacksC0511fK.f10639h = this.f10413c;
                    componentCallbacksC0511fK.f10640i = null;
                }
            }
        }
        ComponentCallbacksC0511f componentCallbacksC0511f3 = this.f10413c;
        String str2 = componentCallbacksC0511f3.f10640i;
        if (str2 != null) {
            componentCallbacksC0511f3.f10639h = this.f10412b.f(str2);
        }
        this.f10412b.s(this);
    }

    void h() {
        View view;
        if (x.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f10413c);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        ViewGroup viewGroup = componentCallbacksC0511f.f10612H;
        if (viewGroup != null && (view = componentCallbacksC0511f.f10613I) != null) {
            viewGroup.removeView(view);
        }
        this.f10413c.e1();
        this.f10411a.n(this.f10413c, false);
        ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10413c;
        componentCallbacksC0511f2.f10612H = null;
        componentCallbacksC0511f2.f10613I = null;
        componentCallbacksC0511f2.f10624W = null;
        componentCallbacksC0511f2.f10625X.n(null);
        this.f10413c.f10647p = false;
    }

    void i() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f10413c);
        }
        this.f10413c.f1();
        this.f10411a.e(this.f10413c, false);
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        componentCallbacksC0511f.f10628a = -1;
        componentCallbacksC0511f.f10652u = null;
        componentCallbacksC0511f.f10654w = null;
        componentCallbacksC0511f.f10651t = null;
        if ((!componentCallbacksC0511f.f10644m || componentCallbacksC0511f.i0()) && !this.f10412b.p().W(this.f10413c)) {
            return;
        }
        if (x.F0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f10413c);
        }
        this.f10413c.e0();
    }

    void j() {
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        if (componentCallbacksC0511f.f10646o && componentCallbacksC0511f.f10647p && !componentCallbacksC0511f.f10649r) {
            if (x.F0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f10413c);
            }
            ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10413c;
            componentCallbacksC0511f2.c1(componentCallbacksC0511f2.g1(componentCallbacksC0511f2.f10630b), null, this.f10413c.f10630b);
            View view = this.f10413c.f10613I;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                ComponentCallbacksC0511f componentCallbacksC0511f3 = this.f10413c;
                componentCallbacksC0511f3.f10613I.setTag(S.b.f5198a, componentCallbacksC0511f3);
                ComponentCallbacksC0511f componentCallbacksC0511f4 = this.f10413c;
                if (componentCallbacksC0511f4.f10605A) {
                    componentCallbacksC0511f4.f10613I.setVisibility(8);
                }
                this.f10413c.t1();
                r rVar = this.f10411a;
                ComponentCallbacksC0511f componentCallbacksC0511f5 = this.f10413c;
                rVar.m(componentCallbacksC0511f5, componentCallbacksC0511f5.f10613I, componentCallbacksC0511f5.f10630b, false);
                this.f10413c.f10628a = 2;
            }
        }
    }

    ComponentCallbacksC0511f k() {
        return this.f10413c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f10414d) {
            if (x.F0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f10414d = true;
            boolean z5 = false;
            while (true) {
                int iD = d();
                ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
                int i5 = componentCallbacksC0511f.f10628a;
                if (iD == i5) {
                    if (!z5 && i5 == -1 && componentCallbacksC0511f.f10644m && !componentCallbacksC0511f.i0() && !this.f10413c.f10645n) {
                        if (x.F0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f10413c);
                        }
                        this.f10412b.p().L(this.f10413c);
                        this.f10412b.s(this);
                        if (x.F0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f10413c);
                        }
                        this.f10413c.e0();
                    }
                    ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10413c;
                    if (componentCallbacksC0511f2.f10618Q) {
                        if (componentCallbacksC0511f2.f10613I != null && (viewGroup = componentCallbacksC0511f2.f10612H) != null) {
                            M mN = M.n(viewGroup, componentCallbacksC0511f2.K());
                            if (this.f10413c.f10605A) {
                                mN.c(this);
                            } else {
                                mN.e(this);
                            }
                        }
                        ComponentCallbacksC0511f componentCallbacksC0511f3 = this.f10413c;
                        x xVar = componentCallbacksC0511f3.f10651t;
                        if (xVar != null) {
                            xVar.D0(componentCallbacksC0511f3);
                        }
                        ComponentCallbacksC0511f componentCallbacksC0511f4 = this.f10413c;
                        componentCallbacksC0511f4.f10618Q = false;
                        componentCallbacksC0511f4.F0(componentCallbacksC0511f4.f10605A);
                        this.f10413c.f10653v.G();
                    }
                    this.f10414d = false;
                    return;
                }
                if (iD <= i5) {
                    switch (i5 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (componentCallbacksC0511f.f10645n && this.f10412b.q(componentCallbacksC0511f.f10637f) == null) {
                                r();
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f10413c.f10628a = 1;
                            break;
                        case 2:
                            componentCallbacksC0511f.f10647p = false;
                            componentCallbacksC0511f.f10628a = 2;
                            break;
                        case 3:
                            if (x.F0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f10413c);
                            }
                            ComponentCallbacksC0511f componentCallbacksC0511f5 = this.f10413c;
                            if (componentCallbacksC0511f5.f10645n) {
                                r();
                            } else if (componentCallbacksC0511f5.f10613I != null && componentCallbacksC0511f5.f10632c == null) {
                                s();
                            }
                            ComponentCallbacksC0511f componentCallbacksC0511f6 = this.f10413c;
                            if (componentCallbacksC0511f6.f10613I != null && (viewGroup2 = componentCallbacksC0511f6.f10612H) != null) {
                                M.n(viewGroup2, componentCallbacksC0511f6.K()).d(this);
                            }
                            this.f10413c.f10628a = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            componentCallbacksC0511f.f10628a = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i5 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (componentCallbacksC0511f.f10613I != null && (viewGroup3 = componentCallbacksC0511f.f10612H) != null) {
                                M.n(viewGroup3, componentCallbacksC0511f.K()).b(M.e.c.d(this.f10413c.f10613I.getVisibility()), this);
                            }
                            this.f10413c.f10628a = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            componentCallbacksC0511f.f10628a = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z5 = true;
            }
        } catch (Throwable th) {
            this.f10414d = false;
            throw th;
        }
    }

    void n() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f10413c);
        }
        this.f10413c.l1();
        this.f10411a.f(this.f10413c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.f10413c.f10630b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        componentCallbacksC0511f.f10632c = componentCallbacksC0511f.f10630b.getSparseParcelableArray("android:view_state");
        ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10413c;
        componentCallbacksC0511f2.f10634d = componentCallbacksC0511f2.f10630b.getBundle("android:view_registry_state");
        ComponentCallbacksC0511f componentCallbacksC0511f3 = this.f10413c;
        componentCallbacksC0511f3.f10640i = componentCallbacksC0511f3.f10630b.getString("android:target_state");
        ComponentCallbacksC0511f componentCallbacksC0511f4 = this.f10413c;
        if (componentCallbacksC0511f4.f10640i != null) {
            componentCallbacksC0511f4.f10641j = componentCallbacksC0511f4.f10630b.getInt("android:target_req_state", 0);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f5 = this.f10413c;
        Boolean bool = componentCallbacksC0511f5.f10636e;
        if (bool != null) {
            componentCallbacksC0511f5.f10615K = bool.booleanValue();
            this.f10413c.f10636e = null;
        } else {
            componentCallbacksC0511f5.f10615K = componentCallbacksC0511f5.f10630b.getBoolean("android:user_visible_hint", true);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f6 = this.f10413c;
        if (componentCallbacksC0511f6.f10615K) {
            return;
        }
        componentCallbacksC0511f6.f10614J = true;
    }

    void p() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f10413c);
        }
        View viewD = this.f10413c.D();
        if (viewD != null && l(viewD)) {
            boolean zRequestFocus = viewD.requestFocus();
            if (x.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(viewD);
                sb.append(" ");
                sb.append(zRequestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f10413c);
                sb.append(" resulting in focused view ");
                sb.append(this.f10413c.f10613I.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f10413c.H1(null);
        this.f10413c.p1();
        this.f10411a.i(this.f10413c, false);
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        componentCallbacksC0511f.f10630b = null;
        componentCallbacksC0511f.f10632c = null;
        componentCallbacksC0511f.f10634d = null;
    }

    void r() {
        D d6 = new D(this.f10413c);
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10413c;
        if (componentCallbacksC0511f.f10628a <= -1 || d6.f10410m != null) {
            d6.f10410m = componentCallbacksC0511f.f10630b;
        } else {
            Bundle bundleQ = q();
            d6.f10410m = bundleQ;
            if (this.f10413c.f10640i != null) {
                if (bundleQ == null) {
                    d6.f10410m = new Bundle();
                }
                d6.f10410m.putString("android:target_state", this.f10413c.f10640i);
                int i5 = this.f10413c.f10641j;
                if (i5 != 0) {
                    d6.f10410m.putInt("android:target_req_state", i5);
                }
            }
        }
        this.f10412b.B(this.f10413c.f10637f, d6);
    }

    void s() {
        if (this.f10413c.f10613I == null) {
            return;
        }
        if (x.F0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f10413c + " with view " + this.f10413c.f10613I);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f10413c.f10613I.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f10413c.f10632c = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f10413c.f10624W.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f10413c.f10634d = bundle;
    }

    void t(int i5) {
        this.f10415e = i5;
    }

    void u() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f10413c);
        }
        this.f10413c.r1();
        this.f10411a.k(this.f10413c, false);
    }

    void v() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f10413c);
        }
        this.f10413c.s1();
        this.f10411a.l(this.f10413c, false);
    }

    E(r rVar, F f5, ClassLoader classLoader, C0520o c0520o, D d6) {
        this.f10411a = rVar;
        this.f10412b = f5;
        ComponentCallbacksC0511f componentCallbacksC0511fA = d6.a(c0520o, classLoader);
        this.f10413c = componentCallbacksC0511fA;
        if (x.F0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + componentCallbacksC0511fA);
        }
    }

    E(r rVar, F f5, ComponentCallbacksC0511f componentCallbacksC0511f, D d6) {
        this.f10411a = rVar;
        this.f10412b = f5;
        this.f10413c = componentCallbacksC0511f;
        componentCallbacksC0511f.f10632c = null;
        componentCallbacksC0511f.f10634d = null;
        componentCallbacksC0511f.f10650s = 0;
        componentCallbacksC0511f.f10647p = false;
        componentCallbacksC0511f.f10643l = false;
        ComponentCallbacksC0511f componentCallbacksC0511f2 = componentCallbacksC0511f.f10639h;
        componentCallbacksC0511f.f10640i = componentCallbacksC0511f2 != null ? componentCallbacksC0511f2.f10637f : null;
        componentCallbacksC0511f.f10639h = null;
        Bundle bundle = d6.f10410m;
        if (bundle != null) {
            componentCallbacksC0511f.f10630b = bundle;
        } else {
            componentCallbacksC0511f.f10630b = new Bundle();
        }
    }
}
