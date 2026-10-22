package net.zetetic.database.sqlcipher;

import android.os.StatFs;
import com.stepos.alphame.sleep.SleepModeEngine;

/* loaded from: classes2.dex */
public final class SQLiteGlobal {
    private static final String TAG = "SQLiteGlobal";
    private static int sDefaultPageSize = 4096;
    private static final Object sLock = new Object();
    private static int sWALConnectionPoolSize = 10;

    private SQLiteGlobal() {
    }

    public static String getDefaultJournalMode() {
        return "delete";
    }

    public static int getDefaultPageSize() {
        synchronized (sLock) {
            try {
                if (sDefaultPageSize == 0) {
                    sDefaultPageSize = new StatFs("/data").getBlockSize();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 4096;
    }

    public static String getDefaultSyncMode() {
        return SleepModeEngine.NORMAL_NAME;
    }

    public static int getJournalSizeLimit() {
        return 10000;
    }

    public static int getWALAutoCheckpoint() {
        return Math.max(1, 1000);
    }

    public static int getWALConnectionPoolSize() {
        return sWALConnectionPoolSize;
    }

    public static String getWALSyncMode() {
        return SleepModeEngine.NORMAL_NAME;
    }

    private static native int nativeReleaseMemory();

    public static int releaseMemory() {
        return nativeReleaseMemory();
    }

    public static void setWALConnectionPoolSize(int i4) {
        sWALConnectionPoolSize = i4;
    }
}
