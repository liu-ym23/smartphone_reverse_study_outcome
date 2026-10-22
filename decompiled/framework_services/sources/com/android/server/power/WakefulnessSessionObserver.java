package com.android.server.power;

import android.R;
import android.app.ActivityManager;
import android.app.SynchronousUserSwitchObserver;
import android.content.ContentResolver;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.net.Uri;
import android.os.Handler;
import android.os.PowerManagerInternal;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.view.DisplayInfo;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.am.ProcessList;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class WakefulnessSessionObserver {
    static final int DEFAULT_USER_ACTIVITY = 0;
    static final Object HANDLER_TOKEN = null;
    static final int OFF_REASON_POWER_BUTTON = 2;
    static final int OFF_REASON_TIMEOUT = 1;
    static final int OFF_REASON_UNKNOWN = 0;
    static final int OVERRIDE_OUTCOME_CANCEL_CLIENT_API_CALL = 3;
    static final int OVERRIDE_OUTCOME_CANCEL_CLIENT_DISCONNECT = 6;
    static final int OVERRIDE_OUTCOME_CANCEL_OTHER = 7;
    static final int OVERRIDE_OUTCOME_CANCEL_POWER_BUTTON = 5;
    static final int OVERRIDE_OUTCOME_CANCEL_USER_INTERACTION = 4;
    static final int OVERRIDE_OUTCOME_TIMEOUT_SUCCESS = 1;
    static final int OVERRIDE_OUTCOME_TIMEOUT_USER_INITIATED_REVERT = 2;
    static final int OVERRIDE_OUTCOME_UNKNOWN = 0;
    static final int POLICY_REASON_BRIGHT_INITIATED_REVERT = 4;
    static final int POLICY_REASON_BRIGHT_UNDIM = 3;
    static final int POLICY_REASON_OFF_POWER_BUTTON = 2;
    static final int POLICY_REASON_OFF_TIMEOUT = 1;
    static final int POLICY_REASON_UNKNOWN = 0;
    static final long SCREEN_POLICY_DIM_POWER_OFF_BRIGHT_THRESHOLD_MILLIS = 500;
    static final long SEND_OVERRIDE_TIMEOUT_LOG_THRESHOLD_MILLIS = 1000;
    private static final String TAG = "WakefulnessSessionObserver";
    static final long USER_INITIATED_REVERT_THRESHOLD_MILLIS = 5000;
    private final Clock mClock;
    private Context mContext;
    private DisplayManagerInternal mDisplayManagerInternal;
    private final Handler mHandler;
    private final Object mLock;
    private int mOverrideTimeoutMs;
    private int mPhysicalDisplayPortIdForDefaultDisplay;
    final SparseArray<WakefulnessSessionPowerGroup> mPowerGroups;
    private int mScreenOffTimeoutMs;
    WakefulnessSessionFrameworkStatsLogger mWakefulnessSessionFrameworkStatsLogger;

    interface Clock {
        long uptimeMillis();
    }

    static class Injector {
        Injector() {
        }

        WakefulnessSessionFrameworkStatsLogger getWakefulnessSessionFrameworkStatsLogger() {
            return new WakefulnessSessionFrameworkStatsLogger();
        }

        Clock getClock() {
            return new WakefulnessSessionObserver$Injector$$ExternalSyntheticLambda0();
        }

        Handler getHandler() {
            return BackgroundThread.getHandler();
        }

        DisplayManagerInternal getDisplayManagerInternal() {
            return (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface OffReason {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface OverrideOutcome {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface PolicyReason {
    }

    private final class UserSwitchObserver extends SynchronousUserSwitchObserver {
        final /* synthetic */ WakefulnessSessionObserver this$0;

        /* synthetic */ UserSwitchObserver(WakefulnessSessionObserver r1, WakefulnessSessionObserverIA r2) {
            this(r1);
        }

        private UserSwitchObserver(WakefulnessSessionObserver r1) {
            this.this$0 = r1;
        }

        public void onUserSwitching(int newUserId) throws RemoteException {
            this.this$0.updateSettingScreenOffTimeout(WakefulnessSessionObserver.m7610$$Nest$fgetmContext(this.this$0));
        }
    }

    protected static class WakefulnessSessionFrameworkStatsLogger {
        private static final int USER_ACTIVITY_ACCESSIBILITY = 3;
        private static final int USER_ACTIVITY_ATTENTION = 4;
        private static final int USER_ACTIVITY_BUTTON = 1;
        private static final int USER_ACTIVITY_DEVICE_STATE = 6;
        private static final int USER_ACTIVITY_FACE_DOWN = 5;
        private static final int USER_ACTIVITY_OTHER = 0;
        private static final int USER_ACTIVITY_TOUCH = 2;

        @Retention(RetentionPolicy.SOURCE)
        private @interface UserActivityEvent {
        }

        protected WakefulnessSessionFrameworkStatsLogger() {
        }

        public void logSessionEvent(int powerGroupId, int interactiveStateOffReason, long interactiveStateOnDurationMs, int userActivityEvent, long lastUserActivityEventDurationMs, int reducedInteractiveStateOnDurationMs) {
            int logUserActivityEvent = convertToLogUserActivityEvent(userActivityEvent);
            FrameworkStatsLog.write(FrameworkStatsLog.SCREEN_INTERACTIVE_SESSION_REPORTED, powerGroupId, interactiveStateOffReason, interactiveStateOnDurationMs, logUserActivityEvent, lastUserActivityEventDurationMs, reducedInteractiveStateOnDurationMs);
        }

        public void logTimeoutOverrideEvent(int powerGroupId, int overrideOutcome, int overrideTimeoutMs, int defaultTimeoutMs) {
            FrameworkStatsLog.write(FrameworkStatsLog.SCREEN_TIMEOUT_OVERRIDE_REPORTED, powerGroupId, overrideOutcome, overrideTimeoutMs, defaultTimeoutMs);
        }

        public void logDimEvent(int physicalDisplayPortId, int policyReason, int userActivityEvent, int lastUserActivityEventDurationMs, int dimDurationMs, int defaultTimeoutMs) {
            int logUserActivityEvent = convertToLogUserActivityEvent(userActivityEvent);
            FrameworkStatsLog.write(FrameworkStatsLog.SCREEN_DIM_REPORTED, physicalDisplayPortId, policyReason, logUserActivityEvent, lastUserActivityEventDurationMs, dimDurationMs, defaultTimeoutMs);
        }

        private int convertToLogUserActivityEvent(int userActivity) {
            switch(userActivity) {
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L9;
                case 5: goto L7;
                case 6: goto L5;
                default: goto L4;
            };
        L4:
            return 0;
        L5:
            return 6;
        L7:
            return 5;
        L9:
            return 4;
        L11:
            return 3;
        L13:
            return 2;
        L15:
            return 1;
        L17:
            return 0;
        }
    }

    protected class WakefulnessSessionPowerGroup {
        private static final long TIMEOUT_OFF_RESET_TIMESTAMP = -1;
        private int mCurrentScreenPolicy;
        private long mCurrentScreenPolicyTimestamp;
        protected int mCurrentUserActivityEvent;
        protected long mCurrentUserActivityTimestamp;
        private int mCurrentWakefulness;
        private long mInteractiveOffTimestamp;
        private long mInteractiveStateOnStartTimestamp;
        protected boolean mIsInteractive;
        protected int mPastDimDurationMs;
        private int mPowerGroupId;
        private int mPrevScreenPolicy;
        private int mPrevScreenPolicyDurationMs;
        protected int mPrevUserActivityEvent;
        protected long mPrevUserActivityTimestamp;
        private long mSendOverrideTimeoutLogTimestamp;
        private long mTimeoutOffTimestamp;
        private int mTimeoutOverrideReleaseReason;
        private int mTimeoutOverrideWakeLockCounter;
        final /* synthetic */ WakefulnessSessionObserver this$0;

        /* JADX INFO: renamed from: $r8$lambda$KmXu3QokAZYu-qVjwdvvOaylSoE, reason: not valid java name */
        public static /* synthetic */ void m7618$r8$lambda$KmXu3QokAZYuqVjwdvvOaylSoE(WakefulnessSessionPowerGroup r0, int r1, int r2, int r3, int r4, int r5) {
            r0.lambda$checkAndLogDimIfQualified$0(r1, r2, r3, r4, r5);
        }

        public WakefulnessSessionPowerGroup(WakefulnessSessionObserver this$0, int powerGroupId) {
            this.this$0 = this$0;
            this.mIsInteractive = false;
            this.mTimeoutOverrideWakeLockCounter = 0;
            this.mCurrentUserActivityEvent = 0;
            this.mCurrentUserActivityTimestamp = -1;
            this.mPrevUserActivityEvent = 0;
            this.mPrevUserActivityTimestamp = -1;
            this.mPowerGroupId = powerGroupId;
            this.mPrevScreenPolicy = 3;
            this.mCurrentScreenPolicy = 3;
            this.mCurrentScreenPolicyTimestamp = 0;
            this.mPrevScreenPolicyDurationMs = 0;
            this.mPastDimDurationMs = 0;
        }

        public void notifyUserActivity(long eventTime, int event) {
            if (event != this.mCurrentUserActivityEvent) goto L5;
            return;
        L5:
            this.mPrevUserActivityEvent = this.mCurrentUserActivityEvent;
            this.mCurrentUserActivityEvent = event;
            this.mPrevUserActivityTimestamp = this.mCurrentUserActivityTimestamp;
            this.mCurrentUserActivityTimestamp = eventTime;
        }

        public void onScreenPolicyUpdate(long eventTime, int newPolicy) {
            if (newPolicy != this.mCurrentScreenPolicy) goto L6;
            return;
        L6:
            if (newPolicy != 3) goto L8;
            checkAndLogDimIfQualified(3, eventTime);
        L8:
            this.mPrevScreenPolicy = this.mCurrentScreenPolicy;
            this.mCurrentScreenPolicy = newPolicy;
            this.mPrevScreenPolicyDurationMs = (int) (eventTime - this.mCurrentScreenPolicyTimestamp);
            this.mCurrentScreenPolicyTimestamp = eventTime;
        }

        public void onWakefulnessChangeStarted(int wakefulness, int changeReason, long eventTime) {
            this.mCurrentWakefulness = wakefulness;
            if (this.mIsInteractive != PowerManagerInternal.isInteractive(wakefulness)) goto L5;
            return;
        L5:
            int screenOffTimeoutMs = WakefulnessSessionObserver.m7617$$Nest$mgetScreenOffTimeout(this.this$0);
            this.mIsInteractive = PowerManagerInternal.isInteractive(wakefulness);
            if (this.mIsInteractive == false) goto L14;
            this.mInteractiveStateOnStartTimestamp = eventTime;
            if (this.mTimeoutOffTimestamp == (-1)) goto L13;
            long timeoutOffToOnDurationMs = eventTime - this.mTimeoutOffTimestamp;
            if (timeoutOffToOnDurationMs >= WakefulnessSessionObserver.USER_INITIATED_REVERT_THRESHOLD_MILLIS) goto L12;
            this.this$0.mWakefulnessSessionFrameworkStatsLogger.logTimeoutOverrideEvent(this.mPowerGroupId, 2, WakefulnessSessionObserver.m7613$$Nest$fgetmOverrideTimeoutMs(this.this$0), screenOffTimeoutMs);
            this.mSendOverrideTimeoutLogTimestamp = eventTime;
        L12:
            this.mTimeoutOffTimestamp = -1;
        L13:
            checkAndLogDimIfQualified(4, eventTime);
            return;
        L14:
            int lastUserActivity = this.mCurrentUserActivityEvent;
            long lastUserActivityDurationMs = eventTime - this.mCurrentUserActivityTimestamp;
            int reducedInteractiveStateOnDurationMs = 0;
            this.mInteractiveOffTimestamp = eventTime;
            if (changeReason != 4) goto L22;
            int lastUserActivity2 = this.mPrevUserActivityEvent;
            long lastUserActivityDurationMs2 = eventTime - this.mPrevUserActivityTimestamp;
            if (isInOverrideTimeout() == false) goto L19;
        L20:
            this.this$0.mWakefulnessSessionFrameworkStatsLogger.logTimeoutOverrideEvent(this.mPowerGroupId, 5, WakefulnessSessionObserver.m7613$$Nest$fgetmOverrideTimeoutMs(this.this$0), screenOffTimeoutMs);
            this.mSendOverrideTimeoutLogTimestamp = eventTime;
            this.mTimeoutOverrideReleaseReason = -1;
        L21:
            checkAndLogDimIfQualified(2, eventTime);
            int lastUserActivity3 = lastUserActivity2;
            long lastUserActivityDurationMs3 = lastUserActivityDurationMs2;
            int interactiveStateOffReason = 2;
        L28:
            long interactiveStateOnDurationMs = eventTime - this.mInteractiveStateOnStartTimestamp;
            if (reducedInteractiveStateOnDurationMs >= screenOffTimeoutMs) goto L32;
            if (reducedInteractiveStateOnDurationMs < 0) goto L32;
            this.this$0.mWakefulnessSessionFrameworkStatsLogger.logSessionEvent(this.mPowerGroupId, interactiveStateOffReason, interactiveStateOnDurationMs, lastUserActivity3, lastUserActivityDurationMs3, reducedInteractiveStateOnDurationMs);
            return;
        L32:
            Slog.w(WakefulnessSessionObserver.TAG, "invalid reducedInteractiveStateOnDurationMs: " + reducedInteractiveStateOnDurationMs);
            return;
        L19:
            if (this.mTimeoutOverrideReleaseReason != 5) goto L21;
        L22:
            if (changeReason != 2) goto L27;
            int lastUserActivity4 = this.mCurrentUserActivityEvent;
            long lastUserActivityDurationMs4 = eventTime - this.mCurrentUserActivityTimestamp;
            if (isInOverrideTimeout() == false) goto L26;
            reducedInteractiveStateOnDurationMs = screenOffTimeoutMs - WakefulnessSessionObserver.m7613$$Nest$fgetmOverrideTimeoutMs(this.this$0);
            this.this$0.mWakefulnessSessionFrameworkStatsLogger.logTimeoutOverrideEvent(this.mPowerGroupId, 1, WakefulnessSessionObserver.m7613$$Nest$fgetmOverrideTimeoutMs(this.this$0), screenOffTimeoutMs);
            this.mSendOverrideTimeoutLogTimestamp = eventTime;
            this.mTimeoutOffTimestamp = eventTime;
        L26:
            checkAndLogDimIfQualified(1, eventTime);
            lastUserActivity3 = lastUserActivity4;
            lastUserActivityDurationMs3 = lastUserActivityDurationMs4;
            interactiveStateOffReason = 1;
            goto L28
        L27:
            lastUserActivity3 = lastUserActivity;
            lastUserActivityDurationMs3 = lastUserActivityDurationMs;
            interactiveStateOffReason = 0;
            goto L28
        }

        public void acquireTimeoutOverrideWakeLock() {
            Object r0 = WakefulnessSessionObserver.m7612$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mTimeoutOverrideWakeLockCounter++;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void releaseTimeoutOverrideWakeLock(int releaseReason) {
            Object r0 = WakefulnessSessionObserver.m7612$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean sendOverrideTimeoutLogSoon = true;
            this.mTimeoutOverrideWakeLockCounter--;     // Catch: Throwable -> L21
            monitor-exit(r0);     // Catch: Throwable -> L21
            if (isInOverrideTimeout() == true) goto L26;
            this.mTimeoutOverrideReleaseReason = releaseReason;
            long now = WakefulnessSessionObserver.m7609$$Nest$fgetmClock(this.this$0).uptimeMillis();
            long sendOverrideTimeoutLogDuration = now - this.mSendOverrideTimeoutLogTimestamp;
            if (sendOverrideTimeoutLogDuration < 1000) goto L12;
            sendOverrideTimeoutLogSoon = false;
        L12:
            if (sendOverrideTimeoutLogSoon == false) goto L14;
            return;
        L14:
            switch(releaseReason) {
                case 1: goto L18;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L17;
                case 5: goto L17;
                case 6: goto L17;
                case 7: goto L17;
                case 8: goto L16;
                default: goto L15;
            };
        L15:
            int outcome = 0;
        L19:
            this.this$0.mWakefulnessSessionFrameworkStatsLogger.logTimeoutOverrideEvent(this.mPowerGroupId, outcome, WakefulnessSessionObserver.m7613$$Nest$fgetmOverrideTimeoutMs(this.this$0), WakefulnessSessionObserver.m7617$$Nest$mgetScreenOffTimeout(this.this$0));
            return;
        L16:
            outcome = 6;
            goto L19
        L17:
            outcome = 4;
            goto L19
        L18:
            outcome = 7;
            goto L19
        L26:
            return;
        L21:
            th = move-exception;
            throw th;
        }

        protected boolean isInOverrideTimeout() {
            Object r0 = WakefulnessSessionObserver.m7612$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mTimeoutOverrideWakeLockCounter <= 0) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        private void checkAndLogDimIfQualified(final int reasonToBeChecked, long eventTime) {
            if (this.mPowerGroupId == 0) goto L5;
            return;
        L5:
            final int screenOffTimeoutMs = WakefulnessSessionObserver.m7617$$Nest$mgetScreenOffTimeout(this.this$0);
            final int lastUserActivity = this.mCurrentUserActivityEvent;
            final int lastUserActivityDurationMs = (int) (eventTime - this.mCurrentUserActivityTimestamp);
            switch(reasonToBeChecked) {
                case 1: goto L24;
                case 2: goto L19;
                case 3: goto L16;
                case 4: goto L8;
                default: goto L7;
            };
        L7:
            return;
        L8:
            long offToOnDurationMs = eventTime - this.mInteractiveOffTimestamp;
            if (this.mPastDimDurationMs <= 0) goto L14;
            if (offToOnDurationMs >= WakefulnessSessionObserver.USER_INITIATED_REVERT_THRESHOLD_MILLIS) goto L14;
            this.this$0.mWakefulnessSessionFrameworkStatsLogger.logDimEvent(WakefulnessSessionObserver.m7614$$Nest$fgetmPhysicalDisplayPortIdForDefaultDisplay(this.this$0), reasonToBeChecked, lastUserActivity, lastUserActivityDurationMs, this.mPastDimDurationMs, screenOffTimeoutMs);
            return;
        L14:
            return;
        L19:
            int lastUserActivity2 = this.mPrevUserActivityEvent;
            int lastUserActivityDurationMs2 = (int) (eventTime - this.mPrevUserActivityTimestamp);
            int dimDurationMs = 0;
            if (this.mCurrentScreenPolicy != 2) goto L22;
            int dimDurationMs2 = (int) (eventTime - this.mCurrentScreenPolicyTimestamp);
            this.this$0.mWakefulnessSessionFrameworkStatsLogger.logDimEvent(WakefulnessSessionObserver.m7614$$Nest$fgetmPhysicalDisplayPortIdForDefaultDisplay(this.this$0), reasonToBeChecked, lastUserActivity2, lastUserActivityDurationMs2, dimDurationMs2, screenOffTimeoutMs);
            WakefulnessSessionObserver.m7611$$Nest$fgetmHandler(this.this$0).removeCallbacksAndMessages(WakefulnessSessionObserver.HANDLER_TOKEN);
            dimDurationMs = dimDurationMs2;
        L22:
            this.mPastDimDurationMs = dimDurationMs;
            return;
        L24:
            int dimDurationMs3 = (int) (eventTime - this.mCurrentScreenPolicyTimestamp);
            if (this.mPrevScreenPolicy != 2) goto L27;
            int dimDurationMs4 = this.mPrevScreenPolicyDurationMs;
            int dimDurationMs5 = dimDurationMs4;
        L28:
            this.this$0.mWakefulnessSessionFrameworkStatsLogger.logDimEvent(WakefulnessSessionObserver.m7614$$Nest$fgetmPhysicalDisplayPortIdForDefaultDisplay(this.this$0), reasonToBeChecked, lastUserActivity, lastUserActivityDurationMs, dimDurationMs5, screenOffTimeoutMs);
            this.mPastDimDurationMs = dimDurationMs5;
            return;
        L27:
            dimDurationMs5 = dimDurationMs3;
            goto L28
        L16:
            if (this.mCurrentScreenPolicy != 2) goto L31;
            final int savedDimDurationMs = (int) (eventTime - this.mCurrentScreenPolicyTimestamp);
            WakefulnessSessionObserver.m7611$$Nest$fgetmHandler(this.this$0).postDelayed(new WakefulnessSessionObserver$WakefulnessSessionPowerGroup$$ExternalSyntheticLambda0(this, reasonToBeChecked, lastUserActivity, lastUserActivityDurationMs, savedDimDurationMs, screenOffTimeoutMs), WakefulnessSessionObserver.HANDLER_TOKEN, 500);
            return;
        }

        private /* synthetic */ void lambda$checkAndLogDimIfQualified$0(int reasonToBeChecked, int savedLastUserActivity, int savedLastUserActivityDurationMs, int savedDimDurationMs, int screenOffTimeoutMs) {
            this.this$0.mWakefulnessSessionFrameworkStatsLogger.logDimEvent(WakefulnessSessionObserver.m7614$$Nest$fgetmPhysicalDisplayPortIdForDefaultDisplay(this.this$0), reasonToBeChecked, savedLastUserActivity, savedLastUserActivityDurationMs, savedDimDurationMs, screenOffTimeoutMs);
            this.mPastDimDurationMs = savedDimDurationMs;
        }

        void dump(IndentingPrintWriter writer) {
            long now = WakefulnessSessionObserver.m7609$$Nest$fgetmClock(this.this$0).uptimeMillis();
            writer.println("Wakefulness Session Power Group powerGroupId: " + this.mPowerGroupId);
            writer.increaseIndent();
            writer.println("current wakefulness: " + this.mCurrentWakefulness);
            writer.println("current user activity event: " + this.mCurrentUserActivityEvent);
            long currentUserActivityDurationMs = now - this.mCurrentUserActivityTimestamp;
            writer.println("current user activity duration: " + currentUserActivityDurationMs);
            writer.println("previous user activity event: " + this.mPrevUserActivityEvent);
            long prevUserActivityDurationMs = now - this.mPrevUserActivityTimestamp;
            writer.println("previous user activity duration: " + prevUserActivityDurationMs);
            writer.println("is in override timeout: " + isInOverrideTimeout());
            writer.println("mIsInteractive: " + this.mIsInteractive);
            writer.println("current screen policy: " + this.mCurrentScreenPolicy);
            long currentScreenPolicyDurationMs = now - this.mCurrentScreenPolicyTimestamp;
            writer.println("current screen policy duration: " + currentScreenPolicyDurationMs);
            writer.println("previous screen policy: " + this.mPrevScreenPolicy);
            writer.println("past screen policy duration: " + this.mPrevScreenPolicyDurationMs);
            writer.decreaseIndent();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Clock m7609$$Nest$fgetmClock(WakefulnessSessionObserver r0) {
        return r0.mClock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7610$$Nest$fgetmContext(WakefulnessSessionObserver r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7611$$Nest$fgetmHandler(WakefulnessSessionObserver r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7612$$Nest$fgetmLock(WakefulnessSessionObserver r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOverrideTimeoutMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7613$$Nest$fgetmOverrideTimeoutMs(WakefulnessSessionObserver r0) {
        return r0.mOverrideTimeoutMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPhysicalDisplayPortIdForDefaultDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7614$$Nest$fgetmPhysicalDisplayPortIdForDefaultDisplay(WakefulnessSessionObserver r0) {
        return r0.mPhysicalDisplayPortIdForDefaultDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPhysicalDisplayPortIdForDefaultDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7615$$Nest$fputmPhysicalDisplayPortIdForDefaultDisplay(WakefulnessSessionObserver r0, int r1) {
        r0.mPhysicalDisplayPortIdForDefaultDisplay = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPhysicalDisplayPortId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7616$$Nest$mgetPhysicalDisplayPortId(WakefulnessSessionObserver r0, int r1) {
        return r0.getPhysicalDisplayPortId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetScreenOffTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7617$$Nest$mgetScreenOffTimeout(WakefulnessSessionObserver r0) {
        return r0.getScreenOffTimeout();
    }

    static {
        HANDLER_TOKEN = new Object();
    }

    public WakefulnessSessionObserver(Context context, Injector injector) {
        this.mOverrideTimeoutMs = 0;
        this.mPowerGroups = new SparseArray();
        this.mLock = new Object();
        if (injector != null) goto L5;
        injector = new Injector();
    L5:
        this.mContext = context;
        this.mDisplayManagerInternal = injector.getDisplayManagerInternal();
        this.mWakefulnessSessionFrameworkStatsLogger = injector.getWakefulnessSessionFrameworkStatsLogger();
        this.mClock = injector.getClock();
        this.mHandler = injector.getHandler();
        updateSettingScreenOffTimeout(this.mContext);
        UserSwitchObserver observer = new UserSwitchObserver(this, null);     // Catch: RemoteException -> L8
        ActivityManager.getService().registerUserSwitchObserver(observer, TAG);     // Catch: RemoteException -> L8
    L9:
        this.mOverrideTimeoutMs = this.mContext.getResources().getInteger(R.integer.config_shutdownBatteryTemperature);
        ContentResolver r1 = this.mContext.getContentResolver();
        Uri r2 = Settings.System.getUriFor("screen_off_timeout");
        final Handler r4 = new Handler(this.mContext.getMainLooper());
        r1.registerContentObserver(r2, false, new AnonymousClass1(this, r4), -1);
        this.mPhysicalDisplayPortIdForDefaultDisplay = getPhysicalDisplayPortId(0);
        registerDisplayListener();
        this.mPowerGroups.append(0, new WakefulnessSessionPowerGroup(this, 0));
    }

    private void registerDisplayListener() {
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        if (displayManager == null) goto L6;
        displayManager.registerDisplayListener(new AnonymousClass2(this), this.mHandler, 4);
        return;
    }

    public void notifyUserActivity(long eventTime, int powerGroupId, int event) {
        if (this.mPowerGroups.contains(powerGroupId) == true) goto L5;
        this.mPowerGroups.append(powerGroupId, new WakefulnessSessionPowerGroup(this, powerGroupId));
    L5:
        this.mPowerGroups.get(powerGroupId).notifyUserActivity(eventTime, event);
    }

    public void onScreenPolicyUpdate(long eventTime, int powerGroupId, int newPolicy) {
        if (this.mPowerGroups.contains(powerGroupId) == true) goto L5;
        this.mPowerGroups.append(powerGroupId, new WakefulnessSessionPowerGroup(this, powerGroupId));
    L5:
        this.mPowerGroups.get(powerGroupId).onScreenPolicyUpdate(eventTime, newPolicy);
    }

    public void onWakefulnessChangeStarted(int powerGroupId, int wakefulness, int changeReason, long eventTime) {
        if (this.mPowerGroups.contains(powerGroupId) == true) goto L5;
        this.mPowerGroups.append(powerGroupId, new WakefulnessSessionPowerGroup(this, powerGroupId));
    L5:
        this.mPowerGroups.get(powerGroupId).onWakefulnessChangeStarted(wakefulness, changeReason, eventTime);
    }

    public void onWakeLockAcquired(int flags) {
        int maskedFlag = 65535 & flags;
        if (maskedFlag != 256) goto L8;
        int idx = 0;
    L6:
        if (idx >= this.mPowerGroups.size()) goto L10;
        this.mPowerGroups.valueAt(idx).acquireTimeoutOverrideWakeLock();
        idx = idx + 1;
        goto L6
    L10:
        return;
    }

    public void onWakeLockReleased(int flags, int releaseReason) {
        int maskedFlag = 65535 & flags;
        if (maskedFlag != 256) goto L8;
        int idx = 0;
    L6:
        if (idx >= this.mPowerGroups.size()) goto L10;
        this.mPowerGroups.valueAt(idx).releaseTimeoutOverrideWakeLock(releaseReason);
        idx = idx + 1;
        goto L6
    L10:
        return;
    }

    public void removePowerGroup(int powerGroupId) {
        if (this.mPowerGroups.contains(powerGroupId) == false) goto L6;
        this.mPowerGroups.delete(powerGroupId);
        return;
    }

    void dump(PrintWriter writer) {
        writer.println();
        writer.println("Wakefulness Session Observer:");
        writer.println("default timeout: " + this.mScreenOffTimeoutMs);
        writer.println("override timeout: " + this.mOverrideTimeoutMs);
        IndentingPrintWriter indentingPrintWriter = new IndentingPrintWriter(writer);
        indentingPrintWriter.increaseIndent();
        int idx = 0;
    L4:
        if (idx >= this.mPowerGroups.size()) goto L6;
        this.mPowerGroups.valueAt(idx).dump(indentingPrintWriter);
        idx = idx + 1;
        goto L4
    L6:
        writer.println();
    }

    void updateSettingScreenOffTimeout(Context context) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mScreenOffTimeoutMs = Settings.System.getIntForUser(context.getContentResolver(), "screen_off_timeout", ProcessList.PSS_MIN_TIME_FROM_STATE_CHANGE, -2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private int getPhysicalDisplayPortId(int displayId) {
        if (this.mDisplayManagerInternal != null) goto L6;
        return -1;
    L6:
        DisplayInfo display = this.mDisplayManagerInternal.getDisplayInfo(displayId);
        return display.address.getPort();
    }

    private int getScreenOffTimeout() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mScreenOffTimeoutMs;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
