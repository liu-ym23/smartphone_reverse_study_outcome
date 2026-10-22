package com.stepos.agentbus.config;

import fi.iki.elonen.NanoHTTPD;
import kotlin.Metadata;
import q7.f;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentbus/config/InvocationMapperConfig;", "", "ttlMs", "", "maxEntries", "", "<init>", "(JI)V", "getTtlMs", "()J", "getMaxEntries", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class InvocationMapperConfig {
    private final int maxEntries;
    private final long ttlMs;

    public InvocationMapperConfig() {
        this(0L, 0, 3, null);
    }

    public static /* synthetic */ InvocationMapperConfig copy$default(InvocationMapperConfig invocationMapperConfig, long j2, int i2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j2 = invocationMapperConfig.ttlMs;
        }
        if ((i10 & 2) != 0) {
            i2 = invocationMapperConfig.maxEntries;
        }
        return invocationMapperConfig.copy(j2, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTtlMs() {
        return this.ttlMs;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxEntries() {
        return this.maxEntries;
    }

    public final InvocationMapperConfig copy(long ttlMs, int maxEntries) {
        return new InvocationMapperConfig(ttlMs, maxEntries);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvocationMapperConfig)) {
            return false;
        }
        InvocationMapperConfig invocationMapperConfig = (InvocationMapperConfig) other;
        return this.ttlMs == invocationMapperConfig.ttlMs && this.maxEntries == invocationMapperConfig.maxEntries;
    }

    public final int getMaxEntries() {
        return this.maxEntries;
    }

    public final long getTtlMs() {
        return this.ttlMs;
    }

    public int hashCode() {
        return Integer.hashCode(this.maxEntries) + (Long.hashCode(this.ttlMs) * 31);
    }

    public String toString() {
        return "InvocationMapperConfig(ttlMs=" + this.ttlMs + ", maxEntries=" + this.maxEntries + ")";
    }

    public InvocationMapperConfig(long j2, int i2) {
        this.ttlMs = j2;
        this.maxEntries = i2;
    }

    public /* synthetic */ InvocationMapperConfig(long j2, int i2, int i10, f fVar) {
        this((i10 & 1) != 0 ? 600000L : j2, (i10 & 2) != 0 ? NanoHTTPD.SOCKET_READ_TIMEOUT : i2);
    }
}
