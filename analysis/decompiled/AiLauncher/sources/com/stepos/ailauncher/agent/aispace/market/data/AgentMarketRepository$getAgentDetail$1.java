package com.stepos.ailauncher.agent.aispace.market.data;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository", f = "AgentMarketRepository.kt", l = {229, 230}, m = "getAgentDetail-BWLJW6A", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketRepository$getAgentDetail$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentMarketRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketRepository$getAgentDetail$1(AgentMarketRepository agentMarketRepository, InterfaceC4014c<? super AgentMarketRepository$getAgentDetail$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentMarketRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objI = this.this$0.i(null, null, 0, this);
        return objI == C4063a.g() ? objI : Result.a(objI);
    }
}
