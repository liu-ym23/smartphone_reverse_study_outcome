package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
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
        Field r100 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Throwable -> L5
        Class r101 = Long.TYPE;     // Catch: Throwable -> L5
        Method r102 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD, new Class[]{r101, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L5
        r102.setAccessible(true);     // Catch: Throwable -> L5
        Constructor<Typeface> r103 = Typeface.class.getDeclaredConstructor(new Class[]{r101});     // Catch: Throwable -> L5
        r103.setAccessible(true);     // Catch: Throwable -> L5
    L6:
        sNativeInstance = r100;
        sNativeCreateFromTypefaceWithExactStyle = r102;
        sConstructor = r103;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L5:
        r100 = null;
        r102 = null;
        r103 = null;
        goto L6
    }

    private static boolean isPrivateApiAvailable() {
        if (sNativeInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    private WeightTypefaceApi26() {
    }

    private static Typeface create(long r100) {
        return sConstructor.newInstance(new Object[]{Long.valueOf(r100)});
    L5:
        return null;
    }

    private static long getNativeInstance(Typeface r100) {
        return sNativeInstance.getLong(r100);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Typeface createWeightStyle(Typeface r100, int r101, boolean r102) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r103 = (r101 << 1) | (r102 ? 1 : 0);
        Object r104 = sWeightCacheLock;
        monitor-enter(r104);
        long r105 = getNativeInstance(r100);     // Catch: Throwable -> L18
        LongSparseArray<SparseArray<Typeface>> r106 = sWeightTypefaceCache;     // Catch: Throwable -> L18
        SparseArray<Typeface> r107 = r106.get(r105);     // Catch: Throwable -> L18
        if (r107 != null) goto L11;
        r107 = new SparseArray(4);     // Catch: Throwable -> L18
        r106.put(r105, r107);     // Catch: Throwable -> L18
    L15:
        Typeface r108 = create(nativeCreateFromTypefaceWithExactStyle(r105, r101, r102));     // Catch: Throwable -> L18
        r107.put(r103 == true ? 1 : 0, r108);     // Catch: Throwable -> L18
        monitor-exit(r104);     // Catch: Throwable -> L18
        return r108;
    L11:
        Typeface r109 = r107.get(r103 == true ? 1 : 0);     // Catch: Throwable -> L18
        if (r109 == null) goto L15;
        monitor-exit(r104);     // Catch: Throwable -> L18
        return r109;
    L18:
        th = move-exception;
        throw th;
    }

    private static long nativeCreateFromTypefaceWithExactStyle(long r100, int r101, boolean r102) {
        return ((Long) sNativeCreateFromTypefaceWithExactStyle.invoke(null, new Object[]{Long.valueOf(r100), Integer.valueOf(r101), Boolean.valueOf(r102)})).longValue();
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
