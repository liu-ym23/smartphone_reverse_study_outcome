package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class v1<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v1 f88225a = null;

    static {
        f88225a = new v1();
    }

    public v1() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        LotteryState r101 = (LotteryState) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return l.b(r101);
    }
}
