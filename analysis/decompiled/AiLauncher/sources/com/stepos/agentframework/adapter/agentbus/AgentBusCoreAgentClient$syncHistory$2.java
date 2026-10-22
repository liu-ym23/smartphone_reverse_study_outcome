package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.SyncHistoryRequest;
import kotlin.SyncHistoryResult;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "it", "LK6/D;", "<anonymous>", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)LK6/D;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncHistory$2", f = "AgentBusCoreAgentClient.kt", l = {3224}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$syncHistory$2 extends SuspendLambda implements p9.p<ClawChannelAgentBusBinding, InterfaceC4014c<? super SyncHistoryResult>, Object> {
    final /* synthetic */ SyncHistoryRequest $request;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$syncHistory$2(SyncHistoryRequest syncHistoryRequest, InterfaceC4014c<? super AgentBusCoreAgentClient$syncHistory$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$request = syncHistoryRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusCoreAgentClient$syncHistory$2 agentBusCoreAgentClient$syncHistory$2 = new AgentBusCoreAgentClient$syncHistory$2(this.$request, interfaceC4014c);
        agentBusCoreAgentClient$syncHistory$2.L$0 = obj;
        return agentBusCoreAgentClient$syncHistory$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ClawChannelAgentBusBinding clawChannelAgentBusBinding, InterfaceC4014c<? super SyncHistoryResult> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$syncHistory$2) create(clawChannelAgentBusBinding, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ClawChannelAgentBusBinding clawChannelAgentBusBinding = (ClawChannelAgentBusBinding) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        String sessionKey = this.$request.getSessionKey();
        this.L$0 = g9.h.a(clawChannelAgentBusBinding);
        this.label = 1;
        Object objM = AgentBusChannelOpsKt.M(clawChannelAgentBusBinding, sessionKey, 0, this, 2, null);
        return objM == objG ? objG : objM;
    }
}
