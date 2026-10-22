package com.stepos.agentbus.config;

import a1.a;
import kotlin.Metadata;
import m.x;
import n.f;
import q7.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentbus/config/EdgeConfig;", "", "host", "", "port", "", "connectTimeoutMs", "", "reconnect", "Lcom/stepos/agentbus/config/ReconnectConfig;", "<init>", "(Ljava/lang/String;IJLcom/stepos/agentbus/config/ReconnectConfig;)V", "getHost", "()Ljava/lang/String;", "getPort", "()I", "getConnectTimeoutMs", "()J", "getReconnect", "()Lcom/stepos/agentbus/config/ReconnectConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class EdgeConfig {
    private final long connectTimeoutMs;
    private final String host;
    private final int port;
    private final ReconnectConfig reconnect;

    public EdgeConfig() {
        this(null, 0, 0L, null, 15, null);
    }

    public static /* synthetic */ EdgeConfig copy$default(EdgeConfig edgeConfig, String str, int i2, long j2, ReconnectConfig reconnectConfig, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = edgeConfig.host;
        }
        if ((i10 & 2) != 0) {
            i2 = edgeConfig.port;
        }
        if ((i10 & 4) != 0) {
            j2 = edgeConfig.connectTimeoutMs;
        }
        if ((i10 & 8) != 0) {
            reconnectConfig = edgeConfig.reconnect;
        }
        ReconnectConfig reconnectConfig2 = reconnectConfig;
        return edgeConfig.copy(str, i2, j2, reconnectConfig2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* renamed from: component3, reason: from getter */
    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    /* renamed from: component4, reason: from getter */
    public final ReconnectConfig getReconnect() {
        return this.reconnect;
    }

    public final EdgeConfig copy(String host, int port, long connectTimeoutMs, ReconnectConfig reconnect) {
        k.e(host, "host");
        k.e(reconnect, "reconnect");
        return new EdgeConfig(host, port, connectTimeoutMs, reconnect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EdgeConfig)) {
            return false;
        }
        EdgeConfig edgeConfig = (EdgeConfig) other;
        return k.a(this.host, edgeConfig.host) && this.port == edgeConfig.port && this.connectTimeoutMs == edgeConfig.connectTimeoutMs && k.a(this.reconnect, edgeConfig.reconnect);
    }

    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    public final ReconnectConfig getReconnect() {
        return this.reconnect;
    }

    public int hashCode() {
        return this.reconnect.hashCode() + x.f(this.connectTimeoutMs, f.b(this.port, this.host.hashCode() * 31, 31), 31);
    }

    public String toString() {
        String str = this.host;
        int i2 = this.port;
        long j2 = this.connectTimeoutMs;
        ReconnectConfig reconnectConfig = this.reconnect;
        StringBuilder sbO = a.o("EdgeConfig(host=", str, ", port=", i2, ", connectTimeoutMs=");
        sbO.append(j2);
        sbO.append(", reconnect=");
        sbO.append(reconnectConfig);
        sbO.append(")");
        return sbO.toString();
    }

    public EdgeConfig(String str, int i2, long j2, ReconnectConfig reconnectConfig) {
        k.e(str, "host");
        k.e(reconnectConfig, "reconnect");
        this.host = str;
        this.port = i2;
        this.connectTimeoutMs = j2;
        this.reconnect = reconnectConfig;
    }

    public /* synthetic */ EdgeConfig(String str, int i2, long j2, ReconnectConfig reconnectConfig, int i10, q7.f fVar) {
        this((i10 & 1) != 0 ? "127.0.0.1" : str, (i10 & 2) != 0 ? 18080 : i2, (i10 & 4) != 0 ? 5000L : j2, (i10 & 8) != 0 ? new ReconnectConfig(0L, 10000L, 0.0d, 5, null) : reconnectConfig);
    }
}
