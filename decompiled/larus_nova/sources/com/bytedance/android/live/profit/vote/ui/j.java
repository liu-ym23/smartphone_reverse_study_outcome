package com.bytedance.android.live.profit.vote.ui;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.vote.b f89355a;

    public j(com.bytedance.android.live.profit.vote.b r100) {
        this.f89355a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        return Long.valueOf(MathKt.roundToLong(this.f89355a.a() / 1000.0f));
    }
}
