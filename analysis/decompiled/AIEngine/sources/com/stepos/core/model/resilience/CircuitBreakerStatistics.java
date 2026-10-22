package com.stepos.core.model.resilience;

import ai.onnxruntime.a;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CircuitBreakerStatistics {
    private final int failureCount;
    private final int failureThreshold;
    private final long resetTimeoutMs;
    private final String state;
    private final int successCount;
    private final long totalCalls;
    private final long totalCircuitOpens;
    private final long totalFailures;

    public CircuitBreakerStatistics(String state, int i10, int i11, long j10, long j11, long j12, int i12, long j13) {
        g.f(state, "state");
        this.state = state;
        this.failureCount = i10;
        this.successCount = i11;
        this.totalCalls = j10;
        this.totalFailures = j11;
        this.totalCircuitOpens = j12;
        this.failureThreshold = i12;
        this.resetTimeoutMs = j13;
    }

    public static /* synthetic */ CircuitBreakerStatistics copy$default(CircuitBreakerStatistics circuitBreakerStatistics, String str, int i10, int i11, long j10, long j11, long j12, int i12, long j13, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = circuitBreakerStatistics.state;
        }
        if ((i13 & 2) != 0) {
            i10 = circuitBreakerStatistics.failureCount;
        }
        if ((i13 & 4) != 0) {
            i11 = circuitBreakerStatistics.successCount;
        }
        if ((i13 & 8) != 0) {
            j10 = circuitBreakerStatistics.totalCalls;
        }
        if ((i13 & 16) != 0) {
            j11 = circuitBreakerStatistics.totalFailures;
        }
        if ((i13 & 32) != 0) {
            j12 = circuitBreakerStatistics.totalCircuitOpens;
        }
        if ((i13 & 64) != 0) {
            i12 = circuitBreakerStatistics.failureThreshold;
        }
        if ((i13 & TraceIdKeys.MAX_LENGTH) != 0) {
            j13 = circuitBreakerStatistics.resetTimeoutMs;
        }
        int i14 = i12;
        long j14 = j12;
        long j15 = j11;
        long j16 = j10;
        int i15 = i11;
        return circuitBreakerStatistics.copy(str, i10, i15, j16, j15, j14, i14, j13);
    }

    public final String component1() {
        return this.state;
    }

    public final int component2() {
        return this.failureCount;
    }

    public final int component3() {
        return this.successCount;
    }

    public final long component4() {
        return this.totalCalls;
    }

    public final long component5() {
        return this.totalFailures;
    }

    public final long component6() {
        return this.totalCircuitOpens;
    }

    public final int component7() {
        return this.failureThreshold;
    }

    public final long component8() {
        return this.resetTimeoutMs;
    }

    public final CircuitBreakerStatistics copy(String state, int i10, int i11, long j10, long j11, long j12, int i12, long j13) {
        g.f(state, "state");
        return new CircuitBreakerStatistics(state, i10, i11, j10, j11, j12, i12, j13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CircuitBreakerStatistics)) {
            return false;
        }
        CircuitBreakerStatistics circuitBreakerStatistics = (CircuitBreakerStatistics) obj;
        return g.b(this.state, circuitBreakerStatistics.state) && this.failureCount == circuitBreakerStatistics.failureCount && this.successCount == circuitBreakerStatistics.successCount && this.totalCalls == circuitBreakerStatistics.totalCalls && this.totalFailures == circuitBreakerStatistics.totalFailures && this.totalCircuitOpens == circuitBreakerStatistics.totalCircuitOpens && this.failureThreshold == circuitBreakerStatistics.failureThreshold && this.resetTimeoutMs == circuitBreakerStatistics.resetTimeoutMs;
    }

    public final int getFailureCount() {
        return this.failureCount;
    }

    public final float getFailureRate() {
        long j10 = this.totalCalls;
        if (j10 > 0) {
            return this.totalFailures / j10;
        }
        return 0.0f;
    }

    public final int getFailureThreshold() {
        return this.failureThreshold;
    }

    public final long getResetTimeoutMs() {
        return this.resetTimeoutMs;
    }

    public final String getState() {
        return this.state;
    }

    public final int getSuccessCount() {
        return this.successCount;
    }

    public final long getTotalCalls() {
        return this.totalCalls;
    }

    public final long getTotalCircuitOpens() {
        return this.totalCircuitOpens;
    }

    public final long getTotalFailures() {
        return this.totalFailures;
    }

    public int hashCode() {
        return Long.hashCode(this.resetTimeoutMs) + a.d(this.failureThreshold, a0.a.c(a0.a.c(a0.a.c(a.d(this.successCount, a.d(this.failureCount, this.state.hashCode() * 31, 31), 31), this.totalCalls, 31), this.totalFailures, 31), this.totalCircuitOpens, 31), 31);
    }

    public String toString() {
        String str = this.state;
        int i10 = this.failureCount;
        int i11 = this.successCount;
        long j10 = this.totalCalls;
        long j11 = this.totalFailures;
        long j12 = this.totalCircuitOpens;
        int i12 = this.failureThreshold;
        long j13 = this.resetTimeoutMs;
        StringBuilder sbF = e.f("CircuitBreakerStatistics(state=", str, ", failureCount=", i10, ", successCount=");
        d.s(sbF, i11, ", totalCalls=", j10);
        a0.a.s(j11, ", totalFailures=", ", totalCircuitOpens=", sbF);
        sbF.append(j12);
        sbF.append(", failureThreshold=");
        sbF.append(i12);
        return a0.a.d(j13, ", resetTimeoutMs=", ")", sbF);
    }
}
