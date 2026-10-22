package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$createOpenClawSession$2", f = "AgentBusChannelOps.kt", l = {69, 77}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusChannelOpsKt$createOpenClawSession$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super String>, Object> {
    final /* synthetic */ String $agentId;
    final /* synthetic */ ClawChannelAgentBusBinding $this_createOpenClawSession;
    final /* synthetic */ long $timeoutMs;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusChannelOpsKt$createOpenClawSession$2(String str, ClawChannelAgentBusBinding clawChannelAgentBusBinding, long j10, InterfaceC4014c<? super AgentBusChannelOpsKt$createOpenClawSession$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$agentId = str;
        this.$this_createOpenClawSession = clawChannelAgentBusBinding;
        this.$timeoutMs = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusChannelOpsKt$createOpenClawSession$2 agentBusChannelOpsKt$createOpenClawSession$2 = new AgentBusChannelOpsKt$createOpenClawSession$2(this.$agentId, this.$this_createOpenClawSession, this.$timeoutMs, interfaceC4014c);
        agentBusChannelOpsKt$createOpenClawSession$2.L$0 = obj;
        return agentBusChannelOpsKt$createOpenClawSession$2;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((AgentBusChannelOpsKt$createOpenClawSession$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$createOpenClawSession$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
