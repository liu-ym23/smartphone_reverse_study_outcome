package com.android.server.wm;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.BackgroundStartPrivileges;
import android.app.IBackgroundActivityLaunchCallback;
import android.app.compat.CompatChanges;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.DebugUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.widget.Toast;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.server.BaseZswSystemServiceFactory;
import com.android.server.UiThread;
import com.android.server.am.PendingIntentRecord;
import com.android.server.job.controllers.JobStatus;
import com.android.server.scene.SceneUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class BackgroundActivityStartController {
    public static final ActivityOptions ACTIVITY_OPTIONS_SYSTEM_DEFINED = null;
    private static final int ASM_GRACEPERIOD_MAX_REPEATS = 5;
    private static final long ASM_GRACEPERIOD_TIMEOUT_MS = 3000;
    static final String AUTO_OPT_IN_CALL_FOR_RESULT = "callForResult";
    static final String AUTO_OPT_IN_COMPAT = "compatibility";
    static final String AUTO_OPT_IN_NOT_PENDING_INTENT = "notPendingIntent";
    static final String AUTO_OPT_IN_SAME_UID = "sameUid";
    static final int BAL_ALLOW_ALLOWLISTED_COMPONENT = 3;
    static final int BAL_ALLOW_ALLOWLISTED_UID = 2;
    static final int BAL_ALLOW_BOUND_BY_FOREGROUND = 13;
    static final int BAL_ALLOW_DEFAULT = 1;
    static final int BAL_ALLOW_FOREGROUND = 9;
    static final int BAL_ALLOW_GRACE_PERIOD = 8;
    static final int BAL_ALLOW_NON_APP_VISIBLE_WINDOW = 11;
    static final int BAL_ALLOW_PENDING_INTENT = 5;
    static final int BAL_ALLOW_PERMISSION = 6;
    static final int BAL_ALLOW_SAW_PERMISSION = 7;
    static final int BAL_ALLOW_SDK_SANDBOX = 10;
    static final int BAL_ALLOW_TOKEN = 12;
    static final int BAL_ALLOW_VISIBLE_WINDOW = 4;
    static final int BAL_BLOCK = 127;
    private static final BackgroundLaunchProcessController.BalCheckConfiguration BAL_CHECK_BACKGROUND = null;
    private static final BackgroundLaunchProcessController.BalCheckConfiguration BAL_CHECK_FOREGROUND = null;
    private static final long DEFAULT_RESCIND_BAL_PRIVILEGES_FROM_PENDING_INTENT_CREATOR = 296478951;
    private static final int NO_PROCESS_UID = -1;
    private static final String TAG = "ActivityTaskManager";
    private final BalExemptionCheck mCheckCallerHasBackgroundPermission;
    private final BalExemptionCheck mCheckCallerHasBgStartAppOp;
    private final BalExemptionCheck mCheckCallerHasSawPermission;
    private final BalExemptionCheck mCheckCallerIsAllowlistedComponent;
    private final BalExemptionCheck mCheckCallerIsAllowlistedUid;
    private final BalExemptionCheck mCheckCallerNonAppVisible;
    private final BalExemptionCheck mCheckCallerProcessAllowsBackground;
    private final BalExemptionCheck mCheckCallerProcessAllowsForeground;
    private final BalExemptionCheck mCheckCallerVisible;
    private final BalExemptionCheck mCheckRealCallerAllowlistedComponent;
    private final BalExemptionCheck mCheckRealCallerAllowlistedUid;
    private final BalExemptionCheck mCheckRealCallerBalPermission;
    private final BalExemptionCheck mCheckRealCallerNonAppVisible;
    private final BalExemptionCheck mCheckRealCallerProcessAllowsBalBackground;
    private final BalExemptionCheck mCheckRealCallerProcessAllowsBalForeground;
    private final BalExemptionCheck mCheckRealCallerSawPermission;
    private final BalExemptionCheck mCheckRealCallerVisible;
    private final IExtBackgroundActivityStartController mExt;
    private final ActivityTaskManagerService mService;
    private final SparseArray<ArrayMap<IBinder, IBackgroundActivityLaunchCallback>> mStrictModeBalCallbacks;
    private final ActivityTaskSupervisor mSupervisor;
    private final HashMap<Integer, FinishedActivityEntry> mTaskIdToFinishedActivity;
    private FinishedActivityEntry mTopFinishedActivity;
    IZswBackgroundActivityStartController mZswExt;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BalCode {
    }

    interface BalExemptionCheck {
        BalVerdict evaluate(BalState r1);
    }

    class BalState {
        private final boolean mAllowBalExemptionForSystemProcess;
        private final int mAppSwitchState;
        private final boolean mAutoOptInCaller;
        final String mAutoOptInReason;
        final BackgroundStartPrivileges mBalAllowedByPiCreator;
        final BackgroundStartPrivileges mBalAllowedByPiSender;
        private final WindowProcessController mCallerApp;
        private final String mCallingPackage;
        private final int mCallingPid;
        private final int mCallingUid;
        private final boolean mCallingUidHasNonAppVisibleWindow;
        private final boolean mCallingUidHasVisibleActivity;
        private final boolean mCallingUidHasVisibleNotPinnedActivity;
        private final int mCallingUidProcState;
        private final ActivityOptions mCheckedOptions;
        private final Intent mIntent;
        private final boolean mIsCallForResult;
        private final boolean mIsCallingUidPersistentSystemProcess;
        private final boolean mIsRealCallingUidPersistentSystemProcess;
        private final PendingIntentRecord mOriginatingPendingIntent;
        private final WindowProcessController mRealCallerApp;
        private final String mRealCallingPackage;
        private final int mRealCallingPid;
        private final int mRealCallingUid;
        private final boolean mRealCallingUidHasNonAppVisibleWindow;
        private final boolean mRealCallingUidHasVisibleActivity;
        private final boolean mRealCallingUidHasVisibleNotPinnedActivity;
        private final int mRealCallingUidProcState;
        private BalVerdict mResultForCaller;
        private BalVerdict mResultForRealCaller;
        final /* synthetic */ BackgroundActivityStartController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmAllowBalExemptionForSystemProcess, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9806$$Nest$fgetmAllowBalExemptionForSystemProcess(BalState r0) {
            return r0.mAllowBalExemptionForSystemProcess;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAppSwitchState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9807$$Nest$fgetmAppSwitchState(BalState r0) {
            return r0.mAppSwitchState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallerApp, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowProcessController m9808$$Nest$fgetmCallerApp(BalState r0) {
            return r0.mCallerApp;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallingPackage, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9809$$Nest$fgetmCallingPackage(BalState r0) {
            return r0.mCallingPackage;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallingPid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9810$$Nest$fgetmCallingPid(BalState r0) {
            return r0.mCallingPid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallingUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9811$$Nest$fgetmCallingUid(BalState r0) {
            return r0.mCallingUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallingUidHasNonAppVisibleWindow, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9812$$Nest$fgetmCallingUidHasNonAppVisibleWindow(BalState r0) {
            return r0.mCallingUidHasNonAppVisibleWindow;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallingUidHasVisibleActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9813$$Nest$fgetmCallingUidHasVisibleActivity(BalState r0) {
            return r0.mCallingUidHasVisibleActivity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallingUidHasVisibleNotPinnedActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9814$$Nest$fgetmCallingUidHasVisibleNotPinnedActivity(BalState r0) {
            return r0.mCallingUidHasVisibleNotPinnedActivity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallingUidProcState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9815$$Nest$fgetmCallingUidProcState(BalState r0) {
            return r0.mCallingUidProcState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCheckedOptions, reason: not valid java name */
        static /* bridge */ /* synthetic */ ActivityOptions m9816$$Nest$fgetmCheckedOptions(BalState r0) {
            return r0.mCheckedOptions;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIntent, reason: not valid java name */
        static /* bridge */ /* synthetic */ Intent m9817$$Nest$fgetmIntent(BalState r0) {
            return r0.mIntent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsCallingUidPersistentSystemProcess, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9818$$Nest$fgetmIsCallingUidPersistentSystemProcess(BalState r0) {
            return r0.mIsCallingUidPersistentSystemProcess;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsRealCallingUidPersistentSystemProcess, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9819$$Nest$fgetmIsRealCallingUidPersistentSystemProcess(BalState r0) {
            return r0.mIsRealCallingUidPersistentSystemProcess;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOriginatingPendingIntent, reason: not valid java name */
        static /* bridge */ /* synthetic */ PendingIntentRecord m9820$$Nest$fgetmOriginatingPendingIntent(BalState r0) {
            return r0.mOriginatingPendingIntent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRealCallerApp, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowProcessController m9821$$Nest$fgetmRealCallerApp(BalState r0) {
            return r0.mRealCallerApp;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRealCallingPackage, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9822$$Nest$fgetmRealCallingPackage(BalState r0) {
            return r0.mRealCallingPackage;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRealCallingPid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9823$$Nest$fgetmRealCallingPid(BalState r0) {
            return r0.mRealCallingPid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRealCallingUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9824$$Nest$fgetmRealCallingUid(BalState r0) {
            return r0.mRealCallingUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRealCallingUidHasNonAppVisibleWindow, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9825$$Nest$fgetmRealCallingUidHasNonAppVisibleWindow(BalState r0) {
            return r0.mRealCallingUidHasNonAppVisibleWindow;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRealCallingUidHasVisibleActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9826$$Nest$fgetmRealCallingUidHasVisibleActivity(BalState r0) {
            return r0.mRealCallingUidHasVisibleActivity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRealCallingUidHasVisibleNotPinnedActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9827$$Nest$fgetmRealCallingUidHasVisibleNotPinnedActivity(BalState r0) {
            return r0.mRealCallingUidHasVisibleNotPinnedActivity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRealCallingUidProcState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9828$$Nest$fgetmRealCallingUidProcState(BalState r0) {
            return r0.mRealCallingUidProcState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmResultForCaller, reason: not valid java name */
        static /* bridge */ /* synthetic */ BalVerdict m9829$$Nest$fgetmResultForCaller(BalState r0) {
            return r0.mResultForCaller;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmResultForRealCaller, reason: not valid java name */
        static /* bridge */ /* synthetic */ BalVerdict m9830$$Nest$fgetmResultForRealCaller(BalState r0) {
            return r0.mResultForRealCaller;
        }

        /* JADX INFO: renamed from: -$$Nest$mcallerIsRealCaller, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9831$$Nest$mcallerIsRealCaller(BalState r0) {
            return r0.callerIsRealCaller();
        }

        /* JADX INFO: renamed from: -$$Nest$mhasRealCaller, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9832$$Nest$mhasRealCaller(BalState r0) {
            return r0.hasRealCaller();
        }

        BalState(BackgroundActivityStartController this$0, int callingUid, int callingPid, String callingPackage, int realCallingUid, int realCallingPid, WindowProcessController callerApp, PendingIntentRecord originatingPendingIntent, boolean allowBalExemptionForSystemProcess, ActivityRecord resultRecord, Intent intent, ActivityOptions checkedOptions) {
            this.this$0 = this$0;
            this.mCallingPackage = callingPackage;
            this.mCallingUid = callingUid;
            this.mCallingPid = callingPid;
            this.mRealCallingUid = realCallingUid;
            this.mRealCallingPid = realCallingPid;
            this.mCallerApp = callerApp;
            this.mAllowBalExemptionForSystemProcess = allowBalExemptionForSystemProcess;
            this.mOriginatingPendingIntent = originatingPendingIntent;
            this.mIntent = intent;
            this.mRealCallingPackage = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).getPackageNameIfUnique(realCallingUid, realCallingPid);
            if (resultRecord == null) goto L5;
            boolean r14 = true;
        L6:
            this.mIsCallForResult = r14;
            this.mCheckedOptions = checkedOptions;
            int callerBackgroundActivityStartMode = checkedOptions.getPendingIntentCreatorBackgroundActivityStartMode();
            int realCallerBackgroundActivityStartMode = checkedOptions.getPendingIntentBackgroundActivityStartMode();
            if (originatingPendingIntent != null) goto L10;
            this.mAutoOptInReason = BackgroundActivityStartController.AUTO_OPT_IN_NOT_PENDING_INTENT;
            this.mAutoOptInCaller = true;
        L20:
            if (this.mAutoOptInCaller == false) goto L25;
            if (callerBackgroundActivityStartMode != 2) goto L23;
            BackgroundStartPrivileges r12 = BackgroundStartPrivileges.NONE;
        L24:
            this.mBalAllowedByPiCreator = r12;
        L27:
            if (this.mAutoOptInReason == null) goto L32;
            if (realCallerBackgroundActivityStartMode != 2) goto L30;
            BackgroundStartPrivileges r13 = BackgroundStartPrivileges.NONE;
        L31:
            this.mBalAllowedByPiSender = r13;
        L33:
            this.mAppSwitchState = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).getBalAppSwitchesState();
            this.mCallingUidProcState = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).mActiveUids.getUidState(callingUid);
            if (this.mCallingUidProcState > 1) goto L36;
            boolean r15 = true;
        L37:
            this.mIsCallingUidPersistentSystemProcess = r15;
            this.mCallingUidHasVisibleActivity = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).mVisibleActivityProcessTracker.hasVisibleActivity(callingUid);
            this.mCallingUidHasVisibleNotPinnedActivity = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).mVisibleActivityProcessTracker.hasVisibleNotPinnedActivity(callingUid);
            this.mCallingUidHasNonAppVisibleWindow = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).mActiveUids.hasNonAppVisibleWindow(callingUid);
            if (realCallingUid != (-1)) goto L41;
            this.mRealCallingUidProcState = 20;
            this.mRealCallingUidHasVisibleActivity = false;
            this.mRealCallingUidHasNonAppVisibleWindow = false;
            this.mRealCallingUidHasVisibleNotPinnedActivity = false;
            this.mRealCallerApp = null;
            this.mIsRealCallingUidPersistentSystemProcess = false;
            return;
        L41:
            if (callingUid != realCallingUid) goto L47;
            this.mRealCallingUidProcState = this.mCallingUidProcState;
            this.mRealCallingUidHasVisibleActivity = this.mCallingUidHasVisibleActivity;
            this.mRealCallingUidHasVisibleNotPinnedActivity = this.mCallingUidHasVisibleNotPinnedActivity;
            this.mRealCallingUidHasNonAppVisibleWindow = this.mCallingUidHasNonAppVisibleWindow;
            if (callerApp != null) goto L45;
            WindowProcessController r16 = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).getProcessController(realCallingPid, realCallingUid);
        L46:
            this.mRealCallerApp = r16;
            this.mIsRealCallingUidPersistentSystemProcess = this.mIsCallingUidPersistentSystemProcess;
            return;
        L45:
            r16 = callerApp;
            goto L46
        L47:
            this.mRealCallingUidProcState = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).mActiveUids.getUidState(realCallingUid);
            this.mRealCallingUidHasVisibleActivity = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).mVisibleActivityProcessTracker.hasVisibleActivity(realCallingUid);
            this.mRealCallingUidHasVisibleNotPinnedActivity = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).mVisibleActivityProcessTracker.hasVisibleNotPinnedActivity(realCallingUid);
            this.mRealCallingUidHasNonAppVisibleWindow = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).mActiveUids.hasNonAppVisibleWindow(realCallingUid);
            this.mRealCallerApp = BackgroundActivityStartController.m9803$$Nest$mgetService(this$0).getProcessController(realCallingPid, realCallingUid);
            if (this.mRealCallingUidProcState > 1) goto L50;
            boolean r17 = true;
        L51:
            this.mIsRealCallingUidPersistentSystemProcess = r17;
            return;
        L50:
            r17 = false;
            goto L51
        L36:
            r15 = false;
            goto L37
        L30:
            r13 = BackgroundStartPrivileges.ALLOW_BAL;
            goto L31
        L32:
            this.mBalAllowedByPiSender = PendingIntentRecord.getBackgroundStartPrivilegesAllowedByCaller(checkedOptions, realCallingUid, this.mRealCallingPackage);
            goto L33
        L23:
            r12 = BackgroundStartPrivileges.ALLOW_BAL;
            goto L24
        L25:
            this.mBalAllowedByPiCreator = getBackgroundStartPrivilegesAllowedByCreator(callingUid, callingPackage, checkedOptions);
            goto L27
        L10:
            if (this.mIsCallForResult == false) goto L13;
            this.mAutoOptInReason = BackgroundActivityStartController.AUTO_OPT_IN_CALL_FOR_RESULT;
            this.mAutoOptInCaller = false;
            goto L20
        L13:
            if (callingUid != realCallingUid) goto L16;
            this.mAutoOptInReason = BackgroundActivityStartController.AUTO_OPT_IN_SAME_UID;
            this.mAutoOptInCaller = false;
            goto L20
        L16:
            if (realCallerBackgroundActivityStartMode != (-1)) goto L18;
            this.mAutoOptInReason = BackgroundActivityStartController.AUTO_OPT_IN_COMPAT;
            this.mAutoOptInCaller = false;
            goto L20
        L18:
            this.mAutoOptInReason = null;
            this.mAutoOptInCaller = false;
            goto L20
        L5:
            r14 = false;
            goto L6
        }

        private BackgroundStartPrivileges getBackgroundStartPrivilegesAllowedByCreator(int callingUid, String callingPackage, ActivityOptions checkedOptions) {
            switch(checkedOptions.getPendingIntentCreatorBackgroundActivityStartMode()) {
                case 0: goto L10;
                case 1: goto L9;
                case 2: goto L7;
                case 3: goto L9;
                case 4: goto L9;
                default: goto L5;
            };
        L10:
            if (callingUid == 0) goto L27;
            if (callingUid == 1000) goto L27;
            if (callingPackage == null) goto L21;
            boolean changeEnabled = CompatChanges.isChangeEnabled(BackgroundActivityStartController.DEFAULT_RESCIND_BAL_PRIVILEGES_FROM_PENDING_INTENT_CREATOR, callingPackage, UserHandle.getUserHandleForUid(callingUid));
            if (changeEnabled == false) goto L20;
            return BackgroundStartPrivileges.NONE;
        L20:
            return BackgroundStartPrivileges.ALLOW_BAL;
        L21:
            boolean changeEnabled2 = CompatChanges.isChangeEnabled(BackgroundActivityStartController.DEFAULT_RESCIND_BAL_PRIVILEGES_FROM_PENDING_INTENT_CREATOR, callingUid);
            if (changeEnabled2 == false) goto L25;
            return BackgroundStartPrivileges.NONE;
        L25:
            return BackgroundStartPrivileges.ALLOW_BAL;
        L27:
            return BackgroundStartPrivileges.NONE;
        L5:
            throw new IllegalStateException("unsupported BackgroundActivityStartMode: " + checkedOptions.getPendingIntentCreatorBackgroundActivityStartMode());
        L7:
            return BackgroundStartPrivileges.NONE;
        L9:
            return BackgroundStartPrivileges.ALLOW_BAL;
        }

        private String getDebugPackageName(String packageName, int uid) {
            if (packageName == null) goto L4;
            return packageName;
        L4:
            if (uid != 0) goto L7;
            return "root[debugOnly]";
        L7:
            String name = BackgroundActivityStartController.m9803$$Nest$mgetService(this.this$0).getPackageManagerInternalLocked().getNameForUid(uid);
            if (name != null) goto L11;
            name = "uid=" + uid;
        L11:
            return name + "[debugOnly]";
        }

        private boolean hasRealCaller() {
            if (this.mRealCallingUid == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isPendingIntent() {
            if (this.mOriginatingPendingIntent != null) goto L5;
        L7:
            return false;
        L5:
            if (hasRealCaller() == false) goto L7;
            return true;
        }

        private boolean callerIsRealCaller() {
            if (this.mCallingUid != this.mRealCallingUid) goto L5;
            return true;
        L5:
            return false;
        }

        public void setResultForCaller(BalVerdict resultForCaller) {
            if (this.mResultForCaller != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "mResultForCaller can only be set once");
            this.mResultForCaller = resultForCaller;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void setResultForRealCaller(BalVerdict resultForRealCaller) {
            if (this.mResultForRealCaller != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "mResultForRealCaller can only be set once");
            this.mResultForRealCaller = resultForRealCaller;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public boolean callerExplicitOptInOrAutoOptIn() {
            if (this.mAutoOptInCaller == false) goto L7;
            return !callerExplicitOptOut();
        L7:
            if (this.mCheckedOptions.getPendingIntentCreatorBackgroundActivityStartMode() != 2) goto L9;
        L11:
            return false;
        L9:
            if (this.mCheckedOptions.getPendingIntentCreatorBackgroundActivityStartMode() == 0) goto L11;
            return true;
        }

        public boolean realCallerExplicitOptInOrAutoOptIn() {
            if (this.mAutoOptInReason == null) goto L7;
            return !realCallerExplicitOptOut();
        L7:
            if (this.mCheckedOptions.getPendingIntentBackgroundActivityStartMode() != 2) goto L9;
        L11:
            return false;
        L9:
            if (this.mCheckedOptions.getPendingIntentBackgroundActivityStartMode() == 0) goto L11;
            return true;
        }

        public boolean callerExplicitOptOut() {
            if (this.mCheckedOptions.getPendingIntentCreatorBackgroundActivityStartMode() != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean realCallerExplicitOptOut() {
            if (this.mCheckedOptions.getPendingIntentBackgroundActivityStartMode() != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean callerExplicitOptInOrOut() {
            if (this.mCheckedOptions.getPendingIntentCreatorBackgroundActivityStartMode() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean realCallerExplicitOptInOrOut() {
            if (this.mCheckedOptions.getPendingIntentBackgroundActivityStartMode() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(2048);
            sb.append("[callingPackage: ");
            sb.append(getDebugPackageName(this.mCallingPackage, this.mCallingUid));
            sb.append("; callingPackageTargetSdk: ");
            sb.append(BackgroundActivityStartController.m9804$$Nest$mgetTargetSdk(this.this$0, this.mCallingPackage));
            sb.append("; callingUid: ");
            sb.append(this.mCallingUid);
            sb.append("; callingPid: ");
            sb.append(this.mCallingPid);
            sb.append("; appSwitchState: ");
            sb.append(this.mAppSwitchState);
            sb.append("; callingUidHasVisibleActivity: ");
            sb.append(this.mCallingUidHasVisibleActivity);
            sb.append("; callingUidHasVisibleNotPinnedActivity: ");
            sb.append(this.mCallingUidHasVisibleNotPinnedActivity);
            sb.append("; callingUidHasNonAppVisibleWindow: ");
            sb.append(this.mCallingUidHasNonAppVisibleWindow);
            sb.append("; callingUidProcState: ");
            sb.append(DebugUtils.valueToString(ActivityManager.class, "PROCESS_STATE_", this.mCallingUidProcState));
            sb.append("; isCallingUidPersistentSystemProcess: ");
            sb.append(this.mIsCallingUidPersistentSystemProcess);
            sb.append("; allowBalExemptionForSystemProcess: ");
            sb.append(this.mAllowBalExemptionForSystemProcess);
            sb.append("; intent: ");
            sb.append(this.mIntent);
            sb.append("; callerApp: ");
            sb.append(this.mCallerApp);
            if (this.mCallerApp == null) goto L5;
            sb.append("; inVisibleTask: ");
            sb.append(this.mCallerApp.hasActivityInVisibleTask());
        L5:
            sb.append("; balAllowedByPiCreator: ");
            sb.append(this.mBalAllowedByPiCreator);
            if (this.mResultForCaller == null) goto L8;
            sb.append("; resultIfPiCreatorAllowsBal: ");
            sb.append(BackgroundActivityStartController.balCodeToString(BalVerdict.m9834$$Nest$fgetmCode(this.mResultForCaller)));
        L8:
            sb.append("; callerStartMode: ");
            sb.append(BackgroundActivityStartController.balStartModeToString(this.mCheckedOptions.getPendingIntentCreatorBackgroundActivityStartMode()));
            sb.append("; hasRealCaller: ");
            sb.append(hasRealCaller());
            sb.append("; isCallForResult: ");
            sb.append(this.mIsCallForResult);
            sb.append("; isPendingIntent: ");
            sb.append(isPendingIntent());
            sb.append("; autoOptInReason: ");
            sb.append(this.mAutoOptInReason);
            if (hasRealCaller() == false) goto L17;
            sb.append("; realCallingPackage: ");
            sb.append(getDebugPackageName(this.mRealCallingPackage, this.mRealCallingUid));
            sb.append("; realCallingPackageTargetSdk: ");
            sb.append(BackgroundActivityStartController.m9804$$Nest$mgetTargetSdk(this.this$0, this.mRealCallingPackage));
            sb.append("; realCallingUid: ");
            sb.append(this.mRealCallingUid);
            sb.append("; realCallingPid: ");
            sb.append(this.mRealCallingPid);
            sb.append("; realCallingUidHasVisibleActivity: ");
            sb.append(this.mRealCallingUidHasVisibleActivity);
            sb.append("; realCallingUidHasVisibleNotPinnedActivity: ");
            sb.append(this.mRealCallingUidHasVisibleNotPinnedActivity);
            sb.append("; realCallingUidHasNonAppVisibleWindow: ");
            sb.append(this.mRealCallingUidHasNonAppVisibleWindow);
            sb.append("; realCallingUidProcState: ");
            sb.append(DebugUtils.valueToString(ActivityManager.class, "PROCESS_STATE_", this.mRealCallingUidProcState));
            sb.append("; isRealCallingUidPersistentSystemProcess: ");
            sb.append(this.mIsRealCallingUidPersistentSystemProcess);
            sb.append("; originatingPendingIntent: ");
            sb.append(this.mOriginatingPendingIntent);
            sb.append("; realCallerApp: ");
            sb.append(this.mRealCallerApp);
            if (this.mRealCallerApp == null) goto L13;
            sb.append("; realInVisibleTask: ");
            sb.append(this.mRealCallerApp.hasActivityInVisibleTask());
        L13:
            sb.append("; balAllowedByPiSender: ");
            sb.append(this.mBalAllowedByPiSender);
            if (this.mResultForRealCaller == null) goto L16;
            sb.append("; resultIfPiSenderAllowsBal: ");
            sb.append(BackgroundActivityStartController.balCodeToString(BalVerdict.m9834$$Nest$fgetmCode(this.mResultForRealCaller)));
        L16:
            sb.append("; realCallerStartMode: ");
            sb.append(BackgroundActivityStartController.balStartModeToString(this.mCheckedOptions.getPendingIntentBackgroundActivityStartMode()));
        L17:
            sb.append("; balRequireOptInByPendingIntentCreator: ");
            sb.append(true);
            sb.append("; balDontBringExistingBackgroundTaskStackToFg: ");
            sb.append(true);
            sb.append("]");
            return sb.toString();
        }
    }

    static class BalVerdict {
        static final BalVerdict ALLOW_BY_DEFAULT = null;
        static final BalVerdict ALLOW_PRIVILEGED = null;
        static final BalVerdict BLOCK = null;
        private boolean mBasedOnRealCaller;
        private final int mCode;
        private final String mMessage;
        private boolean mOnlyCreatorAllows;
        private String mProcessInfo;

        /* JADX INFO: renamed from: -$$Nest$fgetmBasedOnRealCaller, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9833$$Nest$fgetmBasedOnRealCaller(BalVerdict r0) {
            return r0.mBasedOnRealCaller;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCode, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9834$$Nest$fgetmCode(BalVerdict r0) {
            return r0.mCode;
        }

        static {
            BLOCK = new BalVerdict(127, "Blocked");
            ALLOW_BY_DEFAULT = new BalVerdict(1, "Default");
            ALLOW_PRIVILEGED = new BalVerdict(2, "PRIVILEGED");
        }

        BalVerdict(int balCode, String message) {
            this.mCode = balCode;
            this.mMessage = message;
        }

        public BalVerdict withProcessInfo(String msg, WindowProcessController process) {
            if (this != BLOCK) goto L5;
        L11:
            return this;
        L5:
            if (this == ALLOW_BY_DEFAULT) goto L11;
            if (this == ALLOW_PRIVILEGED) goto L11;
            this.mProcessInfo = msg + " (uid=" + process.mUid + ",pid=" + process.getPid() + ")";
            return this;
        }

        boolean blocks() {
            if (this.mCode != 127) goto L5;
            return true;
        L5:
            return false;
        }

        boolean allows() {
            return !blocks();
        }

        void setOnlyCreatorAllows(boolean onlyCreatorAllows) {
            if (this != BLOCK) goto L5;
            return;
        L5:
            this.mOnlyCreatorAllows = onlyCreatorAllows;
        }

        boolean onlyCreatorAllows() {
            return this.mOnlyCreatorAllows;
        }

        BalVerdict setBasedOnRealCaller() {
            if (this != BLOCK) goto L5;
            return this;
        L5:
            this.mBasedOnRealCaller = true;
            return this;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(BackgroundActivityStartController.balCodeToString(this.mCode));
            if (this == BLOCK) goto L17;
            if (this.mOnlyCreatorAllows == false) goto L8;
            builder.append(" [onlyCaller]");
        L11:
            if (ActivityTaskManagerDebugConfig.DEBUG_ACTIVITY_STARTS == false) goto L17;
            builder.append(" (");
            builder.append(this.mMessage);
            if (this.mProcessInfo == null) goto L15;
            builder.append(" ");
            builder.append(this.mProcessInfo);
        L15:
            builder.append(")");
            goto L17
        L8:
            if (this.mBasedOnRealCaller == false) goto L11;
            builder.append(" [realCaller]");
        L17:
            return builder.toString();
        }

        public int getRawCode() {
            return this.mCode;
        }

        public int getCode() {
            if (this.mBasedOnRealCaller == false) goto L9;
            if (this.mCode == 127) goto L9;
            return 5;
        L9:
            return this.mCode;
        }
    }

    private static class BlockActivityStart {
        private ActivityRecord mActivityOptedIn;
        private boolean mTopActivityMatchesSource;
        private boolean mTopActivityOptedIn;

        /* JADX INFO: renamed from: -$$Nest$fgetmActivityOptedIn, reason: not valid java name */
        static /* bridge */ /* synthetic */ ActivityRecord m9835$$Nest$fgetmActivityOptedIn(BlockActivityStart r0) {
            return r0.mActivityOptedIn;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTopActivityMatchesSource, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9836$$Nest$fgetmTopActivityMatchesSource(BlockActivityStart r0) {
            return r0.mTopActivityMatchesSource;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTopActivityOptedIn, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9837$$Nest$fgetmTopActivityOptedIn(BlockActivityStart r0) {
            return r0.mTopActivityOptedIn;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmTopActivityMatchesSource, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9838$$Nest$fputmTopActivityMatchesSource(BlockActivityStart r0, boolean r1) {
            r0.mTopActivityMatchesSource = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmTopActivityOptedIn, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9839$$Nest$fputmTopActivityOptedIn(BlockActivityStart r0, boolean r1) {
            r0.mTopActivityOptedIn = r1;
        }

        /* synthetic */ BlockActivityStart(BackgroundActivityStartControllerIA r1) {
            this();
        }

        private BlockActivityStart() {
        }

        BlockActivityStart optedIn(ActivityRecord activity) {
            this.mTopActivityOptedIn = true;
            if (this.mActivityOptedIn != null) goto L5;
            this.mActivityOptedIn = activity;
        L5:
            return this;
        }

        BlockActivityStart matchesSource() {
            this.mTopActivityMatchesSource = true;
            return this;
        }
    }

    private class FinishedActivityEntry {
        String mDebugInfo;
        int mLaunchCount;
        int mTaskId;
        int mUid;
        final /* synthetic */ BackgroundActivityStartController this$0;

        public static /* synthetic */ void $r8$lambda$ynGgZ1HotwBRwYgybi9MzOri2cg(FinishedActivityEntry r0, int r1) {
            r0.lambda$new$0(r1);
        }

        FinishedActivityEntry(BackgroundActivityStartController r6, ActivityRecord ar) {
            this.this$0 = r6;
            FinishedActivityEntry entry = (FinishedActivityEntry) BackgroundActivityStartController.m9800$$Nest$fgetmTaskIdToFinishedActivity(r6).get(Integer.valueOf(ar.getTask().mTaskId));
            final int taskId = ar.getTask().mTaskId;
            this.mUid = ar.getUid();
            this.mTaskId = taskId;
            int r2 = 1;
            if (entry != null) goto L5;
        L8:
            this.mLaunchCount = r2;
            this.mDebugInfo = BackgroundActivityStartController.m9805$$Nest$smgetDebugStringForActivityRecord(ar);
            BackgroundActivityStartController.m9803$$Nest$mgetService(r6).mH.postDelayed(new BackgroundActivityStartController$FinishedActivityEntry$$ExternalSyntheticLambda0(this, taskId), 3000);
            return;
        L5:
            if (ar.isUid(entry.mUid) == false) goto L8;
            r2 = 1 + entry.mLaunchCount;
            goto L8
        }

        private /* synthetic */ void lambda$new$0(int taskId) {
            WindowManagerGlobalLock r0 = BackgroundActivityStartController.m9803$$Nest$mgetService(this.this$0).mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (BackgroundActivityStartController.m9800$$Nest$fgetmTaskIdToFinishedActivity(this.this$0).get(Integer.valueOf(taskId)) != this) goto L10;
            BackgroundActivityStartController.m9800$$Nest$fgetmTaskIdToFinishedActivity(this.this$0).remove(Integer.valueOf(taskId));     // Catch: Throwable -> L7
        L10:
            if (BackgroundActivityStartController.m9801$$Nest$fgetmTopFinishedActivity(this.this$0) != this) goto L12;
            BackgroundActivityStartController.m9802$$Nest$fputmTopFinishedActivity(this.this$0, null);     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
        }
    }

    public static /* synthetic */ boolean $r8$lambda$0txmP7nEF0LrgLPG4AUjroyjecg(int r0, int r1, int r2, ActivityRecord r3) {
        return lambda$clearTopIfNeeded$20(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$4XphJH50pbXG7XA_vyhxMUD02PI(ActivityRecord r0) {
        return lambda$checkActivityAllowedToClearTask$21(r0);
    }

    public static /* synthetic */ void $r8$lambda$6pV9vHbj0k0gwICnR9quSaNvtrY(StringJoiner r0, Task r1) {
        lambda$getDebugInfoForActivitySecurity$29(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$9mD1MFsGNRxyY3OUy6EnJx1kz5o(BackgroundActivityStartController r0, Predicate r1, BlockActivityStart[] r2, int r3, TaskFragment r4) {
        r0.lambda$checkTopActivityForAsm$24(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$BSn_PZ1Gf7aRLCU8NHv6pxgvanA(BackgroundActivityStartController r0, int r1, IBinder r2) {
        r0.lambda$addStrictModeCallback$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$DhQDAQyQgw-XKj1Nh-wjYh-21vo, reason: not valid java name */
    public static /* synthetic */ BalVerdict m9792$r8$lambda$DhQDAQyQgwXKj1NhwjYh21vo(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$1(r1);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$F6iaE2jcl2tpq3MAx3HO6Nibx_Q(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$FJFLqdYoRSV-0g5di0PIFpH82xo, reason: not valid java name */
    public static /* synthetic */ BalVerdict m9793$r8$lambda$FJFLqdYoRSV0g5di0PIFpH82xo(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$5(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$FMo7NrtbDsWPz89uQRgB85HQ8l4(int r0, ActivityRecord r1) {
        return lambda$checkTopActivityForAsm$22(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$KCH4emsy9MoEKCDjO_eBL_oxwTU(ActivityRecord r0, ActivityRecord r1) {
        return lambda$checkTopActivityForAsm$23(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Oj55gCcC-ZmBa1qdBpRJyeEgmWc, reason: not valid java name */
    public static /* synthetic */ void m9794$r8$lambda$Oj55gCcCZmBa1qdBpRJyeEgmWc(StringJoiner r0, Function r1, ActivityRecord r2) {
        lambda$getDebugInfoForActivitySecurity$27(r0, r1, r2);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$R6w0O4KPPVd4sTu9TdTn2Gx0voo(BalState r0) {
        return lambda$new$16(r0);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$RlbspcKMeFIefBYHCbRzPx4zavI(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$9(r1);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$W1djLwQGgGetfpNERa3xUsGgpxA(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$10(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$YEACyGi1QEkWj7IoZ-Dk1Us-EAU, reason: not valid java name */
    public static /* synthetic */ BalVerdict m9795$r8$lambda$YEACyGi1QEkWj7IoZDk1UsEAU(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$6(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$YcD5uswiD7bReEci-IdwP331IZY, reason: not valid java name */
    public static /* synthetic */ BalVerdict m9796$r8$lambda$YcD5uswiD7bReEciIdwP331IZY(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$13(r1);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$YmsGUOiGV30tgTdcBAXkvH1Rc5I(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$12(r1);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$agwEK9qwrzNc6cV3naUd52zksR0(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ctWjo5OoBSE3eJa3g-llQ3bC1hc, reason: not valid java name */
    public static /* synthetic */ BalVerdict m9797$r8$lambda$ctWjo5OoBSE3eJa3gllQ3bC1hc(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$14(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dI82Goc0QzXDA80mVbwB0t-0c7w, reason: not valid java name */
    public static /* synthetic */ boolean m9798$r8$lambda$dI82Goc0QzXDA80mVbwB0t0c7w(ActivityRecord r0) {
        return lambda$logAsmFailureAndCheckFeatureEnabled$18(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$dfoBJHTz7ndC7TW6_aien8-ODpM, reason: not valid java name */
    public static /* synthetic */ BalVerdict m9799$r8$lambda$dfoBJHTz7ndC7TW6_aien8ODpM(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$17(r1);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$fhzKZx2jwtcIfnwBzgvuYW0E5DU(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$11(r1);
    }

    public static /* synthetic */ void $r8$lambda$k2yOseZTc140OPCycC9m9cFSyAY(StringJoiner r0, Function r1, ActivityRecord r2) {
        lambda$getDebugInfoForActivitySecurity$26(r0, r1, r2);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$kS7MK094THGkRDZroVab3BNNxY4(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$15(r1);
    }

    public static /* synthetic */ String $r8$lambda$mdknfWam_0rK4EOY75iDal7MnfI(ActivityRecord r0, ActivityRecord r1, ActivityRecord r2, ActivityRecord r3) {
        return lambda$getDebugInfoForActivitySecurity$25(r0, r1, r2, r3);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$qwKE29ZgLVq82R1Dbs6thRoF194(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$7(r1);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$sSQXOx60Z_LKLOn6Zlt0mmNv2OM(BalState r0) {
        return lambda$new$3(r0);
    }

    public static /* synthetic */ void $r8$lambda$uLeRDh5znlPAtTl8IN5Og9EpWxQ(BackgroundActivityStartController r0, String r1) {
        r0.lambda$showToast$19(r1);
    }

    public static /* synthetic */ BalVerdict $r8$lambda$uVjAnc6CEWSG0Erw3uRpeGN1dHs(BackgroundActivityStartController r0, BalState r1) {
        return r0.lambda$new$8(r1);
    }

    public static /* synthetic */ void $r8$lambda$wQjHETe6MlBqjqRwygZZ1P35974(StringJoiner r0, FinishedActivityEntry r1) {
        lambda$getDebugInfoForActivitySecurity$28(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTaskIdToFinishedActivity, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m9800$$Nest$fgetmTaskIdToFinishedActivity(BackgroundActivityStartController r0) {
        return r0.mTaskIdToFinishedActivity;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTopFinishedActivity, reason: not valid java name */
    static /* bridge */ /* synthetic */ FinishedActivityEntry m9801$$Nest$fgetmTopFinishedActivity(BackgroundActivityStartController r0) {
        return r0.mTopFinishedActivity;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTopFinishedActivity, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9802$$Nest$fputmTopFinishedActivity(BackgroundActivityStartController r0, FinishedActivityEntry r1) {
        r0.mTopFinishedActivity = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerService m9803$$Nest$mgetService(BackgroundActivityStartController r0) {
        return r0.getService();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTargetSdk, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9804$$Nest$mgetTargetSdk(BackgroundActivityStartController r0, String r1) {
        return r0.getTargetSdk(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetDebugStringForActivityRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9805$$Nest$smgetDebugStringForActivityRecord(ActivityRecord r0) {
        return getDebugStringForActivityRecord(r0);
    }

    static {
        BAL_CHECK_FOREGROUND = new BackgroundLaunchProcessController.BalCheckConfiguration(false, true, false, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        BAL_CHECK_BACKGROUND = new BackgroundLaunchProcessController.BalCheckConfiguration(false, false, true, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        ACTIVITY_OPTIONS_SYSTEM_DEFINED = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(0).setPendingIntentCreatorBackgroundActivityStartMode(0);
    }

    static String balCodeToString(int balCode) {
        switch(balCode) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            case 127: goto L5;
            default: goto L4;
        };
    L5:
        return "BAL_BLOCK";
    L6:
        return "BAL_ALLOW_BOUND_BY_FOREGROUND";
    L7:
        return "BAL_ALLOW_TOKEN";
    L8:
        return "BAL_ALLOW_NON_APP_VISIBLE_WINDOW";
    L9:
        return "BAL_ALLOW_SDK_SANDBOX";
    L10:
        return "BAL_ALLOW_FOREGROUND";
    L11:
        return "BAL_ALLOW_GRACE_PERIOD";
    L12:
        return "BAL_ALLOW_SAW_PERMISSION";
    L13:
        return "BAL_ALLOW_PERMISSION";
    L14:
        return "BAL_ALLOW_PENDING_INTENT";
    L15:
        return "BAL_ALLOW_VISIBLE_WINDOW";
    L16:
        return "BAL_ALLOW_ALLOWLISTED_COMPONENT";
    L17:
        return "BAL_ALLOW_ALLOWLISTED_UID";
    L18:
        return "BAL_ALLOW_DEFAULT";
    L4:
        throw new IllegalArgumentException("Unexpected value: " + balCode);
    }

    static String balStartModeToString(int startMode) {
        switch(startMode) {
            case -1: goto L9;
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L4;
            default: goto L11;
        };
    L4:
        return "MODE_BACKGROUND_ACTIVITY_START_ALLOW_IF_VISIBLE";
    L5:
        return "MODE_BACKGROUND_ACTIVITY_START_ALWAYS";
    L6:
        return "MODE_BACKGROUND_ACTIVITY_START_DENIED";
    L7:
        return "MODE_BACKGROUND_ACTIVITY_START_ALLOWED";
    L8:
        return "MODE_BACKGROUND_ACTIVITY_START_SYSTEM_DEFINED";
    L9:
        return "MODE_BACKGROUND_ACTIVITY_START_COMPAT";
    L11:
        return "MODE_BACKGROUND_ACTIVITY_START_ALLOWED(" + startMode + ")";
    }

    BackgroundActivityStartController(ActivityTaskManagerService service, ActivityTaskSupervisor supervisor) {
        this.mStrictModeBalCallbacks = new SparseArray();
        this.mTaskIdToFinishedActivity = new HashMap();
        this.mTopFinishedActivity = null;
        this.mCheckCallerVisible = new BackgroundActivityStartController$$ExternalSyntheticLambda11(this);
        this.mCheckCallerNonAppVisible = new BackgroundActivityStartController$$ExternalSyntheticLambda19(this);
        this.mCheckCallerIsAllowlistedUid = new BackgroundActivityStartController$$ExternalSyntheticLambda20();
        this.mCheckCallerIsAllowlistedComponent = new BackgroundActivityStartController$$ExternalSyntheticLambda21(this);
        this.mCheckCallerHasBackgroundPermission = new BackgroundActivityStartController$$ExternalSyntheticLambda22(this);
        this.mCheckCallerHasSawPermission = new BackgroundActivityStartController$$ExternalSyntheticLambda23(this);
        this.mCheckCallerHasBgStartAppOp = new BackgroundActivityStartController$$ExternalSyntheticLambda24(this);
        this.mCheckCallerProcessAllowsForeground = new BackgroundActivityStartController$$ExternalSyntheticLambda25(this);
        this.mCheckCallerProcessAllowsBackground = new BackgroundActivityStartController$$ExternalSyntheticLambda26(this);
        this.mCheckRealCallerVisible = new BackgroundActivityStartController$$ExternalSyntheticLambda27(this);
        this.mCheckRealCallerNonAppVisible = new BackgroundActivityStartController$$ExternalSyntheticLambda12(this);
        this.mCheckRealCallerProcessAllowsBalForeground = new BackgroundActivityStartController$$ExternalSyntheticLambda13(this);
        this.mCheckRealCallerProcessAllowsBalBackground = new BackgroundActivityStartController$$ExternalSyntheticLambda14(this);
        this.mCheckRealCallerBalPermission = new BackgroundActivityStartController$$ExternalSyntheticLambda15(this);
        this.mCheckRealCallerSawPermission = new BackgroundActivityStartController$$ExternalSyntheticLambda16(this);
        this.mCheckRealCallerAllowlistedUid = new BackgroundActivityStartController$$ExternalSyntheticLambda17();
        this.mCheckRealCallerAllowlistedComponent = new BackgroundActivityStartController$$ExternalSyntheticLambda18(this);
        this.mExt = (IExtBackgroundActivityStartController) ExtImplFactory.getImpl(IExtBackgroundActivityStartController.class, new Object[]{this});
        this.mService = service;
        this.mSupervisor = supervisor;
        this.mZswExt = BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswBackgroundActivityStartController(this);
    }

    private ActivityTaskManagerService getService() {
        return this.mService;
    }

    private ActivityTaskSupervisor getSupervisor() {
        return this.mSupervisor;
    }

    private boolean isHomeApp(int uid, String packageName) {
        WindowProcessController homeProcess = getService().mHomeProcess;
        if (homeProcess != null) goto L5;
    L12:
        if (packageName != null) goto L14;
        return false;
    L14:
        ComponentName activity = getService().getPackageManagerInternalLocked().getDefaultHomeActivity(UserHandle.getUserId(uid));
        if (activity == null) goto L20;
        if (packageName.equals(activity.getPackageName()) == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (homeProcess.mUid != 1000) goto L8;
        if (packageName != null) goto L12;
    L8:
        if (uid != homeProcess.mUid) goto L11;
        return true;
    L11:
        return false;
    }

    BalVerdict checkBackgroundActivityStart(int callingUid, int callingPid, String callingPackage, int realCallingUid, int realCallingPid, WindowProcessController callerApp, PendingIntentRecord originatingPendingIntent, boolean allowBalExemptionForSystemProcess, ActivityRecord resultRecord, Intent intent, ActivityOptions checkedOptions) {
        if (checkedOptions != null) goto L4;
        ActivityOptions checkedOptions2 = ACTIVITY_OPTIONS_SYSTEM_DEFINED;
    L5:
        BalState state = new BalState(this, callingUid, callingPid, callingPackage, realCallingUid, realCallingPid, callerApp, originatingPendingIntent, allowBalExemptionForSystemProcess, resultRecord, intent, checkedOptions2);
        if (Process.isSdkSandboxUid(BalState.m9824$$Nest$fgetmRealCallingUid(state)) == false) goto L11;
        int realCallingSdkSandboxUidToAppUid = Process.getAppUidForSdkSandboxUid(BalState.m9824$$Nest$fgetmRealCallingUid(state));
        if (getService().hasActiveVisibleWindow(realCallingSdkSandboxUidToAppUid) == false) goto L11;
        state.setResultForRealCaller(new BalVerdict(10, "uid in SDK sandbox has visible (non-toast) window"));
        return allowBasedOnRealCaller(state);
    L11:
        BalVerdict resultForCaller = checkBackgroundActivityStartAllowedByCaller(state);
        state.setResultForCaller(resultForCaller);
        if (BalState.m9832$$Nest$mhasRealCaller(state) == true) goto L20;
        if (resultForCaller.allows() == false) goto L18;
        return allowBasedOnCaller(state);
    L18:
        return abortLaunch(state);
    L20:
        if (BalState.m9831$$Nest$mcallerIsRealCaller(state) == true) goto L22;
    L24:
        BalVerdict resultForRealCaller = checkBackgroundActivityStartAllowedByRealCaller(state).setBasedOnRealCaller();
    L25:
        state.setResultForRealCaller(resultForRealCaller);
        boolean realCallerCanAllow = true;
        if (state.isPendingIntent() == false) goto L33;
        if (resultForCaller.allows() == false) goto L33;
        if (resultForRealCaller.blocks() == false) goto L33;
        resultForCaller.setOnlyCreatorAllows(true);
    L33:
        if (resultForCaller.allows() == false) goto L39;
        if (state.callerExplicitOptInOrAutoOptIn() == false) goto L39;
        return allowBasedOnCaller(state);
    L39:
        if (resultForRealCaller.allows() == false) goto L45;
        if (state.realCallerExplicitOptInOrAutoOptIn() == false) goto L45;
        return allowBasedOnRealCaller(state);
    L45:
        if (resultForCaller.allows() == true) goto L47;
    L49:
        boolean callerCanAllow = false;
    L51:
        if (resultForRealCaller.allows() == true) goto L53;
    L55:
        realCallerCanAllow = false;
    L57:
        if (callerCanAllow == true) goto L59;
    L62:
        if (realCallerCanAllow == true) goto L64;
    L67:
        if (callerCanAllow == true) goto L69;
        if (realCallerCanAllow == true) goto L69;
    L71:
        return abortLaunch(state);
    L69:
        Slog.w(TAG, "Without BAL hardening this activity start would be allowed");
        goto L71
    L64:
        if (state.mBalAllowedByPiSender.allowsBackgroundActivityStarts() == false) goto L67;
        Slog.wtf(TAG, "With Android 14 BAL hardening this activity start will be blocked if the PI sender upgrades target_sdk to 34+!  goo.gle/android-bal (missing opt in by PI sender)!" + state);
        return allowBasedOnRealCaller(state);
    L59:
        if (state.mBalAllowedByPiCreator.allowsBackgroundActivityStarts() == false) goto L62;
        Slog.wtf(TAG, "With Android 15 BAL hardening this activity start may be blocked if the PI creator upgrades target_sdk to 35+! goo.gle/android-bal (missing opt in by PI creator)!" + state);
        return allowBasedOnCaller(state);
    L53:
        if (state.realCallerExplicitOptOut() == true) goto L55;
    L47:
        if (state.callerExplicitOptOut() == true) goto L49;
        callerCanAllow = true;
        goto L51
    L22:
        if (resultForCaller.allows() == false) goto L24;
        resultForRealCaller = resultForCaller;
        goto L25
    L4:
        checkedOptions2 = checkedOptions;
        goto L5
    }

    private BalVerdict allowBasedOnCaller(BalState state) {
        if (ActivityTaskManagerDebugConfig.DEBUG_ACTIVITY_STARTS == false) goto L6;
        Slog.d(TAG, "Background activity launch allowed based on caller. " + state);
    L6:
        return statsLog(BalState.m9829$$Nest$fgetmResultForCaller(state), state);
    }

    private BalVerdict allowBasedOnRealCaller(BalState state) {
        if (ActivityTaskManagerDebugConfig.DEBUG_ACTIVITY_STARTS == false) goto L6;
        Slog.d(TAG, "Background activity launch allowed based on real caller. " + state);
    L6:
        return statsLog(BalState.m9830$$Nest$fgetmResultForRealCaller(state), state);
    }

    private BalVerdict abortLaunch(BalState state) {
        Slog.wtf(TAG, "Background activity launch blocked! goo.gle/android-bal " + state);
        BalVerdict verdict = statsLog(BalVerdict.BLOCK, state);
        if (state.isPendingIntent() == false) goto L13;
        StringBuilder r1 = new StringBuilder();
        r1.append("PendingIntent Activity start blocked in ");
        r1.append(BalState.m9822$$Nest$fgetmRealCallingPackage(state));
        r1.append(". PendingIntent was created in ");
        r1.append(BalState.m9809$$Nest$fgetmCallingPackage(state));
        r1.append(". ");
        String r3 = "";
        if (BalState.m9830$$Nest$fgetmResultForRealCaller(state).allows() == false) goto L7;
        String r2 = BalState.m9822$$Nest$fgetmRealCallingPackage(state) + " could opt in to grant BAL privileges when sending. ";
    L8:
        r1.append(r2);
        if (BalState.m9829$$Nest$fgetmResultForCaller(state).allows() == false) goto L12;
        r3 = BalState.m9809$$Nest$fgetmCallingPackage(state) + " could opt in to grant BAL privileges when creating.";
    L12:
        r1.append(r3);
        r1.append("The intent would have started ");
        r1.append(BalState.m9817$$Nest$fgetmIntent(state).getComponent());
        String abortDebugMessage = r1.toString();
    L14:
        strictModeLaunchAborted(BalState.m9811$$Nest$fgetmCallingUid(state), abortDebugMessage);
        if (BalState.m9831$$Nest$mcallerIsRealCaller(state) == true) goto L17;
        strictModeLaunchAborted(BalState.m9824$$Nest$fgetmRealCallingUid(state), abortDebugMessage);
    L17:
        return verdict;
    L7:
        r2 = "";
        goto L8
    L13:
        abortDebugMessage = "Activity start blocked. The intent would have started " + BalState.m9817$$Nest$fgetmIntent(state).getComponent();
        goto L14
    }

    Map<IBinder, IBackgroundActivityLaunchCallback> getStrictModeBalCallbacks(int uid) {
        SparseArray<ArrayMap<IBinder, IBackgroundActivityLaunchCallback>> r0 = this.mStrictModeBalCallbacks;
        monitor-enter(r0);
        ArrayMap<IBinder, IBackgroundActivityLaunchCallback> callbackMap = this.mStrictModeBalCallbacks.get(uid);     // Catch: Throwable -> L9
        if (callbackMap != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        ArrayMap r2 = new ArrayMap(callbackMap);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    boolean addStrictModeCallback(final int uid, final IBinder callback) {
        IBackgroundActivityLaunchCallback balCallback = IBackgroundActivityLaunchCallback.Stub.asInterface(callback);
        SparseArray<ArrayMap<IBinder, IBackgroundActivityLaunchCallback>> r1 = this.mStrictModeBalCallbacks;
        monitor-enter(r1);
        ArrayMap<IBinder, IBackgroundActivityLaunchCallback> callbackMap = this.mStrictModeBalCallbacks.get(uid);     // Catch: Throwable -> L7
        if (callbackMap != null) goto L10;
        callbackMap = new ArrayMap();     // Catch: Throwable -> L7
        this.mStrictModeBalCallbacks.put(uid, callbackMap);     // Catch: Throwable -> L7
    L10:
        if (callbackMap.containsKey(callback) == false) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L7
        return false;
    L13:
        callbackMap.put(callback, balCallback);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        callback.linkToDeath(new BackgroundActivityStartController$$ExternalSyntheticLambda10(this, uid, callback), 0);     // Catch: RemoteException -> L17
        return true;
    L18:
        removeStrictModeCallback(uid, callback);
        return true;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$addStrictModeCallback$0(int uid, IBinder callback) {
        removeStrictModeCallback(uid, callback);
    }

    void removeStrictModeCallback(int uid, IBinder callback) {
        SparseArray<ArrayMap<IBinder, IBackgroundActivityLaunchCallback>> r0 = this.mStrictModeBalCallbacks;
        monitor-enter(r0);
        Map<IBinder, IBackgroundActivityLaunchCallback> callbackMap = this.mStrictModeBalCallbacks.get(uid);     // Catch: Throwable -> L12
        if (callback == null) goto L16;
        if (callbackMap.containsKey(callback) == false) goto L16;
        callbackMap.remove(callback);     // Catch: Throwable -> L12
        if (callbackMap.isEmpty() == false) goto L14;
        this.mStrictModeBalCallbacks.remove(uid);     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void strictModeLaunchAborted(int callingUid, String message) {
        Map<IBinder, IBackgroundActivityLaunchCallback> strictModeBalCallbacks = getStrictModeBalCallbacks(callingUid);
        if (strictModeBalCallbacks != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<IBinder, IBackgroundActivityLaunchCallback>> r1 = strictModeBalCallbacks.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<IBinder, IBackgroundActivityLaunchCallback> callbackEntry = r1.next();
        callbackEntry.getValue().onBackgroundActivityLaunchAborted(message);     // Catch: RemoteException -> L11
    L12:
        removeStrictModeCallback(callingUid, callbackEntry.getKey());
        goto L7
    }

    BalVerdict checkBackgroundActivityStartAllowedByCaller(BalState state) {
        if (BalState.m9816$$Nest$fgetmCheckedOptions(state).getPendingIntentCreatorBackgroundActivityStartMode() != 4) goto L5;
        boolean evaluateVisibleOnly = true;
    L6:
        if (evaluateVisibleOnly == false) goto L10;
        return evaluateChain(state, new BalExemptionCheck[]{this.mCheckCallerVisible, this.mCheckCallerNonAppVisible, this.mCheckCallerProcessAllowsForeground});
    L10:
        if (state.isPendingIntent() == false) goto L14;
        return evaluateChain(state, new BalExemptionCheck[]{this.mCheckCallerIsAllowlistedUid, this.mCheckCallerIsAllowlistedComponent, this.mCheckCallerHasBackgroundPermission, this.mCheckCallerHasSawPermission, this.mCheckCallerHasBgStartAppOp, this.mCheckCallerProcessAllowsBackground, this.mCheckCallerVisible, this.mCheckCallerNonAppVisible, this.mCheckCallerProcessAllowsForeground});
    L14:
        return evaluateChain(state, new BalExemptionCheck[]{this.mCheckCallerVisible, this.mCheckCallerNonAppVisible, this.mCheckCallerProcessAllowsForeground, this.mCheckCallerIsAllowlistedUid, this.mCheckCallerIsAllowlistedComponent, this.mCheckCallerHasBackgroundPermission, this.mCheckCallerHasSawPermission, this.mCheckCallerHasBgStartAppOp, this.mCheckCallerProcessAllowsBackground});
    L5:
        evaluateVisibleOnly = false;
        goto L6
    }

    private BalVerdict evaluateChain(BalState state, BalExemptionCheck... checks) {
        int r0 = checks.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        BalExemptionCheck check = checks[r1];
        BalVerdict verdict = check.evaluate(state);
        if (verdict != BalVerdict.BLOCK) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return verdict;
    L9:
        return BalVerdict.BLOCK;
    }

    private /* synthetic */ BalVerdict lambda$new$1(BalState state) {
        boolean appSwitchAllowedOrFg = true;
        if (BalState.m9807$$Nest$fgetmAppSwitchState(state) != 2) goto L5;
    L12:
        if (appSwitchAllowedOrFg == false) goto L18;
        if (BalState.m9814$$Nest$fgetmCallingUidHasVisibleNotPinnedActivity(state) == false) goto L18;
        return new BalVerdict(4, "callingUid has visible non-pinned window");
    L18:
        return BalVerdict.BLOCK;
    L5:
        if (BalState.m9807$$Nest$fgetmAppSwitchState(state) == 1) goto L12;
        if (isHomeApp(BalState.m9811$$Nest$fgetmCallingUid(state), BalState.m9809$$Nest$fgetmCallingPackage(state)) == true) goto L12;
        appSwitchAllowedOrFg = false;
        goto L12
    }

    private /* synthetic */ BalVerdict lambda$new$2(BalState state) {
        if (BalState.m9812$$Nest$fgetmCallingUidHasNonAppVisibleWindow(state) == false) goto L7;
        return new BalVerdict(11, "callingUid has non-app visible window " + getService().mActiveUids.getNonAppVisibleWindowDetails(BalState.m9811$$Nest$fgetmCallingUid(state)));
    L7:
        return BalVerdict.BLOCK;
    }

    private static /* synthetic */ BalVerdict lambda$new$3(BalState state) {
        int callingAppId = UserHandle.getAppId(BalState.m9811$$Nest$fgetmCallingUid(state));
        if (BalState.m9811$$Nest$fgetmCallingUid(state) == 0) goto L12;
        if (callingAppId == 1000) goto L12;
        if (callingAppId == 1027) goto L12;
        return BalVerdict.BLOCK;
    L12:
        return new BalVerdict(2, "Important callingUid");
    }

    private /* synthetic */ BalVerdict lambda$new$4(BalState state) {
        if (isHomeApp(BalState.m9811$$Nest$fgetmCallingUid(state), BalState.m9809$$Nest$fgetmCallingPackage(state)) == true) goto L5;
        int callingAppId = UserHandle.getAppId(BalState.m9811$$Nest$fgetmCallingUid(state));
        WindowState imeWindow = getService().mRootWindowContainer.getCurrentInputMethodWindow();
        if (imeWindow == null) goto L13;
        if (callingAppId != imeWindow.mOwnerUid) goto L13;
        return new BalVerdict(3, "Active ime");
    L13:
        if (BalState.m9818$$Nest$fgetmIsCallingUidPersistentSystemProcess(state) == false) goto L17;
        return new BalVerdict(3, "callingUid is persistent system process");
    L17:
        if (getSupervisor().mRecentTasks.isCallerRecents(BalState.m9811$$Nest$fgetmCallingUid(state)) == false) goto L21;
        return new BalVerdict(3, "Recents Component");
    L21:
        if (getService().isDeviceOwner(BalState.m9811$$Nest$fgetmCallingUid(state)) == false) goto L25;
        return new BalVerdict(3, "Device Owner");
    L25:
        if (getService().isAffiliatedProfileOwner(BalState.m9811$$Nest$fgetmCallingUid(state)) == true) goto L27;
        int callingUserId = UserHandle.getUserId(BalState.m9811$$Nest$fgetmCallingUid(state));
        if (getService().isAssociatedCompanionApp(callingUserId, BalState.m9811$$Nest$fgetmCallingUid(state)) == false) goto L33;
        return new BalVerdict(3, "Companion App");
    L33:
        if (this.mZswExt.isAppStartModeLockedSkip(BalState.m9809$$Nest$fgetmCallingPackage(state), BalState.m9817$$Nest$fgetmIntent(state), BalState.m9810$$Nest$fgetmCallingPid(state)) == false) goto L37;
        return new BalVerdict(1, "autolaunch whitelist apps");
    L37:
        return BalVerdict.BLOCK;
    L27:
        return new BalVerdict(3, "Affiliated Profile Owner");
    L5:
        return new BalVerdict(3, "Home app");
    }

    private /* synthetic */ BalVerdict lambda$new$5(BalState state) {
        if (hasBalPermission(BalState.m9811$$Nest$fgetmCallingUid(state), BalState.m9810$$Nest$fgetmCallingPid(state)) == false) goto L7;
        return new BalVerdict(6, "START_ACTIVITIES_FROM_BACKGROUND permission granted");
    L7:
        return BalVerdict.BLOCK;
    }

    private /* synthetic */ BalVerdict lambda$new$6(BalState state) {
        if (getService().hasSystemAlertWindowPermission(BalState.m9811$$Nest$fgetmCallingUid(state), BalState.m9810$$Nest$fgetmCallingPid(state), BalState.m9809$$Nest$fgetmCallingPackage(state)) == false) goto L9;
        if (getExt().checkBackgroundActivityPermission(getService(), BalState.m9811$$Nest$fgetmCallingUid(state), BalState.m9809$$Nest$fgetmCallingPackage(state), BalState.m9817$$Nest$fgetmIntent(state)) == false) goto L9;
        return new BalVerdict(7, "SYSTEM_ALERT_WINDOW permission is granted");
    L9:
        return BalVerdict.BLOCK;
    }

    private /* synthetic */ BalVerdict lambda$new$7(BalState state) {
        if (isSystemExemptFlagEnabled() == false) goto L9;
        if (getService().getAppOpsManager().checkOpNoThrow(130, BalState.m9811$$Nest$fgetmCallingUid(state), BalState.m9809$$Nest$fgetmCallingPackage(state)) != 0) goto L9;
        return new BalVerdict(6, "OP_SYSTEM_EXEMPT_FROM_ACTIVITY_BG_START_RESTRICTION appop is granted");
    L9:
        return BalVerdict.BLOCK;
    }

    private /* synthetic */ BalVerdict lambda$new$8(BalState state) {
        return checkProcessAllowsBal(BalState.m9808$$Nest$fgetmCallerApp(state), state, BAL_CHECK_FOREGROUND);
    }

    private /* synthetic */ BalVerdict lambda$new$9(BalState state) {
        return checkProcessAllowsBal(BalState.m9808$$Nest$fgetmCallerApp(state), state, BAL_CHECK_BACKGROUND);
    }

    BalVerdict checkBackgroundActivityStartAllowedByRealCaller(BalState state) {
        if (BalState.m9816$$Nest$fgetmCheckedOptions(state).getPendingIntentBackgroundActivityStartMode() != 4) goto L5;
        boolean evaluateVisibleOnly = true;
    L6:
        if (evaluateVisibleOnly == false) goto L10;
        return evaluateChain(state, new BalExemptionCheck[]{this.mCheckRealCallerVisible, this.mCheckRealCallerNonAppVisible, this.mCheckRealCallerProcessAllowsBalForeground});
    L10:
        return evaluateChain(state, new BalExemptionCheck[]{this.mCheckRealCallerVisible, this.mCheckRealCallerNonAppVisible, this.mCheckRealCallerProcessAllowsBalForeground, this.mCheckRealCallerBalPermission, this.mCheckRealCallerSawPermission, this.mCheckRealCallerAllowlistedUid, this.mCheckRealCallerAllowlistedComponent, this.mCheckRealCallerProcessAllowsBalBackground});
    L5:
        evaluateVisibleOnly = false;
        goto L6
    }

    private /* synthetic */ BalVerdict lambda$new$10(BalState state) {
        boolean appSwitchAllowedOrFg = true;
        if (BalState.m9807$$Nest$fgetmAppSwitchState(state) != 2) goto L5;
    L12:
        if (appSwitchAllowedOrFg == false) goto L18;
        if (BalState.m9827$$Nest$fgetmRealCallingUidHasVisibleNotPinnedActivity(state) == false) goto L18;
        return new BalVerdict(4, "realCallingUid has visible non-pinned window");
    L18:
        return BalVerdict.BLOCK;
    L5:
        if (BalState.m9807$$Nest$fgetmAppSwitchState(state) == 1) goto L12;
        if (isHomeApp(BalState.m9824$$Nest$fgetmRealCallingUid(state), BalState.m9822$$Nest$fgetmRealCallingPackage(state)) == true) goto L12;
        appSwitchAllowedOrFg = false;
        goto L12
    }

    private /* synthetic */ BalVerdict lambda$new$11(BalState state) {
        if (BalState.m9825$$Nest$fgetmRealCallingUidHasNonAppVisibleWindow(state) == false) goto L7;
        return new BalVerdict(11, "realCallingUid has non-app visible window " + getService().mActiveUids.getNonAppVisibleWindowDetails(BalState.m9824$$Nest$fgetmRealCallingUid(state)));
    L7:
        return BalVerdict.BLOCK;
    }

    private /* synthetic */ BalVerdict lambda$new$12(BalState state) {
        return checkProcessAllowsBal(BalState.m9821$$Nest$fgetmRealCallerApp(state), state, BAL_CHECK_FOREGROUND);
    }

    private /* synthetic */ BalVerdict lambda$new$13(BalState state) {
        return checkProcessAllowsBal(BalState.m9821$$Nest$fgetmRealCallerApp(state), state, BAL_CHECK_BACKGROUND);
    }

    private /* synthetic */ BalVerdict lambda$new$14(BalState state) {
        if (BalState.m9816$$Nest$fgetmCheckedOptions(state).getPendingIntentBackgroundActivityStartMode() != 3) goto L5;
        boolean allowAlways = true;
    L7:
        if (allowAlways == false) goto L13;
        if (hasBalPermission(BalState.m9824$$Nest$fgetmRealCallingUid(state), BalState.m9823$$Nest$fgetmRealCallingPid(state)) == false) goto L13;
        return new BalVerdict(6, "realCallingUid has BAL permission.");
    L13:
        return BalVerdict.BLOCK;
    L5:
        allowAlways = false;
        goto L7
    }

    private /* synthetic */ BalVerdict lambda$new$15(BalState state) {
        if (BalState.m9816$$Nest$fgetmCheckedOptions(state).getPendingIntentBackgroundActivityStartMode() != 3) goto L5;
        boolean allowAlways = true;
    L6:
        if (allowAlways == false) goto L12;
        if (getService().hasSystemAlertWindowPermission(BalState.m9824$$Nest$fgetmRealCallingUid(state), BalState.m9823$$Nest$fgetmRealCallingPid(state), BalState.m9822$$Nest$fgetmRealCallingPackage(state)) == false) goto L12;
        return new BalVerdict(7, "SYSTEM_ALERT_WINDOW permission is granted");
    L12:
        return BalVerdict.BLOCK;
    L5:
        allowAlways = false;
        goto L6
    }

    private static /* synthetic */ BalVerdict lambda$new$16(BalState state) {
        if (BalState.m9816$$Nest$fgetmCheckedOptions(state).getPendingIntentBackgroundActivityStartMode() != 3) goto L5;
        boolean allowAlways = true;
    L6:
        if (allowAlways == true) goto L10;
        if (BalState.m9806$$Nest$fgetmAllowBalExemptionForSystemProcess(state) == true) goto L10;
    L14:
        return BalVerdict.BLOCK;
    L10:
        if (BalState.m9819$$Nest$fgetmIsRealCallingUidPersistentSystemProcess(state) == false) goto L14;
        return new BalVerdict(2, "realCallingUid is persistent system process AND intent sender forced to allow.");
    L5:
        allowAlways = false;
        goto L6
    }

    private /* synthetic */ BalVerdict lambda$new$17(BalState state) {
        if (getService().isAssociatedCompanionApp(UserHandle.getUserId(BalState.m9824$$Nest$fgetmRealCallingUid(state)), BalState.m9824$$Nest$fgetmRealCallingUid(state)) == false) goto L7;
        return new BalVerdict(3, "realCallingUid is a companion app.");
    L7:
        return BalVerdict.BLOCK;
    }

    boolean hasBalPermission(int uid, int pid) {
        if (ActivityTaskManagerService.checkPermission("android.permission.START_ACTIVITIES_FROM_BACKGROUND", pid, uid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    BalVerdict checkProcessAllowsBal(WindowProcessController app, BalState state, BackgroundLaunchProcessController.BalCheckConfiguration balCheckConfiguration) {
        if (app == null) goto L4;
        BalVerdict balAllowedForCaller = app.areBackgroundActivityStartsAllowed(BalState.m9807$$Nest$fgetmAppSwitchState(state), balCheckConfiguration);
        if (balAllowedForCaller.allows() == true) goto L8;
        ArraySet<WindowProcessController> uidProcesses = getService().mProcessMap.getProcesses(app.mUid);
        if (uidProcesses == null) goto L21;
        int i = uidProcesses.size() - 1;
    L12:
        if (i < 0) goto L21;
        WindowProcessController proc = uidProcesses.valueAt(i);
        if (proc == app) goto L19;
        BalVerdict balAllowedForUid = proc.areBackgroundActivityStartsAllowed(BalState.m9807$$Nest$fgetmAppSwitchState(state), balCheckConfiguration);
        if (balAllowedForUid.allows() == false) goto L19;
        return balAllowedForUid.withProcessInfo(SceneUtils.KEY_PROCESS_NAME, proc);
    L19:
        i = i - 1;
    L21:
        return BalVerdict.BLOCK;
    L8:
        return balAllowedForCaller.withProcessInfo("callerApp process", app);
    L4:
        return BalVerdict.BLOCK;
    }

    boolean checkActivityAllowedToStart(ActivityRecord sourceRecord, ActivityRecord targetRecord, boolean newTask, boolean avoidMoveTaskToFront, Task targetTask, int launchFlags, int balCode, int callingUid, int realCallingUid, TaskDisplayArea preferredTaskDisplayArea) {
        if (balCode == 2) goto L75;
        boolean r0 = false;
        if (newTask == false) goto L7;
    L10:
        boolean taskToFront = true;
    L11:
        if (taskToFront == true) goto L13;
    L29:
        BlockActivityStart bas = new BlockActivityStart(null);
        if (sourceRecord == null) goto L47;
        Task sourceTask = sourceRecord.getTask();
        if (taskToFront == false) goto L34;
        Task taskToCheck = sourceTask;
    L35:
        BlockActivityStart bas2 = checkTopActivityForAsm(taskToCheck, sourceRecord.getUid(), sourceRecord, bas);
        if (taskToFront == true) goto L38;
    L46:
        BlockActivityStart bas3 = bas2;
    L71:
        if (BlockActivityStart.m9836$$Nest$fgetmTopActivityMatchesSource(bas3) == false) goto L74;
        return true;
    L74:
        return logAsmFailureAndCheckFeatureEnabled(sourceRecord, callingUid, realCallingUid, newTask, avoidMoveTaskToFront, targetTask, targetRecord, balCode, launchFlags, bas3, taskToFront);
    L38:
        if (BlockActivityStart.m9836$$Nest$fgetmTopActivityMatchesSource(bas2) == false) goto L46;
        if (sourceTask != null) goto L41;
    L45:
        BlockActivityStart.m9838$$Nest$fputmTopActivityMatchesSource(bas2, r0);
        goto L46
    L41:
        if (sourceTask.isVisible() == true) goto L43;
        if (sourceTask != targetTask) goto L45;
    L43:
        r0 = true;
        goto L45
    L34:
        taskToCheck = targetTask;
        goto L35
    L47:
        if (targetTask == null) goto L51;
        if (taskToFront == false) goto L50;
        if (avoidMoveTaskToFront == false) goto L51;
    L50:
        bas3 = checkTopActivityForAsm(targetTask, callingUid, null, bas);
    L51:
        if (targetTask != null) goto L53;
    L55:
        TaskDisplayArea displayArea = preferredTaskDisplayArea;
    L57:
        if (displayArea == null) goto L69;
        ArrayList<Task> visibleTasks = displayArea.getVisibleTasks();
        int i = 0;
    L60:
        if (i >= visibleTasks.size()) goto L68;
        Task task = visibleTasks.get(i);
        if (visibleTasks.size() == 1) goto L64;
    L66:
        bas = checkTopActivityForAsm(task, callingUid, null, bas);
    L67:
        i = i + 1;
        goto L60
    L64:
        if (task.isActivityTypeHomeOrRecents() == false) goto L66;
        bas.optedIn(task.getTopMostActivity());
        goto L67
    L68:
        bas3 = bas;
        goto L71
    L69:
        bas3 = bas;
        goto L71
    L53:
        if (targetTask.getDisplayArea() == null) goto L55;
        displayArea = targetTask.getDisplayArea();
        goto L57
    L13:
        if (balCode != 3) goto L15;
    L28:
        return true;
    L15:
        if (balCode == 6) goto L28;
        if (balCode == 5) goto L28;
        if (balCode == 7) goto L28;
        if (balCode == 4) goto L28;
        if (balCode == 11) goto L28;
        if (balCode == 12) goto L28;
        if (balCode != 13) goto L29;
    L7:
        if ((launchFlags & 268435456) == 268435456) goto L10;
        taskToFront = false;
        goto L11
    L75:
        return true;
    }

    private boolean logAsmFailureAndCheckFeatureEnabled(ActivityRecord sourceRecord, int callingUid, int realCallingUid, boolean newTask, boolean avoidMoveTaskToFront, Task targetTask, ActivityRecord targetRecord, int balCode, int launchFlags, BlockActivityStart bas, boolean taskToFront) {
        String r14 = null;
        if (targetTask != null) goto L5;
        ActivityRecord r5 = null;
    L6:
        ActivityRecord targetTopActivity = r5;
        if (newTask == true) goto L14;
        if (sourceRecord == null) goto L14;
        if (sourceRecord.getTask().equals(targetTask) == false) goto L13;
        int r0 = 1;
    L15:
        int action = r0;
        if (BlockActivityStart.m9837$$Nest$fgetmTopActivityOptedIn(bas) == true) goto L18;
    L20:
        boolean enforceBlock = false;
    L21:
        boolean allowedByGracePeriod = allowedByAsmGracePeriod(callingUid, sourceRecord, targetTask, balCode, taskToFront, avoidMoveTaskToFront);
        String asmDebugInfo = getDebugInfoForActivitySecurity("Launch", sourceRecord, targetRecord, targetTask, targetTopActivity, realCallingUid, balCode, enforceBlock, taskToFront, avoidMoveTaskToFront, allowedByGracePeriod, BlockActivityStart.m9835$$Nest$fgetmActivityOptedIn(bas));
        if (sourceRecord == null) goto L24;
        int r17 = sourceRecord.getUid();
    L25:
        if (sourceRecord == null) goto L27;
        String r18 = sourceRecord.info.name;
    L28:
        if (targetTopActivity == null) goto L31;
        int r1 = targetTopActivity.getUid();
    L30:
        int r19 = r1;
        if (targetTopActivity == null) goto L34;
        r14 = targetTopActivity.info.name;
    L34:
        String r20 = r14;
        if (newTask == true) goto L42;
        if (sourceRecord == null) goto L42;
        if (targetTask == null) goto L42;
        if (targetTask.equals(sourceRecord.getTask()) == false) goto L42;
        boolean r21 = false;
    L43:
        int r22 = targetRecord.getUid();
        String r2 = targetRecord.info.name;
        String r24 = targetRecord.intent.getAction();
        if (targetTask == null) goto L51;
        if (sourceRecord == null) goto L51;
        if (targetTask.equals(sourceRecord.getTask()) == true) goto L51;
        if (targetTask.isVisible() == false) goto L51;
        boolean r28 = true;
    L52:
        FrameworkStatsLog.write(FrameworkStatsLog.ACTIVITY_ACTION_BLOCKED, r17, r18, r19, r20, r21, r22, r2, r24, launchFlags, action, 11, r28, balCode, asmDebugInfo);
        String launchedFromPackageName = targetRecord.launchedFromPackage;
        if (ActivitySecurityModelFeatureFlags.shouldShowToast(callingUid) == false) goto L60;
        StringBuilder r6 = new StringBuilder();
        r6.append("go/android-asm");
        if (enforceBlock == false) goto L57;
        String r9 = " blocked ";
    L58:
        r6.append(r9);
        r6.append(ActivityTaskSupervisor.getApplicationLabel(getService().mContext.getPackageManager(), launchedFromPackageName));
        String toastText = r6.toString();
        showToast(toastText);
        Slog.i(TAG, asmDebugInfo);
        goto L60
    L57:
        r9 = " would block ";
    L60:
        if (enforceBlock == false) goto L67;
        StringBuilder r7 = new StringBuilder();
        r7.append("[ASM] Abort Launching r: ");
        r7.append(targetRecord);
        r7.append(" as source: ");
        if (sourceRecord == null) goto L64;
        Object r10 = sourceRecord;
    L65:
        r7.append(r10);
        r7.append(" is in background. New task: ");
        r7.append(newTask);
        r7.append(". Top activity: ");
        r7.append(targetTopActivity);
        r7.append(". BAL Code: ");
        r7.append(balCodeToString(balCode));
        Slog.e(TAG, r7.toString());
        return false;
    L64:
        r10 = launchedFromPackageName;
        goto L65
    L67:
        return true;
    L51:
        r28 = false;
    L42:
        r21 = true;
        goto L43
    L31:
        r1 = -1;
        goto L30
    L27:
        r18 = null;
        goto L28
    L24:
        r17 = callingUid;
        goto L25
    L18:
        if (ActivitySecurityModelFeatureFlags.shouldRestrictActivitySwitch(callingUid) == false) goto L20;
        enforceBlock = true;
        goto L21
    L13:
        r0 = 2;
    L14:
        r0 = 3;
        goto L15
    L5:
        r5 = targetTask.getActivity(new BackgroundActivityStartController$$ExternalSyntheticLambda28());
        goto L6
    }

    private static /* synthetic */ boolean lambda$logAsmFailureAndCheckFeatureEnabled$18(ActivityRecord ar) {
        if (ar.finishing == false) goto L5;
    L7:
        return false;
    L5:
        if (ar.isAlwaysOnTop() == true) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$showToast$19(String toastText) {
        Toast.makeText(getService().mContext, toastText, 1).show();
    }

    void showToast(final String toastText) {
        UiThread.getHandler().post(new BackgroundActivityStartController$$ExternalSyntheticLambda9(this, toastText));
    }

    void clearTopIfNeeded(Task targetTask, ActivityRecord sourceRecord, ActivityRecord targetRecord, final int callingUid, final int realCallingUid, int launchFlags, int balCode) {
        if ((launchFlags & 268435456) == 268435456) goto L5;
        return;
    L5:
        if (balCode == 2) goto L42;
        final int startingUid = targetRecord.getUid();
        Predicate<ActivityRecord> isLaunchingOrLaunched = new BackgroundActivityStartController$$ExternalSyntheticLambda29(startingUid, callingUid, realCallingUid);
        ActivityRecord targetTaskTop = targetTask.getTopMostActivity();
        if (targetTaskTop == null) goto L37;
        if (isLaunchingOrLaunched.test(targetTaskTop) == true) goto L41;
        int[] finishCount = new int[1];
        boolean shouldBlockActivityStart = ActivitySecurityModelFeatureFlags.shouldRestrictActivitySwitch(callingUid);
        BlockActivityStart bas = checkCrossUidActivitySwitchFromBelow(targetTaskTop, callingUid, new BlockActivityStart(null));
        if (shouldBlockActivityStart == false) goto L23;
        if (BlockActivityStart.m9837$$Nest$fgetmTopActivityOptedIn(bas) == false) goto L23;
        ActivityRecord activity = targetTask.getActivity(isLaunchingOrLaunched);
        if (activity != null) goto L19;
        activity = targetRecord;
    L19:
        targetTask.performClearTop(activity, launchFlags, finishCount);
        if (finishCount[0] <= 0) goto L23;
        Slog.w(TAG, "Cleared top n: " + finishCount[0] + " activities from task t: " + targetTask + " not matching top uid: " + callingUid);
    L23:
        if (ActivitySecurityModelFeatureFlags.shouldShowToast(callingUid) == false) goto L35;
        if (shouldBlockActivityStart == true) goto L26;
    L29:
        StringBuilder r9 = new StringBuilder();
        if (shouldBlockActivityStart == false) goto L32;
        String r10 = "Top activities cleared by ";
    L33:
        r9.append(r10);
        r9.append("go/android-asm");
        showToast(r9.toString());
        Slog.i(TAG, getDebugInfoForActivitySecurity("Clear Top", sourceRecord, targetRecord, targetTask, targetTaskTop, realCallingUid, balCode, shouldBlockActivityStart, true, false, false, BlockActivityStart.m9835$$Nest$fgetmActivityOptedIn(bas)));
        return;
    L32:
        r10 = "Top activities would be cleared by ";
        goto L33
    L26:
        if (finishCount[0] > 0) goto L29;
        return;
    L35:
        return;
    L41:
        return;
    L37:
        return;
    }

    private static /* synthetic */ boolean lambda$clearTopIfNeeded$20(int startingUid, int callingUid, int realCallingUid, ActivityRecord ar) {
        if (ar.isUid(startingUid) == false) goto L5;
    L10:
        return true;
    L5:
        if (ar.isUid(callingUid) == true) goto L10;
        if (ar.isUid(realCallingUid) == true) goto L10;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void checkActivityAllowedToClearTask(Task r30, int r31, int r32, String r33) {
        if (r31 == 1000) goto L63;
        if (r30.isVisible() == false) goto L63;
        if (r30.inMultiWindowMode() == true) goto L66;
        int r2 = BalVerdict.m9834$$Nest$fgetmCode(checkBackgroundActivityStartAllowedByCaller(new BalState(this, r31, r32, getService().mContext.getPackageManager().getNameForUid(r31), -1, -1, null, null, false, null, null, ActivityOptions.makeBasic())));
        if (r2 == 2) goto L61;
        if (r2 == 3) goto L61;
        if (r2 == 6) goto L61;
        if (r2 == 7) goto L61;
        if (r2 == 4) goto L61;
        if (r2 == 11) goto L61;
        if (r2 == 13) goto L65;
        TaskDisplayArea r3 = r30.getTaskDisplayArea();
        if (r3 != null) goto L27;
        return;
    L27:
        String r6 = null;
        BlockActivityStart r5 = checkTopActivityForAsm(r30, r31, null, new BlockActivityStart(0 == true ? 1 : 0));
        if (BlockActivityStart.m9836$$Nest$fgetmTopActivityMatchesSource(r5) == false) goto L30;
        return;
    L30:
        ActivityRecord r7 = r30.getActivity(new BackgroundActivityStartController$$ExternalSyntheticLambda0());
        if (r7 != null) goto L34;
        int r8 = -1;
    L33:
        int r17 = r8;
        if (r7 == null) goto L38;
        r6 = r7.info.name;
    L38:
        FrameworkStatsLog.write(FrameworkStatsLog.ACTIVITY_ACTION_BLOCKED, r31, r33, r17, r6, false, -1, null, null, 0, 4, 11, false, -1, null);
        if (ActivitySecurityModelFeatureFlags.shouldRestrictActivitySwitch(r31) == true) goto L41;
    L43:
        boolean r9 = false;
    L44:
        PackageManager r10 = getService().mContext.getPackageManager();
        String r11 = r10.getNameForUid(r31);
        if (r11 != null) goto L47;
        r11 = String.valueOf(r31);
        CharSequence r12 = r11;
    L49:
        if (ActivitySecurityModelFeatureFlags.shouldShowToast(r31) == false) goto L56;
        StringBuilder r13 = new StringBuilder();
        r13.append("go/android-asm");
        if (r9 == false) goto L53;
        String r14 = " returned home due to ";
    L54:
        r13.append(r14);
        r13.append(r12);
        showToast(r13.toString());
        goto L56
    L53:
        r14 = " would return home due to ";
    L56:
        if (r9 == false) goto L58;
        Slog.w(TAG, "[ASM] Return to home as source: " + r11 + " is not on top of task t: " + r30);
        r3.moveHomeActivityToTop("taskRemoved");
        return;
    L58:
        Slog.i(TAG, "[ASM] Would return to home as source: " + r11 + " is not on top of task t: " + r30);
        return;
    L47:
        r12 = ActivityTaskSupervisor.getApplicationLabel(r10, r11);
        goto L49
    L41:
        if (BlockActivityStart.m9837$$Nest$fgetmTopActivityOptedIn(r5) == false) goto L43;
        r9 = true;
        goto L44
    L34:
        r8 = r7.getUid();
        goto L33
    L65:
        return;
    L61:
        return;
    L66:
        return;
    }

    private static /* synthetic */ boolean lambda$checkActivityAllowedToClearTask$21(ActivityRecord ar) {
        if (ar.finishing == false) goto L5;
    L7:
        return false;
    L5:
        if (ar.isAlwaysOnTop() == true) goto L7;
        return true;
    }

    private BlockActivityStart checkTopActivityForAsm(Task task, final int uid, final ActivityRecord sourceRecord, BlockActivityStart bas) {
        if (sourceRecord != null) goto L4;
    L7:
        ActivityRecord topActivity = task.getTopMostActivity();
        if (topActivity != null) goto L11;
        Slog.wtf(TAG, "Activities for task: " + task + " not found.");
        return bas.optedIn(topActivity);
    L11:
        BlockActivityStart bas2 = checkCrossUidActivitySwitchFromBelow(topActivity, uid, bas);
        if (BlockActivityStart.m9836$$Nest$fgetmTopActivityMatchesSource(bas2) == false) goto L15;
        return bas2;
    L15:
        if (task.forAllActivities(new BackgroundActivityStartController$$ExternalSyntheticLambda1(uid)) == true) goto L17;
        final Predicate<ActivityRecord> topOfStackPredicate = new BackgroundActivityStartController$$ExternalSyntheticLambda2(sourceRecord);
        ActivityRecord topActivity2 = task.getActivity(topOfStackPredicate);
        if (topActivity2 != null) goto L21;
        return bas2;
    L21:
        BlockActivityStart bas3 = checkCrossUidActivitySwitchFromBelow(topActivity2, uid, bas2);
        if (BlockActivityStart.m9836$$Nest$fgetmTopActivityMatchesSource(bas3) == false) goto L24;
        return bas3;
    L24:
        TaskFragment taskFragment = topActivity2.getTaskFragment();
        if (taskFragment != null) goto L28;
        return bas3;
    L28:
        if (taskFragment.hasAdjacentTaskFragment() == true) goto L30;
        return bas3;
    L30:
        final BlockActivityStart[] out = {bas3};
        taskFragment.forOtherAdjacentTaskFragments(new BackgroundActivityStartController$$ExternalSyntheticLambda3(this, topOfStackPredicate, out, uid));
        return out[0];
    L17:
        return bas2.matchesSource();
    L4:
        if (sourceRecord.isVisibleRequested() == false) goto L7;
        return bas.matchesSource();
    }

    private static /* synthetic */ boolean lambda$checkTopActivityForAsm$22(int uid, ActivityRecord ar) {
        if (ar.isUid(uid) == true) goto L5;
    L7:
        return false;
    L5:
        if (ar.isVisibleRequested() == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$checkTopActivityForAsm$23(ActivityRecord sourceRecord, ActivityRecord ar) {
        if (ar.equals(sourceRecord) == false) goto L5;
    L10:
        return true;
    L5:
        if (ar.finishing == false) goto L7;
    L9:
        return false;
    L7:
        if (ar.isAlwaysOnTop() == true) goto L9;
        goto L9
    }

    private /* synthetic */ void lambda$checkTopActivityForAsm$24(Predicate topOfStackPredicate, BlockActivityStart[] out, int uid, TaskFragment adjacentTaskFragment) {
        ActivityRecord top = adjacentTaskFragment.getActivity(topOfStackPredicate);
        if (top == null) goto L6;
        out[0] = checkCrossUidActivitySwitchFromBelow(top, uid, out[0]);
        return;
    }

    private BlockActivityStart checkCrossUidActivitySwitchFromBelow(ActivityRecord ar, int sourceUid, BlockActivityStart bas) {
        if (ar.isUid(sourceUid) == false) goto L7;
        return bas.matchesSource();
    L7:
        if (ar.mAllowCrossUidActivitySwitchFromBelow == false) goto L11;
        BlockActivityStart.m9839$$Nest$fputmTopActivityOptedIn(bas, false);
        return bas.matchesSource();
    L11:
        if (ar.isUid(1000) == false) goto L14;
        return bas;
    L14:
        if (CompatChanges.isChangeEnabled(230590090, ar.getUid()) == true) goto L16;
        return bas;
    L16:
        String packageName = ar.packageName;
        if (packageName != null) goto L20;
        Slog.wtf(TAG, "Package name: " + ar + " not found.");
        return bas.optedIn(ar);
    L20:
        PackageManager pm = getService().mContext.getPackageManager();
        int sourceUserId = UserHandle.getUserId(sourceUid);
        ApplicationInfo applicationInfo = pm.getApplicationInfoAsUser(packageName, 0, sourceUserId);     // Catch: PackageManager.NameNotFoundException -> L27
        if (applicationInfo.allowCrossUidActivitySwitchFromBelow == false) goto L26;
        return bas;
    L26:
        return bas.optedIn(ar);
    L28:
        Slog.wtf(TAG, "Package name: " + packageName + " not found for user " + sourceUserId);
        return bas.optedIn(ar);
    }

    private String getDebugInfoForActivitySecurity(String action, final ActivityRecord sourceRecord, final ActivityRecord targetRecord, Task targetTask, final ActivityRecord targetTopActivity, int realCallingUid, int balCode, boolean enforceBlock, boolean taskToFront, boolean avoidMoveTaskToFront, boolean allowedByGracePeriod, ActivityRecord activityOptedIn) {
        final Function<ActivityRecord, String> recordToString = new BackgroundActivityStartController$$ExternalSyntheticLambda4(sourceRecord, targetTopActivity, targetRecord);
        final StringJoiner joiner = new StringJoiner("\n");
        joiner.add("[ASM] ------ Activity Security " + action + " Debug Logging Start ------");
        StringBuilder r11 = new StringBuilder();
        r11.append("[ASM] Block Enabled: ");
        r11.append(enforceBlock);
        joiner.add(r11.toString());
        boolean targetTaskMatchesSourceTask = true;
        if (enforceBlock == true) goto L5;
        joiner.add("[ASM] Feature Flag Enabled: true");
        joiner.add("[ASM] Mendel Override: " + ActivitySecurityModelFeatureFlags.asmRestrictionsEnabledForAll());
    L5:
        joiner.add("[ASM] ASM Version: 11");
        joiner.add("[ASM] System Time: " + SystemClock.uptimeMillis());
        joiner.add("[ASM] Activity Opted In: " + recordToString.apply(activityOptedIn));
        if (targetTask == null) goto L11;
        if (sourceRecord == null) goto L11;
        if (sourceRecord.getTask() != targetTask) goto L11;
    L13:
        if (sourceRecord != null) goto L15;
        joiner.add("[ASM] Source Package: " + targetRecord.launchedFromPackage);
        String realCallingPackage = getService().mContext.getPackageManager().getNameForUid(realCallingUid);
        joiner.add("[ASM] Real Calling Uid Package: " + realCallingPackage);
    L20:
        joiner.add("[ASM] Target Task Top: " + recordToString.apply(targetTopActivity));
        if (targetTaskMatchesSourceTask == true) goto L25;
        joiner.add("[ASM] Target Task: " + targetTask);
        if (targetTask == null) goto L25;
        joiner.add("[ASM] Target Task Stack: ");
        targetTask.forAllActivities(new BackgroundActivityStartController$$ExternalSyntheticLambda6(joiner, recordToString));
    L25:
        joiner.add("[ASM] Target Record: " + recordToString.apply(targetRecord));
        joiner.add("[ASM] Intent: " + targetRecord.intent);
        joiner.add("[ASM] TaskToFront: " + taskToFront);
        joiner.add("[ASM] AvoidMoveToFront: " + avoidMoveTaskToFront);
        joiner.add("[ASM] BalCode: " + balCodeToString(balCode));
        joiner.add("[ASM] Allowed By Grace Period: " + allowedByGracePeriod);
        joiner.add("[ASM] LastResumedActivity: " + recordToString.apply(getService().mLastResumedActivity));
        joiner.add("[ASM] System opted into enforcement: false");
        if (this.mTopFinishedActivity == null) goto L29;
        joiner.add("[ASM] TopFinishedActivity: " + this.mTopFinishedActivity.mDebugInfo);
    L29:
        if (this.mTaskIdToFinishedActivity.isEmpty() == true) goto L32;
        joiner.add("[ASM] TaskIdToFinishedActivity: ");
        this.mTaskIdToFinishedActivity.values().forEach(new BackgroundActivityStartController$$ExternalSyntheticLambda7(joiner));
    L32:
        if (balCode != 4) goto L34;
    L39:
        if (sourceRecord == null) goto L41;
        Task task = sourceRecord.getTask();
    L42:
        if (task != null) goto L44;
    L46:
        joiner.add("[ASM] ------ Activity Security " + action + " Debug Logging End ------");
        return joiner.toString();
    L44:
        if (task.getDisplayArea() == null) goto L46;
        joiner.add("[ASM] Tasks: ");
        task.getDisplayArea().forAllTasks(new BackgroundActivityStartController$$ExternalSyntheticLambda8(joiner));
        goto L46
    L41:
        task = targetTask;
        goto L42
    L34:
        if (balCode == 11) goto L39;
        if (balCode == 9) goto L39;
        if (balCode != 13) goto L46;
    L15:
        joiner.add("[ASM] Source Record: " + recordToString.apply(sourceRecord));
        joiner.add("[ASM] Source Launch Package: " + sourceRecord.launchedFromPackage);
        joiner.add("[ASM] Source Launch Intent: " + sourceRecord.intent);
        if (targetTaskMatchesSourceTask == false) goto L18;
        joiner.add("[ASM] Source/Target Task: " + sourceRecord.getTask());
        joiner.add("[ASM] Source/Target Task Stack: ");
    L19:
        sourceRecord.getTask().forAllActivities(new BackgroundActivityStartController$$ExternalSyntheticLambda5(joiner, recordToString));
        goto L20
    L18:
        joiner.add("[ASM] Source Task: " + sourceRecord.getTask());
        joiner.add("[ASM] Source Task Stack: ");
    L11:
        targetTaskMatchesSourceTask = false;
        goto L13
    }

    private static /* synthetic */ String lambda$getDebugInfoForActivitySecurity$25(ActivityRecord sourceRecord, ActivityRecord targetTopActivity, ActivityRecord targetRecord, ActivityRecord ar) {
        if (ar != null) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        if (ar != sourceRecord) goto L8;
        String r1 = " [source]=> ";
    L13:
        r0.append(r1);
        r0.append(getDebugStringForActivityRecord(ar));
        return r0.toString();
    L8:
        if (ar != targetTopActivity) goto L10;
        r1 = " [ top  ]=> ";
        goto L13
    L10:
        if (ar != targetRecord) goto L12;
        r1 = " [target]=> ";
        goto L13
    L12:
        r1 = "         => ";
        goto L13
    }

    private static /* synthetic */ void lambda$getDebugInfoForActivitySecurity$26(StringJoiner joiner, Function recordToString, ActivityRecord ar) {
        joiner.add("[ASM] " + ((String) recordToString.apply(ar)));
    }

    private static /* synthetic */ void lambda$getDebugInfoForActivitySecurity$27(StringJoiner joiner, Function recordToString, ActivityRecord ar) {
        joiner.add("[ASM] " + ((String) recordToString.apply(ar)));
    }

    private static /* synthetic */ void lambda$getDebugInfoForActivitySecurity$28(StringJoiner joiner, FinishedActivityEntry fae) {
        joiner.add("[ASM]   " + fae.mDebugInfo);
    }

    private static /* synthetic */ void lambda$getDebugInfoForActivitySecurity$29(StringJoiner joiner, Task t) {
        joiner.add("[ASM]    T: " + t.toFullString());
    }

    private boolean allowedByAsmGracePeriod(int callingUid, ActivityRecord sourceRecord, Task targetTask, int balCode, boolean taskToFront, boolean avoidMoveTaskToFront) {
        if (balCode == 8) goto L5;
    L26:
        return false;
    L5:
        if (taskToFront == true) goto L7;
    L11:
        if (taskToFront == false) goto L13;
        if (avoidMoveTaskToFront == false) goto L26;
    L13:
        if (targetTask == null) goto L19;
        FinishedActivityEntry finishedEntry = this.mTaskIdToFinishedActivity.get(Integer.valueOf(targetTask.mTaskId));
        if (finishedEntry == null) goto L19;
        if (finishedEntry.mUid != callingUid) goto L19;
        return true;
    L19:
        if (sourceRecord == null) goto L26;
        FinishedActivityEntry finishedEntry2 = this.mTaskIdToFinishedActivity.get(Integer.valueOf(sourceRecord.getTask().mTaskId));
        if (finishedEntry2 != null) goto L23;
        return false;
    L23:
        if (finishedEntry2.mUid == callingUid) goto L25;
        return false;
    L25:
        return true;
    L7:
        if (this.mTopFinishedActivity == null) goto L11;
        if (this.mTopFinishedActivity.mUid != callingUid) goto L11;
        return true;
    }

    private static boolean isSystemExemptFlagEnabled() {
        return DeviceConfig.getBoolean("window_manager", "system_exempt_from_activity_bg_start_restriction_enabled", true);
    }

    private BalVerdict statsLog(BalVerdict finalVerdict, BalState state) {
        if (finalVerdict.blocks() == false) goto L25;
        if (getService().isActivityStartsLoggingEnabled() == false) goto L25;
        ActivityMetricsLogger r1 = this.mSupervisor.getActivityMetricsLogger();
        Intent r2 = BalState.m9817$$Nest$fgetmIntent(state);
        WindowProcessController r3 = BalState.m9808$$Nest$fgetmCallerApp(state);
        int r4 = BalState.m9811$$Nest$fgetmCallingUid(state);
        String r5 = BalState.m9809$$Nest$fgetmCallingPackage(state);
        int r6 = BalState.m9815$$Nest$fgetmCallingUidProcState(state);
        boolean r7 = true;
        if (BalState.m9813$$Nest$fgetmCallingUidHasVisibleActivity(state) == true) goto L13;
        if (BalState.m9812$$Nest$fgetmCallingUidHasNonAppVisibleWindow(state) == true) goto L13;
        r7 = false;
    L13:
        int r8 = BalState.m9824$$Nest$fgetmRealCallingUid(state);
        boolean r10 = false;
        int r9 = BalState.m9828$$Nest$fgetmRealCallingUidProcState(state);
        if (BalState.m9826$$Nest$fgetmRealCallingUidHasVisibleActivity(state) == false) goto L16;
    L19:
        r10 = r7;
    L21:
        if (BalState.m9820$$Nest$fgetmOriginatingPendingIntent(state) == null) goto L23;
        r10 = true;
    L23:
        r1.logAbortedBgActivityStart(r2, r3, r4, r5, r6, r7, r8, r9, r10, r10);
        goto L25
    L16:
        if (BalState.m9825$$Nest$fgetmRealCallingUidHasNonAppVisibleWindow(state) == false) goto L21;
    L25:
        if (logIfOnlyAllowedBy(finalVerdict, state, 8) == false) goto L27;
        String abortDebugMessage = "Activity start is only allowed by grace period. This may stop working in the future. intent: " + BalState.m9817$$Nest$fgetmIntent(state);
        strictModeLaunchAborted(BalState.m9824$$Nest$fgetmRealCallingUid(state), abortDebugMessage);
    L27:
        logIfOnlyAllowedBy(finalVerdict, state, 11);
        logIfOnlyAllowedBy(finalVerdict, state, 12);
        if (shouldLogStats(finalVerdict, state) == true) goto L30;
        writeBalAllowedLogMinimal(state);
    L39:
        return finalVerdict;
    L30:
        if (shouldLogIntentActivity(finalVerdict, state) == false) goto L36;
        Intent intent = BalState.m9817$$Nest$fgetmIntent(state);
        if (intent != null) goto L34;
        String activityName = "noIntent";
    L37:
        writeBalAllowedLog(activityName, finalVerdict.getCode(), state);
        goto L39
    L34:
        ComponentName r11 = intent.getComponent();
        r11.getClass();
        activityName = r11.flattenToShortString();
        goto L37
    L36:
        activityName = "";
        goto L37
    }

    private static boolean logIfOnlyAllowedBy(BalVerdict finalVerdict, BalState state, int balCode) {
        if (finalVerdict.getRawCode() == balCode) goto L5;
        return false;
    L5:
        if (state.realCallerExplicitOptInOrAutoOptIn() == false) goto L14;
        if (BalState.m9830$$Nest$fgetmResultForRealCaller(state) == null) goto L14;
        if (BalState.m9830$$Nest$fgetmResultForRealCaller(state).allows() == false) goto L14;
        if (BalState.m9830$$Nest$fgetmResultForRealCaller(state).getRawCode() == balCode) goto L14;
        return false;
    L14:
        if (state.callerExplicitOptInOrAutoOptIn() == true) goto L16;
        return true;
    L16:
        if (BalState.m9829$$Nest$fgetmResultForCaller(state) != null) goto L18;
        return true;
    L18:
        if (BalState.m9829$$Nest$fgetmResultForCaller(state).allows() == true) goto L20;
        return true;
    L20:
        if (BalState.m9829$$Nest$fgetmResultForCaller(state).getRawCode() == balCode) goto L27;
        return false;
    L27:
        return true;
    }

    boolean shouldLogStats(BalVerdict finalVerdict, BalState state) {
        if (finalVerdict.getRawCode() == 4) goto L5;
        return true;
    L5:
        if (state.isPendingIntent() == true) goto L8;
        return false;
    L8:
        if (BalVerdict.m9833$$Nest$fgetmBasedOnRealCaller(finalVerdict) == false) goto L12;
        return false;
    L12:
        return true;
    }

    boolean shouldLogIntentActivity(BalVerdict finalVerdict, BalState state) {
        if (BalVerdict.m9833$$Nest$fgetmBasedOnRealCaller(finalVerdict) == false) goto L8;
        if (BalState.m9824$$Nest$fgetmRealCallingUid(state) < 10000) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (BalState.m9811$$Nest$fgetmCallingUid(state) < 10000) goto L10;
        return false;
    L10:
        return true;
    }

    void writeBalAllowedLog(String activityName, int code, BalState state) {
        int r4 = BalState.m9811$$Nest$fgetmCallingUid(state);
        int r5 = BalState.m9824$$Nest$fgetmRealCallingUid(state);
        if (BalState.m9829$$Nest$fgetmResultForCaller(state) != null) goto L5;
        int r6 = 127;
    L6:
        boolean r7 = state.mBalAllowedByPiCreator.allowsBackgroundActivityStarts();
        boolean r8 = state.callerExplicitOptInOrOut();
        if (BalState.m9830$$Nest$fgetmResultForRealCaller(state) != null) goto L9;
        int r9 = 127;
    L10:
        FrameworkStatsLog.write(FrameworkStatsLog.BAL_ALLOWED, activityName, code, r4, r5, r6, r7, r8, r9, state.mBalAllowedByPiSender.allowsBackgroundActivityStarts(), state.realCallerExplicitOptInOrOut(), getTargetSdk(BalState.m9809$$Nest$fgetmCallingPackage(state)), getTargetSdk(BalState.m9822$$Nest$fgetmRealCallingPackage(state)));
        return;
    L9:
        r9 = BalState.m9830$$Nest$fgetmResultForRealCaller(state).getRawCode();
        goto L10
    L5:
        r6 = BalState.m9829$$Nest$fgetmResultForCaller(state).getRawCode();
        goto L6
    }

    void writeBalAllowedLogMinimal(BalState state) {
        if (BalState.m9829$$Nest$fgetmResultForCaller(state) != null) goto L5;
        int r9 = 127;
    L6:
        boolean r10 = state.mBalAllowedByPiCreator.allowsBackgroundActivityStarts();
        boolean r11 = state.callerExplicitOptInOrOut();
        if (BalState.m9830$$Nest$fgetmResultForRealCaller(state) != null) goto L9;
        int r12 = 127;
    L10:
        FrameworkStatsLog.write(FrameworkStatsLog.BAL_ALLOWED, "", 1, -1, -1, r9, r10, r11, r12, state.mBalAllowedByPiSender.allowsBackgroundActivityStarts(), state.realCallerExplicitOptInOrOut(), getTargetSdk(BalState.m9809$$Nest$fgetmCallingPackage(state)), getTargetSdk(BalState.m9822$$Nest$fgetmRealCallingPackage(state)));
        return;
    L9:
        r12 = BalState.m9830$$Nest$fgetmResultForRealCaller(state).getRawCode();
        goto L10
    L5:
        r9 = BalState.m9829$$Nest$fgetmResultForCaller(state).getRawCode();
        goto L6
    }

    void onActivityRequestedFinishing(ActivityRecord finishActivity) {
        FinishedActivityEntry entry = this.mTaskIdToFinishedActivity.get(Integer.valueOf(finishActivity.getTask().mTaskId));
        if (entry == null) goto L10;
        if (finishActivity.isUid(entry.mUid) == false) goto L10;
        if (entry.mLaunchCount <= 5) goto L10;
        return;
    L10:
        if (finishActivity.isVisibleRequested() == false) goto L12;
    L14:
        FinishedActivityEntry newEntry = new FinishedActivityEntry(this, finishActivity);
        this.mTaskIdToFinishedActivity.put(Integer.valueOf(finishActivity.getTask().mTaskId), newEntry);
        if (finishActivity.getTask().mVisibleRequested == false) goto L18;
        this.mTopFinishedActivity = newEntry;
        return;
    L18:
        return;
    L12:
        if (finishActivity == finishActivity.getTask().getTopMostActivity()) goto L14;
    }

    void onNewActivityLaunched(ActivityRecord activityStarted) {
        if (activityStarted.getTask() != null) goto L6;
        return;
    L6:
        if (activityStarted.getTask().mVisibleRequested == false) goto L8;
        this.mTopFinishedActivity = null;
    L8:
        FinishedActivityEntry entry = this.mTaskIdToFinishedActivity.get(Integer.valueOf(activityStarted.getTask().mTaskId));
        if (entry != null) goto L11;
        return;
    L11:
        if (activityStarted.getTask().isTaskId(entry.mTaskId) == false) goto L15;
        this.mTaskIdToFinishedActivity.remove(Integer.valueOf(entry.mTaskId));
        return;
    }

    private static String getDebugStringForActivityRecord(ActivityRecord ar) {
        return ar + " :: visible=" + ar.isVisible() + ", visibleRequested=" + ar.isVisibleRequested() + ", finishing=" + ar.finishing + ", alwaysOnTop=" + ar.isAlwaysOnTop() + ", lastLaunchTime=" + ar.lastLaunchTime + ", lastVisibleTime=" + ar.lastVisibleTime + ", taskFragment=" + ar.getTaskFragment();
    }

    private int getTargetSdk(String packageName) {
        if (packageName != null) goto L9;
        return -1;
    L9:
        PackageManager pm = getService().mContext.getPackageManager();     // Catch: Exception -> L7
        return pm.getTargetSdkVersion(packageName);
    L8:
        return -1;
    }

    public IExtBackgroundActivityStartController getExt() {
        return this.mExt;
    }
}
