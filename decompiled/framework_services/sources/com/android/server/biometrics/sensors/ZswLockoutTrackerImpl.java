package com.android.server.biometrics.sensors;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public class ZswLockoutTrackerImpl implements LockoutTracker {
    private static final String ACTION_LOCKOUT_RESET = "com.android.server.biometrics.sensors.fingerprint.ACTION_LOCKOUT_RESET";
    private static final long FAIL_LOCKOUT_TIMEOUT_MS = 30000;
    private static final String KEY_LOCKOUT_RESET_USER = "lockout_reset_user";
    private static final int MAX_FAILED_ATTEMPTS_LOCKOUT_PERMANENT = 20;
    private static final int MAX_FAILED_ATTEMPTS_LOCKOUT_PERMANENT_SIDEFPS = 150;
    private static final int MAX_FAILED_ATTEMPTS_LOCKOUT_TIMED = 5;
    private static final int MAX_FAILED_ATTEMPTS_LOCKOUT_TIMED_SIDEFPS = 30;
    private final String TAG;
    private final AlarmManager mAlarmManager;
    private final SparseIntArray mFailedAttempts;
    private final Handler mHandler;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    private final Function<Integer, PendingIntent> mLockoutResetIntent;
    private int mSensorId;
    private int mSensorType;
    private final SparseBooleanArray mTimedLockoutCleared;

    public static /* synthetic */ void $r8$lambda$Ce7E9bFSa3cO8PXm2fnnSsOs4gk(ZswLockoutTrackerImpl r0, int r1) {
        r0.lambda$scheduleLockoutResetForUser$2(r1);
    }

    public static /* synthetic */ PendingIntent $r8$lambda$epWAU1svKwbKPjEmfKetannRLkA(Context r0, Integer r1) {
        return lambda$new$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$hGBnFu89gveL5dcQDUr05rqM-1M, reason: not valid java name */
    public static /* synthetic */ PendingIntent m2635$r8$lambda$hGBnFu89gveL5dcQDUr05rqM1M(Context r0, Integer r1) {
        return lambda$new$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2636$$Nest$fgetTAG(ZswLockoutTrackerImpl r0) {
        return r0.TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockoutResetDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ LockoutResetDispatcher m2637$$Nest$fgetmLockoutResetDispatcher(ZswLockoutTrackerImpl r0) {
        return r0.mLockoutResetDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2638$$Nest$fgetmSensorId(ZswLockoutTrackerImpl r0) {
        return r0.mSensorId;
    }

    public ZswLockoutTrackerImpl(final Context context) {
        this(context, new ZswLockoutTrackerImpl$$ExternalSyntheticLambda1(context), null, null, null);
    }

    private static /* synthetic */ PendingIntent lambda$new$0(Context context, Integer userId) {
        return PendingIntent.getBroadcast(context, userId.intValue(), new Intent(ACTION_LOCKOUT_RESET).putExtra(KEY_LOCKOUT_RESET_USER, userId), AudioFormat.DTS_HD);
    }

    public ZswLockoutTrackerImpl(final Context context, Handler handler, LockoutResetDispatcher lockoutResetDispatcher, FingerprintSensorPropertiesInternal sensorProperties) {
        this(context, new ZswLockoutTrackerImpl$$ExternalSyntheticLambda0(context), handler, lockoutResetDispatcher, sensorProperties);
    }

    private static /* synthetic */ PendingIntent lambda$new$1(Context context, Integer userId) {
        return PendingIntent.getBroadcast(context, userId.intValue(), new Intent(ACTION_LOCKOUT_RESET).putExtra(KEY_LOCKOUT_RESET_USER, userId), AudioFormat.DTS_HD);
    }

    public ZswLockoutTrackerImpl(Context context, Function<Integer, PendingIntent> lockoutResetIntent, Handler handler, LockoutResetDispatcher lockoutResetDispatcher, FingerprintSensorPropertiesInternal sensorProperties) {
        this.TAG = "ZswLockoutTracker@" + this;
        this.mSensorId = -1;
        this.mSensorType = 0;
        this.mTimedLockoutCleared = new SparseBooleanArray();
        this.mFailedAttempts = new SparseIntArray();
        this.mAlarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
        if (handler != null) goto L5;
        Handler r0 = new Handler(Looper.getMainLooper());
    L6:
        this.mHandler = r0;
        this.mLockoutResetIntent = lockoutResetIntent;
        this.mLockoutResetDispatcher = lockoutResetDispatcher;
        if (sensorProperties == null) goto L9;
        this.mSensorId = sensorProperties.sensorId;
        this.mSensorType = sensorProperties.sensorType;
    L9:
        context.registerReceiver(new AnonymousClass1(this), new IntentFilter(ACTION_LOCKOUT_RESET), "android.permission.RESET_FINGERPRINT_LOCKOUT", null, 2);
        return;
    L5:
        r0 = handler;
        goto L6
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public void resetFailedAttemptsForUser(boolean clearAttemptCounter, int userId) {
        if (getLockoutModeForUser(userId) == 0) goto L5;
        Slog.i(this.TAG, "Reset biometric lockout for user: " + userId + ", clearAttemptCounter: " + clearAttemptCounter);
    L5:
        if (clearAttemptCounter == false) goto L7;
        this.mFailedAttempts.put(userId, 0);
    L7:
        Slog.i(this.TAG, "resetFailedAttemptsForUser: userId=" + userId + ", mFailedAttempts=" + this.mFailedAttempts);
        this.mTimedLockoutCleared.put(userId, true);
        cancelLockoutResetForUser(userId);
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public void addFailedAttemptForUser(int userId) {
        this.mFailedAttempts.put(userId, this.mFailedAttempts.get(userId, 0) + 1);
        Slog.i(this.TAG, "addFailedAttemptForUser: userId=" + userId + ", mFailedAttempts=" + this.mFailedAttempts);
        this.mTimedLockoutCleared.put(userId, false);
        Slog.i(this.TAG, "addFailedAttemptForUser: " + userId + ", mFailedAttempts: " + this.mFailedAttempts);
        if (getLockoutModeForUser(userId) != 1) goto L6;
        scheduleLockoutResetForUser(userId);
        return;
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public int getLockoutModeForUser(int userId) {
        int failedAttempts = this.mFailedAttempts.get(userId, 0);
        int maxPermanent = getMaxFailedAttemptsLockoutPermanent();
        int maxTimed = getMaxFailedAttemptsLockoutTimed();
        if (failedAttempts < maxPermanent) goto L7;
        return 2;
    L7:
        if (failedAttempts > 0) goto L9;
    L14:
        return 0;
    L9:
        if (this.mTimedLockoutCleared.get(userId, false) == true) goto L14;
        if ((failedAttempts % maxTimed) != 0) goto L14;
        return 1;
    }

    private int getMaxFailedAttemptsLockoutPermanent() {
        if (this.mSensorType != 4) goto L6;
        return 150;
    L6:
        return 20;
    }

    private int getMaxFailedAttemptsLockoutTimed() {
        if (this.mSensorType != 4) goto L6;
        return 30;
    L6:
        return 5;
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public void setLockoutModeForUser(int userId, int mode) {
    }

    private void cancelLockoutResetForUser(int userId) {
        this.mAlarmManager.cancel(this.mLockoutResetIntent.apply(Integer.valueOf(userId)));
    }

    private void scheduleLockoutResetForUser(final int userId) {
        Slog.i(this.TAG, "scheduleLockoutResetForUser: " + userId);
        this.mHandler.post(new ZswLockoutTrackerImpl$$ExternalSyntheticLambda2(this, userId));
    }

    private /* synthetic */ void lambda$scheduleLockoutResetForUser$2(int userId) {
        this.mAlarmManager.setExact(2, SystemClock.elapsedRealtime() + 30000, this.mLockoutResetIntent.apply(Integer.valueOf(userId)));
    }
}
