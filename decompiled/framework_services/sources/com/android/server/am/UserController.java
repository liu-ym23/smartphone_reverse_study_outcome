package com.android.server.am;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.BroadcastOptions;
import android.app.IStopUserCallback;
import android.app.IUserSwitchObserver;
import android.app.KeyguardManager;
import android.app.doppelganger.DoppelgangerManager;
import android.appwidget.AppWidgetManagerInternal;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.PermissionChecker;
import android.content.pm.IPackageManager;
import android.content.pm.PackagePartitions;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.IProgressListener;
import android.os.IRemoteCallback;
import android.os.IUserManager;
import android.os.Message;
import android.os.PowerManagerInternal;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.IStorageManager;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.IntArray;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.ObjectUtils;
import com.android.internal.util.Preconditions;
import com.android.internal.util.ProgressReporter;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.AlarmManagerInternal;
import com.android.server.FactoryResetter;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.SystemServiceManager;
import com.android.server.pm.UserJourneyLogger;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.UserManagerService;
import com.android.server.utils.Slogf;
import com.android.server.utils.TimingsTraceAndSlog;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerService;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes.dex */
class UserController implements Handler.Callback {
    static final int CLEAR_USER_JOURNEY_SESSION_MSG = 200;
    static final int COMPLETE_USER_SWITCH_MSG = 130;
    static final int CONTINUE_USER_SWITCH_MSG = 20;
    static final int DEFAULT_USER_SWITCH_TIMEOUT_MS = 3000;
    static final int FOREGROUND_PROFILE_CHANGED_MSG = 70;
    private static final int LONG_USER_SWITCH_OBSERVER_WARNING_TIME_MS = 500;
    private static final int NO_ARG2 = 0;
    static final int REPORT_LOCKED_BOOT_COMPLETE_MSG = 110;
    static final int REPORT_USER_SWITCH_COMPLETE_MSG = 80;
    static final int REPORT_USER_SWITCH_MSG = 10;
    static final int SCHEDULED_STOP_BACKGROUND_USER_MSG = 150;
    static final int START_PROFILES_MSG = 40;
    static final int START_USER_SWITCH_FG_MSG = 120;
    static final int START_USER_SWITCH_UI_MSG = 1000;
    private static final String TAG = "ActivityManager";
    private static final long TIME_BEFORE_USERS_ALARM_TO_AVOID_STOPPING_MS = 3600000;
    private static final int USER_COMPLETED_EVENT_DELAY_MS = 5000;
    static final int USER_COMPLETED_EVENT_MSG = 140;
    static final int USER_CURRENT_MSG = 60;
    private static final int USER_JOURNEY_TIMEOUT_MS = 90000;
    static final int USER_START_MSG = 50;
    static final int USER_SWITCHING_DIALOG_ANIMATION_TIMEOUT_MSG = 160;
    private static final int USER_SWITCH_CALLBACKS_TIMEOUT_MS = 5000;
    static final int USER_SWITCH_CALLBACKS_TIMEOUT_MSG = 90;
    static final int USER_SWITCH_TIMEOUT_MSG = 30;
    static final int USER_UNLOCKED_MSG = 105;
    static final int USER_UNLOCK_MSG = 100;
    private volatile boolean mAllowUserUnlocking;
    private int mBackgroundUserScheduledStopTimeSecs;
    volatile boolean mBootCompleted;
    private final SparseIntArray mCompletedEventTypes;
    private volatile ArraySet<String> mCurWaitingUserSwitchCallbacks;
    private int[] mCurrentProfileIds;
    private volatile int mCurrentUserId;
    private boolean mDelayUserDataLocking;
    private final ArraySet<Integer> mDoNotAbortShutdownUserIds;
    private final Handler mHandler;
    private boolean mHasBeenRecorded;
    private boolean mInitialized;
    private final Injector mInjector;
    private boolean mIsBroadcastSentForSystemUserStarted;
    private boolean mIsBroadcastSentForSystemUserStarting;
    private final ArrayList<Integer> mLastActiveUsersForDelayedLocking;
    private volatile long mLastUserUnlockingUptime;
    private final Object mLock;
    private final LockPatternUtils mLockPatternUtils;
    private int mMaxRunningUsers;
    private final ArrayDeque<Integer> mPendingTargetUserIds;
    private final List<PendingUserStart> mPendingUserStarts;
    private int[] mStartedUserArray;
    private final SparseArray<UserState> mStartedUsers;
    private int mStopUserOnSwitch;
    private final SparseArray<String> mSwitchingFromUserMessage;
    private final SparseArray<String> mSwitchingToUserMessage;
    private volatile int mTargetUserId;
    private ArraySet<String> mTimeoutUserSwitchCallbacks;
    private final Handler mUiHandler;
    private final UserManagerInternal.UserLifecycleListener mUserLifecycleListener;
    private final ArrayList<Integer> mUserLru;
    private final SparseIntArray mUserProfileGroupIds;
    private final RemoteCallbackList<IUserSwitchObserver> mUserSwitchObservers;
    private boolean mUserSwitchUiEnabled;

    /* JADX INFO: renamed from: com.android.server.am.UserController$3, reason: invalid class name */
    class AnonymousClass3 extends IIntentReceiver.Stub {
        final /* synthetic */ UserController this$0;
        final /* synthetic */ int val$userId;

        public static /* synthetic */ void $r8$lambda$tGCqnmkFtknJfFRlEkUt7Xg9hD8(long r0) {
            lambda$performReceive$0(r0);
        }

        AnonymousClass3(UserController this$0, int r2) {
            this.this$0 = this$0;
            this.val$userId = r2;
        }

        public void performReceive(Intent intent, int resultCode, String data, Bundle extras, boolean ordered, boolean sticky, int sendingUser) throws RemoteException {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            Slogf.i(UserController.TAG, "Finished processing BOOT_COMPLETED for u" + this.val$userId + ", elapsedRealtime: " + elapsedRealtime);
            this.this$0.mBootCompleted = true;
            if (UserController.m1596$$Nest$fgetmHasBeenRecorded(this.this$0) == true) goto L6;
            UserController.m1598$$Nest$fputmHasBeenRecorded(this.this$0, true);
            BackgroundThread.getHandler().post(new UserController$3$$ExternalSyntheticLambda0(elapsedRealtime));
            return;
        }

        private static /* synthetic */ void lambda$performReceive$0(long elapsedRealtime) {
            SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_sys_completed_finish", elapsedRealtime);
            SysOptBridge.getFactory().getBootEventStat().saveFile();
            SysOptBridge.getFactory().getBootEventStat().release();
        }
    }

    /* JADX INFO: renamed from: com.android.server.am.UserController$4, reason: invalid class name */
    class AnonymousClass4 implements UserState.KeyEvictedCallback {
        final /* synthetic */ UserController this$0;
        final /* synthetic */ int val$userStartMode;

        public static /* synthetic */ void $r8$lambda$mxjguYJ_KfC3A1rONydf9dkk7_Q(AnonymousClass4 r0, int r1, int r2) {
            r0.lambda$keyEvicted$0(r1, r2);
        }

        AnonymousClass4(UserController this$0, int r2) {
            this.this$0 = this$0;
            this.val$userStartMode = r2;
        }

        private /* synthetic */ void lambda$keyEvicted$0(int userId, int userStartMode) {
            this.this$0.startUser(userId, userStartMode);
        }

        @Override // com.android.server.am.UserState.KeyEvictedCallback
        public void keyEvicted(final int userId) {
            Handler r0 = UserController.m1595$$Nest$fgetmHandler(this.this$0);
            final int r1 = this.val$userStartMode;
            r0.post(new UserController$4$$ExternalSyntheticLambda0(this, userId, r1));
        }
    }

    static class Injector {
        private Handler mHandler;
        private PowerManagerInternal mPowerManagerInternal;
        private final ActivityManagerService mService;
        private UserManagerService mUserManager;
        private UserManagerInternal mUserManagerInternal;
        private UserSwitchingDialog mUserSwitchingDialog;
        private final Object mUserSwitchingDialogLock;

        public static /* synthetic */ void $r8$lambda$FvvzSlnmEfZ797QDRQWwplqhvGU(AppWidgetManagerInternal r0, int r1) {
            lambda$startUserWidgets$0(r0, r1);
        }

        Injector(ActivityManagerService service) {
            this.mUserSwitchingDialogLock = new Object();
            this.mService = service;
        }

        protected Handler getHandler(Handler.Callback callback) {
            Handler r0 = new Handler(this.mService.mHandlerThread.getLooper(), callback);
            this.mHandler = r0;
            return r0;
        }

        protected Handler getUiHandler(Handler.Callback callback) {
            return new Handler(this.mService.mUiHandler.getLooper(), callback);
        }

        protected UserJourneyLogger getUserJourneyLogger() {
            return getUserManager().getUserJourneyLogger();
        }

        protected Context getContext() {
            return this.mService.mContext;
        }

        protected LockPatternUtils getLockPatternUtils() {
            return new LockPatternUtils(getContext());
        }

        protected int broadcastIntent(Intent intent, String resolvedType, IIntentReceiver resultTo, int resultCode, String resultData, Bundle resultExtras, String[] requiredPermissions, int appOp, Bundle bOptions, boolean sticky, int callingPid, int callingUid, int realCallingUid, int realCallingPid, int userId) {
            int logUserId = intent.getIntExtra("android.intent.extra.user_handle", ProcessList.INVALID_ADJ);
            if (logUserId != (-10000)) goto L5;
            int logUserId2 = userId;
        L6:
            EventLog.writeEvent(EventLogTags.UC_SEND_USER_BROADCAST, new Object[]{Integer.valueOf(logUserId2), intent.getAction()});
            TimingsTraceAndSlog t = new TimingsTraceAndSlog();
            ActivityManagerService r4 = this.mService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r4);
            t.traceBegin("broadcastIntent-" + userId + "-" + intent.getAction());     // Catch: Throwable -> L20
            int result = this.mService.broadcastIntentLocked(null, null, null, intent, resolvedType, resultTo, resultCode, resultData, resultExtras, requiredPermissions, null, null, appOp, bOptions, false, sticky, callingPid, callingUid, realCallingUid, realCallingPid, userId);     // Catch: Throwable -> L16
            t.traceEnd();     // Catch: Throwable -> L16
            monitor-exit(r4);     // Catch: Throwable -> L16
            ActivityManagerService.resetPriorityAfterLockedSection();
            return result;
        L18:
            th = th;
        L22:
            monitor-exit(r4);     // Catch: Throwable -> L16
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L20:
            th = th;
        L16:
            th = th;
            goto L22
        L5:
            logUserId2 = logUserId;
            goto L6
        }

        int checkCallingPermission(String permission) {
            return this.mService.checkCallingPermission(permission);
        }

        WindowManagerService getWindowManager() {
            return this.mService.mWindowManager;
        }

        void activityManagerOnUserStopped(int userId) {
            ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).onUserStopped(userId);
        }

        void systemServiceManagerOnUserStopped(int userId) {
            getSystemServiceManager().onUserStopped(userId);
        }

        void systemServiceManagerOnUserCompletedEvent(int userId, int eventTypes) {
            getSystemServiceManager().onUserCompletedEvent(userId, eventTypes);
        }

        protected UserManagerService getUserManager() {
            if (this.mUserManager != null) goto L6;
            IBinder b = ServiceManager.getService("user");
            this.mUserManager = IUserManager.Stub.asInterface(b);
        L6:
            return this.mUserManager;
        }

        UserManagerInternal getUserManagerInternal() {
            if (this.mUserManagerInternal != null) goto L6;
            this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        L6:
            return this.mUserManagerInternal;
        }

        PowerManagerInternal getPowerManagerInternal() {
            if (this.mPowerManagerInternal != null) goto L6;
            this.mPowerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        L6:
            return this.mPowerManagerInternal;
        }

        AlarmManagerInternal getAlarmManagerInternal() {
            return (AlarmManagerInternal) LocalServices.getService(AlarmManagerInternal.class);
        }

        KeyguardManager getKeyguardManager() {
            return (KeyguardManager) this.mService.mContext.getSystemService(KeyguardManager.class);
        }

        void batteryStatsServiceNoteEvent(int code, String name, int uid) {
            this.mService.mBatteryStatsService.noteEvent(code, name, uid);
        }

        boolean isRuntimeRestarted() {
            return getSystemServiceManager().isRuntimeRestarted();
        }

        SystemServiceManager getSystemServiceManager() {
            return this.mService.mSystemServiceManager;
        }

        boolean isFirstBootOrUpgrade() {
            IPackageManager pm = AppGlobals.getPackageManager();
        L9:
            e = move-exception;
            throw e.rethrowFromSystemServer();
        L4:
            if (pm.isFirstBoot() == true) goto L11;
            if (pm.isDeviceUpgrading() == true) goto L11;
            return false;
        L11:
            return true;
        }

        void sendPreBootBroadcast(final int userId, final boolean quiet, final Runnable onFinish) {
            EventLog.writeEvent(EventLogTags.UC_SEND_USER_BROADCAST, new Object[]{Integer.valueOf(userId), "android.intent.action.PRE_BOOT_COMPLETED"});
            final ActivityManagerService r4 = this.mService;
            final ProgressReporter r6 = null;
            new AnonymousClass1(this, r4, userId, r6, quiet, onFinish).sendNext();
        }

        void activityManagerForceStopUserPackages(int userId, String reason, boolean evenImportantServices) {
            ActivityManagerService r0 = this.mService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.mService.forceStopUserPackagesLocked(userId, reason, evenImportantServices);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        int checkComponentPermission(String permission, int pid, int uid, int owningUid, boolean exported) {
            return ActivityManagerService.checkComponentPermission(permission, pid, uid, owningUid, exported);
        }

        boolean checkPermissionForPreflight(String permission, int pid, int uid, String pkg) {
            if (PermissionChecker.checkPermissionForPreflight(getContext(), permission, pid, uid, pkg) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        protected void startHomeActivity(int userId, String reason) {
            this.mService.mAtmInternal.startHomeActivity(userId, reason);
        }

        void startUserWidgets(final int userId) {
            final AppWidgetManagerInternal awm = (AppWidgetManagerInternal) LocalServices.getService(AppWidgetManagerInternal.class);
            if (awm == null) goto L6;
            FgThread.getHandler().post(new UserController$Injector$$ExternalSyntheticLambda0(awm, userId));
            return;
        }

        private static /* synthetic */ void lambda$startUserWidgets$0(AppWidgetManagerInternal awm, int userId) {
            awm.unlockUser(userId);
        }

        void updateUserConfiguration() {
            this.mService.mAtmInternal.updateUserConfiguration();
        }

        void clearBroadcastQueueForUser(int userId) {
            ActivityManagerService r0 = this.mService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.mService.clearBroadcastQueueForUserLocked(userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        void loadUserRecents(int userId) {
            this.mService.mAtmInternal.loadRecentTasksForUser(userId);
        }

        void startPersistentApps(int matchFlags) {
            this.mService.startPersistentApps(matchFlags);
        }

        void installEncryptionUnawareProviders(int userId) {
            this.mService.mCpHelper.installEncryptionUnawareProviders(userId);
        }

        void dismissUserSwitchingDialog(Runnable onDismissed) {
            Object r0 = this.mUserSwitchingDialogLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mUserSwitchingDialog == null) goto L9;
            this.mUserSwitchingDialog.dismiss(onDismissed);     // Catch: Throwable -> L7
            this.mUserSwitchingDialog = null;     // Catch: Throwable -> L7
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            if (onDismissed == null) goto L11;
            onDismissed.run();     // Catch: Throwable -> L7
            goto L11
        }

        void showUserSwitchingDialog(UserInfo fromUser, UserInfo toUser, String switchingFromUserMessage, String switchingToUserMessage, Runnable onShown) {
            if (this.mService.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L5;
            Slogf.w(UserController.TAG, "Showing user switch dialog on UserController, it could cause a race condition if it's shown by CarSystemUI as well");
        L5:
            Object r1 = this.mUserSwitchingDialogLock;
            monitor-enter(r1);
            dismissUserSwitchingDialog(null);     // Catch: Throwable -> L15
            this.mUserSwitchingDialog = new UserSwitchingDialog(this.mService.mContext, fromUser, toUser, this.mHandler, switchingFromUserMessage, switchingToUserMessage);     // Catch: Throwable -> L13
            this.mUserSwitchingDialog.show(onShown);     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            Throwable r10 = th;
        L17:
            monitor-exit(r1);     // Catch: Throwable -> L13
            throw r10;
        L15:
            th = move-exception;
            r10 = th;
            goto L17
        }

        void reportGlobalUsageEvent(int event) {
            this.mService.reportGlobalUsageEvent(event);
        }

        void reportCurWakefulnessUsageEvent() {
            this.mService.reportCurWakefulnessUsageEvent();
        }

        void taskSupervisorRemoveUser(int userId) {
            this.mService.mAtmInternal.removeUser(userId);
        }

        protected boolean taskSupervisorSwitchUser(int userId, UserState uss) {
            return this.mService.mAtmInternal.switchUser(userId, uss);
        }

        protected void taskSupervisorResumeFocusedStackTopActivity() {
            this.mService.mAtmInternal.resumeTopActivities(false);
        }

        protected void clearAllLockedTasks(String reason) {
            this.mService.mAtmInternal.clearLockedTasks(reason);
        }

        boolean isCallerRecents(int callingUid) {
            return this.mService.mAtmInternal.isCallerRecents(callingUid);
        }

        protected IStorageManager getStorageManager() {
            return IStorageManager.Stub.asInterface(ServiceManager.getService("mount"));
        }

        boolean isHeadlessSystemUserMode() {
            return UserManager.isHeadlessSystemUserMode();
        }

        boolean isUsersOnSecondaryDisplaysEnabled() {
            return UserManager.isVisibleBackgroundUsersEnabled();
        }

        void onUserStarting(int userId) {
            getSystemServiceManager().onUserStarting(TimingsTraceAndSlog.newAsyncLog(), userId);
        }

        void setPerformancePowerMode(boolean enabled) {
            Slogf.i(UserController.TAG, "Setting power mode MODE_FIXED_PERFORMANCE to " + enabled);
            getPowerManagerInternal().setPowerMode(3, enabled);
        }

        void onSystemUserVisibilityChanged(boolean visible) {
            getUserManagerInternal().onSystemUserVisibilityChanged(visible);
        }

        void lockDeviceNowAndWaitForKeyguardShown() {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                com.android.server.utils.TimingsTraceAndSlog r0 = new com.android.server.utils.TimingsTraceAndSlog
                r0.<init>()
                java.lang.String r1 = "lockDeviceNowAndWaitForKeyguardShown"
                r0.traceBegin(r1)
                java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch
                r2 = 1
                r1.<init>(r2)
                android.os.Bundle r2 = new android.os.Bundle
                r2.<init>()
                com.android.server.am.UserController$Injector$2 r3 = new com.android.server.am.UserController$Injector$2
                r3.<init>(r6, r1)
                java.lang.String r4 = "onSwitchCallback"
                r2.putBinder(r4, r3)
                com.android.server.wm.WindowManagerService r3 = r6.getWindowManager()
                r3.lockNow(r2)
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L3f java.lang.InterruptedException -> L41
                r4 = 20
                boolean r3 = r1.await(r4, r3)     // Catch: java.lang.Throwable -> L3f java.lang.InterruptedException -> L41
                if (r3 == 0) goto L37
                r0.traceEnd()
                return
            L37:
                java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L3f java.lang.InterruptedException -> L41
                java.lang.String r4 = "User controller expected a callback while waiting to show the keyguard. Timed out after 20 seconds."
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L3f java.lang.InterruptedException -> L41
                throw r3     // Catch: java.lang.Throwable -> L3f java.lang.InterruptedException -> L41
            L3f:
                r3 = move-exception
                goto L49
            L41:
                r3 = move-exception
                java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L3f
                r4.<init>(r3)     // Catch: java.lang.Throwable -> L3f
                throw r4     // Catch: java.lang.Throwable -> L3f
            L49:
                r0.traceEnd()
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.am.UserController.Injector.lockDeviceNowAndWaitForKeyguardShown():void");
        }
    }

    private static class PendingUserStart {
        public final IProgressListener unlockListener;
        public final int userId;
        public final int userStartMode;

        PendingUserStart(int userId, int userStartMode, IProgressListener unlockListener) {
            this.userId = userId;
            this.userStartMode = userStartMode;
            this.unlockListener = unlockListener;
        }

        public String toString() {
            return "PendingUserStart{userId=" + this.userId + ", userStartMode=" + UserManagerInternal.userStartModeToString(this.userStartMode) + ", unlockListener=" + this.unlockListener + '}';
        }
    }

    private static class UserProgressListener extends IProgressListener.Stub {
        private volatile long mUnlockStarted;

        /* synthetic */ UserProgressListener(UserControllerIA r1) {
            this();
        }

        private UserProgressListener() {
        }

        public void onStarted(int id, Bundle extras) throws RemoteException {
            Slogf.d(UserController.TAG, "Started unlocking user " + id);
            this.mUnlockStarted = SystemClock.uptimeMillis();
        }

        public void onProgress(int id, int progress, Bundle extras) throws RemoteException {
            Slogf.d(UserController.TAG, "Unlocking user " + id + " progress " + progress);
        }

        public void onFinished(int id, Bundle extras) throws RemoteException {
            long unlockTime = SystemClock.uptimeMillis() - this.mUnlockStarted;
            if (id != 0) goto L5;
            new TimingsTraceAndSlog().logDuration("SystemUserUnlock", unlockTime);
            return;
        L5:
            new TimingsTraceAndSlog().logDuration("User" + id + "Unlock", unlockTime);
        }
    }

    public static /* synthetic */ void $r8$lambda$1kbCAdFccubgUf4yiVDi3WKKsAs(int r0, IUserSwitchObserver r1, IRemoteCallback r2) {
        lambda$dispatchOnBeforeUserSwitching$19(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$7HDljRD7qQE4RI26031lSu3_BrA(UserController r0, int r1, UserState r2, boolean r3) {
        r0.lambda$finishUserStopping$9(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$7IRlOMwowrCbGLBC49RnRMi9jas(UserController r0, Runnable r1) {
        r0.lambda$startUserInternal$15(r1);
    }

    public static /* synthetic */ void $r8$lambda$7Rp5340dvuzFn_mIFckphGkyezI(UserController r0, int r1, UserState r2, boolean r3) {
        r0.lambda$stopSingleUserLU$7(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$BzfFXLjYyFir6apMcfrl2AcdDIs(int r0, IUserSwitchObserver r1, IRemoteCallback r2) {
        lambda$dispatchUserSwitch$22(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$CJMUgyUXssLbrLSA211iBjtm80Q(UserController r0) {
        r0.lambda$scheduleStartProfiles$13();
    }

    public static /* synthetic */ void $r8$lambda$FuBNptCe0rzAmkykUEV5JuWbkNM(UserController r0, UserState r1, int r2, int r3) {
        r0.lambda$dispatchUserSwitch$23(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$HdZJXiGkw2vfoEFivDUcJD4u_Po(UserController r0, UserState r1) {
        r0.lambda$finishUserUnlocked$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$IdrmNQEbckLj5IuU4PA_CYRVBuY(UserController r0, PendingUserStart r1) {
        r0.lambda$resumePendingUserStarts$11(r1);
    }

    public static /* synthetic */ void $r8$lambda$LYgwFBbxx9XRrYfMSUASCs9H6MY(UserController r0, Intent r1, int r2, int r3, int r4) {
        r0.lambda$finishUserUnlockedCompleted$4(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$Lw_poiEiVaTwq5tia4CjT5Fw2Ws(UserController r0, int r1, Runnable r2) {
        r0.lambda$stopSingleUserLU$8(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$MSstRnhX4XfdxG1hK-syGsOWd2A, reason: not valid java name */
    public static /* synthetic */ void m1589$r8$lambda$MSstRnhX4XfdxG1hKsyGsOWd2A(UserController r0, int r1, Runnable r2) {
        r0.lambda$startUserInternal$16(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$OxdhwCv6Vy3KUyKMjyCBLuCttx0(UserController r0, int r1, UserState r2, boolean r3) {
        r0.lambda$stopSingleUserLU$6(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$Pm_cczMeOnLSazWne1O2q8Ii48Y(UserController r0) {
        r0.endUserSwitch();
    }

    public static /* synthetic */ void $r8$lambda$QZw1tuG6OKJDkarIvAt93PtwA1E(UserController r0, int r1, int r2) {
        r0.lambda$completeUserSwitch$24(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$R1Ejc6BBI8vsJqg8UbrYrlujUSA(UserController r0, int r1, List r2) {
        r0.lambda$dispatchUserLocking$12(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$YCqBoXsEcsqTlCp5G3jumgpVKCs(UserController r0, AtomicBoolean r1, long r2, Runnable r4) {
        r0.lambda$startTimeoutForOnBeforeUserSwitching$21(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$YRogdBe_w-n7aACFMrILmeTdha0, reason: not valid java name */
    public static /* synthetic */ void m1590$r8$lambda$YRogdBe_wn7aACFMrILmeTdha0(UserController r0, UserInfo r1, int r2, int r3, IProgressListener r4, int r5, int r6) {
        r0.lambda$startUserInternal$14(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$aXrMhheLTVS7w6eap82_5eQPhJk(UserController r0, int r1, UserState r2) {
        r0.lambda$finishUserUnlocking$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$h-98K9OAF6YeBO_TfJr5Mc3gzDc, reason: not valid java name */
    public static /* synthetic */ void m1591$r8$lambda$h98K9OAF6YeBO_TfJr5Mc3gzDc(UserController r0, int r1, UserState r2, boolean r3) {
        r0.lambda$finishUserStopping$10(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$igRLMjY7sH0EPeCPD9a6D_OTjSA(UserController r0, int r1) {
        r0.lambda$handleMessage$25(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$kC_RmTRStzDplRCF-xAvlJxvcu0, reason: not valid java name */
    public static /* synthetic */ void m1592$r8$lambda$kC_RmTRStzDplRCFxAvlJxvcu0(UserController r0, Pair r1) {
        r0.lambda$showUserSwitchDialog$18(r1);
    }

    public static /* synthetic */ void $r8$lambda$lW7vAzYON6itSHEndug7bYT4rDE(UserController r0, Runnable r1) {
        r0.lambda$dismissUserSwitchDialog$17(r1);
    }

    public static /* synthetic */ void $r8$lambda$lspD3Va72ri8aCrogTjkYPDglnw(UserController r0, UserInfo r1) {
        r0.lambda$finishUserUnlockedCompleted$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$nWwxMxcB3bDFcnNaVn88ZowSjgk(IStopUserCallback r0, int r1) {
        lambda$stopSingleUserLU$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$rZCfkm40PtakDtUXmYiaWEXRbw0(UserController r0, UserState r1) {
        r0.lambda$finishUserSwitch$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$vcYx6IMV-IBMtWC9BF7r9AEpYaE, reason: not valid java name */
    public static /* synthetic */ void m1593$r8$lambda$vcYx6IMVIBMtWC9BF7r9AEpYaE(AtomicBoolean r0, Runnable r1) {
        lambda$dispatchOnBeforeUserSwitching$20(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurWaitingUserSwitchCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m1594$$Nest$fgetmCurWaitingUserSwitchCallbacks(UserController r0) {
        return r0.mCurWaitingUserSwitchCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m1595$$Nest$fgetmHandler(UserController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHasBeenRecorded, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1596$$Nest$fgetmHasBeenRecorded(UserController r0) {
        return r0.mHasBeenRecorded;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1597$$Nest$fgetmLock(UserController r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHasBeenRecorded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1598$$Nest$fputmHasBeenRecorded(UserController r0, boolean r1) {
        r0.mHasBeenRecorded = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$monUserAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1599$$Nest$monUserAdded(UserController r0, UserInfo r1) {
        r0.onUserAdded(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smasyncTraceEnd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1600$$Nest$smasyncTraceEnd(String r0, int r1) {
        asyncTraceEnd(r0, r1);
    }

    UserController(ActivityManagerService service) {
        this(new Injector(service));
    }

    UserController(Injector injector) {
        this.mBackgroundUserScheduledStopTimeSecs = -1;
        this.mLock = new Object();
        this.mCurrentUserId = 0;
        this.mTargetUserId = ProcessList.INVALID_ADJ;
        this.mPendingTargetUserIds = new ArrayDeque();
        this.mStartedUsers = new SparseArray();
        this.mUserLru = new ArrayList();
        this.mStartedUserArray = new int[]{0};
        this.mCurrentProfileIds = new int[0];
        this.mUserProfileGroupIds = new SparseIntArray();
        this.mUserSwitchObservers = new RemoteCallbackList();
        this.mUserSwitchUiEnabled = true;
        this.mSwitchingFromUserMessage = new SparseArray();
        this.mSwitchingToUserMessage = new SparseArray();
        this.mLastActiveUsersForDelayedLocking = new ArrayList();
        this.mCompletedEventTypes = new SparseIntArray();
        this.mStopUserOnSwitch = -1;
        this.mLastUserUnlockingUptime = 0;
        this.mHasBeenRecorded = false;
        this.mPendingUserStarts = new ArrayList();
        this.mDoNotAbortShutdownUserIds = new ArraySet();
        this.mUserLifecycleListener = new AnonymousClass1(this);
        this.mInjector = injector;
        this.mHandler = this.mInjector.getHandler(this);
        this.mUiHandler = this.mInjector.getUiHandler(this);
        UserState uss = new UserState(UserHandle.SYSTEM);
        uss.mUnlockProgress.addListener(new UserProgressListener(null));
        this.mStartedUsers.put(0, uss);
        this.mUserLru.add(0);
        this.mLockPatternUtils = this.mInjector.getLockPatternUtils();
        updateStartedUserArrayLU();
    }

    void setInitialConfig(boolean userSwitchUiEnabled, int maxRunningUsers, boolean delayUserDataLocking, int backgroundUserScheduledStopTimeSecs) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserSwitchUiEnabled = userSwitchUiEnabled;     // Catch: Throwable -> L7
        this.mMaxRunningUsers = maxRunningUsers;     // Catch: Throwable -> L7
        this.mDelayUserDataLocking = delayUserDataLocking;     // Catch: Throwable -> L7
        this.mBackgroundUserScheduledStopTimeSecs = backgroundUserScheduledStopTimeSecs;     // Catch: Throwable -> L7
        this.mInitialized = true;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isUserSwitchUiEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mUserSwitchUiEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int getMaxRunningUsers() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mMaxRunningUsers;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setStopUserOnSwitch(int value) {
        if (this.mInjector.checkCallingPermission("android.permission.MANAGE_USERS") == (-1)) goto L5;
    L9:
        Object r0 = this.mLock;
        monitor-enter(r0);
        Slogf.i(TAG, "setStopUserOnSwitch(): %d -> %d", new Object[]{Integer.valueOf(this.mStopUserOnSwitch), Integer.valueOf(value)});     // Catch: Throwable -> L14
        this.mStopUserOnSwitch = value;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mInjector.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS") != (-1)) goto L9;
        throw new SecurityException("You either need MANAGE_USERS or INTERACT_ACROSS_USERS permission to call setStopUserOnSwitch()");
    }

    private boolean isStopUserOnSwitchEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean value = false;
        if (this.mStopUserOnSwitch != (-1)) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L12
        int property = SystemProperties.getInt("fw.stop_bg_users_on_switch", -1);
        if (property == (-1)) goto L24;
        if (property == 1) goto L20;
        return false;
    L20:
        return true;
    L24:
        return this.mDelayUserDataLocking;
    L7:
        if (this.mStopUserOnSwitch != 1) goto L9;
        value = true;
    L9:
        Slogf.i(TAG, "isStopUserOnSwitchEnabled(): returning overridden value (%b)", new Object[]{Boolean.valueOf(value)});     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return value;
    L12:
        th = move-exception;
        throw th;
    }

    boolean isEarlyPackageKillEnabledForUserSwitch(int fromUserId, int toUserId) {
        if (fromUserId != 0) goto L6;
        return false;
    L6:
        return isStopUserOnSwitchEnabled();
    }

    void finishUserSwitch(final UserState uss) {
        this.mHandler.post(new UserController$$ExternalSyntheticLambda3(this, uss));
    }

    private /* synthetic */ void lambda$finishUserSwitch$0(UserState uss) {
        finishUserBoot(uss);
        startProfiles();
        stopExcessRunningUsers();
    }

    private void addUserToUserLru(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Integer userIdObj = Integer.valueOf(userId);     // Catch: Throwable -> L11
        this.mUserLru.remove(userIdObj);     // Catch: Throwable -> L11
        this.mUserLru.add(userIdObj);     // Catch: Throwable -> L11
        Integer parentIdObj = Integer.valueOf(this.mUserProfileGroupIds.get(userId, ProcessList.INVALID_ADJ));     // Catch: Throwable -> L11
        if (parentIdObj.intValue() != (-10000)) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (parentIdObj.equals(userIdObj) == true) goto L13;
        if (this.mUserLru.remove(parentIdObj) == false) goto L13;
        this.mUserLru.add(parentIdObj);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    List<Integer> getRunningUsersLU() {
        ArrayList<Integer> runningUsers = new ArrayList();
        Iterator<Integer> r1 = this.mUserLru.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Integer userId = r1.next();
        UserState uss = this.mStartedUsers.get(userId.intValue());
        if (uss == null) goto L4;
        if (uss.state == 4) goto L4;
        if (uss.state == 5) goto L4;
        runningUsers.add(userId);
        goto L4
    L14:
        return runningUsers;
    }

    private void stopExcessRunningUsers() {
        ArraySet<Integer> exemptedUsers = new ArraySet();
        List<UserInfo> users = this.mInjector.getUserManager().getUsers(true);
        int i = 0;
    L4:
        if (i >= users.size()) goto L9;
        int userId = users.get(i).id;
        if (isAlwaysVisibleUser(userId) == false) goto L8;
        exemptedUsers.add(Integer.valueOf(userId));
    L8:
        i = i + 1;
        goto L4
    L9:
        Object r2 = this.mLock;
        monitor-enter(r2);
        stopExcessRunningUsersLU(this.mMaxRunningUsers, exemptedUsers);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void stopExcessRunningUsersLU(int maxRunningUsers, ArraySet<Integer> exemptedUsers) {
        List<Integer> currentlyRunningLru = getRunningUsersLU();
        Iterator<Integer> iterator = currentlyRunningLru.iterator();
    L4:
        if (currentlyRunningLru.size() <= maxRunningUsers) goto L18;
        if (iterator.hasNext() == false) goto L31;
        Integer userId = iterator.next();
        if (userId.intValue() == 0) goto L4;
        if (userId.intValue() == this.mCurrentUserId) goto L4;
        if (exemptedUsers.contains(userId) == true) goto L4;
        Slogf.i(TAG, "Too many running users (%d). Attempting to stop user %d", new Object[]{Integer.valueOf(currentlyRunningLru.size()), userId});
        if (stopUsersLU(userId.intValue(), false, true, null, null) != 0) goto L4;
        iterator.remove();
        goto L4
    L31:
        return;
    }

    boolean canStartMoreUsers() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (getRunningUsersLU().size() >= this.mMaxRunningUsers) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private void finishUserBoot(UserState uss) {
        finishUserBoot(uss, null);
    }

    private void finishUserBoot(UserState uss, IIntentReceiver resultTo) {
        int userId = uss.mHandle.getIdentifier();
        EventLog.writeEvent(EventLogTags.UC_FINISH_USER_BOOT, userId);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mStartedUsers.get(userId) == uss) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L8
        if (uss.setState(0, 1) == false) goto L27;
        this.mInjector.getUserJourneyLogger().logUserLifecycleEvent(userId, 4, 0);
        this.mInjector.getUserManagerInternal().setUserState(userId, uss.state);
        if (userId != 0) goto L23;
        if (this.mInjector.isRuntimeRestarted() == true) goto L23;
        if (this.mInjector.isFirstBootOrUpgrade() == true) goto L23;
        long elapsedTimeMs = SystemClock.elapsedRealtime();
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED, 12, elapsedTimeMs);
        if (elapsedTimeMs <= 120000) goto L23;
        Slogf.wtf(TimingsTraceAndSlog.SYSTEM_SERVER_TIMING_TAG, "finishUserBoot took too long. elapsedTimeMs=" + elapsedTimeMs);
    L23:
        if (this.mInjector.getUserManager().isPreCreated(userId) == true) goto L27;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(110, userId, 0));
        if (this.mAllowUserUnlocking == false) goto L27;
        sendLockedBootCompletedBroadcast(resultTo, userId);
    L27:
        UserInfo parent = this.mInjector.getUserManager().getProfileParent(userId);
        if (parent != null) goto L31;
        maybeUnlockUser(userId);
        return;
    L31:
        if (isUserRunning(parent.id, 4) == false) goto L33;
        Slogf.d(TAG, "User " + userId + " (parent " + parent.id + "): attempting unlock because parent is unlocked");
        maybeUnlockUser(userId);
        return;
    L33:
        Slogf.d(TAG, "User " + userId + " (parent " + parent.id + "): delaying unlock because parent is locked");
    }

    private void sendLockedBootCompletedBroadcast(IIntentReceiver receiver, int userId) {
        UserInfo userInfo = getUserInfo(userId);
        if (userInfo != null) goto L5;
    L8:
        Intent intent = new Intent("android.intent.action.LOCKED_BOOT_COMPLETED", null);
        intent.putExtra("android.intent.extra.user_handle", userId);
        intent.addFlags(-1996488704);
        this.mInjector.broadcastIntent(intent, null, receiver, 0, null, null, new String[]{"android.permission.RECEIVE_BOOT_COMPLETED"}, -1, getTemporaryAppAllowlistBroadcastOptions(202).toBundle(), false, ActivityManagerService.MY_PID, 1000, Binder.getCallingUid(), Binder.getCallingPid(), userId);
        return;
    L5:
        if (userInfo.isPrivateProfile() == false) goto L8;
        Slogf.i(TAG, "Skipping LOCKED_BOOT_COMPLETED for private profile user #" + userId);
    }

    private boolean finishUserUnlocking(final UserState uss) {
        final int userId = uss.mHandle.getIdentifier();
        EventLog.writeEvent(EventLogTags.UC_FINISH_USER_UNLOCKING, userId);
        this.mInjector.getUserJourneyLogger().logUserLifecycleEvent(userId, 5, 1);
        if (StorageManager.isCeStorageUnlocked(userId) == true) goto L5;
        return false;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.mStartedUsers.get(userId) != uss) goto L17;
        if (uss.state != 1) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L15
        uss.mUnlockProgress.start();
        uss.mUnlockProgress.setProgress(5, this.mInjector.getContext().getString(R.string.app_not_found));
        FgThread.getHandler().post(new UserController$$ExternalSyntheticLambda15(this, userId, uss));
        return true;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return false;
    }

    private /* synthetic */ void lambda$finishUserUnlocking$1(int userId, UserState uss) {
        if (StorageManager.isCeStorageUnlocked(userId) == true) goto L6;
        Slogf.w(TAG, "User's CE storage got locked unexpectedly, leaving user locked.");
        return;
    L6:
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("UM.onBeforeUnlockUser-" + userId);
        this.mInjector.getUserManager().onBeforeUnlockUser(userId);
        t.traceEnd();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L10:
        if (uss.setState(1, 2) == true) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        this.mInjector.getUserManagerInternal().setUserState(userId, uss.state);
        uss.mUnlockProgress.setProgress(20);
        this.mLastUserUnlockingUptime = SystemClock.uptimeMillis();
        this.mHandler.obtainMessage(100, userId, 0, uss).sendToTarget();
    }

    private void finishUserUnlocked(final UserState uss) {
        int userId = uss.mHandle.getIdentifier();
        EventLog.writeEvent(EventLogTags.UC_FINISH_USER_UNLOCKED, userId);
        if (StorageManager.isCeStorageUnlocked(userId) == true) goto L5;
        return;
    L5:
        Object r4 = this.mLock;
        monitor-enter(r4);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mStartedUsers.get(uss.mHandle.getIdentifier()) == uss) goto L14;
        monitor-exit(r4);     // Catch: Throwable -> L11
        return;
    L14:
        if (uss.setState(2, 3) == true) goto L17;
        monitor-exit(r4);     // Catch: Throwable -> L11
        return;
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L11
        this.mInjector.getUserManagerInternal().setUserState(userId, uss.state);
        uss.mUnlockProgress.finish();
        if (userId != 0) goto L21;
        this.mInjector.startPersistentApps(262144);
    L21:
        this.mInjector.installEncryptionUnawareProviders(userId);
        if (this.mInjector.getUserManager().isPreCreated(userId) == true) goto L24;
        Intent unlockedIntent = new Intent("android.intent.action.USER_UNLOCKED");
        unlockedIntent.putExtra("android.intent.extra.user_handle", userId);
        unlockedIntent.addFlags(1342177280);
        int r0 = 1342177280;
        this.mInjector.broadcastIntent(unlockedIntent, null, null, 0, null, null, null, -1, null, false, ActivityManagerService.MY_PID, 1000, Binder.getCallingUid(), Binder.getCallingPid(), userId);
        userId = userId;
    L25:
        UserInfo userInfo = getUserInfo(userId);
        if (userInfo.isProfile() == false) goto L32;
        UserInfo parent = this.mInjector.getUserManager().getProfileParent(userId);
        if (parent == null) goto L32;
        broadcastProfileAccessibleStateChanged(userId, parent.id, "android.intent.action.PROFILE_ACCESSIBLE");
        if (userInfo.isManagedProfile() == false) goto L32;
        Intent profileUnlockedIntent = new Intent("android.intent.action.MANAGED_PROFILE_UNLOCKED");
        profileUnlockedIntent.putExtra("android.intent.extra.USER", UserHandle.of(userId));
        profileUnlockedIntent.addFlags(r0);
        this.mInjector.broadcastIntent(profileUnlockedIntent, null, null, 0, null, null, null, -1, null, false, ActivityManagerService.MY_PID, 1000, Binder.getCallingUid(), Binder.getCallingPid(), parent.id);
    L32:
        UserInfo info = getUserInfo(userId);
        if (Objects.equals(info.lastLoggedInFingerprint, PackagePartitions.FINGERPRINT) == true) goto L35;
    L38:
        boolean quiet = info.isManagedProfile();
        this.mInjector.sendPreBootBroadcast(userId, quiet, new UserController$$ExternalSyntheticLambda24(this, uss));
        return;
    L35:
        if (SystemProperties.getBoolean("persist.pm.mock-upgrade", false) == true) goto L38;
        finishUserUnlockedCompleted(uss);
        return;
    L24:
        r0 = 1342177280;
        goto L25
    }

    private /* synthetic */ void lambda$finishUserUnlocked$2(UserState uss) {
        finishUserUnlockedCompleted(uss);
    }

    private void finishUserUnlockedCompleted(UserState r24) {
        final int r3 = r24.mHandle.getIdentifier();
        EventLog.writeEvent(EventLogTags.UC_FINISH_USER_UNLOCKED_COMPLETED, r3);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mStartedUsers.get(r24.mHandle.getIdentifier()) == r24) goto L10;
        monitor-exit(r2);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        final UserInfo r0 = getUserInfo(r3);
        if (r0 != null) goto L15;
        return;
    L15:
        if (StorageManager.isCeStorageUnlocked(r3) == true) goto L17;
        return;
    L17:
        this.mInjector.getUserManager().onUserLoggedIn(r3);
        final Runnable r4 = new UserController$$ExternalSyntheticLambda10(this, r0);
        if (r0.isInitialized() == true) goto L25;
        Slogf.d(TAG, "Initializing user #" + r3);
        if (r0.preCreated == false) goto L22;
        r4.run();
        goto L25
    L22:
        if (r3 == 0) goto L25;
        Intent r8 = new Intent("android.intent.action.USER_INITIALIZE");
        r8.addFlags(AudioFormat.EVRCB);
        this.mInjector.broadcastIntent(r8, null, new AnonymousClass2(this, r4), 0, null, null, null, -1, null, false, ActivityManagerService.MY_PID, 1000, Binder.getCallingUid(), Binder.getCallingPid(), r3);
    L25:
        if (r0.preCreated == false) goto L28;
        Slogf.i(TAG, "Stopping pre-created user " + r0.toFullString());
        stopUser(r0.id, false, null, null);
        return;
    L28:
        this.mInjector.startUserWidgets(r3);
        this.mHandler.obtainMessage(105, r3, 0).sendToTarget();
        if (r0.isPrivateProfile() == false) goto L32;
        Slogf.i(TAG, "Skipping BOOT_COMPLETED for private profile user #" + r3);
        return;
    L32:
        long r9 = SystemClock.elapsedRealtime();
        Slogf.i(TAG, "Posting BOOT_COMPLETED user #" + r3 + ", elapsedRealtime: " + r9);
        if (this.mHasBeenRecorded == true) goto L43;
        SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_sys_completed_posting", r9);
        boolean r5 = this.mLockPatternUtils.isSecure(r3);
        if (r5 == false) goto L37;
        Slogf.i(TAG, "Keyguard is se");
    L37:
        IBootEventStat r6 = SysOptBridge.getFactory().getBootEventStat();
        if (r5 == false) goto L40;
        long r11 = 1;
    L41:
        r6.writeEvent("isKeyguardSecure", r11);
        EventLog.writeEvent(EventLogTags.BOOT_SYS_KEYGUARD_SECURE, r5 ? 1 : 0);
        goto L43
    L40:
        r11 = 0;
    L43:
        if (r3 == 0) goto L45;
    L49:
        final Intent r7 = new Intent("android.intent.action.BOOT_COMPLETED", null);
        r7.putExtra("android.intent.extra.user_handle", r3);
        r7.addFlags(-1996488704);
        final int r10 = Binder.getCallingUid();
        final int r12 = Binder.getCallingPid();
        FgThread.getHandler().post(new UserController$$ExternalSyntheticLambda11(this, r7, r3, r10, r12));
        return;
    L45:
        if (this.mInjector.isRuntimeRestarted() == true) goto L49;
        if (this.mInjector.isFirstBootOrUpgrade() == true) goto L49;
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED, 13, SystemClock.elapsedRealtime());
        goto L49
    }

    private /* synthetic */ void lambda$finishUserUnlockedCompleted$3(UserInfo userInfo) {
        this.mInjector.getUserManager().makeInitialized(userInfo.id);
    }

    private /* synthetic */ void lambda$finishUserUnlockedCompleted$4(Intent bootIntent, int userId, int callingUid, int callingPid) {
        this.mInjector.broadcastIntent(bootIntent, null, new AnonymousClass3(this, userId), 0, null, null, new String[]{"android.permission.RECEIVE_BOOT_COMPLETED"}, -1, getTemporaryAppAllowlistBroadcastOptions(200).toBundle(), false, ActivityManagerService.MY_PID, 1000, callingUid, callingPid, userId);
    }

    int restartUser(int userId, int userStartMode) {
        return stopUser(userId, false, null, new AnonymousClass4(this, userStartMode));
    }

    boolean stopProfile(int userId) {
        if (this.mInjector.checkCallingPermission("android.permission.MANAGE_USERS") == (-1)) goto L5;
    L9:
        UserInfo userInfo = getUserInfo(userId);
        if (userInfo == null) goto L25;
        if (userInfo.isProfile() == false) goto L25;
        enforceShellRestriction("no_debugging_features", userId);
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean r3 = false;
    L21:
        th = move-exception;
        throw th;
    L17:
        if (stopUsersLU(userId, false, null, null) != 0) goto L19;
        r3 = true;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r3;
    L25:
        throw new IllegalArgumentException("User " + userId + " is not a profile");
    L5:
        if (this.mInjector.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL") != (-1)) goto L9;
        throw new SecurityException("You either need MANAGE_USERS or INTERACT_ACROSS_USERS_FULL permission to stop a profile");
    }

    int stopUser(int userId, boolean allowDelayedLocking, IStopUserCallback stopUserCallback, UserState.KeyEvictedCallback keyEvictedCallback) {
        return stopUser(userId, true, allowDelayedLocking, stopUserCallback, keyEvictedCallback);
    }

    int stopUser(int userId, boolean stopProfileRegardlessOfParent, boolean allowDelayedLocking, IStopUserCallback stopUserCallback, UserState.KeyEvictedCallback keyEvictedCallback) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        StringBuilder r0 = new StringBuilder();
        r0.append("UserController");
        if (stopProfileRegardlessOfParent == false) goto L5;
        String r2 = "-stopProfileRegardlessOfParent";
    L6:
        r0.append(r2);
        if (allowDelayedLocking == false) goto L9;
        String r3 = "-allowDelayedLocking";
    L10:
        r0.append(r3);
        if (stopUserCallback == null) goto L13;
        String r4 = "-withStopUserCallback";
    L14:
        r0.append(r4);
        r0.append("-");
        r0.append(userId);
        r0.append("-[stopUser]");
        t.traceBegin(r0.toString());
        checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "stopUser");     // Catch: Throwable -> L28
        if (userId < 0) goto L18;
        boolean r1 = true;
    L19:
        Preconditions.checkArgument(r1, "Invalid user id %d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L28
        enforceShellRestriction("no_debugging_features", userId);     // Catch: Throwable -> L28
        Object r5 = this.mLock;     // Catch: Throwable -> L28
        monitor-enter(r5);     // Catch: Throwable -> L28
        int r6 = stopUsersLU(userId, stopProfileRegardlessOfParent, allowDelayedLocking, stopUserCallback, keyEvictedCallback);     // Catch: Throwable -> L25
        monitor-exit(r5);     // Catch: Throwable -> L25
        t.traceEnd();
        return r6;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L18:
        r1 = false;
    L28:
        th = move-exception;
        t.traceEnd();
        throw th;
    L13:
        r4 = "";
        goto L14
    L9:
        r3 = "";
        goto L10
    L5:
        r2 = "";
        goto L6
    }

    private int stopUsersLU(int userId, boolean allowDelayedLocking, IStopUserCallback stopUserCallback, UserState.KeyEvictedCallback keyEvictedCallback) {
        return stopUsersLU(userId, true, allowDelayedLocking, stopUserCallback, keyEvictedCallback);
    }

    private int stopUsersLU(int userId, boolean stopProfileRegardlessOfParent, boolean allowDelayedLocking, IStopUserCallback stopUserCallback, UserState.KeyEvictedCallback keyEvictedCallback) {
        if (userId != 0) goto L6;
        return -3;
    L6:
        if (isCurrentUserLU(userId) == false) goto L10;
        return -2;
    L10:
        if (stopProfileRegardlessOfParent == true) goto L18;
        int parentId = this.mUserProfileGroupIds.get(userId, ProcessList.INVALID_ADJ);
        if (parentId == (-10000)) goto L18;
        if (parentId == userId) goto L18;
        if (parentId != 0) goto L16;
    L17:
        return -4;
    L16:
        if (isCurrentUserLU(parentId) == true) goto L17;
    L18:
        int[] usersToStop = getUsersToStopLU(userId);
        int r2 = usersToStop.length;
        int r4 = 0;
    L20:
        if (r4 >= r2) goto L29;
        int relatedUserId = usersToStop[r4];
        if (relatedUserId == 0) goto L27;
        if (isCurrentUserLU(relatedUserId) == true) goto L27;
        r4 = r4 + 1;
    L27:
        Slogf.e(TAG, "Cannot stop user %d because it is related to user %d. ", new Object[]{Integer.valueOf(userId), Integer.valueOf(relatedUserId)});
        return -4;
    L29:
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L32;
        Slogf.i(TAG, "stopUsersLocked usersToStop=" + Arrays.toString(usersToStop));
    L32:
        int r3 = usersToStop.length;
        int r5 = 0;
    L33:
        if (r5 >= r3) goto L41;
        int userIdToStop = usersToStop[r5];
        t.traceBegin("stopSingleUserLU-" + userIdToStop + "-[stopUser]");
        UserState.KeyEvictedCallback r6 = null;
        if (userIdToStop != userId) goto L37;
        IStopUserCallback r7 = stopUserCallback;
    L38:
        if (userIdToStop != userId) goto L40;
        r6 = keyEvictedCallback;
    L40:
        stopSingleUserLU(userIdToStop, allowDelayedLocking, r7, r6);
        t.traceEnd();
        r5 = r5 + 1;
        goto L33
    L37:
        r7 = null;
        goto L38
    L41:
        return 0;
    }

    private void stopSingleUserLU(final int userId, final boolean allowDelayedLocking, final IStopUserCallback stopUserCallback, UserState.KeyEvictedCallback keyEvictedCallback) {
        Slogf.i(TAG, "stopSingleUserLU userId=" + userId);
        final UserState uss = this.mStartedUsers.get(userId);
        if (uss == null) goto L5;
        logUserJourneyBegin(userId, 5);
        if (stopUserCallback == null) goto L22;
        uss.mStopCallbacks.add(stopUserCallback);
    L22:
        if (keyEvictedCallback == null) goto L25;
        uss.mKeyEvictedCallbacks.add(keyEvictedCallback);
    L25:
        if (uss.state != 4) goto L27;
        return;
    L27:
        if (uss.state == 5) goto L36;
        uss.setState(4);
        UserManagerInternal userManagerInternal = this.mInjector.getUserManagerInternal();
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("setUserState-STATE_STOPPING-" + userId + "-[stopUser]");
        userManagerInternal.setUserState(userId, uss.state);
        t.traceEnd();
        t.traceBegin("unassignUserFromDisplayOnStop-" + userId + "-[stopUser]");
        userManagerInternal.unassignUserFromDisplayOnStop(userId);
        t.traceEnd();
        updateStartedUserArrayLU();
        final Runnable finishUserStoppingAsync = new UserController$$ExternalSyntheticLambda1(this, userId, uss, allowDelayedLocking);
        if (this.mInjector.getUserManager().isPreCreated(userId) == false) goto L32;
        finishUserStoppingAsync.run();
        return;
    L32:
        this.mHandler.post(new UserController$$ExternalSyntheticLambda2(this, userId, finishUserStoppingAsync));
        return;
    L36:
        return;
    L5:
        if (canDelayDataLockingForUser(userId) == false) goto L16;
        if (allowDelayedLocking == false) goto L9;
        if (keyEvictedCallback == null) goto L9;
        Slogf.wtf(TAG, "allowDelayedLocking set with KeyEvictedCallback, ignore it and lock user:" + userId, new RuntimeException());
        allowDelayedLocking = false;
    L9:
        if (allowDelayedLocking == true) goto L16;
        if (this.mLastActiveUsersForDelayedLocking.remove(Integer.valueOf(userId)) == false) goto L16;
        if (keyEvictedCallback == null) goto L14;
        ArrayList<UserState.KeyEvictedCallback> keyEvictedCallbacks = new ArrayList(1);
        keyEvictedCallbacks.add(keyEvictedCallback);
    L15:
        dispatchUserLocking(userId, keyEvictedCallbacks);
        goto L16
    L14:
        keyEvictedCallbacks = null;
    L16:
        if (stopUserCallback == null) goto L34;
        this.mHandler.post(new UserController$$ExternalSyntheticLambda0(stopUserCallback, userId));
        return;
    }

    private static /* synthetic */ void lambda$stopSingleUserLU$5(IStopUserCallback stopUserCallback, int userId) {
        stopUserCallback.userStopped(userId);     // Catch: RemoteException -> L4
        return;
    }

    private /* synthetic */ void lambda$stopSingleUserLU$7(final int userId, final UserState uss, final boolean allowDelayedLockingCopied) {
        this.mHandler.post(new UserController$$ExternalSyntheticLambda16(this, userId, uss, allowDelayedLockingCopied));
    }

    private /* synthetic */ void lambda$stopSingleUserLU$6(int userId, UserState uss, boolean allowDelayedLockingCopied) {
        TimingsTraceAndSlog t2 = new TimingsTraceAndSlog();
        t2.traceBegin("finishUserStopping-" + userId + "-[stopUser]");
        finishUserStopping(userId, uss, allowDelayedLockingCopied);
        t2.traceEnd();
    }

    private /* synthetic */ void lambda$stopSingleUserLU$8(final int userId, final Runnable finishUserStoppingAsync) {
        Intent stoppingIntent = new Intent("android.intent.action.USER_STOPPING");
        stoppingIntent.addFlags(1073741824);
        stoppingIntent.putExtra("android.intent.extra.user_handle", userId);
        stoppingIntent.putExtra("android.intent.extra.SHUTDOWN_USERSPACE_ONLY", true);
        IIntentReceiver stoppingReceiver = new AnonymousClass5(this, userId, finishUserStoppingAsync);
        TimingsTraceAndSlog t2 = new TimingsTraceAndSlog();
        t2.traceBegin("clearBroadcastQueueForUser-" + userId + "-[stopUser]");
        this.mInjector.clearBroadcastQueueForUser(userId);
        t2.traceEnd();
        asyncTraceBegin("broadcast-ACTION_USER_STOPPING-" + userId + "-[stopUser]", userId);
        this.mInjector.broadcastIntent(stoppingIntent, null, stoppingReceiver, 0, null, null, new String[]{"android.permission.INTERACT_ACROSS_USERS"}, -1, null, false, ActivityManagerService.MY_PID, 1000, Binder.getCallingUid(), Binder.getCallingPid(), -1);
    }

    private void finishUserStopping(final int userId, final UserState uss, final boolean allowDelayedLocking) {
        EventLog.writeEvent(EventLogTags.UC_FINISH_USER_STOPPING, userId);
        Object r4 = this.mLock;
        monitor-enter(r4);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (uss.state == 4) goto L14;
        UserJourneyLogger.UserJourneySession session = this.mInjector.getUserJourneyLogger().logUserJourneyFinishWithError(-1, getUserInfo(userId), 5, 3);     // Catch: Throwable -> L9
        if (session == null) goto L11;
        this.mHandler.removeMessages(200, session);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return;
    L11:
        this.mInjector.getUserJourneyLogger().logUserJourneyFinishWithError(-1, getUserInfo(userId), 5, 0);     // Catch: Throwable -> L9
        goto L12
    L14:
        uss.setState(5);     // Catch: Throwable -> L9
        this.mDoNotAbortShutdownUserIds.remove(Integer.valueOf(userId));     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("setUserState-STATE_SHUTDOWN-" + userId + "-[stopUser]");
        this.mInjector.getUserManagerInternal().setUserState(userId, uss.state);
        t.traceEnd();
        this.mInjector.batteryStatsServiceNoteEvent(16391, Integer.toString(userId), userId);
        this.mInjector.getSystemServiceManager().onUserStopping(userId);
        final Runnable finishUserStoppedAsync = new UserController$$ExternalSyntheticLambda26(this, userId, uss, allowDelayedLocking);
        if (this.mInjector.getUserManager().isPreCreated(userId) == false) goto L20;
        finishUserStoppedAsync.run();
        return;
    L20:
        Intent shutdownIntent = new Intent("android.intent.action.ACTION_SHUTDOWN");
        IIntentReceiver shutdownReceiver = new AnonymousClass6(this, userId, finishUserStoppedAsync);
        asyncTraceBegin("broadcast-ACTION_SHUTDOWN-" + userId + "-[stopUser]", userId);
        this.mInjector.broadcastIntent(shutdownIntent, null, shutdownReceiver, 0, null, null, null, -1, null, false, ActivityManagerService.MY_PID, 1000, Binder.getCallingUid(), Binder.getCallingPid(), userId);
    }

    private /* synthetic */ void lambda$finishUserStopping$10(final int userId, final UserState uss, final boolean allowDelayedLocking) {
        this.mHandler.post(new UserController$$ExternalSyntheticLambda4(this, userId, uss, allowDelayedLocking));
    }

    private /* synthetic */ void lambda$finishUserStopping$9(int userId, UserState uss, boolean allowDelayedLocking) {
        TimingsTraceAndSlog t2 = new TimingsTraceAndSlog();
        t2.traceBegin("finishUserStopped-" + userId + "-[stopUser]");
        finishUserStopped(uss, allowDelayedLocking);
        t2.traceEnd();
    }

    void finishUserStopped(UserState uss, boolean allowDelayedLocking) {
        int userId = uss.mHandle.getIdentifier();
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L5;
        Slogf.i(TAG, "finishUserStopped(%d): allowDelayedLocking=%b", new Object[]{Integer.valueOf(userId), Boolean.valueOf(allowDelayedLocking)});
    L5:
        EventLog.writeEvent(EventLogTags.UC_FINISH_USER_STOPPED, userId);
        boolean lockUser = true;
        int userIdToLock = userId;
        UserInfo userInfo = getUserInfo(userId);
        Object r4 = this.mLock;
        monitor-enter(r4);
        ArrayList<IStopUserCallback> stopCallbacks = new ArrayList(uss.mStopCallbacks);     // Catch: Throwable -> L17
        ArrayList<UserState.KeyEvictedCallback> keyEvictedCallbacks = new ArrayList(uss.mKeyEvictedCallbacks);     // Catch: Throwable -> L17
        if (this.mStartedUsers.get(userId) != uss) goto L22;
        if (uss.state != 5) goto L22;
        boolean stopped = true;
        Slogf.i(TAG, "Removing user state from UserController.mStartedUsers for user #" + userId + " as a result of user being stopped");     // Catch: Throwable -> L17
        this.mStartedUsers.remove(userId);     // Catch: Throwable -> L17
        this.mUserLru.remove(Integer.valueOf(userId));     // Catch: Throwable -> L17
        updateStartedUserArrayLU();     // Catch: Throwable -> L17
        if (allowDelayedLocking == true) goto L15;
    L19:
        userIdToLock = updateUserToLockLU(userId, allowDelayedLocking);     // Catch: Throwable -> L17
        if (userIdToLock != (-10000)) goto L23;
        lockUser = false;
    L23:
        monitor-exit(r4);     // Catch: Throwable -> L17
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        if (stopped == false) goto L27;
        Slogf.i(TAG, "Removing user state from UserManager.mUserStates for user #" + userId + " as a result of user being stopped");
        this.mInjector.getUserManagerInternal().removeUserState(userId);
        this.mInjector.activityManagerOnUserStopped(userId);
        t.traceBegin("stopPackagesOfStoppedUser-" + userId + "-[stopUser]");
        stopPackagesOfStoppedUser(userId, "finish user");
        t.traceEnd();
    L27:
        Iterator<IStopUserCallback> r9 = stopCallbacks.iterator();
    L29:
        if (r9.hasNext() == false) goto L39;
        IStopUserCallback callback = r9.next();
        if (stopped == false) goto L35;
        t.traceBegin("stopCallbacks.userStopped-" + userId + "-[stopUser]");     // Catch: RemoteException -> L33
        callback.userStopped(userId);     // Catch: RemoteException -> L33
        t.traceEnd();     // Catch: RemoteException -> L33
        goto L29
    L35:
        t.traceBegin("stopCallbacks.userStopAborted-" + userId + "-[stopUser]");     // Catch: RemoteException -> L33
        callback.userStopAborted(userId);     // Catch: RemoteException -> L33
        t.traceEnd();     // Catch: RemoteException -> L33
        goto L29
    L39:
        if (stopped == false) goto L51;
        t.traceBegin("systemServiceManagerOnUserStopped-" + userId + "-[stopUser]");
        this.mInjector.systemServiceManagerOnUserStopped(userId);
        t.traceEnd();
        t.traceBegin("taskSupervisorRemoveUser-" + userId + "-[stopUser]");
        this.mInjector.taskSupervisorRemoveUser(userId);
        t.traceEnd();
        if (userInfo.isEphemeral() == true) goto L43;
    L45:
        UserJourneyLogger.UserJourneySession session = this.mInjector.getUserJourneyLogger().logUserJourneyFinish(-1, userInfo, 5);
        if (session == null) goto L48;
        this.mHandler.removeMessages(200, session);
    L48:
        if (lockUser == false) goto L50;
        dispatchUserLocking(userIdToLock, keyEvictedCallbacks);
    L50:
        resumePendingUserStarts(userId);
        return;
    L43:
        if (userInfo.preCreated == true) goto L45;
        this.mInjector.getUserManager().removeUserEvenWhenDisallowed(userId);
        goto L45
    L51:
        UserJourneyLogger.UserJourneySession session2 = this.mInjector.getUserJourneyLogger().finishAndClearIncompleteUserJourney(userId, 5);
        if (session2 == null) goto L68;
        this.mHandler.removeMessages(200, session2);
        return;
    L68:
        return;
    L15:
        if (keyEvictedCallbacks.isEmpty() == true) goto L19;
        Slogf.wtf(TAG, "Delayed locking enabled while KeyEvictedCallbacks not empty, userId:" + userId + " callbacks:" + keyEvictedCallbacks);     // Catch: Throwable -> L17
        allowDelayedLocking = false;
    L22:
        stopped = false;
    L17:
        th = move-exception;
        throw th;
    }

    private void resumePendingUserStarts(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<PendingUserStart> handledUserStarts = new ArrayList();     // Catch: Throwable -> L10
        Iterator<PendingUserStart> r2 = this.mPendingUserStarts.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        final PendingUserStart userStart = r2.next();     // Catch: Throwable -> L10
        if (userStart.userId != userId) goto L6;
        Slogf.i(TAG, "resumePendingUserStart for" + userStart);     // Catch: Throwable -> L10
        this.mHandler.post(new UserController$$ExternalSyntheticLambda22(this, userStart));     // Catch: Throwable -> L10
        handledUserStarts.add(userStart);     // Catch: Throwable -> L10
        goto L6
    L13:
        this.mPendingUserStarts.removeAll(handledUserStarts);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$resumePendingUserStarts$11(PendingUserStart userStart) {
        startUser(userStart.userId, userStart.userStartMode, userStart.unlockListener);
    }

    private void dispatchUserLocking(final int userId, final List<UserState.KeyEvictedCallback> keyEvictedCallbacks) {
        FgThread.getHandler().post(new UserController$$ExternalSyntheticLambda25(this, userId, keyEvictedCallbacks));
    }

    private /* synthetic */ void lambda$dispatchUserLocking$12(int userId, List keyEvictedCallbacks) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mStartedUsers.get(userId) == null) goto L11;
        Slogf.w(TAG, "User was restarted, skipping key eviction");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        Slogf.i(TAG, "Locking CE storage for user #" + userId);     // Catch: RemoteException -> L21
        this.mInjector.getStorageManager().lockCeStorage(userId);     // Catch: RemoteException -> L21
        if (keyEvictedCallbacks != null) goto L15;
        return;
    L15:
        int i = 0;
    L17:
        if (i >= keyEvictedCallbacks.size()) goto L20;
        ((UserState.KeyEvictedCallback) keyEvictedCallbacks.get(i)).keyEvicted(userId);
        i = i + 1;
        goto L17
    L20:
        return;
    L21:
        re = move-exception;
        throw re.rethrowAsRuntimeException();
    }

    private int updateUserToLockLU(int userId, boolean allowDelayedLocking) {
        if (canDelayDataLockingForUser(userId) == false) goto L18;
        if (allowDelayedLocking == false) goto L18;
        if (getUserInfo(userId).isEphemeral() == true) goto L18;
        if (hasUserRestriction("no_run_in_background", userId) == true) goto L18;
        if (this.mDelayUserDataLocking == false) goto L16;
        this.mLastActiveUsersForDelayedLocking.remove(Integer.valueOf(userId));
        this.mLastActiveUsersForDelayedLocking.add(0, Integer.valueOf(userId));
        int totalUnlockedUsers = this.mStartedUsers.size() + this.mLastActiveUsersForDelayedLocking.size();
        if (totalUnlockedUsers <= this.mMaxRunningUsers) goto L16;
        int userIdToLock = this.mLastActiveUsersForDelayedLocking.get(this.mLastActiveUsersForDelayedLocking.size() - 1).intValue();
        this.mLastActiveUsersForDelayedLocking.remove(this.mLastActiveUsersForDelayedLocking.size() - 1);
        Slogf.i(TAG, "finishUserStopped: should stop user " + userId + " but should lock user " + userIdToLock);
        return userIdToLock;
    L16:
        Slogf.i(TAG, "finishUserStopped: should stop user " + userId + " but without any locking");
        return ProcessList.INVALID_ADJ;
    L18:
        return userId;
    }

    private boolean canDelayDataLockingForUser(int userIdToLock) {
        if (allowBiometricUnlockForPrivateProfile() == false) goto L14;
        UserProperties userProperties = getUserProperties(userIdToLock);
        if (this.mDelayUserDataLocking == true) goto L11;
        if (userProperties != null) goto L8;
    L10:
        return false;
    L8:
        if (userProperties.getAllowStoppingUserWithDelayedLocking() == false) goto L10;
    L11:
        return true;
    L14:
        return this.mDelayUserDataLocking;
    }

    private boolean allowBiometricUnlockForPrivateProfile() {
        return true;
    }

    private int[] getUsersToStopLU(int userId) {
        int startedUsersSize = this.mStartedUsers.size();
        IntArray userIds = new IntArray();
        userIds.add(userId);
        int userGroupId = this.mUserProfileGroupIds.get(userId, ProcessList.INVALID_ADJ);
        if (userGroupId != userId) goto L20;
        int i = 0;
    L5:
        if (i >= startedUsersSize) goto L20;
        UserState uss = this.mStartedUsers.valueAt(i);
        int startedUserId = uss.mHandle.getIdentifier();
        int startedUserGroupId = this.mUserProfileGroupIds.get(startedUserId, ProcessList.INVALID_ADJ);
        boolean sameUserId = false;
        if (userGroupId == (-10000)) goto L10;
        if (userGroupId != startedUserGroupId) goto L10;
        boolean sameGroup = true;
    L11:
        if (startedUserId != userId) goto L14;
        sameUserId = true;
    L14:
        if (sameGroup == false) goto L18;
        if (sameUserId == true) goto L18;
        userIds.add(startedUserId);
    L18:
        i = i + 1;
    L10:
        sameGroup = false;
    L20:
        return userIds.toArray();
    }

    private void stopPackagesOfStoppedUser(int userId, String reason) {
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L5;
        Slogf.i(TAG, "stopPackagesOfStoppedUser(%d): %s", new Object[]{Integer.valueOf(userId), reason});
    L5:
        this.mInjector.activityManagerForceStopUserPackages(userId, reason, true);
        if (this.mInjector.getUserManager().isPreCreated(userId) == false) goto L8;
        return;
    L8:
        Intent intent = new Intent("android.intent.action.USER_STOPPED");
        intent.addFlags(1342177280);
        intent.putExtra("android.intent.extra.user_handle", userId);
        this.mInjector.broadcastIntent(intent, null, null, 0, null, null, null, -1, null, false, ActivityManagerService.MY_PID, 1000, Binder.getCallingUid(), Binder.getCallingPid(), -1);
        UserInfo userInfo = getUserInfo(userId);
        if (userInfo != null) goto L11;
        return;
    L11:
        if (userInfo.isProfile() == false) goto L17;
        UserInfo parent = this.mInjector.getUserManager().getProfileParent(userId);
        if (parent == null) goto L18;
        broadcastProfileAccessibleStateChanged(userId, parent.id, "android.intent.action.PROFILE_INACCESSIBLE");
        return;
    L18:
        return;
    }

    private void stopGuestOrEphemeralUserIfBackground(int oldUserId) {
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L5;
        Slogf.i(TAG, "Stop guest or ephemeral user if background: " + oldUserId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserState oldUss = this.mStartedUsers.get(oldUserId);     // Catch: Throwable -> L34
        if (oldUserId == 0) goto L36;
        if (oldUserId == this.mCurrentUserId) goto L36;
        if (oldUss == null) goto L36;
        if (oldUss.state == 4) goto L36;
        if (oldUss.state == 5) goto L36;
        monitor-exit(r0);     // Catch: Throwable -> L34
        UserInfo userInfo = getUserInfo(oldUserId);
        if (userInfo.isEphemeral() == false) goto L22;
        ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).onEphemeralUserStop(oldUserId);
    L22:
        if (userInfo.isGuest() == false) goto L24;
    L25:
        Slogf.i(TAG, "Stopping background guest or ephemeral user " + oldUserId);
        Object r2 = this.mLock;
        monitor-enter(r2);
        stopUsersLU(oldUserId, false, null, null);     // Catch: Throwable -> L31
        monitor-exit(r2);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    L24:
        if (userInfo.isEphemeral() == true) goto L25;
        return;
    L36:
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L34:
        th = move-exception;
        throw th;
    }

    private void stopPreviousUserPackagesIfEnabled(int fromUserId, int toUserId) {
        if (isEarlyPackageKillEnabledForUserSwitch(fromUserId, toUserId) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDoNotAbortShutdownUserIds.add(Integer.valueOf(fromUserId));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mInjector.activityManagerForceStopUserPackages(fromUserId, "early stop user packages", false);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void scheduleStartProfiles() {
        FgThread.getHandler().post(new UserController$$ExternalSyntheticLambda9(this));
    }

    private /* synthetic */ void lambda$scheduleStartProfiles$13() {
        if (this.mHandler.hasMessages(40) == true) goto L6;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(40), 1000);
        return;
    }

    private void startProfiles() {
        int currentUserId = getCurrentUserId();
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L5;
        Slogf.i(TAG, "startProfilesLocked");
    L5:
        List<UserInfo> profiles = this.mInjector.getUserManager().getProfiles(currentUserId, false);
        List<UserInfo> profilesToStart = new ArrayList(profiles.size());
        Iterator<UserInfo> r4 = profiles.iterator();
    L7:
        if (r4.hasNext() == false) goto L16;
        UserInfo user = r4.next();
        if ((user.flags & 16) != 16) goto L7;
        if (user.id == currentUserId) goto L7;
        if (shouldStartWithParent(user) == false) goto L7;
        profilesToStart.add(user);
        goto L7
    L16:
        int profilesToStartSize = profilesToStart.size();
        int i = 0;
    L17:
        if (i >= profilesToStartSize) goto L21;
        if (i >= (getMaxRunningUsers() - 1)) goto L21;
        startUser(profilesToStart.get(i).id, 3);
        i = i + 1;
    L21:
        if (i >= profilesToStartSize) goto L35;
        Slogf.w(TAG, "More profiles than MAX_RUNNING_USERS");
        return;
    }

    private boolean shouldStartWithParent(UserInfo user) {
        UserProperties properties = getUserProperties(user.id);
        if (properties != null) goto L5;
    L9:
        return false;
    L5:
        if (properties.getStartWithParent() == false) goto L9;
        if (user.isQuietModeEnabled() == true) goto L9;
        return true;
    }

    boolean startProfile(int userId, boolean evenWhenDisabled, IProgressListener unlockListener) {
        if (this.mInjector.checkCallingPermission("android.permission.MANAGE_USERS") == (-1)) goto L5;
    L9:
        UserInfo userInfo = getUserInfo(userId);
        if (userInfo == null) goto L21;
        if (userInfo.isProfile() == false) goto L21;
        if (userInfo.isEnabled() == true) goto L19;
        if (evenWhenDisabled == true) goto L19;
        Slogf.w(TAG, "Cannot start disabled profile #%d", new Object[]{Integer.valueOf(userId)});
        return false;
    L19:
        return startUserNoChecks(userId, 0, 3, unlockListener);
    L21:
        throw new IllegalArgumentException("User " + userId + " is not a profile");
    L5:
        if (this.mInjector.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL") != (-1)) goto L9;
        throw new SecurityException("You either need MANAGE_USERS or INTERACT_ACROSS_USERS_FULL permission to start a profile");
    }

    boolean startUser(int userId, int userStartMode) {
        return startUser(userId, userStartMode, null);
    }

    boolean startUser(int userId, int userStartMode, IProgressListener unlockListener) {
        checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "startUser");
        return startUserNoChecks(userId, 0, userStartMode, unlockListener);
    }

    boolean startUserVisibleOnDisplay(int userId, int displayId, IProgressListener unlockListener) {
        checkCallingHasOneOfThosePermissions("startUserOnDisplay", new String[]{"android.permission.MANAGE_USERS", "android.permission.INTERACT_ACROSS_USERS"});
        return startUserNoChecks(userId, displayId, 3, unlockListener);
    L5:
        e = move-exception;
        Slogf.e(TAG, "startUserOnSecondaryDisplay(%d, %d) failed: %s", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId), e});
        return false;
    }

    private boolean startUserNoChecks(int userId, int displayId, int userStartMode, IProgressListener unlockListener) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        StringBuilder r0 = new StringBuilder();
        r0.append("UserController.startUser-");
        r0.append(userId);
        if (displayId != 0) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        r0.append("-");
        if (userStartMode != 1) goto L9;
        String r2 = "fg";
    L10:
        r0.append(r2);
        r0.append("-start-mode-");
        r0.append(userStartMode);
        t.traceBegin(r0.toString());
        boolean r8 = startUserInternal(userId, displayId, userStartMode, unlockListener, t);     // Catch: Throwable -> L14
        t.traceEnd();
        return r8;
    L14:
        th = move-exception;
        t.traceEnd();
        throw th;
    L9:
        r2 = "bg";
        goto L10
    L5:
        r1 = "-display-" + displayId;
        goto L6
    }

    private boolean startUserInternal(final int userId, int displayId, final int userStartMode, final IProgressListener unlockListener, TimingsTraceAndSlog t) {
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L6;
        Slogf.i(TAG, "Starting user %d on display %d with mode  %s", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId), UserManagerInternal.userStartModeToString(userStartMode)});
    L6:
        if (userStartMode != 1) goto L8;
        boolean r3 = true;
    L9:
        boolean foreground = r3;
        if (displayId == 0) goto L12;
        boolean r4 = true;
    L13:
        boolean onSecondaryDisplay = r4;
        if (onSecondaryDisplay == false) goto L19;
        if (foreground == true) goto L17;
        boolean r5 = true;
    L18:
        Preconditions.checkArgument(r5, "Cannot start user %d in foreground AND on secondary display (%d)", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
        goto L19
    L17:
        r5 = false;
    L19:
        Integer r6 = Integer.valueOf(userId);
        if (foreground == false) goto L22;
        int r7 = 1;
    L23:
        EventLog.writeEvent(EventLogTags.UC_START_USER_INTERNAL, new Object[]{r6, Integer.valueOf(r7), Integer.valueOf(displayId)});
        final int callingUid = Binder.getCallingUid();
        final int callingPid = Binder.getCallingPid();
        long ident = Binder.clearCallingIdentity();
        t.traceBegin("getStartedUserState");     // Catch: Throwable -> L30
        final int oldUserId = getCurrentUserId();     // Catch: Throwable -> L30
        if (oldUserId == userId) goto L91;
        boolean r16 = false;
    L49:
        t.traceEnd();     // Catch: Throwable -> L30
        if (foreground == false) goto L52;
        t.traceBegin("clearAllLockedTasks");     // Catch: Throwable -> L30
        this.mInjector.clearAllLockedTasks("startUser");     // Catch: Throwable -> L30
        t.traceEnd();     // Catch: Throwable -> L30
    L52:
        t.traceBegin("getUserInfo");     // Catch: Throwable -> L30
        final UserInfo userInfo = getUserInfo(userId);     // Catch: Throwable -> L30
        t.traceEnd();     // Catch: Throwable -> L30
        if (userInfo != null) goto L57;
        Slogf.w(TAG, "No user info for user #" + userId);     // Catch: Throwable -> L30
        Binder.restoreCallingIdentity(ident);
        return r16;
    L57:
        if (foreground == true) goto L59;
    L63:
        if (foreground == true) goto L66;
        if (onSecondaryDisplay == true) goto L66;
    L70:
        t.traceBegin("assignUserToDisplayOnStart");     // Catch: Throwable -> L30
        int result = this.mInjector.getUserManagerInternal().assignUserToDisplayOnStart(userId, userInfo.profileGroupId, userStartMode, displayId);     // Catch: Throwable -> L30
        t.traceEnd();     // Catch: Throwable -> L30
        if (result != (-1)) goto L81;
        Slogf.e(TAG, "%s user(%d) / display (%d) assignment failed: %s", new Object[]{UserManagerInternal.userStartModeToString(userStartMode), Integer.valueOf(userId), Integer.valueOf(displayId), UserManagerInternal.userAssignmentResultToString(result)});     // Catch: Throwable -> L76
        Binder.restoreCallingIdentity(ident);
        return r16;
    L81:
        final Runnable continueStartUserInternal = new UserController$$ExternalSyntheticLambda7(this, userInfo, oldUserId, userStartMode, unlockListener, callingUid, callingPid);     // Catch: Throwable -> L30
        if (foreground == false) goto L84;
        this.mHandler.post(new UserController$$ExternalSyntheticLambda8(this, userId, continueStartUserInternal));     // Catch: Throwable -> L30
    L85:
        Binder.restoreCallingIdentity(ident);
        return true;
    L84:
        continueStartUserInternal.run();     // Catch: Throwable -> L30
    L76:
        th = th;
    L87:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L66:
        if (userInfo.preCreated == false) goto L70;
        Slogf.w(TAG, "Cannot start pre-created user #" + userId + " in foreground or on secondary display");     // Catch: Throwable -> L30
        Binder.restoreCallingIdentity(ident);
        return r16;
    L59:
        if (userInfo.isProfile() == false) goto L63;
        Slogf.w(TAG, "Cannot switch to User #" + userId + ": not a full user");     // Catch: Throwable -> L30
        Binder.restoreCallingIdentity(ident);
        return r16;
    L91:
        UserState state = getStartedUserState(userId);     // Catch: Throwable -> L46
        if (state != null) goto L32;
        r16 = false;
        Slogf.wtf(TAG, "Current user has no UserState");     // Catch: Throwable -> L30
        goto L49
    L32:
        r16 = false;
        if (userId == 0) goto L35;
    L37:
        if (state.state != 3) goto L43;
        notifyFinished(userId, unlockListener);     // Catch: Throwable -> L30
    L43:
        t.traceEnd();     // Catch: Throwable -> L30
        Binder.restoreCallingIdentity(ident);
        return true;
    L35:
        if (state.state != 0) goto L37;
    L46:
        th = th;
    L30:
        th = th;
        goto L87
    L22:
        r7 = 0;
        goto L23
    L12:
        r4 = false;
        goto L13
    L8:
        r3 = false;
        goto L9
    }

    private /* synthetic */ void lambda$startUserInternal$14(UserInfo userInfo, int oldUserId, int userStartMode, IProgressListener unlockListener, int callingUid, int callingPid) {
        continueStartUserInternal(userInfo, oldUserId, userStartMode, unlockListener, callingUid, callingPid);
    }

    private /* synthetic */ void lambda$startUserInternal$16(int userId, final Runnable continueStartUserInternal) {
        dispatchOnBeforeUserSwitching(userId, new UserController$$ExternalSyntheticLambda5(this, continueStartUserInternal));
    }

    private /* synthetic */ void lambda$startUserInternal$15(Runnable continueStartUserInternal) {
        this.mHandler.post(continueStartUserInternal);
    }

    private void continueStartUserInternal(UserInfo userInfo, int oldUserId, int userStartMode, IProgressListener unlockListener, int callingUid, int callingPid) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        if (userStartMode != 1) goto L5;
        boolean foreground = true;
    L6:
        int userId = userInfo.id;
        boolean needStart = false;
        boolean updateUmState = false;
        t.traceBegin("updateStartedUserArrayStarting");
        Object r14 = this.mLock;
        monitor-enter(r14);
        UserState uss = this.mStartedUsers.get(userId);     // Catch: Throwable -> L15
        if (uss != null) goto L18;
        uss = new UserState(UserHandle.of(userId));     // Catch: Throwable -> L15
        uss.mUnlockProgress.addListener(new UserProgressListener(null));     // Catch: Throwable -> L13
        this.mStartedUsers.put(userId, uss);     // Catch: Throwable -> L13
        updateStartedUserArrayLU();     // Catch: Throwable -> L13
        needStart = true;
        updateUmState = true;
    L108:
        monitor-exit(r14);     // Catch: Throwable -> L101
        addUserToUserLru(userId);
        if (unlockListener == null) goto L26;
        uss.mUnlockProgress.addListener(unlockListener);
    L26:
        t.traceEnd();
        if (updateUmState == false) goto L29;
        t.traceBegin("setUserState");
        this.mInjector.getUserManagerInternal().setUserState(userId, uss.state);
        t.traceEnd();
    L29:
        t.traceBegin("updateConfigurationAndProfileIds");
        if (foreground == 0) goto L45;
        this.mInjector.reportGlobalUsageEvent(16);
        Object r9 = this.mLock;
        monitor-enter(r9);
        this.mCurrentUserId = userId;     // Catch: Throwable -> L42
        ActivityManager.invalidateGetCurrentUserIdCache();     // Catch: Throwable -> L42
        boolean userSwitchUiEnabled = this.mUserSwitchUiEnabled;     // Catch: Throwable -> L42
        monitor-exit(r9);     // Catch: Throwable -> L42
        this.mInjector.updateUserConfiguration();
        updateProfileRelatedCaches();
        this.mInjector.getWindowManager().setCurrentUser(userId);
        this.mInjector.reportCurWakefulnessUsageEvent();
        if (userSwitchUiEnabled == false) goto L47;
        this.mInjector.getWindowManager().setSwitchingUser(true);
        if (this.mInjector.getKeyguardManager().isDeviceSecure(userId) == false) goto L47;
        Slogf.d(TAG, "Locking the device before moving on with the user switch");
        this.mInjector.lockDeviceNowAndWaitForKeyguardShown();
    L47:
        if (userStartMode == 2) goto L49;
    L51:
        t.traceEnd();
        if (uss.state != 4) goto L62;
        t.traceBegin("updateStateStopping");
        uss.setState(uss.lastState);
        this.mInjector.getUserManagerInternal().setUserState(userId, uss.state);
        Object r10 = this.mLock;
        monitor-enter(r10);
        updateStartedUserArrayLU();     // Catch: Throwable -> L58
        monitor-exit(r10);     // Catch: Throwable -> L58
        needStart = true;
        t.traceEnd();
    L72:
        if (uss.state != 0) goto L75;
        t.traceBegin("updateStateBooting");
        this.mInjector.getUserManager().onBeforeStartUser(userId);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(50, userId, 0));
        t.traceEnd();
    L75:
        t.traceBegin("sendMessages");
        if (foreground == 0) goto L80;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(60, userId, oldUserId));
        this.mHandler.removeMessages(10);
        this.mHandler.removeMessages(30);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(10, oldUserId, userId, uss));
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(30, oldUserId, userId, uss), getUserSwitchTimeoutMs());
    L80:
        if (userInfo.preCreated == false) goto L82;
        boolean needStart2 = false;
    L84:
        if (userId == 0) goto L86;
    L88:
        boolean isSystemUserInHeadlessMode = false;
    L90:
        if (needStart2 == true) goto L92;
        if (isSystemUserInHeadlessMode == true) goto L92;
    L93:
        t.traceEnd();
        if (foreground == false) goto L96;
        t.traceBegin("moveUserToForeground");
        moveUserToForeground(uss, userId);
        t.traceEnd();
    L97:
        if (needStart2 == true) goto L99;
        if (isSystemUserInHeadlessMode == true) goto L99;
        return;
    L99:
        t.traceBegin("sendRestartBroadcast");
        sendUserStartingBroadcast(userId, callingUid, callingPid);
        t.traceEnd();
        return;
    L96:
        t.traceBegin("finishUserBoot");
        finishUserBoot(uss);
        t.traceEnd();
    L92:
        sendUserStartedBroadcast(userId, callingUid, callingPid);
        goto L93
    L86:
        if (this.mInjector.isHeadlessSystemUserMode() == false) goto L88;
        isSystemUserInHeadlessMode = true;
        goto L90
    L82:
        needStart2 = needStart;
    L58:
        th = move-exception;
        throw th;
    L62:
        if (uss.state != 5) goto L72;
        t.traceBegin("updateStateShutdown");
        uss.setState(0);
        this.mInjector.getUserManagerInternal().setUserState(userId, uss.state);
        Object r11 = this.mLock;
        monitor-enter(r11);
        updateStartedUserArrayLU();     // Catch: Throwable -> L68
        monitor-exit(r11);     // Catch: Throwable -> L68
        needStart = true;
        t.traceEnd();
    L68:
        th = move-exception;
        throw th;
    L49:
        if (userInfo.isProfile() == true) goto L51;
        scheduleStopOfBackgroundUser(userId);
    L42:
        th = move-exception;
        throw th;
    L45:
        updateProfileRelatedCaches();
        addUserToUserLru(this.mCurrentUserId);
    L101:
        th = th;
    L106:
        monitor-exit(r14);     // Catch: Throwable -> L13
        throw th;
    L18:
        if (uss.state != 5) goto L20;
    L103:
        Slogf.i(TAG, "User #" + userId + " is shutting down - will start after full shutdown");     // Catch: Throwable -> L13
        this.mPendingUserStarts.add(new PendingUserStart(userId, userStartMode, unlockListener));     // Catch: Throwable -> L13
        t.traceEnd();     // Catch: Throwable -> L13
        monitor-exit(r14);     // Catch: Throwable -> L13
        return;
    L20:
        if (this.mDoNotAbortShutdownUserIds.contains(Integer.valueOf(userId)) == false) goto L108;
    L13:
        th = th;
    L15:
        th = th;
        goto L106
    L5:
        foreground = false;
        goto L6
    }

    void startUserInForeground(int targetUserId) {
        this.mInjector.setPerformancePowerMode(true);
        boolean success = startUser(targetUserId, 1);
        if (success == true) goto L6;
        this.mInjector.getWindowManager().setSwitchingUser(false);
        dismissUserSwitchDialog(new UserController$$ExternalSyntheticLambda6(this));
        return;
    }

    boolean unlockUser(int userId, IProgressListener listener) {
        checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "unlockUser");
        EventLog.writeEvent(EventLogTags.UC_UNLOCK_USER, userId);
        long binderToken = Binder.clearCallingIdentity();
        boolean r2 = maybeUnlockUser(userId, listener);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(binderToken);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(binderToken);
        throw th;
    }

    private static void notifyFinished(int userId, IProgressListener listener) {
        if (listener != null) goto L9;
        return;
    L9:
        listener.onFinished(userId, null);     // Catch: RemoteException -> L7
        return;
    }

    private boolean maybeUnlockUser(int userId) {
        return maybeUnlockUser(userId, null);
    }

    private boolean maybeUnlockUser(int userId, IProgressListener listener) {
        int r1 = 0;
        if (this.mAllowUserUnlocking == true) goto L7;
        Slogf.i(TAG, "Not unlocking user %d yet because boot hasn't completed", new Object[]{Integer.valueOf(userId)});
        notifyFinished(userId, listener);
        return false;
    L7:
        if (StorageManager.isCeStorageUnlocked(userId) == true) goto L9;
        this.mLockPatternUtils.unlockUserKeyIfUnsecured(userId);
    L9:
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserState uss = this.mStartedUsers.get(userId);     // Catch: Throwable -> L14
        if (uss == null) goto L16;
        uss.mUnlockProgress.addListener(listener);     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (uss != null) goto L20;
        notifyFinished(userId, listener);
        return false;
    L20:
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("finishUserUnlocking-" + userId);
        boolean finishUserUnlockingResult = finishUserUnlocking(uss);
        t.traceEnd();
        if (finishUserUnlockingResult == true) goto L24;
        notifyFinished(userId, listener);
        return false;
    L24:
        Object r5 = this.mLock;
        monitor-enter(r5);
        int[] userIds = new int[this.mStartedUsers.size()];     // Catch: Throwable -> L30
        int i = 0;
    L28:
        if (i >= userIds.length) goto L33;
        userIds[i] = this.mStartedUsers.keyAt(i);     // Catch: Throwable -> L30
        i = i + 1;     // Catch: Throwable -> L30
        goto L28
    L33:
        monitor-exit(r5);     // Catch: Throwable -> L30
        int r6 = userIds.length;
    L35:
        if (r1 >= r6) goto L43;
        int testUserId = userIds[r1];
        UserInfo parent = this.mInjector.getUserManager().getProfileParent(testUserId);
        if (parent == null) goto L42;
        if (parent.id != userId) goto L42;
        if (testUserId == userId) goto L42;
        Slogf.d(TAG, "User " + testUserId + " (parent " + parent.id + "): attempting unlock because parent was just unlocked");
        maybeUnlockUser(testUserId);
    L42:
        r1 = r1 + 1;
        goto L35
    L43:
        return true;
    L30:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    boolean switchUser(int targetUserId) {
        enforceShellRestriction("no_debugging_features", targetUserId);
        EventLog.writeEvent(EventLogTags.UC_SWITCH_USER, targetUserId);
        int currentUserId = getCurrentUserId();
        UserInfo targetUserInfo = getUserInfo(targetUserId);
        Object r2 = this.mLock;
        monitor-enter(r2);
        if (targetUserId != currentUserId) goto L14;
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mTargetUserId != (-10000)) goto L14;
        Slogf.i(TAG, "user #" + targetUserId + " is already the current user");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return true;
    L14:
        if (targetUserInfo != null) goto L19;
        Slogf.w(TAG, "No user info for user #" + targetUserId);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return false;
    L19:
        if (targetUserInfo.supportsSwitchTo() == true) goto L24;
        Slogf.w(TAG, "Cannot switch to User #" + targetUserId + ": not supported");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return false;
    L24:
        if (FactoryResetter.isFactoryResetting() == false) goto L29;
        Slogf.w(TAG, "Cannot switch to User #" + targetUserId + ": factory reset in progress");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return false;
    L29:
        if (this.mInitialized == true) goto L34;
        Slogf.e(TAG, "Cannot switch to User #" + targetUserId + ": UserController not ready yet");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return false;
    L34:
        if (this.mTargetUserId == (-10000)) goto L38;
        Slogf.w(TAG, "There is already an ongoing user switch to User #" + this.mTargetUserId + ". User #" + targetUserId + " will be added to the queue.");     // Catch: Throwable -> L11
        this.mPendingTargetUserIds.offer(Integer.valueOf(targetUserId));     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return true;
    L38:
        this.mTargetUserId = targetUserId;     // Catch: Throwable -> L11
        ActivityManager.invalidateGetCurrentUserIdCache();     // Catch: Throwable -> L11
        boolean userSwitchUiEnabled = this.mUserSwitchUiEnabled;     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        if (userSwitchUiEnabled == false) goto L42;
        UserInfo currentUserInfo = getUserInfo(currentUserId);
        Pair<UserInfo, UserInfo> userNames = new Pair(currentUserInfo, targetUserInfo);
        this.mUiHandler.removeMessages(1000);
        this.mUiHandler.sendMessage(this.mUiHandler.obtainMessage(1000, userNames));
    L43:
        return true;
    L42:
        sendStartUserSwitchFgMessage(targetUserId);
        goto L43
    }

    private void sendStartUserSwitchFgMessage(int targetUserId) {
        this.mHandler.removeMessages(120);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(120, targetUserId, 0));
    }

    private void dismissUserSwitchDialog(final Runnable onDismissed) {
        this.mUiHandler.post(new UserController$$ExternalSyntheticLambda23(this, onDismissed));
    }

    private /* synthetic */ void lambda$dismissUserSwitchDialog$17(Runnable onDismissed) {
        this.mInjector.dismissUserSwitchingDialog(onDismissed);
    }

    private void showUserSwitchDialog(final Pair<UserInfo, UserInfo> fromToUserPair) {
        this.mInjector.showUserSwitchingDialog((UserInfo) fromToUserPair.first, (UserInfo) fromToUserPair.second, getSwitchingFromUserMessageUnchecked(((UserInfo) fromToUserPair.first).id), getSwitchingToUserMessageUnchecked(((UserInfo) fromToUserPair.second).id), new UserController$$ExternalSyntheticLambda17(this, fromToUserPair));
    }

    private /* synthetic */ void lambda$showUserSwitchDialog$18(Pair fromToUserPair) {
        sendStartUserSwitchFgMessage(((UserInfo) fromToUserPair.second).id);
    }

    private void dispatchForegroundProfileChanged(int userId) {
        int observerCount = this.mUserSwitchObservers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= observerCount) goto L8;
        this.mUserSwitchObservers.getBroadcastItem(i).onForegroundProfileSwitch(userId);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mUserSwitchObservers.finishBroadcast();
    }

    private void dispatchOnBeforeUserSwitching(final int newUserId, final Runnable onComplete) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("dispatchOnBeforeUserSwitching-" + newUserId);
        final AtomicBoolean isFirst = new AtomicBoolean(true);
        startTimeoutForOnBeforeUserSwitching(isFirst, onComplete);
        informUserSwitchObservers(new UserController$$ExternalSyntheticLambda12(newUserId), new UserController$$ExternalSyntheticLambda13(isFirst, onComplete), "onBeforeUserSwitching");
        t.traceEnd();
    }

    private static /* synthetic */ void lambda$dispatchOnBeforeUserSwitching$19(int newUserId, IUserSwitchObserver observer, IRemoteCallback callback) {
        observer.onBeforeUserSwitching(newUserId, callback);     // Catch: RemoteException -> L4
        return;
    }

    private static /* synthetic */ void lambda$dispatchOnBeforeUserSwitching$20(AtomicBoolean isFirst, Runnable onComplete) {
        if (isFirst.getAndSet(false) == false) goto L6;
        onComplete.run();
        return;
    }

    private void startTimeoutForOnBeforeUserSwitching(final AtomicBoolean isFirst, final Runnable onComplete) {
        final long timeout = getUserSwitchTimeoutMs();
        this.mHandler.postDelayed(new UserController$$ExternalSyntheticLambda14(this, isFirst, timeout, onComplete), timeout);
    }

    private /* synthetic */ void lambda$startTimeoutForOnBeforeUserSwitching$21(AtomicBoolean isFirst, long timeout, Runnable onComplete) {
        if (isFirst.getAndSet(false) == false) goto L12;
        Object r0 = this.mLock;
        monitor-enter(r0);
        String unresponsiveObservers = String.join(", ", this.mCurWaitingUserSwitchCallbacks);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        Slogf.e(TAG, "Timeout on dispatchOnBeforeUserSwitching. These UserSwitchObservers did not respond in " + timeout + "ms: " + unresponsiveObservers + ".");
        onComplete.run();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void dispatchUserSwitchComplete(int oldUserId, int newUserId) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("dispatchUserSwitchComplete-" + newUserId);
        this.mInjector.getWindowManager().setSwitchingUser(false);
        int observerCount = this.mUserSwitchObservers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= observerCount) goto L8;
        t.traceBegin("onUserSwitchComplete-" + newUserId + " #" + i + " " + this.mUserSwitchObservers.getBroadcastCookie(i));     // Catch: RemoteException -> L6
        this.mUserSwitchObservers.getBroadcastItem(i).onUserSwitchComplete(newUserId);     // Catch: RemoteException -> L6
        t.traceEnd();     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mUserSwitchObservers.finishBroadcast();
        t.traceBegin("sendUserSwitchBroadcasts-" + oldUserId + "-" + newUserId);
        sendUserSwitchBroadcasts(oldUserId, newUserId);
        t.traceEnd();
        t.traceEnd();
        endUserSwitch();
    }

    private void endUserSwitch() {
        this.mInjector.setPerformancePowerMode(false);
        Object r0 = this.mLock;
        monitor-enter(r0);
        int nextUserId = ((Integer) ObjectUtils.getOrElse(this.mPendingTargetUserIds.poll(), Integer.valueOf(ProcessList.INVALID_ADJ))).intValue();     // Catch: Throwable -> L9
        this.mTargetUserId = ProcessList.INVALID_ADJ;     // Catch: Throwable -> L9
        ActivityManager.invalidateGetCurrentUserIdCache();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (nextUserId == (-10000)) goto L14;
        switchUser(nextUserId);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void dispatchLockedBootComplete(int userId) {
        int observerCount = this.mUserSwitchObservers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= observerCount) goto L8;
        this.mUserSwitchObservers.getBroadcastItem(i).onLockedBootComplete(userId);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mUserSwitchObservers.finishBroadcast();
    }

    private void stopUserOnSwitchIfEnforced(int oldUserId) {
        if (oldUserId != 0) goto L4;
        return;
    L4:
        boolean hasRestriction = hasUserRestriction("no_run_in_background", oldUserId);
        Object r2 = this.mLock;
        monitor-enter(r2);
        boolean r0 = false;
        if (hasRestriction == true) goto L32;
    L29:
        th = th;
    L39:
        monitor-exit(r2);     // Catch: Throwable -> L38
        throw th;
    L9:
        if (isStopUserOnSwitchEnabled() == true) goto L32;
        monitor-exit(r2);     // Catch: Throwable -> L29
        List<UserInfo> profiles = this.mInjector.getUserManager().getProfiles(oldUserId, false);
        int count = profiles.size();
        int i = 0;
    L13:
        if (i >= count) goto L28;
        int profileUserId = profiles.get(i).id;
        if (hasUserRestriction("no_run_in_background", profileUserId) == false) goto L26;
        Slogf.i(TAG, "Stopping profile %d on user switch", new Object[]{Integer.valueOf(profileUserId)});
        Object r11 = this.mLock;
        monitor-enter(r11);
        stopUsersLU(profileUserId, false, false, null, null);     // Catch: Throwable -> L22
        monitor-exit(r11);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L26:
        i = i + 1;
        goto L13
    L28:
        return;
    L32:
        Slogf.i(TAG, "Stopping user %d and its profiles on user switch", new Object[]{Integer.valueOf(oldUserId)});     // Catch: Throwable -> L38
        if (hasRestriction == true) goto L35;
        r0 = true;
    L35:
        stopUsersLU(oldUserId, r0, null, null);     // Catch: Throwable -> L38
        monitor-exit(r2);     // Catch: Throwable -> L38
        return;
    L38:
        th = th;
        goto L39
    }

    private void scheduleStopOfBackgroundUser(int oldUserId) {
    }

    void processScheduledStopOfBackgroundUser(Integer userIdInteger) {
        int userId = userIdInteger.intValue();
        Slogf.d(TAG, "Considering stopping background user %d due to inactivity", new Object[]{Integer.valueOf(userId)});
        if (avoidStoppingUserDueToUpcomingAlarm(userId) == false) goto L6;
        scheduleStopOfBackgroundUser(userId);
        return;
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (getCurrentOrTargetUserIdLU() != userId) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L15:
        if (this.mPendingTargetUserIds.contains(userIdInteger) == false) goto L18;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L18:
        UserInfo currentOrTargetUser = getCurrentUserLU();     // Catch: Throwable -> L12
        if (currentOrTargetUser != null) goto L21;
    L25:
        Slogf.i(TAG, "Stopping background user %d due to inactivity", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L12
        stopUsersLU(userId, true, null, null);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L21:
        if (currentOrTargetUser.isGuest() == false) goto L25;
        scheduleStopOfBackgroundUser(userId);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
    }

    private boolean avoidStoppingUserDueToUpcomingAlarm(int userId) {
        long alarmWallclockMs = this.mInjector.getAlarmManagerInternal().getNextAlarmTriggerTimeForUser(userId);
        if (System.currentTimeMillis() < alarmWallclockMs) goto L5;
    L7:
        return false;
    L5:
        if (alarmWallclockMs >= (System.currentTimeMillis() + 3600000)) goto L7;
        return true;
    }

    private void timeoutUserSwitch(UserState uss, int oldUserId, int newUserId) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog(TAG);
        t.traceBegin("timeoutUserSwitch-" + oldUserId + "-to-" + newUserId);
        Object r1 = this.mLock;
        monitor-enter(r1);
        Slogf.e(TAG, "User switch timeout: from " + oldUserId + " to " + newUserId);     // Catch: Throwable -> L8
        this.mTimeoutUserSwitchCallbacks = this.mCurWaitingUserSwitchCallbacks;     // Catch: Throwable -> L8
        this.mHandler.removeMessages(90);     // Catch: Throwable -> L8
        sendContinueUserSwitchLU(uss, oldUserId, newUserId);     // Catch: Throwable -> L8
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(90, oldUserId, newUserId), 5000);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        t.traceEnd();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void timeoutUserSwitchCallbacks(int oldUserId, int newUserId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mTimeoutUserSwitchCallbacks != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mTimeoutUserSwitchCallbacks.isEmpty() == true) goto L11;
        Slogf.wtf(TAG, "User switch timeout: from " + oldUserId + " to " + newUserId + ". Observers that didn't respond: " + this.mTimeoutUserSwitchCallbacks);     // Catch: Throwable -> L9
        this.mTimeoutUserSwitchCallbacks = null;     // Catch: Throwable -> L9
        goto L11
    }

    void dispatchUserSwitch(final UserState uss, final int oldUserId, final int newUserId) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("dispatchUserSwitch-" + oldUserId + "-to-" + newUserId);
        EventLog.writeEvent(EventLogTags.UC_DISPATCH_USER_SWITCH, new Object[]{Integer.valueOf(oldUserId), Integer.valueOf(newUserId)});
        uss.switching = true;
        informUserSwitchObservers(new UserController$$ExternalSyntheticLambda18(newUserId), new UserController$$ExternalSyntheticLambda19(this, uss, oldUserId, newUserId), "onUserSwitching");
        t.traceEnd();
    }

    private static /* synthetic */ void lambda$dispatchUserSwitch$22(int newUserId, IUserSwitchObserver observer, IRemoteCallback callback) {
        observer.onUserSwitching(newUserId, callback);     // Catch: RemoteException -> L4
        return;
    }

    private /* synthetic */ void lambda$dispatchUserSwitch$23(UserState uss, int oldUserId, int newUserId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        sendContinueUserSwitchLU(uss, oldUserId, newUserId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void informUserSwitchObservers(BiConsumer<IUserSwitchObserver, IRemoteCallback> consumer, final Runnable onComplete, final String trace) {
        int observerCount = this.mUserSwitchObservers.beginBroadcast();
        if (observerCount != 0) goto L6;
        onComplete.run();
        this.mUserSwitchObservers.finishBroadcast();
        return;
    L6:
        final ArraySet<String> curWaitingUserSwitchCallbacks = new ArraySet();
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCurWaitingUserSwitchCallbacks = curWaitingUserSwitchCallbacks;     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Throwable -> L25
        final AtomicInteger waitingCallbacksCount = new AtomicInteger(observerCount);
        final long userSwitchTimeoutMs = getUserSwitchTimeoutMs();
        final long dispatchStartedTime = SystemClock.elapsedRealtime();
        int i = 0;
    L11:
        if (i >= observerCount) goto L23;
        final long dispatchStartedTimeForObserver = SystemClock.elapsedRealtime();
        final String name = "#" + i + " " + this.mUserSwitchObservers.getBroadcastCookie(i);
        Object r3 = this.mLock;
        monitor-enter(r3);
        curWaitingUserSwitchCallbacks.add(name);     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        IRemoteCallback.Stub r0 = new AnonymousClass7(this, trace, name, dispatchStartedTimeForObserver, dispatchStartedTime, userSwitchTimeoutMs, curWaitingUserSwitchCallbacks, waitingCallbacksCount, onComplete);
        asyncTraceBegin(trace + "-" + name, 0);
        consumer.accept((IUserSwitchObserver) this.mUserSwitchObservers.getBroadcastItem(i), r0);
        i = i + 1;
    L17:
        th = th;
    L33:
        throw th;
    L21:
        th = th;
        goto L33
    L23:
        this.mUserSwitchObservers.finishBroadcast();
        return;
    L25:
        th = th;
    L35:
        throw th;
    L29:
        th = th;
        goto L35
    }

    private void sendContinueUserSwitchLU(UserState uss, int oldUserId, int newUserId) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog(TAG);
        t.traceBegin("sendContinueUserSwitchLU-" + oldUserId + "-to-" + newUserId);
        this.mCurWaitingUserSwitchCallbacks = null;
        this.mHandler.removeMessages(30);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(20, oldUserId, newUserId, uss));
        t.traceEnd();
    }

    void continueUserSwitch(UserState uss, int oldUserId, int newUserId) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("continueUserSwitch-" + oldUserId + "-to-" + newUserId);
        EventLog.writeEvent(EventLogTags.UC_CONTINUE_USER_SWITCH, new Object[]{Integer.valueOf(oldUserId), Integer.valueOf(newUserId)});
        this.mHandler.removeMessages(130);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(130, oldUserId, newUserId));
        uss.switching = false;
        stopGuestOrEphemeralUserIfBackground(oldUserId);
        stopUserOnSwitchIfEnforced(oldUserId);
        scheduleStopOfBackgroundUser(oldUserId);
        t.traceEnd();
    }

    void completeUserSwitch(final int oldUserId, final int newUserId) {
        Runnable runnable = new UserController$$ExternalSyntheticLambda21(this, oldUserId, newUserId);
        if (isUserSwitchUiEnabled() == false) goto L5;
        dismissUserSwitchDialog(runnable);
        return;
    L5:
        runnable.run();
    }

    private /* synthetic */ void lambda$completeUserSwitch$24(int oldUserId, int newUserId) {
        this.mHandler.removeMessages(80);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(80, oldUserId, newUserId));
    }

    private void moveUserToForeground(UserState uss, int newUserId) {
        boolean homeInFront = this.mInjector.taskSupervisorSwitchUser(newUserId, uss);
        if (homeInFront == false) goto L5;
        this.mInjector.startHomeActivity(newUserId, "moveUserToForeground");
    L6:
        EventLogTags.writeAmSwitchUser(newUserId);
        return;
    L5:
        this.mInjector.taskSupervisorResumeFocusedStackTopActivity();
        goto L6
    }

    void sendUserStartedBroadcast(int userId, int callingUid, int callingPid) {
        if (userId != 0) goto L17;
        Object r3 = this.mLock;
        monitor-enter(r3);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.mIsBroadcastSentForSystemUserStarted == false) goto L12;
        monitor-exit(r3);     // Catch: Throwable -> L10
        return;
    L12:
        this.mIsBroadcastSentForSystemUserStarted = true;     // Catch: Throwable -> L10
        monitor-exit(r3);     // Catch: Throwable -> L10
    L17:
        Intent intent = new Intent("android.intent.action.USER_STARTED");
        intent.addFlags(1342177280);
        intent.putExtra("android.intent.extra.user_handle", userId);
        this.mInjector.broadcastIntent(intent, null, null, 0, null, null, null, -1, null, false, ActivityManagerService.MY_PID, 1000, callingUid, callingPid, userId);
    }

    void sendUserStartingBroadcast(int userId, int callingUid, int callingPid) {
        if (userId != 0) goto L17;
        Object r3 = this.mLock;
        monitor-enter(r3);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.mIsBroadcastSentForSystemUserStarting == false) goto L12;
        monitor-exit(r3);     // Catch: Throwable -> L10
        return;
    L12:
        this.mIsBroadcastSentForSystemUserStarting = true;     // Catch: Throwable -> L10
        monitor-exit(r3);     // Catch: Throwable -> L10
    L17:
        Intent intent = new Intent("android.intent.action.USER_STARTING");
        intent.addFlags(1073741824);
        intent.putExtra("android.intent.extra.user_handle", userId);
        this.mInjector.broadcastIntent(intent, null, new AnonymousClass8(this), 0, null, null, new String[]{"android.permission.INTERACT_ACROSS_USERS"}, -1, null, false, ActivityManagerService.MY_PID, 1000, callingUid, callingPid, -1);
    }

    void sendUserSwitchBroadcasts(int oldUserId, int newUserId) {
        UserController r1 = this;
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        long ident = Binder.clearCallingIdentity();
        String r4 = "android.intent.extra.USER";
        String r5 = "android.intent.extra.user_handle";
        int r6 = 1342177280;
        if (oldUserId >= 0) goto L26;
        String r28 = "android.intent.extra.USER";
        String r29 = "android.intent.extra.user_handle";
    L11:
        if (newUserId < 0) goto L24;
        List<UserInfo> profiles = r1.mInjector.getUserManager().getProfiles(newUserId, false);     // Catch: Throwable -> L7
        int count = profiles.size();     // Catch: Throwable -> L7
        int i = 0;
    L14:
        if (i >= count) goto L18;
        int profileUserId = profiles.get(i).id;     // Catch: Throwable -> L16
        Intent intent = new Intent("android.intent.action.USER_FOREGROUND");     // Catch: Throwable -> L16
        intent.addFlags(1342177280);     // Catch: Throwable -> L16
        String r9 = r29;
        intent.putExtra(r9, profileUserId);     // Catch: Throwable -> L16
        String r11 = r28;
        intent.putExtra(r11, UserHandle.of(profileUserId));     // Catch: Throwable -> L16
        int count2 = count;
        r1.mInjector.broadcastIntent(intent, null, null, 0, null, null, null, -1, null, false, ActivityManagerService.MY_PID, 1000, callingUid, callingPid, profileUserId);     // Catch: Throwable -> L16
        r1 = this;
        r28 = r11;
        r29 = r9;
        i = i + 1;     // Catch: Throwable -> L16
        count = count2;
        profiles = profiles;
    L16:
        th = th;
    L22:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L18:
        Intent intent2 = new Intent("android.intent.action.USER_SWITCHED");     // Catch: Throwable -> L16
        intent2.addFlags(1342177280);     // Catch: Throwable -> L16
        intent2.putExtra(r29, newUserId);     // Catch: Throwable -> L16
        intent2.putExtra(r28, UserHandle.of(newUserId));     // Catch: Throwable -> L16
        this.mInjector.broadcastIntent(intent2, null, null, 0, null, null, new String[]{"android.permission.MANAGE_USERS"}, -1, null, false, ActivityManagerService.MY_PID, 1000, callingUid, callingPid, -1);     // Catch: Throwable -> L7
    L7:
        th = th;
    L24:
        Binder.restoreCallingIdentity(ident);
        return;
    L26:
        List<UserInfo> profiles2 = r1.mInjector.getUserManager().getProfiles(oldUserId, false);     // Catch: Throwable -> L7
        int count3 = profiles2.size();     // Catch: Throwable -> L7
        int i2 = 0;
    L5:
        if (i2 >= count3) goto L9;
        int profileUserId2 = profiles2.get(i2).id;     // Catch: Throwable -> L7
        Intent intent3 = new Intent("android.intent.action.USER_BACKGROUND");     // Catch: Throwable -> L7
        intent3.addFlags(r6);     // Catch: Throwable -> L7
        intent3.putExtra(r5, profileUserId2);     // Catch: Throwable -> L7
        intent3.putExtra(r4, UserHandle.of(profileUserId2));     // Catch: Throwable -> L7
        String r12 = r4;
        r1.mInjector.broadcastIntent(intent3, null, null, 0, null, null, null, -1, null, false, ActivityManagerService.MY_PID, 1000, callingUid, callingPid, profileUserId2);     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        count3 = count3;
        profiles2 = profiles2;
        r4 = r12;
        r5 = r5;
        r6 = 1342177280;
        goto L5
    L9:
        r28 = r4;
        r29 = r5;
        goto L11
    }

    private void broadcastProfileAccessibleStateChanged(int userId, int parentId, String intentAction) {
        Intent intent = new Intent(intentAction);
        intent.putExtra("android.intent.extra.USER", UserHandle.of(userId));
        intent.addFlags(1342177280);
        this.mInjector.broadcastIntent(intent, null, null, 0, null, null, null, -1, null, false, ActivityManagerService.MY_PID, 1000, Binder.getCallingUid(), Binder.getCallingPid(), parentId);
    }

    int handleIncomingUser(int callingPid, int callingUid, int userId, boolean allowAll, int allowMode, String name, String callerPackage) {
        int r4 = callingUid;
        int callingUserId = UserHandle.getUserId(r4);
        if (callingUserId != userId) goto L6;
        return userId;
    L6:
        if (DoppelgangerManager.allowCrossUser(callingUserId, userId) == false) goto L8;
        return userId;
    L8:
        int targetUserId = unsafeConvertIncomingUser(userId);
        if (r4 != 0) goto L11;
    L56:
        UserController r8 = this;
    L57:
        if (allowAll == true) goto L60;
        r8.ensureNotSpecialUser(targetUserId);
    L60:
        if (r4 != 2000) goto L67;
        if (targetUserId < 0) goto L67;
        if (r8.hasUserRestriction("no_debugging_features", targetUserId) == false) goto L67;
        throw new SecurityException("Shell does not have permission to access user " + targetUserId + "\n " + Debug.getCallers(3));
    L67:
        return targetUserId;
    L11:
        if (r4 == 1000) goto L56;
        boolean isSameProfileGroup = isSameProfileGroup(callingUserId, targetUserId);
        if (this.mInjector.isCallerRecents(r4) == false) goto L17;
        if (isSameProfileGroup == false) goto L17;
        boolean allow = true;
        String r15 = callerPackage;
        boolean isSameProfileGroup2 = isSameProfileGroup;
        int r12 = allowMode;
        r8 = this;
    L35:
        if (allow == true) goto L57;
        if (userId != (-3)) goto L39;
        targetUserId = callingUserId;
        goto L57
    L39:
        StringBuilder builder = new StringBuilder(128);
        builder.append("Permission Denial: ");
        builder.append(name);
        if (r15 == null) goto L42;
        builder.append(" from ");
        builder.append(r15);
    L42:
        builder.append(" asks to run as user ");
        builder.append(userId);
        builder.append(" but is calling from uid ");
        UserHandle.formatUid(builder, r4);
        builder.append("; this requires ");
        builder.append("android.permission.INTERACT_ACROSS_USERS_FULL");
        if (r12 != 2) goto L45;
    L53:
        String msg = builder.toString();
        Slogf.w(TAG, msg);
        throw new SecurityException(msg);
    L45:
        if (r12 == 0) goto L49;
        if (r12 == 3) goto L49;
        if (r12 != 1) goto L50;
        if (isSameProfileGroup2 == true) goto L49;
    L50:
        if (isSameProfileGroup2 == false) goto L53;
        if (r12 != 3) goto L53;
        builder.append(" or ");
        builder.append("android.permission.INTERACT_ACROSS_PROFILES");
    L49:
        builder.append(" or ");
        builder.append("android.permission.INTERACT_ACROSS_USERS");
    L17:
        if (this.mInjector.checkComponentPermission("android.permission.INTERACT_ACROSS_USERS_FULL", callingPid, r4, -1, true) != 0) goto L19;
        allow = true;
        r4 = callingUid;
        r15 = callerPackage;
        isSameProfileGroup2 = isSameProfileGroup;
        r12 = allowMode;
        r8 = this;
        goto L35
    L19:
        if (allowMode != 2) goto L21;
        allow = false;
        r4 = callingUid;
        r15 = callerPackage;
        isSameProfileGroup2 = isSameProfileGroup;
        r12 = allowMode;
        r8 = this;
        goto L35
    L21:
        boolean r6 = canInteractWithAcrossProfilesPermission(allowMode, isSameProfileGroup, callingPid, callingUid, callerPackage);
        r8 = this;
        r12 = allowMode;
        isSameProfileGroup2 = isSameProfileGroup;
        r15 = callerPackage;
        if (r6 == false) goto L24;
        allow = true;
        r4 = callingUid;
        goto L35
    L24:
        r4 = callingUid;
        if (r8.mInjector.checkComponentPermission("android.permission.INTERACT_ACROSS_USERS", callingPid, callingUid, -1, true) == 0) goto L27;
        allow = false;
        goto L35
    L27:
        if (r12 == 0) goto L34;
        if (r12 == 3) goto L34;
        if (r12 != 1) goto L33;
        allow = isSameProfileGroup2;
        goto L35
    L33:
        throw new IllegalArgumentException("Unknown mode: " + r12);
    L34:
        allow = true;
        goto L35
    }

    private boolean canInteractWithAcrossProfilesPermission(int allowMode, boolean isSameProfileGroup, int callingPid, int callingUid, String callingPackage) {
        if (allowMode == 3) goto L5;
        return false;
    L5:
        if (isSameProfileGroup == true) goto L8;
        return false;
    L8:
        return this.mInjector.checkPermissionForPreflight("android.permission.INTERACT_ACROSS_PROFILES", callingPid, callingUid, callingPackage);
    }

    int unsafeConvertIncomingUser(int userId) {
        if (userId == (-2)) goto L9;
        if (userId == (-3)) goto L9;
        return userId;
    L9:
        return getCurrentUserId();
    }

    void ensureNotSpecialUser(int userId) {
        if (userId < 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Call does not support special user #" + userId);
    }

    void registerUserSwitchObserver(IUserSwitchObserver observer, String name) {
        name.getClass();
        checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "registerUserSwitchObserver");
        this.mUserSwitchObservers.register(observer, name);
    }

    void sendForegroundProfileChanged(int userId) {
        this.mHandler.removeMessages(70);
        this.mHandler.obtainMessage(70, userId, 0).sendToTarget();
    }

    void unregisterUserSwitchObserver(IUserSwitchObserver observer) {
        this.mUserSwitchObservers.unregister(observer);
    }

    UserState getStartedUserState(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserState r1 = this.mStartedUsers.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean hasStartedUserState(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mStartedUsers.get(userId) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private void updateStartedUserArrayLU() {
        int num = 0;
        int i = 0;
    L4:
        if (i >= this.mStartedUsers.size()) goto L11;
        UserState uss = this.mStartedUsers.valueAt(i);
        if (uss.state == 4) goto L10;
        if (uss.state == 5) goto L10;
        num = num + 1;
    L10:
        i = i + 1;
        goto L4
    L11:
        this.mStartedUserArray = new int[num];
        int num2 = 0;
        int i2 = 0;
    L13:
        if (i2 >= this.mStartedUsers.size()) goto L21;
        UserState uss2 = this.mStartedUsers.valueAt(i2);
        if (uss2.state == 4) goto L19;
        if (uss2.state == 5) goto L19;
        this.mStartedUserArray[num2] = this.mStartedUsers.keyAt(i2);
        num2 = num2 + 1;
    L19:
        i2 = i2 + 1;
        goto L13
    }

    void setAllowUserUnlocking(boolean allowed) {
        this.mAllowUserUnlocking = allowed;
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L6;
        Slogf.d(TAG, new Exception(), "setAllowUserUnlocking(%b)", new Object[]{Boolean.valueOf(allowed)});
        return;
    }

    void onBootComplete(IIntentReceiver resultTo) {
        boolean r0 = true;
        setAllowUserUnlocking(true);
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseArray<UserState> startedUsers = this.mStartedUsers.clone();     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        if (startedUsers.keyAt(0) == 0) goto L10;
        r0 = false;
    L10:
        Preconditions.checkArgument(r0);
        int i = 0;
    L12:
        if (i >= startedUsers.size()) goto L19;
        int userId = startedUsers.keyAt(i);
        UserState uss = startedUsers.valueAt(i);
        if (this.mInjector.isHeadlessSystemUserMode() == true) goto L16;
        finishUserBoot(uss, resultTo);
    L17:
        i = i + 1;
        goto L12
    L16:
        sendLockedBootCompletedBroadcast(resultTo, userId);
        maybeUnlockUser(userId);
        goto L17
    L19:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    void onSystemReady() {
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L5;
        Slogf.d(TAG, "onSystemReady()");
    L5:
        this.mInjector.getUserManagerInternal().addUserLifecycleListener(this.mUserLifecycleListener);
        updateProfileRelatedCaches();
        this.mInjector.reportCurWakefulnessUsageEvent();
        ActivityManager.invalidateGetCurrentUserIdCache();
    }

    void onSystemUserStarting() {
        if (this.mInjector.isHeadlessSystemUserMode() == true) goto L6;
        this.mInjector.onUserStarting(0);
        this.mInjector.onSystemUserVisibilityChanged(true);
        return;
    }

    private void updateProfileRelatedCaches() {
        List<UserInfo> profiles = this.mInjector.getUserManager().getProfiles(getCurrentUserId(), false);
        int[] currentProfileIds = new int[profiles.size()];
        int i = 0;
    L4:
        if (i >= currentProfileIds.length) goto L6;
        currentProfileIds[i] = profiles.get(i).id;
        i = i + 1;
        goto L4
    L6:
        List<UserInfo> users = this.mInjector.getUserManager().getUsers(false);
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mCurrentProfileIds = currentProfileIds;     // Catch: Throwable -> L14
        this.mUserProfileGroupIds.clear();     // Catch: Throwable -> L14
        int i2 = 0;
    L10:
        if (i2 >= users.size()) goto L18;
        UserInfo user = users.get(i2);     // Catch: Throwable -> L14
        if (user.profileGroupId == (-10000)) goto L16;
        this.mUserProfileGroupIds.put(user.id, user.profileGroupId);     // Catch: Throwable -> L14
    L16:
        i2 = i2 + 1;     // Catch: Throwable -> L14
        goto L10
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    int[] getStartedUserArray() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int[] r1 = this.mStartedUserArray;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isUserRunning(int userId, int flags) {
        UserState state = getStartedUserState(userId);
        if (state != null) goto L6;
        return false;
    L6:
        if ((flags & 1) == 0) goto L9;
        return true;
    L9:
        if ((flags & 2) == 0) goto L15;
        switch(state.state) {
            case 0: goto L13;
            case 1: goto L13;
            default: goto L12;
        };
    L12:
        return false;
    L13:
        return true;
    L15:
        if ((flags & 8) == 0) goto L23;
        switch(state.state) {
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L20;
            default: goto L18;
        };
    L18:
        return false;
    L21:
        return true;
    L20:
        return StorageManager.isCeStorageUnlocked(userId);
    L23:
        if ((flags & 4) == 0) goto L31;
        switch(state.state) {
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L28;
            default: goto L26;
        };
    L26:
        return false;
    L29:
        return true;
    L28:
        return StorageManager.isCeStorageUnlocked(userId);
    L31:
        if (state.state != 4) goto L33;
        return false;
    L33:
        if (state.state != 5) goto L35;
        return false;
    L35:
        return true;
    }

    boolean isSystemUserStarted() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        UserState uss = this.mStartedUsers.get(0);     // Catch: Throwable -> L8
        if (uss != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L11:
        if (uss.state != 1) goto L13;
    L16:
        r2 = true;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L13:
        if (uss.state == 2) goto L16;
        if (uss.state != 3) goto L17;
    L8:
        th = move-exception;
        throw th;
    }

    private void checkGetCurrentUserPermissions() {
        if (this.mInjector.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS") != 0) goto L5;
        return;
    L5:
        if (this.mInjector.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) goto L10;
        String msg = "Permission Denial: getCurrentUser() from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " requires android.permission.INTERACT_ACROSS_USERS";
        Slogf.w(TAG, msg);
        throw new SecurityException(msg);
    }

    UserInfo getCurrentUser() {
        checkGetCurrentUserPermissions();
        if (this.mTargetUserId == (-10000)) goto L5;
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserInfo r1 = getCurrentUserLU();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return getUserInfo(this.mCurrentUserId);
    }

    int getCurrentUserIdChecked() {
        checkGetCurrentUserPermissions();
        if (this.mTargetUserId != (-10000)) goto L7;
        return this.mCurrentUserId;
    L7:
        return getCurrentOrTargetUserId();
    }

    private UserInfo getCurrentUserLU() {
        int userId = getCurrentOrTargetUserIdLU();
        return getUserInfo(userId);
    }

    int getCurrentOrTargetUserId() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = getCurrentOrTargetUserIdLU();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private int getCurrentOrTargetUserIdLU() {
        if (this.mTargetUserId == (-10000)) goto L6;
        return this.mTargetUserId;
    L6:
        return this.mCurrentUserId;
    }

    Pair<Integer, Integer> getCurrentAndTargetUserIds() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Pair<Integer, Integer> r1 = new Pair(Integer.valueOf(this.mCurrentUserId), Integer.valueOf(this.mTargetUserId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private int getCurrentUserIdLU() {
        return this.mCurrentUserId;
    }

    int getCurrentUserId() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mCurrentUserId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isCurrentUserLU(int userId) {
        if (userId != getCurrentOrTargetUserIdLU()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isAlwaysVisibleUser(int userId) {
        UserProperties properties = getUserProperties(userId);
        if (properties != null) goto L5;
    L7:
        return false;
    L5:
        if (properties.getAlwaysVisible() == false) goto L7;
        return true;
    }

    int[] getUsers() {
        UserManagerService ums = this.mInjector.getUserManager();
        if (ums == null) goto L6;
        return ums.getUserIds();
    L6:
        return new int[]{0};
    }

    private UserInfo getUserInfo(int userId) {
        return this.mInjector.getUserManager().getUserInfo(userId);
    }

    private UserProperties getUserProperties(int userId) {
        return this.mInjector.getUserManagerInternal().getUserProperties(userId);
    }

    int[] getUserIds() {
        return this.mInjector.getUserManager().getUserIds();
    }

    int[] expandUserId(int userId) {
        if (userId == (-1)) goto L7;
        return new int[]{userId};
    L7:
        return getUsers();
    }

    boolean exists(int userId) {
        return this.mInjector.getUserManager().exists(userId);
    }

    private void checkCallingPermission(String permission, String methodName) {
        checkCallingHasOneOfThosePermissions(methodName, new String[]{permission});
    }

    private void checkCallingHasOneOfThosePermissions(String methodName, String... permissions) {
        int r0 = permissions.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        String permission = permissions[r2];
        if (this.mInjector.checkCallingPermission(permission) == 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return;
    L8:
        StringBuilder r1 = new StringBuilder();
        r1.append("Permission denial: ");
        r1.append(methodName);
        r1.append("() from pid=");
        r1.append(Binder.getCallingPid());
        r1.append(", uid=");
        r1.append(Binder.getCallingUid());
        r1.append(" requires ");
        if (permissions.length != 1) goto L11;
        String r3 = permissions[0];
    L12:
        r1.append(r3);
        String msg = r1.toString();
        Slogf.w(TAG, msg);
        throw new SecurityException(msg);
    L11:
        r3 = "one of " + Arrays.toString(permissions);
        goto L12
    }

    private void enforceShellRestriction(String restriction, int userId) {
        if (Binder.getCallingUid() != 2000) goto L10;
        if (userId < 0) goto L9;
        if (hasUserRestriction(restriction, userId) == true) goto L9;
        return;
    L9:
        throw new SecurityException("Shell does not have permission to access user " + userId);
    }

    boolean hasUserRestriction(String restriction, int userId) {
        return this.mInjector.getUserManager().hasUserRestriction(restriction, userId);
    }

    boolean isSameProfileGroup(int callingUserId, int targetUserId) {
        boolean r0 = true;
        if (callingUserId != targetUserId) goto L5;
        return true;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int callingProfile = this.mUserProfileGroupIds.get(callingUserId, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L14
        int targetProfile = this.mUserProfileGroupIds.get(targetUserId, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L14
        if (callingProfile == (-10000)) goto L11;
        if (callingProfile != targetProfile) goto L11;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r0;
    L11:
        r0 = false;
    L14:
        th = move-exception;
        throw th;
    }

    boolean isUserOrItsParentRunning(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (isUserRunning(userId, 0) == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L12:
        int parentUserId = this.mUserProfileGroupIds.get(userId, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L10
        if (parentUserId != (-10000)) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L16:
        boolean r1 = isUserRunning(parentUserId, 0);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    boolean isCurrentProfile(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = ArrayUtils.contains(this.mCurrentProfileIds, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int[] getCurrentProfileIds() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int[] r1 = this.mCurrentProfileIds;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void onUserAdded(UserInfo user) {
        if (user.isProfile() == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (user.profileGroupId != this.mCurrentUserId) goto L13;
        this.mCurrentProfileIds = ArrayUtils.appendInt(this.mCurrentProfileIds, user.id);     // Catch: Throwable -> L10
    L13:
        if (user.profileGroupId == (-10000)) goto L15;
        this.mUserProfileGroupIds.put(user.id, user.profileGroupId);     // Catch: Throwable -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int size = this.mUserProfileGroupIds.size();     // Catch: Throwable -> L11
        int i = size - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L15;
        if (this.mUserProfileGroupIds.keyAt(i) != userId) goto L9;
    L13:
        this.mUserProfileGroupIds.removeAt(i);     // Catch: Throwable -> L11
    L14:
        i = i - 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        if (this.mUserProfileGroupIds.valueAt(i) != userId) goto L14;
    L15:
        this.mCurrentProfileIds = ArrayUtils.removeInt(this.mCurrentProfileIds, userId);     // Catch: Throwable -> L11
        this.mUserLru.remove(Integer.valueOf(userId));     // Catch: Throwable -> L11
        this.mStartedUsers.remove(userId);     // Catch: Throwable -> L11
        updateStartedUserArrayLU();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    protected boolean shouldConfirmCredentials(int userId) {
        if (getStartedUserState(userId) != null) goto L5;
        return false;
    L5:
        UserProperties properties = getUserProperties(userId);
        if (properties != null) goto L8;
    L20:
        return false;
    L8:
        if (properties.isCredentialShareableWithParent() == false) goto L20;
        if (this.mLockPatternUtils.isSeparateProfileChallengeEnabled(userId) == false) goto L19;
        KeyguardManager km = this.mInjector.getKeyguardManager();
        if (km.isDeviceLocked(userId) == true) goto L15;
        return false;
    L15:
        if (km.isDeviceSecure(userId) == false) goto L22;
        return true;
    L22:
        return false;
    L19:
        return isUserRunning(userId, 2);
    }

    boolean isLockScreenDisabled(int userId) {
        return this.mLockPatternUtils.isLockScreenDisabled(userId);
    }

    void setSwitchingFromUserMessage(int user, String message) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSwitchingFromUserMessage.put(user, message);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setSwitchingToUserMessage(int user, String message) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSwitchingToUserMessage.put(user, message);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    String getSwitchingFromUserMessage(int userId) {
        checkHasManageUsersPermission("getSwitchingFromUserMessage()");
        return getSwitchingFromUserMessageUnchecked(userId);
    }

    String getSwitchingToUserMessage(int userId) {
        checkHasManageUsersPermission("getSwitchingToUserMessage()");
        return getSwitchingToUserMessageUnchecked(userId);
    }

    private String getSwitchingFromUserMessageUnchecked(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mSwitchingFromUserMessage.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private String getSwitchingToUserMessageUnchecked(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mSwitchingToUserMessage.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void checkHasManageUsersPermission(String operation) {
        if (this.mInjector.checkCallingPermission("android.permission.MANAGE_USERS") == (-1)) goto L6;
        return;
    L6:
        throw new SecurityException("You need MANAGE_USERS permission to call " + operation);
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long token = proto.start(fieldId);     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mStartedUsers.size()) goto L10;
        UserState uss = this.mStartedUsers.valueAt(i);     // Catch: Throwable -> L8
        long uToken = proto.start(2246267895809L);     // Catch: Throwable -> L8
        proto.write(1120986464257L, uss.mHandle.getIdentifier());     // Catch: Throwable -> L8
        uss.dumpDebug(proto, 1146756268034L);     // Catch: Throwable -> L8
        proto.end(uToken);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        int i2 = 0;
    L12:
        if (i2 >= this.mStartedUserArray.length) goto L14;
        proto.write(2220498092034L, this.mStartedUserArray[i2]);     // Catch: Throwable -> L8
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L12
    L14:
        int i3 = 0;
    L16:
        if (i3 >= this.mUserLru.size()) goto L19;
        proto.write(2220498092035L, this.mUserLru.get(i3).intValue());     // Catch: Throwable -> L8
        i3 = i3 + 1;     // Catch: Throwable -> L8
        goto L16
    L19:
        if (this.mUserProfileGroupIds.size() <= 0) goto L24;
        int i4 = 0;
    L22:
        if (i4 >= this.mUserProfileGroupIds.size()) goto L24;
        long uToken2 = proto.start(2246267895812L);     // Catch: Throwable -> L8
        proto.write(1120986464257L, this.mUserProfileGroupIds.keyAt(i4));     // Catch: Throwable -> L8
        proto.write(1120986464258L, this.mUserProfileGroupIds.valueAt(i4));     // Catch: Throwable -> L8
        proto.end(uToken2);     // Catch: Throwable -> L8
        i4 = i4 + 1;     // Catch: Throwable -> L8
    L24:
        int i5 = this.mCurrentUserId;     // Catch: Throwable -> L8
        proto.write(1120986464261L, i5);     // Catch: Throwable -> L8
        int i6 = 0;
    L26:
        if (i6 >= this.mCurrentProfileIds.length) goto L28;
        proto.write(2220498092038L, this.mCurrentProfileIds[i6]);     // Catch: Throwable -> L8
        i6 = i6 + 1;     // Catch: Throwable -> L8
        goto L26
    L28:
        proto.end(token);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("  mStartedUsers:");     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mStartedUsers.size()) goto L10;
        UserState uss = this.mStartedUsers.valueAt(i);     // Catch: Throwable -> L8
        pw.print("    User #");     // Catch: Throwable -> L8
        pw.print(uss.mHandle.getIdentifier());     // Catch: Throwable -> L8
        pw.print(": ");     // Catch: Throwable -> L8
        uss.dump("", pw);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        pw.print("  mStartedUserArray: [");     // Catch: Throwable -> L8
        int i2 = 0;
    L12:
        if (i2 >= this.mStartedUserArray.length) goto L16;
        if (i2 <= 0) goto L15;
        pw.print(", ");     // Catch: Throwable -> L8
    L15:
        pw.print(this.mStartedUserArray[i2]);     // Catch: Throwable -> L8
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L12
    L16:
        pw.println("]");     // Catch: Throwable -> L8
        pw.print("  mUserLru: [");     // Catch: Throwable -> L8
        int i3 = 0;
    L18:
        if (i3 >= this.mUserLru.size()) goto L22;
        if (i3 <= 0) goto L21;
        pw.print(", ");     // Catch: Throwable -> L8
    L21:
        pw.print(this.mUserLru.get(i3));     // Catch: Throwable -> L8
        i3 = i3 + 1;     // Catch: Throwable -> L8
        goto L18
    L22:
        pw.println("]");     // Catch: Throwable -> L8
        if (this.mUserProfileGroupIds.size() <= 0) goto L28;
        pw.println("  mUserProfileGroupIds:");     // Catch: Throwable -> L8
        int i4 = 0;
    L26:
        if (i4 >= this.mUserProfileGroupIds.size()) goto L28;
        pw.print("    User #");     // Catch: Throwable -> L8
        pw.print(this.mUserProfileGroupIds.keyAt(i4));     // Catch: Throwable -> L8
        pw.print(" -> profile #");     // Catch: Throwable -> L8
        pw.println(this.mUserProfileGroupIds.valueAt(i4));     // Catch: Throwable -> L8
        i4 = i4 + 1;     // Catch: Throwable -> L8
    L28:
        pw.println("  mCurrentProfileIds:" + Arrays.toString(this.mCurrentProfileIds));     // Catch: Throwable -> L8
        pw.println("  mCurrentUserId:" + this.mCurrentUserId);     // Catch: Throwable -> L8
        pw.println("  mTargetUserId:" + this.mTargetUserId);     // Catch: Throwable -> L8
        pw.println("  mLastActiveUsersForDelayedLocking:" + this.mLastActiveUsersForDelayedLocking);     // Catch: Throwable -> L8
        pw.println("  mDelayUserDataLocking:" + this.mDelayUserDataLocking);     // Catch: Throwable -> L8
        pw.println("  mAllowUserUnlocking:" + this.mAllowUserUnlocking);     // Catch: Throwable -> L8
        pw.println("  isStopUserOnSwitchEnabled():" + isStopUserOnSwitchEnabled());     // Catch: Throwable -> L8
        pw.println("  mStopUserOnSwitch:" + this.mStopUserOnSwitch);     // Catch: Throwable -> L8
        pw.println("  mMaxRunningUsers:" + this.mMaxRunningUsers);     // Catch: Throwable -> L8
        pw.println("  mBackgroundUserScheduledStopTimeSecs:" + this.mBackgroundUserScheduledStopTimeSecs);     // Catch: Throwable -> L8
        pw.println("  mUserSwitchUiEnabled:" + this.mUserSwitchUiEnabled);     // Catch: Throwable -> L8
        pw.println("  mInitialized:" + this.mInitialized);     // Catch: Throwable -> L8
        pw.println("  mIsBroadcastSentForSystemUserStarted:" + this.mIsBroadcastSentForSystemUserStarted);     // Catch: Throwable -> L8
        pw.println("  mIsBroadcastSentForSystemUserStarting:" + this.mIsBroadcastSentForSystemUserStarting);     // Catch: Throwable -> L8
        pw.println("  mSwitchingFromUserMessage:" + this.mSwitchingFromUserMessage);     // Catch: Throwable -> L8
        pw.println("  mSwitchingToUserMessage:" + this.mSwitchingToUserMessage);     // Catch: Throwable -> L8
        pw.println("  mLastUserUnlockingUptime: " + this.mLastUserUnlockingUptime);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        int r3 = 5000;
        switch(msg.what) {
            case 10: goto L28;
            case 20: goto L27;
            case 30: goto L26;
            case 40: goto L25;
            case 50: goto L24;
            case 60: goto L23;
            case 70: goto L22;
            case 80: goto L19;
            case 90: goto L18;
            case 100: goto L17;
            case 105: goto L12;
            case 110: goto L11;
            case 120: goto L10;
            case 130: goto L9;
            case 140: goto L8;
            case 150: goto L7;
            case 200: goto L6;
            case 1000: goto L5;
            default: goto L49;
        };
    L5:
        Pair<UserInfo, UserInfo> fromToUserPair = (Pair) msg.obj;
        logUserJourneyBegin(((UserInfo) fromToUserPair.second).id, 1);
        showUserSwitchDialog(fromToUserPair);
        return false;
    L6:
        this.mInjector.getUserJourneyLogger().finishAndClearIncompleteUserJourney(msg.arg1, msg.arg2);
        this.mHandler.removeMessages(200, msg.obj);
        return false;
    L7:
        processScheduledStopOfBackgroundUser((Integer) msg.obj);
        return false;
    L8:
        reportOnUserCompletedEvent((Integer) msg.obj);
        return false;
    L9:
        completeUserSwitch(msg.arg1, msg.arg2);
        return false;
    L10:
        logUserJourneyBegin(msg.arg1, 2);
        startUserInForeground(msg.arg1);
        return false;
    L11:
        dispatchLockedBootComplete(msg.arg1);
        return false;
    L12:
        this.mInjector.getSystemServiceManager().onUserUnlocked(msg.arg1);
        int r0 = msg.arg1;
        if (this.mCurrentUserId == msg.arg1) goto L16;
        r3 = 1000;
    L16:
        scheduleOnUserCompletedEvent(r0, 2, r3);
        this.mInjector.getUserJourneyLogger().logUserLifecycleEvent(msg.arg1, 6, 2);
        return false;
    L17:
        final int userId = msg.arg1;
        this.mInjector.getSystemServiceManager().onUserUnlocking(userId);
        FgThread.getHandler().post(new UserController$$ExternalSyntheticLambda20(this, userId));
        this.mInjector.getUserJourneyLogger().logUserLifecycleEvent(msg.arg1, 5, 2);
        this.mInjector.getUserJourneyLogger().logUserLifecycleEvent(msg.arg1, 6, 1);
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("finishUserUnlocked-" + userId);
        finishUserUnlocked((UserState) msg.obj);
        t.traceEnd();
        return false;
    L18:
        timeoutUserSwitchCallbacks(msg.arg1, msg.arg2);
        return false;
    L19:
        dispatchUserSwitchComplete(msg.arg1, msg.arg2);
        UserJourneyLogger.UserJourneySession session = this.mInjector.getUserJourneyLogger().logUserSwitchJourneyFinish(msg.arg1, getUserInfo(msg.arg2));
        if (session == null) goto L41;
        this.mHandler.removeMessages(200, session);
        return false;
    L41:
        return false;
    L22:
        dispatchForegroundProfileChanged(msg.arg1);
        return false;
    L23:
        this.mInjector.batteryStatsServiceNoteEvent(16392, Integer.toString(msg.arg2), msg.arg2);
        this.mInjector.batteryStatsServiceNoteEvent(32776, Integer.toString(msg.arg1), msg.arg1);
        this.mInjector.getSystemServiceManager().onUserSwitching(msg.arg2, msg.arg1);
        stopPreviousUserPackagesIfEnabled(msg.arg2, msg.arg1);
        scheduleOnUserCompletedEvent(msg.arg1, 4, 5000);
        return false;
    L24:
        this.mInjector.batteryStatsServiceNoteEvent(32775, Integer.toString(msg.arg1), msg.arg1);
        logUserJourneyBegin(msg.arg1, 3);
        this.mInjector.onUserStarting(msg.arg1);
        scheduleOnUserCompletedEvent(msg.arg1, 1, 5000);
        this.mInjector.getUserJourneyLogger().logUserJourneyFinish(-1, getUserInfo(msg.arg1), 3);
        return false;
    L25:
        startProfiles();
        return false;
    L26:
        timeoutUserSwitch((UserState) msg.obj, msg.arg1, msg.arg2);
        return false;
    L27:
        continueUserSwitch((UserState) msg.obj, msg.arg1, msg.arg2);
        return false;
    L28:
        dispatchUserSwitch((UserState) msg.obj, msg.arg1, msg.arg2);
        return false;
    L49:
        return false;
    }

    private /* synthetic */ void lambda$handleMessage$25(int userId) {
        this.mInjector.loadUserRecents(userId);
    }

    void scheduleOnUserCompletedEvent(int userId, int eventType, int delayMs) {
        if (eventType == 0) goto L11;
        SparseIntArray r0 = this.mCompletedEventTypes;
        monitor-enter(r0);
        this.mCompletedEventTypes.put(userId, this.mCompletedEventTypes.get(userId, 0) | eventType);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        Object msgObj = Integer.valueOf(userId);
        this.mHandler.removeEqualMessages(140, msgObj);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(140, msgObj), delayMs);
    }

    void reportOnUserCompletedEvent(Integer userId) {
        this.mHandler.removeEqualMessages(140, userId);
        SparseIntArray r0 = this.mCompletedEventTypes;
        monitor-enter(r0);
        int eventTypes = this.mCompletedEventTypes.get(userId.intValue(), 0);     // Catch: Throwable -> L27
        this.mCompletedEventTypes.delete(userId.intValue());     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        int eligibleEventTypes = 0;
        Object r2 = this.mLock;
        monitor-enter(r2);
        UserState uss = this.mStartedUsers.get(userId.intValue());     // Catch: Throwable -> L13
        if (uss != null) goto L11;
    L15:
        if (uss == null) goto L20;
        if (uss.state != 3) goto L20;
        eligibleEventTypes = eligibleEventTypes | 2;     // Catch: Throwable -> L13
    L20:
        if (userId.intValue() != this.mCurrentUserId) goto L22;
        eligibleEventTypes = eligibleEventTypes | 4;     // Catch: Throwable -> L13
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L13
        Slogf.i(TAG, "reportOnUserCompletedEvent(%d): stored=%s, eligible=%s", new Object[]{userId, Integer.toBinaryString(eventTypes), Integer.toBinaryString(eligibleEventTypes)});
        Injector r3 = this.mInjector;
        int r4 = userId.intValue();
        r3.systemServiceManagerOnUserCompletedEvent(r4, eventTypes & eligibleEventTypes);
        return;
    L11:
        if (uss.state == 5) goto L15;
        eligibleEventTypes = 0 | 1;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L27:
        th = move-exception;
        throw th;
    }

    private void logUserJourneyBegin(int targetId, int journey) {
        UserJourneyLogger.UserJourneySession oldSession = this.mInjector.getUserJourneyLogger().finishAndClearIncompleteUserJourney(targetId, journey);
        if (oldSession != null) goto L5;
    L8:
        UserJourneyLogger.UserJourneySession newSession = this.mInjector.getUserJourneyLogger().logUserJourneyBegin(targetId, journey);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200, targetId, journey, newSession), 90000);
        return;
    L5:
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L7;
        Slogf.d(TAG, "Starting a new journey: " + journey + " with session id: " + oldSession);
    L7:
        this.mHandler.removeMessages(200, oldSession);
        goto L8
    }

    BroadcastOptions getTemporaryAppAllowlistBroadcastOptions(int reasonCode) {
        ActivityManagerInternal amInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (amInternal == null) goto L5;
        long duration = amInternal.getBootTimeTempAllowListDuration();
        long duration2 = duration;
    L6:
        BroadcastOptions bOptions = BroadcastOptions.makeBasic();
        bOptions.setTemporaryAppAllowlist(duration2, 0, reasonCode, "");
        return bOptions;
    L5:
        duration2 = 10000;
        goto L6
    }

    private static int getUserSwitchTimeoutMs() {
        String userSwitchTimeoutMs = SystemProperties.get("debug.usercontroller.user_switch_timeout_ms");
        if (TextUtils.isEmpty(userSwitchTimeoutMs) == true) goto L11;
        return Integer.parseInt(userSwitchTimeoutMs);
    L7:
        return 3000;
    L11:
        return 3000;
    }

    private static void asyncTraceBegin(String msg, int cookie) {
        Slogf.d(TAG, "%s - asyncTraceBegin(%d)", new Object[]{msg, Integer.valueOf(cookie)});
        Trace.asyncTraceBegin(64, msg, cookie);
    }

    private static void asyncTraceEnd(String msg, int cookie) {
        Trace.asyncTraceEnd(64, msg, cookie);
        Slogf.d(TAG, "%s - asyncTraceEnd(%d)", new Object[]{msg, Integer.valueOf(cookie)});
    }

    public long getLastUserUnlockingUptime() {
        return this.mLastUserUnlockingUptime;
    }
}
