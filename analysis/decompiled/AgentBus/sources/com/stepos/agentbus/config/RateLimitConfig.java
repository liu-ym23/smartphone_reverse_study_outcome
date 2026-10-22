package com.stepos.agentbus.config;

import com.stepos.account.oauth.OAuthConstants;
import kotlin.Metadata;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentbus/config/RateLimitConfig;", "", "thirdparty", "Lcom/stepos/agentbus/config/RateBucket;", "agentspace", "<init>", "(Lcom/stepos/agentbus/config/RateBucket;Lcom/stepos/agentbus/config/RateBucket;)V", "getThirdparty", "()Lcom/stepos/agentbus/config/RateBucket;", "getAgentspace", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RateLimitConfig {
    private final RateBucket agentspace;
    private final RateBucket thirdparty;

    /* JADX WARN: Multi-variable type inference failed */
    public RateLimitConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RateLimitConfig copy$default(RateLimitConfig rateLimitConfig, RateBucket rateBucket, RateBucket rateBucket2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            rateBucket = rateLimitConfig.thirdparty;
        }
        if ((i2 & 2) != 0) {
            rateBucket2 = rateLimitConfig.agentspace;
        }
        return rateLimitConfig.copy(rateBucket, rateBucket2);
    }

    /* renamed from: component1, reason: from getter */
    public final RateBucket getThirdparty() {
        return this.thirdparty;
    }

    /* renamed from: component2, reason: from getter */
    public final RateBucket getAgentspace() {
        return this.agentspace;
    }

    public final RateLimitConfig copy(RateBucket thirdparty, RateBucket agentspace) {
        k.e(thirdparty, "thirdparty");
        k.e(agentspace, "agentspace");
        return new RateLimitConfig(thirdparty, agentspace);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RateLimitConfig)) {
            return false;
        }
        RateLimitConfig rateLimitConfig = (RateLimitConfig) other;
        return k.a(this.thirdparty, rateLimitConfig.thirdparty) && k.a(this.agentspace, rateLimitConfig.agentspace);
    }

    public final RateBucket getAgentspace() {
        return this.agentspace;
    }

    public final RateBucket getThirdparty() {
        return this.thirdparty;
    }

    public int hashCode() {
        return this.agentspace.hashCode() + (this.thirdparty.hashCode() * 31);
    }

    public String toString() {
        return "RateLimitConfig(thirdparty=" + this.thirdparty + ", agentspace=" + this.agentspace + ")";
    }

    public RateLimitConfig(RateBucket rateBucket, RateBucket rateBucket2) {
        k.e(rateBucket, "thirdparty");
        k.e(rateBucket2, "agentspace");
        this.thirdparty = rateBucket;
        this.agentspace = rateBucket2;
    }

    public /* synthetic */ RateLimitConfig(RateBucket rateBucket, RateBucket rateBucket2, int i2, f fVar) {
        this((i2 & 1) != 0 ? new RateBucket(10, 20) : rateBucket, (i2 & 2) != 0 ? new RateBucket(100, OAuthConstants.RESPONSE_CODE_OK) : rateBucket2);
    }
}
