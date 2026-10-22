package com.android.server.wm;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.window.DesktopModeFlags;

/* JADX INFO: loaded from: classes3.dex */
class DesktopModeLaunchParamsModifier implements LaunchParamsController.LaunchParamsModifier {
    private static final boolean DEBUG = false;
    private static final String TAG = "ActivityTaskManager";
    private final Context mContext;
    private StringBuilder mLogBuilder;

    public static /* synthetic */ void $r8$lambda$eIFc4C2U2JJa0ZohMsXAO75lM4Y(DesktopModeLaunchParamsModifier r0, String r1) {
        lambda$calculate$0(r0, r1);
    }

    DesktopModeLaunchParamsModifier(Context context) {
        this.mContext = context;
    }

    @Override // com.android.server.wm.LaunchParamsController.LaunchParamsModifier
    public int onCalculate(Task task, ActivityInfo.WindowLayout layout, ActivityRecord activity, ActivityRecord source, ActivityOptions options, ActivityStarter.Request request, int phase, LaunchParamsController.LaunchParams currentParams, LaunchParamsController.LaunchParams outParams) {
        initLogBuilder(task, activity);
        int result = calculate(task, layout, activity, source, options, request, phase, currentParams, outParams);
        outputLog();
        return result;
    }

    private int calculate(Task task, ActivityInfo.WindowLayout layout, ActivityRecord activity, ActivityRecord source, ActivityOptions options, ActivityStarter.Request request, int phase, LaunchParamsController.LaunchParams currentParams, LaunchParamsController.LaunchParams outParams) {
        if (DesktopModeHelper.canEnterDesktopMode(this.mContext) == true) goto L6;
        appendLog("desktop mode is not enabled, skipping", new Object[0]);
        return 0;
    L6:
        if (task != null) goto L8;
    L68:
        appendLog("task null, skipping", new Object[0]);
        return 0;
    L8:
        if (task.isAttached() == false) goto L68;
        if (DesktopModeFlags.DISABLE_DESKTOP_LAUNCH_PARAMS_OUTSIDE_DESKTOP_BUG_FIX.isTrue() == false) goto L17;
        if (isEnteringDesktopMode(task, options, currentParams) == true) goto L17;
        appendLog("not entering desktop mode, skipping", new Object[0]);
        return 0;
    L17:
        if (task.getCreatedByOrganizerTask() == null) goto L21;
        appendLog("has created-by-organizer-task, skipping", new Object[0]);
        return 0;
    L21:
        if (task.isActivityTypeStandardOrUndefined() == true) goto L25;
        appendLog("not standard or undefined activity type, skipping", new Object[0]);
        return 0;
    L25:
        if (phase >= 1) goto L28;
        appendLog("not in windowing mode or bounds phase, skipping", new Object[0]);
        return 0;
    L28:
        outParams.set(currentParams);
        if (source == null) goto L39;
        if (source.getTask() == null) goto L39;
        Task sourceTask = source.getTask();
        if (DesktopModeFlags.DISABLE_DESKTOP_LAUNCH_PARAMS_OUTSIDE_DESKTOP_BUG_FIX.isTrue() == true) goto L35;
    L37:
        outParams.mWindowingMode = sourceTask.getWindowingMode();
        appendLog("inherit-from-source=" + outParams.mWindowingMode, new Object[0]);
        goto L39
    L35:
        if (isEnteringDesktopMode(sourceTask, options, currentParams) == false) goto L37;
        outParams.mWindowingMode = 5;
        appendLog("freeform window mode applied to task trampoline", new Object[0]);
    L39:
        if (phase != 1) goto L42;
        return 2;
    L42:
        if (currentParams.mBounds.isEmpty() == true) goto L45;
        appendLog("currentParams has bounds set, not overriding", new Object[0]);
        return 0;
    L45:
        if (options == null) goto L49;
        if (options.getLaunchBounds() == null) goto L49;
    L56:
        if (DesktopModeFlags.INHERIT_TASK_BOUNDS_FOR_TRAMPOLINE_TASK_LAUNCHES.isTrue() == false) goto L61;
        ActivityRecord topVisibleFreeformActivity = task.getDisplayContent().getTopMostVisibleFreeformActivity();
        if (shouldInheritExistingTaskBounds(topVisibleFreeformActivity, activity, task) == false) goto L61;
        appendLog("inheriting bounds from existing closing instance", new Object[0]);
        outParams.mBounds.set(topVisibleFreeformActivity.getBounds());
        appendLog("final desktop mode task bounds set to %s", new Object[]{outParams.mBounds});
        return 1;
    L61:
        DesktopModeBoundsCalculator.updateInitialBounds(task, layout, activity, options, outParams, new DesktopModeLaunchParamsModifier$$ExternalSyntheticLambda0(this));
        appendLog("final desktop mode task bounds set to %s", new Object[]{outParams.mBounds});
        if (options != null) goto L64;
    L67:
        return 2;
    L64:
        if (options.getFlexibleLaunchSize() == false) goto L67;
        outParams.mWindowingMode = options.getLaunchWindowingMode();
        return 1;
    L49:
        if (task.hasOverrideBounds() == false) goto L56;
        if (DesktopModeFlags.DISABLE_DESKTOP_LAUNCH_PARAMS_OUTSIDE_DESKTOP_BUG_FIX.isTrue() == false) goto L53;
        return 1;
    L53:
        appendLog("current task has bounds set, not overriding", new Object[0]);
        return 0;
    }

    private static /* synthetic */ void lambda$calculate$0(DesktopModeLaunchParamsModifier rec$, String x$0) {
        rec$.appendLog(x$0, new Object[0]);
    }

    boolean isEnteringDesktopMode(Task task, ActivityOptions options, LaunchParamsController.LaunchParams currentParams) {
        if (task.getDisplayContent().getTopMostFreeformActivity() == null) goto L7;
        if (checkSourceWindowModesCompatible(task, options, currentParams) == false) goto L7;
    L8:
        return true;
    L7:
        if (isRequestingFreeformWindowMode(task, options, currentParams) == true) goto L8;
        return false;
    }

    private boolean isRequestingFreeformWindowMode(Task task, ActivityOptions options, LaunchParamsController.LaunchParams currentParams) {
        if (task.inFreeformWindowingMode() == false) goto L5;
    L14:
        return true;
    L5:
        if (options == null) goto L9;
        if (options.getLaunchWindowingMode() == 5) goto L14;
    L9:
        if (currentParams.hasWindowingMode() == true) goto L11;
    L13:
        return false;
    L11:
        if (currentParams.mWindowingMode != 5) goto L13;
        goto L13
    }

    private boolean checkSourceWindowModesCompatible(Task task, ActivityOptions options, LaunchParamsController.LaunchParams currentParams) {
        if (isCompatibleDesktopWindowingMode(task.getWindowingMode()) == false) goto L10;
        if (options == null) goto L8;
        if (isCompatibleDesktopWindowingMode(options.getLaunchWindowingMode()) == false) goto L10;
    L8:
        if (isCompatibleDesktopWindowingMode(currentParams.mWindowingMode) == false) goto L10;
        return true;
    L10:
        return false;
    }

    private boolean isCompatibleDesktopWindowingMode(int windowingMode) {
        switch(windowingMode) {
            case 0: goto L4;
            case 1: goto L4;
            case 5: goto L4;
            default: goto L3;
        };
    L3:
        return false;
    L4:
        return true;
    }

    private boolean shouldInheritExistingTaskBounds(ActivityRecord existingTaskActivity, ActivityRecord launchingActivity, Task launchingTask) {
        if (existingTaskActivity == null) goto L15;
        if (launchingActivity == null) goto L15;
        if (existingTaskActivity.packageName == launchingActivity.packageName) goto L9;
        return false;
    L9:
        if (isLaunchingNewSingleTask(launchingActivity.launchMode) == true) goto L11;
        return false;
    L11:
        if (isClosingExitingInstance(launchingTask.getBaseIntent().getFlags()) == false) goto L18;
        return true;
    L18:
        return false;
    L15:
        return false;
    }

    private boolean isLaunchingNewSingleTask(int launchMode) {
        if (launchMode != 2) goto L5;
    L10:
        return true;
    L5:
        if (launchMode == 3) goto L10;
        if (launchMode == 4) goto L10;
        return false;
    }

    private boolean isClosingExitingInstance(int intentFlags) {
        if ((32768 & intentFlags) == 0) goto L5;
    L8:
        return true;
    L5:
        if ((134217728 & intentFlags) == 0) goto L8;
        return false;
    }

    private void initLogBuilder(Task task, ActivityRecord activity) {
    }

    private void appendLog(String format, Object... args) {
    }

    private void outputLog() {
    }
}
