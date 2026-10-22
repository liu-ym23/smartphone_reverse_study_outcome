package com.stepos.pps.reflect;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class ReflectCache {
    private static final ConcurrentHashMap<Long, Method> CACHE_METHOD = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, Class<?>> CACHE_CLASS = new ConcurrentHashMap<>();
    private static final CRC32 crc32 = new CRC32();

    public static Reflect on(String str, String str2, Class<?>... clsArr) throws Exception {
        ReflectCacheIA reflectCacheIA = null;
        return new Reflect(reflectCacheIA, getMethod(str, str2, clsArr));
    }

    public static Reflect on(Object obj, String str, Class<?>... clsArr) throws Exception {
        return new Reflect(obj, getMethod(obj.getClass(), str, clsArr));
    }

    private static Method getMethod(String str, String str2, Class<?>... clsArr) throws Exception {
        return getMethod(getClass(str), str2, clsArr);
    }

    private static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws Exception {
        String[] strArr = new String[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            strArr[i] = clsArr[i].getName();
        }
        long methodCacheName = getMethodCacheName(cls.getName(), str, strArr);
        ConcurrentHashMap<Long, Method> concurrentHashMap = CACHE_METHOD;
        Method method = concurrentHashMap.get(Long.valueOf(methodCacheName));
        if (method != null) {
            return method;
        }
        Method methodExactMethod = exactMethod(cls, str, clsArr);
        concurrentHashMap.put(Long.valueOf(methodCacheName), methodExactMethod);
        return methodExactMethod;
    }

    private static Method exactMethod(Class<?> cls, String str, Class<?>[] clsArr) throws Exception {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return cls.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    cls = cls.getSuperclass();
                    if (cls == null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (cls == null);
            throw new NoSuchMethodException();
        }
    }

    private static Class<?> getClass(String str) throws Exception {
        long crc322 = getCrc32(str);
        ConcurrentHashMap<Long, Class<?>> concurrentHashMap = CACHE_CLASS;
        Class<?> cls = concurrentHashMap.get(Long.valueOf(crc322));
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str);
        concurrentHashMap.put(Long.valueOf(crc322), cls2);
        return cls2;
    }

    private static long getMethodCacheName(String str, String str2, String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append("(");
        for (String str3 : strArr) {
            sb.append(str3);
            sb.append(",");
        }
        sb.append(")");
        return getCrc32(sb.toString());
    }

    private static long getCrc32(String str) {
        long value;
        CRC32 crc322 = crc32;
        synchronized (crc322) {
            crc322.reset();
            crc322.update(str.getBytes());
            value = crc322.getValue();
        }
        return value;
    }

    public static void clearCache() {
        CACHE_METHOD.clear();
        CACHE_CLASS.clear();
    }

    public static class Reflect {
        private final Method mMethod;
        private final Object mObject;

        private Reflect(Object obj, Method method) {
            this.mObject = obj;
            this.mMethod = method;
        }

        public <T> T invoke(Object... objArr) throws Exception {
            Method method = this.mMethod;
            if (method == null) {
                return null;
            }
            if (!method.isAccessible()) {
                this.mMethod.setAccessible(true);
            }
            if (this.mMethod.getReturnType() == Void.TYPE) {
                this.mMethod.invoke(this.mObject, objArr);
                return null;
            }
            return (T) this.mMethod.invoke(this.mObject, objArr);
        }

        public boolean hasMethod(String str) throws Exception {
            Method method = this.mMethod;
            return method != null && method.getName().equals(str);
        }
    }
}
