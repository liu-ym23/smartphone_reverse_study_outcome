package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentbus/config/CloudBridgeConfig;", "", "enabled", "", "openclaw", "Lcom/stepos/agentbus/config/OpenClawCloudUpstream;", "<init>", "(ZLcom/stepos/agentbus/config/OpenClawCloudUpstream;)V", "getEnabled", "()Z", "getOpenclaw", "()Lcom/stepos/agentbus/config/OpenClawCloudUpstream;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CloudBridgeConfig {
    private final boolean enabled;
    private final OpenClawCloudUpstream openclaw;

    /* JADX WARN: Multi-variable type inference failed */
    public CloudBridgeConfig() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CloudBridgeConfig copy$default(CloudBridgeConfig cloudBridgeConfig, boolean z4, OpenClawCloudUpstream openClawCloudUpstream, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z4 = cloudBridgeConfig.enabled;
        }
        if ((i2 & 2) != 0) {
            openClawCloudUpstream = cloudBridgeConfig.openclaw;
        }
        return cloudBridgeConfig.copy(z4, openClawCloudUpstream);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final OpenClawCloudUpstream getOpenclaw() {
        return this.openclaw;
    }

    public final CloudBridgeConfig copy(boolean enabled, OpenClawCloudUpstream openclaw) {
        k.e(openclaw, "openclaw");
        return new CloudBridgeConfig(enabled, openclaw);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudBridgeConfig)) {
            return false;
        }
        CloudBridgeConfig cloudBridgeConfig = (CloudBridgeConfig) other;
        return this.enabled == cloudBridgeConfig.enabled && k.a(this.openclaw, cloudBridgeConfig.openclaw);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final OpenClawCloudUpstream getOpenclaw() {
        return this.openclaw;
    }

    public int hashCode() {
        return this.openclaw.hashCode() + (Boolean.hashCode(this.enabled) * 31);
    }

    public String toString() {
        return "CloudBridgeConfig(enabled=" + this.enabled + ", openclaw=" + this.openclaw + ")";
    }

    public CloudBridgeConfig(boolean z4, OpenClawCloudUpstream openClawCloudUpstream) {
        k.e(openClawCloudUpstream, "openclaw");
        this.enabled = z4;
        this.openclaw = openClawCloudUpstream;
    }

    public /* synthetic */ CloudBridgeConfig(boolean z4, OpenClawCloudUpstream openClawCloudUpstream, int i2, f fVar) {
        this((i2 & 1) != 0 ? false : z4, (i2 & 2) != 0 ? new OpenClawCloudUpstream(null, false, null, false, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 1048575, null) : openClawCloudUpstream);
    }
}
