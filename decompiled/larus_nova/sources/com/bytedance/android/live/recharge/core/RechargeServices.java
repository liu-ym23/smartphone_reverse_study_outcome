package com.bytedance.android.live.recharge.core;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class RechargeServices {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f89681a = null;

    public static final d b() {
        return (d) f89681a.getValue();
    }

    static {
        f89681a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, RechargeServices$rechargeServices$2.INSTANCE);
    }

    public static final ow0.a a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$firstChargeService");
        return (ow0.a) r100.f(Reflection.getOrCreateKotlinClass(ow0.a.class));
    }
}
