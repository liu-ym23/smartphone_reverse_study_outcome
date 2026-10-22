package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f91448a = null;

    static {
        f91448a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.live.revenue.platform.container.impl.core.h r101 = (com.bytedance.android.live.revenue.platform.container.impl.core.h) r100;
        Intrinsics.checkNotNullParameter(r101, "mgr");
        zy0.b r102 = r101.D();
        Intrinsics.checkNotNull(r102);
        return new d(r101, r102);
    }
}
