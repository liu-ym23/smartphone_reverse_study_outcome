package r3;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharSequence f23722a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CharSequence f23723b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CharSequence f23724c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f23725d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f23726e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f23727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f23728g;

    static {
        f23722a = "sony";
        f23723b = "amigo";
        f23724c = "funtouch";
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
        if (t() == true) goto L5;
        return "";
    L5:
        return "miui_" + l("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String j() {
        if (t() == false) goto L7;
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
        f23726e = true;
        return Build.DISPLAY;
    L28:
        return a();
    L13:
        return c();
    }

    public static String k() {
        if (f23726e == true) goto L5;
    L8:
        String r10 = j();
        f23727f = r10;
        return r10;
    L5:
        if (TextUtils.isEmpty(f23727f) == true) goto L8;
        return f23727f;
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
        d.a(r15);
        return r12;
    L10:
        r13 = r15;
    L11:
        d.a(r13);
        return r12;
    }

    public static String m(String r10) {
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (f23728g != null) goto L7;
        f23728g = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});     // Catch: Exception -> L5
    L7:
        return (String) f23728g.invoke(null, new Object[]{r10});
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
        if (r10.toLowerCase(Locale.getDefault()).contains(f23723b) == false) goto L7;
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
        if (r10.toLowerCase(Locale.getDefault()).contains(f23724c) == false) goto L7;
        return true;
    }

    public static boolean t() {
        Class.forName("miui.os.Build");     // Catch: Exception -> L4
        f23725d = true;     // Catch: Exception -> L4
        return true;
    L5:
        return f23725d;
    }
}
