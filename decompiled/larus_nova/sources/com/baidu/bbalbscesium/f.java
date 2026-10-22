package com.baidu.bbalbscesium;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f30072e = "CuidV266Info";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f30073f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f30074g = "libcuid.so";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f30075h = "ZGV2aWNlaWQ=";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f30076i = "aW1laQ==";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f30077j = "dmVy";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f30078k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f30079l = "0";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f30080m = "O";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f30081n = 14;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f30082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f30083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f30085d;

    public f() {
        this.f30084c = 2;
        this.f30085d = 0;
    }

    public static f a(String r100) {
        return b(c(r100));
    }

    public static f a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L15;
        f r102 = new f();
        r102.f30082a = r100;
        if (TextUtils.isEmpty(r101) == false) goto L7;
        int r103 = 0;
    L8:
        r102.f30085d = r103;
        if (r103 < 14) goto L11;
    L14:
        return r102;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        r101 = "0";
    L13:
        r102.f30083b = r101;
        goto L14
    L7:
        r103 = r101.length();
        goto L8
    L15:
        return null;
    }

    public static boolean a(int r100) {
        if (r100 < 14) goto L5;
        return true;
    L5:
        return false;
    }

    private static f b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L34;
        return null;
    L34:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L31
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L31
        String r103 = "0";
        String r104 = "0";
    L9:
        if (r102.hasNext() == false) goto L16;
        String r105 = r102.next();     // Catch: JSONException -> L31
        if (e(f30075h).equals(r105) == true) goto L9;
        if (e(f30077j).equals(r105) == true) goto L9;
        r104 = r101.optString(r105, "0");     // Catch: JSONException -> L31
        goto L9
    L16:
        String r106 = JSONObjectProtectorUtils.getString(r101, e(f30075h));     // Catch: JSONException -> L31
        int r107 = JSONObjectProtectorUtils.getInt(r101, e(f30077j));     // Catch: JSONException -> L31
        if (TextUtils.isEmpty(r104) == false) goto L19;
        int r108 = 0;
    L21:
        if (TextUtils.isEmpty(r106) == true) goto L33;
        f r109 = new f();     // Catch: JSONException -> L31
        r109.f30082a = r106;     // Catch: JSONException -> L31
        r109.f30084c = r107;     // Catch: JSONException -> L31
        r109.f30085d = r108;     // Catch: JSONException -> L31
        if (r108 < 14) goto L25;
    L29:
        r109.a();     // Catch: JSONException -> L31
        return r109;
    L25:
        if (TextUtils.isEmpty(r104) == true) goto L28;
        r103 = r104;
    L28:
        r109.f30083b = r103;     // Catch: JSONException -> L31
    L33:
        return null;
    L19:
        r108 = r104.length();     // Catch: JSONException -> L31
    L31:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
        goto L33
    }

    private static String c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return null;
    L11:
        byte[] r101 = com.baidu.bbalbscesium.k.a.g.a();     // Catch: Exception -> L8
        return new String(com.baidu.bbalbscesium.k.a.c.a(r101, r101, com.baidu.bbalbscesium.m.b.a(r100.getBytes())));
    L8:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
        return "";
    }

    private static String d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return null;
    L13:
        byte[] r101 = com.baidu.bbalbscesium.k.a.g.a();     // Catch: Throwable -> L8 UnsupportedEncodingException -> L10
        return com.baidu.bbalbscesium.m.b.a(com.baidu.bbalbscesium.k.a.c.b(r101, r101, r100.getBytes()), XML.CHARSET_UTF8);
    L8:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
        return "";
    }

    private static String e(String r100) {
        return new String(com.baidu.bbalbscesium.m.b.a(r100.getBytes()));
    }

    private String f() {
        return new JSONObject().put(e(f30075h), this.f30082a).put(e(f30076i), this.f30083b).put(e(f30077j), this.f30084c).toString();
    L4:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
        return null;
    }

    public static boolean f(String r100) {
        return TextUtils.isEmpty(r100);
    }

    public boolean a() {
        if (c() == false) goto L7;
        String r100 = "O";
    L5:
        this.f30083b = r100;
        return true;
    L7:
        if (d() == false) goto L9;
        r100 = "0";
        goto L5
    L9:
        return false;
    }

    public String b() {
        String r100 = this.f30083b;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = "0";
    L6:
        return this.f30082a + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r100;
    }

    public boolean c() {
        return a(this.f30085d);
    }

    public boolean d() {
        return f(this.f30083b);
    }

    public String e() {
        return d(f());
    }
}
