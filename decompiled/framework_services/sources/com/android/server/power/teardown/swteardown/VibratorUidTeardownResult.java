package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class VibratorUidTeardownResult extends ComponentResult {
    public long mBgCurrent;
    public int mCount;
    public long mDuration;
    public HashMap<String, VibratorPackageInfo> mVibratorPackageEntrys;

    public static class VibratorPackageInfo {
        public int mBgCurrent;
        public int mCount;
        public int mCurrent;
        public long mDuration;
        public String mPackageName;
        public List<VibratorProcInfo> mProcInfoList;
        public List<VibratorProcInfo> mProcInfoListBg;
        public int mUid;

        public VibratorPackageInfo(String packageName, int uid) {
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mProcInfoList = new ArrayList();
            this.mProcInfoListBg = new ArrayList();
        }

        public String toString() {
            return "pkg=" + this.mPackageName + ", uid=" + this.mUid + ", current=" + this.mCurrent + "mA, duration=" + (this.mDuration / 1000) + "s, count=" + this.mCount;
        }
    }

    public static class VibratorProcInfo {
        public int mCount;
        public int mCurrent;
        public long mDuration;
        public int mPid;
        public String mProcessName;

        public VibratorProcInfo(int current, int pid, String processName, long duration, int count) {
            this.mCurrent = current;
            this.mPid = pid;
            this.mProcessName = processName;
            this.mDuration = duration;
            this.mCount = count;
        }

        public VibratorProcInfo() {
            this.mProcessName = "Unknown";
        }

        public String toString() {
            return "pid=" + this.mPid + ", processName=" + this.mProcessName + ", current=" + this.mCurrent + "mA, activeTime=" + (this.mDuration / 1000) + "s, count=" + this.mCount;
        }
    }

    public VibratorUidTeardownResult() {
        this.mVibratorPackageEntrys = new HashMap();
    }

    public VibratorProcInfo getPrcoInfo(String packageName, int uid, int pid) {
        if (this.mVibratorPackageEntrys.containsKey(packageName) == false) goto L14;
        VibratorPackageInfo packageInfo = this.mVibratorPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoList.size()) goto L12;
        if (packageInfo.mProcInfoList.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoList.get(i);
    L12:
        VibratorProcInfo procInfo = new VibratorProcInfo();
        packageInfo.mProcInfoList.add(procInfo);
        return procInfo;
    L14:
        VibratorProcInfo procInfo2 = new VibratorProcInfo();
        VibratorPackageInfo packageInfo2 = new VibratorPackageInfo(packageName, uid);
        packageInfo2.mProcInfoList.add(procInfo2);
        this.mVibratorPackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public VibratorProcInfo getBgPrcoInfo(String packageName, int uid, int pid) {
        if (this.mVibratorPackageEntrys.containsKey(packageName) == false) goto L14;
        VibratorPackageInfo packageInfo = this.mVibratorPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoListBg.size()) goto L12;
        if (packageInfo.mProcInfoListBg.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoListBg.get(i);
    L12:
        VibratorProcInfo procInfo = new VibratorProcInfo();
        packageInfo.mProcInfoListBg.add(procInfo);
        return procInfo;
    L14:
        VibratorProcInfo procInfo2 = new VibratorProcInfo();
        VibratorPackageInfo packageInfo2 = new VibratorPackageInfo(packageName, uid);
        packageInfo2.mProcInfoListBg.add(procInfo2);
        this.mVibratorPackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Vibrator_All] ");
        sb.append("vibrator current=");
        sb.append(this.mCurrent);
        sb.append("mA, activeTime=");
        sb.append(this.mDuration / 1000);
        sb.append("s, count=");
        sb.append(this.mCount);
        sb.append("\n");
        Iterator<Map.Entry<String, VibratorPackageInfo>> r2 = this.mVibratorPackageEntrys.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        VibratorPackageInfo packageInfo = r2.next().getValue();
        sb.append("[Vibrator]");
        sb.append(packageInfo.toString());
        sb.append("\n");
        goto L4
    L6:
        Iterator<Map.Entry<String, VibratorPackageInfo>> r3 = this.mVibratorPackageEntrys.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        Map.Entry<String, VibratorPackageInfo> entry = r3.next();
        VibratorPackageInfo packageInfo2 = entry.getValue();
        int i = 0;
    L11:
        if (i >= packageInfo2.mProcInfoListBg.size()) goto L8;
        if (packageInfo2.mProcInfoListBg.get(i).mCurrent <= 0) goto L16;
        sb.append("[Vibrator_BG]");
        sb.append("pkg = ");
        sb.append(entry.getKey());
        sb.append(", uid=");
        sb.append(packageInfo2.mUid);
        sb.append(", ");
        sb.append(packageInfo2.mProcInfoListBg.get(i).toString());
        sb.append("\n");
    L16:
        i = i + 1;
        goto L11
    L19:
        return sb.toString();
    }
}
