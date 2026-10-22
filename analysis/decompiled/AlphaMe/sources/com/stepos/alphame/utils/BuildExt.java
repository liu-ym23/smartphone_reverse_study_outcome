package com.stepos.alphame.utils;

import com.stepos.alphame.perfbinder.PerfBinderHelper;

/* loaded from: classes.dex */
public class BuildExt {
    public static String CTA;
    public static boolean CUSTOMIZE_CHINAMOBILE;
    public static boolean IS_M98;
    public static boolean IS_MA01;
    public static boolean IS_MX2;
    public static boolean IS_MX4;
    public static boolean IS_MX5_PRO;
    private static boolean IS_PRODUCT_INTERNATIONAL;
    private static volatile boolean sLoaded;

    private static void ensureLoaded() {
        if (sLoaded) {
            return;
        }
        synchronized (BuildExt.class) {
            if (sLoaded) {
                return;
            }
            try {
                IS_PRODUCT_INTERNATIONAL = PerfBinderHelper.isProductInternational();
            } catch (Exception unused) {
            }
            try {
                CUSTOMIZE_CHINAMOBILE = PerfBinderHelper.getBuildExtBoolean("CUSTOMIZE_CHINAMOBILE", false);
            } catch (Exception unused2) {
            }
            try {
                CTA = PerfBinderHelper.getBuildExtString("CTA", null);
            } catch (Exception unused3) {
            }
            try {
                IS_MX2 = PerfBinderHelper.getBuildExtBoolean("IS_MX2", false);
            } catch (Exception unused4) {
            }
            try {
                IS_MX4 = PerfBinderHelper.getBuildExtBoolean("IS_MX4", false);
            } catch (Exception unused5) {
            }
            try {
                IS_MX5_PRO = PerfBinderHelper.getBuildExtBoolean("IS_MX5_PRO", false);
            } catch (Exception unused6) {
            }
            try {
                IS_MA01 = PerfBinderHelper.getBuildExtBoolean("IS_MA01", false);
            } catch (Exception unused7) {
            }
            try {
                IS_M98 = PerfBinderHelper.getBuildExtBoolean("IS_M98", false);
            } catch (Exception unused8) {
            }
            sLoaded = true;
        }
    }

    public static boolean isCustomizeChinaMobile() {
        ensureLoaded();
        return CUSTOMIZE_CHINAMOBILE;
    }

    public static boolean isProductInternational() {
        ensureLoaded();
        return IS_PRODUCT_INTERNATIONAL;
    }
}
