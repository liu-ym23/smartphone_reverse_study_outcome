package com.stepos.pps.logpull;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.stepos.pps.logpull.LogPullDateCleanupReceiver;
import com.stepos.pps.logpull.LogPullTaskStore;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.ToLongFunction;

/* loaded from: classes.dex */
public class LogPullDateCleanupReceiver extends BroadcastReceiver {
    private static final int CAPACITY_SWEEP_MIN_ENTRIES = 8;
    private static final long MAX_TOTAL_BYTES = 2147483648L;
    private static final long RETENTION_MS = 259200000;
    private static final String TAG = "LogPull.DateCleanup";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        if ("android.intent.action.DATE_CHANGED".equals(action) || "android.intent.action.BOOT_COMPLETED".equals(action)) {
            Log.i(TAG, "cleanup triggered by " + action);
            if ("android.intent.action.DATE_CHANGED".equals(action)) {
                LogPullCheckJobService.resetBackoffToBase(context);
            }
            final Context applicationContext = context.getApplicationContext();
            new Thread(new Runnable() { // from class: com.stepos.pps.logpull.LogPullDateCleanupReceiver$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LogPullDateCleanupReceiver.cleanup(applicationContext, true);
                }
            }, "logpull-cleanup").start();
        }
    }

    public static void cleanupNow(Context context) {
        cleanup(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cleanup(Context context, boolean z) {
        long size;
        try {
            long jActiveConfigId = activeConfigId(context);
            ArrayList arrayList = new ArrayList();
            collect(LogPullDiskManager.PPS_LOGPULL_ROOT, arrayList);
            long jCurrentTimeMillis = System.currentTimeMillis() - RETENTION_MS;
            ArrayList<Entry> arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            while (true) {
                size = 0;
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                if (!entry.isActive(jActiveConfigId)) {
                    if (entry.mtime > 0 && entry.mtime < jCurrentTimeMillis) {
                        if (entry.delete()) {
                            i2++;
                        }
                    } else {
                        arrayList2.add(entry);
                    }
                }
            }
            boolean z2 = z || arrayList2.size() >= 8;
            if (!z2 || arrayList2.isEmpty()) {
                size = -1;
            } else {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    size += ((Entry) it2.next()).size();
                }
                if (size > MAX_TOTAL_BYTES) {
                    Collections.sort(arrayList2, Comparator.comparingLong(new ToLongFunction() { // from class: com.stepos.pps.logpull.LogPullDateCleanupReceiver$$ExternalSyntheticLambda1
                        @Override // java.util.function.ToLongFunction
                        public final long applyAsLong(Object obj) {
                            return ((LogPullDateCleanupReceiver.Entry) obj).mtime;
                        }
                    }));
                    for (Entry entry2 : arrayList2) {
                        if (size <= MAX_TOTAL_BYTES) {
                            break;
                        }
                        long size2 = entry2.size();
                        if (entry2.delete()) {
                            i++;
                            size -= size2;
                        }
                    }
                }
            }
            Log.i(TAG, "cleanup done deletedByAge=" + i2 + " deletedBySize=" + i + " survivors=" + arrayList2.size() + " capacitySweep=" + z2 + " remainingBytes=" + size + " activeConfigId=" + jActiveConfigId);
        } catch (Exception e) {
            Log.e(TAG, "cleanup 异常", e);
        }
    }

    private static long activeConfigId(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            LogPullTaskStore.PendingTask pendingTaskLoad = new LogPullTaskStore(context).load();
            if (pendingTaskLoad != null) {
                return pendingTaskLoad.configId;
            }
            return -1L;
        } catch (Exception e) {
            Log.w(TAG, "读取在途任务失败，按无在途处理", e);
            return -1L;
        }
    }

    private static void collect(String str, List<Entry> list) {
        File file = new File(str);
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                Log.w(TAG, "listFiles null: " + str);
            } else {
                for (File file2 : fileArrListFiles) {
                    list.add(new Entry(file2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Entry {
        private long cachedSize = -1;
        final File file;
        final long mtime;

        Entry(File file) {
            this.file = file;
            this.mtime = file.lastModified();
        }

        boolean isActive(long j) {
            return j > 0 && this.file.getName().equals(String.valueOf(j));
        }

        long size() {
            if (this.cachedSize < 0) {
                this.cachedSize = LogPullDateCleanupReceiver.sizeOf(this.file);
            }
            return this.cachedSize;
        }

        boolean delete() {
            boolean zDeleteRecursive = LogPullDateCleanupReceiver.deleteRecursive(this.file);
            if (zDeleteRecursive) {
                Log.i(LogPullDateCleanupReceiver.TAG, "deleted stale: " + this.file.getAbsolutePath());
                return zDeleteRecursive;
            }
            Log.w(LogPullDateCleanupReceiver.TAG, "delete failed: " + this.file.getAbsolutePath());
            return zDeleteRecursive;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long sizeOf(File file) {
        long jSizeOf = 0;
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    jSizeOf += sizeOf(file2);
                }
            }
        }
        return jSizeOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean deleteRecursive(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!deleteRecursive(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }
}
