package com.airbnb.lottie;

import Mb.InterfaceC0968f;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.zyql.ai.selector.config.PictureMimeType;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();
    private static final Set<LottieTaskIdleListener> taskIdleListeners = new HashSet();
    private static final byte[] ZIP_MAGIC = {80, 75, 3, 4};
    private static final byte[] GZIP_MAGIC = {31, -117, 8};

    private LottieCompositionFactory() {
    }

    public static /* synthetic */ void c(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    private static LottieTask<LottieComposition> cache(final String str, Callable<LottieResult<LottieComposition>> callable, Runnable runnable) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        LottieTask<LottieComposition> lottieTask = lottieComposition != null ? new LottieTask<>(lottieComposition) : null;
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                lottieTask = map.get(str);
            }
        }
        if (lottieTask != null) {
            if (runnable != null) {
                runnable.run();
            }
            return lottieTask;
        }
        LottieTask<LottieComposition> lottieTask2 = new LottieTask<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask2.addListener(new LottieListener() { // from class: com.airbnb.lottie.m
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.s(str, atomicBoolean, (LottieComposition) obj);
                }
            });
            lottieTask2.addFailureListener(new LottieListener() { // from class: com.airbnb.lottie.n
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.c(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, LottieTask<LottieComposition>> map2 = taskCache;
                map2.put(str, lottieTask2);
                if (map2.size() == 1) {
                    notifyTaskCacheIdleListeners(false);
                }
            }
        }
        return lottieTask2;
    }

    public static void clearCache(Context context) {
        clearCache(context, true);
    }

    public static /* synthetic */ LottieResult d(Context context, String str, String str2) {
        LottieResult<LottieComposition> lottieResultFetchSync = L.networkFetcher(context).fetchSync(context, str, str2);
        if (str2 != null && lottieResultFetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, lottieResultFetchSync.getValue());
        }
        return lottieResultFetchSync;
    }

    public static /* synthetic */ LottieResult e(WeakReference weakReference, Context context, int i10, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return fromRawResSync(context, i10, str);
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    public static LottieTask<LottieComposition> fromInputStream(Context context, final InputStream inputStream, final String str) {
        final Context applicationContext = context == null ? null : context.getApplicationContext();
        return cache(str, new Callable() { // from class: com.airbnb.lottie.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromInputStreamSync(applicationContext, inputStream, str);
            }
        }, null);
    }

    public static LottieResult<LottieComposition> fromInputStreamSync(Context context, InputStream inputStream, String str) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            InterfaceC0968f interfaceC0968fC = Mb.u.c(Mb.u.l(inputStream));
            return isZipCompressed(interfaceC0968fC).booleanValue() ? fromZipStreamSync(context, new ZipInputStream(interfaceC0968fC.r1()), str) : isGzipCompressed(interfaceC0968fC).booleanValue() ? fromJsonInputStreamSync(new GZIPInputStream(interfaceC0968fC.r1()), str) : fromJsonReaderSync(JsonReader.of(interfaceC0968fC), str);
        } catch (IOException e10) {
            return new LottieResult<>((Throwable) e10);
        }
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(final JSONObject jSONObject, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonSync(jSONObject, str);
            }
        }, null);
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.u
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.v
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                Utils.closeQuietly(inputStream);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieTask<LottieComposition> fromJsonReader(final JsonReader jsonReader, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonReaderSync(jsonReader, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.i
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                Utils.closeQuietly(jsonReader);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSync(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z10) throws IOException {
        LottieComposition lottieComposition;
        try {
            if (str == null) {
                lottieComposition = null;
            } else {
                try {
                    lottieComposition = LottieCompositionCache.getInstance().get(str);
                } catch (Exception e10) {
                    LottieResult<LottieComposition> lottieResult = new LottieResult<>(e10);
                    if (z10) {
                        Utils.closeQuietly(jsonReader);
                    }
                    return lottieResult;
                }
            }
            if (lottieComposition != null) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(lottieComposition);
                if (z10) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult2;
            }
            LottieComposition lottieComposition2 = LottieCompositionMoshiParser.parse(jsonReader);
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition2);
            }
            LottieResult<LottieComposition> lottieResult3 = new LottieResult<>(lottieComposition2);
            if (z10) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult3;
        } catch (Throwable th) {
            if (z10) {
                Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> fromJsonSource(final Mb.I i10, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonSourceSync(i10, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.p
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                Utils.closeQuietly(i10);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonSourceSync(Mb.I i10, String str) {
        return fromJsonSourceSync(i10, str, true);
    }

    public static LottieTask<LottieComposition> fromJsonString(final String str, final String str2) {
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonStringSync(str, str2);
            }
        }, null);
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String str, String str2) {
        return fromJsonSourceSync(Mb.u.l(new ByteArrayInputStream(str.getBytes())), str2);
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int i10) {
        return fromRawRes(context, i10, rawResCacheKey(context, i10));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i10) {
        return fromRawResSync(context, i10, rawResCacheKey(context, i10));
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, String str) {
        return fromZipStream((Context) null, zipInputStream, str);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        return fromZipStreamSync(zipInputStream, str, true);
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(Context context, ZipInputStream zipInputStream, String str) throws IOException {
        LottieComposition lottieComposition;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            lottieComposition = null;
        } else {
            try {
                lottieComposition = LottieCompositionCache.getInstance().get(str);
            } catch (IOException e10) {
                return new LottieResult<>((Throwable) e10);
            }
        }
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        LottieComposition value = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                value = fromJsonReaderSyncInternal(JsonReader.of(Mb.u.c(Mb.u.l(zipInputStream))), null, false).getValue();
            } else if (name.contains(PictureMimeType.PNG) || name.contains(PictureMimeType.WEBP) || name.contains(PictureMimeType.JPG) || name.contains(".jpeg")) {
                String[] strArrSplit = name.split("/");
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
                String[] strArrSplit2 = name.split("/");
                String str2 = strArrSplit2[strArrSplit2.length - 1];
                String str3 = str2.split("\\.")[0];
                if (context == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("Unable to extract font " + str3 + " please pass a non-null Context parameter"));
                }
                File file = new File(context.getCacheDir(), str2);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream2 = new FileOutputStream(file);
                    } finally {
                    }
                } catch (Throwable th) {
                    Logger.warning("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i10 = zipInputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i10);
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    fileOutputStream.close();
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                    if (!file.delete()) {
                        Logger.warning("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                    }
                    map2.put(str3, typefaceCreateFromFile);
                } catch (Throwable th2) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (value == null) {
            return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            LottieImageAsset lottieImageAssetFindImageAssetForFileName = findImageAssetForFileName(value, (String) entry.getKey());
            if (lottieImageAssetFindImageAssetForFileName != null) {
                lottieImageAssetFindImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), lottieImageAssetFindImageAssetForFileName.getWidth(), lottieImageAssetFindImageAssetForFileName.getHeight()));
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z10 = false;
            for (Font font : value.getFonts().values()) {
                if (font.getFamily().equals(entry2.getKey())) {
                    font.setTypeface((Typeface) entry2.getValue());
                    z10 = true;
                }
            }
            if (!z10) {
                Logger.warning("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator<Map.Entry<String, LottieImageAsset>> it = value.getImages().entrySet().iterator();
            while (it.hasNext()) {
                LottieImageAsset value2 = it.next().getValue();
                if (value2 == null) {
                    return null;
                }
                String fileName = value2.getFileName();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME;
                if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                        if (bitmapDecodeByteArray != null) {
                            value2.setBitmap(Utils.resizeBitmapIfNeeded(bitmapDecodeByteArray, value2.getWidth(), value2.getHeight()));
                        }
                    } catch (IllegalArgumentException e11) {
                        Logger.warning("data URL did not have correct base64 format.", e11);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            LottieCompositionCache.getInstance().put(str, value);
        }
        return new LottieResult<>(value);
    }

    private static Boolean isGzipCompressed(InterfaceC0968f interfaceC0968f) {
        return matchesMagicBytes(interfaceC0968f, GZIP_MAGIC);
    }

    private static boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean isZipCompressed(InterfaceC0968f interfaceC0968f) {
        return matchesMagicBytes(interfaceC0968f, ZIP_MAGIC);
    }

    public static /* synthetic */ void k(boolean z10, InputStream inputStream) throws IOException {
        if (z10) {
            Utils.closeQuietly(inputStream);
        }
    }

    private static Boolean matchesMagicBytes(InterfaceC0968f interfaceC0968f, byte[] bArr) {
        try {
            InterfaceC0968f interfaceC0968fPeek = interfaceC0968f.peek();
            for (byte b10 : bArr) {
                if (interfaceC0968fPeek.readByte() != b10) {
                    return Boolean.FALSE;
                }
            }
            interfaceC0968fPeek.close();
            return Boolean.TRUE;
        } catch (Exception e10) {
            Logger.error("Failed to check zip file header", e10);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    private static void notifyTaskCacheIdleListeners(boolean z10) {
        ArrayList arrayList = new ArrayList(taskIdleListeners);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((LottieTaskIdleListener) arrayList.get(i10)).onIdleChanged(z10);
        }
    }

    private static String rawResCacheKey(Context context, int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawRes");
        sb2.append(isNightMode(context) ? "_night_" : "_day_");
        sb2.append(i10);
        return sb2.toString();
    }

    public static void registerLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener) {
        taskIdleListeners.add(lottieTaskIdleListener);
        lottieTaskIdleListener.onIdleChanged(taskCache.size() == 0);
    }

    public static /* synthetic */ void s(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    public static void setMaxCacheSize(int i10) {
        LottieCompositionCache.getInstance().resize(i10);
    }

    public static void unregisterLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener) {
        taskIdleListeners.remove(lottieTaskIdleListener);
    }

    public static void clearCache(Context context, boolean z10) {
        NetworkCache networkCache;
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        if (!z10 || (networkCache = L.networkCache(context)) == null) {
            return;
        }
        networkCache.clear();
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, final String str, final boolean z10) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str, z10);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.f
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                LottieCompositionFactory.k(z10, inputStream);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str, boolean z10) {
        return fromJsonSourceSync(Mb.u.l(inputStream), str, z10);
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str, boolean z10) {
        return fromJsonReaderSyncInternal(jsonReader, str, z10);
    }

    public static LottieResult<LottieComposition> fromJsonSourceSync(Mb.I i10, String str, boolean z10) {
        return fromJsonReaderSyncInternal(JsonReader.of(Mb.u.c(i10)), str, z10);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, final int i10, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable() { // from class: com.airbnb.lottie.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.e(weakReference, applicationContext, i10, str);
            }
        }, null);
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i10, String str) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            InterfaceC0968f interfaceC0968fC = Mb.u.c(Mb.u.l(context.getResources().openRawResource(i10)));
            if (isZipCompressed(interfaceC0968fC).booleanValue()) {
                return fromZipStreamSync(context, new ZipInputStream(interfaceC0968fC.r1()), str);
            }
            if (!isGzipCompressed(interfaceC0968fC).booleanValue()) {
                return fromJsonReaderSync(JsonReader.of(interfaceC0968fC), str);
            }
            try {
                return fromJsonInputStreamSync(new GZIPInputStream(interfaceC0968fC.r1()), str);
            } catch (IOException e10) {
                return new LottieResult<>((Throwable) e10);
            }
        } catch (Resources.NotFoundException e11) {
            return new LottieResult<>((Throwable) e11);
        }
    }

    public static LottieTask<LottieComposition> fromUrl(final Context context, final String str, final String str2) {
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.d(context, str, str2);
            }
        }, null);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, String str2) {
        LottieComposition lottieComposition = str2 == null ? null : LottieCompositionCache.getInstance().get(str2);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        LottieResult<LottieComposition> lottieResultFetchSync = L.networkFetcher(context).fetchSync(context, str, str2);
        if (str2 != null && lottieResultFetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, lottieResultFetchSync.getValue());
        }
        return lottieResultFetchSync;
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, String str, boolean z10) {
        return fromZipStream(null, zipInputStream, str, z10);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str, boolean z10) {
        return fromZipStreamSync(null, zipInputStream, str, z10);
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str, str2);
            }
        }, null);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, String str2) {
        LottieComposition lottieComposition = str2 == null ? null : LottieCompositionCache.getInstance().get(str2);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            return fromInputStreamSync(context, context.getAssets().open(str), str2);
        } catch (IOException e10) {
            return new LottieResult<>((Throwable) e10);
        }
    }

    public static LottieTask<LottieComposition> fromZipStream(final Context context, final ZipInputStream zipInputStream, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromZipStreamSync(context, zipInputStream, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.l
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                Utils.closeQuietly(zipInputStream);
            }
        });
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(Context context, ZipInputStream zipInputStream, String str) {
        return fromZipStreamSync(context, zipInputStream, str, true);
    }

    public static LottieTask<LottieComposition> fromZipStream(final Context context, final ZipInputStream zipInputStream, final String str, boolean z10) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromZipStreamSync(context, zipInputStream, str);
            }
        }, z10 ? new Runnable() { // from class: com.airbnb.lottie.r
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                Utils.closeQuietly(zipInputStream);
            }
        } : null);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(Context context, ZipInputStream zipInputStream, String str, boolean z10) throws IOException {
        try {
            return fromZipStreamSyncInternal(context, zipInputStream, str);
        } finally {
            if (z10) {
                Utils.closeQuietly(zipInputStream);
            }
        }
    }
}
