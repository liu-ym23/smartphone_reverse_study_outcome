package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.activity.b;
import b3.a;
import bb.d;
import com.stepos.agentsafetycenter.R;
import id.k;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends a {

    /* renamed from: b, reason: collision with root package name */
    public int f2384b;

    /* renamed from: c, reason: collision with root package name */
    public int f2385c;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f2386d;

    /* renamed from: e, reason: collision with root package name */
    public TimeInterpolator f2387e;

    /* renamed from: g, reason: collision with root package name */
    public AccessibilityManager f2389g;

    /* renamed from: h, reason: collision with root package name */
    public r6.a f2390h;

    /* renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f2392k;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f2383a = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name */
    public int f2388f = 0;
    public final boolean i = true;

    /* renamed from: j, reason: collision with root package name */
    public int f2391j = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    public final void c(View view) {
        if (this.f2391j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2392k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f2391j = 2;
        Iterator it = this.f2383a.iterator();
        if (it.hasNext()) {
            throw b.g(it);
        }
        this.f2392k = view.animate().translationY(0).setInterpolator(this.f2386d).setDuration(this.f2384b).setListener(new d(this, 5));
    }

    @Override // b3.a
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        this.f2388f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f2384b = k.O(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f2385c = k.O(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f2386d = k.P(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, q6.a.f10103c);
        this.f2387e = k.P(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, q6.a.f10102b);
        if (this.f2389g == null) {
            this.f2389g = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f2389g;
        if (accessibilityManager != null && this.f2390h == null) {
            r6.a aVar2 = new r6.a(0);
            aVar2.f10465c = this;
            aVar2.f10464b = view;
            VarHandle.storeStoreFence();
            this.f2390h = aVar2;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar2);
            ab.b bVar = new ab.b(4);
            bVar.f379f = this;
            VarHandle.storeStoreFence();
            view.addOnAttachStateChangeListener(bVar);
        }
        return false;
    }

    @Override // b3.a
    public final void onNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int i10, int i11, int i12, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i3 <= 0) {
            if (i3 < 0) {
                c(view);
                return;
            }
            return;
        }
        if (this.f2391j == 1) {
            return;
        }
        if (this.i && (accessibilityManager = this.f2389g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2392k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f2391j = 1;
        Iterator it = this.f2383a.iterator();
        if (it.hasNext()) {
            throw b.g(it);
        }
        this.f2392k = view.animate().translationY(this.f2388f).setInterpolator(this.f2387e).setDuration(this.f2385c).setListener(new d(this, 5));
    }

    @Override // b3.a
    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, View view3, int i, int i3) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
