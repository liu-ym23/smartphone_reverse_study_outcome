package com.obric.autogui.common.api;

import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.m;
import d.h.b.l;
import d.x;

/* JADX INFO: compiled from: AOSystemTools.kt */
/* JADX INFO: loaded from: classes3.dex */
/* synthetic */ class AOAgentRobotsTools$sRegistrationRetryRunner$1 extends l implements m<Long, d<? super x>, Object> {
    AOAgentRobotsTools$sRegistrationRetryRunner$1(Object r8) {
        super(2, r8, AOThreadingTools.class, "delayForMillis", "delayForMillis(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(long r3, d<? super x> r5) {
        d<? super x> r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return ((AOThreadingTools) ZeusTransformUtils.preCheckCast(this.receiver, AOThreadingTools.class, "com.obric.aiagent.plugin")).delayForMillis(r3, r6);
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(Long r5, d<? super x> r6) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue(), (d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.aiagent.plugin"));
    }
}
