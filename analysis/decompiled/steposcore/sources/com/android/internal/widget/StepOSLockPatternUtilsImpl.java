package com.android.internal.widget;

import android.app.ActivityManager;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.widget.LockPatternUtils;
import stepos.app.StepOSLockSettingsManager;

/* loaded from: classes.dex */
public class StepOSLockPatternUtilsImpl implements StepOSLockPatternUtilsStub {
    private static final String LOCKOUT_ATTEMPT_DEADLINE = "lockscreen.lockoutattemptdeadline";
    private static final String LOCKOUT_ATTEMPT_TIMEOUT_MS = "lockscreen.lockoutattempttimeoutmss";
    private static final String TAG = "StepOSLockPatternUtilsImpl";

    private void throwIfCalledOnMainThread() {
        if (Looper.getMainLooper().isCurrentThread()) {
            throw new IllegalStateException("should not be called from the main thread.");
        }
    }

    public boolean checkPassword(LockPatternUtils lockPatternUtils, String password, int userId) {
        LockscreenCredential credential;
        throwIfCalledOnMainThread();
        if (TextUtils.isEmpty(password)) {
            credential = LockscreenCredential.createNone();
        } else if (lockPatternUtils.getCredentialTypeForUser(userId) == 3) {
            credential = LockscreenCredential.createPin(password);
        } else {
            credential = LockscreenCredential.createPassword(password);
        }
        try {
            return lockPatternUtils.checkCredential(credential, userId, (LockPatternUtils.CheckCredentialProgressCallback) null);
        } catch (LockPatternUtils.RequestThrottledException e) {
            Log.e(TAG, "Failed to check password", e);
            return false;
        }
    }

    public boolean setStepOSPassword(LockPatternUtils lpu, int type, String password) {
        return StepOSLockSettingsManager.get().setStepOSPassword(type, password, ActivityManager.getCurrentUser());
    }

    public boolean checkStepOSPassword(LockPatternUtils lpu, int type, String password) {
        return StepOSLockSettingsManager.get().checkStepOSPassword(type, password, ActivityManager.getCurrentUser());
    }

    public boolean hasStepOSPassword(LockPatternUtils lpu, int type) {
        return StepOSLockSettingsManager.get().hasStepOSPassword(type, ActivityManager.getCurrentUser());
    }

    public boolean clearStepOSPassword(LockPatternUtils lpu, int type) {
        return StepOSLockSettingsManager.get().clearStepOSPassword(type, ActivityManager.getCurrentUser());
    }

    public void writePasswordHash(LockPatternUtils lpu, byte[] hash, int type, int userId) {
        StepOSLockSettingsManager.get().writePasswordHash(hash, type, userId);
    }

    public void onCredentialChanged(int credentialType, int userId) {
        if (credentialType == -1) {
            Log.d(TAG, "Credential cleared for userId=" + userId + ", resetting FindPhone left times");
            StepOSLockSettingsManager.get().stepOSProcessLeftTimes(true);
        }
    }

    private long getLong(LockPatternUtils lpu, String key, long defaultValue, int userId) {
        try {
            return lpu.getLockSettings().getLong(key, defaultValue, userId);
        } catch (RemoteException e) {
            return defaultValue;
        }
    }

    private void setLong(LockPatternUtils lpu, String key, long value, int userId) {
        try {
            lpu.getLockSettings().setLong(key, value, userId);
        } catch (RemoteException re) {
            Log.e(TAG, "Couldn't write long " + key + re);
        }
    }

    public void setLockoutAttemptDeadlineInLockSettings(LockPatternUtils lpu, int userId, long deadline, long timeoutMs) {
        setLong(lpu, LOCKOUT_ATTEMPT_DEADLINE, deadline, userId);
        setLong(lpu, LOCKOUT_ATTEMPT_TIMEOUT_MS, timeoutMs, userId);
        try {
            SystemProperties.set("persist.sys.password.deadline", String.valueOf(deadline));
            SystemProperties.set("persist.sys.password.timeout", String.valueOf(timeoutMs));
        } catch (Exception e) {
            Log.e(TAG, "Failed to set persist.sys.password.deadline/timeout for userId=" + userId + ", deadline=" + deadline + ", timeout=" + timeoutMs, e);
        }
    }

    public long getLockoutAttemptDeadlineFromLockSettings(LockPatternUtils lpu, int userId) {
        long deadline = getLong(lpu, LOCKOUT_ATTEMPT_DEADLINE, 0L, userId);
        long timeoutMs = getLong(lpu, LOCKOUT_ATTEMPT_TIMEOUT_MS, 0L, userId);
        long now = SystemClock.elapsedRealtime();
        if (deadline < now && deadline != 0) {
            setLong(lpu, LOCKOUT_ATTEMPT_DEADLINE, 0L, userId);
            setLong(lpu, LOCKOUT_ATTEMPT_TIMEOUT_MS, 0L, userId);
            return 0L;
        }
        if (deadline > now + timeoutMs) {
            long deadline2 = now + timeoutMs;
            setLong(lpu, LOCKOUT_ATTEMPT_DEADLINE, deadline2, userId);
            return deadline2;
        }
        return deadline;
    }
}
