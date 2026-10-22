package com.stepos.agentframework.adapter.bff;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.bff.BffCoreAgentClient", f = "BffCoreAgentClient.kt", l = {207}, m = "vote", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BffCoreAgentClient$vote$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BffCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BffCoreAgentClient$vote$1(BffCoreAgentClient bffCoreAgentClient, InterfaceC4014c<? super BffCoreAgentClient$vote$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = bffCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.u(null, this);
    }
}
