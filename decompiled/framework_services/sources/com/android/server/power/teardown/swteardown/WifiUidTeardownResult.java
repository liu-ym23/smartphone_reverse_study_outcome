package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WifiUidTeardownResult extends ComponentResult {
    public int mActiveCurrent;
    public int mBgCurrent;
    public int mOldCurrent;
    public int mScanCurrent;
    public HashMap<String, WifiPackageInfo> mWifiPackageEntrys;

    public static class WifiPackageInfo {
        public int mActiveCurrent;
        public int mBgCurrent;
        public int mBgSmallNetTrafficCount;
        public int mCurrent;
        public int mOldCurrent;
        public String mPackageName;
        public List<WifiProcInfo> mProcInfoList;
        public List<WifiProcInfo> mProcInfoListBg;
        public int mScanCurrent;
        public int mUid;

        public WifiPackageInfo(String packageName, int uid) {
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mProcInfoList = new ArrayList();
            this.mProcInfoListBg = new ArrayList();
        }

        public String toString() {
            return "pkg=" + this.mPackageName + ", uid=" + this.mUid + ", current=" + this.mCurrent + "mA, oldCurrent=" + this.mOldCurrent + "mA, bgCurrent=" + this.mBgCurrent + "mA, scanCurrent=" + this.mScanCurrent + "mA, activeCurrent=" + this.mActiveCurrent + "mA, bgSmallNetTrafficCount=" + this.mBgSmallNetTrafficCount + "\n";
        }
    }

    public static class WifiProcInfo {
        public int mActiveCurrent;
        public long mActiveTime;
        public int mCurrent;
        public int mOldCurrent;
        public int mPid;
        public String mProcessName;
        public long mRxBytes;
        public long mRxPackets;
        public long mScanCount;
        public int mScanCurrent;
        public long mScanTime;
        public long mTxBytes;
        public long mTxPackets;

        public WifiProcInfo(int pid, String processName) {
            this.mPid = pid;
            this.mProcessName = processName;
        }

        public String toString() {
            return "pid=" + this.mPid + ", processName=" + this.mProcessName + ", current=" + this.mCurrent + "mA, oldCurrent=" + this.mOldCurrent + "mA, scanCurrent=" + this.mScanCurrent + "mA, activeCurrent=" + this.mActiveCurrent + "mA, rxBytes=" + this.mRxBytes + ", rxPackets=" + this.mRxPackets + ", txBytes=" + this.mTxBytes + ", txPackets=" + this.mTxPackets + ", activeTime=" + (this.mActiveTime / 1000) + "s, scanTime=" + (this.mScanTime / 1000) + "s, scanCount=" + this.mScanCount + "\n";
        }
    }

    public WifiUidTeardownResult() {
        this.mWifiPackageEntrys = new HashMap();
    }

    public WifiProcInfo getPrcoInfo(String packageName, int uid, int pid, String procName) {
        if (this.mWifiPackageEntrys.containsKey(packageName) == false) goto L14;
        WifiPackageInfo packageInfo = this.mWifiPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoList.size()) goto L12;
        if (packageInfo.mProcInfoList.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoList.get(i);
    L12:
        WifiProcInfo procInfo = new WifiProcInfo(pid, procName);
        packageInfo.mProcInfoList.add(procInfo);
        return procInfo;
    L14:
        WifiProcInfo procInfo2 = new WifiProcInfo(pid, procName);
        WifiPackageInfo packageInfo2 = new WifiPackageInfo(packageName, uid);
        packageInfo2.mProcInfoList.add(procInfo2);
        this.mWifiPackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public WifiProcInfo getPrcoInfoBg(String packageName, int uid, int pid, String procName) {
        if (this.mWifiPackageEntrys.containsKey(packageName) == false) goto L14;
        WifiPackageInfo packageInfo = this.mWifiPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoListBg.size()) goto L12;
        if (packageInfo.mProcInfoListBg.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoListBg.get(i);
    L12:
        WifiProcInfo procInfoBg = new WifiProcInfo(pid, procName);
        packageInfo.mProcInfoListBg.add(procInfoBg);
        return procInfoBg;
    L14:
        WifiProcInfo procInfo = new WifiProcInfo(pid, procName);
        WifiPackageInfo packageInfo2 = new WifiPackageInfo(packageName, uid);
        packageInfo2.mProcInfoListBg.add(procInfo);
        this.mWifiPackageEntrys.put(packageName, packageInfo2);
        return procInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Wifi_All]");
        sb.append("wifi current=");
        sb.append(this.mCurrent);
        sb.append("mA, Old model current=");
        sb.append(this.mOldCurrent);
        sb.append("mA, bgCurrent=");
        sb.append(this.mBgCurrent);
        sb.append("mA, scanCurrent=");
        sb.append(this.mScanCurrent);
        sb.append("mA, activeCurrent=");
        sb.append(this.mActiveCurrent);
        sb.append("mA\n");
        Iterator<Map.Entry<String, WifiPackageInfo>> r1 = this.mWifiPackageEntrys.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L20;
        Map.Entry<String, WifiPackageInfo> entry = r1.next();
        WifiPackageInfo packageInfo = entry.getValue();
        if (packageInfo.mCurrent != 0) goto L10;
        if (packageInfo.mBgSmallNetTrafficCount < 3) goto L4;
    L10:
        int i = 0;
    L12:
        if (i >= packageInfo.mProcInfoList.size()) goto L14;
        sb.append("[Wifi]");
        sb.append("pkg=");
        sb.append(entry.getKey());
        sb.append(", uid=");
        sb.append(packageInfo.mUid);
        sb.append(", bgSmlNetCount=");
        sb.append(entry.getValue().mBgSmallNetTrafficCount);
        sb.append(", ");
        sb.append(packageInfo.mProcInfoList.get(i).toString());
        i = i + 1;
        goto L12
    L14:
        int i2 = 0;
    L16:
        if (i2 >= packageInfo.mProcInfoListBg.size()) goto L4;
        sb.append("[Wifi_BG]");
        sb.append("pkg = ");
        sb.append(entry.getKey());
        sb.append(", uid=");
        sb.append(packageInfo.mUid);
        sb.append(", ");
        sb.append(packageInfo.mProcInfoListBg.get(i2).toString());
        i2 = i2 + 1;
        goto L16
    L20:
        return sb.toString();
    }
}
