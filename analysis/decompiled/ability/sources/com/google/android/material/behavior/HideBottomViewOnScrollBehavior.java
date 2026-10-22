package com.google.android.material.behavior;

import A6.m;
import D6.e;
import D7.N;
import S2.a;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.stepos.ability.R;
import java.util.Iterator;
import java.util.LinkedHashSet;

@Deprecated
/* loaded from: classes3.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f2297a;
    public int b;
    public int c;
    public TimeInterpolator d;
    public TimeInterpolator e;
    public int f;
    public AccessibilityManager g;
    public a h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public int f2298j;
    public ViewPropertyAnimator k;

    public HideBottomViewOnScrollBehavior() {
        this.f2297a = new LinkedHashSet();
        this.f = 0;
        this.i = true;
        this.f2298j = 2;
    }

    public final void c(View view) {
        if (this.f2298j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f2298j = 2;
        Iterator it = this.f2297a.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
        this.k = view.animate().translationY(0).setInterpolator(this.d).setDuration(this.b).setListener(new m(this, 3));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.b = N.N(view.getContext(), R.attr.motionDurationLong2, 225);
        this.c = N.N(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.d = N.O(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, Q2.a.d);
        this.e = N.O(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, Q2.a.c);
        if (this.g == null) {
            this.g = (AccessibilityManager) ContextCompat.getSystemService(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.g;
        if (accessibilityManager != null && this.h == null) {
            a aVar = new a(this, view, 0);
            this.h = aVar;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            view.addOnAttachStateChangeListener(new e(this, 3));
        }
        return super.onLayoutChild(coordinatorLayout, view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i6, int i10, int i11, int i12, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i6 <= 0) {
            if (i6 < 0) {
                c(view);
                return;
            }
            return;
        }
        if (this.f2298j == 1) {
            return;
        }
        if (this.i && (accessibilityManager = this.g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f2298j = 1;
        Iterator it = this.f2297a.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
        this.k = view.animate().translationY(this.f).setInterpolator(this.e).setDuration(this.c).setListener(new m(this, 3));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i6) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2297a = new LinkedHashSet();
        this.f = 0;
        this.i = true;
        this.f2298j = 2;
    }
}
