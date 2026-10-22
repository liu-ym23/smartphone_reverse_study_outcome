package com.byted.cast.common.ble;

import android.content.Context;
import android.net.wifi.WifiManager;

/* JADX INFO: loaded from: classes39.dex */
public class WifiUtils {
    private static final int IP_LENGTH = 4;
    static boolean isBlePublish;

    private WifiUtils() {
    }

    public static boolean isBlePublish() {
        return isBlePublish;
    }

    public static int getIpAdress(Context r100) {
        return getWifiManager(r100).getDhcpInfo().ipAddress;
    }

    public static int getNetMaskInt(Context r100) {
        return getWifiManager(r100).getDhcpInfo().netmask;
    }

    public static String getStringIp(int r100) {
        String r101 = "";
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= 4) goto L7;
        r101 = r101 + ((r100 >> r103) & 255) + ".";
        r102 = r102 + 1;
        r103 = r103 + 8;
        goto L4
    L7:
        return r101.substring(0, r101.length() - 1);
    }

    public static WifiManager getWifiManager(Context r100) {
        return (WifiManager) r100.getApplicationContext().getSystemService("wifi");
    }

    public static void setBlePublish(boolean r100) {
        isBlePublish = r100;
    }

    public static boolean isInSameLAN(Context r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r103 = getIpAdress(r100);
        if ((getNetMaskInt(r100) & r103) != (r101 & r102)) goto L9;
        return true;
    L9:
        return false;
    }
}
