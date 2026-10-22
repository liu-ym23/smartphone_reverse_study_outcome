package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.SurfaceRequest;

/* loaded from: classes.dex */
public final class e extends SurfaceRequest.g {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f11281a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11282b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11283c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11284d;

    /* renamed from: e, reason: collision with root package name */
    public final Matrix f11285e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11286f;

    public e(Rect rect, int i10, int i11, boolean z10, Matrix matrix, boolean z11) {
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.f11281a = rect;
        this.f11282b = i10;
        this.f11283c = i11;
        this.f11284d = z10;
        if (matrix == null) {
            throw new NullPointerException("Null getSensorToBufferTransform");
        }
        this.f11285e = matrix;
        this.f11286f = z11;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public Rect a() {
        return this.f11281a;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public int b() {
        return this.f11282b;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public Matrix c() {
        return this.f11285e;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public int d() {
        return this.f11283c;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public boolean e() {
        return this.f11284d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceRequest.g) {
            SurfaceRequest.g gVar = (SurfaceRequest.g) obj;
            if (this.f11281a.equals(gVar.a()) && this.f11282b == gVar.b() && this.f11283c == gVar.d() && this.f11284d == gVar.e() && this.f11285e.equals(gVar.c()) && this.f11286f == gVar.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public boolean f() {
        return this.f11286f;
    }

    public int hashCode() {
        return ((((((((((this.f11281a.hashCode() ^ 1000003) * 1000003) ^ this.f11282b) * 1000003) ^ this.f11283c) * 1000003) ^ (this.f11284d ? 1231 : 1237)) * 1000003) ^ this.f11285e.hashCode()) * 1000003) ^ (this.f11286f ? 1231 : 1237);
    }

    public String toString() {
        return "TransformationInfo{getCropRect=" + this.f11281a + ", getRotationDegrees=" + this.f11282b + ", getTargetRotation=" + this.f11283c + ", hasCameraTransform=" + this.f11284d + ", getSensorToBufferTransform=" + this.f11285e + ", isMirroring=" + this.f11286f + "}";
    }
}
