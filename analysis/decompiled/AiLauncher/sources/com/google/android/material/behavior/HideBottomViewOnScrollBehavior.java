package com.google.android.material.behavior;

import T2.h;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.util.Iterator;
import java.util.LinkedHashSet;

@Deprecated
/* loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: m, reason: collision with root package name */
    public static final int f20316m = R$attr.motionDurationLong2;

    /* renamed from: n, reason: collision with root package name */
    public static final int f20317n = R$attr.motionDurationMedium4;

    /* renamed from: o, reason: collision with root package name */
    public static final int f20318o = R$attr.motionEasingEmphasizedInterpolator;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<c> f20319a;

    /* renamed from: b, reason: collision with root package name */
    public int f20320b;

    /* renamed from: c, reason: collision with root package name */
    public int f20321c;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f20322d;

    /* renamed from: e, reason: collision with root package name */
    public TimeInterpolator f20323e;

    /* renamed from: f, reason: collision with root package name */
    public int f20324f;

    /* renamed from: g, reason: collision with root package name */
    public AccessibilityManager f20325g;

    /* renamed from: h, reason: collision with root package name */
    public AccessibilityManager.TouchExplorationStateChangeListener f20326h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20327i;

    /* renamed from: j, reason: collision with root package name */
    public int f20328j;

    /* renamed from: k, reason: collision with root package name */
    public int f20329k;

    /* renamed from: l, reason: collision with root package name */
    public ViewPropertyAnimator f20330l;

    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (HideBottomViewOnScrollBehavior.this.f20326h == null || HideBottomViewOnScrollBehavior.this.f20325g == null) {
                return;
            }
            HideBottomViewOnScrollBehavior.this.f20325g.removeTouchExplorationStateChangeListener(HideBottomViewOnScrollBehavior.this.f20326h);
            HideBottomViewOnScrollBehavior.this.f20326h = null;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f20330l = null;
        }
    }

    public interface c {
        void a(View view, int i10);
    }

    public HideBottomViewOnScrollBehavior() {
        this.f20319a = new LinkedHashSet<>();
        this.f20324f = 0;
        this.f20327i = true;
        this.f20328j = 2;
        this.f20329k = 0;
    }

    public static /* synthetic */ void g(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, View view, boolean z10) {
        if (!z10) {
            hideBottomViewOnScrollBehavior.getClass();
        } else if (hideBottomViewOnScrollBehavior.n()) {
            hideBottomViewOnScrollBehavior.s(view);
        }
    }

    public final void l(V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f20330l = v10.animate().translationY(i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new b());
    }

    public final void m(final V v10) {
        if (this.f20325g == null) {
            this.f20325g = (AccessibilityManager) androidx.core.content.a.i(v10.getContext(), AccessibilityManager.class);
        }
        if (this.f20325g == null || this.f20326h != null) {
            return;
        }
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: F2.a
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                HideBottomViewOnScrollBehavior.g(this.f2573a, v10, z10);
            }
        };
        this.f20326h = touchExplorationStateChangeListener;
        this.f20325g.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        v10.addOnAttachStateChangeListener(new a());
    }

    public boolean n() {
        return this.f20328j == 1;
    }

    public boolean o() {
        return this.f20328j == 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        this.f20324f = v10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v10.getLayoutParams()).bottomMargin;
        this.f20320b = h.f(v10.getContext(), f20316m, 225);
        this.f20321c = h.f(v10.getContext(), f20317n, 175);
        Context context = v10.getContext();
        int i11 = f20318o;
        this.f20322d = h.g(context, i11, E2.a.f2342d);
        this.f20323e = h.g(v10.getContext(), i11, E2.a.f2341c);
        m(v10);
        return super.onLayoutChild(coordinatorLayout, v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i11 > 0) {
            q(v10);
        } else if (i11 < 0) {
            s(v10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        return i10 == 2;
    }

    public void p(V v10, int i10) {
        this.f20329k = i10;
        if (this.f20328j == 1) {
            v10.setTranslationY(this.f20324f + i10);
        }
    }

    public void q(V v10) {
        r(v10, true);
    }

    public void r(V v10, boolean z10) {
        AccessibilityManager accessibilityManager;
        if (n()) {
            return;
        }
        if (this.f20327i && (accessibilityManager = this.f20325g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f20330l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        u(v10, 1);
        int i10 = this.f20324f + this.f20329k;
        if (z10) {
            l(v10, i10, this.f20321c, this.f20323e);
        } else {
            v10.setTranslationY(i10);
        }
    }

    public void s(V v10) {
        t(v10, true);
    }

    public void t(V v10, boolean z10) {
        if (o()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f20330l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        u(v10, 2);
        if (z10) {
            l(v10, 0, this.f20320b, this.f20322d);
        } else {
            v10.setTranslationY(0);
        }
    }

    public final void u(V v10, int i10) {
        this.f20328j = i10;
        Iterator<c> it = this.f20319a.iterator();
        while (it.hasNext()) {
            it.next().a(v10, this.f20328j);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20319a = new LinkedHashSet<>();
        this.f20324f = 0;
        this.f20327i = true;
        this.f20328j = 2;
        this.f20329k = 0;
    }
}
