package com.google.android.material.behavior;

import F2.d;
import F2.f;
import T2.h;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: o, reason: collision with root package name */
    public static final int f20333o = R$attr.motionDurationLong2;

    /* renamed from: p, reason: collision with root package name */
    public static final int f20334p = R$attr.motionDurationMedium4;

    /* renamed from: q, reason: collision with root package name */
    public static final int f20335q = R$attr.motionEasingEmphasizedInterpolator;

    /* renamed from: a, reason: collision with root package name */
    public f f20336a;

    /* renamed from: b, reason: collision with root package name */
    public AccessibilityManager f20337b;

    /* renamed from: c, reason: collision with root package name */
    public AccessibilityManager.TouchExplorationStateChangeListener f20338c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20339d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<c> f20340e;

    /* renamed from: f, reason: collision with root package name */
    public int f20341f;

    /* renamed from: g, reason: collision with root package name */
    public int f20342g;

    /* renamed from: h, reason: collision with root package name */
    public TimeInterpolator f20343h;

    /* renamed from: i, reason: collision with root package name */
    public TimeInterpolator f20344i;

    /* renamed from: j, reason: collision with root package name */
    public int f20345j;

    /* renamed from: k, reason: collision with root package name */
    public int f20346k;

    /* renamed from: l, reason: collision with root package name */
    public int f20347l;

    /* renamed from: m, reason: collision with root package name */
    public ViewPropertyAnimator f20348m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20349n;

    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (HideViewOnScrollBehavior.this.f20338c == null || HideViewOnScrollBehavior.this.f20337b == null) {
                return;
            }
            HideViewOnScrollBehavior.this.f20337b.removeTouchExplorationStateChangeListener(HideViewOnScrollBehavior.this.f20338c);
            HideViewOnScrollBehavior.this.f20338c = null;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideViewOnScrollBehavior.this.f20348m = null;
        }
    }

    public interface c {
        void a(View view, int i10);
    }

    public HideViewOnScrollBehavior() {
        this.f20339d = true;
        this.f20340e = new LinkedHashSet<>();
        this.f20345j = 0;
        this.f20346k = 2;
        this.f20347l = 0;
        this.f20349n = false;
    }

    public static /* synthetic */ void g(HideViewOnScrollBehavior hideViewOnScrollBehavior, View view, boolean z10) {
        if (hideViewOnScrollBehavior.f20339d && z10 && hideViewOnScrollBehavior.q()) {
            hideViewOnScrollBehavior.t(view);
        }
    }

    private void l(V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f20348m = this.f20336a.d(v10, i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new b());
    }

    private void m(final V v10) {
        if (this.f20337b == null) {
            this.f20337b = (AccessibilityManager) androidx.core.content.a.i(v10.getContext(), AccessibilityManager.class);
        }
        if (this.f20337b == null || this.f20338c != null) {
            return;
        }
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: F2.e
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                HideViewOnScrollBehavior.g(this.f2575a, v10, z10);
            }
        };
        this.f20338c = touchExplorationStateChangeListener;
        this.f20337b.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        v10.addOnAttachStateChangeListener(new a());
    }

    private void x(V v10, int i10) {
        this.f20346k = i10;
        Iterator<c> it = this.f20340e.iterator();
        while (it.hasNext()) {
            it.next().a(v10, this.f20346k);
        }
    }

    public final boolean n(int i10) {
        return i10 == 80 || i10 == 81;
    }

    public final boolean o(int i10) {
        return i10 == 3 || i10 == 19;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        m(v10);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        r(v10, i10);
        this.f20345j = this.f20336a.a(v10, marginLayoutParams);
        this.f20341f = h.f(v10.getContext(), f20333o, 225);
        this.f20342g = h.f(v10.getContext(), f20334p, 175);
        Context context = v10.getContext();
        int i11 = f20335q;
        this.f20343h = h.g(context, i11, E2.a.f2342d);
        this.f20344i = h.g(v10.getContext(), i11, E2.a.f2341c);
        return super.onLayoutChild(coordinatorLayout, v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i11 > 0) {
            v(v10);
        } else if (i11 < 0) {
            t(v10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        return i10 == 2;
    }

    public boolean p() {
        return this.f20346k == 2;
    }

    public boolean q() {
        return this.f20346k == 1;
    }

    public final void r(V v10, int i10) {
        if (this.f20349n) {
            return;
        }
        int i11 = ((CoordinatorLayout.f) v10.getLayoutParams()).f12909c;
        if (n(i11)) {
            s(1);
        } else {
            s(o(Gravity.getAbsoluteGravity(i11, i10)) ? 2 : 0);
        }
    }

    public final void s(int i10) {
        f fVar = this.f20336a;
        if (fVar == null || fVar.c() != i10) {
            if (i10 == 0) {
                this.f20336a = new d();
                return;
            }
            if (i10 == 1) {
                this.f20336a = new F2.b();
                return;
            }
            if (i10 == 2) {
                this.f20336a = new F2.c();
                return;
            }
            throw new IllegalArgumentException("Invalid view edge position value: " + i10 + ". Must be 0, 1 or 2.");
        }
    }

    public void t(V v10) {
        u(v10, true);
    }

    public void u(V v10, boolean z10) {
        if (p()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f20348m;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        x(v10, 2);
        int iB = this.f20336a.b();
        if (z10) {
            l(v10, iB, this.f20341f, this.f20343h);
        } else {
            this.f20336a.e(v10, iB);
        }
    }

    public void v(V v10) {
        w(v10, true);
    }

    public void w(V v10, boolean z10) {
        AccessibilityManager accessibilityManager;
        if (q()) {
            return;
        }
        if (this.f20339d && (accessibilityManager = this.f20337b) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f20348m;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        x(v10, 1);
        int i10 = this.f20345j + this.f20347l;
        if (z10) {
            l(v10, i10, this.f20342g, this.f20344i);
        } else {
            this.f20336a.e(v10, i10);
        }
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20339d = true;
        this.f20340e = new LinkedHashSet<>();
        this.f20345j = 0;
        this.f20346k = 2;
        this.f20347l = 0;
        this.f20349n = false;
    }
}
