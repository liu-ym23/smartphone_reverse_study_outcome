package com.android.common;

import android.content.SharedPreferences;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SharedPreferencesCompat {
    private static Method sApplyMethod;

    public SharedPreferencesCompat() {
    }

    static {
        sApplyMethod = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);     // Catch: NoSuchMethodException -> L4
        return;
    L4:
        sApplyMethod = null;
    }

    public static void apply(SharedPreferences.Editor r2) {
        Method r0 = sApplyMethod;
        if (r0 != null) goto L10;
    L7:
        r2.commit();
        return;
    L10:
        r0.invoke(r2, new Object[0]);     // Catch: Throwable -> L9
    }
}
