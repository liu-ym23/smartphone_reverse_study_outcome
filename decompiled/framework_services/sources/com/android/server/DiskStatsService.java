package com.android.server;

import android.content.Context;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.os.IStoraged;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.util.Log;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.DumpUtils;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.storage.DiskStatsFileLogger;
import com.android.server.storage.DiskStatsLoggingService;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import libcore.io.IoUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DiskStatsService extends Binder {
    private static final String DISKSTATS_DUMP_FILE = "/data/system/diskstats_cache.json";
    private static final String TAG = "DiskStatsService";
    private final Context mContext;

    public DiskStatsService(Context context) {
        this.mContext = context;
        DiskStatsLoggingService.schedule(context);
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        PrintWriter pw2 = pw;
        if (DumpUtils.checkDumpAndUsageStatsPermission(this.mContext, TAG, pw2) == true) goto L5;
        return;
    L5:
        byte[] junk = new byte[512];
        int i = 0;
    L7:
        if (i >= junk.length) goto L9;
        junk[i] = (byte) i;
        i = i + 1;
        goto L7
    L9:
        File tmp = new File(Environment.getDataDirectory(), "system/perftest.tmp");
        FileOutputStream fos = null;
        IOException error = null;
        long before = SystemClock.uptimeMillis();
        fos = new FileOutputStream(tmp);     // Catch: Throwable -> L16 IOException -> L18
        fos.write(junk);     // Catch: Throwable -> L16 IOException -> L18
        fos.close();     // Catch: IOException -> L13
    L15:
        IOException error2 = error;
        long after = SystemClock.uptimeMillis();
        if (tmp.exists() == false) goto L34;
        tmp.delete();
    L34:
        boolean protoFormat = hasOption(args, "--proto");
        if (protoFormat == false) goto L46;
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        pw2 = null;
        if (error2 == null) goto L39;
        boolean r5 = true;
    L40:
        proto.write(1133871366145L, r5);
        if (error2 == null) goto L43;
        proto.write(1138166333442L, error2.toString());
    L44:
        ProtoOutputStream proto2 = proto;
    L50:
        if (protoFormat == false) goto L52;
        reportDiskWriteSpeedProto(proto2);
    L53:
        PrintWriter pw3 = pw2;
        reportFreeSpace(Environment.getDataDirectory(), "Data", pw3, proto2, 0);
        reportFreeSpace(Environment.getDownloadCacheDirectory(), "Cache", pw3, proto2, 1);
        reportFreeSpace(new File("/system"), "System", pw3, proto2, 2);
        reportFreeSpace(Environment.getMetadataDirectory(), "Metadata", pw3, proto2, 3);
        boolean fileBased = StorageManager.isFileEncrypted();
        if (protoFormat == true) goto L56;
        if (fileBased == false) goto L61;
        pw3.println("File-based Encryption: true");
    L61:
        if (protoFormat == false) goto L63;
        reportCachedValuesProto(proto2);
    L64:
        if (protoFormat == false) goto L78;
        proto2.flush();
        return;
    L78:
        return;
    L63:
        reportCachedValues(pw3);
        goto L64
    L56:
        if (fileBased == false) goto L58;
        proto2.write(1159641169925L, 3);
        goto L61
    L58:
        proto2.write(1159641169925L, 1);
        goto L61
    L52:
        reportDiskWriteSpeed(pw2);
        goto L53
    L43:
        proto.write(1120986464259L, after - before);
        goto L44
    L39:
        r5 = false;
        goto L40
    L46:
        if (error2 == null) goto L48;
        pw2.print("Test-Error: ");
        pw2.println(error2.toString());
    L49:
        proto2 = null;
        goto L50
    L48:
        pw2.print("Latency: ");
        pw2.print(after - before);
        pw2.println("ms [512B Data Write]");
        goto L49
    L18:
        e = move-exception;
        error = e;
        if (fos == null) goto L15;
        fos.close();     // Catch: IOException -> L29
    L16:
        th = move-exception;
        FileOutputStream fos2 = fos;
        if (fos2 == null) goto L76;
        fos2.close();     // Catch: IOException -> L23
        throw th;
    L24:
        throw th;
    L76:
        throw th;
    }

    private void reportFreeSpace(File path, String name, PrintWriter pw, ProtoOutputStream proto, int folderType) {
        StatFs statfs = new StatFs(path.getPath());     // Catch: IllegalArgumentException -> L9
        long bsize = statfs.getBlockSize();     // Catch: IllegalArgumentException -> L9
        long avail = statfs.getAvailableBlocks();     // Catch: IllegalArgumentException -> L9
        long total = statfs.getBlockCount();     // Catch: IllegalArgumentException -> L9
        if (bsize <= 0) goto L15;
        if (total <= 0) goto L15;
        if (proto == null) goto L11;
        long freeSpaceToken = proto.start(2246267895812L);     // Catch: IllegalArgumentException -> L9
        proto.write(1159641169921L, folderType);     // Catch: IllegalArgumentException -> L9
        proto.write(1112396529666L, (avail * bsize) / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: IllegalArgumentException -> L9
        proto.write(1112396529667L, (total * bsize) / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: IllegalArgumentException -> L9
        proto.end(freeSpaceToken);     // Catch: IllegalArgumentException -> L9
        return;
    L11:
        pw.print(name);     // Catch: IllegalArgumentException -> L9
        pw.print("-Free: ");     // Catch: IllegalArgumentException -> L9
        pw.print((avail * bsize) / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: IllegalArgumentException -> L9
        pw.print("K / ");     // Catch: IllegalArgumentException -> L9
        pw.print((total * bsize) / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: IllegalArgumentException -> L9
        pw.print("K total = ");     // Catch: IllegalArgumentException -> L9
        pw.print((100 * avail) / total);     // Catch: IllegalArgumentException -> L9
        pw.println("% free");     // Catch: IllegalArgumentException -> L9
        return;
    L15:
        throw new IllegalArgumentException("Invalid stat: bsize=" + bsize + " avail=" + avail + " total=" + total);     // Catch: IllegalArgumentException -> L9
    L9:
        e = move-exception;
        if (proto != null) goto L23;
        pw.print(name);
        pw.print("-Error: ");
        pw.println(e.toString());
        return;
    }

    private boolean hasOption(String[] args, String arg) {
        int r0 = args.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        String opt = args[r2];
        if (arg.equals(opt) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void reportCachedValues(PrintWriter pw) {
        String jsonString = IoUtils.readFileAsString("/data/system/diskstats_cache.json");     // Catch: Throwable -> L4
        JSONObject json = new JSONObject(jsonString);     // Catch: Throwable -> L4
        pw.print("App Size: ");     // Catch: Throwable -> L4
        pw.println(json.getLong(DiskStatsFileLogger.APP_SIZE_AGG_KEY));     // Catch: Throwable -> L4
        pw.print("App Data Size: ");     // Catch: Throwable -> L4
        pw.println(json.getLong(DiskStatsFileLogger.APP_DATA_SIZE_AGG_KEY));     // Catch: Throwable -> L4
        pw.print("App Cache Size: ");     // Catch: Throwable -> L4
        pw.println(json.getLong(DiskStatsFileLogger.APP_CACHE_AGG_KEY));     // Catch: Throwable -> L4
        pw.print("Photos Size: ");     // Catch: Throwable -> L4
        pw.println(json.getLong(DiskStatsFileLogger.PHOTOS_KEY));     // Catch: Throwable -> L4
        pw.print("Videos Size: ");     // Catch: Throwable -> L4
        pw.println(json.getLong(DiskStatsFileLogger.VIDEOS_KEY));     // Catch: Throwable -> L4
        pw.print("Audio Size: ");     // Catch: Throwable -> L4
        pw.println(json.getLong(DiskStatsFileLogger.AUDIO_KEY));     // Catch: Throwable -> L4
        pw.print("Downloads Size: ");     // Catch: Throwable -> L4
        pw.println(json.getLong(DiskStatsFileLogger.DOWNLOADS_KEY));     // Catch: Throwable -> L4
        pw.print("System Size: ");     // Catch: Throwable -> L4
        pw.println(json.getLong(DiskStatsFileLogger.SYSTEM_KEY));     // Catch: Throwable -> L4
        pw.print("Other Size: ");     // Catch: Throwable -> L4
        pw.println(json.getLong(DiskStatsFileLogger.MISC_KEY));     // Catch: Throwable -> L4
        pw.print("Package Names: ");     // Catch: Throwable -> L4
        pw.println(json.getJSONArray(DiskStatsFileLogger.PACKAGE_NAMES_KEY));     // Catch: Throwable -> L4
        pw.print("App Sizes: ");     // Catch: Throwable -> L4
        pw.println(json.getJSONArray(DiskStatsFileLogger.APP_SIZES_KEY));     // Catch: Throwable -> L4
        pw.print("App Data Sizes: ");     // Catch: Throwable -> L4
        pw.println(json.getJSONArray(DiskStatsFileLogger.APP_DATA_KEY));     // Catch: Throwable -> L4
        pw.print("Cache Sizes: ");     // Catch: Throwable -> L4
        pw.println(json.getJSONArray(DiskStatsFileLogger.APP_CACHES_KEY));     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Log.w(TAG, "exception reading diskstats cache file", e);
    }

    private void reportCachedValuesProto(ProtoOutputStream proto) {
        String jsonString = IoUtils.readFileAsString("/data/system/diskstats_cache.json");     // Catch: Throwable -> L12
        JSONObject json = new JSONObject(jsonString);     // Catch: Throwable -> L12
        long cachedValuesToken = proto.start(1146756268038L);     // Catch: Throwable -> L12
        proto.write(1112396529665L, json.getLong(DiskStatsFileLogger.APP_SIZE_AGG_KEY));     // Catch: Throwable -> L12
        proto.write(1112396529674L, json.getLong(DiskStatsFileLogger.APP_DATA_SIZE_AGG_KEY));     // Catch: Throwable -> L12
        proto.write(1112396529666L, json.getLong(DiskStatsFileLogger.APP_CACHE_AGG_KEY));     // Catch: Throwable -> L12
        proto.write(1112396529667L, json.getLong(DiskStatsFileLogger.PHOTOS_KEY));     // Catch: Throwable -> L12
        proto.write(1112396529668L, json.getLong(DiskStatsFileLogger.VIDEOS_KEY));     // Catch: Throwable -> L12
        proto.write(1112396529669L, json.getLong(DiskStatsFileLogger.AUDIO_KEY));     // Catch: Throwable -> L12
        proto.write(1112396529670L, json.getLong(DiskStatsFileLogger.DOWNLOADS_KEY));     // Catch: Throwable -> L12
        proto.write(1112396529671L, json.getLong(DiskStatsFileLogger.SYSTEM_KEY));     // Catch: Throwable -> L12
        proto.write(1112396529672L, json.getLong(DiskStatsFileLogger.MISC_KEY));     // Catch: Throwable -> L12
        JSONArray packageNamesArray = json.getJSONArray(DiskStatsFileLogger.PACKAGE_NAMES_KEY);     // Catch: Throwable -> L12
        JSONArray appSizesArray = json.getJSONArray(DiskStatsFileLogger.APP_SIZES_KEY);     // Catch: Throwable -> L12
        JSONArray appDataSizesArray = json.getJSONArray(DiskStatsFileLogger.APP_DATA_KEY);     // Catch: Throwable -> L12
        JSONArray cacheSizesArray = json.getJSONArray(DiskStatsFileLogger.APP_CACHES_KEY);     // Catch: Throwable -> L12
        int len = packageNamesArray.length();     // Catch: Throwable -> L12
        if (len != appSizesArray.length()) goto L18;
        if (len != appDataSizesArray.length()) goto L18;
        if (len != cacheSizesArray.length()) goto L18;
        int i = 0;
    L10:
        if (i >= len) goto L14;
        long packageToken = proto.start(2246267895817L);     // Catch: Throwable -> L12
        JSONObject json2 = json;
        proto.write(1138166333441L, packageNamesArray.getString(i));     // Catch: Throwable -> L12
        proto.write(1112396529666L, appSizesArray.getLong(i));     // Catch: Throwable -> L12
        proto.write(1112396529668L, appDataSizesArray.getLong(i));     // Catch: Throwable -> L12
        proto.write(1112396529667L, cacheSizesArray.getLong(i));     // Catch: Throwable -> L12
        proto.end(packageToken);     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        packageNamesArray = packageNamesArray;
        json = json2;
        cachedValuesToken = cachedValuesToken;
        goto L10
    L14:
        cachedValuesToken = cachedValuesToken;
    L19:
        proto.end(cachedValuesToken);     // Catch: Throwable -> L12
        return;
    L18:
        Slog.wtf(TAG, "Sizes of packageNamesArray, appSizesArray, appDataSizesArray  and cacheSizesArray are not the same");     // Catch: Throwable -> L12
    L12:
        e = move-exception;
        Log.w(TAG, "exception reading diskstats cache file", e);
    }

    private int getRecentPerf() throws RemoteException, IllegalStateException {
        IBinder binder = ServiceManager.getService("storaged");
        if (binder == null) goto L7;
        IStoraged storaged = IStoraged.Stub.asInterface(binder);
        return storaged.getRecentPerf();
    L7:
        throw new IllegalStateException("storaged not found");
    }

    private void reportDiskWriteSpeed(PrintWriter pw) {
        long perf = getRecentPerf();     // Catch: Throwable -> L6
        if (perf == 0) goto L8;
        pw.print("Recent Disk Write Speed (kB/s) = ");     // Catch: Throwable -> L6
        pw.println(perf);     // Catch: Throwable -> L6
    L12:
        return;
    L8:
        pw.println("Recent Disk Write Speed data unavailable");     // Catch: Throwable -> L6
        Log.w(TAG, "Recent Disk Write Speed data unavailable!");     // Catch: Throwable -> L6
    L6:
        e = move-exception;
        pw.println(e.toString());
        Log.e(TAG, e.toString());
    }

    private void reportDiskWriteSpeedProto(ProtoOutputStream proto) {
        long perf = getRecentPerf();     // Catch: Throwable -> L6
        if (perf == 0) goto L8;
        proto.write(1120986464263L, perf);     // Catch: Throwable -> L6
    L12:
        return;
    L8:
        Log.w(TAG, "Recent Disk Write Speed data unavailable!");     // Catch: Throwable -> L6
    L6:
        e = move-exception;
        Log.e(TAG, e.toString());
    }
}
