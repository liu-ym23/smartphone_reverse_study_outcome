package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraUidTeardownResult extends ComponentResult {
    public int mBgCurrent;
    public ConcurrentHashMap<String, CameraPackageInfo> mCameraPackageEntrys;

    public static class CameraPackageInfo {
        public int mBgCurrent;
        public int mCurrent;
        public String mPackageName;
        public List<CameraProcInfo> mProcInfoList;
        public List<CameraProcInfo> mProcInfoListBg;
        public int mUid;

        public CameraPackageInfo(String packageName, int uid) {
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mProcInfoList = new ArrayList();
            this.mProcInfoListBg = new ArrayList();
        }

        public String toString() {
            return "pkg=" + this.mPackageName + ", uid=" + this.mUid + ", current=" + this.mCurrent + "mA, bgCurrent=" + this.mBgCurrent + "mA";
        }
    }

    public static class CameraProcInfo {
        public int mBgCurrent;
        public ConcurrentHashMap<CameraUidInfoKey, Long> mCameraInfo;
        public int mCurrent;
        public CameraUidTeardownResult mOuter;
        public int mPid;
        public String mProcessName;

        public CameraProcInfo(int pid, String processName, CameraUidTeardownResult outer) {
            this.mPid = pid;
            this.mProcessName = processName;
            this.mCameraInfo = new ConcurrentHashMap();
            this.mOuter = outer;
        }

        public CameraProcInfo(CameraUidTeardownResult outer) {
            this(-1, "Unknown", outer);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("pid=");
            sb.append(this.mPid);
            sb.append(", processName=");
            sb.append(this.mProcessName);
            sb.append(", current=");
            sb.append(this.mCurrent);
            sb.append("mA, bgCurrent=");
            sb.append(this.mBgCurrent);
            sb.append("mA");
            boolean start = false;
            if (this.mCameraInfo == null) goto L20;
            ConcurrentHashMap<String, CameraPackageInfo> r2 = this.mOuter.mCameraPackageEntrys;
            monitor-enter(r2);
            Iterator<Map.Entry<CameraUidInfoKey, Long>> r3 = this.mCameraInfo.entrySet().iterator();     // Catch: Throwable -> L12
        L8:
            if (r3.hasNext() == false) goto L15;
            Map.Entry<CameraUidInfoKey, Long> entry = r3.next();     // Catch: Throwable -> L12
            sb.append("[");     // Catch: Throwable -> L12
            sb.append("cameraInfo: " + entry.getKey() + " duration:" + (entry.getValue().longValue() / 1000) + "s]");     // Catch: Throwable -> L12
            if (start == false) goto L14;
            sb.append(",");     // Catch: Throwable -> L12
        L14:
            start = true;
            goto L8
        L15:
            monitor-exit(r2);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L20:
            return sb.toString();
        }
    }

    public static class CameraUidInfoKey {
        int mCameraId;
        int mModeIndex;

        public CameraUidInfoKey(int cameraId, int modeIndex) {
            this.mCameraId = cameraId;
            this.mModeIndex = modeIndex;
        }

        public CameraUidInfoKey() {
        }

        public int getmCameraId() {
            return this.mCameraId;
        }

        public int getmModeIndex() {
            return this.mModeIndex;
        }

        public boolean equals(Object o) {
            if (o != null) goto L5;
        L13:
            return false;
        L5:
            if (getClass() != o.getClass()) goto L13;
            CameraUidInfoKey that = (CameraUidInfoKey) o;
            if (this.mCameraId == that.mCameraId) goto L10;
            return false;
        L10:
            if (this.mModeIndex != that.mModeIndex) goto L15;
            return true;
        L15:
            return false;
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

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mCameraId), Integer.valueOf(this.mModeIndex)});
        }

        public String toString() {
            return "camera=" + cameraIdToString(this.mCameraId) + ", modeIndex=" + this.mModeIndex;
        }
    }

    public static /* synthetic */ CameraPackageInfo $r8$lambda$0XsOo1oHJRfW3EahIn1838jD_cg(int r0, String r1) {
        return lambda$getPrcoInfo$0(r0, r1);
    }

    public static /* synthetic */ CameraPackageInfo $r8$lambda$UDabDao1SPJrvEVfNbi7ygts5PU(int r0, String r1) {
        return lambda$getBgPrcoInfo$1(r0, r1);
    }

    public CameraUidTeardownResult() {
        this.mCameraPackageEntrys = new ConcurrentHashMap();
    }

    public CameraUidTeardownResult(int cameraCurrent, HashMap<String, CameraPackageInfo> cameraInfo) {
        this.mCurrent = cameraCurrent;
        this.mCameraPackageEntrys = new ConcurrentHashMap();
        if (cameraInfo == null) goto L21;
        ConcurrentHashMap<String, CameraPackageInfo> r0 = this.mCameraPackageEntrys;
        monitor-enter(r0);
        Iterator<Map.Entry<String, CameraPackageInfo>> r1 = cameraInfo.entrySet().iterator();     // Catch: Throwable -> L14
    L8:
        if (r1.hasNext() == false) goto L17;
        Map.Entry<String, CameraPackageInfo> entry = r1.next();     // Catch: Throwable -> L14
        if (entry.getKey() == null) goto L8;
        if (entry.getValue() == null) goto L8;
        this.mCameraPackageEntrys.put(entry.getKey(), entry.getValue());     // Catch: Throwable -> L14
        goto L8
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public CameraProcInfo getPrcoInfo(String packageName, final int uid, int pid) {
        if (packageName != null) goto L4;
        packageName = "Unknown";
    L4:
        CameraPackageInfo packageInfo = this.mCameraPackageEntrys.computeIfAbsent(packageName, new CameraUidTeardownResult$$ExternalSyntheticLambda0(uid));
        ConcurrentHashMap<String, CameraPackageInfo> r1 = this.mCameraPackageEntrys;
        monitor-enter(r1);
        int i = 0;
    L22:
    L14:
        th = move-exception;
        throw th;
    L8:
        if (i >= packageInfo.mProcInfoList.size()) goto L17;
        if (packageInfo.mProcInfoList.get(i).mPid == pid) goto L11;
        i = i + 1;     // Catch: Throwable -> L14
        goto L22
    L11:
        CameraProcInfo r3 = packageInfo.mProcInfoList.get(i);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r3;
    L17:
        CameraProcInfo procInfo = new CameraProcInfo(this);     // Catch: Throwable -> L14
        packageInfo.mProcInfoList.add(procInfo);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return procInfo;
    }

    private static /* synthetic */ CameraPackageInfo lambda$getPrcoInfo$0(int uid, String k) {
        return new CameraPackageInfo(k, uid);
    }

    public CameraProcInfo getBgPrcoInfo(String packageName, final int uid, int pid) {
        if (packageName != null) goto L4;
        packageName = "Unknown";
    L4:
        CameraPackageInfo packageInfo = this.mCameraPackageEntrys.computeIfAbsent(packageName, new CameraUidTeardownResult$$ExternalSyntheticLambda1(uid));
        ConcurrentHashMap<String, CameraPackageInfo> r1 = this.mCameraPackageEntrys;
        monitor-enter(r1);
        int i = 0;
    L22:
    L14:
        th = move-exception;
        throw th;
    L8:
        if (i >= packageInfo.mProcInfoListBg.size()) goto L17;
        if (packageInfo.mProcInfoListBg.get(i).mPid == pid) goto L11;
        i = i + 1;     // Catch: Throwable -> L14
        goto L22
    L11:
        CameraProcInfo r3 = packageInfo.mProcInfoListBg.get(i);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r3;
    L17:
        CameraProcInfo procInfo = new CameraProcInfo(this);     // Catch: Throwable -> L14
        packageInfo.mProcInfoListBg.add(procInfo);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return procInfo;
    }

    private static /* synthetic */ CameraPackageInfo lambda$getBgPrcoInfo$1(int uid, String k) {
        return new CameraPackageInfo(k, uid);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[CAMERA_ALL] camera current=");
        sb.append(this.mCurrent);
        sb.append("mA, bgCurrent=");
        sb.append(this.mBgCurrent);
        sb.append("mA\n");
        ConcurrentHashMap<String, CameraPackageInfo> r1 = this.mCameraPackageEntrys;
        monitor-enter(r1);
        Iterator<Map.Entry<String, CameraPackageInfo>> r2 = this.mCameraPackageEntrys.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L18;
        Map.Entry<String, CameraPackageInfo> entry = r2.next();     // Catch: Throwable -> L15
        CameraPackageInfo packageInfo = entry.getValue();     // Catch: Throwable -> L15
        int i = 0;
    L9:
        if (i >= packageInfo.mProcInfoList.size()) goto L6;
        if (packageInfo.mProcInfoList.get(i).mCurrent <= 0) goto L14;
        sb.append("[Camera]");     // Catch: Throwable -> L15
        sb.append("pkg=");     // Catch: Throwable -> L15
        sb.append(entry.getKey());     // Catch: Throwable -> L15
        sb.append(", uid=");     // Catch: Throwable -> L15
        sb.append(packageInfo.mUid);     // Catch: Throwable -> L15
        sb.append(", ");     // Catch: Throwable -> L15
        sb.append(packageInfo.mProcInfoList.get(i).toString());     // Catch: Throwable -> L15
        sb.append("\n");     // Catch: Throwable -> L15
    L14:
        i = i + 1;     // Catch: Throwable -> L15
        goto L9
    L18:
        Iterator<Map.Entry<String, CameraPackageInfo>> r3 = this.mCameraPackageEntrys.entrySet().iterator();     // Catch: Throwable -> L15
    L20:
        if (r3.hasNext() == false) goto L30;
        Map.Entry<String, CameraPackageInfo> entry2 = r3.next();     // Catch: Throwable -> L15
        CameraPackageInfo packageInfo2 = entry2.getValue();     // Catch: Throwable -> L15
        int i2 = 0;
    L23:
        if (i2 >= packageInfo2.mProcInfoListBg.size()) goto L20;
        if (packageInfo2.mProcInfoListBg.get(i2).mCurrent <= 0) goto L28;
        sb.append("[Camera_BG]");     // Catch: Throwable -> L15
        sb.append("pkg=");     // Catch: Throwable -> L15
        sb.append(entry2.getKey());     // Catch: Throwable -> L15
        sb.append(", uid=");     // Catch: Throwable -> L15
        sb.append(packageInfo2.mUid);     // Catch: Throwable -> L15
        sb.append(", ");     // Catch: Throwable -> L15
        sb.append(packageInfo2.mProcInfoListBg.get(i2).toString());     // Catch: Throwable -> L15
        sb.append("\n");     // Catch: Throwable -> L15
    L28:
        i2 = i2 + 1;     // Catch: Throwable -> L15
        goto L23
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return sb.toString();
    L15:
        th = move-exception;
        throw th;
    }
}
