package android.content.res.stepostheme.iconfilter.utils;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class StringUtils {
    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static int parseInt(String str, int defaultValue) {
        if (isEmpty(str)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static float parseFloat(String str, float defaultValue) {
        if (isEmpty(str)) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(str.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static boolean parseBoolean(String str, boolean defaultValue) {
        if (isEmpty(str)) {
            return defaultValue;
        }
        String trimmed = str.trim().toLowerCase();
        if ("true".equals(trimmed) || "1".equals(trimmed) || "yes".equals(trimmed)) {
            return true;
        }
        if ("false".equals(trimmed) || "0".equals(trimmed) || "no".equals(trimmed)) {
            return false;
        }
        return defaultValue;
    }

    public static String getOrDefault(String str, String defaultValue) {
        return isEmpty(str) ? defaultValue : str;
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equalsIgnoreCase(str2);
    }
}
