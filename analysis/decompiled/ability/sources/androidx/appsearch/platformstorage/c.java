package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import androidx.appsearch.platformstorage.PlatformStorage;
import androidx.concurrent.futures.ResolvableFuture;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1703a;
    public final /* synthetic */ ResolvableFuture b;
    public final /* synthetic */ PlatformStorage.GlobalSearchContext c;

    public /* synthetic */ c(ResolvableFuture resolvableFuture, PlatformStorage.GlobalSearchContext globalSearchContext, int i) {
        this.f1703a = i;
        this.b = resolvableFuture;
        this.c = globalSearchContext;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f1703a) {
            case 0:
                PlatformStorage.lambda$createEnterpriseGlobalSearchSessionAsync$2(this.b, this.c, (AppSearchResult) obj);
                break;
            default:
                PlatformStorage.lambda$createGlobalSearchSessionAsync$1(this.b, this.c, (AppSearchResult) obj);
                break;
        }
    }
}
