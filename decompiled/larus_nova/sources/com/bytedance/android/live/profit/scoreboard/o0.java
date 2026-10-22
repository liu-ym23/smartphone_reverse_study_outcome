package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o0<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f88937a;

    public o0(long r100) {
        this.f88937a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        dv0.h r101 = (dv0.h) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.getRoomId() != this.f88937a) goto L5;
        return true;
    L5:
        return false;
    }
}
