package com.stepos.statsapp.v3.lib.plugin.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Display;
import com.stepos.statsapp.v3.utils.log.Logger;
import com.stepos.statsapp.v3.utils.reflect.SystemProperties;
import java.util.Locale;

/* loaded from: classes2.dex */
public class StepOSUtils {
    public static final String ACTION_VCC_OFFLINE_STATS_PHONE = "com.stepos.dataservice.action.vccOfflineStats";
    public static final String DATASERVICE_PACKAGENAME_PHONE = "com.stepos.dataservice";
    private static final String TAG = "StepOSUtils";
    private static boolean sBootWizardIsCompleted = false;
    private static String sBuildMask = "";
    private static String sCountry = "";
    private static String sDisplaySize = "";
    private static Boolean sIsInternational = null;
    private static String sLocationLanguage = "";
    private static String sOtherBrand = "";
    private static int sPackageCode = 0;
    private static String sPackageVersion = "";

    public static boolean bootWizardIsCompleted(Context context) {
        if (sBootWizardIsCompleted) {
            return true;
        }
        boolean z10 = Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1;
        sBootWizardIsCompleted = z10;
        return z10;
    }

    public static String getBrand() throws IllegalArgumentException {
        if (!TextUtils.isEmpty(sOtherBrand)) {
            return sOtherBrand;
        }
        String str = SystemProperties.get("ro.product.other.brand", "unknown");
        if ("unknown".equals(str)) {
            sOtherBrand = Build.BRAND;
        } else {
            sOtherBrand = str;
        }
        return sOtherBrand;
    }

    public static String getBuildMask() {
        if (TextUtils.isEmpty(sBuildMask)) {
            sBuildMask = SystemProperties.get("ro.build.mask.id");
        }
        return sBuildMask;
    }

    public static String getCountry(Context context) {
        if (!TextUtils.isEmpty(sCountry)) {
            return sCountry;
        }
        if (context == null) {
            return "";
        }
        try {
            if (context.getResources().getConfiguration() != null && context.getResources().getConfiguration().locale != null) {
                sCountry = context.getResources().getConfiguration().locale.getCountry();
            }
        } catch (Exception e10) {
            Logger.e(TAG, "Exception: " + e10.getMessage() + " - Cause: " + e10.getCause());
        }
        return sCountry;
    }

    public static String getDisplaySize(Context context) {
        if (!TextUtils.isEmpty(sDisplaySize)) {
            return sDisplaySize;
        }
        try {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display != null) {
                Point point = new Point();
                display.getRealSize(point);
                int i10 = point.x;
                int i11 = point.y;
                if (i10 > 0 && i11 > 0) {
                    sDisplaySize = i10 + "." + i11;
                }
            }
        } catch (Exception e10) {
            Logger.e(TAG, "getDisplaySize error, " + e10.getMessage());
        }
        return sDisplaySize;
    }

    public static String getLocationLanguage(Context context) {
        if (!TextUtils.isEmpty(sLocationLanguage)) {
            return sLocationLanguage;
        }
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (language == null) {
            language = "";
        }
        if (country == null) {
            country = "";
        }
        String str = language + "_" + country;
        sLocationLanguage = str;
        return str;
    }

    public static int getPackageCode(String str, Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        int i10 = sPackageCode;
        if (i10 != 0) {
            return i10;
        }
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return 0;
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Logger.w(TAG, "Exception: " + e10.getMessage() + " - Cause: " + e10.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            sPackageCode = packageInfo.versionCode;
        }
        return sPackageCode;
    }

    public static String getPackageVersion(String str, Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(sPackageVersion)) {
            return sPackageVersion;
        }
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Logger.w(TAG, "Exception: " + e10.getMessage() + " - Cause: " + e10.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            sPackageVersion = packageInfo.versionName;
        }
        return sPackageVersion;
    }

    public static String getProductModel() {
        return Build.MODEL;
    }

    public static boolean isBox(Context context) {
        return false;
    }

    public static boolean isInternational() {
        if (sIsInternational == null) {
            try {
                sIsInternational = Boolean.valueOf(("zh".equalsIgnoreCase(SystemProperties.get("ro.product.locale.language")) && "CN".equalsIgnoreCase(SystemProperties.get("ro.product.locale.region")) && !"zh-CN".equalsIgnoreCase(SystemProperties.get("ro.product.locale"))) ? false : true);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return sIsInternational.booleanValue();
        }
        Logger.d(TAG, "isInternational = " + sIsInternational);
        return sIsInternational.booleanValue();
    }

    public static boolean isSystemDataCollectionEnable(Context context) {
        try {
            int i10 = Settings.System.getInt(context.getContentResolver(), "stepos_data_collection", 0);
            Logger.d(TAG, "get system data collection enable: " + i10);
            return i10 != 0;
        } catch (Exception e10) {
            Logger.e(TAG, "get system data collection enable error, " + e10.getMessage());
            return true;
        }
    }

    public static boolean isTablet() {
        return false;
    }

    public static boolean isWearable() {
        return false;
    }
}
