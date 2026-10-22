package com.android.server.power.stats;

import android.hardware.tv.mediaquality.ParameterName;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.os.SystemClock;
import android.system.suspend.internal.ISuspendControlServiceInternal;
import android.system.suspend.internal.WakeLockInfo;
import android.util.Slog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class KernelWakelockReader {
    private static final int[] PROC_WAKELOCKS_FORMAT = null;
    private static final String TAG = "KernelWakelockReader";
    private static final int[] WAKEUP_SOURCES_FORMAT = null;
    private static int sKernelWakelockUpdateVersion = 0;
    private static final String sSysClassWakeupDir = "/sys/class/wakeup";
    private static final String sWakelockFile = "/proc/wakelocks";
    private static final String sWakeupSourceFile = "/d/wakeup_sources";
    private byte[] mKernelWakelockBuffer;
    private final long[] mProcWakelocksData;
    private final String[] mProcWakelocksName;
    private ISuspendControlServiceInternal mSuspendControlService;

    public KernelWakelockReader() {
        this.mProcWakelocksName = new String[3];
        this.mProcWakelocksData = new long[4];
        this.mSuspendControlService = null;
        this.mKernelWakelockBuffer = new byte[32768];
    }

    static {
        sKernelWakelockUpdateVersion = 0;
        PROC_WAKELOCKS_FORMAT = new int[]{5129, 8201, 9, 8201, 9, 8201};
        WAKEUP_SOURCES_FORMAT = new int[]{4105, 8457, 265, 265, 265, 8457, 8457};
    }

    public KernelWakelockStats readKernelWakelockStats(KernelWakelockStats staleStats) {
        boolean useSystemSuspend = new File(sSysClassWakeupDir).exists();
        if (useSystemSuspend == true) goto L5;
        Arrays.fill(this.mKernelWakelockBuffer, (byte) 0);
        int len = 0;
        long startTime = SystemClock.uptimeMillis();
        int oldMask = StrictMode.allowThreadDiskReadsMask();
        FileInputStream is = new FileInputStream(sWakelockFile);     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L25
        boolean wakeup_sources = false;
    L28:
        int cnt = is.read(this.mKernelWakelockBuffer, len, this.mKernelWakelockBuffer.length - len);     // Catch: Throwable -> L21 IOException -> L23
        if (cnt <= 0) goto L31;
        len = len + cnt;     // Catch: Throwable -> L21 IOException -> L23
        goto L28
    L31:
        is.close();     // Catch: Throwable -> L21 IOException -> L23
        StrictMode.setThreadPolicyMask(oldMask);
        long readTime = SystemClock.uptimeMillis() - startTime;
        if (readTime <= 100) goto L35;
        Slog.w(TAG, "Reading wakelock stats took " + readTime + "ms");
    L35:
        if (len > 0) goto L37;
    L45:
        int i = len;
    L47:
        monitor-enter(KernelWakelockReader.class);
        updateVersion(staleStats);     // Catch: Throwable -> L51
        if (getWakelockStatsFromSystemSuspend(staleStats) != null) goto L53;
        Slog.w(TAG, "Failed to get Native wakelock stats from SystemSuspend");     // Catch: Throwable -> L51
    L53:
        parseProcWakelocks(this.mKernelWakelockBuffer, i, wakeup_sources, staleStats);     // Catch: Throwable -> L51
        KernelWakelockStats r2 = removeOldStats(staleStats);     // Catch: Throwable -> L51
        monitor-exit(KernelWakelockReader.class);     // Catch: Throwable -> L51
        return r2;
    L51:
        th = move-exception;
        throw th;
    L37:
        if (len < this.mKernelWakelockBuffer.length) goto L39;
        Slog.wtf(TAG, "Kernel wake locks exceeded mKernelWakelockBuffer size " + this.mKernelWakelockBuffer.length);
    L39:
        i = 0;
    L40:
        if (i >= len) goto L45;
        if (this.mKernelWakelockBuffer[i] == 0) goto L47;
        i = i + 1;
    L23:
        e = move-exception;
        Slog.wtf(TAG, "failed to read kernel wakelocks", e);     // Catch: Throwable -> L21
        StrictMode.setThreadPolicyMask(oldMask);
        return null;
    L73:
        FileInputStream is2 = new FileInputStream(sWakeupSourceFile);     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L58
        is = is2;
        wakeup_sources = true;
    L59:
        Slog.wtf(TAG, "neither /proc/wakelocks nor /d/wakeup_sources exists");     // Catch: Throwable -> L21 IOException -> L23
        StrictMode.setThreadPolicyMask(oldMask);
        return null;
    L21:
        th = move-exception;
        StrictMode.setThreadPolicyMask(oldMask);
        throw th;
    L5:
        monitor-enter(KernelWakelockReader.class);
        updateVersion(staleStats);     // Catch: Throwable -> L11
        if (getWakelockStatsFromSystemSuspend(staleStats) != null) goto L13;
        Slog.w(TAG, "Failed to get wakelock stats from SystemSuspend");     // Catch: Throwable -> L11
        monitor-exit(KernelWakelockReader.class);     // Catch: Throwable -> L11
        return null;
    L13:
        KernelWakelockStats r1 = removeOldStats(staleStats);     // Catch: Throwable -> L11
        monitor-exit(KernelWakelockReader.class);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private ISuspendControlServiceInternal waitForSuspendControlService() throws ServiceManager.ServiceNotFoundException {
        int i = 0;
    L4:
        if (i >= 5) goto L11;
        this.mSuspendControlService = ISuspendControlServiceInternal.Stub.asInterface(ServiceManager.getService("suspend_control_internal"));
        if (this.mSuspendControlService != null) goto L8;
        i = i + 1;
        goto L4
    L8:
        return this.mSuspendControlService;
    L11:
        throw new ServiceManager.ServiceNotFoundException("suspend_control_internal");
    }

    private KernelWakelockStats getWakelockStatsFromSystemSuspend(KernelWakelockStats staleStats) {
        if (this.mSuspendControlService == null) goto L16;
    L14:
        WakeLockInfo[] wlStats = this.mSuspendControlService.getWakeLockStats();     // Catch: RemoteException -> L11
        updateWakelockStats(wlStats, staleStats);     // Catch: RemoteException -> L11
        return staleStats;
    L11:
        e = move-exception;
        Slog.wtf(TAG, "Failed to obtain wakelock stats from ISuspendControlService", e);
        return null;
    L16:
        this.mSuspendControlService = waitForSuspendControlService();     // Catch: ServiceManager.ServiceNotFoundException -> L6
    L6:
        e = move-exception;
        Slog.wtf(TAG, "Required service suspend_control not available", e);
        return null;
    }

    public KernelWakelockStats updateWakelockStats(WakeLockInfo[] wlStats, KernelWakelockStats staleStats) {
        int r2 = wlStats.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L15;
        WakeLockInfo info = wlStats[r3];
        long r6 = 0;
        if (staleStats.containsKey(info.name) == true) goto L10;
        String r5 = info.name;
        int r11 = (int) info.activeCount;
        long r12 = info.totalTime * 1000;
        if (info.isActive == false) goto L9;
        r6 = info.activeTime * 1000;
    L9:
        staleStats.put(r5, new KernelWakelockStats.Entry(r11, r12, r6, sKernelWakelockUpdateVersion));
    L14:
        r3 = r3 + 1;
        goto L3
    L10:
        KernelWakelockStats.Entry kwlStats = staleStats.get(info.name);
        kwlStats.count = (int) info.activeCount;
        kwlStats.totalTimeUs = info.totalTime * 1000;
        if (info.isActive == false) goto L13;
        r6 = info.activeTime * 1000;
    L13:
        kwlStats.activeTimeUs = r6;
        kwlStats.version = sKernelWakelockUpdateVersion;
        goto L14
    L15:
        return staleStats;
    }

    public KernelWakelockStats parseProcWakelocks(byte[] wlBuffer, int len, boolean wakeup_sources, KernelWakelockStats staleStats) {
        int i = 0;
    L3:
        byte r12 = 10;
        if (i >= len) goto L10;
        if (wlBuffer[i] == 10) goto L10;
        if (wlBuffer[i] == 0) goto L10;
        i = i + 1;
    L10:
        int startIndex = i + 1;
        int endIndex = startIndex;
        monitor-enter(this);
        int startIndex2 = startIndex;
    L13:
        if (endIndex >= len) goto L106;
        int endIndex2 = startIndex2;
    L15:
        if (endIndex2 >= len) goto L24;
        if (wlBuffer[endIndex2] == r12) goto L24;
        if (wlBuffer[endIndex2] == 0) goto L24;
        endIndex2 = endIndex2 + 1;
    L21:
        th = th;
    L98:
        monitor-exit(this);     // Catch: Throwable -> L47
    L47:
        th = th;
        goto L98
    L99:
        throw th;
    L24:
        if (endIndex2 > (len - 1)) goto L25;
        String[] nameStringArray = this.mProcWakelocksName;     // Catch: Throwable -> L91
        long[] wlData = this.mProcWakelocksData;     // Catch: Throwable -> L91
        int j = startIndex2;
    L28:
        if (j >= endIndex2) goto L34;
        if ((wlBuffer[j] & 128) == 0) goto L32;
        wlBuffer[j] = ParameterName.COLOR_TUNER_HUE_YELLOW;     // Catch: Throwable -> L21
    L32:
        j = j + 1;     // Catch: Throwable -> L21
        goto L28
    L34:
        if (wakeup_sources == true) goto L36;
        int[] r5 = PROC_WAKELOCKS_FORMAT;     // Catch: Throwable -> L91
    L102:
        boolean parsed = Process.parseProcLine(wlBuffer, startIndex2, endIndex2, r5, nameStringArray, wlData, null);     // Catch: Throwable -> L88
        int startIndex3 = startIndex2;
        String name = nameStringArray[0].trim();     // Catch: Throwable -> L67
        int count = (int) wlData[1];
        if (wakeup_sources == true) goto L110;
        long activeTime = (wlData[2] + 500) / 1000;     // Catch: Throwable -> L67
        long activeTime2 = activeTime;
        long activeTime3 = (wlData[3] + 500) / 1000;     // Catch: Throwable -> L67
    L50:
        if (parsed == true) goto L52;
    L69:
        int endIndex3 = endIndex2;
        if (parsed == true) goto L87;
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L63 Exception -> L81
        r7.append("Failed to parse proc line: ");     // Catch: Throwable -> L63 Exception -> L79
        r7.append(new String(wlBuffer, startIndex3, endIndex3 - startIndex3));     // Catch: Throwable -> L63 Exception -> L77
        Slog.wtf(TAG, r7.toString());     // Catch: Throwable -> L63 Exception -> L77
    L84:
        Slog.wtf(TAG, "Failed to parse proc line!");     // Catch: Throwable -> L63
    L87:
        endIndex = endIndex3;
        r12 = 10;
        startIndex2 = endIndex3 + 1;
        goto L13
    L52:
        if (name.length() <= 0) goto L69;
        if (staleStats.containsKey(name) == true) goto L57;
        staleStats.put(name, new KernelWakelockStats.Entry(count, activeTime3, activeTime2, sKernelWakelockUpdateVersion));     // Catch: Throwable -> L47
        endIndex3 = endIndex2;
        goto L87
    L57:
        long totalTime = activeTime3;
        long activeTime4 = activeTime2;
        KernelWakelockStats.Entry kwlStats = (KernelWakelockStats.Entry) staleStats.get(name);     // Catch: Throwable -> L67
        int r2 = kwlStats.version;     // Catch: Throwable -> L67
        endIndex3 = endIndex2;
        int endIndex4 = sKernelWakelockUpdateVersion;     // Catch: Throwable -> L63
        if (r2 != endIndex4) goto L65;
        kwlStats.count += count;     // Catch: Throwable -> L63
        kwlStats.totalTimeUs += totalTime;     // Catch: Throwable -> L63
        kwlStats.activeTimeUs = activeTime4;     // Catch: Throwable -> L63
        goto L87
    L65:
        kwlStats.count = count;     // Catch: Throwable -> L63
        kwlStats.totalTimeUs = totalTime;     // Catch: Throwable -> L63
        kwlStats.activeTimeUs = activeTime4;     // Catch: Throwable -> L63
        kwlStats.version = sKernelWakelockUpdateVersion;     // Catch: Throwable -> L63
    L63:
        th = th;
        goto L98
    L110:
        long activeTime5 = wlData[2] * 1000;     // Catch: Throwable -> L47
        activeTime2 = activeTime5;
        activeTime3 = wlData[3] * 1000;
        goto L50
    L120:
        th = th;
    L67:
        th = th;
    L88:
        th = th;
        goto L98
    L36:
        r5 = WAKEUP_SOURCES_FORMAT;     // Catch: Throwable -> L21
    L91:
        th = th;
        goto L98
    L25:
        endIndex = endIndex2;
    L106:
        monitor-exit(this);     // Catch: Throwable -> L96
        return staleStats;
    L96:
        th = th;
        goto L98
    }

    public KernelWakelockStats updateVersion(KernelWakelockStats staleStats) {
        sKernelWakelockUpdateVersion++;
        staleStats.kernelWakelockVersion = sKernelWakelockUpdateVersion;
        return staleStats;
    }

    public KernelWakelockStats removeOldStats(KernelWakelockStats staleStats) {
        Iterator<KernelWakelockStats.Entry> itr = staleStats.values().iterator();
    L4:
        if (itr.hasNext() == false) goto L8;
        if (itr.next().version == sKernelWakelockUpdateVersion) goto L4;
        itr.remove();
        goto L4
    L8:
        return staleStats;
    }
}
