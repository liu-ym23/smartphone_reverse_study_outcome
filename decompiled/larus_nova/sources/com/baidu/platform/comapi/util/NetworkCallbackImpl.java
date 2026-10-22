package com.baidu.platform.comapi.util;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes39.dex */
public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        super.onUnavailable();
        SysOSUtil.getInstance().updateNetType("mobile");
    }

    public NetworkCallbackImpl() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        super.onAvailable(r100);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        super.onLost(r100);
        SysOSUtil.getInstance().updateNetType("mobile");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
        if (r100 == null) goto L23;
        if (r101 == null) goto L24;
        super.onCapabilitiesChanged(r100, r101);
        if (r101.hasCapability(16) == false) goto L20;
        boolean r102 = r101.hasTransport(1);
        boolean r103 = r101.hasTransport(0);
        boolean r104 = r101.hasTransport(3);
        boolean r105 = r101.hasTransport(6);
        boolean r106 = r101.hasTransport(4);
        boolean r107 = r101.hasTransport(5);
        if (r102 == false) goto L10;
        String r108 = "WIFI";
    L21:
        SysOSUtil.getInstance().updateNetType(r108);
        return;
    L10:
        if (r103 == false) goto L12;
        r108 = "CELLULAR";
        goto L21
    L12:
        if (r104 == false) goto L14;
        r108 = "ETHERNET";
        goto L21
    L14:
        if (r105 == false) goto L16;
        r108 = "LoWPAN";
        goto L21
    L16:
        if (r106 == false) goto L18;
        r108 = "VPN";
        goto L21
    L18:
        if (r107 == false) goto L20;
        r108 = "WifiAware";
    L20:
        r108 = "mobile";
        goto L21
    L24:
        return;
    }
}
