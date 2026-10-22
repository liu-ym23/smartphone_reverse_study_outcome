package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import androidx.appsearch.platformstorage.PlatformStorage;
import androidx.concurrent.futures.ResolvableFuture;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1704a = 0;
    public final /* synthetic */ ResolvableFuture b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d(SearchResultsImpl searchResultsImpl, ResolvableFuture resolvableFuture) {
        this.c = searchResultsImpl;
        this.b = resolvableFuture;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f1704a) {
            case 0:
                ((SearchResultsImpl) this.c).lambda$getNextPageAsync$0(this.b, (AppSearchResult) obj);
                break;
            default:
                PlatformStorage.lambda$createSearchSessionAsync$0(this.b, (PlatformStorage.SearchContext) this.c, (AppSearchResult) obj);
                break;
        }
    }

    public /* synthetic */ d(ResolvableFuture resolvableFuture, PlatformStorage.SearchContext searchContext) {
        this.b = resolvableFuture;
        this.c = searchContext;
    }
}
