package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.compat.CompatChanges;
import android.content.pm.ApplicationInfo;
import android.os.UserHandle;
import android.util.Slog;
import android.window.ITaskOrganizer;
import android.window.TaskSnapshot;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class StartingSurfaceController {
    private static final long ALLOW_COPY_SOLID_COLOR_VIEW = 205907456;
    private static final String TAG = null;
    private final ArrayList<DeferringStartingWindowRecord> mDeferringAddStartActivities;
    private boolean mDeferringAddStartingWindow;
    boolean mInitNewTask;
    boolean mInitProcessRunning;
    boolean mInitTaskSwitch;
    private final WindowManagerService mService;
    private final SplashScreenExceptionList mSplashScreenExceptionsList;

    private static final class DeferringStartingWindowRecord {
        final ActivityRecord mDeferring;
        final ActivityRecord mPrev;
        final ActivityRecord mSource;

        DeferringStartingWindowRecord(ActivityRecord deferring, ActivityRecord prev, ActivityRecord source) {
            this.mDeferring = deferring;
            this.mPrev = prev;
            this.mSource = source;
        }
    }

    final class StartingSurface {
        private final Task mTask;
        final ITaskOrganizer mTaskOrganizer;
        final /* synthetic */ StartingSurfaceController this$0;

        StartingSurface(StartingSurfaceController this$0, Task task, ITaskOrganizer taskOrganizer) {
            this.this$0 = this$0;
            this.mTask = task;
            this.mTaskOrganizer = taskOrganizer;
        }

        public void remove(boolean animate, boolean hasImeSurface) {
            WindowManagerGlobalLock r0 = StartingSurfaceController.m10150$$Nest$fgetmService(this.this$0).mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            StartingSurfaceController.m10150$$Nest$fgetmService(this.this$0).mAtmService.mTaskOrganizerController.removeStartingWindow(this.mTask, this.mTaskOrganizer, animate, hasImeSurface);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m10150$$Nest$fgetmService(StartingSurfaceController r0) {
        return r0.mService;
    }

    static {
        TAG = "WindowManager";
    }

    public StartingSurfaceController(WindowManagerService wm) {
        this.mDeferringAddStartActivities = new ArrayList();
        this.mService = wm;
        this.mSplashScreenExceptionsList = new SplashScreenExceptionList(wm.mContext.getMainExecutor());
    }

    StartingSurface createSplashScreenStartingSurface(ActivityRecord activity, int theme, TaskSnapshot taskSnapshot) {
        Task task = activity.getTask();
        TaskOrganizerController controller = this.mService.mAtmService.mTaskOrganizerController;
        activity.getExt().handleFixedRotationIfNeeded();
        if (task != null) goto L5;
        return null;
    L5:
        if (controller.addStartingWindow(task, activity, theme, taskSnapshot) == true) goto L7;
        return null;
    L7:
        return new StartingSurface(this, task, controller.getTaskOrganizer());
    }

    boolean isExceptionApp(String packageName, int targetSdk, Supplier<ApplicationInfo> infoProvider) {
        return this.mSplashScreenExceptionsList.isException(packageName, targetSdk, infoProvider);
    }

    static int makeStartingWindowTypeParameter(boolean newTask, boolean taskSwitch, boolean processRunning, boolean allowTaskSnapshot, boolean activityCreated, boolean isSolidColor, boolean useLegacy, boolean activityDrawn, int startingWindowType, boolean appPrefersIcon, String packageName, int userId) {
        int parameter = 0;
        if (newTask == false) goto L5;
        parameter = 0 | 1;
    L5:
        if (taskSwitch == false) goto L7;
        parameter = parameter | 2;
    L7:
        if (processRunning == false) goto L9;
        parameter = parameter | 4;
    L9:
        if (allowTaskSnapshot == false) goto L11;
        parameter = parameter | 8;
    L11:
        if (activityCreated == false) goto L13;
    L14:
        parameter = parameter | 16;
    L15:
        if (isSolidColor == false) goto L17;
        parameter = parameter | 32;
    L17:
        if (useLegacy == false) goto L19;
        parameter = parameter | Integer.MIN_VALUE;
    L19:
        if (activityDrawn == false) goto L22;
        parameter = parameter | 64;
    L22:
        if (startingWindowType == 2) goto L24;
    L26:
        if (appPrefersIcon == true) goto L28;
        return parameter;
    L28:
        return parameter | 512;
    L24:
        if (CompatChanges.isChangeEnabled(ALLOW_COPY_SOLID_COLOR_VIEW, packageName, UserHandle.of(userId)) == false) goto L26;
        parameter = parameter | 128;
        goto L26
    L13:
        if (startingWindowType != 1) goto L15;
        goto L14
    }

    StartingSurface createTaskSnapshotSurface(ActivityRecord activity, TaskSnapshot taskSnapshot) {
        Task task = activity.getTask();
        if (task != null) goto L6;
        Slog.w(TAG, "TaskSnapshotSurface.create: Failed to find task for activity=" + activity);
        return null;
    L6:
        WindowState mainWindow = task.getTopFullscreenMainWindow();
        if (mainWindow != null) goto L11;
        Slog.w(TAG, "TaskSnapshotSurface.create: no main window in " + activity);
        return null;
    L11:
        if (activity.mDisplayContent.getRotation() == taskSnapshot.getRotation()) goto L13;
        activity.mDisplayContent.handleTopActivityLaunchingInDifferentOrientation(activity, false);
    L13:
        TaskOrganizerController controller = this.mService.mAtmService.mTaskOrganizerController;
        if (controller.addStartingWindow(task, activity, 0, taskSnapshot) == true) goto L16;
        return null;
    L16:
        return new StartingSurface(this, task, controller.getTaskOrganizer());
    }

    void showStartingWindow(ActivityRecord target, ActivityRecord prev, boolean newTask, boolean isTaskSwitch, ActivityRecord source) {
        if (this.mDeferringAddStartingWindow == false) goto L5;
        addDeferringRecord(target, prev, newTask, isTaskSwitch, source);
        return;
    L5:
        target.showStartingWindow(prev, newTask, isTaskSwitch, true, source);
    }

    private void addDeferringRecord(ActivityRecord deferring, ActivityRecord prev, boolean newTask, boolean isTaskSwitch, ActivityRecord source) {
        if (this.mDeferringAddStartActivities.isEmpty() == false) goto L5;
        this.mInitProcessRunning = deferring.isProcessRunning();
        this.mInitNewTask = newTask;
        this.mInitTaskSwitch = isTaskSwitch;
    L5:
        this.mDeferringAddStartActivities.add(new DeferringStartingWindowRecord(deferring, prev, source));
    }

    private void showStartingWindowFromDeferringActivities(ActivityOptions topOptions) {
        int i = this.mDeferringAddStartActivities.size() - 1;
    L3:
        if (i < 0) goto L12;
        DeferringStartingWindowRecord next = this.mDeferringAddStartActivities.get(i);
        if (next.mDeferring.getTask() != null) goto L7;
        Slog.e(TAG, "No task exists: " + next.mDeferring.shortComponentName + " parent: " + next.mDeferring.getParent());
        ActivityOptions topOptions2 = topOptions;
    L10:
        i = i - 1;
        topOptions = topOptions2;
        goto L3
    L7:
        topOptions2 = topOptions;
        next.mDeferring.showStartingWindow(next.mPrev, this.mInitNewTask, this.mInitTaskSwitch, this.mInitProcessRunning, true, next.mSource, topOptions2);
        if (next.mDeferring.mStartingData == null) goto L10;
    L12:
        this.mDeferringAddStartActivities.clear();
    }

    void beginDeferAddStartingWindow() {
        this.mDeferringAddStartingWindow = true;
    }

    void endDeferAddStartingWindow(ActivityOptions topOptions) {
        this.mDeferringAddStartingWindow = false;
        showStartingWindowFromDeferringActivities(topOptions);
    }
}
