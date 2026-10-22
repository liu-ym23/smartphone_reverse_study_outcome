package com.ttnet.org.chromium.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class MemoryUtils {
    private static String TAG = "MemoryUtils";
    private static boolean sInitialized = false;
    private static String sMemoryInfoPath = "/proc/meminfo";
    private static final Object sMemoryLock = null;
    private static String sTotalMemoryGB = "unknown";

    public MemoryUtils() {
    }

    static {
        sMemoryLock = new Object();
    }

    public static boolean initialize() {
        if (sInitialized == false) goto L5;
        return true;
    L5:
        fetchTotalMemory();
        sInitialized = true;
        return true;
    }

    private static void fetchTotalMemory() {
        Pattern r0 = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        BufferedReader r5 = null;
        long r6 = 0;
        FileReader r8 = new FileReader(sMemoryInfoPath);     // Catch: Throwable -> L36 Exception -> L38
        BufferedReader r9 = new BufferedReader(r8);     // Catch: Exception -> L34 Throwable -> L54
    L88:
        String r7 = r9.readLine();     // Catch: Throwable -> L30 Exception -> L32
        if (r7 == null) goto L73;
        Matcher r10 = r0.matcher(r7);     // Catch: Throwable -> L30 Exception -> L32
        if (r10.find() == false) goto L88;
        long r11 = Long.parseLong(r10.group(1));     // Catch: Throwable -> L30 Exception -> L32
    L12:
        if (r11 <= 1024) goto L90;
        r6 = r11;
        goto L73
    L90:
        android.util.Log.w(TAG, "Invalid " + sMemoryInfoPath + " total size in kB: " + r11);     // Catch: Throwable -> L15 Exception -> L17
    L17:
        e = e;
        r5 = r9;
        r6 = r11;
    L40:
        android.util.Log.w(TAG, "Cannot get total physical size from " + sMemoryInfoPath, e);     // Catch: Throwable -> L54
        if (r5 != null) goto L83;
    L43:
        if (r8 == null) goto L45;
        r8.close();     // Catch: Exception -> L69
    L45:
        Object r1 = sMemoryLock;
        monitor-enter(r1);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((r6 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L51
        monitor-exit(r1);     // Catch: Throwable -> L51
        return;
    L51:
        th = move-exception;
        throw th;
    L83:
        r5.close();     // Catch: Exception -> L69
    L15:
        th = th;
        r5 = r9;
        r6 = r11;
    L55:
        if (r5 != null) goto L81;
    L57:
        if (r8 == null) goto L59;
        r8.close();     // Catch: Exception -> L68
    L59:
        Object r12 = sMemoryLock;
        monitor-enter(r12);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((r6 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L65
        monitor-exit(r12);     // Catch: Throwable -> L65
        throw th;
    L65:
        th = move-exception;
        throw th;
    L81:
        r5.close();     // Catch: Exception -> L68
    L73:
        r9.close();     // Catch: Exception -> L70
        r8.close();     // Catch: Exception -> L70
    L21:
        Object r2 = sMemoryLock;
        monitor-enter(r2);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((r6 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L27
        monitor-exit(r2);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        throw th;
    L32:
        e = e;
        r5 = r9;
    L30:
        th = th;
        r5 = r9;
    L34:
        e = e;
    L54:
        th = th;
        goto L55
    L38:
        e = e;
        r8 = null;
    L36:
        th = th;
        r8 = null;
        goto L55
    }

    public static String getTotalMemoryGB() {
        Object r0 = sMemoryLock;
        monitor-enter(r0);
        String r1 = sTotalMemoryGB;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
