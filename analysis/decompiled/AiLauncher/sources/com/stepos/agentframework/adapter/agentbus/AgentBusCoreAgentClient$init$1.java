package com.stepos.agentframework.adapter.agentbus;

import Ua.C1056g;
import Ua.Y;
import com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$init$1;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$init$1", f = "AgentBusCoreAgentClient.kt", l = {691, 697}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$init$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$init$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Xa.c {
        final /* synthetic */ Ref$BooleanRef $connectedOnce;
        final /* synthetic */ AgentBusCoreAgentClient this$0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$init$1$1$2", f = "AgentBusCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$init$1$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;

            public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
                super(2, interfaceC4014c);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass2(interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass1(AgentBusCoreAgentClient agentBusCoreAgentClient, Ref$BooleanRef ref$BooleanRef) {
            this.this$0 = agentBusCoreAgentClient;
            this.$connectedOnce = ref$BooleanRef;
        }

        public static final Y8.t h(com.stepos.agentframework.adapter.netcore.h listener) {
            kotlin.jvm.internal.p.i(listener, "listener");
            listener.a();
            return Y8.t.f7040a;
        }

        public static final Y8.t i(com.stepos.agentframework.adapter.netcore.h listener) {
            kotlin.jvm.internal.p.i(listener, "listener");
            listener.d();
            return Y8.t.f7040a;
        }

        @Override // Xa.c
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public final Object emit(com.stepos.agentbus.generated.c cVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            if (!this.this$0.v1()) {
                return Y8.t.f7040a;
            }
            C4148a.k("AgentBusCoreAgentClient", "receive health cloud status: " + cVar.a(), false, 4, null);
            if (cVar.a()) {
                Ref$BooleanRef ref$BooleanRef = this.$connectedOnce;
                if (!ref$BooleanRef.f34815a) {
                    ref$BooleanRef.f34815a = true;
                    Object objJ = C1056g.j(Y.c(), new AnonymousClass2(null), interfaceC4014c);
                    return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
                }
                C4148a.k("AgentBusCoreAgentClient", "cloud reconnected -> ReconnectEventBus.emit()", false, 4, null);
                com.stepos.agentframework.adapter.netcore.u.a();
                this.this$0.G1("cloud reconnected", new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.f
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return AgentBusCoreAgentClient$init$1.AnonymousClass1.h((com.stepos.agentframework.adapter.netcore.h) obj);
                    }
                });
            } else if (this.$connectedOnce.f34815a) {
                this.this$0.G1("cloud disconnected", new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.g
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return AgentBusCoreAgentClient$init$1.AnonymousClass1.i((com.stepos.agentframework.adapter.netcore.h) obj);
                    }
                });
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$init$1(AgentBusCoreAgentClient agentBusCoreAgentClient, InterfaceC4014c<? super AgentBusCoreAgentClient$init$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentBusCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusCoreAgentClient$init$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$init$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b9, code lost:
    
        if (r1.collect(r3, r6) == r0) goto L37;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1f
            if (r1 == r2) goto L16
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L16:
            java.lang.Object r6 = r6.L$0
            kotlin.jvm.internal.Ref$BooleanRef r6 = (kotlin.jvm.internal.Ref$BooleanRef) r6
            kotlin.C4849c.b(r7)
            goto Lbc
        L1f:
            kotlin.C4849c.b(r7)
            goto L3d
        L23:
            kotlin.C4849c.b(r7)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r7 = r6.this$0
            boolean r7 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.D0(r7)
            if (r7 != 0) goto L31
            Y8.t r6 = Y8.t.f7040a
            return r6
        L31:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r7 = r6.this$0
            r6.label = r3
            java.lang.Object r7 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.u0(r7, r6)
            if (r7 != r0) goto L3d
            goto Lbb
        L3d:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r7 = r6.this$0
            boolean r7 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.D0(r7)
            if (r7 != 0) goto L48
            Y8.t r6 = Y8.t.f7040a
            return r6
        L48:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r7 = r6.this$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r7 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.x0(r7)
            r1 = 0
            if (r7 == 0) goto L5a
            boolean r7 = r7.D()
            java.lang.Boolean r7 = g9.C4109a.a(r7)
            goto L5b
        L5a:
            r7 = r1
        L5b:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r3 = r6.this$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r3 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.x0(r3)
            if (r3 == 0) goto L6c
            boolean r3 = r3.C()
            java.lang.Boolean r3 = g9.C4109a.a(r3)
            goto L6d
        L6c:
            r3 = r1
        L6d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "AgentBusCoreAgentClient init,isConnected: "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r7 = ", isCloudConnected:"
            r4.append(r7)
            r4.append(r3)
            java.lang.String r7 = r4.toString()
            r3 = 0
            r4 = 4
            java.lang.String r5 = "AgentBusCoreAgentClient"
            h8.C4148a.k(r5, r7, r3, r4, r1)
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r1 = r6.this$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r1 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.x0(r1)
            if (r1 == 0) goto Lc2
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$b r1 = r1.getHealth()
            if (r1 == 0) goto Lc2
            Xa.t r1 = r1.b()
            if (r1 == 0) goto Lc2
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$init$1$1 r3 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$init$1$1
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r4 = r6.this$0
            r3.<init>(r4, r7)
            java.lang.Object r7 = g9.h.a(r7)
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r6 = r1.collect(r3, r6)
            if (r6 != r0) goto Lbc
        Lbb:
            return r0
        Lbc:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        Lc2:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$init$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
