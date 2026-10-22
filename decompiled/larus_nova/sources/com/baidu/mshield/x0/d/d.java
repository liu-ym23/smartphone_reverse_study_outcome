package com.baidu.mshield.x0.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.u.i;
import com.baidu.mshield.rp.Report;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x6.f.k;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32485a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f32486b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f32487c;

    public static class a extends com.baidu.mshield.x0.d.h.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f32488b;

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            d.a(true);
            d.a(this.f32488b);
            d.a(false);
        }

        public a(Context r100) {
            this.f32488b = r100;
        }
    }

    public static class b implements com.baidu.mshield.x0.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f32489a;

        @Override // com.baidu.mshield.x0.e.b
        public boolean a() {
            return true;
        }

        public b(Context r100) {
            this.f32489a = r100;
        }

        @Override // com.baidu.mshield.x0.e.b
        public void a(String r100) {
        L9:
            th = move-exception;
            d.a(th);
            return;
        L4:
            if (r100.contains("mshield") == false) goto L14;
            JSONArray r101 = new JSONArray();     // Catch: Throwable -> L9
            JSONObject r102 = new JSONObject();     // Catch: Throwable -> L9
            r102.put("0", "mshield");     // Catch: Throwable -> L9
            r102.put("1", r100.replaceAll("\t", i.f25853b).replaceAll("\n", i.f25853b));     // Catch: Throwable -> L9
            r101.put(r102);     // Catch: Throwable -> L9
            c r103 = new c();     // Catch: Throwable -> L9
            d.a(this.f32489a, r103, r101, "1003138");     // Catch: Throwable -> L9
            return;
        }
    }

    public static String k(Context r100) {
        return "4.2.9";
    }

    static {
        f32486b = new String[]{"L3N5c3RlbS94YmluL3N1", "L3N5c3RlbS9iaW4vc3U", "L3N5c3RlbS94YmluLy5zdQ==", "L3N5c3RlbS9iaW4vLnN1", "L3N5c3RlbS9iaW4vLnN1dg==", "L3N5c3RlbS94YmluLy5zdXY=", "L3N5c3RlbS94YmluL2Jkc3U=", "L3N5c3RlbS9iaW4vYmRzdQ==", "L3N5c3RlbS94YmluL2F1", "L3N5c3RlbS9iaW4vYXU=", "L3N5c3RlbS94YmluL2t1LnN1ZA==", "L3N5c3RlbS9iaW4va3Uuc3Vk", "L3N5c3RlbS9iaW4vLnJncw==", "L3N5c3RlbS94YmluLy5yZ3M=", "L3NiaW4vc3U="};
    }

    public static String a() {
        String r100 = System.getProperty("http.proxyHost");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return r100;
    }

    public static String b() {
        Calendar r100 = Calendar.getInstance();     // Catch: Throwable -> L5
        return r100.get(1) + "" + r100.get(2) + "" + r100.get(5);
    L5:
        th = move-exception;
        a(th);
        return "";
    }

    public static byte[] d() {
        char[] r100 = new char[16];
        char[] r101 = f32485a.toCharArray();     // Catch: Throwable -> L11
        int r102 = 0;
    L4:
        if (r102 >= 16) goto L14;
        int r103 = new Random().nextInt(62);     // Catch: Throwable -> L11
        if (r103 < 0) goto L10;
        if (r103 >= r101.length) goto L10;
        r100[r102] = r101[r103];     // Catch: Throwable -> L11
    L10:
        r102 = r102 + 1;
    L14:
        return new String(r100).getBytes();
    L11:
        th = move-exception;
        a(th);
        goto L14
    }

    public static String e() {
        String r100 = "";
        InputStreamReader r101 = null;
        InputStreamReader r102 = new InputStreamReader(com_baidu_mshield_x0_d_d_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop ro.build.version.security_patch").getInputStream());     // Catch: Throwable -> L21
        LineNumberReader r103 = new LineNumberReader(r102);     // Catch: Throwable -> L19
        String r104 = "";
    L6:
        if (r104 != null) goto L56;
    L51:
        r102.close();     // Catch: Throwable -> L15
    L17:
        r103.close();     // Catch: IOException -> L32
    L53:
    L34:
        return r100;
    L15:
        th = move-exception;
        a(th);
        goto L17
    L56:
        r104 = r103.readLine();     // Catch: Throwable -> L11
        if (r104 == null) goto L6;
        r100 = r104.trim();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th = th;
        r101 = r102;
        LineNumberReader r105 = r103;
    L58:
        a(th);     // Catch: Throwable -> L35
        if (r101 != null) goto L60;
    L29:
        if (r105 == null) goto L34;
        r105.close();     // Catch: IOException -> L32
        goto L53
    L60:
        r101.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        a(th);
    L35:
        th = move-exception;
        if (r101 != null) goto L49;
    L41:
        if (r105 == null) goto L68;
        r105.close();     // Catch: IOException -> L44
        throw th;
    L44:
        e = move-exception;
        a(e);
        throw th;
    L68:
        throw th;
    L49:
        r101.close();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        a(th);
    L19:
        th = th;
        r105 = null;
        r101 = r102;
    L21:
        th = th;
        r105 = null;
    L32:
        e = move-exception;
        a(e);
        goto L34
    }

    public static String f() {
        return new String(com.baidu.mshield.b.f.d.a(Base64.decode(f.f32491b, 2), com.baidu.mshield.b.f.a.a(16)));
    L4:
        th = move-exception;
        a(th);
        return "";
    }

    public static String c() {
        return UUID.randomUUID().toString();
    L4:
        th = move-exception;
        a(th);
        return "";
    }

    public d() {
    }

    public static String a(String r100) {
    L8:
        return "";
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return new String(com.baidu.mshield.b.f.d.a(Base64.decode(r100, 0), com.baidu.mshield.b.f.a.a(16)));
    }

    public static String b(String r100) {
    L8:
        th = move-exception;
        a(th);
        return "";
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return Base64.encodeToString(com.baidu.mshield.b.f.d.b(r100.getBytes(), com.baidu.mshield.b.f.a.a(16)), 0);
    }

    public static String c(Context r100) {
        String r101 = EngineImpl.sAppkey;     // Catch: Throwable -> L5
        if (r101 == null) goto L11;
        return r101;
    L11:
        return "";
    L5:
        th = move-exception;
        a(th);
        return "";
    }

    public static String d(Context r100) {
        String r101 = EngineImpl.sSecKey;     // Catch: Throwable -> L5
        if (r101 == null) goto L11;
        return r101;
    L11:
        return "";
    L5:
        th = move-exception;
        a(th);
        return "";
    }

    public static String e(Context r100) {
        return com.baidu.mshield.b.a.d.a(r100);
    }

    public static int f(Context r100) {
        return com.baidu.mshield.b.e.c.a(r100, r100.getPackageName(), 0).versionCode;
    L5:
        th = move-exception;
        a(th);
        return 0;
    }

    public static JSONObject g(Context r100) {
        JSONObject r101 = new JSONObject();
        String[] r102 = f32486b;     // Catch: Throwable -> L28
        int r103 = r102.length;     // Catch: Throwable -> L28
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r105 >= r103) goto L31;
        if (new PolarisFileWrapper(new String(Base64.decode(r102[r105], 0))).exists() == false) goto L10;
        r101.put(Integer.toString(r106), "1");     // Catch: Throwable -> L28
    L11:
        r106 = r106 + 1;     // Catch: Throwable -> L28
        r105 = r105 + 1;     // Catch: Throwable -> L28
        goto L6
    L10:
        r101.put(Integer.toString(r106), "0");     // Catch: Throwable -> L28
        goto L11
    L31:
        PolarisFileWrapper r107 = new PolarisFileWrapper(new String(Base64.decode("L3NiaW5fb3JpZw==", 0)));     // Catch: Throwable -> L25
        if (r107.exists() == true) goto L16;
    L23:
        r101.put(Integer.toString(r106), "0");     // Catch: Throwable -> L25
    L30:
        return r101;
    L16:
        if (r107.isDirectory() == false) goto L23;
        r101.put(Integer.toString(r106), "0");     // Catch: Throwable -> L25
        String[] r108 = r107.list();     // Catch: Throwable -> L25
        int r109 = r108.length;     // Catch: Throwable -> L25
    L18:
        if (r104 >= r109) goto L30;
        String r110 = r108[r104];     // Catch: Throwable -> L25
        com.baidu.mshield.b.c.a.b(r110 + " exits!!");     // Catch: Throwable -> L25
        if (r110.startsWith("su") == true) goto L21;
        r104 = r104 + 1;     // Catch: Throwable -> L25
        goto L18
    L21:
        r101.put(Integer.toString(r106), "1");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        a(th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        a(th);
        goto L30
    }

    public static String h(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), com.baidu.mshield.x0.a.f32463a);     // Catch: Throwable -> L7
        if (r101.exists() == true) goto L5;
        r101.mkdirs();     // Catch: Throwable -> L7
    L5:
        return r101.getAbsolutePath();
    L7:
        th = move-exception;
        a(th);
        return "";
    }

    public static String i(Context r100) {
        return com.baidu.xclient.gdid.a.c(r100);
    L4:
        th = move-exception;
        a(th);
        return "";
    }

    public static String j(Context r100) {
        return Long.toString(com.baidu.mshield.b.e.c.a(r100, r100.getPackageName(), 0).firstInstallTime);
    L4:
        th = move-exception;
        a(th);
        return "";
    }

    public static String l(Context r100) {
        return new String(com.baidu.mshield.b.f.d.a(Base64.decode(com.baidu.mshield.x0.a.f32464b, 0), com.baidu.mshield.b.f.a.a(16)));
    L4:
        return "";
    }

    public static void m(Context r100) {
        com.baidu.mshield.x0.e.a.a().a(new b(r100));
    }

    public static boolean n(Context r100) {
    L12:
        th = move-exception;
        a(th);
        return false;
    L4:
        if (k.a(r100, new String[]{"android.permission.ACCESS_NETWORK_STATE"}) == true) goto L7;
        return true;
    L7:
        NetworkInfo r101 = com.baidu.mshield.b.e.b.a(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.isConnected();
    }

    public static boolean o(Context r100) {
        if (com.baidu.mshield.b.e.a.b(r100, "adb_enabled") <= 0) goto L11;
        return true;
    L11:
        return false;
    L6:
        th = move-exception;
        a(th);
        return false;
    }

    public static void p(Context r100) {
        com.baidu.mshield.x0.l.a r101 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L13
        List<com.baidu.mshield.x0.l.b> r102 = r101.e();     // Catch: Throwable -> L13
        if (r102 != null) goto L6;
        return;
    L6:
        com.baidu.mshield.b.c.a.b("re_con==" + r102.size());     // Catch: Throwable -> L13
        Iterator<com.baidu.mshield.x0.l.b> r103 = r102.iterator();     // Catch: Throwable -> L13
    L8:
        if (r103.hasNext() == false) goto L23;
        com.baidu.mshield.x0.l.b r104 = r103.next();     // Catch: Throwable -> L13
        if (a(r100, r101.a(), r104.f32541b) == false) goto L8;
        a(r100, r104);     // Catch: Throwable -> L13
        goto L8
    L23:
        return;
    L13:
        th = move-exception;
        a(th);
    }

    public static void q(Context r110) {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        String r102 = "";
        com.baidu.mshield.b.c.a.b("setAliveDate begin");
        int r103 = 0;
        PackageInfo r104 = com.baidu.mshield.b.e.c.a(r110, r110.getPackageName(), 16384);     // Catch: Throwable -> L11
        int r105 = r104.applicationInfo.flags;     // Catch: Throwable -> L11
        if ((r105 & 1) != 1) goto L7;
    L8:
        r103 = 1;
    L48:
        r102 = com.baidu.mshield.b.f.e.a(new PolarisFileWrapper(r104.applicationInfo.sourceDir));     // Catch: Throwable -> L47
    L50:
        r101.put("0", "0");     // Catch: Throwable -> L44
        r101.put(Constants.VIA_REPORT_TYPE_WPA_STATE, Integer.toString(r103));     // Catch: Throwable -> L44
        r101.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, j(r110));     // Catch: Throwable -> L44
        r101.put(Constants.VIA_REPORT_TYPE_START_WAP, e());     // Catch: Throwable -> L44
        r101.put(Constants.VIA_REPORT_TYPE_START_GROUP, r102);     // Catch: Throwable -> L44
        r101.put("18", e(r110));     // Catch: Throwable -> L44
        r101.put(Constants.VIA_ACT_TYPE_NINETEEN, f(r110));     // Catch: Throwable -> L44
        r101.put("990", com.baidu.xclient.gdid.a.d(r110));     // Catch: Throwable -> L44
        r101.put("989", k(r110));     // Catch: Throwable -> L44
        r101.put("993", e.a(r110));     // Catch: Throwable -> L44
        r101.put("995", g.b(r110));     // Catch: Throwable -> L44
        if (a(r110, "plc31", true) == false) goto L36;
        r101.put("997", i(r110));     // Catch: Throwable -> L44
    L36:
        r101.put("998", e.b(r110));     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(com.baidu.mshield.utility.c.j(r110)) == false) goto L39;
        String r106 = com.baidu.mshield.utility.c.i(r110);     // Catch: Throwable -> L44
    L40:
        r101.put("999", r106);     // Catch: Throwable -> L44
        r101.put("981", new com.baidu.mshield.x0.l.c(r110).a());     // Catch: Throwable -> L44
        r100.put("0", new JSONObject().put("1001003", r101));     // Catch: Throwable -> L44
        com.baidu.mshield.b.c.a.b("setAliveDate begin to report" + r100.toString());     // Catch: Throwable -> L44
        c(r110, r100.toString());     // Catch: Throwable -> L44
        return;
    L39:
        r106 = com.baidu.mshield.utility.c.j(r110);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        a(th);
        return;
    L7:
        if ((r105 & 128) != 128) goto L48;
    L11:
        th = move-exception;
        a(th);
        goto L50
    }

    public static /* synthetic */ void a(Context r100) {
        p(r100);
    }

    public static void b(Context r100) {
        monitor-enter(d.class);     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L5:
        if (f32487c == false) goto L8;
        monitor-exit(d.class);     // Catch: Throwable -> L11
        return;
    L8:
        com.baidu.mshield.x0.d.h.d.b().a(new a(r100));     // Catch: Throwable -> L11
        monitor-exit(d.class);     // Catch: Throwable -> L11
        return;
    L14:
        th = move-exception;
        a(th);
    }

    public static void a(Throwable r100) {
        com.baidu.mshield.b.c.a.a(r100);
    }

    public static /* synthetic */ boolean a(boolean r100) {
        f32487c = r100;
        return r100;
    }

    public static void a(Context r100, com.baidu.mshield.x0.l.b r101) {
        com.baidu.mshield.x0.l.a r102 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L10
        String r103 = r102.d(r101.f32543d);     // Catch: Throwable -> L10
        String r104 = b();     // Catch: Throwable -> L10
        if (r103.equals(r104) == false) goto L5;
        return;
    L5:
        String r105 = r102.a(r101.f32543d);     // Catch: Throwable -> L10
        String r106 = a(r100, r101, r105).toString();     // Catch: Throwable -> L10
        if (new com.baidu.mshield.x0.i.c(r100, null).a(r106) == true) goto L8;
        b(r100, r101, r105);     // Catch: Throwable -> L10
    L8:
        r102.c(r101.f32543d, r104);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        a(th);
    }

    public static void b(Context r100, String r101) {
        Report.getInstance(r100).sr(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(th);
    }

    public static void c(Context r100, String r101) {
        Report.getInstance(r100).w(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(th);
    }

    private static Process com_baidu_mshield_x0_d_d_java_lang_Runtime_exec(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    public static String a(long r100, String r101) {
        if (r100 >= 0) goto L12;
    L11:
        return "";
    L12:
    L9:
        th = move-exception;
        a(th);
        goto L11
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return new SimpleDateFormat(r101).format(new Date(r100));
    }

    public static JSONArray a(JSONArray r100, int r101) {
        JSONArray r102 = new JSONArray();
        int r103 = r100.length();     // Catch: Throwable -> L8
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L10;
        if (r104 == r101) goto L7;
        r102.put(r100.get(r104));     // Catch: Throwable -> L8
    L7:
        r104 = r104 + 1;
    L10:
        return r102;
    L8:
        th = move-exception;
        a(th);
        goto L10
    }

    public static int a(Context r100, String r101) {
        Report.getInstance(r100).s(r101);     // Catch: Throwable -> L4
        return 0;
    L4:
        th = move-exception;
        a(th);
        return 0;
    }

    public static JSONArray a(Context r110, com.baidu.mshield.x0.l.b r111, String r112) {
        JSONObject r100 = new JSONObject();
        long r101 = System.currentTimeMillis();
        String r102 = "";
        PackageInfo r103 = com.baidu.mshield.b.e.c.a(r110, r110.getPackageName(), 0);     // Catch: Throwable -> L16
        String r104 = r103.versionName;     // Catch: Throwable -> L16
        int r105 = r103.versionCode;     // Catch: Throwable -> L14
        String r113 = r103.applicationInfo.loadLabel(r110.getPackageManager()).toString();     // Catch: Throwable -> L12
    L10:
        th = th;
    L97:
        a(th);     // Catch: Throwable -> L87
    L20:
        r100.put("1", r113);     // Catch: Throwable -> L87
        r100.put("2", EngineImpl.getInstance(r110).getPropertyByType("p"));     // Catch: Throwable -> L87
        r100.put("3", r104);     // Catch: Throwable -> L87
        r100.put("4", com.baidu.mshield.utility.c.b(r110));     // Catch: Throwable -> L87
        r100.put("5", r111.f32543d);     // Catch: Throwable -> L87
        r100.put("6", r101);     // Catch: Throwable -> L87
        r100.put("7", "0");     // Catch: Throwable -> L87
        r100.put("8", c(r110));     // Catch: Throwable -> L87
        r100.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r111.f32540a);     // Catch: Throwable -> L87
        r100.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r111.f32542c);     // Catch: Throwable -> L87
        com.baidu.mshield.x0.l.a r106 = new com.baidu.mshield.x0.l.a(r110);     // Catch: Throwable -> L87
        r100.put("11", r106.c());     // Catch: Throwable -> L87
        r100.put("12", r106.k());     // Catch: Throwable -> L87
        r100.put("13", 1);     // Catch: Throwable -> L87
        r100.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, EngineImpl.getInstance(r110).getPropertyByType("ws"));     // Catch: Throwable -> L87
        r100.put("20", com.baidu.mshield.utility.c.j(r110));     // Catch: Throwable -> L87
        r100.put("21", com.baidu.mshield.utility.c.i(r110));     // Catch: Throwable -> L87
        r100.put("22", e.b(r110));     // Catch: Throwable -> L87
        r100.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, i(r110));     // Catch: Throwable -> L87
        r100.put("26", e.a(r110));     // Catch: Throwable -> L87
        r100.put("28", g.b(r110));     // Catch: Throwable -> L87
        if ("1003003".endsWith(r111.f32543d) == false) goto L53;
        r100.put("29", "x0");     // Catch: Throwable -> L87
    L53:
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r112) == true) goto L83;
        JSONObject r108 = new JSONObject(r112);     // Catch: Throwable -> L79
        if ("1001003".endsWith(r111.f32543d) == false) goto L61;
        com.baidu.mshield.b.c.a.b("1001003 createAlive");     // Catch: Throwable -> L79
        r108.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, j(r110));     // Catch: Throwable -> L79
        r108.put(Constants.VIA_REPORT_TYPE_START_WAP, e());     // Catch: Throwable -> L79
        r108.put(Constants.VIA_REPORT_TYPE_START_GROUP, r102);     // Catch: Throwable -> L79
        r108.put("18", r104);     // Catch: Throwable -> L79
        r108.put(Constants.VIA_ACT_TYPE_NINETEEN, r105);     // Catch: Throwable -> L79
    L61:
        if (a(r110, "plc31", false) == false) goto L65;
        r108.put("997", i(r110));     // Catch: Throwable -> L79
    L65:
        r108.put("998", e.b(r110));     // Catch: Throwable -> L79
        if (TextUtils.isEmpty(com.baidu.mshield.utility.c.j(r110)) == false) goto L68;
        String r114 = com.baidu.mshield.utility.c.i(r110);     // Catch: Throwable -> L79
    L69:
        r108.put("999", r114);     // Catch: Throwable -> L79
        r108.put("990", com.baidu.xclient.gdid.a.d(r110));     // Catch: Throwable -> L79
        r108.put("989", k(r110));     // Catch: Throwable -> L79
        r108.put("985", com.baidu.mshield.x6.f.e.a(r110));     // Catch: Throwable -> L79
        r108.put("971", com.baidu.mshield.x6.f.e.b(r110));     // Catch: Throwable -> L79
        r107 = r108;
        goto L83
    L68:
        r114 = com.baidu.mshield.utility.c.j(r110);     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        a(th);     // Catch: Throwable -> L87
    L83:
        if (r107.length() != 0) goto L85;
        r100.put("module_section", new JSONArray());     // Catch: Throwable -> L87
    L90:
        return new JSONArray().put(r100);
    L85:
        r100.put("module_section", new JSONArray().put(r107));     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        a(th);
        goto L90
    L7:
        if ("1001003".endsWith(r111.f32543d) == false) goto L20;
        r102 = com.baidu.mshield.b.f.e.a(new PolarisFileWrapper(r103.applicationInfo.sourceDir));     // Catch: Throwable -> L10
    L12:
        th = th;
        r113 = "";
    L14:
        th = th;
        r113 = "";
    L18:
        r105 = 0;
    L16:
        th = th;
        r104 = "";
        r113 = r104;
        goto L18
    }

    public static JSONObject b(Context r110, com.baidu.mshield.x0.l.b r111, String r112) {
        String r100 = "";
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L53
    L13:
        th = move-exception;
        Throwable r103 = th;
        String r104 = "";
    L15:
        a(r103);     // Catch: Throwable -> L53
    L16:
        int r105 = 0;
    L17:
        r102.put("0", System.currentTimeMillis());     // Catch: Throwable -> L53
        r102.put("1", "0");     // Catch: Throwable -> L53
        r102.put("2", "0");     // Catch: Throwable -> L53
        r102.put("3", c(r110));     // Catch: Throwable -> L53
        r102.put("4", 0);     // Catch: Throwable -> L53
        r102.put("5", 0);     // Catch: Throwable -> L53
        r102.put("6", 1);     // Catch: Throwable -> L53
        r102.put("7", 0);     // Catch: Throwable -> L53
        r102.put("8", r111.f32540a);     // Catch: Throwable -> L53
        r102.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r111.f32542c);     // Catch: Throwable -> L53
        r102.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r111.f32543d);     // Catch: Throwable -> L53
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L53
        if (TextUtils.isEmpty(r112) == false) goto L60;
    L51:
        r101.put("Common_section", r102);     // Catch: Throwable -> L53
        r101.put("Module_section", r106);     // Catch: Throwable -> L53
        a(r110, r101.toString());     // Catch: Throwable -> L53
    L55:
        return r101;
    L60:
        JSONObject r107 = new JSONObject(r112);     // Catch: Throwable -> L49
        if ("1001003".endsWith(r111.f32543d) == false) goto L35;
        com.baidu.mshield.b.c.a.b("1001003 createInsertAlive");     // Catch: Throwable -> L49
        r107.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, j(r110));     // Catch: Throwable -> L49
        r107.put(Constants.VIA_REPORT_TYPE_START_WAP, e());     // Catch: Throwable -> L49
        r107.put(Constants.VIA_REPORT_TYPE_START_GROUP, r100);     // Catch: Throwable -> L49
        r107.put("18", r104);     // Catch: Throwable -> L49
        r107.put(Constants.VIA_ACT_TYPE_NINETEEN, r105);     // Catch: Throwable -> L49
    L35:
        if (a(r110, "plc31", false) == false) goto L39;
        r107.put("997", i(r110));     // Catch: Throwable -> L49
    L39:
        r107.put("998", e.b(r110));     // Catch: Throwable -> L49
        r107.put("990", com.baidu.xclient.gdid.a.d(r110));     // Catch: Throwable -> L49
        r107.put("989", k(r110));     // Catch: Throwable -> L49
        if (TextUtils.isEmpty(com.baidu.mshield.utility.c.j(r110)) == false) goto L46;
        String r113 = com.baidu.mshield.utility.c.i(r110);     // Catch: Throwable -> L49
    L47:
        r107.put("999", r113);     // Catch: Throwable -> L49
        r106 = r107;
        goto L51
    L46:
        r113 = com.baidu.mshield.utility.c.j(r110);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        a(th);     // Catch: Throwable -> L53
        goto L51
    L6:
        if ("1001003".endsWith(r111.f32543d) == false) goto L12;
        PackageInfo r108 = com.baidu.mshield.b.e.c.a(r110, r110.getPackageName(), 0);     // Catch: Throwable -> L13
        String r109 = com.baidu.mshield.b.f.e.a(new PolarisFileWrapper(r108.applicationInfo.sourceDir));     // Catch: Throwable -> L13
        r100 = r108.versionName;     // Catch: Throwable -> L10
        int r114 = r108.versionCode;     // Catch: Throwable -> L10
        r104 = r100;
        r100 = r109;
        r105 = r114;
    L10:
        th = move-exception;
        r104 = r100;
        r100 = r109;
        r103 = th;
        goto L15
    L12:
        r104 = "";
    L53:
        th = move-exception;
        a(th);
        goto L55
    }

    public static JSONObject a(Context r110, String r111, JSONArray r112) {
        String r100 = "";
        JSONObject r101 = new JSONObject();
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L26
        String r103 = c(r110);     // Catch: Throwable -> L26
        String r104 = com.baidu.mshield.x0.a.f32466d;     // Catch: Throwable -> L26
        String r105 = EngineImpl.sLoadVersion;     // Catch: Throwable -> L26
        String r106 = com.baidu.mshield.b.e.c.a(r110, r110.getPackageName(), 0).versionName;     // Catch: Throwable -> L10
        r100 = r110.getApplicationInfo().loadLabel(r110.getPackageManager()).toString();     // Catch: Throwable -> L8
    L13:
        r101.put("1", r100);     // Catch: Throwable -> L26
        r101.put("2", EngineImpl.getInstance(r110).getPropertyByType("p"));     // Catch: Throwable -> L26
        r101.put("3", r106);     // Catch: Throwable -> L26
        r101.put("4", com.baidu.mshield.utility.c.b(r110));     // Catch: Throwable -> L26
        r101.put("5", r111);     // Catch: Throwable -> L26
        r101.put("6", r102);     // Catch: Throwable -> L26
        r101.put("7", " ");     // Catch: Throwable -> L26
        r101.put("8", r103);     // Catch: Throwable -> L26
        r101.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r104);     // Catch: Throwable -> L26
        r101.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r105);     // Catch: Throwable -> L26
        r101.put("11", " ");     // Catch: Throwable -> L26
        r101.put("12", " ");     // Catch: Throwable -> L26
        r101.put("13", " ");     // Catch: Throwable -> L26
        r101.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, EngineImpl.getInstance(r110).getPropertyByType("ws"));     // Catch: Throwable -> L26
        if (a(r110, "plc31", false) == false) goto L24;
        r101.put("997", i(r110));     // Catch: Throwable -> L26
    L24:
        r101.put("989", k(r110));     // Catch: Throwable -> L26
        r101.put("module_section", r112);     // Catch: Throwable -> L26
    L28:
        return r101;
    L8:
        th = th;
    L12:
        a(th);     // Catch: Throwable -> L26
    L10:
        th = th;
        r106 = "";
    L26:
        th = move-exception;
        a(th);
        goto L28
    }

    public static void b(Context r100, JSONArray r101, String r102) {
        c r103 = new c();     // Catch: Throwable -> L33
        String r104 = EngineImpl.KEY_CUID;     // Catch: Throwable -> L33
        r103.f32481c = 0;     // Catch: Throwable -> L33
        String r105 = com.baidu.mshield.x0.a.f32463a;     // Catch: Throwable -> L33
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() == 0) goto L40;
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L29
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L29
        r107.put("0", Long.toString(System.currentTimeMillis()));     // Catch: Throwable -> L29
        r107.put("1", r103.f32479a);     // Catch: Throwable -> L29
        r107.put("2", r103.f32480b);     // Catch: Throwable -> L29
        r107.put("3", String.valueOf(c(r100)));     // Catch: Throwable -> L29
        r107.put("4", r103.f32481c);     // Catch: Throwable -> L29
        r107.put("5", r103.f32482d);     // Catch: Throwable -> L29
        r107.put("6", r103.f32483e);     // Catch: Throwable -> L29
        r107.put("7", r103.f32484f);     // Catch: Throwable -> L29
        r107.put("8", com.baidu.mshield.x0.a.f32466d);     // Catch: Throwable -> L29
        r107.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, EngineImpl.sLoadVersion);     // Catch: Throwable -> L29
        r107.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r102);     // Catch: Throwable -> L29
        r106.put("Common_section", r107);     // Catch: Throwable -> L29
        r106.put("Module_section", r101);     // Catch: Throwable -> L29
        b(r100, r106.toString());     // Catch: Throwable -> L29
    L41:
        return;
    L29:
        th = move-exception;
        a(th);     // Catch: Throwable -> L33
        return;
    L40:
        return;
    L33:
        th = move-exception;
        a(th);
    }

    public static boolean a(Context r100, String r101, String r102) {
    L21:
        th = move-exception;
        a(th);
        return false;
    L4:
        if (TextUtils.isEmpty(r102) == false) goto L7;
        return false;
    L7:
        if (r102.equals(r100.getPackageName()) == false) goto L10;
        return true;
    L10:
        if (r102.equals(com.baidu.mshield.x0.a.f32463a) == false) goto L12;
        return true;
    L12:
        if (TextUtils.isEmpty(r101) == true) goto L31;
        JSONArray r103 = new JSONArray(r101);     // Catch: Throwable -> L24
        int r104 = 0;
    L16:
        if (r104 >= r103.length()) goto L34;
        if (r102.equals(r103.get(r104)) == true) goto L19;
        r104 = r104 + 1;
        goto L16
    L19:
        return true;
    L34:
        return false;
    L33:
        return false;
    L31:
        return false;
    }

    public static boolean a(Context r100, String r101, boolean r102) {
        String r103 = new com.baidu.mshield.x0.l.a(r100).c(r101);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r103) == true) goto L12;
        if (new JSONObject(r103).optInt("1") == 1) goto L15;
        return false;
    L15:
        return true;
    L12:
        return r102;
    L10:
        th = move-exception;
        a(th);
        goto L12
    }

    public static String a(String r100, String r101, long r102) {
        return com.baidu.mshield.b.f.e.a(r100 + r102 + r101);
    L4:
        th = move-exception;
        a(th);
        return null;
    }

    public static void a(Context r100, JSONArray r101, String r102) {
        c r103 = new c();     // Catch: Throwable -> L4
        String r104 = EngineImpl.KEY_CUID;     // Catch: Throwable -> L4
        r103.f32481c = 0;     // Catch: Throwable -> L4
        String r105 = com.baidu.mshield.x0.a.f32463a;     // Catch: Throwable -> L4
        a(r100, r103, r101, r102, true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(th);
    }

    public static void a(Context r100, String r101, c r102, com.baidu.mshield.x0.l.a r103) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (r103 == null) goto L14;
    L7:
        String r104 = r103.c(r101);     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r104) == true) goto L16;
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L11
        r102.f32483e = r105.optInt("2");     // Catch: Throwable -> L11
        r102.f32482d = r105.optInt("3");     // Catch: Throwable -> L11
        r102.f32484f = r105.optInt("4");     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        a(th);
        return;
    L16:
        return;
    L14:
        r103 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L11
        goto L7
    }

    public static String a(Context r100, com.baidu.mshield.x0.l.a r101, String r102, String r103) {
        if (r101 == null) goto L14;
    L5:
        String r104 = r101.c(r102);     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r104) == true) goto L13;
        JSONObject r105 = new JSONObject(r104).getJSONObject("5");     // Catch: Throwable -> L11
        if (r105.has(r103) == false) goto L13;
        return r105.optString(r103, "");
    L11:
        th = move-exception;
        a(th);
    L13:
        return "";
    L14:
        r101 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L11
        goto L5
    }

    public static boolean a(Context r100, String r101, boolean r102, com.baidu.mshield.x0.l.a r103) {
        if (r103 == null) goto L15;
    L4:
        String r104 = r103.c(r101);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r104) == true) goto L14;
        if (new JSONObject(r104).optInt("1") == 1) goto L17;
        return false;
    L17:
        return true;
    L12:
        th = move-exception;
        a(th);
    L14:
        return r102;
    L15:
        r103 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L12
        goto L4
    }

    public static void a(Context r100, c r101, JSONArray r102, String r103) {
        a(r100, r101, r102, r103, true);
    }

    public static void a(Context r100, c r101, JSONArray r102, String r103, boolean r110) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (r102.length() == 0) goto L48;
        if (r101 != null) goto L44;
        return;
    L44:
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L41
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L41
        int r105 = r102.length();     // Catch: Throwable -> L41
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L21;
        JSONObject r107 = r102.getJSONObject(r106);     // Catch: Throwable -> L41
        r107.put("991", i(r100));     // Catch: Throwable -> L41
        r107.put("995", g.b(r100));     // Catch: Throwable -> L41
        r107.put("998", e.b(r100));     // Catch: Throwable -> L41
        r107.put("989", k(r100));     // Catch: Throwable -> L41
        r106 = r106 + 1;
        goto L9
    L21:
        r104.put("0", Long.toString(System.currentTimeMillis()));     // Catch: Throwable -> L41
        r104.put("1", r101.f32479a);     // Catch: Throwable -> L41
        r104.put("2", r101.f32480b);     // Catch: Throwable -> L41
        r104.put("3", String.valueOf(c(r100)));     // Catch: Throwable -> L41
        r104.put("4", r101.f32481c);     // Catch: Throwable -> L41
        r104.put("5", r101.f32482d);     // Catch: Throwable -> L41
        r104.put("6", r101.f32483e);     // Catch: Throwable -> L41
        r104.put("7", r101.f32484f);     // Catch: Throwable -> L41
        r104.put("8", com.baidu.mshield.x0.a.f32466d);     // Catch: Throwable -> L41
        r104.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, EngineImpl.sLoadVersion);     // Catch: Throwable -> L41
        r104.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r103);     // Catch: Throwable -> L41
        r111.put("Common_section", r104);     // Catch: Throwable -> L41
        r111.put("Module_section", r102);     // Catch: Throwable -> L41
        a(r100, r111.toString());     // Catch: Throwable -> L41
        return;
    L41:
        th = move-exception;
        a(th);
        return;
    }

    public static void a(Context r100, String r101, String r102, String r103, String r110, String r111) {
        Report.getInstance(r100).i(r101, r102, r103, r110, r111);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(th);
    }
}
