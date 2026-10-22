package com.stepos.datacenter.vector;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006*"}, d2 = {"Lcom/stepos/datacenter/vector/CollectionHealth;", "", "collectionId", "", "quarantinedSnapshotPaths", "", "vectorCount", "", "primaryIndexId", "currentAlgorithm", "Lcom/stepos/datacenter/vector/IndexType;", "recommendedAlgorithm", "algorithmMismatch", "", "<init>", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Lcom/stepos/datacenter/vector/IndexType;Lcom/stepos/datacenter/vector/IndexType;Z)V", "getCollectionId", "()Ljava/lang/String;", "getQuarantinedSnapshotPaths", "()Ljava/util/List;", "getVectorCount", "()I", "getPrimaryIndexId", "getCurrentAlgorithm", "()Lcom/stepos/datacenter/vector/IndexType;", "getRecommendedAlgorithm", "getAlgorithmMismatch", "()Z", "hasQuarantine", "getHasQuarantine", "component1", "component2", "component3", "component4", "component5", "component6", "component7", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CollectionHealth {
    private final boolean algorithmMismatch;
    private final String collectionId;
    private final IndexType currentAlgorithm;
    private final String primaryIndexId;
    private final List<String> quarantinedSnapshotPaths;
    private final IndexType recommendedAlgorithm;
    private final int vectorCount;

    public CollectionHealth(String collectionId, List<String> quarantinedSnapshotPaths, int i10, String primaryIndexId, IndexType indexType, IndexType indexType2, boolean z10) {
        p.i(collectionId, "collectionId");
        p.i(quarantinedSnapshotPaths, "quarantinedSnapshotPaths");
        p.i(primaryIndexId, "primaryIndexId");
        this.collectionId = collectionId;
        this.quarantinedSnapshotPaths = quarantinedSnapshotPaths;
        this.vectorCount = i10;
        this.primaryIndexId = primaryIndexId;
        this.currentAlgorithm = indexType;
        this.recommendedAlgorithm = indexType2;
        this.algorithmMismatch = z10;
    }

    public static /* synthetic */ CollectionHealth copy$default(CollectionHealth collectionHealth, String str, List list, int i10, String str2, IndexType indexType, IndexType indexType2, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = collectionHealth.collectionId;
        }
        if ((i11 & 2) != 0) {
            list = collectionHealth.quarantinedSnapshotPaths;
        }
        if ((i11 & 4) != 0) {
            i10 = collectionHealth.vectorCount;
        }
        if ((i11 & 8) != 0) {
            str2 = collectionHealth.primaryIndexId;
        }
        if ((i11 & 16) != 0) {
            indexType = collectionHealth.currentAlgorithm;
        }
        if ((i11 & 32) != 0) {
            indexType2 = collectionHealth.recommendedAlgorithm;
        }
        if ((i11 & 64) != 0) {
            z10 = collectionHealth.algorithmMismatch;
        }
        IndexType indexType3 = indexType2;
        boolean z11 = z10;
        IndexType indexType4 = indexType;
        int i12 = i10;
        return collectionHealth.copy(str, list, i12, str2, indexType4, indexType3, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCollectionId() {
        return this.collectionId;
    }

    public final List<String> component2() {
        return this.quarantinedSnapshotPaths;
    }

    /* renamed from: component3, reason: from getter */
    public final int getVectorCount() {
        return this.vectorCount;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPrimaryIndexId() {
        return this.primaryIndexId;
    }

    /* renamed from: component5, reason: from getter */
    public final IndexType getCurrentAlgorithm() {
        return this.currentAlgorithm;
    }

    /* renamed from: component6, reason: from getter */
    public final IndexType getRecommendedAlgorithm() {
        return this.recommendedAlgorithm;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getAlgorithmMismatch() {
        return this.algorithmMismatch;
    }

    public final CollectionHealth copy(String collectionId, List<String> quarantinedSnapshotPaths, int vectorCount, String primaryIndexId, IndexType currentAlgorithm, IndexType recommendedAlgorithm, boolean algorithmMismatch) {
        p.i(collectionId, "collectionId");
        p.i(quarantinedSnapshotPaths, "quarantinedSnapshotPaths");
        p.i(primaryIndexId, "primaryIndexId");
        return new CollectionHealth(collectionId, quarantinedSnapshotPaths, vectorCount, primaryIndexId, currentAlgorithm, recommendedAlgorithm, algorithmMismatch);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionHealth)) {
            return false;
        }
        CollectionHealth collectionHealth = (CollectionHealth) other;
        return p.d(this.collectionId, collectionHealth.collectionId) && p.d(this.quarantinedSnapshotPaths, collectionHealth.quarantinedSnapshotPaths) && this.vectorCount == collectionHealth.vectorCount && p.d(this.primaryIndexId, collectionHealth.primaryIndexId) && this.currentAlgorithm == collectionHealth.currentAlgorithm && this.recommendedAlgorithm == collectionHealth.recommendedAlgorithm && this.algorithmMismatch == collectionHealth.algorithmMismatch;
    }

    public final boolean getAlgorithmMismatch() {
        return this.algorithmMismatch;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final IndexType getCurrentAlgorithm() {
        return this.currentAlgorithm;
    }

    public final boolean getHasQuarantine() {
        return !this.quarantinedSnapshotPaths.isEmpty();
    }

    public final String getPrimaryIndexId() {
        return this.primaryIndexId;
    }

    public final List<String> getQuarantinedSnapshotPaths() {
        return this.quarantinedSnapshotPaths;
    }

    public final IndexType getRecommendedAlgorithm() {
        return this.recommendedAlgorithm;
    }

    public final int getVectorCount() {
        return this.vectorCount;
    }

    public int hashCode() {
        int iHashCode = ((((((this.collectionId.hashCode() * 31) + this.quarantinedSnapshotPaths.hashCode()) * 31) + Integer.hashCode(this.vectorCount)) * 31) + this.primaryIndexId.hashCode()) * 31;
        IndexType indexType = this.currentAlgorithm;
        int iHashCode2 = (iHashCode + (indexType == null ? 0 : indexType.hashCode())) * 31;
        IndexType indexType2 = this.recommendedAlgorithm;
        return ((iHashCode2 + (indexType2 != null ? indexType2.hashCode() : 0)) * 31) + Boolean.hashCode(this.algorithmMismatch);
    }

    public String toString() {
        return "CollectionHealth(collectionId=" + this.collectionId + ", quarantinedSnapshotPaths=" + this.quarantinedSnapshotPaths + ", vectorCount=" + this.vectorCount + ", primaryIndexId=" + this.primaryIndexId + ", currentAlgorithm=" + this.currentAlgorithm + ", recommendedAlgorithm=" + this.recommendedAlgorithm + ", algorithmMismatch=" + this.algorithmMismatch + ")";
    }

    public /* synthetic */ CollectionHealth(String str, List list, int i10, String str2, IndexType indexType, IndexType indexType2, boolean z10, int i11, i iVar) {
        this(str, list, i10, str2, (i11 & 16) != 0 ? null : indexType, (i11 & 32) != 0 ? null : indexType2, (i11 & 64) != 0 ? false : z10);
    }
}
