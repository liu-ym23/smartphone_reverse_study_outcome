package com.stepos.ability.mcpserver.model;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/stepos/ability/mcpserver/model/BatchResult;", "", "requestId", "", "taskResults", "", "Lcom/stepos/ability/mcpserver/model/TaskResult;", "metrics", "Lcom/stepos/ability/mcpserver/model/BatchMetrics;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;Lcom/stepos/ability/mcpserver/model/BatchMetrics;)V", "getRequestId", "()Ljava/lang/String;", "getTaskResults", "()Ljava/util/Map;", "getMetrics", "()Lcom/stepos/ability/mcpserver/model/BatchMetrics;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BatchResult {
    private final BatchMetrics metrics;
    private final String requestId;
    private final Map<String, TaskResult> taskResults;

    public BatchResult(String requestId, Map<String, TaskResult> taskResults, BatchMetrics metrics) {
        k.f(requestId, "requestId");
        k.f(taskResults, "taskResults");
        k.f(metrics, "metrics");
        this.requestId = requestId;
        this.taskResults = taskResults;
        this.metrics = metrics;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchResult copy$default(BatchResult batchResult, String str, Map map, BatchMetrics batchMetrics, int i, Object obj) {
        if ((i & 1) != 0) {
            str = batchResult.requestId;
        }
        if ((i & 2) != 0) {
            map = batchResult.taskResults;
        }
        if ((i & 4) != 0) {
            batchMetrics = batchResult.metrics;
        }
        return batchResult.copy(str, map, batchMetrics);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public final Map<String, TaskResult> component2() {
        return this.taskResults;
    }

    /* renamed from: component3, reason: from getter */
    public final BatchMetrics getMetrics() {
        return this.metrics;
    }

    public final BatchResult copy(String requestId, Map<String, TaskResult> taskResults, BatchMetrics metrics) {
        k.f(requestId, "requestId");
        k.f(taskResults, "taskResults");
        k.f(metrics, "metrics");
        return new BatchResult(requestId, taskResults, metrics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchResult)) {
            return false;
        }
        BatchResult batchResult = (BatchResult) other;
        return k.b(this.requestId, batchResult.requestId) && k.b(this.taskResults, batchResult.taskResults) && k.b(this.metrics, batchResult.metrics);
    }

    public final BatchMetrics getMetrics() {
        return this.metrics;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Map<String, TaskResult> getTaskResults() {
        return this.taskResults;
    }

    public int hashCode() {
        return this.metrics.hashCode() + a.f(this.taskResults, this.requestId.hashCode() * 31, 31);
    }

    public String toString() {
        return "BatchResult(requestId=" + this.requestId + ", taskResults=" + this.taskResults + ", metrics=" + this.metrics + ")";
    }
}
