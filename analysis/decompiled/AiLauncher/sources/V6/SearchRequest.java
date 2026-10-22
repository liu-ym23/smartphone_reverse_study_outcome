package V6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.api.SearchStyle;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R#\u0010\u0016\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R%\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0012\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0017\u0010\"\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b\u001d\u0010 \u001a\u0004\b\u0018\u0010!R\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\f\u0010\u0004¨\u0006$"}, d2 = {"LV6/j;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_UMID, "text", "", "Lw9/d;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "f", "()Ljava/util/List;", "types", "", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "filter", "I", "e", "topK", "Lcom/stepos/datacenter/api/SearchStyle;", "Lcom/stepos/datacenter/api/SearchStyle;", "()Lcom/stepos/datacenter/api/SearchStyle;", "style", "collection", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: V6.j, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SearchRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<InterfaceC5745d<?>> types;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> filter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int topK;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final SearchStyle style;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String collection;

    /* renamed from: a, reason: from getter */
    public final String getCollection() {
        return this.collection;
    }

    public final Map<String, Object> b() {
        return this.filter;
    }

    /* renamed from: c, reason: from getter */
    public final SearchStyle getStyle() {
        return this.style;
    }

    /* renamed from: d, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: e, reason: from getter */
    public final int getTopK() {
        return this.topK;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchRequest)) {
            return false;
        }
        SearchRequest searchRequest = (SearchRequest) other;
        return p.d(this.text, searchRequest.text) && p.d(this.types, searchRequest.types) && p.d(this.filter, searchRequest.filter) && this.topK == searchRequest.topK && this.style == searchRequest.style && p.d(this.collection, searchRequest.collection);
    }

    public final List<InterfaceC5745d<?>> f() {
        return this.types;
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        List<InterfaceC5745d<?>> list = this.types;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, Object> map = this.filter;
        int iHashCode3 = (((((iHashCode2 + (map == null ? 0 : map.hashCode())) * 31) + Integer.hashCode(this.topK)) * 31) + this.style.hashCode()) * 31;
        String str = this.collection;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SearchRequest(text=" + this.text + ", types=" + this.types + ", filter=" + this.filter + ", topK=" + this.topK + ", style=" + this.style + ", collection=" + this.collection + ")";
    }
}
