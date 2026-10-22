package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentbus/config/LocalSocketConfig;", "", "name", "", "maxConnections", "", "<init>", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getMaxConnections", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LocalSocketConfig {
    private final int maxConnections;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalSocketConfig() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LocalSocketConfig copy$default(LocalSocketConfig localSocketConfig, String str, int i2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = localSocketConfig.name;
        }
        if ((i10 & 2) != 0) {
            i2 = localSocketConfig.maxConnections;
        }
        return localSocketConfig.copy(str, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxConnections() {
        return this.maxConnections;
    }

    public final LocalSocketConfig copy(String name, int maxConnections) {
        k.e(name, "name");
        return new LocalSocketConfig(name, maxConnections);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalSocketConfig)) {
            return false;
        }
        LocalSocketConfig localSocketConfig = (LocalSocketConfig) other;
        return k.a(this.name, localSocketConfig.name) && this.maxConnections == localSocketConfig.maxConnections;
    }

    public final int getMaxConnections() {
        return this.maxConnections;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return Integer.hashCode(this.maxConnections) + (this.name.hashCode() * 31);
    }

    public String toString() {
        return "LocalSocketConfig(name=" + this.name + ", maxConnections=" + this.maxConnections + ")";
    }

    public LocalSocketConfig(String str, int i2) {
        k.e(str, "name");
        this.name = str;
        this.maxConnections = i2;
    }

    public /* synthetic */ LocalSocketConfig(String str, int i2, int i10, f fVar) {
        this((i10 & 1) != 0 ? "agentbus" : str, (i10 & 2) != 0 ? 64 : i2);
    }
}
