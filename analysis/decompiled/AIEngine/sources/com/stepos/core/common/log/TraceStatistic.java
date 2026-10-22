package com.stepos.core.common.log;

import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TraceStatistic {
    private volatile long failCount;
    private volatile double maxDurationMs;
    private volatile double minDurationMs;
    private final String module;
    private final String operation;
    private volatile long successCount;
    private volatile long totalCount;
    private volatile double totalDurationMs;

    public TraceStatistic(String module, String operation) {
        g.f(module, "module");
        g.f(operation, "operation");
        this.module = module;
        this.operation = operation;
        this.minDurationMs = Double.MAX_VALUE;
    }

    public final synchronized void add(double d8, boolean z) {
        try {
            this.totalCount++;
            this.totalDurationMs += d8;
            if (d8 < this.minDurationMs) {
                this.minDurationMs = d8;
            }
            if (d8 > this.maxDurationMs) {
                this.maxDurationMs = d8;
            }
            if (z) {
                this.successCount++;
            } else {
                this.failCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final double getAvgDurationMs() {
        if (this.totalCount > 0) {
            return this.totalDurationMs / this.totalCount;
        }
        return 0.0d;
    }

    public final long getFailCount() {
        return this.failCount;
    }

    public final double getMaxDurationMs() {
        return this.maxDurationMs;
    }

    public final double getMinDurationMs() {
        return this.minDurationMs;
    }

    public final String getModule() {
        return this.module;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final long getSuccessCount() {
        return this.successCount;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }

    public final double getTotalDurationMs() {
        return this.totalDurationMs;
    }

    public String toString() {
        String str = this.module;
        String str2 = this.operation;
        long j10 = this.totalCount;
        String str3 = String.format(ai.onnxruntime.a.h(this.failCount, "avg=%.2fms, min=%.2fms, max=%.2fms, fail=", ")"), Arrays.copyOf(new Object[]{Double.valueOf(getAvgDurationMs()), Double.valueOf(this.minDurationMs), Double.valueOf(this.maxDurationMs)}, 3));
        StringBuilder sbS = ai.onnxruntime.a.s("TraceStatistic(op=", str, ":", str2, ", count=");
        sbS.append(j10);
        sbS.append(", ");
        sbS.append(str3);
        return sbS.toString();
    }
}
