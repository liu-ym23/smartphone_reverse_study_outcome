package com.stepos.dylog;

import android.util.ArrayMap;
import android.util.Log;
import android.util.StepOSDateTimeUrlHelper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/* loaded from: classes.dex */
public class ReflectDynamicalLogHelper {
    private static final ArrayMap<String, WeakReference<Field>> CACHES = new ArrayMap<>();
    private static final boolean DEBUG = false;
    private static final String TAG = "ReflectDynamicalLog";

    private static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        String key = clazz.getSimpleName() + StepOSDateTimeUrlHelper.TIME_TO_TIME_STRING + fieldName;
        WeakReference<Field> weakReference = CACHES.get(key);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            CACHES.put(key, new WeakReference<>(field));
            return field;
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "NoSuchFieldException: " + clazz.getName() + "." + fieldName);
            return null;
        }
    }

    private static void setDynamicalLog(Class<?> clazz, String fieldName, boolean value) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (clazz == null || fieldName == null) {
            return;
        }
        Log.d(TAG, "setDynamicalLog class: " + clazz.getName() + " , Field: " + fieldName + " value " + value);
        Field field = getField(clazz, fieldName);
        if (field == null) {
            return;
        }
        if (!Modifier.isStatic(field.getModifiers())) {
            Log.e(TAG, "Field " + fieldName + " is not static");
            return;
        }
        try {
            field.setBoolean(null, value);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "IllegalAccessException: " + e.getMessage());
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, "IllegalArgumentException: " + fieldName + " is not a boolean field");
        }
    }

    public static void setDynamicalConfig(Class<?> clazz, List<String> fields, boolean value) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (clazz == null || fields == null) {
            return;
        }
        for (String field : fields) {
            setDynamicalLog(clazz, field, value);
        }
    }

    public static void setStringField(Class<?> clazz, String fieldName, String value) throws IllegalAccessException, IllegalArgumentException {
        Field field;
        if (clazz == null || fieldName == null || (field = getField(clazz, fieldName)) == null) {
            return;
        }
        if (!Modifier.isStatic(field.getModifiers())) {
            Log.e(TAG, "Field " + fieldName + " is not static");
            return;
        }
        try {
            field.set(null, value);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "IllegalAccessException: " + e.getMessage());
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, "IllegalArgumentException: " + fieldName + " is not assignable from String");
        }
    }
}
