package com.android.server.stats.pull;

import android.os.FileUtils;
import android.util.Slog;
import android.util.SparseArray;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class IonMemoryUtil {
    private static final String DEBUG_SYSTEM_ION_HEAP_FILE = "/sys/kernel/debug/ion/heaps/system";
    private static final Pattern ION_HEAP_SIZE_IN_BYTES = null;
    private static final Pattern PROCESS_ION_HEAP_SIZE_IN_BYTES = null;
    private static final String TAG = "IonMemoryUtil";

    public static final class IonAllocations {
        public int count;
        public long maxSizeInBytes;
        public int pid;
        public long totalSizeInBytes;

        public IonAllocations() {
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L21;
            IonAllocations that = (IonAllocations) o;
            if (this.pid != that.pid) goto L20;
            if (this.totalSizeInBytes != that.totalSizeInBytes) goto L20;
            if (this.count != that.count) goto L20;
            if (this.maxSizeInBytes != that.maxSizeInBytes) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.pid), Long.valueOf(this.totalSizeInBytes), Integer.valueOf(this.count), Long.valueOf(this.maxSizeInBytes)});
        }

        public String toString() {
            return "IonAllocations{pid=" + this.pid + ", totalSizeInBytes=" + this.totalSizeInBytes + ", count=" + this.count + ", maxSizeInBytes=" + this.maxSizeInBytes + '}';
        }
    }

    static {
        ION_HEAP_SIZE_IN_BYTES = Pattern.compile("\n\\s*total\\s*(\\d+)\\s*\n");
        PROCESS_ION_HEAP_SIZE_IN_BYTES = Pattern.compile("\n\\s+\\S+\\s+(\\d+)\\s+(\\d+)");
    }

    private IonMemoryUtil() {
    }

    public static long readSystemIonHeapSizeFromDebugfs() {
        return parseIonHeapSizeFromDebugfs(readFile(DEBUG_SYSTEM_ION_HEAP_FILE));
    }

    static long parseIonHeapSizeFromDebugfs(String contents) {
        if (contents.isEmpty() == false) goto L5;
        return 0;
    L5:
        Matcher matcher = ION_HEAP_SIZE_IN_BYTES.matcher(contents);
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to parse value", e);
        return 0;
    L7:
        if (matcher.find() == false) goto L12;
        return Long.parseLong(matcher.group(1));
    L12:
        return 0;
    }

    public static List<IonAllocations> readProcessSystemIonHeapSizesFromDebugfs() {
        return parseProcessIonHeapSizesFromDebugfs(readFile(DEBUG_SYSTEM_ION_HEAP_FILE));
    }

    static List<IonAllocations> parseProcessIonHeapSizesFromDebugfs(String contents) {
        if (contents.isEmpty() == true) goto L5;
        Matcher m = PROCESS_ION_HEAP_SIZE_IN_BYTES.matcher(contents);
        SparseArray<IonAllocations> entries = new SparseArray();
    L8:
        if (m.find() == false) goto L18;
        int pid = Integer.parseInt(m.group(1));     // Catch: NumberFormatException -> L13
        long sizeInBytes = Long.parseLong(m.group(2));     // Catch: NumberFormatException -> L13
        IonAllocations allocations = entries.get(pid);     // Catch: NumberFormatException -> L13
        if (allocations != null) goto L15;
        allocations = new IonAllocations();     // Catch: NumberFormatException -> L13
        entries.put(pid, allocations);     // Catch: NumberFormatException -> L13
    L15:
        allocations.pid = pid;     // Catch: NumberFormatException -> L13
        allocations.totalSizeInBytes += sizeInBytes;     // Catch: NumberFormatException -> L13
        allocations.count++;     // Catch: NumberFormatException -> L13
        allocations.maxSizeInBytes = Math.max(allocations.maxSizeInBytes, sizeInBytes);     // Catch: NumberFormatException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "Failed to parse value", e);
        goto L8
    L18:
        List<IonAllocations> result = new ArrayList(entries.size());
        int i = 0;
    L20:
        if (i >= entries.size()) goto L23;
        result.add(entries.valueAt(i));
        i = i + 1;
        goto L20
    L23:
        return result;
    L5:
        return Collections.emptyList();
    }

    private static String readFile(String path) {
        File file = new File(path);     // Catch: IOException -> L4
        return FileUtils.readTextFile(file, 0, null);
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to read file", e);
        return "";
    }
}
