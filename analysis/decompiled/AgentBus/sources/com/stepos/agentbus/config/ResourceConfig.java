package com.stepos.agentbus.config;

import kotlin.Metadata;
import m.x;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentbus/config/ResourceConfig;", "", "backend", "", "rootfsBase", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBackend", "()Ljava/lang/String;", "getRootfsBase", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ResourceConfig {
    private final String backend;
    private final String rootfsBase;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ResourceConfig copy$default(ResourceConfig resourceConfig, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = resourceConfig.backend;
        }
        if ((i2 & 2) != 0) {
            str2 = resourceConfig.rootfsBase;
        }
        return resourceConfig.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBackend() {
        return this.backend;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRootfsBase() {
        return this.rootfsBase;
    }

    public final ResourceConfig copy(String backend, String rootfsBase) {
        k.e(backend, "backend");
        k.e(rootfsBase, "rootfsBase");
        return new ResourceConfig(backend, rootfsBase);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResourceConfig)) {
            return false;
        }
        ResourceConfig resourceConfig = (ResourceConfig) other;
        return k.a(this.backend, resourceConfig.backend) && k.a(this.rootfsBase, resourceConfig.rootfsBase);
    }

    public final String getBackend() {
        return this.backend;
    }

    public final String getRootfsBase() {
        return this.rootfsBase;
    }

    public int hashCode() {
        return this.rootfsBase.hashCode() + (this.backend.hashCode() * 31);
    }

    public String toString() {
        return x.x("ResourceConfig(backend=", this.backend, ", rootfsBase=", this.rootfsBase, ")");
    }

    public ResourceConfig(String str, String str2) {
        k.e(str, "backend");
        k.e(str2, "rootfsBase");
        this.backend = str;
        this.rootfsBase = str2;
    }

    public /* synthetic */ ResourceConfig(String str, String str2, int i2, f fVar) {
        this((i2 & 1) != 0 ? "mock" : str, (i2 & 2) != 0 ? "" : str2);
    }
}
