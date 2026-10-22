package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.recharge.exchange.model.AutoExchangeStatus;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f89914a = null;

    static {
        f89914a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Integer r101 = (Integer) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        int r102 = AutoExchangeStatus.Open.getValue();
        if (r101.intValue() != r102) goto L5;
        boolean r103 = true;
    L7:
        return Boolean.valueOf(r103);
    L5:
        r103 = false;
        goto L7
    }
}
