package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.content.IntentCompat;

/* JADX INFO: loaded from: classes17.dex */
public class AppLaunchChecker {
    private static final String KEY_STARTED_FROM_LAUNCHER = "startedFromLauncher";
    private static final String SHARED_PREFS_NAME = "android.support.AppLaunchChecker";

    public AppLaunchChecker() {
    }

    public static boolean hasStartedFromLauncher(Context r100) {
        return r100.getSharedPreferences(SHARED_PREFS_NAME, 0).getBoolean(KEY_STARTED_FROM_LAUNCHER, false);
    }

    public static void onActivityCreate(Activity r100) {
        SharedPreferences r101 = r100.getSharedPreferences(SHARED_PREFS_NAME, 0);
        if (r101.getBoolean(KEY_STARTED_FROM_LAUNCHER, false) == false) goto L5;
        return;
    L5:
        Intent r102 = r100.getIntent();
        if (r102 != null) goto L9;
        return;
    L9:
        if ("android.intent.action.MAIN".equals(r102.getAction()) == true) goto L11;
        return;
    L11:
        if (r102.hasCategory("android.intent.category.LAUNCHER") == false) goto L13;
    L14:
        r101.edit().putBoolean(KEY_STARTED_FROM_LAUNCHER, true).apply();
        return;
    L13:
        if (r102.hasCategory(IntentCompat.CATEGORY_LEANBACK_LAUNCHER) == true) goto L14;
    }
}
