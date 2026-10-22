package com.stepos.ailauncher.agent.aispace.market;

import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$observeStatus$3", f = "AgentMarketDetailActivity.kt", l = {250}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailActivity$observeStatus$3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ AgentMarketDetailActivity this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ AgentMarketDetailActivity this$0;

        public a(AgentMarketDetailActivity agentMarketDetailActivity) {
            this.this$0 = agentMarketDetailActivity;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(AgentMarketOperaManager.a aVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AgentMarketItem agentMarketItem = null;
            if (aVar instanceof AgentMarketOperaManager.a.InstallSucceeded) {
                this.this$0.b1();
                String assetId = ((AgentMarketOperaManager.a.InstallSucceeded) aVar).getAssetId();
                AgentMarketItem agentMarketItem2 = this.this$0.item;
                if (agentMarketItem2 == null) {
                    kotlin.jvm.internal.p.A("item");
                } else {
                    agentMarketItem = agentMarketItem2;
                }
                if (kotlin.jvm.internal.p.d(assetId, agentMarketItem.getAssetId())) {
                    this.this$0.F0();
                }
            } else if (aVar instanceof AgentMarketOperaManager.a.UpdateSucceeded) {
                this.this$0.needUpdate = false;
                AgentMarketDetailActivity agentMarketDetailActivity = this.this$0;
                AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
                AgentMarketItem agentMarketItem3 = agentMarketDetailActivity.item;
                if (agentMarketItem3 == null) {
                    kotlin.jvm.internal.p.A("item");
                    agentMarketItem3 = null;
                }
                String assetId2 = agentMarketItem3.getAssetId();
                AgentMarketItem agentMarketItem4 = this.this$0.item;
                if (agentMarketItem4 == null) {
                    kotlin.jvm.internal.p.A("item");
                } else {
                    agentMarketItem = agentMarketItem4;
                }
                agentMarketDetailActivity.p0(agentMarketOperaManager.Q(assetId2, agentMarketItem.getInitialStatus()));
                this.this$0.e1("更新成功");
            } else if (!(aVar instanceof AgentMarketOperaManager.a.UninstallSucceeded)) {
                if (!(aVar instanceof AgentMarketOperaManager.a.Failed)) {
                    throw new NoWhenBranchMatchedException();
                }
                AgentMarketOperaManager.a.Failed failed = (AgentMarketOperaManager.a.Failed) aVar;
                if (failed.getIsNetworkError()) {
                    AgentMarketDetailActivity agentMarketDetailActivity2 = this.this$0;
                    String string = agentMarketDetailActivity2.getString(R$string.agent_market_toast_network_unavailable);
                    kotlin.jvm.internal.p.h(string, "getString(...)");
                    agentMarketDetailActivity2.e1(string);
                } else {
                    AgentMarketDetailActivity agentMarketDetailActivity3 = this.this$0;
                    String message = failed.getMessage();
                    if (La.H.x0(message)) {
                        message = "请稍后重试";
                    }
                    agentMarketDetailActivity3.e1("操作失败：" + ((Object) message));
                }
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailActivity$observeStatus$3(AgentMarketDetailActivity agentMarketDetailActivity, InterfaceC4014c<? super AgentMarketDetailActivity$observeStatus$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentMarketDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailActivity$observeStatus$3(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketDetailActivity$observeStatus$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<AgentMarketOperaManager.a> oVarU = AgentMarketOperaManager.INSTANCE.u();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (oVarU.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
