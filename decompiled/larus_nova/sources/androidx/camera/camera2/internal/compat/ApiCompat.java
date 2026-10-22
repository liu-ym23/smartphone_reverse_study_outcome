package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
public final class ApiCompat {

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_com_obric_performance_power_monitor_camera_CameraLancet_close(CameraDevice r100) {
            if (fna.g.d() == true) goto L6;
            androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_android_hardware_camera2_CameraDevice_close(r100);
            return;
        L6:
            androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_android_hardware_camera2_CameraDevice_close(r100);
            if ((r100 instanceof CameraDevice) == false) goto L10;
            jna.a.a(r100.getId());
            return;
        }

        private static void androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_android_hardware_camera2_CameraDevice_close(CameraDevice r110) {
            f06.c r100 = new f06.c();
            Object[] r101 = new Object[0];
            f06.b r111 = new f06.b();
            if (r100.b(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, "void", r111).f474982a == false) goto L6;
            r100.a(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, null, r111, false);
            return;
        L6:
            r110.close();
            r100.a(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, null, r111, true);
        }

        public static void close(CameraDevice r100) {
            INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_com_obric_performance_power_monitor_camera_CameraLancet_close(r100);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void onSurfacePrepared(CameraCaptureSession.StateCallback r100, CameraCaptureSession r101, Surface r102) {
            r100.onSurfacePrepared(r101, r102);
        }
    }

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void onCaptureBufferLost(CameraCaptureSession.CaptureCallback r100, CameraCaptureSession r101, CaptureRequest r102, Surface r103, long r104) {
            r100.onCaptureBufferLost(r101, r102, r103, r104);
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static <T> OutputConfiguration newOutputConfiguration(Size r100, Class<T> r101) {
            return new OutputConfiguration(r100, r101);
        }

        public static void onCaptureQueueEmpty(CameraCaptureSession.StateCallback r100, CameraCaptureSession r101) {
            r100.onCaptureQueueEmpty(r101);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void onCameraAccessPrioritiesChanged(CameraManager.AvailabilityCallback r100) {
            r100.onCameraAccessPrioritiesChanged();
        }
    }

    private ApiCompat() {
    }
}
