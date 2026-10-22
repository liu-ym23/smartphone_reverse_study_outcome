package com.stepos.ame.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/stepos/ame/sdk/SearchBatchResult;", "", "results", "", "Lcom/stepos/ame/sdk/SearchResult;", "<init>", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchBatchResult {
    private final List<List<SearchResult>> results;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchBatchResult(List<? extends List<SearchResult>> results) {
        p.i(results, "results");
        this.results = results;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchBatchResult copy$default(SearchBatchResult searchBatchResult, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = searchBatchResult.results;
        }
        return searchBatchResult.copy(list);
    }

    public final List<List<SearchResult>> component1() {
        return this.results;
    }

    public final SearchBatchResult copy(List<? extends List<SearchResult>> results) {
        p.i(results, "results");
        return new SearchBatchResult(results);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SearchBatchResult) && p.d(this.results, ((SearchBatchResult) other).results);
    }

    public final List<List<SearchResult>> getResults() {
        return this.results;
    }

    public int hashCode() {
        return this.results.hashCode();
    }

    public String toString() {
        return "SearchBatchResult(results=" + this.results + ")";
    }
}
