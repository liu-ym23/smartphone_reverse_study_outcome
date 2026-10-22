package com.stepos.statsapp.v3.utils;

import android.content.Context;
import android.util.Log;
import com.stepos.statsapp.v3.utils.reflect.SystemProperties;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes2.dex */
public class CommonUtils {
    public static final String TAG = "CommonUtils";

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                Log.e(TAG, "closeQuietly error " + e10.getMessage());
            }
        }
    }

    public static boolean isDebugMode(Context context) {
        try {
            String str = SystemProperties.get("persist.stepos.usagestats.debug", "");
            if (str == null) {
                return false;
            }
            if (str.equals("all")) {
                return true;
            }
            return str.equals(context.getPackageName());
        } catch (Exception e10) {
            Log.e(TAG, "isDebugMode error " + e10.getMessage());
            return false;
        }
    }

    public static boolean isPrintLog() {
        try {
            String str = SystemProperties.get("persist.stepos.usagestats.log", "false");
            if (str != null) {
                return str.equals("true");
            }
            return false;
        } catch (Exception e10) {
            Log.e(TAG, "isPrintLog error " + e10.getMessage());
            return false;
        }
    }
}
