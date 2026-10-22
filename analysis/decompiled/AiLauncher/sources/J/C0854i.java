package J;

import J.d0;
import androidx.camera.core.ImageCaptureException;

/* renamed from: J.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0854i extends d0.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f3643a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageCaptureException f3644b;

    public C0854i(int i10, ImageCaptureException imageCaptureException) {
        this.f3643a = i10;
        if (imageCaptureException == null) {
            throw new NullPointerException("Null imageCaptureException");
        }
        this.f3644b = imageCaptureException;
    }

    @Override // J.d0.a
    public ImageCaptureException a() {
        return this.f3644b;
    }

    @Override // J.d0.a
    public int b() {
        return this.f3643a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0.a) {
            d0.a aVar = (d0.a) obj;
            if (this.f3643a == aVar.b() && this.f3644b.equals(aVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f3644b.hashCode() ^ ((this.f3643a ^ 1000003) * 1000003);
    }

    public String toString() {
        return "CaptureError{requestId=" + this.f3643a + ", imageCaptureException=" + this.f3644b + "}";
    }
}
