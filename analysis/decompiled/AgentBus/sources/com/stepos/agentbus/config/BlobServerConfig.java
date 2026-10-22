package com.stepos.agentbus.config;

import kotlin.Metadata;
import n.f;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentbus/config/BlobServerConfig;", "", "port", "", "maxCacheSizeMb", "maxPutSizeMb", "<init>", "(III)V", "getPort", "()I", "getMaxCacheSizeMb", "getMaxPutSizeMb", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BlobServerConfig {
    private final int maxCacheSizeMb;
    private final int maxPutSizeMb;
    private final int port;

    public BlobServerConfig() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BlobServerConfig copy$default(BlobServerConfig blobServerConfig, int i2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i2 = blobServerConfig.port;
        }
        if ((i12 & 2) != 0) {
            i10 = blobServerConfig.maxCacheSizeMb;
        }
        if ((i12 & 4) != 0) {
            i11 = blobServerConfig.maxPutSizeMb;
        }
        return blobServerConfig.copy(i2, i10, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxCacheSizeMb() {
        return this.maxCacheSizeMb;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxPutSizeMb() {
        return this.maxPutSizeMb;
    }

    public final BlobServerConfig copy(int port, int maxCacheSizeMb, int maxPutSizeMb) {
        return new BlobServerConfig(port, maxCacheSizeMb, maxPutSizeMb);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlobServerConfig)) {
            return false;
        }
        BlobServerConfig blobServerConfig = (BlobServerConfig) other;
        return this.port == blobServerConfig.port && this.maxCacheSizeMb == blobServerConfig.maxCacheSizeMb && this.maxPutSizeMb == blobServerConfig.maxPutSizeMb;
    }

    public final int getMaxCacheSizeMb() {
        return this.maxCacheSizeMb;
    }

    public final int getMaxPutSizeMb() {
        return this.maxPutSizeMb;
    }

    public final int getPort() {
        return this.port;
    }

    public int hashCode() {
        return Integer.hashCode(this.maxPutSizeMb) + f.b(this.maxCacheSizeMb, Integer.hashCode(this.port) * 31, 31);
    }

    public String toString() {
        return "BlobServerConfig(port=" + this.port + ", maxCacheSizeMb=" + this.maxCacheSizeMb + ", maxPutSizeMb=" + this.maxPutSizeMb + ")";
    }

    public BlobServerConfig(int i2, int i10, int i11) {
        this.port = i2;
        this.maxCacheSizeMb = i10;
        this.maxPutSizeMb = i11;
    }

    public /* synthetic */ BlobServerConfig(int i2, int i10, int i11, int i12, q7.f fVar) {
        this((i12 & 1) != 0 ? 18800 : i2, (i12 & 2) != 0 ? 100 : i10, (i12 & 4) != 0 ? 32 : i11);
    }
}
