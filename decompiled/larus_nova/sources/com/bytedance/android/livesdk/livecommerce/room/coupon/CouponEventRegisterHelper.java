package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;

/* JADX INFO: loaded from: classes10.dex */
public final class CouponEventRegisterHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f151729a;

    public static void a() {
        if (f151729a == false) goto L5;
        return;
    L5:
        f151729a = true;
        ECLiveHybridUtil.m("ecom.coupon.short_touch_coupon_msg", new c(CouponEventRegisterHelper$registerSubscriber$1.INSTANCE));
    }

    static {
    }
}
