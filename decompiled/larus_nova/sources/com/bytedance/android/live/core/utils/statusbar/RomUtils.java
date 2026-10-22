package com.bytedance.android.live.core.utils.statusbar;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.SystemPropertiesUtil;

/* JADX INFO: loaded from: classes45.dex */
public class RomUtils extends puc.a {
    public static final int BUILD_VERSION_CODE_M = 23;
    private static final String HTC_MANUFACTURER = "htc";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    private static final String OPPO_MANUFACTURER = "oppo";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SAMSUNG = "SAMSUNG";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    public static final int SZ = 1024;
    private static final String TAG = "Rom";
    private static final String VIVO_MANUFACTURER = "vivo";
    private static String sName;
    private static String sVersion;

    public static String getName() {
        if (sName != null) goto L6;
        check("");
    L6:
        return sName;
    }

    public static boolean isVivo() {
        if (getRomManufacturer() == null) goto L9;
        if (getRomManufacturer().toLowerCase().equals("vivo") == false) goto L9;
        return true;
    L9:
        return check("VIVO");
    }

    public RomUtils() {
    }

    public static String getRomManufacturer() {
        return Build.MANUFACTURER;
    }

    public static boolean check(String r100) {
        String r101 = sName;
        if (r101 == null) goto L7;
        return r101.equals(r100);
    L7:
        if (TextUtils.isEmpty(getProp(KEY_VERSION_MIUI)) == true) goto L10;
        sVersion = getProp(KEY_VERSION_MIUI);
        sName = "MIUI";
    L26:
        return sName.equals(r100);
    L10:
        if (TextUtils.isEmpty(getProp("ro.build.version.emui")) == true) goto L13;
        sVersion = getProp("ro.build.version.emui");
        sName = "EMUI";
        goto L26
    L13:
        if (TextUtils.isEmpty(getProp(KEY_VERSION_OPPO)) == true) goto L16;
        sVersion = getProp(KEY_VERSION_OPPO);
        sName = "OPPO";
        goto L26
    L16:
        if (TextUtils.isEmpty(getProp(KEY_VERSION_VIVO)) == true) goto L19;
        sVersion = getProp(KEY_VERSION_VIVO);
        sName = "VIVO";
        goto L26
    L19:
        if (TextUtils.isEmpty(getProp(KEY_VERSION_SMARTISAN)) == true) goto L21;
        sVersion = getProp(KEY_VERSION_SMARTISAN);
        sName = "SMARTISAN";
        goto L26
    L21:
        String r102 = Build.DISPLAY;
        sVersion = r102;
        if (r102.toUpperCase().contains("FLYME") == false) goto L24;
        sName = "FLYME";
        goto L26
    L24:
        sVersion = "unknown";
        sName = Build.MANUFACTURER.toUpperCase();
        goto L26
    }

    public static String getProp(String r100) {
        return SystemPropertiesUtil.getProp(r100);
    }

    public static boolean isTablet(Context r100) {
        if ((r100.getResources().getConfiguration().screenLayout & 15) < 3) goto L5;
        return true;
    L5:
        return false;
    }
}
