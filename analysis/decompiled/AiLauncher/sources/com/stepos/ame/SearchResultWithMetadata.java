package com.stepos.ame;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/ame/SearchResultWithMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", Const.INTENT_KEY_APIKEY, "J", "()J", "id", "", Const.INTENT_KEY_PKGNAME, "F", "c", "()F", "score", "", "Ljava/util/Map;", "()Ljava/util/Map;", "metadata", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchResultWithMetadata {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final float score;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> metadata;

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final Map<String, Object> b() {
        return this.metadata;
    }

    /* renamed from: c, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResultWithMetadata)) {
            return false;
        }
        SearchResultWithMetadata searchResultWithMetadata = (SearchResultWithMetadata) other;
        return this.id == searchResultWithMetadata.id && Float.compare(this.score, searchResultWithMetadata.score) == 0 && p.d(this.metadata, searchResultWithMetadata.metadata);
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + Float.hashCode(this.score)) * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "SearchResultWithMetadata(id=" + this.id + ", score=" + this.score + ", metadata=" + this.metadata + ")";
    }
}
