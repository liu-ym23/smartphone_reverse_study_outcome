package com.obric.cae.libs.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WifiUtils {
    public static final int WIFI_BAND_24_GHZ = 1;
    public static final int WIFI_BAND_5_GHZ = 2;
    public static final int WIFI_BAND_6_GHZ = 8;

    public WifiUtils() {
    }

    public static int convertChannelToFrequencyMhz(int r3, int r4) {
        if (r4 != 1) goto L14;
        if (r3 != 14) goto L8;
        return ChannelsEnvironment.BAND_24_GHZ_END_FREQ_MHZ;
    L8:
        if (r3 < 1) goto L12;
        if (r3 > 14) goto L12;
        return ((r3 - 1) * 5) + ChannelsEnvironment.BAND_24_GHZ_START_FREQ_MHZ;
    L12:
        return -1;
    L14:
        if (r4 != 2) goto L23;
        if (r3 >= 32) goto L18;
    L21:
        return -1;
    L18:
        if (r3 > 173) goto L21;
        return ((r3 - 32) * 5) + ChannelsEnvironment.BAND_5_GHZ_START_FREQ_MHZ;
    L23:
        if (r4 != 8) goto L29;
        if (r3 < 1) goto L29;
        if (r3 > 233) goto L29;
        return ((r3 - 1) * 5) + ChannelsEnvironment.BAND_6_GHZ_START_FREQ_MHZ;
    L29:
        return -1;
    }

    public static int convertFrequencyMhzToChannel(int r1) {
        if (r1 != 2484) goto L7;
        return 14;
    L7:
        if (is24GHz(r1) == false) goto L11;
        return ((r1 - 2412) / 5) + 1;
    L11:
        if (is5GHz(r1) == false) goto L15;
        return ((r1 - 5160) / 5) + 32;
    L15:
        if (is6GHz(r1) == true) goto L17;
        return -1;
    L17:
        return ((r1 - 5945) / 5) + 1;
    }

    public static List<ScanResult> getWifiScanResults(Context r3, WifiManager r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33) goto L13;
        if (r5.checkSelfPermission("android.permission.NEARBY_WIFI_DEVICES") == 0) goto L19;
        LogUtil.e("WifiUtils", "getWifiScanResults: NEARBY_WIFI_DEVICES permission not granted");
        return Collections.emptyList();
    L19:
        return r4.getScanResults();
    L13:
        if (r0 < 23) goto L19;
        if (r5.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L19;
        LogUtil.e("WifiUtils", "getWifiScanResults: ACCESS_FINE_LOCATION permission not granted");
        return Collections.emptyList();
    L5:
        return Collections.emptyList();
    }

    public static boolean is24GHz(int r1) {
        if (r1 >= 2412) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 2484) goto L7;
        return true;
    }

    public static boolean is5GHz(int r1) {
        if (r1 >= 5160) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 5865) goto L7;
        return true;
    }

    public static boolean is6GHz(int r1) {
        if (r1 >= 5945) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 7105) goto L7;
        return true;
    }

    public static boolean isWifiConnected(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin");
        if (((WifiManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("wifi"), WifiManager.class, "com.obric.aiagent.plugin")) == null) goto L31;
        if (r0 == null) goto L34;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 23) goto L13;
        if (r6.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) goto L13;
        LogUtil.e("WifiUtils", "isWifiConnected: ACCESS_NETWORK_STATE permission not granted");
        return false;
    L13:
        if (r1 < 23) goto L23;
        Network r2 = r0.getActiveNetwork();
        if (r2 != null) goto L17;
        return false;
    L17:
        NetworkCapabilities r3 = r0.getNetworkCapabilities(r2);
        if (r3 != null) goto L20;
        return false;
    L20:
        if (r3.hasTransport(1) == true) goto L22;
        return false;
    L22:
        return true;
    L23:
        NetworkInfo r4 = r0.getNetworkInfo(1);
        if (r4 != null) goto L26;
        return false;
    L26:
        if (r4.isConnected() == true) goto L28;
        return false;
    L28:
        return true;
    L34:
        return false;
    L31:
        return false;
    }

    public static String maskMacAddress(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        String[] r1 = r4.split(":");
        if (r1.length == 6) goto L10;
        return r4;
    L10:
        return r1[0] + ":" + r1[1] + ":" + r1[2] + ":**:**:" + r1[5];
    }

    public static String removeDoubleQuotes(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.length();
        if (r0 > 1) goto L9;
        return r4;
    L9:
        if (r4.charAt(0) != '\"') goto L15;
        int r1 = r0 - 1;
        if (r4.charAt(r1) == '\"') goto L13;
        return r4;
    L13:
        return r4.substring(1, r1);
    L15:
        return r4;
    }

    public static String ssidHide(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r3);
        int r4 = r3.length() / 3;
        int r1 = 0;
    L7:
        if (r1 >= r4) goto L10;
        r0.setCharAt(r1, '*');
        r1 = r1 + 1;
        goto L7
    L10:
        return r0.toString();
    }
}
