package com.airbnb.lottie;

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
import com.bytedance.librarian.LibrarianImpl;
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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionFactory {
    private static final byte[] MAGIC = null;
    private static final Map<String, LottieTask<LottieComposition>> taskCache = null;
    private static final Set<LottieTaskIdleListener> taskIdleListeners = null;

    static {
        taskCache = new HashMap();
        taskIdleListeners = new HashSet();
        MAGIC = new byte[]{80, 75, 3, 4};
    }

    private LottieCompositionFactory() {
    }

    public static void setMaxCacheSize(int r1) {
        LottieCompositionCache.getInstance().resize(r1);
    }

    public static void clearCache(Context r1) {
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        NetworkCache r2 = L.networkCache(r1);
        if (r2 == null) goto L6;
        r2.clear();
        return;
    }

    public static void registerLottieTaskIdleListener(LottieTaskIdleListener r1) {
        taskIdleListeners.add(r1);
        if (taskCache.size() != 0) goto L5;
        boolean r0 = true;
    L6:
        r1.onIdleChanged(r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void unregisterLottieTaskIdleListener(LottieTaskIdleListener r1) {
        taskIdleListeners.remove(r1);
    }

    public static LottieTask<LottieComposition> fromUrl(Context r2, String r3) {
        return fromUrl(r2, r3, "url_" + r3);
    }

    public static LottieTask<LottieComposition> fromUrl(final Context r1, final String r2, final String r3) {
        return cache(r3, new LottieCompositionFactory$$ExternalSyntheticLambda16(r1, r2, r3), null);
    }

    static /* synthetic */ LottieResult lambda$fromUrl$0(Context r1, String r2, String r3) throws Exception {
        LottieResult<LottieComposition> r4 = L.networkFetcher(r1).fetchSync(r1, r2, r3);
        if (r3 != null) goto L5;
    L7:
        return r4;
    L5:
        if (r4.getValue() == null) goto L7;
        LottieCompositionCache.getInstance().put(r3, r4.getValue());
        goto L7
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context r0, String r1) {
        return fromUrlSync(r0, r1, r1);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context r1, String r2, String r3) {
        LottieResult<LottieComposition> r4 = L.networkFetcher(r1).fetchSync(r1, r2, r3);
        if (r3 != null) goto L5;
    L7:
        return r4;
    L5:
        if (r4.getValue() == null) goto L7;
        LottieCompositionCache.getInstance().put(r3, r4.getValue());
        goto L7
    }

    public static LottieTask<LottieComposition> fromAsset(Context r2, String r3) {
        return fromAsset(r2, r3, "asset_" + r3);
    }

    public static LottieTask<LottieComposition> fromAsset(Context r1, final String r2, final String r3) {
        final Context r4 = r1.getApplicationContext();
        return cache(r3, new LottieCompositionFactory$$ExternalSyntheticLambda7(r4, r2, r3), null);
    }

    static /* synthetic */ LottieResult lambda$fromAsset$1(Context r0, String r1, String r2) throws Exception {
        return fromAssetSync(r0, r1, r2);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context r2, String r3) {
        return fromAssetSync(r2, r3, "asset_" + r3);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context r2, String r3, String r4) {
    L11:
        e = move-exception;
        return new LottieResult(e);
    L3:
        if (r3.endsWith(".zip") == true) goto L10;
        if (r3.endsWith(".lottie") == true) goto L10;
        return fromJsonInputStreamSync(r2.getAssets().open(r3), r4);
    L10:
        return fromZipStreamSync(r2, new ZipInputStream(r2.getAssets().open(r3)), r4);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context r1, int r2) {
        return fromRawRes(r1, r2, rawResCacheKey(r1, r2));
    }

    public static LottieTask<LottieComposition> fromRawRes(Context r2, final int r3, final String r4) {
        final WeakReference r0 = new WeakReference(r2);
        final Context r5 = r2.getApplicationContext();
        return cache(r4, new LottieCompositionFactory$$ExternalSyntheticLambda8(r0, r5, r3, r4), null);
    }

    static /* synthetic */ LottieResult lambda$fromRawRes$2(WeakReference r0, Context r1, int r2, String r3) throws Exception {
        Context r4 = (Context) r0.get();
        if (r4 == null) goto L6;
        r1 = r4;
    L6:
        return fromRawResSync(r1, r2, r3);
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context r1, int r2) {
        return fromRawResSync(r1, r2, rawResCacheKey(r1, r2));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context r1, int r2, String r3) {
        BufferedSource r4 = Okio.buffer(Okio.source(r1.getResources().openRawResource(r2)));     // Catch: Resources.NotFoundException -> L8
        if (isZipCompressed(r4).booleanValue() == false) goto L7;
        return fromZipStreamSync(r1, new ZipInputStream(r4.inputStream()), r3);
    L7:
        return fromJsonInputStreamSync(r4.inputStream(), r3);
    L8:
        e = move-exception;
        return new LottieResult(e);
    }

    private static String rawResCacheKey(Context r2, int r3) {
        StringBuilder r0 = new StringBuilder("rawRes");
        if (isNightMode(r2) == false) goto L5;
        String r4 = "_night_";
    L7:
        return r0.append(r4).append(r3).toString();
    L5:
        r4 = "_day_";
        goto L7
    }

    private static boolean isNightMode(Context r1) {
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream r2, final String r3) {
        return cache(r3, new LottieCompositionFactory$$ExternalSyntheticLambda2(r2, r3), new LottieCompositionFactory$$ExternalSyntheticLambda3(r2));
    }

    static /* synthetic */ LottieResult lambda$fromJsonInputStream$3(InputStream r0, String r1) throws Exception {
        return fromJsonInputStreamSync(r0, r1);
    }

    static /* synthetic */ void lambda$fromJsonInputStream$4(InputStream r0) {
        Utils.closeQuietly(r0);
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream r2, final String r3, final boolean r4) {
        return cache(r3, new LottieCompositionFactory$$ExternalSyntheticLambda0(r2, r3, r4), new LottieCompositionFactory$$ExternalSyntheticLambda9(r4, r2));
    }

    static /* synthetic */ LottieResult lambda$fromJsonInputStream$5(InputStream r0, String r1, boolean r2) throws Exception {
        return fromJsonInputStreamSync(r0, r1, r2);
    }

    static /* synthetic */ void lambda$fromJsonInputStream$6(boolean r0, InputStream r1) {
        if (r0 == false) goto L5;
        Utils.closeQuietly(r1);
        return;
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream r1, String r2) {
        return fromJsonInputStreamSync(r1, r2, true);
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream r1, String r2, boolean r3) {
        LottieResult<LottieComposition> r4 = fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(r1))), r2);     // Catch: Throwable -> L6
        if (r3 == false) goto L5;
        Utils.closeQuietly(r1);
    L5:
        return r4;
    L6:
        th = move-exception;
        if (r3 == false) goto L9;
        Utils.closeQuietly(r1);
    L9:
        throw th;
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(final JSONObject r1, final String r2) {
        return cache(r2, new LottieCompositionFactory$$ExternalSyntheticLambda17(r1, r2), null);
    }

    static /* synthetic */ LottieResult lambda$fromJson$7(JSONObject r0, String r1) throws Exception {
        return fromJsonSync(r0, r1);
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject r0, String r1) {
        return fromJsonStringSync(r0.toString(), r1);
    }

    public static LottieTask<LottieComposition> fromJsonString(final String r1, final String r2) {
        return cache(r2, new LottieCompositionFactory$$ExternalSyntheticLambda1(r1, r2), null);
    }

    static /* synthetic */ LottieResult lambda$fromJsonString$8(String r0, String r1) throws Exception {
        return fromJsonStringSync(r0, r1);
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String r1, String r2) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(new ByteArrayInputStream(r1.getBytes())))), r2);
    }

    public static LottieTask<LottieComposition> fromJsonReader(final JsonReader r2, final String r3) {
        return cache(r3, new LottieCompositionFactory$$ExternalSyntheticLambda14(r2, r3), new LottieCompositionFactory$$ExternalSyntheticLambda15(r2));
    }

    static /* synthetic */ void lambda$fromJsonReader$10(JsonReader r0) {
        Utils.closeQuietly(r0);
    }

    static /* synthetic */ LottieResult lambda$fromJsonReader$9(JsonReader r0, String r1) throws Exception {
        return fromJsonReaderSync(r0, r1);
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader r1, String r2) {
        return fromJsonReaderSyncInternal(r1, r2, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader r2, String r3, boolean r4) {
        LottieComposition r0 = LottieCompositionMoshiParser.parse(r2);     // Catch: Throwable -> L9 Exception -> L11
        if (r3 == null) goto L5;
        LottieCompositionCache.getInstance().put(r3, r0);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        LottieResult<LottieComposition> r5 = new LottieResult(r0);     // Catch: Throwable -> L9 Exception -> L11
        if (r4 == false) goto L8;
        Utils.closeQuietly(r2);
    L8:
        return r5;
    L11:
        e = move-exception;
        LottieResult<LottieComposition> r1 = new LottieResult(e);     // Catch: Throwable -> L9
        if (r4 == false) goto L15;
        Utils.closeQuietly(r2);
    L15:
        return r1;
    L9:
        th = move-exception;
        if (r4 == false) goto L18;
        Utils.closeQuietly(r2);
    L18:
        throw th;
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream r1, String r2) {
        return fromZipStream(null, r1, r2);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream r1, String r2, boolean r3) {
        return fromZipStream(null, r1, r2, r3);
    }

    public static LottieTask<LottieComposition> fromZipStream(final Context r1, final ZipInputStream r2, final String r3) {
        return cache(r3, new LottieCompositionFactory$$ExternalSyntheticLambda10(r1, r2, r3), new LottieCompositionFactory$$ExternalSyntheticLambda11(r2));
    }

    static /* synthetic */ LottieResult lambda$fromZipStream$11(Context r0, ZipInputStream r1, String r2) throws Exception {
        return fromZipStreamSync(r0, r1, r2);
    }

    static /* synthetic */ void lambda$fromZipStream$12(ZipInputStream r0) {
        Utils.closeQuietly(r0);
    }

    public static LottieTask<LottieComposition> fromZipStream(final Context r1, final ZipInputStream r2, final String r3, boolean r4) {
        Callable r0 = new LottieCompositionFactory$$ExternalSyntheticLambda12(r1, r2, r3);
        if (r4 == false) goto L5;
        Runnable r5 = new LottieCompositionFactory$$ExternalSyntheticLambda13(r2);
    L7:
        return cache(r3, r0, r5);
    L5:
        r5 = null;
        goto L7
    }

    static /* synthetic */ LottieResult lambda$fromZipStream$13(Context r0, ZipInputStream r1, String r2) throws Exception {
        return fromZipStreamSync(r0, r1, r2);
    }

    static /* synthetic */ void lambda$fromZipStream$14(ZipInputStream r0) {
        Utils.closeQuietly(r0);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream r1, String r2) {
        return fromZipStreamSync(r1, r2, true);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream r1, String r2, boolean r3) {
        return fromZipStreamSync(null, r1, r2, r3);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(Context r1, ZipInputStream r2, String r3) {
        return fromZipStreamSync(r1, r2, r3, true);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(Context r0, ZipInputStream r1, String r2, boolean r3) {
        LottieResult<LottieComposition> r4 = fromZipStreamSyncInternal(r0, r1, r2);     // Catch: Throwable -> L6
        if (r3 == false) goto L5;
        Utils.closeQuietly(r1);
    L5:
        return r4;
    L6:
        th = move-exception;
        if (r3 == false) goto L9;
        Utils.closeQuietly(r1);
    L9:
        throw th;
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(Context r12, ZipInputStream r13, String r14) {
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap();
        ZipEntry r2 = r13.getNextEntry();     // Catch: IOException -> L98
        LottieComposition r4 = null;
    L5:
        if (r2 == null) goto L56;
        String r7 = r2.getName();     // Catch: IOException -> L98
        if (r7.contains("__MACOSX") == false) goto L10;
        r13.closeEntry();     // Catch: IOException -> L98
    L54:
        r2 = r13.getNextEntry();     // Catch: IOException -> L98
        goto L5
    L10:
        if (r2.getName().equalsIgnoreCase("manifest.json") == false) goto L13;
        r13.closeEntry();     // Catch: IOException -> L98
        goto L54
    L13:
        if (r2.getName().contains(".json") == false) goto L17;
        r4 = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(r13))), null, false).getValue();     // Catch: IOException -> L98
        goto L54
    L17:
        if (r7.contains(".png") == false) goto L19;
    L53:
        String[] r3 = r7.split(LibrarianImpl.Constants.SEPARATOR);     // Catch: IOException -> L98
        r0.put(r3[r3.length - 1], BitmapFactory.decodeStream(r13));     // Catch: IOException -> L98
        goto L54
    L19:
        if (r7.contains(".webp") == true) goto L53;
        if (r7.contains(".jpg") == true) goto L53;
        if (r7.contains(".jpeg") == true) goto L53;
        if (r7.contains(".ttf") == false) goto L28;
    L31:
        String[] r5 = r7.split(LibrarianImpl.Constants.SEPARATOR);     // Catch: IOException -> L98
        String r6 = r5[r5.length - 1];     // Catch: IOException -> L98
        String r8 = r6.split("\\.")[0];     // Catch: IOException -> L98
        File r9 = new File(r12.getCacheDir(), r6);     // Catch: IOException -> L98
        new FileOutputStream(r9);     // Catch: IOException -> L98
        FileOutputStream r10 = new FileOutputStream(r9);     // Catch: Throwable -> L47
        byte[] r11 = new byte[4096];     // Catch: Throwable -> L41
    L35:
        int r15 = r13.read(r11);     // Catch: Throwable -> L41
        if (r15 == (-1)) goto L38;
        r10.write(r11, 0, r15);     // Catch: Throwable -> L41
        goto L35
    L38:
        r10.flush();     // Catch: Throwable -> L41
        r10.close();     // Catch: Throwable -> L47
    L49:
        Typeface r16 = Typeface.createFromFile(r9);     // Catch: IOException -> L98
        if (r9.delete() == true) goto L52;
        Logger.warning("Failed to delete temp font file " + r9.getAbsolutePath() + LibrarianImpl.Constants.DOT);     // Catch: IOException -> L98
    L52:
        r1.put(r8, r16);     // Catch: IOException -> L98
        goto L54
    L41:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L44
    L46:
        throw th;     // Catch: Throwable -> L47
    L44:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Logger.warning("Unable to save font " + r8 + " to the temporary file: " + r6 + ". ", th);     // Catch: IOException -> L98
        goto L49
    L28:
        if (r7.contains(".otf") == true) goto L31;
        r13.closeEntry();     // Catch: IOException -> L98
        goto L54
    L56:
        if (r4 == null) goto L58;
        Iterator r17 = r0.entrySet().iterator();
    L61:
        if (r17.hasNext() == false) goto L65;
        Map.Entry r18 = (Map.Entry) r17.next();
        LottieImageAsset r19 = findImageAssetForFileName(r4, (String) r18.getKey());
        if (r19 == null) goto L61;
        r19.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) r18.getValue(), r19.getWidth(), r19.getHeight()));
        goto L61
    L65:
        Iterator r110 = r1.entrySet().iterator();
    L67:
        if (r110.hasNext() == false) goto L77;
        Map.Entry r111 = (Map.Entry) r110.next();
        Iterator<Font> r20 = r4.getFonts().values().iterator();
        boolean r21 = false;
    L70:
        if (r20.hasNext() == false) goto L74;
        Font r22 = r20.next();
        if (r22.getFamily().equals(r111.getKey()) == false) goto L70;
        r22.setTypeface((Typeface) r111.getValue());
        r21 = true;
        goto L70
    L74:
        if (r21 == true) goto L67;
        Logger.warning("Parsed font for " + ((String) r111.getKey()) + " however it was not found in the animation.");
        goto L67
    L77:
        if (r0.isEmpty() == false) goto L94;
        Iterator<Map.Entry<String, LottieImageAsset>> r112 = r4.getImages().entrySet().iterator();
    L80:
        if (r112.hasNext() == false) goto L94;
        LottieImageAsset r113 = r112.next().getValue();
        if (r113 == null) goto L83;
        String r23 = r113.getFileName();
        BitmapFactory.Options r24 = new BitmapFactory.Options();
        r24.inScaled = true;
        r24.inDensity = 160;
        if (r23.startsWith("data:") == false) goto L80;
        if (r23.indexOf("base64,") <= 0) goto L80;
        byte[] r25 = Base64.decode(r23.substring(r23.indexOf(44) + 1), 0);     // Catch: IllegalArgumentException -> L91
        r113.setBitmap(BitmapFactory.decodeByteArray(r25, 0, r25.length, r24));
    L91:
        e = move-exception;
        Logger.warning("data URL did not have correct base64 format.", e);
        return null;
    L83:
        return null;
    L94:
        if (r14 == null) goto L97;
        LottieCompositionCache.getInstance().put(r14, r4);
    L97:
        return new LottieResult(r4);
    L58:
        return new LottieResult(new IllegalArgumentException("Unable to parse composition"));
    L98:
        e = move-exception;
        return new LottieResult(e);
    }

    private static Boolean isZipCompressed(BufferedSource r6) {
        BufferedSource r7 = r6.peek();     // Catch: Exception -> L12 NoSuchMethodError -> L15
        byte[] r1 = MAGIC;     // Catch: Exception -> L12 NoSuchMethodError -> L15
        int r2 = r1.length;     // Catch: Exception -> L12 NoSuchMethodError -> L15
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L10;
        if (r7.readByte() != r1[r3]) goto L8;
        r3 = r3 + 1;     // Catch: Exception -> L12 NoSuchMethodError -> L15
        goto L4
    L8:
        return false;
    L10:
        r7.close();     // Catch: Exception -> L12 NoSuchMethodError -> L15
        return true;
    L12:
        e = move-exception;
        Logger.error("Failed to check zip file header", e);
        return false;
    L16:
        return false;
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition r2, String r3) {
        Iterator<LottieImageAsset> r4 = r2.getImages().values().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        LottieImageAsset r0 = r4.next();
        if (r0.getFileName().equals(r3) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private static LottieTask<LottieComposition> cache(final String r3, Callable<LottieResult<LottieComposition>> r4, Runnable r5) {
        LottieTask<LottieComposition> r0 = null;
        if (r3 != null) goto L5;
        final LottieComposition r1 = null;
    L6:
        if (r1 == null) goto L8;
        r0 = new LottieTask(new LottieCompositionFactory$$ExternalSyntheticLambda4(r1));
    L8:
        if (r3 == null) goto L12;
        Map<String, LottieTask<LottieComposition>> r2 = taskCache;
        if (r2.containsKey(r3) == false) goto L12;
        r0 = r2.get(r3);
    L12:
        if (r0 == null) goto L16;
        if (r5 == null) goto L15;
        r5.run();
    L15:
        return r0;
    L16:
        LottieTask<LottieComposition> r6 = new LottieTask(r4);
        if (r3 == null) goto L23;
        final AtomicBoolean r7 = new AtomicBoolean(false);
        r6.addListener(new LottieCompositionFactory$$ExternalSyntheticLambda5(r3, r7));
        r6.addFailureListener(new LottieCompositionFactory$$ExternalSyntheticLambda6(r3, r7));
        if (r7.get() == true) goto L23;
        Map<String, LottieTask<LottieComposition>> r8 = taskCache;
        r8.put(r3, r6);
        if (r8.size() != 1) goto L23;
        notifyTaskCacheIdleListeners(false);
    L23:
        return r6;
    L5:
        r1 = LottieCompositionCache.getInstance().get(r3);
        goto L6
    }

    static /* synthetic */ LottieResult lambda$cache$15(LottieComposition r1) throws Exception {
        return new LottieResult(r1);
    }

    static /* synthetic */ void lambda$cache$16(String r0, AtomicBoolean r1, LottieComposition r2) {
        Map<String, LottieTask<LottieComposition>> r3 = taskCache;
        r3.remove(r0);
        r1.set(true);
        if (r3.size() != 0) goto L6;
        notifyTaskCacheIdleListeners(true);
        return;
    }

    static /* synthetic */ void lambda$cache$17(String r0, AtomicBoolean r1, Throwable r2) {
        Map<String, LottieTask<LottieComposition>> r3 = taskCache;
        r3.remove(r0);
        r1.set(true);
        if (r3.size() != 0) goto L6;
        notifyTaskCacheIdleListeners(true);
        return;
    }

    private static void notifyTaskCacheIdleListeners(boolean r3) {
        ArrayList r0 = new ArrayList(taskIdleListeners);
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        ((LottieTaskIdleListener) r0.get(r1)).onIdleChanged(r3);
        r1 = r1 + 1;
        goto L4
    }
}
