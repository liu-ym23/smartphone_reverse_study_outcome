package com.google.android.material.behavior;

import a1.C0409b;
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
import b1.C0553a;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import java.util.Iterator;
import java.util.LinkedHashSet;
import o1.e;

/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: o, reason: collision with root package name */
    private static final int f12209o = C0409b.f6736w;

    /* renamed from: p, reason: collision with root package name */
    private static final int f12210p = C0409b.f6739z;

    /* renamed from: q, reason: collision with root package name */
    private static final int f12211q = C0409b.f6696F;

    /* renamed from: a, reason: collision with root package name */
    private d f12212a;

    /* renamed from: b, reason: collision with root package name */
    private AccessibilityManager f12213b;

    /* renamed from: c, reason: collision with root package name */
    private AccessibilityManager.TouchExplorationStateChangeListener f12214c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12215d;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashSet<c> f12216e;

    /* renamed from: f, reason: collision with root package name */
    private int f12217f;

    /* renamed from: g, reason: collision with root package name */
    private int f12218g;

    /* renamed from: h, reason: collision with root package name */
    private TimeInterpolator f12219h;

    /* renamed from: i, reason: collision with root package name */
    private TimeInterpolator f12220i;

    /* renamed from: j, reason: collision with root package name */
    private int f12221j;

    /* renamed from: k, reason: collision with root package name */
    private int f12222k;

    /* renamed from: l, reason: collision with root package name */
    private int f12223l;

    /* renamed from: m, reason: collision with root package name */
    private ViewPropertyAnimator f12224m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f12225n;

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (HideViewOnScrollBehavior.this.f12214c == null || HideViewOnScrollBehavior.this.f12213b == null) {
                return;
            }
            HideViewOnScrollBehavior.this.f12213b.removeTouchExplorationStateChangeListener(HideViewOnScrollBehavior.this.f12214c);
            HideViewOnScrollBehavior.this.f12214c = null;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideViewOnScrollBehavior.this.f12224m = null;
        }
    }

    public interface c {
        void a(View view, int i5);
    }

    public HideViewOnScrollBehavior() {
        this.f12215d = true;
        this.f12216e = new LinkedHashSet<>();
        this.f12221j = 0;
        this.f12222k = 2;
        this.f12223l = 0;
        this.f12225n = false;
    }

    public static /* synthetic */ void c(HideViewOnScrollBehavior hideViewOnScrollBehavior, View view, boolean z5) {
        if (hideViewOnScrollBehavior.f12215d && z5 && hideViewOnScrollBehavior.m()) {
            hideViewOnScrollBehavior.p(view);
        }
    }

    private void h(V v5, int i5, long j5, TimeInterpolator timeInterpolator) {
        this.f12224m = this.f12212a.d(v5, i5).setInterpolator(timeInterpolator).setDuration(j5).setListener(new b());
    }

    private void i(final V v5) {
        if (this.f12213b == null) {
            this.f12213b = (AccessibilityManager) androidx.core.content.a.h(v5.getContext(), AccessibilityManager.class);
        }
        if (this.f12213b == null || this.f12214c != null) {
            return;
        }
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: c1.b
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z5) {
                HideViewOnScrollBehavior.c(this.f11949a, v5, z5);
            }
        };
        this.f12214c = touchExplorationStateChangeListener;
        this.f12213b.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        v5.addOnAttachStateChangeListener(new a());
    }

    private boolean j(int i5) {
        return i5 == 80 || i5 == 81;
    }

    private boolean k(int i5) {
        return i5 == 3 || i5 == 19;
    }

    private void n(V v5, int i5) {
        if (this.f12225n) {
            return;
        }
        int i6 = ((CoordinatorLayout.f) v5.getLayoutParams()).f9427c;
        if (j(i6)) {
            o(1);
        } else {
            o(k(Gravity.getAbsoluteGravity(i6, i5)) ? 2 : 0);
        }
    }

    private void o(int i5) {
        d dVar = this.f12212a;
        if (dVar == null || dVar.c() != i5) {
            if (i5 == 0) {
                this.f12212a = new com.google.android.material.behavior.c();
                return;
            }
            if (i5 == 1) {
                this.f12212a = new com.google.android.material.behavior.a();
                return;
            }
            if (i5 == 2) {
                this.f12212a = new com.google.android.material.behavior.b();
                return;
            }
            throw new IllegalArgumentException("Invalid view edge position value: " + i5 + ". Must be 0, 1 or 2.");
        }
    }

    private void t(V v5, int i5) {
        this.f12222k = i5;
        Iterator<c> it = this.f12216e.iterator();
        while (it.hasNext()) {
            it.next().a(v5, this.f12222k);
        }
    }

    public boolean l() {
        return this.f12222k == 2;
    }

    public boolean m() {
        return this.f12222k == 1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v5, int i5) {
        i(v5);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v5.getLayoutParams();
        n(v5, i5);
        this.f12221j = this.f12212a.a(v5, marginLayoutParams);
        this.f12217f = e.f(v5.getContext(), f12209o, 225);
        this.f12218g = e.f(v5.getContext(), f12210p, 175);
        Context context = v5.getContext();
        int i6 = f12211q;
        this.f12219h = e.g(context, i6, C0553a.f11786d);
        this.f12220i = e.g(v5.getContext(), i6, C0553a.f11785c);
        return super.onLayoutChild(coordinatorLayout, v5, i5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        if (i6 > 0) {
            r(v5);
        } else if (i6 < 0) {
            p(v5);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i5, int i6) {
        return i5 == 2;
    }

    public void p(V v5) {
        q(v5, true);
    }

    public void q(V v5, boolean z5) {
        if (l()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f12224m;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v5.clearAnimation();
        }
        t(v5, 2);
        int iB = this.f12212a.b();
        if (z5) {
            h(v5, iB, this.f12217f, this.f12219h);
        } else {
            this.f12212a.e(v5, iB);
        }
    }

    public void r(V v5) {
        s(v5, true);
    }

    public void s(V v5, boolean z5) {
        AccessibilityManager accessibilityManager;
        if (m()) {
            return;
        }
        if (this.f12215d && (accessibilityManager = this.f12213b) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f12224m;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v5.clearAnimation();
        }
        t(v5, 1);
        int i5 = this.f12221j + this.f12223l;
        if (z5) {
            h(v5, i5, this.f12218g, this.f12220i);
        } else {
            this.f12212a.e(v5, i5);
        }
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12215d = true;
        this.f12216e = new LinkedHashSet<>();
        this.f12221j = 0;
        this.f12222k = 2;
        this.f12223l = 0;
        this.f12225n = false;
    }
}
