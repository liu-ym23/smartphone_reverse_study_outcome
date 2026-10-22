package com.android.server.am;

import android.os.FileUtils;
import android.os.SystemProperties;
import android.system.Os;
import android.system.OsConstants;
import android.util.Slog;
import com.android.server.wm.ActivityTaskManagerDebugConfig;
import java.io.File;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class MemoryStatUtil {
    private static final Pattern CACHE_IN_BYTES = null;
    private static final boolean DEVICE_HAS_PER_APP_MEMCG = false;
    private static final String MEMORY_STAT_FILE_FMT = "/dev/memcg/apps/uid_%d/pid_%d/memory.stat";
    static final int PAGE_SIZE = 0;
    private static final Pattern PGFAULT = null;
    private static final int PGFAULT_INDEX = 9;
    private static final Pattern PGMAJFAULT = null;
    private static final int PGMAJFAULT_INDEX = 11;
    private static final String PROC_STAT_FILE_FMT = "/proc/%d/stat";
    private static final Pattern RSS_IN_BYTES = null;
    private static final int RSS_IN_PAGES_INDEX = 23;
    private static final Pattern SWAP_IN_BYTES = null;
    private static final String TAG = "ActivityManager";

    public static final class MemoryStat {
        public long cacheInBytes;
        public long pgfault;
        public long pgmajfault;
        public long rssInBytes;
        public long swapInBytes;

        public MemoryStat() {
        }
    }

    static {
        PAGE_SIZE = (int) Os.sysconf(OsConstants._SC_PAGESIZE);
        DEVICE_HAS_PER_APP_MEMCG = SystemProperties.getBoolean("ro.config.per_app_memcg", false);
        PGFAULT = Pattern.compile("total_pgfault (\\d+)");
        PGMAJFAULT = Pattern.compile("total_pgmajfault (\\d+)");
        RSS_IN_BYTES = Pattern.compile("total_rss (\\d+)");
        CACHE_IN_BYTES = Pattern.compile("total_cache (\\d+)");
        SWAP_IN_BYTES = Pattern.compile("total_swap (\\d+)");
    }

    private MemoryStatUtil() {
    }

    public static MemoryStat readMemoryStatFromFilesystem(int uid, int pid) {
        if (hasMemcg() == false) goto L6;
        return readMemoryStatFromMemcg(uid, pid);
    L6:
        return readMemoryStatFromProcfs(pid);
    }

    static MemoryStat readMemoryStatFromMemcg(int uid, int pid) {
        String statPath = String.format(Locale.US, MEMORY_STAT_FILE_FMT, new Object[]{Integer.valueOf(uid), Integer.valueOf(pid)});
        return parseMemoryStatFromMemcg(readFileContents(statPath));
    }

    public static MemoryStat readMemoryStatFromProcfs(int pid) {
        String statPath = String.format(Locale.US, PROC_STAT_FILE_FMT, new Object[]{Integer.valueOf(pid)});
        return parseMemoryStatFromProcfs(readFileContents(statPath));
    }

    private static String readFileContents(String path) {
        File file = new File(path);
        if (file.exists() == true) goto L14;
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L7;
        Slog.i(TAG, path + " not found");
    L7:
        return null;
    L14:
        return FileUtils.readTextFile(file, 0, null);
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to read file:", e);
        return null;
    }

    static MemoryStat parseMemoryStatFromMemcg(String memoryStatContents) {
        if (memoryStatContents != null) goto L4;
        return null;
    L4:
        if (memoryStatContents.isEmpty() == true) goto L10;
        MemoryStat memoryStat = new MemoryStat();
        memoryStat.pgfault = tryParseLong(PGFAULT, memoryStatContents);
        memoryStat.pgmajfault = tryParseLong(PGMAJFAULT, memoryStatContents);
        memoryStat.rssInBytes = tryParseLong(RSS_IN_BYTES, memoryStatContents);
        memoryStat.cacheInBytes = tryParseLong(CACHE_IN_BYTES, memoryStatContents);
        memoryStat.swapInBytes = tryParseLong(SWAP_IN_BYTES, memoryStatContents);
        return memoryStat;
    L10:
        return null;
    }

    static MemoryStat parseMemoryStatFromProcfs(String procStatContents) {
        if (procStatContents != null) goto L5;
    L15:
        return null;
    L5:
        if (procStatContents.isEmpty() == true) goto L15;
        String[] splits = procStatContents.split(" ");
        if (splits.length >= 24) goto L16;
        return null;
    L16:
        MemoryStat memoryStat = new MemoryStat();     // Catch: NumberFormatException -> L12
        memoryStat.pgfault = Long.parseLong(splits[9]);     // Catch: NumberFormatException -> L12
        memoryStat.pgmajfault = Long.parseLong(splits[11]);     // Catch: NumberFormatException -> L12
        memoryStat.rssInBytes = Long.parseLong(splits[23]) * ((long) PAGE_SIZE);     // Catch: NumberFormatException -> L12
        return memoryStat;
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to parse value", e);
        return null;
    }

    static boolean hasMemcg() {
        return DEVICE_HAS_PER_APP_MEMCG;
    }

    private static long tryParseLong(Pattern pattern, String input) {
        Matcher m = pattern.matcher(input);
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to parse value", e);
        return 0;
    L4:
        if (m.find() == false) goto L9;
        return Long.parseLong(m.group(1));
    L9:
        return 0;
    }
}
