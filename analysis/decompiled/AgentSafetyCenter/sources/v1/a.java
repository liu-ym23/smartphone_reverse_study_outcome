package v1;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f14324c;

    /* renamed from: f, reason: collision with root package name */
    public IBinder f14325f;

    /* renamed from: g, reason: collision with root package name */
    public g2 f14326g;

    /* renamed from: h, reason: collision with root package name */
    public k0.v f14327h;
    public ed.l i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14328j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14329k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14330l;

    public a(Context context) {
        super(context, null, 0);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        ab.b bVar = new ab.b(7);
        bVar.f379f = this;
        VarHandle.storeStoreFence();
        addOnAttachStateChangeListener(bVar);
        s1 s1Var = new s1();
        s1Var.f14533a = this;
        VarHandle.storeStoreFence();
        id.k.D(this).f11367a.add(s1Var);
        this.i = new ed.l(this, bVar, s1Var, 3);
    }

    private final void setParentContext(k0.v vVar) {
        if (this.f14327h != vVar) {
            this.f14327h = vVar;
            if (vVar != null) {
                this.f14324c = null;
            }
            g2 g2Var = this.f14326g;
            if (g2Var != null) {
                g2Var.a();
                this.f14326g = null;
                if (isAttachedToWindow()) {
                    c();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.f14325f != iBinder) {
            this.f14325f = iBinder;
            this.f14324c = null;
        }
    }

    public abstract void a(int i, k0.s sVar);

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        b();
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams) {
        b();
        return super.addViewInLayout(view, i, layoutParams);
    }

    public final void b() {
        if (this.f14329k) {
            return;
        }
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    public final void c() {
        if (this.f14326g == null) {
            try {
                this.f14329k = true;
                this.f14326g = h2.a(this, f(), new s0.c(-656146368, true, new b0.s(this, 5)));
            } finally {
                this.f14329k = false;
            }
        }
    }

    public void d(int i, int i3, int i10, int i11) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (i10 - i) - getPaddingRight(), (i11 - i3) - getPaddingBottom());
        }
    }

    public void e(int i, int i3) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i, i3);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(i3)));
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingBottom() + getPaddingTop() + childAt.getMeasuredHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k0.v f() {
        k0.z1 z1Var;
        nb.g gVar;
        k0.m1 m1Var;
        k0.v vVarB = this.f14327h;
        if (vVarB == null) {
            vVarB = d2.b(this);
            if (vVarB == null) {
                Object parent = getParent();
                while (vVarB == null && (parent instanceof View)) {
                    View view = (View) parent;
                    vVarB = d2.b(view);
                    parent = view.getParent();
                }
            }
            if (vVarB != null) {
                k0.v vVar = (!(vVarB instanceof k0.z1) || ((k0.w1) ((k0.z1) vVarB).f7173t.getValue()).compareTo(k0.w1.f7101f) > 0) ? vVarB : null;
                if (vVar != null) {
                    this.f14324c = new WeakReference(vVar);
                }
            } else {
                vVarB = null;
            }
            if (vVarB == null) {
                WeakReference weakReference = this.f14324c;
                if (weakReference == null || (vVarB = (k0.v) weakReference.get()) == null || ((vVarB instanceof k0.z1) && ((k0.w1) ((k0.z1) vVarB).f7173t.getValue()).compareTo(k0.w1.f7101f) <= 0)) {
                    vVarB = null;
                }
                if (vVarB == null) {
                    if (!isAttachedToWindow()) {
                        r1.a.b("Cannot locate windowRecomposer; View " + this + " is not attached to a window");
                    }
                    Object parent2 = getParent();
                    View view2 = this;
                    while (parent2 instanceof View) {
                        View view3 = (View) parent2;
                        if (view3.getId() == 16908290) {
                            break;
                        }
                        view2 = view3;
                        parent2 = view3.getParent();
                    }
                    k0.v vVarB2 = d2.b(view2);
                    if (vVarB2 == null) {
                        ((y1) z1.f14602a.get()).getClass();
                        nb.h hVar = nb.h.f8811c;
                        jb.k kVar = m0.f14492p;
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            gVar = (nb.g) m0.f14492p.getValue();
                        } else {
                            gVar = (nb.g) m0.f14493q.get();
                            if (gVar == null) {
                                od.f.e("no AndroidUiDispatcher for this thread");
                                return null;
                            }
                        }
                        nb.g gVarPlus = gVar.plus(hVar);
                        k0.z0 z0Var = (k0.z0) gVarPlus.get(k0.y0.f7136f);
                        int i = 0;
                        if (z0Var != null) {
                            k0.m1 m1Var2 = new k0.m1(i);
                            m1Var2.f6977f = z0Var;
                            ab.c cVar = new ab.c();
                            Object obj = new Object();
                            cVar.f383b = obj;
                            cVar.f384c = new ArrayList();
                            cVar.f385d = new ArrayList();
                            cVar.f382a = true;
                            VarHandle.storeStoreFence();
                            m1Var2.f6978g = cVar;
                            VarHandle.storeStoreFence();
                            synchronized (obj) {
                                cVar.f382a = false;
                                m1Var = m1Var2;
                            }
                        } else {
                            m1Var = 0;
                        }
                        yb.u uVar = new yb.u();
                        w0.n nVar = (w0.n) gVarPlus.get(w0.b.f15103t);
                        w0.n nVar2 = nVar;
                        if (nVar == null) {
                            l1 l1Var = new l1();
                            l1Var.f14489c = new k0.g1(1.0f);
                            VarHandle.storeStoreFence();
                            uVar.f16098c = l1Var;
                            nVar2 = l1Var;
                        }
                        if (m1Var != 0) {
                            hVar = m1Var;
                        }
                        nb.g gVarPlus2 = gVarPlus.plus(hVar).plus(nVar2);
                        k0.z1 z1Var2 = new k0.z1();
                        ab.e eVar = new ab.e(6);
                        eVar.f393f = z1Var2;
                        VarHandle.storeStoreFence();
                        k0.g gVar2 = new k0.g();
                        gVar2.f6910c = eVar;
                        gVar2.f6911f = new Object();
                        gVar2.f6913h = new s0.a(0);
                        gVar2.i = new p.a0();
                        gVar2.f6914j = new p.a0();
                        VarHandle.storeStoreFence();
                        z1Var2.f7155a = gVar2;
                        Object obj2 = new Object();
                        z1Var2.f7156b = obj2;
                        z1Var2.f7159e = new ArrayList();
                        z1Var2.f7161g = new p.g0();
                        z1Var2.f7162h = new m0.e(new k0.y[16]);
                        z1Var2.i = new ArrayList();
                        z1Var2.f7163j = new ArrayList();
                        z1Var2.f7164k = new p.f0();
                        p5.c cVar2 = new p5.c(7);
                        cVar2.f9717f = new p.f0();
                        cVar2.f9718g = new p.f0();
                        VarHandle.storeStoreFence();
                        z1Var2.f7165l = cVar2;
                        z1Var2.f7166m = new p.f0();
                        z1Var2.f7167n = new p.f0();
                        z1Var2.f7173t = nc.k0.a(k0.w1.f7102g);
                        new p5.m();
                        kc.z0 z0Var2 = new kc.z0((kc.x0) gVarPlus2.get(kc.w0.f7498c));
                        a9.e eVar2 = new a9.e(9);
                        eVar2.f257f = z1Var2;
                        VarHandle.storeStoreFence();
                        z0Var2.g(eVar2);
                        z1Var2.f7174u = z0Var2;
                        z1Var2.f7175v = gVarPlus2.plus(gVar2).plus(z0Var2);
                        int i3 = 8;
                        z1Var2.f7176w = new k0.y0(8);
                        VarHandle.storeStoreFence();
                        synchronized (obj2) {
                            z1Var2.f7172s = true;
                        }
                        pc.c cVarA = kc.w.a(gVarPlus2);
                        androidx.lifecycle.x xVarD = androidx.lifecycle.s0.d(view2);
                        androidx.lifecycle.q lifecycle = xVarD != null ? xVarD.getLifecycle() : null;
                        if (lifecycle == null) {
                            r1.a.c("ViewTreeLifecycleOwner not found from " + view2);
                            throw new androidx.fragment.app.d();
                        }
                        a2 a2Var = new a2();
                        a2Var.f14377c = view2;
                        a2Var.f14378f = z1Var2;
                        VarHandle.storeStoreFence();
                        view2.addOnAttachStateChangeListener(a2Var);
                        c2 c2Var = new c2();
                        c2Var.f14392c = cVarA;
                        c2Var.f14393f = m1Var;
                        c2Var.f14394g = z1Var2;
                        c2Var.f14395h = uVar;
                        c2Var.i = view2;
                        VarHandle.storeStoreFence();
                        lifecycle.a(c2Var);
                        view2.setTag(R.id.androidx_compose_ui_view_composition_context, z1Var2);
                        kc.r0 r0Var = kc.r0.f7476c;
                        Handler handler = view2.getHandler();
                        int i10 = lc.e.f7861a;
                        kc.z zVarU = kc.w.u(r0Var, new lc.d(handler, "windowRecomposer cleanup", false).i, null, new t5.e(z1Var2, view2, cVar, 3), 2);
                        ab.b bVar = new ab.b(i3);
                        bVar.f379f = zVarU;
                        VarHandle.storeStoreFence();
                        view2.addOnAttachStateChangeListener(bVar);
                        z1Var = z1Var2;
                    } else {
                        if (!(vVarB2 instanceof k0.z1)) {
                            od.f.e("root viewTreeParentCompositionContext is not a Recomposer");
                            return null;
                        }
                        z1Var = (k0.z1) vVarB2;
                    }
                    cVar = ((k0.w1) z1Var.f7173t.getValue()).compareTo(k0.w1.f7101f) > 0 ? z1Var : null;
                    if (cVar != null) {
                        this.f14324c = new WeakReference(cVar);
                    }
                    return z1Var;
                }
            }
        }
        return vVarB;
    }

    public final boolean getHasComposition() {
        return this.f14326g != null;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.f14328j;
    }

    @Override // android.view.ViewGroup
    public final boolean isTransitionGroup() {
        return !this.f14330l || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        d(i, i3, i10, i11);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        c();
        e(i, i3);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(i);
        }
    }

    public final void setParentCompositionContext(k0.v vVar) {
        setParentContext(vVar);
    }

    public final void setShowLayoutBounds(boolean z10) {
        this.f14328j = z10;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((t) ((u1.n1) childAt)).setShowLayoutBounds(z10);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean z10) {
        super.setTransitionGroup(z10);
        this.f14330l = true;
    }

    public final void setViewCompositionStrategy(t1 t1Var) {
        ed.l lVar = this.i;
        if (lVar != null) {
            lVar.invoke();
        }
        ((g0) t1Var).getClass();
        ab.b bVar = new ab.b(7);
        bVar.f379f = this;
        VarHandle.storeStoreFence();
        addOnAttachStateChangeListener(bVar);
        s1 s1Var = new s1();
        s1Var.f14533a = this;
        VarHandle.storeStoreFence();
        id.k.D(this).f11367a.add(s1Var);
        this.i = new ed.l(this, bVar, s1Var, 3);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        b();
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z10) {
        b();
        return super.addViewInLayout(view, i, layoutParams, z10);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i3) {
        b();
        super.addView(view, i, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        b();
        super.addView(view, i, layoutParams);
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }
}
