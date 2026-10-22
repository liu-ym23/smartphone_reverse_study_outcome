package com.stepos.ability.mcpserver.model;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/stepos/ability/mcpserver/model/BatchRequest;", "", "tasks", "", "Lcom/stepos/ability/mcpserver/model/BatchTask;", "timeoutMs", "", AppAgent.CONSTRUCT, "(Ljava/util/List;Ljava/lang/Long;)V", "getTasks", "()Ljava/util/List;", "getTimeoutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Long;)Lcom/stepos/ability/mcpserver/model/BatchRequest;", "equals", "", "other", "hashCode", "", "toString", "", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BatchRequest {
    private final List<BatchTask> tasks;
    private final Long timeoutMs;

    public BatchRequest(List<BatchTask> tasks, Long l) {
        k.f(tasks, "tasks");
        this.tasks = tasks;
        this.timeoutMs = l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchRequest copy$default(BatchRequest batchRequest, List list, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            list = batchRequest.tasks;
        }
        if ((i & 2) != 0) {
            l = batchRequest.timeoutMs;
        }
        return batchRequest.copy(list, l);
    }

    public final List<BatchTask> component1() {
        return this.tasks;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final BatchRequest copy(List<BatchTask> tasks, Long timeoutMs) {
        k.f(tasks, "tasks");
        return new BatchRequest(tasks, timeoutMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchRequest)) {
            return false;
        }
        BatchRequest batchRequest = (BatchRequest) other;
        return k.b(this.tasks, batchRequest.tasks) && k.b(this.timeoutMs, batchRequest.timeoutMs);
    }

    public final List<BatchTask> getTasks() {
        return this.tasks;
    }

    public final Long getTimeoutMs() {
        return this.timeoutMs;
    }

    public int hashCode() {
        int iHashCode = this.tasks.hashCode() * 31;
        Long l = this.timeoutMs;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "BatchRequest(tasks=" + this.tasks + ", timeoutMs=" + this.timeoutMs + ")";
    }

    public /* synthetic */ BatchRequest(List list, Long l, int i, e eVar) {
        this(list, (i & 2) != 0 ? 60000L : l);
    }
}
