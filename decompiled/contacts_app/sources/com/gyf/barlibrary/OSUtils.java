package com.gyf.barlibrary;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class OSUtils {
    private static final String KEY_DISPLAY = "ro.build.display.id";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    public OSUtils() {
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name", ""));
    }

    public static boolean isMIUI6Later() {
        String r0 = getMIUIVersion();
        if (r0.isEmpty() == false) goto L11;
        return false;
    L11:
        if (Integer.valueOf(r0.substring(1)).intValue() >= 6) goto L9;
        return false;
    L9:
        return true;
    L15:
        return false;
    }

    public static String getMIUIVersion() {
        if (isMIUI() == true) goto L5;
        return "";
    L5:
        return getSystemProperty("ro.miui.ui.version.name", "");
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_EMUI_VERSION_NAME, ""));
    }

    public static String getEMUIVersion() {
        if (isEMUI() == true) goto L5;
        return "";
    L5:
        return getSystemProperty(KEY_EMUI_VERSION_NAME, "");
    }

    public static boolean isEMUI3_1() {
        String r0 = getEMUIVersion();
        if ("EmotionUI 3".equals(r0) == false) goto L5;
        return true;
    L5:
        if (r0.contains("EmotionUI_3.1") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isEMUI3_0() {
        if (getEMUIVersion().contains("EmotionUI_3.0") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isEMUI3_x() {
        if (isEMUI3_0() == false) goto L5;
    L8:
        return true;
    L5:
        if (isEMUI3_1() == true) goto L8;
        return false;
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        String r0 = getFlymeOSVersion();
        if (r0.isEmpty() == true) goto L14;
        if (r0.toLowerCase().contains("os") == false) goto L7;
        int r1 = Integer.valueOf(r0.substring(9, 10)).intValue();     // Catch: NumberFormatException -> L12
    L9:
        if (r1 < 4) goto L15;
        return true;
    L15:
        return false;
    L7:
        r1 = Integer.valueOf(r0.substring(6, 7)).intValue();     // Catch: NumberFormatException -> L12
        goto L9
    L16:
        return false;
    L14:
        return false;
    }

    public static boolean isFlymeOS5() {
        String r0 = getFlymeOSVersion();
        if (r0.isEmpty() == true) goto L14;
        if (r0.toLowerCase().contains("os") == false) goto L7;
        int r1 = Integer.valueOf(r0.substring(9, 10)).intValue();     // Catch: NumberFormatException -> L12
    L9:
        if (r1 != 5) goto L15;
        return true;
    L15:
        return false;
    L7:
        r1 = Integer.valueOf(r0.substring(6, 7)).intValue();     // Catch: NumberFormatException -> L12
        goto L9
    L16:
        return false;
    L14:
        return false;
    }

    public static String getFlymeOSVersion() {
        if (isFlymeOS() == true) goto L5;
        return "";
    L5:
        return getSystemProperty(KEY_DISPLAY, "");
    }

    private static String getFlymeOSFlag() {
        return getSystemProperty(KEY_DISPLAY, "");
    }

    private static String getSystemProperty(String r7, String r8) {
        Class<?> r0 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L4
        return (String) r0.getMethod("get", new Class[]{String.class, String.class}).invoke(r0, new Object[]{r7, r8});
    L4:
        e = move-exception;
        e.printStackTrace();
        return r8;
    }
}
