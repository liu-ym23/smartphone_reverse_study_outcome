package com.android.server.wm;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Binder;
import android.util.Slog;
import com.android.server.dispatcher.GameActivityStateEventDispatcher;
import com.android.server.display.DisplayMirrorInternal;
import com.zte.game.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayMirrorWm {
    public static boolean ENABLE_GAME_ASSIST = false;
    public static String MAGIC_GAME_ASSIST = null;
    private static final String TAG = "NDMCtrl.DisplayMirrorWm";
    private final WindowManagerGlobalLock mGlobalLock;
    private ActivityStarter.Request mLastRequestToMirror;
    private final ActivityTaskManagerService mService;

    public static /* synthetic */ boolean $r8$lambda$bT1Tzdeyy3YVRPrWU5oPr7Houkw(ActivityRecord r0) {
        return lambda$getTopFullscreenActivity$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$gxYtB4md2BDAhUPWuXjFPun4214(int r0, ArrayList r1, Task r2) {
        lambda$allTaskToDisplay$1(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$psn6_oXU5opaJEiMh6cwTOSYXj8(int r0, Task r1) {
        return lambda$getRootTaskById$0(r0, r1);
    }

    static {
        MAGIC_GAME_ASSIST = "ZTE_FEATURE_MAGIC_GAME_ASSIST";
        ENABLE_GAME_ASSIST = Feature.getBoolean(MAGIC_GAME_ASSIST, false);
    }

    public DisplayMirrorWm(ActivityTaskManagerService atm) {
        this.mLastRequestToMirror = null;
        this.mService = atm;
        this.mGlobalLock = atm.mGlobalLock;
    }

    private Task getRootTaskById(final int taskId) {
        return this.mService.mWindowManager.mRoot.getDefaultTaskDisplayArea().getRootTask(new DisplayMirrorWm$$ExternalSyntheticLambda2(taskId));
    }

    private static /* synthetic */ boolean lambda$getRootTaskById$0(int taskId, Task rootTask) {
        return rootTask.isTaskId(taskId);
    }

    public ActivityRecord getTopFullActivity(int taskId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task task = getRootTaskById(taskId);     // Catch: Throwable -> L9
        if (task != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L11:
        ActivityRecord r2 = getTopFullActivityInner(task);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public ActivityRecord getTopFullActivityOfDisplay(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mService.mWindowManager.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (dc != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L11:
        Task task = dc.getDefaultTaskDisplayArea().getTopRootTaskInWindowingMode(1);     // Catch: Throwable -> L9
        if (task != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L16:
        ActivityRecord r2 = getTopFullActivityInner(task);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public ActivityRecord getTopFullActivityInner(Task task) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r1 = getTopFullscreenActivity(task);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private Task getTopFullTaskLocked() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        TaskDisplayArea tc = this.mService.mRootWindowContainer.getDefaultTaskDisplayArea();     // Catch: Throwable -> L12
        Task task = tc.getTopRootTaskInWindowingMode(1);     // Catch: Throwable -> L12
        if (task == null) goto L14;
        if (task.isActivityTypeStandard() == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return task;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private Task getTopTaskOfDefaultDisplay() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        TaskDisplayArea tc = this.mService.mRootWindowContainer.getDefaultTaskDisplayArea();     // Catch: Throwable -> L8
        Task tack = tc.getTopRootTask();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return tack;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setFocusedTask(ActivityRecord activity) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.setFocusedTask(activity.getRootTaskId());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void saveLastRequestToMirror(Object request) {
        if (request != null) goto L4;
        this.mLastRequestToMirror = null;
        return;
    L4:
        this.mLastRequestToMirror = new ActivityStarter.Request();
        this.mLastRequestToMirror.set((ActivityStarter.Request) request);
    }

    public void finishPointerCaptureAcvitiy(ActivityRecord activity) {
        if (activity != null) goto L4;
        return;
    L4:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L7:
        if (activity.toString().contains("com.limelight") == false) goto L11;
        Slog.d(TAG, "finishPointerCaptureAcvitiy mirror activity=" + activity);     // Catch: Throwable -> L9
        activity.finishIfPossible("request-mirror", false);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    public int getTopFullTaskId() {
        Task task = getTopFullTaskLocked();
        if (task != null) goto L7;
        return -1;
    L7:
        return task.getRootTaskId();
    }

    public void taskToDisplay(int taskId, int displayId, boolean toTop) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.deferWindowLayout();     // Catch: Throwable -> L10
        Slog.e(TAG, "taskToDisplay " + taskId);     // Catch: Throwable -> L12
        this.mService.mRootWindowContainer.moveRootTaskToDisplay(taskId, displayId, toTop);     // Catch: Throwable -> L12
        mergeToGlobalTransactionNow(this.mService.mRootWindowContainer);     // Catch: Throwable -> L12
        DisplayContent displayContent = this.mService.mRootWindowContainer.getDisplayContent(displayId);     // Catch: Throwable -> L12
        this.mService.mRootWindowContainer.ensureVisibilityAndConfig(null, displayContent, false);     // Catch: Throwable -> L12
        this.mService.continueWindowLayout();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        this.mService.continueWindowLayout();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void allTaskToDisplay(int fromDisplayId, final int toDisplayId, boolean toTop) {
        if (fromDisplayId != toDisplayId) goto L5;
        return;
    L5:
        WindowManagerGlobalLock r5 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r5);
        this.mService.deferWindowLayout();     // Catch: Throwable -> L14
        DisplayContent fromDisplay = this.mService.mRootWindowContainer.getDisplayContent(fromDisplayId);     // Catch: Throwable -> L36
        if (fromDisplay != null) goto L16;
        this.mService.continueWindowLayout();     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L16:
        DisplayContent toDisplay = this.mService.mRootWindowContainer.getDisplayContent(toDisplayId);     // Catch: Throwable -> L36
        if (toDisplay != null) goto L22;
        this.mService.continueWindowLayout();     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L22:
        TaskDisplayArea toArea = toDisplay.getDefaultTaskDisplayArea();     // Catch: Throwable -> L36
        if (toArea != null) goto L28;
        this.mService.continueWindowLayout();     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L28:
        final ArrayList<Task> taskList = new ArrayList();     // Catch: Throwable -> L36
        Consumer<Task> r9 = new DisplayMirrorWm$$ExternalSyntheticLambda1(toDisplayId, taskList);     // Catch: Throwable -> L36
        if (toTop == true) goto L31;
        boolean r11 = true;
    L32:
        fromDisplay.forAllRootTasks(r9, r11);     // Catch: Throwable -> L36
        Iterator<Task> r10 = taskList.iterator();     // Catch: Throwable -> L36
    L34:
        if (r10.hasNext() == false) goto L38;
        Task task = r10.next();     // Catch: Throwable -> L36
        task.reparent(toArea, toTop);     // Catch: Throwable -> L36
        goto L34
    L38:
        int i = 0;
    L40:
        if (i >= taskList.size()) goto L54;
        Task srctask = taskList.get(i);     // Catch: Throwable -> L36
        if (srctask == null) goto L53;
        ActivityRecord topactivity = srctask.topRunningActivity();     // Catch: Throwable -> L36
        Slog.d(TAG, "allTaskToDisplay checktop " + srctask);     // Catch: Throwable -> L36
        if (ENABLE_GAME_ASSIST == false) goto L53;
        if (topactivity == null) goto L53;
        if (topactivity.isInterestingToUserLocked() == false) goto L53;
        if (toTop == false) goto L53;
        GameActivityStateEventDispatcher.getInstance().notifyGameActivityResumed(topactivity.getDisplayId(), topactivity.info, topactivity.getRootTaskId(), topactivity.app.getPid(), topactivity.getWindowingMode(), topactivity.getActivityType(), topactivity, topactivity.mActivityComponent, topactivity.mUserId, getTaskLabelHashcode(srctask));     // Catch: Throwable -> L36
    L53:
        i = i + 1;     // Catch: Throwable -> L36
        fromDisplay = fromDisplay;
        goto L40
    L54:
        DisplayContent displayContent = this.mService.mRootWindowContainer.getDisplayContent(0);     // Catch: Throwable -> L36
        this.mService.mRootWindowContainer.ensureVisibilityAndConfig(null, displayContent, false);     // Catch: Throwable -> L36
        this.mService.continueWindowLayout();     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L31:
        r11 = false;
    L36:
        th = move-exception;
        this.mService.continueWindowLayout();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$allTaskToDisplay$1(int toDisplayId, ArrayList taskList, Task task) {
        if (task.inFreeformWindowingMode() == false) goto L8;
        if (toDisplayId != 0) goto L8;
        task.setWindowingMode(1);
        return;
    L8:
        if (task.isActivityTypeHome() == true) goto L11;
        taskList.add(task);
        return;
    }

    public String getLableOfActivity(ActivityRecord r) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        String taskLable = "";
        Task task = r.getTask();     // Catch: Throwable -> L9
        if (task == null) goto L12;
        if (task.getTaskDescription().getLabel() == null) goto L12;
        taskLable = task.getTaskDescription().getLabel().toString();     // Catch: Throwable -> L9
    L12:
        if (taskLable.equals("") == false) goto L19;
        if (r.info == null) goto L19;
        ActivityInfo info = r.info;     // Catch: Throwable -> L9
        CharSequence temp = info.loadLabel(this.mService.mContext.getPackageManager());     // Catch: Throwable -> L9
        if (temp == null) goto L19;
        taskLable = temp.toString();     // Catch: Throwable -> L9
    L19:
        if (taskLable.equals("") == false) goto L21;
        taskLable = r.packageName;     // Catch: Throwable -> L9
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return taskLable;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void continueStartActivity(boolean isContinue) {
        if (this.mLastRequestToMirror != null) goto L6;
        return;
    L6:
        if (isContinue == true) goto L9;
        saveLastRequestToMirror(null);
        return;
    L9:
        ActivityStarter starter = this.mService.getActivityStartController().obtainStarter(null, "continueStartActivity");
        setReuseByAppMirror(true);
        starter.mRequest.set(this.mLastRequestToMirror);     // Catch: Throwable -> L13
        starter.execute();     // Catch: Throwable -> L13
        setReuseByAppMirror(false);
        return;
    L13:
        th = move-exception;
        setReuseByAppMirror(false);
        throw th;
    }

    public boolean mirrorGameBox(boolean isEnable, int displayId) {
        if (isEnable == true) goto L4;
        return true;
    L4:
        return startMirrorGameBox(displayId);
    }

    private boolean startMirrorGameBox(int displayId) {
        Intent gbIntent = DisplayMirrorInternal.getGameBoxIntent(displayId);
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        DisplayContent display = this.mService.mRootWindowContainer.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L11:
        TaskDisplayArea displayArea = display.getDefaultTaskDisplayArea();     // Catch: Throwable -> L9
        if (displayArea != null) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L16:
        ActivityInfo aInfo = this.mService.mRootWindowContainer.resolveHomeActivity(0, gbIntent);     // Catch: Throwable -> L9
        if (aInfo != null) goto L34;
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L34:
        DisplayMirrorInternal.mNeedCreateHome = true;     // Catch: Throwable -> L27
        this.mService.getActivityStartController().startHomeActivity(gbIntent, aInfo, "mirrorGameBox", displayArea);     // Catch: Throwable -> L27
        DisplayMirrorInternal.mNeedCreateHome = false;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L27:
        th = move-exception;
        DisplayMirrorInternal.mNeedCreateHome = false;     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public String getTopActivityTypeInDefaultDisplay() {
        ActivityTaskManagerService.enforceTaskPermission("getTopActivityTypeInDefaultDisplay()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L61
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L61
        monitor-enter(r2);     // Catch: Throwable -> L61
        Task topTask = getTopTaskOfDefaultDisplay();     // Catch: Throwable -> L18
        if (topTask == null) goto L55;
        if (topTask.isActivityTypeHome() == true) goto L51;
        if (topTask.isActivityTypeRecents() == true) goto L51;
        if (topTask.inFreeformWindowingMode() == false) goto L21;
        monitor-exit(r2);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return "freeform";
    L21:
        if (topTask.inPinnedWindowingMode() == true) goto L23;
        Task leaf = topTask.getTopLeafTask();     // Catch: Throwable -> L18
        if (leaf != null) goto L29;
    L34:
        ActivityRecord r = getTopFullscreenActivity(topTask);     // Catch: Throwable -> L18
        if (r != null) goto L41;
        monitor-exit(r2);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return "dialog";
    L41:
        if ("cn.nubia.keymapcenter".equals(r.packageName) == true) goto L43;
        String r6 = r.packageName;     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r6;
    L43:
        monitor-exit(r2);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return "home";
    L29:
        if (leaf.getWindowingMode() != 6) goto L34;
        monitor-exit(r2);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return "splitscreen";
    L23:
        monitor-exit(r2);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return "freeform";
    L51:
        monitor-exit(r2);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return "home";
    L55:
        monitor-exit(r2);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return "";
    L18:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public int getTaskLabelHashcode(Task task) {
        if (ENABLE_GAME_ASSIST == true) goto L5;
        return 0;
    L5:
        if (task.getTaskDescription() != null) goto L7;
        return 0;
    L7:
        if (task.getTaskDescription().getLabel() == null) goto L12;
        int taskHashcode = task.getTaskDescription().getLabel().hashCode();
        return taskHashcode;
    L12:
        return 0;
    }

    public ActivityRecord getTopFullscreenActivity(Task task) {
        return task.getActivity(new DisplayMirrorWm$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ boolean lambda$getTopFullscreenActivity$2(ActivityRecord r) {
        WindowState win = r.findMainWindow();
        if (win != null) goto L5;
    L7:
        return false;
    L5:
        if (win.mAttrs.isFullscreen() == false) goto L7;
        return true;
    }

    void mergeToGlobalTransactionNow(RootWindowContainer mRootWindowContainer) {
        int count = mRootWindowContainer.mChildren.size();
        int j = 0;
    L3:
        if (j >= count) goto L6;
        DisplayContent dc = (DisplayContent) mRootWindowContainer.mChildren.get(j);
        dc.prepareSurfaces();
        j = j + 1;
        goto L3
    }

    void setReuseByAppMirror(boolean isReuse) {
        DisplayMirrorInternal.mIsReuseByAppMirror = isReuse;
    }
}
