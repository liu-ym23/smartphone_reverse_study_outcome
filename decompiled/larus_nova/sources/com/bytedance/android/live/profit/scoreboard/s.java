package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f88965a = null;

    static {
        f88965a = new s();
    }

    public s() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        com.bytedance.android.live.profit.scoreboard.dto.d r102 = ((com.bytedance.android.live.profit.scoreboard.dto.m) r101.data).getCounterInfo();
        if (r102 == null) goto L5;
        long r103 = r102.getActualFinishTime();
    L7:
        if (r103 > 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r103 = 0;
        goto L7
    }
}
