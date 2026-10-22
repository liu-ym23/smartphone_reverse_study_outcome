package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k6<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k6 f63504a = null;

    static {
        f63504a = new k6();
    }

    public k6() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Object[]) r100, "it");
        return Unit.INSTANCE;
    }
}
