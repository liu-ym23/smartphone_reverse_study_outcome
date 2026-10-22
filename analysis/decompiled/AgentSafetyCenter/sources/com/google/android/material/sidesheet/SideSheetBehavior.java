package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import b3.a;
import com.stepos.agentsafetycenter.R;
import f7.i;
import f7.l;
import f7.m;
import g7.d;
import g7.e;
import g7.f;
import id.k;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import n3.h0;
import n3.k0;
import td.h;
import u3.b;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends a {

    /* renamed from: a, reason: collision with root package name */
    public k f2443a;

    /* renamed from: b, reason: collision with root package name */
    public final i f2444b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f2445c;

    /* renamed from: d, reason: collision with root package name */
    public final m f2446d;

    /* renamed from: e, reason: collision with root package name */
    public final f f2447e;

    /* renamed from: f, reason: collision with root package name */
    public final float f2448f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2449g;

    /* renamed from: h, reason: collision with root package name */
    public int f2450h;
    public b i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2451j;

    /* renamed from: k, reason: collision with root package name */
    public final float f2452k;

    /* renamed from: l, reason: collision with root package name */
    public int f2453l;

    /* renamed from: m, reason: collision with root package name */
    public int f2454m;

    /* renamed from: n, reason: collision with root package name */
    public int f2455n;

    /* renamed from: o, reason: collision with root package name */
    public int f2456o;

    /* renamed from: p, reason: collision with root package name */
    public WeakReference f2457p;

    /* renamed from: q, reason: collision with root package name */
    public WeakReference f2458q;

    /* renamed from: r, reason: collision with root package name */
    public final int f2459r;

    /* renamed from: s, reason: collision with root package name */
    public VelocityTracker f2460s;

    /* renamed from: t, reason: collision with root package name */
    public int f2461t;

    /* renamed from: u, reason: collision with root package name */
    public final LinkedHashSet f2462u;

    /* renamed from: v, reason: collision with root package name */
    public final d f2463v;

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.f2447e = new f(this);
        this.f2449g = true;
        this.f2450h = 5;
        this.f2452k = 0.1f;
        this.f2459r = -1;
        this.f2462u = new LinkedHashSet();
        this.f2463v = new d(this, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p6.a.f9826s);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f2445c = h.s(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.f2446d = m.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.f2459r = resourceId;
            WeakReference weakReference = this.f2458q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f2458q = null;
            WeakReference weakReference2 = this.f2457p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        m mVar = this.f2446d;
        if (mVar != null) {
            i iVar = new i(mVar);
            this.f2444b = iVar;
            iVar.g(context);
            ColorStateList colorStateList = this.f2445c;
            if (colorStateList != null) {
                this.f2444b.j(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f2444b.setTint(typedValue.data);
            }
        }
        this.f2448f = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.f2449g = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final void c(int i) {
        View view;
        if (this.f2450h == i) {
            return;
        }
        this.f2450h = i;
        WeakReference weakReference = this.f2457p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i3 = this.f2450h == 5 ? 4 : 0;
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
        Iterator it = this.f2462u.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
        f();
    }

    public final boolean d() {
        if (this.i != null) {
            return this.f2449g || this.f2450h == 1;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1.p(r0, r3.getTop()) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        c(2);
        r2.f2447e.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            r0 = 3
            if (r4 == r0) goto L17
            r0 = 5
            if (r4 != r0) goto Ld
            id.k r0 = r2.f2443a
            int r0 = r0.x()
            goto L1d
        Ld:
            java.lang.String r2 = "Invalid state to get outer edge offset: "
            java.lang.String r2 = k0.a.j(r4, r2)
            g5.f.s(r2)
            return
        L17:
            id.k r0 = r2.f2443a
            int r0 = r0.w()
        L1d:
            u3.b r1 = r2.i
            if (r1 == 0) goto L55
            if (r5 == 0) goto L2e
            int r3 = r3.getTop()
            boolean r3 = r1.p(r0, r3)
            if (r3 == 0) goto L55
            goto L4b
        L2e:
            int r5 = r3.getTop()
            r1.f14042r = r3
            r3 = -1
            r1.f14028c = r3
            r3 = 0
            boolean r3 = r1.i(r0, r5, r3, r3)
            if (r3 != 0) goto L49
            int r5 = r1.f14026a
            if (r5 != 0) goto L49
            android.view.View r5 = r1.f14042r
            if (r5 == 0) goto L49
            r5 = 0
            r1.f14042r = r5
        L49:
            if (r3 == 0) goto L55
        L4b:
            r3 = 2
            r2.c(r3)
            g7.f r2 = r2.f2447e
            r2.a(r4)
            return
        L55:
            r2.c(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.e(android.view.View, int, boolean):void");
    }

    public final void f() {
        View view;
        WeakReference weakReference = this.f2457p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        k0.e(262144, view);
        k0.c(0, view);
        k0.e(1048576, view);
        k0.c(0, view);
        if (this.f2450h != 5) {
            o3.b bVar = o3.b.f9140k;
            g7.b bVar2 = new g7.b();
            bVar2.f4353c = this;
            bVar2.f4354f = 5;
            VarHandle.storeStoreFence();
            k0.f(view, bVar, bVar2);
        }
        if (this.f2450h != 3) {
            o3.b bVar3 = o3.b.i;
            g7.b bVar4 = new g7.b();
            bVar4.f4353c = this;
            bVar4.f4354f = 3;
            VarHandle.storeStoreFence();
            k0.f(view, bVar3, bVar4);
        }
    }

    @Override // b3.a
    public final void onAttachedToLayoutParams(b3.d dVar) {
        super.onAttachedToLayoutParams(dVar);
        this.f2457p = null;
        this.i = null;
    }

    @Override // b3.a
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f2457p = null;
        this.i = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    @Override // b3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.a r3, android.view.View r4, android.view.MotionEvent r5) {
        /*
            r2 = this;
            boolean r3 = r4.isShown()
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L10
            java.util.WeakHashMap r3 = n3.k0.f8724a
            java.lang.CharSequence r3 = n3.h0.a(r4)
            if (r3 == 0) goto L59
        L10:
            boolean r3 = r2.f2449g
            if (r3 == 0) goto L59
            int r3 = r5.getActionMasked()
            if (r3 != 0) goto L24
            android.view.VelocityTracker r4 = r2.f2460s
            if (r4 == 0) goto L24
            r4.recycle()
            r4 = 0
            r2.f2460s = r4
        L24:
            android.view.VelocityTracker r4 = r2.f2460s
            if (r4 != 0) goto L2e
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r2.f2460s = r4
        L2e:
            android.view.VelocityTracker r4 = r2.f2460s
            r4.addMovement(r5)
            if (r3 == 0) goto L42
            if (r3 == r0) goto L3b
            r4 = 3
            if (r3 == r4) goto L3b
            goto L49
        L3b:
            boolean r3 = r2.f2451j
            if (r3 == 0) goto L49
            r2.f2451j = r1
            return r1
        L42:
            float r3 = r5.getX()
            int r3 = (int) r3
            r2.f2461t = r3
        L49:
            boolean r3 = r2.f2451j
            if (r3 != 0) goto L58
            u3.b r2 = r2.i
            if (r2 == 0) goto L58
            boolean r2 = r2.q(r5)
            if (r2 == 0) goto L58
            return r0
        L58:
            return r1
        L59:
            r2.f2451j = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.a, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // b3.a
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) throws Resources.NotFoundException {
        View view2;
        View view3;
        int iB;
        int i3;
        View viewFindViewById;
        int i10 = 1;
        if (aVar.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        WeakReference weakReference = this.f2457p;
        i iVar = this.f2444b;
        int i11 = 0;
        if (weakReference == null) {
            this.f2457p = new WeakReference(view);
            new b7.a(view);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
            if (iVar != null) {
                view.setBackground(iVar);
                float elevation = this.f2448f;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                iVar.i(elevation);
            } else {
                ColorStateList colorStateList = this.f2445c;
                if (colorStateList != null) {
                    WeakHashMap weakHashMap = k0.f8724a;
                    view.setBackgroundTintList(colorStateList);
                }
            }
            int i12 = this.f2450h == 5 ? 4 : 0;
            if (view.getVisibility() != i12) {
                view.setVisibility(i12);
            }
            f();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            WeakHashMap weakHashMap2 = k0.f8724a;
            if (h0.a(view) == null) {
                k0.h(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i13 = Gravity.getAbsoluteGravity(((b3.d) view.getLayoutParams()).f1879c, i) == 3 ? 1 : 0;
        k kVar = this.f2443a;
        if (kVar == null || kVar.E() != i13) {
            b3.d dVar = null;
            m mVar = this.f2446d;
            if (i13 == 0) {
                g7.a aVar2 = new g7.a(i10);
                aVar2.f4352d = this;
                VarHandle.storeStoreFence();
                this.f2443a = aVar2;
                if (mVar != null) {
                    WeakReference weakReference2 = this.f2457p;
                    if (weakReference2 != null && (view3 = (View) weakReference2.get()) != null && (view3.getLayoutParams() instanceof b3.d)) {
                        dVar = (b3.d) view3.getLayoutParams();
                    }
                    if (dVar == null || ((ViewGroup.MarginLayoutParams) dVar).rightMargin <= 0) {
                        l lVarF = mVar.f();
                        lVarF.f3980f = new f7.a(0.0f);
                        lVarF.f3981g = new f7.a(0.0f);
                        m mVarA = lVarF.a();
                        if (iVar != null) {
                            iVar.setShapeAppearanceModel(mVarA);
                        }
                    }
                }
            } else {
                if (i13 != 1) {
                    g5.f.s(k0.a.k(i13, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                    return false;
                }
                g7.a aVar3 = new g7.a(i11);
                aVar3.f4352d = this;
                VarHandle.storeStoreFence();
                this.f2443a = aVar3;
                if (mVar != null) {
                    WeakReference weakReference3 = this.f2457p;
                    if (weakReference3 != null && (view2 = (View) weakReference3.get()) != null && (view2.getLayoutParams() instanceof b3.d)) {
                        dVar = (b3.d) view2.getLayoutParams();
                    }
                    if (dVar == null || ((ViewGroup.MarginLayoutParams) dVar).leftMargin <= 0) {
                        l lVarF2 = mVar.f();
                        lVarF2.f3979e = new f7.a(0.0f);
                        lVarF2.f3982h = new f7.a(0.0f);
                        m mVarA2 = lVarF2.a();
                        if (iVar != null) {
                            iVar.setShapeAppearanceModel(mVarA2);
                        }
                    }
                }
            }
        }
        if (this.i == null) {
            this.i = b.g(aVar, this.f2463v);
        }
        int iB2 = this.f2443a.B(view);
        aVar.B(i, view);
        this.f2454m = aVar.getWidth();
        this.f2455n = this.f2443a.C(aVar);
        this.f2453l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f2456o = marginLayoutParams != null ? this.f2443a.g(marginLayoutParams) : 0;
        int i14 = this.f2450h;
        if (i14 == 1 || i14 == 2) {
            iB = iB2 - this.f2443a.B(view);
        } else if (i14 == 3) {
            iB = 0;
        } else {
            if (i14 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.f2450h);
            }
            iB = this.f2443a.x();
        }
        WeakHashMap weakHashMap3 = k0.f8724a;
        view.offsetLeftAndRight(iB);
        if (this.f2458q == null && (i3 = this.f2459r) != -1 && (viewFindViewById = aVar.findViewById(i3)) != null) {
            this.f2458q = new WeakReference(viewFindViewById);
        }
        Iterator it = this.f2462u.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                od.f.j();
                return false;
            }
        }
        return true;
    }

    @Override // b3.a
    public final boolean onMeasureChild(androidx.coordinatorlayout.widget.a aVar, View view, int i, int i3, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, aVar.getPaddingRight() + aVar.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i10, aVar.getPaddingBottom() + aVar.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // b3.a
    public final void onRestoreInstanceState(androidx.coordinatorlayout.widget.a aVar, View view, Parcelable parcelable) {
        e eVar = (e) parcelable;
        if (eVar.getSuperState() != null) {
            super.onRestoreInstanceState(aVar, view, eVar.getSuperState());
        }
        int i = eVar.f4360c;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.f2450h = i;
    }

    @Override // b3.a
    public final Parcelable onSaveInstanceState(androidx.coordinatorlayout.widget.a aVar, View view) {
        e eVar = new e(super.onSaveInstanceState(aVar, view));
        eVar.f4360c = this.f2450h;
        VarHandle.storeStoreFence();
        return eVar;
    }

    @Override // b3.a
    public final boolean onTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f2450h == 1 && actionMasked == 0) {
            return true;
        }
        if (d()) {
            this.i.k(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f2460s) != null) {
            velocityTracker.recycle();
            this.f2460s = null;
        }
        if (this.f2460s == null) {
            this.f2460s = VelocityTracker.obtain();
        }
        this.f2460s.addMovement(motionEvent);
        if (d() && actionMasked == 2 && !this.f2451j && d()) {
            float fAbs = Math.abs(this.f2461t - motionEvent.getX());
            b bVar = this.i;
            if (fAbs > bVar.f14027b) {
                bVar.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.f2451j;
    }

    public SideSheetBehavior() {
        this.f2447e = new f(this);
        this.f2449g = true;
        this.f2450h = 5;
        this.f2452k = 0.1f;
        this.f2459r = -1;
        this.f2462u = new LinkedHashSet();
        this.f2463v = new d(this, 0);
    }
}
