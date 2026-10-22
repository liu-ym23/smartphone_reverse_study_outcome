package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
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
        Field r100 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Throwable -> L4
        Class r101 = Long.TYPE;     // Catch: Throwable -> L4
        Class r102 = Integer.TYPE;     // Catch: Throwable -> L4
        Method r103 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_METHOD, new Class[]{r101, r102});     // Catch: Throwable -> L4
        r103.setAccessible(true);     // Catch: Throwable -> L4
        Method r104 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_WEIGHT_ALIAS_METHOD, new Class[]{r101, r102});     // Catch: Throwable -> L4
        r104.setAccessible(true);     // Catch: Throwable -> L4
        Constructor<Typeface> r105 = Typeface.class.getDeclaredConstructor(new Class[]{r101});     // Catch: Throwable -> L4
        r105.setAccessible(true);     // Catch: Throwable -> L4
    L5:
        sNativeInstance = r100;
        sNativeCreateFromTypeface = r103;
        sNativeCreateWeightAlias = r104;
        sConstructor = r105;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L4:
        r100 = null;
        r103 = null;
        r104 = null;
        r105 = null;
        goto L5
    }

    private static boolean isPrivateApiAvailable() {
        if (sNativeInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    private WeightTypefaceApi21() {
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

    private static long nativeCreateWeightAlias(long r100, int r101) {
        return ((Long) sNativeCreateWeightAlias.invoke(null, new Object[]{Long.valueOf(r100), Integer.valueOf(r101)})).longValue();
    L7:
        e = move-exception;
        throw new RuntimeException(e);
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
        long r105 = getNativeInstance(r100);     // Catch: Throwable -> L22
        LongSparseArray<SparseArray<Typeface>> r106 = sWeightTypefaceCache;     // Catch: Throwable -> L22
        SparseArray<Typeface> r107 = r106.get(r105);     // Catch: Throwable -> L22
        if (r107 != null) goto L11;
        r107 = new SparseArray(4);     // Catch: Throwable -> L22
        r106.put(r105, r107);     // Catch: Throwable -> L22
    L16:
        if (r102 != r100.isItalic()) goto L18;
        Typeface r108 = create(nativeCreateWeightAlias(r105, r101));     // Catch: Throwable -> L22
    L19:
        r107.put(r103 == true ? 1 : 0, r108);     // Catch: Throwable -> L22
        monitor-exit(r104);     // Catch: Throwable -> L22
        return r108;
    L18:
        r108 = create(nativeCreateFromTypefaceWithExactStyle(r105, r101, r102));     // Catch: Throwable -> L22
        goto L19
    L11:
        Typeface r109 = r107.get(r103 == true ? 1 : 0);     // Catch: Throwable -> L22
        if (r109 == null) goto L16;
        monitor-exit(r104);     // Catch: Throwable -> L22
        return r109;
    L22:
        th = move-exception;
        throw th;
    }

    private static long nativeCreateFromTypefaceWithExactStyle(long r100, int r101, boolean r102) {
        if (r102 == false) goto L5;
        int r103 = 2;
    L14:
        long r104 = ((Long) sNativeCreateFromTypeface.invoke(null, new Object[]{Long.valueOf(r100), Integer.valueOf(r103)})).longValue();     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L11
        return ((Long) sNativeCreateWeightAlias.invoke(null, new Object[]{Long.valueOf(r104), Integer.valueOf(r101)})).longValue();
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        r103 = 0;
        goto L14
    }
}
