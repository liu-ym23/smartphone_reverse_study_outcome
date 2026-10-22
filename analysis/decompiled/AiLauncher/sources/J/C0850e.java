package J;

import J.F;
import androidx.camera.core.ImageCapture;

/* renamed from: J.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0850e extends F.a {

    /* renamed from: a, reason: collision with root package name */
    public final U.A<byte[]> f3621a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageCapture.OutputFileOptions f3622b;

    public C0850e(U.A<byte[]> a10, ImageCapture.OutputFileOptions outputFileOptions) {
        if (a10 == null) {
            throw new NullPointerException("Null packet");
        }
        this.f3621a = a10;
        if (outputFileOptions == null) {
            throw new NullPointerException("Null outputFileOptions");
        }
        this.f3622b = outputFileOptions;
    }

    @Override // J.F.a
    public ImageCapture.OutputFileOptions a() {
        return this.f3622b;
    }

    @Override // J.F.a
    public U.A<byte[]> b() {
        return this.f3621a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.a) {
            F.a aVar = (F.a) obj;
            if (this.f3621a.equals(aVar.b()) && this.f3622b.equals(aVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f3622b.hashCode() ^ ((this.f3621a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "In{packet=" + this.f3621a + ", outputFileOptions=" + this.f3622b + "}";
    }
}
