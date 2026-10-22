package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.CameraInternal;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_SurfaceOutput_CameraInputInfo extends SurfaceOutput.CameraInputInfo {
    private final CameraInternal cameraInternal;
    private final Rect inputCropRect;
    private final Size inputSize;
    private final boolean mirroring;
    private final int rotationDegrees;

    public int hashCode() {
        int r100 = (((this.inputSize.hashCode() ^ 1000003) * 1000003) ^ this.inputCropRect.hashCode()) * 1000003;
        CameraInternal r101 = this.cameraInternal;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 ^ r102) * 1000003) ^ this.rotationDegrees) * 1000003;
        if (this.mirroring == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 ^ r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CameraInputInfo{inputSize=" + this.inputSize + ", inputCropRect=" + this.inputCropRect + ", cameraInternal=" + this.cameraInternal + ", rotationDegrees=" + this.rotationDegrees + ", mirroring=" + this.mirroring + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public CameraInternal getCameraInternal() {
        return this.cameraInternal;
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public Rect getInputCropRect() {
        return this.inputCropRect;
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public Size getInputSize() {
        return this.inputSize;
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public boolean getMirroring() {
        return this.mirroring;
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SurfaceOutput.CameraInputInfo) == false) goto L25;
        SurfaceOutput.CameraInputInfo r101 = (SurfaceOutput.CameraInputInfo) r100;
        if (this.inputSize.equals(r101.getInputSize()) == true) goto L10;
    L23:
        return false;
    L10:
        if (this.inputCropRect.equals(r101.getInputCropRect()) == false) goto L23;
        CameraInternal r102 = this.cameraInternal;
        if (r102 != null) goto L17;
        if (r101.getCameraInternal() != null) goto L23;
    L19:
        if (this.rotationDegrees != r101.getRotationDegrees()) goto L23;
        if (this.mirroring != r101.getMirroring()) goto L23;
        return true;
    L17:
        if (r102.equals(r101.getCameraInternal()) == false) goto L23;
    L25:
        return false;
    }

    public AutoValue_SurfaceOutput_CameraInputInfo(Size r100, Rect r101, CameraInternal r102, int r103, boolean r104) {
        if (r100 == null) goto L11;
        this.inputSize = r100;
        if (r101 == null) goto L9;
        this.inputCropRect = r101;
        this.cameraInternal = r102;
        this.rotationDegrees = r103;
        this.mirroring = r104;
        return;
    L9:
        throw new NullPointerException("Null inputCropRect");
    L11:
        throw new NullPointerException("Null inputSize");
    }
}
