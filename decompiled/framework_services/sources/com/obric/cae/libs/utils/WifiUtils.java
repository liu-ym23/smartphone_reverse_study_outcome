package com.obric.cae.libs.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
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

    public static List<ScanResult> getWifiScanResults(Context r1, WifiManager r2) {
        if (r2 != null) goto L6;
        return Collections.emptyList();
    L6:
        if (r1.checkSelfPermission("android.permission.NEARBY_WIFI_DEVICES") == 0) goto L10;
        LogUtil.e("WifiUtils", "getWifiScanResults: NEARBY_WIFI_DEVICES permission not granted");
        return Collections.emptyList();
    L10:
        return r2.getScanResults();
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

    public static boolean isWifiConnected(Context r3) {
        ConnectivityManager r0 = (ConnectivityManager) r3.getSystemService("connectivity");
        if (((WifiManager) r3.getSystemService("wifi")) == null) goto L20;
        if (r0 == null) goto L20;
        if (r3.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) goto L10;
        LogUtil.e("WifiUtils", "isWifiConnected: ACCESS_NETWORK_STATE permission not granted");
        return false;
    L10:
        Network r4 = r0.getActiveNetwork();
        if (r4 != null) goto L13;
        return false;
    L13:
        NetworkCapabilities r5 = r0.getNetworkCapabilities(r4);
        if (r5 != null) goto L16;
        return false;
    L16:
        if (r5.hasTransport(1) == true) goto L19;
        return false;
    L19:
        return true;
    L20:
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
