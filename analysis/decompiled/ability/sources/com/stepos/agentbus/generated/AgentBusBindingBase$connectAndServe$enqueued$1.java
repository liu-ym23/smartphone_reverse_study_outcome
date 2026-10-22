package com.stepos.agentbus.generated;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import o9.InterfaceC1779e;
import org.json.JSONObject;

@c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$connectAndServe$enqueued$1", f = "AgentBusBindingBase.kt", l = {499}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AgentBusBindingBase$connectAndServe$enqueued$1 extends SuspendLambda implements n {
    final /* synthetic */ JSONObject $frame;
    final /* synthetic */ InterfaceC1779e $inboundQueue;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$connectAndServe$enqueued$1(InterfaceC1779e interfaceC1779e, JSONObject jSONObject, H7.c<? super AgentBusBindingBase$connectAndServe$enqueued$1> cVar) {
        super(2, cVar);
        this.$inboundQueue = interfaceC1779e;
        this.$frame = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new AgentBusBindingBase$connectAndServe$enqueued$1(this.$inboundQueue, this.$frame, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            InterfaceC1779e interfaceC1779e = this.$inboundQueue;
            JSONObject jSONObject = this.$frame;
            this.label = 1;
            if (interfaceC1779e.p(this, jSONObject) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return Boolean.TRUE;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
        return ((AgentBusBindingBase$connectAndServe$enqueued$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
