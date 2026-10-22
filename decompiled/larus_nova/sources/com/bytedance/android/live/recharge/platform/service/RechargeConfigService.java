package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.platform.core.config.RechargeConfigKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class RechargeConfigService implements com.bytedance.android.scope.o, zv0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bx0.f f90291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f90292b;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f90291a = new bx0.f();
    }

    public RechargeConfigService() {
        this.f90292b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new RechargeConfigService$configStore$2(this));
    }

    @Override // zv0.g
    public final <T extends zv0.h> T p1(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        bx0.e r101 = (bx0.e) this.f90292b.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r102 = MapsKt.getValue(r101.f21276b, r100);
        if (r102 == null) goto L7;
        return (T) r102;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public final <V> V E1(RechargeConfigKey r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        bx0.e r102 = (bx0.e) this.f90292b.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r103 = r102.f21275a.get(r100);
        if ((r103 instanceof Object) == true) goto L5;
        r103 = null;
    L5:
        if (r103 != null) goto L8;
        return r101;
    L8:
        return (V) r103;
    }
}
