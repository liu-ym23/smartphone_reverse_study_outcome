package com.stepos.core.performance.data;

import ai.onnxruntime.a;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import p6.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PerformanceRequestContext {
    private final b abilityType;
    private final boolean callerForeground;
    private final long modelHardCeilingMs;
    private final String modelId;
    private final TaskPriority requestPriority;
    private final int requestedMaxBatchSize;
    private final int requestedMaxTokens;
    private final long requestedTimeoutMs;

    public PerformanceRequestContext(String modelId, TaskPriority requestPriority, b abilityType, int i10, int i11, long j10, boolean z, long j11) {
        g.f(modelId, "modelId");
        g.f(requestPriority, "requestPriority");
        g.f(abilityType, "abilityType");
        this.modelId = modelId;
        this.requestPriority = requestPriority;
        this.abilityType = abilityType;
        this.requestedMaxTokens = i10;
        this.requestedMaxBatchSize = i11;
        this.requestedTimeoutMs = j10;
        this.callerForeground = z;
        this.modelHardCeilingMs = j11;
    }

    public static /* synthetic */ PerformanceRequestContext copy$default(PerformanceRequestContext performanceRequestContext, String str, TaskPriority taskPriority, b bVar, int i10, int i11, long j10, boolean z, long j11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = performanceRequestContext.modelId;
        }
        if ((i12 & 2) != 0) {
            taskPriority = performanceRequestContext.requestPriority;
        }
        if ((i12 & 4) != 0) {
            bVar = performanceRequestContext.abilityType;
        }
        if ((i12 & 8) != 0) {
            i10 = performanceRequestContext.requestedMaxTokens;
        }
        if ((i12 & 16) != 0) {
            i11 = performanceRequestContext.requestedMaxBatchSize;
        }
        if ((i12 & 32) != 0) {
            j10 = performanceRequestContext.requestedTimeoutMs;
        }
        if ((i12 & 64) != 0) {
            z = performanceRequestContext.callerForeground;
        }
        if ((i12 & TraceIdKeys.MAX_LENGTH) != 0) {
            j11 = performanceRequestContext.modelHardCeilingMs;
        }
        boolean z3 = z;
        long j12 = j10;
        int i13 = i10;
        int i14 = i11;
        b bVar2 = bVar;
        return performanceRequestContext.copy(str, taskPriority, bVar2, i13, i14, j12, z3, j11);
    }

    public final String component1() {
        return this.modelId;
    }

    public final TaskPriority component2() {
        return this.requestPriority;
    }

    public final b component3() {
        return this.abilityType;
    }

    public final int component4() {
        return this.requestedMaxTokens;
    }

    public final int component5() {
        return this.requestedMaxBatchSize;
    }

    public final long component6() {
        return this.requestedTimeoutMs;
    }

    public final boolean component7() {
        return this.callerForeground;
    }

    public final long component8() {
        return this.modelHardCeilingMs;
    }

    public final PerformanceRequestContext copy(String modelId, TaskPriority requestPriority, b abilityType, int i10, int i11, long j10, boolean z, long j11) {
        g.f(modelId, "modelId");
        g.f(requestPriority, "requestPriority");
        g.f(abilityType, "abilityType");
        return new PerformanceRequestContext(modelId, requestPriority, abilityType, i10, i11, j10, z, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PerformanceRequestContext)) {
            return false;
        }
        PerformanceRequestContext performanceRequestContext = (PerformanceRequestContext) obj;
        return g.b(this.modelId, performanceRequestContext.modelId) && this.requestPriority == performanceRequestContext.requestPriority && g.b(this.abilityType, performanceRequestContext.abilityType) && this.requestedMaxTokens == performanceRequestContext.requestedMaxTokens && this.requestedMaxBatchSize == performanceRequestContext.requestedMaxBatchSize && this.requestedTimeoutMs == performanceRequestContext.requestedTimeoutMs && this.callerForeground == performanceRequestContext.callerForeground && this.modelHardCeilingMs == performanceRequestContext.modelHardCeilingMs;
    }

    public final b getAbilityType() {
        return this.abilityType;
    }

    public final boolean getCallerForeground() {
        return this.callerForeground;
    }

    public final long getModelHardCeilingMs() {
        return this.modelHardCeilingMs;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final TaskPriority getRequestPriority() {
        return this.requestPriority;
    }

    public final int getRequestedMaxBatchSize() {
        return this.requestedMaxBatchSize;
    }

    public final int getRequestedMaxTokens() {
        return this.requestedMaxTokens;
    }

    public final long getRequestedTimeoutMs() {
        return this.requestedTimeoutMs;
    }

    public int hashCode() {
        return Long.hashCode(this.modelHardCeilingMs) + a.f(a0.a.c(a.d(this.requestedMaxBatchSize, a.d(this.requestedMaxTokens, (this.abilityType.hashCode() + ((this.requestPriority.hashCode() + (this.modelId.hashCode() * 31)) * 31)) * 31, 31), 31), this.requestedTimeoutMs, 31), 31, this.callerForeground);
    }

    public String toString() {
        String str = this.modelId;
        TaskPriority taskPriority = this.requestPriority;
        b bVar = this.abilityType;
        int i10 = this.requestedMaxTokens;
        int i11 = this.requestedMaxBatchSize;
        long j10 = this.requestedTimeoutMs;
        boolean z = this.callerForeground;
        long j11 = this.modelHardCeilingMs;
        StringBuilder sb2 = new StringBuilder("PerformanceRequestContext(modelId=");
        sb2.append(str);
        sb2.append(", requestPriority=");
        sb2.append(taskPriority);
        sb2.append(", abilityType=");
        sb2.append(bVar);
        sb2.append(", requestedMaxTokens=");
        sb2.append(i10);
        sb2.append(", requestedMaxBatchSize=");
        d.s(sb2, i11, ", requestedTimeoutMs=", j10);
        sb2.append(", callerForeground=");
        sb2.append(z);
        sb2.append(", modelHardCeilingMs=");
        return a.m(sb2, j11, ")");
    }

    public /* synthetic */ PerformanceRequestContext(String str, TaskPriority taskPriority, b bVar, int i10, int i11, long j10, boolean z, long j11, int i12, e eVar) {
        this(str, taskPriority, bVar, i10, i11, j10, (i12 & 64) != 0 ? false : z, (i12 & TraceIdKeys.MAX_LENGTH) != 0 ? 30000L : j11);
    }
}
