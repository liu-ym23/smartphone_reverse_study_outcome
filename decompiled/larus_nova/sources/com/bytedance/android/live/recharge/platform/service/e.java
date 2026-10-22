package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f90297a = null;

    static {
        f90297a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.live.recharge.deal.i r101 = (com.bytedance.android.live.recharge.deal.i) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        boolean r102 = LastCustomRechargeRecoder.f90450a;
        return LastCustomRechargeRecoder.c(r101, com.bytedance.android.live.recharge.panel.g.a());
    }
}
