package com.stepos.pps.logpull;

import android.os.StatFs;
import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class LogPullDiskManager {
    public static final String PPS_LOGPULL_ROOT = "/data/misc/pps/logpull";
    private static final long SAFETY_MARGIN_BYTES = 536870912;
    private static final String TAG = "LogPull.Disk";

    public boolean hasEnoughSpace(long j) {
        try {
            long availableBytes = new StatFs("/data").getAvailableBytes();
            long j2 = (j * 2) + SAFETY_MARGIN_BYTES;
            boolean z = availableBytes >= j2;
            if (!z) {
                Log.w(TAG, "空间不足: available=" + availableBytes + ", required=" + j2);
            }
            return z;
        } catch (Exception e) {
            Log.e(TAG, "检查空间失败", e);
            return false;
        }
    }

    public void cleanupTask(long j) {
        File file = new File("/data/misc/pps/logpull/" + j);
        if (file.exists()) {
            deleteRecursive(file);
            Log.i(TAG, "清理任务目录: " + file.getAbsolutePath());
        }
    }

    private void deleteRecursive(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                deleteRecursive(file2);
            }
        }
        file.delete();
    }
}
