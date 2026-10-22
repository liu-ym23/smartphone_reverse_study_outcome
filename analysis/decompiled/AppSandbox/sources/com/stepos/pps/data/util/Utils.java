package com.stepos.pps.data.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.PersistableBundle;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.data.ouc.cloud.UserTypeManager;
import com.stepos.pps.reflect.ReflectCache;
import com.stepos.pps.reflect.ReflectUtils;
import com.stepos.pps.reflect.SystemProperties;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import kotlin.UByte;
import okio.Segment;

/* loaded from: classes.dex */
public class Utils {
    private static final String TAG = "Utils";
    public static final String PRODUCT_MODEL = getProductModel();
    public static final String BUILD_MASK = SystemProperties.get("ro.build.mask.id");
    public static final String BUILD_TYPE = SystemProperties.get("ro.build.type");
    public static final String CHIP_TYPE = SystemProperties.get(Constants.DEVICE_SYSTEM_PROPERY);
    private static Boolean sIsRoot = null;
    public static final boolean sTestMode = "1".equals(SystemProperties.get("persist.stepos.pps.testmode", "0"));

    public static String getLocation(Context context) {
        return null;
    }

    public static boolean checkVersionTypeAvailable() {
        if (sTestMode) {
            return true;
        }
        if ("userdebug".equals(SystemProperties.get("ro.build.type", ""))) {
            Log.d(TAG, "checkVersionTypeAvailable: userdebug build, do not upload");
            return false;
        }
        String str = SystemProperties.get("ro.build.stepos_version_type", "");
        return ("".equals(str) || Constants.UNKNOWN.equals(str) || "patch".equals(str)) ? false : true;
    }

    public static long getDataDirAvailableSize() {
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes();
    }

    public static long getDataDirTotalSize() {
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getTotalBytes();
    }

    public static boolean isDataDirLowOnSpace() {
        long dataDirAvailableSize = getDataDirAvailableSize();
        long dataDirTotalSize = getDataDirTotalSize();
        long jMax = Math.max(Constants.MIN_AVAILABLE_SIZE, (dataDirTotalSize / 100) * 10);
        LogUtil.d(TAG, "isDataDirLowOnSpace avail=" + dataDirAvailableSize + " total=" + dataDirTotalSize + " floor=" + jMax);
        return dataDirAvailableSize < jMax;
    }

    public static String getCountry(Context context) {
        if (context != null && context.getResources().getConfiguration() != null && context.getResources().getConfiguration().locale != null) {
            return context.getResources().getConfiguration().locale.getCountry();
        }
        return "";
    }

    public static String getStepOSUid(Context context) {
        return "";
    }

    public static String getOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
            String simOperator = telephonyManager.getSimOperator();
            LogUtil.d(TAG, "### getOperator, " + simOperator);
            return simOperator;
        }
        return "";
    }

    public static boolean isWiFiWorking(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || NetworkInfo.State.CONNECTED != networkInfo.getState()) ? false : true;
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Exception e) {
            Log.w(TAG, "getNetworkType exception: " + e + " - Cause: " + e.getCause());
        }
        if (activeNetworkInfo == null) {
            return Constants.UNKNOWN;
        }
        if (!activeNetworkInfo.isAvailable()) {
            return "off";
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return "wifi";
        }
        if (type == 9) {
            return "ethernet";
        }
        int telephonyNetworkType = getTelephonyNetworkType(context);
        if (telephonyNetworkType == -1 && type == 0) {
            telephonyNetworkType = activeNetworkInfo.getSubtype();
        }
        if (telephonyNetworkType == 18) {
            return "4g";
        }
        if (telephonyNetworkType == 20) {
            return "5g";
        }
        switch (telephonyNetworkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return is5GNetwork(context) ? "5g" : "4g";
            default:
                return Constants.UNKNOWN;
        }
        Log.w(TAG, "getNetworkType exception: " + e + " - Cause: " + e.getCause());
        return Constants.UNKNOWN;
    }

    private static int getTelephonyNetworkType(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        } catch (Exception e) {
            LogUtil.w(TAG, "getTelephonyNetworkType exception: " + e.getMessage());
            return -1;
        }
    }

    private static boolean is5GNetwork(Context context) {
        ServiceState serviceState;
        try {
            serviceState = (ServiceState) ReflectCache.on((TelephonyManager) context.getSystemService("phone"), "getServiceState", (Class<?>[]) new Class[0]).invoke(new Object[0]);
        } catch (Exception e) {
            LogUtil.w(TAG, e.getMessage());
        }
        if (serviceState == null) {
            return false;
        }
        int iIntValue = ((Integer) ReflectCache.on(serviceState, "getNrState", (Class<?>[]) new Class[0]).invoke(new Object[0])).intValue();
        return iIntValue == ReflectUtils.getStaticVariableInt("android.telephony.NetworkRegistrationInfo", "NR_STATE_NOT_RESTRICTED") || iIntValue == ReflectUtils.getStaticVariableInt("android.telephony.NetworkRegistrationInfo", "NR_STATE_CONNECTED");
    }

    public static boolean isRoot(Context context) {
        if (sIsRoot != null) {
            Log.d(TAG, "isRoot(cached) = " + sIsRoot);
            return sIsRoot.booleanValue();
        }
        String str = SystemProperties.get("ro.debuggable", "0");
        String str2 = SystemProperties.get("ro.build.type", "");
        sIsRoot = Boolean.valueOf("1".equals(str) || "userdebug".equalsIgnoreCase(str2) || "eng".equalsIgnoreCase(str2));
        Log.d(TAG, "isRoot = " + sIsRoot + " (ro.debuggable=" + str + " ro.build.type=" + str2 + ")");
        return sIsRoot.booleanValue();
    }

    public static String getDns(Context context) {
        return "";
    }

    public static String getIpAddresses(Context context) {
        return "";
    }

    private static String getProductModel() {
        String str = SystemProperties.get("ro.vendor.stepos.product.model");
        return TextUtils.isEmpty(str) ? Build.MODEL : str;
    }

    public static String dumpLogcat(int i) throws Throwable {
        Throwable th;
        InputStreamReader inputStreamReader;
        StringBuilder sb = new StringBuilder(Segment.SHARE_MINIMUM);
        sb.append("\n\n----------Logcat----------\n");
        InputStreamReader inputStreamReader2 = null;
        try {
            try {
                try {
                    Process processStart = new ProcessBuilder("/system/bin/logcat", "-v", "time", "-b", "events", "-b", "system", "-b", "main", "-t", String.valueOf(i), "-d").redirectErrorStream(true).start();
                    try {
                        processStart.getOutputStream().close();
                        processStart.getErrorStream().close();
                    } catch (IOException unused) {
                    }
                    inputStreamReader = new InputStreamReader(processStart.getInputStream());
                } catch (IOException unused2) {
                }
            } catch (IOException unused3) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            char[] cArr = new char[8192];
            while (true) {
                int i2 = inputStreamReader.read(cArr);
                if (i2 <= 0) {
                    break;
                }
                sb.append(cArr, 0, i2);
            }
            inputStreamReader.close();
        } catch (IOException unused4) {
            inputStreamReader2 = inputStreamReader;
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader2 = inputStreamReader;
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                    throw th;
                } catch (IOException unused5) {
                    throw th;
                }
            }
            throw th;
        }
        return sb.toString();
    }

    public static String getPackageVersion(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return "";
    }

    public static String getPublishedType() {
        String str = SystemProperties.get("ro.build.aios_publish_type");
        return TextUtils.isEmpty(str) ? UserTypeManager.DEV : str;
    }

    public static String getProductName() {
        String str = SystemProperties.get("ro.product.name", "unkown");
        Log.e(TAG, "get product name erro, please check.");
        return str;
    }

    public static String getProjectID() {
        return SystemProperties.get("ro.stepos.project.id");
    }

    public static String getInsideId() {
        return SystemProperties.get("ro.build.inside.id");
    }

    public static boolean isCTA() {
        String str = SystemProperties.get("ro.build.cta");
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("CTA")) {
            return true;
        }
        String str2 = SystemProperties.get("ro.vendor.build.cta");
        return !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("CTA");
    }

    public static boolean isCTS() {
        return "true".equals(SystemProperties.get("persist.sys.cts_state", "false"));
    }

    public static boolean isSetupWizardCompleted(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1;
    }

    public static boolean isBetaUser() {
        return "beta".equals(UserTypeManager.get());
    }

    public static boolean canDataCollect(Context context) {
        if (isSetupWizardCompleted(context)) {
            return isBetaUser() || Settings.System.getInt(context.getContentResolver(), Constants.SETTINGS_KEY_DATA_COLLECT, 0) != 0;
        }
        return false;
    }

    public static boolean canLogCollect(Context context) {
        if (isSetupWizardCompleted(context)) {
            return isBetaUser() || Settings.System.getInt(context.getContentResolver(), Constants.SETTINGS_KEY_OUC_LOG_COLLECT, 0) != 0;
        }
        return false;
    }

    public static boolean canPerfConfigUpdate(Context context) {
        return isSetupWizardCompleted(context) && Settings.System.getInt(context.getContentResolver(), Constants.SETTINGS_KEY_PERF_CONFIG_UPDATE, 0) != 0;
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String getProcessName(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static String md5checkSum(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static HashMap<String, String> transformPersistableBundleToHashMap(PersistableBundle persistableBundle) {
        if (persistableBundle == null) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>();
        for (String str : persistableBundle.keySet()) {
            Object obj = persistableBundle.get(str);
            if (obj != null) {
                map.put(str, obj.toString());
            }
        }
        return map;
    }

    public static long getBatteryChargeCounter(Context context) {
        return ((BatteryManager) context.getSystemService("batterymanager")).getLongProperty(1);
    }

    public static int getRefreshRate(Context context) {
        return (int) ((DisplayManager) context.getSystemService("display")).getDisplay(0).getMode().getRefreshRate();
    }

    public static boolean getSettingGlobalSwitch(Context context, String str) {
        return Settings.Global.getInt(context.getContentResolver(), str, 0) == 1;
    }
}
