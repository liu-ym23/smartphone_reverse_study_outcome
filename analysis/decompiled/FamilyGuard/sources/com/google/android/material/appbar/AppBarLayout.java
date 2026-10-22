package com.google.android.material.appbar;

import E.c;
import a1.C0409b;
import a1.C0411d;
import a1.C0414g;
import a1.C0417j;
import a1.C0418k;
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
import androidx.core.view.C0456a;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0474t;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import b1.C0553a;
import com.google.android.material.internal.o;
import h.C0744a;
import j1.C0777a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import q1.C0981c;
import t1.C1115h;
import t1.C1116i;
import x1.C1282a;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: B, reason: collision with root package name */
    private static final int f12099B = C0417j.f6912c;

    /* renamed from: A, reason: collision with root package name */
    private Behavior f12100A;

    /* renamed from: a, reason: collision with root package name */
    private int f12101a;

    /* renamed from: b, reason: collision with root package name */
    private int f12102b;

    /* renamed from: c, reason: collision with root package name */
    private int f12103c;

    /* renamed from: d, reason: collision with root package name */
    private int f12104d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12105e;

    /* renamed from: f, reason: collision with root package name */
    private int f12106f;

    /* renamed from: g, reason: collision with root package name */
    private Y f12107g;

    /* renamed from: h, reason: collision with root package name */
    private List<b> f12108h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12109i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12110j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12111k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f12112l;

    /* renamed from: m, reason: collision with root package name */
    private ColorStateList f12113m;

    /* renamed from: n, reason: collision with root package name */
    private int f12114n;

    /* renamed from: o, reason: collision with root package name */
    private WeakReference<View> f12115o;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f12116p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f12117q;

    /* renamed from: r, reason: collision with root package name */
    private final List<f> f12118r;

    /* renamed from: s, reason: collision with root package name */
    private final LinkedHashSet<g> f12119s;

    /* renamed from: t, reason: collision with root package name */
    private final long f12120t;

    /* renamed from: u, reason: collision with root package name */
    private final TimeInterpolator f12121u;

    /* renamed from: v, reason: collision with root package name */
    private int[] f12122v;

    /* renamed from: w, reason: collision with root package name */
    private int f12123w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f12124x;

    /* renamed from: y, reason: collision with root package name */
    private Integer f12125y;

    /* renamed from: z, reason: collision with root package name */
    private final float f12126z;

    protected static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.c<T> {

        /* renamed from: h, reason: collision with root package name */
        private int f12127h;

        /* renamed from: i, reason: collision with root package name */
        private int f12128i;

        /* renamed from: j, reason: collision with root package name */
        private ValueAnimator f12129j;

        /* renamed from: k, reason: collision with root package name */
        private c f12130k;

        /* renamed from: l, reason: collision with root package name */
        private WeakReference<View> f12131l;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f12132a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f12133b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f12132a = coordinatorLayout;
                this.f12133b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.k(this.f12132a, this.f12133b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b extends C0456a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f12135a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f12136b;

            b(AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout) {
                this.f12135a = appBarLayout;
                this.f12136b = coordinatorLayout;
            }

            @Override // androidx.core.view.C0456a
            public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
                View viewA;
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.d0(ScrollView.class.getName());
                if (this.f12135a.getTotalScrollRange() == 0 || (viewA = BaseBehavior.this.A(this.f12136b)) == null || !BaseBehavior.this.w(this.f12135a)) {
                    return;
                }
                if (BaseBehavior.this.h() != (-this.f12135a.getTotalScrollRange())) {
                    cVar.b(c.a.f1258q);
                    cVar.w0(true);
                }
                if (BaseBehavior.this.h() != 0) {
                    if (!viewA.canScrollVertically(-1)) {
                        cVar.b(c.a.f1259r);
                        cVar.w0(true);
                    } else if ((-this.f12135a.getDownNestedPreScrollRange()) != 0) {
                        cVar.b(c.a.f1259r);
                        cVar.w0(true);
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.C0456a
            public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
                if (i5 == 4096) {
                    this.f12135a.setExpanded(false);
                    return true;
                }
                if (i5 != 8192) {
                    return super.performAccessibilityAction(view, i5, bundle);
                }
                if (BaseBehavior.this.h() != 0) {
                    View viewA = BaseBehavior.this.A(this.f12136b);
                    if (!viewA.canScrollVertically(-1)) {
                        this.f12135a.setExpanded(true);
                        return true;
                    }
                    int i6 = -this.f12135a.getDownNestedPreScrollRange();
                    if (i6 != 0) {
                        BaseBehavior.this.onNestedPreScroll(this.f12136b, this.f12135a, viewA, 0, i6, new int[]{0, 0}, 1);
                        return true;
                    }
                }
                return false;
            }
        }

        public BaseBehavior() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public View A(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = coordinatorLayout.getChildAt(i5);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int D(T t5, int i5) {
            int iAbs = Math.abs(i5);
            int childCount = t5.getChildCount();
            int topInset = 0;
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    break;
                }
                View childAt = t5.getChildAt(i6);
                e eVar = (e) childAt.getLayoutParams();
                Interpolator interpolatorD = eVar.d();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i6++;
                } else if (interpolatorD != null) {
                    int iC = eVar.c();
                    if ((iC & 1) != 0) {
                        topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= childAt.getMinimumHeight();
                        }
                    }
                    if (childAt.getFitsSystemWindows()) {
                        topInset -= t5.getTopInset();
                    }
                    if (topInset > 0) {
                        float f5 = topInset;
                        return Integer.signum(i5) * (childAt.getTop() + Math.round(f5 * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f5)));
                    }
                }
            }
            return i5;
        }

        private boolean Q(CoordinatorLayout coordinatorLayout, T t5) {
            List<View> listF = coordinatorLayout.F(t5);
            int size = listF.size();
            for (int i5 = 0; i5 < size; i5++) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) listF.get(i5).getLayoutParams()).f();
                if (cVarF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) cVarF).getOverlayTop() != 0;
                }
            }
            return false;
        }

        private void R(CoordinatorLayout coordinatorLayout, T t5) {
            int topInset = t5.getTopInset() + t5.getPaddingTop();
            int iH = h() - topInset;
            int iZ = z(t5, iH);
            if (iZ >= 0) {
                View childAt = t5.getChildAt(iZ);
                e eVar = (e) childAt.getLayoutParams();
                int iC = eVar.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int minimumHeight = -childAt.getBottom();
                    if (iZ == 0 && t5.getFitsSystemWindows() && childAt.getFitsSystemWindows()) {
                        topInset2 -= t5.getTopInset();
                    }
                    if (v(iC, 2)) {
                        minimumHeight += childAt.getMinimumHeight();
                    } else if (v(iC, 5)) {
                        int minimumHeight2 = childAt.getMinimumHeight() + minimumHeight;
                        if (iH < minimumHeight2) {
                            topInset2 = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if (v(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) eVar).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    }
                    q(coordinatorLayout, t5, B.a.b(s(iH, minimumHeight, topInset2) + topInset, -t5.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void S(CoordinatorLayout coordinatorLayout, T t5, int i5, int i6, boolean z5) {
            View viewY = y(t5, i5);
            boolean zK = false;
            if (viewY != null) {
                int iC = ((e) viewY.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int minimumHeight = viewY.getMinimumHeight();
                    if (i6 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i5) < (viewY.getBottom() - minimumHeight) - t5.getTopInset()) : (-i5) >= (viewY.getBottom() - minimumHeight) - t5.getTopInset()) {
                        zK = true;
                    }
                }
            }
            if (t5.t()) {
                zK = t5.K(x(coordinatorLayout));
            }
            boolean zH = t5.H(zK);
            if (z5 || (zH && Q(coordinatorLayout, t5))) {
                if (t5.getBackground() != null) {
                    t5.getBackground().jumpToCurrentState();
                }
                if (t5.getForeground() != null) {
                    t5.getForeground().jumpToCurrentState();
                }
                if (t5.getStateListAnimator() != null) {
                    t5.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        private void p(CoordinatorLayout coordinatorLayout, T t5) {
            if (H.M(coordinatorLayout)) {
                return;
            }
            H.k0(coordinatorLayout, new b(t5, coordinatorLayout));
        }

        private void q(CoordinatorLayout coordinatorLayout, T t5, int i5, float f5) {
            int iAbs = Math.abs(h() - i5);
            float fAbs = Math.abs(f5);
            r(coordinatorLayout, t5, i5, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t5.getHeight()) + 1.0f) * 150.0f));
        }

        private void r(CoordinatorLayout coordinatorLayout, T t5, int i5, int i6) {
            int iH = h();
            if (iH == i5) {
                ValueAnimator valueAnimator = this.f12129j;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f12129j.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f12129j;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f12129j = valueAnimator3;
                valueAnimator3.setInterpolator(C0553a.f11787e);
                this.f12129j.addUpdateListener(new a(coordinatorLayout, t5));
            } else {
                valueAnimator2.cancel();
            }
            this.f12129j.setDuration(Math.min(i6, 600));
            this.f12129j.setIntValues(iH, i5);
            this.f12129j.start();
        }

        private int s(int i5, int i6, int i7) {
            return i5 < (i6 + i7) / 2 ? i6 : i7;
        }

        private boolean u(CoordinatorLayout coordinatorLayout, T t5, View view) {
            return t5.p() && coordinatorLayout.getHeight() - view.getHeight() <= t5.getHeight();
        }

        private static boolean v(int i5, int i6) {
            return (i5 & i6) == i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean w(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                if (((e) appBarLayout.getChildAt(i5).getLayoutParams()).f12146a != 0) {
                    return true;
                }
            }
            return false;
        }

        private View x(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = coordinatorLayout.getChildAt(i5);
                if ((childAt instanceof InterfaceC0474t) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View y(AppBarLayout appBarLayout, int i5) {
            int iAbs = Math.abs(i5);
            int childCount = appBarLayout.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = appBarLayout.getChildAt(i6);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int z(T t5, int i5) {
            int childCount = t5.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = t5.getChildAt(i6);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e eVar = (e) childAt.getLayoutParams();
                if (v(eVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) eVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) eVar).bottomMargin;
                }
                int i7 = -i5;
                if (top <= i7 && bottom >= i7) {
                    return i6;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.c
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public int f(T t5) {
            return (-t5.getDownNestedScrollRange()) + t5.getTopInset();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.c
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public int g(T t5) {
            return t5.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.c
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public void i(CoordinatorLayout coordinatorLayout, T t5) {
            R(coordinatorLayout, t5);
            if (t5.t()) {
                t5.H(t5.K(x(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.e, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, T t5, int i5) {
            boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, t5, i5);
            int pendingAction = t5.getPendingAction();
            c cVar = this.f12130k;
            if (cVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z5 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i6 = -t5.getUpNestedPreScrollRange();
                        if (z5) {
                            q(coordinatorLayout, t5, i6, 0.0f);
                        } else {
                            k(coordinatorLayout, t5, i6);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z5) {
                            q(coordinatorLayout, t5, 0, 0.0f);
                        } else {
                            k(coordinatorLayout, t5, 0);
                        }
                    }
                }
            } else if (cVar.f12138a) {
                k(coordinatorLayout, t5, -t5.getTotalScrollRange());
            } else if (cVar.f12139b) {
                k(coordinatorLayout, t5, 0);
            } else {
                View childAt = t5.getChildAt(cVar.f12140c);
                k(coordinatorLayout, t5, (-childAt.getBottom()) + (this.f12130k.f12142e ? childAt.getMinimumHeight() + t5.getTopInset() : Math.round(childAt.getHeight() * this.f12130k.f12141d)));
            }
            t5.D();
            this.f12130k = null;
            setTopAndBottomOffset(B.a.b(getTopAndBottomOffset(), -t5.getTotalScrollRange(), 0));
            S(coordinatorLayout, t5, getTopAndBottomOffset(), 0, true);
            t5.y(getTopAndBottomOffset());
            p(coordinatorLayout, t5);
            return zOnLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t5, int i5, int i6, int i7, int i8) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t5.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, t5, i5, i6, i7, i8);
            }
            coordinatorLayout.X(t5, i5, i6, View.MeasureSpec.makeMeasureSpec(0, 0), i8);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
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
                int r6 = r0.j(r1, r2, r3, r4, r5)
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
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t5, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
            BaseBehavior<T> baseBehavior;
            CoordinatorLayout coordinatorLayout2;
            T t6;
            int i10;
            if (i8 < 0) {
                baseBehavior = this;
                coordinatorLayout2 = coordinatorLayout;
                t6 = t5;
                i10 = i8;
                iArr[1] = baseBehavior.j(coordinatorLayout2, t6, i10, -t5.getDownNestedScrollRange(), 0);
            } else {
                baseBehavior = this;
                coordinatorLayout2 = coordinatorLayout;
                t6 = t5;
                i10 = i8;
            }
            if (i10 == 0) {
                baseBehavior.p(coordinatorLayout2, t6);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t5, Parcelable parcelable) {
            if (parcelable instanceof c) {
                N((c) parcelable, true);
                super.onRestoreInstanceState(coordinatorLayout, t5, this.f12130k.getSuperState());
            } else {
                super.onRestoreInstanceState(coordinatorLayout, t5, parcelable);
                this.f12130k = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, T t5) {
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t5);
            c cVarO = O(parcelableOnSaveInstanceState, t5);
            return cVarO == null ? parcelableOnSaveInstanceState : cVarO;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t5, View view, View view2, int i5, int i6) {
            ValueAnimator valueAnimator;
            boolean z5 = (i5 & 2) != 0 && (t5.t() || t5.v() || u(coordinatorLayout, t5, view));
            if (z5 && (valueAnimator = this.f12129j) != null) {
                valueAnimator.cancel();
            }
            this.f12131l = null;
            this.f12128i = i6;
            return z5;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t5, View view, int i5) {
            if (this.f12128i == 0 || i5 == 1) {
                R(coordinatorLayout, t5);
                if (t5.t()) {
                    t5.H(t5.K(view));
                }
            }
            this.f12131l = new WeakReference<>(view);
        }

        void N(c cVar, boolean z5) {
            if (this.f12130k == null || z5) {
                this.f12130k = cVar;
            }
        }

        c O(Parcelable parcelable, T t5) {
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t5.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = t5.getChildAt(i5);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = androidx.customview.view.a.EMPTY_STATE;
                    }
                    c cVar = new c(parcelable);
                    boolean z5 = topAndBottomOffset == 0;
                    cVar.f12139b = z5;
                    cVar.f12138a = !z5 && (-topAndBottomOffset) >= t5.getTotalScrollRange();
                    cVar.f12140c = i5;
                    cVar.f12142e = bottom == childAt.getMinimumHeight() + t5.getTopInset();
                    cVar.f12141d = bottom / childAt.getHeight();
                    return cVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.c
        /* renamed from: P, reason: merged with bridge method [inline-methods] */
        public int l(CoordinatorLayout coordinatorLayout, T t5, int i5, int i6, int i7) {
            int iH = h();
            int i8 = 0;
            if (i6 == 0 || iH < i6 || iH > i7) {
                this.f12127h = 0;
            } else {
                int iB = B.a.b(i5, i6, i7);
                if (iH != iB) {
                    int iD = t5.n() ? D(t5, iB) : iB;
                    boolean topAndBottomOffset = setTopAndBottomOffset(iD);
                    int i9 = iH - iB;
                    this.f12127h = iB - iD;
                    if (topAndBottomOffset) {
                        while (i8 < t5.getChildCount()) {
                            e eVar = (e) t5.getChildAt(i8).getLayoutParams();
                            c cVarB = eVar.b();
                            if (cVarB != null && (eVar.c() & 1) != 0) {
                                cVarB.a(t5, t5.getChildAt(i8), getTopAndBottomOffset());
                            }
                            i8++;
                        }
                    }
                    if (!topAndBottomOffset && t5.n()) {
                        coordinatorLayout.y(t5);
                    }
                    t5.y(getTopAndBottomOffset());
                    S(coordinatorLayout, t5, iB, iB < iH ? -1 : 1, false);
                    i8 = i9;
                }
            }
            p(coordinatorLayout, t5);
            return i8;
        }

        @Override // com.google.android.material.appbar.c
        int h() {
            return getTopAndBottomOffset() + this.f12127h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.c
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public boolean c(T t5) {
            WeakReference<View> weakReference = this.f12131l;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected static class c extends androidx.customview.view.a {
            public static final Parcelable.Creator<c> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            boolean f12138a;

            /* renamed from: b, reason: collision with root package name */
            boolean f12139b;

            /* renamed from: c, reason: collision with root package name */
            int f12140c;

            /* renamed from: d, reason: collision with root package name */
            float f12141d;

            /* renamed from: e, reason: collision with root package name */
            boolean f12142e;

            class a implements Parcelable.ClassLoaderCreator<c> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public c createFromParcel(Parcel parcel) {
                    return new c(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new c(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public c[] newArray(int i5) {
                    return new c[i5];
                }
            }

            public c(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f12138a = parcel.readByte() != 0;
                this.f12139b = parcel.readByte() != 0;
                this.f12140c = parcel.readInt();
                this.f12141d = parcel.readFloat();
                this.f12142e = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i5) {
                super.writeToParcel(parcel, i5);
                parcel.writeByte(this.f12138a ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f12139b ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f12140c);
                parcel.writeFloat(this.f12141d);
                parcel.writeByte(this.f12142e ? (byte) 1 : (byte) 0);
            }

            public c(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: F */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i5) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: G */
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i5, int i6, int i7, int i8) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i5, i6, i7, i8);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: H */
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i5, int i6, int[] iArr, int i7) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i5, i6, iArr, i7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: I */
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i5, i6, i7, i8, i9, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: J */
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: K */
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: L */
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i5, int i6) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i5, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: M */
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i5) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i5);
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
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z5) {
            super.setHorizontalOffsetEnabled(z5);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i5) {
            return super.setLeftAndRightOffset(i5);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i5) {
            return super.setTopAndBottomOffset(i5);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z5) {
            super.setVerticalOffsetEnabled(z5);
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
                return ((BaseBehavior) cVarF).h();
            }
            return 0;
        }

        private void offsetChildAsNeeded(View view, View view2) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                H.V(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVarF).f12127h) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
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
        /* bridge */ /* synthetic */ View findFirstDependency(List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.d
        float getOverlapRatioForOffset(View view) {
            int i5;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i5 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (appBarLayoutOffset / i5) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.d
        int getScrollRange(View view) {
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
                H.k0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.e, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i5) {
            return super.onLayoutChild(coordinatorLayout, view, i5);
        }

        @Override // com.google.android.material.appbar.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i5, int i6, int i7, int i8) {
            return super.onMeasureChild(coordinatorLayout, view, i5, i6, i7, i8);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z5) {
            AppBarLayout appBarLayoutFindFirstDependency = findFirstDependency(coordinatorLayout.E(view));
            if (appBarLayoutFindFirstDependency != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.tempRect1;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutFindFirstDependency.E(false, !z5);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z5) {
            super.setHorizontalOffsetEnabled(z5);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i5) {
            return super.setLeftAndRightOffset(i5);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i5) {
            return super.setTopAndBottomOffset(i5);
        }

        @Override // com.google.android.material.appbar.e
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z5) {
            super.setVerticalOffsetEnabled(z5);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7053T3);
            setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(C0418k.f7059U3, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.d
        AppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = list.get(i5);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    class a implements InterfaceC0479y {
        a() {
        }

        @Override // androidx.core.view.InterfaceC0479y
        public Y a(View view, Y y5) {
            return AppBarLayout.this.z(y5);
        }
    }

    public interface b<T extends AppBarLayout> {
        void a(T t5, int i5);
    }

    public static abstract class c {
        public abstract void a(AppBarLayout appBarLayout, View view, float f5);
    }

    public static class d extends c {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f12144a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        private final Rect f12145b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, View view, float f5) {
            b(this.f12144a, appBarLayout, view);
            float fAbs = this.f12144a.top - Math.abs(f5);
            if (fAbs > 0.0f) {
                view.setClipBounds(null);
                view.setTranslationY(0.0f);
                view.setAlpha(1.0f);
                return;
            }
            float fA = 1.0f - B.a.a(Math.abs(fAbs / this.f12144a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.f12144a.height() * 0.3f) * (1.0f - (fA * fA)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.f12145b);
            this.f12145b.offset(0, (int) (-fHeight));
            if (fHeight >= this.f12145b.height()) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(1.0f);
            }
            view.setClipBounds(this.f12145b);
        }
    }

    @Deprecated
    public interface f {
        void a(float f5, int i5);
    }

    public static abstract class g {
        public abstract void a(float f5, int i5, float f6);
    }

    public interface h extends b<AppBarLayout> {
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0409b.f6714a);
    }

    private void F(boolean z5, boolean z6, boolean z7) {
        this.f12106f = (z5 ? 1 : 2) | (z6 ? 4 : 0) | (z7 ? 8 : 0);
        requestLayout();
    }

    private boolean G(boolean z5) {
        if (this.f12110j == z5) {
            return false;
        }
        this.f12110j = z5;
        refreshDrawableState();
        return true;
    }

    private boolean J() {
        return this.f12124x != null && getTopInset() > 0;
    }

    private boolean L() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                return true;
            }
        }
        return false;
    }

    private void M(float f5, float f6) {
        ValueAnimator valueAnimator = this.f12116p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f5, f6);
        this.f12116p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f12120t);
        this.f12116p.setInterpolator(this.f12121u);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f12117q;
        if (animatorUpdateListener != null) {
            this.f12116p.addUpdateListener(animatorUpdateListener);
        }
        this.f12116p.start();
    }

    private void N() {
        setWillNotDraw(!J());
    }

    public static /* synthetic */ void c(AppBarLayout appBarLayout, C1115h c1115h, ValueAnimator valueAnimator) {
        appBarLayout.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        c1115h.f0(fFloatValue);
        Drawable drawable = appBarLayout.f12124x;
        if (drawable instanceof C1115h) {
            ((C1115h) drawable).f0(fFloatValue);
        }
        Iterator<f> it = appBarLayout.f12118r.iterator();
        while (it.hasNext()) {
            it.next().a(fFloatValue, c1115h.E());
        }
        Iterator<g> it2 = appBarLayout.f12119s.iterator();
        while (it2.hasNext()) {
            it2.next().a(fFloatValue, c1115h.E(), fFloatValue / appBarLayout.f12126z);
        }
    }

    public static /* synthetic */ void d(AppBarLayout appBarLayout, ColorStateList colorStateList, C1115h c1115h, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        appBarLayout.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int iJ = C0777a.j(appBarLayout.f12123w, colorStateList.getDefaultColor(), fFloatValue);
        c1115h.g0(ColorStateList.valueOf(iJ));
        if (appBarLayout.f12124x != null && (num2 = appBarLayout.f12125y) != null && num2.equals(num)) {
            appBarLayout.f12124x.setTint(iJ);
        }
        if (!appBarLayout.f12118r.isEmpty()) {
            for (f fVar : appBarLayout.f12118r) {
                if (c1115h.B() != null) {
                    fVar.a(0.0f, iJ);
                }
            }
        }
        if (appBarLayout.f12119s.isEmpty()) {
            return;
        }
        Iterator<g> it = appBarLayout.f12119s.iterator();
        while (it.hasNext()) {
            it.next().a(0.0f, iJ, fFloatValue);
        }
    }

    private void h() {
        WeakReference<View> weakReference = this.f12115o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f12115o = null;
    }

    private Integer i() {
        Drawable drawable = this.f12124x;
        if (drawable instanceof C1115h) {
            return Integer.valueOf(((C1115h) drawable).E());
        }
        ColorStateList colorStateListF = com.google.android.material.drawable.a.f(drawable);
        if (colorStateListF != null) {
            return Integer.valueOf(colorStateListF.getDefaultColor());
        }
        return null;
    }

    private View j(View view) {
        int i5;
        if (this.f12115o == null && (i5 = this.f12114n) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i5) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f12114n);
            }
            if (viewFindViewById != null) {
                this.f12115o = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f12115o;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean o() {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((e) getChildAt(i5).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void q(final C1115h c1115h, final ColorStateList colorStateList) {
        final Integer numF = C0777a.f(getContext(), C0409b.f6720g);
        this.f12117q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.d(this.f12168a, colorStateList, c1115h, numF, valueAnimator);
            }
        };
    }

    private void r(Context context, final C1115h c1115h) {
        c1115h.U(context);
        this.f12117q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.c(this.f12172a, c1115h, valueAnimator);
            }
        };
    }

    private void s() {
        Behavior behavior = this.f12100A;
        BaseBehavior.c cVarO = (behavior == null || this.f12102b == -1 || this.f12106f != 0) ? null : behavior.O(androidx.customview.view.a.EMPTY_STATE, this);
        this.f12102b = -1;
        this.f12103c = -1;
        this.f12104d = -1;
        if (cVarO != null) {
            this.f12100A.N(cVarO, false);
        }
    }

    private boolean u() {
        return getBackground() instanceof C1115h;
    }

    private C1115h w(Drawable drawable) {
        if (drawable instanceof C1115h) {
            return (C1115h) drawable;
        }
        ColorStateList colorStateListF = com.google.android.material.drawable.a.f(drawable);
        if (colorStateListF == null) {
            return null;
        }
        C1115h c1115h = new C1115h();
        c1115h.g0(colorStateListF);
        return c1115h;
    }

    private Drawable x(Context context, Drawable drawable) {
        C1115h c1115hW = w(drawable);
        if (c1115hW == null || c1115hW.B() == null) {
            return drawable;
        }
        this.f12123w = c1115hW.B().getDefaultColor();
        ColorStateList colorStateList = this.f12113m;
        if (colorStateList != null) {
            q(c1115hW, colorStateList);
            return c1115hW;
        }
        r(context, c1115hW);
        return c1115hW;
    }

    public boolean A(g gVar) {
        return this.f12119s.remove(gVar);
    }

    public void B(b bVar) {
        List<b> list = this.f12108h;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    public void C(h hVar) {
        B(hVar);
    }

    void D() {
        this.f12106f = 0;
    }

    public void E(boolean z5, boolean z6) {
        F(z5, z6, true);
    }

    boolean H(boolean z5) {
        return I(z5, !this.f12109i);
    }

    boolean I(boolean z5, boolean z6) {
        if (!z6 || this.f12111k == z5) {
            return false;
        }
        this.f12111k = z5;
        refreshDrawableState();
        if (!u()) {
            return true;
        }
        if (this.f12113m != null) {
            M(z5 ? 0.0f : 1.0f, z5 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f12112l) {
            return true;
        }
        M(z5 ? 0.0f : this.f12126z, z5 ? this.f12126z : 0.0f);
        return true;
    }

    boolean K(View view) {
        View viewJ = j(view);
        if (viewJ != null) {
            view = viewJ;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (J()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f12101a);
            this.f12124x.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f12124x;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public void e(g gVar) {
        this.f12119s.add(gVar);
    }

    public void f(b bVar) {
        if (this.f12108h == null) {
            this.f12108h = new ArrayList();
        }
        if (bVar == null || this.f12108h.contains(bVar)) {
            return;
        }
        this.f12108h.add(bVar);
    }

    public void g(h hVar) {
        f(hVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f12100A = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i5 = this.f12103c;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = eVar.f12146a;
                if ((i7 & 5) != 5) {
                    if (i6 > 0) {
                        break;
                    }
                } else {
                    int i8 = ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    if ((i7 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i7 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i8 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i6 += iMin;
                    }
                    iMin = i8 + minimumHeight;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i6 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i6);
        this.f12103c = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i5 = this.f12104d;
        if (i5 != -1) {
            return i5;
        }
        int childCount = getChildCount();
        int i6 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                int i7 = eVar.f12146a;
                if ((i7 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i7 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i6++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f12104d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f12114n;
    }

    public C1115h getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof C1115h) {
            return (C1115h) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i5 = (minimumHeight * 2) + topInset;
            return i5 < getHeight() ? i5 : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i6 = (minimumHeight2 * 2) + topInset;
        return i6 < getHeight() ? i6 : minimumHeight2 + topInset;
    }

    int getPendingAction() {
        return this.f12106f;
    }

    public Drawable getStatusBarForeground() {
        return this.f12124x;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        Y y5 = this.f12107g;
        if (y5 != null) {
            return y5.k();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i5 = this.f12102b;
        if (i5 != -1) {
            return i5;
        }
        int childCount = getChildCount();
        int i6 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = eVar.f12146a;
                if ((i7 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                if (i6 == 0 && childAt.getFitsSystemWindows()) {
                    minimumHeight -= getTopInset();
                }
                if ((i7 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i6++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f12102b = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new e((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    boolean n() {
        return this.f12105e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C1116i.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        if (this.f12122v == null) {
            this.f12122v = new int[4];
        }
        int[] iArr = this.f12122v;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + iArr.length);
        boolean z5 = this.f12110j;
        int i6 = C0409b.f6709S;
        if (!z5) {
            i6 = -i6;
        }
        iArr[0] = i6;
        iArr[1] = (z5 && this.f12111k) ? C0409b.f6710T : -C0409b.f6710T;
        int i7 = C0409b.f6705O;
        if (!z5) {
            i7 = -i7;
        }
        iArr[2] = i7;
        iArr[3] = (z5 && this.f12111k) ? C0409b.f6704N : -C0409b.f6704N;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        boolean z6 = true;
        if (getFitsSystemWindows() && L()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                H.V(getChildAt(childCount), topInset);
            }
        }
        s();
        this.f12105e = false;
        int childCount2 = getChildCount();
        int i9 = 0;
        while (true) {
            if (i9 >= childCount2) {
                break;
            }
            if (((e) getChildAt(i9).getLayoutParams()).d() != null) {
                this.f12105e = true;
                break;
            }
            i9++;
        }
        Drawable drawable = this.f12124x;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f12109i) {
            return;
        }
        if (!this.f12112l && !o()) {
            z6 = false;
        }
        G(z6);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i6);
        if (mode != 1073741824 && getFitsSystemWindows() && L()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = B.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i6));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        s();
    }

    boolean p() {
        return getTotalScrollRange() != 0;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(x(getContext(), drawable));
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        C1116i.d(this, f5);
    }

    public void setExpanded(boolean z5) {
        E(z5, isLaidOut());
    }

    public void setLiftOnScroll(boolean z5) {
        this.f12112l = z5;
    }

    public void setLiftOnScrollColor(ColorStateList colorStateList) {
        if (this.f12113m != colorStateList) {
            this.f12113m = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f12114n = -1;
        if (view == null) {
            h();
        } else {
            this.f12115o = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i5) {
        this.f12114n = i5;
        h();
    }

    public void setLiftableOverrideEnabled(boolean z5) {
        this.f12109i = z5;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i5) {
        if (i5 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i5);
    }

    void setPendingAction(int i5) {
        this.f12106f = i5;
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f12124x;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f12124x = drawable != null ? drawable.mutate() : null;
            this.f12125y = i();
            Drawable drawable3 = this.f12124x;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f12124x.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.f12124x, getLayoutDirection());
                this.f12124x.setVisible(getVisibility() == 0, false);
                this.f12124x.setCallback(this);
            }
            N();
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i5) {
        setStatusBarForeground(new ColorDrawable(i5));
    }

    public void setStatusBarForegroundResource(int i5) {
        setStatusBarForeground(C0744a.b(getContext(), i5));
    }

    @Deprecated
    public void setTargetElevation(float f5) throws Resources.NotFoundException {
        com.google.android.material.appbar.g.b(this, f5);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z5 = i5 == 0;
        Drawable drawable = this.f12124x;
        if (drawable != null) {
            drawable.setVisible(z5, false);
        }
    }

    public boolean t() {
        return this.f12112l;
    }

    public boolean v() {
        return this.f12111k;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f12124x;
    }

    void y(int i5) {
        this.f12101a = i5;
        if (!willNotDraw()) {
            postInvalidateOnAnimation();
        }
        List<b> list = this.f12108h;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                b bVar = this.f12108h.get(i6);
                if (bVar != null) {
                    bVar.a(this, i5);
                }
            }
        }
    }

    Y z(Y y5) {
        Y y6 = getFitsSystemWindows() ? y5 : null;
        if (!D.c.a(this.f12107g, y6)) {
            this.f12107g = y6;
            N();
            requestLayout();
        }
        return y5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        int i6 = f12099B;
        super(C1282a.d(context, attributeSet, i5, i6), attributeSet, i5);
        this.f12102b = -1;
        this.f12103c = -1;
        this.f12104d = -1;
        this.f12106f = 0;
        this.f12118r = new ArrayList();
        this.f12119s = new LinkedHashSet<>();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            com.google.android.material.appbar.g.a(this);
        }
        com.google.android.material.appbar.g.c(this, attributeSet, i5, i6);
        TypedArray typedArrayI = o.i(context2, attributeSet, C0418k.f7091a, i5, i6, new int[0]);
        this.f12113m = C0981c.a(context2, typedArrayI, C0418k.f7138h);
        this.f12120t = o1.e.f(context2, C0409b.f6738y, getResources().getInteger(C0414g.f6864a));
        this.f12121u = o1.e.g(context2, C0409b.f6698H, C0553a.f11783a);
        int i7 = C0418k.f7126f;
        if (typedArrayI.hasValue(i7)) {
            F(typedArrayI.getBoolean(i7, false), false, false);
        }
        if (typedArrayI.hasValue(C0418k.f7119e)) {
            com.google.android.material.appbar.g.b(this, typedArrayI.getDimensionPixelSize(r10, 0));
        }
        setBackground(typedArrayI.getDrawable(C0418k.f7098b));
        int i8 = C0418k.f7112d;
        if (typedArrayI.hasValue(i8)) {
            setKeyboardNavigationCluster(typedArrayI.getBoolean(i8, false));
        }
        int i9 = C0418k.f7105c;
        if (typedArrayI.hasValue(i9)) {
            setTouchscreenBlocksFocus(typedArrayI.getBoolean(i9, false));
        }
        this.f12126z = getResources().getDimension(C0411d.f6772a);
        this.f12112l = typedArrayI.getBoolean(C0418k.f7132g, false);
        this.f12114n = typedArrayI.getResourceId(C0418k.f7144i, -1);
        setStatusBarForeground(typedArrayI.getDrawable(C0418k.f7150j));
        typedArrayI.recycle();
        H.w0(this, new a());
    }

    public static class e extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f12146a;

        /* renamed from: b, reason: collision with root package name */
        private c f12147b;

        /* renamed from: c, reason: collision with root package name */
        Interpolator f12148c;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12146a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7162l);
            this.f12146a = typedArrayObtainStyledAttributes.getInt(C0418k.f7174n, 0);
            f(typedArrayObtainStyledAttributes.getInt(C0418k.f7168m, 0));
            int i5 = C0418k.f7180o;
            if (typedArrayObtainStyledAttributes.hasValue(i5)) {
                this.f12148c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i5, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        private c a(int i5) {
            if (i5 != 1) {
                return null;
            }
            return new d();
        }

        public c b() {
            return this.f12147b;
        }

        public int c() {
            return this.f12146a;
        }

        public Interpolator d() {
            return this.f12148c;
        }

        boolean e() {
            int i5 = this.f12146a;
            return (i5 & 1) == 1 && (i5 & 10) != 0;
        }

        public void f(int i5) {
            this.f12147b = a(i5);
        }

        public void g(int i5) {
            this.f12146a = i5;
        }

        public e(int i5, int i6) {
            super(i5, i6);
            this.f12146a = 1;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12146a = 1;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f12146a = 1;
        }

        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12146a = 1;
        }
    }
}
