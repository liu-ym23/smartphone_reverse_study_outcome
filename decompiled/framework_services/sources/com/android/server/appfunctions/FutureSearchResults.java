package com.android.server.appfunctions;

import android.app.appsearch.AppSearchResult;
import android.app.appsearch.SearchResult;
import com.android.internal.infra.AndroidFuture;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface FutureSearchResults extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    AndroidFuture<List<SearchResult>> getNextPage();

    static Exception failedResultToException(AppSearchResult<?> appSearchResult) {
        switch(appSearchResult.getResultCode()) {
            case 3: goto L8;
            case 4: goto L11;
            case 8: goto L10;
            default: goto L9;
        };
    L9:
        return new IllegalStateException(appSearchResult.getErrorMessage());
    L10:
        return new SecurityException(appSearchResult.getErrorMessage());
    L11:
        return new IOException(appSearchResult.getErrorMessage());
    L8:
        return new IllegalArgumentException(appSearchResult.getErrorMessage());
    }
}
