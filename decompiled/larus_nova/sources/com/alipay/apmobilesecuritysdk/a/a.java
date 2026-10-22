package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.sdk.m.f0.c;
import com.alipay.sdk.m.f0.d;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.apmobilesecuritysdk.b.a f25084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25085c;

    public a(Context r100) {
        this.f25084b = com.alipay.apmobilesecuritysdk.b.a.a();
        this.f25085c = 4;
        this.f25083a = r100;
    }

    public static String a(Context r100) {
        String r101 = b(r100);
        if (com.alipay.sdk.m.z.a.a(r101) == true) goto L5;
        return r101;
    L5:
        return h.f(r100);
    }

    public static String a(Context r100, String r101) {
        b();     // Catch: Throwable -> L10
        String r102 = i.a(r101);     // Catch: Throwable -> L10
        if (com.alipay.sdk.m.z.a.a(r102) == true) goto L5;
        return r102;
    L5:
        String r103 = g.a(r100, r101);     // Catch: Throwable -> L10
        i.a(r101, r103);     // Catch: Throwable -> L10
        if (com.alipay.sdk.m.z.a.a(r103) == true) goto L8;
        return r103;
    L8:
        return "";
    L13:
        return "";
    }

    public static boolean a() {
        SimpleDateFormat r100 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] r101 = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int r102 = ((int) (((Math.random() * 24.0d) * 60.0d) * 60.0d)) * 1;
        int r103 = 0;
    L4:
        if (r103 >= 3) goto L15;
        String[] r104 = r101[r103].split(" ");     // Catch: Exception -> L16
        if (r104 == null) goto L14;
        if (r104.length != 2) goto L14;
        Date r105 = new Date();     // Catch: Exception -> L16
        Date r106 = r100.parse(r104[0] + " 00:00:00");     // Catch: Exception -> L16
        Date r107 = r100.parse(r104[1] + " 23:59:59");     // Catch: Exception -> L16
        Calendar r108 = Calendar.getInstance();     // Catch: Exception -> L16
        r108.setTime(r107);     // Catch: Exception -> L16
        r108.add(13, r102);     // Catch: Exception -> L16
        Date r109 = r108.getTime();     // Catch: Exception -> L16
        if (r105.after(r106) == false) goto L14;
        if (r105.before(r109) == false) goto L14;
        return true;
    L14:
        r103 = r103 + 1;
    L15:
        return false;
    }

    private c b(Map<String, String> r110) {
        String r100 = "";
        Context r101 = this.f25083a;     // Catch: Throwable -> L31
        d r102 = new d();     // Catch: Throwable -> L31
        String r103 = com.alipay.sdk.m.z.a.a(r110, "appName", "");     // Catch: Throwable -> L31
        String r104 = com.alipay.sdk.m.z.a.a(r110, "sessionId", "");     // Catch: Throwable -> L31
        String r105 = com.alipay.sdk.m.z.a.a(r110, "rpcVersion", "");     // Catch: Throwable -> L31
        String r106 = a(r101, r103);     // Catch: Throwable -> L31
        String r107 = UmidSdkWrapper.getSecurityToken(r101);     // Catch: Throwable -> L31
        String r108 = h.d(r101);     // Catch: Throwable -> L31
        if (com.alipay.sdk.m.z.a.b(r104) == false) goto L6;
        r102.f25298c = r104;     // Catch: Throwable -> L31
    L7:
        r102.f25299d = r107;     // Catch: Throwable -> L31
        r102.f25300e = r108;     // Catch: Throwable -> L31
        r102.f25296a = "android";     // Catch: Throwable -> L31
        com.alipay.apmobilesecuritysdk.e.c r109 = com.alipay.apmobilesecuritysdk.e.d.c(r101);     // Catch: Throwable -> L31
        if (r109 == null) goto L10;
        String r111 = r109.f25093a;     // Catch: Throwable -> L31
        String r112 = r109.f25095c;     // Catch: Throwable -> L31
    L12:
        if (com.alipay.sdk.m.z.a.a(r111) == false) goto L16;
        b r113 = com.alipay.apmobilesecuritysdk.e.a.c(r101);     // Catch: Throwable -> L31
        if (r113 == null) goto L16;
        r111 = r113.f25090a;     // Catch: Throwable -> L31
        r112 = r113.f25092c;     // Catch: Throwable -> L31
    L16:
        com.alipay.apmobilesecuritysdk.e.c r114 = com.alipay.apmobilesecuritysdk.e.d.b();     // Catch: Throwable -> L31
        if (r114 == null) goto L19;
        r100 = r114.f25093a;     // Catch: Throwable -> L31
        String r115 = r114.f25095c;     // Catch: Throwable -> L31
    L21:
        if (com.alipay.sdk.m.z.a.a(r100) == false) goto L25;
        b r116 = com.alipay.apmobilesecuritysdk.e.a.b();     // Catch: Throwable -> L31
        if (r116 == null) goto L25;
        r100 = r116.f25090a;     // Catch: Throwable -> L31
        r115 = r116.f25092c;     // Catch: Throwable -> L31
    L25:
        r102.f25303h = r111;     // Catch: Throwable -> L31
        r102.f25302g = r100;     // Catch: Throwable -> L31
        r102.f25305j = r105;     // Catch: Throwable -> L31
        if (com.alipay.sdk.m.z.a.a(r111) == false) goto L28;
        r102.f25297b = r100;     // Catch: Throwable -> L31
        r112 = r115;
    L29:
        r102.f25304i = r112;     // Catch: Throwable -> L31
        r102.f25301f = e.a(r101, r110);     // Catch: Throwable -> L31
        return com.alipay.sdk.m.d0.d.b(this.f25083a, this.f25084b.c()).a(r102);
    L28:
        r102.f25297b = r111;     // Catch: Throwable -> L31
        goto L29
    L19:
        r115 = "";
        goto L21
    L10:
        r112 = "";
        r111 = r112;
        goto L12
    L6:
        r102.f25298c = r106;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.printStackTrace();
        com.alipay.apmobilesecuritysdk.c.a.a(th);
        return null;
    }

    public static String b(Context r100) {
        String r101 = i.b();     // Catch: Throwable -> L17
        if (com.alipay.sdk.m.z.a.a(r101) == true) goto L5;
        return r101;
    L5:
        com.alipay.apmobilesecuritysdk.e.c r102 = com.alipay.apmobilesecuritysdk.e.d.b(r100);     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        i.a(r102);     // Catch: Throwable -> L17
        String r103 = r102.f25093a;     // Catch: Throwable -> L17
        if (com.alipay.sdk.m.z.a.b(r103) == false) goto L10;
        return r103;
    L10:
        b r104 = com.alipay.apmobilesecuritysdk.e.a.b(r100);     // Catch: Throwable -> L17
        if (r104 == null) goto L15;
        i.a(r104);     // Catch: Throwable -> L17
        String r105 = r104.f25090a;     // Catch: Throwable -> L17
        if (com.alipay.sdk.m.z.a.b(r105) == false) goto L20;
        return r105;
    L20:
        return "";
    L15:
        return "";
    L21:
        return "";
    }

    public static void b() {
        String[] r100 = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};     // Catch: Throwable -> L12
        int r101 = 0;
    L4:
        if (r101 >= 5) goto L19;
        String r102 = r100[r101];     // Catch: Throwable -> L12
        PolarisFileWrapper r103 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), ".SystemConfig/" + r102);     // Catch: Throwable -> L12
        if (r103.exists() == false) goto L10;
        if (r103.canWrite() == false) goto L10;
        r103.delete();     // Catch: Throwable -> L12
    L10:
        r101 = r101 + 1;
        goto L4
    L19:
        return;
    }

    public final int a(Map<String, String> r110) {
        com.alipay.apmobilesecuritysdk.c.a.a(this.f25083a, com.alipay.sdk.m.z.a.a(r110, "tid", ""), com.alipay.sdk.m.z.a.a(r110, com.alipay.sdk.m.l.b.f25485g, ""), a(this.f25083a));     // Catch: Exception -> L84
        String r100 = com.alipay.sdk.m.z.a.a(r110, "appName", "");     // Catch: Exception -> L84
        b();     // Catch: Exception -> L84
        b(this.f25083a);     // Catch: Exception -> L84
        a(this.f25083a, r100);     // Catch: Exception -> L84
        i.a();     // Catch: Exception -> L84
        boolean r101 = false;
        if (a() == true) goto L31;
        if (com.alipay.apmobilesecuritysdk.common.a.a(this.f25083a) == true) goto L31;
        e.a();     // Catch: Exception -> L84
        if ((!com.alipay.sdk.m.z.a.a(e.b(this.f25083a, r110), i.c())) == true) goto L35;
        String r102 = com.alipay.sdk.m.z.a.a(r110, "tid", "");     // Catch: Exception -> L84
        String r103 = com.alipay.sdk.m.z.a.a(r110, com.alipay.sdk.m.l.b.f25485g, "");     // Catch: Exception -> L84
        if (com.alipay.sdk.m.z.a.b(r102) == false) goto L17;
        if (com.alipay.sdk.m.z.a.a(r102, i.d()) == false) goto L35;
    L17:
        if (com.alipay.sdk.m.z.a.b(r103) == false) goto L22;
        if (com.alipay.sdk.m.z.a.a(r103, i.e()) == false) goto L35;
    L22:
        if (i.a(this.f25083a, r100) == false) goto L35;
        if (com.alipay.sdk.m.z.a.a(a(this.f25083a, r100)) == true) goto L35;
        if (com.alipay.sdk.m.z.a.a(b(this.f25083a)) == true) goto L35;
    L36:
        boolean r104 = false;
    L37:
        Context r105 = this.f25083a;     // Catch: Exception -> L84
        com.alipay.sdk.m.a0.b.a(APSecuritySdk.getInstance(r105));     // Catch: Exception -> L84
        h.b(r105, String.valueOf(com.alipay.sdk.m.a0.b.m()));     // Catch: Exception -> L84
        if (r104 == false) goto L68;
        new com.alipay.apmobilesecuritysdk.c.b();     // Catch: Exception -> L84
        UmidSdkWrapper.startUmidTaskSync(this.f25083a, com.alipay.apmobilesecuritysdk.b.a.a().b());     // Catch: Exception -> L84
        c r106 = b(r110);     // Catch: Exception -> L84
        if (r106 == null) goto L43;
        int r107 = r106.c();     // Catch: Exception -> L84
    L44:
        if (r107 != 1) goto L46;
        h.a(this.f25083a, r106.b());     // Catch: Exception -> L84
        h.d(this.f25083a, r106.a());     // Catch: Exception -> L84
        h.e(this.f25083a, r106.f25291g);     // Catch: Exception -> L84
        h.a(this.f25083a, r106.f25292h);     // Catch: Exception -> L84
        h.f(this.f25083a, r106.f25293i);     // Catch: Exception -> L84
        h.g(this.f25083a, r106.f25295k);     // Catch: Exception -> L84
        i.c(e.b(this.f25083a, r110));     // Catch: Exception -> L84
        i.a(r100, r106.f25288d);     // Catch: Exception -> L84
        i.b(r106.f25287c);     // Catch: Exception -> L84
        i.d(r106.f25294j);     // Catch: Exception -> L84
        String r108 = com.alipay.sdk.m.z.a.a(r110, "tid", "");     // Catch: Exception -> L84
        if (com.alipay.sdk.m.z.a.b(r108) == true) goto L58;
    L60:
        r108 = i.d();     // Catch: Exception -> L84
    L61:
        i.e(r108);     // Catch: Exception -> L84
        String r111 = com.alipay.sdk.m.z.a.a(r110, com.alipay.sdk.m.l.b.f25485g, "");     // Catch: Exception -> L84
        if (com.alipay.sdk.m.z.a.b(r111) == true) goto L64;
    L66:
        r111 = i.e();     // Catch: Exception -> L84
    L67:
        i.f(r111);     // Catch: Exception -> L84
        i.a();     // Catch: Exception -> L84
        com.alipay.apmobilesecuritysdk.e.d.a(this.f25083a, i.g());     // Catch: Exception -> L84
        com.alipay.apmobilesecuritysdk.e.d.a();     // Catch: Exception -> L84
        com.alipay.apmobilesecuritysdk.e.a.a(this.f25083a, new b(i.b(), i.c(), i.f()));     // Catch: Exception -> L84
        com.alipay.apmobilesecuritysdk.e.a.a();     // Catch: Exception -> L84
        g.a(this.f25083a, r100, i.a(r100));     // Catch: Exception -> L84
        g.a();     // Catch: Exception -> L84
        h.a(this.f25083a, r100, System.currentTimeMillis());     // Catch: Exception -> L84
        goto L68
    L64:
        if (com.alipay.sdk.m.z.a.a(r111, i.e()) == true) goto L66;
        i.f(r111);     // Catch: Exception -> L84
        goto L67
    L58:
        if (com.alipay.sdk.m.z.a.a(r108, i.d()) == true) goto L60;
        i.e(r108);     // Catch: Exception -> L84
        goto L61
    L46:
        if (r107 == 3) goto L54;
        if (r106 == null) goto L50;
        String r112 = "Server error, result:" + r106.f25281b;     // Catch: Exception -> L84
    L49:
        com.alipay.apmobilesecuritysdk.c.a.a(r112);     // Catch: Exception -> L84
        if (com.alipay.sdk.m.z.a.a(a(this.f25083a, r100)) == false) goto L68;
        int r113 = 4;
    L69:
        this.f25085c = r113;     // Catch: Exception -> L84
        com.alipay.sdk.m.g0.a r114 = com.alipay.sdk.m.d0.d.b(this.f25083a, this.f25084b.c());     // Catch: Exception -> L84
        Context r109 = this.f25083a;     // Catch: Exception -> L84
        ConnectivityManager r115 = (ConnectivityManager) r109.getSystemService("connectivity");     // Catch: Exception -> L84
        if (r115 == null) goto L72;
        NetworkInfo r116 = r115.getActiveNetworkInfo();     // Catch: Exception -> L84
    L73:
        if (r116 != null) goto L75;
    L79:
        if (r101 == false) goto L87;
        if (h.c(r109) == false) goto L87;
        new com.alipay.sdk.m.c0.b(r109.getFilesDir().getAbsolutePath() + "/log/ap", r114).a();     // Catch: Exception -> L84
    L87:
        return this.f25085c;
    L75:
        if (r116.isConnected() == false) goto L79;
        if (r116.getType() != 1) goto L79;
        r101 = true;
        goto L79
    L72:
        r116 = null;
        goto L73
    L50:
        r112 = "Server error, returned null";
        goto L49
    L54:
        r113 = 1;
        goto L69
    L43:
        r107 = 2;
    L68:
        r113 = 0;
    L35:
        r104 = true;
    L31:
        if (com.alipay.sdk.m.z.a.a(a(this.f25083a, r100)) == true) goto L35;
        if (com.alipay.sdk.m.z.a.a(b(this.f25083a)) == false) goto L36;
    L84:
        e = move-exception;
        com.alipay.apmobilesecuritysdk.c.a.a(e);
        goto L87
    }
}
