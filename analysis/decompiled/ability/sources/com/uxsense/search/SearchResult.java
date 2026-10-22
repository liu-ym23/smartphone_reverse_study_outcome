package com.uxsense.search;

import androidx.appfunctions.metadata.a;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u0017\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JB\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/uxsense/search/SearchResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "entityId", "", "entity", "score", "", "matchedFields", "", "Lcom/uxsense/search/MatchedField;", AppAgent.CONSTRUCT, "(JLjava/lang/Object;FLjava/util/List;)V", "getEntityId", "()J", "getEntity", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getScore", "()F", "getMatchedFields", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(JLjava/lang/Object;FLjava/util/List;)Lcom/uxsense/search/SearchResult;", "equals", "", "other", "hashCode", "", "toString", "", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchResult<T> {
    private final T entity;
    private final long entityId;
    private final List<MatchedField> matchedFields;
    private final float score;

    public SearchResult(long j5, T t9, float f, List<MatchedField> matchedFields) {
        k.f(matchedFields, "matchedFields");
        this.entityId = j5;
        this.entity = t9;
        this.score = f;
        this.matchedFields = matchedFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, long j5, Object obj, float f, List list, int i, Object obj2) {
        if ((i & 1) != 0) {
            j5 = searchResult.entityId;
        }
        long j6 = j5;
        T t9 = obj;
        if ((i & 2) != 0) {
            t9 = searchResult.entity;
        }
        T t10 = t9;
        if ((i & 4) != 0) {
            f = searchResult.score;
        }
        float f7 = f;
        if ((i & 8) != 0) {
            list = searchResult.matchedFields;
        }
        return searchResult.copy(j6, t10, f7, list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getEntityId() {
        return this.entityId;
    }

    public final T component2() {
        return this.entity;
    }

    /* renamed from: component3, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    public final List<MatchedField> component4() {
        return this.matchedFields;
    }

    public final SearchResult<T> copy(long entityId, T entity, float score, List<MatchedField> matchedFields) {
        k.f(matchedFields, "matchedFields");
        return new SearchResult<>(entityId, entity, score, matchedFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) other;
        return this.entityId == searchResult.entityId && k.b(this.entity, searchResult.entity) && Float.compare(this.score, searchResult.score) == 0 && k.b(this.matchedFields, searchResult.matchedFields);
    }

    public final T getEntity() {
        return this.entity;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public final List<MatchedField> getMatchedFields() {
        return this.matchedFields;
    }

    public final float getScore() {
        return this.score;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.entityId) * 31;
        T t9 = this.entity;
        return this.matchedFields.hashCode() + a.b(this.score, (iHashCode + (t9 == null ? 0 : t9.hashCode())) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SearchResult(entityId=");
        sb.append(this.entityId);
        sb.append(", entity=");
        sb.append(this.entity);
        sb.append(", score=");
        sb.append(this.score);
        sb.append(", matchedFields=");
        return B7.a.r(sb, this.matchedFields, ')');
    }

    public SearchResult(long j5, Object obj, float f, List list, int i, e eVar) {
        this(j5, obj, f, (i & 8) != 0 ? EmptyList.f4893a : list);
    }
}
