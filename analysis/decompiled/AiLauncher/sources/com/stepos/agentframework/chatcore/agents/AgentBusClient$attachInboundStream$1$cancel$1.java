package com.stepos.agentframework.chatcore.agents;

import Ua.M;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.AgentBusClient$attachInboundStream$1$cancel$1", f = "AgentBusClient.kt", l = {833}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusClient$attachInboundStream$1$cancel$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentDispatcher.b $callback;
    final /* synthetic */ AtomicBoolean $pendingCancel;
    final /* synthetic */ AgentBusStreamBridge $streamBridge;
    final /* synthetic */ AtomicBoolean $streamClosed;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ AgentBusClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusClient$attachInboundStream$1$cancel$1(AgentBusClient agentBusClient, AgentDispatcher.b bVar, AtomicBoolean atomicBoolean, AgentBusStreamBridge agentBusStreamBridge, AtomicBoolean atomicBoolean2, InterfaceC4014c<? super AgentBusClient$attachInboundStream$1$cancel$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentBusClient;
        this.$callback = bVar;
        this.$streamClosed = atomicBoolean;
        this.$streamBridge = agentBusStreamBridge;
        this.$pendingCancel = atomicBoolean2;
    }

    public static final Y8.t h(AgentBusClient agentBusClient, AgentDispatcher.b bVar) {
        agentBusClient.r0(bVar);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusClient$attachInboundStream$1$cancel$1(this.this$0, this.$callback, this.$streamClosed, this.$streamBridge, this.$pendingCancel, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusClient$attachInboundStream$1$cancel$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC4021a interfaceC4021a;
        final AgentDispatcher.b bVar;
        final AgentBusClient agentBusClient;
        AgentBusStreamBridge agentBusStreamBridge;
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            InterfaceC4021a interfaceC4021a2 = this.this$0.streamMutex;
            AgentBusClient agentBusClient2 = this.this$0;
            AgentDispatcher.b bVar2 = this.$callback;
            AtomicBoolean atomicBoolean3 = this.$streamClosed;
            AgentBusStreamBridge agentBusStreamBridge2 = this.$streamBridge;
            AtomicBoolean atomicBoolean4 = this.$pendingCancel;
            this.L$0 = interfaceC4021a2;
            this.L$1 = agentBusClient2;
            this.L$2 = bVar2;
            this.L$3 = atomicBoolean3;
            this.L$4 = agentBusStreamBridge2;
            this.L$5 = atomicBoolean4;
            this.I$0 = 0;
            this.label = 1;
            if (interfaceC4021a2.m(null, this) == objG) {
                return objG;
            }
            interfaceC4021a = interfaceC4021a2;
            bVar = bVar2;
            agentBusClient = agentBusClient2;
            agentBusStreamBridge = agentBusStreamBridge2;
            atomicBoolean = atomicBoolean4;
            atomicBoolean2 = atomicBoolean3;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AtomicBoolean atomicBoolean5 = (AtomicBoolean) this.L$5;
            AgentBusStreamBridge agentBusStreamBridge3 = (AgentBusStreamBridge) this.L$4;
            AtomicBoolean atomicBoolean6 = (AtomicBoolean) this.L$3;
            AgentDispatcher.b bVar3 = (AgentDispatcher.b) this.L$2;
            AgentBusClient agentBusClient3 = (AgentBusClient) this.L$1;
            interfaceC4021a = (InterfaceC4021a) this.L$0;
            C4849c.b(obj);
            atomicBoolean = atomicBoolean5;
            bVar = bVar3;
            agentBusClient = agentBusClient3;
            agentBusStreamBridge = agentBusStreamBridge3;
            atomicBoolean2 = atomicBoolean6;
        }
        try {
            AgentBusClient.o0(atomicBoolean2, agentBusStreamBridge, atomicBoolean, false, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.agents.i
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentBusClient$attachInboundStream$1$cancel$1.h(agentBusClient, bVar);
                }
            }, 8, null);
            Y8.t tVar = Y8.t.f7040a;
            interfaceC4021a.l(null);
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4021a.l(null);
            throw th;
        }
    }
}
