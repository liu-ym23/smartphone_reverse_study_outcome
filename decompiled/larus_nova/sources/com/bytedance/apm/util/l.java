package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.common.utility.NetworkUtils;

/* JADX INFO: loaded from: classes14.dex */
public final class l {
    public static NetworkUtils.NetworkType a(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L23
        if (r101 == null) goto L22;
        if (r101.isAvailable() == false) goto L22;
        int r102 = r101.getType();     // Catch: Throwable -> L23
        if (1 == r102) goto L10;
        if (r102 != 0) goto L20;
        switch(((TelephonyManager) r100.getSystemService("phone")).getNetworkType()) {
            case 3: goto L18;
            case 4: goto L26;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L26;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            case 11: goto L26;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L18;
            case 15: goto L18;
            default: goto L26;
        };     // Catch: Throwable -> L23
    L26:
        return NetworkUtils.NetworkType.MOBILE;
    L16:
        return NetworkUtils.NetworkType.MOBILE_4G;
    L18:
        return NetworkUtils.NetworkType.MOBILE_3G;
    L20:
        return NetworkUtils.NetworkType.MOBILE;
    L10:
        return NetworkUtils.NetworkType.WIFI;
    L22:
        return NetworkUtils.NetworkType.NONE;
    L24:
        return NetworkUtils.NetworkType.MOBILE;
    }
}
