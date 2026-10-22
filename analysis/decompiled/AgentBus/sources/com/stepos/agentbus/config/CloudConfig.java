package com.stepos.agentbus.config;

import kotlin.Metadata;
import m.x;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006'"}, d2 = {"Lcom/stepos/agentbus/config/CloudConfig;", "", "url", "", "connectTimeoutMs", "", "reconnect", "Lcom/stepos/agentbus/config/ReconnectConfig;", "heartbeat", "Lcom/stepos/agentbus/config/HeartbeatConfig;", "token", "Lcom/stepos/agentbus/config/TokenConfig;", "certificatePin", "<init>", "(Ljava/lang/String;JLcom/stepos/agentbus/config/ReconnectConfig;Lcom/stepos/agentbus/config/HeartbeatConfig;Lcom/stepos/agentbus/config/TokenConfig;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getConnectTimeoutMs", "()J", "getReconnect", "()Lcom/stepos/agentbus/config/ReconnectConfig;", "getHeartbeat", "()Lcom/stepos/agentbus/config/HeartbeatConfig;", "getToken", "()Lcom/stepos/agentbus/config/TokenConfig;", "getCertificatePin", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CloudConfig {
    private final String certificatePin;
    private final long connectTimeoutMs;
    private final HeartbeatConfig heartbeat;
    private final ReconnectConfig reconnect;
    private final TokenConfig token;
    private final String url;

    public CloudConfig() {
        this(null, 0L, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CloudConfig copy$default(CloudConfig cloudConfig, String str, long j2, ReconnectConfig reconnectConfig, HeartbeatConfig heartbeatConfig, TokenConfig tokenConfig, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cloudConfig.url;
        }
        if ((i2 & 2) != 0) {
            j2 = cloudConfig.connectTimeoutMs;
        }
        if ((i2 & 4) != 0) {
            reconnectConfig = cloudConfig.reconnect;
        }
        if ((i2 & 8) != 0) {
            heartbeatConfig = cloudConfig.heartbeat;
        }
        if ((i2 & 16) != 0) {
            tokenConfig = cloudConfig.token;
        }
        if ((i2 & 32) != 0) {
            str2 = cloudConfig.certificatePin;
        }
        return cloudConfig.copy(str, j2, reconnectConfig, heartbeatConfig, tokenConfig, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    /* renamed from: component3, reason: from getter */
    public final ReconnectConfig getReconnect() {
        return this.reconnect;
    }

    /* renamed from: component4, reason: from getter */
    public final HeartbeatConfig getHeartbeat() {
        return this.heartbeat;
    }

    /* renamed from: component5, reason: from getter */
    public final TokenConfig getToken() {
        return this.token;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCertificatePin() {
        return this.certificatePin;
    }

    public final CloudConfig copy(String url, long connectTimeoutMs, ReconnectConfig reconnect, HeartbeatConfig heartbeat, TokenConfig token, String certificatePin) {
        k.e(url, "url");
        k.e(reconnect, "reconnect");
        k.e(heartbeat, "heartbeat");
        k.e(token, "token");
        return new CloudConfig(url, connectTimeoutMs, reconnect, heartbeat, token, certificatePin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudConfig)) {
            return false;
        }
        CloudConfig cloudConfig = (CloudConfig) other;
        return k.a(this.url, cloudConfig.url) && this.connectTimeoutMs == cloudConfig.connectTimeoutMs && k.a(this.reconnect, cloudConfig.reconnect) && k.a(this.heartbeat, cloudConfig.heartbeat) && k.a(this.token, cloudConfig.token) && k.a(this.certificatePin, cloudConfig.certificatePin);
    }

    public final String getCertificatePin() {
        return this.certificatePin;
    }

    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public final HeartbeatConfig getHeartbeat() {
        return this.heartbeat;
    }

    public final ReconnectConfig getReconnect() {
        return this.reconnect;
    }

    public final TokenConfig getToken() {
        return this.token;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = (this.token.hashCode() + ((this.heartbeat.hashCode() + ((this.reconnect.hashCode() + x.f(this.connectTimeoutMs, this.url.hashCode() * 31, 31)) * 31)) * 31)) * 31;
        String str = this.certificatePin;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CloudConfig(url=" + this.url + ", connectTimeoutMs=" + this.connectTimeoutMs + ", reconnect=" + this.reconnect + ", heartbeat=" + this.heartbeat + ", token=" + this.token + ", certificatePin=" + this.certificatePin + ")";
    }

    public CloudConfig(String str, long j2, ReconnectConfig reconnectConfig, HeartbeatConfig heartbeatConfig, TokenConfig tokenConfig, String str2) {
        k.e(str, "url");
        k.e(reconnectConfig, "reconnect");
        k.e(heartbeatConfig, "heartbeat");
        k.e(tokenConfig, "token");
        this.url = str;
        this.connectTimeoutMs = j2;
        this.reconnect = reconnectConfig;
        this.heartbeat = heartbeatConfig;
        this.token = tokenConfig;
        this.certificatePin = str2;
    }

    public /* synthetic */ CloudConfig(String str, long j2, ReconnectConfig reconnectConfig, HeartbeatConfig heartbeatConfig, TokenConfig tokenConfig, String str2, int i2, f fVar) {
        this((i2 & 1) != 0 ? "wss://cloud.stepclaw.example/ws" : str, (i2 & 2) != 0 ? 10000L : j2, (i2 & 4) != 0 ? new ReconnectConfig(0L, 0L, 0.0d, 7, null) : reconnectConfig, (i2 & 8) != 0 ? new HeartbeatConfig(0, 1, null) : heartbeatConfig, (i2 & 16) != 0 ? new TokenConfig(0L, 1, null) : tokenConfig, (i2 & 32) != 0 ? null : str2);
    }
}
