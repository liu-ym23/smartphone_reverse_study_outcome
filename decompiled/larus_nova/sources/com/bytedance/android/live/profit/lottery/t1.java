package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class t1<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LotteryState.a f88205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lottery f88206b;

    public t1(LotteryState.a r100, Lottery r101) {
        this.f88205a = r100;
        this.f88206b = r101;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        e1 r101 = (e1) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.f88062a == this.f88205a.f88023a.f88194a) goto L5;
    L7:
        return false;
    L5:
        if ((this.f88206b.getState() instanceof LotteryState.a) == false) goto L7;
        return true;
    }
}
