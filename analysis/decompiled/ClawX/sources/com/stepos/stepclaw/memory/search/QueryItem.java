package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/stepclaw/memory/search/QueryItem;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "query", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "categories", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getQuery", "()Ljava/lang/String;", "getCategories", "()Ljava/util/List;", "component1", "component2", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class QueryItem {
    private final List<String> categories;
    private final String query;

    public QueryItem(String query, List<String> categories) {
        p.e(query, "query");
        p.e(categories, "categories");
        this.query = query;
        this.categories = categories;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryItem copy$default(QueryItem queryItem, String str, List list, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = queryItem.query;
        }
        if ((i8 & 2) != 0) {
            list = queryItem.categories;
        }
        return queryItem.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    public final List<String> component2() {
        return this.categories;
    }

    public final QueryItem copy(String query, List<String> categories) {
        p.e(query, "query");
        p.e(categories, "categories");
        return new QueryItem(query, categories);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryItem)) {
            return false;
        }
        QueryItem queryItem = (QueryItem) other;
        return p.a(this.query, queryItem.query) && p.a(this.categories, queryItem.categories);
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final String getQuery() {
        return this.query;
    }

    public int hashCode() {
        return this.categories.hashCode() + (this.query.hashCode() * 31);
    }

    public String toString() {
        return "QueryItem(query=" + this.query + ", categories=" + this.categories + ")";
    }
}
