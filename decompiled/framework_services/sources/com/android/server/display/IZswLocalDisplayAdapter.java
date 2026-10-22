package com.android.server.display;

import com.zte.feature.Feature;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswLocalDisplayAdapter {
    public static final boolean ZTE_REFRESH_RATE_ENABLED = false;

    static {
        ZTE_REFRESH_RATE_ENABLED = Feature.getBoolean("ZTE_FEATURE_SCREEN_REFRESH_RATE_ENABLED", false);
    }

    static boolean zteRefreshRateCheckCts() {
        if (ZTE_REFRESH_RATE_ENABLED == true) goto L5;
    L7:
        return false;
    L5:
        if (Feature.getCtsRunningStatus() == true) goto L7;
        return true;
    }
}
