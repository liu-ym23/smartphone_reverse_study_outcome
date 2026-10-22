package com.stepos.launcher.assistant.utils.reflect;

import android.util.ArrayMap;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes.dex */
public class ReflectHelper {
    private static Map<String, Class> mClassMap = new ArrayMap();
    private static Map<String, Method> mMethodMap = new ArrayMap();
    private static Map<String, Field> mFieldMap = new ArrayMap();

    public static Object getField(Object obj, Class<?> cls, String str) throws NoSuchFieldException {
        Object obj2;
        if (obj == null || cls == null || str == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        synchronized (mFieldMap) {
            String str2 = cls.getName() + "_" + str;
            Field declaredField = mFieldMap.get(str2);
            if (declaredField == null) {
                declaredField = cls.getDeclaredField(str);
                mFieldMap.put(str2, declaredField);
            }
            try {
                declaredField.setAccessible(true);
                obj2 = declaredField.get(obj);
            } catch (Exception unused) {
                throw new NoSuchFieldException(str);
            }
        }
        return obj2;
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

    private static String getParamsTypesString(Class<?>... clsArr) {
        StringBuilder sb2 = new StringBuilder("(");
        boolean z10 = true;
        for (Class<?> cls : clsArr) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(Const.STR_MART_COMMA);
            }
            if (cls != null) {
                sb2.append(cls.getCanonicalName());
            } else {
                sb2.append("null");
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public static Object getStaticField(String str, String str2) throws NoSuchFieldException {
        Object fieldStepwise;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        synchronized (mClassMap) {
            Class<?> cls = mClassMap.get(str);
            if (cls == null) {
                try {
                    cls = Class.forName(str);
                    mClassMap.put(str, cls);
                } catch (ClassNotFoundException unused) {
                    throw new IllegalArgumentException("className not found");
                }
            }
            fieldStepwise = getFieldStepwise(cls, cls, str2);
        }
        return fieldStepwise;
    }

    public static Object invoke(Object obj, String str, Object[] objArr) throws Exception {
        return invoke(obj.getClass(), obj, str, objArr);
    }

    public static Object invokeStatic(String str, String str2, Object[] objArr) throws Exception {
        Object objInvoke;
        synchronized (mClassMap) {
            try {
                Class<?> cls = mClassMap.get(str);
                if (cls == null) {
                    cls = Class.forName(str);
                    mClassMap.put(str, cls);
                }
                objInvoke = invoke(cls, cls, str2, objArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return objInvoke;
    }

    public static Object reflectConstructor(Class<?> cls, Object[] objArr) throws Exception {
        return (objArr == null || objArr.length <= 0) ? cls.getConstructor(null).newInstance(null) : cls.getConstructor(getParamsTypes(objArr)).newInstance(objArr);
    }

    public static boolean setField(Object obj, Class<?> cls, String str, Object obj2) {
        if (obj == null || cls == null || str == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            synchronized (mFieldMap) {
                try {
                    String str2 = cls.getName() + "_" + str;
                    Field declaredField = mFieldMap.get(str2);
                    if (declaredField == null) {
                        declaredField = cls.getDeclaredField(str);
                        mFieldMap.put(str2, declaredField);
                    }
                    declaredField.setAccessible(true);
                    declaredField.set(obj, obj2);
                } finally {
                }
            }
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
        boolean fieldStepwise;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        synchronized (mClassMap) {
            Class<?> cls = mClassMap.get(str);
            if (cls == null) {
                try {
                    cls = Class.forName(str);
                    mClassMap.put(str, cls);
                } catch (ClassNotFoundException unused) {
                    throw new IllegalArgumentException("className not found");
                }
            }
            fieldStepwise = setFieldStepwise(cls, cls, str2, obj);
        }
        return fieldStepwise;
    }

    private static Object invoke(Class<?> cls, Object obj, String str, Object[] objArr) throws Exception {
        Object objInvoke;
        Object objInvoke2;
        if (objArr == null || objArr.length == 0) {
            String str2 = cls.getName() + "_" + str;
            synchronized (mMethodMap) {
                try {
                    Method method = mMethodMap.get(str2);
                    if (method == null) {
                        method = cls.getMethod(str, null);
                        method.setAccessible(true);
                        mMethodMap.put(str2, method);
                    }
                    objInvoke = method.invoke(obj, null);
                } finally {
                }
            }
            return objInvoke;
        }
        synchronized (mMethodMap) {
            try {
                Class<?>[] paramsTypes = getParamsTypes(objArr);
                String str3 = cls.getName() + '#' + str + getParamsTypesString(paramsTypes) + "#bestmatch";
                Method method2 = mMethodMap.get(str3);
                if (method2 == null) {
                    method2 = cls.getMethod(str, paramsTypes);
                    method2.setAccessible(true);
                    mMethodMap.put(str3, method2);
                }
                objInvoke2 = method2.invoke(obj, objArr);
            } finally {
            }
        }
        return objInvoke2;
    }

    public static Object reflectConstructor(Class<?> cls, Class<?>[] clsArr, Object[] objArr) throws Exception {
        if (objArr != null && objArr.length > 0) {
            return cls.getConstructor(clsArr).newInstance(objArr);
        }
        return cls.getConstructor(null).newInstance(null);
    }

    public static Object invokeStatic(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Object objInvoke;
        synchronized (mClassMap) {
            try {
                Class<?> cls = mClassMap.get(str);
                if (cls == null) {
                    cls = Class.forName(str);
                    mClassMap.put(str, cls);
                }
                objInvoke = invoke(cls, cls, str2, clsArr, objArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return objInvoke;
    }

    public static Object getField(Object obj, String str) throws NoSuchFieldException {
        if (obj != null && str != null) {
            return getFieldStepwise(obj, obj.getClass(), str);
        }
        throw new IllegalArgumentException("parameter can not be null!");
    }

    public static boolean setField(Object obj, String str, Object obj2) {
        if (obj != null && str != null) {
            return setFieldStepwise(obj, obj.getClass(), str, obj2);
        }
        throw new IllegalArgumentException("parameter can not be null!");
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
                    String str2 = cls.getName() + '#' + str + getParamsTypesString(clsArr) + "#bestmatch";
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
        String str3 = cls.getName() + "_" + str;
        synchronized (mMethodMap) {
            try {
                Method method2 = mMethodMap.get(str3);
                if (method2 == null) {
                    method2 = cls.getMethod(str, null);
                    method2.setAccessible(true);
                    mMethodMap.put(str3, method2);
                }
                objInvoke = method2.invoke(obj, null);
            } finally {
            }
        }
        return objInvoke;
    }
}
