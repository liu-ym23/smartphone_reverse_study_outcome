package com.bytedance.android.live.profile.seeselftransition;

import io.reactivex.functions.BiFunction;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f86165a = null;

    static {
        f86165a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        sh6.b r102 = (sh6.b) r100;
        sh6.b r103 = (sh6.b) r101;
        Intrinsics.checkNotNullParameter(r102, "t1");
        Intrinsics.checkNotNullParameter(r103, "t2");
        return TuplesKt.to(sh6.c.b(r102), sh6.c.b(r103));
    }
}
