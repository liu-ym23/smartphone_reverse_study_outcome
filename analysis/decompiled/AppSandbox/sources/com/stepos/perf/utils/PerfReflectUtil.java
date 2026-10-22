package com.stepos.perf.utils;

import android.os.IBinder;
import com.stepos.pps.reflect.ReflectUtils;
import com.stepos.pps.reflect.ReflectionCache;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public class PerfReflectUtil {
    private static ConcurrentHashMap<String, Class> classCache = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Method> methodCache = new ConcurrentHashMap<>();

    public static Class<?> getReflectClass(String str) throws ClassNotFoundException {
        ConcurrentHashMap<String, Class> concurrentHashMap = classCache;
        if (concurrentHashMap == null) {
            return null;
        }
        Class<?> cls = concurrentHashMap.get(str);
        if (cls == null) {
            try {
                cls = Class.forName(str);
                classCache.put(str, cls);
                return cls;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cls;
    }

    public static Method getReflectMethod(String str, String str2, Class<?>... clsArr) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Class<?> reflectClass = getReflectClass(str);
        Method method = null;
        if (reflectClass == null) {
            return null;
        }
        String str3 = reflectClass.getName() + Typography.amp + str2 + Arrays.toString(types(clsArr));
        ConcurrentHashMap<String, Method> concurrentHashMap = methodCache;
        if (concurrentHashMap != null && (method = concurrentHashMap.get(str3)) == null) {
            try {
                method = reflectClass.getMethod(str2, clsArr);
                methodCache.put(str3, method);
                return method;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return method;
    }

    public static Method getReflectMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method method = null;
        if (cls == null) {
            return null;
        }
        String str2 = cls.getName() + Typography.amp + str + Arrays.toString(types(clsArr));
        ConcurrentHashMap<String, Method> concurrentHashMap = methodCache;
        if (concurrentHashMap != null && (method = concurrentHashMap.get(str2)) == null) {
            try {
                method = cls.getMethod(str, clsArr);
                methodCache.put(str2, method);
                return method;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return method;
    }

    public static Object invokeStaticMethod(Method method, Object[] objArr) {
        try {
            return method.invoke(null, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invokeMethod(Object obj, Method method, Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Class<?>[] types(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof Class) {
                clsArr[i] = (Class) obj;
            } else {
                clsArr[i] = obj.getClass();
            }
        }
        return clsArr;
    }

    public static void clearAllCache() {
        ConcurrentHashMap<String, Class> concurrentHashMap = classCache;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, Method> concurrentHashMap2 = methodCache;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
    }

    public static Object getIWindowManagerExt() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("stepos.view.IWindowManagerExt$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            if (cachedMethod != null) {
                return cachedMethod.invoke(clsForName, ReflectUtils.getIBinder("window_ext"));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static Object getIActivityManagerExt() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("stepos.app.IActivityManagerExt$Stub");
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = ReflectUtils.getIBinder("activity_ext");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
