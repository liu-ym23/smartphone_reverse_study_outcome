package com.stepos.core.common.log;

import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PerfStatistic {
    private long count;
    private double maxMs;
    private double minMs;
    private final String operation;
    private double totalMs;

    public PerfStatistic(String operation) {
        g.f(operation, "operation");
        this.operation = operation;
        this.minMs = Double.MAX_VALUE;
    }

    public final synchronized void add(double d8) {
        try {
            this.count++;
            this.totalMs += d8;
            if (d8 < this.minMs) {
                this.minMs = d8;
            }
            if (d8 > this.maxMs) {
                this.maxMs = d8;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final double getAvgMs() {
        long j10 = this.count;
        if (j10 > 0) {
            return this.totalMs / j10;
        }
        return 0.0d;
    }

    public final String getOperation() {
        return this.operation;
    }

    public String toString() {
        StringBuilder sbL = com.stepos.core.ota.d.l("PerfStatistic(op=", this.count, this.operation, ", count=");
        sbL.append(", avg=%.2f ms, min=%.2f ms, max=%.2f ms)");
        return String.format(sbL.toString(), Arrays.copyOf(new Object[]{Double.valueOf(getAvgMs()), Double.valueOf(this.minMs), Double.valueOf(this.maxMs)}, 3));
    }
}
