package com.google.android.material.behavior;

import A.b;
import A.d;
import B0.g;
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
import o1.C0807b;

/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends b {

    /* renamed from: a, reason: collision with root package name */
    public C0807b f10382a;

    /* renamed from: b, reason: collision with root package name */
    public AccessibilityManager f10383b;

    /* renamed from: c, reason: collision with root package name */
    public AccessibilityManager.TouchExplorationStateChangeListener f10384c;

    /* renamed from: f, reason: collision with root package name */
    public int f10387f;

    /* renamed from: g, reason: collision with root package name */
    public int f10388g;

    /* renamed from: h, reason: collision with root package name */
    public TimeInterpolator f10389h;

    /* renamed from: i, reason: collision with root package name */
    public TimeInterpolator f10390i;

    /* renamed from: l, reason: collision with root package name */
    public ViewPropertyAnimator f10393l;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10385d = true;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet f10386e = new LinkedHashSet();

    /* renamed from: j, reason: collision with root package name */
    public int f10391j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f10392k = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface ScrollState {
    }

    public HideViewOnScrollBehavior() {
    }

    public final void c(int i4) {
        C0807b c0807b = this.f10382a;
        if (c0807b == null || c0807b.h0() != i4) {
            if (i4 == 0) {
                this.f10382a = new C0807b(2);
            } else if (i4 == 1) {
                this.f10382a = new C0807b(0);
            } else {
                if (i4 != 2) {
                    throw new IllegalArgumentException(g.j("Invalid view edge position value: ", i4, ". Must be 0, 1 or 2."));
                }
                this.f10382a = new C0807b(1);
            }
        }
    }

    public final void d(View view) {
        if (this.f10392k == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f10393l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f10392k = 2;
        Iterator it = this.f10386e.iterator();
        if (it.hasNext()) {
            g.y(it.next());
            throw null;
        }
        this.f10382a.getClass();
        this.f10393l = this.f10382a.i0(0, view).setInterpolator(this.f10389h).setDuration(this.f10387f).setListener(new C0195d(5, this));
    }

    @Override // A.b
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        if (this.f10383b == null) {
            this.f10383b = (AccessibilityManager) androidx.core.content.b.b(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f10383b;
        if (accessibilityManager != null && this.f10384c == null) {
            AccessibilityManagerTouchExplorationStateChangeListenerC0806a accessibilityManagerTouchExplorationStateChangeListenerC0806a = new AccessibilityManagerTouchExplorationStateChangeListenerC0806a(this, view, 1);
            this.f10384c = accessibilityManagerTouchExplorationStateChangeListenerC0806a;
            accessibilityManager.addTouchExplorationStateChangeListener(accessibilityManagerTouchExplorationStateChangeListenerC0806a);
            view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0652f(3, this));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = ((d) view.getLayoutParams()).f7c;
        if (i5 == 80 || i5 == 81) {
            c(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i5, i4);
            c((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.f10391j = this.f10382a.g0(view, marginLayoutParams);
        this.f10387f = c.L(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f10388g = c.L(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f10389h = c.M(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC0775a.f13653d);
        this.f10390i = c.M(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC0775a.f13652c);
        return false;
    }

    @Override // A.b
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i5 <= 0) {
            if (i5 < 0) {
                d(view);
                return;
            }
            return;
        }
        if (this.f10392k == 1) {
            return;
        }
        if (this.f10385d && (accessibilityManager = this.f10383b) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f10393l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f10392k = 1;
        Iterator it = this.f10386e.iterator();
        if (it.hasNext()) {
            g.y(it.next());
            throw null;
        }
        this.f10393l = this.f10382a.i0(this.f10391j, view).setInterpolator(this.f10390i).setDuration(this.f10388g).setListener(new C0195d(5, this));
    }

    @Override // A.b
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i4, int i5) {
        return i4 == 2;
    }

    public HideViewOnScrollBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
    }
}
