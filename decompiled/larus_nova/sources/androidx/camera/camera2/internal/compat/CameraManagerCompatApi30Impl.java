package androidx.camera.camera2.internal.compat;

import android.content.Context;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class CameraManagerCompatApi30Impl extends CameraManagerCompatApi29Impl {
    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat {
        return this.mCameraManager.getConcurrentCameraIds();
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    public CameraManagerCompatApi30Impl(Context r100) {
        super(r100);
    }
}
