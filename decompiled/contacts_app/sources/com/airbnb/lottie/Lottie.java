package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public class Lottie {
    private Lottie() {
    }

    public static void initialize(LottieConfig r1) {
        L.setFetcher(r1.networkFetcher);
        L.setCacheProvider(r1.cacheProvider);
        L.setTraceEnabled(r1.enableSystraceMarkers);
        L.setNetworkCacheEnabled(r1.enableNetworkCache);
        L.setDisablePathInterpolatorCache(r1.disablePathInterpolatorCache);
    }
}
