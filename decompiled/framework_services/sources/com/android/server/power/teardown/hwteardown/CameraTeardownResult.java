package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraTeardownResult extends ComponentResult {
    public ConcurrentHashMap<CameraInfoKey, Long> mCameraInfo;

    public static class CameraInfoKey {
        int mCameraId;
        int mModeIndex;
        String mPkg;

        public CameraInfoKey(int cameraId, int modeIndex, String pkg) {
            this.mCameraId = cameraId;
            this.mModeIndex = modeIndex;
            if (pkg == null) goto L5;
            String r0 = pkg;
        L6:
            this.mPkg = r0;
            return;
        L5:
            r0 = "";
            goto L6
        }

        public CameraInfoKey() {
            this.mPkg = "Unknown";
        }

        public int getmCameraId() {
            return this.mCameraId;
        }

        public int getmModeIndex() {
            return this.mModeIndex;
        }

        public String getmPkg() {
            return this.mPkg;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L19;
            CameraInfoKey that = (CameraInfoKey) o;
            if (this.mCameraId != that.mCameraId) goto L18;
            if (this.mModeIndex != that.mModeIndex) goto L18;
            if (this.mPkg.equals(that.mPkg) == false) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mPkg, Integer.valueOf(this.mCameraId), Integer.valueOf(this.mModeIndex)});
        }

        public String cameraIdToString(int cameraId) {
            switch(cameraId) {
                case 0: goto L11;
                case 1: goto L9;
                case 2: goto L3;
                case 3: goto L7;
                case 4: goto L3;
                case 5: goto L5;
                default: goto L3;
            };
        L3:
            return "Unknown";
        L5:
            return "RearSat";
        L7:
            return "RearUltraWide";
        L9:
            return "Front";
        L11:
            return "RearMain";
        }

        public String toString() {
            return "camera=" + cameraIdToString(this.mCameraId) + ", modeIndex=" + this.mModeIndex + ", pkg:" + this.mPkg;
        }
    }

    public CameraTeardownResult(int cameraCurrent, ConcurrentHashMap<CameraInfoKey, Long> cameraInfo) {
        this.mCurrent = cameraCurrent;
        this.mCameraInfo = cameraInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Camera] camera current = ");
        sb.append(this.mCurrent);
        sb.append("mA\n");
        Iterator<Map.Entry<CameraInfoKey, Long>> r1 = this.mCameraInfo.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<CameraInfoKey, Long> entry = r1.next();
        sb.append("[Camera] cameraInfo: " + entry.getKey() + " duration:" + (entry.getValue().longValue() / 1000) + "s\n");
        goto L4
    L7:
        return sb.toString();
    }
}
