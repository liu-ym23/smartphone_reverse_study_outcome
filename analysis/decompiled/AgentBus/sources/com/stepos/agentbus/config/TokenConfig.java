package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentbus/config/TokenConfig;", "", "refreshBeforeExpiryMs", "", "<init>", "(J)V", "getRefreshBeforeExpiryMs", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TokenConfig {
    private final long refreshBeforeExpiryMs;

    public TokenConfig() {
        this(0L, 1, null);
    }

    public static /* synthetic */ TokenConfig copy$default(TokenConfig tokenConfig, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = tokenConfig.refreshBeforeExpiryMs;
        }
        return tokenConfig.copy(j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRefreshBeforeExpiryMs() {
        return this.refreshBeforeExpiryMs;
    }

    public final TokenConfig copy(long refreshBeforeExpiryMs) {
        return new TokenConfig(refreshBeforeExpiryMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TokenConfig) && this.refreshBeforeExpiryMs == ((TokenConfig) other).refreshBeforeExpiryMs;
    }

    public final long getRefreshBeforeExpiryMs() {
        return this.refreshBeforeExpiryMs;
    }

    public int hashCode() {
        return Long.hashCode(this.refreshBeforeExpiryMs);
    }

    public String toString() {
        return "TokenConfig(refreshBeforeExpiryMs=" + this.refreshBeforeExpiryMs + ")";
    }

    public TokenConfig(long j2) {
        this.refreshBeforeExpiryMs = j2;
    }

    public /* synthetic */ TokenConfig(long j2, int i2, f fVar) {
        this((i2 & 1) != 0 ? 300000L : j2);
    }
}
