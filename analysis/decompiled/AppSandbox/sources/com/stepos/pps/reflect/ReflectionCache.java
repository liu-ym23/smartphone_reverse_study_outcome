package com.stepos.pps.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ReflectionCache {
    private static final int DEFAULT_REFLECTINON_CACHE_SIZE = 1024;
    public static final String TAG = "ReflectionCache";
    public static HashMap<String, ClassInfo> classInfoMap;
    private Map<Object, ClassInfo> mClassInfoCache;

    private ReflectionCache() {
        classInfoMap = new HashMap<>();
        this.mClassInfoCache = new HashMap();
    }

    private static class SingletonHolder {
        private static final ReflectionCache INSTANCE = new ReflectionCache();

        private SingletonHolder() {
        }
    }

    public static final ReflectionCache build() {
        return SingletonHolder.INSTANCE;
    }

    private void putClassInfoToCache(String str, ClassInfo classInfo) {
        classInfoMap.put(str, classInfo);
    }

    private ClassInfo getClassInfoFromCache(String str) {
        return classInfoMap.get(str);
    }

    public Class<?> forName(String str) throws ClassNotFoundException {
        return forName(str, true);
    }

    public Class<?> forName(String str, Boolean bool) throws ClassNotFoundException {
        if (bool.booleanValue()) {
            ClassInfo classInfoFromCache = getClassInfoFromCache(str);
            if (classInfoFromCache != null) {
                return classInfoFromCache.mClass;
            }
            Class<?> cls = Class.forName(str);
            putClassInfoToCache(str, new ClassInfo(cls, str));
            return cls;
        }
        return Class.forName(str);
    }

    public Method getMethod(Class<?> cls, String str, boolean z, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        ClassInfo classInfoFromCache = getClassInfoFromCache(cls.getName());
        String str2 = str;
        for (Class<?> cls2 : clsArr) {
            str2 = str2 + cls2.toString();
        }
        if (classInfoFromCache == null) {
            if (!z) {
                return cls.getMethod(str, clsArr);
            }
            Method declaredMethod2 = cls.getDeclaredMethod(str, clsArr);
            declaredMethod2.setAccessible(true);
            return declaredMethod2;
        }
        Method cachedMethod = classInfoFromCache.getCachedMethod(str2);
        if (cachedMethod != null) {
            return cachedMethod;
        }
        if (!z) {
            declaredMethod = cls.getMethod(str, clsArr);
        } else {
            declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
        }
        classInfoFromCache.addCachedMethod(str2, declaredMethod);
        return declaredMethod;
    }

    public Field getField(Class<?> cls, String str, boolean z) throws NoSuchFieldException {
        Field declaredField;
        ClassInfo classInfoFromCache = getClassInfoFromCache(cls.getName());
        if (classInfoFromCache == null) {
            if (!z) {
                return cls.getField(str);
            }
            Field declaredField2 = cls.getDeclaredField(str);
            declaredField2.setAccessible(true);
            return declaredField2;
        }
        Field cachedField = classInfoFromCache.getCachedField(str);
        if (cachedField != null) {
            return cachedField;
        }
        if (!z) {
            declaredField = cls.getField(str);
        } else {
            declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
        }
        classInfoFromCache.addCachedField(str, declaredField);
        return declaredField;
    }

    public static Method getCachedMethod(Class<?> cls, String str, boolean z, Class<?>... clsArr) {
        try {
            build().forName(cls.getName(), true);
            return build().getMethod(cls, str, z, clsArr);
        } catch (ClassNotFoundException e) {
            Log.w(TAG, "getCachedMethod " + e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.w(TAG, "getCachedMethod " + e2);
            return null;
        }
    }

    public static Field getCachedField(Class<?> cls, String str, boolean z) {
        try {
            build().forName(cls.getName());
            return build().getField(cls, str, z);
        } catch (ClassNotFoundException e) {
            Log.w(TAG, "getCachedField " + e);
            return null;
        } catch (NoSuchFieldException e2) {
            Log.w(TAG, "getCachedField " + e2);
            return null;
        }
    }
}
