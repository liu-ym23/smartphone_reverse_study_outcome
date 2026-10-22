package com.bytedance.android.window.shop.home.tab.event;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/event/WindowCouponBannerEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "name", "", "(Ljava/lang/String;)V", "couponGroup", "getCouponGroup", "()Ljava/lang/String;", "followStatus", "getFollowStatus", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowCouponBannerEvent extends BaseMetricsEvent2 {

    @EventKey("coupon_group")
    private final String couponGroup;

    @EventKey("follow_status")
    private final String followStatus;

    public final String getCouponGroup() {
        return this.couponGroup;
    }

    public final String getFollowStatus() {
        return this.followStatus;
    }

    public WindowCouponBannerEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        super(r100);
        this.couponGroup = "fans_102";
    }
}
