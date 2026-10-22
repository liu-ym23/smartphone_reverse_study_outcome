package com.android.server.appfunctions;

import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.GlobalSearchSession;
import android.app.appsearch.SearchResults;
import android.app.appsearch.SearchSpec;
import android.app.appsearch.observer.ObserverCallback;
import android.app.appsearch.observer.ObserverSpec;
import com.android.internal.infra.AndroidFuture;
import java.io.Closeable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class FutureGlobalSearchSession implements Closeable {
    private static final String TAG = null;
    private final Executor mExecutor;
    private final AndroidFuture<AppSearchResult<GlobalSearchSession>> mSettableSessionFuture;

    /* JADX INFO: renamed from: $r8$lambda$0qHG0pa-4z42mlbsXVHJ9J0p-Mk, reason: not valid java name */
    public static /* synthetic */ SearchResults m1691$r8$lambda$0qHG0pa4z42mlbsXVHJ9J0pMk(String r0, SearchSpec r1, GlobalSearchSession r2) {
        return lambda$search$1(r0, r1, r2);
    }

    public static /* synthetic */ GlobalSearchSession $r8$lambda$EtxqmNDQz_MWov7nuq1eqfjOUx0(AppSearchResult r0) {
        return lambda$getSessionAsync$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$i-ta5WlaweofGofCKsVRgg4AMJQ, reason: not valid java name */
    public static /* synthetic */ FutureSearchResults m1692$r8$lambda$ita5WlaweofGofCKsVRgg4AMJQ(FutureGlobalSearchSession r0, SearchResults r1) {
        return r0.lambda$search$2(r1);
    }

    public static /* synthetic */ CompletionStage $r8$lambda$mstb6dlOJg0h7MKcQGG8wlw7KmI(String r0, ObserverSpec r1, Executor r2, ObserverCallback r3, GlobalSearchSession r4) {
        return lambda$registerObserverCallbackAsync$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$y6tL64kMFsgVw73V5YAS3rQA3go(GlobalSearchSession r0, Throwable r1) {
        lambda$close$4(r0, r1);
    }

    static {
        TAG = FutureGlobalSearchSession.class.getSimpleName();
    }

    public FutureGlobalSearchSession(AppSearchManager appSearchManager, Executor executor) {
        this.mExecutor = executor;
        this.mSettableSessionFuture = new AndroidFuture();
        Executor r0 = this.mExecutor;
        AndroidFuture<AppSearchResult<GlobalSearchSession>> r1 = this.mSettableSessionFuture;
        r1.getClass();
        appSearchManager.createGlobalSearchSession(r0, new FutureAppSearchSessionImpl$$ExternalSyntheticLambda1(r1));
    }

    private AndroidFuture<GlobalSearchSession> getSessionAsync() {
        return this.mSettableSessionFuture.thenApply(new FutureGlobalSearchSession$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ GlobalSearchSession lambda$getSessionAsync$0(AppSearchResult result) {
        if (result.isSuccess() == false) goto L7;
        return (GlobalSearchSession) result.getResultValue();
    L7:
        throw new RuntimeException(FutureSearchResults.failedResultToException(result));
    }

    public AndroidFuture<FutureSearchResults> search(final String queryExpression, final SearchSpec searchSpec) {
        return getSessionAsync().thenApply(new FutureGlobalSearchSession$$ExternalSyntheticLambda3(queryExpression, searchSpec)).thenApply(new FutureGlobalSearchSession$$ExternalSyntheticLambda4(this));
    }

    private static /* synthetic */ SearchResults lambda$search$1(String queryExpression, SearchSpec searchSpec, GlobalSearchSession session) {
        return session.search(queryExpression, searchSpec);
    }

    private /* synthetic */ FutureSearchResults lambda$search$2(SearchResults result) {
        return new FutureSearchResultsImpl(result, this.mExecutor);
    }

    public AndroidFuture<Void> registerObserverCallbackAsync(final String targetPackageName, final ObserverSpec spec, final Executor executor, final ObserverCallback observer) {
        return getSessionAsync().thenCompose(new FutureGlobalSearchSession$$ExternalSyntheticLambda1(targetPackageName, spec, executor, observer));
    }

    private static /* synthetic */ CompletionStage lambda$registerObserverCallbackAsync$3(String targetPackageName, ObserverSpec spec, Executor executor, ObserverCallback observer, GlobalSearchSession session) {
        session.registerObserverCallback(targetPackageName, spec, executor, observer);     // Catch: android.app.appsearch.exceptions.AppSearchException -> L4
        return AndroidFuture.completedFuture(null);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        getSessionAsync().whenComplete(new FutureGlobalSearchSession$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ void lambda$close$4(GlobalSearchSession appSearchSession, Throwable throwable) {
        if (appSearchSession == null) goto L5;
        appSearchSession.close();
        return;
    }
}
