package com.stepos.core.model.resilience;

import a0.a;
import h0.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FlowStatistics {
    private final int availablePermits;
    private final int currentConcurrent;
    private final int maxConcurrent;
    private final int queueLength;
    private final long rejectedCount;
    private final long totalAcquires;

    public FlowStatistics(int i10, int i11, int i12, int i13, long j10, long j11) {
        this.maxConcurrent = i10;
        this.currentConcurrent = i11;
        this.availablePermits = i12;
        this.queueLength = i13;
        this.totalAcquires = j10;
        this.rejectedCount = j11;
    }

    public static /* synthetic */ FlowStatistics copy$default(FlowStatistics flowStatistics, int i10, int i11, int i12, int i13, long j10, long j11, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = flowStatistics.maxConcurrent;
        }
        if ((i14 & 2) != 0) {
            i11 = flowStatistics.currentConcurrent;
        }
        if ((i14 & 4) != 0) {
            i12 = flowStatistics.availablePermits;
        }
        if ((i14 & 8) != 0) {
            i13 = flowStatistics.queueLength;
        }
        if ((i14 & 16) != 0) {
            j10 = flowStatistics.totalAcquires;
        }
        if ((i14 & 32) != 0) {
            j11 = flowStatistics.rejectedCount;
        }
        long j12 = j11;
        long j13 = j10;
        return flowStatistics.copy(i10, i11, i12, i13, j13, j12);
    }

    public final int component1() {
        return this.maxConcurrent;
    }

    public final int component2() {
        return this.currentConcurrent;
    }

    public final int component3() {
        return this.availablePermits;
    }

    public final int component4() {
        return this.queueLength;
    }

    public final long component5() {
        return this.totalAcquires;
    }

    public final long component6() {
        return this.rejectedCount;
    }

    public final FlowStatistics copy(int i10, int i11, int i12, int i13, long j10, long j11) {
        return new FlowStatistics(i10, i11, i12, i13, j10, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowStatistics)) {
            return false;
        }
        FlowStatistics flowStatistics = (FlowStatistics) obj;
        return this.maxConcurrent == flowStatistics.maxConcurrent && this.currentConcurrent == flowStatistics.currentConcurrent && this.availablePermits == flowStatistics.availablePermits && this.queueLength == flowStatistics.queueLength && this.totalAcquires == flowStatistics.totalAcquires && this.rejectedCount == flowStatistics.rejectedCount;
    }

    public final int getAvailablePermits() {
        return this.availablePermits;
    }

    public final int getCurrentConcurrent() {
        return this.currentConcurrent;
    }

    public final int getMaxConcurrent() {
        return this.maxConcurrent;
    }

    public final int getQueueLength() {
        return this.queueLength;
    }

    public final long getRejectedCount() {
        return this.rejectedCount;
    }

    public final float getRejectionRate() {
        long j10 = this.totalAcquires;
        if (j10 > 0) {
            return this.rejectedCount / j10;
        }
        return 0.0f;
    }

    public final long getTotalAcquires() {
        return this.totalAcquires;
    }

    public int hashCode() {
        return Long.hashCode(this.rejectedCount) + a.c(ai.onnxruntime.a.d(this.queueLength, ai.onnxruntime.a.d(this.availablePermits, ai.onnxruntime.a.d(this.currentConcurrent, Integer.hashCode(this.maxConcurrent) * 31, 31), 31), 31), this.totalAcquires, 31);
    }

    public String toString() {
        int i10 = this.maxConcurrent;
        int i11 = this.currentConcurrent;
        int i12 = this.availablePermits;
        int i13 = this.queueLength;
        long j10 = this.totalAcquires;
        long j11 = this.rejectedCount;
        StringBuilder sbD = e.d(i10, "FlowStatistics(maxConcurrent=", i11, ", currentConcurrent=", ", availablePermits=");
        e.l(sbD, i12, ", queueLength=", i13, ", totalAcquires=");
        sbD.append(j10);
        return a.d(j11, ", rejectedCount=", ")", sbD);
    }
}
