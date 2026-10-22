package com.airbnb.lottie;

import android.content.Context;
import com.airbnb.lottie.network.DefaultLottieNetworkFetcher;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.utils.LottieTrace;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class L {
    public static boolean DBG = false;
    public static final String TAG = "LOTTIE";
    private static LottieNetworkCacheProvider cacheProvider = null;
    private static boolean disablePathInterpolatorCache = true;
    private static LottieNetworkFetcher fetcher = null;
    private static ThreadLocal<LottieTrace> lottieTrace = null;
    private static volatile NetworkCache networkCache = null;
    private static boolean networkCacheEnabled = true;
    private static volatile NetworkFetcher networkFetcher = null;
    private static boolean traceEnabled = false;

    static {
    }

    private L() {
    }

    public static void setTraceEnabled(boolean r1) {
        if (traceEnabled != r1) goto L5;
        return;
    L5:
        traceEnabled = r1;
        if (r1 == true) goto L8;
        return;
    L8:
        if (lottieTrace != null) goto L12;
        lottieTrace = new ThreadLocal();
        return;
    }

    public static void setNetworkCacheEnabled(boolean r0) {
        networkCacheEnabled = r0;
    }

    public static void beginSection(String r1) {
        if (traceEnabled == true) goto L5;
        return;
    L5:
        getTrace().beginSection(r1);
    }

    public static float endSection(String r1) {
        if (traceEnabled == true) goto L7;
        return 0.0f;
    L7:
        return getTrace().endSection(r1);
    }

    private static LottieTrace getTrace() {
        LottieTrace r0 = lottieTrace.get();
        if (r0 != null) goto L6;
        LottieTrace r1 = new LottieTrace();
        lottieTrace.set(r1);
        return r1;
    L6:
        return r0;
    }

    public static void setFetcher(LottieNetworkFetcher r1) {
        LottieNetworkFetcher r0 = fetcher;
        if (r0 != null) goto L5;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L9:
        fetcher = r1;
        networkFetcher = null;
        return;
    L7:
        if (r0.equals(r1) == false) goto L9;
    }

    public static void setCacheProvider(LottieNetworkCacheProvider r1) {
        LottieNetworkCacheProvider r0 = cacheProvider;
        if (r0 != null) goto L5;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L9:
        cacheProvider = r1;
        networkCache = null;
        return;
    L7:
        if (r0.equals(r1) == false) goto L9;
    }

    public static NetworkFetcher networkFetcher(Context r3) {
        NetworkFetcher r0 = networkFetcher;
        if (r0 == null) goto L5;
    L18:
        return r0;
    L5:
        monitor-enter(NetworkFetcher.class);
        r0 = networkFetcher;     // Catch: Throwable -> L15
        if (r0 != null) goto L13;
        NetworkCache r4 = networkCache(r3);     // Catch: Throwable -> L15
        LottieNetworkFetcher r2 = fetcher;     // Catch: Throwable -> L15
        if (r2 != null) goto L12;
        r2 = new DefaultLottieNetworkFetcher();     // Catch: Throwable -> L15
    L12:
        r0 = new NetworkFetcher(r4, r2);     // Catch: Throwable -> L15
        networkFetcher = r0;     // Catch: Throwable -> L15
    L13:
        monitor-exit(NetworkFetcher.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public static NetworkCache networkCache(Context r3) {
        if (networkCacheEnabled == true) goto L6;
        return null;
    L6:
        final Context r4 = r3.getApplicationContext();
        NetworkCache r0 = networkCache;
        if (r0 == null) goto L9;
    L22:
        return r0;
    L9:
        monitor-enter(NetworkCache.class);
        r0 = networkCache;     // Catch: Throwable -> L19
        if (r0 != null) goto L17;
        LottieNetworkCacheProvider r2 = cacheProvider;     // Catch: Throwable -> L19
        if (r2 != null) goto L16;
        r2 = new L$$ExternalSyntheticLambda0(r4);     // Catch: Throwable -> L19
    L16:
        r0 = new NetworkCache(r2);     // Catch: Throwable -> L19
        networkCache = r0;     // Catch: Throwable -> L19
    L17:
        monitor-exit(NetworkCache.class);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ File lambda$networkCache$0(Context r2) {
        return new File(r2.getCacheDir(), "lottie_network_cache");
    }

    public static void setDisablePathInterpolatorCache(boolean r0) {
        disablePathInterpolatorCache = r0;
    }

    public static boolean getDisablePathInterpolatorCache() {
        return disablePathInterpolatorCache;
    }
}
