package com.stepos.alphame.utils;

import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.reflect.UserHandleStepos;

/* loaded from: classes.dex */
public class PrimaryUtils {
    private static final String PRIVATE_MODE_RUNNING_IN_SETTINGSPROVIDER = "stepos_private_mode_running";
    private static final String PRIVATE_MODE_SWITCH_IN_SETTINGSPROVIDER = "stepos_private_mode";
    private static ContentResolver mResolver = ApplicationImpl.getApplication().getContentResolver();

    public static int getCurrentMode() {
        if (isPrivate()) {
            return 2;
        }
        return !isPrimaryUser() ? 1 : 0;
    }

    public static boolean isPrimaryUser() {
        try {
            int currentUserId = PerfBinderHelper.getCurrentUserId();
            if (currentUserId < 0) {
                return true;
            }
            int i4 = UserHandleStepos.USER_OWNER;
            if (i4 < 0) {
                i4 = 0;
            }
            return currentUserId == i4;
        } catch (Exception unused) {
            Log.d("AlphaMe", "Exception");
            return true;
        }
    }

    private static boolean isPrivate() {
        return isPrivateModeEnable() && isPrivateModeRunning();
    }

    private static boolean isPrivateModeEnable() {
        return Settings.Global.getInt(mResolver, PRIVATE_MODE_SWITCH_IN_SETTINGSPROVIDER, 0) == 1;
    }

    private static boolean isPrivateModeRunning() {
        return Settings.Global.getInt(mResolver, PRIVATE_MODE_RUNNING_IN_SETTINGSPROVIDER, 0) == 1;
    }
}
