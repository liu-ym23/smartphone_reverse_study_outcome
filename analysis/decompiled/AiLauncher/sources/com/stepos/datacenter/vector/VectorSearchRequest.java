package com.stepos.datacenter.vector;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001*BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0012J\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJR\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0012R%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010\u001b¨\u0006+"}, d2 = {"Lcom/stepos/datacenter/vector/VectorSearchRequest;", "", "", "queryVector", "", "topK", "", "", "filter", QueryAlgorithmBundle.KEY_CATEGORY, "collection", "<init>", "([FILjava/util/Map;Ljava/lang/Integer;Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "component1", "()[F", "component2", "component3", "()Ljava/util/Map;", "component4", "()Ljava/lang/Integer;", "component5", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "([FILjava/util/Map;Ljava/lang/Integer;Ljava/lang/String;)Lcom/stepos/datacenter/vector/VectorSearchRequest;", "toString", "[F", "getQueryVector", "I", "getTopK", "Ljava/util/Map;", "getFilter", "Ljava/lang/Integer;", "getCategory", "Ljava/lang/String;", "getCollection", "Companion", Const.INTENT_KEY_APIKEY, "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VectorSearchRequest {
    public static final String DEFAULT_COLLECTION = "default";
    private final Integer category;
    private final String collection;
    private final Map<String, Object> filter;
    private final float[] queryVector;
    private final int topK;

    public VectorSearchRequest(float[] queryVector, int i10, Map<String, ? extends Object> map, Integer num, String collection) {
        p.i(queryVector, "queryVector");
        p.i(collection, "collection");
        this.queryVector = queryVector;
        this.topK = i10;
        this.filter = map;
        this.category = num;
        this.collection = collection;
    }

    public static /* synthetic */ VectorSearchRequest copy$default(VectorSearchRequest vectorSearchRequest, float[] fArr, int i10, Map map, Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            fArr = vectorSearchRequest.queryVector;
        }
        if ((i11 & 2) != 0) {
            i10 = vectorSearchRequest.topK;
        }
        if ((i11 & 4) != 0) {
            map = vectorSearchRequest.filter;
        }
        if ((i11 & 8) != 0) {
            num = vectorSearchRequest.category;
        }
        if ((i11 & 16) != 0) {
            str = vectorSearchRequest.collection;
        }
        String str2 = str;
        Map map2 = map;
        return vectorSearchRequest.copy(fArr, i10, map2, num, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final float[] getQueryVector() {
        return this.queryVector;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTopK() {
        return this.topK;
    }

    public final Map<String, Object> component3() {
        return this.filter;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getCategory() {
        return this.category;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCollection() {
        return this.collection;
    }

    public final VectorSearchRequest copy(float[] queryVector, int topK, Map<String, ? extends Object> filter, Integer category, String collection) {
        p.i(queryVector, "queryVector");
        p.i(collection, "collection");
        return new VectorSearchRequest(queryVector, topK, filter, category, collection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!p.d(VectorSearchRequest.class, other != null ? other.getClass() : null)) {
            return false;
        }
        p.g(other, "null cannot be cast to non-null type com.stepos.datacenter.vector.VectorSearchRequest");
        VectorSearchRequest vectorSearchRequest = (VectorSearchRequest) other;
        return this.topK == vectorSearchRequest.topK && p.d(this.category, vectorSearchRequest.category) && p.d(this.collection, vectorSearchRequest.collection) && p.d(this.filter, vectorSearchRequest.filter) && Arrays.equals(this.queryVector, vectorSearchRequest.queryVector);
    }

    public final Integer getCategory() {
        return this.category;
    }

    public final String getCollection() {
        return this.collection;
    }

    public final Map<String, Object> getFilter() {
        return this.filter;
    }

    public final float[] getQueryVector() {
        return this.queryVector;
    }

    public final int getTopK() {
        return this.topK;
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.queryVector) * 31) + this.topK) * 31;
        Map<String, Object> map = this.filter;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Integer num = this.category;
        return ((iHashCode2 + (num != null ? num.intValue() : 0)) * 31) + this.collection.hashCode();
    }

    public String toString() {
        return "VectorSearchRequest(queryVector=" + Arrays.toString(this.queryVector) + ", topK=" + this.topK + ", filter=" + this.filter + ", category=" + this.category + ", collection=" + this.collection + ")";
    }

    public /* synthetic */ VectorSearchRequest(float[] fArr, int i10, Map map, Integer num, String str, int i11, i iVar) {
        this(fArr, (i11 & 2) != 0 ? 10 : i10, (i11 & 4) != 0 ? null : map, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? "default" : str);
    }
}
