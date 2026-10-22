package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        if (network == null) {
            return;
        }
        super.onAvailable(network);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    @Override // android.net.ConnectivityManager.NetworkCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCapabilitiesChanged(android.net.Network r5, android.net.NetworkCapabilities r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L55
            if (r6 != 0) goto L5
            goto L55
        L5:
            super.onCapabilitiesChanged(r5, r6)
            r4 = 16
            boolean r4 = r6.hasCapability(r4)
            if (r4 == 0) goto L4c
            r4 = 1
            boolean r4 = r6.hasTransport(r4)
            r5 = 0
            boolean r5 = r6.hasTransport(r5)
            r0 = 3
            boolean r0 = r6.hasTransport(r0)
            r1 = 6
            boolean r1 = r6.hasTransport(r1)
            r2 = 4
            boolean r2 = r6.hasTransport(r2)
            r3 = 5
            boolean r6 = r6.hasTransport(r3)
            if (r4 == 0) goto L33
            java.lang.String r4 = "WIFI"
            goto L4e
        L33:
            if (r5 == 0) goto L38
            java.lang.String r4 = "CELLULAR"
            goto L4e
        L38:
            if (r0 == 0) goto L3d
            java.lang.String r4 = "ETHERNET"
            goto L4e
        L3d:
            if (r1 == 0) goto L42
            java.lang.String r4 = "LoWPAN"
            goto L4e
        L42:
            if (r2 == 0) goto L47
            java.lang.String r4 = "VPN"
            goto L4e
        L47:
            if (r6 == 0) goto L4c
            java.lang.String r4 = "WifiAware"
            goto L4e
        L4c:
            java.lang.String r4 = "mobile"
        L4e:
            com.baidu.platform.comapi.util.SysOSUtil r5 = com.baidu.platform.comapi.util.SysOSUtil.getInstance()
            r5.updateNetType(r4)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.util.NetworkCallbackImpl.onCapabilitiesChanged(android.net.Network, android.net.NetworkCapabilities):void");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        if (network == null) {
            return;
        }
        super.onLost(network);
        SysOSUtil.getInstance().updateNetType("mobile");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        super.onUnavailable();
        SysOSUtil.getInstance().updateNetType("mobile");
    }
}
