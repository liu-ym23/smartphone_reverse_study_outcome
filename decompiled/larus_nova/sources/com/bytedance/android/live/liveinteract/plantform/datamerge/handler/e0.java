package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e0<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f76431a = null;

    static {
        f76431a = new e0();
    }

    public e0() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        b.C1190b r101 = (b.C1190b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f76423d;
    }
}
