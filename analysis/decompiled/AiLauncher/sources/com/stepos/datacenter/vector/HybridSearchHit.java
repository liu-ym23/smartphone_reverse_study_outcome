package com.stepos.datacenter.vector;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 Jh\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\tHÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/stepos/datacenter/vector/HybridSearchHit;", "", "entityId", "", "entityClassName", "", "combinedScore", "", "keywordRank", "", "keywordBm25", "", "keywordSnippet", "vectorRank", "vectorDistance", "<init>", "(JLjava/lang/String;FLjava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;)V", "getEntityId", "()J", "getEntityClassName", "()Ljava/lang/String;", "getCombinedScore", "()F", "getKeywordRank", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getKeywordBm25", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getKeywordSnippet", "getVectorRank", "getVectorDistance", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ChatTracker.CLICK_COPY, "(JLjava/lang/String;FLjava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;)Lcom/stepos/datacenter/vector/HybridSearchHit;", "equals", "", "other", "hashCode", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HybridSearchHit {
    private final float combinedScore;
    private final String entityClassName;
    private final long entityId;
    private final Double keywordBm25;
    private final Integer keywordRank;
    private final String keywordSnippet;
    private final Float vectorDistance;
    private final Integer vectorRank;

    public HybridSearchHit(long j10, String entityClassName, float f10, Integer num, Double d10, String str, Integer num2, Float f11) {
        p.i(entityClassName, "entityClassName");
        this.entityId = j10;
        this.entityClassName = entityClassName;
        this.combinedScore = f10;
        this.keywordRank = num;
        this.keywordBm25 = d10;
        this.keywordSnippet = str;
        this.vectorRank = num2;
        this.vectorDistance = f11;
    }

    public static /* synthetic */ HybridSearchHit copy$default(HybridSearchHit hybridSearchHit, long j10, String str, float f10, Integer num, Double d10, String str2, Integer num2, Float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = hybridSearchHit.entityId;
        }
        long j11 = j10;
        if ((i10 & 2) != 0) {
            str = hybridSearchHit.entityClassName;
        }
        String str3 = str;
        if ((i10 & 4) != 0) {
            f10 = hybridSearchHit.combinedScore;
        }
        float f12 = f10;
        if ((i10 & 8) != 0) {
            num = hybridSearchHit.keywordRank;
        }
        return hybridSearchHit.copy(j11, str3, f12, num, (i10 & 16) != 0 ? hybridSearchHit.keywordBm25 : d10, (i10 & 32) != 0 ? hybridSearchHit.keywordSnippet : str2, (i10 & 64) != 0 ? hybridSearchHit.vectorRank : num2, (i10 & 128) != 0 ? hybridSearchHit.vectorDistance : f11);
    }

    /* renamed from: component1, reason: from getter */
    public final long getEntityId() {
        return this.entityId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEntityClassName() {
        return this.entityClassName;
    }

    /* renamed from: component3, reason: from getter */
    public final float getCombinedScore() {
        return this.combinedScore;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getKeywordRank() {
        return this.keywordRank;
    }

    /* renamed from: component5, reason: from getter */
    public final Double getKeywordBm25() {
        return this.keywordBm25;
    }

    /* renamed from: component6, reason: from getter */
    public final String getKeywordSnippet() {
        return this.keywordSnippet;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getVectorRank() {
        return this.vectorRank;
    }

    /* renamed from: component8, reason: from getter */
    public final Float getVectorDistance() {
        return this.vectorDistance;
    }

    public final HybridSearchHit copy(long entityId, String entityClassName, float combinedScore, Integer keywordRank, Double keywordBm25, String keywordSnippet, Integer vectorRank, Float vectorDistance) {
        p.i(entityClassName, "entityClassName");
        return new HybridSearchHit(entityId, entityClassName, combinedScore, keywordRank, keywordBm25, keywordSnippet, vectorRank, vectorDistance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HybridSearchHit)) {
            return false;
        }
        HybridSearchHit hybridSearchHit = (HybridSearchHit) other;
        return this.entityId == hybridSearchHit.entityId && p.d(this.entityClassName, hybridSearchHit.entityClassName) && Float.compare(this.combinedScore, hybridSearchHit.combinedScore) == 0 && p.d(this.keywordRank, hybridSearchHit.keywordRank) && p.d(this.keywordBm25, hybridSearchHit.keywordBm25) && p.d(this.keywordSnippet, hybridSearchHit.keywordSnippet) && p.d(this.vectorRank, hybridSearchHit.vectorRank) && p.d(this.vectorDistance, hybridSearchHit.vectorDistance);
    }

    public final float getCombinedScore() {
        return this.combinedScore;
    }

    public final String getEntityClassName() {
        return this.entityClassName;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public final Double getKeywordBm25() {
        return this.keywordBm25;
    }

    public final Integer getKeywordRank() {
        return this.keywordRank;
    }

    public final String getKeywordSnippet() {
        return this.keywordSnippet;
    }

    public final Float getVectorDistance() {
        return this.vectorDistance;
    }

    public final Integer getVectorRank() {
        return this.vectorRank;
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.entityId) * 31) + this.entityClassName.hashCode()) * 31) + Float.hashCode(this.combinedScore)) * 31;
        Integer num = this.keywordRank;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Double d10 = this.keywordBm25;
        int iHashCode3 = (iHashCode2 + (d10 == null ? 0 : d10.hashCode())) * 31;
        String str = this.keywordSnippet;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.vectorRank;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f10 = this.vectorDistance;
        return iHashCode5 + (f10 != null ? f10.hashCode() : 0);
    }

    public String toString() {
        return "HybridSearchHit(entityId=" + this.entityId + ", entityClassName=" + this.entityClassName + ", combinedScore=" + this.combinedScore + ", keywordRank=" + this.keywordRank + ", keywordBm25=" + this.keywordBm25 + ", keywordSnippet=" + this.keywordSnippet + ", vectorRank=" + this.vectorRank + ", vectorDistance=" + this.vectorDistance + ")";
    }
}
