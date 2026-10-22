package com.google.android.material.bottomsheet;

import a7.c;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import b3.a;
import com.stepos.agentsafetycenter.R;
import f7.g;
import f7.i;
import f7.m;
import g7.d;
import g7.f;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import n3.e0;
import n3.i0;
import n3.k0;
import td.h;
import u3.b;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends a {
    public final f A;
    public final ValueAnimator B;
    public final int C;
    public int D;
    public int E;
    public final float F;
    public int G;
    public final float H;
    public boolean I;
    public boolean J;
    public final boolean K;
    public final boolean L;
    public boolean M;
    public int N;
    public b O;
    public boolean P;
    public int Q;
    public boolean R;
    public final float S;
    public int T;
    public int U;
    public int V;
    public WeakReference W;
    public WeakReference X;
    public final ArrayList Y;
    public VelocityTracker Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f2410a;

    /* renamed from: a0, reason: collision with root package name */
    public int f2411a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2412b;

    /* renamed from: b0, reason: collision with root package name */
    public int f2413b0;

    /* renamed from: c, reason: collision with root package name */
    public final float f2414c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f2415c0;

    /* renamed from: d, reason: collision with root package name */
    public final int f2416d;

    /* renamed from: d0, reason: collision with root package name */
    public HashMap f2417d0;

    /* renamed from: e, reason: collision with root package name */
    public int f2418e;
    public final SparseIntArray e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2419f;
    public final d f0;

    /* renamed from: g, reason: collision with root package name */
    public int f2420g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2421h;
    public final i i;

    /* renamed from: j, reason: collision with root package name */
    public final ColorStateList f2422j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2423k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2424l;

    /* renamed from: m, reason: collision with root package name */
    public int f2425m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f2426n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f2427o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f2428p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f2429q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f2430r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f2431s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f2432t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f2433u;

    /* renamed from: v, reason: collision with root package name */
    public int f2434v;

    /* renamed from: w, reason: collision with root package name */
    public int f2435w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f2436x;

    /* renamed from: y, reason: collision with root package name */
    public final m f2437y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2438z;

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        int i;
        this.f2410a = 0;
        this.f2412b = true;
        this.f2423k = -1;
        this.f2424l = -1;
        this.A = new f(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = true;
        this.N = 4;
        this.S = 0.1f;
        this.Y = new ArrayList();
        this.f2413b0 = -1;
        this.e0 = new SparseIntArray();
        this.f0 = new d(this, 1);
        this.f2421h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p6.a.f9811c);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f2422j = h.s(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(22)) {
            this.f2437y = m.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        m mVar = this.f2437y;
        if (mVar != null) {
            i iVar = new i(mVar);
            this.i = iVar;
            iVar.g(context);
            ColorStateList colorStateList = this.f2422j;
            if (colorStateList != null) {
                this.i.j(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(d(), 1.0f);
        this.B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        ValueAnimator valueAnimator = this.B;
        com.stepos.common.widget.b bVar = new com.stepos.common.widget.b(2);
        bVar.f2663b = this;
        VarHandle.storeStoreFence();
        valueAnimator.addUpdateListener(bVar);
        this.H = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f2423k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f2424l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(10);
        if (typedValuePeekValue == null || (i = typedValuePeekValue.data) != -1) {
            l(typedArrayObtainStyledAttributes.getDimensionPixelSize(10, -1));
        } else {
            l(i);
        }
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(9, false);
        if (this.I != z10) {
            this.I = z10;
            if (!z10 && this.N == 5) {
                m(4);
            }
            q();
        }
        this.f2426n = typedArrayObtainStyledAttributes.getBoolean(14, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(7, true);
        if (this.f2412b != z11) {
            this.f2412b = z11;
            if (this.W != null) {
                c();
            }
            n((this.f2412b && this.N == 6) ? 3 : this.N);
            r(this.N, true);
            q();
        }
        this.J = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.K = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.L = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.f2410a = typedArrayObtainStyledAttributes.getInt(11, 0);
        float f5 = typedArrayObtainStyledAttributes.getFloat(8, 0.5f);
        if (f5 <= 0.0f || f5 >= 1.0f) {
            g5.f.s("ratio must be a float value between 0 and 1");
            throw null;
        }
        this.F = f5;
        if (this.W != null) {
            this.E = (int) ((1.0f - f5) * this.V);
        }
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
        if (typedValuePeekValue2 == null || typedValuePeekValue2.type != 16) {
            int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
            if (dimensionPixelOffset < 0) {
                g5.f.s("offset must be greater than or equal to 0");
                throw null;
            }
            this.C = dimensionPixelOffset;
            r(this.N, true);
        } else {
            int i3 = typedValuePeekValue2.data;
            if (i3 < 0) {
                g5.f.s("offset must be greater than or equal to 0");
                throw null;
            }
            this.C = i3;
            r(this.N, true);
        }
        this.f2416d = typedArrayObtainStyledAttributes.getInt(12, 500);
        this.f2427o = typedArrayObtainStyledAttributes.getBoolean(18, false);
        this.f2428p = typedArrayObtainStyledAttributes.getBoolean(19, false);
        this.f2429q = typedArrayObtainStyledAttributes.getBoolean(20, false);
        this.f2430r = typedArrayObtainStyledAttributes.getBoolean(21, true);
        this.f2431s = typedArrayObtainStyledAttributes.getBoolean(15, false);
        this.f2432t = typedArrayObtainStyledAttributes.getBoolean(16, false);
        this.f2433u = typedArrayObtainStyledAttributes.getBoolean(17, false);
        this.f2436x = typedArrayObtainStyledAttributes.getBoolean(24, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f2414c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static View g(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewG = g(viewGroup.getChildAt(i));
            if (viewG != null) {
                return viewG;
            }
        }
        return null;
    }

    public static int h(int i, int i3, int i10, int i11) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i3, i11);
        if (i10 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i10), 1073741824);
        }
        if (size != 0) {
            i10 = Math.min(size, i10);
        }
        return View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE);
    }

    public final void c() {
        int iE = e();
        boolean z10 = this.f2412b;
        int i = this.V;
        if (z10) {
            this.G = Math.max(i - iE, this.D);
        } else {
            this.G = i - iE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float d() {
        /*
            r6 = this;
            f7.i r0 = r6.i
            r1 = 0
            if (r0 == 0) goto L84
            java.lang.ref.WeakReference r0 = r6.W
            if (r0 == 0) goto L84
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L84
            java.lang.ref.WeakReference r0 = r6.W
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r6.k()
            if (r2 == 0) goto L84
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L84
            f7.i r2 = r6.i
            float[] r3 = r2.E
            if (r3 == 0) goto L2d
            r2 = 3
            r2 = r3[r2]
            goto L3b
        L2d:
            f7.g r3 = r2.f3954f
            f7.m r3 = r3.f3936a
            f7.d r3 = r3.f3990e
            android.graphics.RectF r2 = r2.d()
            float r2 = r3.a(r2)
        L3b:
            r3 = 0
            android.view.RoundedCorner r4 = r0.getRoundedCorner(r3)
            if (r4 == 0) goto L51
            int r4 = r4.getRadius()
            float r4 = (float) r4
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r5 <= 0) goto L51
            int r5 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r5 <= 0) goto L51
            float r4 = r4 / r2
            goto L52
        L51:
            r4 = r1
        L52:
            f7.i r6 = r6.i
            float[] r2 = r6.E
            if (r2 == 0) goto L5b
            r6 = r2[r3]
            goto L69
        L5b:
            f7.g r2 = r6.f3954f
            f7.m r2 = r2.f3936a
            f7.d r2 = r2.f3991f
            android.graphics.RectF r6 = r6.d()
            float r6 = r2.a(r6)
        L69:
            r2 = 1
            android.view.RoundedCorner r0 = r0.getRoundedCorner(r2)
            if (r0 == 0) goto L7f
            int r0 = r0.getRadius()
            float r0 = (float) r0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L7f
            int r2 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r2 <= 0) goto L7f
            float r1 = r0 / r6
        L7f:
            float r6 = java.lang.Math.max(r4, r1)
            return r6
        L84:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d():float");
    }

    public final int e() {
        int iMin;
        int i;
        int i3;
        if (this.f2419f) {
            iMin = Math.min(Math.max(this.f2420g, this.V - ((this.U * 9) / 16)), this.T);
            i = this.f2434v;
        } else {
            if (!this.f2426n && !this.f2427o && (i3 = this.f2425m) > 0) {
                return Math.max(this.f2418e, i3 + this.f2421h);
            }
            iMin = this.f2418e;
            i = this.f2434v;
        }
        return iMin + i;
    }

    public final void f(int i) {
        if (((View) this.W.get()) != null) {
            ArrayList arrayList = this.Y;
            if (arrayList.isEmpty()) {
                return;
            }
            int i3 = this.G;
            if (i <= i3 && i3 != i()) {
                i();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            od.f.j();
        }
    }

    public final int i() {
        if (this.f2412b) {
            return this.D;
        }
        return Math.max(this.C, this.f2430r ? 0 : this.f2435w);
    }

    public final int j(int i) {
        if (i == 3) {
            return i();
        }
        if (i == 4) {
            return this.G;
        }
        if (i == 5) {
            return this.V;
        }
        if (i == 6) {
            return this.E;
        }
        g5.f.s(k0.a.j(i, "Invalid state to get top offset: "));
        return 0;
    }

    public final boolean k() {
        WeakReference weakReference = this.W;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.W.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void l(int i) {
        boolean z10 = this.f2419f;
        if (i == -1) {
            if (z10) {
                return;
            } else {
                this.f2419f = true;
            }
        } else {
            if (!z10 && this.f2418e == i) {
                return;
            }
            this.f2419f = false;
            this.f2418e = Math.max(0, i);
        }
        t();
    }

    public final void m(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(androidx.activity.b.n(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        int i3 = 5;
        if (!this.I && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i10 = (i == 6 && this.f2412b && j(i) <= this.D) ? 3 : i;
        WeakReference weakReference = this.W;
        if (weakReference == null || weakReference.get() == null) {
            n(i);
            return;
        }
        View view = (View) this.W.get();
        androidx.activity.h hVar = new androidx.activity.h(i3);
        hVar.f678g = this;
        hVar.f679h = view;
        hVar.f677f = i10;
        VarHandle.storeStoreFence();
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(hVar);
        } else {
            hVar.run();
        }
    }

    public final void n(int i) {
        if (this.N == i) {
            return;
        }
        this.N = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z10 = this.I;
        }
        WeakReference weakReference = this.W;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            s(true);
        } else if (i == 6 || i == 5 || i == 4) {
            s(false);
        }
        r(i, true);
        ArrayList arrayList = this.Y;
        if (arrayList.size() <= 0) {
            q();
        } else {
            arrayList.get(0).getClass();
            od.f.j();
        }
    }

    public final boolean o(View view, float f5) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f5 * this.S) + ((float) view.getTop())) - ((float) this.G)) / ((float) e()) > 0.5f;
    }

    @Override // b3.a
    public final void onAttachedToLayoutParams(b3.d dVar) {
        super.onAttachedToLayoutParams(dVar);
        this.W = null;
        this.O = null;
    }

    @Override // b3.a
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.W = null;
        this.O = null;
    }

    @Override // b3.a
    public final boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        int i;
        b bVar;
        if (!view.isShown() || !this.K) {
            this.P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2411a0 = -1;
            this.f2413b0 = -1;
            VelocityTracker velocityTracker = this.Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Z = null;
            }
        }
        if (this.Z == null) {
            this.Z = VelocityTracker.obtain();
        }
        this.Z.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x6 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            this.f2413b0 = y10;
            if (this.N != 2) {
                WeakReference weakReference = this.X;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && aVar.z(view2, x6, y10)) {
                    this.f2411a0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f2415c0 = true;
                }
            }
            this.P = this.f2411a0 == -1 && !aVar.z(view, x6, this.f2413b0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2415c0 = false;
            this.f2411a0 = -1;
            if (this.P) {
                this.P = false;
                return false;
            }
        }
        if (this.P || (bVar = this.O) == null || !bVar.q(motionEvent)) {
            WeakReference weakReference2 = this.X;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.P || this.N == 1 || aVar.z(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.O == null || (i = this.f2413b0) == -1 || Math.abs(i - motionEvent.getY()) <= this.O.f14027b) {
                return false;
            }
        }
        return true;
    }

    @Override // b3.a
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) throws Resources.NotFoundException {
        int i3 = 1;
        if (aVar.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int i10 = 0;
        if (this.W == null) {
            this.f2420g = aVar.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z10 = (this.f2426n || this.f2419f) ? false : true;
            if (this.f2427o || this.f2428p || this.f2429q || this.f2431s || this.f2432t || this.f2433u || z10) {
                l3.d dVar = new l3.d();
                dVar.f7721f = this;
                dVar.f7720c = z10;
                VarHandle.storeStoreFence();
                int paddingStart = view.getPaddingStart();
                view.getPaddingTop();
                int paddingEnd = view.getPaddingEnd();
                int paddingBottom = view.getPaddingBottom();
                c cVar = new c();
                cVar.f228a = paddingStart;
                cVar.f229b = paddingEnd;
                cVar.f230c = paddingBottom;
                p5.c cVar2 = new p5.c(i3);
                cVar2.f9717f = dVar;
                cVar2.f9718g = cVar;
                VarHandle.storeStoreFence();
                WeakHashMap weakHashMap = k0.f8724a;
                e0.b(view, cVar2);
                if (view.isAttachedToWindow()) {
                    view.requestApplyInsets();
                } else {
                    view.addOnAttachStateChangeListener(new a7.b());
                }
            }
            t6.b bVar = new t6.b(i10);
            bVar.i = new int[2];
            bVar.f13203f = view;
            VarHandle.storeStoreFence();
            k0.i(view, bVar);
            this.W = new WeakReference(view);
            new b7.a(view);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
            i iVar = this.i;
            if (iVar != null) {
                view.setBackground(iVar);
                float elevation = this.H;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                iVar.i(elevation);
            } else {
                ColorStateList colorStateList = this.f2422j;
                if (colorStateList != null) {
                    view.setBackgroundTintList(colorStateList);
                }
            }
            q();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.O == null) {
            this.O = b.g(aVar, this.f0);
        }
        int top = view.getTop();
        aVar.B(i, view);
        this.U = aVar.getWidth();
        this.V = aVar.getHeight();
        int height = view.getHeight();
        this.T = height;
        int iMin = this.V;
        int i11 = iMin - height;
        int i12 = this.f2435w;
        if (i11 < i12) {
            boolean z11 = this.f2430r;
            int i13 = this.f2424l;
            if (z11) {
                if (i13 != -1) {
                    iMin = Math.min(iMin, i13);
                }
                this.T = iMin;
            } else {
                int iMin2 = iMin - i12;
                if (i13 != -1) {
                    iMin2 = Math.min(iMin2, i13);
                }
                this.T = iMin2;
            }
        }
        this.D = Math.max(0, this.V - this.T);
        this.E = (int) ((1.0f - this.F) * this.V);
        c();
        int i14 = this.N;
        if (i14 == 3) {
            int i15 = i();
            WeakHashMap weakHashMap2 = k0.f8724a;
            view.offsetTopAndBottom(i15);
        } else if (i14 == 6) {
            int i16 = this.E;
            WeakHashMap weakHashMap3 = k0.f8724a;
            view.offsetTopAndBottom(i16);
        } else if (this.I && i14 == 5) {
            int i17 = this.V;
            WeakHashMap weakHashMap4 = k0.f8724a;
            view.offsetTopAndBottom(i17);
        } else if (i14 == 4) {
            int i18 = this.G;
            WeakHashMap weakHashMap5 = k0.f8724a;
            view.offsetTopAndBottom(i18);
        } else if (i14 == 1 || i14 == 2) {
            int top2 = top - view.getTop();
            WeakHashMap weakHashMap6 = k0.f8724a;
            view.offsetTopAndBottom(top2);
        }
        r(this.N, false);
        this.X = new WeakReference(g(view));
        ArrayList arrayList = this.Y;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        od.f.j();
        return false;
    }

    @Override // b3.a
    public final boolean onMeasureChild(androidx.coordinatorlayout.widget.a aVar, View view, int i, int i3, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(h(i, aVar.getPaddingRight() + aVar.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, this.f2423k, marginLayoutParams.width), h(i10, aVar.getPaddingBottom() + aVar.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f2424l, marginLayoutParams.height));
        return true;
    }

    @Override // b3.a
    public final boolean onNestedPreFling(androidx.coordinatorlayout.widget.a aVar, View view, View view2, float f5, float f10) {
        WeakReference weakReference = this.X;
        if (weakReference == null || view2 != weakReference.get()) {
            return false;
        }
        return !(this.N == 3 || this.M) || super.onNestedPreFling(aVar, view, view2, f5, f10);
    }

    @Override // b3.a
    public final void onNestedPreScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int[] iArr, int i10) {
        if (i10 == 1) {
            return;
        }
        WeakReference weakReference = this.X;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i11 = top - i3;
        boolean z10 = this.K;
        boolean z11 = this.L;
        if (i3 > 0) {
            if (!this.R && !z11 && view2 == view3 && view2.canScrollVertically(1)) {
                this.M = true;
                return;
            }
            if (i11 < i()) {
                int i12 = top - i();
                iArr[1] = i12;
                WeakHashMap weakHashMap = k0.f8724a;
                view.offsetTopAndBottom(-i12);
                n(3);
            } else {
                if (!z10) {
                    return;
                }
                iArr[1] = i3;
                WeakHashMap weakHashMap2 = k0.f8724a;
                view.offsetTopAndBottom(-i3);
                n(1);
            }
        } else if (i3 < 0) {
            boolean zCanScrollVertically = view2.canScrollVertically(-1);
            if (!this.R && !z11 && view2 == view3 && zCanScrollVertically) {
                this.M = true;
                return;
            }
            if (!zCanScrollVertically) {
                int i13 = this.G;
                if (i11 > i13 && !this.I) {
                    int i14 = top - i13;
                    iArr[1] = i14;
                    WeakHashMap weakHashMap3 = k0.f8724a;
                    view.offsetTopAndBottom(-i14);
                    n(4);
                } else {
                    if (!z10) {
                        return;
                    }
                    iArr[1] = i3;
                    WeakHashMap weakHashMap4 = k0.f8724a;
                    view.offsetTopAndBottom(-i3);
                    n(1);
                }
            }
        }
        f(view.getTop());
        this.Q = i3;
        this.R = true;
        this.M = false;
    }

    @Override // b3.a
    public final void onRestoreInstanceState(androidx.coordinatorlayout.widget.a aVar, View view, Parcelable parcelable) {
        t6.a aVar2 = (t6.a) parcelable;
        super.onRestoreInstanceState(aVar, view, aVar2.getSuperState());
        int i = this.f2410a;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.f2418e = aVar2.f13200f;
            }
            if (i == -1 || (i & 2) == 2) {
                this.f2412b = aVar2.f13201g;
            }
            if (i == -1 || (i & 4) == 4) {
                this.I = aVar2.f13202h;
            }
            if (i == -1 || (i & 8) == 8) {
                this.J = aVar2.i;
            }
        }
        int i3 = aVar2.f13199c;
        if (i3 == 1 || i3 == 2) {
            this.N = 4;
        } else {
            this.N = i3;
        }
    }

    @Override // b3.a
    public final Parcelable onSaveInstanceState(androidx.coordinatorlayout.widget.a aVar, View view) {
        t6.a aVar2 = new t6.a(super.onSaveInstanceState(aVar, view));
        aVar2.f13199c = this.N;
        aVar2.f13200f = this.f2418e;
        aVar2.f13201g = this.f2412b;
        aVar2.f13202h = this.I;
        aVar2.i = this.J;
        VarHandle.storeStoreFence();
        return aVar2;
    }

    @Override // b3.a
    public final boolean onStartNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, View view3, int i, int i3) {
        this.Q = 0;
        this.R = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // b3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.a r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.i()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.n(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.X
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.R
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.Q
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f2412b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.E
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.I
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.Z
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f2414c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.Z
            int r6 = r2.f2411a0
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.o(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.Q
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f2412b
            if (r1 == 0) goto L74
            int r5 = r2.D
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.E
            if (r3 >= r1) goto L83
            int r6 = r2.G
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f2412b
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.E
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.p(r4, r0, r3)
            r2.R = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.a, android.view.View, android.view.View, int):void");
    }

    @Override // b3.a
    public final boolean onTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.N;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        b bVar = this.O;
        if (bVar != null && (this.K || i == 1)) {
            bVar.k(motionEvent);
        }
        if (actionMasked == 0) {
            this.f2411a0 = -1;
            this.f2413b0 = -1;
            VelocityTracker velocityTracker = this.Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Z = null;
            }
        }
        if (this.Z == null) {
            this.Z = VelocityTracker.obtain();
        }
        this.Z.addMovement(motionEvent);
        if (this.O != null && ((this.K || this.N == 1) && actionMasked == 2 && !this.P)) {
            float fAbs = Math.abs(this.f2413b0 - motionEvent.getY());
            b bVar2 = this.O;
            if (fAbs > bVar2.f14027b) {
                bVar2.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.P;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        n(2);
        r(r4, true);
        r2.A.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r1.p(r3.getLeft(), r0) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            int r0 = r2.j(r4)
            u3.b r1 = r2.O
            if (r1 == 0) goto L40
            if (r5 == 0) goto L15
            int r3 = r3.getLeft()
            boolean r3 = r1.p(r3, r0)
            if (r3 == 0) goto L40
            goto L32
        L15:
            int r5 = r3.getLeft()
            r1.f14042r = r3
            r3 = -1
            r1.f14028c = r3
            r3 = 0
            boolean r3 = r1.i(r5, r0, r3, r3)
            if (r3 != 0) goto L30
            int r5 = r1.f14026a
            if (r5 != 0) goto L30
            android.view.View r5 = r1.f14042r
            if (r5 == 0) goto L30
            r5 = 0
            r1.f14042r = r5
        L30:
            if (r3 == 0) goto L40
        L32:
            r3 = 2
            r2.n(r3)
            r3 = 1
            r2.r(r4, r3)
            g7.f r2 = r2.A
            r2.a(r4)
            return
        L40:
            r2.n(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.p(android.view.View, int, boolean):void");
    }

    public final void q() throws Resources.NotFoundException {
        View view;
        int i;
        int iA;
        WeakReference weakReference = this.W;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        k0.e(524288, view);
        k0.c(0, view);
        k0.e(262144, view);
        k0.c(0, view);
        k0.e(1048576, view);
        k0.c(0, view);
        SparseIntArray sparseIntArray = this.e0;
        int i3 = sparseIntArray.get(0, -1);
        if (i3 != -1) {
            k0.e(i3, view);
            k0.c(0, view);
            sparseIntArray.delete(0);
        }
        int i10 = 9;
        if (!this.f2412b && this.N != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            wd.a aVar = new wd.a(i10);
            aVar.f15390g = this;
            aVar.f15389f = 6;
            VarHandle.storeStoreFence();
            ArrayList arrayListB = k0.b(view);
            int i11 = 0;
            while (true) {
                if (i11 >= arrayListB.size()) {
                    int i12 = 0;
                    int i13 = -1;
                    while (true) {
                        int[] iArr = k0.f8725b;
                        if (i12 >= 32 || i13 != -1) {
                            break;
                        }
                        int i14 = iArr[i12];
                        boolean z10 = true;
                        for (int i15 = 0; i15 < arrayListB.size(); i15++) {
                            z10 &= ((o3.b) arrayListB.get(i15)).a() != i14;
                        }
                        if (z10) {
                            i13 = i14;
                        }
                        i12++;
                    }
                    iA = i13;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((o3.b) arrayListB.get(i11)).f9145a).getLabel())) {
                        iA = ((o3.b) arrayListB.get(i11)).a();
                        break;
                    }
                    i11++;
                }
            }
            if (iA != -1) {
                o3.b bVar = new o3.b(null, iA, string, aVar, null);
                View.AccessibilityDelegate accessibilityDelegateA = i0.a(view);
                n3.b bVar2 = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof n3.a ? ((n3.a) accessibilityDelegateA).f8679a : new n3.b(accessibilityDelegateA);
                if (bVar2 == null) {
                    bVar2 = new n3.b();
                }
                k0.g(view, bVar2);
                k0.e(bVar.a(), view);
                k0.b(view).add(bVar);
                k0.c(0, view);
            }
            sparseIntArray.put(0, iA);
        }
        if (this.I && this.N != 5) {
            o3.b bVar3 = o3.b.f9140k;
            wd.a aVar2 = new wd.a(i10);
            aVar2.f15390g = this;
            aVar2.f15389f = 5;
            VarHandle.storeStoreFence();
            k0.f(view, bVar3, aVar2);
        }
        int i16 = this.N;
        if (i16 == 3) {
            i = this.f2412b ? 4 : 6;
            o3.b bVar4 = o3.b.f9139j;
            wd.a aVar3 = new wd.a(i10);
            aVar3.f15390g = this;
            aVar3.f15389f = i;
            VarHandle.storeStoreFence();
            k0.f(view, bVar4, aVar3);
            return;
        }
        if (i16 == 4) {
            i = this.f2412b ? 3 : 6;
            o3.b bVar5 = o3.b.i;
            wd.a aVar4 = new wd.a(i10);
            aVar4.f15390g = this;
            aVar4.f15389f = i;
            VarHandle.storeStoreFence();
            k0.f(view, bVar5, aVar4);
            return;
        }
        if (i16 != 6) {
            return;
        }
        o3.b bVar6 = o3.b.f9139j;
        wd.a aVar5 = new wd.a(i10);
        aVar5.f15390g = this;
        aVar5.f15389f = 4;
        VarHandle.storeStoreFence();
        k0.f(view, bVar6, aVar5);
        o3.b bVar7 = o3.b.i;
        wd.a aVar6 = new wd.a(i10);
        aVar6.f15390g = this;
        aVar6.f15389f = 3;
        VarHandle.storeStoreFence();
        k0.f(view, bVar7, aVar6);
    }

    public final void r(int i, boolean z10) {
        i iVar;
        if (i == 2) {
            return;
        }
        boolean z11 = this.N == 3 && (this.f2436x || k());
        if (this.f2438z == z11 || (iVar = this.i) == null) {
            return;
        }
        this.f2438z = z11;
        ValueAnimator valueAnimator = this.B;
        if (z10 && valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            } else {
                valueAnimator.setFloatValues(iVar.f3954f.f3944j, z11 ? d() : 1.0f);
                valueAnimator.start();
                return;
            }
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        float fD = this.f2438z ? d() : 1.0f;
        g gVar = iVar.f3954f;
        if (gVar.f3944j != fD) {
            gVar.f3944j = fD;
            iVar.f3957j = true;
            iVar.f3958k = true;
            iVar.invalidateSelf();
        }
    }

    public final void s(boolean z10) {
        WeakReference weakReference = this.W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof androidx.coordinatorlayout.widget.a) {
            androidx.coordinatorlayout.widget.a aVar = (androidx.coordinatorlayout.widget.a) parent;
            int childCount = aVar.getChildCount();
            if (z10) {
                if (this.f2417d0 != null) {
                    return;
                } else {
                    this.f2417d0 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = aVar.getChildAt(i);
                if (childAt != this.W.get() && z10) {
                    this.f2417d0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z10) {
                return;
            }
            this.f2417d0 = null;
        }
    }

    public final void t() {
        View view;
        if (this.W != null) {
            c();
            if (this.N != 4 || (view = (View) this.W.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    public BottomSheetBehavior() {
        this.f2410a = 0;
        this.f2412b = true;
        this.f2423k = -1;
        this.f2424l = -1;
        this.A = new f(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = true;
        this.N = 4;
        this.S = 0.1f;
        this.Y = new ArrayList();
        this.f2413b0 = -1;
        this.e0 = new SparseIntArray();
        this.f0 = new d(this, 1);
    }

    @Override // b3.a
    public final void onNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int i10, int i11, int i12, int[] iArr) {
    }
}
