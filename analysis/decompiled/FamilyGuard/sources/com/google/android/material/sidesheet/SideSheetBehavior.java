package com.google.android.material.sidesheet;

import E.c;
import E.f;
import J.c;
import a1.C0416i;
import a1.C0417j;
import a1.C0418k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.H;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import q1.C0981c;
import t1.C1115h;
import t1.l;

/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    private d f13108a;

    /* renamed from: b, reason: collision with root package name */
    private float f13109b;

    /* renamed from: c, reason: collision with root package name */
    private C1115h f13110c;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f13111d;

    /* renamed from: e, reason: collision with root package name */
    private l f13112e;

    /* renamed from: f, reason: collision with root package name */
    private final SideSheetBehavior<V>.c f13113f;

    /* renamed from: g, reason: collision with root package name */
    private float f13114g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13115h;

    /* renamed from: i, reason: collision with root package name */
    private int f13116i;

    /* renamed from: j, reason: collision with root package name */
    private int f13117j;

    /* renamed from: k, reason: collision with root package name */
    private J.c f13118k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13119l;

    /* renamed from: m, reason: collision with root package name */
    private float f13120m;

    /* renamed from: n, reason: collision with root package name */
    private int f13121n;

    /* renamed from: o, reason: collision with root package name */
    private int f13122o;

    /* renamed from: p, reason: collision with root package name */
    private int f13123p;

    /* renamed from: q, reason: collision with root package name */
    private int f13124q;

    /* renamed from: r, reason: collision with root package name */
    private WeakReference<V> f13125r;

    /* renamed from: s, reason: collision with root package name */
    private WeakReference<View> f13126s;

    /* renamed from: t, reason: collision with root package name */
    private int f13127t;

    /* renamed from: u, reason: collision with root package name */
    private VelocityTracker f13128u;

    /* renamed from: v, reason: collision with root package name */
    private o1.d f13129v;

    /* renamed from: w, reason: collision with root package name */
    private int f13130w;

    /* renamed from: x, reason: collision with root package name */
    private final Set<g> f13131x;

    /* renamed from: y, reason: collision with root package name */
    private final c.AbstractC0042c f13132y;

    /* renamed from: z, reason: collision with root package name */
    private static final int f13107z = C0416i.f6909y;

    /* renamed from: A, reason: collision with root package name */
    private static final int f13106A = C0417j.f6921l;

    class a extends c.AbstractC0042c {
        a() {
        }

        @Override // J.c.AbstractC0042c
        public int a(View view, int i5, int i6) {
            return B.a.b(i5, SideSheetBehavior.this.f13108a.f(), SideSheetBehavior.this.f13108a.e());
        }

        @Override // J.c.AbstractC0042c
        public int b(View view, int i5, int i6) {
            return view.getTop();
        }

        @Override // J.c.AbstractC0042c
        public int d(View view) {
            return SideSheetBehavior.this.f13121n + SideSheetBehavior.this.B();
        }

        @Override // J.c.AbstractC0042c
        public void j(int i5) {
            if (i5 == 1 && SideSheetBehavior.this.f13115h) {
                SideSheetBehavior.this.X(1);
            }
        }

        @Override // J.c.AbstractC0042c
        public void k(View view, int i5, int i6, int i7, int i8) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View viewX = SideSheetBehavior.this.x();
            if (viewX != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewX.getLayoutParams()) != null) {
                SideSheetBehavior.this.f13108a.n(marginLayoutParams, view.getLeft(), view.getRight());
                viewX.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.t(view, i5);
        }

        @Override // J.c.AbstractC0042c
        public void l(View view, float f5, float f6) {
            int iP = SideSheetBehavior.this.p(view, f5, f6);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.c0(view, iP, sideSheetBehavior.b0());
        }

        @Override // J.c.AbstractC0042c
        public boolean m(View view, int i5) {
            return (SideSheetBehavior.this.f13116i == 1 || SideSheetBehavior.this.f13125r == null || SideSheetBehavior.this.f13125r.get() != view) ? false : true;
        }
    }

    class c {

        /* renamed from: a, reason: collision with root package name */
        private int f13135a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f13136b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f13137c = new Runnable() { // from class: com.google.android.material.sidesheet.f
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.c.a(this.f13141a);
            }
        };

        c() {
        }

        public static /* synthetic */ void a(c cVar) {
            cVar.f13136b = false;
            if (SideSheetBehavior.this.f13118k != null && SideSheetBehavior.this.f13118k.k(true)) {
                cVar.b(cVar.f13135a);
            } else if (SideSheetBehavior.this.f13116i == 2) {
                SideSheetBehavior.this.X(cVar.f13135a);
            }
        }

        void b(int i5) {
            if (SideSheetBehavior.this.f13125r == null || SideSheetBehavior.this.f13125r.get() == null) {
                return;
            }
            this.f13135a = i5;
            if (this.f13136b) {
                return;
            }
            ((View) SideSheetBehavior.this.f13125r.get()).postOnAnimation(this.f13137c);
            this.f13136b = true;
        }
    }

    public SideSheetBehavior() {
        this.f13113f = new c();
        this.f13115h = true;
        this.f13116i = 5;
        this.f13117j = 5;
        this.f13120m = 0.1f;
        this.f13127t = -1;
        this.f13131x = new LinkedHashSet();
        this.f13132y = new a();
    }

    private CoordinatorLayout.f H() {
        V v5;
        WeakReference<V> weakReference = this.f13125r;
        if (weakReference == null || (v5 = weakReference.get()) == null || !(v5.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return null;
        }
        return (CoordinatorLayout.f) v5.getLayoutParams();
    }

    private boolean I() {
        CoordinatorLayout.f fVarH = H();
        return fVarH != null && ((ViewGroup.MarginLayoutParams) fVarH).leftMargin > 0;
    }

    private boolean J() {
        CoordinatorLayout.f fVarH = H();
        return fVarH != null && ((ViewGroup.MarginLayoutParams) fVarH).rightMargin > 0;
    }

    private boolean K(MotionEvent motionEvent) {
        return Y() && o((float) this.f13130w, motionEvent.getX()) > ((float) this.f13118k.u());
    }

    private boolean L(float f5) {
        return this.f13108a.j(f5);
    }

    private boolean M(V v5) {
        ViewParent parent = v5.getParent();
        return parent != null && parent.isLayoutRequested() && v5.isAttachedToWindow();
    }

    private boolean N(View view, int i5, boolean z5) {
        int iC = C(i5);
        J.c cVarG = G();
        if (cVarG != null) {
            return z5 ? cVarG.F(iC, view.getTop()) : cVarG.H(view, iC, view.getTop());
        }
        return false;
    }

    private void O(CoordinatorLayout coordinatorLayout) {
        int i5;
        View viewFindViewById;
        if (this.f13126s != null || (i5 = this.f13127t) == -1 || (viewFindViewById = coordinatorLayout.findViewById(i5)) == null) {
            return;
        }
        this.f13126s = new WeakReference<>(viewFindViewById);
    }

    private void P(V v5, c.a aVar, int i5) {
        H.f0(v5, aVar, null, r(i5));
    }

    private void Q() {
        VelocityTracker velocityTracker = this.f13128u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f13128u = null;
        }
    }

    private void R(V v5, Runnable runnable) {
        if (M(v5)) {
            v5.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void U(int i5) {
        d dVar = this.f13108a;
        if (dVar == null || dVar.i() != i5) {
            if (i5 == 0) {
                this.f13108a = new com.google.android.material.sidesheet.b(this);
                if (this.f13112e == null || J()) {
                    return;
                }
                l.b bVarW = this.f13112e.w();
                bVarW.G(0.0f).y(0.0f);
                e0(bVarW.m());
                return;
            }
            if (i5 == 1) {
                this.f13108a = new com.google.android.material.sidesheet.a(this);
                if (this.f13112e == null || I()) {
                    return;
                }
                l.b bVarW2 = this.f13112e.w();
                bVarW2.C(0.0f).u(0.0f);
                e0(bVarW2.m());
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i5 + ". Must be 0 or 1.");
        }
    }

    private void V(V v5, int i5) {
        U(Gravity.getAbsoluteGravity(((CoordinatorLayout.f) v5.getLayoutParams()).f9427c, i5) == 3 ? 1 : 0);
    }

    private boolean Y() {
        if (this.f13118k != null) {
            return this.f13115h || this.f13116i == 1;
        }
        return false;
    }

    private boolean a0(V v5) {
        return (v5.isShown() || H.m(v5) != null) && this.f13115h;
    }

    public static /* synthetic */ boolean c(SideSheetBehavior sideSheetBehavior, int i5, View view, f.a aVar) {
        sideSheetBehavior.W(i5);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(View view, int i5, boolean z5) {
        if (!N(view, i5, z5)) {
            X(i5);
        } else {
            X(2);
            this.f13113f.b(i5);
        }
    }

    public static /* synthetic */ void d(SideSheetBehavior sideSheetBehavior, int i5) {
        V v5 = sideSheetBehavior.f13125r.get();
        if (v5 != null) {
            sideSheetBehavior.c0(v5, i5, false);
        }
    }

    private void d0() {
        V v5;
        WeakReference<V> weakReference = this.f13125r;
        if (weakReference == null || (v5 = weakReference.get()) == null) {
            return;
        }
        H.d0(v5, 262144);
        H.d0(v5, 1048576);
        if (this.f13116i != 5) {
            P(v5, c.a.f1266y, 5);
        }
        if (this.f13116i != 3) {
            P(v5, c.a.f1264w, 3);
        }
    }

    private void e0(l lVar) {
        C1115h c1115h = this.f13110c;
        if (c1115h != null) {
            c1115h.setShapeAppearanceModel(lVar);
        }
    }

    private void f0(View view) {
        int i5 = this.f13116i == 5 ? 4 : 0;
        if (view.getVisibility() != i5) {
            view.setVisibility(i5);
        }
    }

    private int n(int i5, V v5) {
        int i6 = this.f13116i;
        if (i6 == 1 || i6 == 2) {
            return i5 - this.f13108a.g(v5);
        }
        if (i6 == 3) {
            return 0;
        }
        if (i6 == 5) {
            return this.f13108a.d();
        }
        throw new IllegalStateException("Unexpected value: " + this.f13116i);
    }

    private float o(float f5, float f6) {
        return Math.abs(f5 - f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p(View view, float f5, float f6) {
        if (L(f5)) {
            return 3;
        }
        if (Z(view, f5)) {
            return (this.f13108a.l(f5, f6) || this.f13108a.k(view)) ? 5 : 3;
        }
        if (f5 != 0.0f && e.a(f5, f6)) {
            return 5;
        }
        int left = view.getLeft();
        return Math.abs(left - y()) < Math.abs(left - this.f13108a.d()) ? 3 : 5;
    }

    private void q() {
        WeakReference<View> weakReference = this.f13126s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f13126s = null;
    }

    private E.f r(final int i5) {
        return new E.f() { // from class: u1.a
            @Override // E.f
            public final boolean a(View view, f.a aVar) {
                return SideSheetBehavior.c(this.f22853a, i5, view, aVar);
            }
        };
    }

    private void s(Context context) {
        if (this.f13112e == null) {
            return;
        }
        C1115h c1115h = new C1115h(this.f13112e);
        this.f13110c = c1115h;
        c1115h.U(context);
        ColorStateList colorStateList = this.f13111d;
        if (colorStateList != null) {
            this.f13110c.g0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f13110c.setTint(typedValue.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(View view, int i5) {
        if (this.f13131x.isEmpty()) {
            return;
        }
        float fB = this.f13108a.b(i5);
        Iterator<g> it = this.f13131x.iterator();
        while (it.hasNext()) {
            it.next().b(view, fB);
        }
    }

    private void u(View view) {
        if (H.m(view) == null) {
            H.m0(view, view.getResources().getString(f13107z));
        }
    }

    private int v(int i5, int i6, int i7, int i8) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, i6, i8);
        if (i7 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i7), 1073741824);
        }
        if (size != 0) {
            i7 = Math.min(size, i7);
        }
        return View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
    }

    float A() {
        return 0.5f;
    }

    int B() {
        return this.f13124q;
    }

    int C(int i5) {
        if (i5 == 3) {
            return y();
        }
        if (i5 == 5) {
            return this.f13108a.d();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i5);
    }

    int D() {
        return this.f13123p;
    }

    int E() {
        return this.f13122o;
    }

    int F() {
        return 500;
    }

    J.c G() {
        return this.f13118k;
    }

    public void S(int i5) {
        this.f13127t = i5;
        q();
        WeakReference<V> weakReference = this.f13125r;
        if (weakReference != null) {
            V v5 = weakReference.get();
            if (i5 == -1 || !v5.isLaidOut()) {
                return;
            }
            v5.requestLayout();
        }
    }

    public void T(boolean z5) {
        this.f13115h = z5;
    }

    public void W(final int i5) {
        if (i5 == 1 || i5 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i5 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference<V> weakReference = this.f13125r;
        if (weakReference == null || weakReference.get() == null) {
            X(i5);
        } else {
            R(this.f13125r.get(), new Runnable() { // from class: u1.b
                @Override // java.lang.Runnable
                public final void run() {
                    SideSheetBehavior.d(this.f22855a, i5);
                }
            });
        }
    }

    void X(int i5) {
        V v5;
        if (this.f13116i == i5) {
            return;
        }
        this.f13116i = i5;
        if (i5 == 3 || i5 == 5) {
            this.f13117j = i5;
        }
        WeakReference<V> weakReference = this.f13125r;
        if (weakReference == null || (v5 = weakReference.get()) == null) {
            return;
        }
        f0(v5);
        Iterator<g> it = this.f13131x.iterator();
        while (it.hasNext()) {
            it.next().a(v5, i5);
        }
        d0();
    }

    boolean Z(View view, float f5) {
        return this.f13108a.m(view, f5);
    }

    public boolean b0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.f13125r = null;
        this.f13118k = null;
        this.f13129v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f13125r = null;
        this.f13118k = null;
        this.f13129v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        J.c cVar;
        if (!a0(v5)) {
            this.f13119l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Q();
        }
        if (this.f13128u == null) {
            this.f13128u = VelocityTracker.obtain();
        }
        this.f13128u.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f13130w = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f13119l) {
            this.f13119l = false;
            return false;
        }
        return (this.f13119l || (cVar = this.f13118k) == null || !cVar.G(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v5, int i5) {
        if (coordinatorLayout.getFitsSystemWindows() && !v5.getFitsSystemWindows()) {
            v5.setFitsSystemWindows(true);
        }
        if (this.f13125r == null) {
            this.f13125r = new WeakReference<>(v5);
            this.f13129v = new o1.d(v5);
            C1115h c1115h = this.f13110c;
            if (c1115h != null) {
                v5.setBackground(c1115h);
                C1115h c1115h2 = this.f13110c;
                float elevation = this.f13114g;
                if (elevation == -1.0f) {
                    elevation = v5.getElevation();
                }
                c1115h2.f0(elevation);
            } else {
                ColorStateList colorStateList = this.f13111d;
                if (colorStateList != null) {
                    H.p0(v5, colorStateList);
                }
            }
            f0(v5);
            d0();
            if (v5.getImportantForAccessibility() == 0) {
                v5.setImportantForAccessibility(1);
            }
            u(v5);
        }
        V(v5, i5);
        if (this.f13118k == null) {
            this.f13118k = J.c.m(coordinatorLayout, this.f13132y);
        }
        int iG = this.f13108a.g(v5);
        coordinatorLayout.W(v5, i5);
        this.f13122o = coordinatorLayout.getWidth();
        this.f13123p = this.f13108a.h(coordinatorLayout);
        this.f13121n = v5.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v5.getLayoutParams();
        this.f13124q = marginLayoutParams != null ? this.f13108a.a(marginLayoutParams) : 0;
        H.U(v5, n(iG, v5));
        O(coordinatorLayout);
        for (g gVar : this.f13131x) {
            if (gVar instanceof g) {
                gVar.c(v5);
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v5, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v5.getLayoutParams();
        v5.measure(v(i5, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, -1, marginLayoutParams.width), v(i7, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, -1, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v5, Parcelable parcelable) {
        b bVar = (b) parcelable;
        if (bVar.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, v5, bVar.getSuperState());
        }
        int i5 = bVar.f13134a;
        if (i5 == 1 || i5 == 2) {
            i5 = 5;
        }
        this.f13116i = i5;
        this.f13117j = i5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v5) {
        return new b(super.onSaveInstanceState(coordinatorLayout, v5), (SideSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        if (!v5.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f13116i == 1 && actionMasked == 0) {
            return true;
        }
        if (Y()) {
            this.f13118k.z(motionEvent);
        }
        if (actionMasked == 0) {
            Q();
        }
        if (this.f13128u == null) {
            this.f13128u = VelocityTracker.obtain();
        }
        this.f13128u.addMovement(motionEvent);
        if (Y() && actionMasked == 2 && !this.f13119l && K(motionEvent)) {
            this.f13118k.b(v5, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f13119l;
    }

    int w() {
        return this.f13121n;
    }

    public View x() {
        WeakReference<View> weakReference = this.f13126s;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int y() {
        return this.f13108a.c();
    }

    public float z() {
        return this.f13120m;
    }

    protected static class b extends androidx.customview.view.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        final int f13134a;

        class a implements Parcelable.ClassLoaderCreator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i5) {
                return new b[i5];
            }
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13134a = parcel.readInt();
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f13134a);
        }

        public b(Parcelable parcelable, SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.f13134a = ((SideSheetBehavior) sideSheetBehavior).f13116i;
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13113f = new c();
        this.f13115h = true;
        this.f13116i = 5;
        this.f13117j = 5;
        this.f13120m = 0.1f;
        this.f13127t = -1;
        this.f13131x = new LinkedHashSet();
        this.f13132y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7155j4);
        int i5 = C0418k.f7167l4;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            this.f13111d = C0981c.a(context, typedArrayObtainStyledAttributes, i5);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C0418k.f7185o4)) {
            this.f13112e = l.e(context, attributeSet, 0, f13106A).m();
        }
        int i6 = C0418k.f7179n4;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            S(typedArrayObtainStyledAttributes.getResourceId(i6, -1));
        }
        s(context);
        this.f13114g = typedArrayObtainStyledAttributes.getDimension(C0418k.f7161k4, -1.0f);
        T(typedArrayObtainStyledAttributes.getBoolean(C0418k.f7173m4, true));
        typedArrayObtainStyledAttributes.recycle();
        this.f13109b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
