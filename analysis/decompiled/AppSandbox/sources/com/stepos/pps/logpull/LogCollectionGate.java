package com.stepos.pps.logpull;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.data.ouc.cloud.CloudUserConfigManager;
import com.stepos.pps.data.ouc.cloud.UserTypeManager;
import com.stepos.pps.data.util.Utils;
import com.stepos.pps.reflect.SystemProperties;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class LogCollectionGate {
    public static final String PROP_LOGD_ENABLE = "persist.sys.logreport.logd.enable";
    public static final String REASON_GATE_CLOSED = "稳定性体验计划已关闭";
    private static final String TAG = "LogCollectionGate";
    private static Controller sController;
    private static Boolean sLastAllowed;

    public interface Controller {
        void onLogPullDisabled(String str);

        void onLogPullEnabled();
    }

    private LogCollectionGate() {
    }

    public static void init(Controller controller) {
        sController = controller;
    }

    public static void sync(Context context, boolean z) {
        Context applicationContext = context.getApplicationContext();
        syncLogdEnable(applicationContext);
        boolean zIsLogPullAllowed = isLogPullAllowed(applicationContext);
        if (!z || sController == null) {
            sLastAllowed = Boolean.valueOf(zIsLogPullAllowed);
            return;
        }
        Boolean bool = sLastAllowed;
        sLastAllowed = Boolean.valueOf(zIsLogPullAllowed);
        if (bool == null || bool.booleanValue() == zIsLogPullAllowed) {
            return;
        }
        if (zIsLogPullAllowed) {
            sController.onLogPullEnabled();
        } else {
            sController.onLogPullDisabled(REASON_GATE_CLOSED);
        }
    }

    public static void sync(Context context) {
        sync(context, true);
    }

    public static boolean isLogPullAllowed(Context context) {
        return computeDesiredLogdEnable(context);
    }

    private static boolean computeDesiredLogdEnable(Context context) {
        return Utils.canLogCollect(context) && !isMpCeiling();
    }

    static boolean isMpCeiling() {
        if ("mp".equals(UserTypeManager.get())) {
            return true;
        }
        if (TextUtils.isEmpty(SystemProperties.get(UserTypeManager.PROP_USER_TYPE, ""))) {
            return "mp".equalsIgnoreCase(Utils.getPublishedType());
        }
        return "mp".equals(CloudUserConfigManager.currentVersionType());
    }

    private static void syncLogdEnable(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str = computeDesiredLogdEnable(context) ? "true" : "false";
        String str2 = SystemProperties.get(PROP_LOGD_ENABLE, "");
        if (str.equals(str2)) {
            return;
        }
        SystemProperties.set(PROP_LOGD_ENABLE, str);
        Log.i(TAG, "logd.enable " + str2 + " -> " + str + " canLogCollect=" + Utils.canLogCollect(context) + " mpCeiling=" + isMpCeiling());
    }
}
