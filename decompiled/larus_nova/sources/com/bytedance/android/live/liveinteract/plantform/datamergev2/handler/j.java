package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f76716a = null;

    static {
        f76716a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b r101 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f76422c;
    }
}
