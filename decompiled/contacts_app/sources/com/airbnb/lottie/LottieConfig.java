package com.airbnb.lottie;

import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class LottieConfig {
    final LottieNetworkCacheProvider cacheProvider;
    final boolean disablePathInterpolatorCache;
    final boolean enableNetworkCache;
    final boolean enableSystraceMarkers;
    final LottieNetworkFetcher networkFetcher;

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private LottieNetworkCacheProvider cacheProvider;
        private boolean disablePathInterpolatorCache;
        private boolean enableNetworkCache;
        private boolean enableSystraceMarkers;
        private LottieNetworkFetcher networkFetcher;

        public Builder() {
            this.enableSystraceMarkers = false;
            this.enableNetworkCache = true;
            this.disablePathInterpolatorCache = true;
        }

        public Builder setNetworkFetcher(LottieNetworkFetcher r1) {
            this.networkFetcher = r1;
            return this;
        }

        public Builder setNetworkCacheDir(final File r2) {
            if (this.cacheProvider != null) goto L7;
            this.cacheProvider = new AnonymousClass1(this, r2);
            return this;
        L7:
            throw new IllegalStateException("There is already a cache provider!");
        }

        public Builder setNetworkCacheProvider(final LottieNetworkCacheProvider r2) {
            if (this.cacheProvider != null) goto L7;
            this.cacheProvider = new AnonymousClass2(this, r2);
            return this;
        L7:
            throw new IllegalStateException("There is already a cache provider!");
        }

        public Builder setEnableSystraceMarkers(boolean r1) {
            this.enableSystraceMarkers = r1;
            return this;
        }

        public Builder setEnableNetworkCache(boolean r1) {
            this.enableNetworkCache = r1;
            return this;
        }

        public Builder setDisablePathInterpolatorCache(boolean r1) {
            this.disablePathInterpolatorCache = r1;
            return this;
        }

        public LottieConfig build() {
            return new LottieConfig(this.networkFetcher, this.cacheProvider, this.enableSystraceMarkers, this.enableNetworkCache, this.disablePathInterpolatorCache, null);
        }
    }

    /* synthetic */ LottieConfig(LottieNetworkFetcher r1, LottieNetworkCacheProvider r2, boolean r3, boolean r4, boolean r5, AnonymousClass1 r6) {
        this(r1, r2, r3, r4, r5);
    }

    private LottieConfig(LottieNetworkFetcher r1, LottieNetworkCacheProvider r2, boolean r3, boolean r4, boolean r5) {
        this.networkFetcher = r1;
        this.cacheProvider = r2;
        this.enableSystraceMarkers = r3;
        this.enableNetworkCache = r4;
        this.disablePathInterpolatorCache = r5;
    }
}
