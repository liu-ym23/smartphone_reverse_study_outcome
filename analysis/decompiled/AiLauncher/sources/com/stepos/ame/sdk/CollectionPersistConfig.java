package com.stepos.ame.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x5.d;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JL\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/stepos/ame/sdk/CollectionPersistConfig;", "", d.EXTRA_ENABLED, "", "checkpointAfterWrites", "", "checkpointIdleSeconds", "useWal", "walFsyncEveryN", "asyncCheckpoint", "<init>", "(ZLjava/lang/Integer;IZIZ)V", "getEnabled", "()Z", "getCheckpointAfterWrites", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCheckpointIdleSeconds", "()I", "getUseWal", "getWalFsyncEveryN", "getAsyncCheckpoint", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "(ZLjava/lang/Integer;IZIZ)Lcom/stepos/ame/sdk/CollectionPersistConfig;", "equals", "other", "hashCode", "toString", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CollectionPersistConfig {
    private final boolean asyncCheckpoint;
    private final Integer checkpointAfterWrites;
    private final int checkpointIdleSeconds;
    private final boolean enabled;
    private final boolean useWal;
    private final int walFsyncEveryN;

    public CollectionPersistConfig() {
        this(false, null, 0, false, 0, false, 63, null);
    }

    public static /* synthetic */ CollectionPersistConfig copy$default(CollectionPersistConfig collectionPersistConfig, boolean z10, Integer num, int i10, boolean z11, int i11, boolean z12, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z10 = collectionPersistConfig.enabled;
        }
        if ((i12 & 2) != 0) {
            num = collectionPersistConfig.checkpointAfterWrites;
        }
        if ((i12 & 4) != 0) {
            i10 = collectionPersistConfig.checkpointIdleSeconds;
        }
        if ((i12 & 8) != 0) {
            z11 = collectionPersistConfig.useWal;
        }
        if ((i12 & 16) != 0) {
            i11 = collectionPersistConfig.walFsyncEveryN;
        }
        if ((i12 & 32) != 0) {
            z12 = collectionPersistConfig.asyncCheckpoint;
        }
        int i13 = i11;
        boolean z13 = z12;
        return collectionPersistConfig.copy(z10, num, i10, z11, i13, z13);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getCheckpointAfterWrites() {
        return this.checkpointAfterWrites;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCheckpointIdleSeconds() {
        return this.checkpointIdleSeconds;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getUseWal() {
        return this.useWal;
    }

    /* renamed from: component5, reason: from getter */
    public final int getWalFsyncEveryN() {
        return this.walFsyncEveryN;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getAsyncCheckpoint() {
        return this.asyncCheckpoint;
    }

    public final CollectionPersistConfig copy(boolean enabled, Integer checkpointAfterWrites, int checkpointIdleSeconds, boolean useWal, int walFsyncEveryN, boolean asyncCheckpoint) {
        return new CollectionPersistConfig(enabled, checkpointAfterWrites, checkpointIdleSeconds, useWal, walFsyncEveryN, asyncCheckpoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionPersistConfig)) {
            return false;
        }
        CollectionPersistConfig collectionPersistConfig = (CollectionPersistConfig) other;
        return this.enabled == collectionPersistConfig.enabled && p.d(this.checkpointAfterWrites, collectionPersistConfig.checkpointAfterWrites) && this.checkpointIdleSeconds == collectionPersistConfig.checkpointIdleSeconds && this.useWal == collectionPersistConfig.useWal && this.walFsyncEveryN == collectionPersistConfig.walFsyncEveryN && this.asyncCheckpoint == collectionPersistConfig.asyncCheckpoint;
    }

    public final boolean getAsyncCheckpoint() {
        return this.asyncCheckpoint;
    }

    public final Integer getCheckpointAfterWrites() {
        return this.checkpointAfterWrites;
    }

    public final int getCheckpointIdleSeconds() {
        return this.checkpointIdleSeconds;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getUseWal() {
        return this.useWal;
    }

    public final int getWalFsyncEveryN() {
        return this.walFsyncEveryN;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.enabled) * 31;
        Integer num = this.checkpointAfterWrites;
        return ((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.checkpointIdleSeconds)) * 31) + Boolean.hashCode(this.useWal)) * 31) + Integer.hashCode(this.walFsyncEveryN)) * 31) + Boolean.hashCode(this.asyncCheckpoint);
    }

    public String toString() {
        return "CollectionPersistConfig(enabled=" + this.enabled + ", checkpointAfterWrites=" + this.checkpointAfterWrites + ", checkpointIdleSeconds=" + this.checkpointIdleSeconds + ", useWal=" + this.useWal + ", walFsyncEveryN=" + this.walFsyncEveryN + ", asyncCheckpoint=" + this.asyncCheckpoint + ")";
    }

    public CollectionPersistConfig(boolean z10, Integer num, int i10, boolean z11, int i11, boolean z12) {
        this.enabled = z10;
        this.checkpointAfterWrites = num;
        this.checkpointIdleSeconds = i10;
        this.useWal = z11;
        this.walFsyncEveryN = i11;
        this.asyncCheckpoint = z12;
    }

    public /* synthetic */ CollectionPersistConfig(boolean z10, Integer num, int i10, boolean z11, int i11, boolean z12, int i12, i iVar) {
        this((i12 & 1) != 0 ? true : z10, (i12 & 2) != 0 ? null : num, (i12 & 4) != 0 ? 60 : i10, (i12 & 8) != 0 ? false : z11, (i12 & 16) != 0 ? 1 : i11, (i12 & 32) != 0 ? true : z12);
    }
}
