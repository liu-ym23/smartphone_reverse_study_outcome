package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.q.c;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class TidHelper {
    public TidHelper() {
    }

    public static void a(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        b.d().a(r100);
    }

    public static Tid b(Context r100) throws Exception {
        com.alipay.sdk.m.p.b r101 = new c().a(a.h(), r100);     // Catch: Throwable -> L13
        if (r101 == null) goto L12;
        JSONObject r102 = new JSONObject(r101.a());     // Catch: Throwable -> L13
        com.alipay.sdk.m.t.a r103 = com.alipay.sdk.m.t.a.a(r100);     // Catch: Throwable -> L13
        String r104 = r102.optString("tid");     // Catch: Throwable -> L13
        String r105 = r102.getString("client_key");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r104) == false) goto L8;
    L10:
        return a(r100, r103);
    L8:
        if (TextUtils.isEmpty(r105) == true) goto L10;
        r103.a(r104, r105);     // Catch: Throwable -> L13
    L12:
        return null;
    }

    public static void clearTID(Context r100) {
        com.alipay.sdk.m.t.a.a(r100).a();
    }

    public static String getIMEI(Context r100) {
        a(r100);
        return com.alipay.sdk.m.u.c.b(r100).b();
    }

    public static String getIMSI(Context r100) {
        a(r100);
        return com.alipay.sdk.m.u.c.b(r100).c();
    }

    public static synchronized String getTIDValue(Context r100) {
        monitor-enter(TidHelper.class);
        Tid r101 = loadOrCreateTID(r100);     // Catch: Throwable -> L10
        if (Tid.isEmpty(r101) == false) goto L7;
        String r102 = "";
    L8:
        monitor-exit(TidHelper.class);
        return r102;
    L7:
        r102 = r101.getTid();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static String getVirtualImei(Context r100) {
        a(r100);
        com.alipay.sdk.m.m.b.b();
        return com.alipay.sdk.m.m.b.f();
    }

    public static String getVirtualImsi(Context r100) {
        a(r100);
        com.alipay.sdk.m.m.b.b();
        return com.alipay.sdk.m.m.b.g();
    }

    public static Tid loadLocalTid(Context r100) {
        com.alipay.sdk.m.t.a r101 = com.alipay.sdk.m.t.a.a(r100);
        if (r101.h() == false) goto L7;
        return null;
    L7:
        return new Tid(r101.d(), r101.c(), r101.e().longValue());
    }

    public static synchronized Tid loadOrCreateTID(Context r100) {
        monitor-enter(TidHelper.class);
        e.b(com.alipay.sdk.m.l.a.A, "load_create_tid");     // Catch: Throwable -> L14
        a(r100);     // Catch: Throwable -> L14
        Tid r101 = loadTID(r100);     // Catch: Throwable -> L14
        if (Tid.isEmpty(r101) == false) goto L12;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L18;
        monitor-exit(TidHelper.class);
        return null;
    L18:
        r101 = b(r100);     // Catch: Throwable -> L17
    L12:
        monitor-exit(TidHelper.class);
        return r101;
    L14:
        th = move-exception;
        throw th;
    }

    public static Tid loadTID(Context r100) {
        a(r100);
        Tid r101 = a(r100, com.alipay.sdk.m.t.a.a(r100));
        if (r101 != null) goto L5;
        e.b(com.alipay.sdk.m.l.a.A, "load_tid null");
    L5:
        return r101;
    }

    public static boolean resetTID(Context r100) throws Exception {
        e.b(com.alipay.sdk.m.l.a.A, "reset_tid");
        if (Looper.myLooper() == Looper.getMainLooper()) goto L15;
        a(r100);
        clearTID(r100);
        Tid r101 = b(r100);     // Catch: Throwable -> L7
    L9:
        if (Tid.isEmpty(r101) == false) goto L12;
        return false;
    L12:
        return true;
    L7:
        r101 = null;
        goto L9
    L15:
        throw new Exception("Must be called on worker thread");
    }

    public static Tid a(Context r100, com.alipay.sdk.m.t.a r101) {
        if (r101 != null) goto L4;
        return null;
    L4:
        if (r101.i() == false) goto L7;
        return null;
    L7:
        return new Tid(r101.d(), r101.c(), r101.e().longValue());
    }
}
