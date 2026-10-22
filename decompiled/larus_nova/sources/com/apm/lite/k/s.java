package com.apm.lite.k;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes39.dex */
public final class s {
    public static String b(String r100) {
        String r101 = "";
        Process r102 = c(Runtime.getRuntime(), "getprop ".concat(r100));     // Catch: Throwable -> L7
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102.getInputStream()), 1024);     // Catch: Throwable -> L7
        r101 = r103.readLine();     // Catch: Throwable -> L10
        r102.destroy();     // Catch: Throwable -> L10
        j.a(r103);
        return r101;
    L8:
        j.a(r103);
        return r101;
    L7:
        r103 = null;
        goto L8
    }

    public static String a() {
        String r100 = "";
        if (e.e() == true) goto L5;
        String r101 = Build.DISPLAY;
        boolean r102 = false;
        if (r101.contains("Flyme") == false) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L21;
        if (r101 != null) goto L18;
        return "";
    L18:
        if (r101.toLowerCase(Locale.getDefault()).contains("flyme") == true) goto L20;
        return "";
    L20:
        return r101;
    L21:
        String r104 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r104) == true) goto L24;
        boolean r105 = r104.toLowerCase(Locale.getDefault()).contains(AppConstants.CHANNEL_OPPO);
    L25:
        if (r105 == true) goto L27;
        String r106 = e.b();
        if (r106 != null) goto L35;
    L37:
        String r107 = "";
    L39:
        if (TextUtils.isEmpty(r107) == true) goto L41;
        return r107;
    L41:
        String r108 = b("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r108) == false) goto L44;
    L46:
        boolean r109 = false;
    L47:
        if (r109 == false) goto L51;
        return b("ro.vivo.os.build.display.id") + "_" + b("ro.vivo.product.version");
    L51:
        if (TextUtils.isEmpty(r101) == false) goto L53;
    L55:
        boolean r110 = false;
    L56:
        if (r110 == true) goto L58;
        String r111 = r104 + Build.BRAND;
        if (TextUtils.isEmpty(r111) == true) goto L67;
        String r112 = r111.toLowerCase(Locale.getDefault());
        if (r112.contains(AppConstants.CHANNEL_360) == false) goto L65;
    L66:
        r102 = true;
        goto L67
    L65:
        if (r112.contains("qiku") == true) goto L66;
    L67:
        if (r102 == false) goto L71;
        return b("ro.build.uiversion") + "_" + r101;
    L71:
        if ((!TextUtils.isEmpty(b("ro.letv.release.version"))) == false) goto L74;
        r100 = "eui_" + b("ro.letv.release.version") + "_" + r101;
    L74:
        if (TextUtils.isEmpty(r100) == true) goto L76;
        return r100;
    L76:
        return r101;
    L58:
        return r101 + "_" + b("ro.gn.sv.version");
    L53:
        if (r101.toLowerCase(Locale.getDefault()).contains("amigo") == false) goto L55;
        r110 = true;
        goto L56
    L44:
        if (r108.toLowerCase(Locale.getDefault()).contains("funtouch") == false) goto L46;
        r109 = true;
        goto L47
    L35:
        if (r106.toLowerCase(Locale.getDefault()).contains("emotionui") == false) goto L37;
        r107 = r106 + "_" + r101;
        goto L39
    L27:
        if (TextUtils.isEmpty(r104) == true) goto L29;
        r102 = r104.toLowerCase(Locale.getDefault()).contains(AppConstants.CHANNEL_OPPO);
    L29:
        if (r102 == true) goto L31;
        return "";
    L31:
        return "coloros_" + b("ro.build.version.opporom") + "_" + r101;
    L24:
        r105 = false;
        goto L25
    L11:
        if (Build.USER.equals("flyme") == true) goto L14;
        r103 = false;
        goto L15
    L5:
        if (e.e() == true) goto L7;
        return "";
    L7:
        return "miui_" + b("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static Process c(Runtime r110, String r111) {
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
}
