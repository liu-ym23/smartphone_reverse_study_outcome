package com.stepos.agentbus.generated;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import com.stepos.agentbus.generated.AgentBusBindingBase;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import o9.InterfaceC1779e;

@c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$connectAndServe$inboundDispatcher$1", f = "AgentBusBindingBase.kt", l = {McpErrorCode.RATE_LIMITED, 431}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AgentBusBindingBase$connectAndServe$inboundDispatcher$1 extends SuspendLambda implements n {
    final /* synthetic */ InterfaceC1779e $inboundQueue;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AgentBusBindingBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$connectAndServe$inboundDispatcher$1(InterfaceC1779e interfaceC1779e, AgentBusBindingBase agentBusBindingBase, H7.c<? super AgentBusBindingBase$connectAndServe$inboundDispatcher$1> cVar) {
        super(2, cVar);
        this.$inboundQueue = interfaceC1779e;
        this.this$0 = agentBusBindingBase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AgentBusBindingBase.ConnectionStatus invokeSuspend$lambda$0(AgentBusBindingBase agentBusBindingBase, AgentBusBindingBase.ConnectionStatus connectionStatus) {
        int iDecrementAndGet = agentBusBindingBase.pendingInboxDepth.decrementAndGet();
        if (iDecrementAndGet < 0) {
            iDecrementAndGet = 0;
        }
        return AgentBusBindingBase.ConnectionStatus.copy$default(connectionStatus, false, null, null, 0L, null, 0, iDecrementAndGet, null, 191, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AgentBusBindingBase.ConnectionStatus invokeSuspend$lambda$1(AgentBusBindingBase.ConnectionStatus connectionStatus) {
        return AgentBusBindingBase.ConnectionStatus.copy$default(connectionStatus, false, null, null, 0L, null, 0, 0, null, 191, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new AgentBusBindingBase$connectAndServe$inboundDispatcher$1(this.$inboundQueue, this.this$0, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        if (r6.dispatchIncoming(r11, r10) == r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:7:0x0016, B:18:0x0036, B:22:0x0046, B:24:0x004e, B:14:0x0029, B:17:0x0030), top: B:31:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006b -> B:8:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r10.label
            r2 = 0
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2d
            if (r1 == r5) goto L25
            if (r1 != r4) goto L1d
            java.lang.Object r1 = r10.L$1
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            java.lang.Object r1 = r10.L$0
            o9.b r1 = (o9.C1776b) r1
            kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L1b
        L19:
            r11 = r1
            goto L36
        L1b:
            r11 = move-exception
            goto L85
        L1d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L25:
            java.lang.Object r1 = r10.L$0
            o9.b r1 = (o9.C1776b) r1
            kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L1b
            goto L46
        L2d:
            kotlin.b.b(r11)
            o9.e r11 = r10.$inboundQueue     // Catch: java.lang.Throwable -> L1b
            o9.b r11 = r11.iterator()     // Catch: java.lang.Throwable -> L1b
        L36:
            r10.L$0 = r11     // Catch: java.lang.Throwable -> L1b
            r10.L$1 = r3     // Catch: java.lang.Throwable -> L1b
            r10.label = r5     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r1 = r11.b(r10)     // Catch: java.lang.Throwable -> L1b
            if (r1 != r0) goto L43
            goto L6d
        L43:
            r9 = r1
            r1 = r11
            r11 = r9
        L46:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L1b
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L1b
            if (r11 == 0) goto L6e
            java.lang.Object r11 = r1.d()     // Catch: java.lang.Throwable -> L1b
            org.json.JSONObject r11 = (org.json.JSONObject) r11     // Catch: java.lang.Throwable -> L1b
            com.stepos.agentbus.generated.AgentBusBindingBase r6 = r10.this$0     // Catch: java.lang.Throwable -> L1b
            com.stepos.agentbus.generated.a r7 = new com.stepos.agentbus.generated.a     // Catch: java.lang.Throwable -> L1b
            r8 = 0
            r7.<init>(r6, r8)     // Catch: java.lang.Throwable -> L1b
            com.stepos.agentbus.generated.AgentBusBindingBase.access$mutateStatus(r6, r7)     // Catch: java.lang.Throwable -> L1b
            com.stepos.agentbus.generated.AgentBusBindingBase r6 = r10.this$0     // Catch: java.lang.Throwable -> L1b
            r10.L$0 = r1     // Catch: java.lang.Throwable -> L1b
            r10.L$1 = r3     // Catch: java.lang.Throwable -> L1b
            r10.label = r4     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r11 = com.stepos.agentbus.generated.AgentBusBindingBase.access$dispatchIncoming(r6, r11, r10)     // Catch: java.lang.Throwable -> L1b
            if (r11 != r0) goto L19
        L6d:
            return r0
        L6e:
            com.stepos.agentbus.generated.AgentBusBindingBase r11 = r10.this$0
            java.util.concurrent.atomic.AtomicInteger r11 = com.stepos.agentbus.generated.AgentBusBindingBase.access$getPendingInboxDepth$p(r11)
            r11.set(r2)
            com.stepos.agentbus.generated.AgentBusBindingBase r10 = r10.this$0
            com.stepos.agentbus.generated.b r11 = new com.stepos.agentbus.generated.b
            r0 = 0
            r11.<init>(r0)
            com.stepos.agentbus.generated.AgentBusBindingBase.access$mutateStatus(r10, r11)
            C7.r r10 = C7.r.f317a
            return r10
        L85:
            com.stepos.agentbus.generated.AgentBusBindingBase r0 = r10.this$0
            java.util.concurrent.atomic.AtomicInteger r0 = com.stepos.agentbus.generated.AgentBusBindingBase.access$getPendingInboxDepth$p(r0)
            r0.set(r2)
            com.stepos.agentbus.generated.AgentBusBindingBase r10 = r10.this$0
            com.stepos.agentbus.generated.b r0 = new com.stepos.agentbus.generated.b
            r1 = 0
            r0.<init>(r1)
            com.stepos.agentbus.generated.AgentBusBindingBase.access$mutateStatus(r10, r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase$connectAndServe$inboundDispatcher$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((AgentBusBindingBase$connectAndServe$inboundDispatcher$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
