package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.h;
import com.stepos.aiengine.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m4.b;
import u4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<a> f4609a;

    /* renamed from: b, reason: collision with root package name */
    public int f4610b;

    /* renamed from: c, reason: collision with root package name */
    public int f4611c;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f4612d;

    /* renamed from: e, reason: collision with root package name */
    public TimeInterpolator f4613e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public AccessibilityManager f4614j;

    /* renamed from: k, reason: collision with root package name */
    public m4.a f4615k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f4616l;

    /* renamed from: m, reason: collision with root package name */
    public int f4617m;

    /* renamed from: n, reason: collision with root package name */
    public ViewPropertyAnimator f4618n;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a();
    }

    public HideBottomViewOnScrollBehavior() {
        this.f4609a = new LinkedHashSet<>();
        this.h = 0;
        this.f4616l = true;
        this.f4617m = 2;
    }

    public final void g(V v3) {
        if (this.f4617m == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4618n;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f4617m = 2;
        Iterator<a> it = this.f4609a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f4618n = v3.animate().translationY(0).setInterpolator(this.f4612d).setDuration(this.f4610b).setListener(new h(this, 4));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i10) {
        this.h = v3.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v3.getLayoutParams()).bottomMargin;
        this.f4610b = j.c(v3.getContext(), R.attr.motionDurationLong2, 225);
        this.f4611c = j.c(v3.getContext(), R.attr.motionDurationMedium4, 175);
        this.f4612d = j.d(v3.getContext(), R.attr.motionEasingEmphasizedInterpolator, l4.a.f10223d);
        this.f4613e = j.d(v3.getContext(), R.attr.motionEasingEmphasizedInterpolator, l4.a.f10222c);
        if (this.f4614j == null) {
            this.f4614j = (AccessibilityManager) v3.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f4614j;
        if (accessibilityManager != null && this.f4615k == null) {
            m4.a aVar = new m4.a(this, v3, 0);
            this.f4615k = aVar;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            v3.addOnAttachStateChangeListener(new b(this));
        }
        return super.onLayoutChild(coordinatorLayout, v3, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i11 <= 0) {
            if (i11 < 0) {
                g(v3);
                return;
            }
            return;
        }
        if (this.f4617m == 1) {
            return;
        }
        if (this.f4616l && (accessibilityManager = this.f4614j) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4618n;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f4617m = 1;
        Iterator<a> it = this.f4609a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f4618n = v3.animate().translationY(this.h).setInterpolator(this.f4613e).setDuration(this.f4611c).setListener(new h(this, 4));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i10, int i11) {
        return i10 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4609a = new LinkedHashSet<>();
        this.h = 0;
        this.f4616l = true;
        this.f4617m = 2;
    }
}
