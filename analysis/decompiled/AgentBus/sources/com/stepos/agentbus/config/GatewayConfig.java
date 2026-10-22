package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/stepos/agentbus/config/GatewayConfig;", "", "vendor", "", "openclaw", "Lcom/stepos/agentbus/config/OpenClawGatewayUpstream;", "cloudBridge", "Lcom/stepos/agentbus/config/CloudBridgeConfig;", "bffBridge", "Lcom/stepos/agentbus/config/BffBridgeConfig;", "debugAccount", "Lcom/stepos/agentbus/config/DebugAccountConfig;", "<init>", "(Ljava/lang/String;Lcom/stepos/agentbus/config/OpenClawGatewayUpstream;Lcom/stepos/agentbus/config/CloudBridgeConfig;Lcom/stepos/agentbus/config/BffBridgeConfig;Lcom/stepos/agentbus/config/DebugAccountConfig;)V", "getVendor", "()Ljava/lang/String;", "getOpenclaw", "()Lcom/stepos/agentbus/config/OpenClawGatewayUpstream;", "getCloudBridge", "()Lcom/stepos/agentbus/config/CloudBridgeConfig;", "getBffBridge", "()Lcom/stepos/agentbus/config/BffBridgeConfig;", "getDebugAccount", "()Lcom/stepos/agentbus/config/DebugAccountConfig;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GatewayConfig {
    private final BffBridgeConfig bffBridge;
    private final CloudBridgeConfig cloudBridge;
    private final DebugAccountConfig debugAccount;
    private final OpenClawGatewayUpstream openclaw;
    private final String vendor;

    public GatewayConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GatewayConfig copy$default(GatewayConfig gatewayConfig, String str, OpenClawGatewayUpstream openClawGatewayUpstream, CloudBridgeConfig cloudBridgeConfig, BffBridgeConfig bffBridgeConfig, DebugAccountConfig debugAccountConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gatewayConfig.vendor;
        }
        if ((i2 & 2) != 0) {
            openClawGatewayUpstream = gatewayConfig.openclaw;
        }
        if ((i2 & 4) != 0) {
            cloudBridgeConfig = gatewayConfig.cloudBridge;
        }
        if ((i2 & 8) != 0) {
            bffBridgeConfig = gatewayConfig.bffBridge;
        }
        if ((i2 & 16) != 0) {
            debugAccountConfig = gatewayConfig.debugAccount;
        }
        DebugAccountConfig debugAccountConfig2 = debugAccountConfig;
        CloudBridgeConfig cloudBridgeConfig2 = cloudBridgeConfig;
        return gatewayConfig.copy(str, openClawGatewayUpstream, cloudBridgeConfig2, bffBridgeConfig, debugAccountConfig2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVendor() {
        return this.vendor;
    }

    /* renamed from: component2, reason: from getter */
    public final OpenClawGatewayUpstream getOpenclaw() {
        return this.openclaw;
    }

    /* renamed from: component3, reason: from getter */
    public final CloudBridgeConfig getCloudBridge() {
        return this.cloudBridge;
    }

    /* renamed from: component4, reason: from getter */
    public final BffBridgeConfig getBffBridge() {
        return this.bffBridge;
    }

    /* renamed from: component5, reason: from getter */
    public final DebugAccountConfig getDebugAccount() {
        return this.debugAccount;
    }

    public final GatewayConfig copy(String vendor, OpenClawGatewayUpstream openclaw, CloudBridgeConfig cloudBridge, BffBridgeConfig bffBridge, DebugAccountConfig debugAccount) {
        k.e(vendor, "vendor");
        k.e(openclaw, "openclaw");
        k.e(cloudBridge, "cloudBridge");
        k.e(bffBridge, "bffBridge");
        k.e(debugAccount, "debugAccount");
        return new GatewayConfig(vendor, openclaw, cloudBridge, bffBridge, debugAccount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayConfig)) {
            return false;
        }
        GatewayConfig gatewayConfig = (GatewayConfig) other;
        return k.a(this.vendor, gatewayConfig.vendor) && k.a(this.openclaw, gatewayConfig.openclaw) && k.a(this.cloudBridge, gatewayConfig.cloudBridge) && k.a(this.bffBridge, gatewayConfig.bffBridge) && k.a(this.debugAccount, gatewayConfig.debugAccount);
    }

    public final BffBridgeConfig getBffBridge() {
        return this.bffBridge;
    }

    public final CloudBridgeConfig getCloudBridge() {
        return this.cloudBridge;
    }

    public final DebugAccountConfig getDebugAccount() {
        return this.debugAccount;
    }

    public final OpenClawGatewayUpstream getOpenclaw() {
        return this.openclaw;
    }

    public final String getVendor() {
        return this.vendor;
    }

    public int hashCode() {
        return this.debugAccount.hashCode() + ((this.bffBridge.hashCode() + ((this.cloudBridge.hashCode() + ((this.openclaw.hashCode() + (this.vendor.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "GatewayConfig(vendor=" + this.vendor + ", openclaw=" + this.openclaw + ", cloudBridge=" + this.cloudBridge + ", bffBridge=" + this.bffBridge + ", debugAccount=" + this.debugAccount + ")";
    }

    public GatewayConfig(String str, OpenClawGatewayUpstream openClawGatewayUpstream, CloudBridgeConfig cloudBridgeConfig, BffBridgeConfig bffBridgeConfig, DebugAccountConfig debugAccountConfig) {
        k.e(str, "vendor");
        k.e(openClawGatewayUpstream, "openclaw");
        k.e(cloudBridgeConfig, "cloudBridge");
        k.e(bffBridgeConfig, "bffBridge");
        k.e(debugAccountConfig, "debugAccount");
        this.vendor = str;
        this.openclaw = openClawGatewayUpstream;
        this.cloudBridge = cloudBridgeConfig;
        this.bffBridge = bffBridgeConfig;
        this.debugAccount = debugAccountConfig;
    }

    public /* synthetic */ GatewayConfig(String str, OpenClawGatewayUpstream openClawGatewayUpstream, CloudBridgeConfig cloudBridgeConfig, BffBridgeConfig bffBridgeConfig, DebugAccountConfig debugAccountConfig, int i2, f fVar) {
        this((i2 & 1) != 0 ? "stepclaw" : str, (i2 & 2) != 0 ? new OpenClawGatewayUpstream(null, false, false, null, false, null, null, null, null, null, null, null, 4095, null) : openClawGatewayUpstream, (i2 & 4) != 0 ? new CloudBridgeConfig(false, null, 3, null) : cloudBridgeConfig, (i2 & 8) != 0 ? new BffBridgeConfig(false, null, null, 0, 0, 0L, 0L, 0L, 0L, 511, null) : bffBridgeConfig, (i2 & 16) != 0 ? new DebugAccountConfig(false, null, 3, null) : debugAccountConfig);
    }
}
