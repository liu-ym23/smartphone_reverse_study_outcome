package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_SurfaceRequest_TransformationInfo extends SurfaceRequest.TransformationInfo {
    private final Rect getCropRect;
    private final int getRotationDegrees;
    private final Matrix getSensorToBufferTransform;
    private final int getTargetRotation;
    private final boolean hasCameraTransform;
    private final boolean isMirroring;

    public int hashCode() {
        int r100 = (((((this.getCropRect.hashCode() ^ 1000003) * 1000003) ^ this.getRotationDegrees) * 1000003) ^ this.getTargetRotation) * 1000003;
        int r101 = 1231;
        if (this.hasCameraTransform == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 ^ r102) * 1000003) ^ this.getSensorToBufferTransform.hashCode()) * 1000003;
        if (this.isMirroring == true) goto L11;
        r101 = 1237;
    L11:
        return r103 ^ r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "TransformationInfo{getCropRect=" + this.getCropRect + ", getRotationDegrees=" + this.getRotationDegrees + ", getTargetRotation=" + this.getTargetRotation + ", hasCameraTransform=" + this.hasCameraTransform + ", getSensorToBufferTransform=" + this.getSensorToBufferTransform + ", isMirroring=" + this.isMirroring + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public Rect getCropRect() {
        return this.getCropRect;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public int getRotationDegrees() {
        return this.getRotationDegrees;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public Matrix getSensorToBufferTransform() {
        return this.getSensorToBufferTransform;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public int getTargetRotation() {
        return this.getTargetRotation;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public boolean hasCameraTransform() {
        return this.hasCameraTransform;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public boolean isMirroring() {
        return this.isMirroring;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SurfaceRequest.TransformationInfo) == false) goto L22;
        SurfaceRequest.TransformationInfo r101 = (SurfaceRequest.TransformationInfo) r100;
        if (this.getCropRect.equals(r101.getCropRect()) == true) goto L10;
    L20:
        return false;
    L10:
        if (this.getRotationDegrees != r101.getRotationDegrees()) goto L20;
        if (this.getTargetRotation != r101.getTargetRotation()) goto L20;
        if (this.hasCameraTransform != r101.hasCameraTransform()) goto L20;
        if (this.getSensorToBufferTransform.equals(r101.getSensorToBufferTransform()) == false) goto L20;
        if (this.isMirroring != r101.isMirroring()) goto L20;
        return true;
    L22:
        return false;
    }

    public AutoValue_SurfaceRequest_TransformationInfo(Rect r100, int r101, int r102, boolean r103, Matrix r104, boolean r105) {
        if (r100 == null) goto L11;
        this.getCropRect = r100;
        this.getRotationDegrees = r101;
        this.getTargetRotation = r102;
        this.hasCameraTransform = r103;
        if (r104 == null) goto L9;
        this.getSensorToBufferTransform = r104;
        this.isMirroring = r105;
        return;
    L9:
        throw new NullPointerException("Null getSensorToBufferTransform");
    L11:
        throw new NullPointerException("Null getCropRect");
    }
}
