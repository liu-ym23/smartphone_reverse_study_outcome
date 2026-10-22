package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class y0<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f89012a = null;

    static {
        f89012a = new y0();
    }

    public y0() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.booleanValue();
    }
}
