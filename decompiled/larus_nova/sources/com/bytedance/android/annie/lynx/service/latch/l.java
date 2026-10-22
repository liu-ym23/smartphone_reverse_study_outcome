package com.bytedance.android.annie.lynx.service.latch;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.annie.service.prefetch.n f39581a;

    public l(k r100, com.bytedance.android.annie.service.prefetch.n r101) {
        this.f39581a = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "node");
        return new k.a(this.f39581a, r101);
    }
}
