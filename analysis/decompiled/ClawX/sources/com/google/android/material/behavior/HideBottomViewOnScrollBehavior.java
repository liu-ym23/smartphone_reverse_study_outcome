package com.google.android.material.behavior;

import a1.k;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.stepos.stepclaw.R;
import f.d;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k4.v;
import t.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends a {

    /* renamed from: b, reason: collision with root package name */
    public int f1207b;

    /* renamed from: c, reason: collision with root package name */
    public int f1208c;
    public TimeInterpolator d;

    /* renamed from: e, reason: collision with root package name */
    public TimeInterpolator f1209e;

    /* renamed from: g, reason: collision with root package name */
    public AccessibilityManager f1211g;

    /* renamed from: h, reason: collision with root package name */
    public g1.a f1212h;

    /* renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f1215k;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f1206a = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name */
    public int f1210f = 0;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f1213i = true;

    /* renamed from: j, reason: collision with root package name */
    public int f1214j = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // t.a
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i8) {
        this.f1210f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f1207b = v.g0(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f1208c = v.g0(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.d = v.h0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, e1.a.d);
        this.f1209e = v.h0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, e1.a.f2341c);
        if (this.f1211g == null) {
            this.f1211g = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f1211g;
        if (accessibilityManager == null || this.f1212h != null) {
            return false;
        }
        g1.a aVar = new g1.a(this, view, 0);
        this.f1212h = aVar;
        accessibilityManager.addTouchExplorationStateChangeListener(aVar);
        view.addOnAttachStateChangeListener(new d(2, this));
        return false;
    }

    @Override // t.a
    public final void k(CoordinatorLayout coordinatorLayout, View view, int i8, int i9, int i10, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i8 <= 0) {
            if (i8 < 0) {
                r(view);
                return;
            }
            return;
        }
        if (this.f1214j == 1) {
            return;
        }
        if (this.f1213i && (accessibilityManager = this.f1211g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f1215k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f1214j = 1;
        Iterator it = this.f1206a.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.f1215k = view.animate().translationY(this.f1210f).setInterpolator(this.f1209e).setDuration(this.f1208c).setListener(new k(2, this));
    }

    @Override // t.a
    public boolean o(View view, int i8, int i9) {
        return i8 == 2;
    }

    public final void r(View view) {
        if (this.f1214j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f1215k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f1214j = 2;
        Iterator it = this.f1206a.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.f1215k = view.animate().translationY(0).setInterpolator(this.d).setDuration(this.f1207b).setListener(new k(2, this));
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
