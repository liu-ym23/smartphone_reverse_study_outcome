package android.app.asyncinflate;

import android.os.SystemProperties;

/* loaded from: classes.dex */
public class AsyncInflateControl {
    public static final String ASYNC_INFLATE_TAG = "AsyncInflate";
    private static final String DEBUG_PROP = "ro.build.type";
    private static final String IS_ENABLE_PROP = "persist.debug.async.inflate.enable";
    private static final String MAX_ACTIVITY_NUM_PROP = "persist.debug.async.max.activity.num";
    private static final String MAX_RES_NUM_PROP = "persist.debug.async.max.res.num";

    public static boolean isEnable() {
        return SystemProperties.getBoolean(IS_ENABLE_PROP, false);
    }

    public static int getMaxActivityNum() {
        return SystemProperties.getInt(MAX_ACTIVITY_NUM_PROP, 100);
    }

    public static int getMaxResNum() {
        return SystemProperties.getInt(MAX_RES_NUM_PROP, 50);
    }

    public static boolean isDebug() {
        String buildType = SystemProperties.get(DEBUG_PROP, "user");
        return "userdebug".equals(buildType) || "eng".equals(buildType);
    }
}
