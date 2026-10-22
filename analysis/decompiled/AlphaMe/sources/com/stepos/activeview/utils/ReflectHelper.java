package com.stepos.activeview.utils;

import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import net.sourceforge.jeval.EvaluationConstants;

/* loaded from: classes.dex */
public class ReflectHelper {
    private static Map<String, Class> mClassMap = new ArrayMap();
    private static Map<String, Method> mMethodMap = new ArrayMap();

    public static Object getField(Object obj, Class<?> cls, String str) throws NoSuchFieldException, SecurityException {
        if (obj == null || cls == null || str == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
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
        for (int i4 = 0; i4 < length; i4++) {
            clsArr[i4] = objArr[i4].getClass();
        }
        return clsArr;
    }

    private static String getParamsTypesString(Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("(");
        boolean z4 = true;
        for (Class<?> cls : clsArr) {
            if (z4) {
                z4 = false;
            } else {
                sb.append(",");
            }
            if (cls != null) {
                sb.append(cls.getCanonicalName());
            } else {
                sb.append("null");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static Object getStaticField(String str, String str2) throws NoSuchFieldException, ClassNotFoundException {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        Class<?> cls = mClassMap.get(str);
        if (cls == null) {
            try {
                cls = Class.forName(str);
                mClassMap.put(str, cls);
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("className not found");
            }
        }
        return getFieldStepwise(cls, cls, str2);
    }

    public static Object invoke(Object obj, String str, Object[] objArr) throws Exception {
        return invoke(obj.getClass(), obj, str, objArr);
    }

    public static Object invokeStatic(String str, String str2, Object[] objArr) throws Exception {
        Class<?> cls = mClassMap.get(str);
        if (cls == null) {
            cls = Class.forName(str);
            mClassMap.put(str, cls);
        }
        return invoke(cls, cls, str2, objArr);
    }

    public static Object reflectConstructor(Class<?> cls, Object[] objArr) throws Exception {
        return (objArr == null || objArr.length <= 0) ? cls.getConstructor(new Class[0]).newInstance(new Object[0]) : cls.getConstructor(getParamsTypes(objArr)).newInstance(objArr);
    }

    public static boolean setField(Object obj, Class<?> cls, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (obj == null || cls == null || str == null) {
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

    public static boolean setStaticField(String str, String str2, Object obj) throws ClassNotFoundException {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        Class<?> cls = mClassMap.get(str);
        if (cls == null) {
            try {
                cls = Class.forName(str);
                mClassMap.put(str, cls);
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("className not found");
            }
        }
        return setFieldStepwise(cls, cls, str2, obj);
    }

    private static Object invoke(Class<?> cls, Object obj, String str, Object[] objArr) throws Exception {
        Object objInvoke;
        Object objInvoke2;
        if (objArr == null || objArr.length == 0) {
            synchronized (mMethodMap) {
                try {
                    Method method = mMethodMap.get(str);
                    if (method == null) {
                        method = cls.getMethod(str, new Class[0]);
                        method.setAccessible(true);
                        mMethodMap.put(str, method);
                    }
                    objInvoke = method.invoke(obj, new Object[0]);
                } finally {
                }
            }
            return objInvoke;
        }
        synchronized (mMethodMap) {
            try {
                Class<?>[] paramsTypes = getParamsTypes(objArr);
                String str2 = cls.getName() + EvaluationConstants.POUND_SIGN + str + getParamsTypesString(paramsTypes) + "#bestmatch";
                Method method2 = mMethodMap.get(str2);
                if (method2 == null) {
                    method2 = cls.getMethod(str, paramsTypes);
                    method2.setAccessible(true);
                    mMethodMap.put(str2, method2);
                }
                objInvoke2 = method2.invoke(obj, objArr);
            } finally {
            }
        }
        return objInvoke2;
    }

    public static Object invokeStatic(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Class<?> cls = mClassMap.get(str);
        if (cls == null) {
            cls = Class.forName(str);
            mClassMap.put(str, cls);
        }
        return invoke(cls, cls, str2, clsArr, objArr);
    }

    public static boolean setField(Object obj, String str, Object obj2) {
        if (obj != null && str != null) {
            return setFieldStepwise(obj, obj.getClass(), str, obj2);
        }
        throw new IllegalArgumentException("parameter can not be null!");
    }

    public static Object getField(Object obj, String str) throws NoSuchFieldException {
        if (obj != null && str != null) {
            return getFieldStepwise(obj, obj.getClass(), str);
        }
        throw new IllegalArgumentException("parameter can not be null!");
    }

    public static Object reflectConstructor(Class<?> cls, Class<?>[] clsArr, Object[] objArr) throws Exception {
        if (objArr != null && objArr.length > 0) {
            return cls.getConstructor(clsArr).newInstance(objArr);
        }
        return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        return invoke(obj.getClass(), obj, str, clsArr, objArr);
    }

    private static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Object objInvoke;
        Object objInvoke2;
        if (objArr != null && objArr.length != 0) {
            synchronized (mMethodMap) {
                try {
                    String str2 = cls.getName() + EvaluationConstants.POUND_SIGN + str + getParamsTypesString(clsArr) + "#bestmatch";
                    Method method = mMethodMap.get(str2);
                    if (method == null) {
                        method = cls.getMethod(str, clsArr);
                        method.setAccessible(true);
                        mMethodMap.put(str2, method);
                    }
                    objInvoke2 = method.invoke(obj, objArr);
                } finally {
                }
            }
            return objInvoke2;
        }
        synchronized (mMethodMap) {
            try {
                Method method2 = mMethodMap.get(str);
                if (method2 == null) {
                    method2 = cls.getMethod(str, new Class[0]);
                    method2.setAccessible(true);
                    mMethodMap.put(str, method2);
                }
                objInvoke = method2.invoke(obj, new Object[0]);
            } finally {
            }
        }
        return objInvoke;
    }
}
