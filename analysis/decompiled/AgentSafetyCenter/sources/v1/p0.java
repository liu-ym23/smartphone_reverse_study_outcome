package v1;

import android.view.ViewConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p0 implements u1 {

    /* renamed from: a, reason: collision with root package name */
    public ViewConfiguration f14523a;

    @Override // v1.u1
    public final long a() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // v1.u1
    public final long b() {
        return ViewConfiguration.getLongPressTimeout();
    }

    @Override // v1.u1
    public final float d() {
        return this.f14523a.getScaledMaximumFlingVelocity();
    }

    @Override // v1.u1
    public final float e() {
        return this.f14523a.getScaledTouchSlop();
    }
}
