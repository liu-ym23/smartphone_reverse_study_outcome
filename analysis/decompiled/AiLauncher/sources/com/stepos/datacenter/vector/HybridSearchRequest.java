package com.stepos.datacenter.vector;

import La.H;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b9\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010;\u001a\u00020\fH\u0016J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010C\u001a\u00020\fHÆ\u0003J\t\u0010D\u001a\u00020\fHÆ\u0003J\t\u0010E\u001a\u00020\fHÆ\u0003J\t\u0010F\u001a\u00020\u0011HÆ\u0003J\t\u0010G\u001a\u00020\u0011HÆ\u0003J\t\u0010H\u001a\u00020\u0011HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010J\u001a\u00020\u0011HÆ\u0003J\t\u0010K\u001a\u00020\bHÆ\u0003J\u0015\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0003J\u0015\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018HÆ\u0003J\t\u0010N\u001a\u00020\bHÆ\u0003Jê\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\b2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00182\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u00182\b\b\u0002\u0010\u001b\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010PJ\t\u0010Q\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u0013\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010)\u001a\u0004\b2\u0010(R\u0011\u0010\u0015\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0011\u0010\u0016\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\b\n\u0000\u001a\u0004\b7\u00106R\u0011\u0010\u001b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$¨\u0006R"}, d2 = {"Lcom/stepos/datacenter/vector/HybridSearchRequest;", "", "keyword", "", "queryVector", "", "collection", "keywordWeight", "", "vectorWeight", "keywordTableName", QueryAlgorithmBundle.KEY_CATEGORY, "", "topK", "rrfK", "perPathTopK", "normalizeWeights", "", "deduplicateByParent", "rerankerEnabled", "rerankerTopK", "temporalDecayEnabled", "temporalHalfLifeDays", "createdAtMs", "", "", "accessCounts", "accessWeight", "<init>", "(Ljava/lang/String;[FLjava/lang/String;FFLjava/lang/String;Ljava/lang/Integer;IIIZZZLjava/lang/Integer;ZFLjava/util/Map;Ljava/util/Map;F)V", "getKeyword", "()Ljava/lang/String;", "getQueryVector", "()[F", "getCollection", "getKeywordWeight", "()F", "getVectorWeight", "getKeywordTableName", "getCategory", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopK", "()I", "getRrfK", "getPerPathTopK", "getNormalizeWeights", "()Z", "getDeduplicateByParent", "getRerankerEnabled", "getRerankerTopK", "getTemporalDecayEnabled", "getTemporalHalfLifeDays", "getCreatedAtMs", "()Ljava/util/Map;", "getAccessCounts", "getAccessWeight", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", ChatTracker.CLICK_COPY, "(Ljava/lang/String;[FLjava/lang/String;FFLjava/lang/String;Ljava/lang/Integer;IIIZZZLjava/lang/Integer;ZFLjava/util/Map;Ljava/util/Map;F)Lcom/stepos/datacenter/vector/HybridSearchRequest;", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HybridSearchRequest {
    private final Map<Long, Integer> accessCounts;
    private final float accessWeight;
    private final Integer category;
    private final String collection;
    private final Map<Long, Long> createdAtMs;
    private final boolean deduplicateByParent;
    private final String keyword;
    private final String keywordTableName;
    private final float keywordWeight;
    private final boolean normalizeWeights;
    private final int perPathTopK;
    private final float[] queryVector;
    private final boolean rerankerEnabled;
    private final Integer rerankerTopK;
    private final int rrfK;
    private final boolean temporalDecayEnabled;
    private final float temporalHalfLifeDays;
    private final int topK;
    private final float vectorWeight;

    public HybridSearchRequest(String keyword, float[] queryVector, String collection, float f10, float f11, String str, Integer num, int i10, int i11, int i12, boolean z10, boolean z11, boolean z12, Integer num2, boolean z13, float f12, Map<Long, Long> createdAtMs, Map<Long, Integer> accessCounts, float f13) {
        int iIntValue;
        p.i(keyword, "keyword");
        p.i(queryVector, "queryVector");
        p.i(collection, "collection");
        p.i(createdAtMs, "createdAtMs");
        p.i(accessCounts, "accessCounts");
        this.keyword = keyword;
        this.queryVector = queryVector;
        this.collection = collection;
        this.keywordWeight = f10;
        this.vectorWeight = f11;
        this.keywordTableName = str;
        this.category = num;
        this.topK = i10;
        this.rrfK = i11;
        this.perPathTopK = i12;
        this.normalizeWeights = z10;
        this.deduplicateByParent = z11;
        this.rerankerEnabled = z12;
        this.rerankerTopK = num2;
        this.temporalDecayEnabled = z13;
        this.temporalHalfLifeDays = f12;
        this.createdAtMs = createdAtMs;
        this.accessCounts = accessCounts;
        this.accessWeight = f13;
        if (H.x0(keyword)) {
            throw new IllegalArgumentException("keyword must not be blank");
        }
        if (queryVector.length == 0) {
            throw new IllegalArgumentException("queryVector must not be empty");
        }
        if (H.x0(collection)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("keywordWeight must be >= 0, got " + f10).toString());
        }
        if (f11 < 0.0f) {
            throw new IllegalArgumentException(("vectorWeight must be >= 0, got " + f11).toString());
        }
        if (i10 <= 0) {
            throw new IllegalArgumentException(("topK must be > 0, got " + i10).toString());
        }
        if (i11 < 0) {
            throw new IllegalArgumentException(("rrfK must be >= 0, got " + i11).toString());
        }
        if (i12 <= 0) {
            throw new IllegalArgumentException(("perPathTopK must be > 0, got " + i12).toString());
        }
        if (f10 + f11 <= 0.0f) {
            throw new IllegalArgumentException("at least one of keywordWeight / vectorWeight must be > 0");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException(("temporalHalfLifeDays must be > 0, got " + f12).toString());
        }
        if (num2 == null || (iIntValue = num2.intValue()) > 0) {
            return;
        }
        throw new IllegalArgumentException(("rerankerTopK must be > 0, got " + iIntValue).toString());
    }

    public static /* synthetic */ HybridSearchRequest copy$default(HybridSearchRequest hybridSearchRequest, String str, float[] fArr, String str2, float f10, float f11, String str3, Integer num, int i10, int i11, int i12, boolean z10, boolean z11, boolean z12, Integer num2, boolean z13, float f12, Map map, Map map2, float f13, int i13, Object obj) {
        float f14;
        Map map3;
        String str4 = (i13 & 1) != 0 ? hybridSearchRequest.keyword : str;
        float[] fArr2 = (i13 & 2) != 0 ? hybridSearchRequest.queryVector : fArr;
        String str5 = (i13 & 4) != 0 ? hybridSearchRequest.collection : str2;
        float f15 = (i13 & 8) != 0 ? hybridSearchRequest.keywordWeight : f10;
        float f16 = (i13 & 16) != 0 ? hybridSearchRequest.vectorWeight : f11;
        String str6 = (i13 & 32) != 0 ? hybridSearchRequest.keywordTableName : str3;
        Integer num3 = (i13 & 64) != 0 ? hybridSearchRequest.category : num;
        int i14 = (i13 & 128) != 0 ? hybridSearchRequest.topK : i10;
        int i15 = (i13 & 256) != 0 ? hybridSearchRequest.rrfK : i11;
        int i16 = (i13 & 512) != 0 ? hybridSearchRequest.perPathTopK : i12;
        boolean z14 = (i13 & 1024) != 0 ? hybridSearchRequest.normalizeWeights : z10;
        boolean z15 = (i13 & 2048) != 0 ? hybridSearchRequest.deduplicateByParent : z11;
        boolean z16 = (i13 & 4096) != 0 ? hybridSearchRequest.rerankerEnabled : z12;
        Integer num4 = (i13 & b.THRESHOLD) != 0 ? hybridSearchRequest.rerankerTopK : num2;
        String str7 = str4;
        boolean z17 = (i13 & 16384) != 0 ? hybridSearchRequest.temporalDecayEnabled : z13;
        float f17 = (i13 & 32768) != 0 ? hybridSearchRequest.temporalHalfLifeDays : f12;
        Map map4 = (i13 & 65536) != 0 ? hybridSearchRequest.createdAtMs : map;
        Map map5 = (i13 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? hybridSearchRequest.accessCounts : map2;
        if ((i13 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0) {
            map3 = map5;
            f14 = hybridSearchRequest.accessWeight;
        } else {
            f14 = f13;
            map3 = map5;
        }
        return hybridSearchRequest.copy(str7, fArr2, str5, f15, f16, str6, num3, i14, i15, i16, z14, z15, z16, num4, z17, f17, map4, map3, f14);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKeyword() {
        return this.keyword;
    }

    /* renamed from: component10, reason: from getter */
    public final int getPerPathTopK() {
        return this.perPathTopK;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getNormalizeWeights() {
        return this.normalizeWeights;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getDeduplicateByParent() {
        return this.deduplicateByParent;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getRerankerEnabled() {
        return this.rerankerEnabled;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getRerankerTopK() {
        return this.rerankerTopK;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getTemporalDecayEnabled() {
        return this.temporalDecayEnabled;
    }

    /* renamed from: component16, reason: from getter */
    public final float getTemporalHalfLifeDays() {
        return this.temporalHalfLifeDays;
    }

    public final Map<Long, Long> component17() {
        return this.createdAtMs;
    }

    public final Map<Long, Integer> component18() {
        return this.accessCounts;
    }

    /* renamed from: component19, reason: from getter */
    public final float getAccessWeight() {
        return this.accessWeight;
    }

    /* renamed from: component2, reason: from getter */
    public final float[] getQueryVector() {
        return this.queryVector;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCollection() {
        return this.collection;
    }

    /* renamed from: component4, reason: from getter */
    public final float getKeywordWeight() {
        return this.keywordWeight;
    }

    /* renamed from: component5, reason: from getter */
    public final float getVectorWeight() {
        return this.vectorWeight;
    }

    /* renamed from: component6, reason: from getter */
    public final String getKeywordTableName() {
        return this.keywordTableName;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getCategory() {
        return this.category;
    }

    /* renamed from: component8, reason: from getter */
    public final int getTopK() {
        return this.topK;
    }

    /* renamed from: component9, reason: from getter */
    public final int getRrfK() {
        return this.rrfK;
    }

    public final HybridSearchRequest copy(String keyword, float[] queryVector, String collection, float keywordWeight, float vectorWeight, String keywordTableName, Integer category, int topK, int rrfK, int perPathTopK, boolean normalizeWeights, boolean deduplicateByParent, boolean rerankerEnabled, Integer rerankerTopK, boolean temporalDecayEnabled, float temporalHalfLifeDays, Map<Long, Long> createdAtMs, Map<Long, Integer> accessCounts, float accessWeight) {
        p.i(keyword, "keyword");
        p.i(queryVector, "queryVector");
        p.i(collection, "collection");
        p.i(createdAtMs, "createdAtMs");
        p.i(accessCounts, "accessCounts");
        return new HybridSearchRequest(keyword, queryVector, collection, keywordWeight, vectorWeight, keywordTableName, category, topK, rrfK, perPathTopK, normalizeWeights, deduplicateByParent, rerankerEnabled, rerankerTopK, temporalDecayEnabled, temporalHalfLifeDays, createdAtMs, accessCounts, accessWeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HybridSearchRequest)) {
            return false;
        }
        HybridSearchRequest hybridSearchRequest = (HybridSearchRequest) other;
        return p.d(this.keyword, hybridSearchRequest.keyword) && Arrays.equals(this.queryVector, hybridSearchRequest.queryVector) && p.d(this.collection, hybridSearchRequest.collection) && this.keywordWeight == hybridSearchRequest.keywordWeight && this.vectorWeight == hybridSearchRequest.vectorWeight && p.d(this.keywordTableName, hybridSearchRequest.keywordTableName) && p.d(this.category, hybridSearchRequest.category) && this.topK == hybridSearchRequest.topK && this.rrfK == hybridSearchRequest.rrfK && this.perPathTopK == hybridSearchRequest.perPathTopK && this.normalizeWeights == hybridSearchRequest.normalizeWeights && this.deduplicateByParent == hybridSearchRequest.deduplicateByParent && this.rerankerEnabled == hybridSearchRequest.rerankerEnabled && p.d(this.rerankerTopK, hybridSearchRequest.rerankerTopK) && this.temporalDecayEnabled == hybridSearchRequest.temporalDecayEnabled && this.temporalHalfLifeDays == hybridSearchRequest.temporalHalfLifeDays && p.d(this.createdAtMs, hybridSearchRequest.createdAtMs) && p.d(this.accessCounts, hybridSearchRequest.accessCounts) && this.accessWeight == hybridSearchRequest.accessWeight;
    }

    public final Map<Long, Integer> getAccessCounts() {
        return this.accessCounts;
    }

    public final float getAccessWeight() {
        return this.accessWeight;
    }

    public final Integer getCategory() {
        return this.category;
    }

    public final String getCollection() {
        return this.collection;
    }

    public final Map<Long, Long> getCreatedAtMs() {
        return this.createdAtMs;
    }

    public final boolean getDeduplicateByParent() {
        return this.deduplicateByParent;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final String getKeywordTableName() {
        return this.keywordTableName;
    }

    public final float getKeywordWeight() {
        return this.keywordWeight;
    }

    public final boolean getNormalizeWeights() {
        return this.normalizeWeights;
    }

    public final int getPerPathTopK() {
        return this.perPathTopK;
    }

    public final float[] getQueryVector() {
        return this.queryVector;
    }

    public final boolean getRerankerEnabled() {
        return this.rerankerEnabled;
    }

    public final Integer getRerankerTopK() {
        return this.rerankerTopK;
    }

    public final int getRrfK() {
        return this.rrfK;
    }

    public final boolean getTemporalDecayEnabled() {
        return this.temporalDecayEnabled;
    }

    public final float getTemporalHalfLifeDays() {
        return this.temporalHalfLifeDays;
    }

    public final int getTopK() {
        return this.topK;
    }

    public final float getVectorWeight() {
        return this.vectorWeight;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.keyword.hashCode() * 31) + Arrays.hashCode(this.queryVector)) * 31) + this.collection.hashCode()) * 31) + Float.hashCode(this.keywordWeight)) * 31) + Float.hashCode(this.vectorWeight)) * 31;
        String str = this.keywordTableName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.category;
        int iIntValue = (((((((((((((iHashCode2 + (num != null ? num.intValue() : 0)) * 31) + this.topK) * 31) + this.rrfK) * 31) + this.perPathTopK) * 31) + Boolean.hashCode(this.normalizeWeights)) * 31) + Boolean.hashCode(this.deduplicateByParent)) * 31) + Boolean.hashCode(this.rerankerEnabled)) * 31;
        Integer num2 = this.rerankerTopK;
        return ((((iIntValue + (num2 != null ? num2.intValue() : 0)) * 31) + Boolean.hashCode(this.temporalDecayEnabled)) * 31) + Float.hashCode(this.temporalHalfLifeDays);
    }

    public String toString() {
        return "HybridSearchRequest(keyword=" + this.keyword + ", queryVector=" + Arrays.toString(this.queryVector) + ", collection=" + this.collection + ", keywordWeight=" + this.keywordWeight + ", vectorWeight=" + this.vectorWeight + ", keywordTableName=" + this.keywordTableName + ", category=" + this.category + ", topK=" + this.topK + ", rrfK=" + this.rrfK + ", perPathTopK=" + this.perPathTopK + ", normalizeWeights=" + this.normalizeWeights + ", deduplicateByParent=" + this.deduplicateByParent + ", rerankerEnabled=" + this.rerankerEnabled + ", rerankerTopK=" + this.rerankerTopK + ", temporalDecayEnabled=" + this.temporalDecayEnabled + ", temporalHalfLifeDays=" + this.temporalHalfLifeDays + ", createdAtMs=" + this.createdAtMs + ", accessCounts=" + this.accessCounts + ", accessWeight=" + this.accessWeight + ")";
    }

    public /* synthetic */ HybridSearchRequest(String str, float[] fArr, String str2, float f10, float f11, String str3, Integer num, int i10, int i11, int i12, boolean z10, boolean z11, boolean z12, Integer num2, boolean z13, float f12, Map map, Map map2, float f13, int i13, i iVar) {
        this(str, fArr, (i13 & 4) != 0 ? "default" : str2, (i13 & 8) != 0 ? 0.5f : f10, (i13 & 16) != 0 ? 0.5f : f11, (i13 & 32) != 0 ? null : str3, (i13 & 64) != 0 ? null : num, i10, (i13 & 256) != 0 ? 60 : i11, (i13 & 512) != 0 ? 50 : i12, (i13 & 1024) != 0 ? true : z10, (i13 & 2048) != 0 ? false : z11, (i13 & 4096) != 0 ? false : z12, (i13 & b.THRESHOLD) != 0 ? null : num2, (i13 & 16384) != 0 ? false : z13, (32768 & i13) != 0 ? 30.0f : f12, (65536 & i13) != 0 ? a.i() : map, (131072 & i13) != 0 ? a.i() : map2, (i13 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? 0.1f : f13);
    }
}
