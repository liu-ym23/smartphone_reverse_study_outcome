package com.android.server.wm;

import android.content.res.CompatibilityInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public interface CompatScaleProvider {
    public static final int COMPAT_SCALE_MODE_GAME = 1;
    public static final int COMPAT_SCALE_MODE_PRODUCT = 2;
    public static final int COMPAT_SCALE_MODE_SYSTEM_FIRST = 0;
    public static final int COMPAT_SCALE_MODE_SYSTEM_LAST = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatScaleModeOrderId {
    }

    CompatibilityInfo.CompatScale getCompatScale(String r1, int r2);

    static boolean isValidOrderId(int id) {
        if (id >= 0) goto L4;
    L6:
        return false;
    L4:
        if (id > 2) goto L6;
        return true;
    }
}
