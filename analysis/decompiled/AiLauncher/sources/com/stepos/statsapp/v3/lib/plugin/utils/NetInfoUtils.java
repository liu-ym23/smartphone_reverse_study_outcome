package com.stepos.statsapp.v3.lib.plugin.utils;

import W4.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.stepos.statsapp.v3.utils.log.Logger;

/* loaded from: classes2.dex */
public class NetInfoUtils {
    private static final String TAG = "NetInfoUtils";

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Exception e10) {
            Logger.w(TAG, "getNetworkType exception: " + e10 + " - Cause: " + e10.getCause());
        }
        if (activeNetworkInfo == null) {
            return "unknown";
        }
        if (!activeNetworkInfo.isAvailable()) {
            return a.ENABLE_OFF;
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
                return "4g";
            default:
                return "unknown";
        }
    }

    @SuppressLint({"MissingPermission"})
    private static int getTelephonyNetworkType(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        } catch (Exception e10) {
            Logger.w(TAG, "getTelephonyNetworkType exception: " + e10.getMessage());
            return -1;
        }
    }

    public static boolean isOnline(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z10 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            Logger.d(TAG, "isOnline:" + z10);
            return z10;
        } catch (SecurityException e10) {
            Logger.e(TAG, "Security exception:" + e10.toString());
            return true;
        }
    }

    public static boolean isWiFiWorking(Context context) {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(1)) != null) {
                if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    return true;
                }
            }
        } catch (Exception e10) {
            Logger.e(TAG, "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
        }
        return false;
    }
}
