package com.google.android.material.behavior;

import A.b;
import K.S;
import Q.e;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.google.android.gms.common.api.internal.p;
import com.stepos.alphame.utils.Property;
import o1.c;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends b {

    /* renamed from: a, reason: collision with root package name */
    public e f10394a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10395b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10396c;

    /* renamed from: d, reason: collision with root package name */
    public int f10397d = 2;

    /* renamed from: e, reason: collision with root package name */
    public final float f10398e = 0.5f;

    /* renamed from: f, reason: collision with root package name */
    public float f10399f = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public float f10400g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    public final c f10401h = new c(this);

    public boolean c(View view) {
        return true;
    }

    @Override // A.b
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z4 = this.f10395b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z4 = coordinatorLayout.z(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f10395b = z4;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f10395b = false;
        }
        if (!z4) {
            return false;
        }
        if (this.f10394a == null) {
            this.f10394a = new e(coordinatorLayout.getContext(), coordinatorLayout, this.f10401h);
        }
        return !this.f10396c && this.f10394a.p(motionEvent);
    }

    @Override // A.b
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            S.f(BmLocated.ALIGN_TOP, view);
            S.d(0, view);
            if (c(view)) {
                S.g(view, L.b.f1134j, new p(6, this));
            }
        }
        return false;
    }

    @Override // A.b
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f10394a == null) {
            return false;
        }
        if (this.f10396c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f10394a.j(motionEvent);
        return true;
    }
}
