package com.bytedance.android.live.recharge.balance;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T, R> implements Function {
    public i() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        DATA r102 = r101.data;
        if (r102 == 0) goto L7;
        return (com.bytedance.android.live.recharge.l) r102;
    L7:
        throw new IllegalStateException("/webcast/wallet/info/ returned null data".toString());
    }
}
