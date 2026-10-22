package com.stepos.agentframework.adapter.openclaw;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$deleteSession$2", f = "OpenClawCoreAgentClient.kt", l = {626}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class OpenClawCoreAgentClient$deleteSession$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $sessionKey;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ OpenClawCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenClawCoreAgentClient$deleteSession$2(OpenClawCoreAgentClient openClawCoreAgentClient, String str, InterfaceC4014c<? super OpenClawCoreAgentClient$deleteSession$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = openClawCoreAgentClient;
        this.$sessionKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new OpenClawCoreAgentClient$deleteSession$2(this.this$0, this.$sessionKey, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((OpenClawCoreAgentClient$deleteSession$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
    
        r5 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
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
            java.lang.String r2 = "OpenClawCoreAgentClient"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L2c
            if (r1 != r4) goto L24
            int r1 = r12.I$2
            int r5 = r12.I$1
            int r6 = r12.I$0
            java.lang.Object r7 = r12.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r12.L$1
            com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient r8 = (com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient) r8
            java.lang.Object r9 = r12.L$0
            com.zyql.agentfront.sdk.client.AgentFrontClient r9 = (com.zyql.agentfront.sdk.client.AgentFrontClient) r9
            kotlin.C4849c.b(r13)
            goto L7f
        L24:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L2c:
            kotlin.C4849c.b(r13)
            com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient r13 = r12.this$0
            com.zyql.agentfront.sdk.client.AgentFrontClient r13 = com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.l0(r13)
            if (r13 != 0) goto L58
            com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient r13 = r12.this$0
            com.stepos.agentframework.adapter.netcore.p r13 = com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.n0(r13)
            java.lang.String r12 = r12.$sessionKey
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "deleteSession failed: client is null, sessionKey="
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r13.b(r2, r12)
            java.lang.Boolean r12 = g9.C4109a.a(r3)
            return r12
        L58:
            com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient r1 = r12.this$0
            java.lang.String r5 = r12.$sessionKey
            r6 = 3
            r9 = r13
            r8 = r1
            r1 = r3
            r7 = r5
        L61:
            if (r1 >= r6) goto Ld4
            if (r1 <= 0) goto L7e
            r12.L$0 = r9
            r12.L$1 = r8
            r12.L$2 = r7
            r12.I$0 = r6
            r12.I$1 = r1
            r12.I$2 = r1
            r12.I$3 = r3
            r12.label = r4
            r10 = 400(0x190, double:1.976E-321)
            java.lang.Object r13 = Ua.U.a(r10, r12)
            if (r13 != r0) goto L7e
            return r0
        L7e:
            r5 = r1
        L7f:
            com.stepos.agentframework.adapter.netcore.p r13 = com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.n0(r8)     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            int r1 = r1 + r4
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            r10.<init>()     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            java.lang.String r11 = "deleteSession: sessionKey="
            r10.append(r11)     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            r10.append(r7)     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            java.lang.String r11 = " attempt="
            r10.append(r11)     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            r10.append(r1)     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            java.lang.String r1 = r10.toString()     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            r13.c(r2, r1)     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            r13 = 2
            r1 = 0
            com.zyql.agentfront.sdk.client.AgentFrontClient.X(r9, r7, r1, r13, r1)     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            java.lang.Boolean r12 = g9.C4109a.a(r4)     // Catch: java.lang.Exception -> Laa java.util.concurrent.CancellationException -> Ld2
            return r12
        Laa:
            r13 = move-exception
            com.stepos.agentframework.adapter.netcore.p r1 = com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.n0(r8)
            java.lang.String r13 = r13.getMessage()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "deleteSession failed: sessionKey="
            r10.append(r11)
            r10.append(r7)
            java.lang.String r11 = ", error="
            r10.append(r11)
            r10.append(r13)
            java.lang.String r13 = r10.toString()
            r1.b(r2, r13)
            int r1 = r5 + 1
            goto L61
        Ld2:
            r12 = move-exception
            throw r12
        Ld4:
            java.lang.Boolean r12 = g9.C4109a.a(r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$deleteSession$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
