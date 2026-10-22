package com.obric.oui.orecyclerview.base;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import d.h.b.o;

/* JADX INFO: compiled from: SystemVelocityTrackerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VelocityTracker f35542a;

    public g() {
        this.f35542a = VelocityTracker.obtain();
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public void a(MotionEvent r2) {
        o.e(r2, "event");
        this.f35542a.addMovement(r2);
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public void a() {
        this.f35542a.clear();
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public void a(int r1, float r2) {
        this.f35542a.computeCurrentVelocity(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public float a(int r1) {
        return this.f35542a.getXVelocity(r1);
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public float b(int r1) {
        return this.f35542a.getYVelocity(r1);
    }
}
