package com.stepos.agentframework.adapter.agentbus;

import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$withBinding$2", f = "AgentBusCoreAgentClient.kt", l = {3301, 3307, 3313}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$withBinding$2<T> extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super T>, Object> {
    final /* synthetic */ p9.p<ClawChannelAgentBusBinding, InterfaceC4014c<? super T>, Object> $block;
    final /* synthetic */ String $op;
    Object L$0;
    int label;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentBusCoreAgentClient$withBinding$2(AgentBusCoreAgentClient agentBusCoreAgentClient, String str, p9.p<? super ClawChannelAgentBusBinding, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, InterfaceC4014c<? super AgentBusCoreAgentClient$withBinding$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentBusCoreAgentClient;
        this.$op = str;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusCoreAgentClient$withBinding$2(this.this$0, this.$op, this.$block, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super T> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$withBinding$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 4
            r6 = 0
            java.lang.String r7 = "AgentBusCoreAgentClient"
            r8 = 0
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 == r3) goto L29
            if (r1 != r2) goto L21
            java.lang.Object r0 = r9.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r0 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r0
            kotlin.C4849c.b(r10)     // Catch: java.lang.Exception -> L1e java.util.concurrent.CancellationException -> Ld8
            return r10
        L1e:
            r10 = move-exception
            goto Lba
        L21:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L29:
            java.lang.Object r1 = r9.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r1 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r1
            kotlin.C4849c.b(r10)
            goto L80
        L31:
            kotlin.C4849c.b(r10)
            goto L4c
        L35:
            kotlin.C4849c.b(r10)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r10 = r9.this$0
            boolean r10 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.D0(r10)
            if (r10 != 0) goto L41
            return r8
        L41:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r10 = r9.this$0
            r9.label = r4
            java.lang.Object r10 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.u0(r10, r9)
            if (r10 != r0) goto L4c
            goto Lb8
        L4c:
            r1 = r10
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r1 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r1
            if (r1 != 0) goto L68
            java.lang.String r9 = r9.$op
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            java.lang.String r9 = " failed: no binding"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            h8.C4148a.k(r7, r9, r6, r5, r8)
            return r8
        L68:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r10 = r9.this$0
            boolean r10 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.D0(r10)
            if (r10 != 0) goto L71
            return r8
        L71:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r10 = r9.this$0
            r9.L$0 = r1
            r9.label = r3
            r3 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r10 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.n0(r10, r1, r3, r9)
            if (r10 != r0) goto L80
            goto Lb8
        L80:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L9f
            java.lang.String r9 = r9.$op
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            java.lang.String r9 = " failed: not connected"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            h8.C4148a.k(r7, r9, r6, r5, r8)
            return r8
        L9f:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r10 = r9.this$0
            boolean r10 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.D0(r10)
            if (r10 != 0) goto La8
            return r8
        La8:
            p9.p<com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, e9.c<? super T>, java.lang.Object> r10 = r9.$block     // Catch: java.lang.Exception -> L1e java.util.concurrent.CancellationException -> Ld8
            java.lang.Object r3 = g9.h.a(r1)     // Catch: java.lang.Exception -> L1e java.util.concurrent.CancellationException -> Ld8
            r9.L$0 = r3     // Catch: java.lang.Exception -> L1e java.util.concurrent.CancellationException -> Ld8
            r9.label = r2     // Catch: java.lang.Exception -> L1e java.util.concurrent.CancellationException -> Ld8
            java.lang.Object r9 = r10.invoke(r1, r9)     // Catch: java.lang.Exception -> L1e java.util.concurrent.CancellationException -> Ld8
            if (r9 != r0) goto Lb9
        Lb8:
            return r0
        Lb9:
            return r9
        Lba:
            java.lang.String r9 = r9.$op
            java.lang.String r10 = r10.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            java.lang.String r9 = " failed: "
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = r0.toString()
            h8.C4148a.k(r7, r9, r6, r5, r8)
            return r8
        Ld8:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$withBinding$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
