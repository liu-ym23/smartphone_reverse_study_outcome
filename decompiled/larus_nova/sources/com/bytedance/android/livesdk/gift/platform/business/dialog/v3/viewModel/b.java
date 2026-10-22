package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f128817a = null;

    static {
        f128817a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(r101, "intercept");
        return !r101.booleanValue();
    }
}
