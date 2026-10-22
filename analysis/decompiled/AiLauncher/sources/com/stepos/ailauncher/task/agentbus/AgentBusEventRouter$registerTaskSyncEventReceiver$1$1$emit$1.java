package com.stepos.ailauncher.task.agentbus;

import com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1$1", f = "AgentBusEventRouter.kt", l = {740}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$registerTaskSyncEventReceiver$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentBusEventRouter$registerTaskSyncEventReceiver$1.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentBusEventRouter$registerTaskSyncEventReceiver$1$1$emit$1(AgentBusEventRouter$registerTaskSyncEventReceiver$1.AnonymousClass1<? super T> anonymousClass1, InterfaceC4014c<? super AgentBusEventRouter$registerTaskSyncEventReceiver$1$1$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
