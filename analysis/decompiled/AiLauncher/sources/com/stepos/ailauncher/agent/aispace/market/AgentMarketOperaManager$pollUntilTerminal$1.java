package com.stepos.ailauncher.agent.aispace.market;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager", f = "AgentMarketOperaManager.kt", l = {470, 476, 486, 515, 554}, m = "pollUntilTerminal", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketOperaManager$pollUntilTerminal$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentMarketOperaManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketOperaManager$pollUntilTerminal$1(AgentMarketOperaManager agentMarketOperaManager, InterfaceC4014c<? super AgentMarketOperaManager$pollUntilTerminal$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentMarketOperaManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.G(null, null, this);
    }
}
