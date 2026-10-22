package com.bytedance.android.live.profit.livepet.container;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f87853a = null;

    static {
        f87853a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        i32.a r101 = (i32.a) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Integer.valueOf(r101.f488090b + r101.f488089a);
    }
}
