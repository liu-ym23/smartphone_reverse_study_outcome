package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$readCoreFile$2", f = "AgentBusCoreAgentClient.kt", l = {3285}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$readCoreFile$2 extends SuspendLambda implements p9.p<ClawChannelAgentBusBinding, InterfaceC4014c<? super String>, Object> {
    final /* synthetic */ String $type;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$readCoreFile$2(String str, InterfaceC4014c<? super AgentBusCoreAgentClient$readCoreFile$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$type = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusCoreAgentClient$readCoreFile$2 agentBusCoreAgentClient$readCoreFile$2 = new AgentBusCoreAgentClient$readCoreFile$2(this.$type, interfaceC4014c);
        agentBusCoreAgentClient$readCoreFile$2.L$0 = obj;
        return agentBusCoreAgentClient$readCoreFile$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ClawChannelAgentBusBinding clawChannelAgentBusBinding, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$readCoreFile$2) create(clawChannelAgentBusBinding, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
        String str = this.$type;
        this.L$0 = g9.h.a(clawChannelAgentBusBinding);
        this.label = 1;
        Object objY = AgentBusChannelOpsKt.y(clawChannelAgentBusBinding, str, 0L, this, 2, null);
        return objY == objG ? objG : objY;
    }
}
