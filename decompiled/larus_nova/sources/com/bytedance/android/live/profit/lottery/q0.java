package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q0<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f88178a = null;

    static {
        f88178a = new q0();
    }

    public q0() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Long r101 = (Long) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.longValue() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
