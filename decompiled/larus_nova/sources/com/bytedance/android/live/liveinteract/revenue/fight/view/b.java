package com.bytedance.android.live.liveinteract.revenue.fight.view;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f78276a = null;

    static {
        f78276a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Long r101 = (Long) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.longValue() > 0) goto L5;
        return true;
    L5:
        return false;
    }
}
