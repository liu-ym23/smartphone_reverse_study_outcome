package com.stepos.agentcache.sdk.api;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "servicePackageName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "maxPendingEvents", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "enableDebugLog", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;IZ)V", "getServicePackageName", "()Ljava/lang/String;", "getMaxPendingEvents", "()I", "getEnableDebugLog", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AgentCacheConfig {
    private final boolean enableDebugLog;
    private final int maxPendingEvents;
    private final String servicePackageName;

    public AgentCacheConfig() {
        this(null, 0, false, 7, null);
    }

    public static /* synthetic */ AgentCacheConfig copy$default(AgentCacheConfig agentCacheConfig, String str, int i8, boolean z, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = agentCacheConfig.servicePackageName;
        }
        if ((i9 & 2) != 0) {
            i8 = agentCacheConfig.maxPendingEvents;
        }
        if ((i9 & 4) != 0) {
            z = agentCacheConfig.enableDebugLog;
        }
        return agentCacheConfig.copy(str, i8, z);
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
        p.e(servicePackageName, "servicePackageName");
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
        return p.a(this.servicePackageName, agentCacheConfig.servicePackageName) && this.maxPendingEvents == agentCacheConfig.maxPendingEvents && this.enableDebugLog == agentCacheConfig.enableDebugLog;
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
        return Boolean.hashCode(this.enableDebugLog) + b.C(this.maxPendingEvents, this.servicePackageName.hashCode() * 31, 31);
    }

    public String toString() {
        String str = this.servicePackageName;
        int i8 = this.maxPendingEvents;
        boolean z = this.enableDebugLog;
        StringBuilder sbU = b.u("AgentCacheConfig(servicePackageName=", i8, str, ", maxPendingEvents=", ", enableDebugLog=");
        sbU.append(z);
        sbU.append(")");
        return sbU.toString();
    }

    public AgentCacheConfig(String servicePackageName, int i8, boolean z) {
        p.e(servicePackageName, "servicePackageName");
        this.servicePackageName = servicePackageName;
        this.maxPendingEvents = i8;
        this.enableDebugLog = z;
    }

    public /* synthetic */ AgentCacheConfig(String str, int i8, boolean z, int i9, i iVar) {
        this((i9 & 1) != 0 ? "com.stepos.agentcache" : str, (i9 & 2) != 0 ? 5 : i8, (i9 & 4) != 0 ? true : z);
    }
}
