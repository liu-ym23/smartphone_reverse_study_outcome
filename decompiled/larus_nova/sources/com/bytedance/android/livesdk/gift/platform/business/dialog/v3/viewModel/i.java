package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f128897a = null;

    static {
        f128897a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(r101, "intercept");
        return !r101.booleanValue();
    }
}
