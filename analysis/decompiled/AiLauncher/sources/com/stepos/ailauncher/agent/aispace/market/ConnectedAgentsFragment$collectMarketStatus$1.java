package com.stepos.ailauncher.agent.aispace.market;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsFragment$collectMarketStatus$1", f = "ConnectedAgentsFragment.kt", l = {273}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ConnectedAgentsFragment$collectMarketStatus$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ConnectedAgentsFragment this$0;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "statusMap", "LY8/t;", "<anonymous>", "(Ljava/util/Map;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsFragment$collectMarketStatus$1$1", f = "ConnectedAgentsFragment.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsFragment$collectMarketStatus$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Map<String, ? extends AgentMarketStatus>, InterfaceC4014c<? super Y8.t>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConnectedAgentsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ConnectedAgentsFragment connectedAgentsFragment, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = connectedAgentsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Map<String, ? extends AgentMarketStatus> map, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(map, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Map map = (Map) this.L$0;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.M(map);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectedAgentsFragment$collectMarketStatus$1(ConnectedAgentsFragment connectedAgentsFragment, InterfaceC4014c<? super ConnectedAgentsFragment$collectMarketStatus$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = connectedAgentsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ConnectedAgentsFragment$collectMarketStatus$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ConnectedAgentsFragment$collectMarketStatus$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<Map<String, AgentMarketStatus>> tVarW = AgentMarketOperaManager.INSTANCE.w();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            kotlin.jvm.internal.p.g(tVarW, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.FlowKt__CollectKt.collectLatest>");
            this.L$0 = g9.h.a(tVarW);
            this.L$1 = g9.h.a(anonymousClass1);
            this.I$0 = 0;
            this.label = 1;
            if (Xa.d.j(tVarW, anonymousClass1, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new IllegalStateException("SharedFlow never completes, this call should never return.");
    }
}
