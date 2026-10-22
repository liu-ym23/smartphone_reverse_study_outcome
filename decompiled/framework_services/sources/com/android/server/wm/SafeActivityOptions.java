package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.AppGlobals;
import android.app.WindowConfiguration;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Slog;
import android.view.RemoteAnimationAdapter;
import android.window.RemoteTransition;
import android.window.WindowContainerToken;

/* JADX INFO: loaded from: classes3.dex */
public class SafeActivityOptions {
    private static final String TAG = "ActivityTaskManager";
    private ActivityOptions mCallerOptions;
    private final int mOriginalCallingPid;
    private final int mOriginalCallingUid;
    private final ActivityOptions mOriginalOptions;
    private int mRealCallingPid;
    private int mRealCallingUid;

    public static /* synthetic */ TaskDisplayArea $r8$lambda$ACnWmPGx_zAftFgijPPx33008Tw(int r0, TaskDisplayArea r1) {
        return lambda$getLaunchTaskDisplayArea$0(r0, r1);
    }

    static SafeActivityOptions fromBundle(Bundle bOptions, int callingPid, int callingUid) {
        if (bOptions != null) goto L6;
        return null;
    L6:
        return new SafeActivityOptions(ActivityOptions.fromBundle(bOptions), callingPid, callingUid);
    }

    public SafeActivityOptions(ActivityOptions options, int callingPid, int callingUid) {
        this.mOriginalCallingPid = callingPid;
        this.mOriginalCallingUid = callingUid;
        this.mOriginalOptions = options;
    }

    SafeActivityOptions selectiveCloneLaunchOptions() {
        ActivityOptions options = cloneLaunchingOptions(this.mOriginalOptions);
        ActivityOptions callerOptions = cloneLaunchingOptions(this.mCallerOptions);
        if (options != null) goto L7;
        if (callerOptions != null) goto L7;
        return null;
    L7:
        SafeActivityOptions safeOptions = new SafeActivityOptions(options, this.mOriginalCallingPid, this.mOriginalCallingUid);
        safeOptions.mCallerOptions = callerOptions;
        safeOptions.mRealCallingPid = this.mRealCallingPid;
        safeOptions.mRealCallingUid = this.mRealCallingUid;
        return safeOptions;
    }

    private ActivityOptions cloneLaunchingOptions(ActivityOptions options) {
        if (options != null) goto L5;
        return null;
    L5:
        ActivityOptions cloneOptions = ActivityOptions.makeBasic().setLaunchTaskDisplayArea(options.getLaunchTaskDisplayArea()).setLaunchDisplayId(options.getLaunchDisplayId()).setCallerDisplayId(options.getCallerDisplayId()).setLaunchRootTask(options.getLaunchRootTask()).setPendingIntentBackgroundActivityStartMode(options.getPendingIntentBackgroundActivityStartMode()).setPendingIntentCreatorBackgroundActivityStartMode(options.getPendingIntentCreatorBackgroundActivityStartMode()).setRemoteTransition(options.getRemoteTransition());
        cloneOptions.setLaunchWindowingMode(options.getLaunchWindowingMode());
        return cloneOptions;
    }

    public void setCallerOptions(ActivityOptions options, int callingPid, int callingUid) {
        this.mRealCallingPid = callingPid;
        this.mRealCallingUid = callingUid;
        this.mCallerOptions = options;
    }

    ActivityOptions getOptions(ActivityRecord r) throws SecurityException {
        return getOptions(r.intent, r.info, r.app, r.mTaskSupervisor);
    }

    ActivityOptions getOptions(ActivityTaskSupervisor supervisor) throws SecurityException {
        return getOptions(null, null, null, supervisor);
    }

    ActivityOptions getOptions(Intent intent, ActivityInfo aInfo, WindowProcessController callerApp, ActivityTaskSupervisor supervisor) throws SecurityException {
        if (this.mOriginalOptions == null) goto L6;
        checkPermissions(intent, aInfo, callerApp, supervisor, this.mOriginalOptions, this.mOriginalCallingPid, this.mOriginalCallingUid);
        setCallingPidUidForRemoteAnimationAdapter(this.mOriginalOptions, this.mOriginalCallingPid, this.mOriginalCallingUid);
    L6:
        if (this.mCallerOptions == null) goto L9;
        checkPermissions(intent, aInfo, callerApp, supervisor, this.mCallerOptions, this.mRealCallingPid, this.mRealCallingUid);
        setCallingPidUidForRemoteAnimationAdapter(this.mCallerOptions, this.mRealCallingPid, this.mRealCallingUid);
    L9:
        return mergeActivityOptions(this.mOriginalOptions, this.mCallerOptions);
    }

    private void setCallingPidUidForRemoteAnimationAdapter(ActivityOptions options, int callingPid, int callingUid) {
        RemoteAnimationAdapter adapter = options.getRemoteAnimationAdapter();
        if (adapter != null) goto L6;
        return;
    L6:
        if (callingPid != WindowManagerService.MY_PID) goto L9;
        Slog.w(TAG, "Safe activity options constructed after clearing calling id");
        return;
    L9:
        adapter.setCallingPidUid(callingPid, callingUid);
    }

    ActivityOptions getOriginalOptions() {
        return this.mOriginalOptions;
    }

    Bundle popAppVerificationBundle() {
        if (this.mOriginalOptions != null) goto L7;
        return null;
    L7:
        return this.mOriginalOptions.popAppVerificationBundle();
    }

    private void abort() {
        if (this.mOriginalOptions == null) goto L6;
        ActivityOptions.abort(this.mOriginalOptions);
    L6:
        if (this.mCallerOptions == null) goto L9;
        ActivityOptions.abort(this.mCallerOptions);
        return;
    }

    static void abort(SafeActivityOptions options) {
        if (options == null) goto L5;
        options.abort();
        return;
    }

    ActivityOptions mergeActivityOptions(ActivityOptions options1, ActivityOptions options2) {
        if (options1 != null) goto L4;
        return options2;
    L4:
        if (options2 != null) goto L6;
        return options1;
    L6:
        Bundle b1 = options1.toBundle();
        Bundle b2 = options2.toBundle();
        b1.putAll(b2);
        return ActivityOptions.fromBundle(b1);
    }

    private void checkPermissions(Intent intent, ActivityInfo aInfo, WindowProcessController callerApp, ActivityTaskSupervisor supervisor, ActivityOptions options, int callingPid, int callingUid) {
        if (options.getLaunchTaskId() != (-1)) goto L7;
        if (options.getDisableStartingWindow() == true) goto L7;
    L14:
        if (options.getTransientLaunch() == true) goto L16;
    L22:
        TaskDisplayArea taskDisplayArea = getLaunchTaskDisplayArea(options, supervisor);
        if (aInfo == null) goto L30;
        if (taskDisplayArea == null) goto L30;
        if (supervisor.isCallerAllowedToLaunchOnTaskDisplayArea(callingPid, callingUid, taskDisplayArea, aInfo) == true) goto L30;
        String msg = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with launchTaskDisplayArea=" + taskDisplayArea;
        Slog.w(TAG, msg);
        throw new SecurityException(msg);
    L30:
        int launchDisplayId = options.getLaunchDisplayId();
        if (aInfo == null) goto L38;
        if (launchDisplayId == (-1)) goto L38;
        if (supervisor.isCallerAllowedToLaunchOnDisplay(callingPid, callingUid, launchDisplayId, aInfo) == true) goto L38;
        String msg2 = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with launchDisplayId=" + launchDisplayId;
        Slog.w(TAG, msg2);
        throw new SecurityException(msg2);
    L38:
        boolean lockTaskMode = options.getLockTaskMode();
        if (aInfo == null) goto L47;
        if (lockTaskMode == false) goto L47;
        if (supervisor.mService.getLockTaskController().isPackageAllowlisted(UserHandle.getUserId(callingUid), aInfo.packageName) == true) goto L47;
        String msg3 = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with lockTaskMode=true";
        Slog.w(TAG, msg3);
        throw new SecurityException(msg3);
    L47:
        boolean overrideTaskTransition = options.getOverrideTaskTransition();
        if (aInfo == null) goto L57;
        if (overrideTaskTransition == false) goto L57;
        int startTasksFromRecentsPerm = ActivityTaskManagerService.checkPermission("android.permission.START_TASKS_FROM_RECENTS", callingPid, callingUid);
        if (startTasksFromRecentsPerm == 0) goto L57;
        if (isAssistant(supervisor.mService, callingUid) == true) goto L57;
        String msg4 = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with overrideTaskTransition=true";
        Slog.w(TAG, msg4);
        throw new SecurityException(msg4);
    L57:
        boolean dismissKeyguardIfInsecure = options.getDismissKeyguardIfInsecure();
        if (aInfo == null) goto L65;
        if (dismissKeyguardIfInsecure == false) goto L65;
        int controlKeyguardPerm = ActivityTaskManagerService.checkPermission("android.permission.CONTROL_KEYGUARD", callingPid, callingUid);
        if (controlKeyguardPerm == 0) goto L65;
        String msg5 = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with dismissKeyguardIfInsecure=true";
        Slog.w(TAG, msg5);
        throw new SecurityException(msg5);
    L65:
        RemoteAnimationAdapter adapter = options.getRemoteAnimationAdapter();
        if (adapter == null) goto L72;
        ActivityTaskManagerService r1 = supervisor.mService;
        if (ActivityTaskManagerService.checkPermission("android.permission.CONTROL_REMOTE_APP_TRANSITION_ANIMATIONS", callingPid, callingUid) == 0) goto L72;
        String msg6 = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with remoteAnimationAdapter";
        Slog.w(TAG, msg6);
        throw new SecurityException(msg6);
    L72:
        RemoteTransition transition = options.getRemoteTransition();
        if (transition == null) goto L81;
        ActivityTaskManagerService r2 = supervisor.mService;
        if (ActivityTaskManagerService.checkPermission("android.permission.CONTROL_REMOTE_APP_TRANSITION_ANIMATIONS", callingPid, callingUid) == 0) goto L81;
        String msg7 = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with remoteTransition";
        Slog.w(TAG, msg7);
        throw new SecurityException(msg7);
    L81:
        if (options.getLaunchedFromBubble() == true) goto L85;
        if (options.getTaskAlwaysOnTop() == true) goto L85;
    L96:
        if (options.getLaunchWindowingMode() == 2) goto L111;
        int activityType = options.getLaunchActivityType();
        if (activityType != 0) goto L100;
        return;
    L100:
        if (isSystemOrSystemUI(callingPid, callingUid) == true) goto L113;
        boolean activityTypeGranted = false;
        if (activityType == 4) goto L104;
    L106:
        if (activityTypeGranted == true) goto L114;
        String msg8 = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with launchActivityType=" + WindowConfiguration.activityTypeToString(options.getLaunchActivityType());
        Slog.w(TAG, msg8);
        throw new SecurityException(msg8);
    L114:
        return;
    L104:
        if (isAssistant(supervisor.mService, callingUid) == false) goto L106;
        activityTypeGranted = true;
        goto L106
    L113:
        return;
    L111:
        String msg9 = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with setLaunchWindowingMode=PINNED";
        Slog.w(TAG, msg9);
        throw new SecurityException(msg9);
    L85:
        if (isSystemOrSystemUI(callingPid, callingUid) == true) goto L96;
        StringBuilder r3 = new StringBuilder();
        r3.append("Permission Denial: starting ");
        r3.append(getIntentString(intent));
        r3.append(" from ");
        r3.append(callerApp);
        r3.append(" (pid=");
        r3.append(callingPid);
        r3.append(", uid=");
        r3.append(callingUid);
        r3.append(") with");
        String r9 = "";
        if (options.getLaunchedFromBubble() == false) goto L89;
        String r8 = " launchedFromBubble=true";
    L90:
        r3.append(r8);
        if (options.getTaskAlwaysOnTop() == false) goto L93;
        r9 = " taskAlwaysOnTop=true";
    L93:
        r3.append(r9);
        String msg10 = r3.toString();
        Slog.w(TAG, msg10);
        throw new SecurityException(msg10);
    L89:
        r8 = "";
        goto L90
    L16:
        if (supervisor.mRecentTasks.isCallerRecents(callingUid) == true) goto L22;
        if (ActivityTaskManagerService.checkPermission("android.permission.MANAGE_ACTIVITY_TASKS", callingPid, callingUid) != (-1)) goto L22;
        String msg11 = "Permission Denial: starting transient launch from " + callerApp + ", pid=" + callingPid + ", uid=" + callingUid;
        Slog.w(TAG, msg11);
        throw new SecurityException(msg11);
    L7:
        if (supervisor.mRecentTasks.isCallerRecents(callingUid) == true) goto L14;
        int startInTaskPerm = ActivityTaskManagerService.checkPermission("android.permission.START_TASKS_FROM_RECENTS", callingPid, callingUid);
        if (startInTaskPerm != (-1)) goto L14;
        String msg12 = "Permission Denial: starting " + getIntentString(intent) + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with launchTaskId=" + options.getLaunchTaskId();
        Slog.w(TAG, msg12);
        throw new SecurityException(msg12);
    }

    TaskDisplayArea getLaunchTaskDisplayArea(ActivityOptions options, ActivityTaskSupervisor supervisor) {
        WindowContainerToken daToken = options.getLaunchTaskDisplayArea();
        if (daToken == null) goto L5;
        TaskDisplayArea taskDisplayArea = (TaskDisplayArea) WindowContainer.fromBinder(daToken.asBinder());
    L6:
        if (taskDisplayArea == null) goto L8;
        return taskDisplayArea;
    L8:
        final int launchTaskDisplayAreaFeatureId = options.getLaunchTaskDisplayAreaFeatureId();
        if (launchTaskDisplayAreaFeatureId != (-1)) goto L11;
        return taskDisplayArea;
    L11:
        if (options.getLaunchDisplayId() != (-1)) goto L13;
        int launchDisplayId = 0;
    L14:
        DisplayContent dc = supervisor.mRootWindowContainer.getDisplayContent(launchDisplayId);
        if (dc == null) goto L19;
        TaskDisplayArea taskDisplayArea2 = (TaskDisplayArea) dc.getItemFromTaskDisplayAreas(new SafeActivityOptions$$ExternalSyntheticLambda0(launchTaskDisplayAreaFeatureId));
        return taskDisplayArea2;
    L19:
        return taskDisplayArea;
    L13:
        launchDisplayId = options.getLaunchDisplayId();
        goto L14
    L5:
        taskDisplayArea = null;
        goto L6
    }

    private static /* synthetic */ TaskDisplayArea lambda$getLaunchTaskDisplayArea$0(int launchTaskDisplayAreaFeatureId, TaskDisplayArea tda) {
        if (tda.mFeatureId == launchTaskDisplayAreaFeatureId) goto L7;
        return null;
    L7:
        return tda;
    }

    public static boolean isAssistant(ActivityTaskManagerService atmService, int callingUid) {
        if (atmService.mActiveVoiceInteractionServiceComponent != null) goto L5;
        return false;
    L5:
        String assistantPackage = atmService.mActiveVoiceInteractionServiceComponent.getPackageName();
        int uid = AppGlobals.getPackageManager().getPackageUid(assistantPackage, 268435456, UserHandle.getUserId(callingUid));     // Catch: RemoteException -> L11
        if (uid != callingUid) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean isSystemOrSystemUI(int callingPid, int callingUid) {
        if (callingUid != 1000) goto L5;
        return true;
    L5:
        int statusBarPerm = ActivityTaskManagerService.checkPermission("android.permission.STATUS_BAR_SERVICE", callingPid, callingUid);
        if (statusBarPerm == 0) goto L10;
        return false;
    L10:
        return true;
    }

    private String getIntentString(Intent intent) {
        if (intent != null) goto L6;
        return "(no intent)";
    L6:
        return intent.toString();
    }
}
