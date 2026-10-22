package com.android.server.wm;

import android.app.ActivityOptions;
import android.os.Debug;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
class ResetTargetTaskHelper implements Consumer<Task>, Predicate<ActivityRecord> {
    private int mActivityReparentPosition;
    private ArrayList<ActivityRecord> mAllActivities;
    private boolean mCanMoveOptions;
    private boolean mForceReset;
    private boolean mIsTargetTask;
    private ArrayList<ActivityRecord> mPendingReparentActivities;
    private ArrayList<ActivityRecord> mResultActivities;
    private ActivityRecord mRoot;
    private Task mTargetRootTask;
    private Task mTargetTask;
    private boolean mTargetTaskFound;
    private Task mTask;
    private ActivityOptions mTopOptions;

    ResetTargetTaskHelper() {
        this.mResultActivities = new ArrayList();
        this.mAllActivities = new ArrayList();
        this.mPendingReparentActivities = new ArrayList();
    }

    @Override // java.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(Task r1) {
        accept2(r1);
    }

    @Override // java.util.function.Predicate
    public /* bridge */ /* synthetic */ boolean test(ActivityRecord r1) {
        return test2(r1);
    }

    private void reset(Task task) {
        this.mTask = task;
        this.mRoot = null;
        this.mCanMoveOptions = true;
        this.mTopOptions = null;
        this.mResultActivities.clear();
        this.mAllActivities.clear();
    }

    ActivityOptions process(Task targetTask, boolean forceReset) {
        this.mForceReset = forceReset;
        this.mTargetTask = targetTask;
        this.mTargetTaskFound = false;
        this.mTargetRootTask = targetTask.getRootTask();
        this.mActivityReparentPosition = -1;
        targetTask.mWmService.mRoot.forAllLeafTasks(this, true);
        processPendingReparentActivities();
        reset(null);
        return this.mTopOptions;
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Task task) {
        reset(task);
        this.mRoot = task.getRootActivity(true);
        if (this.mRoot != null) goto L6;
        return;
    L6:
        if (task != this.mTargetTask) goto L8;
        boolean r1 = true;
    L9:
        this.mIsTargetTask = r1;
        if (this.mIsTargetTask == false) goto L12;
        this.mTargetTaskFound = true;
    L12:
        task.forAllActivities(this);
        return;
    L8:
        r1 = false;
        goto L9
    }

    /* JADX INFO: renamed from: test, reason: avoid collision after fix types in other method */
    public boolean test2(ActivityRecord r) {
        if (r != this.mRoot) goto L5;
        return true;
    L5:
        this.mAllActivities.add(r);
        int flags = r.info.flags;
        if ((flags & 2) == 0) goto L8;
        boolean finishOnTaskLaunch = true;
    L10:
        if ((flags & 64) == 0) goto L12;
        boolean allowTaskReparenting = true;
    L14:
        if ((r.intent.getFlags() & 524288) == 0) goto L16;
        boolean clearWhenTaskReset = true;
    L18:
        if (this.mIsTargetTask == false) goto L45;
        if (finishOnTaskLaunch == true) goto L33;
        if (clearWhenTaskReset == true) goto L33;
        if (r.resultTo == null) goto L25;
        this.mResultActivities.add(r);
        return false;
    L25:
        if (allowTaskReparenting == false) goto L33;
        if (r.taskAffinity == null) goto L33;
        if (r.taskAffinity.equals(this.mTask.affinity) == true) goto L33;
        this.mPendingReparentActivities.add(r);
        return false;
    L33:
        if (this.mForceReset == true) goto L39;
        if (finishOnTaskLaunch == true) goto L39;
        if (clearWhenTaskReset == true) goto L39;
        this.mResultActivities.clear();
        return false;
    L39:
        if (clearWhenTaskReset == false) goto L41;
        finishActivities(this.mAllActivities, "clearWhenTaskReset");
    L42:
        this.mResultActivities.clear();
        return false;
    L41:
        this.mResultActivities.add(r);
        finishActivities(this.mResultActivities, "reset-task");
        goto L42
    L45:
        if (r.resultTo == null) goto L49;
        this.mResultActivities.add(r);
        return false;
    L49:
        if (this.mTargetTaskFound == false) goto L76;
        if (allowTaskReparenting == false) goto L76;
        if (this.mTargetTask.affinity == null) goto L76;
        if (this.mTargetTask.mUserId != r.mUserId) goto L76;
        if (this.mTargetTask.affinity.equals(r.taskAffinity) == false) goto L76;
        this.mResultActivities.add(r);
        if (this.mForceReset == true) goto L72;
        if (finishOnTaskLaunch == true) goto L72;
        if (this.mActivityReparentPosition != (-1)) goto L64;
        this.mActivityReparentPosition = this.mTargetTask.getChildCount();
    L64:
        processResultActivities(r, this.mTargetTask, this.mActivityReparentPosition, false, false);
        if (r.info.launchMode != 1) goto L76;
        ActivityRecord p = this.mTargetTask.getActivityBelow(r);
        if (p == null) goto L76;
        if (p.intent.getComponent().equals(r.intent.getComponent()) == false) goto L76;
        p.finishIfPossible("replace", false);
    L72:
        finishActivities(this.mResultActivities, "move-affinity");
        return false;
    L76:
        return false;
    L16:
        clearWhenTaskReset = false;
        goto L18
    L12:
        allowTaskReparenting = false;
        goto L14
    L8:
        finishOnTaskLaunch = false;
        goto L10
    }

    private void finishActivities(ArrayList<ActivityRecord> activities, String reason) {
        boolean noOptions = this.mCanMoveOptions;
    L4:
        if (activities.isEmpty() == true) goto L12;
        ActivityRecord p = activities.remove(0);
        if (p.finishing == true) goto L4;
        noOptions = takeOption(p, noOptions);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[3] == false) goto L11;
        String protoLogParam0 = String.valueOf(p);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_TASKS, -4617490621756721600L, 0, new Object[]{protoLogParam0});
    L11:
        p.finishIfPossible(reason, false);
        goto L4
    }

    private void processResultActivities(ActivityRecord target, Task targetTask, int position, boolean ignoreFinishing, boolean takeOptions) {
        boolean noOptions = this.mCanMoveOptions;
    L4:
        if (this.mResultActivities.isEmpty() == true) goto L19;
        ActivityRecord p = this.mResultActivities.remove(0);
        if (ignoreFinishing == false) goto L10;
        if (p.finishing == true) goto L4;
    L10:
        if (takeOptions == false) goto L13;
        noOptions = takeOption(p, noOptions);
    L13:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[2] == false) goto L16;
        String protoLogParam0 = String.valueOf(p);
        String protoLogParam1 = String.valueOf(this.mTask);
        String protoLogParam2 = String.valueOf(targetTask);
        String protoLogParam3 = String.valueOf(Debug.getCallers(4));
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 3361857745281957526L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2, protoLogParam3});
    L16:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[1] == false) goto L18;
        String protoLogParam4 = String.valueOf(p);
        String protoLogParam5 = String.valueOf(target);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TASKS, 3958829063955690349L, 0, new Object[]{protoLogParam4, protoLogParam5});
    L18:
        p.reparent(targetTask, position, "resetTargetTaskIfNeeded");
        goto L4
    }

    private void processPendingReparentActivities() {
        if (this.mPendingReparentActivities.isEmpty() == false) goto L5;
        return;
    L5:
        ActivityTaskManagerService atmService = this.mTargetRootTask.mAtmService;
        TaskDisplayArea taskDisplayArea = this.mTargetRootTask.getDisplayArea();
        int windowingMode = this.mTargetRootTask.getWindowingMode();
        int activityType = this.mTargetRootTask.getActivityType();
    L7:
        if (this.mPendingReparentActivities.isEmpty() == true) goto L25;
        ActivityRecord r = this.mPendingReparentActivities.remove(0);
        boolean alwaysCreateTask = DisplayContent.alwaysCreateRootTask(windowingMode, activityType);
        if (alwaysCreateTask == false) goto L11;
        Task task = taskDisplayArea.getBottomMostTask();
    L12:
        Task targetTask = null;
        if (task != null) goto L15;
    L19:
        if (targetTask != null) goto L24;
        if (alwaysCreateTask == false) goto L22;
        targetTask = taskDisplayArea.getOrCreateRootTask(windowingMode, activityType, false);
    L23:
        targetTask.affinityIntent = r.intent;
        goto L24
    L22:
        targetTask = this.mTargetRootTask.reuseOrCreateTask(r.info, null, false);
    L24:
        r.reparent(targetTask, 0, "resetTargetTaskIfNeeded");
        atmService.mTaskSupervisor.mRecentTasks.add(targetTask);
        goto L7
    L15:
        if (r.taskAffinity.equals(task.affinity) == false) goto L19;
        targetTask = task;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[1] == false) goto L19;
        String protoLogParam0 = String.valueOf(r);
        String protoLogParam1 = String.valueOf(targetTask);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TASKS, 1730793580703791926L, 0, new Object[]{protoLogParam0, protoLogParam1});
        goto L19
    L11:
        task = this.mTargetRootTask.getBottomMostTask();
        goto L12
    }

    private boolean takeOption(ActivityRecord p, boolean noOptions) {
        this.mCanMoveOptions = false;
        if (noOptions == true) goto L5;
        return noOptions;
    L5:
        if (this.mTopOptions != null) goto L11;
        this.mTopOptions = p.getOptions();
        if (this.mTopOptions == null) goto L12;
        p.clearOptionsAnimation();
        return false;
    L12:
        return noOptions;
    L11:
        return noOptions;
    }
}
