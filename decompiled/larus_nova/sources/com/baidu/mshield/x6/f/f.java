package com.baidu.mshield.x6.f;

import android.content.Context;
import android.nfc.NfcManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.MH;
import com.baidu.mshield.x6.EngineImpl;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.tencent.connect.common.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class f {
    public static String a() {
        String r100 = EngineImpl.sAppkey;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "";
    }

    public static String b() {
        String r100 = EngineImpl.sSecKey;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "";
    }

    public static String c() {
        Calendar r100 = Calendar.getInstance();     // Catch: Throwable -> L5
        return r100.get(1) + "" + r100.get(2) + "" + r100.get(5);
    L5:
        th = move-exception;
        b(th);
        return "";
    }

    public static String d() {
        return l.f32619c;
    }

    public static String e() {
        return l.f32618b;
    }

    public static String a(Throwable r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        Throwable r101 = r100;
    L6:
        if (r101 == null) goto L11;
    L13:
        th = move-exception;
        b(th);
        return "";
    L8:
        if ((r101 instanceof UnknownHostException) == true) goto L9;
        r101 = r101.getCause();     // Catch: Throwable -> L13
        goto L6
    L9:
        return "";
    L11:
        StringWriter r102 = new StringWriter();     // Catch: Throwable -> L13
        PrintWriter r103 = new PrintWriter(r102);     // Catch: Throwable -> L13
        r100.printStackTrace(r103);     // Catch: Throwable -> L13
        String r104 = r102.toString();     // Catch: Throwable -> L13
        r103.close();     // Catch: Throwable -> L13
        return r104.replaceAll("\t", com.alipay.sdk.m.u.i.f25853b).replaceAll("\n", com.alipay.sdk.m.u.i.f25853b);
    }

    public static String b(String r100) {
    L8:
        th = move-exception;
        b(th);
        return "";
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return Base64.encodeToString(com.baidu.mshield.b.f.a.b(r100.getBytes(), com.baidu.mshield.b.f.a.a()), 0);
    }

    public static int c(String r100) {
        int r101 = -1;
        if (r100 != null) goto L5;
    L45:
        com.baidu.mshield.b.c.a.a("illegalArithmetic expr is empty : " + r100);
        return -1;
    L5:
        if (r100 == "") goto L45;
        char[] r102 = r100.trim().toCharArray();     // Catch: Throwable -> L42
        int r103 = 0;
    L9:
        if (r103 >= (r102.length - 1)) goto L40;
        if (r103 != 0) goto L12;
        r101 = Character.getNumericValue(r102[r103]);     // Catch: Throwable -> L42
    L39:
        r103 = r103 + 1;     // Catch: Throwable -> L42
        goto L9
    L12:
        char r104 = r102[r103];     // Catch: Throwable -> L42
        r103 = r103 + 1;     // Catch: Throwable -> L42
        int r105 = Character.getNumericValue(r102[r103]);     // Catch: Throwable -> L42
        if (r104 != '%') goto L15;
        r101 = r101 % r105;     // Catch: Throwable -> L42
        goto L39
    L15:
        if (r104 != '&') goto L17;
        r101 = r101 & r105;     // Catch: Throwable -> L42
        goto L39
    L17:
        if (r104 != '*') goto L19;
    L36:
        r101 = r101 * r105;     // Catch: Throwable -> L42
        goto L39
    L19:
        if (r104 != '+') goto L21;
        r101 = r101 + r105;     // Catch: Throwable -> L42
        goto L39
    L21:
        if (r104 != '-') goto L23;
        r101 = r101 - r105;     // Catch: Throwable -> L42
        goto L39
    L23:
        if (r104 != '/') goto L25;
        r101 = r101 / r105;     // Catch: Throwable -> L42
        goto L39
    L25:
        if (r104 != '^') goto L27;
        r101 = r101 ^ r105;     // Catch: Throwable -> L42
        goto L39
    L27:
        if (r104 == 'x') goto L36;
        if (r104 == '|') goto L31;
        r101 = r105;
        goto L39
    L31:
        r101 = r101 | r105;     // Catch: Throwable -> L42
        goto L39
    L40:
        com.baidu.mshield.b.c.a.a("illegalArithmetic expr：" + r100 + "，res：" + r101);     // Catch: Throwable -> L42
    L44:
        return r101;
    L42:
        th = move-exception;
        b(th);
        goto L44
    }

    public static String d(Context r100) {
    L9:
        th = move-exception;
        b(th);
        return "";
    L4:
        if (a(r100, false) == false) goto L8;
        return new com.baidu.mshield.x6.b.b(r100).g();
    L8:
        return l.f32621e;
    }

    public static String e(Context r100) {
        return MH.getVersion(r100);
    L4:
        th = move-exception;
        b(th);
        return "";
    }

    public static String f(Context r100) {
        return new String(h.a(Base64.decode(g.f32613b, 0), com.baidu.mshield.b.f.a.a(16)));
    L4:
        return "";
    }

    public static String g(Context r100) {
        String r101 = "";
        com.baidu.mshield.x6.b.c r102 = new com.baidu.mshield.x6.b.c(r100);     // Catch: Throwable -> L8
        r101 = r102.b();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r101) == false) goto L6;
        com.baidu.mshield.b.c.a.a("cloud token is empty");     // Catch: Throwable -> L8
        r101 = r102.e();     // Catch: Throwable -> L8
    L6:
        com.baidu.mshield.b.c.a.a("getUserHoldToken : " + r101);     // Catch: Throwable -> L8
    L10:
        return r101;
    L8:
        th = move-exception;
        b(th);
        goto L10
    }

    public static void h(Context r100) {
        b.c(r100);     // Catch: Throwable -> L14
        com.baidu.mshield.x6.b.b r101 = new com.baidu.mshield.x6.b.b(r100);     // Catch: Throwable -> L14
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L14
        long r103 = ((long) r101.o()) * 60000;     // Catch: Throwable -> L14
        long r104 = r101.K();     // Catch: Throwable -> L14
        if (r101.n() == true) goto L5;
    L6:
        com.baidu.mshield.x6.e.h.a(r100).a(3);     // Catch: Throwable -> L14
    L8:
        if (r101.f() == true) goto L10;
        j(r100);     // Catch: Throwable -> L14
        r101.d(true);     // Catch: Throwable -> L14
    L10:
        com.baidu.mshield.x6.e.h.a(r100).a(1, false);     // Catch: Throwable -> L14
        if (r101.a() == true) goto L19;
        com.baidu.mshield.x6.e.h.a(r100).a();     // Catch: Throwable -> L14
        return;
    L19:
        return;
    L5:
        if ((r102 - r104) <= r103) goto L8;
    L14:
        th = move-exception;
        b(th);
    }

    public static void i(Context r110) {
        String r100 = l.a(r110);     // Catch: Throwable -> L37
        com.baidu.mshield.x6.b.b r101 = new com.baidu.mshield.x6.b.b(r110);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r100) == true) goto L35;
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L37
        String r103 = r102.optString(FaceShowElderlyFragment.MD5_KEY_PREFIX);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r103) == true) goto L9;
        String r111 = com.baidu.mshield.b.f.e.a(r103);     // Catch: Throwable -> L14
        l.f32619c = r111;     // Catch: Throwable -> L14
        r101.h(r111);     // Catch: Throwable -> L14
        String r112 = new String(com.baidu.mshield.b.a.c.b(Base64.decode(r103.getBytes(), 0)), XML.CHARSET_UTF8);     // Catch: Throwable -> L14
        com.baidu.mshield.b.c.a.a("requestSigPolicy ungzSig : ".concat(r112));     // Catch: Throwable -> L14
        l.f32617a = r112;     // Catch: Throwable -> L14
    L10:
        JSONObject r104 = r102.optJSONObject("sgs");     // Catch: Throwable -> L14
        if (r104 == null) goto L42;
        String r105 = r104.optString("3", "");     // Catch: Throwable -> L14
        l.f32618b = r105;     // Catch: Throwable -> L14
        com.baidu.mshield.b.c.a.a("requestSgsPolicy : " + r105);     // Catch: Throwable -> L14
    L42:
        JSONObject r106 = r102.optJSONObject("drf");     // Catch: Throwable -> L21
        if (r106 == null) goto L19;
        l.f32620d = r106.toString();     // Catch: Throwable -> L21
        com.baidu.mshield.b.c.a.a("requestSigPolicy ungzDrf : ".concat(new String(com.baidu.mshield.b.a.c.b(Base64.decode(r106.optString("1").getBytes(), 0)), XML.CHARSET_UTF8)));     // Catch: Throwable -> L21
        r101.g(r106.optString("2"));     // Catch: Throwable -> L21
    L23:
        r101.a(System.currentTimeMillis(), true);     // Catch: Throwable -> L37
        JSONObject r107 = r102.optJSONObject("rmf");     // Catch: Throwable -> L33
        if (r107 != null) goto L27;
        l.f32621e = "";     // Catch: Throwable -> L33
        return;
    L27:
        if (a(r110, false) == false) goto L29;
        r101.v(r107.toString());     // Catch: Throwable -> L33
        l.f32621e = "";     // Catch: Throwable -> L33
    L30:
        com.baidu.mshield.b.c.a.a("requestSigPolicy ungzRmf : ".concat(new String(com.baidu.mshield.b.a.c.b(Base64.decode(r107.optString("1").getBytes(), 0)), XML.CHARSET_UTF8)));     // Catch: Throwable -> L33
        return;
    L29:
        l.f32621e = r107.toString();     // Catch: Throwable -> L33
        r101.p();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        b(th);     // Catch: Throwable -> L37
        return;
    L19:
        l.f32620d = "";     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        b(th);     // Catch: Throwable -> L37
        goto L23
    L9:
        com.baidu.mshield.b.c.a.a("sig sdata is empty ");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        b(th);     // Catch: Throwable -> L37
        goto L42
    L35:
        r101.a(System.currentTimeMillis(), false);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        b(th);
    }

    public static void j(Context r100) {
        String r101 = com.baidu.mshield.x6.c.a.a(r100);     // Catch: Throwable -> L9
        String r102 = com.baidu.mshield.x6.c.a.b(r100);     // Catch: Throwable -> L9
        com.baidu.mshield.x6.b.b r103 = new com.baidu.mshield.x6.b.b(r100);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r103.o(com.baidu.mshield.b.f.e.a(r101));     // Catch: Throwable -> L9
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        r103.n(com.baidu.mshield.b.f.e.a(r102));     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        b(th);
    }

    public static String a(String r100) {
    L8:
        th = move-exception;
        b(th);
        return "";
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return new String(com.baidu.mshield.b.f.a.a(Base64.decode(r100, 0), com.baidu.mshield.b.f.a.a()));
    }

    public static String b(Context r100) {
        if (TextUtils.isEmpty(l.f32620d) == false) goto L5;
        i(r100);
        return l.f32620d;
    L5:
        return l.f32620d;
    }

    public static String c(Context r100) {
    L8:
        th = move-exception;
        b(th);
    L11:
        return l.f32617a;
    L3:
        if (TextUtils.isEmpty(l.f32617a) == false) goto L5;
        i(r100);     // Catch: Throwable -> L8
        goto L11
    L5:
        return l.f32617a;
    }

    public static boolean a(Context r100) {
        if (((NfcManager) r100.getSystemService("nfc")).getDefaultAdapter() == null) goto L12;
        return true;
    L12:
        return false;
    L6:
        th = move-exception;
        b(th);
        return false;
    }

    public static void b(Throwable r100) {
        com.baidu.mshield.b.c.a.a(r100);
    }

    public static boolean a(Context r100, boolean r101) {
        String r102 = a(r100, "plc104");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r102) == true) goto L15;
        JSONObject r103 = new JSONObject(r102).getJSONObject("5");     // Catch: Throwable -> L13
        if (r103.has(BDLocationException.ERROR_ABNORMAL_NETWORK) == false) goto L15;
        if (r103.optInt(BDLocationException.ERROR_ABNORMAL_NETWORK) == 1) goto L18;
        return false;
    L18:
        return true;
    L15:
        return r101;
    L13:
        th = move-exception;
        b(th);
        goto L15
    }

    public static String a(Context r100, String r101) {
        return new com.baidu.mshield.x6.b.a(r100).a(r101);
    L4:
        th = move-exception;
        b(th);
        return "";
    }

    public static boolean a(Context r100, String r101, boolean r102) {
        String r103 = new com.baidu.mshield.x6.b.a(r100).a(r101);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r103) == true) goto L12;
        if (new JSONObject(r103).optInt("1") == 1) goto L15;
        return false;
    L15:
        return true;
    L12:
        return r102;
    L10:
        th = move-exception;
        b(th);
        goto L12
    }

    public static String a(String r100, String r101, long r102) throws UnsupportedEncodingException {
        return com.baidu.mshield.b.f.e.a(r100 + r102 + r101);
    }

    public static JSONObject a(Context r100, JSONObject r101, String r102, boolean r103) {
        return a(r100, r101, r102, "mshield_x6", r103);
    }

    public static JSONObject a(Context r100, JSONObject r101, String r110, String r111, boolean r112) {
        JSONObject r113 = new JSONObject();
        long r102 = System.currentTimeMillis();
        String r103 = com.baidu.mshield.b.e.c.a(r100, r100.getPackageName(), 0).versionName;     // Catch: Throwable -> L8
        String r104 = r100.getApplicationInfo().loadLabel(r100.getPackageManager()).toString();     // Catch: Throwable -> L6
    L11:
        r113.put("1", r104);     // Catch: Throwable -> L37
        r113.put("2", EngineImpl.getInstance(r100).getPropertyByType("p"));     // Catch: Throwable -> L37
        r113.put("3", r103);     // Catch: Throwable -> L37
        r113.put("4", com.baidu.mshield.utility.c.b(r100));     // Catch: Throwable -> L37
        r113.put("5", r110);     // Catch: Throwable -> L37
        r113.put("6", r102);     // Catch: Throwable -> L37
        r113.put("7", "");     // Catch: Throwable -> L37
        r113.put("8", a());     // Catch: Throwable -> L37
        String r114 = EngineImpl.sLoadVersion;     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r114) == false) goto L21;
        r113.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r111);     // Catch: Throwable -> L37
        r113.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "0");     // Catch: Throwable -> L37
    L28:
        r113.put("11", "");     // Catch: Throwable -> L37
        r113.put("12", "");     // Catch: Throwable -> L37
        r113.put("13", 1);     // Catch: Throwable -> L37
        r113.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, EngineImpl.getInstance(r100).getPropertyByType("ws"));     // Catch: Throwable -> L37
        if (r101 != null) goto L33;
    L39:
        return r113;
    L33:
        r101.put("989", e(r100));     // Catch: Throwable -> L37
        r113.put("module_section", new JSONArray().put(r101));     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        b(th);
        goto L39
    L21:
        String[] r115 = r114.split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L37
        if (r115.length != 2) goto L25;
        r113.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r115[0]);     // Catch: Throwable -> L37
        r113.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r115[1]);     // Catch: Throwable -> L37
        goto L28
    L25:
        if (r115.length != 1) goto L27;
        r113.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r111);     // Catch: Throwable -> L37
        r113.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r115[0]);     // Catch: Throwable -> L37
        goto L28
    L27:
        r113.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r111);     // Catch: Throwable -> L37
        r113.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "0");     // Catch: Throwable -> L37
    L6:
        th = th;
    L44:
        b(th);     // Catch: Throwable -> L37
        r104 = "";
    L8:
        th = th;
        r103 = "";
        goto L44
    }
}
