package com.stepos.ailauncher.agent.aispace.market;

import com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository;
import com.stepos.ailauncher.agent.aispace.market.data.GetAgentDetailData;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/agent/aispace/market/data/h;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/agent/aispace/market/data/h;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$loadDetail$1$data$1", f = "AgentMarketDetailActivity.kt", l = {513}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailActivity$loadDetail$1$data$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super GetAgentDetailData>, Object> {
    int label;
    final /* synthetic */ AgentMarketDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailActivity$loadDetail$1$data$1(AgentMarketDetailActivity agentMarketDetailActivity, InterfaceC4014c<? super AgentMarketDetailActivity$loadDetail$1$data$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentMarketDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailActivity$loadDetail$1$data$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super GetAgentDetailData> interfaceC4014c) {
        return ((AgentMarketDetailActivity$loadDetail$1$data$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objI;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AgentMarketRepository agentMarketRepository = AgentMarketRepository.INSTANCE;
            AgentMarketItem agentMarketItem = this.this$0.item;
            if (agentMarketItem == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem = null;
            }
            String assetId = agentMarketItem.getAssetId();
            AgentMarketItem agentMarketItem2 = this.this$0.item;
            if (agentMarketItem2 == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem2 = null;
            }
            boolean testing = agentMarketItem2.getTesting();
            this.label = 1;
            objI = agentMarketRepository.i(assetId, "", testing ? 1 : 0, this);
            if (objI == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            objI = ((Result) obj).getValue();
        }
        if (Result.g(objI)) {
            return null;
        }
        return objI;
    }
}
