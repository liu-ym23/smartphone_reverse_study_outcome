package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.stepos.stepclaw.R;
import e0.a0;
import e0.x;
import f0.c;
import f0.p;
import i0.e;
import i1.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k4.v;
import m0.f;
import t.a;
import t.d;
import t1.j;
import t1.m;
import t1.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends a {

    /* renamed from: a, reason: collision with root package name */
    public v f1325a;

    /* renamed from: b, reason: collision with root package name */
    public final j f1326b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f1327c;
    public final n d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.fragment.app.a f1328e;

    /* renamed from: f, reason: collision with root package name */
    public final float f1329f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1330g;

    /* renamed from: h, reason: collision with root package name */
    public int f1331h;

    /* renamed from: i, reason: collision with root package name */
    public e f1332i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1333j;

    /* renamed from: k, reason: collision with root package name */
    public final float f1334k;

    /* renamed from: l, reason: collision with root package name */
    public int f1335l;

    /* renamed from: m, reason: collision with root package name */
    public int f1336m;

    /* renamed from: n, reason: collision with root package name */
    public int f1337n;

    /* renamed from: o, reason: collision with root package name */
    public int f1338o;

    /* renamed from: p, reason: collision with root package name */
    public WeakReference f1339p;

    /* renamed from: q, reason: collision with root package name */
    public WeakReference f1340q;

    /* renamed from: r, reason: collision with root package name */
    public final int f1341r;

    /* renamed from: s, reason: collision with root package name */
    public VelocityTracker f1342s;

    /* renamed from: t, reason: collision with root package name */
    public int f1343t;

    /* renamed from: u, reason: collision with root package name */
    public final LinkedHashSet f1344u;

    /* renamed from: v, reason: collision with root package name */
    public final b f1345v;

    public SideSheetBehavior() {
        this.f1328e = new androidx.fragment.app.a(this);
        this.f1330g = true;
        this.f1331h = 5;
        this.f1334k = 0.1f;
        this.f1341r = -1;
        this.f1344u = new LinkedHashSet();
        this.f1345v = new b(this, 1);
    }

    @Override // t.a
    public final void c(d dVar) {
        this.f1339p = null;
        this.f1332i = null;
    }

    @Override // t.a
    public final void e() {
        this.f1339p = null;
        this.f1332i = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    @Override // t.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.MotionEvent r5) {
        /*
            r2 = this;
            boolean r3 = r4.isShown()
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L10
            int[] r3 = e0.a0.f2285a
            java.lang.CharSequence r3 = e0.x.a(r4)
            if (r3 == 0) goto L59
        L10:
            boolean r3 = r2.f1330g
            if (r3 == 0) goto L59
            int r3 = r5.getActionMasked()
            if (r3 != 0) goto L24
            android.view.VelocityTracker r4 = r2.f1342s
            if (r4 == 0) goto L24
            r4.recycle()
            r4 = 0
            r2.f1342s = r4
        L24:
            android.view.VelocityTracker r4 = r2.f1342s
            if (r4 != 0) goto L2e
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r2.f1342s = r4
        L2e:
            android.view.VelocityTracker r4 = r2.f1342s
            r4.addMovement(r5)
            if (r3 == 0) goto L42
            if (r3 == r0) goto L3b
            r4 = 3
            if (r3 == r4) goto L3b
            goto L49
        L3b:
            boolean r3 = r2.f1333j
            if (r3 == 0) goto L49
            r2.f1333j = r1
            return r1
        L42:
            float r3 = r5.getX()
            int r3 = (int) r3
            r2.f1343t = r3
        L49:
            boolean r3 = r2.f1333j
            if (r3 != 0) goto L58
            i0.e r2 = r2.f1332i
            if (r2 == 0) goto L58
            boolean r2 = r2.p(r5)
            if (r2 == 0) goto L58
            return r0
        L58:
            return r1
        L59:
            r2.f1333j = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.f(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // t.a
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i8) throws Resources.NotFoundException {
        View view2;
        View view3;
        int i9;
        View viewFindViewById;
        int i10 = 1;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        WeakReference weakReference = this.f1339p;
        j jVar = this.f1326b;
        int iN = 0;
        if (weakReference == null) {
            this.f1339p = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            v.g0(context, R.attr.motionDurationMedium2, 300);
            v.g0(context, R.attr.motionDurationShort3, 150);
            v.g0(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
            if (jVar != null) {
                view.setBackground(jVar);
                float elevation = this.f1329f;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                jVar.l(elevation);
            } else {
                ColorStateList colorStateList = this.f1327c;
                if (colorStateList != null) {
                    int[] iArr = a0.f2285a;
                    view.setBackgroundTintList(colorStateList);
                }
            }
            int i11 = this.f1331h == 5 ? 4 : 0;
            if (view.getVisibility() != i11) {
                view.setVisibility(i11);
            }
            u();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            int[] iArr2 = a0.f2285a;
            if (x.a(view) == null) {
                a0.f(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i12 = Gravity.getAbsoluteGravity(((d) view.getLayoutParams()).f5391c, i8) == 3 ? 1 : 0;
        v vVar = this.f1325a;
        if (vVar == null || vVar.Q() != i12) {
            d dVar = null;
            n nVar = this.d;
            if (i12 == 0) {
                this.f1325a = new u1.a(this, i10);
                if (nVar != null) {
                    WeakReference weakReference2 = this.f1339p;
                    if (weakReference2 != null && (view3 = (View) weakReference2.get()) != null && (view3.getLayoutParams() instanceof d)) {
                        dVar = (d) view3.getLayoutParams();
                    }
                    if (dVar == null || ((ViewGroup.MarginLayoutParams) dVar).rightMargin <= 0) {
                        m mVarF = nVar.f();
                        mVarF.f5501f = new t1.a(0.0f);
                        mVarF.f5502g = new t1.a(0.0f);
                        n nVarA = mVarF.a();
                        if (jVar != null) {
                            jVar.setShapeAppearanceModel(nVarA);
                        }
                    }
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalArgumentException(a8.b.k(i12, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.f1325a = new u1.a(this, iN);
                if (nVar != null) {
                    WeakReference weakReference3 = this.f1339p;
                    if (weakReference3 != null && (view2 = (View) weakReference3.get()) != null && (view2.getLayoutParams() instanceof d)) {
                        dVar = (d) view2.getLayoutParams();
                    }
                    if (dVar == null || ((ViewGroup.MarginLayoutParams) dVar).leftMargin <= 0) {
                        m mVarF2 = nVar.f();
                        mVarF2.f5500e = new t1.a(0.0f);
                        mVarF2.f5503h = new t1.a(0.0f);
                        n nVarA2 = mVarF2.a();
                        if (jVar != null) {
                            jVar.setShapeAppearanceModel(nVarA2);
                        }
                    }
                }
            }
        }
        if (this.f1332i == null) {
            this.f1332i = new e(coordinatorLayout.getContext(), coordinatorLayout, this.f1345v);
        }
        int iN2 = this.f1325a.N(view);
        coordinatorLayout.q(view, i8);
        this.f1336m = coordinatorLayout.getWidth();
        this.f1337n = this.f1325a.O(coordinatorLayout);
        this.f1335l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f1338o = marginLayoutParams != null ? this.f1325a.f(marginLayoutParams) : 0;
        int i13 = this.f1331h;
        if (i13 == 1 || i13 == 2) {
            iN = iN2 - this.f1325a.N(view);
        } else if (i13 != 3) {
            if (i13 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.f1331h);
            }
            iN = this.f1325a.H();
        }
        int[] iArr3 = a0.f2285a;
        view.offsetLeftAndRight(iN);
        if (this.f1340q == null && (i9 = this.f1341r) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i9)) != null) {
            this.f1340q = new WeakReference(viewFindViewById);
        }
        Iterator it = this.f1344u.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // t.a
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i8, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i9, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i10, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // t.a
    public final void m(View view, Parcelable parcelable) {
        int i8 = ((u1.d) parcelable).f5623c;
        if (i8 == 1 || i8 == 2) {
            i8 = 5;
        }
        this.f1331h = i8;
    }

    @Override // t.a
    public final Parcelable n(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new u1.d(this);
    }

    @Override // t.a
    public final boolean q(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f1331h == 1 && actionMasked == 0) {
            return true;
        }
        if (s()) {
            this.f1332i.j(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f1342s) != null) {
            velocityTracker.recycle();
            this.f1342s = null;
        }
        if (this.f1342s == null) {
            this.f1342s = VelocityTracker.obtain();
        }
        this.f1342s.addMovement(motionEvent);
        if (s() && actionMasked == 2 && !this.f1333j && s()) {
            float fAbs = Math.abs(this.f1343t - motionEvent.getX());
            e eVar = this.f1332i;
            if (fAbs > eVar.f3108b) {
                eVar.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f1333j;
    }

    public final void r(int i8) {
        View view;
        if (this.f1331h == i8) {
            return;
        }
        this.f1331h = i8;
        WeakReference weakReference = this.f1339p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i9 = this.f1331h == 5 ? 4 : 0;
        if (view.getVisibility() != i9) {
            view.setVisibility(i9);
        }
        Iterator it = this.f1344u.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        u();
    }

    public final boolean s() {
        if (this.f1332i != null) {
            return this.f1330g || this.f1331h == 1;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r1.o(r0, r3.getTop()) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        r(2);
        r2.f1328e.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            r0 = 3
            if (r4 == r0) goto L19
            r0 = 5
            if (r4 != r0) goto Ld
            k4.v r0 = r2.f1325a
            int r0 = r0.H()
            goto L1f
        Ld:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid state to get outer edge offset: "
            java.lang.String r3 = a8.b.j(r4, r3)
            r2.<init>(r3)
            throw r2
        L19:
            k4.v r0 = r2.f1325a
            int r0 = r0.G()
        L1f:
            i0.e r1 = r2.f1332i
            if (r1 == 0) goto L57
            if (r5 == 0) goto L30
            int r3 = r3.getTop()
            boolean r3 = r1.o(r0, r3)
            if (r3 == 0) goto L57
            goto L4d
        L30:
            int r5 = r3.getTop()
            r1.f3123r = r3
            r3 = -1
            r1.f3109c = r3
            r3 = 0
            boolean r3 = r1.h(r0, r5, r3, r3)
            if (r3 != 0) goto L4b
            int r5 = r1.f3107a
            if (r5 != 0) goto L4b
            android.view.View r5 = r1.f3123r
            if (r5 == 0) goto L4b
            r5 = 0
            r1.f3123r = r5
        L4b:
            if (r3 == 0) goto L57
        L4d:
            r3 = 2
            r2.r(r3)
            androidx.fragment.app.a r2 = r2.f1328e
            r2.a(r4)
            return
        L57:
            r2.r(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.t(android.view.View, int, boolean):void");
    }

    public final void u() {
        View view;
        WeakReference weakReference = this.f1339p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        a0.c(view, 262144);
        a0.b(view, 0);
        a0.c(view, 1048576);
        a0.b(view, 0);
        final int i8 = 5;
        if (this.f1331h != 5) {
            a0.d(view, c.f2536j, new p() { // from class: u1.b
                @Override // f0.p
                public final boolean c(View view2) {
                    int i9 = i8;
                    if (i9 == 1 || i9 == 2) {
                        throw new IllegalArgumentException(f.f(new StringBuilder("STATE_"), i9 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
                    }
                    SideSheetBehavior sideSheetBehavior = this.f5618a;
                    WeakReference weakReference2 = sideSheetBehavior.f1339p;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        sideSheetBehavior.r(i9);
                        return true;
                    }
                    View view3 = (View) sideSheetBehavior.f1339p.get();
                    c cVar = new c(sideSheetBehavior, i9, 0);
                    ViewParent parent = view3.getParent();
                    if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                        view3.post(cVar);
                        return true;
                    }
                    cVar.run();
                    return true;
                }
            });
        }
        final int i9 = 3;
        if (this.f1331h != 3) {
            a0.d(view, c.f2534h, new p() { // from class: u1.b
                @Override // f0.p
                public final boolean c(View view2) {
                    int i92 = i9;
                    if (i92 == 1 || i92 == 2) {
                        throw new IllegalArgumentException(f.f(new StringBuilder("STATE_"), i92 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
                    }
                    SideSheetBehavior sideSheetBehavior = this.f5618a;
                    WeakReference weakReference2 = sideSheetBehavior.f1339p;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        sideSheetBehavior.r(i92);
                        return true;
                    }
                    View view3 = (View) sideSheetBehavior.f1339p.get();
                    c cVar = new c(sideSheetBehavior, i92, 0);
                    ViewParent parent = view3.getParent();
                    if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                        view3.post(cVar);
                        return true;
                    }
                    cVar.run();
                    return true;
                }
            });
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.f1328e = new androidx.fragment.app.a(this);
        this.f1330g = true;
        this.f1331h = 5;
        this.f1334k = 0.1f;
        this.f1341r = -1;
        this.f1344u = new LinkedHashSet();
        this.f1345v = new b(this, 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.a.f1778t);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f1327c = v.D(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.d = n.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.f1341r = resourceId;
            WeakReference weakReference = this.f1340q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f1340q = null;
            WeakReference weakReference2 = this.f1339p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        n nVar = this.d;
        if (nVar != null) {
            j jVar = new j(nVar);
            this.f1326b = jVar;
            jVar.j(context);
            ColorStateList colorStateList = this.f1327c;
            if (colorStateList != null) {
                this.f1326b.m(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f1326b.setTint(typedValue.data);
            }
        }
        this.f1329f = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.f1330g = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
