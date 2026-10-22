package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ResourcesFlusher.java */
/* JADX INFO: loaded from: classes.dex */
class g {
    private static final String TAG = "ResourcesFlusher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Field f251e;
    private static boolean f;
    private static Field g;
    private static boolean h;

    /* JADX INFO: compiled from: ResourcesFlusher.java */
    static class a {
        static void a(LongSparseArray r0) {
            r0.clear();
        }
    }

    static void a(Resources r2) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        d(r2);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        c(r2);
        return;
    L12:
        if (Build.VERSION.SDK_INT < 21) goto L17;
        b(r2);
        return;
    }

    private static void b(Resources r4) {
        if (f248b == false) goto L22;
    L10:
        Field r0 = f247a;
        if (r0 == null) goto L24;
        Map r2 = null;
        r2 = (Map) ZeusTransformUtils.preCheckCast(r0.get(r4), Map.class, "com.obric.aiagent.plugin");     // Catch: IllegalAccessException -> L15
    L17:
        if (r2 == null) goto L25;
        r2.clear();
        return;
    L25:
        return;
    L15:
        e = move-exception;
        a(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        goto L17
    L24:
        return;
    L22:
        Field r3 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        f247a = r3;     // Catch: NoSuchFieldException -> L7
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        f248b = true;
    L7:
        e = move-exception;
        a(TAG, "Could not retrieve Resources#mDrawableCache field", e);
        goto L9
    }

    private static void c(Resources r4) {
        if (f248b == false) goto L22;
    L10:
        Object r0 = null;
        Field r2 = f247a;
        if (r2 != null) goto L20;
    L16:
        if (r0 != null) goto L18;
        return;
    L18:
        a(r0);
        return;
    L20:
        r0 = r2.get(r4);     // Catch: IllegalAccessException -> L14
    L14:
        e = move-exception;
        a(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        goto L16
    L22:
        Field r3 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        f247a = r3;     // Catch: NoSuchFieldException -> L7
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        f248b = true;
    L7:
        e = move-exception;
        a(TAG, "Could not retrieve Resources#mDrawableCache field", e);
        goto L9
    }

    private static void d(Resources r5) {
        if (h == false) goto L41;
    L9:
        Field r0 = g;
        if (r0 != null) goto L12;
        return;
    L12:
        Object r3 = null;
        Object r6 = r0.get(r5);     // Catch: IllegalAccessException -> L15
    L17:
        if (r6 != null) goto L20;
        return;
    L20:
        if (f248b == false) goto L35;
    L26:
        Field r1 = f247a;
        if (r1 != null) goto L39;
    L32:
        if (r3 == null) goto L43;
        a(r3);
        return;
    L43:
        return;
    L39:
        r3 = r1.get(r6);     // Catch: IllegalAccessException -> L30
    L30:
        e = move-exception;
        a(TAG, "Could not retrieve value from ResourcesImpl#mDrawableCache", e);
        goto L32
    L35:
        Field r2 = r6.getClass().getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L23
        f247a = r2;     // Catch: NoSuchFieldException -> L23
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L25:
        f248b = true;
    L23:
        e = move-exception;
        a(TAG, "Could not retrieve ResourcesImpl#mDrawableCache field", e);
    L15:
        e = move-exception;
        a(TAG, "Could not retrieve value from Resources#mResourcesImpl", e);
        r6 = null;
        goto L17
    L41:
        Field r4 = Resources.class.getDeclaredField("mResourcesImpl");     // Catch: NoSuchFieldException -> L6
        g = r4;     // Catch: NoSuchFieldException -> L6
        r4.setAccessible(true);     // Catch: NoSuchFieldException -> L6
    L8:
        h = true;
    L6:
        e = move-exception;
        a(TAG, "Could not retrieve Resources#mResourcesImpl field", e);
        goto L8
    }

    private static void a(Object r5) {
        if (f250d == false) goto L30;
    L9:
        Class<?> r0 = f249c;
        if (r0 != null) goto L13;
        return;
    L13:
        if (f == false) goto L34;
    L19:
        Field r1 = f251e;
        if (r1 != null) goto L22;
        return;
    L22:
        LongSparseArray r2 = null;
        r2 = (LongSparseArray) ZeusTransformUtils.preCheckCast(r1.get(r5), LongSparseArray.class, "com.obric.aiagent.plugin");     // Catch: IllegalAccessException -> L25
    L27:
        if (r2 == null) goto L36;
        a.a(r2);
        return;
    L36:
        return;
    L25:
        e = move-exception;
        a(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e);
        goto L27
    L34:
        Field r3 = r0.getDeclaredField("mUnthemedEntries");     // Catch: NoSuchFieldException -> L16
        f251e = r3;     // Catch: NoSuchFieldException -> L16
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L16
    L18:
        f = true;
    L16:
        e = move-exception;
        a(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e);
        goto L18
    L30:
        f249c = ZeusTransformUtils.forName("android.content.res.ThemedResourceCache", "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L6
    L8:
        f250d = true;
    L6:
        e = move-exception;
        a(TAG, "Could not find ThemedResourceCache class", e);
        goto L8
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
