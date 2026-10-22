package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.sdk.ExtsKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.a;
import d.h.b.p;
import d.x;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
final class AIKernelApi$Companion$loadPackage$2$1 extends p implements a<x> {
    final /* synthetic */ n<AIKernelApi.Companion.LoadedPackage> $continuation;

    AIKernelApi$Companion$loadPackage$2$1(n<? super AIKernelApi.Companion.LoadedPackage> r3) {
        this.$continuation = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ x invoke() {
        invoke2();
        return x.f38692a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ExtsKt.resume((d) ZeusTransformUtils.preCheckCast(this.$continuation, d.class, "com.obric.aiagent.plugin"), null);
    }
}
