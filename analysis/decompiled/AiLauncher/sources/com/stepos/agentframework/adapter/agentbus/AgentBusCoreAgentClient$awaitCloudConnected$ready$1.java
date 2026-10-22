package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$ready$1", f = "AgentBusCoreAgentClient.kt", l = {834}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$awaitCloudConnected$ready$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ ClawChannelAgentBusBinding $bus;
    int label;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/agentbus/generated/c;", "status", "", "local", "<anonymous>", "(Lcom/stepos/agentbus/generated/c;Z)Z"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$ready$1$1", f = "AgentBusCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$ready$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.q<com.stepos.agentbus.generated.c, Boolean, InterfaceC4014c<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        public final Object f(com.stepos.agentbus.generated.c cVar, boolean z10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.L$0 = cVar;
            anonymousClass1.Z$0 = z10;
            return anonymousClass1.invokeSuspend(Y8.t.f7040a);
        }

        @Override // p9.q
        public /* bridge */ /* synthetic */ Object invoke(com.stepos.agentbus.generated.c cVar, Boolean bool, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return f(cVar, bool.booleanValue(), interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.stepos.agentbus.generated.c cVar = (com.stepos.agentbus.generated.c) this.L$0;
            boolean z10 = this.Z$0;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (cVar.a()) {
                return C4109a.a(true);
            }
            if (z10) {
                return null;
            }
            return C4109a.a(false);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$ready$1$2", f = "AgentBusCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$ready$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Boolean, InterfaceC4014c<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Boolean bool, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return ((AnonymousClass2) create(bool, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Boolean bool = (Boolean) this.L$0;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return C4109a.a(bool != null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$awaitCloudConnected$ready$1(ClawChannelAgentBusBinding clawChannelAgentBusBinding, InterfaceC4014c<? super AgentBusCoreAgentClient$awaitCloudConnected$ready$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$bus = clawChannelAgentBusBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusCoreAgentClient$awaitCloudConnected$ready$1(this.$bus, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$awaitCloudConnected$ready$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.b bVarN = Xa.d.n(this.$bus.getHealth().b(), this.$bus.u(), new AnonymousClass1(null));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            this.label = 1;
            obj = Xa.d.z(bVarN, anonymousClass2, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return C4109a.a(kotlin.jvm.internal.p.d(obj, C4109a.a(true)));
    }
}
