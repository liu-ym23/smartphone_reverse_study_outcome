package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class v {
    public static final oc6.e a(ExchangeInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toRpc");
        oc6.e r101 = new oc6.e();
        r101.b(r100.getHideCashExchange());
        r101.c(r100.getHideCombineExchange());
        int r102 = com.bytedance.android.live.recharge.util.d.f90424a;
        r101.a(com.bytedance.android.live.recharge.util.d.b(s1.getContext()));
        return r101;
    }
}
