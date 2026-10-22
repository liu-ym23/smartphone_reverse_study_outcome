package com.bytedance.apm.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharSequence f6668a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CharSequence f6669b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CharSequence f6670c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f6671d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f6672e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f6673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f6674g;

    static {
        f6668a = "sony";
        f6669b = "amigo";
        f6670c = "funtouch";
    }

    public static String a() {
        return l("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String b() {
        return Build.DISPLAY + "_" + l("ro.gn.sv.version");
    }

    public static String c() {
        if (p() == true) goto L5;
        return "";
    L5:
        return "coloros_" + l("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String d() {
        String r10 = f();
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains("emotionui") == true) goto L7;
        return "";
    L7:
        return r10 + "_" + Build.DISPLAY;
    }

    public static String e() {
        if (q() == true) goto L5;
        return "";
    L5:
        return "eui_" + l("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String f() {
        return l("ro.build.version.emui");
    }

    public static String g() {
        String r10 = Build.DISPLAY;
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains("flyme") == false) goto L9;
        return r10;
    L9:
        return "";
    }

    public static String h() {
        return l("ro.vivo.os.build.display.id") + "_" + l("ro.vivo.product.version");
    }

    public static String i() {
        if (u() == true) goto L5;
        return "";
    L5:
        return "miui_" + l("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String j() {
        if (u() == false) goto L7;
        return i();
    L7:
        if (r() == false) goto L11;
        return g();
    L11:
        if (p() == true) goto L13;
        String r10 = d();
        if (TextUtils.isEmpty(r10) == true) goto L18;
        return r10;
    L18:
        if (s() == false) goto L22;
        return h();
    L22:
        if (o() == false) goto L26;
        return b();
    L26:
        if (n() == true) goto L28;
        String r11 = e();
        if (TextUtils.isEmpty(r11) == true) goto L32;
        return r11;
    L32:
        f6672e = true;
        return Build.DISPLAY;
    L28:
        return a();
    L13:
        return c();
    }

    public static String k() {
        if (f6672e == true) goto L5;
    L8:
        String r10 = j();
        f6673f = r10;
        return r10;
    L5:
        if (TextUtils.isEmpty(f6673f) == true) goto L8;
        return f6673f;
    }

    public static String l(String r10) {
        String r11 = m(r10);
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        String r12 = "";
        BufferedReader r13 = null;
        Process r14 = Runtime.getRuntime().exec("getprop " + r10);     // Catch: Throwable -> L13
        BufferedReader r15 = new BufferedReader(new InputStreamReader(r14.getInputStream()), 1024);     // Catch: Throwable -> L13
        r12 = r15.readLine();     // Catch: Throwable -> L10
        r14.destroy();     // Catch: Throwable -> L10
        i5.d.b(r15);
        return r12;
    L10:
        r13 = r15;
    L11:
        i5.d.b(r13);
        return r12;
    }

    public static String m(String r10) {
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (f6674g != null) goto L7;
        f6674g = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});     // Catch: Exception -> L5
    L7:
        return (String) f6674g.invoke(null, new Object[]{r10});
    }

    public static boolean n() {
        String r10 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        String r11 = r10.toLowerCase(Locale.getDefault());
        if (r11.contains("360") == false) goto L8;
    L9:
        return true;
    L8:
        if (r11.contains("qiku") == true) goto L9;
        return false;
    }

    public static boolean o() {
        String r10 = Build.DISPLAY;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains(f6669b) == false) goto L7;
        return true;
    }

    public static boolean p() {
        String r10 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        return r10.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static boolean q() {
        return !TextUtils.isEmpty(l("ro.letv.release.version"));
    }

    public static boolean r() {
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
        return true;
    L5:
        if ("flyme".equals(Build.USER) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean s() {
        String r10 = l("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains(f6670c) == false) goto L7;
        return true;
    }

    public static boolean t() {
        String r10 = Build.BRAND;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r10) == false) goto L7;
    L8:
        String r11 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r11) == true) goto L17;
        if (r11.toLowerCase().startsWith("hua") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r10.toLowerCase().startsWith("hua") == true) goto L12;
    L19:
        return false;
    }

    public static boolean u() {
        Class.forName("miui.os.Build");     // Catch: Exception -> L4
        f6671d = true;     // Catch: Exception -> L4
        return true;
    L5:
        return f6671d;
    }
}
