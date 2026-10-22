package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class x<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f76756a = null;

    static {
        f76756a = new x();
    }

    public x() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b r101 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f76423d;
    }
}
