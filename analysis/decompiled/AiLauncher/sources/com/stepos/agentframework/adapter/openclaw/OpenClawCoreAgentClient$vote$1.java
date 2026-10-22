package com.stepos.agentframework.adapter.openclaw;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient", f = "OpenClawCoreAgentClient.kt", l = {976}, m = "vote", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenClawCoreAgentClient$vote$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenClawCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenClawCoreAgentClient$vote$1(OpenClawCoreAgentClient openClawCoreAgentClient, InterfaceC4014c<? super OpenClawCoreAgentClient$vote$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = openClawCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.u(null, this);
    }
}
