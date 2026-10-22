package com.google.android.material.behavior;

import A6.m;
import D6.e;
import D7.N;
import M0.i;
import S2.a;
import S2.b;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.stepos.ability.R;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a, reason: collision with root package name */
    public i f2299a;
    public AccessibilityManager b;
    public a c;
    public final boolean d;
    public final LinkedHashSet e;
    public int f;
    public int g;
    public TimeInterpolator h;
    public TimeInterpolator i;

    /* renamed from: j, reason: collision with root package name */
    public int f2300j;
    public int k;
    public ViewPropertyAnimator l;

    public HideViewOnScrollBehavior() {
        this.d = true;
        this.e = new LinkedHashSet();
        this.f2300j = 0;
        this.k = 2;
    }

    public final void c(int i) {
        i iVar = this.f2299a;
        if (iVar == null || iVar.v() != i) {
            if (i == 0) {
                this.f2299a = new b(2);
            } else if (i == 1) {
                this.f2299a = new b(0);
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Invalid view edge position value: ", ". Must be 0, 1 or 2."));
                }
                this.f2299a = new b(1);
            }
        }
    }

    public final void d(View view) {
        if (this.k == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.k = 2;
        Iterator it = this.e.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
        this.f2299a.getClass();
        this.l = this.f2299a.w(0, view).setInterpolator(this.h).setDuration(this.f).setListener(new m(this, 4));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (this.b == null) {
            this.b = (AccessibilityManager) ContextCompat.getSystemService(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.b;
        if (accessibilityManager != null && this.c == null) {
            a aVar = new a(this, view, 1);
            this.c = aVar;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            view.addOnAttachStateChangeListener(new e(this, 4));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = ((CoordinatorLayout.LayoutParams) view.getLayoutParams()).gravity;
        if (i6 == 80 || i6 == 81) {
            c(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i6, i);
            c((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.f2300j = this.f2299a.u(view, marginLayoutParams);
        this.f = N.N(view.getContext(), R.attr.motionDurationLong2, 225);
        this.g = N.N(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.h = N.O(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, Q2.a.d);
        this.i = N.O(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, Q2.a.c);
        return super.onLayoutChild(coordinatorLayout, view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i6, int i10, int i11, int i12, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i6 <= 0) {
            if (i6 < 0) {
                d(view);
                return;
            }
            return;
        }
        if (this.k == 1) {
            return;
        }
        if (this.d && (accessibilityManager = this.b) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.k = 1;
        Iterator it = this.e.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
        this.l = this.f2299a.w(this.f2300j, view).setInterpolator(this.i).setDuration(this.g).setListener(new m(this, 4));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i6) {
        return i == 2;
    }

    public HideViewOnScrollBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = true;
        this.e = new LinkedHashSet();
        this.f2300j = 0;
        this.k = 2;
    }
}
