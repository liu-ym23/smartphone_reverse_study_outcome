package com.obric.oui.orecyclerview.base;

import android.view.MotionEvent;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements VelocityTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final android.view.VelocityTracker f15375a;

    public g() {
        this.f15375a = android.view.VelocityTracker.obtain();
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void addMovement(@NotNull MotionEvent r10) {
        q.g(r10, "event");
        this.f15375a.addMovement(r10);
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void clear() {
        this.f15375a.clear();
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void computeCurrentVelocity(int r10, float r11) {
        this.f15375a.computeCurrentVelocity(r10, r11);
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public float getXVelocity(int r10) {
        return this.f15375a.getXVelocity(r10);
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public float getYVelocity(int r10) {
        return this.f15375a.getYVelocity(r10);
    }
}
