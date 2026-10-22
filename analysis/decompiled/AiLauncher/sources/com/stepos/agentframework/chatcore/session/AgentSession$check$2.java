package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$check$2", f = "AgentSession.kt", l = {2400}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$check$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $executor;
    int label;
    final /* synthetic */ AgentSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession$check$2(AgentSession agentSession, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, InterfaceC4014c<? super AgentSession$check$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$executor = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$check$2(this.this$0, this.$executor, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$check$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AgentSession$check$2 agentSession$check$2;
        AgentSession agentSession;
        Exception exc;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            try {
                this.this$0.r1();
                agentSession = this.this$0;
                this.label = 1;
                agentSession$check$2 = this;
            } catch (Exception e10) {
                e = e10;
                agentSession$check$2 = this;
                exc = e;
                C4148a.g(agentSession$check$2.this$0.TAG, "check init", exc, false, 8, null);
                agentSession$check$2.$executor.invoke(C4109a.a(false));
                return Y8.t.f7040a;
            }
            try {
                obj = AgentSession.F2(agentSession, 0L, agentSession$check$2, 1, null);
                if (obj == objG) {
                    return objG;
                }
            } catch (Exception e11) {
                e = e11;
                exc = e;
                C4148a.g(agentSession$check$2.this$0.TAG, "check init", exc, false, 8, null);
                agentSession$check$2.$executor.invoke(C4109a.a(false));
                return Y8.t.f7040a;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                C4849c.b(obj);
                agentSession$check$2 = this;
            } catch (Exception e12) {
                exc = e12;
                agentSession$check$2 = this;
                C4148a.g(agentSession$check$2.this$0.TAG, "check init", exc, false, 8, null);
                agentSession$check$2.$executor.invoke(C4109a.a(false));
                return Y8.t.f7040a;
            }
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        C4148a.k(agentSession$check$2.this$0.TAG, "waitForStatusChange after init success:" + zBooleanValue, false, 4, null);
        agentSession$check$2.$executor.invoke(C4109a.a(zBooleanValue));
        return Y8.t.f7040a;
    }
}
