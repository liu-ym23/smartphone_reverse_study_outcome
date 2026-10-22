package com.stepos.ailauncher.agent.aispace.market.data;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository", f = "AgentMarketRepository.kt", l = {126, 127}, m = "setAgentEnabled-0E7RQCE", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketRepository$setAgentEnabled$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentMarketRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketRepository$setAgentEnabled$1(AgentMarketRepository agentMarketRepository, InterfaceC4014c<? super AgentMarketRepository$setAgentEnabled$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentMarketRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objC = this.this$0.C(null, false, this);
        return objC == C4063a.g() ? objC : Result.a(objC);
    }
}
