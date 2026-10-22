package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0 f94053a;

    public p0(o0 r100) {
        this.f94053a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        k31.f r101 = (k31.f) r100;
        Intrinsics.checkNotNullParameter(r101, "seiCache");
        return this.f94053a.j(r101);
    }
}
