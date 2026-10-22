package com.stepos.agentbus.config;

import kotlin.Metadata;
import m.x;
import n.f;
import q7.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003Je\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001a¨\u0006,"}, d2 = {"Lcom/stepos/agentbus/config/BffBridgeConfig;", "", "enabled", "", "websocketUrl", "", "product", "platform", "", "heartbeatIntervalSec", "idleDisconnectMs", "", "screenOffIdleMs", "reconnectInitialDelayMs", "reconnectMaxDelayMs", "<init>", "(ZLjava/lang/String;Ljava/lang/String;IIJJJJ)V", "getEnabled", "()Z", "getWebsocketUrl", "()Ljava/lang/String;", "getProduct", "getPlatform", "()I", "getHeartbeatIntervalSec", "getIdleDisconnectMs", "()J", "getScreenOffIdleMs", "getReconnectInitialDelayMs", "getReconnectMaxDelayMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BffBridgeConfig {
    private final boolean enabled;
    private final int heartbeatIntervalSec;
    private final long idleDisconnectMs;
    private final int platform;
    private final String product;
    private final long reconnectInitialDelayMs;
    private final long reconnectMaxDelayMs;
    private final long screenOffIdleMs;
    private final String websocketUrl;

    public BffBridgeConfig() {
        this(false, null, null, 0, 0, 0L, 0L, 0L, 0L, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final String getWebsocketUrl() {
        return this.websocketUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getProduct() {
        return this.product;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPlatform() {
        return this.platform;
    }

    /* renamed from: component5, reason: from getter */
    public final int getHeartbeatIntervalSec() {
        return this.heartbeatIntervalSec;
    }

    /* renamed from: component6, reason: from getter */
    public final long getIdleDisconnectMs() {
        return this.idleDisconnectMs;
    }

    /* renamed from: component7, reason: from getter */
    public final long getScreenOffIdleMs() {
        return this.screenOffIdleMs;
    }

    /* renamed from: component8, reason: from getter */
    public final long getReconnectInitialDelayMs() {
        return this.reconnectInitialDelayMs;
    }

    /* renamed from: component9, reason: from getter */
    public final long getReconnectMaxDelayMs() {
        return this.reconnectMaxDelayMs;
    }

    public final BffBridgeConfig copy(boolean enabled, String websocketUrl, String product, int platform, int heartbeatIntervalSec, long idleDisconnectMs, long screenOffIdleMs, long reconnectInitialDelayMs, long reconnectMaxDelayMs) {
        k.e(product, "product");
        return new BffBridgeConfig(enabled, websocketUrl, product, platform, heartbeatIntervalSec, idleDisconnectMs, screenOffIdleMs, reconnectInitialDelayMs, reconnectMaxDelayMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BffBridgeConfig)) {
            return false;
        }
        BffBridgeConfig bffBridgeConfig = (BffBridgeConfig) other;
        return this.enabled == bffBridgeConfig.enabled && k.a(this.websocketUrl, bffBridgeConfig.websocketUrl) && k.a(this.product, bffBridgeConfig.product) && this.platform == bffBridgeConfig.platform && this.heartbeatIntervalSec == bffBridgeConfig.heartbeatIntervalSec && this.idleDisconnectMs == bffBridgeConfig.idleDisconnectMs && this.screenOffIdleMs == bffBridgeConfig.screenOffIdleMs && this.reconnectInitialDelayMs == bffBridgeConfig.reconnectInitialDelayMs && this.reconnectMaxDelayMs == bffBridgeConfig.reconnectMaxDelayMs;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getHeartbeatIntervalSec() {
        return this.heartbeatIntervalSec;
    }

    public final long getIdleDisconnectMs() {
        return this.idleDisconnectMs;
    }

    public final int getPlatform() {
        return this.platform;
    }

    public final String getProduct() {
        return this.product;
    }

    public final long getReconnectInitialDelayMs() {
        return this.reconnectInitialDelayMs;
    }

    public final long getReconnectMaxDelayMs() {
        return this.reconnectMaxDelayMs;
    }

    public final long getScreenOffIdleMs() {
        return this.screenOffIdleMs;
    }

    public final String getWebsocketUrl() {
        return this.websocketUrl;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.enabled) * 31;
        String str = this.websocketUrl;
        return Long.hashCode(this.reconnectMaxDelayMs) + x.f(this.reconnectInitialDelayMs, x.f(this.screenOffIdleMs, x.f(this.idleDisconnectMs, f.b(this.heartbeatIntervalSec, f.b(this.platform, x.g(this.product, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "BffBridgeConfig(enabled=" + this.enabled + ", websocketUrl=" + this.websocketUrl + ", product=" + this.product + ", platform=" + this.platform + ", heartbeatIntervalSec=" + this.heartbeatIntervalSec + ", idleDisconnectMs=" + this.idleDisconnectMs + ", screenOffIdleMs=" + this.screenOffIdleMs + ", reconnectInitialDelayMs=" + this.reconnectInitialDelayMs + ", reconnectMaxDelayMs=" + this.reconnectMaxDelayMs + ")";
    }

    public BffBridgeConfig(boolean z4, String str, String str2, int i2, int i10, long j2, long j4, long j10, long j11) {
        k.e(str2, "product");
        this.enabled = z4;
        this.websocketUrl = str;
        this.product = str2;
        this.platform = i2;
        this.heartbeatIntervalSec = i10;
        this.idleDisconnectMs = j2;
        this.screenOffIdleMs = j4;
        this.reconnectInitialDelayMs = j10;
        this.reconnectMaxDelayMs = j11;
    }

    public /* synthetic */ BffBridgeConfig(boolean z4, String str, String str2, int i2, int i10, long j2, long j4, long j10, long j11, int i11, q7.f fVar) {
        this((i11 & 1) != 0 ? false : z4, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? "stepos" : str2, (i11 & 8) != 0 ? 3 : i2, (i11 & 16) != 0 ? 30 : i10, (i11 & 32) != 0 ? 900000L : j2, (i11 & 64) != 0 ? 30000L : j4, (i11 & 128) != 0 ? 2000L : j10, (i11 & 256) != 0 ? 60000L : j11);
    }
}
