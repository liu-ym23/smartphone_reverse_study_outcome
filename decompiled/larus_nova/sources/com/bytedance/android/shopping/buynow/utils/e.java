package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.data.remote.BuyNowAppInfos;
import com.bytedance.android.shopping.buynow.data.remote.BuyNowSubBTypes;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f171208a = 0;

    static {
        f171208a = com.bytedance.android.shopping.extensions.k.r(ECAppInfoService.f48114e.getAppId(), 1128);
    }

    public static int a() {
        BuyNowAppInfos.a r100 = BuyNowAppInfos.Companion;
        int r101 = f171208a;
        r100.getClass();
        BuyNowAppInfos[] r102 = BuyNowAppInfos.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        BuyNowAppInfos r105 = r102[r104];
        if (r105.getAid() != r101) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L12;
        r104 = r104 + 1;
    L12:
        if (r105 != null) goto L18;
        return 2;
    L18:
        return r105.getBType();
    L7:
        r106 = false;
        goto L8
    L11:
        r105 = null;
        goto L12
    }

    public static int b(boolean r100) {
        BuyNowSubBTypes.Companion.getClass();
        if (r100 == false) goto L6;
        return com.bytedance.android.shopping.extensions.k.r(ECAppInfoService.f48114e.getAppId(), 1128);
    L6:
        return BuyNowSubBTypes.H5.getType();
    }
}
