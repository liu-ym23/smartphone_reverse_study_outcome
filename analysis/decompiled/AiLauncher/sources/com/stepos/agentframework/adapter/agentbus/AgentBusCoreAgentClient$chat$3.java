package com.stepos.agentframework.adapter.agentbus;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$chat$3", f = "AgentBusCoreAgentClient.kt", l = {990, 1016, 1018, FastDoubleMath.DOUBLE_EXPONENT_BIAS}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$chat$3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentBusCoreAgentClient.ActiveChat $active;
    final /* synthetic */ ClawChannelAgentBusBinding $bus;
    final /* synthetic */ Ref$ObjectRef<String> $outboundId;
    final /* synthetic */ boolean $retryAfterAbort;
    final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super String>, Object> $sendOnce;
    final /* synthetic */ String $sessionId;
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentBusCoreAgentClient$chat$3(AgentBusCoreAgentClient agentBusCoreAgentClient, Ref$ObjectRef<String> ref$ObjectRef, ClawChannelAgentBusBinding clawChannelAgentBusBinding, boolean z10, String str, InterfaceC5074l<? super InterfaceC4014c<? super String>, ? extends Object> interfaceC5074l, AgentBusCoreAgentClient.ActiveChat activeChat, InterfaceC4014c<? super AgentBusCoreAgentClient$chat$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentBusCoreAgentClient;
        this.$outboundId = ref$ObjectRef;
        this.$bus = clawChannelAgentBusBinding;
        this.$retryAfterAbort = z10;
        this.$sessionId = str;
        this.$sendOnce = interfaceC5074l;
        this.$active = activeChat;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusCoreAgentClient$chat$3(this.this$0, this.$outboundId, this.$bus, this.$retryAfterAbort, this.$sessionId, this.$sendOnce, this.$active, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$chat$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0241  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$chat$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
