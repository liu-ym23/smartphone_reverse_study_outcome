package com.stepos.agentbus.generated;

import Ua.M;
import Wa.g;
import Y8.t;
import com.stepos.agentbus.generated.AgentBusBindingBase;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.json.JSONObject;
import p9.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase$connectAndServe$inboundDispatcher$1", f = "AgentBusBindingBase.kt", l = {429, 431}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$connectAndServe$inboundDispatcher$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f22252a;

    /* renamed from: b, reason: collision with root package name */
    public Object f22253b;

    /* renamed from: c, reason: collision with root package name */
    public int f22254c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g<JSONObject> f22255d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22256e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$connectAndServe$inboundDispatcher$1(g<JSONObject> gVar, AgentBusBindingBase agentBusBindingBase, InterfaceC4014c<? super AgentBusBindingBase$connectAndServe$inboundDispatcher$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f22255d = gVar;
        this.f22256e = agentBusBindingBase;
    }

    public static final AgentBusBindingBase.ConnectionStatus i(AgentBusBindingBase agentBusBindingBase, AgentBusBindingBase.ConnectionStatus connectionStatus) {
        return AgentBusBindingBase.ConnectionStatus.b(connectionStatus, false, null, null, 0L, null, 0, C5685n.f(agentBusBindingBase.pendingInboxDepth.decrementAndGet(), 0), null, 191, null);
    }

    public static final AgentBusBindingBase.ConnectionStatus n(AgentBusBindingBase.ConnectionStatus connectionStatus) {
        return AgentBusBindingBase.ConnectionStatus.b(connectionStatus, false, null, null, 0L, null, 0, 0, null, 191, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusBindingBase$connectAndServe$inboundDispatcher$1(this.f22255d, this.f22256e, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusBindingBase$connectAndServe$inboundDispatcher$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r5.L(r9, r8) == r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: all -> 0x001c, TRY_LEAVE, TryCatch #0 {all -> 0x001c, blocks: (B:7:0x0017, B:18:0x0037, B:22:0x0048, B:24:0x0050, B:14:0x002a, B:17:0x0031), top: B:31:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0070 -> B:8:0x001a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r8.f22254c
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L26
            if (r1 != r3) goto L1e
            java.lang.Object r1 = r8.f22253b
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            java.lang.Object r1 = r8.f22252a
            Wa.i r1 = (Wa.i) r1
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L1c
        L1a:
            r9 = r1
            goto L37
        L1c:
            r9 = move-exception
            goto L89
        L1e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L26:
            java.lang.Object r1 = r8.f22252a
            Wa.i r1 = (Wa.i) r1
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L1c
            goto L48
        L2e:
            kotlin.C4849c.b(r9)
            Wa.g<org.json.JSONObject> r9 = r8.f22255d     // Catch: java.lang.Throwable -> L1c
            Wa.i r9 = r9.iterator()     // Catch: java.lang.Throwable -> L1c
        L37:
            r8.f22252a = r9     // Catch: java.lang.Throwable -> L1c
            r1 = 0
            r8.f22253b = r1     // Catch: java.lang.Throwable -> L1c
            r8.f22254c = r4     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r1 = r9.a(r8)     // Catch: java.lang.Throwable -> L1c
            if (r1 != r0) goto L45
            goto L72
        L45:
            r7 = r1
            r1 = r9
            r9 = r7
        L48:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L1c
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L1c
            if (r9 == 0) goto L73
            java.lang.Object r9 = r1.next()     // Catch: java.lang.Throwable -> L1c
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch: java.lang.Throwable -> L1c
            com.stepos.agentbus.generated.AgentBusBindingBase r5 = r8.f22256e     // Catch: java.lang.Throwable -> L1c
            com.stepos.agentbus.generated.a r6 = new com.stepos.agentbus.generated.a     // Catch: java.lang.Throwable -> L1c
            r6.<init>()     // Catch: java.lang.Throwable -> L1c
            com.stepos.agentbus.generated.AgentBusBindingBase.v(r5, r6)     // Catch: java.lang.Throwable -> L1c
            com.stepos.agentbus.generated.AgentBusBindingBase r5 = r8.f22256e     // Catch: java.lang.Throwable -> L1c
            r8.f22252a = r1     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r6 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L1c
            r8.f22253b = r6     // Catch: java.lang.Throwable -> L1c
            r8.f22254c = r3     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r9 = com.stepos.agentbus.generated.AgentBusBindingBase.l(r5, r9, r8)     // Catch: java.lang.Throwable -> L1c
            if (r9 != r0) goto L1a
        L72:
            return r0
        L73:
            com.stepos.agentbus.generated.AgentBusBindingBase r9 = r8.f22256e
            java.util.concurrent.atomic.AtomicInteger r9 = com.stepos.agentbus.generated.AgentBusBindingBase.t(r9)
            r9.set(r2)
            com.stepos.agentbus.generated.AgentBusBindingBase r8 = r8.f22256e
            com.stepos.agentbus.generated.b r9 = new com.stepos.agentbus.generated.b
            r9.<init>()
            com.stepos.agentbus.generated.AgentBusBindingBase.v(r8, r9)
            Y8.t r8 = Y8.t.f7040a
            return r8
        L89:
            com.stepos.agentbus.generated.AgentBusBindingBase r0 = r8.f22256e
            java.util.concurrent.atomic.AtomicInteger r0 = com.stepos.agentbus.generated.AgentBusBindingBase.t(r0)
            r0.set(r2)
            com.stepos.agentbus.generated.AgentBusBindingBase r8 = r8.f22256e
            com.stepos.agentbus.generated.b r0 = new com.stepos.agentbus.generated.b
            r0.<init>()
            com.stepos.agentbus.generated.AgentBusBindingBase.v(r8, r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase$connectAndServe$inboundDispatcher$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
