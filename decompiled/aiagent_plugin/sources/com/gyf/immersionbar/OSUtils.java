package com.gyf.immersionbar;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.crash.general.RomInfo;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class OSUtils {
    private static final String KEY_DISPLAY = "ro.build.display.id";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    public OSUtils() {
    }

    public static boolean isXiaoMi() {
        return Build.MANUFACTURER.toLowerCase().contains("xiaomi");
    }

    public static boolean isHuaWei() {
        return Build.MANUFACTURER.toLowerCase().contains("huawei");
    }

    public static boolean isOppo() {
        return Build.MANUFACTURER.toLowerCase().contains("oppo");
    }

    public static boolean isVivo() {
        return Build.MANUFACTURER.toLowerCase().contains("vivo");
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.toLowerCase().contains("samsung");
    }

    public static boolean isLenovo() {
        return Build.MANUFACTURER.toLowerCase().contains("lenovo");
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.toLowerCase().contains("meizu");
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_MIUI_VERSION_NAME));
    }

    public static boolean isMIUI6Later() {
        String r0 = getMIUIVersion();
        if (r0.isEmpty() == false) goto L11;
        return false;
    L11:
        if (Integer.parseInt(r0.substring(1)) >= 6) goto L9;
        return false;
    L9:
        return true;
    L15:
        return false;
    }

    public static String getMIUIVersion() {
        if (isMIUI() == true) goto L7;
        return "";
    L7:
        return getSystemProperty(KEY_MIUI_VERSION_NAME);
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_EMUI_VERSION_NAME));
    }

    public static String getEMUIVersion() {
        if (isEMUI() == true) goto L7;
        return "";
    L7:
        return getSystemProperty(KEY_EMUI_VERSION_NAME);
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
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_x() {
        if (isEMUI3_0() == false) goto L5;
    L8:
        return true;
    L5:
        if (isEMUI3_1() == true) goto L8;
        return false;
    }

    public static boolean isColorOs() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.version.opporom"));
    }

    public static boolean isFuntouchOrOriginOs() {
        return !TextUtils.isEmpty(getSystemProperty("ro.vivo.os.version"));
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        String r0 = getFlymeOSVersion();
        if (r0.isEmpty() == true) goto L14;
        if (r0.toLowerCase().contains(RomInfo.KEY_OS_TYPE) == false) goto L7;
        int r1 = Integer.parseInt(r0.substring(9, 10));     // Catch: NumberFormatException -> L12
    L9:
        if (r1 < 4) goto L15;
        return true;
    L15:
        return false;
    L7:
        r1 = Integer.parseInt(r0.substring(6, 7));     // Catch: NumberFormatException -> L12
        goto L9
    L16:
        return false;
    L14:
        return false;
    }

    public static boolean isFlymeOS5() {
        String r0 = getFlymeOSVersion();
        if (r0.isEmpty() == true) goto L14;
        if (r0.toLowerCase().contains(RomInfo.KEY_OS_TYPE) == false) goto L7;
        int r1 = Integer.parseInt(r0.substring(9, 10));     // Catch: NumberFormatException -> L12
    L9:
        if (r1 != 5) goto L15;
        return true;
    L15:
        return false;
    L7:
        r1 = Integer.parseInt(r0.substring(6, 7));     // Catch: NumberFormatException -> L12
        goto L9
    L16:
        return false;
    L14:
        return false;
    }

    public static String getFlymeOSVersion() {
        if (isFlymeOS() == true) goto L7;
        return "";
    L7:
        return getSystemProperty(KEY_DISPLAY);
    }

    private static String getFlymeOSFlag() {
        return getSystemProperty(KEY_DISPLAY);
    }

    private static String getSystemProperty(String r9) {
        Class r2 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        return (String) ZeusTransformUtils.preCheckCast(r2.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r2, new Object[]{r9, ""}), String.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
