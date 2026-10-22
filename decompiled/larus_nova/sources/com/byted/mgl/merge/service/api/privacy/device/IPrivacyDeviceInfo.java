package com.byted.mgl.merge.service.api.privacy.device;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public interface IPrivacyDeviceInfo {
    String getBSSID(WifiInfo r100, String r101);

    List<WifiConfiguration> getConfiguredNetworks(WifiManager r100, String r101);

    WifiInfo getConnectionInfo(WifiManager r100, String r101);

    String getCookie(CookieManager r100, String r101, String r102);

    Sensor getDefaultSensor(SensorManager r100, int r101, String r102);

    String getExtraInfo(NetworkInfo r100, String r101);

    String getNetworkOperator(TelephonyManager r100, String r101);

    String getNetworkOperatorName(TelephonyManager r100, String r101);

    int getNetworkType(TelephonyManager r100, String r101);

    String getSSID(WifiInfo r100, String r101);

    List<ScanResult> getScanResults(WifiManager r100, String r101);

    void setCookie(CookieManager r100, String r101, String r102, String r103);

    boolean startScan(WifiManager r100, String r101);
}
