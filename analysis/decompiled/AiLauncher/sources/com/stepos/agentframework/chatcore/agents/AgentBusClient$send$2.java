package com.stepos.agentframework.chatcore.agents;

import Ua.M;
import com.stepos.agentframework.chatcore.agents.AgentBusClient;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.AgentBusClient$send$2", f = "AgentBusClient.kt", l = {123, 124}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusClient$send$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentBusClient.b $attach;
    final /* synthetic */ AgentDispatcher.b $callback;
    final /* synthetic */ RequestParameter $parameter;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AgentBusClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusClient$send$2(RequestParameter requestParameter, AgentBusClient.b bVar, AgentDispatcher.b bVar2, AgentBusClient agentBusClient, InterfaceC4014c<? super AgentBusClient$send$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$parameter = requestParameter;
        this.$attach = bVar;
        this.$callback = bVar2;
        this.this$0 = agentBusClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusClient$send$2(this.$parameter, this.$attach, this.$callback, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusClient$send$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0138, code lost:
    
        if (r13 != r0) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient$send$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
