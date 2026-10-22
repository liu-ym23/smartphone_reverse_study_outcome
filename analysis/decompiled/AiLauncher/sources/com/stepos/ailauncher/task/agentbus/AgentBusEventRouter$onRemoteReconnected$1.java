package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$onRemoteReconnected$1", f = "AgentBusEventRouter.kt", l = {304, 305, 306}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$onRemoteReconnected$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    int label;

    public AgentBusEventRouter$onRemoteReconnected$1(InterfaceC4014c<? super AgentBusEventRouter$onRemoteReconnected$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusEventRouter$onRemoteReconnected$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusEventRouter$onRemoteReconnected$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        if (r13.A0("delayed", r12) != r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L2d
            if (r1 == r4) goto L29
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            goto L55
        L16:
            r0 = move-exception
            r12 = r0
            goto L69
        L19:
            r0 = move-exception
            r12 = r0
            r8 = r12
            goto L59
        L1d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L25:
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            goto L48
        L29:
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            goto L3d
        L2d:
            kotlin.C4849c.b(r13)
            com.stepos.ailauncher.task.agentbus.AgentBusEventRouter r13 = com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.INSTANCE     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            java.lang.String r1 = "immediate"
            r12.label = r4     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            java.lang.Object r13 = com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.x(r13, r1, r12)     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            if (r13 != r0) goto L3d
            goto L54
        L3d:
            r12.label = r3     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            r3 = 8000(0x1f40, double:3.9525E-320)
            java.lang.Object r13 = Ua.U.a(r3, r12)     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            if (r13 != r0) goto L48
            goto L54
        L48:
            com.stepos.ailauncher.task.agentbus.AgentBusEventRouter r13 = com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.INSTANCE     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            java.lang.String r1 = "delayed"
            r12.label = r2     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            java.lang.Object r12 = com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.x(r13, r1, r12)     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            if (r12 != r0) goto L55
        L54:
            return r0
        L55:
            com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.y(r5)
            goto L66
        L59:
            java.lang.String r6 = "AILauncher-AgentBus"
            java.lang.String r7 = "reconnect sync error"
            r10 = 8
            r11 = 0
            r9 = 0
            h8.C4148a.g(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L16
            goto L55
        L66:
            Y8.t r12 = Y8.t.f7040a
            return r12
        L69:
            com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.y(r5)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$onRemoteReconnected$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
