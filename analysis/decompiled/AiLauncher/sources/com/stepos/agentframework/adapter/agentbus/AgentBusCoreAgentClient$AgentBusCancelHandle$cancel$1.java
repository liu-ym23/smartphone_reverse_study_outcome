package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$AgentBusCancelHandle$cancel$1", f = "AgentBusCoreAgentClient.kt", l = {631}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$AgentBusCancelHandle$cancel$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Map<String, Object> $abortParams;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$AgentBusCancelHandle$cancel$1(AgentBusCoreAgentClient agentBusCoreAgentClient, Map<String, ? extends Object> map, InterfaceC4014c<? super AgentBusCoreAgentClient$AgentBusCancelHandle$cancel$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentBusCoreAgentClient;
        this.$abortParams = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusCoreAgentClient$AgentBusCancelHandle$cancel$1 agentBusCoreAgentClient$AgentBusCancelHandle$cancel$1 = new AgentBusCoreAgentClient$AgentBusCancelHandle$cancel$1(this.this$0, this.$abortParams, interfaceC4014c);
        agentBusCoreAgentClient$AgentBusCancelHandle$cancel$1.L$0 = obj;
        return agentBusCoreAgentClient$AgentBusCancelHandle$cancel$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$AgentBusCancelHandle$cancel$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = r8.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r8.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L23
            if (r2 != r5) goto L1b
            java.lang.Object r8 = r8.L$1
            Ua.M r8 = (Ua.M) r8
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L19
            goto L4b
        L19:
            r8 = move-exception
            goto L54
        L1b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L23:
            kotlin.C4849c.b(r9)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r9 = r8.this$0
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.$abortParams
            kotlin.Result$a r6 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L19
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r9 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.x0(r9)     // Catch: java.lang.Throwable -> L19
            if (r9 == 0) goto L4e
            java.lang.String r6 = "chat.abort"
            java.lang.Object r7 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L19
            r8.L$0 = r7     // Catch: java.lang.Throwable -> L19
            java.lang.Object r0 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L19
            r8.L$1 = r0     // Catch: java.lang.Throwable -> L19
            r8.I$0 = r4     // Catch: java.lang.Throwable -> L19
            r8.label = r5     // Catch: java.lang.Throwable -> L19
            java.lang.Object r9 = r9.N(r6, r2, r8)     // Catch: java.lang.Throwable -> L19
            if (r9 != r1) goto L4b
            return r1
        L4b:
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L19
            goto L4f
        L4e:
            r9 = r3
        L4f:
            java.lang.Object r8 = kotlin.Result.b(r9)     // Catch: java.lang.Throwable -> L19
            goto L5e
        L54:
            kotlin.Result$a r9 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L5e:
            java.lang.Throwable r8 = kotlin.Result.e(r8)
            if (r8 == 0) goto L7f
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "run abort failed: "
            r9.append(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = 4
            java.lang.String r0 = "AgentBusCoreAgentClient"
            h8.C4148a.d(r0, r8, r4, r9, r3)
        L7f:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$AgentBusCancelHandle$cancel$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
