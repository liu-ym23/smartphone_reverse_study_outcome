package com.stepos.agentframework.adapter.agentbus.bff;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$ensureGapTimer$1", f = "ABBffCoreAgentClient.kt", l = {823, 830}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffCoreAgentClient$SeqReorderBuffer$ensureGapTimer$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ long $expected;
    Object L$0;
    int label;
    final /* synthetic */ ABBffCoreAgentClient.SeqReorderBuffer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffCoreAgentClient$SeqReorderBuffer$ensureGapTimer$1(ABBffCoreAgentClient.SeqReorderBuffer seqReorderBuffer, long j10, InterfaceC4014c<? super ABBffCoreAgentClient$SeqReorderBuffer$ensureGapTimer$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = seqReorderBuffer;
        this.$expected = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ABBffCoreAgentClient$SeqReorderBuffer$ensureGapTimer$1(this.this$0, this.$expected, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ABBffCoreAgentClient$SeqReorderBuffer$ensureGapTimer$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b0, code lost:
    
        if (r1.k(r7) == r0) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r7.L$0
            java.lang.Long r0 = (java.lang.Long) r0
            kotlin.C4849c.b(r8)
            goto Lb3
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1f:
            kotlin.C4849c.b(r8)
            goto L32
        L23:
            kotlin.C4849c.b(r8)
            r7.label = r3
            r3 = 100
            java.lang.Object r8 = Ua.U.a(r3, r7)
            if (r8 != r0) goto L32
            goto Lb2
        L32:
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer r8 = r7.this$0
            boolean r8 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.d(r8)
            if (r8 == 0) goto L3d
            Y8.t r7 = Y8.t.f7040a
            return r7
        L3d:
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer r8 = r7.this$0
            long r3 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.e(r8)
            long r5 = r7.$expected
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto Lc0
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer r8 = r7.this$0
            java.util.TreeMap r8 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.f(r8)
            long r3 = r7.$expected
            java.lang.Long r1 = g9.C4109a.g(r3)
            boolean r8 = r8.containsKey(r1)
            if (r8 != 0) goto Lc0
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer r8 = r7.this$0
            java.util.TreeMap r8 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.f(r8)
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto Lc0
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer r8 = r7.this$0
            java.util.TreeMap r8 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.f(r8)
            java.lang.Object r8 = r8.firstKey()
            java.lang.Long r8 = (java.lang.Long) r8
            long r3 = r7.$expected
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "reorder: gap timeout, skip missing seq="
            r1.append(r5)
            r1.append(r3)
            java.lang.String r3 = ", jump to "
            r1.append(r3)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r3 = 4
            r4 = 0
            java.lang.String r5 = "ABBffCoreAgentClient"
            r6 = 0
            h8.C4148a.u(r5, r1, r6, r3, r4)
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer r1 = r7.this$0
            kotlin.jvm.internal.p.f(r8)
            long r3 = r8.longValue()
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.g(r1, r3)
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer r1 = r7.this$0
            java.lang.Object r8 = g9.h.a(r8)
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r8 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.b(r1, r7)
            if (r8 != r0) goto Lb3
        Lb2:
            return r0
        Lb3:
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer r8 = r7.this$0
            boolean r8 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.d(r8)
            if (r8 != 0) goto Lc0
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer r7 = r7.this$0
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.c(r7)
        Lc0:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$ensureGapTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
