package com.baidu.mshield.x6.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.utility.c;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.h;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f32578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32579b;

    public final String a() {
        if (TextUtils.isEmpty(this.f32579b) == false) goto L5;
        String r100 = f.f(this.f32578a);
        if (TextUtils.isEmpty(r100) == true) goto L10;
        this.f32579b = r100;
    L10:
        return this.f32579b;
    L5:
        return this.f32579b;
    }

    public b(Context r100) {
        this.f32579b = "";
        this.f32578a = r100;
    }

    public String a(String r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(a());
        if (com.baidu.mshield.x6.c.b.b() == false) goto L5;
        r101.append(e("f/2/ejc"));
    L6:
        r101.append("?skey=");
        r101.append(d(r100));
        return r101.toString();
    L5:
        r101.append(e("f/2/jc"));
        goto L6
    }

    public String b(String r100) {
        return a() + e("f/2/sig") + "?skey=" + d(r100);
    }

    public String c(String r100) {
        return a() + e("c/11/z") + "?skey=" + d(r100);
    }

    public String d(String r100) {
        String r101 = e.a(c.b(this.f32578a));
        return URLEncoder.encode(Base64.encodeToString(h.d(r100.getBytes(), r101.getBytes()), 0));
    }

    public final String e(String r100) {
        String r101 = f.a();     // Catch: Throwable -> L10
        String r102 = f.b();     // Catch: Throwable -> L10
        long r103 = System.currentTimeMillis() / 1000;     // Catch: Throwable -> L10
        String r104 = f.a(r101, r102, r103);     // Catch: Throwable -> L6
    L8:
        StringBuffer r105 = new StringBuffer();     // Catch: Throwable -> L10
        r105.append(r100);     // Catch: Throwable -> L10
        r105.append("/250");     // Catch: Throwable -> L10
        r105.append(HTTP.URL_DEFAULT + r101);     // Catch: Throwable -> L10
        r105.append(HTTP.URL_DEFAULT + r103);     // Catch: Throwable -> L10
        r105.append(HTTP.URL_DEFAULT + r104);     // Catch: Throwable -> L10
        return r105.toString();
    L6:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L10
        r104 = "";
    L10:
        th = move-exception;
        f.b(th);
        return "";
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
}
