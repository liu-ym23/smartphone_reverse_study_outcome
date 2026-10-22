package com.android.server.biometrics;

import android.hardware.SensorPrivacyManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BiometricCameraManagerImpl implements BiometricCameraManager {
    private static final String TAG = "BiometricCameraManager";
    private final CameraManager.AvailabilityCallback mCameraAvailabilityCallback;
    private final CameraManager mCameraManager;
    private final ConcurrentHashMap<String, Boolean> mIsCameraAvailable;
    private final SensorPrivacyManager mSensorPrivacyManager;

    /* JADX INFO: renamed from: -$$Nest$fgetmIsCameraAvailable, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConcurrentHashMap m2564$$Nest$fgetmIsCameraAvailable(BiometricCameraManagerImpl r0) {
        return r0.mIsCameraAvailable;
    }

    public BiometricCameraManagerImpl(CameraManager cameraManager, SensorPrivacyManager sensorPrivacyManager) {
        this.mIsCameraAvailable = new ConcurrentHashMap();
        this.mCameraAvailabilityCallback = new AnonymousClass1(this);
        this.mCameraManager = cameraManager;
        this.mSensorPrivacyManager = sensorPrivacyManager;
        this.mCameraManager.registerAvailabilityCallback(this.mCameraAvailabilityCallback, null);
    }

    @Override // com.android.server.biometrics.BiometricCameraManager
    public boolean isAnyCameraUnavailable() {
        String[] r1 = this.mCameraManager.getCameraIdList();     // Catch: CameraAccessException -> L9
        int r2 = r1.length;     // Catch: CameraAccessException -> L9
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L11;
        String cameraId = r1[r3];     // Catch: CameraAccessException -> L9
        if (this.mIsCameraAvailable.getOrDefault(cameraId, true).booleanValue() == false) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        return true;
    L11:
        return false;
    L9:
        e = move-exception;
        Log.e(TAG, "Camera exception thrown when trying to determine availability: ", e);
        return false;
    }

    @Override // com.android.server.biometrics.BiometricCameraManager
    public boolean isCameraPrivacyEnabled() {
        if (this.mSensorPrivacyManager != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mSensorPrivacyManager.isSensorPrivacyEnabled(1, 2) == false) goto L7;
        return true;
    }
}
