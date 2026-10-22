package androidx.camera.core;

import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_SurfaceRequest_Result extends SurfaceRequest.Result {
    private final int resultCode;
    private final Surface surface;

    public int hashCode() {
        return ((this.resultCode ^ 1000003) * 1000003) ^ this.surface.hashCode();
    }

    public String toString() {
        return "Result{resultCode=" + this.resultCode + ", surface=" + this.surface + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.SurfaceRequest.Result
    public int getResultCode() {
        return this.resultCode;
    }

    @Override // androidx.camera.core.SurfaceRequest.Result
    public Surface getSurface() {
        return this.surface;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SurfaceRequest.Result) == false) goto L14;
        SurfaceRequest.Result r101 = (SurfaceRequest.Result) r100;
        if (this.resultCode == r101.getResultCode()) goto L10;
    L12:
        return false;
    L10:
        if (this.surface.equals(r101.getSurface()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_SurfaceRequest_Result(int r100, Surface r101) {
        this.resultCode = r100;
        if (r101 == null) goto L7;
        this.surface = r101;
        return;
    L7:
        throw new NullPointerException("Null surface");
    }
}
