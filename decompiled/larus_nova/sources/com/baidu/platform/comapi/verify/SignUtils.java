package com.baidu.platform.comapi.verify;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;

/* JADX INFO: loaded from: classes39.dex */
public class SignUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f33429a = 621133959;

    public SignUtils() {
    }

    private static int a(Context r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        Signature[] r101 = r100.getPackageManager().getPackageInfo(MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP, 64).signatures;     // Catch: Exception -> L13
    L11:
        return r101[0].hashCode();
    L7:
        if (r100.getPackageManager().getPackageInfo(MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.hasMultipleSigners() == false) goto L9;
        r101 = r100.getPackageManager().getPackageInfo(MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.getApkContentsSigners();     // Catch: Exception -> L13
        goto L11
    L9:
        r101 = r100.getPackageManager().getPackageInfo(MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.getSigningCertificateHistory();     // Catch: Exception -> L13
    L16:
        return 0;
    }

    private static boolean b(Context r100) {
        if (a(r100) != f33429a) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean verifySign(Context r100) {
        return b(r100);
    }
}
