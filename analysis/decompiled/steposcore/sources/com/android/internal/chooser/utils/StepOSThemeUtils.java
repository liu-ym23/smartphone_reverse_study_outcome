package com.android.internal.chooser.utils;

import android.os.SystemProperties;
import android.util.Log;

/* loaded from: classes.dex */
public class StepOSThemeUtils {
    public static boolean isPoleStarTheme() {
        try {
            boolean isPoleStarTheme = SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
            return isPoleStarTheme;
        } catch (IllegalArgumentException e) {
            Log.e("StepOSAlertController", "get ro.stepos.build.channel error");
            return false;
        }
    }
}
