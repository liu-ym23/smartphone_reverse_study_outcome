package com.stepos.agentframework.chatcore.agents;

import Ua.M;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C0917m;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.ABBffClient$send$eventListener$1$onEvent$1", f = "ABBffClient.kt", l = {644}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffClient$send$eventListener$1$onEvent$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ C0917m $chatReplyInfo;
    final /* synthetic */ AgentBusStreamBridge $streamBridge;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ABBffClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffClient$send$eventListener$1$onEvent$1(ABBffClient aBBffClient, C0917m c0917m, AgentBusStreamBridge agentBusStreamBridge, InterfaceC4014c<? super ABBffClient$send$eventListener$1$onEvent$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aBBffClient;
        this.$chatReplyInfo = c0917m;
        this.$streamBridge = agentBusStreamBridge;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ABBffClient$send$eventListener$1$onEvent$1(this.this$0, this.$chatReplyInfo, this.$streamBridge, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ABBffClient$send$eventListener$1$onEvent$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C0917m c0917m;
        InterfaceC4021a interfaceC4021a;
        AgentBusStreamBridge agentBusStreamBridge;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            InterfaceC4021a interfaceC4021a2 = this.this$0.streamMutex;
            c0917m = this.$chatReplyInfo;
            AgentBusStreamBridge agentBusStreamBridge2 = this.$streamBridge;
            this.L$0 = interfaceC4021a2;
            this.L$1 = c0917m;
            this.L$2 = agentBusStreamBridge2;
            this.I$0 = 0;
            this.label = 1;
            if (interfaceC4021a2.m(null, this) == objG) {
                return objG;
            }
            interfaceC4021a = interfaceC4021a2;
            agentBusStreamBridge = agentBusStreamBridge2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            agentBusStreamBridge = (AgentBusStreamBridge) this.L$2;
            c0917m = (C0917m) this.L$1;
            interfaceC4021a = (InterfaceC4021a) this.L$0;
            C4849c.b(obj);
        }
        try {
            agentBusStreamBridge.g(ExtKt.f(c0917m));
            Y8.t tVar = Y8.t.f7040a;
            interfaceC4021a.l(null);
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4021a.l(null);
            throw th;
        }
    }
}
