package com.stepos.ability.mcpserver.model;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/stepos/ability/mcpserver/model/ExecutionPlan;", "", "requestId", "", "layers", "", "Lcom/stepos/ability/mcpserver/model/ExecutionLayer;", "totalTimeoutMs", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/List;J)V", "getRequestId", "()Ljava/lang/String;", "getLayers", "()Ljava/util/List;", "getTotalTimeoutMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExecutionPlan {
    private final List<ExecutionLayer> layers;
    private final String requestId;
    private final long totalTimeoutMs;

    public ExecutionPlan(String requestId, List<ExecutionLayer> layers, long j5) {
        k.f(requestId, "requestId");
        k.f(layers, "layers");
        this.requestId = requestId;
        this.layers = layers;
        this.totalTimeoutMs = j5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExecutionPlan copy$default(ExecutionPlan executionPlan, String str, List list, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = executionPlan.requestId;
        }
        if ((i & 2) != 0) {
            list = executionPlan.layers;
        }
        if ((i & 4) != 0) {
            j5 = executionPlan.totalTimeoutMs;
        }
        return executionPlan.copy(str, list, j5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public final List<ExecutionLayer> component2() {
        return this.layers;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTotalTimeoutMs() {
        return this.totalTimeoutMs;
    }

    public final ExecutionPlan copy(String requestId, List<ExecutionLayer> layers, long totalTimeoutMs) {
        k.f(requestId, "requestId");
        k.f(layers, "layers");
        return new ExecutionPlan(requestId, layers, totalTimeoutMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExecutionPlan)) {
            return false;
        }
        ExecutionPlan executionPlan = (ExecutionPlan) other;
        return k.b(this.requestId, executionPlan.requestId) && k.b(this.layers, executionPlan.layers) && this.totalTimeoutMs == executionPlan.totalTimeoutMs;
    }

    public final List<ExecutionLayer> getLayers() {
        return this.layers;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final long getTotalTimeoutMs() {
        return this.totalTimeoutMs;
    }

    public int hashCode() {
        return Long.hashCode(this.totalTimeoutMs) + a.e(this.layers, this.requestId.hashCode() * 31, 31);
    }

    public String toString() {
        String str = this.requestId;
        List<ExecutionLayer> list = this.layers;
        long j5 = this.totalTimeoutMs;
        StringBuilder sb = new StringBuilder("ExecutionPlan(requestId=");
        sb.append(str);
        sb.append(", layers=");
        sb.append(list);
        sb.append(", totalTimeoutMs=");
        return androidx.constraintlayout.core.dsl.a.e(j5, ")", sb);
    }
}
