package com.android.server.wm;

import android.util.EventLog;

/* JADX INFO: loaded from: classes3.dex */
public class EventLogTags {
    public static final int IMF_REMOVE_IME_SCREENSHOT = 32005;
    public static final int IMF_SHOW_IME_SCREENSHOT = 32004;
    public static final int IMF_UPDATE_IME_PARENT = 32003;
    public static final int WM_ACTIVITY_LAUNCH_TIME = 30009;
    public static final int WM_ADD_TO_STOPPING = 30066;
    public static final int WM_BACK_NAVI_CANCELED = 31100;
    public static final int WM_BOOT_ANIMATION_DONE = 31007;
    public static final int WM_CREATE_ACTIVITY = 30005;
    public static final int WM_CREATE_TASK = 30004;
    public static final int WM_DESTROY_ACTIVITY = 30018;
    public static final int WM_DIM_ANIMATE = 38202;
    public static final int WM_DIM_CANCEL_ANIM = 38203;
    public static final int WM_DIM_CREATED = 38200;
    public static final int WM_DIM_EXIT = 38201;
    public static final int WM_DIM_FINISH_ANIM = 38204;
    public static final int WM_DIM_REMOVED = 38205;
    public static final int WM_ENTER_PIP = 38000;
    public static final int WM_FAILED_TO_PAUSE = 30012;
    public static final int WM_FINISH_ACTIVITY = 30001;
    public static final int WM_FOCUSED_ROOT_TASK = 30044;
    public static final int WM_NEW_INTENT = 30003;
    public static final int WM_NO_SURFACE_MEMORY = 31000;
    public static final int WM_PAUSE_ACTIVITY = 30013;
    public static final int WM_RELAUNCH_ACTIVITY = 30020;
    public static final int WM_RELAUNCH_RESUME_ACTIVITY = 30019;
    public static final int WM_RESTART_ACTIVITY = 30006;
    public static final int WM_RESUME_ACTIVITY = 30007;
    public static final int WM_SET_KEYGUARD_OCCLUDED = 31008;
    public static final int WM_SET_KEYGUARD_SHOWN = 30067;
    public static final int WM_SET_REQUESTED_ORIENTATION = 31006;
    public static final int WM_SET_RESUMED_ACTIVITY = 30043;
    public static final int WM_STOP_ACTIVITY = 30048;
    public static final int WM_TASK_CREATED = 31001;
    public static final int WM_TASK_MOVED = 31002;
    public static final int WM_TASK_REMOVED = 31003;
    public static final int WM_TASK_TO_FRONT = 30002;
    public static final int WM_TF_CREATED = 31004;
    public static final int WM_TF_REMOVED = 31005;
    public static final int WM_WALLPAPER_SURFACE = 33001;

    private EventLogTags() {
    }

    public static void writeWmFinishActivity(int user, int token, int taskId, String componentName, String reason) {
        EventLog.writeEvent(WM_FINISH_ACTIVITY, new Object[]{Integer.valueOf(user), Integer.valueOf(token), Integer.valueOf(taskId), componentName, reason});
    }

    public static void writeWmTaskToFront(int user, int task, int displayId) {
        EventLog.writeEvent(WM_TASK_TO_FRONT, new Object[]{Integer.valueOf(user), Integer.valueOf(task), Integer.valueOf(displayId)});
    }

    public static void writeWmNewIntent(int user, int token, int taskId, String componentName, String action, String mimeType, String uri, int flags) {
        EventLog.writeEvent(WM_NEW_INTENT, new Object[]{Integer.valueOf(user), Integer.valueOf(token), Integer.valueOf(taskId), componentName, action, mimeType, uri, Integer.valueOf(flags)});
    }

    public static void writeWmCreateTask(int user, int taskId, int rootTaskId, int displayId) {
        EventLog.writeEvent(WM_CREATE_TASK, new Object[]{Integer.valueOf(user), Integer.valueOf(taskId), Integer.valueOf(rootTaskId), Integer.valueOf(displayId)});
    }

    public static void writeWmCreateActivity(int user, int token, int taskId, String componentName, String action, String mimeType, String uri, int flags) {
        EventLog.writeEvent(WM_CREATE_ACTIVITY, new Object[]{Integer.valueOf(user), Integer.valueOf(token), Integer.valueOf(taskId), componentName, action, mimeType, uri, Integer.valueOf(flags)});
    }

    public static void writeWmRestartActivity(int user, int token, int taskId, String componentName) {
        EventLog.writeEvent(WM_RESTART_ACTIVITY, new Object[]{Integer.valueOf(user), Integer.valueOf(token), Integer.valueOf(taskId), componentName});
    }

    public static void writeWmResumeActivity(int user, int token, int taskId, String componentName) {
        EventLog.writeEvent(WM_RESUME_ACTIVITY, new Object[]{Integer.valueOf(user), Integer.valueOf(token), Integer.valueOf(taskId), componentName});
    }

    public static void writeWmActivityLaunchTime(int user, int token, String componentName, long time) {
        EventLog.writeEvent(WM_ACTIVITY_LAUNCH_TIME, new Object[]{Integer.valueOf(user), Integer.valueOf(token), componentName, Long.valueOf(time)});
    }

    public static void writeWmFailedToPause(int user, int token, String wantingToPause, String currentlyPausing) {
        EventLog.writeEvent(WM_FAILED_TO_PAUSE, new Object[]{Integer.valueOf(user), Integer.valueOf(token), wantingToPause, currentlyPausing});
    }

    public static void writeWmPauseActivity(int user, int token, String componentName, String userLeaving, String reason) {
        EventLog.writeEvent(WM_PAUSE_ACTIVITY, new Object[]{Integer.valueOf(user), Integer.valueOf(token), componentName, userLeaving, reason});
    }

    public static void writeWmDestroyActivity(int user, int token, int taskId, String componentName, String reason) {
        EventLog.writeEvent(WM_DESTROY_ACTIVITY, new Object[]{Integer.valueOf(user), Integer.valueOf(token), Integer.valueOf(taskId), componentName, reason});
    }

    public static void writeWmRelaunchResumeActivity(int user, int token, int taskId, String componentName, String configMask) {
        EventLog.writeEvent(WM_RELAUNCH_RESUME_ACTIVITY, new Object[]{Integer.valueOf(user), Integer.valueOf(token), Integer.valueOf(taskId), componentName, configMask});
    }

    public static void writeWmRelaunchActivity(int user, int token, int taskId, String componentName, String configMask) {
        EventLog.writeEvent(WM_RELAUNCH_ACTIVITY, new Object[]{Integer.valueOf(user), Integer.valueOf(token), Integer.valueOf(taskId), componentName, configMask});
    }

    public static void writeWmSetResumedActivity(int user, String componentName, String reason) {
        EventLog.writeEvent(WM_SET_RESUMED_ACTIVITY, new Object[]{Integer.valueOf(user), componentName, reason});
    }

    public static void writeWmFocusedRootTask(int user, int displayId, int focusedRootTaskId, int lastFocusedRootTaskId, String reason) {
        EventLog.writeEvent(WM_FOCUSED_ROOT_TASK, new Object[]{Integer.valueOf(user), Integer.valueOf(displayId), Integer.valueOf(focusedRootTaskId), Integer.valueOf(lastFocusedRootTaskId), reason});
    }

    public static void writeWmStopActivity(int user, int token, String componentName) {
        EventLog.writeEvent(WM_STOP_ACTIVITY, new Object[]{Integer.valueOf(user), Integer.valueOf(token), componentName});
    }

    public static void writeWmAddToStopping(int user, int token, String componentName, String reason) {
        EventLog.writeEvent(WM_ADD_TO_STOPPING, new Object[]{Integer.valueOf(user), Integer.valueOf(token), componentName, reason});
    }

    public static void writeWmSetKeyguardShown(int displayId, int keyguardshowing, int aodshowing, int keyguardgoingaway, int occluded, String reason) {
        EventLog.writeEvent(WM_SET_KEYGUARD_SHOWN, new Object[]{Integer.valueOf(displayId), Integer.valueOf(keyguardshowing), Integer.valueOf(aodshowing), Integer.valueOf(keyguardgoingaway), Integer.valueOf(occluded), reason});
    }

    public static void writeWmNoSurfaceMemory(String window, int pid, String operation) {
        EventLog.writeEvent(WM_NO_SURFACE_MEMORY, new Object[]{window, Integer.valueOf(pid), operation});
    }

    public static void writeWmTaskCreated(int taskid) {
        EventLog.writeEvent(WM_TASK_CREATED, taskid);
    }

    public static void writeWmTaskMoved(int taskid, int rootTaskId, int displayId, int totop, int index) {
        EventLog.writeEvent(WM_TASK_MOVED, new Object[]{Integer.valueOf(taskid), Integer.valueOf(rootTaskId), Integer.valueOf(displayId), Integer.valueOf(totop), Integer.valueOf(index)});
    }

    public static void writeWmTaskRemoved(int taskid, int rootTaskId, int displayId, String reason) {
        EventLog.writeEvent(WM_TASK_REMOVED, new Object[]{Integer.valueOf(taskid), Integer.valueOf(rootTaskId), Integer.valueOf(displayId), reason});
    }

    public static void writeWmTfCreated(int token, int taskid) {
        EventLog.writeEvent(WM_TF_CREATED, new Object[]{Integer.valueOf(token), Integer.valueOf(taskid)});
    }

    public static void writeWmTfRemoved(int token, int taskid) {
        EventLog.writeEvent(WM_TF_REMOVED, new Object[]{Integer.valueOf(token), Integer.valueOf(taskid)});
    }

    public static void writeWmSetRequestedOrientation(int orientation, String componentName) {
        EventLog.writeEvent(WM_SET_REQUESTED_ORIENTATION, new Object[]{Integer.valueOf(orientation), componentName});
    }

    public static void writeWmBootAnimationDone(long time) {
        EventLog.writeEvent(WM_BOOT_ANIMATION_DONE, time);
    }

    public static void writeWmSetKeyguardOccluded(int occluded, int animate, int transit, String channel) {
        EventLog.writeEvent(WM_SET_KEYGUARD_OCCLUDED, new Object[]{Integer.valueOf(occluded), Integer.valueOf(animate), Integer.valueOf(transit), channel});
    }

    public static void writeWmBackNaviCanceled(String reason) {
        EventLog.writeEvent(WM_BACK_NAVI_CANCELED, reason);
    }

    public static void writeImfUpdateImeParent(String surfaceName) {
        EventLog.writeEvent(IMF_UPDATE_IME_PARENT, surfaceName);
    }

    public static void writeImfShowImeScreenshot(String targetWindow, int transition, String surfacePosition) {
        EventLog.writeEvent(IMF_SHOW_IME_SCREENSHOT, new Object[]{targetWindow, Integer.valueOf(transition), surfacePosition});
    }

    public static void writeImfRemoveImeScreenshot(String targetWindow) {
        EventLog.writeEvent(IMF_REMOVE_IME_SCREENSHOT, targetWindow);
    }

    public static void writeWmWallpaperSurface(int displayId, int visible, String target) {
        EventLog.writeEvent(WM_WALLPAPER_SURFACE, new Object[]{Integer.valueOf(displayId), Integer.valueOf(visible), target});
    }

    public static void writeWmEnterPip(int user, int token, String componentName, String isAutoEnter) {
        EventLog.writeEvent(WM_ENTER_PIP, new Object[]{Integer.valueOf(user), Integer.valueOf(token), componentName, isAutoEnter});
    }

    public static void writeWmDimCreated(String host, int surface) {
        EventLog.writeEvent(WM_DIM_CREATED, new Object[]{host, Integer.valueOf(surface)});
    }

    public static void writeWmDimExit(int surface, String dimmingwindow, int hostisvisible, int removeimmediately) {
        EventLog.writeEvent(WM_DIM_EXIT, new Object[]{Integer.valueOf(surface), dimmingwindow, Integer.valueOf(hostisvisible), Integer.valueOf(removeimmediately)});
    }

    public static void writeWmDimAnimate(int surface, float toalpha, float toblur) {
        EventLog.writeEvent(WM_DIM_ANIMATE, new Object[]{Integer.valueOf(surface), Float.valueOf(toalpha), Float.valueOf(toblur)});
    }

    public static void writeWmDimCancelAnim(int surface, String reason) {
        EventLog.writeEvent(WM_DIM_CANCEL_ANIM, new Object[]{Integer.valueOf(surface), reason});
    }

    public static void writeWmDimFinishAnim(int surface) {
        EventLog.writeEvent(WM_DIM_FINISH_ANIM, surface);
    }

    public static void writeWmDimRemoved(int surface) {
        EventLog.writeEvent(WM_DIM_REMOVED, surface);
    }
}
