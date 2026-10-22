package com.bytedance.android.live.liveinteract.revenue.fight.view;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f78275a;

    public a(long r100) {
        this.f78275a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Long r101 = (Long) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Long.valueOf(this.f78275a - r101.longValue());
    }
}
