package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class CameraCaptureSessionCompatApi28Impl extends CameraCaptureSessionCompatBaseImpl {
    public CameraCaptureSessionCompatApi28Impl(CameraCaptureSession r100) {
        super(r100, null);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        return this.mCameraCaptureSession.captureBurstRequests(r100, r101, r102);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureSingleRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        return this.mCameraCaptureSession.captureSingleRequest(r100, r101, r102);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setRepeatingBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        return this.mCameraCaptureSession.setRepeatingBurstRequests(r100, r101, r102);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setSingleRepeatingRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        return this.mCameraCaptureSession.setSingleRepeatingRequest(r100, r101, r102);
    }
}
