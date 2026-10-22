package com.android.server.pm;

import android.os.Build;
import android.os.SystemProperties;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class SharedUidMigration {
    public static final int BEST_EFFORT = 2;
    private static final int DEFAULT = 1;
    public static final int LIVE_TRANSITION = 4;
    public static final int NEW_INSTALL_ONLY = 1;
    public static final String PROPERTY_KEY = "persist.debug.pm.shared_uid_migration_strategy";
    public static final int TRANSITION_AT_BOOT = 3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    public static boolean isDisabled() {
        return false;
    }

    public static int getCurrentStrategy() {
        if (Build.IS_USERDEBUG == true) goto L5;
        return 1;
    L5:
        int s = SystemProperties.getInt(PROPERTY_KEY, 1);
        if (s > 2) goto L10;
        if (s < 1) goto L10;
        return s;
    L10:
        return 1;
    }

    public static boolean applyStrategy(int strategy) {
        if (isDisabled() == false) goto L5;
    L7:
        return false;
    L5:
        if (getCurrentStrategy() < strategy) goto L7;
        return true;
    }

    private SharedUidMigration() {
    }
}
