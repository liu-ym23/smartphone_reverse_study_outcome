package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f91457a = null;

    static {
        f91457a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        h80.c r101 = (h80.c) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.b();
    }
}
