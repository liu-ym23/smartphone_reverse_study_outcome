package com.autonavi.base.ae.gmap.glyph;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public final class ReflectUtil {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public ReflectUtil() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_autonavi_base_ae_gmap_glyph_ReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static Object getInstance(String r100, Object... r101) {
        if (r100 == null) goto L18;
        if (r100.equals("") == true) goto L18;
        Class r102 = INVOKESTATIC_com_autonavi_base_ae_gmap_glyph_ReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Throwable -> L14
        int r103 = 0;
        if (r101 == null) goto L12;
        int r104 = r101.length;     // Catch: Throwable -> L14
        Class<?>[] r105 = new Class[r104];     // Catch: Throwable -> L14
    L8:
        if (r103 >= r104) goto L10;
        r105[r103] = r101[r103].getClass();     // Catch: Throwable -> L14
        r103 = r103 + 1;     // Catch: Throwable -> L14
        goto L8
    L10:
        Constructor r106 = r102.getDeclaredConstructor(r105);     // Catch: Throwable -> L14
        r106.setAccessible(true);     // Catch: Throwable -> L14
        return r106.newInstance(r101);
    L12:
        Constructor r107 = r102.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L14
        r107.setAccessible(true);     // Catch: Throwable -> L14
        return r107.newInstance(new Object[0]);
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    L18:
        throw new IllegalArgumentException("className 不能为空");
    }

    public static Object getField(String r100, Object r101, String r102) {
        if (r100 == null) goto L16;
        if (r100.equals("") == true) goto L16;
        if (r102 == null) goto L14;
        if (r102.equals("") == true) goto L14;
        Field r103 = INVOKESTATIC_com_autonavi_base_ae_gmap_glyph_ReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).getDeclaredField(r102);     // Catch: Throwable -> L10
        r103.setAccessible(true);     // Catch: Throwable -> L10
        return r103.get(r101);
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    L14:
        throw new IllegalArgumentException("fieldName 不能为空");
    L16:
        throw new IllegalArgumentException("className 不能为空");
    }

    public static Method getMethod(String r100, String r101, Class... r102) {
        if (r100 == null) goto L16;
        if (r100.equals("") == true) goto L16;
        if (r101 == null) goto L14;
        if (r101.equals("") == true) goto L14;
        return INVOKESTATIC_com_autonavi_base_ae_gmap_glyph_ReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).getDeclaredMethod(r101, r102);
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    L14:
        throw new IllegalArgumentException("methodName不能为空");
    L16:
        throw new IllegalArgumentException("className 不能为空");
    }

    public static Object invokeMethod(Object r100, Method r101, Object... r102) {
        if (r101 == null) goto L10;
        r101.setAccessible(true);
        return r101.invoke(r100, r102);
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    L10:
        throw new IllegalArgumentException("method 不能为空");
    }

    public static Object newInstance(String r100, Class<?>[] r101, Object[] r102) {
        if (r100 == null) goto L15;
        if (r100.equals("") == true) goto L15;
        Class r103 = INVOKESTATIC_com_autonavi_base_ae_gmap_glyph_ReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        Constructor r104 = r103.getDeclaredConstructor(r101);     // Catch: Throwable -> L11
        r104.setAccessible(true);     // Catch: Throwable -> L11
        return r104.newInstance(r102);
    L9:
        Constructor r105 = r103.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L11
        r105.setAccessible(true);     // Catch: Throwable -> L11
        return r105.newInstance(new Object[0]);
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    L15:
        throw new IllegalArgumentException("className 不能为空");
    }

    public static Object invoke(String r100, Object r101, String r102, Object... r103) {
        if (r100 == null) goto L23;
        if (r100.equals("") == true) goto L23;
        if (r102 == null) goto L21;
        if (r102.equals("") == true) goto L21;
        Class r104 = INVOKESTATIC_com_autonavi_base_ae_gmap_glyph_ReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Throwable -> L17
        int r105 = 0;
        if (r103 == null) goto L15;
        int r106 = r103.length;     // Catch: Throwable -> L17
        Class<?>[] r107 = new Class[r106];     // Catch: Throwable -> L17
    L11:
        if (r105 >= r106) goto L13;
        r107[r105] = r103[r105].getClass();     // Catch: Throwable -> L17
        r105 = r105 + 1;     // Catch: Throwable -> L17
        goto L11
    L13:
        Method r108 = r104.getDeclaredMethod(r102, r107);     // Catch: Throwable -> L17
        r108.setAccessible(true);     // Catch: Throwable -> L17
        return r108.invoke(r101, r103);
    L15:
        Method r109 = r104.getDeclaredMethod(r102, new Class[0]);     // Catch: Throwable -> L17
        r109.setAccessible(true);     // Catch: Throwable -> L17
        return r109.invoke(r101, new Object[0]);
    L17:
        th = move-exception;
        th.printStackTrace();
        return null;
    L21:
        throw new IllegalArgumentException("methodName不能为空");
    L23:
        throw new IllegalArgumentException("className 不能为空");
    }

    public static void setField(String r100, Object r101, String r102, Object r103) {
        if (r100 == null) goto L16;
        if (r100.equals("") == true) goto L16;
        if (r102 == null) goto L14;
        if (r102.equals("") == true) goto L14;
        Field r104 = INVOKESTATIC_com_autonavi_base_ae_gmap_glyph_ReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).getDeclaredField(r102);     // Catch: Throwable -> L10
        r104.setAccessible(true);     // Catch: Throwable -> L10
        r104.set(r101, r103);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L14:
        throw new IllegalArgumentException("fieldName 不能为空");
    L16:
        throw new IllegalArgumentException("className 不能为空");
    }
}
