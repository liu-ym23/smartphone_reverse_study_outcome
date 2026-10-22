package com.bytedance.android.openlive.utils;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes12.dex */
public class SoReflectUtil {
    public SoReflectUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_openlive_utils_SoReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static Constructor<?> findConstructor(Object r100, Class<?>... r101) throws NoSuchMethodException {
        Class<?> r102 = r100.getClass();
    L3:
        if (r102 == null) goto L10;
        Constructor<?> r103 = r102.getDeclaredConstructor(r101);     // Catch: NoSuchMethodException -> L8
        if (r103.isAccessible() == true) goto L7;
        r103.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L7:
        return r103;
    L8:
        r102 = r102.getSuperclass();
        goto L3
    L10:
        throw new NoSuchMethodException("Constructor with parameters " + Arrays.asList(r101) + " not found in " + r100.getClass());
    }

    public static Field findField(Object r100, String r101) throws NoSuchFieldException {
        Class<?> r102 = r100.getClass();
    L3:
        if (r102 == null) goto L10;
        Field r103 = r102.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L8
        if (r103.isAccessible() == true) goto L7;
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L7:
        return r103;
    L8:
        r102 = r102.getSuperclass();
        goto L3
    L10:
        throw new NoSuchFieldException("Field " + r101 + " not found in " + r100.getClass());
    }

    public static Object getActivityThread(Context r100, Class<?> r101) {
        if (r101 == null) goto L11;
    L5:
        Method r102 = r101.getMethod("currentActivityThread", new Class[0]);     // Catch: Throwable -> L10
        r102.setAccessible(true);     // Catch: Throwable -> L10
        Object r103 = r102.invoke(null, new Object[0]);     // Catch: Throwable -> L10
        if (r103 != null) goto L13;
        if (r100 == null) goto L14;
        Field r104 = r100.getClass().getField("mLoadedApk");     // Catch: Throwable -> L10
        r104.setAccessible(true);     // Catch: Throwable -> L10
        Object r105 = r104.get(r100);     // Catch: Throwable -> L10
        Field r106 = r105.getClass().getDeclaredField("mActivityThread");     // Catch: Throwable -> L10
        r106.setAccessible(true);     // Catch: Throwable -> L10
        return r106.get(r105);
    L10:
        return null;
    L14:
        return r103;
    L13:
        return r103;
    L11:
        r101 = INVOKESTATIC_com_bytedance_android_openlive_utils_SoReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");     // Catch: Throwable -> L10
        goto L5
    }

    public static Field findField(Class<?> r100, String r101) throws NoSuchFieldException {
        Class<?> r102 = r100;
    L3:
        if (r102 == null) goto L10;
        Field r103 = r102.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L8
        if (r103.isAccessible() == true) goto L7;
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L7:
        return r103;
    L8:
        r102 = r102.getSuperclass();
        goto L3
    L10:
        throw new NoSuchFieldException("Field " + r101 + " not found in " + r100);
    }

    public static void expandFieldArray(Object r100, String r101, Object[] r102) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field r103 = findField(r100, r101);
        Object[] r104 = (Object[]) r103.get(r100);
        Object[] r105 = (Object[]) Array.newInstance(r104.getClass().getComponentType(), r104.length + r102.length);
        System.arraycopy(r102, 0, r105, 0, r102.length);
        System.arraycopy(r104, 0, r105, r102.length, r104.length);
        r103.set(r100, r105);
    }

    public static Method findMethod(Object r100, String r101, Class<?>... r102) throws NoSuchMethodException {
        Class<?> r103 = r100.getClass();
    L3:
        if (r103 == null) goto L10;
        Method r104 = r103.getDeclaredMethod(r101, r102);     // Catch: NoSuchMethodException -> L8
        if (r104.isAccessible() == true) goto L7;
        r104.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L7:
        return r104;
    L8:
        r103 = r103.getSuperclass();
        goto L3
    L10:
        throw new NoSuchMethodException("Method " + r101 + " with parameters " + Arrays.asList(r102) + " not found in " + r100.getClass());
    }

    public static int getValueOfStaticIntField(Class<?> r100, String r101, int r102) {
        return findField(r100, r101).getInt(null);
    L4:
        return r102;
    }

    public static void reduceFieldArray(Object r100, String r101, int r102) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (r102 > 0) goto L4;
        return;
    L4:
        Field r103 = findField(r100, r101);
        Object[] r104 = (Object[]) r103.get(r100);
        int r105 = r104.length - r102;
        if (r105 > 0) goto L7;
        return;
    L7:
        Object[] r106 = (Object[]) Array.newInstance(r104.getClass().getComponentType(), r105);
        System.arraycopy(r104, r102, r106, 0, r105);
        r103.set(r100, r106);
    }

    public static Method findMethod(Class<?> r100, String r101, Class<?>... r102) throws NoSuchMethodException {
    L2:
        if (r100 == null) goto L9;
        Method r103 = r100.getDeclaredMethod(r101, r102);     // Catch: NoSuchMethodException -> L7
        if (r103.isAccessible() == true) goto L6;
        r103.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L6:
        return r103;
    L7:
        r100 = r100.getSuperclass();
        goto L2
    L9:
        throw new NoSuchMethodException("Method " + r101 + " with parameters " + Arrays.asList(r102) + " not found in " + r100);
    }
}
