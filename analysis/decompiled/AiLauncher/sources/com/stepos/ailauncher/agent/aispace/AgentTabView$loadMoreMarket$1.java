package com.stepos.ailauncher.agent.aispace;

import Ua.C1056g;
import Ua.I;
import Ua.M;
import Ua.Y;
import com.stepos.ailauncher.agent.aispace.AgentTabView;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketItem;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager;
import com.stepos.ailauncher.agent.aispace.market.data.PagedAgents;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.AgentTabView$loadMoreMarket$1", f = "AgentTabView.kt", l = {377}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentTabView$loadMoreMarket$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ int $next;
    int label;
    final /* synthetic */ AgentTabView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentTabView$loadMoreMarket$1(AgentTabView agentTabView, int i10, InterfaceC4014c<? super AgentTabView$loadMoreMarket$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentTabView;
        this.$next = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentTabView$loadMoreMarket$1(this.this$0, this.$next, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentTabView$loadMoreMarket$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            I iB = Y.b();
            AgentTabView$loadMoreMarket$1$paged$1 agentTabView$loadMoreMarket$1$paged$1 = new AgentTabView$loadMoreMarket$1$paged$1(this.$next, null);
            this.label = 1;
            obj = C1056g.j(iB, agentTabView$loadMoreMarket$1$paged$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        PagedAgents pagedAgents = (PagedAgents) obj;
        if (this.this$0.pageMode != AgentTabView.PageMode.HOME) {
            this.this$0.marketLoading = false;
            return Y8.t.f7040a;
        }
        if (pagedAgents == null) {
            this.this$0.marketLoading = false;
            return Y8.t.f7040a;
        }
        this.this$0.marketPage = this.$next;
        int total = pagedAgents.getTotal();
        AgentTabView agentTabView = this.this$0;
        if (total > 0) {
            agentTabView.marketTotal = total;
        }
        List<AgentMarketItem> listA = pagedAgents.a();
        AgentTabView agentTabView2 = this.this$0;
        agentTabView2.marketItems = Z8.F.S0(agentTabView2.marketItems, listA);
        AgentMarketOperaManager.INSTANCE.L(listA);
        this.this$0.marketAdapter.f(listA);
        this.this$0.marketLoading = false;
        return Y8.t.f7040a;
    }
}
