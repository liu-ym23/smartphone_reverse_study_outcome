package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.functions.Predicate;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f91340a;

    public q(Set r100) {
        this.f91340a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        m.a r101 = (m.a) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return this.f91340a.contains(r101.f91318b);
    }
}
