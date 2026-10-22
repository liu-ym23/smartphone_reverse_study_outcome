package com.bytedance.android.annie.lynx.service.latch;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<T, R> f39584a = null;

    static {
        f39584a = new o();
    }

    public o() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Throwable) r100, "it");
        return b.f39548c;
    }
}
