package com.stepos.pps.data.util;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.PPSApplication;
import com.stepos.pps.data.deviceid.DeviceIdClient;
import com.stepos.pps.data.ouc.cloud.UserTypeManager;
import com.stepos.pps.reflect.ReflectCache;
import com.stepos.pps.reflect.SystemProperties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/* loaded from: classes.dex */
public class DeviceUtils {
    private static final long ID_CACHE_TTL_FAIL_MS = 30000;
    private static final long ID_CACHE_TTL_OK_MS = 120000;
    private static final String KEY_CACHE_DSID = "cache_dsid";
    private static final String KEY_CACHE_OAID = "cache_oaid";
    private static final String MZ_ANALYTIC_SDK_UMID = "mz_analytic_sdk_umid";
    private static final String SP_ID_CACHE = "pps_sp_deviceid";
    public static String TAG = "DeviceUtils";
    public static volatile String sDeviceId = "";
    private static volatile String sDsid;
    private static volatile long sDsidNextFetchAt;
    private static Boolean sIsAliRom;
    private static Boolean sIsBox;
    private static Boolean sIsChinaMobile;
    private static Boolean sIsProductInternational;
    private static Boolean sIsStepOSRom;
    private static Boolean sIsTablet;
    private static Boolean sIsYunosProject;
    private static volatile long sOaidNextFetchAt;
    private static String sUmid;

    public static boolean isTablet(Context context) {
        try {
            Boolean bool = sIsTablet;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = SystemProperties.get("ro.target.product");
            boolean z = !TextUtils.isEmpty(str) && "tablet".equalsIgnoreCase(str);
            Boolean boolValueOf = Boolean.valueOf(z);
            sIsTablet = boolValueOf;
            boolValueOf.getClass();
            return z;
        } catch (Exception e) {
            Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
            return false;
        }
    }

    public static boolean isBox(Context context) {
        try {
            Boolean bool = sIsBox;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = SystemProperties.get("ro.target.product");
            boolean z = !TextUtils.isEmpty(str) && "box".equalsIgnoreCase(str);
            Boolean boolValueOf = Boolean.valueOf(z);
            sIsBox = boolValueOf;
            boolValueOf.getClass();
            return z;
        } catch (Exception e) {
            Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
            return false;
        }
    }

    public static boolean isBrandStepOS() {
        return !TextUtils.isEmpty(SystemProperties.get("ro.stepos.product.model")) || "stepos".equalsIgnoreCase(Build.BRAND) || "22c4185e".equalsIgnoreCase(Build.BRAND);
    }

    public static String getUmid(Context context) {
        if (sUmid == null) {
            sUmid = Settings.Global.getString(context.getContentResolver(), MZ_ANALYTIC_SDK_UMID);
        }
        return sUmid;
    }

    public static String getStepOSUid(Context context) {
        return "";
    }

    public static String getIMEI(Context context) {
        return "";
    }

    public static String getSN() {
        return "";
    }

    public static String getDeviceId() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!TextUtils.isEmpty(sDeviceId) && jElapsedRealtime < sOaidNextFetchAt) {
            return sDeviceId;
        }
        String oaid = DeviceIdClient.getOaid(PPSApplication.getInstance());
        if (!TextUtils.isEmpty(oaid)) {
            sDeviceId = oaid;
            writeIdCache(KEY_CACHE_OAID, oaid);
            sOaidNextFetchAt = jElapsedRealtime + ID_CACHE_TTL_OK_MS;
            return sDeviceId;
        }
        sOaidNextFetchAt = jElapsedRealtime + ID_CACHE_TTL_FAIL_MS;
        if (TextUtils.isEmpty(sDeviceId)) {
            String idCache = readIdCache(KEY_CACHE_OAID);
            if (!TextUtils.isEmpty(idCache)) {
                sDeviceId = idCache;
            }
        }
        if (TextUtils.isEmpty(sDeviceId)) {
            Log.e(TAG, "OAID is null and no cache");
        } else {
            Log.w(TAG, "OAID fetch empty, fallback to cached OAID");
        }
        return sDeviceId;
    }

    public static String getDsid() {
        return "";
    }

    public static boolean checkDeviceId() {
        String oaid = DeviceIdClient.getOaid(PPSApplication.getInstance());
        if (TextUtils.isEmpty(oaid)) {
            Log.d(TAG, "checkDeviceId: fetch empty, keep current deviceId");
            return false;
        }
        sOaidNextFetchAt = SystemClock.elapsedRealtime() + ID_CACHE_TTL_OK_MS;
        Log.d(TAG, "get device id " + oaid + " by DataFinderHelper");
        if (oaid.equals(sDeviceId)) {
            return false;
        }
        sDeviceId = oaid;
        writeIdCache(KEY_CACHE_OAID, oaid);
        Log.d(TAG, "need update device id by DataFinderHelper");
        return true;
    }

    private static void writeIdCache(String str, String str2) {
        try {
            PPSApplication pPSApplication = PPSApplication.getInstance();
            if (pPSApplication == null) {
                return;
            }
            pPSApplication.getSharedPreferences(SP_ID_CACHE, 0).edit().putString(str, str2).apply();
        } catch (Throwable th) {
            Log.w(TAG, "writeIdCache failed: " + th);
        }
    }

    private static String readIdCache(String str) {
        try {
            PPSApplication pPSApplication = PPSApplication.getInstance();
            if (pPSApplication == null) {
                return null;
            }
            return pPSApplication.getSharedPreferences(SP_ID_CACHE, 0).getString(str, null);
        } catch (Throwable th) {
            Log.w(TAG, "readIdCache failed: " + th);
            return null;
        }
    }

    private static String getMacAddressWithIfName(String str) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("/sys/class/net/" + str + "/address");
            Scanner scanner = new Scanner(fileInputStream);
            strTrim = scanner.hasNextLine() ? scanner.nextLine().trim() : null;
            fileInputStream.close();
            return strTrim;
        } catch (FileNotFoundException e) {
            Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
            return strTrim;
        } catch (IOException e2) {
            Log.w(TAG, "Exception : " + e2.toString() + " - Cause: " + e2.getCause());
            return strTrim;
        }
    }

    public static boolean isAliRom() {
        try {
            Boolean bool = sIsAliRom;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = SystemProperties.get("ro.yunos.project");
            boolean z = !TextUtils.isEmpty(str) && Boolean.parseBoolean(str);
            Boolean boolValueOf = Boolean.valueOf(z);
            sIsAliRom = boolValueOf;
            boolValueOf.getClass();
            return z;
        } catch (Exception e) {
            Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
            return false;
        }
    }

    public static boolean isStepOSRom() {
        try {
            Boolean bool = sIsStepOSRom;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean bool2 = (Boolean) ReflectCache.on("android.os.BuildExt", "isStepOSRom", (Class<?>[]) new Class[0]).invoke(new Object[0]);
            sIsStepOSRom = bool2;
            return bool2.booleanValue();
        } catch (Exception e) {
            try {
                sIsStepOSRom = Boolean.valueOf(SystemProperties.getBoolean("ro.stepos.rom.config", false));
            } catch (Exception unused) {
                Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
            }
            return false;
        }
    }

    public static boolean isChinaMobile() {
        try {
            Boolean bool = sIsChinaMobile;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean bool2 = (Boolean) ReflectCache.on("android.os.BuildExt", "CUSTOMIZE_CHINAMOBILE", (Class<?>[]) new Class[0]).invoke(new Object[0]);
            sIsChinaMobile = bool2;
            if (bool2 == null) {
                sIsChinaMobile = false;
            }
            return sIsChinaMobile.booleanValue();
        } catch (Exception e) {
            Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
            return false;
        }
    }

    public static boolean isProductInternational() {
        try {
            Boolean bool = sIsProductInternational;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean bool2 = (Boolean) ReflectCache.on("android.os.BuildExt", "isProductInternational", (Class<?>[]) new Class[0]).invoke(new Object[0]);
            sIsProductInternational = bool2;
            return bool2.booleanValue();
        } catch (Exception e) {
            Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
            return false;
        }
    }

    public static boolean isYunosProject() {
        Boolean bool = sIsYunosProject;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            sIsYunosProject = (Boolean) ReflectCache.on("ORIGINAL_CLASS_NAME", "FIELD_YUNOS_PROJECT", (Class<?>[]) new Class[0]).invoke(new Object[0]);
        } catch (Exception e) {
            Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
        }
        return sIsYunosProject.booleanValue();
    }

    public static String getOsVersion() {
        String str = SystemProperties.get("ro.build.aios_version", "");
        return str.isEmpty() ? Build.DISPLAY != null ? Build.DISPLAY : "" : str;
    }

    public static String getProjectName() {
        return SystemProperties.get("ro.product.odm.name", "");
    }

    public static String getPublishType() {
        return SystemProperties.get("ro.build.aios_publish_type", UserTypeManager.DEV);
    }
}
