package V6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.api.SearchStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"LV6/k;", "", "", "LV6/i;", "hits", "Lcom/stepos/datacenter/api/SearchStyle;", "resolvedStyle", "", "totalLatencyMs", "<init>", "(Ljava/util/List;Lcom/stepos/datacenter/api/SearchStyle;J)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "getHits", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/datacenter/api/SearchStyle;", "getResolvedStyle", "()Lcom/stepos/datacenter/api/SearchStyle;", "c", "J", "getTotalLatencyMs", "()J", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: V6.k, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SearchResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<SearchHit> hits;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final SearchStyle resolvedStyle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final long totalLatencyMs;

    public SearchResult(List<SearchHit> hits, SearchStyle resolvedStyle, long j10) {
        p.i(hits, "hits");
        p.i(resolvedStyle, "resolvedStyle");
        this.hits = hits;
        this.resolvedStyle = resolvedStyle;
        this.totalLatencyMs = j10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) other;
        return p.d(this.hits, searchResult.hits) && this.resolvedStyle == searchResult.resolvedStyle && this.totalLatencyMs == searchResult.totalLatencyMs;
    }

    public int hashCode() {
        return (((this.hits.hashCode() * 31) + this.resolvedStyle.hashCode()) * 31) + Long.hashCode(this.totalLatencyMs);
    }

    public String toString() {
        return "SearchResult(hits=" + this.hits + ", resolvedStyle=" + this.resolvedStyle + ", totalLatencyMs=" + this.totalLatencyMs + ")";
    }
}
