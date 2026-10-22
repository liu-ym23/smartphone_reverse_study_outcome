package com.bytedance.android.shopping.store.home.presenter;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s1<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1 f184395a = null;

    static {
        f184395a = new s1();
    }

    public s1() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        com.bytedance.android.shopping.store.utils.j.a();
        return Unit.INSTANCE;
    }
}
