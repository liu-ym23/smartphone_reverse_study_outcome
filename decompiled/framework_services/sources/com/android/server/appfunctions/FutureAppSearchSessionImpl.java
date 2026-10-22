package com.android.server.appfunctions;

import android.app.appsearch.AppSearchBatchResult;
import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.AppSearchSession;
import android.app.appsearch.BatchResultCallback;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.GetByDocumentIdRequest;
import android.app.appsearch.GetSchemaResponse;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.RemoveByDocumentIdRequest;
import android.app.appsearch.SearchResults;
import android.app.appsearch.SearchSpec;
import android.app.appsearch.SetSchemaRequest;
import android.app.appsearch.SetSchemaResponse;
import com.android.internal.infra.AndroidFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class FutureAppSearchSessionImpl implements FutureAppSearchSession {
    private static final String TAG = null;
    private final Executor mExecutor;
    private final AndroidFuture<AppSearchResult<AppSearchSession>> mSettableSessionFuture;

    private static final class BatchResultCallbackAdapter<K, V> implements BatchResultCallback<K, V> {
        private final AndroidFuture<AppSearchBatchResult<K, V>> mFuture;

        BatchResultCallbackAdapter(AndroidFuture<AppSearchBatchResult<K, V>> future) {
            this.mFuture = future;
        }

        @Override // android.app.appsearch.BatchResultCallback
        public void onResult(AppSearchBatchResult<K, V> result) {
            this.mFuture.complete(result);
        }

        @Override // android.app.appsearch.BatchResultCallback
        public void onSystemError(Throwable t) {
            this.mFuture.completeExceptionally(t);
        }
    }

    public static /* synthetic */ GetSchemaResponse $r8$lambda$1vtyz9aT23J_5hh81zE3Mn4z3qg(AppSearchResult r0) {
        return lambda$getSchema$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$46izMU8cOzNEYsR-hxiAqbZ1lAk, reason: not valid java name */
    public static /* synthetic */ SearchResults m1689$r8$lambda$46izMU8cOzNEYsRhxiAqbZ1lAk(String r0, SearchSpec r1, AppSearchSession r2) {
        return lambda$search$8(r0, r1, r2);
    }

    public static /* synthetic */ CompletionStage $r8$lambda$5NJeJVUalJgBDGtPr2LjGbGPBQA(FutureAppSearchSessionImpl r0, SetSchemaRequest r1, AppSearchSession r2) {
        return r0.lambda$setSchema$2(r1, r2);
    }

    public static /* synthetic */ CompletionStage $r8$lambda$7cwcP4zTo1Nxbtot1zK1Wld2EAI(FutureAppSearchSessionImpl r0, RemoveByDocumentIdRequest r1, AppSearchSession r2) {
        return r0.lambda$remove$6(r1, r2);
    }

    public static /* synthetic */ CompletionStage $r8$lambda$F96CqzEt0AKZtgLzvc4hkj80hYw(FutureAppSearchSessionImpl r0, AppSearchSession r1) {
        return r0.lambda$getSchema$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$GlOi76RcRm2Kcymq1kQ8mGT3uNk(AppSearchSession r0, Throwable r1) {
        lambda$close$10(r0, r1);
    }

    public static /* synthetic */ FutureSearchResults $r8$lambda$JTDa6745wo4ym2zJzc_Mw9ETX1M(FutureAppSearchSessionImpl r0, SearchResults r1) {
        return r0.lambda$search$9(r1);
    }

    public static /* synthetic */ SetSchemaResponse $r8$lambda$QCdHjwJs_qWHKkvT1iaFVXRrhl8(AppSearchResult r0) {
        return lambda$setSchema$1(r0);
    }

    public static /* synthetic */ CompletionStage $r8$lambda$czNKsIZULcDdbQo_ehJdrGONL4E(FutureAppSearchSessionImpl r0, GetByDocumentIdRequest r1, AppSearchSession r2) {
        return r0.lambda$getByDocumentId$7(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$nKcAnFWLpA8FXrG-rG2LL_1zo-E, reason: not valid java name */
    public static /* synthetic */ AppSearchSession m1690$r8$lambda$nKcAnFWLpA8FXrGrG2LL_1zoE(AppSearchResult r0) {
        return lambda$getSessionAsync$0(r0);
    }

    public static /* synthetic */ CompletionStage $r8$lambda$wkS14ELjO4CVVC29amwYKzXNsyc(FutureAppSearchSessionImpl r0, PutDocumentsRequest r1, AppSearchSession r2) {
        return r0.lambda$put$5(r1, r2);
    }

    static {
        TAG = FutureAppSearchSession.class.getSimpleName();
    }

    public FutureAppSearchSessionImpl(AppSearchManager appSearchManager, Executor executor, AppSearchManager.SearchContext appSearchContext) {
        appSearchManager.getClass();
        executor.getClass();
        appSearchContext.getClass();
        this.mExecutor = executor;
        this.mSettableSessionFuture = new AndroidFuture();
        Executor r0 = this.mExecutor;
        AndroidFuture<AppSearchResult<AppSearchSession>> r1 = this.mSettableSessionFuture;
        r1.getClass();
        appSearchManager.createSearchSession(appSearchContext, r0, new FutureAppSearchSessionImpl$$ExternalSyntheticLambda1(r1));
    }

    private AndroidFuture<AppSearchSession> getSessionAsync() {
        return this.mSettableSessionFuture.thenApply(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda9());
    }

    private static /* synthetic */ AppSearchSession lambda$getSessionAsync$0(AppSearchResult result) {
        if (result.isSuccess() == false) goto L7;
        return (AppSearchSession) result.getResultValue();
    L7:
        throw new RuntimeException(FutureSearchResults.failedResultToException(result));
    }

    @Override // com.android.server.appfunctions.FutureAppSearchSession
    public AndroidFuture<SetSchemaResponse> setSchema(final SetSchemaRequest setSchemaRequest) {
        setSchemaRequest.getClass();
        return getSessionAsync().thenCompose(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda0(this, setSchemaRequest));
    }

    private /* synthetic */ CompletionStage lambda$setSchema$2(SetSchemaRequest setSchemaRequest, AppSearchSession session) {
        AndroidFuture<AppSearchResult<SetSchemaResponse>> settableSchemaResponse = new AndroidFuture();
        session.setSchema(setSchemaRequest, this.mExecutor, this.mExecutor, new FutureAppSearchSessionImpl$$ExternalSyntheticLambda1(settableSchemaResponse));
        return settableSchemaResponse.thenApply(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ SetSchemaResponse lambda$setSchema$1(AppSearchResult result) {
        if (result.isSuccess() == false) goto L7;
        return (SetSchemaResponse) result.getResultValue();
    L7:
        throw new RuntimeException(FutureSearchResults.failedResultToException(result));
    }

    @Override // com.android.server.appfunctions.FutureAppSearchSession
    public AndroidFuture<GetSchemaResponse> getSchema() {
        return getSessionAsync().thenCompose(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda6(this));
    }

    private /* synthetic */ CompletionStage lambda$getSchema$4(AppSearchSession session) {
        AndroidFuture<AppSearchResult<GetSchemaResponse>> settableSchemaResponse = new AndroidFuture();
        session.getSchema(this.mExecutor, new FutureAppSearchSessionImpl$$ExternalSyntheticLambda1(settableSchemaResponse));
        return settableSchemaResponse.thenApply(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda5());
    }

    private static /* synthetic */ GetSchemaResponse lambda$getSchema$3(AppSearchResult result) {
        if (result.isSuccess() == false) goto L7;
        return (GetSchemaResponse) result.getResultValue();
    L7:
        throw new RuntimeException(FutureSearchResults.failedResultToException(result));
    }

    @Override // com.android.server.appfunctions.FutureAppSearchSession
    public AndroidFuture<AppSearchBatchResult<String, Void>> put(final PutDocumentsRequest putDocumentsRequest) {
        putDocumentsRequest.getClass();
        return getSessionAsync().thenCompose(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda3(this, putDocumentsRequest));
    }

    private /* synthetic */ CompletionStage lambda$put$5(PutDocumentsRequest putDocumentsRequest, AppSearchSession session) {
        final AndroidFuture<AppSearchBatchResult<String, Void>> batchResultFuture = new AndroidFuture();
        session.put(putDocumentsRequest, this.mExecutor, new FutureAppSearchSessionImpl$$ExternalSyntheticLambda8(batchResultFuture));
        return batchResultFuture;
    }

    @Override // com.android.server.appfunctions.FutureAppSearchSession
    public AndroidFuture<AppSearchBatchResult<String, Void>> remove(final RemoveByDocumentIdRequest removeRequest) {
        removeRequest.getClass();
        return getSessionAsync().thenCompose(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda7(this, removeRequest));
    }

    private /* synthetic */ CompletionStage lambda$remove$6(RemoveByDocumentIdRequest removeRequest, AppSearchSession session) {
        AndroidFuture<AppSearchBatchResult<String, Void>> settableBatchResultFuture = new AndroidFuture();
        session.remove(removeRequest, this.mExecutor, new BatchResultCallbackAdapter(settableBatchResultFuture));
        return settableBatchResultFuture;
    }

    @Override // com.android.server.appfunctions.FutureAppSearchSession
    public AndroidFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentId(final GetByDocumentIdRequest getRequest) {
        getRequest.getClass();
        return getSessionAsync().thenCompose(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda12(this, getRequest));
    }

    private /* synthetic */ CompletionStage lambda$getByDocumentId$7(GetByDocumentIdRequest getRequest, AppSearchSession session) {
        AndroidFuture<AppSearchBatchResult<String, GenericDocument>> batchResultFuture = new AndroidFuture();
        session.getByDocumentId(getRequest, this.mExecutor, new BatchResultCallbackAdapter(batchResultFuture));
        return batchResultFuture;
    }

    @Override // com.android.server.appfunctions.FutureAppSearchSession
    public AndroidFuture<FutureSearchResults> search(final String queryExpression, final SearchSpec searchSpec) {
        return getSessionAsync().thenApply(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda10(queryExpression, searchSpec)).thenApply(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda11(this));
    }

    private static /* synthetic */ SearchResults lambda$search$8(String queryExpression, SearchSpec searchSpec, AppSearchSession session) {
        return session.search(queryExpression, searchSpec);
    }

    private /* synthetic */ FutureSearchResults lambda$search$9(SearchResults result) {
        return new FutureSearchResultsImpl(result, this.mExecutor);
    }

    @Override // com.android.server.appfunctions.FutureAppSearchSession, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        getSessionAsync().whenComplete(new FutureAppSearchSessionImpl$$ExternalSyntheticLambda4());
    }

    private static /* synthetic */ void lambda$close$10(AppSearchSession appSearchSession, Throwable throwable) {
        if (appSearchSession == null) goto L5;
        appSearchSession.close();
        return;
    }
}
