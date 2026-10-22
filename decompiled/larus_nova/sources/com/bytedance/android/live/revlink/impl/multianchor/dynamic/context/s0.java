package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 f94060a;

    public s0(RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 r100) {
        this.f94060a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Integer r101 = (Integer) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return o0.i(this.f94060a.f93946b, r101.intValue());
    }
}
