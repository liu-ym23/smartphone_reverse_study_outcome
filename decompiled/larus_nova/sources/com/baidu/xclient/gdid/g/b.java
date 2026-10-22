package com.baidu.xclient.gdid.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.a.c;
import com.baidu.mshield.b.f.e;
import com.baidu.xclient.gdid.d;
import com.baidu.xclient.gdid.f;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f33616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f33617b;

    public b(Context r100) {
        this.f33617b = f.f33612a;
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

    public final String a() {
        if (TextUtils.isEmpty(f33616a) == false) goto L6;
        b();
    L6:
        return f33616a;
    }

    public String a(String r100, String r110) {
        String r101 = d.f33592c;
        String r102 = d.f33593d;
        String r103 = "";
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L14:
        return "";
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        long r104 = System.currentTimeMillis() / 1000;
        StringBuilder r105 = new StringBuilder();
        r103 = a(r101, r102, r104);     // Catch: Throwable -> L10
    L12:
        r105.append(a());
        r105.append(r100);
        r105.append("250/");
        r105.append(r101);
        r105.append(HTTP.URL_DEFAULT);
        r105.append(r104);
        r105.append(HTTP.URL_DEFAULT);
        r105.append(r103);
        r105.append("?skey=");
        r105.append(r110);
        return r105.toString();
    L10:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        goto L12
    }

    public String a(String r100, String r101, long r102) {
        return e.a(r100 + r102 + r101);
    L4:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        return "";
    }

    public byte[] a(byte[] r100, String r101) {
        byte[] r102 = c.a(r101.getBytes(XML.CHARSET_UTF8));     // Catch: Throwable -> L4
    L7:
        return com.baidu.mshield.b.f.d.b(r102, r100);
    L4:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        r102 = null;
        goto L7
    }

    public final void b() {
        f33616a = new String(com.baidu.mshield.b.f.d.a(Base64.decode(this.f33617b, 0), com.baidu.mshield.b.f.a.a(16)));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }
}
