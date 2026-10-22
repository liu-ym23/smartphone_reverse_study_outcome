package com.bytedance.security.zenmobile.detect.helpers;

import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.core.content.a;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PersistentIdentifierUtils {
    private static final String TAG = "ZenMobile-PersistentIdentifierUtils";

    public PersistentIdentifierUtils() {
    }

    private static boolean hasFineLocationPermission(Context r2) {
        if (a.b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasCoarseLocationPermission(Context r2) {
        if (a.b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasWifiStatePermission(Context r2) {
        if (a.b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "android.permission.ACCESS_WIFI_STATE") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasReadPrivilegedPhoneStatePermission(Context r2) {
        if (a.b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "android.permission.READ_PRIVILEGED_PHONE_STATE") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasLocalMacAddressPermission(Context r2) {
        if (a.b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "android.permission.LOCAL_MAC_ADDRESS") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isLocationEnabled(Context r2) {
        LocationManager r3 = (LocationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService("location"), LocationManager.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if (r3.isProviderEnabled("gps") == false) goto L7;
    L8:
        return true;
    L7:
        if (r3.isProviderEnabled("network") == false) goto L9;
        goto L8
    }

    private static boolean canAccessWifiInfo(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (hasFineLocationPermission(r3) == true) goto L5;
    L11:
        return false;
    L5:
        if (hasCoarseLocationPermission(r3) == false) goto L11;
        if (hasWifiStatePermission(r3) == false) goto L11;
        if (isLocationEnabled(r3) == false) goto L11;
        return true;
    }

    private static String getWifiBSSID(Context r2) {
        String r3 = ((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService("wifi"), WifiManager.class, "com.obric.aiagent.plugin")).getConnectionInfo().getBSSID();
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    private static String getWifiSSID(Context r2) {
        String r3 = ((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService("wifi"), WifiManager.class, "com.obric.aiagent.plugin")).getConnectionInfo().getSSID();
        if ("<unknown ssid>".equals(r3) == false) goto L6;
        return "";
    L6:
        return r3;
    }

    private static String getDeviceSerialNumber() {
        String r0 = Build.getSerial();
        if (SensitiveType.UNKNOWN.equals(r0) == false) goto L6;
        return "";
    L6:
        return r0;
    }

    private static String getMacAddress(Context r2) {
        return ((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService("wifi"), WifiManager.class, "com.obric.aiagent.plugin")).getConnectionInfo().getMacAddress();
    }

    private static String getDeviceName(Context r2) {
        return Settings.Global.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), SensitiveType.DEVICE_NAME);
    }

    private static String getICCID(Context r3) {
        String r4 = ((TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getSimSerialNumber();     // Catch: Exception -> L5
    L7:
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "getSimSerialNumber failed, exception: " + e.getMessage());
        r4 = "";
        goto L7
    }

    private static String getIMEI(Context r3) {
        String r4 = ((TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getImei();     // Catch: Exception -> L5
    L7:
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "getImei failed, exception: " + e.getMessage());
        r4 = "";
        goto L7
    }

    private static String getIMEI2(Context r3) {
        String r4 = ((TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getImei(1);     // Catch: Exception -> L5
    L7:
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "getImei2 failed, exception: " + e.getMessage());
        r4 = "";
        goto L7
    }

    private static String getIMSI(Context r3) {
        String r4 = ((TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getSubscriberId();     // Catch: Exception -> L5
    L7:
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "getSubscriberId failed, exception: " + e.getMessage());
        r4 = "";
        goto L7
    }

    private static String getMSIN(Context r2) {
        String r3 = getIMSI((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        if (r3.length() == 15) goto L5;
        return "";
    L5:
        return r3.substring(5);
    }

    private static String getMEID(Context r3) {
        String r4 = ((TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getMeid();     // Catch: Exception -> L5
    L7:
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "getMeid failed, exception: " + e.getMessage());
        r4 = "";
        goto L7
    }

    private static String getAndroidID(Context r2) {
        return Settings.Secure.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), SensitiveType.ANDROID_ID);
    }

    public static String getSpecPersistentId(Context r3, long r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        LogUtils.d(TAG, "getSpecPersistentId ruleId: " + r4);
        LogUtils.d(TAG, "canAccessWifiInfo: " + canAccessWifiInfo(r5));
        LogUtils.d(TAG, "hasReadPrivilegedPhoneStatePermission: " + hasReadPrivilegedPhoneStatePermission(r5));
        LogUtils.d(TAG, "hasWifiStatePermission: " + hasWifiStatePermission(r5));
        LogUtils.d(TAG, "hasLocalMacAddressPermission: " + hasLocalMacAddressPermission(r5));
        switch(((int) r4)) {
            case 1000: goto L57;
            case 1001: goto L52;
            case 1002: goto L47;
            case 1003: goto L37;
            case 1004: goto L35;
            case 1005: goto L30;
            case 1006: goto L25;
            case 1007: goto L20;
            case 1008: goto L15;
            case 1009: goto L10;
            case 1010: goto L8;
            case 1011: goto L6;
            default: goto L4;
        };
    L4:
        return "";
    L6:
        return getIMEI2(r5);
    L8:
        return getAndroidID(r5);
    L10:
        if (hasReadPrivilegedPhoneStatePermission(r5) == true) goto L13;
        return "";
    L13:
        return getMSIN(r5);
    L15:
        if (hasReadPrivilegedPhoneStatePermission(r5) == true) goto L18;
        return "";
    L18:
        return getMEID(r5);
    L20:
        if (hasReadPrivilegedPhoneStatePermission(r5) == true) goto L23;
        return "";
    L23:
        return getIMSI(r5);
    L25:
        if (hasReadPrivilegedPhoneStatePermission(r5) == true) goto L28;
        return "";
    L28:
        return getIMEI(r5);
    L30:
        if (hasReadPrivilegedPhoneStatePermission(r5) == true) goto L33;
        return "";
    L33:
        return getICCID(r5);
    L35:
        return getDeviceName(r5);
    L37:
        if (hasFineLocationPermission(r5) == true) goto L39;
    L45:
        return "";
    L39:
        if (hasWifiStatePermission(r5) == false) goto L45;
        if (hasLocalMacAddressPermission(r5) == false) goto L45;
        return getMacAddress(r5);
    L47:
        if (hasReadPrivilegedPhoneStatePermission(r5) == true) goto L50;
        return "";
    L50:
        return getDeviceSerialNumber();
    L52:
        if (canAccessWifiInfo(r5) == true) goto L55;
        return "";
    L55:
        return getWifiSSID(r5);
    L57:
        if (canAccessWifiInfo(r5) == true) goto L60;
        return "";
    L60:
        return getWifiBSSID(r5);
    }
}
