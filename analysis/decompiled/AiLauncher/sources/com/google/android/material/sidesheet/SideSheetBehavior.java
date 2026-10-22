package com.google.android.material.sidesheet;

import C0.c;
import C0.f;
import H0.c;
import Z2.l;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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
import androidx.core.view.N;
import androidx.customview.view.AbsSavedState;
import b.C1423c;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.sidesheet.SideSheetBehavior;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import w0.C5715a;

/* loaded from: classes2.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c<V> implements T2.b {

    /* renamed from: a, reason: collision with root package name */
    public d f21265a;

    /* renamed from: b, reason: collision with root package name */
    public float f21266b;

    /* renamed from: c, reason: collision with root package name */
    public Z2.h f21267c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f21268d;

    /* renamed from: e, reason: collision with root package name */
    public l f21269e;

    /* renamed from: f, reason: collision with root package name */
    public final SideSheetBehavior<V>.c f21270f;

    /* renamed from: g, reason: collision with root package name */
    public float f21271g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21272h;

    /* renamed from: i, reason: collision with root package name */
    public int f21273i;

    /* renamed from: j, reason: collision with root package name */
    public int f21274j;

    /* renamed from: k, reason: collision with root package name */
    public H0.c f21275k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f21276l;

    /* renamed from: m, reason: collision with root package name */
    public float f21277m;

    /* renamed from: n, reason: collision with root package name */
    public int f21278n;

    /* renamed from: o, reason: collision with root package name */
    public int f21279o;

    /* renamed from: p, reason: collision with root package name */
    public int f21280p;

    /* renamed from: q, reason: collision with root package name */
    public int f21281q;

    /* renamed from: r, reason: collision with root package name */
    public WeakReference<V> f21282r;

    /* renamed from: s, reason: collision with root package name */
    public WeakReference<View> f21283s;

    /* renamed from: t, reason: collision with root package name */
    public int f21284t;

    /* renamed from: u, reason: collision with root package name */
    public VelocityTracker f21285u;

    /* renamed from: v, reason: collision with root package name */
    public T2.g f21286v;

    /* renamed from: w, reason: collision with root package name */
    public int f21287w;

    /* renamed from: x, reason: collision with root package name */
    public final Set<j> f21288x;

    /* renamed from: y, reason: collision with root package name */
    public final c.AbstractC0044c f21289y;

    /* renamed from: z, reason: collision with root package name */
    public static final int f21264z = R$string.side_sheet_accessibility_pane_title;

    /* renamed from: A, reason: collision with root package name */
    public static final int f21263A = R$style.Widget_Material3_SideSheet;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final int state;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.state);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.state = sideSheetBehavior.f21273i;
        }
    }

    public class a extends c.AbstractC0044c {
        public a() {
        }

        @Override // H0.c.AbstractC0044c
        public int a(View view, int i10, int i11) {
            return C5715a.b(i10, SideSheetBehavior.this.f21265a.g(), SideSheetBehavior.this.f21265a.f());
        }

        @Override // H0.c.AbstractC0044c
        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // H0.c.AbstractC0044c
        public int d(View view) {
            return SideSheetBehavior.this.f21278n + SideSheetBehavior.this.I();
        }

        @Override // H0.c.AbstractC0044c
        public void j(int i10) {
            if (i10 == 1 && SideSheetBehavior.this.f21272h) {
                SideSheetBehavior.this.e0(1);
            }
        }

        @Override // H0.c.AbstractC0044c
        public void k(View view, int i10, int i11, int i12, int i13) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View viewD = SideSheetBehavior.this.D();
            if (viewD != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewD.getLayoutParams()) != null) {
                SideSheetBehavior.this.f21265a.p(marginLayoutParams, view.getLeft(), view.getRight());
                viewD.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.y(view, i10);
        }

        @Override // H0.c.AbstractC0044c
        public void l(View view, float f10, float f11) {
            int iU = SideSheetBehavior.this.u(view, f10, f11);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.j0(view, iU, sideSheetBehavior.i0());
        }

        @Override // H0.c.AbstractC0044c
        public boolean m(View view, int i10) {
            return (SideSheetBehavior.this.f21273i == 1 || SideSheetBehavior.this.f21282r == null || SideSheetBehavior.this.f21282r.get() != view) ? false : true;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.e0(5);
            if (SideSheetBehavior.this.f21282r == null || SideSheetBehavior.this.f21282r.get() == null) {
                return;
            }
            ((View) SideSheetBehavior.this.f21282r.get()).requestLayout();
        }
    }

    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f21292a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f21293b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f21294c = new Runnable() { // from class: com.google.android.material.sidesheet.i
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.c.a(this.f21306a);
            }
        };

        public c() {
        }

        public static /* synthetic */ void a(c cVar) {
            cVar.f21293b = false;
            if (SideSheetBehavior.this.f21275k != null && SideSheetBehavior.this.f21275k.m(true)) {
                cVar.b(cVar.f21292a);
            } else if (SideSheetBehavior.this.f21273i == 2) {
                SideSheetBehavior.this.e0(cVar.f21292a);
            }
        }

        public void b(int i10) {
            if (SideSheetBehavior.this.f21282r == null || SideSheetBehavior.this.f21282r.get() == null) {
                return;
            }
            this.f21292a = i10;
            if (this.f21293b) {
                return;
            }
            ((View) SideSheetBehavior.this.f21282r.get()).postOnAnimation(this.f21294c);
            this.f21293b = true;
        }
    }

    public SideSheetBehavior() {
        this.f21270f = new c();
        this.f21272h = true;
        this.f21273i = 5;
        this.f21274j = 5;
        this.f21277m = 0.1f;
        this.f21284t = -1;
        this.f21288x = new LinkedHashSet();
        this.f21289y = new a();
    }

    private int A(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    private void W(V v10, c.a aVar, int i10) {
        N.d0(v10, aVar, null, w(i10));
    }

    private void Y(V v10, Runnable runnable) {
        if (T(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    private boolean f0() {
        if (this.f21275k != null) {
            return this.f21272h || this.f21273i == 1;
        }
        return false;
    }

    public static /* synthetic */ boolean g(SideSheetBehavior sideSheetBehavior, int i10, View view, f.a aVar) {
        sideSheetBehavior.d0(i10);
        return true;
    }

    public static /* synthetic */ void h(SideSheetBehavior sideSheetBehavior, int i10) {
        V v10 = sideSheetBehavior.f21282r.get();
        if (v10 != null) {
            sideSheetBehavior.j0(v10, i10, false);
        }
    }

    public static /* synthetic */ void i(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i10, View view, ValueAnimator valueAnimator) {
        sideSheetBehavior.f21265a.o(marginLayoutParams, E2.a.c(i10, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(View view, int i10, boolean z10) {
        if (!U(view, i10, z10)) {
            e0(i10);
        } else {
            e0(2);
            this.f21270f.b(i10);
        }
    }

    private void k0() {
        V v10;
        WeakReference<V> weakReference = this.f21282r;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        N.b0(v10, SQLiteDatabase.OPEN_PRIVATECACHE);
        N.b0(v10, 1048576);
        if (this.f21273i != 5) {
            W(v10, c.a.f1670y, 5);
        }
        if (this.f21273i != 3) {
            W(v10, c.a.f1668w, 3);
        }
    }

    private C0.f w(final int i10) {
        return new C0.f() { // from class: com.google.android.material.sidesheet.g
            @Override // C0.f
            public final boolean a(View view, f.a aVar) {
                return SideSheetBehavior.g(this.f21300a, i10, view, aVar);
            }
        };
    }

    private void x(Context context) {
        if (this.f21269e == null) {
            return;
        }
        Z2.h hVar = new Z2.h(this.f21269e);
        this.f21267c = hVar;
        hVar.U(context);
        ColorStateList colorStateList = this.f21268d;
        if (colorStateList != null) {
            this.f21267c.g0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f21267c.setTint(typedValue.data);
    }

    public int B() {
        return this.f21278n;
    }

    public final ValueAnimator.AnimatorUpdateListener C() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View viewD = D();
        if (viewD == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewD.getLayoutParams()) == null) {
            return null;
        }
        final int iC = this.f21265a.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.sidesheet.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SideSheetBehavior.i(this.f21302a, marginLayoutParams, iC, viewD, valueAnimator);
            }
        };
    }

    public View D() {
        WeakReference<View> weakReference = this.f21283s;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int E() {
        return this.f21265a.d();
    }

    public final int F() {
        d dVar = this.f21265a;
        return (dVar == null || dVar.j() == 0) ? 5 : 3;
    }

    public float G() {
        return this.f21277m;
    }

    public float H() {
        return 0.5f;
    }

    public int I() {
        return this.f21281q;
    }

    public int J(int i10) {
        if (i10 == 3) {
            return E();
        }
        if (i10 == 5) {
            return this.f21265a.e();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i10);
    }

    public int K() {
        return this.f21280p;
    }

    public int L() {
        return this.f21279o;
    }

    public int M() {
        return 500;
    }

    public H0.c N() {
        return this.f21275k;
    }

    public final CoordinatorLayout.f O() {
        V v10;
        WeakReference<V> weakReference = this.f21282r;
        if (weakReference == null || (v10 = weakReference.get()) == null || !(v10.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return null;
        }
        return (CoordinatorLayout.f) v10.getLayoutParams();
    }

    public final boolean P() {
        CoordinatorLayout.f fVarO = O();
        return fVarO != null && ((ViewGroup.MarginLayoutParams) fVarO).leftMargin > 0;
    }

    public final boolean Q() {
        CoordinatorLayout.f fVarO = O();
        return fVarO != null && ((ViewGroup.MarginLayoutParams) fVarO).rightMargin > 0;
    }

    public final boolean R(MotionEvent motionEvent) {
        return f0() && t((float) this.f21287w, motionEvent.getX()) > ((float) this.f21275k.z());
    }

    public final boolean S(float f10) {
        return this.f21265a.k(f10);
    }

    public final boolean T(V v10) {
        ViewParent parent = v10.getParent();
        return parent != null && parent.isLayoutRequested() && v10.isAttachedToWindow();
    }

    public final boolean U(View view, int i10, boolean z10) {
        int iJ = J(i10);
        H0.c cVarN = N();
        if (cVarN != null) {
            return z10 ? cVarN.O(iJ, view.getTop()) : cVarN.Q(view, iJ, view.getTop());
        }
        return false;
    }

    public final void V(CoordinatorLayout coordinatorLayout) {
        int i10;
        View viewFindViewById;
        if (this.f21283s != null || (i10 = this.f21284t) == -1 || (viewFindViewById = coordinatorLayout.findViewById(i10)) == null) {
            return;
        }
        this.f21283s = new WeakReference<>(viewFindViewById);
    }

    public final void X() {
        VelocityTracker velocityTracker = this.f21285u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f21285u = null;
        }
    }

    public void Z(int i10) {
        this.f21284t = i10;
        v();
        WeakReference<V> weakReference = this.f21282r;
        if (weakReference != null) {
            V v10 = weakReference.get();
            if (i10 == -1 || !v10.isLaidOut()) {
                return;
            }
            v10.requestLayout();
        }
    }

    public void a0(boolean z10) {
        this.f21272h = z10;
    }

    @Override // T2.b
    public void b(C1423c c1423c) {
        T2.g gVar = this.f21286v;
        if (gVar == null) {
            return;
        }
        gVar.j(c1423c);
    }

    public final void b0(int i10) {
        d dVar = this.f21265a;
        if (dVar == null || dVar.j() != i10) {
            if (i10 == 0) {
                this.f21265a = new com.google.android.material.sidesheet.b(this);
                if (this.f21269e == null || Q()) {
                    return;
                }
                l.b bVarW = this.f21269e.w();
                bVarW.G(0.0f).y(0.0f);
                m0(bVarW.m());
                return;
            }
            if (i10 == 1) {
                this.f21265a = new com.google.android.material.sidesheet.a(this);
                if (this.f21269e == null || P()) {
                    return;
                }
                l.b bVarW2 = this.f21269e.w();
                bVarW2.C(0.0f).u(0.0f);
                m0(bVarW2.m());
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i10 + ". Must be 0 or 1.");
        }
    }

    public final void c0(V v10, int i10) {
        b0(Gravity.getAbsoluteGravity(((CoordinatorLayout.f) v10.getLayoutParams()).f12909c, i10) == 3 ? 1 : 0);
    }

    @Override // T2.b
    public void d() {
        T2.g gVar = this.f21286v;
        if (gVar == null) {
            return;
        }
        gVar.f();
    }

    public void d0(final int i10) {
        if (i10 == 1 || i10 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            sb2.append(i10 == 1 ? "DRAGGING" : "SETTLING");
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        }
        WeakReference<V> weakReference = this.f21282r;
        if (weakReference == null || weakReference.get() == null) {
            e0(i10);
        } else {
            Y(this.f21282r.get(), new Runnable() { // from class: com.google.android.material.sidesheet.f
                @Override // java.lang.Runnable
                public final void run() {
                    SideSheetBehavior.h(this.f21298a, i10);
                }
            });
        }
    }

    @Override // T2.b
    public void e(C1423c c1423c) {
        T2.g gVar = this.f21286v;
        if (gVar == null) {
            return;
        }
        gVar.l(c1423c, F());
        l0();
    }

    public void e0(int i10) {
        V v10;
        if (this.f21273i == i10) {
            return;
        }
        this.f21273i = i10;
        if (i10 == 3 || i10 == 5) {
            this.f21274j = i10;
        }
        WeakReference<V> weakReference = this.f21282r;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        n0(v10);
        Iterator<j> it = this.f21288x.iterator();
        while (it.hasNext()) {
            it.next().a(v10, i10);
        }
        k0();
    }

    @Override // T2.b
    public void f() {
        T2.g gVar = this.f21286v;
        if (gVar == null) {
            return;
        }
        C1423c c1423cC = gVar.c();
        if (c1423cC != null) {
            this.f21286v.h(c1423cC, F(), new b(), C());
        } else {
            d0(5);
        }
    }

    public boolean g0(View view, float f10) {
        return this.f21265a.n(view, f10);
    }

    public final boolean h0(V v10) {
        return (v10.isShown() || N.k(v10) != null) && this.f21272h;
    }

    public boolean i0() {
        return true;
    }

    public final void l0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference<V> weakReference = this.f21282r;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        V v10 = this.f21282r.get();
        View viewD = D();
        if (viewD == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewD.getLayoutParams()) == null) {
            return;
        }
        this.f21265a.o(marginLayoutParams, (int) ((this.f21278n * v10.getScaleX()) + this.f21281q));
        viewD.requestLayout();
    }

    public final void m0(l lVar) {
        Z2.h hVar = this.f21267c;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(lVar);
        }
    }

    public final void n0(View view) {
        int i10 = this.f21273i == 5 ? 4 : 0;
        if (view.getVisibility() != i10) {
            view.setVisibility(i10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.f21282r = null;
        this.f21275k = null;
        this.f21286v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f21282r = null;
        this.f21275k = null;
        this.f21286v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        H0.c cVar;
        if (!h0(v10)) {
            this.f21276l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            X();
        }
        if (this.f21285u == null) {
            this.f21285u = VelocityTracker.obtain();
        }
        this.f21285u.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f21287w = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f21276l) {
            this.f21276l = false;
            return false;
        }
        return (this.f21276l || (cVar = this.f21275k) == null || !cVar.P(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        if (coordinatorLayout.getFitsSystemWindows() && !v10.getFitsSystemWindows()) {
            v10.setFitsSystemWindows(true);
        }
        if (this.f21282r == null) {
            this.f21282r = new WeakReference<>(v10);
            this.f21286v = new T2.g(v10);
            Z2.h hVar = this.f21267c;
            if (hVar != null) {
                v10.setBackground(hVar);
                Z2.h hVar2 = this.f21267c;
                float elevation = this.f21271g;
                if (elevation == -1.0f) {
                    elevation = v10.getElevation();
                }
                hVar2.f0(elevation);
            } else {
                ColorStateList colorStateList = this.f21268d;
                if (colorStateList != null) {
                    N.n0(v10, colorStateList);
                }
            }
            n0(v10);
            k0();
            if (v10.getImportantForAccessibility() == 0) {
                v10.setImportantForAccessibility(1);
            }
            z(v10);
        }
        c0(v10, i10);
        if (this.f21275k == null) {
            this.f21275k = H0.c.o(coordinatorLayout, this.f21289y);
        }
        int iH = this.f21265a.h(v10);
        coordinatorLayout.Q(v10, i10);
        this.f21279o = coordinatorLayout.getWidth();
        this.f21280p = this.f21265a.i(coordinatorLayout);
        this.f21278n = v10.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        this.f21281q = marginLayoutParams != null ? this.f21265a.a(marginLayoutParams) : 0;
        N.S(v10, s(iH, v10));
        V(coordinatorLayout);
        for (j jVar : this.f21288x) {
            if (jVar instanceof j) {
                jVar.c(v10);
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(A(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, -1, marginLayoutParams.width), A(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, -1, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, v10, savedState.getSuperState());
        }
        int i10 = savedState.state;
        if (i10 == 1 || i10 == 2) {
            i10 = 5;
        }
        this.f21273i = i10;
        this.f21274j = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v10), (SideSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f21273i == 1 && actionMasked == 0) {
            return true;
        }
        if (f0()) {
            this.f21275k.F(motionEvent);
        }
        if (actionMasked == 0) {
            X();
        }
        if (this.f21285u == null) {
            this.f21285u = VelocityTracker.obtain();
        }
        this.f21285u.addMovement(motionEvent);
        if (f0() && actionMasked == 2 && !this.f21276l && R(motionEvent)) {
            this.f21275k.b(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f21276l;
    }

    public final int s(int i10, V v10) {
        int i11 = this.f21273i;
        if (i11 == 1 || i11 == 2) {
            return i10 - this.f21265a.h(v10);
        }
        if (i11 == 3) {
            return 0;
        }
        if (i11 == 5) {
            return this.f21265a.e();
        }
        throw new IllegalStateException("Unexpected value: " + this.f21273i);
    }

    public final float t(float f10, float f11) {
        return Math.abs(f10 - f11);
    }

    public final int u(View view, float f10, float f11) {
        if (S(f10)) {
            return 3;
        }
        if (g0(view, f10)) {
            return (this.f21265a.m(f10, f11) || this.f21265a.l(view)) ? 5 : 3;
        }
        if (f10 != 0.0f && e.a(f10, f11)) {
            return 5;
        }
        int left = view.getLeft();
        return Math.abs(left - E()) < Math.abs(left - this.f21265a.e()) ? 3 : 5;
    }

    public final void v() {
        WeakReference<View> weakReference = this.f21283s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f21283s = null;
    }

    public final void y(View view, int i10) {
        if (this.f21288x.isEmpty()) {
            return;
        }
        float fB = this.f21265a.b(i10);
        Iterator<j> it = this.f21288x.iterator();
        while (it.hasNext()) {
            it.next().b(view, fB);
        }
    }

    public final void z(View view) {
        if (N.k(view) == null) {
            N.k0(view, view.getResources().getString(f21264z));
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21270f = new c();
        this.f21272h = true;
        this.f21273i = 5;
        this.f21274j = 5;
        this.f21277m = 0.1f;
        this.f21284t = -1;
        this.f21288x = new LinkedHashSet();
        this.f21289y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SideSheetBehavior_Layout);
        int i10 = R$styleable.SideSheetBehavior_Layout_backgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.f21268d = W2.c.a(context, typedArrayObtainStyledAttributes, i10);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.f21269e = l.e(context, attributeSet, 0, f21263A).m();
        }
        int i11 = R$styleable.SideSheetBehavior_Layout_coplanarSiblingViewId;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            Z(typedArrayObtainStyledAttributes.getResourceId(i11, -1));
        }
        x(context);
        this.f21271g = typedArrayObtainStyledAttributes.getDimension(R$styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        a0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        typedArrayObtainStyledAttributes.recycle();
        this.f21266b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
