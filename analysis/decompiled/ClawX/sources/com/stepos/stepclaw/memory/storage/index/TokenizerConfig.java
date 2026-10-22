package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/TokenizerConfig;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "levels", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/index/NgramLevel;", "minTokenLength", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lowercase", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/util/Set;IZ)V", "getLevels", "()Ljava/util/Set;", "getMinTokenLength", "()I", "getLowercase", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TokenizerConfig {
    private final Set<NgramLevel> levels;
    private final boolean lowercase;
    private final int minTokenLength;

    public TokenizerConfig() {
        this(null, 0, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TokenizerConfig copy$default(TokenizerConfig tokenizerConfig, Set set, int i8, boolean z, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            set = tokenizerConfig.levels;
        }
        if ((i9 & 2) != 0) {
            i8 = tokenizerConfig.minTokenLength;
        }
        if ((i9 & 4) != 0) {
            z = tokenizerConfig.lowercase;
        }
        return tokenizerConfig.copy(set, i8, z);
    }

    public final Set<NgramLevel> component1() {
        return this.levels;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMinTokenLength() {
        return this.minTokenLength;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getLowercase() {
        return this.lowercase;
    }

    public final TokenizerConfig copy(Set<? extends NgramLevel> levels, int minTokenLength, boolean lowercase) {
        kotlin.jvm.internal.p.e(levels, "levels");
        return new TokenizerConfig(levels, minTokenLength, lowercase);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokenizerConfig)) {
            return false;
        }
        TokenizerConfig tokenizerConfig = (TokenizerConfig) other;
        return kotlin.jvm.internal.p.a(this.levels, tokenizerConfig.levels) && this.minTokenLength == tokenizerConfig.minTokenLength && this.lowercase == tokenizerConfig.lowercase;
    }

    public final Set<NgramLevel> getLevels() {
        return this.levels;
    }

    public final boolean getLowercase() {
        return this.lowercase;
    }

    public final int getMinTokenLength() {
        return this.minTokenLength;
    }

    public int hashCode() {
        return Boolean.hashCode(this.lowercase) + a8.b.C(this.minTokenLength, this.levels.hashCode() * 31, 31);
    }

    public String toString() {
        return "TokenizerConfig(levels=" + this.levels + ", minTokenLength=" + this.minTokenLength + ", lowercase=" + this.lowercase + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TokenizerConfig(Set<? extends NgramLevel> levels, int i8, boolean z) {
        kotlin.jvm.internal.p.e(levels, "levels");
        this.levels = levels;
        this.minTokenLength = i8;
        this.lowercase = z;
    }

    public TokenizerConfig(Set set, int i8, boolean z, int i9, kotlin.jvm.internal.i iVar) {
        this((i9 & 1) != 0 ? c5.l.k0(new NgramLevel[]{NgramLevel.BIGRAM, NgramLevel.TRIGRAM}) : set, (i9 & 2) != 0 ? 1 : i8, (i9 & 4) != 0 ? true : z);
    }
}
