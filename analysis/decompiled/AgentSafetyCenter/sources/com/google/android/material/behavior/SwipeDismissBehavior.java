package com.google.android.material.behavior;

import a2.i;
import android.view.MotionEvent;
import android.view.View;
import b3.a;
import java.lang.invoke.VarHandle;
import n3.k0;
import r6.c;
import u3.b;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends a {

    /* renamed from: a, reason: collision with root package name */
    public b f2403a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2404b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2405c;

    /* renamed from: d, reason: collision with root package name */
    public int f2406d = 2;

    /* renamed from: e, reason: collision with root package name */
    public float f2407e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f2408f = 0.5f;

    /* renamed from: g, reason: collision with root package name */
    public final c f2409g;

    public SwipeDismissBehavior() {
        c cVar = new c();
        cVar.f10469c = this;
        cVar.f10468b = -1;
        VarHandle.storeStoreFence();
        this.f2409g = cVar;
    }

    public boolean c() {
        return true;
    }

    @Override // b3.a
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        boolean z10 = this.f2404b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z10 = aVar.z(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f2404b = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2404b = false;
        }
        if (z10) {
            if (this.f2403a == null) {
                this.f2403a = b.g(aVar, this.f2409g);
            }
            if (!this.f2405c && this.f2403a.q(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // b3.a
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            k0.e(1048576, view);
            k0.c(0, view);
            if (c()) {
                o3.b bVar = o3.b.f9140k;
                i iVar = new i(26);
                iVar.f49f = this;
                VarHandle.storeStoreFence();
                k0.f(view, bVar, iVar);
            }
        }
        return false;
    }

    @Override // b3.a
    public final boolean onTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        if (this.f2403a == null) {
            return false;
        }
        if (this.f2405c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f2403a.k(motionEvent);
        return true;
    }
}
