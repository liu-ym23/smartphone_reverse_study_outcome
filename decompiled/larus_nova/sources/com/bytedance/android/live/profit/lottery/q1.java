package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q1<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LotteryState.a f88179a;

    public q1(LotteryState.a r100) {
        this.f88179a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        e1 r101 = (e1) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.f88062a != this.f88179a.f88023a.f88194a) goto L5;
        return true;
    L5:
        return false;
    }
}
