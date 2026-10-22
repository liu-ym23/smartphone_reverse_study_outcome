package com.bytedance.android.livesdk.arch.task;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class r<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TbTaskFlower f103915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f103916b;

    public r(TbTaskFlower r100, x r101) {
        this.f103915a = r100;
        this.f103916b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        d r101 = (d) r100;
        Intrinsics.checkNotNullParameter(r101, "task");
        return r101.a(this.f103916b).doOnNext(new p(this, r101)).flatMap(new q(r101));
    }
}
