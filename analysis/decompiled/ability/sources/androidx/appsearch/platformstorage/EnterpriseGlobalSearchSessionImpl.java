package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.app.EnterpriseGlobalSearchSession;
import androidx.appsearch.app.Features;
import androidx.appsearch.app.GetByDocumentIdRequest;
import androidx.appsearch.app.SearchResults;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.platformstorage.converter.AppSearchResultToPlatformConverter;
import androidx.appsearch.platformstorage.converter.RequestToPlatformConverter;
import androidx.appsearch.platformstorage.converter.SearchSpecToPlatformConverter;
import androidx.appsearch.platformstorage.util.BatchResultCallbackAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.function.Function;
import n3.InterfaceFutureC1739a;

@RequiresApi(35)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class EnterpriseGlobalSearchSessionImpl implements EnterpriseGlobalSearchSession {
    private final Context mContext;
    private final Executor mExecutor;
    private final Features mFeatures;
    private final android.app.appsearch.EnterpriseGlobalSearchSession mPlatformSession;

    public EnterpriseGlobalSearchSessionImpl(android.app.appsearch.EnterpriseGlobalSearchSession enterpriseGlobalSearchSession, Executor executor, Context context) {
        this.mPlatformSession = androidx.appfunctions.a.a(Preconditions.checkNotNull(enterpriseGlobalSearchSession));
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        Context context2 = (Context) Preconditions.checkNotNull(context);
        this.mContext = context2;
        this.mFeatures = new FeaturesImpl(context2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AppSearchBatchResult lambda$getByDocumentIdAsync$0(GetByDocumentIdRequest getByDocumentIdRequest, AppSearchBatchResult appSearchBatchResult) {
        if (getByDocumentIdRequest.getIds().isEmpty() || !appSearchBatchResult.getAll().isEmpty()) {
            return appSearchBatchResult;
        }
        AppSearchBatchResult.Builder builder = new AppSearchBatchResult.Builder();
        String namespace = getByDocumentIdRequest.getNamespace();
        for (String str : getByDocumentIdRequest.getIds()) {
            builder.setFailure(str, 6, androidx.appfunctions.metadata.a.m("Document (", namespace, ", ", str, ") not found."));
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getSchemaAsync$1(ResolvableFuture resolvableFuture, AppSearchResult appSearchResult) {
        AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture, new E3.d(4));
    }

    @Override // androidx.appsearch.app.EnterpriseGlobalSearchSession
    public InterfaceFutureC1739a getByDocumentIdAsync(String str, String str2, final GetByDocumentIdRequest getByDocumentIdRequest) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(getByDocumentIdRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.getByDocumentId(str, str2, RequestToPlatformConverter.toPlatformGetByDocumentIdRequest(getByDocumentIdRequest), this.mExecutor, new BatchResultCallbackAdapter(resolvableFutureCreate, new E3.d(3), new Function() { // from class: androidx.appsearch.platformstorage.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return EnterpriseGlobalSearchSessionImpl.lambda$getByDocumentIdAsync$0(getByDocumentIdRequest, (AppSearchBatchResult) obj);
            }
        }));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.EnterpriseGlobalSearchSession
    public Features getFeatures() {
        return this.mFeatures;
    }

    @Override // androidx.appsearch.app.EnterpriseGlobalSearchSession
    public InterfaceFutureC1739a getSchemaAsync(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.getSchema(str, str2, this.mExecutor, new b(resolvableFutureCreate, 0));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.EnterpriseGlobalSearchSession
    public SearchResults search(String str, SearchSpec searchSpec) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(searchSpec);
        return new SearchResultsImpl(this.mPlatformSession.search(str, SearchSpecToPlatformConverter.toPlatformSearchSpec(this.mContext, searchSpec)), searchSpec, this.mExecutor, this.mContext);
    }
}
