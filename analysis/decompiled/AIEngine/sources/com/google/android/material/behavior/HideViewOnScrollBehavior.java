package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.h;
import com.stepos.aiengine.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m4.c;
import m4.d;
import m4.e;
import m4.f;
import m4.g;
import u4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public g f4619a;

    /* renamed from: b, reason: collision with root package name */
    public AccessibilityManager f4620b;

    /* renamed from: c, reason: collision with root package name */
    public m4.a f4621c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4622d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<a> f4623e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f4624j;

    /* renamed from: k, reason: collision with root package name */
    public TimeInterpolator f4625k;

    /* renamed from: l, reason: collision with root package name */
    public TimeInterpolator f4626l;

    /* renamed from: m, reason: collision with root package name */
    public int f4627m;

    /* renamed from: n, reason: collision with root package name */
    public int f4628n;

    /* renamed from: o, reason: collision with root package name */
    public ViewPropertyAnimator f4629o;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a();
    }

    public HideViewOnScrollBehavior() {
        this.f4622d = true;
        this.f4623e = new LinkedHashSet<>();
        this.f4627m = 0;
        this.f4628n = 2;
    }

    public final void g(int i10) {
        g gVar = this.f4619a;
        if (gVar == null || gVar.b() != i10) {
            if (i10 == 0) {
                this.f4619a = new e();
            } else if (i10 == 1) {
                this.f4619a = new c();
            } else {
                if (i10 != 2) {
                    throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Invalid view edge position value: ", ". Must be 0, 1 or 2."));
                }
                this.f4619a = new d();
            }
        }
    }

    public final void h(V v3) {
        if (this.f4628n == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4629o;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f4628n = 2;
        Iterator<a> it = this.f4623e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f4619a.getClass();
        this.f4629o = this.f4619a.c(0, v3).setInterpolator(this.f4625k).setDuration(this.h).setListener(new h(this, 5));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i10) {
        if (this.f4620b == null) {
            this.f4620b = (AccessibilityManager) v3.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f4620b;
        if (accessibilityManager != null && this.f4621c == null) {
            m4.a aVar = new m4.a(this, v3, 1);
            this.f4621c = aVar;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            v3.addOnAttachStateChangeListener(new f(this));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v3.getLayoutParams();
        int i11 = ((CoordinatorLayout.f) v3.getLayoutParams()).f1458c;
        if (i11 == 80 || i11 == 81) {
            g(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i11, i10);
            g((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.f4627m = this.f4619a.a(v3, marginLayoutParams);
        this.h = j.c(v3.getContext(), R.attr.motionDurationLong2, 225);
        this.f4624j = j.c(v3.getContext(), R.attr.motionDurationMedium4, 175);
        this.f4625k = j.d(v3.getContext(), R.attr.motionEasingEmphasizedInterpolator, l4.a.f10223d);
        this.f4626l = j.d(v3.getContext(), R.attr.motionEasingEmphasizedInterpolator, l4.a.f10222c);
        return super.onLayoutChild(coordinatorLayout, v3, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i11 <= 0) {
            if (i11 < 0) {
                h(v3);
                return;
            }
            return;
        }
        if (this.f4628n == 1) {
            return;
        }
        if (this.f4622d && (accessibilityManager = this.f4620b) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4629o;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f4628n = 1;
        Iterator<a> it = this.f4623e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f4629o = this.f4619a.c(this.f4627m, v3).setInterpolator(this.f4626l).setDuration(this.f4624j).setListener(new h(this, 5));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i10, int i11) {
        return i10 == 2;
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4622d = true;
        this.f4623e = new LinkedHashSet<>();
        this.f4627m = 0;
        this.f4628n = 2;
    }
}
