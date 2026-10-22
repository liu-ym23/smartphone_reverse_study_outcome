package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.p;
import d.x;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.a.t;

/* JADX INFO: compiled from: AbsApi.kt */
/* JADX INFO: loaded from: classes3.dex */
final class AbsApi$callModelAsFlow$1$monitorTask$1 extends p implements a<x> {
    final /* synthetic */ q<Bundle> $$this$callbackFlow;

    AbsApi$callModelAsFlow$1$monitorTask$1(q<? super Bundle> r3) {
        this.$$this$callbackFlow = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ x invoke() {
        invoke2();
        return x.f38692a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$$this$callbackFlow.a_(BundleExtKt.setErr$default(new Bundle(), 113, "binder died", false, 4, null));
        t.a.a((t) ZeusTransformUtils.preCheckCast(this.$$this$callbackFlow, t.class, "com.obric.aiagent.plugin"), null, 1, null);
    }
}
