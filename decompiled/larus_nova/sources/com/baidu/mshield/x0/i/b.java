package com.baidu.mshield.x0.i;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f32527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32528b;

    public final String a() {
        if (TextUtils.isEmpty(this.f32528b) == false) goto L5;
        String r100 = d.l(this.f32527a);
        if (TextUtils.isEmpty(r100) == true) goto L10;
        this.f32528b = r100;
    L10:
        return this.f32528b;
    L5:
        return this.f32528b;
    }

    public b(Context r100) {
        this.f32528b = "";
        this.f32527a = r100;
    }

    public static synchronized b a(Context r100) {
        monitor-enter(b.class);
        b r101 = new b(r100);     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public String b(String r100) {
        StringBuilder r101 = new StringBuilder();
        String r102 = d.c();
        r101.append(a("p/1/r", r100));
        r101.append("&msg_id=" + r102);
        return r101.toString();
    }

    public String a(String r100) {
        return a("s/5/aio", r100);
    }

    public byte[] a(byte[] r100, String r101) {
        byte[] r102 = null;
        r102 = com.baidu.mshield.b.a.c.a(r101.getBytes(XML.CHARSET_UTF8));     // Catch: Throwable -> L5
        return com.baidu.mshield.b.f.d.b(r102, r100);
    L5:
        th = move-exception;
        d.a(th);
        return r102;
    }

    public final String a(String r100, String r101) {
        return a(r100, r101, "");
    }

    public final String a(String r110, String r111, String r112) {
        String r100 = d.c(this.f32527a);     // Catch: Throwable -> L13
        String r101 = d.d(this.f32527a);     // Catch: Throwable -> L13
        long r102 = System.currentTimeMillis() / 1000;     // Catch: Throwable -> L13
        String r103 = d.a(r100, r101, r102);     // Catch: Throwable -> L6
    L8:
        StringBuffer r104 = new StringBuffer();     // Catch: Throwable -> L13
        r104.append(a());     // Catch: Throwable -> L13
        r104.append(r110);     // Catch: Throwable -> L13
        r104.append("/250");     // Catch: Throwable -> L13
        r104.append(HTTP.URL_DEFAULT + r100);     // Catch: Throwable -> L13
        r104.append(HTTP.URL_DEFAULT + r102);     // Catch: Throwable -> L13
        r104.append(HTTP.URL_DEFAULT + r103);     // Catch: Throwable -> L13
        r104.append("?skey=" + r111);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r112) == true) goto L11;
        r104.append("&page=" + r112);     // Catch: Throwable -> L13
    L11:
        return r104.toString();
    L6:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L13
        r103 = "";
    L13:
        th = move-exception;
        d.a(th);
        return "";
    }
}
