package com.bytedance.apm6.util;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5481a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5482b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CharSequence f5483c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CharSequence f5484d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CharSequence f5485e = null;
    private static String f;
    private static Method g;

    static {
        f5483c = "sony";
        f5484d = "amigo";
        f5485e = "funtouch";
    }

    public static String a() {
        if (f5482b == true) goto L5;
    L8:
        String r0 = s();
        f = r0;
        return r0;
    L5:
        if (TextUtils.isEmpty(f) == true) goto L8;
        return f;
    }

    private static String s() {
        if (r() == false) goto L7;
        return j();
    L7:
        if (o() == false) goto L11;
        return l();
    L11:
        if (m() == true) goto L13;
        String r0 = k();
        if (TextUtils.isEmpty(r0) == true) goto L18;
        return r0;
    L18:
        if (e() == false) goto L22;
        return d();
    L22:
        if (f() == false) goto L26;
        return g();
    L26:
        if (c() == true) goto L28;
        String r1 = h();
        if (TextUtils.isEmpty(r1) == true) goto L32;
        return r1;
    L32:
        f5482b = true;
        return Build.DISPLAY;
    L28:
        return b();
    L13:
        return n();
    }

    public static String b() {
        return a("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean c() {
        String r0 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        String r1 = r0.toLowerCase(Locale.getDefault());
        if (r1.contains("360") == false) goto L8;
    L9:
        return true;
    L8:
        if (r1.contains("qiku") == true) goto L9;
        return false;
    }

    public static String d() {
        return a("ro.vivo.os.build.display.id") + "_" + a("ro.vivo.product.version");
    }

    public static boolean e() {
        String r0 = a("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains(f5485e) == false) goto L7;
        return true;
    }

    public static boolean f() {
        if (TextUtils.isEmpty(Build.DISPLAY) == false) goto L5;
    L7:
        return false;
    L5:
        if (Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(f5484d) == false) goto L7;
        return true;
    }

    public static String g() {
        return Build.DISPLAY + "_" + a("ro.gn.sv.version");
    }

    public static String h() {
        if (i() == true) goto L5;
        return "";
    L5:
        return "eui_" + a("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean i() {
        return !TextUtils.isEmpty(a("ro.letv.release.version"));
    }

    public static String j() {
        if (r() == true) goto L5;
        return "";
    L5:
        return "miui_" + a("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String k() {
        String r0 = p();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains("emotionui") == true) goto L7;
        return "";
    L7:
        return r0 + "_" + Build.DISPLAY;
    }

    public static String l() {
        String r0 = Build.DISPLAY;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains("flyme") == false) goto L9;
        return r0;
    L9:
        return "";
    }

    public static boolean m() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        return r0.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String n() {
        if (m() == true) goto L5;
        return "";
    L5:
        return "coloros_" + a("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    private static String a(String r5) {
        String r0 = b(r5);
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        String r1 = "";
        BufferedReader r2 = null;
        Process r6 = Runtime.getRuntime().exec("getprop " + r5);     // Catch: Throwable -> L13
        BufferedReader r3 = new BufferedReader(new InputStreamReader(r6.getInputStream()), 1024);     // Catch: Throwable -> L13
        r1 = r3.readLine();     // Catch: Throwable -> L10
        r6.destroy();     // Catch: Throwable -> L10
        d.a(r3);
        return r1;
    L10:
        r2 = r3;
    L11:
        d.a(r2);
        return r1;
    }

    private static String b(String r7) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (g != null) goto L6;
        g = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});     // Catch: Exception -> L8
    L6:
        return (String) ZeusTransformUtils.preCheckCast(g.invoke(null, new Object[]{r7}), String.class, "com.obric.aiagent.plugin");
    }

    public static boolean o() {
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
        return true;
    L5:
        if ("flyme".equals(Build.USER) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static String p() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return a("ro.build.version.emui");
    L7:
        return q();
    }

    public static String q() {
        Method r0 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L6
        r0.setAccessible(true);     // Catch: Throwable -> L6
        Object r1 = r0.invoke(null, new Object[]{"ro.build.version.emui"});     // Catch: Throwable -> L6
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L11;
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L11:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static boolean r() {
        if (ZeusTransformUtils.forName("miui.os.Build", "com.obric.aiagent.plugin") == null) goto L7;
        f5481a = true;     // Catch: Exception -> L8
        return true;
    L7:
        return f5481a;
    }
}
