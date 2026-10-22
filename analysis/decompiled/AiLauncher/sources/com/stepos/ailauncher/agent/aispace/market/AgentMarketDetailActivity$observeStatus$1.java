package com.stepos.ailauncher.agent.aispace.market;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$observeStatus$1", f = "AgentMarketDetailActivity.kt", l = {230}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailActivity$observeStatus$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
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
        public final Object emit(Map<String, ? extends AgentMarketStatus> map, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AgentMarketDetailActivity agentMarketDetailActivity = this.this$0;
            AgentMarketItem agentMarketItem = agentMarketDetailActivity.item;
            AgentMarketItem agentMarketItem2 = null;
            if (agentMarketItem == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem = null;
            }
            AgentMarketStatus initialStatus = map.get(agentMarketItem.getAssetId());
            if (initialStatus == null) {
                AgentMarketItem agentMarketItem3 = this.this$0.item;
                if (agentMarketItem3 == null) {
                    kotlin.jvm.internal.p.A("item");
                } else {
                    agentMarketItem2 = agentMarketItem3;
                }
                initialStatus = agentMarketItem2.getInitialStatus();
            }
            agentMarketDetailActivity.p0(initialStatus);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailActivity$observeStatus$1(AgentMarketDetailActivity agentMarketDetailActivity, InterfaceC4014c<? super AgentMarketDetailActivity$observeStatus$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentMarketDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailActivity$observeStatus$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketDetailActivity$observeStatus$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<Map<String, AgentMarketStatus>> tVarW = AgentMarketOperaManager.INSTANCE.w();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (tVarW.collect(aVar, this) == objG) {
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
