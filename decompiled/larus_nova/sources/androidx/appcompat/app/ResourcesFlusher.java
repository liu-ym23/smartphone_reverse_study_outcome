package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class<?> sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private ResourcesFlusher() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_appcompat_app_ResourcesFlusher_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void flush(Resources r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 28) goto L6;
        return;
    L6:
        if (r101 < 24) goto L9;
        flushNougats(r100);
        return;
    L9:
        if (r101 < 23) goto L11;
        flushMarshmallows(r100);
        return;
    L11:
        flushLollipops(r100);
    }

    private static void flushLollipops(Resources r100) {
        if (sDrawableCacheFieldFetched == false) goto L18;
    L7:
        Field r101 = sDrawableCacheField;
        if (r101 == null) goto L20;
        Map r102 = (Map) r101.get(r100);     // Catch: IllegalAccessException -> L11
    L12:
        if (r102 == null) goto L21;
        r102.clear();
        return;
    L21:
        return;
    L11:
        r102 = null;
        goto L12
    L20:
        return;
    L18:
        Field r103 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L15
        sDrawableCacheField = r103;     // Catch: NoSuchFieldException -> L15
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L15
    L6:
        sDrawableCacheFieldFetched = true;
        goto L7
    }

    private static void flushMarshmallows(Resources r100) {
        if (sDrawableCacheFieldFetched == false) goto L18;
    L7:
        Field r101 = sDrawableCacheField;
        if (r101 != null) goto L20;
    L11:
        Object r102 = null;
    L12:
        if (r102 != null) goto L14;
        return;
    L14:
        flushThemedResourcesCache(r102);
        return;
    L20:
        r102 = r101.get(r100);     // Catch: IllegalAccessException -> L17
    L18:
        Field r103 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L16
        sDrawableCacheField = r103;     // Catch: NoSuchFieldException -> L16
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L16
    L6:
        sDrawableCacheFieldFetched = true;
        goto L7
    }

    private static void flushNougats(Resources r100) {
        if (sResourcesImplFieldFetched == false) goto L35;
    L6:
        Field r101 = sResourcesImplField;
        if (r101 != null) goto L9;
        return;
    L9:
        Object r102 = null;
        Object r103 = r101.get(r100);     // Catch: IllegalAccessException -> L12
    L13:
        if (r103 != null) goto L16;
        return;
    L16:
        if (sDrawableCacheFieldFetched == false) goto L29;
    L19:
        Field r104 = sDrawableCacheField;
        if (r104 != null) goto L33;
    L24:
        if (r102 == null) goto L37;
        flushThemedResourcesCache(r102);
        return;
    L37:
        return;
    L33:
        r102 = r104.get(r103);     // Catch: IllegalAccessException -> L23
        goto L24
    L29:
        Field r105 = r103.getClass().getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L27
        sDrawableCacheField = r105;     // Catch: NoSuchFieldException -> L27
        r105.setAccessible(true);     // Catch: NoSuchFieldException -> L27
    L18:
        sDrawableCacheFieldFetched = true;
    L12:
        r103 = null;
        goto L13
    L35:
        Field r106 = Resources.class.getDeclaredField("mResourcesImpl");     // Catch: NoSuchFieldException -> L28
        sResourcesImplField = r106;     // Catch: NoSuchFieldException -> L28
        r106.setAccessible(true);     // Catch: NoSuchFieldException -> L28
    L5:
        sResourcesImplFieldFetched = true;
        goto L6
    }

    private static void flushThemedResourcesCache(Object r100) {
        if (sThemedResourceCacheClazzFetched == false) goto L28;
    L6:
        Class<?> r101 = sThemedResourceCacheClazz;
        if (r101 != null) goto L10;
        return;
    L10:
        if (sThemedResourceCache_mUnthemedEntriesFieldFetched == false) goto L26;
    L13:
        Field r102 = sThemedResourceCache_mUnthemedEntriesField;
        if (r102 != null) goto L24;
        return;
    L24:
        LongSparseArray r103 = (LongSparseArray) r102.get(r100);     // Catch: IllegalAccessException -> L18
    L19:
        if (r103 == null) goto L30;
        r103.clear();
        return;
    L30:
        return;
    L18:
        r103 = null;
        goto L19
    L26:
        Field r104 = r101.getDeclaredField("mUnthemedEntries");     // Catch: NoSuchFieldException -> L22
        sThemedResourceCache_mUnthemedEntriesField = r104;     // Catch: NoSuchFieldException -> L22
        r104.setAccessible(true);     // Catch: NoSuchFieldException -> L22
    L12:
        sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        goto L13
    L28:
        sThemedResourceCacheClazz = INVOKESTATIC_androidx_appcompat_app_ResourcesFlusher_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.res.ThemedResourceCache");     // Catch: ClassNotFoundException -> L23
    L5:
        sThemedResourceCacheClazzFetched = true;
        goto L6
    }
}
