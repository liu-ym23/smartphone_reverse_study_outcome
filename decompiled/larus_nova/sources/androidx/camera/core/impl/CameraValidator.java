package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraValidator {
    private static final CameraSelector EXTERNAL_LENS_FACING = null;
    private static final String TAG = "CameraValidator";

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static int getDeviceId(Context r100) {
            return r100.getDeviceId();
        }
    }

    public static class CameraIdListIncorrectException extends Exception {
        private int mAvailableCameraCount;

        public int getAvailableCameraCount() {
            return this.mAvailableCameraCount;
        }

        public CameraIdListIncorrectException(String r100, int r101, Throwable r102) {
            super(r100, r102);
            this.mAvailableCameraCount = r101;
        }
    }

    static {
        EXTERNAL_LENS_FACING = new CameraSelector.Builder().requireLensFacing(2).build();
    }

    private CameraValidator() {
    }

    public static void validateCameras(Context r100, CameraRepository r101, CameraSelector r102) throws CameraIdListIncorrectException {
        int r103 = 0;
        IllegalArgumentException r104 = null;
        if (Build.VERSION.SDK_INT >= 34) goto L5;
    L12:
        if (r102 != null) goto L52;
        Integer r105 = null;
    L21:
        Logger.d(TAG, "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + r105);
        PackageManager r106 = r100.getPackageManager();
    L30:
        e = move-exception;
        r104 = e;
        Logger.w(TAG, "Camera LENS_FACING_BACK verification failed", r104);
    L54:
    L39:
        e = move-exception;
        r104 = e;
        Logger.w(TAG, "Camera LENS_FACING_FRONT verification failed", r104);
    L48:
        EXTERNAL_LENS_FACING.select(r101.getCameras());     // Catch: IllegalArgumentException -> L43
        Logger.d(TAG, "Found a LENS_FACING_EXTERNAL camera");     // Catch: IllegalArgumentException -> L43
        r103 = r103 + 1;
    L44:
        if (r104 != null) goto L46;
        return;
    L46:
        Logger.e(TAG, "Camera LensFacing verification failed, existing cameras: " + r101.getCameras());
        throw new CameraIdListIncorrectException("Expected camera missing from device.", r103, r104);
    L33:
        if (r106.hasSystemFeature("android.hardware.camera.front") == false) goto L48;
        if (r102 != null) goto L36;
    L37:
        CameraSelector.DEFAULT_FRONT_CAMERA.select(r101.getCameras());     // Catch: IllegalArgumentException -> L39
        r103 = r103 + 1;
        goto L48
    L36:
        if (r105.intValue() != 0) goto L48;
    L23:
        if (r106.hasSystemFeature("android.hardware.camera") == false) goto L54;
        if (r102 != null) goto L27;
    L28:
        CameraSelector.DEFAULT_BACK_CAMERA.select(r101.getCameras());     // Catch: IllegalArgumentException -> L30
        r103 = 1;
        goto L54
    L27:
        if (r105.intValue() != 1) goto L54;
    L52:
        r105 = r102.getLensFacing();     // Catch: IllegalStateException -> L17
        if (r105 != null) goto L21;
        Logger.w(TAG, "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");     // Catch: IllegalStateException -> L17
        return;
    L17:
        e = move-exception;
        Logger.e(TAG, "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e);
        return;
    L5:
        if (Api34Impl.getDeviceId(r100) == 0) goto L12;
        LinkedHashSet<CameraInternal> r107 = r101.getCameras();
        if (r107.isEmpty() == true) goto L11;
        Logger.d(TAG, "Virtual device with ID: " + Api34Impl.getDeviceId(r100) + " has " + r107.size() + " cameras. Skipping validation.");
        return;
    L11:
        throw new CameraIdListIncorrectException("No cameras available", 0, null);
    }
}
