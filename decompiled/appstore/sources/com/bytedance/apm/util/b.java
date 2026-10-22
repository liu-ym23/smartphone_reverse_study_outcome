package com.bytedance.apm.util;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f6626a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f6627b = -1;

    static {
    }

    public static long a() {
        return g(Process.myPid());
    }

    public static synchronized int b() {
        monitor-enter(b.class);
        int r10 = f6626a;     // Catch: Throwable -> L27
        if (r10 == 0) goto L37;
        monitor-exit(b.class);
        return r10;
    L37:
        BufferedReader r11 = new BufferedReader(new FileReader("/proc/cpuinfo"), 50);     // Catch: Throwable -> L19
        int r12 = 0;
    L35:
        String r13 = r11.readLine();     // Catch: Throwable -> L16
        if (r13 == null) goto L18;
        if (r13.startsWith("processor") == false) goto L35;
        r12 = r12 + 1;
        goto L35
    L18:
        r11.close();     // Catch: Throwable -> L30
        f6626a = r12;     // Catch: Throwable -> L30
    L16:
        Throwable th = th;
    L21:
        if (r11 == null) goto L23;
        r11.close();     // Catch: Throwable -> L30
    L23:
        throw th;     // Catch: Throwable -> L30
    L19:
        th = move-exception;
        r11 = null;
        th = th;
    L24:
        int r14 = f6626a;     // Catch: Throwable -> L27
        monitor-exit(b.class);
        return r14;
    L27:
        th = move-exception;
        throw th;
    }

    public static long c() {
        File r10 = Environment.getRootDirectory();
        return d() + f(r10);
    }

    public static long d() {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L6;
        return f(f.a(w0.c.g()));
    L6:
        return 0;
    L11:
        return 0;
    }

    public static long e(File r10) {
        File[] r11 = r10.listFiles();
        long r12 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r13 = r11.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L13;
        File r15 = r11[r14];
        if (r15.isDirectory() == false) goto L11;
        long r16 = e(r15);
    L10:
        r12 = r12 + r16;
        r14 = r14 + 1;
        goto L6
    L11:
        r16 = r15.length();
        goto L10
    L13:
        return r12;
    }

    public static long f(File r10) {
        return new StatFs(r10.getPath()).getTotalBytes();
    L4:
        return 0;
    }

    public static long g(int r10) {
        BufferedReader r11 = null;
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + r10 + "/stat")), 1000);     // Catch: Throwable -> L10
        String r13 = r12.readLine();     // Catch: Throwable -> L7
        r12.close();     // Catch: Throwable -> L7
        String[] r14 = r13.split(" ");     // Catch: Throwable -> L7
        long r15 = ((Long.parseLong(r14[13]) + Long.parseLong(r14[14])) + Long.parseLong(r14[15])) + Long.parseLong(r14[16]);
        i5.d.b(r12);
        return r15;
    L7:
        r11 = r12;
    L8:
        i5.d.b(r11);
        return -1;
    }

    public static long h(long r10) {
        if (f6627b != (-1)) goto L9;
        long r11 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r11 <= 0) goto L7;
        r10 = r11;
    L7:
        f6627b = r10;
    L9:
        return f6627b;
    }

    public static long i() {
        int r10 = b();
        long r11 = -1;
        if (r10 > 0) goto L5;
        return -1;
    L5:
        int r12 = 0;
    L6:
        if (r12 >= r10) goto L26;
        BufferedReader r13 = null;
        BufferedReader r14 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + r12 + "/cpufreq/stats/time_in_state"), 50);     // Catch: Throwable -> L22
    L30:
        String r15 = r14.readLine();     // Catch: Throwable -> L19
        if (r15 != null) goto L12;
    L28:
        r14.close();     // Catch: Throwable -> L27
        r12 = r12 + 1;     // Catch: Throwable -> L27
        goto L6
    L12:
        if (r15.isEmpty() == true) goto L28;
        String[] r16 = r15.split("\\s+");     // Catch: Throwable -> L19
        if (r16.length != 2) goto L30;
        r11 = r11 + Long.parseLong(r16[1]);
    L19:
        th = th;
        r13 = r14;
    L23:
        if (r13 == null) goto L25;
        r13.close();     // Catch: Throwable -> L27
    L25:
        throw th;     // Catch: Throwable -> L27
    L22:
        th = th;
    L26:
        return r11;
    }

    public static long j(Context r10) {
        if (r10 != null) goto L18;
        return -1;
    L18:
    L17:
        return -1;
    L6:
        if (TextUtils.isEmpty(r10.getPackageName()) == false) goto L8;
        return -1;
    L8:
        File r11 = r10.getCacheDir();     // Catch: Throwable -> L17
        long r12 = 0;
        if (r11.exists() == false) goto L11;
        long r13 = e(r11);     // Catch: Throwable -> L17
    L12:
        File r14 = w0.c.g().getExternalCacheDir();     // Catch: Throwable -> L17
        if (r14.exists() == false) goto L16;
        r12 = e(r14);     // Catch: Throwable -> L17
    L16:
        return r13 + r12;
    L11:
        r13 = 0;
        goto L12
    }

    public static long k(Context r10) {
        if (r10 != null) goto L19;
        return -1;
    L19:
        File r11 = new File(r10.getFilesDir().getParent());     // Catch: Throwable -> L18
        if (r11.exists() == true) goto L8;
        return -1;
    L8:
        long r12 = e(r11);     // Catch: Throwable -> L18
        File r13 = r10.getExternalFilesDir(null);     // Catch: Throwable -> L18
        if (r13 == null) goto L17;
        File r14 = r13.getParentFile();     // Catch: Throwable -> L18
        if (r14.exists() == false) goto L14;
        long r15 = e(r14);     // Catch: Throwable -> L18
    L16:
        return r12 + r15;
    L14:
        r15 = 0;
    L17:
        return -1;
    }
}
