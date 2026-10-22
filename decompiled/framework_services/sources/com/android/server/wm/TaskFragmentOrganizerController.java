package com.android.server.wm;

import android.app.IApplicationThread;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.view.RemoteAnimationDefinition;
import android.window.ITaskFragmentOrganizer;
import android.window.ITaskFragmentOrganizerController;
import android.window.RemoteTransition;
import android.window.TaskFragmentInfo;
import android.window.TaskFragmentOrganizer;
import android.window.TaskFragmentParentInfo;
import android.window.TaskFragmentTransaction;
import android.window.WindowContainerTransaction;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.SysOptBridge;
import com.android.server.am.IApplicationFreezer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TaskFragmentOrganizerController extends ITaskFragmentOrganizerController.Stub {
    private static final String TAG = "TaskFragmentOrganizerController";
    private static final long TEMPORARY_ACTIVITY_TOKEN_TIMEOUT_MS = 5000;
    private final ActivityTaskManagerService mAtmService;
    private final ArrayList<TaskFragmentOrganizerState> mCachedTaskFragmentOrganizerStates;
    private final WindowManagerGlobalLock mGlobalLock;
    private final ArrayMap<IBinder, List<PendingTaskFragmentEvent>> mPendingTaskFragmentEvents;
    private final ArrayMap<IBinder, TaskFragmentOrganizerState> mTaskFragmentOrganizerState;
    private final ArraySet<Task> mTmpTaskSet;
    private final WindowOrganizerController mWindowOrganizerController;

    private static class PendingTaskFragmentEvent {
        static final int EVENT_ACTIVITY_REPARENTED_TO_TASK = 5;
        static final int EVENT_APPEARED = 0;
        static final int EVENT_ERROR = 4;
        static final int EVENT_INFO_CHANGED = 2;
        static final int EVENT_PARENT_INFO_CHANGED = 3;
        static final int EVENT_VANISHED = 1;
        private final ActivityRecord mActivity;
        private long mDeferTime;
        private final IBinder mErrorCallbackToken;
        private final int mEventType;
        private final Throwable mException;
        private int mOpType;
        private final ActivityRecord mOtherActivity;
        private final Task mTask;
        private final TaskFragment mTaskFragment;
        private final ITaskFragmentOrganizer mTaskFragmentOrg;
        private final IBinder mTaskFragmentToken;

        private static class Builder {
            private ActivityRecord mActivity;
            private IBinder mErrorCallbackToken;
            private final int mEventType;
            private Throwable mException;
            private int mOpType;
            private ActivityRecord mOtherActivity;
            private Task mTask;
            private TaskFragment mTaskFragment;
            private final ITaskFragmentOrganizer mTaskFragmentOrg;
            private IBinder mTaskFragmentToken;

            Builder(int eventType, ITaskFragmentOrganizer taskFragmentOrg) {
                this.mEventType = eventType;
                taskFragmentOrg.getClass();
                this.mTaskFragmentOrg = taskFragmentOrg;
            }

            Builder setTaskFragment(TaskFragment taskFragment) {
                this.mTaskFragment = taskFragment;
                return this;
            }

            Builder setTaskFragmentToken(IBinder fragmentToken) {
                this.mTaskFragmentToken = fragmentToken;
                return this;
            }

            Builder setErrorCallbackToken(IBinder errorCallbackToken) {
                this.mErrorCallbackToken = errorCallbackToken;
                return this;
            }

            Builder setException(Throwable exception) {
                exception.getClass();
                this.mException = exception;
                return this;
            }

            Builder setActivity(ActivityRecord activity) {
                activity.getClass();
                this.mActivity = activity;
                return this;
            }

            Builder setOtherActivity(ActivityRecord otherActivity) {
                this.mOtherActivity = otherActivity;
                return this;
            }

            Builder setTask(Task task) {
                task.getClass();
                this.mTask = task;
                return this;
            }

            Builder setOpType(int opType) {
                this.mOpType = opType;
                return this;
            }

            PendingTaskFragmentEvent build() {
                return new PendingTaskFragmentEvent(this.mEventType, this.mTaskFragmentOrg, this.mTaskFragment, this.mTaskFragmentToken, this.mErrorCallbackToken, this.mException, this.mActivity, this.mOtherActivity, this.mTask, this.mOpType, null);
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface EventType {
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ ActivityRecord m10276$$Nest$fgetmActivity(PendingTaskFragmentEvent r0) {
            return r0.mActivity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDeferTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m10277$$Nest$fgetmDeferTime(PendingTaskFragmentEvent r2) {
            return r2.mDeferTime;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmErrorCallbackToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m10278$$Nest$fgetmErrorCallbackToken(PendingTaskFragmentEvent r0) {
            return r0.mErrorCallbackToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEventType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10279$$Nest$fgetmEventType(PendingTaskFragmentEvent r0) {
            return r0.mEventType;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmException, reason: not valid java name */
        static /* bridge */ /* synthetic */ Throwable m10280$$Nest$fgetmException(PendingTaskFragmentEvent r0) {
            return r0.mException;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOpType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10281$$Nest$fgetmOpType(PendingTaskFragmentEvent r0) {
            return r0.mOpType;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOtherActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ ActivityRecord m10282$$Nest$fgetmOtherActivity(PendingTaskFragmentEvent r0) {
            return r0.mOtherActivity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTask, reason: not valid java name */
        static /* bridge */ /* synthetic */ Task m10283$$Nest$fgetmTask(PendingTaskFragmentEvent r0) {
            return r0.mTask;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTaskFragment, reason: not valid java name */
        static /* bridge */ /* synthetic */ TaskFragment m10284$$Nest$fgetmTaskFragment(PendingTaskFragmentEvent r0) {
            return r0.mTaskFragment;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTaskFragmentOrg, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITaskFragmentOrganizer m10285$$Nest$fgetmTaskFragmentOrg(PendingTaskFragmentEvent r0) {
            return r0.mTaskFragmentOrg;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTaskFragmentToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m10286$$Nest$fgetmTaskFragmentToken(PendingTaskFragmentEvent r0) {
            return r0.mTaskFragmentToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDeferTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10287$$Nest$fputmDeferTime(PendingTaskFragmentEvent r0, long r1) {
            r0.mDeferTime = r1;
        }

        /* synthetic */ PendingTaskFragmentEvent(int r1, ITaskFragmentOrganizer r2, TaskFragment r3, IBinder r4, IBinder r5, Throwable r6, ActivityRecord r7, ActivityRecord r8, Task r9, int r10, TaskFragmentOrganizerControllerIA r11) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        }

        private PendingTaskFragmentEvent(int eventType, ITaskFragmentOrganizer taskFragmentOrg, TaskFragment taskFragment, IBinder taskFragmentToken, IBinder errorCallbackToken, Throwable exception, ActivityRecord activity, ActivityRecord otherActivity, Task task, int opType) {
            this.mEventType = eventType;
            this.mTaskFragmentOrg = taskFragmentOrg;
            this.mTaskFragment = taskFragment;
            this.mTaskFragmentToken = taskFragmentToken;
            this.mErrorCallbackToken = errorCallbackToken;
            this.mException = exception;
            this.mActivity = activity;
            this.mOtherActivity = otherActivity;
            this.mTask = task;
            this.mOpType = opType;
        }

        boolean isLifecycleEvent() {
            switch(this.mEventType) {
                case 0: goto L6;
                case 1: goto L6;
                case 2: goto L6;
                case 3: goto L6;
                default: goto L4;
            };
        L4:
            return false;
        L6:
            return true;
        }
    }

    private class TaskFragmentOrganizerState implements IBinder.DeathRecipient {
        private IApplicationThread mAppThread;
        private final ArrayMap<IBinder, Integer> mDeferredTransitions;
        private final ArrayMap<IBinder, Transition.ReadyCondition> mInFlightTransactions;
        private final boolean mIsSystemOrganizer;
        private final Map<TaskFragment, TaskFragmentInfo> mLastSentTaskFragmentInfos;
        private final SparseArray<TaskFragmentParentInfo> mLastSentTaskFragmentParentInfos;
        private final ArrayList<TaskFragment> mOrganizedTaskFragments;
        private ITaskFragmentOrganizer mOrganizer;
        private int mOrganizerPid;
        private String mOrganizerPkg;
        private final int mOrganizerUid;
        private RemoteAnimationDefinition mRemoteAnimationDefinition;
        private Bundle mSavedState;
        private final Map<TaskFragment, Integer> mTaskFragmentTaskIds;
        private final Map<IBinder, ActivityRecord> mTemporaryActivityTokens;
        final /* synthetic */ TaskFragmentOrganizerController this$0;

        public static /* synthetic */ void $r8$lambda$9DGsa2Tcl0rm635KkPsfSFGIwVI(TaskFragmentOrganizerState r0, IBinder r1) {
            r0.lambda$prepareActivityReparentedToTask$1(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$NPy909oF-N4zszIX8FvRY3S_Mp4, reason: not valid java name */
        public static /* synthetic */ boolean m10288$r8$lambda$NPy909oFN4zszIX8FvRY3S_Mp4(ActivityRecord r0) {
            return lambda$dispose$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInFlightTransactions, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m10289$$Nest$fgetmInFlightTransactions(TaskFragmentOrganizerState r0) {
            return r0.mInFlightTransactions;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsSystemOrganizer, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10290$$Nest$fgetmIsSystemOrganizer(TaskFragmentOrganizerState r0) {
            return r0.mIsSystemOrganizer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastSentTaskFragmentInfos, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m10291$$Nest$fgetmLastSentTaskFragmentInfos(TaskFragmentOrganizerState r0) {
            return r0.mLastSentTaskFragmentInfos;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastSentTaskFragmentParentInfos, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m10292$$Nest$fgetmLastSentTaskFragmentParentInfos(TaskFragmentOrganizerState r0) {
            return r0.mLastSentTaskFragmentParentInfos;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOrganizedTaskFragments, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayList m10293$$Nest$fgetmOrganizedTaskFragments(TaskFragmentOrganizerState r0) {
            return r0.mOrganizedTaskFragments;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOrganizer, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITaskFragmentOrganizer m10294$$Nest$fgetmOrganizer(TaskFragmentOrganizerState r0) {
            return r0.mOrganizer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOrganizerUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10295$$Nest$fgetmOrganizerUid(TaskFragmentOrganizerState r0) {
            return r0.mOrganizerUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRemoteAnimationDefinition, reason: not valid java name */
        static /* bridge */ /* synthetic */ RemoteAnimationDefinition m10296$$Nest$fgetmRemoteAnimationDefinition(TaskFragmentOrganizerState r0) {
            return r0.mRemoteAnimationDefinition;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSavedState, reason: not valid java name */
        static /* bridge */ /* synthetic */ Bundle m10297$$Nest$fgetmSavedState(TaskFragmentOrganizerState r0) {
            return r0.mSavedState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTemporaryActivityTokens, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m10298$$Nest$fgetmTemporaryActivityTokens(TaskFragmentOrganizerState r0) {
            return r0.mTemporaryActivityTokens;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmRemoteAnimationDefinition, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10299$$Nest$fputmRemoteAnimationDefinition(TaskFragmentOrganizerState r0, RemoteAnimationDefinition r1) {
            r0.mRemoteAnimationDefinition = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmSavedState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10300$$Nest$fputmSavedState(TaskFragmentOrganizerState r0, Bundle r1) {
            r0.mSavedState = r1;
        }

        TaskFragmentOrganizerState(TaskFragmentOrganizerController r4, ITaskFragmentOrganizer organizer, int pid, int uid, boolean isSystemOrganizer) {
            this.this$0 = r4;
            this.mOrganizedTaskFragments = new ArrayList();
            this.mLastSentTaskFragmentInfos = new WeakHashMap();
            this.mTaskFragmentTaskIds = new WeakHashMap();
            this.mLastSentTaskFragmentParentInfos = new SparseArray();
            this.mTemporaryActivityTokens = new WeakHashMap();
            this.mDeferredTransitions = new ArrayMap();
            this.mInFlightTransactions = new ArrayMap();
            this.mAppThread = r4.getAppThread(pid, uid);
            this.mOrganizer = organizer;
            this.mOrganizerPid = pid;
            this.mOrganizerUid = uid;
            this.mIsSystemOrganizer = isSystemOrganizer;
            WindowProcessController wpc = TaskFragmentOrganizerController.m10271$$Nest$fgetmAtmService(r4).mProcessMap.getProcess(pid);
            if (wpc != null) goto L5;
        L7:
            String r0 = null;
        L8:
            this.mOrganizerPkg = r0;
            this.mOrganizer.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L11
            return;
        L12:
            Slog.e(TaskFragmentOrganizerController.TAG, "TaskFragmentOrganizer failed to register death recipient");
            return;
        L5:
            if (wpc.mInfo == null) goto L7;
            r0 = wpc.mInfo.packageName;
            goto L8
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            WindowManagerGlobalLock r0 = TaskFragmentOrganizerController.m10272$$Nest$fgetmGlobalLock(this.this$0);
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            TaskFragmentOrganizerController.m10274$$Nest$mremoveOrganizer(this.this$0, this.mOrganizer, "client died");     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        void restore(ITaskFragmentOrganizer organizer, int pid) {
            this.mOrganizer = organizer;
            this.mOrganizerPid = pid;
            this.mAppThread = this.this$0.getAppThread(pid, this.mOrganizerUid);
            int i = this.mOrganizedTaskFragments.size() - 1;
        L3:
            if (i < 0) goto L17;
            TaskFragment taskFragment = this.mOrganizedTaskFragments.get(i);
            if (taskFragment.isAttached() == true) goto L7;
        L9:
            this.mOrganizedTaskFragments.remove(taskFragment);
        L10:
            i = i - 1;
            goto L3
        L7:
            if (taskFragment.getTopNonFinishingActivity() == null) goto L9;
            taskFragment.onTaskFragmentOrganizerRestarted(organizer);
            goto L10
        L17:
            this.mOrganizer.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L14
            return;
        L15:
            Slog.e(TaskFragmentOrganizerController.TAG, "TaskFragmentOrganizer failed to register death recipient");
        }

        boolean hasSavedState() {
            if (this.mSavedState != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mSavedState.isEmpty() == true) goto L7;
            return true;
        }

        boolean addTaskFragment(TaskFragment taskFragment) {
            if (taskFragment.mTaskFragmentAppearedSent == false) goto L6;
            return false;
        L6:
            if (this.mOrganizedTaskFragments.contains(taskFragment) == false) goto L8;
            return false;
        L8:
            this.mOrganizedTaskFragments.add(taskFragment);
            return true;
        }

        void removeTaskFragment(TaskFragment taskFragment) {
            this.mOrganizedTaskFragments.remove(taskFragment);
        }

        void dispose(String reason) {
            boolean wasVisible = false;
            int i = this.mOrganizedTaskFragments.size() - 1;
        L3:
            if (i < 0) goto L8;
            TaskFragment taskFragment = this.mOrganizedTaskFragments.get(i);
            if (taskFragment.isVisibleRequested() == false) goto L7;
            wasVisible = true;
        L7:
            taskFragment.onTaskFragmentOrganizerRemoved();
            i = i - 1;
            goto L3
        L8:
            TransitionController transitionController = TaskFragmentOrganizerController.m10271$$Nest$fgetmAtmService(this.this$0).getTransitionController();
            if (wasVisible == true) goto L11;
        L25:
            TaskFragmentOrganizerController.m10271$$Nest$fgetmAtmService(this.this$0).deferWindowLayout();
            boolean haveSavedState = hasSavedState();     // Catch: Throwable -> L33
            int i2 = this.mOrganizedTaskFragments.size() - 1;     // Catch: Throwable -> L33
        L27:
            if (i2 < 0) goto L37;
            TaskFragment taskFragment2 = this.mOrganizedTaskFragments.get(i2);     // Catch: Throwable -> L33
            if (haveSavedState == false) goto L35;
            if (taskFragment2.hasChild() == false) goto L35;
        L36:
            i2 = i2 - 1;
        L35:
            this.mOrganizedTaskFragments.remove(i2);     // Catch: Throwable -> L33
            taskFragment2.removeImmediately();     // Catch: Throwable -> L33
            goto L36
        L37:
            TaskFragmentOrganizerController.m10271$$Nest$fgetmAtmService(this.this$0).continueWindowLayout();
            int i3 = this.mDeferredTransitions.size() - 1;
        L38:
            if (i3 < 0) goto L40;
            onTransactionFinished(this.mDeferredTransitions.keyAt(i3));
            i3 = i3 - 1;
            goto L38
        L40:
            int i4 = this.mInFlightTransactions.size() - 1;
        L41:
            if (i4 < 0) goto L43;
            this.mInFlightTransactions.valueAt(i4).meetAlternate("disposed(" + reason + ")");
            i4 = i4 + (-1);
            goto L41
        L43:
            this.mOrganizer.asBinder().unlinkToDeath(this, 0);
            return;
        L33:
            th = move-exception;
            TaskFragmentOrganizerController.m10271$$Nest$fgetmAtmService(this.this$0).continueWindowLayout();
            throw th;
        L11:
            if (transitionController.isShellTransitionsEnabled() == false) goto L25;
            if (transitionController.isCollecting() == true) goto L25;
            Task task = this.mOrganizedTaskFragments.get(0).getTask();
            if (task != null) goto L17;
        L19:
            boolean containsNonEmbeddedActivity = false;
        L20:
            Transition r6 = transitionController.createTransition(2);
            if (containsNonEmbeddedActivity == false) goto L23;
            Task r8 = null;
        L24:
            transitionController.requestStartTransition(r6, r8, null, null);
            goto L25
        L23:
            r8 = task;
            goto L24
        L17:
            if (task.getActivity(new TaskFragmentOrganizerController$TaskFragmentOrganizerState$$ExternalSyntheticLambda0()) == null) goto L19;
            containsNonEmbeddedActivity = true;
            goto L20
        }

        private static /* synthetic */ boolean lambda$dispose$0(ActivityRecord a) {
            return !a.isEmbedded();
        }

        TaskFragmentTransaction.Change prepareTaskFragmentAppeared(TaskFragment tf) {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L5;
            String protoLogParam0 = String.valueOf(tf.getName());
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -2808577027789344626L, 0, new Object[]{protoLogParam0});
        L5:
            TaskFragmentInfo info = tf.getTaskFragmentInfo();
            int taskId = tf.getTask().mTaskId;
            tf.mTaskFragmentAppearedSent = true;
            this.mLastSentTaskFragmentInfos.put(tf, info);
            this.mTaskFragmentTaskIds.put(tf, Integer.valueOf(taskId));
            TaskFragmentTransaction.Change change = new TaskFragmentTransaction.Change(1).setTaskFragmentToken(tf.getFragmentToken()).setTaskFragmentInfo(info).setTaskId(taskId);
            if (this.mIsSystemOrganizer == false) goto L8;
            change.setTaskFragmentSurfaceControl(tf.getSurfaceControl());
        L8:
            return change;
        }

        TaskFragmentTransaction.Change prepareTaskFragmentVanished(TaskFragment tf) {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L5;
            String protoLogParam0 = String.valueOf(tf.getName());
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -3582112419663037270L, 0, new Object[]{protoLogParam0});
        L5:
            tf.mTaskFragmentAppearedSent = false;
            this.mLastSentTaskFragmentInfos.remove(tf);
            if (this.mTaskFragmentTaskIds.containsKey(tf) == false) goto L10;
            int taskId = this.mTaskFragmentTaskIds.remove(tf).intValue();
            if (this.mTaskFragmentTaskIds.containsValue(Integer.valueOf(taskId)) == true) goto L12;
            this.mLastSentTaskFragmentParentInfos.remove(taskId);
        L12:
            return new TaskFragmentTransaction.Change(3).setTaskFragmentToken(tf.getFragmentToken()).setTaskFragmentInfo(tf.getTaskFragmentInfo()).setTaskId(taskId);
        L10:
            taskId = -1;
            goto L12
        }

        TaskFragmentTransaction.Change prepareTaskFragmentInfoChanged(TaskFragment tf) {
            TaskFragmentInfo info = tf.getTaskFragmentInfo();
            TaskFragmentInfo lastInfo = this.mLastSentTaskFragmentInfos.get(tf);
            int configurationChangeMask = tf.getConfigurationChangeMaskForOrganizer();
            if (info.equalsForTaskFragmentOrganizer(lastInfo) == false) goto L9;
            if (WindowOrganizerController.configurationsAreEqualForOrganizer(info.getConfiguration(), lastInfo.getConfiguration(), configurationChangeMask) == false) goto L9;
            return null;
        L9:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L11;
            String protoLogParam0 = String.valueOf(tf.getName());
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 3294593748816836746L, 0, new Object[]{protoLogParam0});
        L11:
            this.mLastSentTaskFragmentInfos.put(tf, info);
            return new TaskFragmentTransaction.Change(2).setTaskFragmentToken(tf.getFragmentToken()).setTaskFragmentInfo(info).setTaskId(tf.getTask().mTaskId);
        }

        TaskFragmentTransaction.Change prepareTaskFragmentParentInfoChanged(Task task) {
            int taskId = task.mTaskId;
            TaskFragmentParentInfo parentInfo = task.getTaskFragmentParentInfo();
            TaskFragmentParentInfo lastParentInfo = this.mLastSentTaskFragmentParentInfos.get(taskId);
            if (lastParentInfo == null) goto L5;
            Configuration lastParentConfig = lastParentInfo.getConfiguration();
        L7:
            if (parentInfo.equalsForTaskFragmentOrganizer(lastParentInfo) == false) goto L12;
            if (WindowOrganizerController.configurationsAreEqualForOrganizer(parentInfo.getConfiguration(), lastParentConfig) == false) goto L12;
            return null;
        L12:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L14;
            String protoLogParam0 = String.valueOf(task.getName());
            long protoLogParam1 = taskId;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 5007230330523630579L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
        L14:
            this.mLastSentTaskFragmentParentInfos.put(taskId, new TaskFragmentParentInfo(parentInfo));
            return new TaskFragmentTransaction.Change(4).setTaskId(taskId).setTaskFragmentParentInfo(parentInfo);
        L5:
            lastParentConfig = null;
            goto L7
        }

        TaskFragmentTransaction.Change prepareTaskFragmentError(IBinder errorCallbackToken, TaskFragment taskFragment, int opType, Throwable exception) {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L5;
            String protoLogParam0 = String.valueOf(exception.toString());
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 6475066005515810081L, 0, new Object[]{protoLogParam0});
        L5:
            if (taskFragment == null) goto L7;
            TaskFragmentInfo info = taskFragment.getTaskFragmentInfo();
        L8:
            Bundle errorBundle = TaskFragmentOrganizer.putErrorInfoInBundle(exception, info, opType);
            return new TaskFragmentTransaction.Change(5).setErrorCallbackToken(errorCallbackToken).setErrorBundle(errorBundle);
        L7:
            info = null;
            goto L8
        }

        TaskFragmentTransaction.Change prepareActivityReparentedToTask(ActivityRecord activity, ActivityRecord nextFillTaskActivity, IBinder lastParentTfToken) {
            if (activity.finishing == false) goto L6;
            Slog.d(TaskFragmentOrganizerController.TAG, "Reparent activity=" + activity.token + " is finishing");
            return null;
        L6:
            Task task = activity.getTask();
            if (task != null) goto L9;
        L40:
            Slog.d(TaskFragmentOrganizerController.TAG, "Reparent activity=" + activity.token + " is not in a task belong to the organizer app.");
            return null;
        L9:
            if (task.effectiveUid != this.mOrganizerUid) goto L40;
            if (task.isAllowedToEmbedActivity(activity, this.mOrganizerUid) == 0) goto L16;
            Slog.d(TaskFragmentOrganizerController.TAG, "Reparent activity=" + activity.token + " is not allowed to be embedded.");
            return null;
        L16:
            if (task.isAllowedToEmbedActivityInTrustedMode(activity, this.mOrganizerUid) == true) goto L22;
            if (activity.isUntrustedEmbeddingStateSharingAllowed() == true) goto L22;
            Slog.d(TaskFragmentOrganizerController.TAG, "Reparent activity=" + activity.token + " is not allowed to be shared with untrusted host.");
            return null;
        L22:
            if (activity.getPid() == this.mOrganizerPid) goto L24;
        L26:
            final IBinder activityToken = new Binder("TemporaryActivityToken");
            this.mTemporaryActivityTokens.put(activityToken, activity);
            Runnable timeout = new TaskFragmentOrganizerController$TaskFragmentOrganizerState$$ExternalSyntheticLambda1(this, activityToken);
            TaskFragmentOrganizerController.m10271$$Nest$fgetmAtmService(this.this$0).mWindowManager.mH.postDelayed(timeout, TaskFragmentOrganizerController.TEMPORARY_ACTIVITY_TOKEN_TIMEOUT_MS);
        L28:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L30;
            String protoLogParam0 = String.valueOf(activity.token);
            long protoLogParam1 = task.mTaskId;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -7893265697482064583L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
        L30:
            TaskFragmentTransaction.Change change = new TaskFragmentTransaction.Change(6).setTaskId(task.mTaskId).setActivityIntent(TaskFragmentOrganizerController.m10275$$Nest$smtrimIntent(activity.intent)).setActivityToken(activityToken);
            if (lastParentTfToken == null) goto L33;
            change.setTaskFragmentToken(lastParentTfToken);
        L33:
            if (nextFillTaskActivity != null) goto L35;
        L39:
            return change;
        L35:
            if (nextFillTaskActivity.getPid() != this.mOrganizerPid) goto L39;
            if (nextFillTaskActivity.getUid() != this.mOrganizerUid) goto L39;
            change.setOtherActivityToken(nextFillTaskActivity.token);
            goto L39
        L24:
            if (activity.getUid() != this.mOrganizerUid) goto L26;
            activityToken = activity.token;
            goto L28
        }

        private /* synthetic */ void lambda$prepareActivityReparentedToTask$1(IBinder activityToken) {
            WindowManagerGlobalLock r0 = TaskFragmentOrganizerController.m10272$$Nest$fgetmGlobalLock(this.this$0);
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.mTemporaryActivityTokens.remove(activityToken);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        void dispatchTransaction(TaskFragmentTransaction transaction) {
            if (transaction.isEmpty() == false) goto L21;
            return;
        L21:
        L8:
            e = move-exception;
            Slog.d(TaskFragmentOrganizerController.TAG, "Exception sending TaskFragmentTransaction", e);
            return;
        L6:
            if (this.mOrganizerPkg == null) goto L10;
            SysOptBridge.getFactory().getApplicationFreezer().unfreezeAppIfNeededAsync(null, this.mOrganizerPkg, this.mOrganizerUid, IApplicationFreezer.UnfreezeReason.SCHEDULE_TASK_TRANSACTION, null, null);     // Catch: RemoteException -> L8
        L10:
            this.mAppThread.scheduleTaskFragmentTransaction(this.mOrganizer, transaction);     // Catch: RemoteException -> L8
            if (TaskFragmentOrganizerController.m10273$$Nest$fgetmWindowOrganizerController(this.this$0).getTransitionController().isCollecting() == true) goto L14;
            return;
        L14:
            int transitionId = TaskFragmentOrganizerController.m10273$$Nest$fgetmWindowOrganizerController(this.this$0).getTransitionController().getCollectingTransitionId();
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L17;
            long protoLogParam0 = transitionId;
            String protoLogParam1 = String.valueOf(transaction.getTransactionToken());
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 7048981249808281819L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
        L17:
            this.mDeferredTransitions.put(transaction.getTransactionToken(), Integer.valueOf(transitionId));
            TaskFragmentOrganizerController.m10273$$Nest$fgetmWindowOrganizerController(this.this$0).getTransitionController().deferTransitionReady();
            Transition.ReadyCondition transactionApplied = new Transition.ReadyCondition("task-fragment transaction", transaction);
            TaskFragmentOrganizerController.m10273$$Nest$fgetmWindowOrganizerController(this.this$0).getTransitionController().waitFor(transactionApplied);
            this.mInFlightTransactions.put(transaction.getTransactionToken(), transactionApplied);
        }

        void onTransactionFinished(IBinder transactionToken) {
            if (this.mDeferredTransitions.containsKey(transactionToken) == true) goto L5;
            return;
        L5:
            int transitionId = this.mDeferredTransitions.remove(transactionToken).intValue();
            if (TaskFragmentOrganizerController.m10273$$Nest$fgetmWindowOrganizerController(this.this$0).getTransitionController().isCollecting() == false) goto L16;
            if (TaskFragmentOrganizerController.m10273$$Nest$fgetmWindowOrganizerController(this.this$0).getTransitionController().getCollectingTransitionId() != transitionId) goto L16;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L13;
            long protoLogParam0 = transitionId;
            String protoLogParam1 = String.valueOf(transactionToken);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 7421521217481553621L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
        L13:
            TaskFragmentOrganizerController.m10273$$Nest$fgetmWindowOrganizerController(this.this$0).getTransitionController().continueTransitionReady();
            return;
        L16:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[3] == false) goto L19;
            long protoLogParam2 = transitionId;
            String protoLogParam3 = String.valueOf(transactionToken);
            ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -1315509853595025526L, 1, new Object[]{Long.valueOf(protoLogParam2), protoLogParam3});
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$S-Yr4xWQtkRyuWTVXvrkVC_151I, reason: not valid java name */
    public static /* synthetic */ boolean m10269$r8$lambda$SYr4xWQtkRyuWTVXvrkVC_151I(ActivityRecord r0, IBinder r1, ActivityRecord r2) {
        return lambda$onActivityReparentedToTask$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$_fqy2svTHBcuLgFz_Y9y-MaCUwM, reason: not valid java name */
    public static /* synthetic */ boolean m10270$r8$lambda$_fqy2svTHBcuLgFz_Y9yMaCUwM(TaskFragment[] r0, TaskFragment r1) {
        return lambda$onActivityReparentedToTask$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAtmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerService m10271$$Nest$fgetmAtmService(TaskFragmentOrganizerController r0) {
        return r0.mAtmService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerGlobalLock m10272$$Nest$fgetmGlobalLock(TaskFragmentOrganizerController r0) {
        return r0.mGlobalLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowOrganizerController, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowOrganizerController m10273$$Nest$fgetmWindowOrganizerController(TaskFragmentOrganizerController r0) {
        return r0.mWindowOrganizerController;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveOrganizer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10274$$Nest$mremoveOrganizer(TaskFragmentOrganizerController r0, ITaskFragmentOrganizer r1, String r2) {
        r0.removeOrganizer(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smtrimIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m10275$$Nest$smtrimIntent(Intent r0) {
        return trimIntent(r0);
    }

    TaskFragmentOrganizerController(ActivityTaskManagerService atm, WindowOrganizerController windowOrganizerController) {
        this.mTaskFragmentOrganizerState = new ArrayMap();
        this.mCachedTaskFragmentOrganizerStates = new ArrayList();
        this.mPendingTaskFragmentEvents = new ArrayMap();
        this.mTmpTaskSet = new ArraySet();
        atm.getClass();
        this.mAtmService = atm;
        this.mGlobalLock = atm.mGlobalLock;
        windowOrganizerController.getClass();
        this.mWindowOrganizerController = windowOrganizerController;
    }

    ActivityRecord getReparentActivityFromTemporaryToken(ITaskFragmentOrganizer organizer, IBinder activityToken) {
        if (organizer == null) goto L11;
        if (activityToken == null) goto L11;
        TaskFragmentOrganizerState state = this.mTaskFragmentOrganizerState.get(organizer.asBinder());
        if (state != null) goto L10;
        return null;
    L10:
        return (ActivityRecord) TaskFragmentOrganizerState.m10298$$Nest$fgetmTemporaryActivityTokens(state).remove(activityToken);
    L11:
        return null;
    }

    public void registerOrganizer(ITaskFragmentOrganizer organizer, boolean isSystemOrganizer, Bundle outSavedState) {
        if (isSystemOrganizer == false) goto L4;
        boolean r0 = true;
    L5:
        registerOrganizerInternal(organizer, r0, outSavedState);
        return;
    L4:
        r0 = false;
        goto L5
    }

    private void registerOrganizerInternal(ITaskFragmentOrganizer organizer, boolean isSystemOrganizer, Bundle outSavedState) {
        if (isSystemOrganizer == false) goto L4;
        ActivityTaskManagerService.enforceTaskPermission("registerSystemOrganizer()");
    L4:
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        WindowManagerGlobalLock r7 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r7);
    L9:
        th = th;
    L31:
        monitor-exit(r7);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L7:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L11;
        String protoLogParam0 = String.valueOf(organizer.asBinder());     // Catch: Throwable -> L9
        long protoLogParam1 = uid;
        long protoLogParam2 = pid;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 3509684748201636981L, 20, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L9
    L11:
        if (isOrganizerRegistered(organizer) == true) goto L30;
        if (pid <= 0) goto L28;
        if (restoreFromCachedStateIfPossible(organizer, pid, uid, outSavedState) == false) goto L22;
        monitor-exit(r7);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L22:
        this.mTaskFragmentOrganizerState.put(organizer.asBinder(), new TaskFragmentOrganizerState(this, organizer, pid, uid, isSystemOrganizer));     // Catch: Throwable -> L20
        this.mPendingTaskFragmentEvents.put(organizer.asBinder(), new ArrayList());     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L28:
        throw new IllegalStateException("Cannot register from invalid pid: " + pid);     // Catch: Throwable -> L20
    L30:
        throw new IllegalStateException("Replacing existing organizer currently unsupported");     // Catch: Throwable -> L20
    L20:
        th = th;
        goto L31
    }

    private boolean restoreFromCachedStateIfPossible(ITaskFragmentOrganizer organizer, int pid, int uid, Bundle outSavedState) {
        TaskFragmentOrganizerState cachedState = null;
        int i = this.mCachedTaskFragmentOrganizerStates.size() - 1;
    L3:
        if (i < 0) goto L8;
        TaskFragmentOrganizerState state = this.mCachedTaskFragmentOrganizerStates.get(i);
        if (TaskFragmentOrganizerState.m10295$$Nest$fgetmOrganizerUid(state) == uid) goto L6;
        i = i - 1;
        goto L3
    L6:
        cachedState = state;
    L8:
        if (cachedState != null) goto L11;
        return false;
    L11:
        this.mCachedTaskFragmentOrganizerStates.remove(cachedState);
        cachedState.restore(organizer, pid);
        outSavedState.putAll(TaskFragmentOrganizerState.m10297$$Nest$fgetmSavedState(cachedState));
        ArrayList<? extends Parcelable> r3 = new ArrayList();
        ArrayMap<Integer, Task> tasks = new ArrayMap();
        int fragmentCount = TaskFragmentOrganizerState.m10293$$Nest$fgetmOrganizedTaskFragments(cachedState).size();
        int j = 0;
    L12:
        if (j >= fragmentCount) goto L17;
        TaskFragment tf = (TaskFragment) TaskFragmentOrganizerState.m10293$$Nest$fgetmOrganizedTaskFragments(cachedState).get(j);
        r3.add(tf.getTaskFragmentInfo());
        if (tasks.containsKey(Integer.valueOf(tf.getTask().mTaskId)) == true) goto L16;
        tasks.put(Integer.valueOf(tf.getTask().mTaskId), tf.getTask());
    L16:
        j = j + 1;
        goto L12
    L17:
        outSavedState.putParcelableArrayList("key_restore_task_fragments_info", r3);
        ArrayList<? extends Parcelable> r6 = new ArrayList();
        int j2 = tasks.size() - 1;
    L18:
        if (j2 < 0) goto L20;
        r6.add(tasks.valueAt(j2).getTaskFragmentParentInfo());
        j2 = j2 - 1;
        goto L18
    L20:
        outSavedState.putParcelableArrayList("key_restore_task_fragment_parent_info", r6);
        this.mTaskFragmentOrganizerState.put(organizer.asBinder(), cachedState);
        this.mPendingTaskFragmentEvents.put(organizer.asBinder(), new ArrayList());
        return true;
    }

    public void unregisterOrganizer(ITaskFragmentOrganizer organizer) {
        int pid = Binder.getCallingPid();
        long uid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r7 = this.mGlobalLock;     // Catch: Throwable -> L23
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L23
        monitor-enter(r7);     // Catch: Throwable -> L23
    L8:
        th = th;
    L20:
        monitor-exit(r7);     // Catch: Throwable -> L19
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L12;
        String protoLogParam0 = String.valueOf(organizer.asBinder());     // Catch: Throwable -> L8
        long protoLogParam2 = pid;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -6777461169027010201L, 20, new Object[]{protoLogParam0, Long.valueOf(uid), Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L8
    L12:
        removeOrganizer(organizer, "unregistered");     // Catch: Throwable -> L19
        monitor-exit(r7);     // Catch: Throwable -> L19
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(origId);
        return;
    L17:
        th = th;
    L25:
        Binder.restoreCallingIdentity(origId);
        throw th;
    L19:
        th = th;
    L23:
        th = th;
        goto L25
    }

    public void registerRemoteAnimations(ITaskFragmentOrganizer organizer, RemoteAnimationDefinition definition) {
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L9;
        String protoLogParam0 = String.valueOf(organizer.asBinder());     // Catch: Throwable -> L7
        long protoLogParam1 = uid;
        long protoLogParam2 = pid;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 1327792561585467865L, 20, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L7
    L9:
        TaskFragmentOrganizerState organizerState = this.mTaskFragmentOrganizerState.get(organizer.asBinder());     // Catch: Throwable -> L7
        if (organizerState == null) goto L20;
        if (TaskFragmentOrganizerState.m10296$$Nest$fgetmRemoteAnimationDefinition(organizerState) != null) goto L18;
        definition.setCallingPidUid(pid, uid);     // Catch: Throwable -> L7
        TaskFragmentOrganizerState.m10299$$Nest$fputmRemoteAnimationDefinition(organizerState, definition);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L18:
        throw new IllegalStateException("The organizer has already registered remote animations=" + TaskFragmentOrganizerState.m10296$$Nest$fgetmRemoteAnimationDefinition(organizerState));     // Catch: Throwable -> L7
    L20:
        throw new IllegalStateException("The organizer hasn't been registered.");     // Catch: Throwable -> L7
    }

    public void unregisterRemoteAnimations(ITaskFragmentOrganizer organizer) {
        int pid = Binder.getCallingPid();
        long uid = Binder.getCallingUid();
        WindowManagerGlobalLock r3 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L9;
        String protoLogParam0 = String.valueOf(organizer.asBinder());     // Catch: Throwable -> L7
        long protoLogParam2 = pid;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -2524361347368208519L, 20, new Object[]{protoLogParam0, Long.valueOf(uid), Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L7
    L9:
        TaskFragmentOrganizerState organizerState = this.mTaskFragmentOrganizerState.get(organizer.asBinder());     // Catch: Throwable -> L7
        if (organizerState != null) goto L16;
        Slog.e(TAG, "The organizer hasn't been registered.");     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L16:
        TaskFragmentOrganizerState.m10299$$Nest$fputmRemoteAnimationDefinition(organizerState, null);     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    public void setSavedState(ITaskFragmentOrganizer organizer, Bundle state) {
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L9;
        String protoLogParam0 = String.valueOf(organizer.asBinder());     // Catch: Throwable -> L7
        long protoLogParam1 = uid;
        long protoLogParam2 = pid;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -2911328149681391757L, 20, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L7
    L9:
        TaskFragmentOrganizerState organizerState = this.mTaskFragmentOrganizerState.get(organizer.asBinder());     // Catch: Throwable -> L7
        if (organizerState == null) goto L16;
        TaskFragmentOrganizerState.m10300$$Nest$fputmSavedState(organizerState, state);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L16:
        throw new IllegalStateException("The organizer hasn't been registered.");     // Catch: Throwable -> L7
    }

    public void onTransactionHandled(IBinder transactionToken, WindowContainerTransaction wct, int transitionType, boolean shouldApplyIndependently) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        TaskFragmentOrganizerState state = null;
        if (isValidTransaction(wct) == false) goto L9;
        applyTransaction(wct, transitionType, shouldApplyIndependently, null);     // Catch: Throwable -> L7
    L9:
        ITaskFragmentOrganizer organizer = wct.getTaskFragmentOrganizer();     // Catch: Throwable -> L7
        if (organizer == null) goto L14;
        state = this.mTaskFragmentOrganizerState.get(organizer.asBinder());     // Catch: Throwable -> L7
    L14:
        if (state == null) goto L18;
        state.onTransactionFinished(transactionToken);     // Catch: Throwable -> L7
        Transition.ReadyCondition condition = (Transition.ReadyCondition) TaskFragmentOrganizerState.m10289$$Nest$fgetmInFlightTransactions(state).remove(transactionToken);     // Catch: Throwable -> L7
        if (condition == null) goto L18;
        condition.meet();     // Catch: Throwable -> L7
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void applyTransaction(WindowContainerTransaction wct, int transitionType, boolean shouldApplyIndependently, RemoteTransition remoteTransition) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (isValidTransaction(wct) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        this.mWindowOrganizerController.applyTaskFragmentTransactionLocked(wct, transitionType, shouldApplyIndependently, remoteTransition);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    public RemoteAnimationDefinition getRemoteAnimationDefinition(ITaskFragmentOrganizer organizer) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        TaskFragmentOrganizerState organizerState = this.mTaskFragmentOrganizerState.get(organizer.asBinder());     // Catch: Throwable -> L10
        if (organizerState != null) goto L12;
        Slog.e(TAG, "TaskFragmentOrganizer has been unregistered or died when trying to play animation on its organized windows.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L12:
        RemoteAnimationDefinition r2 = TaskFragmentOrganizerState.m10296$$Nest$fgetmRemoteAnimationDefinition(organizerState);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    int getTaskFragmentOrganizerUid(ITaskFragmentOrganizer organizer) {
        TaskFragmentOrganizerState state = validateAndGetState(organizer);
        return TaskFragmentOrganizerState.m10295$$Nest$fgetmOrganizerUid(state);
    }

    void onTaskFragmentAppeared(ITaskFragmentOrganizer organizer, TaskFragment taskFragment) {
        if (taskFragment.mTaskFragmentVanishedSent == false) goto L6;
        return;
    L6:
        if (taskFragment.getTask() != null) goto L9;
        Slog.w(TAG, "onTaskFragmentAppeared failed because it is not attached tf=" + taskFragment);
        return;
    L9:
        TaskFragmentOrganizerState state = validateAndGetState(organizer);
        if (state.addTaskFragment(taskFragment) == true) goto L12;
        return;
    L12:
        PendingTaskFragmentEvent pendingEvent = getPendingTaskFragmentEvent(taskFragment, 0);
        if (pendingEvent != null) goto L16;
        addPendingEvent(new PendingTaskFragmentEvent.Builder(0, organizer).setTaskFragment(taskFragment).build());
        return;
    }

    void onTaskFragmentInfoChanged(ITaskFragmentOrganizer organizer, TaskFragment taskFragment) {
        if (taskFragment.mTaskFragmentVanishedSent == false) goto L5;
        return;
    L5:
        validateAndGetState(organizer);
        if (taskFragment.mTaskFragmentAppearedSent == true) goto L8;
        return;
    L8:
        PendingTaskFragmentEvent pendingEvent = getLastPendingLifecycleEvent(taskFragment);
        if (pendingEvent != null) goto L11;
        pendingEvent = new PendingTaskFragmentEvent.Builder(2, organizer).setTaskFragment(taskFragment).build();
    L12:
        addPendingEvent(pendingEvent);
        return;
    L11:
        removePendingEvent(pendingEvent);
        PendingTaskFragmentEvent.m10287$$Nest$fputmDeferTime(pendingEvent, 0);
        goto L12
    }

    void onTaskFragmentVanished(ITaskFragmentOrganizer organizer, TaskFragment taskFragment) {
        if (taskFragment.mTaskFragmentVanishedSent == false) goto L5;
        return;
    L5:
        taskFragment.mTaskFragmentVanishedSent = true;
        TaskFragmentOrganizerState state = validateAndGetState(organizer);
        List<PendingTaskFragmentEvent> pendingEvents = this.mPendingTaskFragmentEvents.get(organizer.asBinder());
        int i = pendingEvents.size() - 1;
    L6:
        if (i < 0) goto L11;
        PendingTaskFragmentEvent event = pendingEvents.get(i);
        if (taskFragment != PendingTaskFragmentEvent.m10284$$Nest$fgetmTaskFragment(event)) goto L10;
        pendingEvents.remove(i);
    L10:
        i = i - 1;
        goto L6
    L11:
        addPendingEvent(new PendingTaskFragmentEvent.Builder(1, organizer).setTaskFragment(taskFragment).build());
        state.removeTaskFragment(taskFragment);
        this.mAtmService.mWindowManager.mWindowPlacerLocked.requestTraversal();
    }

    void onTaskFragmentError(ITaskFragmentOrganizer organizer, IBinder errorCallbackToken, TaskFragment taskFragment, int opType, Throwable exception) {
        if (taskFragment != null) goto L4;
    L6:
        validateAndGetState(organizer);
        addPendingEvent(new PendingTaskFragmentEvent.Builder(4, organizer).setErrorCallbackToken(errorCallbackToken).setTaskFragment(taskFragment).setException(exception).setOpType(opType).build());
        this.mAtmService.mWindowManager.mWindowPlacerLocked.requestTraversal();
        return;
    L4:
        if (taskFragment.mTaskFragmentVanishedSent == false) goto L6;
    }

    void onActivityReparentedToTask(final ActivityRecord activity) {
        Task task = activity.getTask();
        if (activity.mLastTaskFragmentOrganizerBeforePip == null) goto L5;
        ITaskFragmentOrganizer organizer = activity.mLastTaskFragmentOrganizerBeforePip;
    L10:
        if (isOrganizerRegistered(organizer) == true) goto L13;
        Slog.w(TAG, "The last TaskFragmentOrganizer no longer exists");
        return;
    L13:
        final IBinder parentTfTokenBeforePip = activity.getLastEmbeddedParentTfTokenBeforePip();
        PendingTaskFragmentEvent.Builder builder = new PendingTaskFragmentEvent.Builder(5, organizer).setActivity(activity).setTaskFragmentToken(activity.getLastEmbeddedParentTfTokenBeforePip());
        ActivityRecord candidateAssociatedActivity = task.getActivity(new TaskFragmentOrganizerController$$ExternalSyntheticLambda1(activity, parentTfTokenBeforePip));
        if (candidateAssociatedActivity != null) goto L16;
    L20:
        addPendingEvent(builder.build());
        return;
    L16:
        if (candidateAssociatedActivity.isEmbedded() == true) goto L18;
    L19:
        builder.setOtherActivity(candidateAssociatedActivity);
        goto L20
    L18:
        if (candidateAssociatedActivity.getTaskFragment().fillsParent() == false) goto L20;
    L5:
        final TaskFragment[] organizedTf = new TaskFragment[1];
        task.forAllLeafTaskFragments(new TaskFragmentOrganizerController$$ExternalSyntheticLambda0(organizedTf));
        if (organizedTf[0] != null) goto L8;
        return;
    L8:
        organizer = organizedTf[0].getTaskFragmentOrganizer();
        goto L10
    }

    private static /* synthetic */ boolean lambda$onActivityReparentedToTask$0(TaskFragment[] organizedTf, TaskFragment tf) {
        if (tf.isOrganizedTaskFragment() == false) goto L6;
        organizedTf[0] = tf;
        return true;
    L6:
        return false;
    }

    private static /* synthetic */ boolean lambda$onActivityReparentedToTask$1(ActivityRecord activity, IBinder parentTfTokenBeforePip, ActivityRecord ar) {
        if (ar != activity) goto L4;
    L8:
        return false;
    L4:
        if (ar.finishing == true) goto L8;
        if (ar.getTaskFragment().getFragmentToken() == parentTfTokenBeforePip) goto L8;
        return true;
    }

    void onTaskFragmentParentInfoChanged(ITaskFragmentOrganizer organizer, Task task) {
        validateAndGetState(organizer);
        PendingTaskFragmentEvent pendingEvent = getLastPendingParentInfoChangedEvent(organizer, task);
        if (pendingEvent != null) goto L5;
        addPendingEvent(new PendingTaskFragmentEvent.Builder(3, organizer).setTask(task).build());
    L5:
        this.mAtmService.mWindowManager.mWindowPlacerLocked.requestTraversal();
    }

    boolean isSystemOrganizer(IBinder organizerToken) {
        TaskFragmentOrganizerState state = this.mTaskFragmentOrganizerState.get(organizerToken);
        if (state != null) goto L5;
    L7:
        return false;
    L5:
        if (TaskFragmentOrganizerState.m10290$$Nest$fgetmIsSystemOrganizer(state) == false) goto L7;
        return true;
    }

    private PendingTaskFragmentEvent getLastPendingParentInfoChangedEvent(ITaskFragmentOrganizer organizer, Task task) {
        List<PendingTaskFragmentEvent> events = this.mPendingTaskFragmentEvents.get(organizer.asBinder());
        int i = events.size() - 1;
    L3:
        if (i < 0) goto L10;
        PendingTaskFragmentEvent event = events.get(i);
        if (task != PendingTaskFragmentEvent.m10283$$Nest$fgetmTask(event)) goto L9;
        if (PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event) != 3) goto L9;
        return event;
    L9:
        i = i - 1;
        goto L3
    L10:
        return null;
    }

    private void addPendingEvent(PendingTaskFragmentEvent event) {
        this.mPendingTaskFragmentEvents.get(PendingTaskFragmentEvent.m10285$$Nest$fgetmTaskFragmentOrg(event).asBinder()).add(event);
    }

    private void removePendingEvent(PendingTaskFragmentEvent event) {
        this.mPendingTaskFragmentEvents.get(PendingTaskFragmentEvent.m10285$$Nest$fgetmTaskFragmentOrg(event).asBinder()).remove(event);
    }

    private boolean isOrganizerRegistered(ITaskFragmentOrganizer organizer) {
        return this.mTaskFragmentOrganizerState.containsKey(organizer.asBinder());
    }

    private void removeOrganizer(ITaskFragmentOrganizer organizer, String reason) {
        TaskFragmentOrganizerState state = this.mTaskFragmentOrganizerState.get(organizer.asBinder());
        if (state != null) goto L6;
        Slog.w(TAG, "The organizer has already been removed.");
        return;
    L6:
        this.mPendingTaskFragmentEvents.remove(organizer.asBinder());
        state.dispose(reason);
        this.mTaskFragmentOrganizerState.remove(organizer.asBinder());
        if (state.hasSavedState() == false) goto L10;
        this.mCachedTaskFragmentOrganizerStates.add(state);
        return;
    }

    private TaskFragmentOrganizerState validateAndGetState(ITaskFragmentOrganizer organizer) {
        TaskFragmentOrganizerState state = this.mTaskFragmentOrganizerState.get(organizer.asBinder());
        if (state == null) goto L6;
        return state;
    L6:
        throw new IllegalArgumentException("TaskFragmentOrganizer has not been registered. Organizer=" + organizer);
    }

    boolean isValidTransaction(WindowContainerTransaction t) {
        if (t.isEmpty() == false) goto L5;
        return false;
    L5:
        ITaskFragmentOrganizer organizer = t.getTaskFragmentOrganizer();
        if (t.getTaskFragmentOrganizer() != null) goto L8;
    L12:
        Slog.e(TAG, "Caller organizer=" + organizer + " is no longer registered");
        return false;
    L8:
        if (isOrganizerRegistered(organizer) == false) goto L12;
        return true;
    }

    private PendingTaskFragmentEvent getLastPendingLifecycleEvent(TaskFragment tf) {
        ITaskFragmentOrganizer organizer = tf.getTaskFragmentOrganizer();
        List<PendingTaskFragmentEvent> events = this.mPendingTaskFragmentEvents.get(organizer.asBinder());
        int i = events.size() - 1;
    L3:
        if (i < 0) goto L10;
        PendingTaskFragmentEvent event = events.get(i);
        if (tf != PendingTaskFragmentEvent.m10284$$Nest$fgetmTaskFragment(event)) goto L9;
        if (event.isLifecycleEvent() == false) goto L9;
        return event;
    L9:
        i = i - 1;
        goto L3
    L10:
        return null;
    }

    private PendingTaskFragmentEvent getPendingTaskFragmentEvent(TaskFragment taskFragment, int type) {
        ITaskFragmentOrganizer organizer = taskFragment.getTaskFragmentOrganizer();
        List<PendingTaskFragmentEvent> events = this.mPendingTaskFragmentEvents.get(organizer.asBinder());
        int i = events.size() - 1;
    L3:
        if (i < 0) goto L10;
        PendingTaskFragmentEvent event = events.get(i);
        if (taskFragment != PendingTaskFragmentEvent.m10284$$Nest$fgetmTaskFragment(event)) goto L9;
        if (type != PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event)) goto L9;
        return event;
    L9:
        i = i - 1;
        goto L3
    L10:
        return null;
    }

    void dispatchPendingEvents() {
        if (this.mAtmService.mWindowManager.mWindowPlacerLocked.isLayoutDeferred() == false) goto L5;
        return;
    L5:
        if (this.mPendingTaskFragmentEvents.isEmpty() == true) goto L14;
        int organizerNum = this.mPendingTaskFragmentEvents.size();
        int i = 0;
    L8:
        if (i >= organizerNum) goto L11;
        TaskFragmentOrganizerState state = this.mTaskFragmentOrganizerState.get(this.mPendingTaskFragmentEvents.keyAt(i));
        dispatchPendingEvents(state, this.mPendingTaskFragmentEvents.valueAt(i));
        i = i + 1;
        goto L8
    L11:
        return;
    }

    private void dispatchPendingEvents(TaskFragmentOrganizerState state, List<PendingTaskFragmentEvent> pendingEvents) {
        if (pendingEvents.isEmpty() == false) goto L6;
        return;
    L6:
        if (shouldDeferPendingEvents(state, pendingEvents) == false) goto L8;
        return;
    L8:
        this.mTmpTaskSet.clear();
        int numEvents = pendingEvents.size();
        TaskFragmentTransaction transaction = new TaskFragmentTransaction();
        int i = 0;
    L9:
        if (i >= numEvents) goto L18;
        PendingTaskFragmentEvent event = pendingEvents.get(i);
        if (PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event) != 0) goto L13;
    L14:
        Task task = PendingTaskFragmentEvent.m10284$$Nest$fgetmTaskFragment(event).getTask();
        if (this.mTmpTaskSet.add(task) == false) goto L17;
        transaction.addChange(prepareChange(new PendingTaskFragmentEvent.Builder(3, TaskFragmentOrganizerState.m10294$$Nest$fgetmOrganizer(state)).setTask(task).build()));
    L17:
        transaction.addChange(prepareChange(event));
        i = i + 1;
        goto L9
    L13:
        if (PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event) != 2) goto L17;
    L18:
        this.mTmpTaskSet.clear();
        state.dispatchTransaction(transaction);
        pendingEvents.clear();
    }

    private boolean shouldDeferPendingEvents(TaskFragmentOrganizerState state, List<PendingTaskFragmentEvent> pendingEvents) {
        ArrayList<Task> visibleTasks = new ArrayList();
        ArrayList<Task> invisibleTasks = new ArrayList();
        int i = 0;
        int n = pendingEvents.size();
    L3:
        if (i >= n) goto L24;
        PendingTaskFragmentEvent event = pendingEvents.get(i);
        if (PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event) == 3) goto L12;
        if (PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event) == 2) goto L12;
        if (PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event) == 0) goto L12;
        return false;
    L12:
        if (PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event) != 3) goto L14;
        Task task = PendingTaskFragmentEvent.m10283$$Nest$fgetmTask(event);
    L16:
        if (task.lastActiveTime <= PendingTaskFragmentEvent.m10277$$Nest$fgetmDeferTime(event)) goto L21;
        if (isTaskVisible(task, visibleTasks, invisibleTasks) == false) goto L21;
        return false;
    L21:
        if (shouldSendEventWhenTaskInvisible(task, state, event) == true) goto L22;
        PendingTaskFragmentEvent.m10287$$Nest$fputmDeferTime(event, task.lastActiveTime);
        i = i + 1;
        goto L3
    L22:
        return false;
    L14:
        task = PendingTaskFragmentEvent.m10284$$Nest$fgetmTaskFragment(event).getTask();
        goto L16
    L24:
        return true;
    }

    private static boolean isTaskVisible(Task task, ArrayList<Task> knownVisibleTasks, ArrayList<Task> knownInvisibleTasks) {
        if (knownVisibleTasks.contains(task) == false) goto L6;
        return true;
    L6:
        if (knownInvisibleTasks.contains(task) == false) goto L9;
        return false;
    L9:
        if (task.shouldBeVisible(null) == false) goto L12;
        knownVisibleTasks.add(task);
        return true;
    L12:
        knownInvisibleTasks.add(task);
        return false;
    }

    private boolean shouldSendEventWhenTaskInvisible(Task task, TaskFragmentOrganizerState state, PendingTaskFragmentEvent event) {
        TaskFragmentParentInfo lastParentInfo = (TaskFragmentParentInfo) TaskFragmentOrganizerState.m10292$$Nest$fgetmLastSentTaskFragmentParentInfos(state).get(task.mTaskId);
        if (lastParentInfo != null) goto L5;
    L20:
        return true;
    L5:
        if (lastParentInfo.isVisible() == true) goto L20;
        if (PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event) != 2) goto L19;
        TaskFragmentInfo lastInfo = (TaskFragmentInfo) TaskFragmentOrganizerState.m10291$$Nest$fgetmLastSentTaskFragmentInfos(state).get(PendingTaskFragmentEvent.m10284$$Nest$fgetmTaskFragment(event));
        if (PendingTaskFragmentEvent.m10284$$Nest$fgetmTaskFragment(event).getNonFinishingActivityCount() != 0) goto L12;
        boolean isEmpty = true;
    L13:
        if (lastInfo != null) goto L15;
        return true;
    L15:
        if (lastInfo.isEmpty() == isEmpty) goto L18;
        return true;
    L18:
        return false;
    L12:
        isEmpty = false;
        goto L13
    L19:
        return false;
    }

    void dispatchPendingInfoChangedEvent(TaskFragment taskFragment) {
        PendingTaskFragmentEvent event = getPendingTaskFragmentEvent(taskFragment, 2);
        if (event != null) goto L5;
        return;
    L5:
        ITaskFragmentOrganizer organizer = taskFragment.getTaskFragmentOrganizer();
        TaskFragmentOrganizerState state = validateAndGetState(organizer);
        TaskFragmentTransaction transaction = new TaskFragmentTransaction();
        transaction.addChange(prepareChange(new PendingTaskFragmentEvent.Builder(3, organizer).setTask(taskFragment.getTask()).build()));
        transaction.addChange(prepareChange(event));
        state.dispatchTransaction(transaction);
        this.mPendingTaskFragmentEvents.get(organizer.asBinder()).remove(event);
    }

    private TaskFragmentTransaction.Change prepareChange(PendingTaskFragmentEvent event) {
        ITaskFragmentOrganizer taskFragmentOrg = PendingTaskFragmentEvent.m10285$$Nest$fgetmTaskFragmentOrg(event);
        TaskFragment taskFragment = PendingTaskFragmentEvent.m10284$$Nest$fgetmTaskFragment(event);
        TaskFragmentOrganizerState state = this.mTaskFragmentOrganizerState.get(taskFragmentOrg.asBinder());
        if (state != null) goto L7;
        return null;
    L7:
        switch(PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event)) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            default: goto L9;
        };
    L9:
        throw new IllegalArgumentException("Unknown TaskFragmentEvent=" + PendingTaskFragmentEvent.m10279$$Nest$fgetmEventType(event));
    L11:
        return state.prepareActivityReparentedToTask(PendingTaskFragmentEvent.m10276$$Nest$fgetmActivity(event), PendingTaskFragmentEvent.m10282$$Nest$fgetmOtherActivity(event), PendingTaskFragmentEvent.m10286$$Nest$fgetmTaskFragmentToken(event));
    L13:
        return state.prepareTaskFragmentError(PendingTaskFragmentEvent.m10278$$Nest$fgetmErrorCallbackToken(event), taskFragment, PendingTaskFragmentEvent.m10281$$Nest$fgetmOpType(event), PendingTaskFragmentEvent.m10280$$Nest$fgetmException(event));
    L15:
        return state.prepareTaskFragmentParentInfoChanged(PendingTaskFragmentEvent.m10283$$Nest$fgetmTask(event));
    L17:
        return state.prepareTaskFragmentInfoChanged(taskFragment);
    L19:
        return state.prepareTaskFragmentVanished(taskFragment);
    L21:
        return state.prepareTaskFragmentAppeared(taskFragment);
    }

    IApplicationThread getAppThread(int pid, int uid) {
        WindowProcessController wpc = this.mAtmService.mProcessMap.getProcess(pid);
        if (wpc != null) goto L5;
    L7:
        IApplicationThread appThread = null;
    L9:
        if (appThread == null) goto L12;
        return appThread;
    L12:
        throw new IllegalArgumentException("Cannot find process for pid=" + pid + " uid=" + uid);
    L5:
        if (wpc.mUid != uid) goto L7;
        appThread = wpc.getThread();
        goto L9
    }

    private static Intent trimIntent(Intent intent) {
        return new Intent().setComponent(intent.getComponent()).setPackage(intent.getPackage()).setAction(intent.getAction());
    }
}
