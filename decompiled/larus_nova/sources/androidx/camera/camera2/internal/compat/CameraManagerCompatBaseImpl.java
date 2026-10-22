package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class CameraManagerCompatBaseImpl implements CameraManagerCompat.CameraManagerCompatImpl {
    final CameraManager mCameraManager;
    final Object mObject;

    public static final class CameraManagerCompatParamsApi21 {
        final Handler mCompatHandler;
        final Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> mWrapperMap;

        public CameraManagerCompatParamsApi21(Handler r100) {
            this.mWrapperMap = new HashMap();
            this.mCompatHandler = r100;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public String[] getCameraIdList() throws CameraAccessExceptionCompat {
        return this.mCameraManager.getCameraIdList();
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat {
        return Collections.emptySet();
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public CameraManager getCameraManager() {
        return this.mCameraManager;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public CameraCharacteristics getCameraCharacteristics(String r100) throws CameraAccessExceptionCompat {
        return this.mCameraManager.getCameraCharacteristics(r100);
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback r100) {
        if (r100 == null) goto L11;
        CameraManagerCompatParamsApi21 r101 = (CameraManagerCompatParamsApi21) this.mObject;
        Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> r102 = r101.mWrapperMap;
        monitor-enter(r102);
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper r103 = r101.mWrapperMap.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(r102);     // Catch: Throwable -> L8
    L12:
        if (r103 == null) goto L14;
        r103.setDisabled();
    L14:
        this.mCameraManager.unregisterAvailabilityCallback(r103);
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        r103 = null;
        goto L12
    }

    public CameraManagerCompatBaseImpl(Context r100, Object r101) {
        this.mCameraManager = (CameraManager) r100.getSystemService("camera");
        this.mObject = r101;
    }

    public static CameraManagerCompatBaseImpl create(Context r100, Handler r101) {
        return new CameraManagerCompatBaseImpl(r100, new CameraManagerCompatParamsApi21(r101));
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void registerAvailabilityCallback(Executor r100, CameraManager.AvailabilityCallback r101) {
        if (r100 == null) goto L19;
        CameraManagerCompatParamsApi21 r102 = (CameraManagerCompatParamsApi21) this.mObject;
        if (r101 == null) goto L15;
        Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> r103 = r102.mWrapperMap;
        monitor-enter(r103);
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper r104 = r102.mWrapperMap.get(r101);     // Catch: Throwable -> L12
        if (r104 != null) goto L10;
        r104 = new CameraManagerCompat.AvailabilityCallbackExecutorWrapper(r100, r101);     // Catch: Throwable -> L12
        r102.mWrapperMap.put(r101, r104);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r103);     // Catch: Throwable -> L12
    L16:
        this.mCameraManager.registerAvailabilityCallback(r104, r102.mCompatHandler);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        r104 = null;
        goto L16
    L19:
        throw new IllegalArgumentException("executor was null");
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void openCamera(String r100, Executor r101, CameraDevice.StateCallback r102) throws CameraAccessExceptionCompat {
        Preconditions.checkNotNull(r101);
        Preconditions.checkNotNull(r102);
        CameraDeviceCompat.StateCallbackExecutorWrapper r103 = new CameraDeviceCompat.StateCallbackExecutorWrapper(r101, r102);
        CameraManagerCompatParamsApi21 r104 = (CameraManagerCompatParamsApi21) this.mObject;
        INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(this.mCameraManager, r100, r103, r104.mCompatHandler);     // Catch: CameraAccessException -> L5
        return;
    L5:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    public static void INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(CameraManager r100, String r101, CameraDevice.StateCallback r102, Handler r103) throws CameraAccessException {
        if (fna.g.d() == true) goto L6;
        androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_android_hardware_camera2_CameraManager_openCamera(r100, r101, r102, r103);
        return;
    L6:
        androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_android_hardware_camera2_CameraManager_openCamera(r100, r101, r102, r103);
        jna.a.b(r101);
    }

    private static void androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_android_hardware_camera2_CameraManager_openCamera(CameraManager r110, String r111, CameraDevice.StateCallback r112, Handler r113) throws CameraAccessException {
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
