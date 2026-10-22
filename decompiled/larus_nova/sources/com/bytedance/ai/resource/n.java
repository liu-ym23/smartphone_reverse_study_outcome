package com.bytedance.ai.resource;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class n implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f37500a;

    public /* synthetic */ n(x r100) {
        this.f37500a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Function1 r101 = this.f37500a;
        Throwable r102 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        com.bytedance.ai.utils.g.f37637a.e("AppletResourceLoader", r102.getMessage());
        r101.invoke(r102);
        return Unit.INSTANCE;
    }
}
