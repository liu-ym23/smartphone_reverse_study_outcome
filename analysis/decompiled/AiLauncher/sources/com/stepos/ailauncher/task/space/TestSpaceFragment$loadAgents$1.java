package com.stepos.ailauncher.task.space;

import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.model.ListPage;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/stepos/ailauncher/contract/model/ListPage;", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "page", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.TestSpaceFragment$loadAgents$1", f = "TestSpaceFragment.kt", l = {438}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TestSpaceFragment$loadAgents$1 extends SuspendLambda implements p9.p<Integer, InterfaceC4014c<? super ListPage<MarketAgentBrief>>, Object> {
    final /* synthetic */ Triple<String, String, String> $scan;
    /* synthetic */ int I$0;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestSpaceFragment$loadAgents$1(Triple<String, String, String> triple, InterfaceC4014c<? super TestSpaceFragment$loadAgents$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$scan = triple;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TestSpaceFragment$loadAgents$1 testSpaceFragment$loadAgents$1 = new TestSpaceFragment$loadAgents$1(this.$scan, interfaceC4014c);
        testSpaceFragment$loadAgents$1.I$0 = ((Number) obj).intValue();
        return testSpaceFragment$loadAgents$1;
    }

    public final Object f(int i10, InterfaceC4014c<? super ListPage<MarketAgentBrief>> interfaceC4014c) {
        return ((TestSpaceFragment$loadAgents$1) create(Integer.valueOf(i10), interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, InterfaceC4014c<? super ListPage<MarketAgentBrief>> interfaceC4014c) {
        return f(num.intValue(), interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.I$0;
        Object objG = C4063a.g();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
        if (iAgentMarketService == null) {
            throw new IllegalStateException("Market service unavailable");
        }
        Triple<String, String, String> triple = this.$scan;
        String strD = i10 == 1 ? triple != null ? triple.d() : null : null;
        Triple<String, String, String> triple2 = this.$scan;
        String strE = i10 == 1 ? triple2 != null ? triple2.e() : null : null;
        Triple<String, String, String> triple3 = this.$scan;
        String strF = i10 == 1 ? triple3 != null ? triple3.f() : null : null;
        this.L$0 = g9.h.a(iAgentMarketService);
        this.I$0 = i10;
        this.label = 1;
        Object agentPage$default = IAgentMarketService.getAgentPage$default(iAgentMarketService, null, i10, 50, true, strD, strE, strF, this, 1, null);
        return agentPage$default == objG ? objG : agentPage$default;
    }
}
