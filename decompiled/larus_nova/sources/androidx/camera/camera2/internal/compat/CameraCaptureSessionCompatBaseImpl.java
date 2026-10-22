package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class CameraCaptureSessionCompatBaseImpl implements CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl {
    final CameraCaptureSession mCameraCaptureSession;
    final Object mObject;

    public static class CameraCaptureSessionCompatParamsApi21 {
        final Handler mCompatHandler;

        public CameraCaptureSessionCompatParamsApi21(Handler r100) {
            this.mCompatHandler = r100;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public CameraCaptureSession unwrap() {
        return this.mCameraCaptureSession;
    }

    public CameraCaptureSessionCompatBaseImpl(CameraCaptureSession r100, Object r101) {
        this.mCameraCaptureSession = (CameraCaptureSession) Preconditions.checkNotNull(r100);
        this.mObject = r101;
    }

    public static CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl create(CameraCaptureSession r100, Handler r101) {
        return new CameraCaptureSessionCompatBaseImpl(r100, new CameraCaptureSessionCompatParamsApi21(r101));
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper r103 = new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(r101, r102);
        CameraCaptureSessionCompatParamsApi21 r104 = (CameraCaptureSessionCompatParamsApi21) this.mObject;
        return this.mCameraCaptureSession.captureBurst(r100, r103, r104.mCompatHandler);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureSingleRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper r103 = new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(r101, r102);
        CameraCaptureSessionCompatParamsApi21 r104 = (CameraCaptureSessionCompatParamsApi21) this.mObject;
        return this.mCameraCaptureSession.capture(r100, r103, r104.mCompatHandler);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setRepeatingBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper r103 = new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(r101, r102);
        CameraCaptureSessionCompatParamsApi21 r104 = (CameraCaptureSessionCompatParamsApi21) this.mObject;
        return this.mCameraCaptureSession.setRepeatingBurst(r100, r103, r104.mCompatHandler);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setSingleRepeatingRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper r103 = new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(r101, r102);
        CameraCaptureSessionCompatParamsApi21 r104 = (CameraCaptureSessionCompatParamsApi21) this.mObject;
        return this.mCameraCaptureSession.setRepeatingRequest(r100, r103, r104.mCompatHandler);
    }
}
