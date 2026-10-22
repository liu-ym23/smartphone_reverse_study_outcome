package com.stepos.alphame.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.persona.wifi.bean.WifiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NetworkHelper {
    public static List<WifiInfo> getWifiConnectedList() {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : PerfBinderHelper.getConfiguredWifiNetworks()) {
            WifiInfo wifiInfo = new WifiInfo();
            String string = bundle.getString("ssid");
            String string2 = bundle.getString("bssid");
            AlphaMeLogger.debugLog("Personal", " ssid " + string);
            if (!TextUtils.isEmpty(string)) {
                wifiInfo.setSsid(string.replace(String.valueOf('\"'), ""));
            }
            AlphaMeLogger.debugLog("Personal", " bssid " + string2);
            if (!TextUtils.isEmpty(string2)) {
                wifiInfo.setSsid(string2);
            }
            arrayList.add(wifiInfo);
        }
        return arrayList;
    }

    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        Log.e(NetworkHelper.class.getName(), "Can't get connectivitManager");
        return false;
    }

    public static boolean isMobileNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 0;
        }
        Log.e(NetworkHelper.class.getName(), "Can't get connectivitManager");
        return false;
    }

    public static boolean isWifiNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
        }
        Log.e(NetworkHelper.class.getName(), "Can't get connectivitManager");
        return false;
    }
}
