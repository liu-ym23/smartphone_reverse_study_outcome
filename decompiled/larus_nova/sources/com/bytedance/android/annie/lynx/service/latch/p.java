package com.bytedance.android.annie.lynx.service.latch;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p<T> f39585a = null;

    static {
        f39585a = new p();
    }

    public p() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        b r101 = (b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101 == b.f39548c) goto L5;
        return true;
    L5:
        return false;
    }
}
