package com.bytedance.ai.model;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class k implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f36881a;

    public /* synthetic */ k(Function3 r100) {
        this.f36881a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Function3 r101 = this.f36881a;
        String r102 = (String) r100;
        AtomicInteger r103 = AppletRuntime.f36716x;
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        if (r101 == null) goto L6;
        r101.invoke(null, Boolean.FALSE, r102);
    L6:
        return Unit.INSTANCE;
    }
}
