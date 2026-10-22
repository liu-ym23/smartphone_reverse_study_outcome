package com.stepos.agentframework.adapter.netcore;

import J9.i;
import U9.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/EventSourceState;", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "LU9/a;", "eventSource", AppAgent.CONSTRUCT, "(LU9/a;)V", "", "cancel", "()Z", "isCancelled", "value", "LU9/a;", "getEventSource", "()LU9/a;", "cancelled", "Z", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EventSourceState implements ICancelHandle {
    private volatile boolean cancelled;
    private a eventSource;

    public EventSourceState(a eventSource) {
        k.f(eventSource, "eventSource");
        this.eventSource = eventSource;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICancelHandle
    public boolean cancel() {
        if (this.cancelled) {
            return false;
        }
        this.cancelled = true;
        i iVar = ((R9.a) this.eventSource).f1160a;
        if (iVar != null) {
            iVar.cancel();
            return true;
        }
        k.n("call");
        throw null;
    }

    public final a getEventSource() {
        return this.eventSource;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICancelHandle
    /* renamed from: isCancelled, reason: from getter */
    public boolean getCancelled() {
        return this.cancelled;
    }
}
