package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Consumer;
import com.bytedance.keva.KevaImpl;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
class FontRequestWorker {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = null;
    static final Object LOCK = null;
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = null;
    static final LruCache<String, Typeface> sTypefaceCache = null;

    static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(int r2) {
            this.mTypeface = null;
            this.mResult = r2;
        }

        TypefaceResult(Typeface r1) {
            this.mTypeface = r1;
            this.mResult = 0;
        }

        boolean isSuccess() {
            if (this.mResult != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private FontRequestWorker() {
    }

    static {
        sTypefaceCache = new LruCache(16);
        DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap();
    }

    static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }

    static Typeface requestFontSync(final Context r2, final FontRequest r3, CallbackWithHandler r4, final int r5, int r6) {
        final String r0 = createCacheId(r3, r5);
        Typeface r1 = sTypefaceCache.get(r0);
        if (r1 == null) goto L7;
        r4.onTypefaceResult(new TypefaceResult(r1));
        return r1;
    L7:
        if (r6 != (-1)) goto L10;
        TypefaceResult r7 = getFontSync(r0, r2, r3, r5);
        r4.onTypefaceResult(r7);
        return r7.mTypeface;
    L10:
        Callable<TypefaceResult> r8 = new AnonymousClass1(r0, r2, r3, r5);
        TypefaceResult r9 = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, r8, r6);     // Catch: InterruptedException -> L13
        r4.onTypefaceResult(r9);     // Catch: InterruptedException -> L13
        return r9.mTypeface;
    L13:
        r4.onTypefaceResult(new TypefaceResult(-3));
        return null;
    }

    static Typeface requestFontAsync(final Context r5, final FontRequest r6, final int r7, Executor r8, final CallbackWithHandler r9) {
        final String r0 = createCacheId(r6, r7);
        Typeface r1 = sTypefaceCache.get(r0);
        if (r1 == null) goto L6;
        r9.onTypefaceResult(new TypefaceResult(r1));
        return r1;
    L6:
        Consumer<TypefaceResult> r2 = new AnonymousClass2(r9);
        Object r10 = LOCK;
        monitor-enter(r10);
        SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> r3 = PENDING_REPLIES;     // Catch: Throwable -> L20
        ArrayList<Consumer<TypefaceResult>> r4 = r3.get(r0);     // Catch: Throwable -> L20
        if (r4 == null) goto L13;
        r4.add(r2);     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        return null;
    L13:
        ArrayList<Consumer<TypefaceResult>> r11 = new ArrayList();     // Catch: Throwable -> L20
        r11.add(r2);     // Catch: Throwable -> L20
        r3.put(r0, r11);     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        Callable<TypefaceResult> r12 = new AnonymousClass3(r0, r5, r6, r7);
        if (r8 != null) goto L18;
        r8 = DEFAULT_EXECUTOR_SERVICE;
    L18:
        RequestExecutor.execute(r8, r12, new AnonymousClass4(r0));
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    private static String createCacheId(FontRequest r1, int r2) {
        return r1.getId() + "-" + r2;
    }

    static TypefaceResult getFontSync(String r3, Context r4, FontRequest r5, int r6) {
        LruCache<String, Typeface> r0 = sTypefaceCache;
        Typeface r1 = r0.get(r3);
        if (r1 == null) goto L20;
        return new TypefaceResult(r1);
    L20:
        FontsContractCompat.FontFamilyResult r7 = FontProvider.getFontFamilyResult(r4, r5, null);     // Catch: PackageManager.NameNotFoundException -> L18
        int r2 = getFontFamilyResultStatus(r7);
        if (r2 != 0) goto L11;
        Typeface r8 = TypefaceCompat.createFromFontInfo(r4, null, r7.getFonts(), r6);
        if (r8 == null) goto L17;
        r0.put(r3, r8);
        return new TypefaceResult(r8);
    L17:
        return new TypefaceResult(-3);
    L11:
        return new TypefaceResult(r2);
    L19:
        return new TypefaceResult(-1);
    }

    private static int getFontFamilyResultStatus(FontsContractCompat.FontFamilyResult r5) {
        int r2 = 1;
        if (r5.getStatusCode() != 0) goto L5;
        FontsContractCompat.FontInfo[] r6 = r5.getFonts();
        if (r6 != null) goto L12;
    L23:
        return r2;
    L12:
        if (r6.length == 0) goto L23;
        int r0 = r6.length;
        r2 = 0;
        int r3 = 0;
    L15:
        if (r3 >= r0) goto L23;
        int r4 = r6[r3].getResultCode();
        if (r4 != 0) goto L18;
        r3 = r3 + 1;
        goto L15
    L18:
        if (r4 >= 0) goto L21;
        return -3;
    L21:
        return r4;
    L5:
        if (r5.getStatusCode() == 1) goto L7;
        return -3;
    L7:
        return -2;
    }
}
