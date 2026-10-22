package com.stepos.alphame.reflect;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: classes.dex */
public class Reflects {
    private static final String TAG = "Reflects";

    public static void disableScanInterface(WifiManager wifiManager, boolean z4) {
        try {
            PerfBinderHelper.disableWifiScanInterface(z4);
        } catch (Exception e4) {
            Log.w(TAG, "disableScanInterface exception: " + e4);
        }
    }

    public static Object getIAppOpsManager() {
        Log.w(TAG, "getIAppOpsManager deprecated");
        return null;
    }

    public static Object getIBatteryStats() {
        Log.w(TAG, "getIBatteryStats deprecated");
        return null;
    }

    public static IBinder getIBinder(String str) {
        Log.w(TAG, "getIBinder deprecated name=" + str);
        return null;
    }

    public static Object getIPackageManager() {
        Log.w(TAG, "getIPackageManager deprecated");
        return null;
    }

    public static Object getIPowerManager() {
        Log.w(TAG, "getIPowerManager deprecated");
        return null;
    }

    public static Object getISteposPermissionService() {
        Log.w(TAG, "getISteposPermissionService deprecated");
        return null;
    }

    public static Object getITelephonyExt() {
        Log.w(TAG, "getITelephonyExt deprecated");
        return null;
    }

    public static Object getIVoiceSenseService() {
        Log.w(TAG, "getIVoiceSenseService deprecated");
        return null;
    }

    public static Object getIWindowManager() {
        Log.w(TAG, "getIWindowManager deprecated");
        return null;
    }

    public static Object getService(String str) {
        Log.w(TAG, "getService deprecated name=" + str);
        return null;
    }

    public static int getStaticVariableInt(String str, String str2) throws SecurityException {
        try {
            Class<?> clsForName = ReflectionCache.build().forName(str);
            ReflectionCache.build();
            Field cachedField = ReflectionCache.getCachedField(clsForName, str2, true);
            cachedField.setAccessible(true);
            return ((Integer) cachedField.get(clsForName)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String getStaticVariableString(String str, String str2) throws SecurityException {
        try {
            Class<?> clsForName = ReflectionCache.build().forName(str);
            ReflectionCache.build();
            Field cachedField = ReflectionCache.getCachedField(clsForName, str2, true);
            cachedField.setAccessible(true);
            return (String) cachedField.get(clsForName);
        } catch (Exception unused) {
            return str2.toLowerCase(Locale.US);
        }
    }

    public static Object getTelephonyManager(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSystemService("phone");
    }

    public static Bundle getTopActivityBundle() {
        try {
            return PerfBinderHelper.getTopActivityBundle();
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("", e4);
            return null;
        }
    }

    public static Object getWifiManager(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getSystemService(AppSuggestStorable.COLUMN_WIFI);
    }
}
