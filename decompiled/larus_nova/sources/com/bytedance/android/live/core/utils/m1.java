package com.bytedance.android.live.core.utils;

import android.os.Build;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.utility.StringUtils;

/* JADX INFO: loaded from: classes45.dex */
public final class m1 {
    public static boolean a() {
        String r100 = Build.MODEL;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r100) == false) goto L7;
    L8:
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r101) == true) goto L17;
        if (r101.toLowerCase().startsWith("oneplus") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r100.toLowerCase().contains("oneplus") == true) goto L12;
    L19:
        return false;
    }

    public static boolean b() {
        String r100 = Build.BRAND;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r100) == false) goto L7;
    L8:
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r101) == true) goto L17;
        if (r101.toLowerCase().startsWith(AppConstants.CHANNEL_OPPO) == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r100.toLowerCase().startsWith(AppConstants.CHANNEL_OPPO) == true) goto L12;
    L19:
        return false;
    }

    public static boolean c() {
        String r100 = Build.MODEL;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r100) == false) goto L7;
    L8:
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r101) == true) goto L17;
        if (r101.toLowerCase().startsWith("realme") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r100.toLowerCase().contains("realme") == true) goto L12;
    L19:
        return false;
    }
}
