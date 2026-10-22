package com.baidu.bbalbscesium.o;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f30418a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f30419b = "Util";

    private c() {
    }

    public static String a(File r100) {
        PolarisFileReaderWrapper r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r100);     // Catch: Throwable -> L17 Exception -> L19
    L36:
        char[] r103 = new char[8192];     // Catch: Exception -> L15 Throwable -> L28
        CharArrayWriter r104 = new CharArrayWriter();     // Catch: Exception -> L15 Throwable -> L28
    L6:
        int r105 = r102.read(r103);     // Catch: Exception -> L15 Throwable -> L28
        if (r105 <= 0) goto L9;
        r104.write(r103, 0, r105);     // Catch: Exception -> L15 Throwable -> L28
        goto L6
    L9:
        String r106 = r104.toString();     // Catch: Exception -> L15 Throwable -> L28
        r102.close();     // Catch: Exception -> L12
    L14:
        return r106;
    L12:
        e = move-exception;
        a(e);
    L15:
        e = e;
    L21:
        a(e);     // Catch: Throwable -> L28
        if (r102 != null) goto L38;
    L27:
        return null;
    L38:
        r102.close();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        a(e);
    L28:
        th = th;
        r101 = r102;
    L30:
        if (r101 != null) goto L41;
    L35:
        throw th;
    L41:
        r101.close();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        a(e);
    L19:
        e = e;
        r102 = null;
    L17:
        th = th;
        goto L30
    }

    public static String a(byte[] r100, String r101, boolean r102) {
        return com.baidu.bbalbscesium.m.c.a(r100, r101, r102);
    }

    public static String a(byte[] r100, boolean r101) {
        return com.baidu.bbalbscesium.m.c.a(r100, r101);
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        a(e);
        return;
    }

    public static void a(Throwable r100) {
    }

    public static boolean a(Context r100, String r101) {
        Iterator<ActivityManager.RunningServiceInfo> r102 = ((ActivityManager) r100.getApplicationContext().getSystemService("activity")).getRunningServices(100).iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        ActivityManager.RunningServiceInfo r103 = r102.next();
        if (r103.pid != Process.myPid()) goto L4;
        if (TextUtils.equals(r103.service.getClassName(), r101) == true) goto L4;
        return true;
    L11:
        return false;
    }
}
