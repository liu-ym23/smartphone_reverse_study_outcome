package com.stepos.agentbus.generated;

import C7.r;
import J7.c;
import S7.n;
import android.net.LocalSocket;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$connectAndServe$idleJob$1", f = "AgentBusBindingBase.kt", l = {TypedValues.CycleType.TYPE_EASING}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AgentBusBindingBase$connectAndServe$idleJob$1 extends SuspendLambda implements n {
    final /* synthetic */ Ref$BooleanRef $idleTriggered;
    final /* synthetic */ LocalSocket $socket;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AgentBusBindingBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$connectAndServe$idleJob$1(AgentBusBindingBase agentBusBindingBase, Ref$BooleanRef ref$BooleanRef, LocalSocket localSocket, H7.c<? super AgentBusBindingBase$connectAndServe$idleJob$1> cVar) {
        super(2, cVar);
        this.this$0 = agentBusBindingBase;
        this.$idleTriggered = ref$BooleanRef;
        this.$socket = localSocket;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        AgentBusBindingBase$connectAndServe$idleJob$1 agentBusBindingBase$connectAndServe$idleJob$1 = new AgentBusBindingBase$connectAndServe$idleJob$1(this.this$0, this.$idleTriggered, this.$socket, cVar);
        agentBusBindingBase$connectAndServe$idleJob$1.L$0 = obj;
        return agentBusBindingBase$connectAndServe$idleJob$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long jMin;
        InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0 && i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.b.b(obj);
        do {
            boolean zL = AbstractC1683A.l(interfaceC1733z);
            r rVar = r.f317a;
            if (!zL) {
                return rVar;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.this$0.lastActivityMs;
            if (jCurrentTimeMillis >= this.this$0.idleTimeoutMs) {
                this.$idleTriggered.f4916a = true;
                try {
                    this.$socket.close();
                    return rVar;
                } catch (Throwable th) {
                    kotlin.b.a(th);
                    return rVar;
                }
            }
            long j5 = this.this$0.idleTimeoutMs - jCurrentTimeMillis;
            if (j5 < 1) {
                j5 = 1;
            }
            jMin = Math.min(j5, 10000L);
            this.L$0 = interfaceC1733z;
            this.J$0 = jCurrentTimeMillis;
            this.label = 1;
        } while (kotlinx.coroutines.a.f(jMin, this) != coroutineSingletons);
        return coroutineSingletons;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((AgentBusBindingBase$connectAndServe$idleJob$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
