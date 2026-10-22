package com.stepos.ailauncher.agent.aispace.market;

import com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository;
import com.stepos.ailauncher.agent.aispace.market.data.PagedAgents;
import com.stepos.ailauncher.contract.model.ListPage;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/stepos/ailauncher/contract/model/ListPage;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "page", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsFragment$loadInstalledMarketAgents$1", f = "ConnectedAgentsFragment.kt", l = {142}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ConnectedAgentsFragment$loadInstalledMarketAgents$1 extends SuspendLambda implements p9.p<Integer, InterfaceC4014c<? super ListPage<AgentMarketItem>>, Object> {
    /* synthetic */ int I$0;
    int label;

    public ConnectedAgentsFragment$loadInstalledMarketAgents$1(InterfaceC4014c<? super ConnectedAgentsFragment$loadInstalledMarketAgents$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ConnectedAgentsFragment$loadInstalledMarketAgents$1 connectedAgentsFragment$loadInstalledMarketAgents$1 = new ConnectedAgentsFragment$loadInstalledMarketAgents$1(interfaceC4014c);
        connectedAgentsFragment$loadInstalledMarketAgents$1.I$0 = ((Number) obj).intValue();
        return connectedAgentsFragment$loadInstalledMarketAgents$1;
    }

    public final Object f(int i10, InterfaceC4014c<? super ListPage<AgentMarketItem>> interfaceC4014c) {
        return ((ConnectedAgentsFragment$loadInstalledMarketAgents$1) create(Integer.valueOf(i10), interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, InterfaceC4014c<? super ListPage<AgentMarketItem>> interfaceC4014c) {
        return f(num.intValue(), interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objT;
        int i10 = this.I$0;
        Object objG = C4063a.g();
        int i11 = this.label;
        if (i11 == 0) {
            C4849c.b(obj);
            AgentMarketRepository agentMarketRepository = AgentMarketRepository.INSTANCE;
            this.I$0 = i10;
            this.label = 1;
            objT = agentMarketRepository.t(i10, 50, this);
            if (objT == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            objT = ((Result) obj).getValue();
        }
        C4849c.b(objT);
        PagedAgents pagedAgents = (PagedAgents) objT;
        return ListPage.INSTANCE.numbered(pagedAgents.a(), i10, 50, C4109a.f(pagedAgents.getTotal()));
    }
}
