package com.airbnb.lottie.network;

import android.content.Context;
import android.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class NetworkFetcher {
    private final LottieNetworkFetcher fetcher;
    private final NetworkCache networkCache;

    /* renamed from: com.airbnb.lottie.network.NetworkFetcher$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$network$FileExtension;

        static {
            int[] iArr = new int[FileExtension.values().length];
            $SwitchMap$com$airbnb$lottie$network$FileExtension = iArr;
            try {
                iArr[FileExtension.ZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$network$FileExtension[FileExtension.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public NetworkFetcher(NetworkCache networkCache, LottieNetworkFetcher lottieNetworkFetcher) {
        this.networkCache = networkCache;
        this.fetcher = lottieNetworkFetcher;
    }

    private LottieComposition fetchFromCache(Context context, String str, String str2) {
        NetworkCache networkCache;
        Pair<FileExtension, InputStream> pairFetch;
        LottieResult<LottieComposition> lottieResultFromZipStreamSync;
        if (str2 == null || (networkCache = this.networkCache) == null || (pairFetch = networkCache.fetch(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) pairFetch.first;
        InputStream inputStream = (InputStream) pairFetch.second;
        int i10 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$network$FileExtension[fileExtension.ordinal()];
        if (i10 == 1) {
            lottieResultFromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(inputStream), str2);
        } else if (i10 != 2) {
            lottieResultFromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str2);
        } else {
            try {
                lottieResultFromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream), str2);
            } catch (IOException e10) {
                lottieResultFromZipStreamSync = new LottieResult<>(e10);
            }
        }
        if (lottieResultFromZipStreamSync.getValue() != null) {
            return lottieResultFromZipStreamSync.getValue();
        }
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork(Context context, String str, String str2) throws IOException {
        LottieResult<LottieComposition> lottieResult;
        Logger.debug("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                LottieFetchResult lottieFetchResultFetchSync = this.fetcher.fetchSync(str);
                if (lottieFetchResultFetchSync.isSuccessful()) {
                    lottieResult = fromInputStream(context, str, lottieFetchResultFetchSync.bodyByteStream(), lottieFetchResultFetchSync.contentType(), str2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Completed fetch from network. Success: ");
                    sb2.append(lottieResult.getValue() != null);
                    Logger.debug(sb2.toString());
                } else {
                    lottieResult = new LottieResult<>(new IllegalArgumentException(lottieFetchResultFetchSync.error()));
                }
                try {
                    lottieFetchResultFetchSync.close();
                    return lottieResult;
                } catch (IOException e10) {
                    Logger.warning("LottieFetchResult close failed ", e10);
                    return lottieResult;
                }
            } catch (Exception e11) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e11);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e12) {
                        Logger.warning("LottieFetchResult close failed ", e12);
                    }
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                throw th;
            }
            try {
                closeable.close();
                throw th;
            } catch (IOException e13) {
                Logger.warning("LottieFetchResult close failed ", e13);
                throw th;
            }
        }
    }

    private LottieResult<LottieComposition> fromGzipStream(String str, InputStream inputStream, String str2) throws IOException {
        NetworkCache networkCache;
        return (str2 == null || (networkCache = this.networkCache) == null) ? LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream), null) : LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.GZIP))), str);
    }

    private LottieResult<LottieComposition> fromInputStream(Context context, String str, InputStream inputStream, String str2, String str3) throws NoSuchAlgorithmException, IOException {
        LottieResult<LottieComposition> lottieResultFromZipStream;
        FileExtension fileExtension;
        NetworkCache networkCache;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            lottieResultFromZipStream = fromZipStream(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            Logger.debug("Handling gzip response.");
            fileExtension = FileExtension.GZIP;
            lottieResultFromZipStream = fromGzipStream(str, inputStream, str3);
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            lottieResultFromZipStream = fromJsonStream(str, inputStream, str3);
        }
        if (str3 != null && lottieResultFromZipStream.getValue() != null && (networkCache = this.networkCache) != null) {
            networkCache.renameTempFile(str, fileExtension);
        }
        return lottieResultFromZipStream;
    }

    private LottieResult<LottieComposition> fromJsonStream(String str, InputStream inputStream, String str2) throws IOException {
        NetworkCache networkCache;
        return (str2 == null || (networkCache = this.networkCache) == null) ? LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null) : LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    private LottieResult<LottieComposition> fromZipStream(Context context, String str, InputStream inputStream, String str2) throws IOException {
        NetworkCache networkCache;
        return (str2 == null || (networkCache = this.networkCache) == null) ? LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(inputStream), (String) null) : LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.ZIP))), str);
    }

    public LottieResult<LottieComposition> fetchSync(Context context, String str, String str2) {
        LottieComposition lottieCompositionFetchFromCache = fetchFromCache(context, str, str2);
        if (lottieCompositionFetchFromCache != null) {
            return new LottieResult<>(lottieCompositionFetchFromCache);
        }
        Logger.debug("Animation for " + str + " not found in cache. Fetching from network.");
        return fetchFromNetwork(context, str, str2);
    }
}
