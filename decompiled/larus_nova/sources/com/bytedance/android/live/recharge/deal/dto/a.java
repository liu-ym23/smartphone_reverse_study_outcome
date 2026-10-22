package com.bytedance.android.live.recharge.deal.dto;

import com.bytedance.android.live.recharge.deal.d;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.platform.business.model.diamond.e;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final d b(e r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$toCustomDeal");
        long r100 = r110.getId();
        long r101 = r110.getMinPrice();
        long r111 = r110.getMaxPrice();
        String r102 = r110.getDescribe();
        if (r102 != null) goto L5;
        String r103 = "";
    L6:
        float r112 = r110.getDiamondCountRate();
        int r104 = r110.getRewardDiamondCount();
        String r105 = r110.getCouponId();
        if (r105 != null) goto L9;
        String r113 = "";
    L11:
        return new d(r100, 0, r104, r103, "", r101, r111, r112, r113, false);
    L9:
        r113 = r105;
        goto L11
    L5:
        r103 = r102;
        goto L6
    }

    public static final u c(IChargeDeal r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$toRegularDeal");
        long r100 = r110.getId();
        long r101 = r110.getPrice();
        int r102 = r110.getDiamondCount();
        int r103 = r110.getRewardDiamondCount();
        String r104 = r110.getDescribe();
        boolean r111 = r110.isCustomizedDiamond();
        int r112 = r110.getDiscountPrice();
        int r113 = r110.getExchangePrice();
        String r105 = r110.getDiamondSignInfo();
        String r106 = "";
        if (r105 != null) goto L5;
        String r114 = "";
    L6:
        String r107 = r110.getIapProductId();
        if (r107 == null) goto L11;
        r106 = r107;
    L11:
        return new u(r100, r101, r102, r103, r104, r106, r111, r112, r113, r114, r110.getDescribeType());
    L5:
        r114 = r105;
        goto L6
    }

    public static final u a(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "description");
        return new u(666666, r110, r110 / 10, 0, r111, "", true, r110, r110, "", 0);
    }
}
