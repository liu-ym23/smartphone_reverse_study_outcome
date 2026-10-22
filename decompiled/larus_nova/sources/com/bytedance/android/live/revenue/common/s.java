package com.bytedance.android.live.revenue.common;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f90992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<V> f90993b;

    /* JADX WARN: Multi-variable type inference failed */
    public s(K r100, Function0<? extends V> r101) {
        Intrinsics.checkNotNullParameter(r101, "fallbackValue");
        this.f90992a = r100;
        this.f90993b = r101;
    }
}
