package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentbus/config/RestApiConfig;", "", "enabled", "", "port", "", "<init>", "(ZI)V", "getEnabled", "()Z", "getPort", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RestApiConfig {
    private final boolean enabled;
    private final int port;

    /* JADX WARN: Multi-variable type inference failed */
    public RestApiConfig() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static /* synthetic */ RestApiConfig copy$default(RestApiConfig restApiConfig, boolean z4, int i2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z4 = restApiConfig.enabled;
        }
        if ((i10 & 2) != 0) {
            i2 = restApiConfig.port;
        }
        return restApiConfig.copy(z4, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    public final RestApiConfig copy(boolean enabled, int port) {
        return new RestApiConfig(enabled, port);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestApiConfig)) {
            return false;
        }
        RestApiConfig restApiConfig = (RestApiConfig) other;
        return this.enabled == restApiConfig.enabled && this.port == restApiConfig.port;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getPort() {
        return this.port;
    }

    public int hashCode() {
        return Integer.hashCode(this.port) + (Boolean.hashCode(this.enabled) * 31);
    }

    public String toString() {
        return "RestApiConfig(enabled=" + this.enabled + ", port=" + this.port + ")";
    }

    public RestApiConfig(boolean z4, int i2) {
        this.enabled = z4;
        this.port = i2;
    }

    public /* synthetic */ RestApiConfig(boolean z4, int i2, int i10, f fVar) {
        this((i10 & 1) != 0 ? false : z4, (i10 & 2) != 0 ? 18801 : i2);
    }
}
