package com.google.android.material.bottomsheet;

import D7.N;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
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
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import c3.AbstractC0873c;
import com.google.android.material.internal.m;
import com.google.android.material.internal.n;
import com.stepos.ability.R;
import e3.k;
import e3.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: A, reason: collision with root package name */
    public final f f2304A;

    /* renamed from: B, reason: collision with root package name */
    public final ValueAnimator f2305B;

    /* renamed from: C, reason: collision with root package name */
    public final int f2306C;

    /* renamed from: D, reason: collision with root package name */
    public int f2307D;
    public int E;

    /* renamed from: F, reason: collision with root package name */
    public final float f2308F;

    /* renamed from: G, reason: collision with root package name */
    public int f2309G;

    /* renamed from: H, reason: collision with root package name */
    public final float f2310H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f2311I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f2312J;

    /* renamed from: K, reason: collision with root package name */
    public final boolean f2313K;

    /* renamed from: L, reason: collision with root package name */
    public final boolean f2314L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f2315M;

    /* renamed from: N, reason: collision with root package name */
    public int f2316N;

    /* renamed from: O, reason: collision with root package name */
    public ViewDragHelper f2317O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f2318P;

    /* renamed from: Q, reason: collision with root package name */
    public int f2319Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f2320R;

    /* renamed from: S, reason: collision with root package name */
    public final float f2321S;

    /* renamed from: T, reason: collision with root package name */
    public int f2322T;

    /* renamed from: U, reason: collision with root package name */
    public int f2323U;

    /* renamed from: V, reason: collision with root package name */
    public int f2324V;

    /* renamed from: W, reason: collision with root package name */
    public WeakReference f2325W;

    /* renamed from: X, reason: collision with root package name */
    public WeakReference f2326X;

    /* renamed from: Y, reason: collision with root package name */
    public final ArrayList f2327Y;

    /* renamed from: Z, reason: collision with root package name */
    public VelocityTracker f2328Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f2329a;

    /* renamed from: a0, reason: collision with root package name */
    public int f2330a0;
    public boolean b;
    public int b0;
    public final float c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f2331c0;
    public final int d;

    /* renamed from: d0, reason: collision with root package name */
    public HashMap f2332d0;
    public int e;

    /* renamed from: e0, reason: collision with root package name */
    public final SparseIntArray f2333e0;
    public boolean f;

    /* renamed from: f0, reason: collision with root package name */
    public final c f2334f0;
    public int g;
    public final int h;
    public final k i;

    /* renamed from: j, reason: collision with root package name */
    public final ColorStateList f2335j;
    public final int k;
    public final int l;
    public int m;
    public final boolean n;
    public final boolean o;
    public final boolean p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f2336q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f2337r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f2338s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f2339t;
    public final boolean u;

    /* renamed from: v, reason: collision with root package name */
    public int f2340v;

    /* renamed from: w, reason: collision with root package name */
    public int f2341w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f2342x;
    public final p y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2343z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new e();
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.f2316N;
            this.peekHeight = bottomSheetBehavior.e;
            this.fitToContents = bottomSheetBehavior.b;
            this.hideable = bottomSheetBehavior.f2311I;
            this.skipCollapsed = bottomSheetBehavior.f2312J;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }
    }

    public BottomSheetBehavior() {
        this.f2329a = 0;
        this.b = true;
        this.k = -1;
        this.l = -1;
        this.f2304A = new f(this);
        this.f2308F = 0.5f;
        this.f2310H = -1.0f;
        this.f2313K = true;
        this.f2314L = true;
        this.f2316N = 4;
        this.f2321S = 0.1f;
        this.f2327Y = new ArrayList();
        this.b0 = -1;
        this.f2333e0 = new SparseIntArray();
        this.f2334f0 = new c(this);
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

    public static int h(int i, int i6, int i10, int i11) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i6, i11);
        if (i10 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i10), BasicMeasure.EXACTLY);
        }
        if (size != 0) {
            i10 = Math.min(size, i10);
        }
        return View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE);
    }

    public final void c() {
        int iE = e();
        if (this.b) {
            this.f2309G = Math.max(this.f2324V - iE, this.f2307D);
        } else {
            this.f2309G = this.f2324V - iE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float d() {
        /*
            r6 = this;
            e3.k r0 = r6.i
            r1 = 0
            if (r0 == 0) goto L72
            java.lang.ref.WeakReference r0 = r6.f2325W
            if (r0 == 0) goto L72
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L72
            java.lang.ref.WeakReference r0 = r6.f2325W
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r6.k()
            if (r2 == 0) goto L72
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L72
            e3.k r2 = r6.i
            float r2 = r2.k()
            r3 = 0
            android.view.RoundedCorner r4 = r0.getRoundedCorner(r3)
            if (r4 == 0) goto L3f
            int r4 = r4.getRadius()
            float r4 = (float) r4
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r5 <= 0) goto L3f
            int r5 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r5 <= 0) goto L3f
            float r4 = r4 / r2
            goto L40
        L3f:
            r4 = r1
        L40:
            e3.k r6 = r6.i
            float[] r2 = r6.f4354C
            if (r2 == 0) goto L49
            r6 = r2[r3]
            goto L57
        L49:
            e3.h r2 = r6.b
            e3.p r2 = r2.f4345a
            e3.d r2 = r2.f
            android.graphics.RectF r6 = r6.h()
            float r6 = r2.a(r6)
        L57:
            r2 = 1
            android.view.RoundedCorner r0 = r0.getRoundedCorner(r2)
            if (r0 == 0) goto L6d
            int r0 = r0.getRadius()
            float r0 = (float) r0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L6d
            int r2 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r2 <= 0) goto L6d
            float r1 = r0 / r6
        L6d:
            float r6 = java.lang.Math.max(r4, r1)
            return r6
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d():float");
    }

    public final int e() {
        int iMin;
        int i;
        int i6;
        if (this.f) {
            iMin = Math.min(Math.max(this.g, this.f2324V - ((this.f2323U * 9) / 16)), this.f2322T);
            i = this.f2340v;
        } else {
            if (!this.n && !this.o && (i6 = this.m) > 0) {
                return Math.max(this.e, i6 + this.h);
            }
            iMin = this.e;
            i = this.f2340v;
        }
        return iMin + i;
    }

    public final void f(int i) {
        if (((View) this.f2325W.get()) != null) {
            ArrayList arrayList = this.f2327Y;
            if (arrayList.isEmpty()) {
                return;
            }
            int i6 = this.f2309G;
            if (i <= i6 && i6 != i()) {
                i();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final int i() {
        if (this.b) {
            return this.f2307D;
        }
        return Math.max(this.f2306C, this.f2337r ? 0 : this.f2341w);
    }

    public final int j(int i) {
        if (i == 3) {
            return i();
        }
        if (i == 4) {
            return this.f2309G;
        }
        if (i == 5) {
            return this.f2324V;
        }
        if (i == 6) {
            return this.E;
        }
        throw new IllegalArgumentException(B7.a.h(i, "Invalid state to get top offset: "));
    }

    public final boolean k() {
        WeakReference weakReference = this.f2325W;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.f2325W.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void l(int i) {
        if (i == -1) {
            if (this.f) {
                return;
            } else {
                this.f = true;
            }
        } else {
            if (!this.f && this.e == i) {
                return;
            }
            this.f = false;
            this.e = Math.max(0, i);
        }
        t();
    }

    public final void m(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(B7.a.q(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.f2311I && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i6 = (i == 6 && this.b && j(i) <= this.f2307D) ? 3 : i;
        WeakReference weakReference = this.f2325W;
        if (weakReference == null || weakReference.get() == null) {
            n(i);
            return;
        }
        View view = (View) this.f2325W.get();
        a aVar = new a(this, view, i6);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(aVar);
        } else {
            aVar.run();
        }
    }

    public final void n(int i) {
        if (this.f2316N == i) {
            return;
        }
        this.f2316N = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z10 = this.f2311I;
        }
        WeakReference weakReference = this.f2325W;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            s(true);
        } else if (i == 6 || i == 5 || i == 4) {
            s(false);
        }
        r(i, true);
        ArrayList arrayList = this.f2327Y;
        if (arrayList.size() <= 0) {
            q();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final boolean o(View view, float f) {
        if (this.f2312J) {
            return true;
        }
        if (view.getTop() < this.f2309G) {
            return false;
        }
        return Math.abs(((f * this.f2321S) + ((float) view.getTop())) - ((float) this.f2309G)) / ((float) e()) > 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.f2325W = null;
        this.f2317O = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f2325W = null;
        this.f2317O = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i;
        ViewDragHelper viewDragHelper;
        if (!view.isShown() || !this.f2313K) {
            this.f2318P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2330a0 = -1;
            this.b0 = -1;
            VelocityTracker velocityTracker = this.f2328Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2328Z = null;
            }
        }
        if (this.f2328Z == null) {
            this.f2328Z = VelocityTracker.obtain();
        }
        this.f2328Z.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            this.b0 = y;
            if (this.f2316N != 2) {
                WeakReference weakReference = this.f2326X;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x10, y)) {
                    this.f2330a0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f2331c0 = true;
                }
            }
            this.f2318P = this.f2330a0 == -1 && !coordinatorLayout.isPointInChildBounds(view, x10, this.b0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2331c0 = false;
            this.f2330a0 = -1;
            if (this.f2318P) {
                this.f2318P = false;
                return false;
            }
        }
        if (this.f2318P || (viewDragHelper = this.f2317O) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            WeakReference weakReference2 = this.f2326X;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.f2318P || this.f2316N == 1 || coordinatorLayout.isPointInChildBounds(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f2317O == null || (i = this.b0) == -1 || Math.abs(i - motionEvent.getY()) <= this.f2317O.getTouchSlop()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) throws Resources.NotFoundException {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.f2325W == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z10 = (this.n || this.f) ? false : true;
            if (this.o || this.p || this.f2336q || this.f2338s || this.f2339t || this.u || z10) {
                b bVar = new b(this, z10);
                int paddingStart = view.getPaddingStart();
                view.getPaddingTop();
                int paddingEnd = view.getPaddingEnd();
                int paddingBottom = view.getPaddingBottom();
                n nVar = new n();
                nVar.f2504a = paddingStart;
                nVar.b = paddingEnd;
                nVar.c = paddingBottom;
                ViewCompat.setOnApplyWindowInsetsListener(view, new F.g(5, bVar, nVar));
                if (view.isAttachedToWindow()) {
                    view.requestApplyInsets();
                } else {
                    view.addOnAttachStateChangeListener(new m());
                }
            }
            ViewCompat.setWindowInsetsAnimationCallback(view, new g(view));
            this.f2325W = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            N.N(context, R.attr.motionDurationMedium2, 300);
            N.N(context, R.attr.motionDurationShort3, 150);
            N.N(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
            k kVar = this.i;
            if (kVar != null) {
                view.setBackground(kVar);
                float elevation = this.f2310H;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                this.i.p(elevation);
            } else {
                ColorStateList colorStateList = this.f2335j;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            q();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.f2317O == null) {
            this.f2317O = ViewDragHelper.create(coordinatorLayout, this.f2334f0);
        }
        int top = view.getTop();
        coordinatorLayout.onLayoutChild(view, i);
        this.f2323U = coordinatorLayout.getWidth();
        this.f2324V = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.f2322T = height;
        int iMin = this.f2324V;
        int i6 = iMin - height;
        int i10 = this.f2341w;
        if (i6 < i10) {
            if (this.f2337r) {
                int i11 = this.l;
                if (i11 != -1) {
                    iMin = Math.min(iMin, i11);
                }
                this.f2322T = iMin;
            } else {
                int iMin2 = iMin - i10;
                int i12 = this.l;
                if (i12 != -1) {
                    iMin2 = Math.min(iMin2, i12);
                }
                this.f2322T = iMin2;
            }
        }
        this.f2307D = Math.max(0, this.f2324V - this.f2322T);
        this.E = (int) ((1.0f - this.f2308F) * this.f2324V);
        c();
        int i13 = this.f2316N;
        if (i13 == 3) {
            ViewCompat.offsetTopAndBottom(view, i());
        } else if (i13 == 6) {
            ViewCompat.offsetTopAndBottom(view, this.E);
        } else if (this.f2311I && i13 == 5) {
            ViewCompat.offsetTopAndBottom(view, this.f2324V);
        } else if (i13 == 4) {
            ViewCompat.offsetTopAndBottom(view, this.f2309G);
        } else if (i13 == 1 || i13 == 2) {
            ViewCompat.offsetTopAndBottom(view, top - view.getTop());
        }
        r(this.f2316N, false);
        this.f2326X = new WeakReference(g(view));
        ArrayList arrayList = this.f2327Y;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i6, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(h(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, this.k, marginLayoutParams.width), h(i10, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, this.l, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f7) {
        WeakReference weakReference = this.f2326X;
        if (weakReference == null || view2 != weakReference.get()) {
            return false;
        }
        return !(this.f2316N == 3 || this.f2315M) || super.onNestedPreFling(coordinatorLayout, view, view2, f, f7);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i6, int[] iArr, int i10) {
        if (i10 == 1) {
            return;
        }
        WeakReference weakReference = this.f2326X;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i11 = top - i6;
        if (i6 > 0) {
            if (!this.f2320R && !this.f2314L && view2 == view3 && view2.canScrollVertically(1)) {
                this.f2315M = true;
                return;
            }
            if (i11 < i()) {
                int i12 = top - i();
                iArr[1] = i12;
                ViewCompat.offsetTopAndBottom(view, -i12);
                n(3);
            } else {
                if (!this.f2313K) {
                    return;
                }
                iArr[1] = i6;
                ViewCompat.offsetTopAndBottom(view, -i6);
                n(1);
            }
        } else if (i6 < 0) {
            boolean zCanScrollVertically = view2.canScrollVertically(-1);
            if (!this.f2320R && !this.f2314L && view2 == view3 && zCanScrollVertically) {
                this.f2315M = true;
                return;
            }
            if (!zCanScrollVertically) {
                int i13 = this.f2309G;
                if (i11 > i13 && !this.f2311I) {
                    int i14 = top - i13;
                    iArr[1] = i14;
                    ViewCompat.offsetTopAndBottom(view, -i14);
                    n(4);
                } else {
                    if (!this.f2313K) {
                        return;
                    }
                    iArr[1] = i6;
                    ViewCompat.offsetTopAndBottom(view, -i6);
                    n(1);
                }
            }
        }
        f(view.getTop());
        this.f2319Q = i6;
        this.f2320R = true;
        this.f2315M = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i6, int i10, int i11, int i12, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, view, savedState.getSuperState());
        int i = this.f2329a;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.e = savedState.peekHeight;
            }
            if (i == -1 || (i & 2) == 2) {
                this.b = savedState.fitToContents;
            }
            if (i == -1 || (i & 4) == 4) {
                this.f2311I = savedState.hideable;
            }
            if (i == -1 || (i & 8) == 8) {
                this.f2312J = savedState.skipCollapsed;
            }
        }
        int i6 = savedState.state;
        if (i6 == 1 || i6 == 2) {
            this.f2316N = 4;
        } else {
            this.f2316N = i6;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, view), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i6) {
        this.f2319Q = 0;
        this.f2320R = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.i()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.n(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.f2326X
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.f2320R
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.f2319Q
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.E
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.f2311I
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.f2328Z
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.f2328Z
            int r6 = r2.f2330a0
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.o(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.f2319Q
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.b
            if (r1 == 0) goto L74
            int r5 = r2.f2307D
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f2309G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.E
            if (r3 >= r1) goto L83
            int r6 = r2.f2309G
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f2309G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.b
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.E
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f2309G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.p(r4, r0, r3)
            r2.f2320R = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.f2316N;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.f2317O;
        if (viewDragHelper != null && (this.f2313K || i == 1)) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.f2330a0 = -1;
            this.b0 = -1;
            VelocityTracker velocityTracker = this.f2328Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2328Z = null;
            }
        }
        if (this.f2328Z == null) {
            this.f2328Z = VelocityTracker.obtain();
        }
        this.f2328Z.addMovement(motionEvent);
        if (this.f2317O != null && ((this.f2313K || this.f2316N == 1) && actionMasked == 2 && !this.f2318P && Math.abs(this.b0 - motionEvent.getY()) > this.f2317O.getTouchSlop())) {
            this.f2317O.captureChildView(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f2318P;
    }

    public final void p(View view, int i, boolean z10) {
        int iJ = j(i);
        ViewDragHelper viewDragHelper = this.f2317O;
        if (viewDragHelper == null || (!z10 ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), iJ) : viewDragHelper.settleCapturedViewAt(view.getLeft(), iJ))) {
            n(i);
            return;
        }
        n(2);
        r(i, true);
        this.f2304A.a(i);
    }

    public final void q() {
        View view;
        WeakReference weakReference = this.f2325W;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 524288);
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        SparseIntArray sparseIntArray = this.f2333e0;
        int i = sparseIntArray.get(0, -1);
        if (i != -1) {
            ViewCompat.removeAccessibilityAction(view, i);
            sparseIntArray.delete(0);
        }
        if (!this.b && this.f2316N != 6) {
            sparseIntArray.put(0, ViewCompat.addAccessibilityAction(view, view.getResources().getString(R.string.bottomsheet_action_expand_halfway), new d(this, 6)));
        }
        if (this.f2311I && this.f2316N != 5) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new d(this, 5));
        }
        int i6 = this.f2316N;
        if (i6 == 3) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, null, new d(this, this.b ? 4 : 6));
            return;
        }
        if (i6 == 4) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new d(this, this.b ? 3 : 6));
        } else {
            if (i6 != 6) {
                return;
            }
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, null, new d(this, 4));
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new d(this, 3));
        }
    }

    public final void r(int i, boolean z10) {
        k kVar;
        if (i == 2) {
            return;
        }
        boolean z11 = this.f2316N == 3 && (this.f2342x || k());
        if (this.f2343z == z11 || (kVar = this.i) == null) {
            return;
        }
        this.f2343z = z11;
        ValueAnimator valueAnimator = this.f2305B;
        if (!z10 || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            kVar.r(this.f2343z ? d() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator.setFloatValues(kVar.b.f4346j, z11 ? d() : 1.0f);
            valueAnimator.start();
        }
    }

    public final void s(boolean z10) {
        WeakReference weakReference = this.f2325W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                if (this.f2332d0 != null) {
                    return;
                } else {
                    this.f2332d0 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.f2325W.get() && z10) {
                    this.f2332d0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z10) {
                return;
            }
            this.f2332d0 = null;
        }
    }

    public final void t() {
        View view;
        if (this.f2325W != null) {
            c();
            if (this.f2316N != 4 || (view = (View) this.f2325W.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.f2329a = 0;
        this.b = true;
        this.k = -1;
        this.l = -1;
        this.f2304A = new f(this);
        this.f2308F = 0.5f;
        this.f2310H = -1.0f;
        this.f2313K = true;
        this.f2314L = true;
        this.f2316N = 4;
        this.f2321S = 0.1f;
        this.f2327Y = new ArrayList();
        this.b0 = -1;
        this.f2333e0 = new SparseIntArray();
        this.f2334f0 = new c(this);
        this.h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P2.a.c);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f2335j = AbstractC0873c.a(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(22)) {
            this.y = p.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        p pVar = this.y;
        if (pVar != null) {
            k kVar = new k(pVar);
            this.i = kVar;
            kVar.m(context);
            ColorStateList colorStateList = this.f2335j;
            if (colorStateList != null) {
                this.i.q(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(d(), 1.0f);
        this.f2305B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f2305B.addUpdateListener(new J4.c(this, 2));
        this.f2310H = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(10);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            l(i);
        } else {
            l(typedArrayObtainStyledAttributes.getDimensionPixelSize(10, -1));
        }
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(9, false);
        if (this.f2311I != z10) {
            this.f2311I = z10;
            if (!z10 && this.f2316N == 5) {
                m(4);
            }
            q();
        }
        this.n = typedArrayObtainStyledAttributes.getBoolean(14, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(7, true);
        if (this.b != z11) {
            this.b = z11;
            if (this.f2325W != null) {
                c();
            }
            n((this.b && this.f2316N == 6) ? 3 : this.f2316N);
            r(this.f2316N, true);
            q();
        }
        this.f2312J = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.f2313K = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.f2314L = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.f2329a = typedArrayObtainStyledAttributes.getInt(11, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(8, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.f2308F = f;
            if (this.f2325W != null) {
                this.E = (int) ((1.0f - f) * this.f2324V);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i6 = typedValuePeekValue2.data;
                if (i6 >= 0) {
                    this.f2306C = i6;
                    r(this.f2316N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
                if (dimensionPixelOffset >= 0) {
                    this.f2306C = dimensionPixelOffset;
                    r(this.f2316N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.d = typedArrayObtainStyledAttributes.getInt(12, 500);
            this.o = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.p = typedArrayObtainStyledAttributes.getBoolean(19, false);
            this.f2336q = typedArrayObtainStyledAttributes.getBoolean(20, false);
            this.f2337r = typedArrayObtainStyledAttributes.getBoolean(21, true);
            this.f2338s = typedArrayObtainStyledAttributes.getBoolean(15, false);
            this.f2339t = typedArrayObtainStyledAttributes.getBoolean(16, false);
            this.u = typedArrayObtainStyledAttributes.getBoolean(17, false);
            this.f2342x = typedArrayObtainStyledAttributes.getBoolean(24, true);
            typedArrayObtainStyledAttributes.recycle();
            this.c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}
