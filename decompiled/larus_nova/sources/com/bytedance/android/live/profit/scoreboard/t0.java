package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class t0<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Long f88971a;

    public t0(Long r100) {
        this.f88971a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        dv0.k r101 = (dv0.k) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        long r102 = r101.getRoundId();
        Long r103 = this.f88971a;
        if (r103 != null) goto L6;
    L8:
        return false;
    L6:
        if (r102 != r103.longValue()) goto L8;
        return true;
    }
}
