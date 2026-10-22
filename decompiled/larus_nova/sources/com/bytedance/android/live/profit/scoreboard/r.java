package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f88953a = null;

    static {
        f88953a = new r();
    }

    public r() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (((com.bytedance.android.live.profit.scoreboard.dto.m) r101.data).getCounterInfo() == null) goto L9;
        com.bytedance.android.live.profit.scoreboard.dto.d r102 = ((com.bytedance.android.live.profit.scoreboard.dto.m) r101.data).getCounterInfo();
        if (r102 != null) goto L7;
    L8:
        return true;
    L7:
        if (r102.getCounterId() != 0) goto L8;
    L9:
        return false;
    }
}
