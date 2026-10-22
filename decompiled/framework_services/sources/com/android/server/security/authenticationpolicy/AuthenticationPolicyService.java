package com.android.server.security.authenticationpolicy;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.biometrics.AuthenticationStateListener;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Slog;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockSettingsInternal;
import com.android.internal.widget.LockSettingsStateListener;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.wm.WindowManagerInternal;

/* JADX INFO: loaded from: classes3.dex */
public class AuthenticationPolicyService extends SystemService {
    private static final int AUTH_FAILURE = 0;
    private static final int AUTH_SUCCESS = 1;
    private static final boolean DEBUG = false;
    static final int MAX_ALLOWED_FAILED_AUTH_ATTEMPTS = 5;
    private static final int MSG_REPORT_BIOMETRIC_AUTH_ATTEMPT = 2;
    private static final int MSG_REPORT_PRIMARY_AUTH_ATTEMPT = 1;
    private static final String TAG = "AuthenticationPolicyService";
    private static final int TYPE_BIOMETRIC_AUTH = 1;
    private static final int TYPE_PRIMARY_AUTH = 0;
    private final AuthenticationStateListener mAuthenticationStateListener;
    private final BiometricManager mBiometricManager;
    final SparseIntArray mFailedAttemptsForUser;
    private final Handler mHandler;
    private final KeyguardManager mKeyguardManager;
    private final SparseLongArray mLastLockedTimestamp;
    private final LockPatternUtils mLockPatternUtils;
    private final LockSettingsInternal mLockSettings;
    private final LockSettingsStateListener mLockSettingsStateListener;
    private SecureLockDeviceServiceInternal mSecureLockDeviceService;
    private final IBinder mService;
    private final UserManagerInternal mUserManager;
    private final WindowManagerInternal mWindowManager;

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8039$$Nest$fgetmHandler(AuthenticationPolicyService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSecureLockDeviceService, reason: not valid java name */
    static /* bridge */ /* synthetic */ SecureLockDeviceServiceInternal m8040$$Nest$fgetmSecureLockDeviceService(AuthenticationPolicyService r0) {
        return r0.mSecureLockDeviceService;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleReportBiometricAuthAttempt, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8041$$Nest$mhandleReportBiometricAuthAttempt(AuthenticationPolicyService r0, boolean r1, int r2) {
        r0.handleReportBiometricAuthAttempt(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleReportPrimaryAuthAttempt, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8042$$Nest$mhandleReportPrimaryAuthAttempt(AuthenticationPolicyService r0, boolean r1, int r2) {
        r0.handleReportPrimaryAuthAttempt(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8043$$Nest$sfgetDEBUG() {
        return DEBUG;
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

    public AuthenticationPolicyService(Context context) {
        this(context, new LockPatternUtils(context));
    }

    public AuthenticationPolicyService(Context context, LockPatternUtils lockPatternUtils) {
        super(context);
        this.mFailedAttemptsForUser = new SparseIntArray();
        this.mLastLockedTimestamp = new SparseLongArray();
        this.mLockSettingsStateListener = new AnonymousClass1(this);
        this.mAuthenticationStateListener = new AnonymousClass2(this);
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass3(this, r1);
        this.mService = new AnonymousClass4(this);
        this.mLockPatternUtils = lockPatternUtils;
        LockSettingsInternal r0 = (LockSettingsInternal) LocalServices.getService(LockSettingsInternal.class);
        r0.getClass();
        this.mLockSettings = r0;
        BiometricManager r2 = (BiometricManager) context.getSystemService(BiometricManager.class);
        r2.getClass();
        this.mBiometricManager = r2;
        KeyguardManager r3 = (KeyguardManager) context.getSystemService(KeyguardManager.class);
        r3.getClass();
        this.mKeyguardManager = r3;
        WindowManagerInternal r4 = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        r4.getClass();
        this.mWindowManager = r4;
        UserManagerInternal r5 = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        r5.getClass();
        this.mUserManager = r5;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("authentication_policy", this.mService);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        init();
        return;
    }

    void init() {
        this.mLockSettings.registerLockSettingsStateListener(this.mLockSettingsStateListener);
        this.mBiometricManager.registerAuthenticationStateListener(this.mAuthenticationStateListener);
    }

    private void handleReportPrimaryAuthAttempt(boolean success, int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "handleReportPrimaryAuthAttempt: success=" + success + ", userId=" + userId);
    L5:
        reportAuthAttempt(0, success, userId);
    }

    private void handleReportBiometricAuthAttempt(boolean success, int userId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "handleReportBiometricAuthAttempt: success=" + success + ", userId=" + userId);
    L5:
        reportAuthAttempt(1, success, userId);
    }

    private void reportAuthAttempt(int authType, boolean success, int userId) {
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L5;
        return;
    L5:
        if (success == false) goto L10;
        this.mFailedAttemptsForUser.delete(userId);
        if (this.mLastLockedTimestamp.indexOfKey(userId) < 0) goto L22;
        long lastLockedTime = this.mLastLockedTimestamp.get(userId);
        collectTimeElapsedSinceLastLocked(lastLockedTime, SystemClock.elapsedRealtime(), authType);
        this.mLastLockedTimestamp.delete(userId);
        return;
    L22:
        return;
    L10:
        int numFailedAttempts = this.mFailedAttemptsForUser.get(userId, 0) + 1;
        Slog.i(TAG, "reportAuthAttempt: numFailedAttempts=" + numFailedAttempts + ", userId=" + userId);
        this.mFailedAttemptsForUser.put(userId, numFailedAttempts);
        if (this.mKeyguardManager.isDeviceLocked(userId) == false) goto L17;
        if (this.mKeyguardManager.isKeyguardLocked() == false) goto L17;
        Slog.d(TAG, "Not locking the device because the device is already locked.");
        return;
    L17:
        if (numFailedAttempts >= 5) goto L20;
        Slog.d(TAG, "Not locking the device because the number of failed attempts is below the threshold.");
        return;
    L20:
        lockDevice(userId);
    }

    private static void collectTimeElapsedSinceLastLocked(long lastLockedTime, long authTime, int authType) {
        switch(authType) {
            case 0: goto L5;
            case 1: goto L4;
            default: goto L3;
        };
    L3:
        int r0 = 0;
    L6:
        int unlockType = r0;
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "collectTimeElapsedSinceLastLockedForUser: lastLockedTime=" + lastLockedTime + ", authTime=" + authTime + ", unlockType=" + unlockType);
    L10:
        if (lastLockedTime <= authTime) goto L12;
        return;
    L12:
        FrameworkStatsLog.write(FrameworkStatsLog.ADAPTIVE_AUTH_UNLOCK_AFTER_LOCK_REPORTED, lastLockedTime, authTime, unlockType);
        return;
    L4:
        r0 = 2;
        goto L6
    L5:
        r0 = 1;
        goto L6
    }

    private void lockDevice(int userId) {
        this.mLockPatternUtils.requireStrongAuth(512, userId);
        int parentUserId = this.mUserManager.getProfileParentId(userId);
        Slog.i(TAG, "lockDevice: userId=" + userId + ", parentUserId=" + parentUserId);
        if (parentUserId == userId) goto L5;
        this.mLockPatternUtils.requireStrongAuth(512, parentUserId);
    L5:
        this.mLastLockedTimestamp.put(userId, SystemClock.elapsedRealtime());
    }
}
