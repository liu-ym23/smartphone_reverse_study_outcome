package com.stepos.agentframework.chatcore.agents;

import Ua.M;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.session.AgentError;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.ABBffClient$send$eventListener$1$onFailure$1", f = "ABBffClient.kt", l = {644}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffClient$send$eventListener$1$onFailure$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentDispatcher.b $callback;
    final /* synthetic */ AtomicReference<com.stepos.agentframework.adapter.netcore.n> $cancelHandleRef;
    final /* synthetic */ Integer $code;
    final /* synthetic */ String $message;
    final /* synthetic */ AtomicBoolean $pendingCancel;
    final /* synthetic */ String $sessionKey;
    final /* synthetic */ AgentBusStreamBridge $streamBridge;
    final /* synthetic */ AtomicBoolean $streamClosed;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ ABBffClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffClient$send$eventListener$1$onFailure$1(ABBffClient aBBffClient, AgentDispatcher.b bVar, Integer num, String str, AtomicReference<com.stepos.agentframework.adapter.netcore.n> atomicReference, String str2, AtomicBoolean atomicBoolean, AgentBusStreamBridge agentBusStreamBridge, AtomicBoolean atomicBoolean2, InterfaceC4014c<? super ABBffClient$send$eventListener$1$onFailure$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aBBffClient;
        this.$callback = bVar;
        this.$code = num;
        this.$message = str;
        this.$cancelHandleRef = atomicReference;
        this.$sessionKey = str2;
        this.$streamClosed = atomicBoolean;
        this.$streamBridge = agentBusStreamBridge;
        this.$pendingCancel = atomicBoolean2;
    }

    public static final Y8.t h(AgentDispatcher.b bVar, Integer num, String str, ABBffClient aBBffClient, AtomicReference atomicReference, String str2) {
        ABBffClient.f0(atomicReference, aBBffClient, str2);
        int iIntValue = num != null ? num.intValue() : AgentError.ERROR_CODE_UNKNOWN;
        if (str == null) {
            str = "";
        }
        bVar.i(new AgentError(iIntValue, str, null, 4, null));
        aBBffClient.d0(bVar);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ABBffClient$send$eventListener$1$onFailure$1(this.this$0, this.$callback, this.$code, this.$message, this.$cancelHandleRef, this.$sessionKey, this.$streamClosed, this.$streamBridge, this.$pendingCancel, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ABBffClient$send$eventListener$1$onFailure$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        final ABBffClient aBBffClient;
        AtomicBoolean atomicBoolean;
        final Integer num;
        final AgentDispatcher.b bVar;
        InterfaceC4021a interfaceC4021a;
        final String str2;
        final AtomicReference<com.stepos.agentframework.adapter.netcore.n> atomicReference;
        AgentBusStreamBridge agentBusStreamBridge;
        AtomicBoolean atomicBoolean2;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            InterfaceC4021a interfaceC4021a2 = this.this$0.streamMutex;
            AgentDispatcher.b bVar2 = this.$callback;
            Integer num2 = this.$code;
            str = this.$message;
            ABBffClient aBBffClient2 = this.this$0;
            AtomicReference<com.stepos.agentframework.adapter.netcore.n> atomicReference2 = this.$cancelHandleRef;
            String str3 = this.$sessionKey;
            AtomicBoolean atomicBoolean3 = this.$streamClosed;
            AgentBusStreamBridge agentBusStreamBridge2 = this.$streamBridge;
            AtomicBoolean atomicBoolean4 = this.$pendingCancel;
            this.L$0 = interfaceC4021a2;
            this.L$1 = bVar2;
            this.L$2 = num2;
            this.L$3 = str;
            this.L$4 = aBBffClient2;
            this.L$5 = atomicReference2;
            this.L$6 = str3;
            this.L$7 = atomicBoolean3;
            this.L$8 = agentBusStreamBridge2;
            this.L$9 = atomicBoolean4;
            this.I$0 = 0;
            this.label = 1;
            if (interfaceC4021a2.m(null, this) == objG) {
                return objG;
            }
            aBBffClient = aBBffClient2;
            atomicBoolean = atomicBoolean4;
            num = num2;
            bVar = bVar2;
            interfaceC4021a = interfaceC4021a2;
            str2 = str3;
            atomicReference = atomicReference2;
            agentBusStreamBridge = agentBusStreamBridge2;
            atomicBoolean2 = atomicBoolean3;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AtomicBoolean atomicBoolean5 = (AtomicBoolean) this.L$9;
            AgentBusStreamBridge agentBusStreamBridge3 = (AgentBusStreamBridge) this.L$8;
            AtomicBoolean atomicBoolean6 = (AtomicBoolean) this.L$7;
            String str4 = (String) this.L$6;
            AtomicReference<com.stepos.agentframework.adapter.netcore.n> atomicReference3 = (AtomicReference) this.L$5;
            ABBffClient aBBffClient3 = (ABBffClient) this.L$4;
            str = (String) this.L$3;
            Integer num3 = (Integer) this.L$2;
            AgentDispatcher.b bVar3 = (AgentDispatcher.b) this.L$1;
            interfaceC4021a = (InterfaceC4021a) this.L$0;
            C4849c.b(obj);
            num = num3;
            bVar = bVar3;
            str2 = str4;
            atomicReference = atomicReference3;
            aBBffClient = aBBffClient3;
            atomicBoolean = atomicBoolean5;
            agentBusStreamBridge = agentBusStreamBridge3;
            atomicBoolean2 = atomicBoolean6;
        }
        final String str5 = str;
        try {
            ABBffClient.h0(atomicBoolean2, agentBusStreamBridge, atomicBoolean, false, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.agents.c
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ABBffClient$send$eventListener$1$onFailure$1.h(bVar, num, str5, aBBffClient, atomicReference, str2);
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
