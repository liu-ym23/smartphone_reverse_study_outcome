package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.sdk.ExtsKt;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.a;
import d.h.b.p;
import d.x;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AbsApi.kt */
/* JADX INFO: loaded from: classes3.dex */
final class AbsApi$callModelAsResponse$responseBundle$1$1 extends p implements a<x> {
    final /* synthetic */ n<Bundle> $cont;

    AbsApi$callModelAsResponse$responseBundle$1$1(n<? super Bundle> r3) {
        this.$cont = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ x invoke() {
        invoke2();
        return x.f38692a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ExtsKt.resume((d) ZeusTransformUtils.preCheckCast(this.$cont, d.class, "com.obric.aiagent.plugin"), BundleExtKt.setErr$default(new Bundle(), 113, "binder died", false, 4, null));
    }
}
