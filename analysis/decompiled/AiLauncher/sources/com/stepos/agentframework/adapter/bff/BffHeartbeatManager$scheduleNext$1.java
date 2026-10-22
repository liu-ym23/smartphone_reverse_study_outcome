package com.stepos.agentframework.adapter.bff;

import Ua.M;
import Ua.U;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.bff.BffHeartbeatManager$scheduleNext$1", f = "BffHeartbeatManager.kt", l = {42}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class BffHeartbeatManager$scheduleNext$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BffHeartbeatManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BffHeartbeatManager$scheduleNext$1(BffHeartbeatManager bffHeartbeatManager, InterfaceC4014c<? super BffHeartbeatManager$scheduleNext$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = bffHeartbeatManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        BffHeartbeatManager$scheduleNext$1 bffHeartbeatManager$scheduleNext$1 = new BffHeartbeatManager$scheduleNext$1(this.this$0, interfaceC4014c);
        bffHeartbeatManager$scheduleNext$1.L$0 = obj;
        return bffHeartbeatManager$scheduleNext$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BffHeartbeatManager$scheduleNext$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.this$0.onRemoveNullCallbacks.invoke();
            long j10 = this.this$0.heartTimeout;
            this.L$0 = m10;
            this.label = 1;
            if (U.a(j10, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (kotlinx.coroutines.d.h(m10)) {
            this.this$0.onSendHeartbeat.invoke();
        }
        return Y8.t.f7040a;
    }
}
