package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h0<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f88099a = null;

    static {
        f88099a = new h0();
    }

    public h0() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        t r102 = (t) sh6.c.b(r101);
        if (r102 != null) goto L5;
    L8:
        return true;
    L5:
        if (r102.f88195b != 4) goto L8;
        return false;
    }
}
