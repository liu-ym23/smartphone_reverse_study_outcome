package com.android.server.notification;

import android.app.NotificationChannel;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreferencesHelperSmtEx {
    static final String ATT_PACKAGE_VISIBILITY = "package_visibility";
    public static final List<String> SYSTEM_APP_PACKAGES_LIST = null;
    private PreferencesHelper mPreferencesHelper;

    PreferencesHelperSmtEx(PreferencesHelper preferencesHelper) {
        this.mPreferencesHelper = preferencesHelper;
    }

    static {
        SYSTEM_APP_PACKAGES_LIST = Arrays.asList(new String[]{"com.android.incallui", "com.android.mms", "com.android.email", "com.android.calendar", "com.bytedanceos.thinkboost", "com.android.bluetooth"});
    }

    public void setSmtPackageVisibility(String packageName, int uid, int visibility) {
    }

    public int getSmtPackageVisibility(String packageName, int uid) {
        return 0;
    }

    boolean dealWithSystemApp(String pkg, NotificationChannel existing, NotificationChannel channel) {
        if (SYSTEM_APP_PACKAGES_LIST.contains(pkg) == false) goto L6;
        existing.setImportance(channel.getImportance());
        existing.setSound(channel.getSound(), channel.getAudioAttributes());
        existing.setLightColor(channel.getLightColor());
        existing.enableLights(channel.shouldShowLights());
        return true;
    L6:
        return false;
    }
}
