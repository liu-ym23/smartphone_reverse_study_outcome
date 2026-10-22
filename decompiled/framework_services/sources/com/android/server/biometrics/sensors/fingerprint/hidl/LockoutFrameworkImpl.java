package com.android.server.biometrics.sensors.fingerprint.hidl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.android.server.biometrics.sensors.LockoutTracker;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public class LockoutFrameworkImpl implements LockoutTracker {
    private static final String ACTION_LOCKOUT_RESET = "com.android.server.biometrics.sensors.fingerprint.ACTION_LOCKOUT_RESET";
    private static final long FAIL_LOCKOUT_TIMEOUT_MS = 30000;
    private static final String KEY_LOCKOUT_RESET_USER = "lockout_reset_user";
    private static final int MAX_FAILED_ATTEMPTS_LOCKOUT_PERMANENT = 20;
    private static final int MAX_FAILED_ATTEMPTS_LOCKOUT_TIMED = 5;
    private static final String TAG = "LockoutFrameworkImpl";
    private final AlarmManager mAlarmManager;
    private final SparseIntArray mFailedAttempts;
    private final Handler mHandler;
    private final LockoutReceiver mLockoutReceiver;
    private final LockoutResetCallback mLockoutResetCallback;
    private final Function<Integer, PendingIntent> mLockoutResetIntent;
    private final SparseBooleanArray mTimedLockoutCleared;

    private final class LockoutReceiver extends BroadcastReceiver {
        final /* synthetic */ LockoutFrameworkImpl this$0;

        /* synthetic */ LockoutReceiver(LockoutFrameworkImpl r1, LockoutFrameworkImplIA r2) {
            this(r1);
        }

        private LockoutReceiver(LockoutFrameworkImpl r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Slog.v(LockoutFrameworkImpl.TAG, "Resetting lockout: " + intent.getAction());
            if (LockoutFrameworkImpl.ACTION_LOCKOUT_RESET.equals(intent.getAction()) == false) goto L6;
            int user = intent.getIntExtra(LockoutFrameworkImpl.KEY_LOCKOUT_RESET_USER, 0);
            this.this$0.resetFailedAttemptsForUser(false, user);
            return;
        }
    }

    public interface LockoutResetCallback {
        void onLockoutReset(int r1);
    }

    public static /* synthetic */ void $r8$lambda$Tgc87nh1VusqHmBvdWU4lKurth8(LockoutFrameworkImpl r0, int r1) {
        r0.lambda$scheduleLockoutResetForUser$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Uc-wEIk5KRpiCiNMfTLyrucvgHU, reason: not valid java name */
    public static /* synthetic */ PendingIntent m2754$r8$lambda$UcwEIk5KRpiCiNMfTLyrucvgHU(Context r0, Integer r1) {
        return lambda$new$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$XRQspbOzscHbvfhI-dGUGlcj390, reason: not valid java name */
    public static /* synthetic */ PendingIntent m2755$r8$lambda$XRQspbOzscHbvfhIdGUGlcj390(Context r0, Integer r1) {
        return lambda$new$0(r0, r1);
    }

    public LockoutFrameworkImpl(final Context context, LockoutResetCallback lockoutResetCallback) {
        this(context, lockoutResetCallback, new LockoutFrameworkImpl$$ExternalSyntheticLambda0(context), null);
    }

    private static /* synthetic */ PendingIntent lambda$new$0(Context context, Integer userId) {
        return PendingIntent.getBroadcast(context, userId.intValue(), new Intent(ACTION_LOCKOUT_RESET).putExtra(KEY_LOCKOUT_RESET_USER, userId), AudioFormat.DTS_HD);
    }

    public LockoutFrameworkImpl(final Context context, LockoutResetCallback lockoutResetCallback, Handler handler) {
        this(context, lockoutResetCallback, new LockoutFrameworkImpl$$ExternalSyntheticLambda2(context), handler);
    }

    private static /* synthetic */ PendingIntent lambda$new$1(Context context, Integer userId) {
        return PendingIntent.getBroadcast(context, userId.intValue(), new Intent(ACTION_LOCKOUT_RESET).putExtra(KEY_LOCKOUT_RESET_USER, userId), AudioFormat.DTS_HD);
    }

    LockoutFrameworkImpl(Context context, LockoutResetCallback lockoutResetCallback, Function<Integer, PendingIntent> lockoutResetIntent, Handler handler) {
        this.mLockoutResetCallback = lockoutResetCallback;
        this.mTimedLockoutCleared = new SparseBooleanArray();
        this.mFailedAttempts = new SparseIntArray();
        this.mAlarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
        this.mLockoutReceiver = new LockoutReceiver(this, null);
        if (handler != null) goto L5;
        Handler r0 = new Handler(Looper.getMainLooper());
    L6:
        this.mHandler = r0;
        this.mLockoutResetIntent = lockoutResetIntent;
        context.registerReceiver(this.mLockoutReceiver, new IntentFilter(ACTION_LOCKOUT_RESET), "android.permission.RESET_FINGERPRINT_LOCKOUT", null, 2);
        return;
    L5:
        r0 = handler;
        goto L6
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public void resetFailedAttemptsForUser(boolean clearAttemptCounter, int userId) {
        if (getLockoutModeForUser(userId) == 0) goto L5;
        Slog.v(TAG, "Reset biometric lockout for user: " + userId + ", clearAttemptCounter: " + clearAttemptCounter);
    L5:
        if (clearAttemptCounter == false) goto L7;
        this.mFailedAttempts.put(userId, 0);
    L7:
        this.mTimedLockoutCleared.put(userId, true);
        cancelLockoutResetForUser(userId);
        this.mLockoutResetCallback.onLockoutReset(userId);
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public void addFailedAttemptForUser(int userId) {
        this.mFailedAttempts.put(userId, this.mFailedAttempts.get(userId, 0) + 1);
        this.mTimedLockoutCleared.put(userId, false);
        if (getLockoutModeForUser(userId) == 0) goto L6;
        scheduleLockoutResetForUser(userId);
        return;
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public int getLockoutModeForUser(int userId) {
        int failedAttempts = this.mFailedAttempts.get(userId, 0);
        if (failedAttempts < 20) goto L7;
        return 2;
    L7:
        if (failedAttempts > 0) goto L9;
    L14:
        return 0;
    L9:
        if (this.mTimedLockoutCleared.get(userId, false) == true) goto L14;
        if ((failedAttempts % 5) != 0) goto L14;
        return 1;
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public void setLockoutModeForUser(int userId, int mode) {
    }

    private void cancelLockoutResetForUser(int userId) {
        this.mAlarmManager.cancel(this.mLockoutResetIntent.apply(Integer.valueOf(userId)));
    }

    private void scheduleLockoutResetForUser(final int userId) {
        this.mHandler.post(new LockoutFrameworkImpl$$ExternalSyntheticLambda1(this, userId));
    }

    private /* synthetic */ void lambda$scheduleLockoutResetForUser$2(int userId) {
        this.mAlarmManager.setExact(2, SystemClock.elapsedRealtime() + 30000, this.mLockoutResetIntent.apply(Integer.valueOf(userId)));
    }
}
