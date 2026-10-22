package com.bytedance.android.shopping.orderlist.common.controller;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonPageConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f179697a = null;

    static {
        f179697a = LazyKt.lazy(OrderCommonPageConfig$splitService$2.INSTANCE);
    }

    public static boolean a() {
        nj.d r100 = (nj.d) f179697a.getValue();
        if (r100 == null) goto L7;
        r100.isFold();
        return false;
    L7:
        return false;
    }

    public static com.bytedance.android.ecom.arch.slice.render.context.b b(boolean r100) {
        a();
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        float r102 = 1.0f;
        int r103 = 0;
        if (com.bytedance.android.shopping.extensions.k.e(r101.getCurrentFontScale(), 1.0f) < 1.15f) goto L5;
        boolean r104 = true;
    L6:
        Lazy r105 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderCommonPageConfig", OrderCommonPageConfig$getSlcDisplayMetrics$1.INSTANCE);
        com.bytedance.android.ecom.arch.slice.render.context.b.a r106 = com.bytedance.android.ecom.arch.slice.render.context.b.f50238f;
        if (r104 == false) goto L11;
        Float r107 = r101.getCurrentFontScale();
        if (r107 == null) goto L11;
        float r108 = r107.floatValue();
    L12:
        if (r104 == true) goto L14;
    L16:
        if (r100 == false) goto L21;
        nj.d r109 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r109 == null) goto L20;
        r109.getSpiltWidth();
    L22:
        r106.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.b(375.0f, r102, r108, r103);
    L20:
        r103 = 360;
        goto L22
    L21:
        r103 = -1;
        goto L22
    L14:
        if (com.bytedance.android.shopping.extensions.k.d(r101.getCurrentFontScale()) <= 1.15f) goto L16;
        r102 = 1.15f;
    L11:
        r108 = 1.0f;
        goto L12
    L5:
        r104 = false;
        goto L6
    }
}
