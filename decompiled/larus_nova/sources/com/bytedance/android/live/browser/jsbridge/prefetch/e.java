package com.bytedance.android.live.browser.jsbridge.prefetch;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f63799a = null;

    static {
        f63799a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        com.bytedance.android.live.browser.jsbridge.g.a r101 = (com.bytedance.android.live.browser.jsbridge.g.a) r100;
        Intrinsics.checkNotNullParameter(r101, "<name for destructuring parameter 0>");
        return !StringsKt.isBlank(r101.f63199b);
    }
}
