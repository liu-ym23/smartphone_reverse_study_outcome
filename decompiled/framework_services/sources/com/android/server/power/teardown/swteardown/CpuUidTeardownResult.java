package com.android.server.power.teardown.swteardown;

import android.os.SystemProperties;
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
public class CpuUidTeardownResult extends ComponentResult {
    public static final int CPU_CURRENT_TOO_LARGE = 0;
    private static final DateTimeFormatter mFormatter = null;
    public long mActiveTime;
    public long[] mClusterActiveTime;
    public int[] mClusterCpuLoad;
    public int[] mClusterCurrents;
    public List<CpuKTopInfo> mCpuKTopInfoList;
    public int mCpuLoad;
    public HashMap<String, CpuPackageInfo> mCpuPackageEntrys;
    public long[][] mFreqDuration;

    public static class CpuKTopInfo {
        public int mLoad;
        public int mPid;
        public String mProcessName;
        public String mThreadName;
        public long mTime;
        public int mTopNum;
        public int mUid;

        public CpuKTopInfo(long time, int topNum, int uid, int pid, String processName, String threadName, int load) {
            this.mTime = time;
            this.mTopNum = topNum;
            this.mUid = uid;
            this.mPid = pid;
            this.mProcessName = processName;
            this.mThreadName = threadName;
            this.mLoad = load;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("time: ");
            Instant instant = Instant.ofEpochMilli(this.mTime);
            LocalTime localTime = instant.atZone(ZoneId.systemDefault()).toLocalTime();
            sb.append(CpuUidTeardownResult.m7869$$Nest$sfgetmFormatter().format(localTime));
            sb.append(", top");
            sb.append(this.mTopNum);
            sb.append(", load =");
            sb.append(this.mLoad);
            sb.append(", uid =");
            sb.append(this.mUid);
            sb.append(", pid =");
            sb.append(this.mPid);
            sb.append(", processName =");
            sb.append(this.mProcessName);
            sb.append(", threadName =");
            sb.append(this.mThreadName);
            sb.append("\n");
            return sb.toString();
        }
    }

    public static class CpuPackageInfo {
        public long mActiveTime;
        public int mBgCurrent;
        public long[] mClusterActiveTime;
        public int[] mClusterCpuLoad;
        public int[] mClusterCurrents;
        public int mCpuLoad;
        public int mCurrent;
        public int mFgCurrent;
        public CpuProcInfo mFgProcInfo;
        public long[][] mFreqDuration;
        public CpuProcInfo mNoFocusFgProcInfo;
        public String mPackageName;
        public List<CpuProcInfo> mProcInfoList;
        public List<CpuProcInfo> mProcInfoListBg;
        public int mUid;

        public CpuPackageInfo(String packageName, int uid, int[][] freqTables) {
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mProcInfoList = new ArrayList();
            this.mProcInfoListBg = new ArrayList();
            this.mFgProcInfo = new CpuProcInfo(freqTables);
            this.mNoFocusFgProcInfo = new CpuProcInfo(freqTables);
            this.mClusterCurrents = new int[freqTables.length];
            this.mClusterCpuLoad = new int[freqTables.length];
            this.mClusterActiveTime = new long[freqTables.length];
            this.mFreqDuration = new long[freqTables.length][];
            int i = 0;
        L4:
            if (i >= freqTables.length) goto L7;
            this.mFreqDuration[i] = new long[freqTables[i].length];
            i = i + 1;
            goto L4
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("pkg=");
            sb.append(this.mPackageName);
            sb.append(", uid=");
            sb.append(this.mUid);
            sb.append(", current=");
            sb.append(this.mCurrent);
            sb.append("mA, bgCurrent=");
            sb.append(this.mBgCurrent);
            sb.append("mA, clusterCurrent=[");
            int i = 0;
        L4:
            if (i >= this.mClusterCurrents.length) goto L8;
            if (i == 0) goto L7;
            sb.append("mA, ");
        L7:
            sb.append(this.mClusterCurrents[i]);
            i = i + 1;
            goto L4
        L8:
            sb.append("mA], ");
            sb.append("cpuLoad=");
            sb.append(this.mCpuLoad);
            sb.append("%, cluster cpuLoad=[");
            int i2 = 0;
        L10:
            if (i2 >= this.mClusterCpuLoad.length) goto L14;
            if (i2 == 0) goto L13;
            sb.append("%, ");
        L13:
            sb.append(this.mClusterCpuLoad[i2]);
            i2 = i2 + 1;
            goto L10
        L14:
            sb.append("%]");
            sb.append(", activeTime=");
            sb.append(this.mActiveTime / 1000);
            sb.append("s, cluster activeTime=[");
            int i3 = 0;
        L16:
            if (i3 >= this.mClusterActiveTime.length) goto L20;
            if (i3 == 0) goto L19;
            sb.append("s, ");
        L19:
            sb.append(this.mClusterActiveTime[i3] / 1000);
            i3 = i3 + 1;
            goto L16
        L20:
            sb.append("s]");
            int i4 = 0;
        L22:
            if (i4 >= this.mFreqDuration.length) goto L35;
            if (this.mClusterActiveTime[i4] <= 1000) goto L33;
            sb.append(", cluster");
            sb.append(i4);
            sb.append(" freq=[");
            int j = 0;
        L28:
            if (j >= this.mFreqDuration[i4].length) goto L32;
            if (j == 0) goto L31;
            sb.append("%, ");
        L31:
            sb.append(String.format("%.2f", new Object[]{Double.valueOf((this.mFreqDuration[i4][j] * 100.0d) / this.mClusterActiveTime[i4])}));
            j = j + 1;
            goto L28
        L32:
            sb.append("%]");
        L33:
            i4 = i4 + 1;
            goto L22
        L35:
            return sb.toString();
        }
    }

    public static class CpuProcInfo {
        public long mActiveTime;
        public long[] mClusterActiveTime;
        public int[] mClusterCpuLoad;
        public int[] mClusterCurrents;
        public int mCpuLoad;
        public int mCurrent;
        public long[][] mFreqDuration;
        public int mPid;
        public String mProcessName;

        public CpuProcInfo(int pid, String processName, int[][] freqTables) {
            this.mClusterCurrents = new int[freqTables.length];
            this.mClusterCpuLoad = new int[freqTables.length];
            this.mClusterActiveTime = new long[freqTables.length];
            this.mFreqDuration = new long[freqTables.length][];
            int i = 0;
        L4:
            if (i >= freqTables.length) goto L6;
            this.mFreqDuration[i] = new long[freqTables[i].length];
            i = i + 1;
            goto L4
        L6:
            this.mPid = pid;
            this.mProcessName = processName;
        }

        public CpuProcInfo(int[][] freqTable) {
            this(-1, "Unknown", freqTable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("pid=");
            sb.append(this.mPid);
            sb.append(", processName=");
            sb.append(this.mProcessName);
            sb.append(", current=");
            sb.append(this.mCurrent);
            sb.append("mA, clusterCurrent=[");
            int i = 0;
        L4:
            if (i >= this.mClusterCurrents.length) goto L8;
            if (i == 0) goto L7;
            sb.append("mA, ");
        L7:
            sb.append(this.mClusterCurrents[i]);
            i = i + 1;
            goto L4
        L8:
            sb.append("mA], ");
            sb.append("cpuLoad=");
            sb.append(this.mCpuLoad);
            sb.append("%, cluster cpuLoad=[");
            int i2 = 0;
        L10:
            if (i2 >= this.mClusterCpuLoad.length) goto L14;
            if (i2 == 0) goto L13;
            sb.append("%, ");
        L13:
            sb.append(this.mClusterCpuLoad[i2]);
            i2 = i2 + 1;
            goto L10
        L14:
            sb.append("%]");
            sb.append(", activeTime=");
            sb.append(this.mActiveTime / 1000);
            sb.append("s, cluster activeTime=[");
            int i3 = 0;
        L16:
            if (i3 >= this.mClusterActiveTime.length) goto L20;
            if (i3 == 0) goto L19;
            sb.append("s, ");
        L19:
            sb.append(this.mClusterActiveTime[i3] / 1000);
            i3 = i3 + 1;
            goto L16
        L20:
            sb.append("s]");
            int i4 = 0;
        L22:
            if (i4 >= this.mFreqDuration.length) goto L34;
            if (this.mClusterActiveTime[i4] <= 1000) goto L33;
            sb.append(", cluster");
            sb.append(i4);
            sb.append(" freq=[");
            int j = 0;
        L28:
            if (j >= this.mFreqDuration[i4].length) goto L32;
            if (j == 0) goto L31;
            sb.append("%, ");
        L31:
            sb.append(String.format("%.2f", new Object[]{Double.valueOf((this.mFreqDuration[i4][j] * 100.0d) / this.mClusterActiveTime[i4])}));
            j = j + 1;
            goto L28
        L32:
            sb.append("%]");
        L33:
            i4 = i4 + 1;
            goto L22
        L34:
            sb.append("\n");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmFormatter, reason: not valid java name */
    static /* bridge */ /* synthetic */ DateTimeFormatter m7869$$Nest$sfgetmFormatter() {
        return mFormatter;
    }

    static {
        mFormatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault());
        CPU_CURRENT_TOO_LARGE = SystemProperties.getInt("persist.sys.teardown.cpu.percent", 5);
    }

    public CpuUidTeardownResult(int[][] freqTables) {
        this.mCpuPackageEntrys = new HashMap();
        this.mClusterCurrents = new int[freqTables.length];
        this.mClusterCpuLoad = new int[freqTables.length];
        this.mClusterActiveTime = new long[freqTables.length];
        this.mFreqDuration = new long[freqTables.length][];
        int i = 0;
    L4:
        if (i >= freqTables.length) goto L6;
        this.mFreqDuration[i] = new long[freqTables[i].length];
        i = i + 1;
        goto L4
    L6:
        this.mCpuKTopInfoList = new ArrayList();
    }

    public String toString() {
        if (this.mCpuPackageEntrys != null) goto L6;
        return "null";
    L6:
        StringBuilder sb = new StringBuilder();
        sb.append("[CPU_All] cpu current=");
        sb.append(this.mCurrent);
        sb.append("mA, clusterCurrent=[");
        int i = 0;
    L8:
        if (i >= this.mClusterCurrents.length) goto L12;
        if (i == 0) goto L11;
        sb.append("mA, ");
    L11:
        sb.append(this.mClusterCurrents[i]);
        i = i + 1;
        goto L8
    L12:
        sb.append("mA], ");
        sb.append("cpuLoad=");
        sb.append(this.mCpuLoad);
        sb.append("%, cluster cpuLoad=[");
        int i2 = 0;
    L14:
        if (i2 >= this.mClusterCpuLoad.length) goto L18;
        if (i2 == 0) goto L17;
        sb.append("%, ");
    L17:
        sb.append(this.mClusterCpuLoad[i2]);
        i2 = i2 + 1;
        goto L14
    L18:
        sb.append("%]");
        sb.append(", cpu activeTime=");
        sb.append(this.mActiveTime / 1000);
        sb.append("s, cluster activeTime=[");
        int i3 = 0;
    L20:
        if (i3 >= this.mClusterActiveTime.length) goto L24;
        if (i3 == 0) goto L23;
        sb.append("s, ");
    L23:
        sb.append(this.mClusterActiveTime[i3] / 1000);
        i3 = i3 + 1;
        goto L20
    L24:
        sb.append("s]");
        int i4 = 0;
    L26:
        if (i4 >= this.mFreqDuration.length) goto L38;
        if (this.mClusterActiveTime[i4] <= 1000) goto L37;
        sb.append(", cluster");
        sb.append(i4);
        sb.append(" freq=[");
        int j = 0;
    L32:
        if (j >= this.mFreqDuration[i4].length) goto L36;
        if (j == 0) goto L35;
        sb.append("%, ");
    L35:
        sb.append(String.format("%.2f", new Object[]{Double.valueOf((this.mFreqDuration[i4][j] * 100.0d) / this.mClusterActiveTime[i4])}));
        j = j + 1;
        goto L32
    L36:
        sb.append("%]");
    L37:
        i4 = i4 + 1;
        goto L26
    L38:
        sb.append("\n");
        Iterator<Map.Entry<String, CpuPackageInfo>> r1 = this.mCpuPackageEntrys.entrySet().iterator();
    L40:
        if (r1.hasNext() == false) goto L54;
        Map.Entry<String, CpuPackageInfo> entry = r1.next();
        CpuPackageInfo packageInfo = entry.getValue();
        int i5 = 0;
    L43:
        if (i5 >= packageInfo.mProcInfoList.size()) goto L40;
        if (((((double) packageInfo.mCurrent) * 100.0d) / ((double) this.mCurrent)) < CPU_CURRENT_TOO_LARGE) goto L52;
        if (packageInfo.mProcInfoList.get(i5).mPid == (-1)) goto L50;
        sb.append("[CPU_PID] pkg=");
    L51:
        sb.append(entry.getKey().toString());
        sb.append(", uid=");
        sb.append(packageInfo.mUid);
        sb.append(", ");
        sb.append(packageInfo.mProcInfoList.get(i5).toString());
        goto L52
    L50:
        sb.append("[CPU_UID] pkg=");
    L52:
        i5 = i5 + 1;
        goto L43
    L54:
        Iterator<Map.Entry<String, CpuPackageInfo>> r2 = this.mCpuPackageEntrys.entrySet().iterator();
    L56:
        if (r2.hasNext() == false) goto L61;
        Map.Entry<String, CpuPackageInfo> entry2 = r2.next();
        CpuPackageInfo packageInfo2 = entry2.getValue();
        if (packageInfo2.mFgProcInfo.mCurrent <= 0) goto L56;
        sb.append("[CPU_FG_FOCUS] pkg=");
        sb.append(entry2.getKey().toString());
        sb.append(", uid=");
        sb.append(packageInfo2.mUid);
        sb.append(", ");
        sb.append(packageInfo2.mFgProcInfo.toString());
        goto L56
    L61:
        Iterator<Map.Entry<String, CpuPackageInfo>> r3 = this.mCpuPackageEntrys.entrySet().iterator();
    L63:
        if (r3.hasNext() == false) goto L69;
        Map.Entry<String, CpuPackageInfo> entry3 = r3.next();
        CpuPackageInfo packageInfo3 = entry3.getValue();
        if (packageInfo3.mNoFocusFgProcInfo.mCurrent <= 0) goto L63;
        sb.append("[CPU_FG_NO_FOCUS] pkg=");
        sb.append(entry3.getKey().toString());
        sb.append(", uid=");
        sb.append(packageInfo3.mUid);
        sb.append(", ");
        sb.append(packageInfo3.mNoFocusFgProcInfo.toString());
        goto L63
    L69:
        if (this.mCpuKTopInfoList == null) goto L77;
        if (this.mCpuKTopInfoList.size() <= 0) goto L77;
        Iterator<CpuKTopInfo> r4 = this.mCpuKTopInfoList.iterator();
    L74:
        if (r4.hasNext() == false) goto L77;
        CpuKTopInfo info = r4.next();
        sb.append("[CPU_KTop] ");
        sb.append(info.toString());
    L77:
        return sb.toString();
    }
}
