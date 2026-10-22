package com.bytedance.apm.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f190637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f190638b;

    public static String a(int r100) {
        if (TextUtils.isEmpty(f190637a) == true) goto L39;
        return f190637a;
    L39:
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r100 + "/cmdline"));     // Catch: Throwable -> L19
        String r102 = r101.readLine();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r102 = r102.trim();     // Catch: Throwable -> L17
    L11:
        f190637a = r102;     // Catch: Throwable -> L17
        r101.close();     // Catch: IOException -> L14
    L16:
        return r102;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
    L37:
        th.printStackTrace();     // Catch: Throwable -> L28
        if (r101 != null) goto L41;
    L27:
        return null;
    L41:
        r101.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        if (r101 != null) goto L45;
    L34:
        throw th;
    L45:
        r101.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r101 = null;
        goto L37
    }

    public static boolean b(Context r100) {
        String r101 = a(Process.myPid());
        if (r101 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.equals(r100.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r101.contains(":") == false) goto L7;
        return false;
    }
}
