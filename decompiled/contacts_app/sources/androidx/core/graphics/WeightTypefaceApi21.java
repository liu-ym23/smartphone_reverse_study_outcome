package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class WeightTypefaceApi21 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor = null;
    private static final Method sNativeCreateFromTypeface = null;
    private static final Method sNativeCreateWeightAlias = null;
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock = null;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = null;

    static {
        Field r0 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Throwable -> L4
        Method r1 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_METHOD, new Class[]{Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L4
        r1.setAccessible(true);     // Catch: Throwable -> L4
        Method r2 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_WEIGHT_ALIAS_METHOD, new Class[]{Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L4
        r2.setAccessible(true);     // Catch: Throwable -> L4
        Constructor<Typeface> r3 = Typeface.class.getDeclaredConstructor(new Class[]{Long.TYPE});     // Catch: Throwable -> L4
        r3.setAccessible(true);     // Catch: Throwable -> L4
    L6:
        sNativeInstance = r0;
        sNativeCreateFromTypeface = r1;
        sNativeCreateWeightAlias = r2;
        sConstructor = r3;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L4:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r0 = null;
        r1 = null;
        r2 = null;
        r3 = null;
        goto L6
    }

    private static boolean isPrivateApiAvailable() {
        if (sNativeInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    static Typeface createWeightStyle(Typeface r7, int r8, boolean r9) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r0 = (r8 << 1) | (r9 ? 1 : 0);
        Object r1 = sWeightCacheLock;
        monitor-enter(r1);
        long r2 = getNativeInstance(r7);     // Catch: Throwable -> L22
        LongSparseArray<SparseArray<Typeface>> r4 = sWeightTypefaceCache;     // Catch: Throwable -> L22
        SparseArray<Typeface> r5 = r4.get(r2);     // Catch: Throwable -> L22
        if (r5 != null) goto L11;
        r5 = new SparseArray(4);     // Catch: Throwable -> L22
        r4.put(r2, r5);     // Catch: Throwable -> L22
    L16:
        if (r9 != r7.isItalic()) goto L18;
        Typeface r10 = create(nativeCreateWeightAlias(r2, r8));     // Catch: Throwable -> L22
    L19:
        r5.put(r0 == true ? 1 : 0, r10);     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return r10;
    L18:
        r10 = create(nativeCreateFromTypefaceWithExactStyle(r2, r8, r9));     // Catch: Throwable -> L22
        goto L19
    L11:
        Typeface r6 = r5.get(r0 == true ? 1 : 0);     // Catch: Throwable -> L22
        if (r6 == null) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L22
        return r6;
    L22:
        th = move-exception;
        throw th;
    }

    private static long getNativeInstance(Typeface r2) {
        return sNativeInstance.getLong(r2);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static long nativeCreateFromTypefaceWithExactStyle(long r4, int r6, boolean r7) {
        if (r7 == false) goto L5;
        int r8 = 2;
    L14:
        return ((Long) sNativeCreateWeightAlias.invoke(null, new Object[]{Long.valueOf(((Long) sNativeCreateFromTypeface.invoke(null, new Object[]{Long.valueOf(r4), Integer.valueOf(r8)})).longValue()), Integer.valueOf(r6)})).longValue();
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        r8 = 0;
        goto L14
    }

    private static long nativeCreateWeightAlias(long r2, int r4) {
        return ((Long) sNativeCreateWeightAlias.invoke(null, new Object[]{Long.valueOf(r2), Integer.valueOf(r4)})).longValue();
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static Typeface create(long r3) {
        return sConstructor.newInstance(new Object[]{Long.valueOf(r3)});
    L5:
        return null;
    }

    private WeightTypefaceApi21() {
    }
}
