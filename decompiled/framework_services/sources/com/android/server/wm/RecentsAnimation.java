package com.android.server.wm;

import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.util.Slog;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.internal.util.function.pooled.PooledPredicate;

/* JADX INFO: loaded from: classes3.dex */
class RecentsAnimation {
    private static final String TAG = null;
    private final ActivityStartController mActivityStartController;
    private final TaskDisplayArea mDefaultTaskDisplayArea;
    private final ComponentName mRecentsComponent;
    private final String mRecentsFeatureId;
    private final int mRecentsUid;
    private final int mTargetActivityType;
    private final Intent mTargetIntent;
    private final ActivityTaskSupervisor mTaskSupervisor;
    private final int mUserId;

    public static /* synthetic */ boolean $r8$lambda$nqMtnnzx_C3cCWD_kdtY97Bzhpg(RecentsAnimation r0, Task r1) {
        return r0.matchesTarget(r1);
    }

    static {
        TAG = RecentsAnimation.class.getSimpleName();
    }

    RecentsAnimation(ActivityTaskManagerService atm, ActivityTaskSupervisor taskSupervisor, ActivityStartController activityStartController, Intent targetIntent, ComponentName recentsComponent, String recentsFeatureId, int recentsUid) {
        this.mTaskSupervisor = taskSupervisor;
        this.mDefaultTaskDisplayArea = atm.mRootWindowContainer.getDefaultTaskDisplayArea();
        this.mActivityStartController = activityStartController;
        this.mTargetIntent = targetIntent;
        this.mRecentsComponent = recentsComponent;
        this.mRecentsFeatureId = recentsFeatureId;
        this.mRecentsUid = recentsUid;
        this.mUserId = atm.getCurrentUserId();
        if (targetIntent.getComponent() != null) goto L5;
    L7:
        int r0 = 2;
    L8:
        this.mTargetActivityType = r0;
        return;
    L5:
        if (recentsComponent.equals(targetIntent.getComponent()) == false) goto L7;
        r0 = 3;
        goto L8
    }

    void preloadRecentsActivity() {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_RECENTS_ANIMATIONS_enabled[0] == false) goto L5;
        String protoLogParam0 = String.valueOf(this.mTargetIntent);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS, -3758280623533049031L, 0, new Object[]{protoLogParam0});
    L5:
        Task targetRootTask = this.mDefaultTaskDisplayArea.getRootTask(0, this.mTargetActivityType);
        ActivityRecord targetActivity = getTargetActivity(targetRootTask);
        if (targetActivity == null) goto L23;
        if (targetActivity.attachedToProcess() == false) goto L30;
        if (targetActivity.isVisibleRequested() == false) goto L12;
        return;
    L12:
        if (targetActivity.isTopRunningActivity() == false) goto L15;
        return;
    L15:
        if (targetActivity.app.getCurrentProcState() < 16) goto L18;
        Slog.v(TAG, "Skip preload recents for cached proc " + targetActivity.app);
        return;
    L18:
        targetActivity.ensureActivityConfiguration(true);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_RECENTS_ANIMATIONS_enabled[0] == false) goto L30;
        String protoLogParam1 = String.valueOf(targetActivity.getConfiguration());
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS, -3365656764099317101L, 0, new Object[]{protoLogParam1});
    L30:
        if (targetActivity.attachedToProcess() == true) goto L38;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_RECENTS_ANIMATIONS_enabled[0] == false) goto L34;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS, -7165162073742035900L, 0, null);
    L34:
        this.mTaskSupervisor.startSpecificActivity(targetActivity, false, false);
        if (targetActivity.getDisplayContent() == null) goto L38;
        targetActivity.getDisplayContent().mUnknownAppVisibilityController.appRemovedOrHidden(targetActivity);
    L38:
        if (targetActivity.finishing == false) goto L40;
        return;
    L40:
        if (targetActivity.isAttached() == true) goto L42;
        return;
    L42:
        if (targetActivity.isState(ActivityRecord.State.STOPPING, ActivityRecord.State.STOPPED) == true) goto L48;
        targetActivity.addToStopping(true, true, "preloadRecents");
        return;
    L48:
        return;
    L23:
        if (this.mDefaultTaskDisplayArea.getActivity(new RecentsAnimation$$ExternalSyntheticLambda1(), false) != null) goto L25;
        return;
    L25:
        startRecentsActivityInBackground("preloadRecents");
        Task targetRootTask2 = this.mDefaultTaskDisplayArea.getRootTask(0, this.mTargetActivityType);
        targetActivity = getTargetActivity(targetRootTask2);
        if (targetActivity != null) goto L30;
        Slog.w(TAG, "Cannot start " + this.mTargetIntent);
    }

    private void startRecentsActivityInBackground(String reason) {
        ActivityOptions options = ActivityOptions.makeBasic();
        options.setLaunchActivityType(this.mTargetActivityType);
        options.setAvoidMoveToFront();
        this.mTargetIntent.addFlags(268500992);
        this.mActivityStartController.obtainStarter(this.mTargetIntent, reason).setCallingUid(this.mRecentsUid).setCallingPackage(this.mRecentsComponent.getPackageName()).setCallingFeatureId(this.mRecentsFeatureId).setActivityOptions(new SafeActivityOptions(options, Binder.getCallingPid(), Binder.getCallingUid())).setUserId(this.mUserId).execute();
    }

    private ActivityRecord getTargetActivity(Task targetRootTask) {
        if (targetRootTask != null) goto L5;
        return null;
    L5:
        PooledPredicate p = PooledLambda.obtainPredicate(new RecentsAnimation$$ExternalSyntheticLambda0(), this, PooledLambda.__(Task.class));
        Task task = targetRootTask.getTask(p);
        p.recycle();
        if (task != null) goto L8;
        return null;
    L8:
        return task.getTopNonFinishingActivity();
    }

    private boolean matchesTarget(Task task) {
        if (task.getNonFinishingActivityCount() > 0) goto L5;
    L9:
        return false;
    L5:
        if (task.mUserId != this.mUserId) goto L9;
        if (task.getBaseIntent().getComponent().equals(this.mTargetIntent.getComponent()) == false) goto L9;
        return true;
    }
}
