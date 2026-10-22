package com.byted.cast.common;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class ReflectMethods {
    private static final String TAG = null;

    public ReflectMethods() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        TAG = ReflectMethods.class.getName();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_common_ReflectMethods_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static Object invokeStaticMethod(String r100, String r101, Class[] r102, Object[] r103) {
        Class r104 = INVOKESTATIC_com_byted_cast_common_ReflectMethods_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Exception -> L17
        Method r105 = null;
    L5:
        if (r104 == Object.class) goto L10;
        r105 = r104.getMethod(r101, r102);     // Catch: Exception -> L20
        if (r105 != null) goto L10;
    L9:
        r104 = r104.getSuperclass();     // Catch: Exception -> L17
    L10:
        if (r105 != null) goto L12;
        Logger.i(TAG, "not found " + r101 + " method");     // Catch: Exception -> L17
        return null;
    L12:
        if (r105.isAccessible() == true) goto L14;
        r105.setAccessible(true);     // Catch: Exception -> L17
    L14:
        Object r106 = r105.invoke(null, r103);     // Catch: Exception -> L17
        Logger.d(TAG, "invoke " + r101 + " method succeed");     // Catch: Exception -> L17
        return r106;
    L17:
        e = move-exception;
        Logger.i(TAG, "invoke " + r101 + " method failed: " + e);
        return null;
    }
}
