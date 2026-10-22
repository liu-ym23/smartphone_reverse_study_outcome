package com.stepos.agentframework.adapter.agentbus.bff;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$init$3", f = "ABBffCoreAgentClient.kt", l = {181, 183}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffCoreAgentClient$init$3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    int label;
    final /* synthetic */ ABBffCoreAgentClient this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        public static final a<T> INSTANCE = new a<>();

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(com.stepos.agentbus.generated.c cVar, InterfaceC4014c<? super t> interfaceC4014c) {
            C4148a.k("ABBffCoreAgentClient", "receive health bff status: " + cVar.a(), false, 4, null);
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffCoreAgentClient$init$3(ABBffCoreAgentClient aBBffCoreAgentClient, InterfaceC4014c<? super ABBffCoreAgentClient$init$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aBBffCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ABBffCoreAgentClient$init$3(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ABBffCoreAgentClient$init$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r11 == r0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009e, code lost:
    
        if (r10.collect(r11, r7) == r0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a0, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1b
            if (r1 == r2) goto L16
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L16:
            kotlin.C4849c.b(r11)
            goto La1
        L1b:
            kotlin.C4849c.b(r11)
            r7 = r10
            goto L39
        L20:
            kotlin.C4849c.b(r11)
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient r11 = r10.this$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r4 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.p0(r11)
            if (r4 == 0) goto L3c
            r10.label = r3
            r5 = 0
            r8 = 1
            r9 = 0
            r7 = r10
            java.lang.Object r11 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.n(r4, r5, r7, r8, r9)
            if (r11 != r0) goto L39
            goto La0
        L39:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            goto L3d
        L3c:
            r7 = r10
        L3d:
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient r10 = r7.this$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r10 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.p0(r10)
            r11 = 0
            if (r10 == 0) goto L4f
            boolean r10 = r10.D()
            java.lang.Boolean r10 = g9.C4109a.a(r10)
            goto L50
        L4f:
            r10 = r11
        L50:
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient r1 = r7.this$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r1 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.p0(r1)
            if (r1 == 0) goto L61
            boolean r1 = r1.C()
            java.lang.Boolean r1 = g9.C4109a.a(r1)
            goto L62
        L61:
            r1 = r11
        L62:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ABBffCoreAgentClient init,isConnected: "
            r3.append(r4)
            r3.append(r10)
            java.lang.String r10 = ", isCloudConnected:"
            r3.append(r10)
            r3.append(r1)
            java.lang.String r10 = r3.toString()
            r1 = 0
            r3 = 4
            java.lang.String r4 = "ABBffCoreAgentClient"
            h8.C4148a.k(r4, r10, r1, r3, r11)
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient r10 = r7.this$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r10 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.p0(r10)
            if (r10 == 0) goto La7
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$b r10 = r10.getHealth()
            if (r10 == 0) goto La7
            Xa.t r10 = r10.a()
            if (r10 == 0) goto La7
            com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$init$3$a<T> r11 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$init$3.a.INSTANCE
            r7.label = r2
            java.lang.Object r10 = r10.collect(r11, r7)
            if (r10 != r0) goto La1
        La0:
            return r0
        La1:
            kotlin.KotlinNothingValueException r10 = new kotlin.KotlinNothingValueException
            r10.<init>()
            throw r10
        La7:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$init$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
