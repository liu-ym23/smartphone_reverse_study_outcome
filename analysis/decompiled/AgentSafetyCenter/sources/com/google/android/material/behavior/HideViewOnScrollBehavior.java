package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import b3.a;
import bb.d;
import com.stepos.agentsafetycenter.R;
import g5.f;
import id.k;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashSet;
import r6.b;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends a {

    /* renamed from: a, reason: collision with root package name */
    public a.a f2393a;

    /* renamed from: b, reason: collision with root package name */
    public AccessibilityManager f2394b;

    /* renamed from: c, reason: collision with root package name */
    public r6.a f2395c;

    /* renamed from: e, reason: collision with root package name */
    public int f2397e;

    /* renamed from: f, reason: collision with root package name */
    public int f2398f;

    /* renamed from: g, reason: collision with root package name */
    public TimeInterpolator f2399g;

    /* renamed from: h, reason: collision with root package name */
    public TimeInterpolator f2400h;

    /* renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f2402k;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f2396d = new LinkedHashSet();
    public int i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f2401j = 2;

    public HideViewOnScrollBehavior() {
    }

    public final void c(int i) {
        a.a aVar = this.f2393a;
        if (aVar == null || aVar.G() != i) {
            if (i == 0) {
                this.f2393a = new b(2);
                return;
            }
            if (i == 1) {
                this.f2393a = new b(0);
            } else if (i == 2) {
                this.f2393a = new b(1);
            } else {
                f.s(k0.a.k(i, "Invalid view edge position value: ", ". Must be 0, 1 or 2."));
            }
        }
    }

    public final void d(View view) {
        if (this.f2401j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2402k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f2401j = 2;
        Iterator it = this.f2396d.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
        this.f2393a.getClass();
        this.f2402k = this.f2393a.H(0, view).setInterpolator(this.f2399g).setDuration(this.f2397e).setListener(new d(this, 6));
    }

    @Override // b3.a
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        if (this.f2394b == null) {
            this.f2394b = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f2394b;
        if (accessibilityManager != null && this.f2395c == null) {
            r6.a aVar2 = new r6.a(1);
            aVar2.f10465c = this;
            aVar2.f10464b = view;
            VarHandle.storeStoreFence();
            this.f2395c = aVar2;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar2);
            ab.b bVar = new ab.b(5);
            bVar.f379f = this;
            VarHandle.storeStoreFence();
            view.addOnAttachStateChangeListener(bVar);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i3 = ((b3.d) view.getLayoutParams()).f1879c;
        if (i3 == 80 || i3 == 81) {
            c(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i3, i);
            c((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.i = this.f2393a.F(view, marginLayoutParams);
        this.f2397e = k.O(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f2398f = k.O(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f2399g = k.P(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, q6.a.f10103c);
        this.f2400h = k.P(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, q6.a.f10102b);
        return false;
    }

    @Override // b3.a
    public final void onNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int i10, int i11, int i12, int[] iArr) {
        if (i3 <= 0) {
            if (i3 < 0) {
                d(view);
                return;
            }
            return;
        }
        if (this.f2401j == 1) {
            return;
        }
        AccessibilityManager accessibilityManager = this.f2394b;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            ViewPropertyAnimator viewPropertyAnimator = this.f2402k;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f2401j = 1;
            Iterator it = this.f2396d.iterator();
            if (it.hasNext()) {
                throw androidx.activity.b.g(it);
            }
            this.f2402k = this.f2393a.H(this.i, view).setInterpolator(this.f2400h).setDuration(this.f2398f).setListener(new d(this, 6));
        }
    }

    @Override // b3.a
    public final boolean onStartNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, View view3, int i, int i3) {
        return i == 2;
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
