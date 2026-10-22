package J;

import J.C0869y;
import androidx.camera.core.ImageCapture;

/* renamed from: J.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0848c extends C0869y.a {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.core.i f3616a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3617b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageCapture.OutputFileOptions f3618c;

    public C0848c(androidx.camera.core.i iVar, int i10, ImageCapture.OutputFileOptions outputFileOptions) {
        if (iVar == null) {
            throw new NullPointerException("Null imageProxy");
        }
        this.f3616a = iVar;
        this.f3617b = i10;
        if (outputFileOptions == null) {
            throw new NullPointerException("Null outputFileOptions");
        }
        this.f3618c = outputFileOptions;
    }

    @Override // J.C0869y.a
    public androidx.camera.core.i a() {
        return this.f3616a;
    }

    @Override // J.C0869y.a
    public ImageCapture.OutputFileOptions b() {
        return this.f3618c;
    }

    @Override // J.C0869y.a
    public int c() {
        return this.f3617b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0869y.a) {
            C0869y.a aVar = (C0869y.a) obj;
            if (this.f3616a.equals(aVar.a()) && this.f3617b == aVar.c() && this.f3618c.equals(aVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f3618c.hashCode() ^ ((((this.f3616a.hashCode() ^ 1000003) * 1000003) ^ this.f3617b) * 1000003);
    }

    public String toString() {
        return "In{imageProxy=" + this.f3616a + ", rotationDegrees=" + this.f3617b + ", outputFileOptions=" + this.f3618c + "}";
    }
}
