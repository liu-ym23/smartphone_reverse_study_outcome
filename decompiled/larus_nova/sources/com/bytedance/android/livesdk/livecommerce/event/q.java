package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;

/* JADX INFO: loaded from: classes10.dex */
public final class q extends ECEventV3 {
    public q(boolean r100, boolean r101) {
        super("livesdk_commerce_cart_success");
        d("is_new_slot", EComABUtils.isEnableLiveOptSlot() ? 1 : 0);
        d(IPerformanceManager.Params.is_anchor, r100 ? 1 : 0);
        d("is_first_load", r101 ? 1 : 0);
    }
}
