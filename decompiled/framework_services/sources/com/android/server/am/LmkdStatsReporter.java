package com.android.server.am;

import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class LmkdStatsReporter {
    private static final int DIRECT_RECL_AND_THRASHING = 5;
    private static final int DIRECT_RECL_STUCK = 9;
    public static final int KILL_OCCURRED_MSG_SIZE = 80;
    private static final int LOW_FILECACHE_AFTER_THRASHING = 7;
    private static final int LOW_MEM = 8;
    private static final int LOW_MEM_AND_SWAP = 3;
    private static final int LOW_MEM_AND_SWAP_UTIL = 6;
    private static final int LOW_MEM_AND_THRASHING = 4;
    private static final int LOW_SWAP_AND_THRASHING = 2;
    private static final int NOT_RESPONDING = 1;
    private static final int PRESSURE_AFTER_KILL = 0;
    static final String TAG = "ActivityManager";

    public LmkdStatsReporter() {
    }

    public static void logKillOccurred(DataInputStream inputData, int totalForegroundServices, int procsWithForegroundServices) {
        long pgFault = inputData.readLong();     // Catch: IOException -> L4
        long pgMajFault = inputData.readLong();     // Catch: IOException -> L4
        long rssInBytes = inputData.readLong();     // Catch: IOException -> L4
        long cacheInBytes = inputData.readLong();     // Catch: IOException -> L4
        long swapInBytes = inputData.readLong();     // Catch: IOException -> L4
        long processStartTimeNS = inputData.readLong();     // Catch: IOException -> L4
        int uid = inputData.readInt();     // Catch: IOException -> L4
        int oomScore = inputData.readInt();     // Catch: IOException -> L4
        int minOomScore = inputData.readInt();     // Catch: IOException -> L4
        int freeMemKb = inputData.readInt();     // Catch: IOException -> L4
        int freeSwapKb = inputData.readInt();     // Catch: IOException -> L4
        int killReason = inputData.readInt();     // Catch: IOException -> L4
        int thrashing = inputData.readInt();     // Catch: IOException -> L4
        int maxThrashing = inputData.readInt();     // Catch: IOException -> L4
        String procName = inputData.readUTF();     // Catch: IOException -> L4
        FrameworkStatsLog.write(51, uid, procName, oomScore, pgFault, pgMajFault, rssInBytes, cacheInBytes, swapInBytes, processStartTimeNS, minOomScore, freeMemKb, freeSwapKb, mapKillReason(killReason), thrashing, maxThrashing, totalForegroundServices, procsWithForegroundServices);     // Catch: IOException -> L4
        return;
    L5:
        Slog.e(TAG, "Invalid buffer data. Failed to log LMK_KILL_OCCURRED");
    }

    private static int mapKillReason(int reason) {
        switch(reason) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            case 9: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 10;
    L7:
        return 9;
    L9:
        return 8;
    L11:
        return 7;
    L13:
        return 6;
    L15:
        return 5;
    L17:
        return 4;
    L19:
        return 3;
    L21:
        return 2;
    L23:
        return 1;
    }
}
