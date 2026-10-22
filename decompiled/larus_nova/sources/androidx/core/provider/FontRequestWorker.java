package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Consumer;
import androidx.tracing.Trace;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes17.dex */
class FontRequestWorker {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = null;
    static final Object LOCK = null;
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = null;
    static final LruCache<String, Typeface> sTypefaceCache = null;

    public static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        public boolean isSuccess() {
            if (this.mResult != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public TypefaceResult(int r100) {
            this.mTypeface = null;
            this.mResult = r100;
        }

        public TypefaceResult(Typeface r100) {
            this.mTypeface = r100;
            this.mResult = 0;
        }
    }

    private FontRequestWorker() {
    }

    static {
        sTypefaceCache = new LruCache(16);
        DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap();
    }

    public static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }

    private static int getFontFamilyResultStatus(FontsContractCompat.FontFamilyResult r100) {
        int r101 = 1;
        if (r100.getStatusCode() != 0) goto L5;
        FontsContractCompat.FontInfo[] r102 = r100.getFonts();
        if (r102 != null) goto L12;
    L23:
        return r101;
    L12:
        if (r102.length == 0) goto L23;
        int r103 = r102.length;
        r101 = 0;
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L23;
        int r105 = r102[r104].getResultCode();
        if (r105 != 0) goto L18;
        r104 = r104 + 1;
        goto L15
    L18:
        if (r105 >= 0) goto L21;
        return -3;
    L21:
        return r105;
    L5:
        if (r100.getStatusCode() == 1) goto L7;
        return -3;
    L7:
        return -2;
    }

    private static String createCacheId(List<FontRequest> r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L4:
        if (r103 >= r100.size()) goto L10;
        r102.append(((FontRequest) ListProtector.get(r100, r103)).getId());
        r102.append("-");
        r102.append(r101);
        if (r103 >= (r100.size() - 1)) goto L8;
        r102.append(i.f25853b);
    L8:
        r103 = r103 + 1;
        goto L4
    L10:
        return r102.toString();
    }

    public static TypefaceResult getFontSync(String r100, Context r101, List<FontRequest> r102, int r103) {
        Trace.beginSection("getFontSync");
        LruCache<String, Typeface> r104 = sTypefaceCache;     // Catch: Throwable -> L31
        Typeface r105 = r104.get(r100);     // Catch: Throwable -> L31
        if (r105 == null) goto L34;
        TypefaceResult r106 = new TypefaceResult(r105);     // Catch: Throwable -> L31
        Trace.endSection();
        return r106;
    L34:
        FontsContractCompat.FontFamilyResult r107 = FontProvider.getFontFamilyResult(r101, r102, null);     // Catch: PackageManager.NameNotFoundException -> L28 Throwable -> L31
        int r108 = getFontFamilyResultStatus(r107);     // Catch: Throwable -> L31
        if (r108 == 0) goto L16;
        TypefaceResult r109 = new TypefaceResult(r108);     // Catch: Throwable -> L31
        Trace.endSection();
        return r109;
    L16:
        if (r107.hasFallback() == true) goto L18;
    L20:
        Typeface r110 = TypefaceCompat.createFromFontInfo(r101, null, r107.getFonts(), r103);     // Catch: Throwable -> L31
    L21:
        if (r110 == null) goto L25;
        r104.put(r100, r110);     // Catch: Throwable -> L31
        TypefaceResult r111 = new TypefaceResult(r110);     // Catch: Throwable -> L31
        Trace.endSection();
        return r111;
    L25:
        TypefaceResult r112 = new TypefaceResult(-3);     // Catch: Throwable -> L31
        Trace.endSection();
        return r112;
    L18:
        if (Build.VERSION.SDK_INT < 29) goto L20;
        r110 = TypefaceCompat.createFromFontInfoWithFallback(r101, null, r107.getFontsWithFallbacks(), r103);     // Catch: Throwable -> L31
        goto L21
    L28:
        TypefaceResult r113 = new TypefaceResult(-1);     // Catch: Throwable -> L31
        Trace.endSection();
        return r113;
    L31:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static Typeface requestFontAsync(final Context r100, final List<FontRequest> r101, final int r102, Executor r103, final CallbackWrapper r104) {
        final String r105 = createCacheId(r101, r102);
        Typeface r106 = sTypefaceCache.get(r105);
        if (r106 == null) goto L6;
        r104.onTypefaceResult(new TypefaceResult(r106));
        return r106;
    L6:
        Consumer<TypefaceResult> r107 = new AnonymousClass2(r104);
        Object r108 = LOCK;
        monitor-enter(r108);
        SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> r109 = PENDING_REPLIES;     // Catch: Throwable -> L20
        ArrayList<Consumer<TypefaceResult>> r110 = r109.get(r105);     // Catch: Throwable -> L20
        if (r110 == null) goto L13;
        r110.add(r107);     // Catch: Throwable -> L20
        monitor-exit(r108);     // Catch: Throwable -> L20
        return null;
    L13:
        ArrayList<Consumer<TypefaceResult>> r111 = new ArrayList();     // Catch: Throwable -> L20
        r111.add(r107);     // Catch: Throwable -> L20
        r109.put(r105, r111);     // Catch: Throwable -> L20
        monitor-exit(r108);     // Catch: Throwable -> L20
        Callable<TypefaceResult> r112 = new AnonymousClass3(r105, r100, r101, r102);
        if (r103 != null) goto L18;
        r103 = DEFAULT_EXECUTOR_SERVICE;
    L18:
        RequestExecutor.execute(r103, r112, new AnonymousClass4(r105));
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public static Typeface requestFontSync(final Context r100, final FontRequest r101, CallbackWrapper r102, final int r103, int r104) {
        ArrayList r105 = new ArrayList(1);
        Object r106 = new Object[]{r101}[0];
        Objects.requireNonNull(r106);
        r105.add(r106);
        final String r107 = createCacheId(Collections.unmodifiableList(r105), r103);
        Typeface r108 = sTypefaceCache.get(r107);
        if (r108 == null) goto L7;
        r102.onTypefaceResult(new TypefaceResult(r108));
        return r108;
    L7:
        if (r104 != (-1)) goto L15;
        Object[] r109 = {r101};
        ArrayList r110 = new ArrayList(1);
        Object r111 = r109[0];
        Objects.requireNonNull(r111);
        r110.add(r111);
        TypefaceResult r112 = getFontSync(r107, r100, Collections.unmodifiableList(r110), r103);
        r102.onTypefaceResult(r112);
        return r112.mTypeface;
    L15:
        TypefaceResult r113 = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, new AnonymousClass1(r107, r100, r101, r103), r104);     // Catch: InterruptedException -> L13
        r102.onTypefaceResult(r113);     // Catch: InterruptedException -> L13
        return r113.mTypeface;
    L13:
        r102.onTypefaceResult(new TypefaceResult(-3));
        return null;
    }
}
