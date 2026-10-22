package com.stepos.agentcache.sdk.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", "", "servicePackageName", "", "maxPendingEvents", "", "enableDebugLog", "", "<init>", "(Ljava/lang/String;IZ)V", "getServicePackageName", "()Ljava/lang/String;", "getMaxPendingEvents", "()I", "getEnableDebugLog", "()Z", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AgentCacheConfig {
    private final boolean enableDebugLog;
    private final int maxPendingEvents;
    private final String servicePackageName;

    public AgentCacheConfig() {
        this(null, 0, false, 7, null);
    }

    public static /* synthetic */ AgentCacheConfig copy$default(AgentCacheConfig agentCacheConfig, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = agentCacheConfig.servicePackageName;
        }
        if ((i11 & 2) != 0) {
            i10 = agentCacheConfig.maxPendingEvents;
        }
        if ((i11 & 4) != 0) {
            z10 = agentCacheConfig.enableDebugLog;
        }
        return agentCacheConfig.copy(str, i10, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getServicePackageName() {
        return this.servicePackageName;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxPendingEvents() {
        return this.maxPendingEvents;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableDebugLog() {
        return this.enableDebugLog;
    }

    public final AgentCacheConfig copy(String servicePackageName, int maxPendingEvents, boolean enableDebugLog) {
        p.i(servicePackageName, "servicePackageName");
        return new AgentCacheConfig(servicePackageName, maxPendingEvents, enableDebugLog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentCacheConfig)) {
            return false;
        }
        AgentCacheConfig agentCacheConfig = (AgentCacheConfig) other;
        return p.d(this.servicePackageName, agentCacheConfig.servicePackageName) && this.maxPendingEvents == agentCacheConfig.maxPendingEvents && this.enableDebugLog == agentCacheConfig.enableDebugLog;
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
        return (((this.servicePackageName.hashCode() * 31) + Integer.hashCode(this.maxPendingEvents)) * 31) + Boolean.hashCode(this.enableDebugLog);
    }

    public String toString() {
        return "AgentCacheConfig(servicePackageName=" + this.servicePackageName + ", maxPendingEvents=" + this.maxPendingEvents + ", enableDebugLog=" + this.enableDebugLog + ")";
    }

    public AgentCacheConfig(String servicePackageName, int i10, boolean z10) {
        p.i(servicePackageName, "servicePackageName");
        this.servicePackageName = servicePackageName;
        this.maxPendingEvents = i10;
        this.enableDebugLog = z10;
    }

    public /* synthetic */ AgentCacheConfig(String str, int i10, boolean z10, int i11, i iVar) {
        this((i11 & 1) != 0 ? "com.stepos.agentcache" : str, (i11 & 2) != 0 ? 5 : i10, (i11 & 4) != 0 ? true : z10);
    }
}
