package androidx.camera.core.internal;

import androidx.camera.core.impl.Identifier;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_CameraUseCaseAdapter_CameraId extends CameraUseCaseAdapter.CameraId {
    private final Identifier cameraConfigId;
    private final String cameraIdString;

    public int hashCode() {
        return ((this.cameraIdString.hashCode() ^ 1000003) * 1000003) ^ this.cameraConfigId.hashCode();
    }

    public String toString() {
        return "CameraId{cameraIdString=" + this.cameraIdString + ", cameraConfigId=" + this.cameraConfigId + i.f25855d;
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.CameraId
    public Identifier getCameraConfigId() {
        return this.cameraConfigId;
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.CameraId
    public String getCameraIdString() {
        return this.cameraIdString;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraUseCaseAdapter.CameraId) == false) goto L14;
        CameraUseCaseAdapter.CameraId r101 = (CameraUseCaseAdapter.CameraId) r100;
        if (this.cameraIdString.equals(r101.getCameraIdString()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.cameraConfigId.equals(r101.getCameraConfigId()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_CameraUseCaseAdapter_CameraId(String r100, Identifier r101) {
        if (r100 == null) goto L11;
        this.cameraIdString = r100;
        if (r101 == null) goto L9;
        this.cameraConfigId = r101;
        return;
    L9:
        throw new NullPointerException("Null cameraConfigId");
    L11:
        throw new NullPointerException("Null cameraIdString");
    }
}
