package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class CameraManagerCompatApi29Impl extends CameraManagerCompatApi28Impl {
    public CameraManagerCompatApi29Impl(Context r100) {
        super(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatApi28Impl, androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public CameraCharacteristics getCameraCharacteristics(String r100) throws CameraAccessExceptionCompat {
        return this.mCameraManager.getCameraCharacteristics(r100);
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatApi28Impl, androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void openCamera(String r100, Executor r101, CameraDevice.StateCallback r102) throws CameraAccessExceptionCompat {
        INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(this.mCameraManager, r100, r101, r102);     // Catch: CameraAccessException -> L4
        return;
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    public static void INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(CameraManager r100, String r101, Executor r102, CameraDevice.StateCallback r103) throws CameraAccessException {
        if (fna.g.d() == true) goto L6;
        androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_android_hardware_camera2_CameraManager_openCamera(r100, r101, r102, r103);
        return;
    L6:
        androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_android_hardware_camera2_CameraManager_openCamera(r100, r101, r102, r103);
        jna.a.b(r101);
    }

    private static void androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_android_hardware_camera2_CameraManager_openCamera(CameraManager r110, String r111, Executor r112, CameraDevice.StateCallback r113) throws CameraAccessException {
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
