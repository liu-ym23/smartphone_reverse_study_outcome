package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f88972a = null;

    static {
        f88972a = new u();
    }

    public u() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (com.bytedance.android.live.profit.scoreboard.dto.g) r101.data;
    }
}
