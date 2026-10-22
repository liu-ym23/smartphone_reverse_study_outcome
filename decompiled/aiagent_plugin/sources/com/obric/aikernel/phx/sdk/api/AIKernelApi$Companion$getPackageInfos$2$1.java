package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.ExtsKt;
import com.obric.aikernel.sdk.data.PackageResource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.a;
import d.h.b.p;
import d.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
final class AIKernelApi$Companion$getPackageInfos$2$1 extends p implements a<x> {
    final /* synthetic */ n<d.n<? extends List<PackageResource>>> $continuation;

    AIKernelApi$Companion$getPackageInfos$2$1(n<? super d.n<? extends List<PackageResource>>> r3) {
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
        d r9 = (d) ZeusTransformUtils.preCheckCast(this.$continuation, d.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;
        ExtsKt.resume(r9, d.n.g(d.n.f(o.a((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(113, "binder died!", null, 0, 12, null), Throwable.class, "com.obric.aiagent.plugin")))));
    }
}
