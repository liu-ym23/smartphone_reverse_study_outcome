package com.bytedance.android.annie.service.prefetch;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class j<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<T> f39968a = null;

    static {
        f39968a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        o.a r101 = (o.a) r100;
        Intrinsics.checkNotNullParameter(r101, "<name for destructuring parameter 0>");
        return !StringsKt.isBlank(r101.f39973b);
    }
}
