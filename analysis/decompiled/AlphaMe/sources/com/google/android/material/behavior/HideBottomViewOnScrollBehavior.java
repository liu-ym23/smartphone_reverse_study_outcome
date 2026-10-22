package com.google.android.material.behavior;

import A.b;
import B0.g;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.C0195d;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.stepos.alphame.R;
import com.stepos.statsrpk.c;
import e.EnumC0546d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k.ViewOnAttachStateChangeListenerC0652f;
import n1.AbstractC0775a;
import o1.AccessibilityManagerTouchExplorationStateChangeListenerC0806a;

@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends b {

    /* renamed from: b, reason: collision with root package name */
    public int f10372b;

    /* renamed from: c, reason: collision with root package name */
    public int f10373c;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f10374d;

    /* renamed from: e, reason: collision with root package name */
    public TimeInterpolator f10375e;

    /* renamed from: g, reason: collision with root package name */
    public AccessibilityManager f10377g;

    /* renamed from: h, reason: collision with root package name */
    public AccessibilityManager.TouchExplorationStateChangeListener f10378h;

    /* renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f10381k;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f10371a = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name */
    public int f10376f = 0;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10379i = true;

    /* renamed from: j, reason: collision with root package name */
    public int f10380j = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface ScrollState {
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public final void c(View view) {
        if (this.f10380j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f10381k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f10380j = 2;
        Iterator it = this.f10371a.iterator();
        if (it.hasNext()) {
            g.y(it.next());
            throw null;
        }
        this.f10381k = view.animate().translationY(0).setInterpolator(this.f10374d).setDuration(this.f10372b).setListener(new C0195d(4, this));
    }

    @Override // A.b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        this.f10376f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f10372b = c.L(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f10373c = c.L(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f10374d = c.M(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC0775a.f13653d);
        this.f10375e = c.M(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC0775a.f13652c);
        if (this.f10377g == null) {
            this.f10377g = (AccessibilityManager) androidx.core.content.b.b(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f10377g;
        int i5 = 0;
        if (accessibilityManager != null && this.f10378h == null) {
            AccessibilityManagerTouchExplorationStateChangeListenerC0806a accessibilityManagerTouchExplorationStateChangeListenerC0806a = new AccessibilityManagerTouchExplorationStateChangeListenerC0806a(this, view, i5);
            this.f10378h = accessibilityManagerTouchExplorationStateChangeListenerC0806a;
            accessibilityManager.addTouchExplorationStateChangeListener(accessibilityManagerTouchExplorationStateChangeListenerC0806a);
            view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0652f(2, this));
        }
        return false;
    }

    @Override // A.b
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i5 <= 0) {
            if (i5 < 0) {
                c(view);
                return;
            }
            return;
        }
        if (this.f10380j == 1) {
            return;
        }
        if (this.f10379i && (accessibilityManager = this.f10377g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f10381k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f10380j = 1;
        Iterator it = this.f10371a.iterator();
        if (it.hasNext()) {
            g.y(it.next());
            throw null;
        }
        this.f10381k = view.animate().translationY(this.f10376f).setInterpolator(this.f10375e).setDuration(this.f10373c).setListener(new C0195d(4, this));
    }

    @Override // A.b
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i4, int i5) {
        return i4 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
