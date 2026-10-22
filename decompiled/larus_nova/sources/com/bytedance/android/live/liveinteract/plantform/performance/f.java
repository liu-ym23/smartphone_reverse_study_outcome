package com.bytedance.android.live.liveinteract.plantform.performance;

import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f77319a;

    public f(String r100) {
        this.f77319a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        d0 r101 = (d0) r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        return TuplesKt.to(this.f77319a, r101);
    }
}
