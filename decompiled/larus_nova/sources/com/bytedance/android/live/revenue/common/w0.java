package com.bytedance.android.live.revenue.common;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class w0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<String, T, T> f91012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<String, T, Unit> f91013b;

    /* JADX WARN: Multi-variable type inference failed */
    public w0(Function2<? super String, ? super T, ? extends T> r100, Function2<? super String, ? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "read");
        Intrinsics.checkNotNullParameter(r101, "write");
        this.f91012a = r100;
        this.f91013b = r101;
    }
}
