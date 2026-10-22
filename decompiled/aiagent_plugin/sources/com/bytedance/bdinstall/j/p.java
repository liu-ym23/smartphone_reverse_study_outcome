package com.bytedance.bdinstall.j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f6327a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CharSequence f6328b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final r<Boolean> f6329c = null;

    static {
        f6327a = "sony";
        f6328b = "amigo";
        f6329c = new AnonymousClass1();
    }

    public static String a() {
        return b("ro.build.version.emui");
    }

    public static String b() {
        if (o() == false) goto L7;
        return p();
    L7:
        if (s() == true) goto L9;
        String r0 = q();
        if (TextUtils.isEmpty(r0) == true) goto L14;
        return r0;
    L14:
        if (h() == false) goto L18;
        return f();
    L18:
        if (g() == false) goto L22;
        return r();
    L22:
        if (i() == false) goto L26;
        return j();
    L26:
        if (e() == true) goto L28;
        String r1 = k();
        if (TextUtils.isEmpty(r1) == true) goto L33;
        return r1;
    L33:
        return Build.DISPLAY;
    L28:
        return d();
    L9:
        return v();
    }

    public static String c() {
        String r0 = a("persist.pxr.product.forcename", "");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = a("pxr.vendorhw.product.name", "");
    L6:
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        return Build.PRODUCT;
    }

    public static String a(String r8, String r9) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, r9}), String.class, "com.obric.aiagent.plugin");
    L5:
        return r9;
    }

    public static String d() {
        return b("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean e() {
        String r0 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        String r1 = r0.toLowerCase();
        if (r1.contains("360") == false) goto L8;
    L9:
        return true;
    L8:
        if (r1.contains("qiku") == true) goto L9;
        return false;
    }

    public static String f() {
        return b("ro.vivo.os.build.display.id") + "_" + b("ro.vivo.product.version");
    }

    public static boolean a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r3 = a();
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (r3.toLowerCase().contains("emotionui") == false) goto L10;
    L11:
        return true;
    L10:
        if (r3.toLowerCase().contains("magicui") == true) goto L11;
    L13:
        if (G() == false) goto L15;
        return true;
    L15:
        if (m() == true) goto L20;
        return false;
    L20:
        return true;
    }

    public static boolean g() {
        if (TextUtils.isEmpty(Build.DISPLAY) == true) goto L7;
        if (Build.DISPLAY.contains("Flyme") == false) goto L7;
    L8:
        return true;
    L7:
        if ("flyme".equals(Build.USER) == true) goto L8;
        return false;
    }

    public static boolean h() {
        return !TextUtils.isEmpty(b("ro.vivo.os.build.display.id"));
    }

    public static boolean i() {
        if (TextUtils.isEmpty(Build.DISPLAY) == false) goto L5;
    L7:
        return false;
    L5:
        if (Build.DISPLAY.toLowerCase().contains(f6328b) == false) goto L7;
        return true;
    }

    public static String j() {
        return Build.DISPLAY + "_" + b("ro.gn.sv.version");
    }

    public static String k() {
        if (l() == true) goto L5;
        return "";
    L5:
        return "eui_" + b("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean l() {
        return !TextUtils.isEmpty(b("ro.letv.release.version"));
    }

    private static boolean G() {
        if (TextUtils.isEmpty(Build.BRAND) == true) goto L7;
        if (Build.BRAND.toLowerCase().startsWith("huawei") == false) goto L7;
    L10:
        return true;
    L7:
        if (TextUtils.isEmpty(Build.MANUFACTURER) == false) goto L9;
    L11:
        return false;
    L9:
        if (Build.MANUFACTURER.toLowerCase().startsWith("huawei") == false) goto L11;
        goto L10
    }

    public static boolean m() {
        if (TextUtils.isEmpty(Build.BRAND) == true) goto L7;
        if (Build.BRAND.toLowerCase().startsWith("honor") == false) goto L7;
    L12:
        return true;
    L7:
        if (TextUtils.isEmpty(Build.MANUFACTURER) == true) goto L11;
        if (Build.MANUFACTURER.toLowerCase().startsWith("honor") == true) goto L12;
    L11:
        if ("HONOR".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L12;
        return false;
    }

    public static boolean n() {
        Class r2 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        String r0 = (String) ZeusTransformUtils.preCheckCast(r2.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r2, new Object[]{"ro.build.version.emui"}), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r0) == true) goto L9;
        com.bytedance.bdinstall.t.a("honor# oldHonor device, version is" + r0);     // Catch: Exception -> L7
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        com.bytedance.bdinstall.t.b("Honor# " + e.getMessage(), e);
        goto L9
    }

    public static boolean o() {
        if (ZeusTransformUtils.forName("miui.os.Build", "com.obric.aiagent.plugin").getName().length() <= 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public static String p() {
        if (o() == true) goto L5;
        return "";
    L5:
        return "miui_" + b("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String q() {
        String r0 = a();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase().contains("emotionui") == true) goto L9;
        if (r0.toLowerCase().contains("magicui") == true) goto L9;
        return "";
    L9:
        return r0 + "_" + Build.DISPLAY;
    }

    public static String r() {
        String r0 = Build.DISPLAY;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase().contains("flyme") == false) goto L9;
        return r0;
    L9:
        return "";
    }

    public static boolean s() {
        if ("oppo".equalsIgnoreCase(Build.MANUFACTURER) == false) goto L5;
    L10:
        return true;
    L5:
        if ("oppo".equalsIgnoreCase(Build.BRAND) == true) goto L10;
        if ("realme".equalsIgnoreCase(Build.BRAND) == true) goto L10;
        return false;
    }

    public static boolean t() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase("XIAOMI") == true) goto L10;
        if (Build.BRAND.equalsIgnoreCase("REDMI") == true) goto L10;
        return false;
    }

    public static boolean u() {
        if ("BlackShark".equalsIgnoreCase(Build.MANUFACTURER) == false) goto L5;
    L8:
        return true;
    L5:
        if ("BlackShark".equalsIgnoreCase(Build.BRAND) == true) goto L8;
        return false;
    }

    public static String v() {
        if (s() == true) goto L5;
        return "";
    L5:
        return "coloros_" + b("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    private static String b(String r2) {
        return (String) ZeusTransformUtils.preCheckCast(u.a(r2), String.class, "com.obric.aiagent.plugin");
    }

    public static boolean w() {
        String r0 = Build.BRAND;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean x() {
        if ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER) == false) goto L5;
    L8:
        return true;
    L5:
        if ("OnePlus".equalsIgnoreCase(Build.BRAND) == true) goto L8;
        return false;
    }

    public static boolean y() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == false) goto L5;
    L8:
        return true;
    L5:
        if ("samsung".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L8;
        return false;
    }

    private static String H() {
        if (Build.MANUFACTURER != null) goto L6;
        return "";
    L6:
        return Build.MANUFACTURER.trim();
    }

    public static boolean z() {
        String r0 = Build.FINGERPRINT;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        String r1 = b("ro.build.version.incremental");
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L11:
        return false;
    L9:
        if (r1.contains("VIBEUI_V2") == false) goto L11;
        return true;
    L5:
        return r0.contains("VIBEUI_V2");
    }

    public static boolean A() {
        return H().toUpperCase().contains("NUBIA");
    }

    public static boolean B() {
        return H().toUpperCase().contains("ASUS");
    }

    public static boolean C() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean D() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f6329c.c(new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public static boolean a(Context r2) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().targetSdkVersion < 30) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean E() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 29) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean F() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 28) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean b(Context r2) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().targetSdkVersion < 29) goto L5;
        return true;
    L5:
        return false;
    }
}
