package com.bytedance.android.shopping.mall.opt;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f178581a;

    public static List a() {
        if (f178581a != null) goto L13;
        int r100 = s93.c.f541066a;
        Object r101 = new i(null);
        IHybridHostService r102 = com.bytedance.android.ec.hybrid.a.h();
        if (r102 == null) goto L12;
        yj.g r103 = r102.getHostAB();
        if (r103 == null) goto L12;
        Object r104 = r103.a("ec_mall_search_pitaya_refresh_config", r101);
        if (r104 == null) goto L12;
        r101 = r104;
    L12:
        Lazy r105 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : ec_mall_search_pitaya_refresh_config, Value: " + r101);
        f178581a = (i) r101;
    L13:
        i r106 = f178581a;
        if (r106 == null) goto L18;
        List<String> r107 = r106.b();
        if (r107 == null) goto L18;
        return r107;
    L18:
        return new ArrayList();
    }

    public static boolean b() {
        Integer r100 = null;
        if (f178581a != null) goto L13;
        int r101 = s93.c.f541066a;
        Object r102 = new i(null);
        IHybridHostService r103 = com.bytedance.android.ec.hybrid.a.h();
        if (r103 == null) goto L12;
        yj.g r104 = r103.getHostAB();
        if (r104 == null) goto L12;
        Object r105 = r104.a("ec_mall_search_pitaya_refresh_config", r102);
        if (r105 == null) goto L12;
        r102 = r105;
    L12:
        Lazy r106 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : ec_mall_search_pitaya_refresh_config, Value: " + r102);
        f178581a = (i) r102;
    L13:
        i r107 = f178581a;
        if (r107 == null) goto L16;
        r100 = r107.a();
    L16:
        if (r100 != null) goto L19;
    L20:
        return true;
    L19:
        if (r100.intValue() != 0) goto L20;
        return false;
    }

    static {
    }
}
