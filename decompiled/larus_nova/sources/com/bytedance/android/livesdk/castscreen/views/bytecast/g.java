package com.bytedance.android.livesdk.castscreen.views.bytecast;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f104889a = null;

    static {
        f104889a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        return Unit.INSTANCE;
    }
}
