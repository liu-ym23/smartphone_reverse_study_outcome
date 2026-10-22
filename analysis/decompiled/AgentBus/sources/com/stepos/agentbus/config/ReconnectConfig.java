package com.stepos.agentbus.config;

import kotlin.Metadata;
import m.x;
import q7.f;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentbus/config/ReconnectConfig;", "", "initialDelayMs", "", "maxDelayMs", "backoffMultiplier", "", "<init>", "(JJD)V", "getInitialDelayMs", "()J", "getMaxDelayMs", "getBackoffMultiplier", "()D", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ReconnectConfig {
    private final double backoffMultiplier;
    private final long initialDelayMs;
    private final long maxDelayMs;

    public ReconnectConfig() {
        this(0L, 0L, 0.0d, 7, null);
    }

    public static /* synthetic */ ReconnectConfig copy$default(ReconnectConfig reconnectConfig, long j2, long j4, double d6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = reconnectConfig.initialDelayMs;
        }
        long j10 = j2;
        if ((i2 & 2) != 0) {
            j4 = reconnectConfig.maxDelayMs;
        }
        long j11 = j4;
        if ((i2 & 4) != 0) {
            d6 = reconnectConfig.backoffMultiplier;
        }
        return reconnectConfig.copy(j10, j11, d6);
    }

    /* renamed from: component1, reason: from getter */
    public final long getInitialDelayMs() {
        return this.initialDelayMs;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMaxDelayMs() {
        return this.maxDelayMs;
    }

    /* renamed from: component3, reason: from getter */
    public final double getBackoffMultiplier() {
        return this.backoffMultiplier;
    }

    public final ReconnectConfig copy(long initialDelayMs, long maxDelayMs, double backoffMultiplier) {
        return new ReconnectConfig(initialDelayMs, maxDelayMs, backoffMultiplier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReconnectConfig)) {
            return false;
        }
        ReconnectConfig reconnectConfig = (ReconnectConfig) other;
        return this.initialDelayMs == reconnectConfig.initialDelayMs && this.maxDelayMs == reconnectConfig.maxDelayMs && Double.compare(this.backoffMultiplier, reconnectConfig.backoffMultiplier) == 0;
    }

    public final double getBackoffMultiplier() {
        return this.backoffMultiplier;
    }

    public final long getInitialDelayMs() {
        return this.initialDelayMs;
    }

    public final long getMaxDelayMs() {
        return this.maxDelayMs;
    }

    public int hashCode() {
        return Double.hashCode(this.backoffMultiplier) + x.f(this.maxDelayMs, Long.hashCode(this.initialDelayMs) * 31, 31);
    }

    public String toString() {
        return "ReconnectConfig(initialDelayMs=" + this.initialDelayMs + ", maxDelayMs=" + this.maxDelayMs + ", backoffMultiplier=" + this.backoffMultiplier + ")";
    }

    public ReconnectConfig(long j2, long j4, double d6) {
        this.initialDelayMs = j2;
        this.maxDelayMs = j4;
        this.backoffMultiplier = d6;
    }

    public /* synthetic */ ReconnectConfig(long j2, long j4, double d6, int i2, f fVar) {
        this((i2 & 1) != 0 ? 1000L : j2, (i2 & 2) != 0 ? 60000L : j4, (i2 & 4) != 0 ? 2.0d : d6);
    }
}
