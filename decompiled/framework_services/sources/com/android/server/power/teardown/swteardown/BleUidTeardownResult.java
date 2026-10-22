package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BleUidTeardownResult extends ComponentResult {
    public long mBgCurrent;
    public HashMap<String, BlePackageInfo> mBlePackageEntrys;
    public long mDuration;

    public static class BlePackageInfo {
        public int mBgCurrent;
        public int mCurrent;
        public long mDuration;
        public String mPackageName;
        public List<BleProcInfo> mProcInfoList;
        public List<BleProcInfo> mProcInfoListBg;
        public int mUid;

        public BlePackageInfo(String packageName, int uid) {
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mProcInfoList = new ArrayList();
            this.mProcInfoListBg = new ArrayList();
        }

        public String toString() {
            return "pkg=" + this.mPackageName + ", uid=" + this.mUid + ", current=" + this.mCurrent + "mA, duration=" + (this.mDuration / 1000) + "s";
        }
    }

    public static class BleProcInfo {
        public int mCurrent;
        public long mDuration;
        public int mPid;
        public String mProcessName;

        public BleProcInfo(int current, int pid, String processName, long duration) {
            this.mCurrent = current;
            this.mPid = pid;
            this.mProcessName = processName;
            this.mDuration = duration;
        }

        public BleProcInfo() {
            this.mProcessName = "Unknown";
        }

        public String toString() {
            return "pid=" + this.mPid + ", processName=" + this.mProcessName + ", current=" + this.mCurrent + "mA, activeTime=" + (this.mDuration / 1000) + "s";
        }
    }

    public BleUidTeardownResult() {
        this.mBlePackageEntrys = new HashMap();
    }

    public BleProcInfo getPrcoInfo(String packageName, int uid, int pid) {
        if (this.mBlePackageEntrys.containsKey(packageName) == false) goto L14;
        BlePackageInfo packageInfo = this.mBlePackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoList.size()) goto L12;
        if (packageInfo.mProcInfoList.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoList.get(i);
    L12:
        BleProcInfo procInfo = new BleProcInfo();
        packageInfo.mProcInfoList.add(procInfo);
        return procInfo;
    L14:
        BleProcInfo procInfo2 = new BleProcInfo();
        BlePackageInfo packageInfo2 = new BlePackageInfo(packageName, uid);
        packageInfo2.mProcInfoList.add(procInfo2);
        this.mBlePackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public BleProcInfo getBgPrcoInfo(String packageName, int uid, int pid) {
        if (this.mBlePackageEntrys.containsKey(packageName) == false) goto L14;
        BlePackageInfo packageInfo = this.mBlePackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoListBg.size()) goto L12;
        if (packageInfo.mProcInfoListBg.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoListBg.get(i);
    L12:
        BleProcInfo procInfo = new BleProcInfo();
        packageInfo.mProcInfoListBg.add(procInfo);
        return procInfo;
    L14:
        BleProcInfo procInfo2 = new BleProcInfo();
        BlePackageInfo packageInfo2 = new BlePackageInfo(packageName, uid);
        packageInfo2.mProcInfoListBg.add(procInfo2);
        this.mBlePackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[BLE_All] ");
        sb.append("ble current=");
        sb.append(this.mCurrent);
        sb.append("mA, activeTime=");
        sb.append(this.mDuration / 1000);
        sb.append("s\n");
        Iterator<Map.Entry<String, BlePackageInfo>> r1 = this.mBlePackageEntrys.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, BlePackageInfo> entry = r1.next();
        BlePackageInfo packageInfo = entry.getValue();
        int i = 0;
    L7:
        if (i >= packageInfo.mProcInfoList.size()) goto L4;
        if (packageInfo.mProcInfoList.get(i).mCurrent <= 0) goto L12;
        sb.append("[BLE] ");
        sb.append("pkg=");
        sb.append(entry.getKey());
        sb.append(", uid=");
        sb.append(packageInfo.mUid);
        sb.append(", ");
        sb.append(packageInfo.mProcInfoList.get(i).toString());
        sb.append("\n");
    L12:
        i = i + 1;
        goto L7
    L14:
        Iterator<Map.Entry<String, BlePackageInfo>> r2 = this.mBlePackageEntrys.entrySet().iterator();
    L16:
        if (r2.hasNext() == false) goto L27;
        Map.Entry<String, BlePackageInfo> entry2 = r2.next();
        BlePackageInfo packageInfo2 = entry2.getValue();
        int i2 = 0;
    L19:
        if (i2 >= packageInfo2.mProcInfoListBg.size()) goto L16;
        if (packageInfo2.mProcInfoListBg.get(i2).mCurrent <= 0) goto L24;
        sb.append("[BLE_BG]");
        sb.append("pkg=");
        sb.append(entry2.getKey());
        sb.append(", uid=");
        sb.append(packageInfo2.mUid);
        sb.append(", ");
        sb.append(packageInfo2.mProcInfoListBg.get(i2).toString());
        sb.append("\n");
    L24:
        i2 = i2 + 1;
        goto L19
    L27:
        return sb.toString();
    }
}
