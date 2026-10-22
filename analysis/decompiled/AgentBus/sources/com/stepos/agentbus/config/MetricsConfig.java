package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentbus/config/MetricsConfig;", "", "aggregationIntervalMs", "", "localBufferMaxEntries", "", "<init>", "(JI)V", "getAggregationIntervalMs", "()J", "getLocalBufferMaxEntries", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MetricsConfig {
    private final long aggregationIntervalMs;
    private final int localBufferMaxEntries;

    public MetricsConfig() {
        this(0L, 0, 3, null);
    }

    public static /* synthetic */ MetricsConfig copy$default(MetricsConfig metricsConfig, long j2, int i2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j2 = metricsConfig.aggregationIntervalMs;
        }
        if ((i10 & 2) != 0) {
            i2 = metricsConfig.localBufferMaxEntries;
        }
        return metricsConfig.copy(j2, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getAggregationIntervalMs() {
        return this.aggregationIntervalMs;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLocalBufferMaxEntries() {
        return this.localBufferMaxEntries;
    }

    public final MetricsConfig copy(long aggregationIntervalMs, int localBufferMaxEntries) {
        return new MetricsConfig(aggregationIntervalMs, localBufferMaxEntries);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetricsConfig)) {
            return false;
        }
        MetricsConfig metricsConfig = (MetricsConfig) other;
        return this.aggregationIntervalMs == metricsConfig.aggregationIntervalMs && this.localBufferMaxEntries == metricsConfig.localBufferMaxEntries;
    }

    public final long getAggregationIntervalMs() {
        return this.aggregationIntervalMs;
    }

    public final int getLocalBufferMaxEntries() {
        return this.localBufferMaxEntries;
    }

    public int hashCode() {
        return Integer.hashCode(this.localBufferMaxEntries) + (Long.hashCode(this.aggregationIntervalMs) * 31);
    }

    public String toString() {
        return "MetricsConfig(aggregationIntervalMs=" + this.aggregationIntervalMs + ", localBufferMaxEntries=" + this.localBufferMaxEntries + ")";
    }

    public MetricsConfig(long j2, int i2) {
        this.aggregationIntervalMs = j2;
        this.localBufferMaxEntries = i2;
    }

    public /* synthetic */ MetricsConfig(long j2, int i2, int i10, f fVar) {
        this((i10 & 1) != 0 ? 60000L : j2, (i10 & 2) != 0 ? 1440 : i2);
    }
}
