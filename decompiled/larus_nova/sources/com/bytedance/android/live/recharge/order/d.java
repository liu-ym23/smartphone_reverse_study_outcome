package com.bytedance.android.live.recharge.order;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f90088a = null;

    static {
        f90088a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Order.State r101 = (Order.State) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.isClosed();
    }
}
