package D;

import D.r0;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.CameraInternal;

/* renamed from: D.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0768f extends r0.a {

    /* renamed from: a, reason: collision with root package name */
    public final Size f2097a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f2098b;

    /* renamed from: c, reason: collision with root package name */
    public final CameraInternal f2099c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2100d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2101e;

    public C0768f(Size size, Rect rect, CameraInternal cameraInternal, int i10, boolean z10) {
        if (size == null) {
            throw new NullPointerException("Null inputSize");
        }
        this.f2097a = size;
        if (rect == null) {
            throw new NullPointerException("Null inputCropRect");
        }
        this.f2098b = rect;
        this.f2099c = cameraInternal;
        this.f2100d = i10;
        this.f2101e = z10;
    }

    @Override // D.r0.a
    public CameraInternal a() {
        return this.f2099c;
    }

    @Override // D.r0.a
    public Rect b() {
        return this.f2098b;
    }

    @Override // D.r0.a
    public Size c() {
        return this.f2097a;
    }

    @Override // D.r0.a
    public boolean d() {
        return this.f2101e;
    }

    @Override // D.r0.a
    public int e() {
        return this.f2100d;
    }

    public boolean equals(Object obj) {
        CameraInternal cameraInternal;
        if (obj == this) {
            return true;
        }
        if (obj instanceof r0.a) {
            r0.a aVar = (r0.a) obj;
            if (this.f2097a.equals(aVar.c()) && this.f2098b.equals(aVar.b()) && ((cameraInternal = this.f2099c) != null ? cameraInternal.equals(aVar.a()) : aVar.a() == null) && this.f2100d == aVar.e() && this.f2101e == aVar.d()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.f2097a.hashCode() ^ 1000003) * 1000003) ^ this.f2098b.hashCode()) * 1000003;
        CameraInternal cameraInternal = this.f2099c;
        return (this.f2101e ? 1231 : 1237) ^ ((((iHashCode ^ (cameraInternal == null ? 0 : cameraInternal.hashCode())) * 1000003) ^ this.f2100d) * 1000003);
    }

    public String toString() {
        return "CameraInputInfo{inputSize=" + this.f2097a + ", inputCropRect=" + this.f2098b + ", cameraInternal=" + this.f2099c + ", rotationDegrees=" + this.f2100d + ", mirroring=" + this.f2101e + "}";
    }
}
