package com.stepos.ailauncher.agent.aispace.market;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl", f = "AgentMarketServiceImpl.kt", l = {44, 49}, m = "fetchAgents", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketServiceImpl$fetchAgents$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentMarketServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketServiceImpl$fetchAgents$1(AgentMarketServiceImpl agentMarketServiceImpl, InterfaceC4014c<? super AgentMarketServiceImpl$fetchAgents$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentMarketServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, 0, 0, 0, null, null, null, this);
    }
}
