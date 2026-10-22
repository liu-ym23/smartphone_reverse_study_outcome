package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class WeightTypefaceApi26 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD = "nativeCreateFromTypefaceWithExactStyle";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor = null;
    private static final Method sNativeCreateFromTypefaceWithExactStyle = null;
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock = null;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = null;

    static {
        Field r1 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Throwable -> L5
        Method r2 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD, new Class[]{Long.TYPE, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L5
        r2.setAccessible(true);     // Catch: Throwable -> L5
        Constructor<Typeface> r3 = Typeface.class.getDeclaredConstructor(new Class[]{Long.TYPE});     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
    L7:
        sNativeInstance = r1;
        sNativeCreateFromTypefaceWithExactStyle = r2;
        sConstructor = r3;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r1 = null;
        r2 = null;
        r3 = null;
        goto L7
    }

    private static boolean isPrivateApiAvailable() {
        if (sNativeInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    static Typeface createWeightStyle(Typeface r6, int r7, boolean r8) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r0 = (r7 << 1) | (r8 ? 1 : 0);
        Object r1 = sWeightCacheLock;
        monitor-enter(r1);
        long r2 = getNativeInstance(r6);     // Catch: Throwable -> L18
        LongSparseArray<SparseArray<Typeface>> r9 = sWeightTypefaceCache;     // Catch: Throwable -> L18
        SparseArray<Typeface> r4 = r9.get(r2);     // Catch: Throwable -> L18
        if (r4 != null) goto L11;
        r4 = new SparseArray(4);     // Catch: Throwable -> L18
        r9.put(r2, r4);     // Catch: Throwable -> L18
    L15:
        Typeface r10 = create(nativeCreateFromTypefaceWithExactStyle(r2, r7, r8));     // Catch: Throwable -> L18
        r4.put(r0 == true ? 1 : 0, r10);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r10;
    L11:
        Typeface r11 = r4.get(r0 == true ? 1 : 0);     // Catch: Throwable -> L18
        if (r11 == null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r11;
    L18:
        th = move-exception;
        throw th;
    }

    private static long getNativeInstance(Typeface r2) {
        return sNativeInstance.getLong(r2);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static long nativeCreateFromTypefaceWithExactStyle(long r2, int r4, boolean r5) {
        return ((Long) sNativeCreateFromTypefaceWithExactStyle.invoke(null, new Object[]{Long.valueOf(r2), Integer.valueOf(r4), Boolean.valueOf(r5)})).longValue();
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

    private WeightTypefaceApi26() {
    }
}
