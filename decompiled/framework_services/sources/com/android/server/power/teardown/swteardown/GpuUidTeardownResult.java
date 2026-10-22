package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class GpuUidTeardownResult extends ComponentResult {
    private static final DateTimeFormatter mFormatter = null;
    public int mBgCurrent;
    public long mDuration;
    public List<GpuGTopInfo> mGTopInfoList;
    public HashMap<String, GpuPackageInfo> mGpuPackageEntrys;

    public static class GpuGTopInfo {
        public String mComm;
        public int mLoad;
        public int mTGid;
        public String mThreadName;
        public int mTid;
        public long mTime;

        public GpuGTopInfo(long time, int tGid, int tid, String threadName, String comm, int load) {
            this.mTime = time;
            this.mTGid = tGid;
            this.mTid = tid;
            this.mThreadName = threadName;
            this.mComm = comm;
            this.mLoad = load;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("time:");
            Instant instant = Instant.ofEpochMilli(this.mTime);
            LocalTime localTime = instant.atZone(ZoneId.systemDefault()).toLocalTime();
            sb.append(GpuUidTeardownResult.m7871$$Nest$sfgetmFormatter().format(localTime));
            sb.append(", load =");
            sb.append(this.mLoad);
            sb.append(", tgid =");
            sb.append(this.mTGid);
            sb.append(", tid =");
            sb.append(this.mTid);
            sb.append(", threadName =");
            sb.append(this.mThreadName);
            sb.append(", comm =");
            sb.append(this.mComm);
            return sb.toString();
        }
    }

    public static class GpuPackageInfo {
        public int mBgCurrent;
        public int mCurrent;
        public long mDuration;
        public String mPackageName;
        public List<GpuProcInfo> mProcInfoList;
        public List<GpuProcInfo> mProcInfoListBg;
        public List<GpuProcInfo> mProcInfoListFocusFg;
        public List<GpuProcInfo> mProcInfoListNoFocusFg;
        public int mUid;

        public GpuPackageInfo(String packageName, int uid) {
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mProcInfoList = new ArrayList();
            this.mProcInfoListBg = new ArrayList();
            this.mProcInfoListFocusFg = new ArrayList();
            this.mProcInfoListNoFocusFg = new ArrayList();
        }

        public String toString() {
            return "pkg=" + this.mPackageName + ", uid=" + this.mUid + ", current=" + this.mCurrent + "mA, bgCurrent=" + this.mBgCurrent + "mA, duration=" + (this.mDuration / 1000);
        }
    }

    public static class GpuProcInfo {
        public int mCurrent;
        public long mDuration;
        public int mPid;
        public String mProcessName;

        public GpuProcInfo(int pid, String processName) {
            this.mPid = pid;
            this.mProcessName = processName;
        }

        public GpuProcInfo() {
            this(0, "Unknown");
        }

        public String toString() {
            return "pid=" + this.mPid + ", processName=" + this.mProcessName + ", current=" + this.mCurrent + "mA, activeTime=" + this.mDuration + "ms";
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmFormatter, reason: not valid java name */
    static /* bridge */ /* synthetic */ DateTimeFormatter m7871$$Nest$sfgetmFormatter() {
        return mFormatter;
    }

    static {
        mFormatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault());
    }

    public GpuUidTeardownResult() {
        this.mGpuPackageEntrys = new HashMap();
        this.mGTopInfoList = new ArrayList();
    }

    public GpuProcInfo getBgPrcoInfo(String packageName, int uid, int pid) {
        if (this.mGpuPackageEntrys.containsKey(packageName) == false) goto L14;
        GpuPackageInfo packageInfo = this.mGpuPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoListBg.size()) goto L12;
        if (packageInfo.mProcInfoListBg.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoListBg.get(i);
    L12:
        GpuProcInfo procInfo = new GpuProcInfo();
        packageInfo.mProcInfoListBg.add(procInfo);
        return procInfo;
    L14:
        GpuProcInfo procInfo2 = new GpuProcInfo();
        GpuPackageInfo packageInfo2 = new GpuPackageInfo(packageName, uid);
        packageInfo2.mProcInfoListBg.add(procInfo2);
        this.mGpuPackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public GpuProcInfo getFocusFgPrcoInfo(String packageName, int uid, int pid) {
        if (this.mGpuPackageEntrys.containsKey(packageName) == false) goto L14;
        GpuPackageInfo packageInfo = this.mGpuPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoListFocusFg.size()) goto L12;
        if (packageInfo.mProcInfoListFocusFg.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoListFocusFg.get(i);
    L12:
        GpuProcInfo procInfo = new GpuProcInfo();
        packageInfo.mProcInfoListFocusFg.add(procInfo);
        return procInfo;
    L14:
        GpuProcInfo procInfo2 = new GpuProcInfo();
        GpuPackageInfo packageInfo2 = new GpuPackageInfo(packageName, uid);
        packageInfo2.mProcInfoListFocusFg.add(procInfo2);
        this.mGpuPackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public GpuProcInfo getNoFocusFgPrcoInfo(String packageName, int uid, int pid) {
        if (this.mGpuPackageEntrys.containsKey(packageName) == false) goto L14;
        GpuPackageInfo packageInfo = this.mGpuPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoListNoFocusFg.size()) goto L12;
        if (packageInfo.mProcInfoListNoFocusFg.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoListNoFocusFg.get(i);
    L12:
        GpuProcInfo procInfo = new GpuProcInfo();
        packageInfo.mProcInfoListNoFocusFg.add(procInfo);
        return procInfo;
    L14:
        GpuProcInfo procInfo2 = new GpuProcInfo();
        GpuPackageInfo packageInfo2 = new GpuPackageInfo(packageName, uid);
        packageInfo2.mProcInfoListNoFocusFg.add(procInfo2);
        this.mGpuPackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Gpu_All] ");
        sb.append("Gpu current=");
        sb.append(this.mCurrent);
        sb.append("mA, bgCurrent=");
        sb.append(this.mBgCurrent);
        sb.append("mA, activeTime=");
        sb.append(this.mDuration);
        sb.append("ms\n");
        Iterator<Map.Entry<String, GpuPackageInfo>> r1 = this.mGpuPackageEntrys.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, GpuPackageInfo> entry = r1.next();
        GpuPackageInfo packageInfo = entry.getValue();
        int i = 0;
    L7:
        if (i >= packageInfo.mProcInfoList.size()) goto L4;
        if (packageInfo.mProcInfoList.get(i).mCurrent <= 0) goto L12;
        sb.append("[Gpu]");
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
        Iterator<Map.Entry<String, GpuPackageInfo>> r2 = this.mGpuPackageEntrys.entrySet().iterator();
    L16:
        if (r2.hasNext() == false) goto L26;
        Map.Entry<String, GpuPackageInfo> entry2 = r2.next();
        GpuPackageInfo packageInfo2 = entry2.getValue();
        int i2 = 0;
    L19:
        if (i2 >= packageInfo2.mProcInfoListBg.size()) goto L16;
        if (packageInfo2.mProcInfoListBg.get(i2).mCurrent <= 0) goto L24;
        sb.append("[Gpu_BG]");
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
    L26:
        Iterator<Map.Entry<String, GpuPackageInfo>> r3 = this.mGpuPackageEntrys.entrySet().iterator();
    L28:
        if (r3.hasNext() == false) goto L38;
        Map.Entry<String, GpuPackageInfo> entry3 = r3.next();
        GpuPackageInfo packageInfo3 = entry3.getValue();
        int i3 = 0;
    L31:
        if (i3 >= packageInfo3.mProcInfoListFocusFg.size()) goto L28;
        if (packageInfo3.mProcInfoListFocusFg.get(i3).mCurrent <= 0) goto L36;
        sb.append("[Gpu_FOCUS_FG]");
        sb.append("pkg=");
        sb.append(entry3.getKey());
        sb.append(", uid=");
        sb.append(packageInfo3.mUid);
        sb.append(", ");
        sb.append(packageInfo3.mProcInfoListFocusFg.get(i3).toString());
        sb.append("\n");
    L36:
        i3 = i3 + 1;
        goto L31
    L38:
        Iterator<Map.Entry<String, GpuPackageInfo>> r4 = this.mGpuPackageEntrys.entrySet().iterator();
    L40:
        if (r4.hasNext() == false) goto L51;
        Map.Entry<String, GpuPackageInfo> entry4 = r4.next();
        GpuPackageInfo packageInfo4 = entry4.getValue();
        int i4 = 0;
    L43:
        if (i4 >= packageInfo4.mProcInfoListNoFocusFg.size()) goto L40;
        if (packageInfo4.mProcInfoListNoFocusFg.get(i4).mCurrent <= 0) goto L48;
        sb.append("[Gpu_NO_FOCUS_FG]");
        sb.append("pkg=");
        sb.append(entry4.getKey());
        sb.append(", uid=");
        sb.append(packageInfo4.mUid);
        sb.append(", ");
        sb.append(packageInfo4.mProcInfoListNoFocusFg.get(i4).toString());
        sb.append("\n");
    L48:
        i4 = i4 + 1;
        goto L43
    L51:
        if (this.mGTopInfoList == null) goto L59;
        if (this.mGTopInfoList.size() <= 0) goto L59;
        int i5 = 0;
    L56:
        if (i5 >= this.mGTopInfoList.size()) goto L59;
        sb.append("[Gpu_GTop] ");
        sb.append(this.mGTopInfoList.get(i5).toString());
        sb.append("\n");
        i5 = i5 + 1;
    L59:
        return sb.toString();
    }
}
