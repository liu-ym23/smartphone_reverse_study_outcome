package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.emoji2.text.m;
import e0.a0;
import g1.c;
import i0.e;
import t.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends a {

    /* renamed from: a, reason: collision with root package name */
    public e f1226a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1227b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1228c;
    public int d = 2;

    /* renamed from: e, reason: collision with root package name */
    public float f1229e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f1230f = 0.5f;

    /* renamed from: g, reason: collision with root package name */
    public final c f1231g = new c(this);

    @Override // t.a
    public boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zO = this.f1227b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zO = coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f1227b = zO;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f1227b = false;
        }
        if (zO) {
            if (this.f1226a == null) {
                this.f1226a = new e(coordinatorLayout.getContext(), coordinatorLayout, this.f1231g);
            }
            if (!this.f1228c && this.f1226a.p(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // t.a
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i8) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            a0.c(view, 1048576);
            a0.b(view, 0);
            if (r(view)) {
                a0.d(view, f0.c.f2536j, new m(this));
            }
        }
        return false;
    }

    @Override // t.a
    public final boolean q(View view, MotionEvent motionEvent) {
        if (this.f1226a == null) {
            return false;
        }
        if (this.f1228c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f1226a.j(motionEvent);
        return true;
    }

    public boolean r(View view) {
        return true;
    }
}
