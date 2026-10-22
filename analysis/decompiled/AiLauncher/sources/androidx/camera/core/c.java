package androidx.camera.core;

import androidx.camera.core.CameraState;

/* loaded from: classes.dex */
public final class c extends CameraState.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f11277a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f11278b;

    public c(int i10, Throwable th) {
        this.f11277a = i10;
        this.f11278b = th;
    }

    @Override // androidx.camera.core.CameraState.a
    public Throwable c() {
        return this.f11278b;
    }

    @Override // androidx.camera.core.CameraState.a
    public int d() {
        return this.f11277a;
    }

    public boolean equals(Object obj) {
        Throwable th;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CameraState.a) {
            CameraState.a aVar = (CameraState.a) obj;
            if (this.f11277a == aVar.d() && ((th = this.f11278b) != null ? th.equals(aVar.c()) : aVar.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = (this.f11277a ^ 1000003) * 1000003;
        Throwable th = this.f11278b;
        return (th == null ? 0 : th.hashCode()) ^ i10;
    }

    public String toString() {
        return "StateError{code=" + this.f11277a + ", cause=" + this.f11278b + "}";
    }
}
