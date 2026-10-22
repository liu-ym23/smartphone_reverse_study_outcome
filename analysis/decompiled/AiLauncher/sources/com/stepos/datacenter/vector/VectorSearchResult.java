package com.stepos.datacenter.vector;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006 "}, d2 = {"Lcom/stepos/datacenter/vector/VectorSearchResult;", "", "vectorId", "", "entityId", "entityClassName", "", "distance", "", "label", "<init>", "(JJLjava/lang/String;FLjava/lang/String;)V", "getVectorId", "()J", "getEntityId", "getEntityClassName", "()Ljava/lang/String;", "getDistance", "()F", "getLabel", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VectorSearchResult {
    private final float distance;
    private final String entityClassName;
    private final long entityId;
    private final String label;
    private final long vectorId;

    public VectorSearchResult(long j10, long j11, String entityClassName, float f10, String label) {
        p.i(entityClassName, "entityClassName");
        p.i(label, "label");
        this.vectorId = j10;
        this.entityId = j11;
        this.entityClassName = entityClassName;
        this.distance = f10;
        this.label = label;
    }

    public static /* synthetic */ VectorSearchResult copy$default(VectorSearchResult vectorSearchResult, long j10, long j11, String str, float f10, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = vectorSearchResult.vectorId;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            j11 = vectorSearchResult.entityId;
        }
        long j13 = j11;
        if ((i10 & 4) != 0) {
            str = vectorSearchResult.entityClassName;
        }
        String str3 = str;
        if ((i10 & 8) != 0) {
            f10 = vectorSearchResult.distance;
        }
        float f11 = f10;
        if ((i10 & 16) != 0) {
            str2 = vectorSearchResult.label;
        }
        return vectorSearchResult.copy(j12, j13, str3, f11, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getVectorId() {
        return this.vectorId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEntityId() {
        return this.entityId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEntityClassName() {
        return this.entityClassName;
    }

    /* renamed from: component4, reason: from getter */
    public final float getDistance() {
        return this.distance;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final VectorSearchResult copy(long vectorId, long entityId, String entityClassName, float distance, String label) {
        p.i(entityClassName, "entityClassName");
        p.i(label, "label");
        return new VectorSearchResult(vectorId, entityId, entityClassName, distance, label);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VectorSearchResult)) {
            return false;
        }
        VectorSearchResult vectorSearchResult = (VectorSearchResult) other;
        return this.vectorId == vectorSearchResult.vectorId && this.entityId == vectorSearchResult.entityId && p.d(this.entityClassName, vectorSearchResult.entityClassName) && Float.compare(this.distance, vectorSearchResult.distance) == 0 && p.d(this.label, vectorSearchResult.label);
    }

    public final float getDistance() {
        return this.distance;
    }

    public final String getEntityClassName() {
        return this.entityClassName;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getVectorId() {
        return this.vectorId;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.vectorId) * 31) + Long.hashCode(this.entityId)) * 31) + this.entityClassName.hashCode()) * 31) + Float.hashCode(this.distance)) * 31) + this.label.hashCode();
    }

    public String toString() {
        return "VectorSearchResult(vectorId=" + this.vectorId + ", entityId=" + this.entityId + ", entityClassName=" + this.entityClassName + ", distance=" + this.distance + ", label=" + this.label + ")";
    }

    public /* synthetic */ VectorSearchResult(long j10, long j11, String str, float f10, String str2, int i10, i iVar) {
        this(j10, j11, str, f10, (i10 & 16) != 0 ? "" : str2);
    }
}
