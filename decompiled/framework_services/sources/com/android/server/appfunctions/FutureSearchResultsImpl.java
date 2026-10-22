package com.android.server.appfunctions;

import android.app.appsearch.AppSearchResult;
import android.app.appsearch.SearchResult;
import android.app.appsearch.SearchResults;
import com.android.internal.infra.AndroidFuture;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class FutureSearchResultsImpl implements FutureSearchResults {
    private final Executor mExecutor;
    private final SearchResults mSearchResults;

    /* JADX INFO: renamed from: $r8$lambda$u4_-ZPGJhQ80uw8KPqeMiA_RkdM, reason: not valid java name */
    public static /* synthetic */ List m1693$r8$lambda$u4_ZPGJhQ80uw8KPqeMiA_RkdM(AppSearchResult r0) {
        return lambda$getNextPage$0(r0);
    }

    public FutureSearchResultsImpl(SearchResults searchResults, Executor executor) {
        this.mSearchResults = searchResults;
        this.mExecutor = executor;
    }

    @Override // com.android.server.appfunctions.FutureSearchResults
    public AndroidFuture<List<SearchResult>> getNextPage() {
        AndroidFuture<AppSearchResult<List<SearchResult>>> nextPageFuture = new AndroidFuture();
        this.mSearchResults.getNextPage(this.mExecutor, new FutureAppSearchSessionImpl$$ExternalSyntheticLambda1(nextPageFuture));
        return nextPageFuture.thenApply(new FutureSearchResultsImpl$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ List lambda$getNextPage$0(AppSearchResult result) {
        if (result.isSuccess() == false) goto L7;
        return (List) result.getResultValue();
    L7:
        throw new RuntimeException(FutureSearchResults.failedResultToException(result));
    }

    @Override // com.android.server.appfunctions.FutureSearchResults, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mSearchResults.close();
    }
}
