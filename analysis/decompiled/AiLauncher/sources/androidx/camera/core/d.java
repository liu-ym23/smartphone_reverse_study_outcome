package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;

/* loaded from: classes.dex */
public final class d extends SurfaceRequest.f {

    /* renamed from: a, reason: collision with root package name */
    public final int f11279a;

    /* renamed from: b, reason: collision with root package name */
    public final Surface f11280b;

    public d(int i10, Surface surface) {
        this.f11279a = i10;
        if (surface == null) {
            throw new NullPointerException("Null surface");
        }
        this.f11280b = surface;
    }

    @Override // androidx.camera.core.SurfaceRequest.f
    public int a() {
        return this.f11279a;
    }

    @Override // androidx.camera.core.SurfaceRequest.f
    public Surface b() {
        return this.f11280b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceRequest.f) {
            SurfaceRequest.f fVar = (SurfaceRequest.f) obj;
            if (this.f11279a == fVar.a() && this.f11280b.equals(fVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f11280b.hashCode() ^ ((this.f11279a ^ 1000003) * 1000003);
    }

    public String toString() {
        return "Result{resultCode=" + this.f11279a + ", surface=" + this.f11280b + "}";
    }
}
