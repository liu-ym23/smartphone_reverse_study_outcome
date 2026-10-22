package com.airbnb.lottie.network;

import android.content.Context;
import android.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public class NetworkFetcher {
    private final LottieNetworkFetcher fetcher;
    private final NetworkCache networkCache;

    public NetworkFetcher(NetworkCache r1, LottieNetworkFetcher r2) {
        this.networkCache = r1;
        this.fetcher = r2;
    }

    public LottieResult<LottieComposition> fetchSync(Context r3, String r4, String r5) {
        LottieComposition r0 = fetchFromCache(r3, r4, r5);
        if (r0 != null) goto L5;
        Logger.debug("Animation for " + r4 + " not found in cache. Fetching from network.");
        return fetchFromNetwork(r3, r4, r5);
    L5:
        return new LottieResult(r0);
    }

    private LottieComposition fetchFromCache(Context r3, String r4, String r5) {
        if (r5 == null) goto L18;
        NetworkCache r2 = this.networkCache;
        if (r2 == null) goto L18;
        Pair<FileExtension, InputStream> r6 = r2.fetch(r4);
        if (r6 != null) goto L10;
        return null;
    L10:
        FileExtension r7 = (FileExtension) r6.first;
        InputStream r8 = (InputStream) r6.second;
        if (r7 != FileExtension.ZIP) goto L13;
        LottieResult<LottieComposition> r9 = LottieCompositionFactory.fromZipStreamSync(r3, new ZipInputStream(r8), r5);
    L15:
        if (r9.getValue() == null) goto L18;
        return r9.getValue();
    L13:
        r9 = LottieCompositionFactory.fromJsonInputStreamSync(r8, r5);
    L18:
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork(Context r11, String r12, String r13) {
        Logger.debug("Fetching " + r12);
        LottieFetchResult r2 = null;
        LottieFetchResult r3 = this.fetcher.fetchSync(r12);     // Catch: Throwable -> L23 Exception -> L25
        if (r3.isSuccessful() == false) goto L16;
        LottieResult<LottieComposition> r10 = fromInputStream(r11, r12, r3.bodyByteStream(), r3.contentType(), r13);     // Catch: Throwable -> L23 Exception -> L25
        StringBuilder r14 = new StringBuilder("Completed fetch from network. Success: ");     // Catch: Throwable -> L23 Exception -> L25
        if (r10.getValue() == null) goto L8;
        boolean r15 = true;
    L9:
        Logger.debug(r14.append(r15).toString());     // Catch: Throwable -> L23 Exception -> L25
        if (r3 != null) goto L42;
    L15:
        return r10;
    L42:
        r3.close();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        Logger.warning("LottieFetchResult close failed ", e);
        goto L15
    L8:
        r15 = false;
        goto L9
    L16:
        LottieResult<LottieComposition> r16 = new LottieResult(new IllegalArgumentException(r3.error()));     // Catch: Throwable -> L23 Exception -> L25
        if (r3 != null) goto L46;
    L22:
        return r16;
    L46:
        r3.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Logger.warning("LottieFetchResult close failed ", e);
    L23:
        th = move-exception;
        if (0 != 0) goto L39;
    L38:
        throw th;
    L39:
        r2.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        Logger.warning("LottieFetchResult close failed ", e);
    L25:
        e = move-exception;
        LottieResult<LottieComposition> r17 = new LottieResult(e);     // Catch: Throwable -> L23
        if (0 != 0) goto L44;
    L32:
        return r17;
    L44:
        r2.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        Logger.warning("LottieFetchResult close failed ", e);
        goto L32
    }

    private LottieResult<LottieComposition> fromInputStream(Context r2, String r3, InputStream r4, String r5, String r6) throws IOException {
        if (r5 != null) goto L5;
        r5 = "application/json";
    L5:
        if (r5.contains("application/zip") == false) goto L7;
    L14:
        Logger.debug("Handling zip response.");
        FileExtension r7 = FileExtension.ZIP;
        LottieResult<LottieComposition> r8 = fromZipStream(r2, r3, r4, r6);
        FileExtension r9 = r7;
    L15:
        if (r6 != null) goto L17;
    L21:
        return r8;
    L17:
        if (r8.getValue() == null) goto L21;
        NetworkCache r1 = this.networkCache;
        if (r1 == null) goto L21;
        r1.renameTempFile(r3, r9);
        goto L21
    L7:
        if (r5.contains("application/x-zip") == true) goto L14;
        if (r5.contains("application/x-zip-compressed") == true) goto L14;
        if (r3.split("\\?")[0].endsWith(".lottie") == true) goto L14;
        Logger.debug("Received json response.");
        r9 = FileExtension.JSON;
        r8 = fromJsonStream(r3, r4, r6);
        goto L15
    }

    private LottieResult<LottieComposition> fromZipStream(Context r1, String r2, InputStream r3, String r4) throws IOException {
        if (r4 == null) goto L9;
        NetworkCache r0 = this.networkCache;
        if (r0 == null) goto L9;
        return LottieCompositionFactory.fromZipStreamSync(r1, new ZipInputStream(new FileInputStream(r0.writeTempCacheFile(r2, r3, FileExtension.ZIP))), r2);
    L9:
        return LottieCompositionFactory.fromZipStreamSync(r1, new ZipInputStream(r3), null);
    }

    private LottieResult<LottieComposition> fromJsonStream(String r1, InputStream r2, String r3) throws IOException {
        if (r3 == null) goto L9;
        NetworkCache r0 = this.networkCache;
        if (r0 == null) goto L9;
        return LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(r0.writeTempCacheFile(r1, r2, FileExtension.JSON).getAbsolutePath()), r1);
    L9:
        return LottieCompositionFactory.fromJsonInputStreamSync(r2, null);
    }
}
