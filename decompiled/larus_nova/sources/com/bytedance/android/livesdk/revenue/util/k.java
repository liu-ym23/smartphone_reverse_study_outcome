package com.bytedance.android.livesdk.revenue.util;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class k<T, U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<? extends T, ? extends U> f157545a;

    public k() {
    }

    public final U f(T r100, Function1<? super T, ? extends U> r101) {
        Intrinsics.checkNotNullParameter(r101, "transformer");
        Pair<? extends T, ? extends U> r102 = this.f157545a;
        if (r102 != null) goto L5;
    L8:
        U r103 = r101.invoke(r100);
        this.f157545a = TuplesKt.to(r100, r103);
        return r103;
    L5:
        if (r102.getFirst() != r100) goto L8;
        return r102.getSecond();
    }
}
