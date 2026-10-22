package stepos.window;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ActivityThread;
import android.app.WindowConfiguration;
import android.app.WindowModeHelper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import stepos.app.StepOSActivityOptions;
import stepos.app.StepOSWindowManager;

/* loaded from: classes.dex */
public class StepOSWindowModeExtImpl implements IStepOSWindowModeExt {
    public ActivityOptions injectActivityOptionsFromBundle(Bundle bOptions) {
        if (bOptions == null) {
            return null;
        }
        return new StepOSActivityOptions(bOptions);
    }

    public ActivityOptions selectiveCloneLaunchOptions(ActivityOptions options) {
        if (!(options instanceof StepOSActivityOptions)) {
            return null;
        }
        StepOSActivityOptions origin = (StepOSActivityOptions) options;
        StepOSActivityOptions clone = StepOSActivityOptions.makeBasic();
        clone.setStartWindowMode(origin.getStartWindowMode());
        clone.setStartPinWindowMode(origin.isStartPinWindowMode());
        clone.setStartSpaceMode(origin.isStartSpaceMode());
        clone.setStartFloatMode(origin.isStartFloatMode());
        clone.setVirtualWindowMode(origin.getVirtualWindowMode());
        return clone;
    }

    public boolean injectOrientationEventListenerOnSensorChanged() {
        int displayId;
        if (ActivityThread.isSystem()) {
            return false;
        }
        ActivityThread thread = ActivityThread.currentActivityThread();
        int windowingMode = WindowModeHelper.getWindowingMode(thread, null);
        if (WindowConfiguration.isStepOSWindowMode(windowingMode)) {
            return true;
        }
        Activity topActivity = WindowModeHelper.getTopActivity(thread);
        if (topActivity == null || (displayId = topActivity.getDisplayId()) == 0) {
            return false;
        }
        StepOSWindowManager wm = StepOSWindowManager.getInstance();
        return wm.isFeatureOpen(displayId, 26) || wm.isFeatureOpen(displayId, 23);
    }

    public int injectConfigurationDiff(int changed, Configuration self, Configuration delta, boolean compareUndefined, boolean publicOnly) {
        int selfWindowingMode;
        int deltaWindowingMode;
        if (!publicOnly || !ActivityThread.isSystem() || (selfWindowingMode = self.windowConfiguration.getWindowingMode()) == (deltaWindowingMode = delta.windowConfiguration.getWindowingMode())) {
            return changed;
        }
        if (WindowConfiguration.isStepOSWindowMode(selfWindowingMode) || WindowConfiguration.isStepOSWindowMode(deltaWindowingMode)) {
            return changed | 536870912;
        }
        return changed;
    }

    public Bundle computeStartOptions(Bundle options, ActivityThread activityThread, Activity target, Intent... intents) {
        if (options != null && options.get("start_pinwindowmode") != null) {
            return options;
        }
        ActivityThread thread = activityThread != null ? activityThread : ActivityThread.currentActivityThread();
        Activity activity = target != null ? target : WindowModeHelper.getTopActivity(thread);
        if (activity == null) {
            return options;
        }
        StepOSWindowManager wm = StepOSWindowManager.getInstance();
        int virtualWindowMode = wm.getVirtualWindowingMode(activity.getActivityToken());
        int windowingMode = StepOSWindowManager.getWindowingMode(virtualWindowMode);
        if (options != null && options.get("start_windowmode") != null) {
            if (windowingMode == 11) {
                options.putInt("virtual_mode", virtualWindowMode);
            }
            return options;
        }
        if (!Configuration.isStepOSWindowMode(windowingMode)) {
            return options;
        }
        if (!activity.isVisibleForAutofill() && !wm.isWindowMode(windowingMode, activity.getActivityToken())) {
            return options;
        }
        if (ActivityThread.DEBUG_CONFIGURATION) {
            Log.i("StepOSWindowModeExt", "Options set window mode.");
        }
        if (options == null) {
            options = new Bundle();
        }
        if (windowingMode == 11) {
            options.putBoolean("start_windowmode", true);
            options.putInt("virtual_mode", virtualWindowMode);
        } else if (windowingMode == 12) {
            options.putBoolean("start_pinwindowmode", true);
        }
        return options;
    }
}
