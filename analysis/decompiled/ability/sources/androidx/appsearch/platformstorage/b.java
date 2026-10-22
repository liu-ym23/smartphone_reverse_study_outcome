package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import androidx.appsearch.platformstorage.converter.AppSearchResultToPlatformConverter;
import androidx.concurrent.futures.ResolvableFuture;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1702a;
    public final /* synthetic */ ResolvableFuture b;

    public /* synthetic */ b(ResolvableFuture resolvableFuture, int i) {
        this.f1702a = i;
        this.b = resolvableFuture;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f1702a;
        ResolvableFuture resolvableFuture = this.b;
        AppSearchResult appSearchResult = (AppSearchResult) obj;
        switch (i) {
            case 0:
                EnterpriseGlobalSearchSessionImpl.lambda$getSchemaAsync$1(resolvableFuture, appSearchResult);
                break;
            case 1:
                GlobalSearchSessionImpl.lambda$getSchemaAsync$1(resolvableFuture, appSearchResult);
                break;
            case 2:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture);
                break;
            case 3:
                SearchSessionImpl.lambda$searchSuggestionAsync$3(resolvableFuture, appSearchResult);
                break;
            case 4:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture);
                break;
            case 5:
                SearchSessionImpl.lambda$getSchemaAsync$1(resolvableFuture, appSearchResult);
                break;
            case 6:
                SearchSessionImpl.lambda$getStorageInfoAsync$8(resolvableFuture, appSearchResult);
                break;
            case 7:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture);
                break;
            case 8:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture);
                break;
            case 9:
                SearchSessionImpl.lambda$setSchemaAsync$0(resolvableFuture, appSearchResult);
                break;
            default:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture);
                break;
        }
    }
}
