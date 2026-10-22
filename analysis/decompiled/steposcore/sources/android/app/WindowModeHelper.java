package android.app;

import android.app.ActivityThread;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.Process;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.Window;
import stepos.app.StepOSWindowManager;

/* loaded from: classes.dex */
public class WindowModeHelper {
    public static final boolean isNotAppProcess;
    public static final boolean isSystemServer = ActivityThread.isSystem();
    public static final boolean isSystemUIProcess;
    public static final boolean willInjectDisplay;

    static {
        boolean systemProcess = false;
        boolean systemUiProcess = false;
        int uid = Process.myUid();
        if (uid < 10000) {
            systemProcess = true;
        } else {
            try {
                PackageManager pms = ActivityThread.currentApplication().getPackageManager();
                systemUiProcess = uid == pms.getPackageUid("com.android.systemui", 0);
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        isNotAppProcess = systemProcess;
        isSystemUIProcess = systemUiProcess;
        willInjectDisplay = (isSystemServer || isNotAppProcess || isSystemUIProcess) ? false : true;
    }

    public static boolean injectAction(boolean checkDisplay, boolean checkWindowMode, int feature) {
        Activity activity;
        if (!willInjectDisplay) {
            return false;
        }
        ActivityThread activityThread = ActivityThread.currentActivityThread();
        if (activityThread.getApplication().getApplicationInfo().uid != 1000 && (activity = getTopActivity(activityThread)) != null) {
            int displayId = activity.getDisplayId();
            if (displayId != 0 && checkDisplay) {
                return StepOSWindowManager.getInstance().isFeatureOpen(displayId, feature);
            }
            if (checkWindowMode) {
                int windowingMode = getWindowingMode(activityThread, activity);
                if (Configuration.isStepOSWindowMode(windowingMode) || 13 == windowingMode) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getInjectDisplayId(int feature) {
        int displayId;
        if (ActivityThread.isSystem()) {
            return -1;
        }
        ActivityThread activityThread = ActivityThread.currentActivityThread();
        Activity activity = getTopActivity(activityThread);
        if (activity == null || (displayId = activity.getDisplayId()) == 0 || !StepOSWindowManager.getInstance().isFeatureOpen(displayId, feature)) {
            return -1;
        }
        return displayId;
    }

    public static boolean needInjectDisplayInfo(Resources resources, boolean checkPermissions) {
        Application application;
        if (resources == null || !willInjectDisplay) {
            return false;
        }
        if (resources.getConfiguration().isStepOSMagicWindow()) {
            return true;
        }
        if (!resources.getConfiguration().isStepOSWindowMode()) {
            return false;
        }
        if (!checkPermissions || (application = ActivityThread.currentApplication()) == null) {
            return true;
        }
        AppOpsManager appOps = (AppOpsManager) application.getSystemService(AppOpsManager.class);
        int mode = appOps.unsafeCheckOpNoThrow("android:system_alert_window", Process.myUid(), application.getPackageName());
        ApplicationInfo applicationInfo = application.getApplicationInfo();
        return (applicationInfo == null || !applicationInfo.isSystemApp()) ? mode != 0 : mode == 1 || mode == 2;
    }

    public static int getWindowingMode(ActivityThread activityThread, Activity target) {
        Window window;
        View view;
        ViewRootImpl viewRoot;
        int windowingMode = 0;
        if (activityThread == null && target != null) {
            activityThread = target.mMainThread;
        }
        if (activityThread.mSystemThread) {
            if (target == null || target.mCurrentConfig == null) {
                return 0;
            }
            int windowingMode2 = target.mCurrentConfig.windowConfiguration.getWindowingMode();
            return windowingMode2;
        }
        if (target == null) {
            target = getTopActivity(activityThread);
        }
        if (target == null) {
            return 0;
        }
        if (target.mCurrentConfig != null) {
            windowingMode = target.mCurrentConfig.windowConfiguration.getWindowingMode();
        }
        if (windowingMode == 0 && (window = target.getWindow()) != null && (view = window.peekDecorView()) != null && (viewRoot = view.getViewRootImpl()) != null) {
            int windowingMode3 = viewRoot.getStepOSViewRootImplExt().getLastWindowMode();
            return windowingMode3;
        }
        return windowingMode;
    }

    public static Activity getTopActivity(ActivityThread activityThread) {
        ArrayMap<IBinder, ActivityThread.ActivityClientRecord> activities = activityThread.mActivities;
        Activity fallback = null;
        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.valueAt(i).activity;
            if (activity != null) {
                if (activity.isResumed()) {
                    return activity;
                }
                if (fallback == null || (!fallback.isVisibleForAutofill() && activity.isVisibleForAutofill())) {
                    fallback = activity;
                }
            }
        }
        return fallback;
    }

    public static Configuration getCurrentConfig(Activity activity) {
        return activity.mCurrentConfig;
    }
}
