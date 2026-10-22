package com.monitor.cloudmessage.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.apm.util.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static String[] a() {
        String[] r10 = {"", ""};
        BufferedReader r11 = null;
        FileReader r12 = new FileReader("/proc/cpuinfo");     // Catch: Throwable -> L17 IOException -> L19
    L29:
        BufferedReader r13 = new BufferedReader(r12, 8192);     // Catch: Throwable -> L15 IOException -> L24
        String[] r14 = r13.readLine().split("\\s+");     // Catch: Throwable -> L9 IOException -> L11
        int r15 = 2;
    L7:
        if (r15 >= r14.length) goto L12;
        r10[0] = r10[0] + r14[r15] + " ";     // Catch: Throwable -> L9 IOException -> L11
        r15 = r15 + 1;     // Catch: Throwable -> L9 IOException -> L11
        goto L7
    L12:
        r10[1] = r10[1] + r13.readLine().split("\\s+")[2];     // Catch: Throwable -> L9 IOException -> L11
        r3.d.a(r13);
    L14:
        r3.d.a(r12);
        return r10;
    L11:
        r11 = r13;
    L9:
        th = th;
        r11 = r13;
    L20:
        r3.d.a(r11);
        r3.d.a(r12);
        throw th;
    L15:
        th = th;
    L22:
        r3.d.a(r11);
    L19:
        r12 = null;
    L17:
        th = th;
        r12 = null;
        goto L20
    }

    public static long[] b() {
        long[] r10 = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L8;
        File r11 = f.a(w0.c.g());
        if (r11 != null) goto L7;
        return r10;
    L7:
        StatFs r12 = new StatFs(r11.getPath());
        long r13 = r12.getBlockSize();
        long r14 = r12.getBlockCount();
        long r15 = r12.getAvailableBlocks();
        r10[0] = ((r14 * r13) / 1024) / 1024;
        r10[1] = ((r13 * r15) / 1024) / 1024;
    L8:
        return r10;
    }

    public static long c() {
        return (Runtime.getRuntime().maxMemory() / 1024) / 1024;
    }

    public static long d() {
        return (Runtime.getRuntime().totalMemory() / 1024) / 1024;
    }

    public static String[] e() {
        String[] r10 = {"null", "null", "null", "null"};
        BufferedReader r11 = null;
        FileReader r12 = new FileReader("/proc/version");     // Catch: Throwable -> L13 IOException -> L15
        BufferedReader r13 = new BufferedReader(r12, 8192);     // Catch: Throwable -> L11 IOException -> L21
        r10[0] = r13.readLine().split("\\s+")[2];     // Catch: Throwable -> L8 IOException -> L10
        r3.d.a(r13);
    L7:
        r3.d.a(r12);
        r10[1] = Build.VERSION.RELEASE;
        r10[2] = Build.MODEL;
        r10[3] = Build.DISPLAY;
        return r10;
    L10:
        r11 = r13;
    L8:
        th = th;
        r11 = r13;
    L16:
        r3.d.a(r11);
        r3.d.a(r12);
        throw th;
    L11:
        th = th;
    L18:
        r3.d.a(r11);
        goto L7
    L15:
        r12 = null;
    L13:
        th = th;
        r12 = null;
        goto L16
    }
}
