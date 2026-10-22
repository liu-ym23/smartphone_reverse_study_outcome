package com.android.server.wm;

import android.app.ActivityManager;
import android.app.WindowConfiguration;
import android.content.Intent;
import android.content.pm.ParceledListSlice;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.pico.utils.ExtImplFactory;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.SurfaceControl;
import android.window.ITaskOrganizer;
import android.window.ITaskOrganizerController;
import android.window.IWindowlessStartingSurfaceCallback;
import android.window.StartingWindowInfo;
import android.window.StartingWindowRemovalInfo;
import android.window.TaskAppearedInfo;
import android.window.TaskSnapshot;
import android.window.WindowContainerToken;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ArrayUtils;
import com.android.server.SysOptBridge;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
class TaskOrganizerController extends ITaskOrganizerController.Stub {
    private static final String TAG = "TaskOrganizerController";
    private IExtTaskOrganizerController mExt;
    private final WindowManagerGlobalLock mGlobalLock;
    private final HashSet<Integer> mInterceptBackPressedOnRootTasks;
    private final ActivityTaskManagerService mService;
    private final ArrayMap<IBinder, TaskOrganizerState> mTaskOrganizerStates;
    private final ArrayDeque<ITaskOrganizer> mTaskOrganizers;

    class DeathRecipient implements IBinder.DeathRecipient {
        ITaskOrganizer mTaskOrganizer;
        final /* synthetic */ TaskOrganizerController this$0;

        DeathRecipient(TaskOrganizerController this$0, ITaskOrganizer organizer) {
            this.this$0 = this$0;
            this.mTaskOrganizer = organizer;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            WindowManagerGlobalLock r0 = TaskOrganizerController.m10304$$Nest$fgetmGlobalLock(this.this$0);
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            TaskOrganizerState state = (TaskOrganizerState) TaskOrganizerController.m10307$$Nest$fgetmTaskOrganizerStates(this.this$0).get(this.mTaskOrganizer.asBinder());     // Catch: Throwable -> L7
            if (state == null) goto L9;
            state.dispose();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    static class PendingTaskEvent {
        static final int EVENT_APPEARED = 0;
        static final int EVENT_INFO_CHANGED = 2;
        static final int EVENT_ROOT_BACK_PRESSED = 3;
        static final int EVENT_VANISHED = 1;
        final int mEventType;
        boolean mForce;
        final Task mTask;
        final ITaskOrganizer mTaskOrg;

        PendingTaskEvent(Task task, int event) {
            this(task, task.mTaskOrganizer, event);
        }

        PendingTaskEvent(Task task, ITaskOrganizer taskOrg, int eventType) {
            this.mTask = task;
            this.mTaskOrg = taskOrg;
            this.mEventType = eventType;
        }

        boolean isLifecycleEvent() {
            if (this.mEventType != 0) goto L5;
            return true;
        L5:
            if (this.mEventType != 1) goto L7;
            return true;
        L7:
            if (this.mEventType == 2) goto L13;
            return false;
        L13:
            return true;
        }
    }

    static class StartingWindowAnimationAdaptor implements AnimationAdapter {
        StartingWindowAnimationAdaptor() {
        }

        @Override // com.android.server.wm.AnimationAdapter
        public boolean getShowWallpaper() {
            return false;
        }

        @Override // com.android.server.wm.AnimationAdapter
        public void startAnimation(SurfaceControl animationLeash, SurfaceControl.Transaction t, int type, SurfaceAnimator.OnAnimationFinishedCallback finishCallback) {
        }

        @Override // com.android.server.wm.AnimationAdapter
        public void onAnimationCancelled(SurfaceControl animationLeash) {
        }

        @Override // com.android.server.wm.AnimationAdapter
        public long getDurationHint() {
            return 0;
        }

        @Override // com.android.server.wm.AnimationAdapter
        public long getStatusBarTransitionsStartTime() {
            return 0;
        }

        @Override // com.android.server.wm.AnimationAdapter
        public void dump(PrintWriter pw, String prefix) {
        }

        @Override // com.android.server.wm.AnimationAdapter
        public void dumpDebug(ProtoOutputStream proto) {
        }
    }

    private static class TaskOrganizerCallbacks {
        final ITaskOrganizer mTaskOrganizer;

        TaskOrganizerCallbacks(ITaskOrganizer taskOrg) {
            this.mTaskOrganizer = taskOrg;
        }

        IBinder getBinder() {
            return this.mTaskOrganizer.asBinder();
        }

        SurfaceControl prepareLeash(Task task, String reason) {
            return new SurfaceControl(task.getSurfaceControl(), reason);
        }

        void onTaskAppeared(Task task) {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L5;
            long protoLogParam0 = task.mTaskId;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -6181189296332065162L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        L5:
            ActivityManager.RunningTaskInfo taskInfo = task.getTaskInfo();
            this.mTaskOrganizer.onTaskAppeared(taskInfo, prepareLeash(task, "TaskOrganizerController.onTaskAppeared"));     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Slog.e(TaskOrganizerController.TAG, "Exception sending onTaskAppeared callback", e);
        }

        void onTaskVanished(Task task) {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L5;
            long protoLogParam0 = task.mTaskId;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 6535296991997214354L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        L5:
            ActivityManager.RunningTaskInfo taskInfo = task.getTaskInfo();
            this.mTaskOrganizer.onTaskVanished(taskInfo);     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Slog.e(TaskOrganizerController.TAG, "Exception sending onTaskVanished callback", e);
        }

        void onTaskInfoChanged(Task task, ActivityManager.RunningTaskInfo taskInfo) {
            if (task.mTaskAppearedSent == true) goto L6;
            return;
        L6:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L9;
            long protoLogParam0 = task.mTaskId;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -6638141753476761854L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        L9:
            if (task.isOrganized() == true) goto L16;
            return;
        L16:
            this.mTaskOrganizer.onTaskInfoChanged(taskInfo);     // Catch: RemoteException -> L13
            return;
        L13:
            e = move-exception;
            Slog.e(TaskOrganizerController.TAG, "Exception sending onTaskInfoChanged callback", e);
        }

        void onBackPressedOnTaskRoot(Task task) {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L6;
            long protoLogParam0 = task.mTaskId;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -8100069665346602959L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        L6:
            if (task.mTaskAppearedSent == true) goto L9;
            return;
        L9:
            if (task.isOrganized() == true) goto L16;
            return;
        L16:
            this.mTaskOrganizer.onBackPressedOnTaskRoot(task.getTaskInfo());     // Catch: Exception -> L13
            return;
        L13:
            e = move-exception;
            Slog.e(TaskOrganizerController.TAG, "Exception sending onBackPressedOnTaskRoot callback", e);
        }
    }

    static final class TaskOrganizerPendingEventsQueue {
        private final WeakHashMap<Task, ActivityManager.RunningTaskInfo> mLastSentTaskInfos;
        private final TaskOrganizerState mOrganizerState;
        private final ArrayList<PendingTaskEvent> mPendingTaskEvents;
        private ActivityManager.RunningTaskInfo mTmpTaskInfo;

        /* JADX INFO: renamed from: -$$Nest$mdispatchTaskInfoChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10310$$Nest$mdispatchTaskInfoChanged(TaskOrganizerPendingEventsQueue r0, Task r1, boolean r2) {
            r0.dispatchTaskInfoChanged(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetPendingTaskEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ PendingTaskEvent m10311$$Nest$mgetPendingTaskEvent(TaskOrganizerPendingEventsQueue r0, Task r1, int r2) {
            return r0.getPendingTaskEvent(r1, r2);
        }

        TaskOrganizerPendingEventsQueue(TaskOrganizerState taskOrganizerState) {
            this.mLastSentTaskInfos = new WeakHashMap();
            this.mPendingTaskEvents = new ArrayList();
            this.mOrganizerState = taskOrganizerState;
        }

        public ArrayList<PendingTaskEvent> getPendingEventList() {
            return this.mPendingTaskEvents;
        }

        int numPendingTaskEvents() {
            return this.mPendingTaskEvents.size();
        }

        void clearPendingTaskEvents() {
            this.mPendingTaskEvents.clear();
        }

        void addPendingTaskEvent(PendingTaskEvent event) {
            this.mPendingTaskEvents.add(event);
        }

        void removePendingTaskEvent(PendingTaskEvent event) {
            this.mPendingTaskEvents.remove(event);
        }

        boolean removePendingTaskEvents(Task task) {
            boolean foundPendingAppearedEvents = false;
            int i = this.mPendingTaskEvents.size() - 1;
        L3:
            if (i < 0) goto L11;
            PendingTaskEvent entry = this.mPendingTaskEvents.get(i);
            if (task.mTaskId != entry.mTask.mTaskId) goto L9;
            this.mPendingTaskEvents.remove(i);
            if (entry.mEventType != 0) goto L9;
            foundPendingAppearedEvents = true;
        L9:
            i = i - 1;
            goto L3
        L11:
            return foundPendingAppearedEvents;
        }

        private PendingTaskEvent getPendingTaskEvent(Task task, int type) {
            int i = this.mPendingTaskEvents.size() - 1;
        L3:
            if (i < 0) goto L10;
            PendingTaskEvent entry = this.mPendingTaskEvents.get(i);
            if (task.mTaskId != entry.mTask.mTaskId) goto L9;
            if (type != entry.mEventType) goto L9;
            return entry;
        L9:
            i = i - 1;
            goto L3
        L10:
            return null;
        }

        PendingTaskEvent getPendingLifecycleTaskEvent(Task task) {
            int i = this.mPendingTaskEvents.size() - 1;
        L3:
            if (i < 0) goto L10;
            PendingTaskEvent entry = this.mPendingTaskEvents.get(i);
            if (task.mTaskId != entry.mTask.mTaskId) goto L9;
            if (entry.isLifecycleEvent() == false) goto L9;
            return entry;
        L9:
            i = i - 1;
            goto L3
        L10:
            return null;
        }

        void dispatchPendingEvents() {
            if (this.mPendingTaskEvents.isEmpty() == false) goto L5;
            return;
        L5:
            int i = 0;
            int n = this.mPendingTaskEvents.size();
        L6:
            if (i >= n) goto L8;
            dispatchPendingEvent(this.mPendingTaskEvents.get(i));
            i = i + 1;
            goto L6
        L8:
            this.mPendingTaskEvents.clear();
        }

        private void dispatchPendingEvent(PendingTaskEvent event) {
            Task task = event.mTask;
            switch(event.mEventType) {
                case 0: goto L9;
                case 1: goto L7;
                case 2: goto L6;
                case 3: goto L5;
                default: goto L16;
            };
        L5:
            TaskOrganizerState.m10313$$Nest$fgetmOrganizer(this.mOrganizerState).onBackPressedOnTaskRoot(task);
            return;
        L6:
            dispatchTaskInfoChanged(event.mTask, event.mForce);
            return;
        L7:
            TaskOrganizerState.m10313$$Nest$fgetmOrganizer(this.mOrganizerState).onTaskVanished(task);
            this.mLastSentTaskInfos.remove(task);
            return;
        L16:
            return;
        L9:
            if (task.taskAppearedReady() == false) goto L15;
            TaskOrganizerState.m10313$$Nest$fgetmOrganizer(this.mOrganizerState).onTaskAppeared(task);
            return;
        }

        private void dispatchTaskInfoChanged(Task task, boolean force) {
            ActivityManager.RunningTaskInfo lastInfo = this.mLastSentTaskInfos.get(task);
            if (this.mTmpTaskInfo != null) goto L5;
            this.mTmpTaskInfo = new ActivityManager.RunningTaskInfo();
        L5:
            this.mTmpTaskInfo.configuration.unset();
            task.fillTaskInfo(this.mTmpTaskInfo);
            if (this.mTmpTaskInfo.equalsForTaskOrganizer(lastInfo) == true) goto L8;
        L11:
            boolean changed = true;
        L13:
            if (changed == true) goto L16;
            if (force == true) goto L16;
            return;
        L16:
            ActivityManager.RunningTaskInfo newInfo = this.mTmpTaskInfo;
            this.mLastSentTaskInfos.put(task, this.mTmpTaskInfo);
            this.mTmpTaskInfo = null;
            if (task.isOrganized() == false) goto L20;
            TaskOrganizerState.m10313$$Nest$fgetmOrganizer(this.mOrganizerState).onTaskInfoChanged(task, newInfo);
            return;
        L20:
            return;
        L8:
            if (WindowOrganizerController.configurationsAreEqualForOrganizer(this.mTmpTaskInfo.configuration, lastInfo.configuration) == false) goto L11;
            changed = false;
            goto L13
        }
    }

    class TaskOrganizerState {
        private final DeathRecipient mDeathRecipient;
        private final ArrayList<Task> mOrganizedTasks;
        private final TaskOrganizerCallbacks mOrganizer;
        private final TaskOrganizerPendingEventsQueue mPendingEventsQueue;
        private final int mUid;
        final /* synthetic */ TaskOrganizerController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmOrganizedTasks, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayList m10312$$Nest$fgetmOrganizedTasks(TaskOrganizerState r0) {
            return r0.mOrganizedTasks;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOrganizer, reason: not valid java name */
        static /* bridge */ /* synthetic */ TaskOrganizerCallbacks m10313$$Nest$fgetmOrganizer(TaskOrganizerState r0) {
            return r0.mOrganizer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPendingEventsQueue, reason: not valid java name */
        static /* bridge */ /* synthetic */ TaskOrganizerPendingEventsQueue m10314$$Nest$fgetmPendingEventsQueue(TaskOrganizerState r0) {
            return r0.mPendingEventsQueue;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10315$$Nest$fgetmUid(TaskOrganizerState r0) {
            return r0.mUid;
        }

        /* JADX INFO: renamed from: -$$Nest$maddTask, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10316$$Nest$maddTask(TaskOrganizerState r0, Task r1) {
            return r0.addTask(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mremoveTask, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10317$$Nest$mremoveTask(TaskOrganizerState r0, Task r1, boolean r2) {
            return r0.removeTask(r1, r2);
        }

        TaskOrganizerState(TaskOrganizerController this$0, ITaskOrganizer organizer, int uid) {
            this.this$0 = this$0;
            this.mOrganizedTasks = new ArrayList();
            this.mOrganizer = new TaskOrganizerCallbacks(organizer);
            this.mDeathRecipient = new DeathRecipient(this$0, organizer);
            this.mPendingEventsQueue = new TaskOrganizerPendingEventsQueue(this);
            organizer.asBinder().linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L5
        L7:
            this.mUid = uid;
            return;
        L6:
            Slog.e(TaskOrganizerController.TAG, "TaskOrganizer failed to register death recipient");
            goto L7
        }

        DeathRecipient getDeathRecipient() {
            return this.mDeathRecipient;
        }

        TaskOrganizerPendingEventsQueue getPendingEventsQueue() {
            return this.mPendingEventsQueue;
        }

        SurfaceControl addTaskWithoutCallback(Task t, String reason) {
            t.mTaskAppearedSent = true;
            if (this.mOrganizedTasks.contains(t) == true) goto L6;
            this.mOrganizedTasks.add(t);
        L6:
            return this.mOrganizer.prepareLeash(t, reason);
        }

        private boolean addTask(Task t) {
            if (t.mTaskAppearedSent == false) goto L6;
            return false;
        L6:
            if (this.mOrganizedTasks.contains(t) == true) goto L9;
            this.mOrganizedTasks.add(t);
        L9:
            if (t.taskAppearedReady() == false) goto L12;
            t.mTaskAppearedSent = true;
            return true;
        L12:
            return false;
        }

        private boolean removeTask(Task t, boolean removeFromSystem) {
            this.mOrganizedTasks.remove(t);
            TaskOrganizerController.m10305$$Nest$fgetmInterceptBackPressedOnRootTasks(this.this$0).remove(Integer.valueOf(t.mTaskId));
            boolean taskAppearedSent = t.mTaskAppearedSent;
            if (taskAppearedSent == true) goto L5;
        L8:
            if (removeFromSystem == false) goto L10;
            TaskOrganizerController.m10306$$Nest$fgetmService(this.this$0).removeTask(t);
        L10:
            return taskAppearedSent;
        L5:
            if (t.getSurfaceControl() == null) goto L7;
            t.migrateToNewSurfaceControl(t.getSyncTransaction());
        L7:
            t.mTaskAppearedSent = false;
            goto L8
        }

        void dispose() {
            TaskOrganizerController.m10308$$Nest$fgetmTaskOrganizers(this.this$0).remove(this.mOrganizer.mTaskOrganizer);
        L4:
            if (this.mOrganizedTasks.isEmpty() == true) goto L22;
            Task t = this.mOrganizedTasks.get(0);
            if (t.mCreatedByOrganizer == false) goto L8;
            t.removeImmediately();
        L10:
            if (this.mOrganizedTasks.contains(t) == false) goto L15;
            if (removeTask(t, t.mRemoveWithTaskOrganizer) == false) goto L15;
            TaskOrganizerController.m10309$$Nest$monTaskVanishedInternal(this.this$0, this, t);
        L15:
            if (TaskOrganizerController.m10306$$Nest$fgetmService(this.this$0).getTransitionController().isShellTransitionsEnabled() == false) goto L4;
            if (t.mTaskOrganizer == null) goto L4;
            if (t.getSurfaceControl() == null) goto L4;
            t.getSyncTransaction().show(t.getSurfaceControl());
            goto L4
        L8:
            t.updateTaskOrganizerState();
            goto L10
        L22:
            this.mPendingEventsQueue.clearPendingTaskEvents();
            TaskOrganizerController.m10307$$Nest$fgetmTaskOrganizerStates(this.this$0).remove(this.mOrganizer.getBinder());
        }

        void unlinkDeath() {
            this.mOrganizer.getBinder().unlinkToDeath(this.mDeathRecipient, 0);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-E7HA_4Ykr1Ex3yc_2uHWFkdKAE, reason: not valid java name */
    public static /* synthetic */ void m10302$r8$lambda$E7HA_4Ykr1Ex3yc_2uHWFkdKAE(int[] r0, ArrayList r1, Task r2) {
        lambda$getRootTasks$3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$VSKvVVPI5NKYlAdukWH1TzgUuVQ(TaskOrganizerController r0, ITaskOrganizer r1, int r2, ArrayList r3) {
        r0.lambda$registerTaskOrganizer$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$bT61f4Y0QjfsnHX0y1DB-YUT2U4, reason: not valid java name */
    public static /* synthetic */ void m10303$r8$lambda$bT61f4Y0QjfsnHX0y1DBYUT2U4(TaskOrganizerController r0, ITaskOrganizer r1, int r2) {
        r0.lambda$unregisterTaskOrganizer$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ersYTYpQCW6sGFO8mYwHFWIJ7D0(TaskOrganizerState r0, ArrayList r1, Task r2) {
        lambda$registerTaskOrganizer$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerGlobalLock m10304$$Nest$fgetmGlobalLock(TaskOrganizerController r0) {
        return r0.mGlobalLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInterceptBackPressedOnRootTasks, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashSet m10305$$Nest$fgetmInterceptBackPressedOnRootTasks(TaskOrganizerController r0) {
        return r0.mInterceptBackPressedOnRootTasks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerService m10306$$Nest$fgetmService(TaskOrganizerController r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTaskOrganizerStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m10307$$Nest$fgetmTaskOrganizerStates(TaskOrganizerController r0) {
        return r0.mTaskOrganizerStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTaskOrganizers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayDeque m10308$$Nest$fgetmTaskOrganizers(TaskOrganizerController r0) {
        return r0.mTaskOrganizers;
    }

    /* JADX INFO: renamed from: -$$Nest$monTaskVanishedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10309$$Nest$monTaskVanishedInternal(TaskOrganizerController r0, TaskOrganizerState r1, Task r2) {
        r0.onTaskVanishedInternal(r1, r2);
    }

    TaskOrganizerController(ActivityTaskManagerService atm) {
        this.mTaskOrganizers = new ArrayDeque();
        this.mTaskOrganizerStates = new ArrayMap();
        this.mInterceptBackPressedOnRootTasks = new HashSet();
        this.mExt = (IExtTaskOrganizerController) ExtImplFactory.getImpl(IExtTaskOrganizerController.class, new Object[]{this});
        this.mService = atm;
        this.mGlobalLock = atm.mGlobalLock;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    L4:
        e = move-exception;
        throw ActivityTaskManagerService.logAndRethrowRuntimeExceptionOnTransact(TAG, e);
    }

    public ParceledListSlice<TaskAppearedInfo> registerTaskOrganizer(final ITaskOrganizer organizer) {
        ActivityTaskManagerService.enforceTaskPermission("registerTaskOrganizer()");
        final int uid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        final ArrayList<TaskAppearedInfo> taskInfos = new ArrayList();     // Catch: Throwable -> L6
        Runnable withGlobalLock = new TaskOrganizerController$$ExternalSyntheticLambda3(this, organizer, uid, taskInfos);     // Catch: Throwable -> L6
        if (this.mService.getTransitionController().isShellTransitionsEnabled() == false) goto L8;
        this.mService.getTransitionController().mRunningLock.runWhenIdle(1000, withGlobalLock);     // Catch: Throwable -> L6
    L13:
        ParceledListSlice<TaskAppearedInfo> r5 = new ParceledListSlice(taskInfos);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(origId);
        return r5;
    L8:
        WindowManagerGlobalLock r6 = this.mGlobalLock;     // Catch: Throwable -> L6
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L6
        monitor-enter(r6);     // Catch: Throwable -> L6
        withGlobalLock.run();     // Catch: Throwable -> L16
        monitor-exit(r6);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L6
        goto L13
    L16:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private /* synthetic */ void lambda$registerTaskOrganizer$1(ITaskOrganizer organizer, int uid, final ArrayList taskInfos) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L6;
        String protoLogParam0 = String.valueOf(organizer.asBinder());
        long protoLogParam1 = uid;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -610138383571469481L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
    L6:
        if (this.mTaskOrganizerStates.containsKey(organizer.asBinder()) == true) goto L8;
        this.mTaskOrganizers.add(organizer);
        this.mTaskOrganizerStates.put(organizer.asBinder(), new TaskOrganizerState(this, organizer, uid));
    L8:
        final TaskOrganizerState state = this.mTaskOrganizerStates.get(organizer.asBinder());
        this.mService.mRootWindowContainer.forAllTasks(new TaskOrganizerController$$ExternalSyntheticLambda1(state, taskInfos));
    }

    private static /* synthetic */ void lambda$registerTaskOrganizer$0(TaskOrganizerState state, ArrayList taskInfos, Task task) {
        boolean returnTask = !task.mCreatedByOrganizer;
        task.updateTaskOrganizerState(returnTask);
        if (task.isOrganized() == false) goto L7;
        if (returnTask == false) goto L8;
        SurfaceControl taskLeash = state.addTaskWithoutCallback(task, "TaskOrganizerController.registerTaskOrganizer");
        taskInfos.add(new TaskAppearedInfo(task.getTaskInfo(), taskLeash));
        return;
    L8:
        return;
    }

    public void unregisterTaskOrganizer(final ITaskOrganizer organizer) {
        ActivityTaskManagerService.enforceTaskPermission("unregisterTaskOrganizer()");
        final int uid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        Runnable withGlobalLock = new TaskOrganizerController$$ExternalSyntheticLambda2(this, organizer, uid);     // Catch: Throwable -> L6
        if (this.mService.getTransitionController().isShellTransitionsEnabled() == false) goto L8;
        this.mService.getTransitionController().mRunningLock.runWhenIdle(1000, withGlobalLock);     // Catch: Throwable -> L6
    L13:
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        WindowManagerGlobalLock r4 = this.mGlobalLock;     // Catch: Throwable -> L6
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L6
        monitor-enter(r4);     // Catch: Throwable -> L6
        withGlobalLock.run();     // Catch: Throwable -> L15
        monitor-exit(r4);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L6
        goto L13
    L15:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private /* synthetic */ void lambda$unregisterTaskOrganizer$2(ITaskOrganizer organizer, int uid) {
        TaskOrganizerState state = this.mTaskOrganizerStates.get(organizer.asBinder());
        if (state != null) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L8;
        String protoLogParam0 = String.valueOf(organizer.asBinder());
        long protoLogParam1 = uid;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 1705860547080436016L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
    L8:
        state.unlinkDeath();
        state.dispose();
    }

    ITaskOrganizer getTaskOrganizer() {
        return this.mTaskOrganizers.peekLast();
    }

    static SurfaceControl applyStartingWindowAnimation(WindowState window) {
        SurfaceControl.Transaction t = window.getPendingTransaction();
        StartingWindowAnimationAdaptor adaptor = new StartingWindowAnimationAdaptor();
        window.startAnimation(t, adaptor, false, 128);
        SurfaceControl leash = window.getAnimationLeash();
        if (leash != null) goto L6;
        Slog.e(TAG, "Cannot start starting window animation, the window " + window + " was removed");
        return null;
    L6:
        t.setPosition(leash, window.mSurfacePosition.x, window.mSurfacePosition.y);
        return leash;
    }

    boolean addStartingWindow(Task task, ActivityRecord activity, int launchTheme, TaskSnapshot taskSnapshot) {
        Task rootTask = task.getRootTask();
        if (rootTask != null) goto L5;
    L21:
        return false;
    L5:
        if (activity.mStartingData == null) goto L21;
        ITaskOrganizer lastOrganizer = getTaskOrganizer();
        if (lastOrganizer != null) goto L10;
        return false;
    L10:
        StartingWindowInfo info = task.getStartingWindowInfo(activity);
        boolean isGameScene = SysOptBridge.getFactory().getAppRecordManagerService().isGameApp(activity.packageName);
        if (isGameScene == false) goto L13;
        Slog.d(TAG, "addStartingWindow, game scene, landscape, use black background");
        info.mUseBlackBackground = true;
    L13:
        if (launchTheme == 0) goto L15;
        info.splashScreenThemeResId = launchTheme;
    L15:
        info.taskSnapshot = taskSnapshot;
        info.appToken = activity.token;
        lastOrganizer.addStartingWindow(info);     // Catch: RemoteException -> L18
        return true;
    L18:
        e = move-exception;
        Slog.e(TAG, "Exception sending onTaskStart callback", e);
        return false;
    }

    void removeStartingWindow(Task task, ITaskOrganizer taskOrganizer, boolean prepareAnimation, boolean hasImeSurface) {
        Task rootTask = task.getRootTask();
        if (rootTask != null) goto L5;
        return;
    L5:
        if (taskOrganizer == null) goto L7;
        ITaskOrganizer lastOrganizer = taskOrganizer;
    L9:
        if (lastOrganizer != null) goto L11;
        return;
    L11:
        StartingWindowRemovalInfo removalInfo = new StartingWindowRemovalInfo();
        removalInfo.taskId = task.mTaskId;
        if (prepareAnimation == true) goto L14;
    L18:
        boolean r6 = false;
    L19:
        removalInfo.playRevealAnimation = r6;
        boolean playShiftUpAnimation = !task.inMultiWindowMode();
        ActivityRecord topActivity = task.topActivityContainsStartingWindow();
        if (topActivity == null) goto L47;
        DisplayContent dc = topActivity.getDisplayContent();
        if (hasImeSurface == true) goto L24;
    L31:
        WindowState mainWindow = topActivity.findMainWindow(false);
        if (mainWindow != null) goto L34;
    L40:
        removalInfo.playRevealAnimation = false;
    L41:
        this.mExt.deferStartingWindowRemove(topActivity, removalInfo);
        goto L47
    L34:
        if (mainWindow.mRemoved == true) goto L40;
        if (removalInfo.playRevealAnimation == false) goto L41;
        if (playShiftUpAnimation == false) goto L41;
        removalInfo.roundedCornerRadius = topActivity.mAppCompatController.getLetterboxPolicy().getRoundedCornersRadius(mainWindow);
        removalInfo.windowAnimationLeash = applyStartingWindowAnimation(mainWindow);
        removalInfo.mainFrame = new Rect(mainWindow.getFrame());
        removalInfo.mainFrame.offsetTo(mainWindow.mSurfacePosition.x, mainWindow.mSurfacePosition.y);
        goto L41
    L24:
        if (topActivity.isVisibleRequested() == true) goto L26;
    L30:
        removalInfo.deferRemoveMode = 1;
        goto L31
    L26:
        if (dc.mInputMethodWindow == null) goto L30;
        if (dc.isFixedRotationLaunchingApp(topActivity) == false) goto L30;
        removalInfo.deferRemoveMode = 2;
    L47:
        lastOrganizer.removeStartingWindow(removalInfo);     // Catch: RemoteException -> L44
        return;
    L44:
        e = move-exception;
        Slog.e(TAG, "Exception sending onStartTaskFinished callback", e);
        return;
    L14:
        if (task.getDisplayContent() == null) goto L18;
        if (task.getDisplayInfo().state != 2) goto L18;
        r6 = true;
        goto L19
    L7:
        lastOrganizer = getTaskOrganizer();
        goto L9
    }

    int addWindowlessStartingSurface(Task task, ActivityRecord activity, SurfaceControl root, TaskSnapshot taskSnapshot, Configuration configuration, IWindowlessStartingSurfaceCallback callback) {
        Task rootTask = task.getRootTask();
        if (rootTask != null) goto L5;
        return -1;
    L5:
        ITaskOrganizer lastOrganizer = this.mTaskOrganizers.peekLast();
        if (lastOrganizer != null) goto L8;
        return -1;
    L8:
        StartingWindowInfo info = task.getStartingWindowInfo(activity);
        info.taskInfo.configuration.setTo(configuration);
        ActivityManager.RunningTaskInfo r4 = info.taskInfo;
        r4.taskDescription = activity.taskDescription;
        info.taskSnapshot = taskSnapshot;
        info.windowlessStartingSurfaceCallback = callback;
        info.rootSurface = root;
        lastOrganizer.addStartingWindow(info);     // Catch: RemoteException -> L12
        return task.mTaskId;
    L12:
        e = move-exception;
        Slog.e(TAG, "Exception sending addWindowlessStartingSurface ", e);
        return -1;
    }

    void removeWindowlessStartingSurface(int taskId, boolean immediately) {
        ITaskOrganizer lastOrganizer = this.mTaskOrganizers.peekLast();
        if (lastOrganizer == null) goto L12;
        if (taskId == 0) goto L16;
        StartingWindowRemovalInfo removalInfo = new StartingWindowRemovalInfo();
        removalInfo.taskId = taskId;
        removalInfo.windowlessSurface = true;
        removalInfo.removeImmediately = immediately;
        removalInfo.deferRemoveMode = 3;
        lastOrganizer.removeStartingWindow(removalInfo);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Exception sending removeWindowlessStartingSurface ", e);
        return;
    L16:
        return;
    }

    boolean copySplashScreenView(Task task, ITaskOrganizer taskOrganizer) {
        Task rootTask = task.getRootTask();
        if (rootTask != null) goto L5;
        return false;
    L5:
        if (taskOrganizer == null) goto L7;
        ITaskOrganizer lastOrganizer = taskOrganizer;
    L9:
        if (lastOrganizer != null) goto L17;
        return false;
    L17:
        lastOrganizer.copySplashScreenView(task.mTaskId);     // Catch: RemoteException -> L14
        return true;
    L14:
        e = move-exception;
        Slog.e(TAG, "Exception sending copyStartingWindowView callback", e);
        return false;
    L7:
        lastOrganizer = getTaskOrganizer();
        goto L9
    }

    boolean isSupportWindowlessStartingSurface() {
        ITaskOrganizer lastOrganizer = this.mTaskOrganizers.peekLast();
        if (lastOrganizer == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void onAppSplashScreenViewRemoved(Task task, ITaskOrganizer organizer) {
        Task rootTask = task.getRootTask();
        if (rootTask != null) goto L5;
        return;
    L5:
        if (organizer == null) goto L7;
        ITaskOrganizer lastOrganizer = organizer;
    L8:
        if (lastOrganizer != null) goto L15;
        return;
    L15:
        lastOrganizer.onAppSplashScreenViewRemoved(task.mTaskId);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "Exception sending onAppSplashScreenViewRemoved callback", e);
        return;
    L7:
        lastOrganizer = getTaskOrganizer();
        goto L8
    }

    void onTaskAppeared(ITaskOrganizer organizer, Task task) {
        TaskOrganizerState state = this.mTaskOrganizerStates.get(organizer.asBinder());
        if (state != null) goto L5;
        return;
    L5:
        if (TaskOrganizerState.m10316$$Nest$maddTask(state, task) == false) goto L11;
        TaskOrganizerPendingEventsQueue pendingEvents = TaskOrganizerState.m10314$$Nest$fgetmPendingEventsQueue(state);
        PendingTaskEvent pending = TaskOrganizerPendingEventsQueue.m10311$$Nest$mgetPendingTaskEvent(pendingEvents, task, 0);
        if (pending != null) goto L12;
        pendingEvents.addPendingTaskEvent(new PendingTaskEvent(task, 0));
        return;
    L12:
        return;
    }

    void onTaskVanished(ITaskOrganizer organizer, Task task) {
        TaskOrganizerState state = this.mTaskOrganizerStates.get(organizer.asBinder());
        if (state != null) goto L5;
        return;
    L5:
        if (TaskOrganizerState.m10317$$Nest$mremoveTask(state, task, task.mRemoveWithTaskOrganizer) == false) goto L9;
        onTaskVanishedInternal(state, task);
        return;
    }

    private void onTaskVanishedInternal(TaskOrganizerState organizerState, Task task) {
        if (organizerState != null) goto L5;
        Slog.i(TAG, "cannot send onTaskVanished because organizer state is not present for this organizer");
        return;
    L5:
        TaskOrganizerPendingEventsQueue pendingEventsQueue = TaskOrganizerState.m10314$$Nest$fgetmPendingEventsQueue(organizerState);
        boolean hadPendingAppearedEvents = pendingEventsQueue.removePendingTaskEvents(task);
        if (hadPendingAppearedEvents == false) goto L8;
        return;
    L8:
        pendingEventsQueue.addPendingTaskEvent(new PendingTaskEvent(task, TaskOrganizerState.m10313$$Nest$fgetmOrganizer(organizerState).mTaskOrganizer, 1));
    }

    public void createRootTask(int displayId, int windowingMode, IBinder launchCookie, boolean removeWithTaskOrganizer) {
        ActivityTaskManagerService.enforceTaskPermission("createRootTask()");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L20
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
        DisplayContent display = this.mService.mRootWindowContainer.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (display == null) goto L8;
        createRootTask(display, windowingMode, launchCookie, removeWithTaskOrganizer);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[4] == false) goto L12;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -2286607251115721394L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L10
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    Task createRootTask(DisplayContent display, int windowingMode, IBinder launchCookie) {
        return createRootTask(display, windowingMode, launchCookie, false);
    }

    Task createRootTask(DisplayContent display, int windowingMode, IBinder launchCookie, boolean removeWithTaskOrganizer) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L5;
        long protoLogParam0 = display.mDisplayId;
        long protoLogParam1 = windowingMode;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 8466395828406204368L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});
    L5:
        Task task = new Task.Builder(this.mService).setWindowingMode(windowingMode).setIntent(new Intent()).setCreatedByOrganizer(true).setDeferTaskAppear(true).setLaunchCookie(launchCookie).setParent(display.getDefaultTaskDisplayArea()).setRemoveWithTaskOrganizer(removeWithTaskOrganizer).build();
        task.setDeferTaskAppear(false);
        return task;
    }

    public boolean deleteRootTask(WindowContainerToken token) {
        ActivityTaskManagerService.enforceTaskPermission("deleteRootTask()");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r4 = this.mGlobalLock;     // Catch: Throwable -> L31
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L31
        monitor-enter(r4);     // Catch: Throwable -> L31
        WindowContainer wc = WindowContainer.fromBinder(token.asBinder());     // Catch: Throwable -> L10
        if (wc != null) goto L12;
        monitor-exit(r4);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L12:
        Task task = wc.asTask();     // Catch: Throwable -> L10
        if (task != null) goto L18;
        monitor-exit(r4);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L18:
        if (task.mCreatedByOrganizer == false) goto L27;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L22;
        long protoLogParam0 = task.getDisplayId();     // Catch: Throwable -> L10
        long protoLogParam1 = task.getWindowingMode();     // Catch: Throwable -> L10
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 6867170298997192615L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});     // Catch: Throwable -> L10
    L22:
        task.remove(true, "deleteRootTask");     // Catch: Throwable -> L10
        monitor-exit(r4);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return true;
    L27:
        throw new IllegalArgumentException("Attempt to delete task not created by organizer task=" + task);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    void dispatchPendingEvents() {
        if (this.mService.mWindowManager.mWindowPlacerLocked.isLayoutDeferred() == false) goto L5;
        return;
    L5:
        int taskOrgIdx = 0;
    L7:
        if (taskOrgIdx >= this.mTaskOrganizerStates.size()) goto L10;
        TaskOrganizerState taskOrganizerState = this.mTaskOrganizerStates.valueAt(taskOrgIdx);
        TaskOrganizerState.m10314$$Nest$fgetmPendingEventsQueue(taskOrganizerState).dispatchPendingEvents();
        taskOrgIdx = taskOrgIdx + 1;
        goto L7
    }

    void reportImeDrawnOnTask(Task task) {
        TaskOrganizerState state = this.mTaskOrganizerStates.get(task.mTaskOrganizer.asBinder());
        if (state == null) goto L11;
        TaskOrganizerState.m10313$$Nest$fgetmOrganizer(state).mTaskOrganizer.onImeDrawnOnTask(task.mTaskId);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Exception sending onImeDrawnOnTask callback", e);
        return;
    }

    void onTaskInfoChanged(Task task, boolean force) {
        if (task.mTaskAppearedSent == true) goto L5;
        return;
    L5:
        TaskOrganizerState taskOrganizerState = this.mTaskOrganizerStates.get(task.mTaskOrganizer.asBinder());
        TaskOrganizerPendingEventsQueue pendingEventsQueue = TaskOrganizerState.m10314$$Nest$fgetmPendingEventsQueue(taskOrganizerState);
        if (pendingEventsQueue != null) goto L9;
        Slog.i(TAG, "cannot send onTaskInfoChanged because pending events queue is not present for this organizer");
        return;
    L9:
        if (force == true) goto L11;
    L14:
        PendingTaskEvent pending = pendingEventsQueue.getPendingLifecycleTaskEvent(task);
        if (pending != null) goto L18;
        pending = new PendingTaskEvent(task, 2);
    L21:
        pending.mForce |= force;
        pendingEventsQueue.addPendingTaskEvent(pending);
        return;
    L18:
        if (pending.mEventType == 2) goto L20;
        return;
    L20:
        pendingEventsQueue.removePendingTaskEvent(pending);
        goto L21
    L11:
        if (pendingEventsQueue.numPendingTaskEvents() != 0) goto L14;
        TaskOrganizerPendingEventsQueue.m10310$$Nest$mdispatchTaskInfoChanged(pendingEventsQueue, task, true);
    }

    public WindowContainerToken getImeTarget(int displayId) {
        ActivityTaskManagerService.enforceTaskPermission("getImeTarget()");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L33
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L33
        monitor-enter(r2);     // Catch: Throwable -> L33
        DisplayContent dc = this.mService.mWindowManager.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (dc != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return null;
    L13:
        InsetsControlTarget imeLayeringTarget = dc.getImeTarget(0);     // Catch: Throwable -> L10
        if (imeLayeringTarget == null) goto L27;
        if (imeLayeringTarget.getWindow() == null) goto L27;
        Task task = imeLayeringTarget.getWindow().getTask();     // Catch: Throwable -> L10
        if (task != null) goto L23;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return null;
    L23:
        WindowContainerToken r4 = task.mRemoteToken.toWindowContainerToken();     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r4;
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return null;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public List<ActivityManager.RunningTaskInfo> getChildTasks(WindowContainerToken parent, int[] activityTypes) {
        ActivityTaskManagerService.enforceTaskPermission("getChildTasks()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L46
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L46
        monitor-enter(r2);     // Catch: Throwable -> L46
        if (parent == null) goto L42;
        WindowContainer container = WindowContainer.fromBinder(parent.asBinder());     // Catch: Throwable -> L12
        if (container != null) goto L14;
        Slog.e(TAG, "Can't get children of " + parent + " because it is not valid.");     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return null;
    L14:
        Task task = container.asTask();     // Catch: Throwable -> L12
        if (task != null) goto L21;
        Slog.e(TAG, container + " is not a task...");     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return null;
    L21:
        if (task.mCreatedByOrganizer == true) goto L26;
        Slog.w(TAG, "Can only get children of root tasks created via createRootTask");     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return null;
    L26:
        ArrayList<ActivityManager.RunningTaskInfo> out = new ArrayList();     // Catch: Throwable -> L12
        int i = task.getChildCount() - 1;     // Catch: Throwable -> L12
    L27:
        if (i < 0) goto L38;
        Task child = task.getChildAt(i).asTask();     // Catch: Throwable -> L12
        if (child == null) goto L36;
        if (activityTypes != null) goto L33;
    L35:
        out.add(child.getTaskInfo());     // Catch: Throwable -> L12
        goto L36
    L33:
        if (ArrayUtils.contains(activityTypes, child.getActivityType()) == true) goto L35;
    L36:
        i = i - 1;     // Catch: Throwable -> L12
        goto L27
    L38:
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return out;
    L42:
        throw new IllegalArgumentException("Can't get children of null parent");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public List<ActivityManager.RunningTaskInfo> getRootTasks(int displayId, final int[] activityTypes) {
        ActivityTaskManagerService.enforceTaskPermission("getRootTasks()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L18
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L18
        monitor-enter(r2);     // Catch: Throwable -> L18
        DisplayContent dc = this.mService.mRootWindowContainer.getDisplayContent(displayId);     // Catch: Throwable -> L11
        if (dc == null) goto L14;
        final ArrayList<ActivityManager.RunningTaskInfo> out = new ArrayList();     // Catch: Throwable -> L11
        dc.forAllRootTasks(new TaskOrganizerController$$ExternalSyntheticLambda0(activityTypes, out));     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return out;
    L14:
        throw new IllegalArgumentException("Display " + displayId + " doesn't exist");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private static /* synthetic */ void lambda$getRootTasks$3(int[] activityTypes, ArrayList out, Task task) {
        if (activityTypes != null) goto L4;
    L6:
        out.add(task.getTaskInfo());
        return;
    L4:
        if (ArrayUtils.contains(activityTypes, task.getActivityType()) == true) goto L6;
    }

    public void setInterceptBackPressedOnTaskRoot(WindowContainerToken token, boolean interceptBackPressed) {
        ActivityTaskManagerService.enforceTaskPermission("setInterceptBackPressedOnTaskRoot()");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L29
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L29
        monitor-enter(r2);     // Catch: Throwable -> L29
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L10;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -4296644831871159510L, 3, new Object[]{Boolean.valueOf(interceptBackPressed)});     // Catch: Throwable -> L8
    L10:
        WindowContainer wc = WindowContainer.fromBinder(token.asBinder());     // Catch: Throwable -> L8
        if (wc != null) goto L16;
        Slog.w(TAG, "Could not resolve window from token");     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L16:
        Task task = wc.asTask();     // Catch: Throwable -> L8
        if (task != null) goto L22;
        Slog.w(TAG, "Could not resolve task from token");     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L22:
        if (interceptBackPressed == false) goto L24;
        this.mInterceptBackPressedOnRootTasks.add(Integer.valueOf(task.mTaskId));     // Catch: Throwable -> L8
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(origId);
        return;
    L24:
        this.mInterceptBackPressedOnRootTasks.remove(Integer.valueOf(task.mTaskId));     // Catch: Throwable -> L8
    L29:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void restartTaskTopActivityProcessIfVisible(WindowContainerToken token) {
        ActivityTaskManagerService.enforceTaskPermission("restartTopActivityProcessIfVisible()");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L29
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L29
        monitor-enter(r2);     // Catch: Throwable -> L29
        WindowContainer wc = WindowContainer.fromBinder(token.asBinder());     // Catch: Throwable -> L11
        if (wc != null) goto L13;
        Slog.w(TAG, "Could not resolve window from token");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L13:
        Task task = wc.asTask();     // Catch: Throwable -> L11
        if (task != null) goto L20;
        Slog.w(TAG, "Could not resolve task from token");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L20:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L22;
        long protoLogParam0 = task.mTaskId;     // Catch: Throwable -> L11
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -558727273888268534L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L11
    L22:
        ActivityRecord activity = task.getTopNonFinishingActivity();     // Catch: Throwable -> L11
        if (activity == null) goto L25;
        activity.restartProcessIfVisible();     // Catch: Throwable -> L11
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(origId);
        return;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public boolean handleInterceptBackPressedOnTaskRoot(Task task) {
        if (shouldInterceptBackPressedOnRootTask(task) == true) goto L5;
        return false;
    L5:
        TaskOrganizerPendingEventsQueue pendingEventsQueue = TaskOrganizerState.m10314$$Nest$fgetmPendingEventsQueue(this.mTaskOrganizerStates.get(task.mTaskOrganizer.asBinder()));
        if (pendingEventsQueue != null) goto L9;
        Slog.w(TAG, "cannot get handle BackPressedOnTaskRoot because organizerState is not present");
        return false;
    L9:
        PendingTaskEvent pendingVanished = TaskOrganizerPendingEventsQueue.m10311$$Nest$mgetPendingTaskEvent(pendingEventsQueue, task, 1);
        if (pendingVanished == null) goto L12;
        return false;
    L12:
        PendingTaskEvent pending = TaskOrganizerPendingEventsQueue.m10311$$Nest$mgetPendingTaskEvent(pendingEventsQueue, task, 3);
        if (pending != null) goto L15;
        pending = new PendingTaskEvent(task, 3);
    L16:
        pendingEventsQueue.addPendingTaskEvent(pending);
        this.mService.mWindowManager.mWindowPlacerLocked.requestTraversal();
        return true;
    L15:
        pendingEventsQueue.removePendingTaskEvent(pending);
        goto L16
    }

    boolean shouldInterceptBackPressedOnRootTask(Task task) {
        if (task != null) goto L4;
    L8:
        return false;
    L4:
        if (task.isOrganized() == false) goto L8;
        if (this.mInterceptBackPressedOnRootTasks.contains(Integer.valueOf(task.mTaskId)) == false) goto L8;
        return true;
    }

    public void dump(PrintWriter pw, String prefix) {
        String innerPrefix = prefix + "  ";
        pw.print(prefix);
        pw.println("TaskOrganizerController:");
        ITaskOrganizer lastOrganizer = this.mTaskOrganizers.peekLast();
        Iterator<ITaskOrganizer> r3 = this.mTaskOrganizers.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        ITaskOrganizer organizer = r3.next();
        TaskOrganizerState state = this.mTaskOrganizerStates.get(organizer.asBinder());
        ArrayList<Task> tasks = TaskOrganizerState.m10312$$Nest$fgetmOrganizedTasks(state);
        pw.print(innerPrefix + "  ");
        pw.print(TaskOrganizerState.m10313$$Nest$fgetmOrganizer(state).mTaskOrganizer + " uid=" + TaskOrganizerState.m10315$$Nest$fgetmUid(state));
        if (lastOrganizer != organizer) goto L8;
        pw.print(" (active)");
    L8:
        pw.println(':');
        int k = 0;
    L10:
        if (k >= tasks.size()) goto L4;
        Task task = tasks.get(k);
        int mode = task.getWindowingMode();
        pw.println(innerPrefix + "    (" + WindowConfiguration.windowingModeToString(mode) + ") " + task);
        k = k + 1;
        goto L10
    L13:
        pw.println();
    }

    TaskOrganizerState getTaskOrganizerState(IBinder taskOrganizer) {
        return this.mTaskOrganizerStates.get(taskOrganizer);
    }

    TaskOrganizerPendingEventsQueue getTaskOrganizerPendingEvents(IBinder taskOrganizer) {
        return TaskOrganizerState.m10314$$Nest$fgetmPendingEventsQueue(this.mTaskOrganizerStates.get(taskOrganizer));
    }

    public IExtTaskOrganizerController getExt() {
        return this.mExt;
    }
}
