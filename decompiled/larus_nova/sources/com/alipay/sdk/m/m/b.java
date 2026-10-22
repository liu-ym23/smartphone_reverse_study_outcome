package com.alipay.sdk.m.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.n;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import java.util.Random;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25593d = "virtualImeiAndImsi";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25594e = "virtual_imei";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25595f = "virtual_imsi";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile b f25596g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25599c;

    public static String d() {
        return "-1;-1";
    }

    public static String e() {
        return "1";
    }

    public static String h() {
        return CustomAlbumViewModel.DEFAULT_TAB_ID;
    }

    public static String i() {
        return "-1";
    }

    public static synchronized b b() {
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f25596g != null) goto L7;
        f25596g = new b();     // Catch: Throwable -> L10
    L7:
        b r100 = f25596g;     // Catch: Throwable -> L10
        monitor-exit(b.class);
        return r100;
    }

    public b() {
        this.f25598b = "sdk-and-lite";
        String r100 = com.alipay.sdk.m.j.a.a();
        if (com.alipay.sdk.m.j.a.b() == true) goto L6;
        this.f25598b += '_' + r100;
        return;
    }

    public static String c() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public static String f() {
        Context r100 = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences r101 = r100.getSharedPreferences(f25593d, 0);
        String r102 = r101.getString(f25594e, null);
        if (TextUtils.isEmpty(r102) == true) goto L5;
        return r102;
    L5:
        if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(r100).d()) == false) goto L7;
        String r103 = c();
    L8:
        String r104 = r103;
        r101.edit().putString(f25594e, r104).apply();
        return r104;
    L7:
        r103 = c.b(r100).b();
        goto L8
    }

    public static String g() {
        Context r100 = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences r101 = r100.getSharedPreferences(f25593d, 0);
        String r102 = r101.getString(f25595f, null);
        if (TextUtils.isEmpty(r102) == true) goto L5;
        return r102;
    L5:
        if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(r100).d()) == false) goto L13;
        String r103 = com.alipay.sdk.m.s.b.d().c();
        if (TextUtils.isEmpty(r103) == false) goto L9;
    L12:
        String r104 = c();
    L14:
        String r105 = r104;
        r101.edit().putString(f25595f, r105).apply();
        return r105;
    L9:
        if (r103.length() < 18) goto L12;
        r104 = r103.substring(3, 18);
        goto L14
    L13:
        r104 = c.b(r100).c();
        goto L14
    }

    public String a() {
        return this.f25599c;
    }

    public static synchronized void a(String r100) {
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        monitor-exit(b.class);
        return;
    L8:
        PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.m.s.b.d().b()).edit().putString(com.alipay.sdk.m.l.b.f25487i, r100).apply();     // Catch: Throwable -> L11
        com.alipay.sdk.m.l.a.f25458f = r100;     // Catch: Throwable -> L11
        monitor-exit(b.class);
    }

    public static String b(Context r100) {
        if (r100 != null) goto L9;
        return "";
    L9:
        StringBuilder r101 = new StringBuilder("(");     // Catch: Exception -> L8
        String r102 = r100.getPackageName();     // Catch: Exception -> L8
        PackageInfo r103 = r100.getPackageManager().getPackageInfo(r102, 0);     // Catch: Exception -> L8
        r101.append(r102);     // Catch: Exception -> L8
        r101.append(i.f25853b);     // Catch: Exception -> L8
        r101.append(r103.versionCode);     // Catch: Exception -> L8
        r101.append(")");     // Catch: Exception -> L8
        return r101.toString();
    L11:
        return "";
    }

    public static String a(Context r100) {
        return Float.toString(new TextView(r100).getTextSize());
    }

    public String a(com.alipay.sdk.m.s.a r110, com.alipay.sdk.m.t.a r111, boolean r210) {
        Context r100 = com.alipay.sdk.m.s.b.d().b();
        c r101 = c.b(r100);
        if (TextUtils.isEmpty(this.f25597a) == false) goto L5;
        this.f25597a = "Msp/15.8.15 (" + n.f() + i.f25853b + n.e() + i.f25853b + n.c(r100) + i.f25853b + n.e(r100) + i.f25853b + n.f(r100) + i.f25853b + a(r100);
    L5:
        String r102 = c.d(r100).b();
        String r103 = n.b(r100);
        String r104 = e();
        String r105 = r101.c();
        String r106 = r101.b();
        String r112 = g();
        String r113 = f();
        if (r111 == null) goto L8;
        this.f25599c = r111.c();
    L8:
        String r114 = Build.MANUFACTURER.replace(i.f25853b, " ");
        String r115 = Build.MODEL.replace(i.f25853b, " ");
        boolean r116 = com.alipay.sdk.m.s.b.e();
        String r107 = r101.d();
        String r117 = i();
        String r108 = h();
        StringBuilder r109 = new StringBuilder();
        r109.append(this.f25597a);
        r109.append(i.f25853b);
        r109.append(r102);
        r109.append(i.f25853b);
        r109.append(r103);
        r109.append(i.f25853b);
        r109.append(r104);
        r109.append(i.f25853b);
        r109.append(r105);
        r109.append(i.f25853b);
        r109.append(r106);
        r109.append(i.f25853b);
        r109.append(this.f25599c);
        r109.append(i.f25853b);
        r109.append(r114);
        r109.append(i.f25853b);
        r109.append(r115);
        r109.append(i.f25853b);
        r109.append(r116);
        r109.append(i.f25853b);
        r109.append(r107);
        r109.append(i.f25853b);
        r109.append(d());
        r109.append(i.f25853b);
        r109.append(this.f25598b);
        r109.append(i.f25853b);
        r109.append(r112);
        r109.append(i.f25853b);
        r109.append(r113);
        r109.append(i.f25853b);
        r109.append(r117);
        r109.append(i.f25853b);
        r109.append(r108);
        if (r111 == null) goto L13;
        String r118 = com.alipay.sdk.m.w.b.a(r110, r100, com.alipay.sdk.m.t.a.a(r100).d(), com.alipay.sdk.m.w.b.c(r110, r100));
        if (TextUtils.isEmpty(r118) == true) goto L13;
        r109.append(";;;");
        r109.append(r118);
    L13:
        r109.append(")");
        return r109.toString();
    }
}
