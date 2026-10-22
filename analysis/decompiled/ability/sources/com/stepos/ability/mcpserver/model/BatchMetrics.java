package com.stepos.ability.mcpserver.model;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/stepos/ability/mcpserver/model/BatchMetrics;", "", "totalTimeMs", "", "successCount", "", "failedCount", AppAgent.CONSTRUCT, "(JII)V", "getTotalTimeMs", "()J", "getSuccessCount", "()I", "getFailedCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BatchMetrics {
    private final int failedCount;
    private final int successCount;
    private final long totalTimeMs;

    public BatchMetrics(long j5, int i, int i6) {
        this.totalTimeMs = j5;
        this.successCount = i;
        this.failedCount = i6;
    }

    public static /* synthetic */ BatchMetrics copy$default(BatchMetrics batchMetrics, long j5, int i, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j5 = batchMetrics.totalTimeMs;
        }
        if ((i10 & 2) != 0) {
            i = batchMetrics.successCount;
        }
        if ((i10 & 4) != 0) {
            i6 = batchMetrics.failedCount;
        }
        return batchMetrics.copy(j5, i, i6);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTotalTimeMs() {
        return this.totalTimeMs;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSuccessCount() {
        return this.successCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFailedCount() {
        return this.failedCount;
    }

    public final BatchMetrics copy(long totalTimeMs, int successCount, int failedCount) {
        return new BatchMetrics(totalTimeMs, successCount, failedCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchMetrics)) {
            return false;
        }
        BatchMetrics batchMetrics = (BatchMetrics) other;
        return this.totalTimeMs == batchMetrics.totalTimeMs && this.successCount == batchMetrics.successCount && this.failedCount == batchMetrics.failedCount;
    }

    public final int getFailedCount() {
        return this.failedCount;
    }

    public final int getSuccessCount() {
        return this.successCount;
    }

    public final long getTotalTimeMs() {
        return this.totalTimeMs;
    }

    public int hashCode() {
        return Integer.hashCode(this.failedCount) + a.a(this.successCount, Long.hashCode(this.totalTimeMs) * 31, 31);
    }

    public String toString() {
        return "BatchMetrics(totalTimeMs=" + this.totalTimeMs + ", successCount=" + this.successCount + ", failedCount=" + this.failedCount + ")";
    }
}
