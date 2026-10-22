package com.stepos.alphame.utils;

import androidx.room.AbstractC0351g;
import com.stepos.alphame.perfbinder.PerfBinderHelper;

/* loaded from: classes.dex */
public class SystemProperty {
    private static final String TAG = "AlphaMe";

    public static String get(String str, String str2) {
        try {
            return PerfBinderHelper.getSystemProperties(str, str2);
        } catch (Exception e4) {
            AbstractC0351g.B("SystemProperty get ", e4, TAG);
            return str2;
        }
    }

    public static boolean getBoolean(String str, boolean z4) {
        try {
            return PerfBinderHelper.getSystemPropertiesBoolean(str, z4);
        } catch (Exception e4) {
            AbstractC0351g.B("SystemProperty getBoolean ", e4, TAG);
            return z4;
        }
    }

    public static int getInt(String str, int i4) {
        try {
            return PerfBinderHelper.getSystemPropertiesInt(str, i4);
        } catch (Exception e4) {
            AbstractC0351g.B("SystemProperty getInt ", e4, TAG);
            return i4;
        }
    }

    public static String get(String str) {
        return get(str, null);
    }
}
