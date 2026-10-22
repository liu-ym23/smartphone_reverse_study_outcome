package com.stepos.ailauncher.agent.aispace;

import Ua.M;
import com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository;
import com.stepos.ailauncher.agent.aispace.market.data.PagedAgents;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/agent/aispace/market/data/z;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/agent/aispace/market/data/z;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.AgentTabView$loadMoreMarket$1$paged$1", f = "AgentTabView.kt", l = {378}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentTabView$loadMoreMarket$1$paged$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super PagedAgents>, Object> {
    final /* synthetic */ int $next;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentTabView$loadMoreMarket$1$paged$1(int i10, InterfaceC4014c<? super AgentTabView$loadMoreMarket$1$paged$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$next = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentTabView$loadMoreMarket$1$paged$1(this.$next, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super PagedAgents> interfaceC4014c) {
        return ((AgentTabView$loadMoreMarket$1$paged$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objN;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AgentMarketRepository agentMarketRepository = AgentMarketRepository.INSTANCE;
            int i11 = this.$next;
            this.label = 1;
            objN = AgentMarketRepository.n(agentMarketRepository, null, i11, 20, this, 1, null);
            if (objN == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            objN = ((Result) obj).getValue();
        }
        if (Result.g(objN)) {
            return null;
        }
        return objN;
    }
}
