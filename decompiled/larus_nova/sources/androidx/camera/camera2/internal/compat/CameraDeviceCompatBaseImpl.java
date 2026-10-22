package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class CameraDeviceCompatBaseImpl implements CameraDeviceCompat.CameraDeviceCompatImpl {
    final CameraDevice mCameraDevice;
    final Object mImplParams;

    public static class CameraDeviceCompatParamsApi21 {
        final Handler mCompatHandler;

        public CameraDeviceCompatParamsApi21(Handler r100) {
            this.mCompatHandler = r100;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public CameraDevice unwrap() {
        return this.mCameraDevice;
    }

    public static List<Surface> unpackSurfaces(List<OutputConfigurationCompat> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<OutputConfigurationCompat> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next().getSurface());
        goto L4
    L6:
        return r101;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(SessionConfigurationCompat r100) throws CameraAccessExceptionCompat {
        checkPreconditions(this.mCameraDevice, r100);
        if (r100.getInputConfiguration() != null) goto L11;
        if (r100.getSessionType() == 1) goto L9;
        CameraCaptureSessionCompat.StateCallbackExecutorWrapper r101 = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(r100.getExecutor(), r100.getStateCallback());
        List<Surface> r102 = unpackSurfaces(r100.getOutputConfigurations());
        CameraDeviceCompatParamsApi21 r103 = (CameraDeviceCompatParamsApi21) this.mImplParams;
        createBaseCaptureSession(this.mCameraDevice, r102, r101, r103.mCompatHandler);
        return;
    L9:
        throw new IllegalArgumentException("High speed capture sessions not supported until API 23");
    L11:
        throw new IllegalArgumentException("Reprocessing sessions not supported until API 23");
    }

    public CameraDeviceCompatBaseImpl(CameraDevice r100, Object r101) {
        this.mCameraDevice = (CameraDevice) Preconditions.checkNotNull(r100);
        this.mImplParams = r101;
    }

    private static void checkPhysicalCameraIdValid(CameraDevice r100, List<OutputConfigurationCompat> r101) {
        String r102 = r100.getId();
        Iterator<OutputConfigurationCompat> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next().getPhysicalCameraId();
        if (r104 == null) goto L4;
        if (r104.isEmpty() == true) goto L4;
        Logger.w("CameraDeviceCompat", "Camera " + r102 + ": Camera doesn't support physicalCameraId " + r104 + ". Ignoring.");
        goto L4
    }

    public static void checkPreconditions(CameraDevice r100, SessionConfigurationCompat r101) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        Preconditions.checkNotNull(r101.getStateCallback());
        List<OutputConfigurationCompat> r102 = r101.getOutputConfigurations();
        if (r102 == null) goto L11;
        if (r101.getExecutor() == null) goto L9;
        checkPhysicalCameraIdValid(r100, r102);
        return;
    L9:
        throw new IllegalArgumentException("Invalid executor");
    L11:
        throw new IllegalArgumentException("Invalid output configurations");
    }

    public static CameraDeviceCompatBaseImpl create(CameraDevice r100, Handler r101) {
        return new CameraDeviceCompatBaseImpl(r100, new CameraDeviceCompatParamsApi21(r101));
    }

    public void createBaseCaptureSession(CameraDevice r100, List<Surface> r101, CameraCaptureSession.StateCallback r102, Handler r103) throws CameraAccessExceptionCompat {
        r100.createCaptureSession(r101, r102, r103);     // Catch: CameraAccessException -> L4
        return;
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }
}
