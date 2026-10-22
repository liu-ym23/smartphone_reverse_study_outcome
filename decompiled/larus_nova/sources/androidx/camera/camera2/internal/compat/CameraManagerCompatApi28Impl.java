package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class CameraManagerCompatApi28Impl extends CameraManagerCompatBaseImpl {
    public CameraManagerCompatApi28Impl(Context r100) {
        super(r100, null);
    }

    public static CameraManagerCompatApi28Impl create(Context r100) {
        return new CameraManagerCompatApi28Impl(r100);
    }

    private boolean isDndFailCase(Throwable r100) {
        if (Build.VERSION.SDK_INT == 28) goto L5;
    L7:
        return false;
    L5:
        if (isDndRuntimeException(r100) == false) goto L7;
        return true;
    }

    private static boolean isDndRuntimeException(Throwable r100) {
        if (r100.getClass().equals(RuntimeException.class) == false) goto L11;
        StackTraceElement[] r101 = r100.getStackTrace();
        if (r101 == null) goto L11;
        if (r101.length < 0) goto L11;
        return "_enableShutterSound".equals(r101[0].getMethodName());
    L11:
        return false;
    }

    private void throwDndException(Throwable r100) throws CameraAccessExceptionCompat {
        throw new CameraAccessExceptionCompat(10001, r100);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public CameraCharacteristics getCameraCharacteristics(String r100) throws CameraAccessExceptionCompat {
        return super.getCameraCharacteristics(r100);
    L4:
        e = move-exception;
        if (isDndFailCase(e) == false) goto L8;
        throwDndException(e);
    L8:
        throw e;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback r100) {
        this.mCameraManager.unregisterAvailabilityCallback(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void registerAvailabilityCallback(Executor r100, CameraManager.AvailabilityCallback r101) {
        this.mCameraManager.registerAvailabilityCallback(r100, r101);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void openCamera(String r100, Executor r101, CameraDevice.StateCallback r102) throws CameraAccessExceptionCompat {
        INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(this.mCameraManager, r100, r101, r102);     // Catch: RuntimeException -> L4 SecurityException -> L9 IllegalArgumentException -> L11 CameraAccessException -> L13
        return;
    L13:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    L11:
        e = move-exception;
        throw e;
    L9:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        if (isDndFailCase(e) == false) goto L8;
        throwDndException(e);
    L8:
        throw e;
    }

    public static void INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(CameraManager r100, String r101, Executor r102, CameraDevice.StateCallback r103) throws CameraAccessException {
        if (fna.g.d() == true) goto L6;
        androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_android_hardware_camera2_CameraManager_openCamera(r100, r101, r102, r103);
        return;
    L6:
        androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_android_hardware_camera2_CameraManager_openCamera(r100, r101, r102, r103);
        jna.a.b(r101);
    }

    private static void androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_android_hardware_camera2_CameraManager_openCamera(CameraManager r110, String r111, Executor r112, CameraDevice.StateCallback r113) throws CameraAccessException {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113};
        f06.b r114 = new f06.b();
        if (r100.b(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, "void", r114).f474982a == false) goto L6;
        r100.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, null, r114, false);
        return;
    L6:
        r110.openCamera(r111, r112, r113);
        r100.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, null, r114, true);
    }
}
