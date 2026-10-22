package com.google.android.material.appbar;

import C0.c;
import Z2.i;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.A;
import androidx.core.view.C1313a;
import androidx.core.view.InterfaceC1333v;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import d3.C3953a;
import f.C4027a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import u0.C5566a;
import w0.C5715a;

/* loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: B, reason: collision with root package name */
    public static final int f20201B = R$style.Widget_Design_AppBarLayout;

    /* renamed from: A, reason: collision with root package name */
    public Behavior f20202A;

    /* renamed from: a, reason: collision with root package name */
    public int f20203a;

    /* renamed from: b, reason: collision with root package name */
    public int f20204b;

    /* renamed from: c, reason: collision with root package name */
    public int f20205c;

    /* renamed from: d, reason: collision with root package name */
    public int f20206d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20207e;

    /* renamed from: f, reason: collision with root package name */
    public int f20208f;

    /* renamed from: g, reason: collision with root package name */
    public a0 f20209g;

    /* renamed from: h, reason: collision with root package name */
    public List<b> f20210h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20211i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20212j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20213k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20214l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f20215m;

    /* renamed from: n, reason: collision with root package name */
    public int f20216n;

    /* renamed from: o, reason: collision with root package name */
    public WeakReference<View> f20217o;

    /* renamed from: p, reason: collision with root package name */
    public ValueAnimator f20218p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f20219q;

    /* renamed from: r, reason: collision with root package name */
    public final List<f> f20220r;

    /* renamed from: s, reason: collision with root package name */
    public final LinkedHashSet<g> f20221s;

    /* renamed from: t, reason: collision with root package name */
    public final long f20222t;

    /* renamed from: u, reason: collision with root package name */
    public final TimeInterpolator f20223u;

    /* renamed from: v, reason: collision with root package name */
    public int[] f20224v;

    /* renamed from: w, reason: collision with root package name */
    public int f20225w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f20226x;

    /* renamed from: y, reason: collision with root package name */
    public Integer f20227y;

    /* renamed from: z, reason: collision with root package name */
    public final float f20228z;

    public static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.c<T> {

        /* renamed from: h, reason: collision with root package name */
        public int f20229h;

        /* renamed from: i, reason: collision with root package name */
        public int f20230i;

        /* renamed from: j, reason: collision with root package name */
        public ValueAnimator f20231j;

        /* renamed from: k, reason: collision with root package name */
        public SavedState f20232k;

        /* renamed from: l, reason: collision with root package name */
        public WeakReference<View> f20233l;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f20234a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f20235b;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f20234a = coordinatorLayout;
                this.f20235b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.o(this.f20234a, this.f20235b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public class b extends C1313a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f20237a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f20238b;

            public b(AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout) {
                this.f20237a = appBarLayout;
                this.f20238b = coordinatorLayout;
            }

            @Override // androidx.core.view.C1313a
            public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
                View viewE;
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.m0(ScrollView.class.getName());
                if (this.f20237a.getTotalScrollRange() == 0 || (viewE = BaseBehavior.this.E(this.f20238b)) == null || !BaseBehavior.this.A(this.f20237a)) {
                    return;
                }
                if (BaseBehavior.this.l() != (-this.f20237a.getTotalScrollRange())) {
                    cVar.b(c.a.f1662q);
                    cVar.I0(true);
                }
                if (BaseBehavior.this.l() != 0) {
                    if (!viewE.canScrollVertically(-1)) {
                        cVar.b(c.a.f1663r);
                        cVar.I0(true);
                    } else if ((-this.f20237a.getDownNestedPreScrollRange()) != 0) {
                        cVar.b(c.a.f1663r);
                        cVar.I0(true);
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.C1313a
            public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
                if (i10 == 4096) {
                    this.f20237a.setExpanded(false);
                    return true;
                }
                if (i10 != 8192) {
                    return super.performAccessibilityAction(view, i10, bundle);
                }
                if (BaseBehavior.this.l() != 0) {
                    View viewE = BaseBehavior.this.E(this.f20238b);
                    if (!viewE.canScrollVertically(-1)) {
                        this.f20237a.setExpanded(true);
                        return true;
                    }
                    int i11 = -this.f20237a.getDownNestedPreScrollRange();
                    if (i11 != 0) {
                        BaseBehavior.this.onNestedPreScroll(this.f20238b, this.f20237a, viewE, 0, i11, new int[]{0, 0}, 1);
                        return true;
                    }
                }
                return false;
            }
        }

        public BaseBehavior() {
        }

        public static View C(AppBarLayout appBarLayout, int i10) {
            int iAbs = Math.abs(i10);
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        public static boolean z(int i10, int i11) {
            return (i10 & i11) == i11;
        }

        public final boolean A(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (((e) appBarLayout.getChildAt(i10).getLayoutParams()).f20243a != 0) {
                    return true;
                }
            }
            return false;
        }

        public final View B(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof InterfaceC1333v) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public final int D(T t10, int i10) {
            int childCount = t10.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = t10.getChildAt(i11);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e eVar = (e) childAt.getLayoutParams();
                if (z(eVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) eVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) eVar).bottomMargin;
                }
                int i12 = -i10;
                if (top <= i12 && bottom >= i12) {
                    return i11;
                }
            }
            return -1;
        }

        public final View E(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.c
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public int j(T t10) {
            return (-t10.getDownNestedScrollRange()) + t10.getTopInset();
        }

        @Override // com.google.android.material.appbar.c
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public int k(T t10) {
            return t10.getTotalScrollRange();
        }

        public final int H(T t10, int i10) {
            int iAbs = Math.abs(i10);
            int childCount = t10.getChildCount();
            int topInset = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                }
                View childAt = t10.getChildAt(i11);
                e eVar = (e) childAt.getLayoutParams();
                Interpolator interpolatorD = eVar.d();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i11++;
                } else if (interpolatorD != null) {
                    int iC = eVar.c();
                    if ((iC & 1) != 0) {
                        topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= childAt.getMinimumHeight();
                        }
                    }
                    if (childAt.getFitsSystemWindows()) {
                        topInset -= t10.getTopInset();
                    }
                    if (topInset > 0) {
                        float f10 = topInset;
                        return Integer.signum(i10) * (childAt.getTop() + Math.round(f10 * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f10)));
                    }
                }
            }
            return i10;
        }

        @Override // com.google.android.material.appbar.c
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public void m(CoordinatorLayout coordinatorLayout, T t10) {
            V(coordinatorLayout, t10);
            if (t10.t()) {
                t10.H(t10.K(B(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.e, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, T t10, int i10) {
            boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, t10, i10);
            int pendingAction = t10.getPendingAction();
            SavedState savedState = this.f20232k;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z10 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i11 = -t10.getUpNestedPreScrollRange();
                        if (z10) {
                            u(coordinatorLayout, t10, i11, 0.0f);
                        } else {
                            o(coordinatorLayout, t10, i11);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            u(coordinatorLayout, t10, 0, 0.0f);
                        } else {
                            o(coordinatorLayout, t10, 0);
                        }
                    }
                }
            } else if (savedState.fullyScrolled) {
                o(coordinatorLayout, t10, -t10.getTotalScrollRange());
            } else if (savedState.fullyExpanded) {
                o(coordinatorLayout, t10, 0);
            } else {
                View childAt = t10.getChildAt(savedState.firstVisibleChildIndex);
                o(coordinatorLayout, t10, (-childAt.getBottom()) + (this.f20232k.firstVisibleChildAtMinimumHeight ? childAt.getMinimumHeight() + t10.getTopInset() : Math.round(childAt.getHeight() * this.f20232k.firstVisibleChildPercentageShown)));
            }
            t10.D();
            this.f20232k = null;
            setTopAndBottomOffset(C5715a.b(getTopAndBottomOffset(), -t10.getTotalScrollRange(), 0));
            W(coordinatorLayout, t10, getTopAndBottomOffset(), 0, true);
            t10.y(getTopAndBottomOffset());
            t(coordinatorLayout, t10);
            return zOnLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, int i12, int i13) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t10.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, t10, i10, i11, i12, i13);
            }
            coordinatorLayout.R(t10, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r7, T r8, android.view.View r9, int r10, int r11, int[] r12, int r13) {
            /*
                r6 = this;
                if (r11 == 0) goto L26
                if (r11 >= 0) goto L11
                int r10 = r8.getTotalScrollRange()
                int r10 = -r10
                int r13 = r8.getDownNestedPreScrollRange()
                int r13 = r13 + r10
            Le:
                r4 = r10
                r5 = r13
                goto L18
            L11:
                int r10 = r8.getUpNestedPreScrollRange()
                int r10 = -r10
                r13 = 0
                goto Le
            L18:
                if (r4 == r5) goto L26
                r10 = 1
                r0 = r6
                r1 = r7
                r2 = r8
                r3 = r11
                int r6 = r0.n(r1, r2, r3, r4, r5)
                r12[r10] = r6
                goto L27
            L26:
                r2 = r8
            L27:
                boolean r6 = r2.t()
                if (r6 == 0) goto L34
                boolean r6 = r2.K(r9)
                r2.H(r6)
            L34:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int, int[], int):void");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            BaseBehavior<T> baseBehavior;
            CoordinatorLayout coordinatorLayout2;
            T t11;
            int i15;
            if (i13 < 0) {
                baseBehavior = this;
                coordinatorLayout2 = coordinatorLayout;
                t11 = t10;
                i15 = i13;
                iArr[1] = baseBehavior.n(coordinatorLayout2, t11, i15, -t10.getDownNestedScrollRange(), 0);
            } else {
                baseBehavior = this;
                coordinatorLayout2 = coordinatorLayout;
                t11 = t10;
                i15 = i13;
            }
            if (i15 == 0) {
                baseBehavior.t(coordinatorLayout2, t11);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t10, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                R((SavedState) parcelable, true);
                super.onRestoreInstanceState(coordinatorLayout, t10, this.f20232k.getSuperState());
            } else {
                super.onRestoreInstanceState(coordinatorLayout, t10, parcelable);
                this.f20232k = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, T t10) {
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t10);
            SavedState savedStateS = S(parcelableOnSaveInstanceState, t10);
            return savedStateS == null ? parcelableOnSaveInstanceState : savedStateS;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: P, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t10, View view, View view2, int i10, int i11) {
            ValueAnimator valueAnimator;
            boolean z10 = (i10 & 2) != 0 && (t10.t() || t10.v() || y(coordinatorLayout, t10, view));
            if (z10 && (valueAnimator = this.f20231j) != null) {
                valueAnimator.cancel();
            }
            this.f20233l = null;
            this.f20230i = i11;
            return z10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t10, View view, int i10) {
            if (this.f20230i == 0 || i10 == 1) {
                V(coordinatorLayout, t10);
                if (t10.t()) {
                    t10.H(t10.K(view));
                }
            }
            this.f20233l = new WeakReference<>(view);
        }

        public void R(SavedState savedState, boolean z10) {
            if (this.f20232k == null || z10) {
                this.f20232k = savedState;
            }
        }

        public SavedState S(Parcelable parcelable, T t10) {
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t10.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = t10.getChildAt(i10);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z10 = topAndBottomOffset == 0;
                    savedState.fullyExpanded = z10;
                    savedState.fullyScrolled = !z10 && (-topAndBottomOffset) >= t10.getTotalScrollRange();
                    savedState.firstVisibleChildIndex = i10;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == childAt.getMinimumHeight() + t10.getTopInset();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.c
        /* renamed from: T, reason: merged with bridge method [inline-methods] */
        public int p(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, int i12) {
            int iL = l();
            int i13 = 0;
            if (i11 == 0 || iL < i11 || iL > i12) {
                this.f20229h = 0;
            } else {
                int iB = C5715a.b(i10, i11, i12);
                if (iL != iB) {
                    int iH = t10.n() ? H(t10, iB) : iB;
                    boolean topAndBottomOffset = setTopAndBottomOffset(iH);
                    int i14 = iL - iB;
                    this.f20229h = iB - iH;
                    if (topAndBottomOffset) {
                        while (i13 < t10.getChildCount()) {
                            e eVar = (e) t10.getChildAt(i13).getLayoutParams();
                            c cVarB = eVar.b();
                            if (cVarB != null && (eVar.c() & 1) != 0) {
                                cVarB.a(t10, t10.getChildAt(i13), getTopAndBottomOffset());
                            }
                            i13++;
                        }
                    }
                    if (!topAndBottomOffset && t10.n()) {
                        coordinatorLayout.n(t10);
                    }
                    t10.y(getTopAndBottomOffset());
                    W(coordinatorLayout, t10, iB, iB < iL ? -1 : 1, false);
                    i13 = i14;
                }
            }
            t(coordinatorLayout, t10);
            return i13;
        }

        public final boolean U(CoordinatorLayout coordinatorLayout, T t10) {
            List<View> listZ = coordinatorLayout.z(t10);
            int size = listZ.size();
            for (int i10 = 0; i10 < size; i10++) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) listZ.get(i10).getLayoutParams()).f();
                if (cVarF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) cVarF).getOverlayTop() != 0;
                }
            }
            return false;
        }

        public final void V(CoordinatorLayout coordinatorLayout, T t10) {
            int topInset = t10.getTopInset() + t10.getPaddingTop();
            int iL = l() - topInset;
            int iD = D(t10, iL);
            if (iD >= 0) {
                View childAt = t10.getChildAt(iD);
                e eVar = (e) childAt.getLayoutParams();
                int iC = eVar.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int minimumHeight = -childAt.getBottom();
                    if (iD == 0 && t10.getFitsSystemWindows() && childAt.getFitsSystemWindows()) {
                        topInset2 -= t10.getTopInset();
                    }
                    if (z(iC, 2)) {
                        minimumHeight += childAt.getMinimumHeight();
                    } else if (z(iC, 5)) {
                        int minimumHeight2 = childAt.getMinimumHeight() + minimumHeight;
                        if (iL < minimumHeight2) {
                            topInset2 = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if (z(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) eVar).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    }
                    u(coordinatorLayout, t10, C5715a.b(w(iL, minimumHeight, topInset2) + topInset, -t10.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void W(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, boolean z10) {
            View viewC = C(t10, i10);
            boolean zK = false;
            if (viewC != null) {
                int iC = ((e) viewC.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int minimumHeight = viewC.getMinimumHeight();
                    if (i11 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i10) < (viewC.getBottom() - minimumHeight) - t10.getTopInset()) : (-i10) >= (viewC.getBottom() - minimumHeight) - t10.getTopInset()) {
                        zK = true;
                    }
                }
            }
            if (t10.t()) {
                zK = t10.K(B(coordinatorLayout));
            }
            boolean zH = t10.H(zK);
            if (z10 || (zH && U(coordinatorLayout, t10))) {
                if (t10.getBackground() != null) {
                    t10.getBackground().jumpToCurrentState();
                }
                if (t10.getForeground() != null) {
                    t10.getForeground().jumpToCurrentState();
                }
                if (t10.getStateListAnimator() != null) {
                    t10.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        @Override // com.google.android.material.appbar.c
        public int l() {
            return getTopAndBottomOffset() + this.f20229h;
        }

        public final void t(CoordinatorLayout coordinatorLayout, T t10) {
            if (N.J(coordinatorLayout)) {
                return;
            }
            N.i0(coordinatorLayout, new b(t10, coordinatorLayout));
        }

        public final void u(CoordinatorLayout coordinatorLayout, T t10, int i10, float f10) {
            int iAbs = Math.abs(l() - i10);
            float fAbs = Math.abs(f10);
            v(coordinatorLayout, t10, i10, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t10.getHeight()) + 1.0f) * 150.0f));
        }

        public final void v(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11) {
            int iL = l();
            if (iL == i10) {
                ValueAnimator valueAnimator = this.f20231j;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f20231j.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f20231j;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f20231j = valueAnimator3;
                valueAnimator3.setInterpolator(E2.a.f2343e);
                this.f20231j.addUpdateListener(new a(coordinatorLayout, t10));
            } else {
                valueAnimator2.cancel();
            }
            this.f20231j.setDuration(Math.min(i11, 600));
            this.f20231j.setIntValues(iL, i10);
            this.f20231j.start();
        }

        public final int w(int i10, int i11, int i12) {
            return i10 < (i11 + i12) / 2 ? i11 : i12;
        }

        @Override // com.google.android.material.appbar.c
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public boolean g(T t10) {
            WeakReference<View> weakReference = this.f20233l;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        public final boolean y(CoordinatorLayout coordinatorLayout, T t10, View view) {
            return t10.p() && coordinatorLayout.getHeight() - view.getHeight() <= t10.getHeight();
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
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

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.fullyScrolled = parcel.readByte() != 0;
                this.fullyExpanded = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: J */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: K */
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10, int i11, int i12, int i13) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i10, i11, i12, i13);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: L */
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i10, i11, iArr, i12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: M */
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i10, i11, i12, i13, i14, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: N */
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: O */
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: P */
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i10, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: Q */
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i10);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z10) {
            super.setHorizontalOffsetEnabled(z10);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i10) {
            return super.setLeftAndRightOffset(i10);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i10) {
            return super.setTopAndBottomOffset(i10);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z10) {
            super.setVerticalOffsetEnabled(z10);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.d {
        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(AppBarLayout appBarLayout) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                return ((BaseBehavior) cVarF).l();
            }
            return 0;
        }

        private void offsetChildAsNeeded(View view, View view2) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                N.T(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVarF).f20229h) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.t()) {
                    appBarLayout.H(appBarLayout.K(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ View findFirstDependency(List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.d
        public float getOverlapRatioForOffset(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (appBarLayoutOffset / i10) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.d
        public int getScrollRange(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                N.i0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.e, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
            return super.onLayoutChild(coordinatorLayout, view, i10);
        }

        @Override // com.google.android.material.appbar.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
            return super.onMeasureChild(coordinatorLayout, view, i10, i11, i12, i13);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            AppBarLayout appBarLayoutFindFirstDependency = findFirstDependency(coordinatorLayout.y(view));
            if (appBarLayoutFindFirstDependency != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.tempRect1;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutFindFirstDependency.E(false, !z10);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z10) {
            super.setHorizontalOffsetEnabled(z10);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i10) {
            return super.setLeftAndRightOffset(i10);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i10) {
            return super.setTopAndBottomOffset(i10);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z10) {
            super.setVerticalOffsetEnabled(z10);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.d
        public AppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public class a implements A {
        public a() {
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            return AppBarLayout.this.z(a0Var);
        }
    }

    public interface b<T extends AppBarLayout> {
        void a(T t10, int i10);
    }

    public static abstract class c {
        public abstract void a(AppBarLayout appBarLayout, View view, float f10);
    }

    public static class d extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f20241a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        public final Rect f20242b = new Rect();

        public static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, View view, float f10) {
            b(this.f20241a, appBarLayout, view);
            float fAbs = this.f20241a.top - Math.abs(f10);
            if (fAbs > 0.0f) {
                view.setClipBounds(null);
                view.setTranslationY(0.0f);
                view.setAlpha(1.0f);
                return;
            }
            float fA = 1.0f - C5715a.a(Math.abs(fAbs / this.f20241a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.f20241a.height() * 0.3f) * (1.0f - (fA * fA)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.f20242b);
            this.f20242b.offset(0, (int) (-fHeight));
            if (fHeight >= this.f20242b.height()) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(1.0f);
            }
            view.setClipBounds(this.f20242b);
        }
    }

    @Deprecated
    public interface f {
        void a(float f10, int i10);
    }

    public static abstract class g {
        public abstract void a(float f10, int i10, float f11);
    }

    public interface h extends b<AppBarLayout> {
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    public static /* synthetic */ void c(AppBarLayout appBarLayout, Z2.h hVar, ValueAnimator valueAnimator) {
        appBarLayout.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        hVar.f0(fFloatValue);
        Drawable drawable = appBarLayout.f20226x;
        if (drawable instanceof Z2.h) {
            ((Z2.h) drawable).f0(fFloatValue);
        }
        Iterator<f> it = appBarLayout.f20220r.iterator();
        while (it.hasNext()) {
            it.next().a(fFloatValue, hVar.E());
        }
        Iterator<g> it2 = appBarLayout.f20221s.iterator();
        while (it2.hasNext()) {
            it2.next().a(fFloatValue, hVar.E(), fFloatValue / appBarLayout.f20228z);
        }
    }

    public static /* synthetic */ void d(AppBarLayout appBarLayout, ColorStateList colorStateList, Z2.h hVar, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        appBarLayout.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int iJ = M2.a.j(appBarLayout.f20225w, colorStateList.getDefaultColor(), fFloatValue);
        hVar.g0(ColorStateList.valueOf(iJ));
        if (appBarLayout.f20226x != null && (num2 = appBarLayout.f20227y) != null && num2.equals(num)) {
            appBarLayout.f20226x.setTint(iJ);
        }
        if (!appBarLayout.f20220r.isEmpty()) {
            for (f fVar : appBarLayout.f20220r) {
                if (hVar.B() != null) {
                    fVar.a(0.0f, iJ);
                }
            }
        }
        if (appBarLayout.f20221s.isEmpty()) {
            return;
        }
        Iterator<g> it = appBarLayout.f20221s.iterator();
        while (it.hasNext()) {
            it.next().a(0.0f, iJ, fFloatValue);
        }
    }

    public boolean A(g gVar) {
        return this.f20221s.remove(gVar);
    }

    public void B(b bVar) {
        List<b> list = this.f20210h;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    public void C(h hVar) {
        B(hVar);
    }

    public void D() {
        this.f20208f = 0;
    }

    public void E(boolean z10, boolean z11) {
        F(z10, z11, true);
    }

    public final void F(boolean z10, boolean z11, boolean z12) {
        this.f20208f = (z10 ? 1 : 2) | (z11 ? 4 : 0) | (z12 ? 8 : 0);
        requestLayout();
    }

    public final boolean G(boolean z10) {
        if (this.f20212j == z10) {
            return false;
        }
        this.f20212j = z10;
        refreshDrawableState();
        return true;
    }

    public boolean H(boolean z10) {
        return I(z10, !this.f20211i);
    }

    public boolean I(boolean z10, boolean z11) {
        if (!z11 || this.f20213k == z10) {
            return false;
        }
        this.f20213k = z10;
        refreshDrawableState();
        if (!u()) {
            return true;
        }
        if (this.f20215m != null) {
            M(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f20214l) {
            return true;
        }
        M(z10 ? 0.0f : this.f20228z, z10 ? this.f20228z : 0.0f);
        return true;
    }

    public final boolean J() {
        return this.f20226x != null && getTopInset() > 0;
    }

    public boolean K(View view) {
        View viewJ = j(view);
        if (viewJ != null) {
            view = viewJ;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final boolean L() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                return true;
            }
        }
        return false;
    }

    public final void M(float f10, float f11) {
        ValueAnimator valueAnimator = this.f20218p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        this.f20218p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f20222t);
        this.f20218p.setInterpolator(this.f20223u);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f20219q;
        if (animatorUpdateListener != null) {
            this.f20218p.addUpdateListener(animatorUpdateListener);
        }
        this.f20218p.start();
    }

    public final void N() {
        setWillNotDraw(!J());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (J()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f20203a);
            this.f20226x.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f20226x;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public void e(g gVar) {
        this.f20221s.add(gVar);
    }

    public void f(b bVar) {
        if (this.f20210h == null) {
            this.f20210h = new ArrayList();
        }
        if (bVar == null || this.f20210h.contains(bVar)) {
            return;
        }
        this.f20210h.add(bVar);
    }

    public void g(h hVar) {
        f(hVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f20202A = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i10 = this.f20205c;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = eVar.f20243a;
                if ((i12 & 5) != 5) {
                    if (i11 > 0) {
                        break;
                    }
                } else {
                    int i13 = ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    if ((i12 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i12 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i13 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i11 += iMin;
                    }
                    iMin = i13 + minimumHeight;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i11 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i11);
        this.f20205c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i10 = this.f20206d;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                int i12 = eVar.f20243a;
                if ((i12 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i12 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f20206d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f20216n;
    }

    public Z2.h getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof Z2.h) {
            return (Z2.h) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i10 = (minimumHeight * 2) + topInset;
            return i10 < getHeight() ? i10 : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i11 = (minimumHeight2 * 2) + topInset;
        return i11 < getHeight() ? i11 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.f20208f;
    }

    public Drawable getStatusBarForeground() {
        return this.f20226x;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        a0 a0Var = this.f20209g;
        if (a0Var != null) {
            return a0Var.m();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f20204b;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = eVar.f20243a;
                if ((i12 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                if (i11 == 0 && childAt.getFitsSystemWindows()) {
                    minimumHeight -= getTopInset();
                }
                if ((i12 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f20204b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void h() {
        WeakReference<View> weakReference = this.f20217o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f20217o = null;
    }

    public final Integer i() {
        Drawable drawable = this.f20226x;
        if (drawable instanceof Z2.h) {
            return Integer.valueOf(((Z2.h) drawable).E());
        }
        ColorStateList colorStateListF = O2.a.f(drawable);
        if (colorStateListF != null) {
            return Integer.valueOf(colorStateListF.getDefaultColor());
        }
        return null;
    }

    public final View j(View view) {
        int i10;
        if (this.f20217o == null && (i10 = this.f20216n) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i10) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f20216n);
            }
            if (viewFindViewById != null) {
                this.f20217o = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f20217o;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new e((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public boolean n() {
        return this.f20207e;
    }

    public final boolean o() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((e) getChildAt(i10).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (this.f20224v == null) {
            this.f20224v = new int[4];
        }
        int[] iArr = this.f20224v;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f20212j;
        int i11 = R$attr.state_liftable;
        if (!z10) {
            i11 = -i11;
        }
        iArr[0] = i11;
        iArr[1] = (z10 && this.f20213k) ? R$attr.state_lifted : -R$attr.state_lifted;
        int i12 = R$attr.state_collapsible;
        if (!z10) {
            i12 = -i12;
        }
        iArr[2] = i12;
        iArr[3] = (z10 && this.f20213k) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (getFitsSystemWindows() && L()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                N.T(getChildAt(childCount), topInset);
            }
        }
        s();
        this.f20207e = false;
        int childCount2 = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount2) {
                break;
            }
            if (((e) getChildAt(i14).getLayoutParams()).d() != null) {
                this.f20207e = true;
                break;
            }
            i14++;
        }
        Drawable drawable = this.f20226x;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f20211i) {
            return;
        }
        if (!this.f20214l && !o()) {
            z11 = false;
        }
        G(z11);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824 && getFitsSystemWindows() && L()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = C5715a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i11));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        s();
    }

    public boolean p() {
        return getTotalScrollRange() != 0;
    }

    public final void q(final Z2.h hVar, final ColorStateList colorStateList) {
        final Integer numF = M2.a.f(getContext(), R$attr.colorSurface);
        this.f20219q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.d(this.f20265a, colorStateList, hVar, numF, valueAnimator);
            }
        };
    }

    public final void r(Context context, final Z2.h hVar) {
        hVar.U(context);
        this.f20219q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.c(this.f20269a, hVar, valueAnimator);
            }
        };
    }

    public final void s() {
        Behavior behavior = this.f20202A;
        BaseBehavior.SavedState savedStateS = (behavior == null || this.f20204b == -1 || this.f20208f != 0) ? null : behavior.S(AbsSavedState.EMPTY_STATE, this);
        this.f20204b = -1;
        this.f20205c = -1;
        this.f20206d = -1;
        if (savedStateS != null) {
            this.f20202A.R(savedStateS, false);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(x(getContext(), drawable));
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        i.d(this, f10);
    }

    public void setExpanded(boolean z10) {
        E(z10, isLaidOut());
    }

    public void setLiftOnScroll(boolean z10) {
        this.f20214l = z10;
    }

    public void setLiftOnScrollColor(ColorStateList colorStateList) {
        if (this.f20215m != colorStateList) {
            this.f20215m = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f20216n = -1;
        if (view == null) {
            h();
        } else {
            this.f20217o = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i10) {
        this.f20216n = i10;
        h();
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f20211i = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i10);
    }

    public void setPendingAction(int i10) {
        this.f20208f = i10;
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f20226x;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f20226x = drawable != null ? drawable.mutate() : null;
            this.f20227y = i();
            Drawable drawable3 = this.f20226x;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f20226x.setState(getDrawableState());
                }
                C5566a.m(this.f20226x, getLayoutDirection());
                this.f20226x.setVisible(getVisibility() == 0, false);
                this.f20226x.setCallback(this);
            }
            N();
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i10) {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(int i10) {
        setStatusBarForeground(C4027a.b(getContext(), i10));
    }

    @Deprecated
    public void setTargetElevation(float f10) throws Resources.NotFoundException {
        com.google.android.material.appbar.g.b(this, f10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f20226x;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    public boolean t() {
        return this.f20214l;
    }

    public final boolean u() {
        return getBackground() instanceof Z2.h;
    }

    public boolean v() {
        return this.f20213k;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f20226x;
    }

    public final Z2.h w(Drawable drawable) {
        if (drawable instanceof Z2.h) {
            return (Z2.h) drawable;
        }
        ColorStateList colorStateListF = O2.a.f(drawable);
        if (colorStateListF == null) {
            return null;
        }
        Z2.h hVar = new Z2.h();
        hVar.g0(colorStateListF);
        return hVar;
    }

    public final Drawable x(Context context, Drawable drawable) {
        Z2.h hVarW = w(drawable);
        if (hVarW == null || hVarW.B() == null) {
            return drawable;
        }
        this.f20225w = hVarW.B().getDefaultColor();
        ColorStateList colorStateList = this.f20215m;
        if (colorStateList != null) {
            q(hVarW, colorStateList);
            return hVarW;
        }
        r(context, hVarW);
        return hVarW;
    }

    public void y(int i10) {
        this.f20203a = i10;
        if (!willNotDraw()) {
            postInvalidateOnAnimation();
        }
        List<b> list = this.f20210h;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = this.f20210h.get(i11);
                if (bVar != null) {
                    bVar.a(this, i10);
                }
            }
        }
    }

    public a0 z(a0 a0Var) {
        a0 a0Var2 = getFitsSystemWindows() ? a0Var : null;
        if (!B0.c.a(this.f20209g, a0Var2)) {
            this.f20209g = a0Var2;
            N();
            requestLayout();
        }
        return a0Var;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int i11 = f20201B;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        this.f20204b = -1;
        this.f20205c = -1;
        this.f20206d = -1;
        this.f20208f = 0;
        this.f20220r = new ArrayList();
        this.f20221s = new LinkedHashSet<>();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            com.google.android.material.appbar.g.a(this);
        }
        com.google.android.material.appbar.g.c(this, attributeSet, i10, i11);
        TypedArray typedArrayI = r.i(context2, attributeSet, R$styleable.AppBarLayout, i10, i11, new int[0]);
        this.f20215m = W2.c.a(context2, typedArrayI, R$styleable.AppBarLayout_liftOnScrollColor);
        this.f20222t = T2.h.f(context2, R$attr.motionDurationMedium2, getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
        this.f20223u = T2.h.g(context2, R$attr.motionEasingStandardInterpolator, E2.a.f2339a);
        int i12 = R$styleable.AppBarLayout_expanded;
        if (typedArrayI.hasValue(i12)) {
            F(typedArrayI.getBoolean(i12, false), false, false);
        }
        if (typedArrayI.hasValue(R$styleable.AppBarLayout_elevation)) {
            com.google.android.material.appbar.g.b(this, typedArrayI.getDimensionPixelSize(r10, 0));
        }
        setBackground(typedArrayI.getDrawable(R$styleable.AppBarLayout_android_background));
        int i13 = R$styleable.AppBarLayout_android_keyboardNavigationCluster;
        if (typedArrayI.hasValue(i13)) {
            setKeyboardNavigationCluster(typedArrayI.getBoolean(i13, false));
        }
        int i14 = R$styleable.AppBarLayout_android_touchscreenBlocksFocus;
        if (typedArrayI.hasValue(i14)) {
            setTouchscreenBlocksFocus(typedArrayI.getBoolean(i14, false));
        }
        this.f20228z = getResources().getDimension(R$dimen.design_appbar_elevation);
        this.f20214l = typedArrayI.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
        this.f20216n = typedArrayI.getResourceId(R$styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayI.getDrawable(R$styleable.AppBarLayout_statusBarForeground));
        typedArrayI.recycle();
        N.u0(this, new a());
    }

    public static class e extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f20243a;

        /* renamed from: b, reason: collision with root package name */
        public c f20244b;

        /* renamed from: c, reason: collision with root package name */
        public Interpolator f20245c;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f20243a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.f20243a = typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            int i10 = R$styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                this.f20245c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i10, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public final c a(int i10) {
            if (i10 != 1) {
                return null;
            }
            return new d();
        }

        public c b() {
            return this.f20244b;
        }

        public int c() {
            return this.f20243a;
        }

        public Interpolator d() {
            return this.f20245c;
        }

        public boolean e() {
            int i10 = this.f20243a;
            return (i10 & 1) == 1 && (i10 & 10) != 0;
        }

        public void f(int i10) {
            this.f20244b = a(i10);
        }

        public void g(int i10) {
            this.f20243a = i10;
        }

        public e(int i10, int i11) {
            super(i10, i11);
            this.f20243a = 1;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f20243a = 1;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f20243a = 1;
        }

        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f20243a = 1;
        }
    }
}
