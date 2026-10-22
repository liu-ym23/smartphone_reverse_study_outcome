package com.android.ttcjpaysdk.ocr.utils;

import android.os.Build;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes39.dex */
public class RomUtils {
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    private static final String TAG = "Rom";
    private static String sName;
    private static String sVersion;

    public RomUtils() {
    }

    public static boolean isVivo() {
        return check("VIVO");
    }

    public static boolean check(String r100) {
        String r101 = sName;
        if (r101 != null) goto L5;
        String r102 = getProp(KEY_VERSION_MIUI);
        sVersion = r102;
        if (TextUtils.isEmpty(r102) == true) goto L9;
        sName = "MIUI";
    L26:
        return sName.equals(r100);
    L9:
        String r103 = getProp("ro.build.version.emui");
        sVersion = r103;
        if (TextUtils.isEmpty(r103) == true) goto L12;
        sName = "EMUI";
        goto L26
    L12:
        String r104 = getProp(KEY_VERSION_OPPO);
        sVersion = r104;
        if (TextUtils.isEmpty(r104) == true) goto L15;
        sName = "OPPO";
        goto L26
    L15:
        String r105 = getProp(KEY_VERSION_VIVO);
        sVersion = r105;
        if (TextUtils.isEmpty(r105) == true) goto L18;
        sName = "VIVO";
        goto L26
    L18:
        String r106 = getProp(KEY_VERSION_SMARTISAN);
        sVersion = r106;
        if (TextUtils.isEmpty(r106) == true) goto L21;
        sName = "SMARTISAN";
        goto L26
    L21:
        String r107 = Build.DISPLAY;
        sVersion = r107;
        if (r107.toUpperCase().contains("FLYME") == false) goto L24;
        sName = "FLYME";
        goto L26
    L24:
        sVersion = "unknown";
        sName = Build.MANUFACTURER.toUpperCase();
        goto L26
    L5:
        return r101.equals(r100);
    }

    public static String getProp(String r100) {
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(com_android_ttcjpaysdk_ocr_utils_RomUtils_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop " + r100).getInputStream()), 1024);     // Catch: Throwable -> L12 IOException -> L14
        String r103 = r102.readLine();     // Catch: IOException -> L10 Throwable -> L23
        r102.close();     // Catch: IOException -> L10 Throwable -> L23
        r102.close();     // Catch: IOException -> L7
    L9:
        return r103;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("RomUtils#getProp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "RomUtils#getProp", e);
        e.printStackTrace();
    L10:
        e = e;
    L16:
        CJBasicCommonUtils.reportCatchException("RomUtils#getProp", e);     // Catch: Throwable -> L23
        CJBasicCommonUtils.logCatch("CJCatch", "RomUtils#getProp", e);     // Catch: Throwable -> L23
        if (r102 != null) goto L35;
    L22:
        return null;
    L35:
        r102.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("RomUtils#getProp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "RomUtils#getProp", e);
        e.printStackTrace();
    L23:
        th = th;
        r101 = r102;
    L25:
        if (r101 != null) goto L31;
    L30:
        throw th;
    L31:
        r101.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("RomUtils#getProp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "RomUtils#getProp", e);
        e.printStackTrace();
        goto L30
    L14:
        e = e;
        r102 = null;
    L12:
        th = th;
        goto L25
    }

    private static Process com_android_ttcjpaysdk_ocr_utils_RomUtils_java_lang_Runtime_exec(Runtime r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
