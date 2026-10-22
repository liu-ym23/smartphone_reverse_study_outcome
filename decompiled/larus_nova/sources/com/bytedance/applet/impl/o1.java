package com.bytedance.applet.impl;

import com.bytedance.ai.api.OperateResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class o1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f191991a;

    public /* synthetic */ o1(Function1 r100) {
        this.f191991a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Function1 r101 = this.f191991a;
        OperateResult r102 = (OperateResult) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        r101.invoke(z1.a(r102));
        return Unit.INSTANCE;
    }
}
