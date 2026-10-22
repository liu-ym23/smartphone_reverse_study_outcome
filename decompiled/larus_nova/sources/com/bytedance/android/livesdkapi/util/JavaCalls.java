package com.bytedance.android.livesdkapi.util;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import jc1.e;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes12.dex */
public class JavaCalls {
    private static final String LOG_TAG = "JavaCalls";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP = null;

    public static class JavaParam<T> {
        public final Class<? extends T> clazz;
        public final T obj;

        public JavaParam(Class<? extends T> r100, T r101) {
            this.clazz = r100;
            this.obj = r101;
        }
    }

    public JavaCalls() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ Class access$001(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    static {
        HashMap r100 = new HashMap();
        PRIMITIVE_MAP = r100;
        Class r101 = Boolean.TYPE;
        r100.put(Boolean.class, r101);
        r100.put(Byte.class, Byte.TYPE);
        r100.put(Character.class, Character.TYPE);
        r100.put(Short.class, Short.TYPE);
        Class r102 = Integer.TYPE;
        r100.put(Integer.class, r102);
        Class r103 = Float.TYPE;
        r100.put(Float.class, r103);
        Class r104 = Long.TYPE;
        r100.put(Long.class, r104);
        r100.put(Double.class, Double.TYPE);
        r100.put(r101, r101);
        Class r105 = Byte.TYPE;
        r100.put(r105, r105);
        Class r106 = Character.TYPE;
        r100.put(r106, r106);
        Class r107 = Short.TYPE;
        r100.put(r107, r107);
        r100.put(r102, r102);
        r100.put(r103, r103);
        r100.put(r104, r104);
        Class r108 = Double.TYPE;
        r100.put(r108, r108);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livesdkapi_util_JavaCalls_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static Object getDefaultValue(Class<?> r100) {
        if (Integer.TYPE.equals(r100) == true) goto L44;
        if (Integer.class.equals(r100) == true) goto L44;
        if (Byte.TYPE.equals(r100) == true) goto L44;
        if (Byte.class.equals(r100) == true) goto L44;
        if (Short.TYPE.equals(r100) == true) goto L44;
        if (Short.class.equals(r100) == true) goto L44;
        if (Long.TYPE.equals(r100) == true) goto L44;
        if (Long.class.equals(r100) == true) goto L44;
        if (Double.TYPE.equals(r100) == true) goto L44;
        if (Double.class.equals(r100) == true) goto L44;
        if (Float.TYPE.equals(r100) == true) goto L44;
        if (Float.class.equals(r100) == true) goto L44;
        if (Boolean.TYPE.equals(r100) == true) goto L42;
        if (Boolean.class.equals(r100) == true) goto L42;
        if (Character.TYPE.equals(r100) == true) goto L40;
        if (Character.class.equals(r100) == true) goto L40;
        return null;
    L40:
        return (char) 0;
    L42:
        return Boolean.FALSE;
    L44:
        return 0;
    }

    private static Class<?>[] getParameterTypes(Object... r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length <= 0) goto L25;
        Class<?>[] r101 = new Class[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L20;
        Object r103 = r100[r102];
        if (r103 != null) goto L12;
    L14:
        if (r103 != null) goto L16;
        Class<?> r104 = null;
    L17:
        r101[r102] = r104;
    L18:
        r102 = r102 + 1;
        goto L8
    L16:
        r104 = r103.getClass();
        goto L17
    L12:
        if ((r103 instanceof JavaParam) == false) goto L14;
        r101[r102] = ((JavaParam) r103).clazz;
        goto L18
    L20:
        return r101;
    L25:
        return null;
    }

    private static Object[] getParameters(Object... r100) {
        if (r100 != null) goto L4;
    L15:
        return null;
    L4:
        if (r100.length <= 0) goto L15;
        Object[] r101 = new Object[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L20;
        Object r103 = r100[r102];
        if (r103 != null) goto L11;
    L13:
        r101[r102] = r103;
    L14:
        r102 = r102 + 1;
        goto L7
    L11:
        if ((r103 instanceof JavaParam) == false) goto L13;
        r101[r102] = ((JavaParam) r103).obj;
        goto L14
    L20:
        return r101;
    }

    public static <T> T newEmptyInstance(Class<?> r100) {
        return (T) newEmptyInstanceOrThrow(r100);
    L4:
        r100.getSimpleName();
        return null;
    }

    public static <T> T newEmptyInstanceOrThrow(Class<?> r100) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Constructor<?>[] r101 = r100.getDeclaredConstructors();
        if (r101 == null) goto L20;
        if (r101.length == 0) goto L20;
        int r102 = 0;
        Constructor<?> r103 = r101[0];
        r103.setAccessible(true);
        Class<?>[] r104 = r103.getParameterTypes();
        if (r104 == null) goto L18;
        if (r104.length == 0) goto L18;
        Object[] r105 = new Object[r104.length];
    L13:
        if (r102 >= r104.length) goto L16;
        r105[r102] = getDefaultValue(r104[r102]);
        r102 = r102 + 1;
        goto L13
    L16:
        return (T) r103.newInstance(r105);
    L18:
        return (T) r103.newInstance(new Object[0]);
    L20:
        throw new IllegalArgumentException("Can't get even one available constructor for " + r100);
    }

    private static boolean compareClassLists(Class<?>[] r100, Class<?>[] r101) {
        if (r100 != null) goto L10;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r101.length == 0) goto L37;
        return false;
    L37:
        return true;
    L10:
        if (r101 != null) goto L17;
        if (r100.length == 0) goto L38;
        return false;
    L38:
        return true;
    L17:
        if (r100.length == r101.length) goto L19;
        return false;
    L19:
        int r102 = 0;
    L21:
        if (r102 >= r100.length) goto L30;
        if (r100[r102].isAssignableFrom(r101[r102]) == true) goto L29;
        Map<Class<?>, Class<?>> r103 = PRIMITIVE_MAP;
        if (r103.containsKey(r100[r102]) == false) goto L28;
        if (r103.get(r100[r102]).equals(r103.get(r101[r102])) == true) goto L29;
    L28:
        return false;
    L29:
        r102 = r102 + 1;
        goto L21
    L30:
        return true;
    }

    public static <T> T getField(Object r100, String r101) {
        return (T) getFieldOrThrow(r100, r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static <T> T getFieldOrThrow(Object r100, String r101) throws NoSuchFieldException, IllegalAccessException {
        Class<?> r102 = r100.getClass();
        Field r103 = null;
    L4:
        if (r103 != null) goto L12;
        r103 = r102.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L7
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        if (r102 != null) goto L4;
        throw new NoSuchFieldException();
    L7:
        r102 = r102.getSuperclass();
        goto L8
    L12:
        r103.setAccessible(true);
        return (T) r103.get(r100);
    }

    public static <T> T newInstance(Class<?> r100, Object... r101) {
        return (T) newInstanceOrThrow(r100, r101);
    L4:
        r100.getSimpleName();
        return null;
    }

    public static <T> T newInstanceOrThrow(Class<?> r100, Object... r101) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor<?> r102 = r100.getConstructor(getParameterTypes(r101));
        r102.setAccessible(true);
        return (T) r102.newInstance(getParameters(r101));
    }

    public static Object newInstance(String r100, Object... r101) {
        return newInstanceOrThrow(r100, r101);
    L5:
        return null;
    }

    public static Object newInstanceOrThrow(String r100, Object... r101) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NullPointerException {
        int r102 = e.f498076a;
        return newInstanceOrThrow(INVOKESTATIC_com_bytedance_android_livesdkapi_util_JavaCalls_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100), getParameters(r101));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livesdkapi_util_JavaCalls_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$001(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$001(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static <T> T callMethod(Object r100, String r101, Object... r102) {
        return (T) callMethodOrThrow(r100, r101, r102);
    L4:
        Objects.toString(r100);
        return null;
    }

    public static <T> T callMethodOrThrow(Object r100, String r101, Object... r102) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return (T) getDeclaredMethod(r100.getClass(), r101, getParameterTypes(r102)).invoke(r100, getParameters(r102));
    }

    public static <T> T callStaticMethod(String r100, String r101, Object... r102) {
        int r103 = e.f498076a;     // Catch: Exception -> L4
        return (T) callStaticMethodOrThrow(INVOKESTATIC_com_bytedance_android_livesdkapi_util_JavaCalls_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100), r101, r102);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static <T> T callStaticMethodOrThrow(String r100, String r101, Object... r102) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        int r103 = e.f498076a;
        return (T) getDeclaredMethod(INVOKESTATIC_com_bytedance_android_livesdkapi_util_JavaCalls_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100), r101, getParameterTypes(r102)).invoke(null, getParameters(r102));
    }

    private static Method findMethodByName(Method[] r100, String r101, Class<?>[] r102) {
        if (r101 == null) goto L14;
        int r103 = r100.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L11;
        Method r105 = r100[r104];
        if (r105.getName().equals(r101) == false) goto L10;
        if (compareClassLists(r105.getParameterTypes(), r102) == false) goto L10;
        return r105;
    L10:
        r104 = r104 + 1;
        goto L4
    L11:
        return null;
    L14:
        throw new NullPointerException("Method name must not be null.");
    }

    private static Method getDeclaredMethod(Class<?> r100, String r101, Class<?>... r102) throws NoSuchMethodException, SecurityException {
        Method r103 = findMethodByName(r100.getDeclaredMethods(), r101, r102);
        if (r103 == null) goto L5;
        r103.setAccessible(true);
        return r103;
    L5:
        if (r100.getSuperclass() == null) goto L9;
        return getDeclaredMethod(r100.getSuperclass(), r101, r102);
    L9:
        throw new NoSuchMethodException();
    }

    public static void setField(Object r100, String r101, Object r102) {
        setFieldOrThrow(r100, r101, r102);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
    L12:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setFieldOrThrow(Object r100, String r101, Object r102) throws NoSuchFieldException, IllegalAccessException {
        Class<?> r103 = r100.getClass();
        Field r104 = null;
    L3:
        if (r104 != null) goto L11;
        r104 = r103.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L6
    L7:
        if (r103 != null) goto L3;
        throw new NoSuchFieldException();
    L6:
        r103 = r103.getSuperclass();
        goto L7
    L11:
        r104.setAccessible(true);
        r104.set(r100, r102);
    }

    public static <T> T callStaticMethodOrThrow(Class<?> r100, String r101, Object... r102) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return (T) getDeclaredMethod(r100, r101, getParameterTypes(r102)).invoke(null, getParameters(r102));
    }

    public static <T> T callStaticMethodWithClassLoader(String r100, String r101, ClassLoader r102, Object... r103) {
        int r104 = e.f498076a;     // Catch: Exception -> L4
        return (T) callStaticMethodOrThrow(INVOKESTATIC_com_bytedance_android_livesdkapi_util_JavaCalls_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100, true, r102), r101, r103);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
