package j1;

import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class v0 implements y1 {

    /* renamed from: a, reason: collision with root package name */
    public final ViewConfiguration f5340a;

    public v0(ViewConfiguration viewConfiguration) {
        this.f5340a = viewConfiguration;
    }

    @Override // j1.y1
    public final float a() {
        return this.f5340a.getScaledMaximumFlingVelocity();
    }

    @Override // j1.y1
    public final float b() {
        return this.f5340a.getScaledTouchSlop();
    }
}
