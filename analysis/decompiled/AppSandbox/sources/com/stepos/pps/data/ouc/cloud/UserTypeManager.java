package com.stepos.pps.data.ouc.cloud;

import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.reflect.SystemProperties;

/* loaded from: classes.dex */
public final class UserTypeManager {
    public static final String BETA = "beta";
    public static final String DEV = "dev";
    public static final String MP = "mp";
    public static final String PROP_USER_TYPE = "persist.sys.stepos.user_type";
    private static final String TAG = "UserTypeManager";

    private UserTypeManager() {
    }

    public static String get() {
        try {
            String str = SystemProperties.get(PROP_USER_TYPE, DEV);
            return TextUtils.isEmpty(str) ? DEV : str;
        } catch (Throwable th) {
            Log.w(TAG, "get failed: " + th);
            return DEV;
        }
    }

    public static void set(String str) {
        try {
            String strNormalize = normalize(str);
            String str2 = SystemProperties.get(PROP_USER_TYPE, "");
            if (strNormalize.equals(str2)) {
                return;
            }
            SystemProperties.set(PROP_USER_TYPE, strNormalize);
            Log.i(TAG, "user_type set to " + strNormalize + " (was \"" + str2 + "\")");
        } catch (Throwable th) {
            Log.w(TAG, "set failed: " + th);
        }
    }

    private static String normalize(String str) {
        return ("beta".equals(str) || "mp".equals(str)) ? str : DEV;
    }
}
