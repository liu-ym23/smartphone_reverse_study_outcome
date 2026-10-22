package com.stepos.agentcache.sdk.api;

import ai.onnxruntime.a;
import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AgentCacheConfig {
    private final boolean enableDebugLog;
    private final int maxPendingEvents;
    private final String servicePackageName;

    public AgentCacheConfig() {
        this(null, 0, false, 7, null);
    }

    public static /* synthetic */ AgentCacheConfig copy$default(AgentCacheConfig agentCacheConfig, String str, int i10, boolean z, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = agentCacheConfig.servicePackageName;
        }
        if ((i11 & 2) != 0) {
            i10 = agentCacheConfig.maxPendingEvents;
        }
        if ((i11 & 4) != 0) {
            z = agentCacheConfig.enableDebugLog;
        }
        return agentCacheConfig.copy(str, i10, z);
    }

    public final String component1() {
        return this.servicePackageName;
    }

    public final int component2() {
        return this.maxPendingEvents;
    }

    public final boolean component3() {
        return this.enableDebugLog;
    }

    public final AgentCacheConfig copy(String servicePackageName, int i10, boolean z) {
        g.f(servicePackageName, "servicePackageName");
        return new AgentCacheConfig(servicePackageName, i10, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgentCacheConfig)) {
            return false;
        }
        AgentCacheConfig agentCacheConfig = (AgentCacheConfig) obj;
        return g.b(this.servicePackageName, agentCacheConfig.servicePackageName) && this.maxPendingEvents == agentCacheConfig.maxPendingEvents && this.enableDebugLog == agentCacheConfig.enableDebugLog;
    }

    public final boolean getEnableDebugLog() {
        return this.enableDebugLog;
    }

    public final int getMaxPendingEvents() {
        return this.maxPendingEvents;
    }

    public final String getServicePackageName() {
        return this.servicePackageName;
    }

    public int hashCode() {
        return Boolean.hashCode(this.enableDebugLog) + a.d(this.maxPendingEvents, this.servicePackageName.hashCode() * 31, 31);
    }

    public String toString() {
        String str = this.servicePackageName;
        int i10 = this.maxPendingEvents;
        return a0.a.m(e.f("AgentCacheConfig(servicePackageName=", str, ", maxPendingEvents=", i10, ", enableDebugLog="), this.enableDebugLog, ")");
    }

    public AgentCacheConfig(String servicePackageName, int i10, boolean z) {
        g.f(servicePackageName, "servicePackageName");
        this.servicePackageName = servicePackageName;
        this.maxPendingEvents = i10;
        this.enableDebugLog = z;
    }

    public /* synthetic */ AgentCacheConfig(String str, int i10, boolean z, int i11, kotlin.jvm.internal.e eVar) {
        this((i11 & 1) != 0 ? "com.stepos.agentcache" : str, (i11 & 2) != 0 ? 5 : i10, (i11 & 4) != 0 ? true : z);
    }
}
