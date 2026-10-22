package com.stepos.agentframework.adapter.agentbus;

import a4.StepClawEvent;
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
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$startStepClawEventsCollector$1", f = "AgentBusCoreAgentClient.kt", l = {1775}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$startStepClawEventsCollector$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
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

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(StepClawEvent stepClawEvent, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            if (!this.this$0.v1()) {
                return Y8.t.f7040a;
            }
            this.this$0.s1(stepClawEvent);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$startStepClawEventsCollector$1(ClawChannelAgentBusBinding clawChannelAgentBusBinding, AgentBusCoreAgentClient agentBusCoreAgentClient, InterfaceC4014c<? super AgentBusCoreAgentClient$startStepClawEventsCollector$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$bus = clawChannelAgentBusBinding;
        this.this$0 = agentBusCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusCoreAgentClient$startStepClawEventsCollector$1 agentBusCoreAgentClient$startStepClawEventsCollector$1 = new AgentBusCoreAgentClient$startStepClawEventsCollector$1(this.$bus, this.this$0, interfaceC4014c);
        agentBusCoreAgentClient$startStepClawEventsCollector$1.L$0 = obj;
        return agentBusCoreAgentClient$startStepClawEventsCollector$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$startStepClawEventsCollector$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
                Xa.o<StepClawEvent> oVarA = clawChannelAgentBusBinding.A();
                a aVar = new a(agentBusCoreAgentClient);
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                if (oVarA.collect(aVar, this) == objG) {
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
                C4148a.u("AgentBusCoreAgentClient", "stepClawEvents collector stopped: " + thE.getMessage(), false, 4, null);
            }
            return Y8.t.f7040a;
        }
    }
}
