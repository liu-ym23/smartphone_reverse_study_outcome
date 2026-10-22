package com.bytedance.android.shopping.orderlist.common.debug;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import kotlin.Lazy;
import kotlin.LazyKt;
import sc3.h;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderUIDebugClientHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f179761a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f179762b = null;

    static {
        int r100 = ECSdk.f48106a;
        IEShoppingService r101 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r101 == null) goto L5;
        h r102 = r101.getOrderListService();
    L6:
        f179761a = r102;
        f179762b = LazyKt.lazy(OrderUIDebugClientHelper$mainHandler$2.INSTANCE);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
