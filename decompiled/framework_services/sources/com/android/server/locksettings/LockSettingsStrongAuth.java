package com.android.server.locksettings;

import android.app.AlarmManager;
import android.app.admin.DevicePolicyManager;
import android.app.trust.IStrongAuthTracker;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.widget.LockPatternUtils;

/* JADX INFO: loaded from: classes2.dex */
public class LockSettingsStrongAuth {
    private static final boolean DEBUG = false;
    public static final long DEFAULT_NON_STRONG_BIOMETRIC_IDLE_TIMEOUT_MS = 86400000;
    public static final long DEFAULT_NON_STRONG_BIOMETRIC_TIMEOUT_MS = 86400000;
    private static final int MSG_NO_LONGER_REQUIRE_STRONG_AUTH = 6;
    private static final int MSG_REFRESH_STRONG_AUTH_TIMEOUT = 10;
    private static final int MSG_REGISTER_TRACKER = 2;
    private static final int MSG_REMOVE_USER = 4;
    private static final int MSG_REQUIRE_STRONG_AUTH = 1;
    private static final int MSG_SCHEDULE_NON_STRONG_BIOMETRIC_IDLE_TIMEOUT = 9;
    private static final int MSG_SCHEDULE_NON_STRONG_BIOMETRIC_TIMEOUT = 7;
    private static final int MSG_SCHEDULE_STRONG_AUTH_TIMEOUT = 5;
    private static final int MSG_STRONG_BIOMETRIC_UNLOCK = 8;
    private static final int MSG_UNREGISTER_TRACKER = 3;
    protected static final String NON_STRONG_BIOMETRIC_IDLE_TIMEOUT_ALARM_TAG = "LockSettingsPrimaryAuth.nonStrongBiometricIdleTimeoutForUser";
    protected static final String NON_STRONG_BIOMETRIC_TIMEOUT_ALARM_TAG = "LockSettingsPrimaryAuth.nonStrongBiometricTimeoutForUser";
    protected static final String STRONG_AUTH_TIMEOUT_ALARM_TAG = "LockSettingsStrongAuth.timeoutForUser";
    private static final String TAG = "LockSettingsStrongAuth";
    private final AlarmManager mAlarmManager;
    private final Context mContext;
    private final boolean mDefaultIsNonStrongBiometricAllowed;
    private final int mDefaultStrongAuthFlags;
    protected final Handler mHandler;
    private final Injector mInjector;
    protected final SparseBooleanArray mIsNonStrongBiometricAllowedForUser;
    protected final ArrayMap<Integer, NonStrongBiometricIdleTimeoutAlarmListener> mNonStrongBiometricIdleTimeoutAlarmListener;
    protected final ArrayMap<Integer, NonStrongBiometricTimeoutAlarmListener> mNonStrongBiometricTimeoutAlarmListener;
    protected final SparseIntArray mStrongAuthForUser;
    protected final ArrayMap<Integer, StrongAuthTimeoutAlarmListener> mStrongAuthTimeoutAlarmListenerForUser;
    private final RemoteCallbackList<IStrongAuthTracker> mTrackers;

    public static class Injector {
        public Injector() {
        }

        public AlarmManager getAlarmManager(Context context) {
            return (AlarmManager) context.getSystemService(AlarmManager.class);
        }

        public int getDefaultStrongAuthFlags(Context context) {
            return LockPatternUtils.StrongAuthTracker.getDefaultFlags(context);
        }

        public long getNextAlarmTimeMs(long timeout) {
            return SystemClock.elapsedRealtime() + timeout;
        }

        public long getElapsedRealtimeMs() {
            return SystemClock.elapsedRealtime();
        }
    }

    protected class NonStrongBiometricIdleTimeoutAlarmListener implements AlarmManager.OnAlarmListener {
        private final int mUserId;
        final /* synthetic */ LockSettingsStrongAuth this$0;

        NonStrongBiometricIdleTimeoutAlarmListener(LockSettingsStrongAuth this$0, int userId) {
            this.this$0 = this$0;
            this.mUserId = userId;
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            this.this$0.setIsNonStrongBiometricAllowed(false, this.mUserId);
        }
    }

    protected class NonStrongBiometricTimeoutAlarmListener implements AlarmManager.OnAlarmListener {
        private final int mUserId;
        final /* synthetic */ LockSettingsStrongAuth this$0;

        NonStrongBiometricTimeoutAlarmListener(LockSettingsStrongAuth this$0, int userId) {
            this.this$0 = this$0;
            this.mUserId = userId;
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            this.this$0.requireStrongAuth(128, this.mUserId);
        }
    }

    protected class StrongAuthTimeoutAlarmListener implements AlarmManager.OnAlarmListener {
        private long mLatestStrongAuthTime;
        private final int mUserId;
        final /* synthetic */ LockSettingsStrongAuth this$0;

        public StrongAuthTimeoutAlarmListener(LockSettingsStrongAuth this$0, long latestStrongAuthTime, int userId) {
            this.this$0 = this$0;
            this.mLatestStrongAuthTime = latestStrongAuthTime;
            this.mUserId = userId;
        }

        public void setLatestStrongAuthTime(long strongAuthTime) {
            this.mLatestStrongAuthTime = strongAuthTime;
        }

        public long getLatestStrongAuthTime() {
            return this.mLatestStrongAuthTime;
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            this.this$0.requireStrongAuth(16, this.mUserId);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAddStrongAuthTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5452$$Nest$mhandleAddStrongAuthTracker(LockSettingsStrongAuth r0, IStrongAuthTracker r1) {
        r0.handleAddStrongAuthTracker(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNoLongerRequireStrongAuth, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5453$$Nest$mhandleNoLongerRequireStrongAuth(LockSettingsStrongAuth r0, int r1, int r2) {
        r0.handleNoLongerRequireStrongAuth(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRefreshStrongAuthTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5454$$Nest$mhandleRefreshStrongAuthTimeout(LockSettingsStrongAuth r0, int r1) {
        r0.handleRefreshStrongAuthTimeout(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRemoveStrongAuthTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5455$$Nest$mhandleRemoveStrongAuthTracker(LockSettingsStrongAuth r0, IStrongAuthTracker r1) {
        r0.handleRemoveStrongAuthTracker(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRemoveUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5456$$Nest$mhandleRemoveUser(LockSettingsStrongAuth r0, int r1) {
        r0.handleRemoveUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRequireStrongAuth, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5457$$Nest$mhandleRequireStrongAuth(LockSettingsStrongAuth r0, int r1, int r2) {
        r0.handleRequireStrongAuth(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleScheduleNonStrongBiometricIdleTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5458$$Nest$mhandleScheduleNonStrongBiometricIdleTimeout(LockSettingsStrongAuth r0, int r1) {
        r0.handleScheduleNonStrongBiometricIdleTimeout(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleScheduleNonStrongBiometricTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5459$$Nest$mhandleScheduleNonStrongBiometricTimeout(LockSettingsStrongAuth r0, int r1) {
        r0.handleScheduleNonStrongBiometricTimeout(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleScheduleStrongAuthTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5460$$Nest$mhandleScheduleStrongAuthTimeout(LockSettingsStrongAuth r0, int r1) {
        r0.handleScheduleStrongAuthTimeout(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleStrongBiometricUnlock, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5461$$Nest$mhandleStrongBiometricUnlock(LockSettingsStrongAuth r0, int r1) {
        r0.handleStrongBiometricUnlock(r1);
    }

    static {
        if (Build.IS_DEBUGGABLE == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        DEBUG = r0;
        return;
    L5:
        if (Log.isLoggable(TAG, 3) == false) goto L7;
        r0 = true;
        goto L8
    }

    public LockSettingsStrongAuth(Context context) {
        this(context, new Injector());
    }

    protected LockSettingsStrongAuth(Context context, Injector injector) {
        this.mTrackers = new RemoteCallbackList();
        this.mStrongAuthForUser = new SparseIntArray();
        this.mIsNonStrongBiometricAllowedForUser = new SparseBooleanArray();
        this.mStrongAuthTimeoutAlarmListenerForUser = new ArrayMap();
        this.mNonStrongBiometricTimeoutAlarmListener = new ArrayMap();
        this.mNonStrongBiometricIdleTimeoutAlarmListener = new ArrayMap();
        this.mDefaultIsNonStrongBiometricAllowed = true;
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mContext = context;
        this.mInjector = injector;
        this.mDefaultStrongAuthFlags = this.mInjector.getDefaultStrongAuthFlags(context);
        this.mAlarmManager = this.mInjector.getAlarmManager(context);
    }

    private void handleAddStrongAuthTracker(IStrongAuthTracker tracker) {
        this.mTrackers.register(tracker);
        int i = 0;
    L4:
        if (i >= this.mStrongAuthForUser.size()) goto L11;
        int key = this.mStrongAuthForUser.keyAt(i);
        int value = this.mStrongAuthForUser.valueAt(i);
        tracker.onStrongAuthRequiredChanged(value, key);     // Catch: RemoteException -> L8
    L10:
        i = i + 1;
    L8:
        e = move-exception;
        Slog.e(TAG, "Exception while adding StrongAuthTracker.", e);
        goto L10
    L11:
        int i2 = 0;
    L13:
        if (i2 >= this.mIsNonStrongBiometricAllowedForUser.size()) goto L21;
        int key2 = this.mIsNonStrongBiometricAllowedForUser.keyAt(i2);
        boolean value2 = this.mIsNonStrongBiometricAllowedForUser.valueAt(i2);
        tracker.onIsNonStrongBiometricAllowedChanged(value2, key2);     // Catch: RemoteException -> L17
    L19:
        i2 = i2 + 1;
    L17:
        e = move-exception;
        Slog.e(TAG, "Exception while adding StrongAuthTracker: IsNonStrongBiometricAllowedChanged.", e);
        goto L19
    }

    private void handleRemoveStrongAuthTracker(IStrongAuthTracker tracker) {
        this.mTrackers.unregister(tracker);
    }

    private void handleRequireStrongAuth(int strongAuthReason, int userId) {
        if (userId != (-1)) goto L9;
        int i = 0;
    L6:
        if (i >= this.mStrongAuthForUser.size()) goto L12;
        int key = this.mStrongAuthForUser.keyAt(i);
        handleRequireStrongAuthOneUser(strongAuthReason, key);
        i = i + 1;
        goto L6
    L12:
        return;
    L9:
        handleRequireStrongAuthOneUser(strongAuthReason, userId);
    }

    private void handleRequireStrongAuthOneUser(int strongAuthReason, int userId) {
        int oldValue = this.mStrongAuthForUser.get(userId, this.mDefaultStrongAuthFlags);
        if (strongAuthReason != 0) goto L5;
        int newValue = 0;
    L7:
        if (oldValue == newValue) goto L10;
        this.mStrongAuthForUser.put(userId, newValue);
        notifyStrongAuthTrackers(newValue, userId);
        return;
    L10:
        return;
    L5:
        newValue = oldValue | strongAuthReason;
        goto L7
    }

    private void handleNoLongerRequireStrongAuth(int strongAuthReason, int userId) {
        if (userId != (-1)) goto L9;
        int i = 0;
    L6:
        if (i >= this.mStrongAuthForUser.size()) goto L12;
        int key = this.mStrongAuthForUser.keyAt(i);
        handleNoLongerRequireStrongAuthOneUser(strongAuthReason, key);
        i = i + 1;
        goto L6
    L12:
        return;
    L9:
        handleNoLongerRequireStrongAuthOneUser(strongAuthReason, userId);
    }

    private void handleNoLongerRequireStrongAuthOneUser(int strongAuthReason, int userId) {
        int oldValue = this.mStrongAuthForUser.get(userId, this.mDefaultStrongAuthFlags);
        int newValue = (~strongAuthReason) & oldValue;
        if (oldValue == newValue) goto L6;
        this.mStrongAuthForUser.put(userId, newValue);
        notifyStrongAuthTrackers(newValue, userId);
        return;
    }

    private void handleRemoveUser(int userId) {
        int index = this.mStrongAuthForUser.indexOfKey(userId);
        if (index < 0) goto L5;
        this.mStrongAuthForUser.removeAt(index);
        notifyStrongAuthTrackers(this.mDefaultStrongAuthFlags, userId);
    L5:
        int index2 = this.mIsNonStrongBiometricAllowedForUser.indexOfKey(userId);
        if (index2 < 0) goto L9;
        this.mIsNonStrongBiometricAllowedForUser.removeAt(index2);
        notifyStrongAuthTrackersForIsNonStrongBiometricAllowed(true, userId);
        return;
    }

    private void rescheduleStrongAuthTimeoutAlarm(long strongAuthTime, int userId) {
        DevicePolicyManager dpm = (DevicePolicyManager) this.mContext.getSystemService("device_policy");
        StrongAuthTimeoutAlarmListener alarm = this.mStrongAuthTimeoutAlarmListenerForUser.get(Integer.valueOf(userId));
        if (alarm == null) goto L5;
        this.mAlarmManager.cancel(alarm);
        alarm.setLatestStrongAuthTime(strongAuthTime);
        StrongAuthTimeoutAlarmListener alarm2 = alarm;
    L6:
        long nextAlarmTime = strongAuthTime + dpm.getRequiredStrongAuthTimeout(null, userId);
        this.mAlarmManager.setExact(2, nextAlarmTime, STRONG_AUTH_TIMEOUT_ALARM_TAG, alarm2, this.mHandler);
        return;
    L5:
        StrongAuthTimeoutAlarmListener alarm3 = new StrongAuthTimeoutAlarmListener(this, strongAuthTime, userId);
        this.mStrongAuthTimeoutAlarmListenerForUser.put(Integer.valueOf(userId), alarm3);
        alarm2 = alarm3;
        goto L6
    }

    private void handleScheduleStrongAuthTimeout(int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "handleScheduleStrongAuthTimeout for userId=" + userId);
    L5:
        rescheduleStrongAuthTimeoutAlarm(this.mInjector.getElapsedRealtimeMs(), userId);
        cancelNonStrongBiometricAlarmListener(userId);
        cancelNonStrongBiometricIdleAlarmListener(userId);
        setIsNonStrongBiometricAllowed(true, userId);
    }

    private void handleRefreshStrongAuthTimeout(int userId) {
        StrongAuthTimeoutAlarmListener alarm = this.mStrongAuthTimeoutAlarmListenerForUser.get(Integer.valueOf(userId));
        if (alarm == null) goto L6;
        rescheduleStrongAuthTimeoutAlarm(alarm.getLatestStrongAuthTime(), userId);
        return;
    }

    private void handleScheduleNonStrongBiometricTimeout(int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "handleScheduleNonStrongBiometricTimeout for userId=" + userId);
    L5:
        long nextAlarmTime = this.mInjector.getNextAlarmTimeMs(86400000);
        if (this.mNonStrongBiometricTimeoutAlarmListener.get(Integer.valueOf(userId)) == null) goto L11;
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "There is an existing alarm for non-strong biometric fallback timeout, so do not re-schedule");
    L14:
        cancelNonStrongBiometricIdleAlarmListener(userId);
        return;
    L11:
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "Schedule a new alarm for non-strong biometric fallback timeout");
    L13:
        NonStrongBiometricTimeoutAlarmListener alarm = new NonStrongBiometricTimeoutAlarmListener(this, userId);
        this.mNonStrongBiometricTimeoutAlarmListener.put(Integer.valueOf(userId), alarm);
        this.mAlarmManager.setExact(2, nextAlarmTime, NON_STRONG_BIOMETRIC_TIMEOUT_ALARM_TAG, alarm, this.mHandler);
        goto L14
    }

    private void handleStrongBiometricUnlock(int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "handleStrongBiometricUnlock for userId=" + userId);
    L5:
        cancelNonStrongBiometricAlarmListener(userId);
        cancelNonStrongBiometricIdleAlarmListener(userId);
        setIsNonStrongBiometricAllowed(true, userId);
    }

    private void cancelNonStrongBiometricAlarmListener(int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "cancelNonStrongBiometricAlarmListener for userId=" + userId);
    L5:
        NonStrongBiometricTimeoutAlarmListener alarm = this.mNonStrongBiometricTimeoutAlarmListener.get(Integer.valueOf(userId));
        if (alarm != null) goto L8;
        return;
    L8:
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "Cancel alarm for non-strong biometric fallback timeout");
    L10:
        this.mAlarmManager.cancel(alarm);
        this.mNonStrongBiometricTimeoutAlarmListener.remove(Integer.valueOf(userId));
    }

    private void cancelNonStrongBiometricIdleAlarmListener(int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "cancelNonStrongBiometricIdleAlarmListener for userId=" + userId);
    L5:
        NonStrongBiometricIdleTimeoutAlarmListener alarm = this.mNonStrongBiometricIdleTimeoutAlarmListener.get(Integer.valueOf(userId));
        if (alarm != null) goto L8;
        return;
    L8:
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "Cancel alarm for non-strong biometric idle timeout");
    L10:
        this.mAlarmManager.cancel(alarm);
    }

    protected void setIsNonStrongBiometricAllowed(boolean allowed, int userId) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "setIsNonStrongBiometricAllowed for allowed=" + allowed + ", userId=" + userId);
    L6:
        if (userId != (-1)) goto L12;
        int i = 0;
    L9:
        if (i >= this.mIsNonStrongBiometricAllowedForUser.size()) goto L15;
        int key = this.mIsNonStrongBiometricAllowedForUser.keyAt(i);
        setIsNonStrongBiometricAllowedOneUser(allowed, key);
        i = i + 1;
        goto L9
    L15:
        return;
    L12:
        setIsNonStrongBiometricAllowedOneUser(allowed, userId);
    }

    private void setIsNonStrongBiometricAllowedOneUser(boolean allowed, int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "setIsNonStrongBiometricAllowedOneUser for allowed=" + allowed + ", userId=" + userId);
    L5:
        boolean oldValue = this.mIsNonStrongBiometricAllowedForUser.get(userId, true);
        if (allowed != oldValue) goto L8;
        return;
    L8:
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "mIsNonStrongBiometricAllowedForUser value changed: oldValue=" + oldValue + ", allowed=" + allowed);
    L10:
        this.mIsNonStrongBiometricAllowedForUser.put(userId, allowed);
        notifyStrongAuthTrackersForIsNonStrongBiometricAllowed(allowed, userId);
    }

    private void handleScheduleNonStrongBiometricIdleTimeout(int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "handleScheduleNonStrongBiometricIdleTimeout for userId=" + userId);
    L5:
        long nextAlarmTime = this.mInjector.getNextAlarmTimeMs(86400000);
        NonStrongBiometricIdleTimeoutAlarmListener alarm = this.mNonStrongBiometricIdleTimeoutAlarmListener.get(Integer.valueOf(userId));
        if (alarm != null) goto L8;
        NonStrongBiometricIdleTimeoutAlarmListener alarm2 = new NonStrongBiometricIdleTimeoutAlarmListener(this, userId);
        this.mNonStrongBiometricIdleTimeoutAlarmListener.put(Integer.valueOf(userId), alarm2);
        NonStrongBiometricIdleTimeoutAlarmListener alarm3 = alarm2;
    L13:
        if (DEBUG == false) goto L15;
        Slog.d(TAG, "Schedule a new alarm for non-strong biometric idle timeout");
    L15:
        this.mAlarmManager.setExact(2, nextAlarmTime, NON_STRONG_BIOMETRIC_IDLE_TIMEOUT_ALARM_TAG, alarm3, this.mHandler);
        return;
    L8:
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "Cancel existing alarm for non-strong biometric idle timeout");
    L10:
        this.mAlarmManager.cancel(alarm);
        alarm3 = alarm;
        goto L13
    }

    private void notifyStrongAuthTrackers(int strongAuthReason, int userId) {
        int i = this.mTrackers.beginBroadcast();
    L3:
        if (i <= 0) goto L14;
        i = i - 1;
        this.mTrackers.getBroadcastItem(i).onStrongAuthRequiredChanged(strongAuthReason, userId);     // Catch: Throwable -> L7 RemoteException -> L9
    L7:
        th = move-exception;
        this.mTrackers.finishBroadcast();
        throw th;
    L9:
        e = move-exception;
        Slog.e(TAG, "Exception while notifying StrongAuthTracker.", e);     // Catch: Throwable -> L7
        goto L3
    L14:
        this.mTrackers.finishBroadcast();
    }

    private void notifyStrongAuthTrackersForIsNonStrongBiometricAllowed(boolean allowed, int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "notifyStrongAuthTrackersForIsNonStrongBiometricAllowed for allowed=" + allowed + ", userId=" + userId);
    L5:
        int i = this.mTrackers.beginBroadcast();
    L6:
        if (i <= 0) goto L17;
        i = i - 1;
        this.mTrackers.getBroadcastItem(i).onIsNonStrongBiometricAllowedChanged(allowed, userId);     // Catch: Throwable -> L10 RemoteException -> L12
    L10:
        th = move-exception;
        this.mTrackers.finishBroadcast();
        throw th;
    L12:
        e = move-exception;
        Slog.e(TAG, "Exception while notifying StrongAuthTracker: IsNonStrongBiometricAllowedChanged.", e);     // Catch: Throwable -> L10
        goto L6
    L17:
        this.mTrackers.finishBroadcast();
    }

    public void registerStrongAuthTracker(IStrongAuthTracker tracker) {
        this.mHandler.obtainMessage(2, tracker).sendToTarget();
    }

    public void unregisterStrongAuthTracker(IStrongAuthTracker tracker) {
        this.mHandler.obtainMessage(3, tracker).sendToTarget();
    }

    public void removeUser(int userId) {
        this.mHandler.obtainMessage(4, userId, 0).sendToTarget();
    }

    public void requireStrongAuth(int strongAuthReason, int userId) {
        if (userId == (-1)) goto L8;
        if (userId >= 0) goto L8;
        throw new IllegalArgumentException("userId must be an explicit user id or USER_ALL");
    L8:
        this.mHandler.obtainMessage(1, strongAuthReason, userId).sendToTarget();
    }

    void noLongerRequireStrongAuth(int strongAuthReason, int userId) {
        if (userId == (-1)) goto L8;
        if (userId >= 0) goto L8;
        throw new IllegalArgumentException("userId must be an explicit user id or USER_ALL");
    L8:
        this.mHandler.obtainMessage(6, strongAuthReason, userId).sendToTarget();
    }

    public void reportUnlock(int userId) {
        requireStrongAuth(0, userId);
    }

    public void reportSuccessfulStrongAuthUnlock(int userId) {
        this.mHandler.obtainMessage(5, userId, 0).sendToTarget();
    }

    public void refreshStrongAuthTimeout(int userId) {
        this.mHandler.obtainMessage(10, userId, 0).sendToTarget();
    }

    public void reportSuccessfulBiometricUnlock(boolean isStrongBiometric, int userId) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "reportSuccessfulBiometricUnlock for isStrongBiometric=" + isStrongBiometric + ", userId=" + userId);
    L6:
        if (isStrongBiometric == false) goto L8;
        this.mHandler.obtainMessage(8, userId, 0).sendToTarget();
        return;
    L8:
        this.mHandler.obtainMessage(7, userId, 0).sendToTarget();
    }

    public void scheduleNonStrongBiometricIdleTimeout(int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "scheduleNonStrongBiometricIdleTimeout for userId=" + userId);
    L5:
        this.mHandler.obtainMessage(9, userId, 0).sendToTarget();
    }

    public void dump(IndentingPrintWriter pw) {
        pw.println("PrimaryAuthFlags state:");
        pw.increaseIndent();
        int i = 0;
    L4:
        if (i >= this.mStrongAuthForUser.size()) goto L6;
        int key = this.mStrongAuthForUser.keyAt(i);
        int value = this.mStrongAuthForUser.valueAt(i);
        pw.println("userId=" + key + ", primaryAuthFlags=" + Integer.toHexString(value));
        i = i + 1;
        goto L4
    L6:
        pw.println();
        pw.decreaseIndent();
        pw.println("NonStrongBiometricAllowed state:");
        pw.increaseIndent();
        int i2 = 0;
    L8:
        if (i2 >= this.mIsNonStrongBiometricAllowedForUser.size()) goto L10;
        int key2 = this.mIsNonStrongBiometricAllowedForUser.keyAt(i2);
        boolean value2 = this.mIsNonStrongBiometricAllowedForUser.valueAt(i2);
        pw.println("userId=" + key2 + ", allowed=" + value2);
        i2 = i2 + 1;
        goto L8
    L10:
        pw.println();
        pw.decreaseIndent();
    }
}
