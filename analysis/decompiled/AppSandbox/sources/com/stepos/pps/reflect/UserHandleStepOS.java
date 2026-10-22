package com.stepos.pps.reflect;

import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class UserHandleStepOS {
    private static final String TAG = "UserHandleStepOS";
    public static final int USER_ALL = ReflectUtils.getStaticVariableInt("android.os.UserHandle", "USER_ALL");
    public static final int USER_CURRENT = ReflectUtils.getStaticVariableInt("android.os.UserHandle", "USER_CURRENT");
    public static final UserHandle ALL = getStaticVariableUserHandle("ALL");
    public static final UserHandle CURRENT = getStaticVariableUserHandle("CURRENT");
    private static Class<?> mClazz = null;
    private static Method mMethod = null;

    private static UserHandle getStaticVariableUserHandle(String str) throws NoSuchFieldException {
        try {
            Field declaredField = UserHandle.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return (UserHandle) declaredField.get(UserHandle.class);
        } catch (Exception e) {
            Log.e(TAG, "getStaticVariableUserHandle failed : " + e);
            return null;
        }
    }

    public static int myUserId() {
        try {
            if (mClazz == null) {
                mClazz = UserHandle.class;
            }
            if (mMethod == null) {
                Class[] clsArr = new Class[0];
                mMethod = mClazz.getMethod("myUserId", null);
            }
            return ((Integer) mMethod.invoke(mClazz, null)).intValue();
        } catch (Exception e) {
            Log.e(TAG, "myUserId failed : " + e);
            return USER_CURRENT;
        }
    }

    public static int getUserId(int i) {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.UserHandle");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "getUserId", false, Integer.TYPE);
            if (cachedMethod == null) {
                return 0;
            }
            return ((Integer) cachedMethod.invoke(clsForName, Integer.valueOf(i))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "getUserId exception: " + e);
            return 0;
        }
    }
}
