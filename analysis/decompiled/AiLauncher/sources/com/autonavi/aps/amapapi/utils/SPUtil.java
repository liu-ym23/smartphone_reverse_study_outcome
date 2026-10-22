package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class SPUtil {
    public static void endEdit(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        editor.apply();
    }

    public static boolean getPrefsBoolean(Context context, String str, String str2, boolean z10) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z10);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SpUtil", "getPrefsBoolean");
            return z10;
        }
    }

    public static int getPrefsInt(Context context, String str, String str2, int i10) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i10);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SpUtil", "getPrefsInt");
            return i10;
        }
    }

    public static long getPrefsLong(Context context, String str, String str2, long j10) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j10);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SpUtil", "getPrefsLong");
            return j10;
        }
    }

    public static String getPrefsStr(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static String getSmac(Context context) {
        return context == null ? Const.STR_DEF_SMAC : getPrefsStr(context, Const.STR_PREF, Const.STR_PREF_KEY_SMAC, Const.STR_DEF_SMAC);
    }

    public static void removeKeyData(SharedPreferences.Editor editor, String str) {
        try {
            editor.remove(str);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void setPrefsBoolean(SharedPreferences.Editor editor, String str, boolean z10) {
        try {
            editor.putBoolean(str, z10);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SpUtil", "updatePrefsBoolean");
        }
    }

    public static void setPrefsInt(SharedPreferences.Editor editor, String str, int i10) {
        try {
            editor.putInt(str, i10);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SpUtil", "setPrefsInt");
        }
    }

    public static void setPrefsLong(SharedPreferences.Editor editor, String str, long j10) {
        try {
            editor.putLong(str, j10);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void setPrefsStr(SharedPreferences.Editor editor, String str, String str2) {
        try {
            editor.putString(str, str2);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SpUtil", "setPrefsStr");
        }
    }

    public static SharedPreferences.Editor startEdit(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }
}
