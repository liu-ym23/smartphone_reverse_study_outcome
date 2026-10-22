package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ModemUidTeardownResult extends ComponentResult {
    public int mBgCurrent;
    public HashMap<String, ModemPackageInfo> mModemPackageEntrys;

    public static class ModemPackageInfo {
        public int mBgCurrent;
        public int mBgSmallNetTrafficCount;
        public int mCurrent;
        public String mPackageName;
        public List<ModemProcInfo> mProcInfoList;
        public List<ModemProcInfo> mProcInfoListBg;
        public int mUid;

        public ModemPackageInfo(String packageName, int uid) {
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mProcInfoList = new ArrayList();
            this.mProcInfoListBg = new ArrayList();
        }

        public String toString() {
            return "pkg = " + this.mPackageName + ", uid = " + this.mUid + ", current = " + this.mCurrent + "mA, bgCurrent = " + this.mBgCurrent + "mA, bgSmallNetTrafficCount=" + this.mBgSmallNetTrafficCount + "\n";
        }
    }

    public static class ModemProcInfo {
        public long mActiveTime;
        public int mCurrent;
        public int mPid;
        public String mProcessName;
        public long mRxBytes;
        public long mRxPackets;
        public long mTxBytes;
        public long mTxPackets;

        public ModemProcInfo(int pid, String processName) {
            this.mPid = pid;
            this.mProcessName = processName;
        }

        public String toString() {
            return "pid = " + this.mPid + ", processName = " + this.mProcessName + ", current = " + this.mCurrent + "mA, rxBytes = " + this.mRxBytes + ", rxPackets = " + this.mRxPackets + ", txBytes = " + this.mTxBytes + ", txPackets = " + this.mTxPackets + ", activeTime = " + (this.mActiveTime / 1000) + "s\n";
        }
    }

    public ModemUidTeardownResult() {
        this.mModemPackageEntrys = new HashMap();
    }

    public ModemProcInfo getPrcoInfo(String packageName, int uid, int pid, String processName) {
        if (this.mModemPackageEntrys.containsKey(packageName) == false) goto L14;
        ModemPackageInfo packageInfo = this.mModemPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoList.size()) goto L12;
        if (packageInfo.mProcInfoList.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoList.get(i);
    L12:
        ModemProcInfo procInfo = new ModemProcInfo(pid, processName);
        packageInfo.mProcInfoList.add(procInfo);
        return procInfo;
    L14:
        ModemProcInfo procInfo2 = new ModemProcInfo(pid, processName);
        ModemPackageInfo packageInfo2 = new ModemPackageInfo(packageName, uid);
        packageInfo2.mProcInfoList.add(procInfo2);
        this.mModemPackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public ModemProcInfo getPrcoInfoBg(String packageName, int uid, int pid, String processName) {
        if (this.mModemPackageEntrys.containsKey(packageName) == false) goto L14;
        ModemPackageInfo packageInfo = this.mModemPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoListBg.size()) goto L12;
        if (packageInfo.mProcInfoListBg.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoListBg.get(i);
    L12:
        ModemProcInfo procInfoBg = new ModemProcInfo(pid, processName);
        packageInfo.mProcInfoListBg.add(procInfoBg);
        return procInfoBg;
    L14:
        ModemProcInfo procInfo = new ModemProcInfo(pid, processName);
        ModemPackageInfo packageInfo2 = new ModemPackageInfo(packageName, uid);
        packageInfo2.mProcInfoListBg.add(procInfo);
        this.mModemPackageEntrys.put(packageName, packageInfo2);
        return procInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Modem_All] ");
        sb.append("Modem current = ");
        sb.append(this.mCurrent);
        sb.append("mA, bgCurrent = ");
        sb.append(this.mBgCurrent);
        sb.append("mA\n");
        Iterator<Map.Entry<String, ModemPackageInfo>> r1 = this.mModemPackageEntrys.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L20;
        Map.Entry<String, ModemPackageInfo> entry = r1.next();
        ModemPackageInfo packageInfo = entry.getValue();
        if (packageInfo.mCurrent != 0) goto L10;
        if (packageInfo.mBgSmallNetTrafficCount < 3) goto L4;
    L10:
        int i = 0;
    L12:
        if (i >= packageInfo.mProcInfoList.size()) goto L14;
        sb.append("[Modem]");
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
        sb.append("[Modem_BG]");
        sb.append("pkg=");
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
