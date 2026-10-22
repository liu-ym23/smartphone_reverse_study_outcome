package com.android.server.biometrics;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.FingerprintManager;
import android.util.Slog;
import com.android.server.biometrics.sensors.BiometricNotification;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AuthenticationStatsCollector {
    public static final String ACTION_LAST_ENROLL_TIME_CHANGED = "last_enroll_time_changed";
    private static final int AUTHENTICATION_UPLOAD_INTERVAL = 50;
    public static final String EXTRA_MODALITY = "modality";
    static final Duration FRR_MINIMAL_DURATION = null;
    static final int MAXIMUM_ENROLLMENT_NOTIFICATIONS = 0;
    private static final int MINIMUM_ATTEMPTS = 150;
    private static final String TAG = "AuthenticationStatsCollector";
    private AuthenticationStatsPersister mAuthenticationStatsPersister;
    private BiometricNotification mBiometricNotification;
    private final BroadcastReceiver mBroadcastReceiver;
    private final Clock mClock;
    private final Context mContext;
    private final boolean mEnabled;
    private final BroadcastReceiver mEnrollTimeUpdatedReceiver;
    private final FaceManager mFaceManager;
    private final FingerprintManager mFingerprintManager;
    private final int mModality;
    private final PackageManager mPackageManager;
    private final float mThreshold;
    private final Map<Integer, AuthenticationStats> mUserAuthenticationStatsMap;

    /* JADX INFO: renamed from: -$$Nest$fgetmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Clock m2559$$Nest$fgetmClock(AuthenticationStatsCollector r0) {
        return r0.mClock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModality, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2560$$Nest$fgetmModality(AuthenticationStatsCollector r0) {
        return r0.mModality;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserAuthenticationStatsMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m2561$$Nest$fgetmUserAuthenticationStatsMap(AuthenticationStatsCollector r0) {
        return r0.mUserAuthenticationStatsMap;
    }

    /* JADX INFO: renamed from: -$$Nest$monUserRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2562$$Nest$monUserRemoved(AuthenticationStatsCollector r0, int r1) {
        r0.onUserRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAuthenticationStatsMapIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2563$$Nest$mupdateAuthenticationStatsMapIfNeeded(AuthenticationStatsCollector r0, int r1) {
        r0.updateAuthenticationStatsMapIfNeeded(r1);
    }

    static {
        MAXIMUM_ENROLLMENT_NOTIFICATIONS = 1;
        FRR_MINIMAL_DURATION = Duration.ofDays(7);
    }

    public AuthenticationStatsCollector(Context context, int modality, BiometricNotification biometricNotification, Clock clock) {
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mEnrollTimeUpdatedReceiver = new AnonymousClass2(this);
        this.mContext = context;
        this.mEnabled = context.getResources().getBoolean(R.bool.config_brightWhenDozing);
        this.mThreshold = context.getResources().getFraction(R.fraction.config_biometricNotificationFrrThreshold, 1, 1);
        this.mUserAuthenticationStatsMap = new HashMap();
        this.mModality = modality;
        this.mBiometricNotification = biometricNotification;
        this.mClock = clock;
        this.mPackageManager = context.getPackageManager();
        this.mFaceManager = (FaceManager) this.mContext.getSystemService(FaceManager.class);
        this.mFingerprintManager = (FingerprintManager) this.mContext.getSystemService(FingerprintManager.class);
        this.mAuthenticationStatsPersister = new AuthenticationStatsPersister(this.mContext);
        initializeUserAuthenticationStatsMap();
        this.mAuthenticationStatsPersister.persistFrrThreshold(this.mThreshold);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_REMOVED");
        context.registerReceiver(this.mBroadcastReceiver, intentFilter);
        IntentFilter enrollTimeChangedFilter = new IntentFilter();
        enrollTimeChangedFilter.addAction(ACTION_LAST_ENROLL_TIME_CHANGED);
        context.registerReceiver(this.mEnrollTimeUpdatedReceiver, enrollTimeChangedFilter, 4);
    }

    private void initializeUserAuthenticationStatsMap() {
        Iterator<AuthenticationStats> r0 = this.mAuthenticationStatsPersister.getAllFrrStats(this.mModality).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AuthenticationStats stats = r0.next();
        this.mUserAuthenticationStatsMap.put(Integer.valueOf(stats.getUserId()), stats);
        goto L4
    }

    public void authenticate(int userId, boolean authenticated) {
        if (this.mEnabled == true) goto L6;
        return;
    L6:
        if (isSingleModalityDevice() == false) goto L8;
        return;
    L8:
        if (hasEnrolledFace(userId) == true) goto L10;
    L12:
        updateAuthenticationStatsMapIfNeeded(userId);
        AuthenticationStats authenticationStats = this.mUserAuthenticationStatsMap.get(Integer.valueOf(userId));
        if (authenticationStats.getEnrollmentNotifications() < MAXIMUM_ENROLLMENT_NOTIFICATIONS) goto L15;
        return;
    L15:
        authenticationStats.authenticate(authenticated);
        sendNotificationIfNeeded(userId);
        persistDataIfNeeded(userId);
        return;
    L10:
        if (hasEnrolledFingerprint(userId) == false) goto L12;
    }

    private void updateAuthenticationStatsMapIfNeeded(int userId) {
        if (this.mUserAuthenticationStatsMap.isEmpty() == false) goto L6;
        initializeUserAuthenticationStatsMap();
    L6:
        if (this.mUserAuthenticationStatsMap.containsKey(Integer.valueOf(userId)) == true) goto L9;
        this.mUserAuthenticationStatsMap.put(Integer.valueOf(userId), new AuthenticationStats(userId, this.mModality));
        return;
    }

    private void sendNotificationIfNeeded(int userId) {
        AuthenticationStats authenticationStats = this.mUserAuthenticationStatsMap.get(Integer.valueOf(userId));
        if (authenticationStats.getTotalAttempts() >= 150) goto L6;
        return;
    L6:
        if (authenticationStats.getEnrollmentNotifications() < MAXIMUM_ENROLLMENT_NOTIFICATIONS) goto L8;
    L10:
        boolean showFrr = false;
    L12:
        if (showFrr == true) goto L15;
        authenticationStats.resetData();
        return;
    L15:
        authenticationStats.resetData();
        boolean hasEnrolledFace = hasEnrolledFace(userId);
        boolean hasEnrolledFingerprint = hasEnrolledFingerprint(userId);
        if (hasEnrolledFace == false) goto L19;
        if (hasEnrolledFingerprint == true) goto L19;
        this.mBiometricNotification.sendFpEnrollNotification(this.mContext);
        authenticationStats.updateLastFrrNotificationTime(this.mClock.millis());
        authenticationStats.updateNotificationCounter();
        return;
    L19:
        if (hasEnrolledFace == true) goto L24;
        if (hasEnrolledFingerprint == false) goto L25;
        this.mBiometricNotification.sendFaceEnrollNotification(this.mContext);
        authenticationStats.updateLastFrrNotificationTime(this.mClock.millis());
        authenticationStats.updateNotificationCounter();
        return;
    L25:
        return;
    L24:
        return;
    L8:
        if (authenticationStats.getFrr() < this.mThreshold) goto L10;
        showFrr = true;
        goto L12
    }

    private boolean isFrrMinimalDurationPassed(long previousMillis) {
        Instant previous = Instant.ofEpochMilli(previousMillis);
        long nowMillis = this.mClock.millis();
        Instant now = Instant.ofEpochMilli(nowMillis);
        if (now.isAfter(previous) == false) goto L9;
        Duration between = Duration.between(previous, now);
        if (between.compareTo(FRR_MINIMAL_DURATION) <= 0) goto L8;
        return true;
    L8:
        Slog.d(TAG, "isFrrMinimalDurationPassed, duration too short");
        return false;
    L9:
        Slog.d(TAG, "isFrrMinimalDurationPassed, date not match");
        return false;
    }

    private void persistDataIfNeeded(int userId) {
        AuthenticationStats authenticationStats = this.mUserAuthenticationStatsMap.get(Integer.valueOf(userId));
        if ((authenticationStats.getTotalAttempts() % 50) != 0) goto L6;
        this.mAuthenticationStatsPersister.persistFrrStats(authenticationStats.getUserId(), authenticationStats.getTotalAttempts(), authenticationStats.getRejectedAttempts(), authenticationStats.getEnrollmentNotifications(), authenticationStats.getLastEnrollmentTime(), authenticationStats.getLastFrrNotificationTime(), authenticationStats.getModality());
        return;
    }

    public void sendFaceReEnrollNotification() {
        this.mBiometricNotification.sendFaceEnrollNotification(this.mContext);
    }

    public void sendFingerprintReEnrollNotification() {
        this.mBiometricNotification.sendFpEnrollNotification(this.mContext);
    }

    private void onUserRemoved(int userId) {
        this.mUserAuthenticationStatsMap.remove(Integer.valueOf(userId));
        this.mAuthenticationStatsPersister.removeFrrStats(userId);
    }

    private boolean isSingleModalityDevice() {
        if (this.mPackageManager.hasSystemFeature("android.hardware.fingerprint") == true) goto L5;
    L8:
        return true;
    L5:
        if (this.mPackageManager.hasSystemFeature("android.hardware.biometrics.face") == false) goto L8;
        return false;
    }

    private boolean hasEnrolledFace(int userId) {
        if (this.mFaceManager != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mFaceManager.hasEnrolledTemplates(userId) == false) goto L7;
        return true;
    }

    private boolean hasEnrolledFingerprint(int userId) {
        if (this.mFingerprintManager != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mFingerprintManager.hasEnrolledTemplates(userId) == false) goto L7;
        return true;
    }

    AuthenticationStats getAuthenticationStatsForUser(int userId) {
        return this.mUserAuthenticationStatsMap.getOrDefault(Integer.valueOf(userId), null);
    }

    void setAuthenticationStatsForUser(int userId, AuthenticationStats authenticationStats) {
        this.mUserAuthenticationStatsMap.put(Integer.valueOf(userId), authenticationStats);
    }
}
