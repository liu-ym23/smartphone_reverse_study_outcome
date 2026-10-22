package com.stepos.statsapp.v3.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class ReflectHelper {
    public static Object getField(Object obj, Class<?> cls, String str) throws NoSuchFieldException, SecurityException {
        if (cls == null || str == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            Field declaredField = ReflectionCache.build().getDeclaredField(cls, str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception unused) {
            throw new NoSuchFieldException(str);
        }
    }

    private static Object getFieldStepwise(Object obj, Class<?> cls, String str) throws NoSuchFieldException {
        while (cls != null) {
            try {
                try {
                    return getField(obj, cls, str);
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                }
            } catch (Exception unused2) {
                cls = null;
            }
        }
        throw new NoSuchFieldException(str);
    }

    private static Class<?>[] getParamsTypes(Object[] objArr) {
        int length = objArr.length;
        Class<?>[] clsArr = new Class[length];
        for (int i10 = 0; i10 < length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        return clsArr;
    }

    public static Object getStaticField(String str, String str2) throws NoSuchFieldException {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            return getFieldStepwise(null, ReflectionCache.build().forName(str), str2);
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("className not found");
        }
    }

    public static Object invoke(Object obj, String str, Object[] objArr) throws Exception {
        return invoke(obj.getClass(), obj, str, objArr);
    }

    public static Object invokeStatic(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws Exception {
        return invoke(ReflectionCache.build().forName(str), null, str2, clsArr, objArr);
    }

    public static Object reflectConstructor(String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        return (objArr == null || objArr.length <= 0) ? ReflectionCache.build().forName(str).getConstructor(null).newInstance(null) : ReflectionCache.build().forName(str).getConstructor(clsArr).newInstance(objArr);
    }

    public static boolean setField(Object obj, Class<?> cls, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (cls == null || str == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean setFieldStepwise(Object obj, Class<?> cls, String str, Object obj2) {
        while (cls != null) {
            if (setField(obj, cls, str, obj2)) {
                return true;
            }
            try {
                cls = cls.getSuperclass();
            } catch (Exception unused) {
                cls = null;
            }
        }
        return false;
    }

    public static boolean setStaticField(String str, String str2, Object obj) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            return setFieldStepwise(null, ReflectionCache.build().forName(str), str2, obj);
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("className not found");
        }
    }

    private static Object invoke(Class<?> cls, Object obj, String str, Object[] objArr) throws Exception {
        if (objArr == null || objArr.length == 0) {
            Method declaredMethod = ReflectionCache.build().getDeclaredMethod(cls, str, new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, null);
        }
        Method declaredMethod2 = ReflectionCache.build().getDeclaredMethod(cls, str, getParamsTypes(objArr));
        declaredMethod2.setAccessible(true);
        return declaredMethod2.invoke(obj, objArr);
    }

    public static Object invokeStatic(String str, String str2, Object[] objArr) throws Exception {
        return invoke(ReflectionCache.build().forName(str), (Object) null, str2, objArr);
    }

    public static Object getField(Object obj, String str) throws NoSuchFieldException {
        if (str != null) {
            return getFieldStepwise(obj, obj.getClass(), str);
        }
        throw new IllegalArgumentException("parameter can not be null!");
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        return invoke(obj.getClass(), obj, str, clsArr, objArr);
    }

    private static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        if (objArr != null && objArr.length != 0) {
            Method declaredMethod = ReflectionCache.build().getDeclaredMethod(cls, str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        }
        Method declaredMethod2 = ReflectionCache.build().getDeclaredMethod(cls, str, new Class[0]);
        declaredMethod2.setAccessible(true);
        return declaredMethod2.invoke(obj, null);
    }
}
