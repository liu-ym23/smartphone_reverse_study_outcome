package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class w<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f88766a = null;

    static {
        f88766a = new w();
    }

    public w() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        k1 r101 = (k1) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return !(r101.f88650c instanceof RedPacketState.Waiting);
    }
}
