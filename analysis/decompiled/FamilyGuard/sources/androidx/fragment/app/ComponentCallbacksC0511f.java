package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.C0466k;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.C0541v;
import androidx.lifecycle.InterfaceC0531k;
import androidx.lifecycle.InterfaceC0537q;
import androidx.lifecycle.InterfaceC0539t;
import androidx.lifecycle.P;
import androidx.lifecycle.U;
import androidx.lifecycle.W;
import androidx.lifecycle.X;
import androidx.lifecycle.Y;
import androidx.lifecycle.Z;
import c0.C0574d;
import c0.C0575e;
import c0.C0577g;
import c0.InterfaceC0576f;
import d.AbstractC0642c;
import d.AbstractC0643d;
import d.InterfaceC0641b;
import d.InterfaceC0644e;
import e.AbstractC0674a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import o.InterfaceC0887a;

/* renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ComponentCallbacksC0511f implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0539t, X, InterfaceC0531k, InterfaceC0576f {

    /* renamed from: e0, reason: collision with root package name */
    static final Object f10604e0 = new Object();

    /* renamed from: A, reason: collision with root package name */
    boolean f10605A;

    /* renamed from: B, reason: collision with root package name */
    boolean f10606B;

    /* renamed from: C, reason: collision with root package name */
    boolean f10607C;

    /* renamed from: D, reason: collision with root package name */
    boolean f10608D;

    /* renamed from: E, reason: collision with root package name */
    boolean f10609E;

    /* renamed from: G, reason: collision with root package name */
    private boolean f10611G;

    /* renamed from: H, reason: collision with root package name */
    ViewGroup f10612H;

    /* renamed from: I, reason: collision with root package name */
    View f10613I;

    /* renamed from: J, reason: collision with root package name */
    boolean f10614J;

    /* renamed from: L, reason: collision with root package name */
    j f10616L;

    /* renamed from: Q, reason: collision with root package name */
    boolean f10618Q;

    /* renamed from: R, reason: collision with root package name */
    LayoutInflater f10619R;

    /* renamed from: S, reason: collision with root package name */
    boolean f10620S;

    /* renamed from: T, reason: collision with root package name */
    public String f10621T;

    /* renamed from: V, reason: collision with root package name */
    C0541v f10623V;

    /* renamed from: W, reason: collision with root package name */
    K f10624W;

    /* renamed from: Y, reason: collision with root package name */
    U.c f10626Y;

    /* renamed from: Z, reason: collision with root package name */
    C0575e f10627Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f10629a0;

    /* renamed from: b, reason: collision with root package name */
    Bundle f10630b;

    /* renamed from: c, reason: collision with root package name */
    SparseArray<Parcelable> f10632c;

    /* renamed from: d, reason: collision with root package name */
    Bundle f10634d;

    /* renamed from: e, reason: collision with root package name */
    Boolean f10636e;

    /* renamed from: g, reason: collision with root package name */
    Bundle f10638g;

    /* renamed from: h, reason: collision with root package name */
    ComponentCallbacksC0511f f10639h;

    /* renamed from: j, reason: collision with root package name */
    int f10641j;

    /* renamed from: l, reason: collision with root package name */
    boolean f10643l;

    /* renamed from: m, reason: collision with root package name */
    boolean f10644m;

    /* renamed from: n, reason: collision with root package name */
    boolean f10645n;

    /* renamed from: o, reason: collision with root package name */
    boolean f10646o;

    /* renamed from: p, reason: collision with root package name */
    boolean f10647p;

    /* renamed from: q, reason: collision with root package name */
    boolean f10648q;

    /* renamed from: r, reason: collision with root package name */
    boolean f10649r;

    /* renamed from: s, reason: collision with root package name */
    int f10650s;

    /* renamed from: t, reason: collision with root package name */
    x f10651t;

    /* renamed from: u, reason: collision with root package name */
    p<?> f10652u;

    /* renamed from: w, reason: collision with root package name */
    ComponentCallbacksC0511f f10654w;

    /* renamed from: x, reason: collision with root package name */
    int f10655x;

    /* renamed from: y, reason: collision with root package name */
    int f10656y;

    /* renamed from: z, reason: collision with root package name */
    String f10657z;

    /* renamed from: a, reason: collision with root package name */
    int f10628a = -1;

    /* renamed from: f, reason: collision with root package name */
    String f10637f = UUID.randomUUID().toString();

    /* renamed from: i, reason: collision with root package name */
    String f10640i = null;

    /* renamed from: k, reason: collision with root package name */
    private Boolean f10642k = null;

    /* renamed from: v, reason: collision with root package name */
    x f10653v = new y();

    /* renamed from: F, reason: collision with root package name */
    boolean f10610F = true;

    /* renamed from: K, reason: collision with root package name */
    boolean f10615K = true;

    /* renamed from: M, reason: collision with root package name */
    Runnable f10617M = new b();

    /* renamed from: U, reason: collision with root package name */
    AbstractC0533m.b f10622U = AbstractC0533m.b.RESUMED;

    /* renamed from: X, reason: collision with root package name */
    androidx.lifecycle.B<InterfaceC0539t> f10625X = new androidx.lifecycle.B<>();

    /* renamed from: b0, reason: collision with root package name */
    private final AtomicInteger f10631b0 = new AtomicInteger();

    /* renamed from: c0, reason: collision with root package name */
    private final ArrayList<m> f10633c0 = new ArrayList<>();

    /* renamed from: d0, reason: collision with root package name */
    private final m f10635d0 = new c();

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* renamed from: androidx.fragment.app.f$a */
    class a<I> extends AbstractC0642c<I> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f10658a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractC0674a f10659b;

        a(AtomicReference atomicReference, AbstractC0674a abstractC0674a) {
            this.f10658a = atomicReference;
            this.f10659b = abstractC0674a;
        }

        @Override // d.AbstractC0642c
        public void b(I i5, androidx.core.app.c cVar) {
            AbstractC0642c abstractC0642c = (AbstractC0642c) this.f10658a.get();
            if (abstractC0642c == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            abstractC0642c.b(i5, cVar);
        }

        @Override // d.AbstractC0642c
        public void c() {
            AbstractC0642c abstractC0642c = (AbstractC0642c) this.f10658a.getAndSet(null);
            if (abstractC0642c != null) {
                abstractC0642c.c();
            }
        }
    }

    /* renamed from: androidx.fragment.app.f$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentCallbacksC0511f.this.T1();
        }
    }

    /* renamed from: androidx.fragment.app.f$c */
    class c extends m {
        c() {
            super(null);
        }

        @Override // androidx.fragment.app.ComponentCallbacksC0511f.m
        void a() {
            ComponentCallbacksC0511f.this.f10627Z.c();
            androidx.lifecycle.M.c(ComponentCallbacksC0511f.this);
        }
    }

    /* renamed from: androidx.fragment.app.f$d */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentCallbacksC0511f.this.k(false);
        }
    }

    /* renamed from: androidx.fragment.app.f$e */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ M f10664a;

        e(M m5) {
            this.f10664a = m5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10664a.g();
        }
    }

    /* renamed from: androidx.fragment.app.f$f, reason: collision with other inner class name */
    class C0134f extends AbstractC0518m {
        C0134f() {
        }

        @Override // androidx.fragment.app.AbstractC0518m
        public View c(int i5) {
            View view = ComponentCallbacksC0511f.this.f10613I;
            if (view != null) {
                return view.findViewById(i5);
            }
            throw new IllegalStateException("Fragment " + ComponentCallbacksC0511f.this + " does not have a view");
        }

        @Override // androidx.fragment.app.AbstractC0518m
        public boolean d() {
            return ComponentCallbacksC0511f.this.f10613I != null;
        }
    }

    /* renamed from: androidx.fragment.app.f$g */
    class g implements InterfaceC0537q {
        g() {
        }

        @Override // androidx.lifecycle.InterfaceC0537q
        public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
            View view;
            if (aVar != AbstractC0533m.a.ON_STOP || (view = ComponentCallbacksC0511f.this.f10613I) == null) {
                return;
            }
            k.a(view);
        }
    }

    /* renamed from: androidx.fragment.app.f$h */
    class h implements InterfaceC0887a<Void, AbstractC0643d> {
        h() {
        }

        @Override // o.InterfaceC0887a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0643d apply(Void r22) {
            ComponentCallbacksC0511f componentCallbacksC0511f = ComponentCallbacksC0511f.this;
            Object obj = componentCallbacksC0511f.f10652u;
            return obj instanceof InterfaceC0644e ? ((InterfaceC0644e) obj).getActivityResultRegistry() : componentCallbacksC0511f.y1().getActivityResultRegistry();
        }
    }

    /* renamed from: androidx.fragment.app.f$i */
    class i extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0887a f10669a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f10670b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractC0674a f10671c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC0641b f10672d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC0887a interfaceC0887a, AtomicReference atomicReference, AbstractC0674a abstractC0674a, InterfaceC0641b interfaceC0641b) {
            super(null);
            this.f10669a = interfaceC0887a;
            this.f10670b = atomicReference;
            this.f10671c = abstractC0674a;
            this.f10672d = interfaceC0641b;
        }

        @Override // androidx.fragment.app.ComponentCallbacksC0511f.m
        void a() {
            String strP = ComponentCallbacksC0511f.this.p();
            this.f10670b.set(((AbstractC0643d) this.f10669a.apply(null)).i(strP, ComponentCallbacksC0511f.this, this.f10671c, this.f10672d));
        }
    }

    /* renamed from: androidx.fragment.app.f$j */
    static class j {

        /* renamed from: a, reason: collision with root package name */
        View f10674a;

        /* renamed from: b, reason: collision with root package name */
        boolean f10675b;

        /* renamed from: c, reason: collision with root package name */
        int f10676c;

        /* renamed from: d, reason: collision with root package name */
        int f10677d;

        /* renamed from: e, reason: collision with root package name */
        int f10678e;

        /* renamed from: f, reason: collision with root package name */
        int f10679f;

        /* renamed from: g, reason: collision with root package name */
        int f10680g;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<String> f10681h;

        /* renamed from: i, reason: collision with root package name */
        ArrayList<String> f10682i;

        /* renamed from: j, reason: collision with root package name */
        Object f10683j = null;

        /* renamed from: k, reason: collision with root package name */
        Object f10684k;

        /* renamed from: l, reason: collision with root package name */
        Object f10685l;

        /* renamed from: m, reason: collision with root package name */
        Object f10686m;

        /* renamed from: n, reason: collision with root package name */
        Object f10687n;

        /* renamed from: o, reason: collision with root package name */
        Object f10688o;

        /* renamed from: p, reason: collision with root package name */
        Boolean f10689p;

        /* renamed from: q, reason: collision with root package name */
        Boolean f10690q;

        /* renamed from: r, reason: collision with root package name */
        float f10691r;

        /* renamed from: s, reason: collision with root package name */
        View f10692s;

        /* renamed from: t, reason: collision with root package name */
        boolean f10693t;

        j() {
            Object obj = ComponentCallbacksC0511f.f10604e0;
            this.f10684k = obj;
            this.f10685l = null;
            this.f10686m = obj;
            this.f10687n = null;
            this.f10688o = obj;
            this.f10691r = 1.0f;
            this.f10692s = null;
        }
    }

    /* renamed from: androidx.fragment.app.f$k */
    static class k {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* renamed from: androidx.fragment.app.f$l */
    public static class l extends RuntimeException {
        public l(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* renamed from: androidx.fragment.app.f$m */
    private static abstract class m {
        private m() {
        }

        abstract void a();

        /* synthetic */ m(b bVar) {
            this();
        }
    }

    public ComponentCallbacksC0511f() {
        d0();
    }

    private void D1() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.f10613I != null) {
            E1(this.f10630b);
        }
        this.f10630b = null;
    }

    private int H() {
        AbstractC0533m.b bVar = this.f10622U;
        return (bVar == AbstractC0533m.b.INITIALIZED || this.f10654w == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.f10654w.H());
    }

    private ComponentCallbacksC0511f Z(boolean z5) {
        String str;
        if (z5) {
            T.c.h(this);
        }
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10639h;
        if (componentCallbacksC0511f != null) {
            return componentCallbacksC0511f;
        }
        x xVar = this.f10651t;
        if (xVar == null || (str = this.f10640i) == null) {
            return null;
        }
        return xVar.d0(str);
    }

    private void d0() {
        this.f10623V = new C0541v(this);
        this.f10627Z = C0575e.a(this);
        this.f10626Y = null;
        if (this.f10633c0.contains(this.f10635d0)) {
            return;
        }
        w1(this.f10635d0);
    }

    @Deprecated
    public static ComponentCallbacksC0511f f0(Context context, String str, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            ComponentCallbacksC0511f componentCallbacksC0511fNewInstance = C0520o.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return componentCallbacksC0511fNewInstance;
            }
            bundle.setClassLoader(componentCallbacksC0511fNewInstance.getClass().getClassLoader());
            componentCallbacksC0511fNewInstance.G1(bundle);
            return componentCallbacksC0511fNewInstance;
        } catch (IllegalAccessException e6) {
            throw new l("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e6);
        } catch (InstantiationException e7) {
            throw new l("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e7);
        } catch (NoSuchMethodException e8) {
            throw new l("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e8);
        } catch (InvocationTargetException e9) {
            throw new l("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e9);
        }
    }

    private j n() {
        if (this.f10616L == null) {
            this.f10616L = new j();
        }
        return this.f10616L;
    }

    private <I, O> AbstractC0642c<I> u1(AbstractC0674a<I, O> abstractC0674a, InterfaceC0887a<Void, AbstractC0643d> interfaceC0887a, InterfaceC0641b<O> interfaceC0641b) {
        if (this.f10628a <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            w1(new i(interfaceC0887a, atomicReference, abstractC0674a, interfaceC0641b));
            return new a(atomicReference, abstractC0674a);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void w1(m mVar) {
        if (this.f10628a >= 0) {
            mVar.a();
        } else {
            this.f10633c0.add(mVar);
        }
    }

    int A() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return 0;
        }
        return jVar.f10677d;
    }

    public void A0() {
        this.f10611G = true;
    }

    public final Context A1() {
        Context contextW = w();
        if (contextW != null) {
            return contextW;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public Object B() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        return jVar.f10685l;
    }

    @Deprecated
    public void B0() {
    }

    public final View B1() {
        View viewA0 = a0();
        if (viewA0 != null) {
            return viewA0;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    androidx.core.app.s C() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        jVar.getClass();
        return null;
    }

    public void C0() {
        this.f10611G = true;
    }

    void C1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f10653v.d1(parcelable);
        this.f10653v.z();
    }

    View D() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        return jVar.f10692s;
    }

    public void D0() {
        this.f10611G = true;
    }

    public final Object E() {
        p<?> pVar = this.f10652u;
        if (pVar == null) {
            return null;
        }
        return pVar.i();
    }

    public LayoutInflater E0(Bundle bundle) {
        return G(bundle);
    }

    final void E1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f10632c;
        if (sparseArray != null) {
            this.f10613I.restoreHierarchyState(sparseArray);
            this.f10632c = null;
        }
        if (this.f10613I != null) {
            this.f10624W.d(this.f10634d);
            this.f10634d = null;
        }
        this.f10611G = false;
        V0(bundle);
        if (this.f10611G) {
            if (this.f10613I != null) {
                this.f10624W.a(AbstractC0533m.a.ON_CREATE);
            }
        } else {
            throw new O("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public final LayoutInflater F() {
        LayoutInflater layoutInflater = this.f10619R;
        return layoutInflater == null ? g1(null) : layoutInflater;
    }

    public void F0(boolean z5) {
    }

    void F1(int i5, int i6, int i7, int i8) {
        if (this.f10616L == null && i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            return;
        }
        n().f10676c = i5;
        n().f10677d = i6;
        n().f10678e = i7;
        n().f10679f = i8;
    }

    @Deprecated
    public LayoutInflater G(Bundle bundle) {
        p<?> pVar = this.f10652u;
        if (pVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterJ = pVar.j();
        C0466k.a(layoutInflaterJ, this.f10653v.t0());
        return layoutInflaterJ;
    }

    @Deprecated
    public void G0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f10611G = true;
    }

    public void G1(Bundle bundle) {
        if (this.f10651t != null && n0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f10638g = bundle;
    }

    public void H0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f10611G = true;
        p<?> pVar = this.f10652u;
        Activity activityE = pVar == null ? null : pVar.e();
        if (activityE != null) {
            this.f10611G = false;
            G0(activityE, attributeSet, bundle);
        }
    }

    void H1(View view) {
        n().f10692s = view;
    }

    int I() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return 0;
        }
        return jVar.f10680g;
    }

    public void I0(boolean z5) {
    }

    @Deprecated
    public void I1(boolean z5) {
        if (this.f10609E != z5) {
            this.f10609E = z5;
            if (!g0() || h0()) {
                return;
            }
            this.f10652u.n();
        }
    }

    public final ComponentCallbacksC0511f J() {
        return this.f10654w;
    }

    @Deprecated
    public boolean J0(MenuItem menuItem) {
        return false;
    }

    public void J1(boolean z5) {
        if (this.f10610F != z5) {
            this.f10610F = z5;
            if (this.f10609E && g0() && !h0()) {
                this.f10652u.n();
            }
        }
    }

    public final x K() {
        x xVar = this.f10651t;
        if (xVar != null) {
            return xVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @Deprecated
    public void K0(Menu menu) {
    }

    void K1(int i5) {
        if (this.f10616L == null && i5 == 0) {
            return;
        }
        n();
        this.f10616L.f10680g = i5;
    }

    boolean L() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return false;
        }
        return jVar.f10675b;
    }

    public void L0() {
        this.f10611G = true;
    }

    void L1(boolean z5) {
        if (this.f10616L == null) {
            return;
        }
        n().f10675b = z5;
    }

    int M() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return 0;
        }
        return jVar.f10678e;
    }

    public void M0(boolean z5) {
    }

    void M1(float f5) {
        n().f10691r = f5;
    }

    int N() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return 0;
        }
        return jVar.f10679f;
    }

    @Deprecated
    public void N0(Menu menu) {
    }

    void N1(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        n();
        j jVar = this.f10616L;
        jVar.f10681h = arrayList;
        jVar.f10682i = arrayList2;
    }

    float O() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return 1.0f;
        }
        return jVar.f10691r;
    }

    public void O0(boolean z5) {
    }

    @Deprecated
    public void O1(ComponentCallbacksC0511f componentCallbacksC0511f, int i5) {
        if (componentCallbacksC0511f != null) {
            T.c.i(this, componentCallbacksC0511f, i5);
        }
        x xVar = this.f10651t;
        x xVar2 = componentCallbacksC0511f != null ? componentCallbacksC0511f.f10651t : null;
        if (xVar != null && xVar2 != null && xVar != xVar2) {
            throw new IllegalArgumentException("Fragment " + componentCallbacksC0511f + " must share the same FragmentManager to be set as a target fragment");
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511fZ = componentCallbacksC0511f; componentCallbacksC0511fZ != null; componentCallbacksC0511fZ = componentCallbacksC0511fZ.Z(false)) {
            if (componentCallbacksC0511fZ.equals(this)) {
                throw new IllegalArgumentException("Setting " + componentCallbacksC0511f + " as the target of " + this + " would create a target cycle");
            }
        }
        if (componentCallbacksC0511f == null) {
            this.f10640i = null;
            this.f10639h = null;
        } else if (this.f10651t == null || componentCallbacksC0511f.f10651t == null) {
            this.f10640i = null;
            this.f10639h = componentCallbacksC0511f;
        } else {
            this.f10640i = componentCallbacksC0511f.f10637f;
            this.f10639h = null;
        }
        this.f10641j = i5;
    }

    public Object P() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.f10686m;
        return obj == f10604e0 ? B() : obj;
    }

    @Deprecated
    public void P0(int i5, String[] strArr, int[] iArr) {
    }

    @Deprecated
    public void P1(boolean z5) {
        T.c.j(this, z5);
        if (!this.f10615K && z5 && this.f10628a < 5 && this.f10651t != null && g0() && this.f10620S) {
            x xVar = this.f10651t;
            xVar.T0(xVar.t(this));
        }
        this.f10615K = z5;
        this.f10614J = this.f10628a < 5 && !z5;
        if (this.f10630b != null) {
            this.f10636e = Boolean.valueOf(z5);
        }
    }

    public final Resources Q() {
        return A1().getResources();
    }

    public void Q0() {
        this.f10611G = true;
    }

    @Deprecated
    public void Q1(Intent intent, int i5) {
        R1(intent, i5, null);
    }

    public Object R() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.f10684k;
        return obj == f10604e0 ? y() : obj;
    }

    public void R0(Bundle bundle) {
    }

    @Deprecated
    public void R1(Intent intent, int i5, Bundle bundle) {
        if (this.f10652u != null) {
            K().O0(this, intent, i5, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public Object S() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        return jVar.f10687n;
    }

    public void S0() {
        this.f10611G = true;
    }

    @Deprecated
    public void S1(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        Bundle bundle2;
        if (this.f10652u == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (x.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" received the following in startIntentSenderForResult() requestCode: ");
            sb.append(i5);
            sb.append(" IntentSender: ");
            sb.append(intentSender);
            sb.append(" fillInIntent: ");
            sb.append(intent);
            sb.append(" options: ");
            bundle2 = bundle;
            sb.append(bundle2);
            Log.v("FragmentManager", sb.toString());
        } else {
            bundle2 = bundle;
        }
        K().P0(this, intentSender, i5, intent, i6, i7, i8, bundle2);
    }

    public Object T() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.f10688o;
        return obj == f10604e0 ? S() : obj;
    }

    public void T0() {
        this.f10611G = true;
    }

    public void T1() {
        if (this.f10616L == null || !n().f10693t) {
            return;
        }
        if (this.f10652u == null) {
            n().f10693t = false;
        } else if (Looper.myLooper() != this.f10652u.g().getLooper()) {
            this.f10652u.g().postAtFrontOfQueue(new d());
        } else {
            k(true);
        }
    }

    ArrayList<String> U() {
        ArrayList<String> arrayList;
        j jVar = this.f10616L;
        return (jVar == null || (arrayList = jVar.f10681h) == null) ? new ArrayList<>() : arrayList;
    }

    public void U0(View view, Bundle bundle) {
    }

    ArrayList<String> V() {
        ArrayList<String> arrayList;
        j jVar = this.f10616L;
        return (jVar == null || (arrayList = jVar.f10682i) == null) ? new ArrayList<>() : arrayList;
    }

    public void V0(Bundle bundle) {
        this.f10611G = true;
    }

    public final String W(int i5) {
        return Q().getString(i5);
    }

    void W0(Bundle bundle) {
        this.f10653v.R0();
        this.f10628a = 3;
        this.f10611G = false;
        p0(bundle);
        if (this.f10611G) {
            D1();
            this.f10653v.v();
        } else {
            throw new O("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public final String X(int i5, Object... objArr) {
        return Q().getString(i5, objArr);
    }

    void X0() {
        ArrayList<m> arrayList = this.f10633c0;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            m mVar = arrayList.get(i5);
            i5++;
            mVar.a();
        }
        this.f10633c0.clear();
        this.f10653v.k(this.f10652u, l(), this);
        this.f10628a = 0;
        this.f10611G = false;
        s0(this.f10652u.f());
        if (this.f10611G) {
            this.f10651t.F(this);
            this.f10653v.w();
        } else {
            throw new O("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    @Deprecated
    public final ComponentCallbacksC0511f Y() {
        return Z(true);
    }

    void Y0(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    boolean Z0(MenuItem menuItem) {
        if (this.f10605A) {
            return false;
        }
        if (u0(menuItem)) {
            return true;
        }
        return this.f10653v.y(menuItem);
    }

    public View a0() {
        return this.f10613I;
    }

    void a1(Bundle bundle) {
        this.f10653v.R0();
        this.f10628a = 1;
        this.f10611G = false;
        this.f10623V.a(new g());
        this.f10627Z.d(bundle);
        v0(bundle);
        this.f10620S = true;
        if (this.f10611G) {
            this.f10623V.i(AbstractC0533m.a.ON_CREATE);
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onCreate()");
    }

    public InterfaceC0539t b0() {
        K k5 = this.f10624W;
        if (k5 != null) {
            return k5;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    boolean b1(Menu menu, MenuInflater menuInflater) {
        boolean z5 = false;
        if (this.f10605A) {
            return false;
        }
        if (this.f10609E && this.f10610F) {
            y0(menu, menuInflater);
            z5 = true;
        }
        return this.f10653v.A(menu, menuInflater) | z5;
    }

    public AbstractC0545z<InterfaceC0539t> c0() {
        return this.f10625X;
    }

    void c1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10653v.R0();
        this.f10649r = true;
        this.f10624W = new K(this, getViewModelStore());
        View viewZ0 = z0(layoutInflater, viewGroup, bundle);
        this.f10613I = viewZ0;
        if (viewZ0 == null) {
            if (this.f10624W.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f10624W = null;
        } else {
            this.f10624W.b();
            Y.a(this.f10613I, this.f10624W);
            Z.a(this.f10613I, this.f10624W);
            C0577g.a(this.f10613I, this.f10624W);
            this.f10625X.n(this.f10624W);
        }
    }

    void d1() {
        this.f10653v.B();
        this.f10623V.i(AbstractC0533m.a.ON_DESTROY);
        this.f10628a = 0;
        this.f10611G = false;
        this.f10620S = false;
        A0();
        if (this.f10611G) {
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void e0() {
        d0();
        this.f10621T = this.f10637f;
        this.f10637f = UUID.randomUUID().toString();
        this.f10643l = false;
        this.f10644m = false;
        this.f10646o = false;
        this.f10647p = false;
        this.f10648q = false;
        this.f10650s = 0;
        this.f10651t = null;
        this.f10653v = new y();
        this.f10652u = null;
        this.f10655x = 0;
        this.f10656y = 0;
        this.f10657z = null;
        this.f10605A = false;
        this.f10606B = false;
    }

    void e1() {
        this.f10653v.C();
        if (this.f10613I != null && this.f10624W.getLifecycle().b().d(AbstractC0533m.b.CREATED)) {
            this.f10624W.a(AbstractC0533m.a.ON_DESTROY);
        }
        this.f10628a = 1;
        this.f10611G = false;
        C0();
        if (this.f10611G) {
            androidx.loader.app.a.b(this).c();
            this.f10649r = false;
        } else {
            throw new O("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    void f1() {
        this.f10628a = -1;
        this.f10611G = false;
        D0();
        this.f10619R = null;
        if (this.f10611G) {
            if (this.f10653v.E0()) {
                return;
            }
            this.f10653v.B();
            this.f10653v = new y();
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onDetach()");
    }

    public final boolean g0() {
        return this.f10652u != null && this.f10643l;
    }

    LayoutInflater g1(Bundle bundle) {
        LayoutInflater layoutInflaterE0 = E0(bundle);
        this.f10619R = layoutInflaterE0;
        return layoutInflaterE0;
    }

    @Override // androidx.lifecycle.InterfaceC0531k
    public W.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = A1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && x.F0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + A1().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        W.b bVar = new W.b();
        if (application != null) {
            bVar.c(U.a.f10846h, application);
        }
        bVar.c(androidx.lifecycle.M.f10823a, this);
        bVar.c(androidx.lifecycle.M.f10824b, this);
        if (u() != null) {
            bVar.c(androidx.lifecycle.M.f10825c, u());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.InterfaceC0531k
    public U.c getDefaultViewModelProviderFactory() {
        Application application;
        if (this.f10651t == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.f10626Y == null) {
            Context applicationContext = A1().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && x.F0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + A1().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.f10626Y = new P(application, this, u());
        }
        return this.f10626Y;
    }

    @Override // androidx.lifecycle.InterfaceC0539t
    public AbstractC0533m getLifecycle() {
        return this.f10623V;
    }

    @Override // c0.InterfaceC0576f
    public final C0574d getSavedStateRegistry() {
        return this.f10627Z.b();
    }

    @Override // androidx.lifecycle.X
    public W getViewModelStore() {
        if (this.f10651t == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (H() != AbstractC0533m.b.INITIALIZED.ordinal()) {
            return this.f10651t.A0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public final boolean h0() {
        if (this.f10605A) {
            return true;
        }
        x xVar = this.f10651t;
        return xVar != null && xVar.I0(this.f10654w);
    }

    void h1() {
        onLowMemory();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    final boolean i0() {
        return this.f10650s > 0;
    }

    void i1(boolean z5) {
        I0(z5);
    }

    public final boolean j0() {
        return this.f10647p;
    }

    boolean j1(MenuItem menuItem) {
        if (this.f10605A) {
            return false;
        }
        if (this.f10609E && this.f10610F && J0(menuItem)) {
            return true;
        }
        return this.f10653v.H(menuItem);
    }

    void k(boolean z5) {
        ViewGroup viewGroup;
        x xVar;
        j jVar = this.f10616L;
        if (jVar != null) {
            jVar.f10693t = false;
        }
        if (this.f10613I == null || (viewGroup = this.f10612H) == null || (xVar = this.f10651t) == null) {
            return;
        }
        M mN = M.n(viewGroup, xVar);
        mN.p();
        if (z5) {
            this.f10652u.g().post(new e(mN));
        } else {
            mN.g();
        }
    }

    public final boolean k0() {
        if (!this.f10610F) {
            return false;
        }
        x xVar = this.f10651t;
        return xVar == null || xVar.J0(this.f10654w);
    }

    void k1(Menu menu) {
        if (this.f10605A) {
            return;
        }
        if (this.f10609E && this.f10610F) {
            K0(menu);
        }
        this.f10653v.I(menu);
    }

    AbstractC0518m l() {
        return new C0134f();
    }

    boolean l0() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return false;
        }
        return jVar.f10693t;
    }

    void l1() {
        this.f10653v.K();
        if (this.f10613I != null) {
            this.f10624W.a(AbstractC0533m.a.ON_PAUSE);
        }
        this.f10623V.i(AbstractC0533m.a.ON_PAUSE);
        this.f10628a = 6;
        this.f10611G = false;
        L0();
        if (this.f10611G) {
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onPause()");
    }

    public void m(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f10655x));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f10656y));
        printWriter.print(" mTag=");
        printWriter.println(this.f10657z);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f10628a);
        printWriter.print(" mWho=");
        printWriter.print(this.f10637f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f10650s);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f10643l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f10644m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f10646o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f10647p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f10605A);
        printWriter.print(" mDetached=");
        printWriter.print(this.f10606B);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f10610F);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f10609E);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f10607C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f10615K);
        if (this.f10651t != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f10651t);
        }
        if (this.f10652u != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f10652u);
        }
        if (this.f10654w != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f10654w);
        }
        if (this.f10638g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f10638g);
        }
        if (this.f10630b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f10630b);
        }
        if (this.f10632c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f10632c);
        }
        if (this.f10634d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f10634d);
        }
        ComponentCallbacksC0511f componentCallbacksC0511fZ = Z(false);
        if (componentCallbacksC0511fZ != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(componentCallbacksC0511fZ);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f10641j);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(L());
        if (x() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(x());
        }
        if (A() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(A());
        }
        if (M() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(M());
        }
        if (N() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(N());
        }
        if (this.f10612H != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f10612H);
        }
        if (this.f10613I != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f10613I);
        }
        if (t() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(t());
        }
        if (w() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f10653v + ":");
        this.f10653v.U(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean m0() {
        return this.f10628a >= 7;
    }

    void m1(boolean z5) {
        M0(z5);
    }

    public final boolean n0() {
        x xVar = this.f10651t;
        if (xVar == null) {
            return false;
        }
        return xVar.M0();
    }

    boolean n1(Menu menu) {
        boolean z5 = false;
        if (this.f10605A) {
            return false;
        }
        if (this.f10609E && this.f10610F) {
            N0(menu);
            z5 = true;
        }
        return this.f10653v.M(menu) | z5;
    }

    ComponentCallbacksC0511f o(String str) {
        return str.equals(this.f10637f) ? this : this.f10653v.h0(str);
    }

    void o0() {
        this.f10653v.R0();
    }

    void o1() {
        boolean zK0 = this.f10651t.K0(this);
        Boolean bool = this.f10642k;
        if (bool == null || bool.booleanValue() != zK0) {
            this.f10642k = Boolean.valueOf(zK0);
            O0(zK0);
            this.f10653v.N();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f10611G = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        y1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f10611G = true;
    }

    String p() {
        return "fragment_" + this.f10637f + "_rq#" + this.f10631b0.getAndIncrement();
    }

    @Deprecated
    public void p0(Bundle bundle) {
        this.f10611G = true;
    }

    void p1() {
        this.f10653v.R0();
        this.f10653v.Y(true);
        this.f10628a = 7;
        this.f10611G = false;
        Q0();
        if (!this.f10611G) {
            throw new O("Fragment " + this + " did not call through to super.onResume()");
        }
        C0541v c0541v = this.f10623V;
        AbstractC0533m.a aVar = AbstractC0533m.a.ON_RESUME;
        c0541v.i(aVar);
        if (this.f10613I != null) {
            this.f10624W.a(aVar);
        }
        this.f10653v.O();
    }

    public final ActivityC0516k q() {
        p<?> pVar = this.f10652u;
        if (pVar == null) {
            return null;
        }
        return (ActivityC0516k) pVar.e();
    }

    @Deprecated
    public void q0(int i5, int i6, Intent intent) {
        if (x.F0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i5 + " resultCode: " + i6 + " data: " + intent);
        }
    }

    void q1(Bundle bundle) {
        R0(bundle);
        this.f10627Z.e(bundle);
        Bundle bundleF1 = this.f10653v.f1();
        if (bundleF1 != null) {
            bundle.putParcelable("android:support:fragments", bundleF1);
        }
    }

    public boolean r() {
        Boolean bool;
        j jVar = this.f10616L;
        if (jVar == null || (bool = jVar.f10690q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public void r0(Activity activity) {
        this.f10611G = true;
    }

    void r1() {
        this.f10653v.R0();
        this.f10653v.Y(true);
        this.f10628a = 5;
        this.f10611G = false;
        S0();
        if (!this.f10611G) {
            throw new O("Fragment " + this + " did not call through to super.onStart()");
        }
        C0541v c0541v = this.f10623V;
        AbstractC0533m.a aVar = AbstractC0533m.a.ON_START;
        c0541v.i(aVar);
        if (this.f10613I != null) {
            this.f10624W.a(aVar);
        }
        this.f10653v.P();
    }

    public boolean s() {
        Boolean bool;
        j jVar = this.f10616L;
        if (jVar == null || (bool = jVar.f10689p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void s0(Context context) {
        this.f10611G = true;
        p<?> pVar = this.f10652u;
        Activity activityE = pVar == null ? null : pVar.e();
        if (activityE != null) {
            this.f10611G = false;
            r0(activityE);
        }
    }

    void s1() {
        this.f10653v.R();
        if (this.f10613I != null) {
            this.f10624W.a(AbstractC0533m.a.ON_STOP);
        }
        this.f10623V.i(AbstractC0533m.a.ON_STOP);
        this.f10628a = 4;
        this.f10611G = false;
        T0();
        if (this.f10611G) {
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onStop()");
    }

    View t() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        return jVar.f10674a;
    }

    @Deprecated
    public void t0(ComponentCallbacksC0511f componentCallbacksC0511f) {
    }

    void t1() {
        U0(this.f10613I, this.f10630b);
        this.f10653v.S();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f10637f);
        if (this.f10655x != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f10655x));
        }
        if (this.f10657z != null) {
            sb.append(" tag=");
            sb.append(this.f10657z);
        }
        sb.append(")");
        return sb.toString();
    }

    public final Bundle u() {
        return this.f10638g;
    }

    public boolean u0(MenuItem menuItem) {
        return false;
    }

    public final x v() {
        if (this.f10652u != null) {
            return this.f10653v;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void v0(Bundle bundle) {
        this.f10611G = true;
        C1(bundle);
        if (this.f10653v.L0(1)) {
            return;
        }
        this.f10653v.z();
    }

    public final <I, O> AbstractC0642c<I> v1(AbstractC0674a<I, O> abstractC0674a, InterfaceC0641b<O> interfaceC0641b) {
        return u1(abstractC0674a, new h(), interfaceC0641b);
    }

    public Context w() {
        p<?> pVar = this.f10652u;
        if (pVar == null) {
            return null;
        }
        return pVar.f();
    }

    public Animation w0(int i5, boolean z5, int i6) {
        return null;
    }

    int x() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return 0;
        }
        return jVar.f10676c;
    }

    public Animator x0(int i5, boolean z5, int i6) {
        return null;
    }

    @Deprecated
    public final void x1(String[] strArr, int i5) {
        if (this.f10652u != null) {
            K().N0(this, strArr, i5);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public Object y() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        return jVar.f10683j;
    }

    @Deprecated
    public void y0(Menu menu, MenuInflater menuInflater) {
    }

    public final ActivityC0516k y1() {
        ActivityC0516k activityC0516kQ = q();
        if (activityC0516kQ != null) {
            return activityC0516kQ;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    androidx.core.app.s z() {
        j jVar = this.f10616L;
        if (jVar == null) {
            return null;
        }
        jVar.getClass();
        return null;
    }

    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i5 = this.f10629a0;
        if (i5 != 0) {
            return layoutInflater.inflate(i5, viewGroup, false);
        }
        return null;
    }

    public final Bundle z1() {
        Bundle bundleU = u();
        if (bundleU != null) {
            return bundleU;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }
}
