package com.byted.cast.common.performance;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import com.byted.cast.common.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import tb2.c;

/* JADX INFO: loaded from: classes39.dex */
public class CrashUtil {
    static final String TAG = "CrashUtil";
    static final String anrCrashType = "anr";
    static final String anrLogSuffix = ".anr.xcrash";
    static final String fullVersion = "xCrash 3.0.0";
    static final String javaCrashType = "java";
    static final String javaLogSuffix = ".java.xcrash";
    static final String logPrefix = "tombstone";
    private static final String memInfoFmt = "%21s %8s\n";
    private static final String memInfoFmt2 = "%21s %8s %21s %8s\n";
    static final String nativeCrashType = "native";
    static final String nativeLogSuffix = ".native.xcrash";
    static final String sepHead = "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***";
    static final String sepOtherThreads = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    static final String sepOtherThreadsEnding = "+++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++";
    private static final String[] suPathname = null;
    static final String timeFormatterStr = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    static final String traceLogSuffix = ".trace.xcrash";
    static final String version = "3.0.0";

    public static boolean isRoot() {
        String[] r100 = suPathname;     // Catch: Exception -> L11
        int r101 = r100.length;     // Catch: Exception -> L11
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L10;
        if (new PolarisFileWrapper(r100[r102]).exists() == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    static {
        suPathname = new String[]{"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
    }

    public static String getAbiList() {
        return TextUtils.join(",", Build.SUPPORTED_ABIS);
    }

    public static String getFds() {
        StringBuilder r100 = new StringBuilder("open files:\n");
        File[] r101 = new PolarisFileWrapper("/proc/self/fd").listFiles(new AnonymousClass1());     // Catch: Exception -> L26
        if (r101 == null) goto L24;
        int r102 = r101.length;     // Catch: Exception -> L26
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r102) goto L21;
        File r105 = r101[r103];     // Catch: Exception -> L26
        String r106 = Os.readlink(r105.getAbsolutePath());     // Catch: Exception -> L11
    L12:
        r100.append("    fd ");     // Catch: Exception -> L26
        r100.append(r105.getName());     // Catch: Exception -> L26
        r100.append(": ");     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r106) == false) goto L15;
        String r107 = "???";
    L16:
        r100.append(r107);     // Catch: Exception -> L26
        r100.append('\n');     // Catch: Exception -> L26
        r104 = r104 + 1;     // Catch: Exception -> L26
        if (r104 > 1024) goto L21;
        r103 = r103 + 1;     // Catch: Exception -> L26
        goto L7
    L15:
        r107 = r106.trim();     // Catch: Exception -> L26
    L11:
        r106 = null;
    L21:
        if (r101.length <= 1024) goto L23;
        r100.append("    ......\n");     // Catch: Exception -> L26
    L23:
        r100.append("    (number of FDs: ");     // Catch: Exception -> L26
        r100.append(r101.length);     // Catch: Exception -> L26
        r100.append(")\n");     // Catch: Exception -> L26
    L24:
        r100.append('\n');
        return r100.toString();
    }

    public static String getMemoryInfo() {
        return "memory info:\n System Summary (From: /proc/meminfo)\n" + getFileContent("/proc/meminfo") + "-\n Process Status (From: /proc/PID/status)\n" + getFileContent("/proc/self/status") + "-\n Process Limits (From: /proc/PID/limits)\n" + getFileContent("/proc/self/limits") + "-\n" + getProcessMemoryInfo() + "\n";
    }

    public static String getNetworkInfo() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return "network info:\nNot supported on Android Q (API level 29) and later.\n\n";
    L7:
        return "network info:\n TCP over IPv4 (From: /proc/PID/net/tcp)\n" + getFileContent("/proc/self/net/tcp", 1024) + "-\n TCP over IPv6 (From: /proc/PID/net/tcp6)\n" + getFileContent("/proc/self/net/tcp6", 1024) + "-\n UDP over IPv4 (From: /proc/PID/net/udp)\n" + getFileContent("/proc/self/net/udp", 1024) + "-\n UDP over IPv6 (From: /proc/PID/net/udp6)\n" + getFileContent("/proc/self/net/udp6", 1024) + "-\n ICMP in IPv4 (From: /proc/PID/net/icmp)\n" + getFileContent("/proc/self/net/icmp", 256) + "-\n ICMP in IPv6 (From: /proc/PID/net/icmp6)\n" + getFileContent("/proc/self/net/icmp6", 256) + "-\n UNIX domain (From: /proc/PID/net/unix)\n" + getFileContent("/proc/self/net/unix", 256) + "\n";
    }

    public static String getProcessMemoryInfo() {
        StringBuilder r100 = new StringBuilder(" Process Summary (From: android.os.Debug.MemoryInfo)\n");
        Locale r101 = Locale.US;
        r100.append(String.format(r101, memInfoFmt, new Object[]{"", "Pss(KB)"}));
        r100.append(String.format(r101, memInfoFmt, new Object[]{"", "------"}));
        Debug.MemoryInfo r102 = new Debug.MemoryInfo();     // Catch: Exception -> L9
        Debug.getMemoryInfo(r102);     // Catch: Exception -> L9
        if (Build.VERSION.SDK_INT < 23) goto L7;
        r100.append(String.format(r101, memInfoFmt, new Object[]{"Java Heap:", r102.getMemoryStat("summary.java-heap")}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"Native Heap:", r102.getMemoryStat("summary.native-heap")}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"Code:", r102.getMemoryStat("summary.code")}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"Stack:", r102.getMemoryStat("summary.stack")}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"Graphics:", r102.getMemoryStat("summary.graphics")}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"Private Other:", r102.getMemoryStat("summary.private-other")}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"System:", r102.getMemoryStat("summary.system")}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt2, new Object[]{"TOTAL:", r102.getMemoryStat("summary.total-pss"), "TOTAL SWAP:", r102.getMemoryStat("summary.total-swap")}));     // Catch: Exception -> L9
    L13:
    L12:
        return r100.toString();
    L7:
        r100.append(String.format(r101, memInfoFmt, new Object[]{"Java Heap:", "~ " + r102.dalvikPrivateDirty}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"Native Heap:", String.valueOf(r102.nativePrivateDirty)}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"Private Other:", "~ " + r102.otherPrivateDirty}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"System:", String.valueOf((r102.getTotalPss() - r102.getTotalPrivateDirty()) - r102.getTotalPrivateClean())}));     // Catch: Exception -> L9
        r100.append(String.format(r101, memInfoFmt, new Object[]{"TOTAL:", String.valueOf(r102.getTotalPss())}));     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Logger.e(TAG, "Util getProcessMemoryInfo failed", e);
        goto L12
    }

    private CrashUtil() {
    }

    public static boolean checkAndCreateDir(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L12;
        r101.mkdirs();     // Catch: Exception -> L13
        if (r101.exists() == true) goto L8;
        return false;
    L8:
        if (r101.isDirectory() == false) goto L16;
        return true;
    L16:
        return false;
    L12:
        return r101.isDirectory();
    L17:
        return false;
    }

    public static String getAppVersion(Context r100) {
        String r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;     // Catch: Exception -> L4
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return "unknown";
    L11:
        return r101;
    L4:
        r101 = null;
        goto L6
    }

    private static String getFileContent(String r100) {
        return getFileContent(r100, 0);
    }

    public static boolean checkProcessAnrState(Context r100, long r101) {
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");
        if (r102 != null) goto L5;
        return false;
    L5:
        int r103 = Process.myPid();
        long r104 = r101 / 500;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L21;
        List<ActivityManager.ProcessErrorStateInfo> r106 = r102.getProcessesInErrorState();
        if (r106 == null) goto L23;
        Iterator<ActivityManager.ProcessErrorStateInfo> r107 = r106.iterator();
    L12:
        if (r107.hasNext() == false) goto L23;
        ActivityManager.ProcessErrorStateInfo r108 = r107.next();
        if (r108.pid != r103) goto L12;
        if (r108.condition != 2) goto L12;
        return true;
    L23:
        Thread.sleep(500);     // Catch: Exception -> L22
    L20:
        r105 = r105 + 1;
        goto L7
    L21:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7 */
    private static String getFileContent(String r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        ?? r103 = 0;
        BufferedReader r104 = null;
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L22 Exception -> L24
        int r106 = 0;
    L44:
        String r107 = r105.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r107 == null) goto L13;
        String r108 = r107.trim();     // Catch: Throwable -> L18 Exception -> L20
        if (r108.length() <= 0) goto L44;
        r106 = r106 + 1;     // Catch: Throwable -> L18 Exception -> L20
        if (r101 == 0) goto L12;
        if (r106 > r101) goto L44;
    L12:
        r102.append(c.DEFAULT_TEXT);     // Catch: Throwable -> L18 Exception -> L20
        r102.append(r108);     // Catch: Throwable -> L18 Exception -> L20
        r102.append("\n");     // Catch: Throwable -> L18 Exception -> L20
        goto L44
    L13:
        if (r101 <= 0) goto L16;
        if (r106 <= r101) goto L16;
        r102.append("  ......\n");     // Catch: Throwable -> L18 Exception -> L20
        r102.append("  (number of records: ");     // Catch: Throwable -> L18 Exception -> L20
        r102.append(r106);     // Catch: Throwable -> L18 Exception -> L20
        r102.append(")\n");     // Catch: Throwable -> L18 Exception -> L20
    L16:
        r105.close();     // Catch: Exception -> L33
        r103 = r106;
    L35:
    L20:
        e = e;
        r104 = r105;
    L25:
        Logger.e(TAG, "Util getInfo(" + r100 + ") failed", e);     // Catch: Throwable -> L22
        r103 = r104;
        if (r104 == null) goto L35;
        r104.close();     // Catch: Exception -> L33
        r103 = r104;
    L18:
        th = th;
        r103 = r105;
    L30:
        if (r103 != 0) goto L42;
    L32:
        throw th;
    L42:
        r103.close();     // Catch: Exception -> L34
    L22:
        th = th;
    L24:
        e = e;
    L29:
        return r102.toString();
    }

    public static String getProcessName(Context r100, int r101) {
        BufferedReader r102 = null;
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r101 + "/cmdline"));     // Catch: Throwable -> L14 Exception -> L18
        String r104 = r103.readLine();     // Catch: Throwable -> L12 Exception -> L25
        if (TextUtils.isEmpty(r104) == true) goto L26;
        String r105 = r104.trim();     // Catch: Throwable -> L12 Exception -> L25
        if (TextUtils.isEmpty(r105) == true) goto L26;
        r103.close();     // Catch: Exception -> L22
    L9:
        return r105;
    L26:
        r103.close();     // Catch: Exception -> L23
    L21:
        return null;
    L12:
        th = th;
        r102 = r103;
    L15:
        if (r102 != null) goto L30;
    L17:
        throw th;
    L30:
        r102.close();     // Catch: Exception -> L24
    L19:
        if (r103 == null) goto L21;
    L18:
        r103 = null;
    L14:
        th = th;
        goto L15
    }

    public static String getLogHeader(Date r100, Date r101, String r102, String r103, String r104) {
        SimpleDateFormat r105 = new SimpleDateFormat(timeFormatterStr, Locale.US);
        StringBuilder r106 = new StringBuilder("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\nTombstone maker: 'xCrash 3.0.0'\nCrash type: '");
        r106.append(r102);
        r106.append("'\nStart time: '");
        r106.append(r105.format(r100));
        r106.append("'\nCrash time: '");
        r106.append(r105.format(r101));
        r106.append("'\nApp ID: '");
        r106.append(r103);
        r106.append("'\nApp version: '");
        r106.append(r104);
        r106.append("'\nRooted: '");
        if (isRoot() == false) goto L5;
        String r107 = "Yes";
    L6:
        r106.append(r107);
        r106.append("'\nAPI level: '");
        r106.append(Build.VERSION.SDK_INT);
        r106.append("'\nOS version: '");
        r106.append(Build.VERSION.RELEASE);
        r106.append("'\nABI list: '");
        r106.append(getAbiList());
        r106.append("'\nManufacturer: '");
        r106.append(Build.MANUFACTURER);
        r106.append("'\nBrand: '");
        r106.append(Build.BRAND);
        r106.append("'\nModel: '");
        r106.append(Build.MODEL);
        r106.append("'\nBuild fingerprint: '");
        r106.append(Build.FINGERPRINT);
        r106.append("'\n");
        return r106.toString();
    L5:
        r107 = "No";
        goto L6
    }
}
