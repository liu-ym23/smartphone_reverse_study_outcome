package com.stepos.agentframework.adapter.netcore;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/i;", "Lcom/stepos/agentframework/adapter/netcore/n;", "LKb/a;", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30739f, "<init>", "(LKb/a;)V", "", "reason", "", "cancel", "(Ljava/lang/String;)Z", "isCancelled", "()Z", UxipConstants.f30680s, "LKb/a;", "getEventSource", "()LKb/a;", "cancelled", "Z", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class i implements n {
    private volatile boolean cancelled;
    private Kb.a eventSource;

    public i(Kb.a eventSource) {
        kotlin.jvm.internal.p.i(eventSource, "eventSource");
        this.eventSource = eventSource;
    }

    @Override // com.stepos.agentframework.adapter.netcore.n
    public boolean cancel(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        if (this.cancelled) {
            return false;
        }
        this.cancelled = true;
        this.eventSource.cancel();
        return true;
    }

    @Override // com.stepos.agentframework.adapter.netcore.n
    /* renamed from: isCancelled, reason: from getter */
    public boolean getCancelled() {
        return this.cancelled;
    }
}
