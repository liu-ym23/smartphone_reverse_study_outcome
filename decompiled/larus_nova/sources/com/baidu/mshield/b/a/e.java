package com.baidu.mshield.b.a;

import android.os.Build;
import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public class e {
    public static String a() {
        String[] r100 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L7
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L7
        int r102 = r100.length;     // Catch: Throwable -> L7
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.append(r100[r103]);     // Catch: Throwable -> L7
        r101.append(',');     // Catch: Throwable -> L7
        r103 = r103 + 1;     // Catch: Throwable -> L7
        goto L3
    L5:
        String r104 = r101.toString();     // Catch: Throwable -> L7
        return r104.substring(0, r104.length() - 1);
    L7:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return "";
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT <= 22) goto L58;
        return Process.is64Bit();
    L58:
    L46:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
    L48:
        return false;
    L9:
        PolarisFileWrapper r100 = new PolarisFileWrapper("/proc/" + Process.myPid() + "/maps");     // Catch: Throwable -> L46
        if (r100.exists() == true) goto L50;
    L45:
        return false;
    L50:
        if (r100.isDirectory() == true) goto L45;
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L29
    L56:
        String r102 = r101.readLine();     // Catch: Throwable -> L27
        if (r102 == null) goto L25;
        if (r102.contains("/system/lib64/libc.so") == false) goto L56;
        r101.close();     // Catch: IOException -> L21 Throwable -> L46
    L65:
        return true;
    L21:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);     // Catch: Throwable -> L46
        return true;
    L25:
        r101.close();     // Catch: IOException -> L35 Throwable -> L46
    L49:
    L27:
        Throwable th10 = th;
    L61:
        com.baidu.mshield.b.c.a.a(th10);     // Catch: Throwable -> L38
        if (r101 == null) goto L48;
        r101.close();     // Catch: IOException -> L35 Throwable -> L46
        goto L49
    L38:
        th = move-exception;
        if (r101 != null) goto L52;
    L44:
        throw th;     // Catch: Throwable -> L46
    L52:
        r101.close();     // Catch: IOException -> L42 Throwable -> L46
    L42:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);     // Catch: Throwable -> L46
    L29:
        th = move-exception;
        th10 = th;
        r101 = null;
    L35:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);     // Catch: Throwable -> L46
        goto L48
    }

    public static int b() {
        return Runtime.getRuntime().availableProcessors();
    L4:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return 0;
    }
}
