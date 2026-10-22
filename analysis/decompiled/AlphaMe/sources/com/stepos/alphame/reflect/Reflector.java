package com.stepos.alphame.reflect;

import B0.g;
import android.util.Log;
import androidx.room.AbstractC0351g;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class Reflector {
    private static final String TAG = "Refector-AlphaMe";
    private static ConcurrentHashMap<String, Class<?>> mClassCache = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Method> mMethodCache = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Field> mFieldCache = new ConcurrentHashMap<>();

    private static Class<?> getCachedClass(String str) throws ClassNotFoundException {
        Class<?> cls;
        if (mClassCache.containsKey(str)) {
            return mClassCache.get(str);
        }
        try {
            cls = Class.forName(str);
            try {
                mClassCache.put(str, cls);
            } catch (ClassNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                return cls;
            }
        } catch (ClassNotFoundException e5) {
            e = e5;
            cls = null;
        }
        return cls;
    }

    private static Field getCachedField(String str, String str2) throws IllegalArgumentException {
        String strP = AbstractC0351g.p(str, str2);
        if (mFieldCache.containsKey(strP)) {
            return mFieldCache.get(strP);
        }
        Field fieldReflectField = reflectField(getCachedClass(str), str2);
        if (fieldReflectField != null) {
            mFieldCache.put(strP, fieldReflectField);
        }
        return fieldReflectField;
    }

    private static Method getCachedMethod(String str, String str2, Class<?>... clsArr) throws IllegalArgumentException {
        StringBuilder sbV = g.v(str, str2);
        for (Class<?> cls : clsArr) {
            sbV.append(cls.getName());
        }
        String string = sbV.toString();
        if (mMethodCache.containsKey(string)) {
            return mMethodCache.get(string);
        }
        Method methodReflectMethod = reflectMethod(getCachedClass(str), str2, clsArr);
        if (methodReflectMethod != null) {
            mMethodCache.put(string, methodReflectMethod);
        }
        return methodReflectMethod;
    }

    public static <T> T getConstant(String str, String str2, T t4) {
        try {
            return (T) invokeField(str, str2);
        } catch (Exception e4) {
            loge(e4);
            return t4;
        }
    }

    private static Field getField(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchFieldException, SecurityException {
        Field declaredField;
        try {
            try {
                return cls.getField(str);
            } catch (NoSuchFieldException unused) {
                declaredField = null;
                try {
                    return getSuperClassField(cls, str);
                } catch (NoSuchFieldException e4) {
                    loge(e4);
                    return declaredField;
                }
            }
        } catch (NoSuchFieldException unused2) {
            declaredField = cls.getDeclaredField(str);
            try {
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException unused3) {
                return getSuperClassField(cls, str);
            }
        }
    }

    private static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        try {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                declaredMethod = null;
                try {
                    return getSuperClassMethod(cls, str, clsArr);
                } catch (NoSuchMethodException e4) {
                    loge(e4);
                    return declaredMethod;
                }
            }
        } catch (NoSuchMethodException unused2) {
            declaredMethod = cls.getDeclaredMethod(str, clsArr);
            try {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused3) {
                return getSuperClassMethod(cls, str, clsArr);
            }
        }
    }

    private static Field getSuperClassField(Class<?> cls, String str) throws NoSuchFieldException, SecurityException {
        Field declaredField;
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
            }
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField;
            }
            continue;
        }
        StringBuilder sbW = g.w("No field ", str, " in ");
        sbW.append(cls.toString());
        throw new NoSuchFieldException(sbW.toString());
    }

    private static Method getSuperClassMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                declaredMethod = superclass.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
            continue;
        }
        StringBuilder sbW = g.w("No method ", str, " in ");
        sbW.append(cls.toString());
        throw new NoSuchMethodException(sbW.toString());
    }

    public static Object invokeField(Object obj, String str) throws NoSuchMethodException, IllegalArgumentException {
        try {
            if (str != null) {
                return getCachedField(obj.getClass().getName(), str).get(obj);
            }
            throw new NoSuchMethodException();
        } catch (Exception e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static Object invokeMethod(Object obj, Object[] objArr, String str, Class<?>... clsArr) throws NoSuchMethodException, IllegalArgumentException {
        try {
            if (str == null) {
                throw new NoSuchMethodException();
            }
            Method cachedMethod = getCachedMethod(obj.getClass().getName(), str, clsArr);
            cachedMethod.setAccessible(true);
            return cachedMethod.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new IllegalArgumentException(e4);
        } catch (NullPointerException e5) {
            throw new IllegalArgumentException(e5);
        } catch (InvocationTargetException e6) {
            throw new IllegalArgumentException(e6);
        } catch (Exception e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public static final void loge(Exception exc) {
        Log.i(TAG, "Fail to reflect, " + exc.getMessage());
    }

    public static Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static Field reflectField(Class<?> cls, String str) throws IllegalArgumentException {
        try {
            return getField(cls, str, new Class[0]);
        } catch (Exception e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    private static Method reflectMethod(Class<?> cls, String str, Class<?>... clsArr) throws IllegalArgumentException {
        try {
            return getMethod(cls, str, clsArr);
        } catch (Exception e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static Object invokeField(String str, String str2) throws NoSuchMethodException, IllegalArgumentException {
        try {
            if (str2 != null) {
                return getCachedField(str, str2).get(null);
            }
            throw new NoSuchMethodException();
        } catch (Exception e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static Object invokeMethod(Object obj, Object obj2, String str, Class<?> cls) throws NoSuchMethodException, IllegalArgumentException {
        return invokeMethod(obj, new Object[]{obj2}, str, (Class<?>[]) new Class[]{cls});
    }

    public static Object invokeMethod(Object obj, String str) throws NoSuchMethodException, IllegalArgumentException {
        return invokeMethod(obj, (Object[]) null, str, (Class<?>[]) new Class[0]);
    }

    public static Object invokeMethod(String str, Object obj, String str2, Class<?> cls) throws NoSuchMethodException, IllegalArgumentException {
        return invokeMethod(str, new Object[]{obj}, str2, (Class<?>[]) new Class[]{cls});
    }

    public static Object invokeMethod(String str, Object[] objArr, String str2, Class<?>... clsArr) throws NoSuchMethodException, SecurityException, IllegalArgumentException {
        try {
            if (str2 != null) {
                Method cachedMethod = getCachedMethod(str, str2, clsArr);
                cachedMethod.setAccessible(true);
                return cachedMethod.invoke(null, objArr);
            }
            throw new NoSuchMethodException();
        } catch (IllegalAccessException e4) {
            throw new IllegalArgumentException(e4);
        } catch (NullPointerException e5) {
            throw new IllegalArgumentException(e5);
        } catch (InvocationTargetException e6) {
            throw new IllegalArgumentException(e6);
        } catch (Exception e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public static Object invokeMethod(String str, String str2) throws NoSuchMethodException, IllegalArgumentException {
        return invokeMethod(str, (Object[]) null, str2, (Class<?>[]) new Class[0]);
    }
}
