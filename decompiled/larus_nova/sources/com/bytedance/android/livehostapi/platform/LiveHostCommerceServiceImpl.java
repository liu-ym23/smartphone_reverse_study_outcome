package com.bytedance.android.livehostapi.platform;

import com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.commerce.LiveECCommerce;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHostCommerceServiceImpl {
    public LiveHostCommerceServiceImpl() {
    }

    public static void registerLiveHostCommerceService() {
        IHostCommerceServiceLive r100 = LiveECCommerce.getCommerceInstanceWithReflect();
        if (r100 == null) goto L6;
        k.l(IHostCommerceServiceLive.class, r100);
        return;
    }
}
