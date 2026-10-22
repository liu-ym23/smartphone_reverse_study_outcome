package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/BM25Config;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "k1", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "b", "tokenizerConfig", "Lcom/stepos/stepclaw/memory/storage/index/TokenizerConfig;", "<init>", "(DDLcom/stepos/stepclaw/memory/storage/index/TokenizerConfig;)V", "getK1", "()D", "getB", "getTokenizerConfig", "()Lcom/stepos/stepclaw/memory/storage/index/TokenizerConfig;", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BM25Config {
    private final double b;
    private final double k1;
    private final TokenizerConfig tokenizerConfig;

    public BM25Config() {
        this(0.0d, 0.0d, null, 7, null);
    }

    public static /* synthetic */ BM25Config copy$default(BM25Config bM25Config, double d, double d9, TokenizerConfig tokenizerConfig, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            d = bM25Config.k1;
        }
        double d10 = d;
        if ((i8 & 2) != 0) {
            d9 = bM25Config.b;
        }
        double d11 = d9;
        if ((i8 & 4) != 0) {
            tokenizerConfig = bM25Config.tokenizerConfig;
        }
        return bM25Config.copy(d10, d11, tokenizerConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final double getK1() {
        return this.k1;
    }

    /* renamed from: component2, reason: from getter */
    public final double getB() {
        return this.b;
    }

    /* renamed from: component3, reason: from getter */
    public final TokenizerConfig getTokenizerConfig() {
        return this.tokenizerConfig;
    }

    public final BM25Config copy(double k12, double b9, TokenizerConfig tokenizerConfig) {
        kotlin.jvm.internal.p.e(tokenizerConfig, "tokenizerConfig");
        return new BM25Config(k12, b9, tokenizerConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BM25Config)) {
            return false;
        }
        BM25Config bM25Config = (BM25Config) other;
        return Double.compare(this.k1, bM25Config.k1) == 0 && Double.compare(this.b, bM25Config.b) == 0 && kotlin.jvm.internal.p.a(this.tokenizerConfig, bM25Config.tokenizerConfig);
    }

    public final double getB() {
        return this.b;
    }

    public final double getK1() {
        return this.k1;
    }

    public final TokenizerConfig getTokenizerConfig() {
        return this.tokenizerConfig;
    }

    public int hashCode() {
        return this.tokenizerConfig.hashCode() + ((Double.hashCode(this.b) + (Double.hashCode(this.k1) * 31)) * 31);
    }

    public String toString() {
        return "BM25Config(k1=" + this.k1 + ", b=" + this.b + ", tokenizerConfig=" + this.tokenizerConfig + ")";
    }

    public BM25Config(double d, double d9, TokenizerConfig tokenizerConfig) {
        kotlin.jvm.internal.p.e(tokenizerConfig, "tokenizerConfig");
        this.k1 = d;
        this.b = d9;
        this.tokenizerConfig = tokenizerConfig;
    }

    public /* synthetic */ BM25Config(double d, double d9, TokenizerConfig tokenizerConfig, int i8, kotlin.jvm.internal.i iVar) {
        this((i8 & 1) != 0 ? 1.2d : d, (i8 & 2) != 0 ? 0.75d : d9, (i8 & 4) != 0 ? new TokenizerConfig(null, 0, false, 7, null) : tokenizerConfig);
    }
}
