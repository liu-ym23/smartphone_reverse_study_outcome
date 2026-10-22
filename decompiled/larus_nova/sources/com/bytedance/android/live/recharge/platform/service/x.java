package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.deal.DealSetApiDataSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x implements DealSetApiDataSource.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f90335a = null;

    public x() {
    }

    static {
        f90335a = new x();
    }

    @Override // com.bytedance.android.live.recharge.deal.DealSetApiDataSource.b
    public final void a(com.bytedance.android.live.recharge.deal.m r100) {
        Intrinsics.checkNotNullParameter(r100, "requestParams");
        if (com.bytedance.android.live.wallet.pay.iap.f.a() == false) goto L5;
        int r101 = 212;
    L6:
        Map<String, String> r102 = r100.f89721a;
        HashMap r103 = (HashMap) r102;
        r103.put("type", String.valueOf(r101));
        return;
    L5:
        r101 = 1;
        goto L6
    }
}
