package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j1<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f88117a = null;

    static {
        f88117a = new j1();
    }

    public j1() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        k3 r101 = (k3) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f88131a instanceof LotteryState.f;
    }
}
