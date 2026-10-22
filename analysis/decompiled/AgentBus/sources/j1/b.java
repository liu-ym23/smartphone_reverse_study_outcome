package j1;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.agentbus.R;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class b extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f5096f;

    /* renamed from: g, reason: collision with root package name */
    public IBinder f5097g;

    /* renamed from: h, reason: collision with root package name */
    public n2 f5098h;

    /* renamed from: i, reason: collision with root package name */
    public b0.u f5099i;

    /* renamed from: j, reason: collision with root package name */
    public eb.k f5100j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5101k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5102l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5103m;

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    private final void setParentContext(b0.u uVar) {
        if (this.f5099i != uVar) {
            this.f5099i = uVar;
            if (uVar != null) {
                this.f5096f = null;
            }
            n2 n2Var = this.f5098h;
            if (n2Var != null) {
                n2Var.c();
                this.f5098h = null;
                if (isAttachedToWindow()) {
                    c();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.f5097g != iBinder) {
            this.f5097g = iBinder;
            this.f5096f = null;
        }
    }

    public abstract void a(int i2, b0.p pVar);

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        b();
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        b();
        return super.addViewInLayout(view, i2, layoutParams);
    }

    public final void b() {
        if (this.f5102l) {
            return;
        }
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    public final void c() {
        if (this.f5098h == null) {
            try {
                this.f5102l = true;
                this.f5098h = o2.a(this, d(), new j0.d(-656146368, true, new a(0, this)));
            } finally {
                this.f5102l = false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b0.u d() {
        b0.j2 j2Var;
        g7.l lVar;
        b0.q1 q1Var;
        b0.u uVarB = this.f5099i;
        if (uVarB == null) {
            uVarB = k2.b(this);
            if (uVarB == null) {
                Object parent = getParent();
                while (uVarB == null && (parent instanceof View)) {
                    View view = (View) parent;
                    uVarB = k2.b(view);
                    parent = view.getParent();
                }
            }
            if (uVarB != null) {
                b0.u uVar = (!(uVarB instanceof b0.j2) || ((b0.d2) ((b0.j2) uVarB).f1225t.getValue()).compareTo(b0.d2.f1124g) > 0) ? uVarB : null;
                if (uVar != null) {
                    this.f5096f = new WeakReference(uVar);
                }
            } else {
                uVarB = null;
            }
            if (uVarB == null) {
                WeakReference weakReference = this.f5096f;
                if (weakReference == null || (uVarB = (b0.u) weakReference.get()) == null || ((uVarB instanceof b0.j2) && ((b0.d2) ((b0.j2) uVarB).f1225t.getValue()).compareTo(b0.d2.f1124g) <= 0)) {
                    uVarB = null;
                }
                if (uVarB == null) {
                    if (!isAttachedToWindow()) {
                        f1.a.b("Cannot locate windowRecomposer; View " + this + " is not attached to a window");
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
                    b0.u uVarB2 = k2.b(view2);
                    if (uVarB2 == null) {
                        ((d2) e2.f5132a.get()).getClass();
                        g7.m mVar = g7.m.f3866f;
                        c7.o oVar = s0.f5312r;
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            lVar = (g7.l) s0.f5312r.getValue();
                        } else {
                            lVar = (g7.l) s0.f5313s.get();
                            if (lVar == null) {
                                throw new IllegalStateException("no AndroidUiDispatcher for this thread");
                            }
                        }
                        g7.l lVarQ = lVar.Q(mVar);
                        b0.c1 c1Var = (b0.c1) lVarQ.o(b0.b1.f1107g);
                        if (c1Var != null) {
                            b0.q1 q1Var2 = new b0.q1(c1Var);
                            b0.x0 x0Var = (b0.x0) q1Var2.f1321h;
                            synchronized (x0Var.f1416c) {
                                x0Var.f1415b = false;
                                q1Var = q1Var2;
                            }
                        } else {
                            q1Var = 0;
                        }
                        q7.v vVar = new q7.v();
                        g7.l q1Var3 = (n0.o) lVarQ.o(n0.b.f6786t);
                        if (q1Var3 == null) {
                            q1Var3 = new q1();
                            vVar.f8820f = q1Var3;
                        }
                        if (q1Var != 0) {
                            mVar = q1Var;
                        }
                        g7.l lVarQ2 = lVarQ.Q(mVar).Q(q1Var3);
                        j2Var = new b0.j2(lVarQ2);
                        synchronized (j2Var.f1207b) {
                            j2Var.f1224s = true;
                        }
                        na.d dVarB = ia.d0.b(lVarQ2);
                        androidx.lifecycle.v vVarC = androidx.lifecycle.j0.c(view2);
                        androidx.lifecycle.x xVarA = vVarC != null ? vVarC.a() : null;
                        if (xVarA == null) {
                            f1.a.c("ViewTreeLifecycleOwner not found from " + view2);
                            throw new a4.u();
                        }
                        view2.addOnAttachStateChangeListener(new f2(view2, j2Var));
                        xVarA.a(new i2(dVarB, q1Var, j2Var, vVar, view2));
                        view2.setTag(R.id.androidx_compose_ui_view_composition_context, j2Var);
                        ia.a1 a1Var = ia.a1.f4917f;
                        Handler handler = view2.getHandler();
                        int i2 = ja.e.f5425a;
                        view2.addOnAttachStateChangeListener(new b0(2, ia.d0.s(a1Var, new ja.d(handler, "windowRecomposer cleanup", false).f5424k, null, new a5.b(j2Var, view2, null, 9), 2)));
                    } else {
                        if (!(uVarB2 instanceof b0.j2)) {
                            throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer");
                        }
                        j2Var = (b0.j2) uVarB2;
                    }
                    b0.j2 j2Var2 = ((b0.d2) j2Var.f1225t.getValue()).compareTo(b0.d2.f1124g) > 0 ? j2Var : null;
                    if (j2Var2 != null) {
                        this.f5096f = new WeakReference(j2Var2);
                    }
                    return j2Var;
                }
            }
        }
        return uVarB;
    }

    public final boolean getHasComposition() {
        return this.f5098h != null;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.f5101k;
    }

    @Override // android.view.ViewGroup
    public final boolean isTransitionGroup() {
        return !this.f5103m || super.isTransitionGroup();
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
    public final void onLayout(boolean z4, int i2, int i10, int i11, int i12) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (i11 - i2) - getPaddingRight(), (i12 - i10) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i10) {
        c();
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i2, i10);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i2)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(i10)));
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingBottom() + getPaddingTop() + childAt.getMeasuredHeight());
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(i2);
        }
    }

    public final void setParentCompositionContext(b0.u uVar) {
        setParentContext(uVar);
    }

    public final void setShowLayoutBounds(boolean z4) {
        this.f5101k = z4;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((y) ((i1.k1) childAt)).setShowLayoutBounds(z4);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean z4) {
        super.setTransitionGroup(z4);
        this.f5103m = true;
    }

    public final void setViewCompositionStrategy(x1 x1Var) {
        eb.k kVar = this.f5100j;
        if (kVar != null) {
            kVar.c();
        }
        ((k0) x1Var).getClass();
        b0 b0Var = new b0(1, this);
        addOnAttachStateChangeListener(b0Var);
        b4.b bVar = new b4.b(6);
        n7.a.m(this).f8969a.add(bVar);
        this.f5100j = new eb.k(this, b0Var, bVar, 1);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2) {
        b();
        super.addView(view, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z4) {
        b();
        return super.addViewInLayout(view, i2, layoutParams, z4);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, int i10) {
        b();
        super.addView(view, i2, i10);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        b();
        super.addView(view, i2, layoutParams);
    }
}
