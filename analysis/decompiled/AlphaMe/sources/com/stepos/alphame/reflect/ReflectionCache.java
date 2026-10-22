package com.stepos.alphame.reflect;

import B0.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import android.util.LruCache;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ReflectionCache {
    private static final int DEFAULT_REFLECTINON_CACHE_SIZE = 1024;
    public static final String TAG = "ReflectionCache";
    private LruCache<String, ClassInfo> mClassInfoCache;
    public HashMap<String, ClassInfo> mClassInfoMap;
    private Method mRegisterReceiverAsUser;

    public static class SingletonHolder {
        private static final ReflectionCache INSTANCE = new ReflectionCache(0);

        private SingletonHolder() {
        }
    }

    public /* synthetic */ ReflectionCache(int i4) {
        this();
    }

    public static final ReflectionCache build() {
        return SingletonHolder.INSTANCE;
    }

    public static Field getCachedField(Class<?> cls, String str, boolean z4) {
        try {
            build().forName(cls.getName());
            return build().getField(cls, str, z4);
        } catch (ClassNotFoundException e4) {
            Log.w(TAG, "getCachedField " + e4);
            return null;
        } catch (NoSuchFieldException e5) {
            Log.w(TAG, "getCachedField " + e5);
            return null;
        }
    }

    public static Method getCachedMethod(Class<?> cls, String str, boolean z4, Class<?>... clsArr) {
        try {
            build().forName(cls.getName(), Boolean.TRUE);
            return build().getMethod(cls, str, z4, clsArr);
        } catch (ClassNotFoundException e4) {
            Log.w(TAG, "getCachedMethod " + e4);
            return null;
        } catch (NoSuchMethodException e5) {
            Log.w(TAG, "getCachedMethod " + e5);
            return null;
        }
    }

    private ClassInfo getClassInfoFromCache(String str) {
        return this.mClassInfoMap.get(str);
    }

    private Method getMethod(Class<?> cls, String str, boolean z4, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        ClassInfo classInfoFromCache = getClassInfoFromCache(cls.getName());
        String string = str;
        for (Class<?> cls2 : clsArr) {
            StringBuilder sbS = g.s(string);
            sbS.append(cls2.toString());
            string = sbS.toString();
        }
        if (classInfoFromCache == null) {
            if (!z4) {
                return cls.getMethod(str, clsArr);
            }
            Method declaredMethod2 = cls.getDeclaredMethod(str, clsArr);
            declaredMethod2.setAccessible(true);
            return declaredMethod2;
        }
        Method cachedMethod = classInfoFromCache.getCachedMethod(string);
        if (cachedMethod != null) {
            return cachedMethod;
        }
        if (z4) {
            declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
        } else {
            declaredMethod = cls.getMethod(str, clsArr);
        }
        Method method = declaredMethod;
        classInfoFromCache.addCachedMethod(string, method);
        return method;
    }

    public static Object invokeStaticMethodWithReturn(String str, String str2) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void putClassInfoToCache(String str, ClassInfo classInfo) {
        this.mClassInfoMap.put(str, classInfo);
    }

    public Class<?> forName(String str) throws ClassNotFoundException {
        return forName(str, Boolean.TRUE);
    }

    public Field getField(Class<?> cls, String str, boolean z4) throws NoSuchFieldException, SecurityException {
        Field declaredField;
        ClassInfo classInfoFromCache = getClassInfoFromCache(cls.getName());
        if (classInfoFromCache == null) {
            return cls.getField(str);
        }
        Field cachedField = classInfoFromCache.getCachedField(str);
        if (cachedField != null) {
            return cachedField;
        }
        if (z4) {
            declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
        } else {
            declaredField = cls.getField(str);
        }
        Field field = declaredField;
        classInfoFromCache.addCachedField(str, field);
        return field;
    }

    public void registerReceiverAsUser(Context context, BroadcastReceiver broadcastReceiver, android.os.UserHandle userHandle, IntentFilter intentFilter) {
        Log.w(TAG, "registerReceiverAsUser deprecated — use AppPlatform package monitor");
    }

    private ReflectionCache() {
        this.mClassInfoMap = new HashMap<>();
        this.mClassInfoCache = new LruCache<String, ClassInfo>(1024) { // from class: com.stepos.alphame.reflect.ReflectionCache.1
            @Override // android.util.LruCache
            public int sizeOf(String str, ClassInfo classInfo) {
                return 1;
            }
        };
    }

    public Class<?> forName(String str, Boolean bool) throws ClassNotFoundException {
        if (!bool.booleanValue()) {
            return Class.forName(str);
        }
        ClassInfo classInfoFromCache = getClassInfoFromCache(str);
        if (classInfoFromCache != null) {
            return classInfoFromCache.mClass;
        }
        Class<?> cls = Class.forName(str);
        putClassInfoToCache(str, new ClassInfo(cls, str));
        return cls;
    }
}
