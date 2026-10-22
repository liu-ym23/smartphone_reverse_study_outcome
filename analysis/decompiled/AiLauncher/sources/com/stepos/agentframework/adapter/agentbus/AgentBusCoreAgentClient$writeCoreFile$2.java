package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$writeCoreFile$2", f = "AgentBusCoreAgentClient.kt", l = {3288}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$writeCoreFile$2 extends SuspendLambda implements p9.p<ClawChannelAgentBusBinding, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $type;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$writeCoreFile$2(String str, String str2, InterfaceC4014c<? super AgentBusCoreAgentClient$writeCoreFile$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$type = str;
        this.$content = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusCoreAgentClient$writeCoreFile$2 agentBusCoreAgentClient$writeCoreFile$2 = new AgentBusCoreAgentClient$writeCoreFile$2(this.$type, this.$content, interfaceC4014c);
        agentBusCoreAgentClient$writeCoreFile$2.L$0 = obj;
        return agentBusCoreAgentClient$writeCoreFile$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ClawChannelAgentBusBinding clawChannelAgentBusBinding, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$writeCoreFile$2) create(clawChannelAgentBusBinding, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
        String str2 = this.$content;
        this.L$0 = g9.h.a(clawChannelAgentBusBinding);
        this.label = 1;
        Object objP = AgentBusChannelOpsKt.P(clawChannelAgentBusBinding, str, str2, 0L, this, 4, null);
        return objP == objG ? objG : objP;
    }
}
