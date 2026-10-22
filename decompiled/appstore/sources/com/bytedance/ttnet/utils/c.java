package com.bytedance.ttnet.utils;

import com.bytedance.common.utility.e;
import com.bytedance.frameworks.baselib.network.http.util.d;
import com.bytedance.retrofit2.f;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    static {
    }

    public static boolean a(String r10, List r11) {
        if (e.b(r10) == false) goto L5;
    L17:
        return false;
    L5:
        if (com.bytedance.common.utility.c.a(r11) == true) goto L17;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L17;
        String r13 = (String) r12.next();
        if (e.b(r13) == true) goto L9;
        if (r10.endsWith(r13) == false) goto L9;
        return true;
    }

    public static String b(Throwable r10) {
        String r11 = null;
        if (r10 != null) goto L29;
        return null;
    L29:
        StringWriter r12 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r13 = new PrintWriter(r12);     // Catch: Throwable -> L15
        r10.printStackTrace(r13);     // Catch: Throwable -> L11
        Throwable r14 = r10.getCause();     // Catch: Throwable -> L11
        if (r14 == null) goto L13;
        r14.printStackTrace(r13);     // Catch: Throwable -> L11
        Throwable r15 = r14.getCause();     // Catch: Throwable -> L11
        if (r15 == null) goto L13;
        r15.printStackTrace(r13);     // Catch: Throwable -> L11
    L13:
        r11 = r12.toString();     // Catch: Throwable -> L11
    L14:
        r13.close();
    L20:
        return r11;
    L11:
        th = th;
    L27:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r13 == null) goto L20;
    L21:
        th = move-exception;
        if (r13 == null) goto L24;
        r13.close();
    L24:
        throw th;
    L15:
        th = th;
        r13 = null;
        goto L27
    }

    public static void c(String r10, List r11) {
        if (e.b(r10) == true) goto L14;
        if (r11 == null) goto L19;
        String[] r12 = r10.split(",");
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L20;
        String r15 = r12[r14];
        if (e.b(r15) == true) goto L13;
        if (a(r15, r11) == true) goto L13;
        r11.add(r15.trim());
    L13:
        r14 = r14 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public static void d(d r10, Interceptor r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.i() <= 0) goto L31;
        Map r12 = r10.e();
        Collection r13 = r12.values();
        monitor-enter(r12);
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L15
    L9:
        if (r14.hasNext() == false) goto L17;
        List r15 = ((f) r14.next()).i();     // Catch: Throwable -> L15
        if (r15 == null) goto L9;
        if (r15.contains(r11) == true) goto L9;
        r15.add(r11);     // Catch: Throwable -> L15
        goto L9
    L17:
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
