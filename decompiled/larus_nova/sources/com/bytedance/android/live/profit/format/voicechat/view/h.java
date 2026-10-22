package com.bytedance.android.live.profit.format.voicechat.view;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f87788a;

    public h(long r100) {
        this.f87788a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Long r101 = (Long) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Float.valueOf((this.f87788a - r101.longValue()) / this.f87788a);
    }
}
