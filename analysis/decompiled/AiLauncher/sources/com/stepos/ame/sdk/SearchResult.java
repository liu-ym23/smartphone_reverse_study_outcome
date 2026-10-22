package com.stepos.ame.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/stepos/ame/sdk/SearchResult;", "", "id", "", "score", "", "metadata", "", "", "<init>", "(JFLjava/util/Map;)V", "getId", "()J", "getScore", "()F", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchResult {
    private final long id;
    private final Map<String, Object> metadata;
    private final float score;

    public SearchResult(long j10, float f10, Map<String, ? extends Object> map) {
        this.id = j10;
        this.score = f10;
        this.metadata = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, long j10, float f10, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = searchResult.id;
        }
        if ((i10 & 2) != 0) {
            f10 = searchResult.score;
        }
        if ((i10 & 4) != 0) {
            map = searchResult.metadata;
        }
        return searchResult.copy(j10, f10, map);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    public final Map<String, Object> component3() {
        return this.metadata;
    }

    public final SearchResult copy(long id, float score, Map<String, ? extends Object> metadata) {
        return new SearchResult(id, score, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) other;
        return this.id == searchResult.id && Float.compare(this.score, searchResult.score) == 0 && p.d(this.metadata, searchResult.metadata);
    }

    public final long getId() {
        return this.id;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final float getScore() {
        return this.score;
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.id) * 31) + Float.hashCode(this.score)) * 31;
        Map<String, Object> map = this.metadata;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "SearchResult(id=" + this.id + ", score=" + this.score + ", metadata=" + this.metadata + ")";
    }

    public /* synthetic */ SearchResult(long j10, float f10, Map map, int i10, i iVar) {
        this(j10, f10, (i10 & 4) != 0 ? null : map);
    }
}
