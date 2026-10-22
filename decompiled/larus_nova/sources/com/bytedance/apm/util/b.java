package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f190639a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f190640b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f190641c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f190642d = -1;

    public static long i() {
        BufferedReader r100 = null;
        BufferedReader r101 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/stat")), 1000);     // Catch: Throwable -> L10
        String r102 = r101.readLine();     // Catch: Throwable -> L7
        r101.close();     // Catch: Throwable -> L7
        String[] r103 = r102.split(" ");     // Catch: Throwable -> L7
        long r104 = (((((Long.parseLong(r103[2]) + Long.parseLong(r103[3])) + Long.parseLong(r103[4])) + Long.parseLong(r103[6])) + Long.parseLong(r103[5])) + Long.parseLong(r103[7])) + Long.parseLong(r103[8]);
        d27.d.a(r101);
        return r104;
    L7:
        r100 = r101;
    L8:
        d27.d.a(r100);
        return -1;
    }

    public static long k() {
        int r100 = 0;
        String[] r101 = g(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split("\n");     // Catch: Exception -> L20
        int r102 = r101.length;     // Catch: Exception -> L20
    L5:
        if (r100 >= r102) goto L14;
        String r103 = r101[r100];     // Catch: Exception -> L20
        if (r103.startsWith("VmSize") == false) goto L12;
        Matcher r104 = PatternProtector.compile("\\d+").matcher(r103);     // Catch: Exception -> L20
        if (r104.find() == false) goto L12;
        return CastLongProtector.parseLong(r104.group());
    L12:
        r100 = r100 + 1;     // Catch: Exception -> L20
        goto L5
    L14:
        if (r101.length <= 12) goto L19;
        Matcher r105 = PatternProtector.compile("\\d+").matcher(r101[12]);     // Catch: Exception -> L20
        if (r105.find() == false) goto L19;
        return CastLongProtector.parseLong(r105.group());
    L19:
        return -1;
    }

    public static synchronized int b() {
        monitor-enter(b.class);
        int r100 = f190639a;     // Catch: Throwable -> L27
        if (r100 == 0) goto L37;
        monitor-exit(b.class);
        return r100;
    L37:
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"), 50);     // Catch: Throwable -> L19
        int r102 = 0;
    L31:
        String r103 = r101.readLine();     // Catch: Throwable -> L17
        if (r103 == null) goto L16;
        if (r103.startsWith("processor") == false) goto L31;
        r102 = r102 + 1;
        goto L31
    L16:
        r101.close();     // Catch: Throwable -> L30
        f190639a = r102;     // Catch: Throwable -> L30
    L17:
        Throwable th10 = th;
    L21:
        if (r101 == null) goto L43;
        r101.close();     // Catch: Throwable -> L30
        throw th10;     // Catch: Throwable -> L30
    L43:
        throw th10;     // Catch: Throwable -> L30
    L19:
        th = move-exception;
        r101 = null;
        th10 = th;
    L24:
        int r104 = f190639a;     // Catch: Throwable -> L27
        monitor-exit(b.class);
        return r104;
    L27:
        th = move-exception;
        throw th;
    }

    public static long f() {
        if (f190640b != (-1)) goto L10;
        long r100 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r100 > 0) goto L8;
        r100 = 100;
    L8:
        f190640b = r100;
    L10:
        return f190640b;
    }

    public static long a() {
        return d(Process.myPid());
    }

    public static long j() {
        int r100 = b();
        long r101 = -1;
        if (r100 > 0) goto L5;
        return -1;
    L5:
        int r102 = 0;
    L6:
        if (r102 >= r100) goto L26;
        BufferedReader r103 = null;
        BufferedReader r104 = new BufferedReader(new PolarisFileReaderWrapper("/sys/devices/system/cpu/cpu" + r102 + "/cpufreq/stats/time_in_state"), 50);     // Catch: Throwable -> L22
    L30:
        String r105 = r104.readLine();     // Catch: Throwable -> L20
        if (r105 != null) goto L12;
    L28:
        r104.close();     // Catch: Throwable -> L27
        r102 = r102 + 1;     // Catch: Throwable -> L27
        goto L6
    L12:
        if (r105.isEmpty() == true) goto L28;
        String[] r106 = r105.split("\\s+");     // Catch: Throwable -> L20
        if (r106.length != 2) goto L30;
        r101 = r101 + Long.parseLong(r106[1]);
    L20:
        th = th;
        r103 = r104;
    L23:
        if (r103 == null) goto L25;
        r103.close();     // Catch: Throwable -> L27
    L25:
        throw th;     // Catch: Throwable -> L27
    L22:
        th = th;
    L26:
        return r101;
    }

    public static long c(File r100) {
        File[] r101 = r100.listFiles();
        long r102 = 0;
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L12;
        File r105 = r101[r104];
        if (r105.isDirectory() == false) goto L10;
        long r106 = c(r105);
    L11:
        r102 = r102 + r106;
        r104 = r104 + 1;
        goto L6
    L10:
        r106 = r105.length();
        goto L11
    L12:
        return r102;
    }

    public static long d(int r100) {
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + r100 + "/stat")), 1000);     // Catch: Throwable -> L10
        String r103 = r102.readLine();     // Catch: Throwable -> L7
        r102.close();     // Catch: Throwable -> L7
        String[] r104 = r103.split(" ");     // Catch: Throwable -> L7
        long r105 = ((Long.parseLong(r104[13]) + Long.parseLong(r104[14])) + Long.parseLong(r104[15])) + Long.parseLong(r104[16]);
        d27.d.a(r102);
        return r105;
    L7:
        r101 = r102;
    L8:
        d27.d.a(r101);
        return -1;
    }

    public static String g(String r100) throws Exception {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        BufferedReader r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L21
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L13
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r103));     // Catch: Throwable -> L17
    L29:
        String r106 = r105.readLine();     // Catch: Throwable -> L15
        if (r106 == null) goto L10;
        r104.append(r106);     // Catch: Throwable -> L15
        r104.append('\n');     // Catch: Throwable -> L15
        goto L29
    L10:
        r105.close();     // Catch: Throwable -> L13
        String r107 = r104.toString();     // Catch: Throwable -> L13
        r103.close();
        return r107;
    L15:
        th = move-exception;
        th = th;
        r102 = r105;
    L18:
        if (r102 == null) goto L20;
        r102.close();     // Catch: Throwable -> L13
    L20:
        throw th;     // Catch: Throwable -> L13
    L17:
        th = th;
    L13:
        Throwable th10 = th;
    L23:
        if (r103 == null) goto L25;
        r103.close();
    L25:
        throw th10;
    L21:
        th = move-exception;
        r103 = null;
        th10 = th;
        goto L23
    }

    public static Debug.MemoryInfo e(int r100, Context r101) {
        if (r101 != null) goto L11;
        return null;
    L11:
        ActivityManager r102 = (ActivityManager) r101.getSystemService("activity");     // Catch: Exception -> L10
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getProcessMemoryInfo(new int[]{r100})[0];
    L10:
        return null;
    }

    public static LinkedList<t> h(int r210, boolean r211, long r212) {
        File[] r100 = new PolarisFileWrapper("/proc/" + r210 + "/task/").listFiles();
        LinkedList<t> r101 = new LinkedList();
        int r102 = r100.length;
        BufferedReader r103 = null;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L32;
        BufferedReader r110 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r100[r104].getPath() + "/stat")), 1000);     // Catch: Throwable -> L25 Exception -> L33 FileNotFoundException -> L30
        String r105 = r110.readLine();     // Catch: Throwable -> L22 Exception -> L24
        int r106 = r105.lastIndexOf(41);     // Catch: Throwable -> L22 Exception -> L24
        String r111 = r105.substring(0, r106);     // Catch: Throwable -> L22 Exception -> L24
        String r107 = r105.substring(r106 + 4);     // Catch: Throwable -> L22 Exception -> L24
        int r108 = r111.indexOf(40);     // Catch: Throwable -> L22 Exception -> L24
        int r112 = Integer.valueOf(r111.substring(0, r108 - 1)).intValue();     // Catch: Throwable -> L22 Exception -> L24
        String r113 = r111.substring(r108 + 1);     // Catch: Throwable -> L22 Exception -> L24
        String[] r109 = r107.split(" ");     // Catch: Throwable -> L22 Exception -> L24
        long r114 = Long.parseLong(r109[10]);     // Catch: Throwable -> L22 Exception -> L24
        long r115 = Long.parseLong(r109[11]);     // Catch: Throwable -> L22 Exception -> L24
        long r213 = Long.parseLong(r109[18]);     // Catch: Throwable -> L22 Exception -> L24
        if (r211 == true) goto L9;
    L21:
        d27.d.a(r110);
        r103 = r110;
    L31:
        r104 = r104 + 1;
        goto L3
    L9:
        if ((r114 + r115) <= 0) goto L21;
        t r116 = new t(r112, r113, r114, r115, r213);     // Catch: Throwable -> L22 Exception -> L24
        if (r112 == Process.myPid()) goto L13;
    L20:
        r101.add(r116);     // Catch: Throwable -> L22 Exception -> L24
        goto L21
    L13:
        if (r212 <= 0) goto L20;
        if (r116.f190690g <= (2 * r212)) goto L20;
        if (com.bytedance.apm.d.j() == false) goto L19;
        ps3.b.a(new String[]{"origin thread starttime error:" + r116.f190690g + " new:" + r212});     // Catch: Throwable -> L22 Exception -> L24
    L19:
        r116.f190690g = r212;     // Catch: Throwable -> L22 Exception -> L24
        r116.f190687d = (r116.f190686c * 1.0f) / r212;     // Catch: Throwable -> L22 Exception -> L24
        goto L20
    L24:
        r103 = r110;
    L22:
        th = th;
        r103 = r110;
    L26:
        d27.d.a(r103);
        throw th;
    L30:
        d27.d.a(r103);
    L25:
        th = th;
    L28:
        d27.d.a(r103);
        return null;
    L32:
        return r101;
    }
}
