package com.apm.lite.j;

import android.text.TextUtils;
import com.apm.lite.k.o;
import com.apm.lite.k.p;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;
import r1.m;
import r1.q;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RunnableC0622a f29921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f29922b;

    /* JADX INFO: renamed from: com.apm.lite.j.a$a, reason: collision with other inner class name */
    public static class RunnableC0622a implements Runnable {
        public RunnableC0622a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = m.a();     // Catch: Throwable -> L13
            RunnableC0622a r101 = a.f29921a;     // Catch: Throwable -> L13
            r100.e(r101);     // Catch: Throwable -> L13
            if (o.b(com.apm.lite.e.f29909a) == false) goto L6;
            a.c();     // Catch: Throwable -> L13
        L6:
            if (a.f29922b > 0) goto L8;
            return;
        L8:
            if (com.apm.lite.k.a.h(com.apm.lite.e.f29909a) == false) goto L10;
            q r102 = m.a();     // Catch: Throwable -> L13
            long r103 = 15000;
        L11:
            r102.b(r101, r103);     // Catch: Throwable -> L13
            return;
        L10:
            r102 = m.a();     // Catch: Throwable -> L13
            r103 = 60000;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    static {
        f29921a = new RunnableC0622a();
        f29922b = 0;
    }

    public static byte[] b() {
        String r100 = com.apm.lite.e.f29913e.getConfigUrl();     // Catch: Throwable -> L15
        ConcurrentLinkedQueue<com.apm.lite.d> r101 = k1.b.f501332a;     // Catch: Throwable -> L15
        JSONArray r102 = new JSONArray();     // Catch: Throwable -> L15
        Iterator<com.apm.lite.d> r103 = k1.b.f501332a.iterator();     // Catch: Throwable -> L15
    L5:
        if (r103.hasNext() == false) goto L9;
        com.apm.lite.d r104 = r103.next();     // Catch: Throwable -> L15
        if (r104 == null) goto L9;
        r102.put(r104.d(true));     // Catch: Throwable -> L15
    L9:
        byte[] r105 = r102.toString().getBytes();     // Catch: Throwable -> L15
        TextUtils.isDigitsOnly(r100);     // Catch: IOException -> L12 Throwable -> L15
    L22:
        return e.c(r100, r105, e.a.f29958b, false).f29986b;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        return null;
    L15:
        com.apm.lite.e.f29913e.isDebugMode();
        return null;
    }

    public static void a() {
        if (j.f29983c == true) goto L6;
        j.b();
    L6:
        if (o.b(com.apm.lite.e.f29909a) == true) goto L8;
        return;
    L8:
        if (j.a() == false) goto L12;
        c();
        return;
    }

    public static synchronized void c() {
        monitor-enter(a.class);
        int r100 = f29922b;     // Catch: Throwable -> L28
        if (r100 <= 0) goto L7;
        f29922b = r100 - 1;     // Catch: Throwable -> L28
    L7:
        p.a("try fetchApmConfig");     // Catch: Throwable -> L28
        if (com.apm.lite.k.a.h(com.apm.lite.e.f29909a) == false) goto L23;
        JSONArray r101 = null;
        byte[] r102 = b();     // Catch: Throwable -> L15
        if (r102 == null) goto L18;
        r101 = new JSONObject(new String(r102)).optJSONArray("data");     // Catch: Throwable -> L15
    L18:
        p.a("after fetchApmConfig net " + r101);     // Catch: Throwable -> L28
        if (r101 == null) goto L22;
        r1.a.c(r101, true);     // Catch: Throwable -> L28
    L21:
        f29922b = 0;     // Catch: Throwable -> L28
    L26:
        monitor-exit(a.class);
        return;
    L22:
        f29922b -= 10;     // Catch: Throwable -> L28
    L16:
        if (com.apm.lite.e.f29913e.isDebugMode() == false) goto L18;
        goto L18
    L23:
        j.b();     // Catch: Throwable -> L28
        if (j.f29982b == false) goto L26;
    L28:
        th = move-exception;
        throw th;
    }
}
