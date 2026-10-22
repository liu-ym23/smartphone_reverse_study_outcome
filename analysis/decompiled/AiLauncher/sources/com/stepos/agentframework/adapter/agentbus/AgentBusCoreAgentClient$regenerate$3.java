package com.stepos.agentframework.adapter.agentbus;

import com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.concurrent.CancellationException;
import kotlin.C0918n;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$regenerate$3", f = "AgentBusCoreAgentClient.kt", l = {1178}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$regenerate$3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentBusCoreAgentClient.ActiveChat $active;
    final /* synthetic */ ClawChannelAgentBusBinding $bus;
    final /* synthetic */ String $chatId;
    final /* synthetic */ String $frameId;
    final /* synthetic */ com.stepos.agentframework.adapter.netcore.h $listener;
    final /* synthetic */ String $originRunId;
    final /* synthetic */ C0918n $request;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$regenerate$3(AgentBusCoreAgentClient agentBusCoreAgentClient, ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, String str2, AgentBusCoreAgentClient.ActiveChat activeChat, String str3, com.stepos.agentframework.adapter.netcore.h hVar, C0918n c0918n, String str4, InterfaceC4014c<? super AgentBusCoreAgentClient$regenerate$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentBusCoreAgentClient;
        this.$bus = clawChannelAgentBusBinding;
        this.$frameId = str;
        this.$sessionId = str2;
        this.$active = activeChat;
        this.$originRunId = str3;
        this.$listener = hVar;
        this.$request = c0918n;
        this.$chatId = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusCoreAgentClient$regenerate$3(this.this$0, this.$bus, this.$frameId, this.$sessionId, this.$active, this.$originRunId, this.$listener, this.$request, this.$chatId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$regenerate$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AgentBusCoreAgentClient$regenerate$3 agentBusCoreAgentClient$regenerate$3;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                if (!this.this$0.v1()) {
                    return Y8.t.f7040a;
                }
                ClawChannelAgentBusBinding clawChannelAgentBusBinding = this.$bus;
                String str = this.$frameId;
                this.label = 1;
                agentBusCoreAgentClient$regenerate$3 = this;
                obj = AgentBusChannelOpsKt.f(clawChannelAgentBusBinding, str, 0L, agentBusCoreAgentClient$regenerate$3, 2, null);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                agentBusCoreAgentClient$regenerate$3 = this;
            }
            RegenerateAck regenerateAck = (RegenerateAck) obj;
            if (!agentBusCoreAgentClient$regenerate$3.this$0.v1()) {
                return Y8.t.f7040a;
            }
            if (regenerateAck == null || !regenerateAck.b()) {
                C4148a.k("AgentBusCoreAgentClient", "regenerate ack fail sessionId=" + agentBusCoreAgentClient$regenerate$3.$sessionId + " status=" + (regenerateAck != null ? regenerateAck.getStatus() : null), false, 4, null);
                agentBusCoreAgentClient$regenerate$3.$listener.b(agentBusCoreAgentClient$regenerate$3.$request, C4109a.f(-1), "重新生成失败，请稍后重试");
                agentBusCoreAgentClient$regenerate$3.$active.getCancelHandle().c();
                AgentBusCoreAgentClient.S1(agentBusCoreAgentClient$regenerate$3.this$0, agentBusCoreAgentClient$regenerate$3.$sessionId, agentBusCoreAgentClient$regenerate$3.$chatId, false, 4, null);
            } else {
                C4148a.k("AgentBusCoreAgentClient", "regenerate ack ok sessionId=" + agentBusCoreAgentClient$regenerate$3.$sessionId + " runId=" + La.K.R1(regenerateAck.getRunId(), 32), false, 4, null);
                agentBusCoreAgentClient$regenerate$3.this$0.b1(agentBusCoreAgentClient$regenerate$3.$active, true, null, null);
                if (!kotlin.jvm.internal.p.d(regenerateAck.getRunId(), agentBusCoreAgentClient$regenerate$3.$originRunId)) {
                    C4148a.u("AgentBusCoreAgentClient", "regenerate ack runId drift: expected=" + La.K.R1(agentBusCoreAgentClient$regenerate$3.$originRunId, 32) + " actual=" + La.K.R1(regenerateAck.getRunId(), 32), false, 4, null);
                }
            }
            return Y8.t.f7040a;
        } catch (CancellationException unused) {
            return Y8.t.f7040a;
        }
    }
}
