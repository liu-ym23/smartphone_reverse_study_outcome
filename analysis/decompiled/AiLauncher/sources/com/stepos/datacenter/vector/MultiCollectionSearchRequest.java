package com.stepos.datacenter.vector;

import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e7.MultiCollectionQuery;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015JJ\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0010J\u001a\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010\u0012R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b%\u0010\u0010R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010\u0015¨\u0006("}, d2 = {"Lcom/stepos/datacenter/vector/MultiCollectionSearchRequest;", "", "", "Le7/f;", "queries", "", "topK", "", "normalizeWeights", "rrfK", QueryAlgorithmBundle.KEY_CATEGORY, "<init>", "(Ljava/util/List;IZILjava/lang/Integer;)V", "component1", "()Ljava/util/List;", "component2", "()I", "component3", "()Z", "component4", "component5", "()Ljava/lang/Integer;", ChatTracker.CLICK_COPY, "(Ljava/util/List;IZILjava/lang/Integer;)Lcom/stepos/datacenter/vector/MultiCollectionSearchRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getQueries", "I", "getTopK", "Z", "getNormalizeWeights", "getRrfK", "Ljava/lang/Integer;", "getCategory", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MultiCollectionSearchRequest {
    private final Integer category;
    private final boolean normalizeWeights;
    private final List<MultiCollectionQuery> queries;
    private final int rrfK;
    private final int topK;

    public MultiCollectionSearchRequest(List<MultiCollectionQuery> queries, int i10, boolean z10, int i11, Integer num) {
        p.i(queries, "queries");
        this.queries = queries;
        this.topK = i10;
        this.normalizeWeights = z10;
        this.rrfK = i11;
        this.category = num;
        if (queries.isEmpty()) {
            throw new IllegalArgumentException("at least one MultiCollectionQuery required");
        }
        if (i10 <= 0) {
            throw new IllegalArgumentException(("topK must be > 0, got " + i10).toString());
        }
        if (i11 < 0) {
            throw new IllegalArgumentException(("rrfK must be >= 0, got " + i11).toString());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : queries) {
            String collectionId = ((MultiCollectionQuery) obj).getCollectionId();
            Object arrayList = linkedHashMap.get(collectionId);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(collectionId, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((List) entry.getValue()).size() > 1) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        Set setKeySet = linkedHashMap2.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException(("each collectionId should appear at most once in queries, duplicates: " + setKeySet).toString());
    }

    public static /* synthetic */ MultiCollectionSearchRequest copy$default(MultiCollectionSearchRequest multiCollectionSearchRequest, List list, int i10, boolean z10, int i11, Integer num, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = multiCollectionSearchRequest.queries;
        }
        if ((i12 & 2) != 0) {
            i10 = multiCollectionSearchRequest.topK;
        }
        if ((i12 & 4) != 0) {
            z10 = multiCollectionSearchRequest.normalizeWeights;
        }
        if ((i12 & 8) != 0) {
            i11 = multiCollectionSearchRequest.rrfK;
        }
        if ((i12 & 16) != 0) {
            num = multiCollectionSearchRequest.category;
        }
        Integer num2 = num;
        boolean z11 = z10;
        return multiCollectionSearchRequest.copy(list, i10, z11, i11, num2);
    }

    public final List<MultiCollectionQuery> component1() {
        return this.queries;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTopK() {
        return this.topK;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getNormalizeWeights() {
        return this.normalizeWeights;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRrfK() {
        return this.rrfK;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getCategory() {
        return this.category;
    }

    public final MultiCollectionSearchRequest copy(List<MultiCollectionQuery> queries, int topK, boolean normalizeWeights, int rrfK, Integer category) {
        p.i(queries, "queries");
        return new MultiCollectionSearchRequest(queries, topK, normalizeWeights, rrfK, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiCollectionSearchRequest)) {
            return false;
        }
        MultiCollectionSearchRequest multiCollectionSearchRequest = (MultiCollectionSearchRequest) other;
        return p.d(this.queries, multiCollectionSearchRequest.queries) && this.topK == multiCollectionSearchRequest.topK && this.normalizeWeights == multiCollectionSearchRequest.normalizeWeights && this.rrfK == multiCollectionSearchRequest.rrfK && p.d(this.category, multiCollectionSearchRequest.category);
    }

    public final Integer getCategory() {
        return this.category;
    }

    public final boolean getNormalizeWeights() {
        return this.normalizeWeights;
    }

    public final List<MultiCollectionQuery> getQueries() {
        return this.queries;
    }

    public final int getRrfK() {
        return this.rrfK;
    }

    public final int getTopK() {
        return this.topK;
    }

    public int hashCode() {
        int iHashCode = ((((((this.queries.hashCode() * 31) + Integer.hashCode(this.topK)) * 31) + Boolean.hashCode(this.normalizeWeights)) * 31) + Integer.hashCode(this.rrfK)) * 31;
        Integer num = this.category;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "MultiCollectionSearchRequest(queries=" + this.queries + ", topK=" + this.topK + ", normalizeWeights=" + this.normalizeWeights + ", rrfK=" + this.rrfK + ", category=" + this.category + ")";
    }

    public /* synthetic */ MultiCollectionSearchRequest(List list, int i10, boolean z10, int i11, Integer num, int i12, i iVar) {
        this(list, i10, (i12 & 4) != 0 ? true : z10, (i12 & 8) != 0 ? 60 : i11, (i12 & 16) != 0 ? null : num);
    }
}
