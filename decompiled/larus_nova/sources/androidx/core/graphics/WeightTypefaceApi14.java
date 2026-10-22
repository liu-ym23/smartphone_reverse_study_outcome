package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes17.dex */
final class WeightTypefaceApi14 {
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock = null;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = null;

    static {
        Field r100 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Exception -> L4
        r100.setAccessible(true);     // Catch: Exception -> L4
    L5:
        sNativeInstance = r100;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L4:
        r100 = null;
        goto L5
    }

    private static boolean isPrivateApiAvailable() {
        if (sNativeInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    private WeightTypefaceApi14() {
    }

    private static long getNativeInstance(Typeface r100) {
        return ((Number) sNativeInstance.get(r100)).longValue();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static Typeface platformTypefaceCreate(Typeface r100, int r101, boolean r102) {
        int r103 = 1;
        if (r101 < 600) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        if (r102 == true) goto L9;
        r103 = 0;
    L15:
        return Typeface.create(r100, r103);
    L9:
        if (r104 == true) goto L11;
        r103 = 2;
        goto L15
    L11:
        if (r102 == false) goto L15;
        r103 = 3;
        goto L15
    L5:
        r104 = false;
        goto L6
    }

    public static Typeface createWeightStyle(TypefaceCompatBaseImpl r100, Context r101, Typeface r102, int r110, boolean r111) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r103 = (r110 << 1) | (r111 ? 1 : 0);
        Object r104 = sWeightCacheLock;
        monitor-enter(r104);
        long r105 = getNativeInstance(r102);     // Catch: Throwable -> L21
        LongSparseArray<SparseArray<Typeface>> r106 = sWeightTypefaceCache;     // Catch: Throwable -> L21
        SparseArray<Typeface> r107 = r106.get(r105);     // Catch: Throwable -> L21
        if (r107 != null) goto L11;
        r107 = new SparseArray(4);     // Catch: Throwable -> L21
        r106.put(r105, r107);     // Catch: Throwable -> L21
    L15:
        Typeface r108 = getBestFontFromFamily(r100, r101, r102, r110, r111);     // Catch: Throwable -> L21
        if (r108 != null) goto L18;
        r108 = platformTypefaceCreate(r102, r110, r111);     // Catch: Throwable -> L21
    L18:
        r107.put(r103 == true ? 1 : 0, r108);     // Catch: Throwable -> L21
        monitor-exit(r104);     // Catch: Throwable -> L21
        return r108;
    L11:
        Typeface r109 = r107.get(r103 == true ? 1 : 0);     // Catch: Throwable -> L21
        if (r109 == null) goto L15;
        monitor-exit(r104);     // Catch: Throwable -> L21
        return r109;
    L21:
        th = move-exception;
        throw th;
    }

    private static Typeface getBestFontFromFamily(TypefaceCompatBaseImpl r100, Context r101, Typeface r102, int r103, boolean r110) {
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r104 = r100.getFontFamily(r102);
        if (r104 != null) goto L7;
        return null;
    L7:
        return r100.createFromFontFamilyFilesResourceEntry(r101, r104, r101.getResources(), r103, r110);
    }
}
