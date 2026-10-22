package com.stepos.agentframework.adapter.agentbus;

import Ua.U;
import com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$scheduleDisconnectTerminalFallback$job$1", f = "AgentBusCoreAgentClient.kt", l = {2800}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$scheduleDisconnectTerminalFallback$job$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentBusCoreAgentClient.ActiveChat $active;
    final /* synthetic */ String $lookupSessionId;
    int label;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$scheduleDisconnectTerminalFallback$job$1(AgentBusCoreAgentClient.ActiveChat activeChat, AgentBusCoreAgentClient agentBusCoreAgentClient, String str, InterfaceC4014c<? super AgentBusCoreAgentClient$scheduleDisconnectTerminalFallback$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$active = activeChat;
        this.this$0 = agentBusCoreAgentClient;
        this.$lookupSessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusCoreAgentClient$scheduleDisconnectTerminalFallback$job$1(this.$active, this.this$0, this.$lookupSessionId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$scheduleDisconnectTerminalFallback$job$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                this.label = 1;
                if (U.a(20000L, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            if (this.$active.getFinished().get() || this.$active.getCancelHandle().getCancelled() || !this.this$0.v1()) {
                C4148a.d("AgentBusCoreAgentClient", "disconnect-terminal grace superseded chatId=" + this.$active.getChatId() + " finished=" + this.$active.getFinished().get() + " cancelled=" + this.$active.getCancelHandle().getCancelled(), false, 4, null);
                return Y8.t.f7040a;
            }
            C4148a.k("AgentBusCoreAgentClient", "disconnect-terminal grace expired → onClosed sessionId=" + this.$lookupSessionId + " chatId=" + this.$active.getChatId() + " outboundId=" + this.$active.getOutboundId(), false, 4, null);
            this.$active.getStreamAccumulator().c();
            this.$active.getCancelHandle().c();
            this.$active.getListener().j(this.$active.getRequest());
            AgentBusCoreAgentClient.S1(this.this$0, this.$lookupSessionId, this.$active.getChatId(), false, 4, null);
            return Y8.t.f7040a;
        } catch (CancellationException unused) {
            return Y8.t.f7040a;
        }
    }
}
