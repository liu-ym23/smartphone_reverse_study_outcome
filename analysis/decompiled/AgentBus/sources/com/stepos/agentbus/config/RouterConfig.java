package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentbus/config/RouterConfig;", "", "onlineStableWindowMs", "", "maxOfflineDurationForFlushMs", "<init>", "(JJ)V", "getOnlineStableWindowMs", "()J", "getMaxOfflineDurationForFlushMs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RouterConfig {
    private final long maxOfflineDurationForFlushMs;
    private final long onlineStableWindowMs;

    public RouterConfig() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ RouterConfig copy$default(RouterConfig routerConfig, long j2, long j4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = routerConfig.onlineStableWindowMs;
        }
        if ((i2 & 2) != 0) {
            j4 = routerConfig.maxOfflineDurationForFlushMs;
        }
        return routerConfig.copy(j2, j4);
    }

    /* renamed from: component1, reason: from getter */
    public final long getOnlineStableWindowMs() {
        return this.onlineStableWindowMs;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMaxOfflineDurationForFlushMs() {
        return this.maxOfflineDurationForFlushMs;
    }

    public final RouterConfig copy(long onlineStableWindowMs, long maxOfflineDurationForFlushMs) {
        return new RouterConfig(onlineStableWindowMs, maxOfflineDurationForFlushMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouterConfig)) {
            return false;
        }
        RouterConfig routerConfig = (RouterConfig) other;
        return this.onlineStableWindowMs == routerConfig.onlineStableWindowMs && this.maxOfflineDurationForFlushMs == routerConfig.maxOfflineDurationForFlushMs;
    }

    public final long getMaxOfflineDurationForFlushMs() {
        return this.maxOfflineDurationForFlushMs;
    }

    public final long getOnlineStableWindowMs() {
        return this.onlineStableWindowMs;
    }

    public int hashCode() {
        return Long.hashCode(this.maxOfflineDurationForFlushMs) + (Long.hashCode(this.onlineStableWindowMs) * 31);
    }

    public String toString() {
        return "RouterConfig(onlineStableWindowMs=" + this.onlineStableWindowMs + ", maxOfflineDurationForFlushMs=" + this.maxOfflineDurationForFlushMs + ")";
    }

    public RouterConfig(long j2, long j4) {
        this.onlineStableWindowMs = j2;
        this.maxOfflineDurationForFlushMs = j4;
    }

    public /* synthetic */ RouterConfig(long j2, long j4, int i2, f fVar) {
        this((i2 & 1) != 0 ? 3000L : j2, (i2 & 2) != 0 ? 300000L : j4);
    }
}
