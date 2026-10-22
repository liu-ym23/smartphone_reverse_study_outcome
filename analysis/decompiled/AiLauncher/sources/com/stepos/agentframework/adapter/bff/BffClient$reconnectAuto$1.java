package com.stepos.agentframework.adapter.bff;

import Ua.M;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.bff.BffClient$reconnectAuto$1", f = "BffClient.kt", l = {194, 198}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class BffClient$reconnectAuto$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BffClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BffClient$reconnectAuto$1(BffClient bffClient, InterfaceC4014c<? super BffClient$reconnectAuto$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = bffClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        BffClient$reconnectAuto$1 bffClient$reconnectAuto$1 = new BffClient$reconnectAuto$1(this.this$0, interfaceC4014c);
        bffClient$reconnectAuto$1.L$0 = obj;
        return bffClient$reconnectAuto$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BffClient$reconnectAuto$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ad, code lost:
    
        if (r11.T(r10) == r1) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r10.label
            java.lang.String r3 = " [BffClient] "
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L27
            if (r2 == r5) goto L21
            if (r2 != r4) goto L19
            kotlin.C4849c.b(r11)
            goto Lb0
        L19:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L21:
            long r6 = r10.J$0
            kotlin.C4849c.b(r11)
            goto L83
        L27:
            kotlin.C4849c.b(r11)
            com.stepos.agentframework.adapter.bff.BffClient r11 = r10.this$0
            int r11 = com.stepos.agentframework.adapter.bff.BffClient.o(r11)
            r2 = 5
            if (r11 >= r2) goto Lb9
            com.stepos.agentframework.adapter.bff.BffClient r11 = r10.this$0
            int r11 = com.stepos.agentframework.adapter.bff.BffClient.o(r11)
            double r6 = (double) r11
            r8 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = java.lang.Math.pow(r8, r6)
            long r6 = (long) r6
            r8 = 2000(0x7d0, double:9.88E-321)
            long r6 = r6 * r8
            r8 = 60000(0xea60, double:2.9644E-319)
            long r6 = v9.C5685n.k(r6, r8)
            com.stepos.agentframework.adapter.netcore.p r11 = com.stepos.agentframework.adapter.bff.r.a()
            com.stepos.agentframework.adapter.bff.BffClient r2 = r10.this$0
            int r2 = com.stepos.agentframework.adapter.bff.BffClient.o(r2)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Next reconnect attempt in "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r9 = "ms (count="
            r8.append(r9)
            r8.append(r2)
            java.lang.String r2 = ")"
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            r11.c(r3, r2)
            r10.L$0 = r0
            r10.J$0 = r6
            r10.label = r5
            java.lang.Object r11 = Ua.U.a(r6, r10)
            if (r11 != r1) goto L83
            goto Laf
        L83:
            boolean r11 = kotlinx.coroutines.d.h(r0)
            if (r11 == 0) goto Lb9
            com.stepos.agentframework.adapter.bff.BffClient r11 = r10.this$0
            boolean r11 = r11.O()
            if (r11 != 0) goto Lb9
            com.stepos.agentframework.adapter.bff.BffClient r11 = r10.this$0
            int r11 = com.stepos.agentframework.adapter.bff.BffClient.o(r11)
            com.stepos.agentframework.adapter.bff.BffClient r2 = r10.this$0
            int r11 = r11 + r5
            com.stepos.agentframework.adapter.bff.BffClient.p(r2, r11)
            com.stepos.agentframework.adapter.bff.BffClient r11 = r10.this$0
            java.lang.Object r0 = g9.h.a(r0)
            r10.L$0 = r0
            r10.J$0 = r6
            r10.label = r4
            java.lang.Object r10 = r11.T(r10)
            if (r10 != r1) goto Lb0
        Laf:
            return r1
        Lb0:
            com.stepos.agentframework.adapter.netcore.p r10 = com.stepos.agentframework.adapter.bff.r.a()
            java.lang.String r11 = "reconnectAuto"
            r10.c(r3, r11)
        Lb9:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.bff.BffClient$reconnectAuto$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
