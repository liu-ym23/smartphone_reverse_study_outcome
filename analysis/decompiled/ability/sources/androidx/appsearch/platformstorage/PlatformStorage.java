package androidx.appsearch.platformstorage;

import android.annotation.SuppressLint;
import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.AppSearchSession;
import android.app.appsearch.EnterpriseGlobalSearchSession;
import android.app.appsearch.GlobalSearchSession;
import android.content.Context;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.appsearch.app.AppSearchEnvironmentFactory;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.Features;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.platformstorage.converter.SearchContextToPlatformConverter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import n3.InterfaceFutureC1739a;

@RequiresApi(31)
/* loaded from: classes.dex */
public final class PlatformStorage {
    static final Executor EXECUTOR = AppSearchEnvironmentFactory.getEnvironmentInstance().createCachedThreadPoolExecutor();

    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void createEnterpriseGlobalSearchSession(AppSearchManager appSearchManager, Executor executor, Consumer<AppSearchResult<EnterpriseGlobalSearchSession>> consumer) {
            appSearchManager.createEnterpriseGlobalSearchSession(executor, consumer);
        }
    }

    public static final class GlobalSearchContext {
        final Context mContext;
        final Executor mExecutor;

        public static final class Builder {
            private final Context mContext;
            private Executor mExecutor;

            public Builder(Context context) {
                this.mContext = (Context) Preconditions.checkNotNull(context);
            }

            public GlobalSearchContext build() {
                if (this.mExecutor == null) {
                    this.mExecutor = PlatformStorage.EXECUTOR;
                }
                return new GlobalSearchContext(this.mContext, this.mExecutor);
            }

            public Builder setWorkerExecutor(Executor executor) {
                Preconditions.checkNotNull(executor);
                this.mExecutor = executor;
                return this;
            }
        }

        public GlobalSearchContext(Context context, Executor executor) {
            this.mContext = (Context) Preconditions.checkNotNull(context);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        public Context getContext() {
            return this.mContext;
        }

        public Executor getWorkerExecutor() {
            return this.mExecutor;
        }
    }

    public static final class SearchContext {
        final Context mContext;
        final String mDatabaseName;
        final Executor mExecutor;

        public static final class Builder {
            private final Context mContext;
            private final String mDatabaseName;
            private Executor mExecutor;

            public Builder(Context context, String str) {
                this.mContext = (Context) Preconditions.checkNotNull(context);
                Preconditions.checkNotNull(str);
                if (str.contains("/")) {
                    throw new IllegalArgumentException("Database name cannot contain '/'");
                }
                this.mDatabaseName = str;
            }

            public SearchContext build() {
                if (this.mExecutor == null) {
                    this.mExecutor = PlatformStorage.EXECUTOR;
                }
                return new SearchContext(this.mContext, this.mDatabaseName, this.mExecutor);
            }

            public Builder setWorkerExecutor(Executor executor) {
                this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
                return this;
            }
        }

        public SearchContext(Context context, String str, Executor executor) {
            this.mContext = (Context) Preconditions.checkNotNull(context);
            this.mDatabaseName = (String) Preconditions.checkNotNull(str);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        public Context getContext() {
            return this.mContext;
        }

        public String getDatabaseName() {
            return this.mDatabaseName;
        }

        public Executor getWorkerExecutor() {
            return this.mExecutor;
        }
    }

    private PlatformStorage() {
    }

    @RequiresApi(35)
    @SuppressLint({"WrongConstant"})
    public static InterfaceFutureC1739a createEnterpriseGlobalSearchSessionAsync(GlobalSearchContext globalSearchContext) {
        if (Build.VERSION.SDK_INT < 35) {
            throw new UnsupportedOperationException("ENTERPRISE_GLOBAL_SEARCH_SESSION is not supported on this AppSearch implementation");
        }
        Preconditions.checkNotNull(globalSearchContext);
        AppSearchManager appSearchManager = (AppSearchManager) globalSearchContext.mContext.getSystemService(AppSearchManager.class);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        ApiHelperForV.createEnterpriseGlobalSearchSession(appSearchManager, globalSearchContext.mExecutor, new c(resolvableFutureCreate, globalSearchContext, 0));
        return resolvableFutureCreate;
    }

    @SuppressLint({"WrongConstant"})
    public static InterfaceFutureC1739a createGlobalSearchSessionAsync(GlobalSearchContext globalSearchContext) {
        Preconditions.checkNotNull(globalSearchContext);
        AppSearchManager appSearchManager = (AppSearchManager) globalSearchContext.mContext.getSystemService(AppSearchManager.class);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        appSearchManager.createGlobalSearchSession(globalSearchContext.mExecutor, new c(resolvableFutureCreate, globalSearchContext, 1));
        return resolvableFutureCreate;
    }

    @SuppressLint({"WrongConstant"})
    public static InterfaceFutureC1739a createSearchSessionAsync(SearchContext searchContext) {
        Preconditions.checkNotNull(searchContext);
        AppSearchManager appSearchManager = (AppSearchManager) searchContext.mContext.getSystemService(AppSearchManager.class);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        appSearchManager.createSearchSession(SearchContextToPlatformConverter.toPlatformSearchContext(searchContext), searchContext.mExecutor, new d(resolvableFutureCreate, searchContext));
        return resolvableFutureCreate;
    }

    @ExperimentalAppSearchApi
    public static Features getFeatures(Context context) {
        return new FeaturesImpl(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createEnterpriseGlobalSearchSessionAsync$2(ResolvableFuture resolvableFuture, GlobalSearchContext globalSearchContext, AppSearchResult appSearchResult) {
        if (appSearchResult.isSuccess()) {
            resolvableFuture.set(new EnterpriseGlobalSearchSessionImpl(androidx.appfunctions.a.a(appSearchResult.getResultValue()), globalSearchContext.mExecutor, globalSearchContext.mContext));
        } else {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createGlobalSearchSessionAsync$1(ResolvableFuture resolvableFuture, GlobalSearchContext globalSearchContext, AppSearchResult appSearchResult) {
        if (appSearchResult.isSuccess()) {
            resolvableFuture.set(new GlobalSearchSessionImpl((GlobalSearchSession) appSearchResult.getResultValue(), globalSearchContext.mExecutor, globalSearchContext.mContext));
        } else {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createSearchSessionAsync$0(ResolvableFuture resolvableFuture, SearchContext searchContext, AppSearchResult appSearchResult) {
        if (appSearchResult.isSuccess()) {
            resolvableFuture.set(new SearchSessionImpl((AppSearchSession) appSearchResult.getResultValue(), searchContext.mExecutor, searchContext.mContext));
        } else {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
        }
    }
}
