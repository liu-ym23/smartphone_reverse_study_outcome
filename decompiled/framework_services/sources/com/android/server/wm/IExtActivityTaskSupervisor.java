package com.android.server.wm;

import android.app.ActivityOptions;
import android.graphics.Rect;
import android.pico.utils.IExtBase;
import android.quick.window.QuickWinInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtActivityTaskSupervisor extends IExtBase {
    void afterStartActivityFromRecents();

    void beforeStartActivityFromRecents();

    void findTaskToMoveToFront(Task r1, ActivityOptions r2);

    default int calculate(int launchMode, ActivityRecord source, Task task, ActivityRecord startActivity, ActivityOptions options, int realCallingPid) {
        return launchMode;
    }

    default boolean disableUpdateExistingTaskWindowingMode(Task task) {
        return false;
    }

    default void prepareTaskForStartActivityFromRecents(Task task, ActivityOptions options) {
    }

    default void onTaskRemoved(Task task, String reason) {
    }

    default Task resolveQuickWindowSourceTaskIfNeeded(ActivityTaskSupervisor supervisor, Task sourceTask, ActivityRecord startActivity, Task targetTask, ActivityOptions options, int realCallingPid) {
        return sourceTask;
    }

    default QuickWinInfo calculateQuickWindowBounds(ActivityRecord activity, ActivityRecord source, Task task, Rect outBounds) {
        return null;
    }
}
