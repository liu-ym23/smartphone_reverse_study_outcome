package com.stepos.alphame.reflect;

import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.utils.AlphaMeLogger;

/* loaded from: classes.dex */
public class UserInfoProxy {
    public static int getCurrentUser() {
        try {
            return PerfBinderHelper.getCurrentUserId();
        } catch (Exception e4) {
            AlphaMeLogger.eLog("getCurrentUser error: " + e4.getMessage());
            return -1;
        }
    }

    public static boolean isGuest() {
        try {
            return PerfBinderHelper.isGuestUser();
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("isGuest error!!", e4);
            return false;
        }
    }
}
