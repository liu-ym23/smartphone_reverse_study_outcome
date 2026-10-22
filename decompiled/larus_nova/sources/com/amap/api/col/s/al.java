package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes28.dex */
public final class al {
    public static void a(Context r100, String r101, String r102, Object r103) {
        String r104 = r103.getClass().getSimpleName();
        SharedPreferences.Editor r105 = r100.getSharedPreferences(r101, 0).edit();
        if ("String".equals(r104) == false) goto L6;
        r105.putString(r102, (String) r103);
    L17:
        r105.commit();
        return;
    L6:
        if ("Integer".equals(r104) == false) goto L9;
        r105.putInt(r102, ((Integer) r103).intValue());
        goto L17
    L9:
        if ("Boolean".equals(r104) == false) goto L12;
        r105.putBoolean(r102, ((Boolean) r103).booleanValue());
        goto L17
    L12:
        if ("Float".equals(r104) == false) goto L15;
        r105.putFloat(r102, ((Float) r103).floatValue());
        goto L17
    L15:
        if ("Long".equals(r104) == false) goto L17;
        r105.putLong(r102, ((Long) r103).longValue());
        goto L17
    }

    public static Object b(Context r100, String r101, String r102, Object r103) {
        String r104 = r103.getClass().getSimpleName();
        SharedPreferences r105 = r100.getSharedPreferences(r101, 0);
        if ("String".equals(r104) == false) goto L7;
        return r105.getString(r102, (String) r103);
    L7:
        if ("Integer".equals(r104) == false) goto L11;
        return Integer.valueOf(r105.getInt(r102, ((Integer) r103).intValue()));
    L11:
        if ("Boolean".equals(r104) == false) goto L15;
        return Boolean.valueOf(r105.getBoolean(r102, ((Boolean) r103).booleanValue()));
    L15:
        if ("Float".equals(r104) == false) goto L19;
        return Float.valueOf(r105.getFloat(r102, ((Float) r103).floatValue()));
    L19:
        if ("Long".equals(r104) == true) goto L21;
        return null;
    L21:
        return Long.valueOf(r105.getLong(r102, ((Long) r103).longValue()));
    }
}
