package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentbus/config/DebugAccountConfig;", "", "enabled", "", "debugAccountToken", "", "<init>", "(ZLjava/lang/String;)V", "getEnabled", "()Z", "getDebugAccountToken", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DebugAccountConfig {
    private final String debugAccountToken;
    private final boolean enabled;

    /* JADX WARN: Multi-variable type inference failed */
    public DebugAccountConfig() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DebugAccountConfig copy$default(DebugAccountConfig debugAccountConfig, boolean z4, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z4 = debugAccountConfig.enabled;
        }
        if ((i2 & 2) != 0) {
            str = debugAccountConfig.debugAccountToken;
        }
        return debugAccountConfig.copy(z4, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDebugAccountToken() {
        return this.debugAccountToken;
    }

    public final DebugAccountConfig copy(boolean enabled, String debugAccountToken) {
        k.e(debugAccountToken, "debugAccountToken");
        return new DebugAccountConfig(enabled, debugAccountToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebugAccountConfig)) {
            return false;
        }
        DebugAccountConfig debugAccountConfig = (DebugAccountConfig) other;
        return this.enabled == debugAccountConfig.enabled && k.a(this.debugAccountToken, debugAccountConfig.debugAccountToken);
    }

    public final String getDebugAccountToken() {
        return this.debugAccountToken;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public int hashCode() {
        return this.debugAccountToken.hashCode() + (Boolean.hashCode(this.enabled) * 31);
    }

    public String toString() {
        return "DebugAccountConfig(enabled=" + this.enabled + ", debugAccountToken=" + this.debugAccountToken + ")";
    }

    public DebugAccountConfig(boolean z4, String str) {
        k.e(str, "debugAccountToken");
        this.enabled = z4;
        this.debugAccountToken = str;
    }

    public /* synthetic */ DebugAccountConfig(boolean z4, String str, int i2, f fVar) {
        this((i2 & 1) != 0 ? false : z4, (i2 & 2) != 0 ? "admin_AAAAAAAAAAAAAAAAVn9wbs5mmyY++3+npvvqVM5ehg==" : str);
    }
}
