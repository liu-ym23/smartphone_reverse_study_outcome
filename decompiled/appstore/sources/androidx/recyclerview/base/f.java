package androidx.recyclerview.base;

import android.view.MotionEvent;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class f implements VelocityTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final android.view.VelocityTracker f4028a;

    public f() {
        this.f4028a = android.view.VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public void addMovement(@NotNull MotionEvent r10) {
        q.g(r10, "event");
        this.f4028a.addMovement(r10);
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public void clear() {
        this.f4028a.clear();
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public void computeCurrentVelocity(int r10, float r11) {
        this.f4028a.computeCurrentVelocity(r10, r11);
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public float getXVelocity(int r10) {
        return this.f4028a.getXVelocity(r10);
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public float getYVelocity(int r10) {
        return this.f4028a.getYVelocity(r10);
    }
}
