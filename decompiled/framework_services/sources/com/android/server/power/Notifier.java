package com.android.server.power;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.app.trust.TrustManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.hardware.display.DisplayManagerInternal;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.metrics.LogMaker;
import android.net.Uri;
import android.os.BatteryStatsInternal;
import android.os.Bundle;
import android.os.Handler;
import android.os.IScreenTimeoutPolicyListener;
import android.os.IWakeLockCallback;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManagerInternal;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.WorkSource;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.ArrayMap;
import android.util.EventLog;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.WindowManagerPolicyConstants;
import com.android.internal.app.IBatteryStats;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.input.InputManagerInternal;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.policy.PhoneWindowManager;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.power.feature.PowerManagerFlags;
import com.android.server.statusbar.StatusBarManagerInternal;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class Notifier {
    private static final int[] CHARGING_VIBRATION_AMPLITUDE = null;
    private static final VibrationEffect CHARGING_VIBRATION_EFFECT = null;
    private static final long[] CHARGING_VIBRATION_TIME = null;
    private static final boolean DEBUG = false;
    private static final VibrationAttributes HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES = null;
    private static final int INTERACTIVE_STATE_ASLEEP = 2;
    private static final int INTERACTIVE_STATE_AWAKE = 1;
    private static final int INTERACTIVE_STATE_UNKNOWN = 0;
    private static final int MSG_BROADCAST = 2;
    private static final int MSG_BROADCAST_ENHANCED_PREDICTION = 4;
    private static final int MSG_PROFILE_TIMED_OUT = 5;
    private static final int MSG_SCREEN_POLICY = 7;
    private static final int MSG_USER_ACTIVITY = 1;
    private static final int MSG_WIRED_CHARGING_STARTED = 6;
    private static final int MSG_WIRELESS_CHARGING_STARTED = 3;
    private static final String TAG = "PowerManagerNotifier";
    private final ActivityManagerInternal mActivityManagerInternal;
    private final AppOpsManager mAppOps;
    private final Executor mBackgroundExecutor;
    private final IBatteryStats mBatteryStats;
    private final BatteryStatsInternal mBatteryStatsInternal;
    private boolean mBroadcastInProgress;
    private long mBroadcastStartTime;
    private int mBroadcastedInteractiveState;
    private final Context mContext;
    private SparseBooleanArray mDisplayInteractivities;
    private final DisplayManagerInternal mDisplayManagerInternal;
    private final FaceDownDetector mFaceDownDetector;
    private final PowerManagerFlags mFlags;
    private final FrameworkStatsLogger mFrameworkStatsLogger;
    private final WakeLockLog mFullWakeLockLog;
    private Interactivity mGlobalInteractivity;
    private final IIntentReceiver mGoToSleepBroadcastDone;
    private final NotifierHandler mHandler;
    private final Injector mInjector;
    private final InputManagerInternal mInputManagerInternal;
    private final InputMethodManagerInternal mInputMethodManagerInternal;
    private String mInteractiveChangeDetails;
    private final SparseArray<Interactivity> mInteractivityByGroupId;
    private final AtomicBoolean mIsPlayingChargingStartedFeedback;
    private final Object mLock;
    private final WakeLockLog mPartialWakeLockLog;
    private boolean mPendingGoToSleepBroadcast;
    private int mPendingInteractiveState;
    private boolean mPendingWakeUpBroadcast;
    private final WindowManagerPolicy mPolicy;
    private final Intent mScreenOffIntent;
    private final Intent mScreenOnIntent;
    private final Bundle mScreenOnOffOptions;
    private final SparseArray<ScreenTimeoutPolicyListenersContainer> mScreenTimeoutPolicyListeners;
    private final ScreenUndimDetector mScreenUndimDetector;
    private final boolean mShowWirelessChargingAnimationConfig;
    private final StatusBarManagerInternal mStatusBarManagerInternal;
    private final SuspendBlocker mSuspendBlocker;
    private final boolean mSuspendWhenScreenOffDueToProximityConfig;
    private final TrustManager mTrustManager;
    private boolean mUserActivityPending;
    private final Vibrator mVibrator;
    private final IIntentReceiver mWakeUpBroadcastDone;
    private final WakefulnessSessionObserver mWakefulnessSessionObserver;

    public interface Injector {
        long currentTimeMillis();

        AppOpsManager getAppOpsManager(Context r1);

        BatteryStatsInternal getBatteryStatsInternal();

        FrameworkStatsLogger getFrameworkStatsLogger();

        WakeLockLog getWakeLockLog(Context r1);
    }

    private static class Interactivity {
        public int changeReason;
        public long changeStartTime;
        public boolean isChanging;
        public boolean isInteractive;

        /* synthetic */ Interactivity(NotifierIA r1) {
            this();
        }

        private Interactivity() {
            this.isInteractive = true;
        }
    }

    private final class NotifierHandler extends Handler {
        final /* synthetic */ Notifier this$0;

        public NotifierHandler(Notifier r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L19;
            };
        L5:
            Notifier.m7423$$Nest$mscreenPolicyChanging(this.this$0, msg.arg1, msg.arg2);
            return;
        L6:
            Notifier.m7427$$Nest$mshowWiredChargingStarted(this.this$0, msg.arg1);
            return;
        L7:
            Notifier.m7422$$Nest$mlockProfile(this.this$0, msg.arg1);
            return;
        L8:
            removeMessages(4);
            Notifier.m7424$$Nest$msendEnhancedDischargePredictionBroadcast(this.this$0);
            return;
        L9:
            Notifier.m7428$$Nest$mshowWirelessChargingStarted(this.this$0, msg.arg1, msg.arg2);
            return;
        L10:
            Notifier.m7425$$Nest$msendNextBroadcast(this.this$0);
            return;
        L11:
            Notifier.m7426$$Nest$msendUserActivity(this.this$0, msg.arg1, msg.arg2);
            return;
        }
    }

    class RealInjector implements Injector {
        RealInjector(Notifier this$0) {
        }

        @Override // com.android.server.power.Notifier.Injector
        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }

        @Override // com.android.server.power.Notifier.Injector
        public WakeLockLog getWakeLockLog(Context context) {
            return new WakeLockLog(context);
        }

        @Override // com.android.server.power.Notifier.Injector
        public AppOpsManager getAppOpsManager(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }

        @Override // com.android.server.power.Notifier.Injector
        public BatteryStatsInternal getBatteryStatsInternal() {
            return (BatteryStatsInternal) LocalServices.getService(BatteryStatsInternal.class);
        }

        @Override // com.android.server.power.Notifier.Injector
        public FrameworkStatsLogger getFrameworkStatsLogger() {
            return new FrameworkStatsLogger();
        }
    }

    private final class ScreenTimeoutPolicyListenersContainer {
        private final ArrayMap<IScreenTimeoutPolicyListener, Integer> mLastReportedState;
        private final RemoteCallbackList<IScreenTimeoutPolicyListener> mListeners;
        private volatile int mScreenTimeoutPolicy;
        final /* synthetic */ Notifier this$0;

        /* JADX INFO: renamed from: $r8$lambda$rVPCw0atz6GsfCstOkR4CMvZP-A, reason: not valid java name */
        public static /* synthetic */ void m7429$r8$lambda$rVPCw0atz6GsfCstOkR4CMvZPA(ScreenTimeoutPolicyListenersContainer r0) {
            r0.lambda$updateScreenTimeoutPolicyAndNotifyIfNeeded$0();
        }

        /* JADX INFO: renamed from: $r8$lambda$rfRzDRR-XAxLfrN45gYO9-58W6U, reason: not valid java name */
        public static /* synthetic */ void m7430$r8$lambda$rfRzDRRXAxLfrN45gYO958W6U(ScreenTimeoutPolicyListenersContainer r0, IScreenTimeoutPolicyListener r1) {
            r0.lambda$addListener$1(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastReportedState, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m7431$$Nest$fgetmLastReportedState(ScreenTimeoutPolicyListenersContainer r0) {
            return r0.mLastReportedState;
        }

        ScreenTimeoutPolicyListenersContainer(final Notifier r2, int screenTimeoutPolicy) {
            this.this$0 = r2;
            this.mLastReportedState = new ArrayMap();
            this.mScreenTimeoutPolicy = screenTimeoutPolicy;
            this.mListeners = new AnonymousClass1(this, r2);
        }

        void updateScreenTimeoutPolicyAndNotifyIfNeeded(int screenTimeoutPolicy) {
            this.mScreenTimeoutPolicy = screenTimeoutPolicy;
            Notifier.m7421$$Nest$fgetmHandler(this.this$0).post(new Notifier$ScreenTimeoutPolicyListenersContainer$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$updateScreenTimeoutPolicyAndNotifyIfNeeded$0() {
            int i = this.mListeners.beginBroadcast() - 1;
        L3:
            if (i < 0) goto L5;
            IScreenTimeoutPolicyListener listener = (IScreenTimeoutPolicyListener) this.mListeners.getBroadcastItem(i);
            notifyListenerIfNeeded(listener);
            i = i - 1;
            goto L3
        L5:
            this.mListeners.finishBroadcast();
        }

        void addListener(final IScreenTimeoutPolicyListener listener) {
            this.mListeners.register(listener);
            Notifier.m7421$$Nest$fgetmHandler(this.this$0).post(new Notifier$ScreenTimeoutPolicyListenersContainer$$ExternalSyntheticLambda1(this, listener));
        }

        private /* synthetic */ void lambda$addListener$1(IScreenTimeoutPolicyListener listener) {
            notifyListenerIfNeeded(listener);
        }

        void removeListener(IScreenTimeoutPolicyListener listener) {
            this.mListeners.unregister(listener);
            this.mLastReportedState.remove(listener);
        }

        boolean isEmpty() {
            if (this.mListeners.getRegisteredCallbackCount() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        private void notifyListenerIfNeeded(IScreenTimeoutPolicyListener listener) {
            int currentScreenTimeoutPolicy = this.mScreenTimeoutPolicy;
            Integer reportedScreenTimeoutPolicy = this.mLastReportedState.get(listener);
            if (reportedScreenTimeoutPolicy != null) goto L5;
        L8:
            boolean needsReporting = true;
        L10:
            if (needsReporting == true) goto L21;
            return;
        L21:
            listener.onScreenTimeoutPolicyChanged(currentScreenTimeoutPolicy);     // Catch: Throwable -> L14 RemoteException -> L16
            this.mLastReportedState.put(listener, Integer.valueOf(currentScreenTimeoutPolicy));     // Catch: Throwable -> L14 RemoteException -> L16
        L23:
            return;
        L16:
            e = move-exception;
            Slog.e(Notifier.TAG, "Remote exception when notifying screen timeout policy change", e);
            return;
        L14:
            e = move-exception;
            Slog.e(Notifier.TAG, "Exception when notifying screen timeout policy change", e);
            removeListener(listener);
            return;
        L5:
            if (reportedScreenTimeoutPolicy.equals(Integer.valueOf(currentScreenTimeoutPolicy)) == false) goto L8;
            needsReporting = false;
            goto L10
        }
    }

    public static /* synthetic */ void $r8$lambda$JPimfzsYkXWexBDnIhDxNZnALw4(Notifier r0, int r1, int r2) {
        r0.lambda$handleEarlyInteractiveChange$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$NfLwjQ1rEoAdiv20_xGg1-SMd6o, reason: not valid java name */
    public static /* synthetic */ void m7415$r8$lambda$NfLwjQ1rEoAdiv20_xGg1SMd6o(Notifier r0, WorkSource r1, int r2, String r3, String r4, int r5, WorkSource r6, int r7, String r8, String r9, int r10, boolean r11) {
        r0.lambda$notifyWakelockChanging$10(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ void $r8$lambda$QTIfwUkFSEuVLy0XrFJFdtz0REM(Notifier r0) {
        r0.lambda$handleEarlyGlobalInteractiveChange$3();
    }

    public static /* synthetic */ void $r8$lambda$QUpiaPNPRkwU8U2MGuOtntv2mQ4(Notifier r0, int r1, int r2) {
        r0.lambda$handleLateInteractiveChange$6(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Rb9qlD2tgScsj7p88_DorCc8zYI(Notifier r0, boolean r1, String r2, int r3, int r4, int r5, WorkSource r6, String r7, String r8, long r9, IWakeLockCallback r11) {
        r0.lambda$notifyWakeLockListener$9(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11);
    }

    public static /* synthetic */ void $r8$lambda$SCBmQ4zv_u2tzxzELhkoGuGYMPs(Notifier r0, int r1, int r2) {
        r0.lambda$handleEarlyInteractiveChange$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$SkDw-9Ah-PeuwEpn0oKEUC_Tixs, reason: not valid java name */
    public static /* synthetic */ void m7416$r8$lambda$SkDw9AhPeuwEpn0oKEUC_Tixs(Notifier r0, int r1, int r2) {
        r0.lambda$handleLateGlobalInteractiveChange$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$YuWSecaCBIZkdw6vgJo0U2_0waI(Notifier r0, int r1, boolean r2) {
        r0.lambda$playChargingStartedFeedback$8(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$gr4Sg-fuhq8LQTf-FG_LHQ6nfuE, reason: not valid java name */
    public static /* synthetic */ void m7417$r8$lambda$gr4Sgfuhq8LQTfFG_LHQ6nfuE(Notifier r0, int r1) {
        r0.lambda$handleLateGlobalInteractiveChange$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$l-pS0TGPyPNM3uy9iTCbhgXMEzY, reason: not valid java name */
    public static /* synthetic */ void m7418$r8$lambda$lpS0TGPyPNM3uy9iTCbhgXMEzY(Notifier r0, int r1, int r2) {
        r0.lambda$handleLateInteractiveChange$7(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$twGPsuehH4Hy48BoSYCiwKEMjdU(Notifier r0) {
        r0.lambda$handleEarlyGlobalInteractiveChange$2();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m7419$$Nest$fgetmActivityManagerInternal(Notifier r0) {
        return r0.mActivityManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBroadcastStartTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7420$$Nest$fgetmBroadcastStartTime(Notifier r2) {
        return r2.mBroadcastStartTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotifierHandler m7421$$Nest$fgetmHandler(Notifier r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mlockProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7422$$Nest$mlockProfile(Notifier r0, int r1) {
        r0.lockProfile(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mscreenPolicyChanging, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7423$$Nest$mscreenPolicyChanging(Notifier r0, int r1, int r2) {
        r0.screenPolicyChanging(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msendEnhancedDischargePredictionBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7424$$Nest$msendEnhancedDischargePredictionBroadcast(Notifier r0) {
        r0.sendEnhancedDischargePredictionBroadcast();
    }

    /* JADX INFO: renamed from: -$$Nest$msendNextBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7425$$Nest$msendNextBroadcast(Notifier r0) {
        r0.sendNextBroadcast();
    }

    /* JADX INFO: renamed from: -$$Nest$msendUserActivity, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7426$$Nest$msendUserActivity(Notifier r0, int r1, int r2) {
        r0.sendUserActivity(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowWiredChargingStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7427$$Nest$mshowWiredChargingStarted(Notifier r0, int r1) {
        r0.showWiredChargingStarted(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowWirelessChargingStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7428$$Nest$mshowWirelessChargingStarted(Notifier r0, int r1, int r2) {
        r0.showWirelessChargingStarted(r1, r2);
    }

    static {
        CHARGING_VIBRATION_TIME = new long[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
        CHARGING_VIBRATION_AMPLITUDE = new int[]{1, 4, 11, 25, 44, 67, 91, 114, 123, 103, 79, 55, 34, 17, 7, 2};
        CHARGING_VIBRATION_EFFECT = VibrationEffect.createWaveform(CHARGING_VIBRATION_TIME, CHARGING_VIBRATION_AMPLITUDE, -1);
        HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES = VibrationAttributes.createForUsage(50);
    }

    public Notifier(Looper looper, Context context, IBatteryStats batteryStats, SuspendBlocker suspendBlocker, WindowManagerPolicy policy, FaceDownDetector faceDownDetector, ScreenUndimDetector screenUndimDetector, Executor backgroundExecutor, PowerManagerFlags powerManagerFlags, Injector injector) {
        this.mLock = new Object();
        this.mScreenTimeoutPolicyListeners = new SparseArray();
        this.mInteractivityByGroupId = new SparseArray();
        this.mDisplayInteractivities = new SparseBooleanArray();
        this.mGlobalInteractivity = new Interactivity(null);
        this.mIsPlayingChargingStartedFeedback = new AtomicBoolean(false);
        this.mWakeUpBroadcastDone = new AnonymousClass2(this);
        this.mGoToSleepBroadcastDone = new AnonymousClass3(this);
        this.mContext = context;
        if (injector != null) goto L5;
        Injector r0 = new RealInjector(this);
    L6:
        this.mInjector = r0;
        this.mFlags = powerManagerFlags;
        this.mBatteryStats = batteryStats;
        this.mAppOps = this.mInjector.getAppOpsManager(context);
        this.mSuspendBlocker = suspendBlocker;
        this.mPolicy = policy;
        this.mFaceDownDetector = faceDownDetector;
        this.mScreenUndimDetector = screenUndimDetector;
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mInputManagerInternal = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);
        this.mInputMethodManagerInternal = (InputMethodManagerInternal) LocalServices.getService(InputMethodManagerInternal.class);
        this.mStatusBarManagerInternal = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        this.mTrustManager = (TrustManager) this.mContext.getSystemService(TrustManager.class);
        this.mVibrator = (Vibrator) this.mContext.getSystemService(Vibrator.class);
        this.mWakefulnessSessionObserver = new WakefulnessSessionObserver(this.mContext, null);
        this.mHandler = new NotifierHandler(this, looper);
        this.mBackgroundExecutor = backgroundExecutor;
        this.mScreenOnIntent = new Intent("android.intent.action.SCREEN_ON");
        this.mScreenOnIntent.addFlags(1344274432);
        this.mScreenOffIntent = new Intent("android.intent.action.SCREEN_OFF");
        this.mScreenOffIntent.addFlags(1344274432);
        this.mScreenOnOffOptions = createScreenOnOffBroadcastOptions();
        this.mSuspendWhenScreenOffDueToProximityConfig = context.getResources().getBoolean(R.bool.config_trackerAppNeedsPermissions);
        this.mShowWirelessChargingAnimationConfig = context.getResources().getBoolean(R.bool.config_silenceSensorAvailable);
        this.mFullWakeLockLog = this.mInjector.getWakeLockLog(context);
        this.mPartialWakeLockLog = this.mInjector.getWakeLockLog(context);
        this.mBatteryStats.noteInteractive(true);     // Catch: RemoteException -> L9
    L11:
        FrameworkStatsLog.write(33, 1);
        if (this.mFlags.isMoveWscLoggingToNotifierEnabled() == false) goto L14;
        this.mBatteryStatsInternal = this.mInjector.getBatteryStatsInternal();
        this.mFrameworkStatsLogger = this.mInjector.getFrameworkStatsLogger();
        return;
    L14:
        this.mBatteryStatsInternal = null;
        this.mFrameworkStatsLogger = null;
        return;
    L5:
        r0 = injector;
        goto L6
    }

    private Bundle createScreenOnOffBroadcastOptions() {
        BroadcastOptions options = BroadcastOptions.makeBasic();
        options.setDeliveryGroupPolicy(1);
        options.setDeliveryGroupMatchingKey(UUID.randomUUID().toString(), "android.intent.action.SCREEN_ON");
        options.setDeferralPolicy(2);
        return options.toBundle();
    }

    public void onWakeLockAcquired(int flags, String tag, String packageName, int ownerUid, int ownerPid, WorkSource workSource, String historyTag, IWakeLockCallback callback) {
        logWakelockStateChanged(flags, tag, ownerUid, workSource, FrameworkStatsLogger.WakelockEventType.ACQUIRE);
        notifyWakeLockListener(callback, tag, true, ownerUid, ownerPid, flags, workSource, packageName, historyTag);
        if (this.mFlags.improveWakelockLatency() == true) goto L35;
        int monitorType = getBatteryStatsWakeLockMonitorType(flags);
        if (monitorType >= 0) goto L7;
        WorkSource r9 = workSource;
    L33:
        getWakeLockLog(flags).onWakeLockAcquired(tag, getUidForWakeLockLog(ownerUid, r9), flags, -1);
        goto L35
    L7:
        if (ownerUid == 1000) goto L9;
    L12:
        boolean r0 = false;
    L11:
        boolean unimportantForLogging = r0;
        if (workSource != null) goto L41;
        r9 = workSource;
        this.mBatteryStats.noteStartWakelock(ownerUid, ownerPid, tag, historyTag, monitorType, unimportantForLogging);     // Catch: RemoteException -> L30
        this.mAppOps.startOpNoThrow(40, ownerUid, packageName, false, null, null);     // Catch: RemoteException -> L28
        goto L33
    L41:
        this.mBatteryStats.noteStartWakelockFromSource(workSource, ownerPid, tag, historyTag, monitorType, unimportantForLogging);     // Catch: RemoteException -> L18
        r9 = workSource;
    L19:
        r9 = workSource;
    L22:
        r9 = workSource;
        goto L33
    L9:
        if ((1073741824 & flags) == 0) goto L12;
        r0 = true;
    L35:
        this.mWakefulnessSessionObserver.onWakeLockAcquired(flags);
    }

    public void onLongPartialWakeLockStart(String tag, int ownerUid, WorkSource workSource, String historyTag) {
        if (workSource == null) goto L18;
        this.mBatteryStats.noteLongPartialWakelockStartFromSource(tag, historyTag, workSource);     // Catch: RemoteException -> L5
        FrameworkStatsLog.write(11, workSource, tag, historyTag, 1);     // Catch: RemoteException -> L5
        return;
    L22:
        return;
    L18:
        this.mBatteryStats.noteLongPartialWakelockStart(tag, historyTag, ownerUid);     // Catch: RemoteException -> L13
        FrameworkStatsLog.write_non_chained(11, ownerUid, null, tag, historyTag, 1);     // Catch: RemoteException -> L11
        return;
    L25:
        return;
    }

    public void onLongPartialWakeLockFinish(String tag, int ownerUid, WorkSource workSource, String historyTag) {
        if (workSource == null) goto L18;
        this.mBatteryStats.noteLongPartialWakelockFinishFromSource(tag, historyTag, workSource);     // Catch: RemoteException -> L5
        FrameworkStatsLog.write(11, workSource, tag, historyTag, 0);     // Catch: RemoteException -> L5
        return;
    L22:
        return;
    L18:
        this.mBatteryStats.noteLongPartialWakelockFinish(tag, historyTag, ownerUid);     // Catch: RemoteException -> L13
        FrameworkStatsLog.write_non_chained(11, ownerUid, null, tag, historyTag, 0);     // Catch: RemoteException -> L11
        return;
    L25:
        return;
    }

    public void onWakeLockChanging(int flags, String tag, String packageName, int ownerUid, int ownerPid, WorkSource workSource, String historyTag, IWakeLockCallback callback, int newFlags, String newTag, String newPackageName, int newOwnerUid, int newOwnerPid, WorkSource newWorkSource, String newHistoryTag, IWakeLockCallback newCallback) {
        if (newWorkSource != null) goto L6;
        WorkSource r1 = null;
    L5:
        WorkSource newWorkSource2 = r1;
        int monitorType = getBatteryStatsWakeLockMonitorType(flags);
        int newMonitorType = getBatteryStatsWakeLockMonitorType(newFlags);
        if (workSource == null) goto L26;
        if (newWorkSource2 == null) goto L26;
        if (monitorType < 0) goto L26;
        if (newMonitorType < 0) goto L26;
        logWakelockStateChanged(flags, tag, ownerUid, workSource, FrameworkStatsLogger.WakelockEventType.RELEASE);
        logWakelockStateChanged(newFlags, newTag, newOwnerUid, newWorkSource2, FrameworkStatsLogger.WakelockEventType.ACQUIRE);
        if (newOwnerUid == 1000) goto L15;
    L18:
        boolean r0 = false;
    L17:
        boolean unimportantForLogging = r0;
        notifyWakelockChanging(workSource, ownerPid, tag, historyTag, monitorType, newWorkSource2, newOwnerPid, newTag, newHistoryTag, newMonitorType, unimportantForLogging);     // Catch: RemoteException -> L22
    L32:
        return;
    L15:
        if ((newFlags & 1073741824) == 0) goto L18;
        r0 = true;
    L26:
        if (PowerManagerService.isSameCallback(callback, newCallback) == true) goto L28;
        onWakeLockReleased(flags, tag, packageName, ownerUid, ownerPid, workSource, historyTag, null);
        onWakeLockAcquired(newFlags, newTag, newPackageName, newOwnerUid, newOwnerPid, newWorkSource2, newHistoryTag, newCallback);
        return;
    L28:
        onWakeLockReleased(flags, tag, packageName, ownerUid, ownerPid, workSource, historyTag, callback);
        onWakeLockAcquired(newFlags, newTag, newPackageName, newOwnerUid, newOwnerPid, newWorkSource2, newHistoryTag, newCallback);
        return;
    L6:
        r1 = new WorkSource(newWorkSource);
        goto L5
    }

    public void onWakeLockReleased(int flags, String tag, String packageName, int ownerUid, int ownerPid, WorkSource workSource, String historyTag, IWakeLockCallback callback) {
        onWakeLockReleased(flags, tag, packageName, ownerUid, ownerPid, workSource, historyTag, callback, -1);
    }

    public void onWakeLockReleased(int flags, String tag, String packageName, int ownerUid, int ownerPid, WorkSource workSource, String historyTag, IWakeLockCallback callback, int releaseReason) {
        logWakelockStateChanged(flags, tag, ownerUid, workSource, FrameworkStatsLogger.WakelockEventType.RELEASE);
        notifyWakeLockListener(callback, tag, false, ownerUid, ownerPid, flags, workSource, packageName, historyTag);
        if (this.mFlags.improveWakelockLatency() == true) goto L23;
        int monitorType = getBatteryStatsWakeLockMonitorType(flags);
        if (monitorType < 0) goto L20;
        if (workSource != null) goto L27;
        WorkSource r8 = workSource;
        this.mBatteryStats.noteStopWakelock(ownerUid, ownerPid, tag, historyTag, monitorType);     // Catch: RemoteException -> L18
        this.mAppOps.finishOp(40, ownerUid, packageName, null);     // Catch: RemoteException -> L18
    L21:
        getWakeLockLog(flags).onWakeLockReleased(tag, getUidForWakeLockLog(ownerUid, r8), -1);
        goto L23
    L27:
        this.mBatteryStats.noteStopWakelockFromSource(workSource, ownerPid, tag, historyTag, monitorType);     // Catch: RemoteException -> L11
        r8 = workSource;
    L12:
        r8 = workSource;
    L14:
        r8 = workSource;
        goto L21
    L20:
        r8 = workSource;
    L23:
        this.mWakefulnessSessionObserver.onWakeLockReleased(flags, releaseReason);
    }

    public void showDismissibleKeyguard() {
        this.mPolicy.showDismissibleKeyguard();
    }

    private int getBatteryStatsWakeLockMonitorType(int flags) {
        switch((65535 & flags)) {
            case 1: goto L14;
            case 6: goto L12;
            case 10: goto L12;
            case 26: goto L12;
            case 32: goto L9;
            case 64: goto L7;
            case 128: goto L5;
            default: goto L4;
        };
    L4:
        return -1;
    L5:
        return 18;
    L7:
        return -1;
    L12:
        return 1;
    L14:
        return 0;
    L9:
        if (this.mSuspendWhenScreenOffDueToProximityConfig == false) goto L11;
        return -1;
    L11:
        return 0;
    }

    int getWakelockMonitorTypeForLogging(int flags) {
        switch((65535 & flags)) {
            case 1: goto L14;
            case 6: goto L12;
            case 10: goto L12;
            case 26: goto L12;
            case 32: goto L9;
            case 64: goto L7;
            case 128: goto L5;
            default: goto L4;
        };
    L4:
        return -1;
    L5:
        return 128;
    L7:
        return -1;
    L12:
        return 26;
    L14:
        return 1;
    L9:
        if (this.mSuspendWhenScreenOffDueToProximityConfig == false) goto L11;
        return -1;
    L11:
        return 1;
    }

    public void onGlobalWakefulnessChangeStarted(final int wakefulness, int reason, String details, long eventTime) {
        boolean interactive = PowerManagerInternal.isInteractive(wakefulness);
        this.mHandler.post(new AnonymousClass1(this, wakefulness));
        if (this.mGlobalInteractivity.isInteractive != interactive) goto L5;
        return;
    L5:
        if (this.mGlobalInteractivity.isChanging == false) goto L7;
        handleLateGlobalInteractiveChange();
    L7:
        this.mInputMethodManagerInternal.setInteractive(interactive);
        int r2 = 0;
        if (this.mFlags.isPerDisplayWakeByTouchEnabled() == true) goto L23;
        SparseBooleanArray displayInteractivities = new SparseBooleanArray();
        int[] displayIds = this.mDisplayManagerInternal.getDisplayIds().toArray();
        int r4 = displayIds.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L12;
        int displayId = displayIds[r5];
        displayInteractivities.put(displayId, interactive);
        r5 = r5 + 1;
        goto L10
    L12:
        this.mInputManagerInternal.setDisplayInteractivities(displayInteractivities);
    L23:
        this.mBatteryStats.noteInteractive(interactive);     // Catch: RemoteException -> L15
    L18:
        if (interactive == false) goto L21;
        r2 = 1;
    L21:
        FrameworkStatsLog.write(33, r2);
        this.mGlobalInteractivity.isInteractive = interactive;
        this.mGlobalInteractivity.isChanging = true;
        this.mGlobalInteractivity.changeReason = reason;
        this.mGlobalInteractivity.changeStartTime = eventTime;
        this.mInteractiveChangeDetails = details;
        handleEarlyGlobalInteractiveChange();
    }

    public void onWakefulnessChangeFinished() {
        int i = 0;
    L4:
        if (i >= this.mInteractivityByGroupId.size()) goto L10;
        int groupId = this.mInteractivityByGroupId.keyAt(i);
        Interactivity interactivity = this.mInteractivityByGroupId.valueAt(i);
        if (interactivity.isChanging == false) goto L8;
        interactivity.isChanging = false;
        handleLateInteractiveChange(groupId);
    L8:
        i = i + 1;
        goto L4
    L10:
        if (this.mGlobalInteractivity.isChanging == false) goto L16;
        this.mGlobalInteractivity.isChanging = false;
        handleLateGlobalInteractiveChange();
        return;
    }

    private void handleEarlyInteractiveChange(final int groupId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Interactivity interactivity = this.mInteractivityByGroupId.get(groupId);     // Catch: Throwable -> L9
        if (interactivity != null) goto L11;
        Slog.e(TAG, "no Interactivity entry for groupId:" + groupId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        final int changeReason = interactivity.changeReason;     // Catch: Throwable -> L9
        if (interactivity.isInteractive == false) goto L14;
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda5(this, groupId, changeReason));     // Catch: Throwable -> L9
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda6(this, groupId, changeReason));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleEarlyInteractiveChange$0(int groupId, int changeReason) {
        this.mPolicy.startedWakingUp(groupId, changeReason);
    }

    private /* synthetic */ void lambda$handleEarlyInteractiveChange$1(int groupId, int changeReason) {
        this.mPolicy.startedGoingToSleep(groupId, changeReason);
    }

    private void handleEarlyGlobalInteractiveChange() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mGlobalInteractivity.isInteractive == false) goto L9;
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda7(this));     // Catch: Throwable -> L7
        this.mPendingInteractiveState = 1;     // Catch: Throwable -> L7
        this.mPendingWakeUpBroadcast = true;     // Catch: Throwable -> L7
        updatePendingBroadcastLocked();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda8(this));     // Catch: Throwable -> L7
        goto L10
    }

    private /* synthetic */ void lambda$handleEarlyGlobalInteractiveChange$2() {
        this.mDisplayManagerInternal.onEarlyInteractivityChange(true);
        this.mPolicy.startedWakingUpGlobal(this.mGlobalInteractivity.changeReason);
    }

    private /* synthetic */ void lambda$handleEarlyGlobalInteractiveChange$3() {
        this.mDisplayManagerInternal.onEarlyInteractivityChange(false);
        this.mPolicy.startedGoingToSleepGlobal(this.mGlobalInteractivity.changeReason);
    }

    private void handleLateGlobalInteractiveChange() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        final int interactiveChangeLatency = (int) (SystemClock.uptimeMillis() - this.mGlobalInteractivity.changeStartTime);     // Catch: Throwable -> L7
        if (this.mGlobalInteractivity.isInteractive == false) goto L10;
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda0(this, interactiveChangeLatency));     // Catch: Throwable -> L7
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        if (this.mUserActivityPending == false) goto L12;
        this.mUserActivityPending = false;     // Catch: Throwable -> L7
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L7
    L12:
        final int offReason = WindowManagerPolicyConstants.translateSleepReasonToOffReason(this.mGlobalInteractivity.changeReason);     // Catch: Throwable -> L7
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda1(this, offReason, interactiveChangeLatency));     // Catch: Throwable -> L7
        this.mPendingInteractiveState = 2;     // Catch: Throwable -> L7
        this.mPendingGoToSleepBroadcast = true;     // Catch: Throwable -> L7
        updatePendingBroadcastLocked();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleLateGlobalInteractiveChange$4(int interactiveChangeLatency) {
        LogMaker log = new LogMaker(FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__SET_USB_DATA_SIGNALING);
        log.setType(1);
        log.setSubtype(WindowManagerPolicyConstants.translateWakeReasonToOnReason(this.mGlobalInteractivity.changeReason));
        log.setLatency(interactiveChangeLatency);
        log.addTaggedData(1694, Integer.valueOf(this.mGlobalInteractivity.changeReason));
        MetricsLogger.action(log);
        EventLogTags.writePowerScreenState(1, 0, 0, 0, interactiveChangeLatency);
        this.mPolicy.finishedWakingUpGlobal(this.mGlobalInteractivity.changeReason);
    }

    private /* synthetic */ void lambda$handleLateGlobalInteractiveChange$5(int offReason, int interactiveChangeLatency) {
        LogMaker log = new LogMaker(FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__SET_USB_DATA_SIGNALING);
        log.setType(2);
        log.setSubtype(offReason);
        log.setLatency(interactiveChangeLatency);
        log.addTaggedData(1695, Integer.valueOf(this.mGlobalInteractivity.changeReason));
        MetricsLogger.action(log);
        EventLogTags.writePowerScreenState(0, offReason, 0, 0, interactiveChangeLatency);
        this.mPolicy.finishedGoingToSleepGlobal(this.mGlobalInteractivity.changeReason);
    }

    private void handleLateInteractiveChange(final int groupId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Interactivity interactivity = this.mInteractivityByGroupId.get(groupId);     // Catch: Throwable -> L9
        if (interactivity != null) goto L11;
        Slog.e(TAG, "no Interactivity entry for groupId:" + groupId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        final int changeReason = interactivity.changeReason;     // Catch: Throwable -> L9
        if (interactivity.isInteractive == false) goto L14;
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda9(this, groupId, changeReason));     // Catch: Throwable -> L9
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda10(this, groupId, changeReason));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleLateInteractiveChange$6(int groupId, int changeReason) {
        this.mPolicy.finishedWakingUp(groupId, changeReason);
    }

    private /* synthetic */ void lambda$handleLateInteractiveChange$7(int groupId, int changeReason) {
        this.mPolicy.finishedGoingToSleep(groupId, changeReason);
    }

    private void updateDisplayInteractivities(int groupId, boolean interactive) {
        int[] displayIds = this.mDisplayManagerInternal.getDisplayIdsForGroup(groupId);
        int r1 = displayIds.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int displayId = displayIds[r2];
        this.mDisplayInteractivities.put(displayId, interactive);
        r2 = r2 + 1;
        goto L3
    }

    private void resetDisplayInteractivities() {
        SparseArray<int[]> displaysByGroupId = this.mDisplayManagerInternal.getDisplayIdsByGroupsIds();
        SparseBooleanArray newDisplayInteractivities = new SparseBooleanArray();
        int i = 0;
    L4:
        if (i >= displaysByGroupId.size()) goto L21;
        int groupId = displaysByGroupId.keyAt(i);
        int[] r4 = displaysByGroupId.get(groupId);
        int r5 = r4.length;
        int r7 = 0;
    L7:
        if (r7 >= r5) goto L20;
        int displayId = r4[r7];
        if (this.mDisplayInteractivities.indexOfKey(displayId) <= 0) goto L11;
        newDisplayInteractivities.put(displayId, this.mDisplayInteractivities.get(displayId));
    L19:
        r7 = r7 + 1;
        goto L7
    L11:
        Interactivity groupInteractivity = this.mInteractivityByGroupId.get(groupId);
        if (groupInteractivity != null) goto L14;
    L17:
        boolean groupInteractive = true;
    L18:
        newDisplayInteractivities.put(displayId, groupInteractive);
        goto L19
    L14:
        if (groupInteractivity.isInteractive == true) goto L17;
        groupInteractive = false;
        goto L18
    L20:
        i = i + 1;
        goto L4
    L21:
        this.mDisplayInteractivities = newDisplayInteractivities;
    }

    public void onGroupWakefulnessChangeStarted(int groupId, int wakefulness, int changeReason, long eventTime) {
        boolean isInteractive = PowerManagerInternal.isInteractive(wakefulness);
        boolean isNewGroup = false;
        Interactivity interactivity = this.mInteractivityByGroupId.get(groupId);
        if (interactivity != null) goto L5;
        isNewGroup = true;
        interactivity = new Interactivity(null);
        this.mInteractivityByGroupId.put(groupId, interactivity);
    L5:
        if (isNewGroup == true) goto L11;
        if (interactivity.isInteractive != isInteractive) goto L11;
        return;
    L11:
        if (interactivity.isChanging == false) goto L13;
        handleLateInteractiveChange(groupId);
    L13:
        interactivity.isInteractive = isInteractive;
        interactivity.changeReason = changeReason;
        interactivity.changeStartTime = eventTime;
        interactivity.isChanging = true;
        handleEarlyInteractiveChange(groupId);
        this.mWakefulnessSessionObserver.onWakefulnessChangeStarted(groupId, wakefulness, changeReason, eventTime);
        if (this.mFlags.isPerDisplayWakeByTouchEnabled() == false) goto L18;
        updateDisplayInteractivities(groupId, isInteractive);
        this.mInputManagerInternal.setDisplayInteractivities(this.mDisplayInteractivities);
        return;
    }

    public void onGroupRemoved(int groupId) {
        this.mInteractivityByGroupId.remove(groupId);
        this.mWakefulnessSessionObserver.removePowerGroup(groupId);
        if (this.mFlags.isPerDisplayWakeByTouchEnabled() == false) goto L6;
        resetDisplayInteractivities();
        this.mInputManagerInternal.setDisplayInteractivities(this.mDisplayInteractivities);
        return;
    }

    public void onGroupChanged() {
        if (this.mFlags.isPerDisplayWakeByTouchEnabled() == false) goto L6;
        resetDisplayInteractivities();
        this.mInputManagerInternal.setDisplayInteractivities(this.mDisplayInteractivities);
        return;
    }

    public void onUserActivity(int displayGroupId, int event, int uid) {
        this.mBatteryStats.noteUserActivity(uid, event);     // Catch: RemoteException -> L4
        this.mWakefulnessSessionObserver.notifyUserActivity(SystemClock.uptimeMillis(), displayGroupId, event);     // Catch: RemoteException -> L4
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mUserActivityPending == true) goto L12;
        this.mUserActivityPending = true;     // Catch: Throwable -> L10
        Message msg = this.mHandler.obtainMessage(1);     // Catch: Throwable -> L10
        msg.arg1 = displayGroupId;     // Catch: Throwable -> L10
        msg.arg2 = event;     // Catch: Throwable -> L10
        msg.setAsynchronous(true);     // Catch: Throwable -> L10
        this.mHandler.sendMessage(msg);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public void onWakeUp(int reason, String details, int reasonUid, String opPackageName, int opUid) {
        this.mBatteryStats.noteWakeUp(details, reasonUid);     // Catch: RemoteException -> L6
        if (opPackageName == null) goto L9;
        this.mAppOps.noteOpNoThrow(61, opUid, opPackageName);     // Catch: RemoteException -> L6
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.DISPLAY_WAKE_REPORTED, reason, reasonUid);
    }

    public void onProfileTimeout(int userId) {
        Message msg = this.mHandler.obtainMessage(5);
        msg.setAsynchronous(true);
        msg.arg1 = userId;
        this.mHandler.sendMessage(msg);
    }

    public void onWirelessChargingStarted(int batteryLevel, int userId) {
        this.mSuspendBlocker.acquire();
        Message msg = this.mHandler.obtainMessage(3);
        msg.setAsynchronous(true);
        msg.arg1 = batteryLevel;
        msg.arg2 = userId;
        this.mHandler.sendMessage(msg);
    }

    public void onWiredChargingStarted(int userId) {
        this.mSuspendBlocker.acquire();
        Message msg = this.mHandler.obtainMessage(6);
        msg.setAsynchronous(true);
        msg.arg1 = userId;
        this.mHandler.sendMessage(msg);
    }

    public void onScreenPolicyUpdate(int displayGroupId, int newPolicy) {
        this.mWakefulnessSessionObserver.onScreenPolicyUpdate(SystemClock.uptimeMillis(), displayGroupId, newPolicy);
        Object r0 = this.mLock;
        monitor-enter(r0);
        Message msg = this.mHandler.obtainMessage(7);     // Catch: Throwable -> L7
        msg.arg1 = displayGroupId;     // Catch: Throwable -> L7
        msg.arg2 = newPolicy;     // Catch: Throwable -> L7
        msg.setAsynchronous(true);     // Catch: Throwable -> L7
        this.mHandler.sendMessage(msg);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        pw.println("Notifier:");
        PrintWriter r0 = new IndentingPrintWriter(pw, "  ");
        r0.println("Partial Wakelock Log:");
        this.mPartialWakeLockLog.dump(r0);
        r0.println("");
        r0.println("Full Wakelock Log:");
        this.mFullWakeLockLog.dump(r0);
        r0.println("");
        this.mWakefulnessSessionObserver.dump(r0);
    }

    private void updatePendingBroadcastLocked() {
        if (this.mBroadcastInProgress == false) goto L5;
        return;
    L5:
        if (this.mPendingInteractiveState != 0) goto L7;
        return;
    L7:
        if (this.mPendingWakeUpBroadcast == false) goto L9;
    L12:
        this.mBroadcastInProgress = true;
        this.mSuspendBlocker.acquire();
        Message msg = this.mHandler.obtainMessage(2);
        msg.setAsynchronous(true);
        this.mHandler.sendMessage(msg);
        return;
    L9:
        if (this.mPendingGoToSleepBroadcast == true) goto L12;
        if (this.mPendingInteractiveState != this.mBroadcastedInteractiveState) goto L12;
    }

    private void finishPendingBroadcastLocked() {
        this.mBroadcastInProgress = false;
        this.mSuspendBlocker.release();
    }

    private void sendUserActivity(int displayGroupId, int event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserActivityPending == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mUserActivityPending = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        TelephonyManager tm = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        tm.notifyUserActivity();
        this.mInputManagerInternal.notifyUserActivity();
        this.mPolicy.userActivity(displayGroupId, event);
        this.mFaceDownDetector.userActivity(event);
        this.mScreenUndimDetector.userActivity(displayGroupId);
    }

    void postEnhancedDischargePredictionBroadcast(long delayMs) {
        this.mHandler.sendEmptyMessageDelayed(4, delayMs);
    }

    private void sendEnhancedDischargePredictionBroadcast() {
        Intent intent = new Intent("android.os.action.ENHANCED_DISCHARGE_PREDICTION_CHANGED").addFlags(1073741824);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL);
    }

    private void sendNextBroadcast() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mBroadcastedInteractiveState != 0) goto L13;
        switch(this.mPendingInteractiveState) {
            case 2: goto L11;
            default: goto L8;
        };     // Catch: Throwable -> L9
    L8:
        this.mPendingWakeUpBroadcast = false;     // Catch: Throwable -> L9
        this.mBroadcastedInteractiveState = 1;     // Catch: Throwable -> L9
    L36:
        this.mBroadcastStartTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        int powerState = this.mBroadcastedInteractiveState;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        EventLog.writeEvent(EventLogTags.POWER_SCREEN_BROADCAST_SEND, 1);
        if (powerState != 1) goto L41;
        sendWakeUpBroadcast();
        return;
    L41:
        sendGoToSleepBroadcast();
        return;
    L11:
        this.mPendingGoToSleepBroadcast = false;     // Catch: Throwable -> L9
        this.mBroadcastedInteractiveState = 2;     // Catch: Throwable -> L9
        goto L36
    L13:
        if (this.mBroadcastedInteractiveState != 1) goto L26;
        if (this.mPendingWakeUpBroadcast == true) goto L24;
        if (this.mPendingGoToSleepBroadcast == true) goto L24;
        if (this.mPendingInteractiveState == 2) goto L24;
        finishPendingBroadcastLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L24:
        this.mPendingGoToSleepBroadcast = false;     // Catch: Throwable -> L9
        this.mBroadcastedInteractiveState = 2;     // Catch: Throwable -> L9
        goto L36
    L26:
        if (this.mPendingWakeUpBroadcast == true) goto L35;
        if (this.mPendingGoToSleepBroadcast == true) goto L35;
        if (this.mPendingInteractiveState == 1) goto L35;
        finishPendingBroadcastLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L35:
        this.mPendingWakeUpBroadcast = false;     // Catch: Throwable -> L9
        this.mBroadcastedInteractiveState = 1;     // Catch: Throwable -> L9
        goto L36
    }

    private void sendWakeUpBroadcast() {
        if (this.mActivityManagerInternal.isSystemReady() == false) goto L5;
        String wakeupReason = wakeupReasonToReportString(this.mGlobalInteractivity.changeReason, this.mInteractiveChangeDetails);
        this.mScreenOnIntent.putExtra(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY, wakeupReason);
        this.mActivityManagerInternal.broadcastIntentWithCallback(this.mScreenOnIntent, this.mWakeUpBroadcastDone, null, -1, null, null, this.mScreenOnOffOptions);
        return;
    L5:
        EventLog.writeEvent(EventLogTags.POWER_SCREEN_BROADCAST_STOP, new Object[]{2, 1});
        sendNextBroadcast();
    }

    private void sendGoToSleepBroadcast() {
        if (this.mActivityManagerInternal.isSystemReady() == false) goto L5;
        String sleepReason = sleepReasonToReportString(this.mGlobalInteractivity.changeReason, this.mInteractiveChangeDetails);
        this.mScreenOffIntent.putExtra(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY, sleepReason);
        this.mActivityManagerInternal.broadcastIntentWithCallback(this.mScreenOffIntent, this.mGoToSleepBroadcastDone, null, -1, null, null, this.mScreenOnOffOptions);
        return;
    L5:
        EventLog.writeEvent(EventLogTags.POWER_SCREEN_BROADCAST_STOP, new Object[]{3, 1});
        sendNextBroadcast();
    }

    private void playChargingStartedFeedback(final int userId, final boolean wireless) {
        if (isChargingFeedbackEnabled(userId) == true) goto L6;
        return;
    L6:
        if (this.mIsPlayingChargingStartedFeedback.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        this.mBackgroundExecutor.execute(new Notifier$$ExternalSyntheticLambda4(this, userId, wireless));
    }

    private /* synthetic */ void lambda$playChargingStartedFeedback$8(int userId, boolean wireless) {
        boolean vibrate = true;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "charging_vibration_enabled", 1, userId) != 0) goto L6;
        vibrate = false;
    L6:
        if (vibrate == false) goto L8;
        this.mVibrator.vibrate(1000, this.mContext.getOpPackageName(), CHARGING_VIBRATION_EFFECT, "Charging started", HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES);
    L8:
        ContentResolver r0 = this.mContext.getContentResolver();
        if (wireless == false) goto L11;
        String r3 = "wireless_charging_started_sound";
    L12:
        String soundPath = Settings.Global.getString(r0, r3);
        Uri soundUri = Uri.parse("file://" + soundPath);
        if (soundUri == null) goto L17;
        Ringtone sfx = RingtoneManager.getRingtone(this.mContext, soundUri);
        if (sfx == null) goto L17;
        sfx.setStreamType(5);
        sfx.play();
    L17:
        this.mIsPlayingChargingStartedFeedback.set(false);
        return;
    L11:
        r3 = "charging_started_sound";
        goto L12
    }

    private void showWirelessChargingStarted(int batteryLevel, int userId) {
        playChargingStartedFeedback(userId, true);
        if (this.mShowWirelessChargingAnimationConfig == true) goto L5;
    L7:
        this.mSuspendBlocker.release();
        return;
    L5:
        if (this.mStatusBarManagerInternal == null) goto L7;
        this.mStatusBarManagerInternal.showChargingAnimation(batteryLevel);
        goto L7
    }

    private void showWiredChargingStarted(int userId) {
        playChargingStartedFeedback(userId, false);
        this.mSuspendBlocker.release();
    }

    private void screenPolicyChanging(int displayGroupId, int screenPolicy) {
        this.mScreenUndimDetector.recordScreenPolicy(displayGroupId, screenPolicy);
    }

    private void lockProfile(int userId) {
        this.mTrustManager.setDeviceLockedForUser(userId, true);
    }

    private boolean isChargingFeedbackEnabled(int userId) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "charging_sounds_enabled", 1, userId) == 0) goto L5;
        boolean enabled = true;
    L7:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "zen_mode", 1) != 0) goto L9;
        boolean dndOff = true;
    L10:
        if (enabled == false) goto L14;
        if (dndOff == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        dndOff = false;
        goto L10
    L5:
        enabled = false;
        goto L7
    }

    private void notifyWakeLockListener(final IWakeLockCallback callback, final String tag, final boolean isEnabled, final int ownerUid, final int ownerPid, final int flags, final WorkSource workSource, final String packageName, final String historyTag) {
        final long currentTime = this.mInjector.currentTimeMillis();
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda2(this, isEnabled, tag, ownerUid, ownerPid, flags, workSource, packageName, historyTag, currentTime, callback));
    }

    private /* synthetic */ void lambda$notifyWakeLockListener$9(boolean isEnabled, String tag, int ownerUid, int ownerPid, int flags, WorkSource workSource, String packageName, String historyTag, long currentTime, IWakeLockCallback callback) {
        if (this.mFlags.improveWakelockLatency() == false) goto L7;
        if (isEnabled == false) goto L6;
        notifyWakelockAcquisition(tag, ownerUid, ownerPid, flags, workSource, packageName, historyTag, currentTime);
        goto L7
    L6:
        notifyWakelockRelease(tag, ownerUid, ownerPid, flags, workSource, packageName, historyTag, currentTime);
    L7:
        if (callback == null) goto L15;
        callback.onStateChanged(isEnabled);     // Catch: RemoteException -> L10
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "Wakelock.mCallback [" + tag + "] is already dead.", e);
        return;
    }

    private void notifyWakelockAcquisition(String tag, int ownerUid, int ownerPid, int flags, WorkSource workSource, String packageName, String historyTag, long currentTime) {
        int monitorType = getBatteryStatsWakeLockMonitorType(flags);
        if (monitorType >= 0) goto L5;
        WorkSource r11 = workSource;
        int r8 = ownerUid;
    L35:
        getWakeLockLog(flags).onWakeLockAcquired(tag, getUidForWakeLockLog(r8, r11), flags, currentTime);
        return;
    L5:
        if (ownerUid == 1000) goto L7;
    L10:
        boolean r0 = false;
    L9:
        boolean unimportantForLogging = r0;
        if (workSource != null) goto L39;
        r11 = workSource;
        this.mBatteryStats.noteStartWakelock(ownerUid, ownerPid, tag, historyTag, monitorType, unimportantForLogging);     // Catch: RemoteException -> L32
        this.mAppOps.startOpNoThrow(40, ownerUid, packageName, false, null, null);     // Catch: RemoteException -> L28
        r8 = ownerUid;
    L29:
        r8 = ownerUid;
    L31:
        r8 = ownerUid;
    L33:
        r8 = ownerUid;
        goto L35
    L39:
        r11 = workSource;
        this.mBatteryStats.noteStartWakelockFromSource(r11, ownerPid, tag, historyTag, monitorType, unimportantForLogging);     // Catch: RemoteException -> L16
        r8 = ownerUid;
    L17:
        r8 = ownerUid;
    L19:
        r11 = workSource;
        r8 = ownerUid;
        goto L35
    L7:
        if ((1073741824 & flags) == 0) goto L10;
        r0 = true;
        goto L9
    }

    private void notifyWakelockRelease(String tag, int ownerUid, int ownerPid, int flags, WorkSource workSource, String packageName, String historyTag, long currentTime) {
        int monitorType = getBatteryStatsWakeLockMonitorType(flags);
        if (monitorType < 0) goto L22;
        if (workSource != null) goto L27;
        String tag2 = tag;
        WorkSource workSource2 = workSource;
        int ownerUid2 = ownerUid;
        this.mBatteryStats.noteStopWakelock(ownerUid2, ownerPid, tag2, historyTag, monitorType);     // Catch: RemoteException -> L18
        this.mAppOps.finishOp(40, ownerUid2, packageName, null);     // Catch: RemoteException -> L18
    L23:
        getWakeLockLog(flags).onWakeLockReleased(tag2, getUidForWakeLockLog(ownerUid2, workSource2), currentTime);
        return;
    L21:
        ownerUid2 = ownerUid;
        goto L23
    L27:
        tag2 = tag;
        this.mBatteryStats.noteStopWakelockFromSource(workSource, ownerPid, tag2, historyTag, monitorType);     // Catch: RemoteException -> L9
        workSource2 = workSource;
        ownerUid2 = ownerUid;
    L10:
        workSource2 = workSource;
        ownerUid2 = ownerUid;
    L12:
        tag2 = tag;
        workSource2 = workSource;
        ownerUid2 = ownerUid;
        goto L23
    L22:
        tag2 = tag;
        ownerUid2 = ownerUid;
        workSource2 = workSource;
        goto L23
    }

    private void notifyWakelockChanging(final WorkSource workSource, final int ownerPid, final String tag, final String historyTag, final int monitorType, final WorkSource newWorkSource, final int newOwnerPid, final String newTag, final String newHistoryTag, final int newMonitorType, final boolean unimportantForLogging) throws RemoteException {
        if (this.mFlags.improveWakelockLatency() == true) goto L5;
        this.mBatteryStats.noteChangeWakelockFromSource(workSource, ownerPid, tag, historyTag, monitorType, newWorkSource, newOwnerPid, newTag, newHistoryTag, newMonitorType, unimportantForLogging);
        return;
    L5:
        this.mHandler.post(new Notifier$$ExternalSyntheticLambda3(this, workSource, ownerPid, tag, historyTag, monitorType, newWorkSource, newOwnerPid, newTag, newHistoryTag, newMonitorType, unimportantForLogging));
    }

    private /* synthetic */ void lambda$notifyWakelockChanging$10(WorkSource workSource, int ownerPid, String tag, String historyTag, int monitorType, WorkSource newWorkSource, int newOwnerPid, String newTag, String newHistoryTag, int newMonitorType, boolean unimportantForLogging) {
        this.mBatteryStats.noteChangeWakelockFromSource(workSource, ownerPid, tag, historyTag, monitorType, newWorkSource, newOwnerPid, newTag, newHistoryTag, newMonitorType, unimportantForLogging);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to notify the wakelock changing from source via Notifier." + e.getLocalizedMessage());
    }

    void addScreenTimeoutPolicyListener(int displayId, int screenTimeoutPolicy, IScreenTimeoutPolicyListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ScreenTimeoutPolicyListenersContainer listenersContainer = this.mScreenTimeoutPolicyListeners.get(displayId);     // Catch: Throwable -> L7
        if (listenersContainer != null) goto L9;
        listenersContainer = new ScreenTimeoutPolicyListenersContainer(this, screenTimeoutPolicy);     // Catch: Throwable -> L7
        this.mScreenTimeoutPolicyListeners.set(displayId, listenersContainer);     // Catch: Throwable -> L7
    L9:
        listenersContainer.addListener(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeScreenTimeoutPolicyListener(int displayId, IScreenTimeoutPolicyListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ScreenTimeoutPolicyListenersContainer listenersContainer = this.mScreenTimeoutPolicyListeners.get(displayId);     // Catch: Throwable -> L8
        if (listenersContainer != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        listenersContainer.removeListener(listener);     // Catch: Throwable -> L8
        if (listenersContainer.isEmpty() == false) goto L13;
        this.mScreenTimeoutPolicyListeners.remove(displayId);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void clearScreenTimeoutPolicyListeners(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mScreenTimeoutPolicyListeners.remove(displayId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void notifyScreenTimeoutPolicyChanges(int displayGroupId, int screenTimeoutPolicy) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int idx = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (idx >= this.mScreenTimeoutPolicyListeners.size()) goto L14;
        int displayId = this.mScreenTimeoutPolicyListeners.keyAt(idx);     // Catch: Throwable -> L10
        if (this.mDisplayManagerInternal.getGroupIdForDisplay(displayId) != displayGroupId) goto L12;
        ScreenTimeoutPolicyListenersContainer container = this.mScreenTimeoutPolicyListeners.valueAt(idx);     // Catch: Throwable -> L10
        container.updateScreenTimeoutPolicyAndNotifyIfNeeded(screenTimeoutPolicy);     // Catch: Throwable -> L10
    L12:
        idx = idx + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private WakeLockLog getWakeLockLog(int flags) {
        if (PowerManagerService.isScreenLock(flags) == false) goto L6;
        return this.mFullWakeLockLog;
    L6:
        return this.mPartialWakeLockLog;
    }

    private int getUidForWakeLockLog(int ownerUid, WorkSource workSource) {
        if (workSource == null) goto L5;
        int attributionUid = workSource.getAttributionUid();
    L6:
        if (attributionUid == (-1)) goto L9;
        return attributionUid;
    L9:
        return ownerUid;
    L5:
        attributionUid = -1;
        goto L6
    }

    private void logWakelockStateChanged(int flags, String tag, int ownerUid, WorkSource workSource, FrameworkStatsLogger.WakelockEventType eventType) {
        if (this.mBatteryStatsInternal != null) goto L5;
        return;
    L5:
        int type = getWakelockMonitorTypeForLogging(flags);
        if (workSource != null) goto L8;
    L24:
        int mappedUid = this.mBatteryStatsInternal.getOwnerUid(ownerUid);
        this.mFrameworkStatsLogger.wakelockStateChanged(mappedUid, tag, type, eventType);
        return;
    L8:
        if (workSource.isEmpty() == true) goto L24;
        int i = 0;
    L12:
        if (i >= workSource.size()) goto L14;
        int mappedUid2 = this.mBatteryStatsInternal.getOwnerUid(workSource.getUid(i));
        this.mFrameworkStatsLogger.wakelockStateChanged(mappedUid2, tag, type, eventType);
        i = i + 1;
        goto L12
    L14:
        List<WorkSource.WorkChain> workChains = workSource.getWorkChains();
        if (workChains == null) goto L29;
        Iterator<WorkSource.WorkChain> r2 = workChains.iterator();
    L18:
        if (r2.hasNext() == false) goto L30;
        WorkSource.WorkChain workChain = r2.next();
        WorkSource.WorkChain mappedWorkChain = new WorkSource.WorkChain();
        int[] uids = workChain.getUids();
        String[] tags = workChain.getTags();
        int i2 = 0;
    L21:
        if (i2 >= workChain.getSize()) goto L23;
        int mappedUid3 = this.mBatteryStatsInternal.getOwnerUid(uids[i2]);
        mappedWorkChain.addNode(mappedUid3, tags[i2]);
        i2 = i2 + 1;
        goto L21
    L23:
        this.mFrameworkStatsLogger.wakelockStateChanged(tag, mappedWorkChain, type, eventType);
        goto L18
    L30:
        return;
    }

    private String wakeupReasonToReportString(int reason, String details) {
        if ("obric.pickup.wakeup".equals(details) == false) goto L7;
        return "handup";
    L7:
        switch(reason) {
            case 0: goto L11;
            case 1: goto L9;
            default: goto L8;
        };
    L8:
        return "unknown";
    L9:
        return "powerkey";
    L11:
        return "unknown";
    }

    private String sleepReasonToReportString(int reason, String details) {
        switch(reason) {
            case 2: goto L7;
            case 3: goto L3;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "powerkey";
    L7:
        return "timeout";
    }
}
