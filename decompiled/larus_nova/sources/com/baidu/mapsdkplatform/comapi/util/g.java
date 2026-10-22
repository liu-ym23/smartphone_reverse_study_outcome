package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mshield.MH;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class g {
    private static Map<String, String> A;
    private static String B;
    private static String C;
    private static boolean D;
    private static boolean E;
    public static String F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.baidu.mapsdkplatform.comjni.util.a f32329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f32330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f32331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f32332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f32333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f32334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f32335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f32336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f32337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f32338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f32339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f32340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f32341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f32342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static String f32343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f32344p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f32345q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f32346r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f32347s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static String f32348t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f32349u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static String f32350v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static String f32351w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static Context f32352x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static float f32353y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static String f32354z;

    public static void u() {
        F = null;
    }

    static {
        f32329a = new com.baidu.mapsdkplatform.comjni.util.a();
        f32330b = "02";
        f32344p = "baidu";
        f32345q = "";
        f32346r = "";
        f32347s = "";
        f32350v = "-1";
        f32351w = "-1";
        f32353y = 1.0f;
        f32354z = "";
        A = new HashMap();
        B = "";
        D = false;
        E = false;
    }

    public static synchronized String c() {
        monitor-enter(g.class);
        String r100 = LBSAuthManager.getInstance(f32352x).getCUID();     // Catch: Throwable -> L17 Exception -> L19
        if (TextUtils.isEmpty(r100) == false) goto L7;
    L20:
        if (r100 != null) goto L22;
        r100 = "";
    L22:
        monitor-exit(g.class);
        return r100;
    L7:
        if (r100.equals(f32354z) == true) goto L20;
        f32354z = r100;     // Catch: Throwable -> L17 Exception -> L19
        if (A == null) goto L13;
        String r101 = c();     // Catch: Throwable -> L17 Exception -> L19
        Map<String, String> r102 = A;     // Catch: Throwable -> L17 Exception -> L19
        r102.put(EngineImpl.KEY_CUID, AppMD5.encodeUrlParamsValue(r101));     // Catch: Throwable -> L17 Exception -> L19
    L13:
        SysUpdateObservable.getInstance().updateCuid(f32354z);     // Catch: Throwable -> L17 Exception -> L19
        HashMap r103 = new HashMap();     // Catch: Throwable -> L17 Exception -> L19
        r103.put(EngineImpl.KEY_CUID, f32354z);     // Catch: Throwable -> L17 Exception -> L19
        MH.ud(f32352x, r103);     // Catch: Throwable -> L17 Exception -> L19
    L19:
        r100 = "";
    L17:
        th = move-exception;
        throw th;
    }

    public static String h() {
        if (A != null) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(f32354z) == false) goto L9;
        A.put(EngineImpl.KEY_CUID, AppMD5.encodeUrlParamsValue(c()));
    L9:
        A.put("zid", p());
        Date r100 = new Date();
        long r101 = r100.getTime() + ((long) (r100.getSeconds() * 1000));
        A.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", new Object[]{Double.valueOf((r101 / 1000) + ((r101 % 1000) / 1000.0d))})));
        StringBuilder r102 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r103 = A.entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, String> r104 = r103.next();
        r102.append("&");
        r102.append(r104.getKey());
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r104.getValue());
        goto L11
    L14:
        return r102.toString();
    }

    public static Map<String, String> j() {
        if (TextUtils.isEmpty(f32354z) == false) goto L6;
        c();
    L6:
        return A;
    }

    private static String p() {
        Context r100 = f32352x;
        if (r100 != null) goto L5;
        return "";
    L5:
        String r101 = MH.gzfi(r100, null, 3041, null, null);
        if (r101 != null) goto L8;
    L14:
        return "";
    L8:
        if (r101.length() <= 0) goto L14;
        if (r101.equals(C) == true) goto L13;
        C = r101;
        SysUpdateObservable.getInstance().updateZid(C);
    L13:
        return r101;
    }

    private static boolean q() {
        int r100 = 0;
        if (f32352x != null) goto L5;
        return false;
    L5:
        HashMap r101 = new HashMap();
        JsonBuilder r102 = new JsonBuilder();
        r102.arrayValue();
        byte[] r103 = a(f32352x);
        if (r103 != null) goto L8;
    L10:
        r102.endArrayValue();
        r101.put(EngineImpl.KEY_CUID, f32354z);
        r101.put("p", f32352x.getPackageName());
        r101.put("s", r102.getJson());
        r101.put("arv", f32334f);
        r101.put("arl", f32335g);
        r101.put("mod", f32332d);
        r101.put("ws", f32343o);
        if (Initializer.getCommonInfo() == null) goto L13;
        r101.put(EngineImpl.KEY_OAID, Initializer.getCommonInfo().getOAID());
    L13:
        MH.init(f32352x, r101);
        return true;
    L8:
        if (r100 >= r103.length) goto L10;
        r102.value(r103[r100]);
        r100 = r100 + 1;
        goto L8
    }

    private static void r() {
        f32343o = "0";
    }

    public static String s() {
        JsonBuilder r100 = new JsonBuilder();
        r100.object();
        r100.putStringValue("cpu", f32345q);
        r100.putStringValue("resid", f32330b);
        r100.putStringValue("channel", f32344p);
        r100.putStringValue("glr", f32346r);
        r100.putStringValue("glv", f32347s);
        r100.putStringValue(Keys.API_PARAM_KEY_MB, l());
        r100.putStringValue(com.alipay.sdk.m.s.a.f25762t, o());
        r100.putStringValue("os", k());
        r100.key("dpi_x").value(d());
        r100.key("dpi_y").value(d());
        r100.putStringValue(com.alipay.sdk.m.k.b.f25406k, f32343o);
        r100.putStringValue(EngineImpl.KEY_CUID, f32354z);
        r100.putStringValue("zid", p());
        if (f32352x != null) goto L5;
        f32352x = JNIInitializer.getCachedContext();
    L5:
        Context r101 = f32352x;
        if (r101 == null) goto L8;
        r100.putStringValue("pcn", r101.getPackageName());
    L8:
        r100.key("screen_x").value(m());
        r100.key("screen_y").value(n());
        r100.endObject();
        String r102 = r100.getJson();
        B = r102;
        return r102;
    }

    public static void t() {
        com.baidu.mapsdkplatform.comjni.util.a r100 = f32329a;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public static void w() {
        A.put(com.alipay.sdk.m.k.b.f25406k, AppMD5.encodeUrlParamsValue(f()));
        A.put("appid", AppMD5.encodeUrlParamsValue(f32350v));
        A.put("bduid", "");
        JsonBuilder r100 = new JsonBuilder();
        r100.object();
        if (Initializer.isAgreePrivacyMode() == false) goto L5;
        f32333e = "Android" + Build.VERSION.SDK;
        f32334f = Build.VERSION.RELEASE;
        f32332d = Build.MODEL;
        f32335g = String.valueOf(Build.VERSION.SDK_INT);
    L6:
        HashMap r101 = new HashMap();
        r101.put("arv", f32334f);
        r101.put("arl", f32335g);
        r101.put("mod", f32332d);
        r101.put("ws", f32343o);
        if (D == false) goto L9;
        a(r101);
    L9:
        r100.putStringValue("cpu", f32345q);
        r100.putStringValue("resid", f32330b);
        r100.putStringValue("channel", f32344p);
        r100.putStringValue("glr", f32346r);
        r100.putStringValue("glv", f32347s);
        r100.putStringValue(Keys.API_PARAM_KEY_MB, l());
        r100.putStringValue(com.alipay.sdk.m.s.a.f25762t, o());
        r100.putStringValue("os", k());
        r100.key("dpi_x").value(d());
        r100.key("dpi_y").value(d());
        r100.putStringValue(com.alipay.sdk.m.k.b.f25406k, f32343o);
        r100.putStringValue(EngineImpl.KEY_CUID, f32354z);
        Context r102 = f32352x;
        if (r102 == null) goto L12;
        r100.putStringValue("pcn", r102.getPackageName());
    L12:
        r100.key("screen_x").value(m());
        r100.key("screen_y").value(n());
        r100.putStringValue("appid", f32350v);
        r100.putStringValue("duid", f32351w);
        r100.putStringValue("zid", p());
        if (TextUtils.isEmpty(F) == true) goto L15;
        r100.putStringValue("token", F);
    L15:
        r100.endObject();
        SysUpdateObservable.getInstance().updatePhoneInfo(r100.getJson());
        return;
    L5:
        f32333e = "Android";
        f32334f = "";
        f32332d = "";
        f32335g = "";
        goto L6
    }

    public static String a() {
        return F;
    }

    public static String b() {
        return f32344p;
    }

    public static int d() {
        return f32342n;
    }

    public static String e() {
        return f32348t;
    }

    public static String f() {
        return f32343o;
    }

    public static String g() {
        return f32331c;
    }

    public static String i() {
        return B;
    }

    public static String k() {
        return f32333e;
    }

    public static String l() {
        return f32332d;
    }

    public static int m() {
        return f32338j;
    }

    public static int n() {
        return f32339k;
    }

    public static String o() {
        return f32336h;
    }

    public static void v() {
        t();
    }

    public static byte[] a(Context r100) {
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return null;
    L4:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        SigningInfo r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo;     // Catch: Exception -> L18
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r101.hasMultipleSigners() == false) goto L11;
        Signature[] r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.getApkContentsSigners();     // Catch: Exception -> L18
    L13:
        if (r102 == null) goto L20;
        if (r102.length <= 0) goto L20;
        return r102[0].toByteArray();
    L11:
        r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.getSigningCertificateHistory();     // Catch: Exception -> L18
        goto L13
    L12:
        r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 64).signatures;     // Catch: Exception -> L18
        goto L13
    }

    public static void b(Context r100) {
        f32352x = r100;
        if (r100.getFilesDir() == null) goto L6;
        f32348t = r100.getFilesDir().getAbsolutePath();
    L6:
        if (r100.getCacheDir() == null) goto L8;
        f32349u = r100.getCacheDir().getAbsolutePath();
    L8:
        MH.setAgreePolicy(f32352x, E);
        if (Initializer.isAgreePrivacyMode() == false) goto L13;
        f32333e = "Android" + Build.VERSION.SDK;
        f32334f = Build.VERSION.RELEASE;
        f32332d = Build.MODEL;
        f32335g = String.valueOf(Build.VERSION.SDK_INT);
        if (D == true) goto L14;
        q();
        D = true;
    L14:
        f32331c = r100.getPackageName();
        c(r100);
        d(r100);
        r();
        A.put("zid", p());
        A.put("resid", AppMD5.encodeUrlParamsValue(f32330b));
        A.put("channel", AppMD5.encodeUrlParamsValue(b()));
        A.put(Keys.API_PARAM_KEY_MB, AppMD5.encodeUrlParamsValue(l()));
        A.put(com.alipay.sdk.m.s.a.f25762t, AppMD5.encodeUrlParamsValue(o()));
        A.put("os", AppMD5.encodeUrlParamsValue(k()));
        A.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", new Object[]{Integer.valueOf(d()), Integer.valueOf(d())})));
        if (TextUtils.isEmpty(f32354z) == true) goto L17;
        A.put(EngineImpl.KEY_CUID, AppMD5.encodeUrlParamsValue(f32354z));
    L17:
        Context r101 = f32352x;
        if (r101 == null) goto L20;
        A.put("pcn", AppMD5.encodeUrlParamsValue(r101.getPackageName()));
    L20:
        A.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", new Object[]{Integer.valueOf(m()), Integer.valueOf(n())})));
        com.baidu.mapsdkplatform.comjni.util.a r102 = f32329a;
        if (r102 == null) goto L24;
        r102.a();
        return;
    L24:
        return;
    L13:
        f32333e = "Android";
        f32334f = "";
        f32332d = "";
        f32335g = "";
        goto L14
    }

    private static void c(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        PackageInfo r102 = r101.getPackageInfo(r100.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L10
        String r103 = VersionInfo.getApiVersion();     // Catch: PackageManager.NameNotFoundException -> L10
        f32336h = r103;     // Catch: PackageManager.NameNotFoundException -> L10
        if (r103 != null) goto L6;
    L8:
        f32337i = r102.versionCode;     // Catch: PackageManager.NameNotFoundException -> L10
        return;
    L6:
        if (r103.equals("") == true) goto L8;
        f32336h = f32336h.replace('_', '.');     // Catch: PackageManager.NameNotFoundException -> L10
    L10:
        f32336h = "1.0.0";
        f32337i = 1;
    }

    private static void d(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        if (r101 == null) goto L5;
        Display r103 = r101.getDefaultDisplay();
    L6:
        if (r103 == null) goto L8;
        f32338j = r103.getWidth();
        f32339k = r103.getHeight();
        r103.getMetrics(r102);
    L8:
        f32353y = r102.density;
        f32340l = (int) r102.xdpi;
        f32341m = (int) r102.ydpi;
        int r104 = r102.densityDpi;
        f32342n = r104;
        if (r104 != 0) goto L12;
        f32342n = 160;
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static void e(Context r100) {
        f32352x = r100;
    }

    private static boolean a(HashMap<String, String> r100) {
        Context r101 = f32352x;
        if (r101 != null) goto L6;
        return false;
    L6:
        MH.ud(r101, r100);
        return true;
    }

    public static void b(boolean r100) {
        if (E != r100) goto L5;
        return;
    L5:
        E = r100;
        Context r101 = f32352x;
        if (r101 != null) goto L8;
        return;
    L8:
        MH.setAgreePolicy(r101, r100);
        if (D == true) goto L12;
        if (r100 == false) goto L12;
        q();
        D = true;
    L12:
        w();
    }

    public static void a(boolean r100) {
        Context r101 = f32352x;
        if (r101 != null) goto L5;
        return;
    L5:
        MH.setAppStatus(r101, r100);
    }

    public static void a(String r100) {
        f32343o = r100;
        w();
    }

    public static void a(String r100, String r101) {
        f32350v = r101;
        f32351w = r100;
        w();
    }
}
