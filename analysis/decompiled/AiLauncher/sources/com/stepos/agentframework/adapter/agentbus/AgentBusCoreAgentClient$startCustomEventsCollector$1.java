package com.stepos.agentframework.adapter.agentbus;

import a4.CustomEvent;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$startCustomEventsCollector$1", f = "AgentBusCoreAgentClient.kt", l = {1807}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$startCustomEventsCollector$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ClawChannelAgentBusBinding $bus;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ AgentBusCoreAgentClient this$0;

        public a(AgentBusCoreAgentClient agentBusCoreAgentClient) {
            this.this$0 = agentBusCoreAgentClient;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(a4.CustomEvent r5, e9.InterfaceC4014c<? super Y8.t> r6) {
            /*
                r4 = this;
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r6 = r4.this$0
                boolean r6 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.D0(r6)
                if (r6 != 0) goto Lb
                Y8.t r4 = Y8.t.f7040a
                return r4
            Lb:
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r6 = r4.this$0
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.A0(r6, r5)
                java.lang.String r6 = r5.getEvent()
                r0 = 0
                r1 = 2
                java.lang.String r2 = "stepclaw."
                r3 = 0
                boolean r6 = La.D.X(r6, r2, r0, r1, r3)
                if (r6 == 0) goto L22
                Y8.t r4 = Y8.t.f7040a
                return r4
            L22:
                java.util.Map r6 = r5.b()
                java.lang.String r0 = "stream"
                java.lang.Object r6 = r6.get(r0)
                boolean r0 = r6 instanceof java.lang.String
                if (r0 == 0) goto L33
                java.lang.String r6 = (java.lang.String) r6
                goto L34
            L33:
                r6 = r3
            L34:
                if (r6 == 0) goto L3d
                boolean r0 = La.H.x0(r6)
                if (r0 != 0) goto L3d
                goto L3e
            L3d:
                r6 = r3
            L3e:
                java.util.Set r0 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.y0()
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                boolean r0 = Z8.F.f0(r0, r6)
                if (r0 == 0) goto Lb3
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r4 = r4.this$0
                java.lang.String r6 = r5.getEvent()
                java.util.Map r0 = r5.b()
                java.util.Map r1 = r5.b()
                java.lang.String r2 = "sessionId"
                java.lang.Object r1 = r1.get(r2)
                boolean r2 = r1 instanceof java.lang.String
                if (r2 == 0) goto L65
                java.lang.String r1 = (java.lang.String) r1
                goto L66
            L65:
                r1 = r3
            L66:
                if (r1 == 0) goto L73
                int r2 = r1.length()
                if (r2 <= 0) goto L6f
                goto L70
            L6f:
                r1 = r3
            L70:
                if (r1 == 0) goto L73
                goto L8f
            L73:
                java.util.Map r1 = r5.b()
                java.lang.String r2 = "sessionKey"
                java.lang.Object r1 = r1.get(r2)
                boolean r2 = r1 instanceof java.lang.String
                if (r2 == 0) goto L84
                java.lang.String r1 = (java.lang.String) r1
                goto L85
            L84:
                r1 = r3
            L85:
                if (r1 == 0) goto L8e
                int r2 = r1.length()
                if (r2 <= 0) goto L8e
                goto L8f
            L8e:
                r1 = r3
            L8f:
                java.util.Map r5 = r5.b()
                java.lang.String r2 = "runId"
                java.lang.Object r5 = r5.get(r2)
                boolean r2 = r5 instanceof java.lang.String
                if (r2 == 0) goto La0
                java.lang.String r5 = (java.lang.String) r5
                goto La1
            La0:
                r5 = r3
            La1:
                if (r5 == 0) goto Laa
                int r2 = r5.length()
                if (r2 <= 0) goto Laa
                r3 = r5
            Laa:
                a4.z r5 = new a4.z
                r5.<init>(r6, r0, r1, r3)
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.B0(r4, r5)
                goto Ld0
            Lb3:
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r0 = r4.this$0
                if (r6 != 0) goto Lbb
                java.lang.String r6 = r5.getEvent()
            Lbb:
                boolean r6 = com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.G0(r0, r6)
                if (r6 == 0) goto Lcb
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r4 = r4.this$0
                java.util.Map r5 = r5.b()
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.C0(r4, r5)
                goto Ld0
            Lcb:
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r4 = r4.this$0
                com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.L0(r4, r5)
            Ld0:
                Y8.t r4 = Y8.t.f7040a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$startCustomEventsCollector$1.a.emit(a4.r, e9.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$startCustomEventsCollector$1(ClawChannelAgentBusBinding clawChannelAgentBusBinding, AgentBusCoreAgentClient agentBusCoreAgentClient, InterfaceC4014c<? super AgentBusCoreAgentClient$startCustomEventsCollector$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$bus = clawChannelAgentBusBinding;
        this.this$0 = agentBusCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusCoreAgentClient$startCustomEventsCollector$1 agentBusCoreAgentClient$startCustomEventsCollector$1 = new AgentBusCoreAgentClient$startCustomEventsCollector$1(this.$bus, this.this$0, interfaceC4014c);
        agentBusCoreAgentClient$startCustomEventsCollector$1.L$0 = obj;
        return agentBusCoreAgentClient$startCustomEventsCollector$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$startCustomEventsCollector$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                ClawChannelAgentBusBinding clawChannelAgentBusBinding = this.$bus;
                AgentBusCoreAgentClient agentBusCoreAgentClient = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                Xa.o<CustomEvent> oVarV = clawChannelAgentBusBinding.v();
                a aVar = new a(agentBusCoreAgentClient);
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                if (oVarV.collect(aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thE = Result.e(Result.b(C4849c.a(th)));
            if (thE != null && !(thE instanceof CancellationException)) {
                C4148a.u("AgentBusCoreAgentClient", "customEvents collector stopped: " + thE.getMessage(), false, 4, null);
            }
            return Y8.t.f7040a;
        }
    }
}
