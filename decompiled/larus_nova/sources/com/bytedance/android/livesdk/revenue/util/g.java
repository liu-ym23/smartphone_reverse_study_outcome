package com.bytedance.android.livesdk.revenue.util;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f157537a;

    public g(h r100) {
        this.f157537a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(T r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        h r101 = this.f157537a;
        return r101.f(r100, r101.f157539c);
    }
}
