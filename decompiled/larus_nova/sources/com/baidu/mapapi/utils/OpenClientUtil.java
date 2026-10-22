package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;

/* JADX INFO: loaded from: classes39.dex */
public class OpenClientUtil {
    public OpenClientUtil() {
    }

    public static int getBaiduMapVersion(Context r100) {
        if (r100 != null) goto L14;
        return 0;
    L14:
        String r101 = r100.getPackageManager().getPackageInfo(MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP, 0).versionName;     // Catch: Exception -> L13
        if (r101 == null) goto L12;
        if (r101.length() <= 0) goto L12;
        return CastIntegerProtector.valueOf(r101.trim().replace(".", "").trim()).intValue();
    L12:
        return 0;
    }

    public static void getLatestBaiduMapApp(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = a.a(r100);
        Intent r102 = new Intent();
        r102.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r102.setData(UriProtector.parse("https://map.baidu.com/zt/client/index/?fr=sdk_[" + r101 + "]"));
        r100.startActivity(r102);
    }
}
