package androidx.camera.lifecycle;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_LifecycleCameraRepository_Key extends LifecycleCameraRepository.Key {
    private final CameraUseCaseAdapter.CameraId cameraId;
    private final LifecycleOwner lifecycleOwner;

    public int hashCode() {
        return ((this.lifecycleOwner.hashCode() ^ 1000003) * 1000003) ^ this.cameraId.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwner=" + this.lifecycleOwner + ", cameraId=" + this.cameraId + i.f25855d;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    public CameraUseCaseAdapter.CameraId getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof LifecycleCameraRepository.Key) == false) goto L14;
        LifecycleCameraRepository.Key r101 = (LifecycleCameraRepository.Key) r100;
        if (this.lifecycleOwner.equals(r101.getLifecycleOwner()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.cameraId.equals(r101.getCameraId()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_LifecycleCameraRepository_Key(LifecycleOwner r100, CameraUseCaseAdapter.CameraId r101) {
        if (r100 == null) goto L11;
        this.lifecycleOwner = r100;
        if (r101 == null) goto L9;
        this.cameraId = r101;
        return;
    L9:
        throw new NullPointerException("Null cameraId");
    L11:
        throw new NullPointerException("Null lifecycleOwner");
    }
}
