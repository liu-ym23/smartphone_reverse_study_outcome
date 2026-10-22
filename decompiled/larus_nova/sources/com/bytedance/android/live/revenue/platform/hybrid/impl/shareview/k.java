package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.view.View;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f91458a = null;

    static {
        f91458a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        h80.c r101 = (h80.c) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (View) r101.a();
    }
}
