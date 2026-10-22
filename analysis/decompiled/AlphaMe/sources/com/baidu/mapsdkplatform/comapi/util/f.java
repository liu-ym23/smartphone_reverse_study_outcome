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
import ch.qos.logback.core.CoreConstants;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mshield.MH;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.stepos.alphame.utils.Consts;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    /* renamed from: C, reason: collision with root package name */
    private static String f8226C;

    /* renamed from: F, reason: collision with root package name */
    public static String f8229F;

    /* renamed from: c, reason: collision with root package name */
    private static String f8232c;

    /* renamed from: d, reason: collision with root package name */
    private static String f8233d;

    /* renamed from: e, reason: collision with root package name */
    private static String f8234e;

    /* renamed from: f, reason: collision with root package name */
    private static String f8235f;

    /* renamed from: g, reason: collision with root package name */
    private static String f8236g;

    /* renamed from: h, reason: collision with root package name */
    private static String f8237h;

    /* renamed from: i, reason: collision with root package name */
    private static int f8238i;

    /* renamed from: j, reason: collision with root package name */
    private static int f8239j;

    /* renamed from: k, reason: collision with root package name */
    private static int f8240k;

    /* renamed from: l, reason: collision with root package name */
    private static int f8241l;

    /* renamed from: m, reason: collision with root package name */
    private static int f8242m;

    /* renamed from: n, reason: collision with root package name */
    private static int f8243n;

    /* renamed from: o, reason: collision with root package name */
    private static String f8244o;

    /* renamed from: t, reason: collision with root package name */
    private static String f8249t;

    /* renamed from: u, reason: collision with root package name */
    private static String f8250u;

    /* renamed from: x, reason: collision with root package name */
    public static Context f8253x;

    /* renamed from: a, reason: collision with root package name */
    private static com.baidu.mapsdkplatform.comjni.util.a f8230a = new com.baidu.mapsdkplatform.comjni.util.a();

    /* renamed from: b, reason: collision with root package name */
    private static String f8231b = "02";

    /* renamed from: p, reason: collision with root package name */
    private static String f8245p = "baidu";

    /* renamed from: q, reason: collision with root package name */
    private static String f8246q = "";

    /* renamed from: r, reason: collision with root package name */
    private static String f8247r = "";

    /* renamed from: s, reason: collision with root package name */
    private static String f8248s = "";

    /* renamed from: v, reason: collision with root package name */
    private static String f8251v = "-1";

    /* renamed from: w, reason: collision with root package name */
    private static String f8252w = "-1";

    /* renamed from: y, reason: collision with root package name */
    public static float f8254y = 1.0f;

    /* renamed from: z, reason: collision with root package name */
    private static String f8255z = "";

    /* renamed from: A, reason: collision with root package name */
    private static Map<String, String> f8224A = new HashMap();

    /* renamed from: B, reason: collision with root package name */
    private static String f8225B = "";

    /* renamed from: D, reason: collision with root package name */
    private static boolean f8227D = false;

    /* renamed from: E, reason: collision with root package name */
    private static boolean f8228E = false;

    public static void a(boolean z4) {
        Context context = f8253x;
        if (context == null) {
            return;
        }
        MH.setAppStatus(context, z4);
    }

    public static void b(boolean z4) {
        if (f8228E == z4) {
            return;
        }
        f8228E = z4;
        Context context = f8253x;
        if (context == null) {
            return;
        }
        MH.setAgreePolicy(context, z4);
        if (!f8227D && z4) {
            p();
            f8227D = true;
        }
        v();
    }

    private static void c(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String apiVersion = VersionInfo.getApiVersion();
            f8237h = apiVersion;
            if (apiVersion != null && !apiVersion.equals("")) {
                f8237h = f8237h.replace('_', CoreConstants.DOT);
            }
            f8238i = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            f8237h = "1.0.0";
            f8238i = 1;
        }
    }

    private static void d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            f8239j = defaultDisplay.getWidth();
            f8240k = defaultDisplay.getHeight();
            defaultDisplay.getMetrics(displayMetrics);
        }
        f8254y = displayMetrics.density;
        f8241l = (int) displayMetrics.xdpi;
        f8242m = (int) displayMetrics.ydpi;
        int i4 = displayMetrics.densityDpi;
        f8243n = i4;
        if (i4 == 0) {
            f8243n = 160;
        }
    }

    public static void e(Context context) {
        f8253x = context;
    }

    public static String f() {
        return f8244o;
    }

    public static String g() {
        return f8232c;
    }

    public static String h() {
        if (f8224A == null) {
            return null;
        }
        if (TextUtils.isEmpty(f8255z)) {
            f8224A.put(EngineImpl.KEY_CUID, AppMD5.encodeUrlParamsValue(c()));
        }
        f8224A.put("zid", o());
        long time = new Date().getTime() + (r0.getSeconds() * 1000);
        f8224A.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf(((time % 1000) / 1000.0d) + (time / 1000)))));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : f8224A.entrySet()) {
            sb.append("&");
            sb.append(entry.getKey());
            sb.append(Consts.SPLITTER_EQUAL);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static String i() {
        return f8225B;
    }

    public static String j() {
        return f8234e;
    }

    public static String k() {
        return f8233d;
    }

    public static int l() {
        return f8239j;
    }

    public static int m() {
        return f8240k;
    }

    public static String n() {
        return f8237h;
    }

    private static String o() {
        String strGzfi;
        Context context = f8253x;
        if (context == null || (strGzfi = MH.gzfi(context, null, 3041, null, null)) == null || strGzfi.length() <= 0) {
            return "";
        }
        if (!strGzfi.equals(f8226C)) {
            f8226C = strGzfi;
            SysUpdateObservable.getInstance().updateZid(f8226C);
        }
        return strGzfi;
    }

    private static boolean p() {
        if (f8253x == null) {
            return false;
        }
        HashMap map = new HashMap();
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.arrayValue();
        byte[] bArrA = a(f8253x);
        if (bArrA != null) {
            for (byte b4 : bArrA) {
                jsonBuilder.value((int) b4);
            }
        }
        jsonBuilder.endArrayValue();
        map.put(EngineImpl.KEY_CUID, f8255z);
        map.put("p", f8253x.getPackageName());
        map.put("s", jsonBuilder.getJson());
        map.put("arv", f8235f);
        map.put("arl", f8236g);
        map.put("mod", f8233d);
        map.put("ws", f8244o);
        if (Initializer.getCommonInfo() != null) {
            map.put(EngineImpl.KEY_OAID, Initializer.getCommonInfo().getOAID());
        }
        MH.init(f8253x, map);
        return true;
    }

    private static void q() {
        f8244o = "0";
    }

    public static String r() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        jsonBuilder.putStringValue("cpu", f8246q);
        jsonBuilder.putStringValue("resid", f8231b);
        jsonBuilder.putStringValue("channel", f8245p);
        jsonBuilder.putStringValue("glr", f8247r);
        jsonBuilder.putStringValue("glv", f8248s);
        jsonBuilder.putStringValue("mb", k());
        jsonBuilder.putStringValue("sv", n());
        jsonBuilder.putStringValue("os", j());
        jsonBuilder.key("dpi_x").value(d());
        jsonBuilder.key("dpi_y").value(d());
        jsonBuilder.putStringValue("net", f8244o);
        jsonBuilder.putStringValue(EngineImpl.KEY_CUID, f8255z);
        jsonBuilder.putStringValue("zid", o());
        if (f8253x == null) {
            f8253x = JNIInitializer.getCachedContext();
        }
        Context context = f8253x;
        if (context != null) {
            jsonBuilder.putStringValue("pcn", context.getPackageName());
        }
        jsonBuilder.key("screen_x").value(l());
        jsonBuilder.key("screen_y").value(m());
        jsonBuilder.endObject();
        String json = jsonBuilder.getJson();
        f8225B = json;
        return json;
    }

    public static void s() {
        com.baidu.mapsdkplatform.comjni.util.a aVar = f8230a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static void t() {
        f8229F = null;
    }

    public static void u() {
        s();
    }

    public static void v() {
        f8224A.put("net", AppMD5.encodeUrlParamsValue(f()));
        f8224A.put("appid", AppMD5.encodeUrlParamsValue(f8251v));
        f8224A.put("bduid", "");
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        if (Initializer.isAgreePrivacyMode()) {
            f8234e = "Android" + Build.VERSION.SDK;
            f8235f = Build.VERSION.RELEASE;
            f8233d = Build.MODEL;
            f8236g = String.valueOf(Build.VERSION.SDK_INT);
        } else {
            f8234e = "Android";
            f8235f = "";
            f8233d = "";
            f8236g = "";
        }
        HashMap map = new HashMap();
        map.put("arv", f8235f);
        map.put("arl", f8236g);
        map.put("mod", f8233d);
        map.put("ws", f8244o);
        if (f8227D) {
            a((HashMap<String, String>) map);
        }
        jsonBuilder.putStringValue("cpu", f8246q);
        jsonBuilder.putStringValue("resid", f8231b);
        jsonBuilder.putStringValue("channel", f8245p);
        jsonBuilder.putStringValue("glr", f8247r);
        jsonBuilder.putStringValue("glv", f8248s);
        jsonBuilder.putStringValue("mb", k());
        jsonBuilder.putStringValue("sv", n());
        jsonBuilder.putStringValue("os", j());
        jsonBuilder.key("dpi_x").value(d());
        jsonBuilder.key("dpi_y").value(d());
        jsonBuilder.putStringValue("net", f8244o);
        jsonBuilder.putStringValue(EngineImpl.KEY_CUID, f8255z);
        Context context = f8253x;
        if (context != null) {
            jsonBuilder.putStringValue("pcn", context.getPackageName());
        }
        jsonBuilder.key("screen_x").value(l());
        jsonBuilder.key("screen_y").value(m());
        jsonBuilder.putStringValue("appid", f8251v);
        jsonBuilder.putStringValue("duid", f8252w);
        jsonBuilder.putStringValue("zid", o());
        if (!TextUtils.isEmpty(f8229F)) {
            jsonBuilder.putStringValue("token", f8229F);
        }
        jsonBuilder.endObject();
        SysUpdateObservable.getInstance().updatePhoneInfo(jsonBuilder.getJson());
    }

    public static String e() {
        return f8249t;
    }

    public static String a() {
        return f8229F;
    }

    public static byte[] a(Context context) {
        SigningInfo signingInfo;
        Signature[] signingCertificateHistory;
        try {
            signingInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (signingInfo == null) {
            return null;
        }
        if (signingInfo.hasMultipleSigners()) {
            signingCertificateHistory = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo.getApkContentsSigners();
        } else {
            signingCertificateHistory = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo.getSigningCertificateHistory();
        }
        if (signingCertificateHistory != null && signingCertificateHistory.length > 0) {
            return signingCertificateHistory[0].toByteArray();
        }
        return null;
    }

    public static void b(Context context) throws PackageManager.NameNotFoundException {
        f8253x = context;
        if (context.getFilesDir() != null) {
            f8249t = context.getFilesDir().getAbsolutePath();
        }
        if (context.getCacheDir() != null) {
            f8250u = context.getCacheDir().getAbsolutePath();
        }
        MH.setAgreePolicy(f8253x, f8228E);
        if (Initializer.isAgreePrivacyMode()) {
            f8234e = "Android" + Build.VERSION.SDK;
            f8235f = Build.VERSION.RELEASE;
            f8233d = Build.MODEL;
            f8236g = String.valueOf(Build.VERSION.SDK_INT);
            if (!f8227D) {
                p();
                f8227D = true;
            }
        } else {
            f8234e = "Android";
            f8235f = "";
            f8233d = "";
            f8236g = "";
        }
        f8232c = context.getPackageName();
        c(context);
        d(context);
        q();
        f8224A.put("zid", o());
        f8224A.put("resid", AppMD5.encodeUrlParamsValue(f8231b));
        f8224A.put("channel", AppMD5.encodeUrlParamsValue(b()));
        f8224A.put("mb", AppMD5.encodeUrlParamsValue(k()));
        f8224A.put("sv", AppMD5.encodeUrlParamsValue(n()));
        f8224A.put("os", AppMD5.encodeUrlParamsValue(j()));
        f8224A.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(d()), Integer.valueOf(d()))));
        if (!TextUtils.isEmpty(f8255z)) {
            f8224A.put(EngineImpl.KEY_CUID, AppMD5.encodeUrlParamsValue(f8255z));
        }
        Context context2 = f8253x;
        if (context2 != null) {
            f8224A.put("pcn", AppMD5.encodeUrlParamsValue(context2.getPackageName()));
        }
        f8224A.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(l()), Integer.valueOf(m()))));
        com.baidu.mapsdkplatform.comjni.util.a aVar = f8230a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static String c() {
        String cuid;
        try {
            cuid = LBSAuthManager.getInstance(f8253x).getCUID();
            if (!TextUtils.isEmpty(cuid) && !cuid.equals(f8255z)) {
                f8255z = cuid;
                if (f8224A != null) {
                    f8224A.put(EngineImpl.KEY_CUID, AppMD5.encodeUrlParamsValue(c()));
                }
                SysUpdateObservable.getInstance().updateCuid(f8255z);
                HashMap map = new HashMap();
                map.put(EngineImpl.KEY_CUID, f8255z);
                MH.ud(f8253x, map);
            }
        } catch (Exception unused) {
            cuid = "";
        }
        return cuid == null ? "" : cuid;
    }

    public static int d() {
        return f8243n;
    }

    private static boolean a(HashMap<String, String> map) {
        Context context = f8253x;
        if (context == null) {
            return false;
        }
        MH.ud(context, map);
        return true;
    }

    public static void a(String str) {
        f8244o = str;
        v();
    }

    public static void a(String str, String str2) {
        f8251v = str2;
        f8252w = str;
        v();
    }

    public static String b() {
        return f8245p;
    }
}
