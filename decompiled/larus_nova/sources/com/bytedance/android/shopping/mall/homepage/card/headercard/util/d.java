package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import kotlin.Lazy;
import yj.g;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f177883a = false;

    static {
        int r100 = s93.c.f541066a;
        boolean r101 = true;
        Object r102 = 1;
        IHybridHostService r103 = com.bytedance.android.ec.hybrid.a.h();
        if (r103 == null) goto L10;
        g r104 = r103.getHostAB();
        if (r104 == null) goto L10;
        Object r105 = r104.a("ec_mall_header_card_async_report", r102);
        if (r105 == null) goto L10;
        r102 = r105;
    L10:
        Lazy r106 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : ec_mall_header_card_async_report, Value: " + r102);
        if (((Number) r102).intValue() == 1) goto L14;
        r101 = false;
    L14:
        f177883a = r101;
    }
}
