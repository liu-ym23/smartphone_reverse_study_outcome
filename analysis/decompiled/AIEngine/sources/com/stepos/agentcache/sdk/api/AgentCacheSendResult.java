package com.stepos.agentcache.sdk.api;

import ai.onnxruntime.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AgentCacheSendResult {
    private final String reason;
    private final boolean success;
    private final String traceId;

    public AgentCacheSendResult(boolean z, String reason, String str) {
        g.f(reason, "reason");
        this.success = z;
        this.reason = reason;
        this.traceId = str;
    }

    public static /* synthetic */ AgentCacheSendResult copy$default(AgentCacheSendResult agentCacheSendResult, boolean z, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z = agentCacheSendResult.success;
        }
        if ((i10 & 2) != 0) {
            str = agentCacheSendResult.reason;
        }
        if ((i10 & 4) != 0) {
            str2 = agentCacheSendResult.traceId;
        }
        return agentCacheSendResult.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.reason;
    }

    public final String component3() {
        return this.traceId;
    }

    public final AgentCacheSendResult copy(boolean z, String reason, String str) {
        g.f(reason, "reason");
        return new AgentCacheSendResult(z, reason, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgentCacheSendResult)) {
            return false;
        }
        AgentCacheSendResult agentCacheSendResult = (AgentCacheSendResult) obj;
        return this.success == agentCacheSendResult.success && g.b(this.reason, agentCacheSendResult.reason) && g.b(this.traceId, agentCacheSendResult.traceId);
    }

    public final String getReason() {
        return this.reason;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iA = d.a(Boolean.hashCode(this.success) * 31, 31, this.reason);
        String str = this.traceId;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        boolean z = this.success;
        String str = this.reason;
        String str2 = this.traceId;
        StringBuilder sb2 = new StringBuilder("AgentCacheSendResult(success=");
        sb2.append(z);
        sb2.append(", reason=");
        sb2.append(str);
        sb2.append(", traceId=");
        return a.o(sb2, str2, ")");
    }

    public /* synthetic */ AgentCacheSendResult(boolean z, String str, String str2, int i10, e eVar) {
        this(z, str, (i10 & 4) != 0 ? null : str2);
    }
}
