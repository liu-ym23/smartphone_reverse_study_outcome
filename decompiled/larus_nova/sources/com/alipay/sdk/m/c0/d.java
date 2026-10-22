package com.alipay.sdk.m.c0;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25264a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f25265b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f25266c = "";

    public static synchronized void a(String r100) {
        monitor-enter(d.class);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L7
        r101.add(r100);     // Catch: Throwable -> L7
        a(r101);     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(String r100, String r101, String r102) {
        monitor-enter(d.class);
        f25264a = r100;     // Catch: Throwable -> L7
        f25265b = r101;     // Catch: Throwable -> L7
        f25266c = r102;     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(Throwable r100) {
        monitor-enter(d.class);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L11
        if (r100 == null) goto L7;
        StringWriter r102 = new StringWriter();     // Catch: Throwable -> L11
        r100.printStackTrace(new PrintWriter(r102));     // Catch: Throwable -> L11
        String r103 = r102.toString();     // Catch: Throwable -> L11
    L8:
        r101.add(r103);     // Catch: Throwable -> L11
        a(r101);     // Catch: Throwable -> L11
        monitor-exit(d.class);
        return;
    L7:
        r103 = "";
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(List<String> r100) {
        monitor-enter(d.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (com.alipay.sdk.m.z.a.a(f25265b) == false) goto L7;
    L29:
        monitor-exit(d.class);
        return;
    L7:
        if (com.alipay.sdk.m.z.a.a(f25266c) == true) goto L29;
        StringBuffer r101 = new StringBuffer();     // Catch: Throwable -> L31
        r101.append(f25266c);     // Catch: Throwable -> L31
        Iterator<String> r102 = r100.iterator();     // Catch: Throwable -> L31
    L11:
        if (r102.hasNext() == false) goto L13;
        r101.append(", " + r102.next());     // Catch: Throwable -> L31
        goto L11
    L13:
        r101.append("\n");     // Catch: Throwable -> L31
        PolarisFileWrapper r103 = new PolarisFileWrapper(f25264a);     // Catch: Exception -> L27 Throwable -> L31
        if (r103.exists() == true) goto L17;
        r103.mkdirs();     // Catch: Exception -> L27 Throwable -> L31
    L17:
        PolarisFileWrapper r104 = new PolarisFileWrapper(f25264a, f25265b);     // Catch: Exception -> L27 Throwable -> L31
        if (r104.exists() == true) goto L21;
        r104.createNewFile();     // Catch: Exception -> L27 Throwable -> L31
    L21:
        if ((((long) r101.length()) + r104.length()) > 51200) goto L23;
        PolarisFileWriterWrapper r105 = new PolarisFileWriterWrapper(r104, true);     // Catch: Exception -> L27 Throwable -> L31
    L24:
        r105.write(r101.toString());     // Catch: Exception -> L27 Throwable -> L31
        r105.flush();     // Catch: Exception -> L27 Throwable -> L31
        r105.close();     // Catch: Exception -> L27 Throwable -> L31
        monitor-exit(d.class);
        return;
        goto L28
    L23:
        r105 = new PolarisFileWriterWrapper(r104);     // Catch: Exception -> L27 Throwable -> L31
    }
}
