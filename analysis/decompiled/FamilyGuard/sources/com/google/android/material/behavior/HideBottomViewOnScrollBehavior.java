package com.google.android.material.behavior;

import a1.C0409b;
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
import b1.C0553a;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.util.Iterator;
import java.util.LinkedHashSet;
import o1.e;

@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: m, reason: collision with root package name */
    private static final int f12192m = C0409b.f6736w;

    /* renamed from: n, reason: collision with root package name */
    private static final int f12193n = C0409b.f6739z;

    /* renamed from: o, reason: collision with root package name */
    private static final int f12194o = C0409b.f6696F;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashSet<c> f12195a;

    /* renamed from: b, reason: collision with root package name */
    private int f12196b;

    /* renamed from: c, reason: collision with root package name */
    private int f12197c;

    /* renamed from: d, reason: collision with root package name */
    private TimeInterpolator f12198d;

    /* renamed from: e, reason: collision with root package name */
    private TimeInterpolator f12199e;

    /* renamed from: f, reason: collision with root package name */
    private int f12200f;

    /* renamed from: g, reason: collision with root package name */
    private AccessibilityManager f12201g;

    /* renamed from: h, reason: collision with root package name */
    private AccessibilityManager.TouchExplorationStateChangeListener f12202h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12203i;

    /* renamed from: j, reason: collision with root package name */
    private int f12204j;

    /* renamed from: k, reason: collision with root package name */
    private int f12205k;

    /* renamed from: l, reason: collision with root package name */
    private ViewPropertyAnimator f12206l;

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (HideBottomViewOnScrollBehavior.this.f12202h == null || HideBottomViewOnScrollBehavior.this.f12201g == null) {
                return;
            }
            HideBottomViewOnScrollBehavior.this.f12201g.removeTouchExplorationStateChangeListener(HideBottomViewOnScrollBehavior.this.f12202h);
            HideBottomViewOnScrollBehavior.this.f12202h = null;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f12206l = null;
        }
    }

    public interface c {
        void a(View view, int i5);
    }

    public HideBottomViewOnScrollBehavior() {
        this.f12195a = new LinkedHashSet<>();
        this.f12200f = 0;
        this.f12203i = true;
        this.f12204j = 2;
        this.f12205k = 0;
    }

    public static /* synthetic */ void c(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, View view, boolean z5) {
        if (!z5) {
            hideBottomViewOnScrollBehavior.getClass();
        } else if (hideBottomViewOnScrollBehavior.j()) {
            hideBottomViewOnScrollBehavior.o(view);
        }
    }

    private void h(V v5, int i5, long j5, TimeInterpolator timeInterpolator) {
        this.f12206l = v5.animate().translationY(i5).setInterpolator(timeInterpolator).setDuration(j5).setListener(new b());
    }

    private void i(final V v5) {
        if (this.f12201g == null) {
            this.f12201g = (AccessibilityManager) androidx.core.content.a.h(v5.getContext(), AccessibilityManager.class);
        }
        if (this.f12201g == null || this.f12202h != null) {
            return;
        }
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: c1.a
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z5) {
                HideBottomViewOnScrollBehavior.c(this.f11947a, v5, z5);
            }
        };
        this.f12202h = touchExplorationStateChangeListener;
        this.f12201g.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        v5.addOnAttachStateChangeListener(new a());
    }

    private void q(V v5, int i5) {
        this.f12204j = i5;
        Iterator<c> it = this.f12195a.iterator();
        while (it.hasNext()) {
            it.next().a(v5, this.f12204j);
        }
    }

    public boolean j() {
        return this.f12204j == 1;
    }

    public boolean k() {
        return this.f12204j == 2;
    }

    public void l(V v5, int i5) {
        this.f12205k = i5;
        if (this.f12204j == 1) {
            v5.setTranslationY(this.f12200f + i5);
        }
    }

    public void m(V v5) {
        n(v5, true);
    }

    public void n(V v5, boolean z5) {
        AccessibilityManager accessibilityManager;
        if (j()) {
            return;
        }
        if (this.f12203i && (accessibilityManager = this.f12201g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f12206l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v5.clearAnimation();
        }
        q(v5, 1);
        int i5 = this.f12200f + this.f12205k;
        if (z5) {
            h(v5, i5, this.f12197c, this.f12199e);
        } else {
            v5.setTranslationY(i5);
        }
    }

    public void o(V v5) {
        p(v5, true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v5, int i5) {
        this.f12200f = v5.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v5.getLayoutParams()).bottomMargin;
        this.f12196b = e.f(v5.getContext(), f12192m, 225);
        this.f12197c = e.f(v5.getContext(), f12193n, 175);
        Context context = v5.getContext();
        int i6 = f12194o;
        this.f12198d = e.g(context, i6, C0553a.f11786d);
        this.f12199e = e.g(v5.getContext(), i6, C0553a.f11785c);
        i(v5);
        return super.onLayoutChild(coordinatorLayout, v5, i5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        if (i6 > 0) {
            m(v5);
        } else if (i6 < 0) {
            o(v5);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i5, int i6) {
        return i5 == 2;
    }

    public void p(V v5, boolean z5) {
        if (k()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f12206l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v5.clearAnimation();
        }
        q(v5, 2);
        if (z5) {
            h(v5, 0, this.f12196b, this.f12198d);
        } else {
            v5.setTranslationY(0);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12195a = new LinkedHashSet<>();
        this.f12200f = 0;
        this.f12203i = true;
        this.f12204j = 2;
        this.f12205k = 0;
    }
}
