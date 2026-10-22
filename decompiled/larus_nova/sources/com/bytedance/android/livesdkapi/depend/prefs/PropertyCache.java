package com.bytedance.android.livesdkapi.depend.prefs;

import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import jc1.a;
import x60.b;

/* JADX INFO: loaded from: classes12.dex */
public class PropertyCache {
    private static Map<String, Map<String, Object>> cachePropertyMaps;
    private static Gson gson;

    public PropertyCache() {
    }

    static {
        cachePropertyMaps = new HashMap();
        Gson r100 = b.f562576a;
        gson = b.f562576a;
    }

    private static SharedPreferences getSharedPreferences(String r100) {
        return a.b().getSharedPreferences(r100, 0);
    }

    public static <T> T getValue(Property<T> r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getType() != Boolean.class) goto L10;
        return (T) Boolean.valueOf(getBoolean(r100.getSpName(), r100.getName(), ((Boolean) r100.getDefaultValue()).booleanValue()));
    L10:
        if (r100.getType() == Integer.class) goto L33;
        if (r100.getType() == Short.class) goto L33;
        if (r100.getType() != Float.class) goto L19;
        return (T) Float.valueOf(getFloat(r100.getSpName(), r100.getName(), ((Float) r100.getDefaultValue()).floatValue()));
    L19:
        if (r100.getType() != Long.class) goto L23;
        return (T) Long.valueOf(getLong(r100.getSpName(), r100.getName(), ((Long) r100.getDefaultValue()).longValue()));
    L23:
        if (r100.getType() != Double.class) goto L27;
        return (T) Double.valueOf(getDouble(r100.getSpName(), r100.getName(), ((Double) r100.getDefaultValue()).doubleValue()));
    L27:
        if (r100.getType() != String.class) goto L31;
        return (T) getString(r100.getSpName(), r100.getName(), (String) r100.getDefaultValue());
    L31:
        return (T) getObject(r100.getSpName(), r100.getName(), r100.getType(), r100.getDefaultValue());
    L33:
        return (T) Integer.valueOf(getInteger(r100.getSpName(), r100.getName(), ((Integer) r100.getDefaultValue()).intValue()));
    }

    public static boolean getBoolean(String r100, boolean r101) {
        return getBoolean("tt_live_sdk", r100, r101);
    }

    public static void setBoolean(String r100, boolean r101) {
        setBoolean("tt_live_sdk", r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void setValue(Property<T> r100, T r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r102 = r100.getSpName();
        if (r101 != 0) goto L9;
        getSharedPreferences(r102).edit().remove(r100.getName()).apply();
        return;
    L9:
        if (r100.getType() != Boolean.class) goto L13;
        setBoolean(r102, r100.getName(), ((Boolean) r101).booleanValue());
        return;
    L13:
        if (r100.getType() != Integer.class) goto L17;
        setInteger(r102, r100.getName(), ((Integer) r101).intValue());
        return;
    L17:
        if (r100.getType() != Float.class) goto L21;
        setFloat(r102, r100.getName(), ((Float) r101).floatValue());
        return;
    L21:
        if (r100.getType() != Long.class) goto L25;
        setLong(r102, r100.getName(), ((Long) r101).longValue());
        return;
    L25:
        if (r100.getType() != Double.class) goto L29;
        setDouble(r102, r100.getName(), ((Double) r101).doubleValue());
        return;
    L29:
        if (r100.getType() != String.class) goto L32;
        setString(r102, r100.getName(), (String) r101);
        return;
    L32:
        Map<String, Object> r103 = cachePropertyMaps.get(r102);
        if (r103 == null) goto L35;
        r103.put(r100.getName(), r101);
    L35:
        getSharedPreferences(r102).edit().putString(r100.getName(), GsonProtectorUtils.toJson(gson, r101)).apply();
    }

    public static boolean getBoolean(String r100, String r101, boolean r102) {
        return getSharedPreferences(r100).getBoolean(r101, r102);
    }

    public static double getDouble(String r100, String r101, double r102) {
        return CastDoubleProtector.parseDouble(getSharedPreferences(r100).getString(r101, String.valueOf(r102)));
    L4:
        e = move-exception;
        e.printStackTrace();
        return r102;
    }

    public static float getFloat(String r100, String r101, float r102) {
        return getSharedPreferences(r100).getFloat(r101, r102);
    }

    public static int getInteger(String r100, String r101, int r102) {
        return getSharedPreferences(r100).getInt(r101, r102);
    }

    public static long getLong(String r100, String r101, long r102) {
        return getSharedPreferences(r100).getLong(r101, r102);
    }

    public static String getString(String r100, String r101, String r102) {
        return getSharedPreferences(r100).getString(r101, r102);
    }

    public static void setBoolean(String r100, String r101, boolean r102) {
        getSharedPreferences(r100).edit().putBoolean(r101, r102).apply();
    }

    public static void setDouble(String r100, String r101, double r102) {
        getSharedPreferences(r100).edit().putString(r101, String.valueOf(r102)).apply();
    }

    public static void setFloat(String r100, String r101, float r102) {
        getSharedPreferences(r100).edit().putFloat(r101, r102).apply();
    }

    public static void setInteger(String r100, String r101, int r102) {
        getSharedPreferences(r100).edit().putInt(r101, r102).apply();
    }

    public static void setLong(String r100, String r101, long r102) {
        getSharedPreferences(r100).edit().putLong(r101, r102).apply();
    }

    public static void setString(String r100, String r101, String r102) {
        getSharedPreferences(r100).edit().putString(r101, r102).apply();
    }

    public static <T> T getObject(String r100, String r101, Type r102, T r103) {
        Map<String, Object> r104 = cachePropertyMaps.get(r100);
        if (r104 != null) goto L18;
        r104 = new HashMap();
        cachePropertyMaps.put(r100, r104);
    L18:
    L15:
        e = move-exception;
        e.printStackTrace();
        r104.remove(r101);
        return r103;
    L6:
        if (r104.containsKey(r101) == true) goto L8;
        String r105 = getSharedPreferences(r100).getString(r101, "");     // Catch: Exception -> L15
        T r106 = (T) gson.fromJson(r105, r102);
        if (r106 != null) goto L13;
        r104.remove(r101);     // Catch: Exception -> L15
        return r103;
    L13:
        r104.put(r101, r106);     // Catch: Exception -> L15
        return r106;
    L8:
        return (T) r104.get(r101);
    }
}
