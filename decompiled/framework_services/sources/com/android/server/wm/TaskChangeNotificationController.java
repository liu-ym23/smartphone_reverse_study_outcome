package com.android.server.wm;

import android.app.ActivityManager;
import android.app.ITaskStackListener;
import android.app.TaskInfo;
import android.app.TaskStackListener;
import android.content.ComponentName;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.window.TaskSnapshot;
import com.android.internal.os.SomeArgs;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class TaskChangeNotificationController {
    private static final int NOTIFY_ACTIVITY_DISMISSING_DOCKED_ROOT_TASK_MSG = 7;
    private static final int NOTIFY_ACTIVITY_LAUNCH_ON_SECONDARY_DISPLAY_FAILED_MSG = 18;
    private static final int NOTIFY_ACTIVITY_LAUNCH_ON_SECONDARY_DISPLAY_REROUTED_MSG = 19;
    private static final int NOTIFY_ACTIVITY_PINNED_LISTENERS_MSG = 3;
    private static final int NOTIFY_ACTIVITY_REQUESTED_ORIENTATION_CHANGED_LISTENERS = 12;
    private static final int NOTIFY_ACTIVITY_RESTART_ATTEMPT_LISTENERS_MSG = 4;
    private static final int NOTIFY_ACTIVITY_ROTATED_MSG = 26;
    private static final int NOTIFY_ACTIVITY_UNPINNED_LISTENERS_MSG = 17;
    private static final int NOTIFY_BACK_PRESSED_ON_TASK_ROOT = 20;
    private static final int NOTIFY_FORCED_RESIZABLE_MSG = 6;
    private static final int NOTIFY_LOCK_TASK_MODE_CHANGED_MSG = 28;
    private static final int NOTIFY_RECENT_TASK_REMOVED_FOR_ADD_TASK_LISTENERS_MSG = 30;
    private static final int NOTIFY_TASK_ADDED_LISTENERS_MSG = 8;
    private static final int NOTIFY_TASK_DESCRIPTION_CHANGED_LISTENERS_MSG = 11;
    private static final int NOTIFY_TASK_DISPLAY_CHANGED_LISTENERS_MSG = 21;
    private static final int NOTIFY_TASK_FOCUS_CHANGED_MSG = 24;
    private static final int NOTIFY_TASK_LIST_FROZEN_UNFROZEN_MSG = 23;
    private static final int NOTIFY_TASK_LIST_UPDATED_LISTENERS_MSG = 22;
    private static final int NOTIFY_TASK_MOVED_TO_BACK_LISTENERS_MSG = 27;
    private static final int NOTIFY_TASK_MOVED_TO_FRONT_LISTENERS_MSG = 10;
    private static final int NOTIFY_TASK_PROFILE_LOCKED_LISTENERS_MSG = 14;
    private static final int NOTIFY_TASK_REMOVAL_STARTED_LISTENERS = 13;
    private static final int NOTIFY_TASK_REMOVED_LISTENERS_MSG = 9;
    private static final int NOTIFY_TASK_REQUESTED_ORIENTATION_CHANGED_MSG = 25;
    private static final int NOTIFY_TASK_SNAPSHOT_CHANGED_LISTENERS_MSG = 15;
    private static final int NOTIFY_TASK_SNAPSHOT_INVALIDATED_LISTENERS_MSG = 29;
    private static final int NOTIFY_TASK_STACK_CHANGE_LISTENERS_DELAY = 100;
    private static final int NOTIFY_TASK_STACK_CHANGE_LISTENERS_MSG = 2;
    private final Handler mHandler;
    private final ArrayList<ITaskStackListener> mLocalTaskStackListeners;
    private final TaskStackConsumer mNotifyActivityDismissingDockedTask;
    private final TaskStackConsumer mNotifyActivityForcedResizable;
    private final TaskStackConsumer mNotifyActivityLaunchOnSecondaryDisplayFailed;
    private final TaskStackConsumer mNotifyActivityLaunchOnSecondaryDisplayRerouted;
    private final TaskStackConsumer mNotifyActivityPinned;
    private final TaskStackConsumer mNotifyActivityRequestedOrientationChanged;
    private final TaskStackConsumer mNotifyActivityRestartAttempt;
    private final TaskStackConsumer mNotifyActivityUnpinned;
    private final TaskStackConsumer mNotifyBackPressedOnTaskRoot;
    private final TaskStackConsumer mNotifyLockTaskModeChanged;
    private final TaskStackConsumer mNotifyOnActivityRotation;
    private final TaskStackConsumer mNotifyRecentTaskRemovedForAddTask;
    private final TaskStackConsumer mNotifyTaskCreated;
    private final TaskStackConsumer mNotifyTaskDescriptionChanged;
    private final TaskStackConsumer mNotifyTaskDisplayChanged;
    private final TaskStackConsumer mNotifyTaskFocusChanged;
    private final TaskStackConsumer mNotifyTaskListFrozen;
    private final TaskStackConsumer mNotifyTaskListUpdated;
    private final TaskStackConsumer mNotifyTaskMovedToBack;
    private final TaskStackConsumer mNotifyTaskMovedToFront;
    private final TaskStackConsumer mNotifyTaskProfileLocked;
    private final TaskStackConsumer mNotifyTaskRemovalStarted;
    private final TaskStackConsumer mNotifyTaskRemoved;
    private final TaskStackConsumer mNotifyTaskRequestedOrientationChanged;
    private final TaskStackConsumer mNotifyTaskSnapshotChanged;
    private final TaskStackConsumer mNotifyTaskSnapshotInvalidated;
    private final TaskStackConsumer mNotifyTaskStackChanged;
    private final RemoteCallbackList<ITaskStackListener> mRemoteTaskStackListeners;
    private final ActivityTaskSupervisor mTaskSupervisor;

    private class MainHandler extends Handler {
        final /* synthetic */ TaskChangeNotificationController this$0;

        public MainHandler(TaskChangeNotificationController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 2: goto L31;
                case 3: goto L30;
                case 4: goto L29;
                case 5: goto L33;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 12: goto L22;
                case 13: goto L21;
                case 14: goto L20;
                case 15: goto L19;
                case 16: goto L33;
                case 17: goto L18;
                case 18: goto L17;
                case 19: goto L16;
                case 20: goto L15;
                case 21: goto L14;
                case 22: goto L13;
                case 23: goto L12;
                case 24: goto L11;
                case 25: goto L10;
                case 26: goto L9;
                case 27: goto L8;
                case 28: goto L7;
                case 29: goto L6;
                case 30: goto L5;
                default: goto L33;
            };
        L5:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10236$$Nest$fgetmNotifyRecentTaskRemovedForAddTask(this.this$0), msg);
            goto L33
        L6:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10250$$Nest$fgetmNotifyTaskSnapshotInvalidated(this.this$0), msg);
            goto L33
        L7:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10234$$Nest$fgetmNotifyLockTaskModeChanged(this.this$0), msg);
            goto L33
        L8:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10243$$Nest$fgetmNotifyTaskMovedToBack(this.this$0), msg);
            goto L33
        L9:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10235$$Nest$fgetmNotifyOnActivityRotation(this.this$0), msg);
            goto L33
        L10:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10248$$Nest$fgetmNotifyTaskRequestedOrientationChanged(this.this$0), msg);
            goto L33
        L11:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10240$$Nest$fgetmNotifyTaskFocusChanged(this.this$0), msg);
            goto L33
        L12:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10241$$Nest$fgetmNotifyTaskListFrozen(this.this$0), msg);
            goto L33
        L13:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10242$$Nest$fgetmNotifyTaskListUpdated(this.this$0), msg);
            goto L33
        L14:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10239$$Nest$fgetmNotifyTaskDisplayChanged(this.this$0), msg);
            goto L33
        L15:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10233$$Nest$fgetmNotifyBackPressedOnTaskRoot(this.this$0), msg);
            goto L33
        L16:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10228$$Nest$fgetmNotifyActivityLaunchOnSecondaryDisplayRerouted(this.this$0), msg);
            goto L33
        L17:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10227$$Nest$fgetmNotifyActivityLaunchOnSecondaryDisplayFailed(this.this$0), msg);
            goto L33
        L18:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10232$$Nest$fgetmNotifyActivityUnpinned(this.this$0), msg);
            goto L33
        L19:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10249$$Nest$fgetmNotifyTaskSnapshotChanged(this.this$0), msg);
            ((TaskSnapshot) msg.obj).removeReference(1);
            goto L33
        L20:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10245$$Nest$fgetmNotifyTaskProfileLocked(this.this$0), msg);
            goto L33
        L21:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10246$$Nest$fgetmNotifyTaskRemovalStarted(this.this$0), msg);
            goto L33
        L22:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10230$$Nest$fgetmNotifyActivityRequestedOrientationChanged(this.this$0), msg);
            goto L33
        L23:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10238$$Nest$fgetmNotifyTaskDescriptionChanged(this.this$0), msg);
            goto L33
        L24:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10244$$Nest$fgetmNotifyTaskMovedToFront(this.this$0), msg);
            goto L33
        L25:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10247$$Nest$fgetmNotifyTaskRemoved(this.this$0), msg);
            goto L33
        L26:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10237$$Nest$fgetmNotifyTaskCreated(this.this$0), msg);
            goto L33
        L27:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10225$$Nest$fgetmNotifyActivityDismissingDockedTask(this.this$0), msg);
            goto L33
        L28:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10226$$Nest$fgetmNotifyActivityForcedResizable(this.this$0), msg);
            goto L33
        L29:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10231$$Nest$fgetmNotifyActivityRestartAttempt(this.this$0), msg);
            goto L33
        L30:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10229$$Nest$fgetmNotifyActivityPinned(this.this$0), msg);
            goto L33
        L31:
            TaskChangeNotificationController.m10252$$Nest$mforAllRemoteListeners(this.this$0, TaskChangeNotificationController.m10251$$Nest$fgetmNotifyTaskStackChanged(this.this$0), msg);
        L33:
            if ((msg.obj instanceof SomeArgs) == false) goto L36;
            ((SomeArgs) msg.obj).recycle();
            return;
        }
    }

    @FunctionalInterface
    public interface TaskStackConsumer {
        void accept(ITaskStackListener r1, Message r2) throws RemoteException;
    }

    /* JADX INFO: renamed from: $r8$lambda$3efeevBcFcEyR-6HMS-AzpBtZg8, reason: not valid java name */
    public static /* synthetic */ void m10218$r8$lambda$3efeevBcFcEyR6HMSAzpBtZg8(ITaskStackListener r0, Message r1) {
        lambda$new$14(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$4eLcfeE5EsykOVynmzu3fgpLtiE(ITaskStackListener r0, Message r1) {
        lambda$new$17(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$B9YMzj4Sx7x6o6GellcYz2j42C4(ITaskStackListener r0, Message r1) {
        lambda$new$9(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ERSwJdfirclxo_SxwopIJjviC-4, reason: not valid java name */
    public static /* synthetic */ void m10219$r8$lambda$ERSwJdfirclxo_SxwopIJjviC4(ITaskStackListener r0, Message r1) {
        lambda$new$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Far2sAT8OX74Uk8OvCXTZTEXQY0(ITaskStackListener r0, Message r1) {
        lambda$new$19(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$JFI_F_hpE-kLZOK3Tx2KyHgWbCk, reason: not valid java name */
    public static /* synthetic */ void m10220$r8$lambda$JFI_F_hpEkLZOK3Tx2KyHgWbCk(ITaskStackListener r0, Message r1) {
        lambda$new$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$LF-U8QTnVFa2t1XdtsotWKGWJcQ, reason: not valid java name */
    public static /* synthetic */ void m10221$r8$lambda$LFU8QTnVFa2t1XdtsotWKGWJcQ(ITaskStackListener r0, Message r1) {
        lambda$new$24(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$LuO8UQe6O3yGvjwiF8c7unoxvm0(ITaskStackListener r0, Message r1) {
        lambda$new$22(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$NW5zZAkpJyS6Ig7DBkUclrq7o6E(ITaskStackListener r0, Message r1) {
        lambda$new$20(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$SzO5O63VCJS3xdIl0vSIMTp9t5U(ITaskStackListener r0, Message r1) {
        lambda$new$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$UIO9IjTxPd3zzG6wdFibHMsY7g4(ITaskStackListener r0, Message r1) {
        lambda$new$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Wk7V2a46XjNuYA1wEeCJbqFuseg(ITaskStackListener r0, Message r1) {
        lambda$new$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$XnL-keZKaVwst4Q0DM1DZhp59bY, reason: not valid java name */
    public static /* synthetic */ void m10222$r8$lambda$XnLkeZKaVwst4Q0DM1DZhp59bY(ITaskStackListener r0, Message r1) {
        lambda$new$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Yh2qVtKQXkA0n6eTAWdlt9I5bKk(ITaskStackListener r0, Message r1) {
        lambda$new$23(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$YtXFdKOJROtNGmU0MWIvvR9x4qE(ITaskStackListener r0, Message r1) {
        lambda$new$26(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZcHKF3Wd6aesC4NxELVljM1oRv8(ITaskStackListener r0, Message r1) {
        lambda$new$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ah1JsV-rMqKWq8lKZtNZ807zrV4, reason: not valid java name */
    public static /* synthetic */ void m10223$r8$lambda$ah1JsVrMqKWq8lKZtNZ807zrV4(ITaskStackListener r0, Message r1) {
        lambda$new$18(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$b5m5f-NmiMSK8k33c8h6brlvbYk, reason: not valid java name */
    public static /* synthetic */ void m10224$r8$lambda$b5m5fNmiMSK8k33c8h6brlvbYk(ITaskStackListener r0, Message r1) {
        lambda$new$21(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$dNAMwBiTlsfPwJwgNsJh6c1qPoE(ITaskStackListener r0, Message r1) {
        lambda$new$13(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$e8qpshHEGuPLoKkKOFxn_qSZ944(ITaskStackListener r0, Message r1) {
        lambda$new$25(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$k4E8J8DdV86uqZN5ysVsMzpxnHQ(ITaskStackListener r0, Message r1) {
        lambda$new$12(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$oJcrjS8ku_Fs2Otv51YQ4YBhiJA(ITaskStackListener r0, Message r1) {
        lambda$new$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$pEEKl3x7xNfwpK3bQNjwUvOrDNs(ITaskStackListener r0, Message r1) {
        lambda$new$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$q7SXkjHOPaMiTDqO9DXDmijw3uk(ITaskStackListener r0, Message r1) {
        lambda$new$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ql1_4BzTGQYBNhxtqcl4510uH8w(ITaskStackListener r0, Message r1) {
        lambda$new$16(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$qoDZrtY2jOJf4Ahc6jYayChKO5Q(ITaskStackListener r0, Message r1) {
        lambda$new$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$wkk0PabK880VZx6HrUI23jWZ2II(ITaskStackListener r0, Message r1) {
        lambda$new$15(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyActivityDismissingDockedTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10225$$Nest$fgetmNotifyActivityDismissingDockedTask(TaskChangeNotificationController r0) {
        return r0.mNotifyActivityDismissingDockedTask;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyActivityForcedResizable, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10226$$Nest$fgetmNotifyActivityForcedResizable(TaskChangeNotificationController r0) {
        return r0.mNotifyActivityForcedResizable;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyActivityLaunchOnSecondaryDisplayFailed, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10227$$Nest$fgetmNotifyActivityLaunchOnSecondaryDisplayFailed(TaskChangeNotificationController r0) {
        return r0.mNotifyActivityLaunchOnSecondaryDisplayFailed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyActivityLaunchOnSecondaryDisplayRerouted, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10228$$Nest$fgetmNotifyActivityLaunchOnSecondaryDisplayRerouted(TaskChangeNotificationController r0) {
        return r0.mNotifyActivityLaunchOnSecondaryDisplayRerouted;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyActivityPinned, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10229$$Nest$fgetmNotifyActivityPinned(TaskChangeNotificationController r0) {
        return r0.mNotifyActivityPinned;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyActivityRequestedOrientationChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10230$$Nest$fgetmNotifyActivityRequestedOrientationChanged(TaskChangeNotificationController r0) {
        return r0.mNotifyActivityRequestedOrientationChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyActivityRestartAttempt, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10231$$Nest$fgetmNotifyActivityRestartAttempt(TaskChangeNotificationController r0) {
        return r0.mNotifyActivityRestartAttempt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyActivityUnpinned, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10232$$Nest$fgetmNotifyActivityUnpinned(TaskChangeNotificationController r0) {
        return r0.mNotifyActivityUnpinned;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyBackPressedOnTaskRoot, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10233$$Nest$fgetmNotifyBackPressedOnTaskRoot(TaskChangeNotificationController r0) {
        return r0.mNotifyBackPressedOnTaskRoot;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyLockTaskModeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10234$$Nest$fgetmNotifyLockTaskModeChanged(TaskChangeNotificationController r0) {
        return r0.mNotifyLockTaskModeChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyOnActivityRotation, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10235$$Nest$fgetmNotifyOnActivityRotation(TaskChangeNotificationController r0) {
        return r0.mNotifyOnActivityRotation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyRecentTaskRemovedForAddTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10236$$Nest$fgetmNotifyRecentTaskRemovedForAddTask(TaskChangeNotificationController r0) {
        return r0.mNotifyRecentTaskRemovedForAddTask;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskCreated, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10237$$Nest$fgetmNotifyTaskCreated(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskCreated;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskDescriptionChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10238$$Nest$fgetmNotifyTaskDescriptionChanged(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskDescriptionChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskDisplayChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10239$$Nest$fgetmNotifyTaskDisplayChanged(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskDisplayChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskFocusChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10240$$Nest$fgetmNotifyTaskFocusChanged(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskFocusChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskListFrozen, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10241$$Nest$fgetmNotifyTaskListFrozen(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskListFrozen;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskListUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10242$$Nest$fgetmNotifyTaskListUpdated(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskListUpdated;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskMovedToBack, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10243$$Nest$fgetmNotifyTaskMovedToBack(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskMovedToBack;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskMovedToFront, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10244$$Nest$fgetmNotifyTaskMovedToFront(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskMovedToFront;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskProfileLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10245$$Nest$fgetmNotifyTaskProfileLocked(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskProfileLocked;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskRemovalStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10246$$Nest$fgetmNotifyTaskRemovalStarted(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskRemovalStarted;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10247$$Nest$fgetmNotifyTaskRemoved(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskRemoved;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskRequestedOrientationChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10248$$Nest$fgetmNotifyTaskRequestedOrientationChanged(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskRequestedOrientationChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskSnapshotChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10249$$Nest$fgetmNotifyTaskSnapshotChanged(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskSnapshotChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskSnapshotInvalidated, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10250$$Nest$fgetmNotifyTaskSnapshotInvalidated(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskSnapshotInvalidated;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifyTaskStackChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskStackConsumer m10251$$Nest$fgetmNotifyTaskStackChanged(TaskChangeNotificationController r0) {
        return r0.mNotifyTaskStackChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$mforAllRemoteListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10252$$Nest$mforAllRemoteListeners(TaskChangeNotificationController r0, TaskStackConsumer r1, Message r2) {
        r0.forAllRemoteListeners(r1, r2);
    }

    private static /* synthetic */ void lambda$new$0(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskStackChanged();
    }

    private static /* synthetic */ void lambda$new$1(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskCreated(m.arg1, (ComponentName) m.obj);
    }

    private static /* synthetic */ void lambda$new$2(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskRemoved(m.arg1);
    }

    private static /* synthetic */ void lambda$new$3(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskMovedToFront((ActivityManager.RunningTaskInfo) m.obj);
    }

    private static /* synthetic */ void lambda$new$4(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskDescriptionChanged((ActivityManager.RunningTaskInfo) m.obj);
    }

    private static /* synthetic */ void lambda$new$5(ITaskStackListener l, Message m) throws RemoteException {
        l.onBackPressedOnTaskRoot((ActivityManager.RunningTaskInfo) m.obj);
    }

    private static /* synthetic */ void lambda$new$6(ITaskStackListener l, Message m) throws RemoteException {
        l.onActivityRequestedOrientationChanged(m.arg1, m.arg2);
    }

    private static /* synthetic */ void lambda$new$7(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskRemovalStarted((ActivityManager.RunningTaskInfo) m.obj);
    }

    private static /* synthetic */ void lambda$new$8(ITaskStackListener l, Message m) throws RemoteException {
        l.onActivityPinned((String) m.obj, m.sendingUid, m.arg1, m.arg2);
    }

    private static /* synthetic */ void lambda$new$9(ITaskStackListener l, Message m) throws RemoteException {
        l.onActivityUnpinned();
    }

    private static /* synthetic */ void lambda$new$10(ITaskStackListener l, Message m) throws RemoteException {
        SomeArgs args = (SomeArgs) m.obj;
        ActivityManager.RunningTaskInfo r1 = (ActivityManager.RunningTaskInfo) args.arg1;
        boolean r3 = false;
        if (args.argi1 == 0) goto L5;
        boolean r2 = true;
    L7:
        if (args.argi2 == 0) goto L9;
        boolean r5 = true;
    L11:
        if (args.argi3 == 0) goto L13;
        r3 = true;
    L13:
        l.onActivityRestartAttempt(r1, r2, r5, r3);
        return;
    L9:
        r5 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    private static /* synthetic */ void lambda$new$11(ITaskStackListener l, Message m) throws RemoteException {
        l.onActivityForcedResizable((String) m.obj, m.arg1, m.arg2);
    }

    private static /* synthetic */ void lambda$new$12(ITaskStackListener l, Message m) throws RemoteException {
        l.onActivityDismissingDockedTask();
    }

    private static /* synthetic */ void lambda$new$13(ITaskStackListener l, Message m) throws RemoteException {
        l.onActivityLaunchOnSecondaryDisplayFailed((ActivityManager.RunningTaskInfo) m.obj, m.arg1);
    }

    private static /* synthetic */ void lambda$new$14(ITaskStackListener l, Message m) throws RemoteException {
        l.onActivityLaunchOnSecondaryDisplayRerouted((ActivityManager.RunningTaskInfo) m.obj, m.arg1);
    }

    private static /* synthetic */ void lambda$new$15(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskProfileLocked((ActivityManager.RunningTaskInfo) m.obj, m.arg1);
    }

    private static /* synthetic */ void lambda$new$16(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskSnapshotChanged(m.arg1, (TaskSnapshot) m.obj);
    }

    private static /* synthetic */ void lambda$new$17(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskSnapshotInvalidated(m.arg1);
    }

    private static /* synthetic */ void lambda$new$18(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskDisplayChanged(m.arg1, m.arg2);
    }

    private static /* synthetic */ void lambda$new$19(ITaskStackListener l, Message m) throws RemoteException {
        l.onRecentTaskListUpdated();
    }

    private static /* synthetic */ void lambda$new$20(ITaskStackListener l, Message m) throws RemoteException {
        if (m.arg1 == 0) goto L5;
        boolean r0 = true;
    L6:
        l.onRecentTaskListFrozenChanged(r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static /* synthetic */ void lambda$new$21(ITaskStackListener l, Message m) throws RemoteException {
        l.onRecentTaskRemovedForAddTask(m.arg1);
    }

    private static /* synthetic */ void lambda$new$22(ITaskStackListener l, Message m) throws RemoteException {
        int r0 = m.arg1;
        if (m.arg2 == 0) goto L5;
        boolean r1 = true;
    L6:
        l.onTaskFocusChanged(r0, r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private static /* synthetic */ void lambda$new$23(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskRequestedOrientationChanged(m.arg1, m.arg2);
    }

    private static /* synthetic */ void lambda$new$24(ITaskStackListener l, Message m) throws RemoteException {
        l.onActivityRotation(m.arg1);
    }

    private static /* synthetic */ void lambda$new$25(ITaskStackListener l, Message m) throws RemoteException {
        l.onTaskMovedToBack((ActivityManager.RunningTaskInfo) m.obj);
    }

    private static /* synthetic */ void lambda$new$26(ITaskStackListener l, Message m) throws RemoteException {
        l.onLockTaskModeChanged(m.arg1);
    }

    TaskChangeNotificationController(ActivityTaskSupervisor taskSupervisor, Handler handler) {
        this.mRemoteTaskStackListeners = new RemoteCallbackList();
        this.mLocalTaskStackListeners = new ArrayList();
        this.mNotifyTaskStackChanged = new TaskChangeNotificationController$$ExternalSyntheticLambda0();
        this.mNotifyTaskCreated = new TaskChangeNotificationController$$ExternalSyntheticLambda11();
        this.mNotifyTaskRemoved = new TaskChangeNotificationController$$ExternalSyntheticLambda19();
        this.mNotifyTaskMovedToFront = new TaskChangeNotificationController$$ExternalSyntheticLambda20();
        this.mNotifyTaskDescriptionChanged = new TaskChangeNotificationController$$ExternalSyntheticLambda21();
        this.mNotifyBackPressedOnTaskRoot = new TaskChangeNotificationController$$ExternalSyntheticLambda22();
        this.mNotifyActivityRequestedOrientationChanged = new TaskChangeNotificationController$$ExternalSyntheticLambda23();
        this.mNotifyTaskRemovalStarted = new TaskChangeNotificationController$$ExternalSyntheticLambda24();
        this.mNotifyActivityPinned = new TaskChangeNotificationController$$ExternalSyntheticLambda25();
        this.mNotifyActivityUnpinned = new TaskChangeNotificationController$$ExternalSyntheticLambda26();
        this.mNotifyActivityRestartAttempt = new TaskChangeNotificationController$$ExternalSyntheticLambda1();
        this.mNotifyActivityForcedResizable = new TaskChangeNotificationController$$ExternalSyntheticLambda2();
        this.mNotifyActivityDismissingDockedTask = new TaskChangeNotificationController$$ExternalSyntheticLambda3();
        this.mNotifyActivityLaunchOnSecondaryDisplayFailed = new TaskChangeNotificationController$$ExternalSyntheticLambda4();
        this.mNotifyActivityLaunchOnSecondaryDisplayRerouted = new TaskChangeNotificationController$$ExternalSyntheticLambda5();
        this.mNotifyTaskProfileLocked = new TaskChangeNotificationController$$ExternalSyntheticLambda6();
        this.mNotifyTaskSnapshotChanged = new TaskChangeNotificationController$$ExternalSyntheticLambda7();
        this.mNotifyTaskSnapshotInvalidated = new TaskChangeNotificationController$$ExternalSyntheticLambda8();
        this.mNotifyTaskDisplayChanged = new TaskChangeNotificationController$$ExternalSyntheticLambda9();
        this.mNotifyTaskListUpdated = new TaskChangeNotificationController$$ExternalSyntheticLambda10();
        this.mNotifyTaskListFrozen = new TaskChangeNotificationController$$ExternalSyntheticLambda12();
        this.mNotifyRecentTaskRemovedForAddTask = new TaskChangeNotificationController$$ExternalSyntheticLambda13();
        this.mNotifyTaskFocusChanged = new TaskChangeNotificationController$$ExternalSyntheticLambda14();
        this.mNotifyTaskRequestedOrientationChanged = new TaskChangeNotificationController$$ExternalSyntheticLambda15();
        this.mNotifyOnActivityRotation = new TaskChangeNotificationController$$ExternalSyntheticLambda16();
        this.mNotifyTaskMovedToBack = new TaskChangeNotificationController$$ExternalSyntheticLambda17();
        this.mNotifyLockTaskModeChanged = new TaskChangeNotificationController$$ExternalSyntheticLambda18();
        this.mTaskSupervisor = taskSupervisor;
        this.mHandler = new MainHandler(this, handler.getLooper());
    }

    public void registerTaskStackListener(ITaskStackListener listener) {
        if ((listener instanceof Binder) == false) goto L18;
        ArrayList<ITaskStackListener> r0 = this.mLocalTaskStackListeners;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mLocalTaskStackListeners.contains(listener) == false) goto L9;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L9:
        if ((listener instanceof TaskStackListener) == false) goto L13;
        ((TaskStackListener) listener).setIsLocal();     // Catch: Throwable -> L11
    L13:
        this.mLocalTaskStackListeners.add(listener);     // Catch: Throwable -> L11
        goto L14
    L18:
        if (listener == null) goto L24;
        this.mRemoteTaskStackListeners.register(listener);
        return;
    }

    public void unregisterTaskStackListener(ITaskStackListener listener) {
        if ((listener instanceof Binder) == false) goto L12;
        ArrayList<ITaskStackListener> r0 = this.mLocalTaskStackListeners;
        monitor-enter(r0);
        this.mLocalTaskStackListeners.remove(listener);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        if (listener == null) goto L18;
        this.mRemoteTaskStackListeners.unregister(listener);
        return;
    }

    private void forAllRemoteListeners(TaskStackConsumer callback, Message message) {
        int i = this.mRemoteTaskStackListeners.beginBroadcast() - 1;
    L3:
        if (i < 0) goto L8;
        callback.accept((ITaskStackListener) this.mRemoteTaskStackListeners.getBroadcastItem(i), message);     // Catch: RemoteException -> L6
    L7:
        i = i - 1;
        goto L3
    L8:
        this.mRemoteTaskStackListeners.finishBroadcast();
    }

    private void forAllLocalListeners(TaskStackConsumer callback, Message message) {
        ArrayList<ITaskStackListener> r0 = this.mLocalTaskStackListeners;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        int i = this.mLocalTaskStackListeners.size() - 1;
    L6:
        if (i < 0) goto L14;
        callback.accept(this.mLocalTaskStackListeners.get(i), message);     // Catch: Throwable -> L9 RemoteException -> L11
    L12:
        i = i - 1;
        goto L6
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    void notifyTaskStackChanged() {
        this.mTaskSupervisor.getActivityMetricsLogger().logWindowState();
        this.mHandler.removeMessages(2);
        Message msg = this.mHandler.obtainMessage(2);
        forAllLocalListeners(this.mNotifyTaskStackChanged, msg);
        this.mHandler.sendMessageDelayed(msg, 100);
    }

    void notifyActivityPinned(ActivityRecord r) {
        this.mHandler.removeMessages(3);
        Message msg = this.mHandler.obtainMessage(3, r.getTask().mTaskId, r.getRootTaskId(), r.packageName);
        msg.sendingUid = r.mUserId;
        forAllLocalListeners(this.mNotifyActivityPinned, msg);
        msg.sendToTarget();
    }

    void notifyActivityUnpinned() {
        this.mHandler.removeMessages(17);
        Message msg = this.mHandler.obtainMessage(17);
        forAllLocalListeners(this.mNotifyActivityUnpinned, msg);
        msg.sendToTarget();
    }

    void notifyActivityRestartAttempt(ActivityManager.RunningTaskInfo r4, boolean r5, boolean r6, boolean r7) {
        this.mHandler.removeMessages(4);
        SomeArgs r0 = SomeArgs.obtain();
        r0.arg1 = r4;
        r0.argi1 = r5 ? 1 : 0;
        r0.argi2 = r6 ? 1 : 0;
        r0.argi3 = r7 ? 1 : 0;
        Message r1 = this.mHandler.obtainMessage(4, r0);
        forAllLocalListeners(this.mNotifyActivityRestartAttempt, r1);
        r1.sendToTarget();
    }

    void notifyActivityDismissingDockedRootTask() {
        this.mHandler.removeMessages(7);
        Message msg = this.mHandler.obtainMessage(7);
        forAllLocalListeners(this.mNotifyActivityDismissingDockedTask, msg);
        msg.sendToTarget();
    }

    void notifyActivityForcedResizable(int taskId, int reason, String packageName) {
        this.mHandler.removeMessages(6);
        Message msg = this.mHandler.obtainMessage(6, taskId, reason, packageName);
        forAllLocalListeners(this.mNotifyActivityForcedResizable, msg);
        msg.sendToTarget();
    }

    void notifyActivityLaunchOnSecondaryDisplayFailed(TaskInfo ti, int requestedDisplayId) {
        this.mHandler.removeMessages(18);
        Message msg = this.mHandler.obtainMessage(18, requestedDisplayId, 0, ti);
        forAllLocalListeners(this.mNotifyActivityLaunchOnSecondaryDisplayFailed, msg);
        msg.sendToTarget();
    }

    void notifyActivityLaunchOnSecondaryDisplayRerouted(TaskInfo ti, int requestedDisplayId) {
        this.mHandler.removeMessages(19);
        Message msg = this.mHandler.obtainMessage(19, requestedDisplayId, 0, ti);
        forAllLocalListeners(this.mNotifyActivityLaunchOnSecondaryDisplayRerouted, msg);
        msg.sendToTarget();
    }

    void notifyTaskCreated(int taskId, ComponentName componentName) {
        Message msg = this.mHandler.obtainMessage(8, taskId, 0, componentName);
        forAllLocalListeners(this.mNotifyTaskCreated, msg);
        msg.sendToTarget();
    }

    void notifyTaskRemoved(int taskId) {
        Message msg = this.mHandler.obtainMessage(9, taskId, 0);
        forAllLocalListeners(this.mNotifyTaskRemoved, msg);
        msg.sendToTarget();
    }

    void notifyTaskMovedToFront(TaskInfo ti) {
        Message msg = this.mHandler.obtainMessage(10, ti);
        forAllLocalListeners(this.mNotifyTaskMovedToFront, msg);
        msg.sendToTarget();
    }

    void notifyTaskDescriptionChanged(TaskInfo taskInfo) {
        Message msg = this.mHandler.obtainMessage(11, taskInfo);
        forAllLocalListeners(this.mNotifyTaskDescriptionChanged, msg);
        msg.sendToTarget();
    }

    void notifyActivityRequestedOrientationChanged(int taskId, int orientation) {
        Message msg = this.mHandler.obtainMessage(12, taskId, orientation);
        forAllLocalListeners(this.mNotifyActivityRequestedOrientationChanged, msg);
        msg.sendToTarget();
    }

    void notifyTaskRemovalStarted(ActivityManager.RunningTaskInfo taskInfo) {
        Message msg = this.mHandler.obtainMessage(13, taskInfo);
        forAllLocalListeners(this.mNotifyTaskRemovalStarted, msg);
        msg.sendToTarget();
    }

    void notifyTaskProfileLocked(ActivityManager.RunningTaskInfo taskInfo, int userId) {
        Message msg = this.mHandler.obtainMessage(14, userId, 0, taskInfo);
        forAllLocalListeners(this.mNotifyTaskProfileLocked, msg);
        msg.sendToTarget();
    }

    void notifyTaskSnapshotChanged(int taskId, TaskSnapshot snapshot) {
        snapshot.addReference(1);
        Message msg = this.mHandler.obtainMessage(15, taskId, 0, snapshot);
        forAllLocalListeners(this.mNotifyTaskSnapshotChanged, msg);
        msg.sendToTarget();
    }

    void notifyTaskSnapshotInvalidated(int taskId) {
        Message msg = this.mHandler.obtainMessage(29, taskId, 0);
        forAllLocalListeners(this.mNotifyTaskSnapshotInvalidated, msg);
        msg.sendToTarget();
    }

    void notifyBackPressedOnTaskRoot(TaskInfo taskInfo) {
        Message msg = this.mHandler.obtainMessage(20, taskInfo);
        forAllLocalListeners(this.mNotifyBackPressedOnTaskRoot, msg);
        msg.sendToTarget();
    }

    void notifyTaskDisplayChanged(int taskId, int newDisplayId) {
        Message msg = this.mHandler.obtainMessage(21, taskId, newDisplayId);
        forAllLocalListeners(this.mNotifyTaskDisplayChanged, msg);
        msg.sendToTarget();
    }

    void notifyTaskListUpdated() {
        Message msg = this.mHandler.obtainMessage(22);
        forAllLocalListeners(this.mNotifyTaskListUpdated, msg);
        msg.sendToTarget();
    }

    void notifyTaskListFrozen(boolean r4) {
        Message r0 = this.mHandler.obtainMessage(23, r4 ? 1 : 0, 0);
        forAllLocalListeners(this.mNotifyTaskListFrozen, r0);
        r0.sendToTarget();
    }

    void notifyRecentTaskRemovedForAddTask(int taskId) {
        Message msg = this.mHandler.obtainMessage(30, taskId, 0);
        forAllLocalListeners(this.mNotifyRecentTaskRemovedForAddTask, msg);
        msg.sendToTarget();
    }

    void notifyTaskFocusChanged(int r3, boolean r4) {
        Message r0 = this.mHandler.obtainMessage(24, r3, r4 ? 1 : 0);
        forAllLocalListeners(this.mNotifyTaskFocusChanged, r0);
        r0.sendToTarget();
    }

    void notifyTaskRequestedOrientationChanged(int taskId, int requestedOrientation) {
        Message msg = this.mHandler.obtainMessage(25, taskId, requestedOrientation);
        forAllLocalListeners(this.mNotifyTaskRequestedOrientationChanged, msg);
        msg.sendToTarget();
    }

    void notifyOnActivityRotation(int displayId) {
        Message msg = this.mHandler.obtainMessage(26, displayId, 0);
        forAllLocalListeners(this.mNotifyOnActivityRotation, msg);
        msg.sendToTarget();
    }

    void notifyTaskMovedToBack(TaskInfo ti) {
        Message msg = this.mHandler.obtainMessage(27, ti);
        forAllLocalListeners(this.mNotifyTaskMovedToBack, msg);
        msg.sendToTarget();
    }

    void notifyLockTaskModeChanged(int lockTaskModeState) {
        Message msg = this.mHandler.obtainMessage(28, lockTaskModeState, 0);
        forAllLocalListeners(this.mNotifyLockTaskModeChanged, msg);
        msg.sendToTarget();
    }
}
