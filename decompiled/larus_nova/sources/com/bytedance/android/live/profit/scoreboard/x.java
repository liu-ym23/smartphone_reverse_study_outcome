package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScoreboardBannerView f89008a;

    public x(ScoreboardBannerView r100) {
        this.f89008a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Unit) r100, "it");
        return Integer.valueOf(this.f89008a.getWidth());
    }
}
