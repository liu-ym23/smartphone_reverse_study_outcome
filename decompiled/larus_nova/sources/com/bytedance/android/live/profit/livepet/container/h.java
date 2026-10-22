package com.bytedance.android.live.profit.livepet.container;

import android.view.ViewGroup;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f87854a;

    public h(ViewGroup r100) {
        this.f87854a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Unit) r100, "it");
        return TuplesKt.to(Integer.valueOf(this.f87854a.getWidth()), Integer.valueOf(this.f87854a.getHeight()));
    }
}
