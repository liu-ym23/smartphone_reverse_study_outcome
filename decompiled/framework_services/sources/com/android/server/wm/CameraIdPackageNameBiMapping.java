package com.android.server.wm;

import android.util.ArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class CameraIdPackageNameBiMapping {
    private final Map<String, String> mCameraIdToPackageMap;
    private final Map<String, String> mPackageToCameraIdMap;

    CameraIdPackageNameBiMapping() {
        this.mPackageToCameraIdMap = new ArrayMap();
        this.mCameraIdToPackageMap = new ArrayMap();
    }

    boolean isEmpty() {
        return this.mCameraIdToPackageMap.isEmpty();
    }

    void put(String packageName, String cameraId) {
        removePackageName(packageName);
        removeCameraId(cameraId);
        this.mPackageToCameraIdMap.put(packageName, cameraId);
        this.mCameraIdToPackageMap.put(cameraId, packageName);
    }

    boolean containsPackageName(String packageName) {
        return this.mPackageToCameraIdMap.containsKey(packageName);
    }

    String getCameraId(String packageName) {
        return this.mPackageToCameraIdMap.get(packageName);
    }

    void removeCameraId(String cameraId) {
        String packageName = this.mCameraIdToPackageMap.get(cameraId);
        if (packageName != null) goto L5;
        return;
    L5:
        this.mPackageToCameraIdMap.remove(packageName, cameraId);
        this.mCameraIdToPackageMap.remove(cameraId, packageName);
    }

    String getSummaryForDisplayRotationHistoryRecord() {
        return "{ mPackageToCameraIdMap=" + this.mPackageToCameraIdMap + " }";
    }

    private void removePackageName(String packageName) {
        String cameraId = this.mPackageToCameraIdMap.get(packageName);
        if (cameraId != null) goto L5;
        return;
    L5:
        this.mPackageToCameraIdMap.remove(packageName, cameraId);
        this.mCameraIdToPackageMap.remove(cameraId, packageName);
    }
}
