package com.obric.aikernel.sdk.autotest;

import android.os.Bundle;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.a;
import d.h.b.p;
import d.x;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AutoTestManager.kt */
/* JADX INFO: loaded from: classes3.dex */
final class AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$deathRecipient$1 extends p implements a<x> {
    final /* synthetic */ n<Bundle> $res;

    AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$deathRecipient$1(n<? super Bundle> r3) {
        this.$res = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ x invoke() {
        invoke2();
        return x.f38692a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AIKLog.INSTANCE.v("AutoTestManager", "callAutoTestlAsResponse connection lost");
        if (this.$res.a() == false) goto L6;
        d r7 = (d) ZeusTransformUtils.preCheckCast(this.$res, d.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;
        r7.resumeWith(d.n.f(BundleExtKt.setErr$default(new Bundle(), 102, "connection lost", false, 4, null)));
        return;
    }
}
