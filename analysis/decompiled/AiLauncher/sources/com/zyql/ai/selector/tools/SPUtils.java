package com.zyql.ai.selector.tools;

import android.app.ActivityThread;
import android.app.Application;
import android.content.SharedPreferences;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class SPUtils {
    private static final Map<String, SPUtils> SP_UTILS_MAP = new HashMap();
    private SharedPreferences sp;

    private SPUtils(String str) {
        this.sp = getApplicationByReflect().getSharedPreferences(str, 0);
    }

    private static Application getApplicationByReflect() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = ActivityThread.class.getMethod("getApplication", null).invoke(ActivityThread.class.getMethod("currentActivityThread", null).invoke(null, null), null);
            if (objInvoke != null) {
                return (Application) objInvoke;
            }
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }

    public static SPUtils getInstance() {
        return getInstance("", 0);
    }

    public static SPUtils getPictureSpUtils() {
        return getInstance("PictureSpUtils");
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        clear(false);
    }

    public boolean contains(String str) {
        return this.sp.contains(str);
    }

    public Map<String, ?> getAll() {
        return this.sp.getAll();
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public float getFloat(String str) {
        return getFloat(str, -1.0f);
    }

    public int getInt(String str) {
        return getInt(str, -1);
    }

    public long getLong(String str) {
        return getLong(str, -1L);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public Set<String> getStringSet(String str) {
        return getStringSet(str, Collections.EMPTY_SET);
    }

    public void put(String str, String str2) {
        put(str, str2, false);
    }

    public void remove(String str) {
        remove(str, false);
    }

    public static SPUtils getInstance(int i10) {
        return getInstance("", i10);
    }

    public void clear(boolean z10) {
        if (z10) {
            this.sp.edit().clear().commit();
        } else {
            this.sp.edit().clear().apply();
        }
    }

    public boolean getBoolean(String str, boolean z10) {
        return this.sp.getBoolean(str, z10);
    }

    public float getFloat(String str, float f10) {
        return this.sp.getFloat(str, f10);
    }

    public int getInt(String str, int i10) {
        return this.sp.getInt(str, i10);
    }

    public long getLong(String str, long j10) {
        return this.sp.getLong(str, j10);
    }

    public String getString(String str, String str2) {
        return this.sp.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.sp.getStringSet(str, set);
    }

    public void put(String str, String str2, boolean z10) {
        if (z10) {
            this.sp.edit().putString(str, str2).commit();
        } else {
            this.sp.edit().putString(str, str2).apply();
        }
    }

    public void remove(String str, boolean z10) {
        if (z10) {
            this.sp.edit().remove(str).commit();
        } else {
            this.sp.edit().remove(str).apply();
        }
    }

    private SPUtils(String str, int i10) {
        this.sp = getApplicationByReflect().getSharedPreferences(str, i10);
    }

    public static SPUtils getInstance(String str) {
        return getInstance(str, 0);
    }

    public static SPUtils getInstance(String str, int i10) {
        SPUtils sPUtils;
        if (isSpace(str)) {
            str = "spUtils";
        }
        Map<String, SPUtils> map = SP_UTILS_MAP;
        SPUtils sPUtils2 = map.get(str);
        if (sPUtils2 != null) {
            return sPUtils2;
        }
        synchronized (SPUtils.class) {
            try {
                sPUtils = map.get(str);
                if (sPUtils == null) {
                    sPUtils = new SPUtils(str, i10);
                    map.put(str, sPUtils);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sPUtils;
    }

    public void put(String str, int i10) {
        put(str, i10, false);
    }

    public void put(String str, int i10, boolean z10) {
        if (z10) {
            this.sp.edit().putInt(str, i10).commit();
        } else {
            this.sp.edit().putInt(str, i10).apply();
        }
    }

    public void put(String str, long j10) {
        put(str, j10, false);
    }

    public void put(String str, long j10, boolean z10) {
        if (z10) {
            this.sp.edit().putLong(str, j10).commit();
        } else {
            this.sp.edit().putLong(str, j10).apply();
        }
    }

    public void put(String str, float f10) {
        put(str, f10, false);
    }

    public void put(String str, float f10, boolean z10) {
        if (z10) {
            this.sp.edit().putFloat(str, f10).commit();
        } else {
            this.sp.edit().putFloat(str, f10).apply();
        }
    }

    public void put(String str, boolean z10) {
        put(str, z10, false);
    }

    public void put(String str, boolean z10, boolean z11) {
        if (z11) {
            this.sp.edit().putBoolean(str, z10).commit();
        } else {
            this.sp.edit().putBoolean(str, z10).apply();
        }
    }

    public void put(String str, Set<String> set) {
        put(str, set, false);
    }

    public void put(String str, Set<String> set, boolean z10) {
        if (z10) {
            this.sp.edit().putStringSet(str, set).commit();
        } else {
            this.sp.edit().putStringSet(str, set).apply();
        }
    }
}
