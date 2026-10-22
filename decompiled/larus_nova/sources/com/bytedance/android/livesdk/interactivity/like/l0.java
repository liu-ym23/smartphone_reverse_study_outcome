package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Predicate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l0<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f137684a = null;

    static {
        f137684a = new l0();
    }

    public l0() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "events");
        if (r101.size() < 2) goto L5;
        return true;
    L5:
        return false;
    }
}
