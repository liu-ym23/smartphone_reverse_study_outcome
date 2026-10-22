package androidx.appsearch.platformstorage;

import android.annotation.SuppressLint;
import android.app.appsearch.AppSearchResult;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.app.SearchResult;
import androidx.appsearch.app.SearchResults;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.platformstorage.converter.SearchResultToPlatformConverter;
import androidx.appsearch.platformstorage.util.AppSearchVersionUtil;
import androidx.collection.ArraySet;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import n3.InterfaceFutureC1739a;

@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class SearchResultsImpl implements SearchResults {
    private final Context mContext;
    private final Executor mExecutor;
    private final android.app.appsearch.SearchResults mPlatformResults;
    private final SearchSpec mSearchSpec;

    public SearchResultsImpl(android.app.appsearch.SearchResults searchResults, SearchSpec searchSpec, Executor executor, Context context) {
        this.mPlatformResults = (android.app.appsearch.SearchResults) Preconditions.checkNotNull(searchResults);
        this.mSearchSpec = (SearchSpec) Preconditions.checkNotNull(searchSpec);
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mContext = (Context) Preconditions.checkNotNull(context);
    }

    private void applyProjectionToNestedDocument(GenericDocument.Builder builder, GenericDocument genericDocument, String str, Set<String> set) {
        ArraySet arraySet = new ArraySet();
        for (String str2 : set) {
            if (str2.startsWith(str + ".")) {
                arraySet.add(str2.substring(str.length() + 1));
            }
        }
        if (arraySet.isEmpty()) {
            return;
        }
        GenericDocument.Builder builder2 = new GenericDocument.Builder(genericDocument);
        for (String str3 : genericDocument.getPropertyNames()) {
            GenericDocument propertyDocument = genericDocument.getPropertyDocument(str3);
            if (propertyDocument != null) {
                applyProjectionToNestedDocument(builder2, propertyDocument, str3, arraySet);
            } else if (!arraySet.contains(str3)) {
                builder2.clearProperty(str3);
            }
        }
        builder.setPropertyDocument(str, builder2.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getNextPageAsync$0(ResolvableFuture resolvableFuture, AppSearchResult appSearchResult) {
        if (!appSearchResult.isSuccess()) {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
            return;
        }
        List list = (List) appSearchResult.getResultValue();
        ArrayList arrayList = new ArrayList(list.size());
        Map<String, List<String>> projections = this.mSearchSpec.getProjections();
        boolean z10 = (Build.VERSION.SDK_INT < 34) && ((AppSearchVersionUtil.getAppSearchVersionCode(this.mContext) > AppSearchVersionUtil.APPSEARCH_U_BASE_VERSION_CODE ? 1 : (AppSearchVersionUtil.getAppSearchVersionCode(this.mContext) == AppSearchVersionUtil.APPSEARCH_U_BASE_VERSION_CODE ? 0 : -1)) < 0) && !projections.isEmpty();
        for (int i = 0; i < list.size(); i++) {
            SearchResult jetpackSearchResult = SearchResultToPlatformConverter.toJetpackSearchResult((android.app.appsearch.SearchResult) list.get(i));
            if (z10) {
                arrayList.add(manuallyApplyProjection(jetpackSearchResult, projections));
            } else {
                arrayList.add(jetpackSearchResult);
            }
        }
        resolvableFuture.set(arrayList);
    }

    private SearchResult manuallyApplyProjection(SearchResult searchResult, Map<String, List<String>> map) {
        GenericDocument genericDocument = searchResult.getGenericDocument();
        GenericDocument.Builder builder = new GenericDocument.Builder(genericDocument);
        List<String> list = map.get(genericDocument.getSchemaType());
        List<String> list2 = map.get("*");
        ArraySet arraySet = list != null ? new ArraySet(list) : list2 != null ? new ArraySet(list2) : null;
        if (arraySet != null) {
            for (String str : genericDocument.getPropertyNames()) {
                GenericDocument propertyDocument = genericDocument.getPropertyDocument(str);
                if (propertyDocument != null) {
                    applyProjectionToNestedDocument(builder, propertyDocument, str, arraySet);
                } else if (!arraySet.contains(str)) {
                    builder.clearProperty(str);
                }
            }
        }
        SearchResult.Builder genericDocument2 = new SearchResult.Builder(searchResult).setGenericDocument(builder.build());
        List<SearchResult.MatchInfo> matchInfos = searchResult.getMatchInfos();
        if (!matchInfos.isEmpty()) {
            genericDocument2.clearMatchInfos();
        }
        for (SearchResult.MatchInfo matchInfo : matchInfos) {
            String propertyPath = matchInfo.getPropertyPath();
            boolean z10 = false;
            boolean z11 = list != null && list.contains(propertyPath);
            if (list2 != null && list2.contains(propertyPath)) {
                z10 = true;
            }
            if (z11 || z10) {
                genericDocument2.addMatchInfo(new SearchResult.MatchInfo.Builder(matchInfo).build());
            }
        }
        return genericDocument2.build();
    }

    @Override // androidx.appsearch.app.SearchResults, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mPlatformResults.close();
    }

    @Override // androidx.appsearch.app.SearchResults
    @SuppressLint({"WrongConstant"})
    public InterfaceFutureC1739a getNextPageAsync() {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformResults.getNextPage(this.mExecutor, new d(this, resolvableFutureCreate));
        return resolvableFutureCreate;
    }
}
