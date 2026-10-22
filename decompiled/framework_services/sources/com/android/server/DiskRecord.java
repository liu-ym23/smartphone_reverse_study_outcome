package com.android.server;

import android.os.Environment;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Slog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DiskRecord {
    private static final boolean DBG = false;
    private static final String DISK_STATS_NODE = "/proc/diskstats";
    private static final int ONE_DAY_MILLIS = 82800000;
    private static final String TAG = "DiskRecord";
    private static final String VM_STATS_NODE = "/proc/vmstat";
    private static long bootTime;
    private static boolean entireDay;
    private static long[] oldStats;
    public long dataFreeSize;
    public long dataTotalSize;

    public DiskRecord() {
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) == 0) goto L5;
        r1 = true;
    L5:
        DBG = r1;
        oldStats = new long[32];
        bootTime = 0;
    }

    public String toString() {
        return this.dataTotalSize + "|" + this.dataFreeSize;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data_size", this.dataTotalSize);     // Catch: JSONException -> L5
        jsonObject.put("data_free_size", this.dataFreeSize);     // Catch: JSONException -> L5
    L7:
        return jsonObject;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static DiskRecord readDiskInfo() {
        DiskRecord diskRecord = new DiskRecord();
        diskRecord.dataTotalSize = Environment.getDataDirectory().getTotalSpace();
        diskRecord.dataFreeSize = Environment.getDataDirectory().getFreeSpace();
        return diskRecord;
    }

    static void init() {
        long[] rw = readDiskStatsFile();
        long[] vm = readVmStatFile();
        int i = 0;
    L4:
        if (i >= rw.length) goto L6;
        oldStats[i] = rw[i];
        i = i + 1;
        goto L4
    L6:
        int len = rw.length;
        int i2 = 0;
    L8:
        if (i2 >= vm.length) goto L10;
        oldStats[i2 + len] = vm[i2];
        i2 = i2 + 1;
        goto L8
    L10:
        bootTime = SystemClock.elapsedRealtime();
    }

    static long[] readDiskRwStats() {
        long[] rwSectors = readDiskStatsFile();
        long[] vmStats = readVmStatFile();
        long[] ret = new long[16];
        if (entireDay == false) goto L5;
    L9:
        int i = 0;
    L11:
        if (i >= rwSectors.length) goto L16;
        if (entireDay == false) goto L15;
        ret[i] = rwSectors[i] - oldStats[i];
    L15:
        oldStats[i] = rwSectors[i];
        i = i + 1;
        goto L11
    L16:
        int i2 = rwSectors.length;
        int i3 = 0;
    L18:
        if (i3 >= vmStats.length) goto L24;
        if (entireDay == false) goto L22;
        ret[i3 + i2] = vmStats[i3] - oldStats[i3 + i2];
    L22:
        oldStats[i3 + i2] = vmStats[i3];
        i3 = i3 + 1;
        goto L18
    L24:
        if (DBG == false) goto L26;
        print(ret);
    L26:
        return ret;
    L5:
        if ((SystemClock.elapsedRealtime() - bootTime) < 82800000) goto L7;
        boolean r3 = true;
    L8:
        entireDay = r3;
        goto L9
    L7:
        r3 = false;
        goto L8
    }

    private static void print(long[] data) {
        StringBuilder sb = new StringBuilder("disk stats: ");
        int i = 0;
    L4:
        if (i >= data.length) goto L6;
        sb.append(data[i]);
        sb.append(" ");
        i = i + 1;
        goto L4
    L6:
        Slog.d(TAG, sb.toString());
    }

    private static long[] readVmStatFile() {
        long[] vmFields = new long[1];
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(VM_STATS_NODE)));     // Catch: Exception -> L25
    L39:
        String line = reader.readLine();     // Catch: Throwable -> L12
        if (line == null) goto L23;
        boolean parsePswpOut = line.contains("pswpout ");     // Catch: Throwable -> L12
        if (parsePswpOut == false) goto L39;
        String line2 = line.trim();     // Catch: Throwable -> L12
        if (DBG == false) goto L14;
        Slog.w(TAG, "line" + line2);     // Catch: Throwable -> L12
    L14:
        String[] fields = line2.split("\\s+");     // Catch: Throwable -> L12
        if (DBG == false) goto L19;
        int r7 = fields.length;     // Catch: Throwable -> L12
        int r9 = 0;
    L17:
        if (r9 >= r7) goto L19;
        String field = fields[r9];     // Catch: Throwable -> L12
        Slog.w(TAG, "field:" + field);     // Catch: Throwable -> L12
        r9 = r9 + 1;     // Catch: Throwable -> L12
    L19:
        if (parsePswpOut == false) goto L39;
        vmFields[0] = Long.valueOf(fields[1]).longValue();     // Catch: Throwable -> L12
        goto L39
    L23:
        reader.close();     // Catch: Exception -> L25
    L33:
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L35:
        if (i >= vmFields.length) goto L37;
        sb.append(vmFields[i]);
        sb.append(" ");
        i = i + 1;
        goto L35
    L37:
        Slog.i(TAG, sb.toString());
        return vmFields;
    L12:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Exception -> L25
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Slog.w(TAG, "vm stats failed", e);
        goto L33
    }

    private static long[] readDiskStatsFile() {
        long[] diskFields = new long[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(DISK_STATS_NODE)));     // Catch: Exception -> L29
    L46:
        String line = reader.readLine();     // Catch: Throwable -> L13
        if (line == null) goto L27;
        boolean parseSda = line.contains("sda ");     // Catch: Throwable -> L13
        boolean parseZram = line.contains("zram0");     // Catch: Throwable -> L13
        if (parseSda == true) goto L10;
        if (parseZram == false) goto L46;
    L10:
        String line2 = line.trim();     // Catch: Throwable -> L13
        if (DBG == false) goto L15;
        Slog.w(TAG, "line" + line2);     // Catch: Throwable -> L13
    L15:
        String[] fields = line2.split("\\s+");     // Catch: Throwable -> L13
        if (DBG == false) goto L21;
        int r7 = fields.length;     // Catch: Throwable -> L13
        int r9 = 0;
    L18:
        if (r9 >= r7) goto L21;
        String field = fields[r9];     // Catch: Throwable -> L13
        Slog.w(TAG, "field:" + field);     // Catch: Throwable -> L13
        r9 = r9 + 1;     // Catch: Throwable -> L13
    L21:
        if (parseSda == true) goto L22;
        if (parseZram == false) goto L46;
        diskFields[2] = Long.valueOf(fields[9]).longValue();     // Catch: Throwable -> L13
        goto L46
    L22:
        diskFields[0] = Long.valueOf(fields[5]).longValue();     // Catch: Throwable -> L13
        diskFields[1] = Long.valueOf(fields[9]).longValue();     // Catch: Throwable -> L13
        goto L46
    L27:
        reader.close();     // Catch: Exception -> L29
    L37:
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L39:
        if (i >= diskFields.length) goto L41;
        sb.append(diskFields[i]);
        sb.append(" ");
        i = i + 1;
        goto L39
    L41:
        Slog.i(TAG, sb.toString());
        return diskFields;
    L13:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: Exception -> L29
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Slog.w(TAG, "disk stats failed", e);
        goto L37
    }
}
