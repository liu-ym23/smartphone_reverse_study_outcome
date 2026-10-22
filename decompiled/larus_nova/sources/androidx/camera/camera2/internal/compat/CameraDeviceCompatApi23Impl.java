package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class CameraDeviceCompatApi23Impl extends CameraDeviceCompatBaseImpl {
    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(SessionConfigurationCompat r100) throws CameraAccessExceptionCompat {
        CameraDeviceCompatBaseImpl.checkPreconditions(this.mCameraDevice, r100);
        CameraCaptureSessionCompat.StateCallbackExecutorWrapper r101 = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(r100.getExecutor(), r100.getStateCallback());
        List<Surface> r102 = CameraDeviceCompatBaseImpl.unpackSurfaces(r100.getOutputConfigurations());
        Handler r103 = ((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) Preconditions.checkNotNull((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) this.mImplParams)).mCompatHandler;
        InputConfigurationCompat r104 = r100.getInputConfiguration();
        if (r104 == null) goto L6;
        InputConfiguration r105 = (InputConfiguration) r104.unwrap();     // Catch: CameraAccessException -> L10
        Preconditions.checkNotNull(r105);     // Catch: CameraAccessException -> L10
        this.mCameraDevice.createReprocessableCaptureSession(r105, r102, r101, r103);     // Catch: CameraAccessException -> L10
    L13:
        return;
    L6:
        if (r100.getSessionType() != 1) goto L8;
        this.mCameraDevice.createConstrainedHighSpeedCaptureSession(r102, r101, r103);     // Catch: CameraAccessException -> L10
        goto L13
    L8:
        createBaseCaptureSession(this.mCameraDevice, r102, r101, r103);     // Catch: CameraAccessException -> L10
    L10:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    public CameraDeviceCompatApi23Impl(CameraDevice r100, Object r101) {
        super(r100, r101);
    }

    public static CameraDeviceCompatApi23Impl create(CameraDevice r100, Handler r101) {
        return new CameraDeviceCompatApi23Impl(r100, new CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21(r101));
    }
}
