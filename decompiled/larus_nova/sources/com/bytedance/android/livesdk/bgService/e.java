package com.bytedance.android.livesdk.bgService;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f104316a = null;

    static {
        f104316a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(r101, "enable");
        return !r101.booleanValue();
    }
}
