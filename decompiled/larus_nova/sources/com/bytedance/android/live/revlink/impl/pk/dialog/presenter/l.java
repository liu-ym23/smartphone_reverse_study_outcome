package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes47.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f96049a;

    public l(long r100) {
        this.f96049a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        long r101 = ((Number) r100).longValue();
        return Long.valueOf(this.f96049a - r101);
    }
}
