package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m<T1, T2> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
    public m() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "t1");
        Intrinsics.checkNotNullParameter(r101, "t2");
        return TuplesKt.to(r100, r101);
    }
}
