package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
class CameraDeviceCompatApi28Impl extends CameraDeviceCompatApi24Impl {
    public CameraDeviceCompatApi28Impl(CameraDevice r100) {
        super((CameraDevice) Preconditions.checkNotNull(r100), null);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompatApi24Impl, androidx.camera.camera2.internal.compat.CameraDeviceCompatApi23Impl, androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(SessionConfigurationCompat r100) throws CameraAccessExceptionCompat {
        SessionConfiguration r101 = (SessionConfiguration) r100.unwrap();
        Preconditions.checkNotNull(r101);
        this.mCameraDevice.createCaptureSession(r101);     // Catch: CameraAccessException -> L5
        return;
    L5:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }
}
