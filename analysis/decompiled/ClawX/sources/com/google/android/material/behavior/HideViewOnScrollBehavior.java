package com.google.android.material.behavior;

import a1.k;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.stepos.stepclaw.R;
import f.d;
import g1.b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k4.v;
import t.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends a {

    /* renamed from: a, reason: collision with root package name */
    public a.a f1216a;

    /* renamed from: b, reason: collision with root package name */
    public AccessibilityManager f1217b;

    /* renamed from: c, reason: collision with root package name */
    public g1.a f1218c;

    /* renamed from: e, reason: collision with root package name */
    public int f1219e;

    /* renamed from: f, reason: collision with root package name */
    public int f1220f;

    /* renamed from: g, reason: collision with root package name */
    public TimeInterpolator f1221g;

    /* renamed from: h, reason: collision with root package name */
    public TimeInterpolator f1222h;

    /* renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f1225k;
    public final LinkedHashSet d = new LinkedHashSet();

    /* renamed from: i, reason: collision with root package name */
    public int f1223i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f1224j = 2;

    public HideViewOnScrollBehavior() {
    }

    @Override // t.a
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i8) {
        if (this.f1217b == null) {
            this.f1217b = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f1217b;
        if (accessibilityManager != null && this.f1218c == null) {
            g1.a aVar = new g1.a(this, view, 1);
            this.f1218c = aVar;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            view.addOnAttachStateChangeListener(new d(3, this));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i9 = ((t.d) view.getLayoutParams()).f5391c;
        if (i9 == 80 || i9 == 81) {
            r(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i9, i8);
            r((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.f1223i = this.f1216a.L(view, marginLayoutParams);
        this.f1219e = v.g0(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f1220f = v.g0(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f1221g = v.h0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, e1.a.d);
        this.f1222h = v.h0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, e1.a.f2341c);
        return false;
    }

    @Override // t.a
    public final void k(CoordinatorLayout coordinatorLayout, View view, int i8, int i9, int i10, int[] iArr) {
        if (i8 <= 0) {
            if (i8 < 0) {
                s(view);
                return;
            }
            return;
        }
        if (this.f1224j == 1) {
            return;
        }
        AccessibilityManager accessibilityManager = this.f1217b;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            ViewPropertyAnimator viewPropertyAnimator = this.f1225k;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f1224j = 1;
            Iterator it = this.d.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
            this.f1225k = this.f1216a.N(view, this.f1223i).setInterpolator(this.f1222h).setDuration(this.f1220f).setListener(new k(3, this));
        }
    }

    @Override // t.a
    public final boolean o(View view, int i8, int i9) {
        return i8 == 2;
    }

    public final void r(int i8) {
        a.a aVar = this.f1216a;
        if (aVar == null || aVar.M() != i8) {
            if (i8 == 0) {
                this.f1216a = new b(2);
            } else if (i8 == 1) {
                this.f1216a = new b(0);
            } else {
                if (i8 != 2) {
                    throw new IllegalArgumentException(a8.b.k(i8, "Invalid view edge position value: ", ". Must be 0, 1 or 2."));
                }
                this.f1216a = new b(1);
            }
        }
    }

    public final void s(View view) {
        if (this.f1224j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f1225k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f1224j = 2;
        Iterator it = this.d.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.f1216a.getClass();
        this.f1225k = this.f1216a.N(view, 0).setInterpolator(this.f1221g).setDuration(this.f1219e).setListener(new k(3, this));
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
