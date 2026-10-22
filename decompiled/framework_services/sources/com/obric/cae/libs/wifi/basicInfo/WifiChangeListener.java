package com.obric.cae.libs.wifi.basicInfo;

import android.net.wifi.ScanResult;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface WifiChangeListener {
    void onScanInfoChanged(List<ScanResult> r1);

    void onWifiInfoChanged(boolean r1);

    void onWifiStateChanged(int r1);
}
