package com.android.server.biometrics.log;

import android.content.Context;
import android.hardware.SensorManager;
import android.util.Slog;
import com.android.server.biometrics.AuthenticationStatsCollector;
import com.android.server.biometrics.Utils;

/* JADX INFO: loaded from: classes.dex */
public class BiometricLogger {
    public static final boolean DEBUG = false;
    public static final String TAG = "BiometricLogger";
    private final ALSProbe mALSProbe;
    private final AuthenticationStatsCollector mAuthenticationStatsCollector;
    private long mFirstAcquireTimeMs;
    private boolean mShouldLogMetrics;
    private final BiometricFrameworkStatsLogger mSink;
    private final int mStatsAction;
    private final int mStatsClient;
    private final int mStatsModality;

    public static BiometricLogger ofUnknown(Context context) {
        return new BiometricLogger(context, 0, 0, 0, null);
    }

    public BiometricLogger(Context context, int statsModality, int statsAction, int statsClient, AuthenticationStatsCollector authenticationStatsCollector) {
        this(statsModality, statsAction, statsClient, BiometricFrameworkStatsLogger.getInstance(), authenticationStatsCollector, (SensorManager) context.getSystemService(SensorManager.class));
    }

    BiometricLogger(int statsModality, int statsAction, int statsClient, BiometricFrameworkStatsLogger logSink, AuthenticationStatsCollector statsCollector, SensorManager sensorManager) {
        this.mShouldLogMetrics = true;
        this.mStatsModality = statsModality;
        this.mStatsAction = statsAction;
        this.mStatsClient = statsClient;
        this.mSink = logSink;
        this.mAuthenticationStatsCollector = statsCollector;
        this.mALSProbe = new ALSProbe(sensorManager);
    }

    public BiometricLogger swapAction(Context context, int statsAction) {
        return new BiometricLogger(context, this.mStatsModality, statsAction, this.mStatsClient, null);
    }

    public void disableMetrics() {
        this.mShouldLogMetrics = false;
        this.mALSProbe.destroy();
    }

    public int getStatsClient() {
        return this.mStatsClient;
    }

    private boolean shouldSkipLogging() {
        if (this.mStatsModality != 0) goto L5;
    L8:
        boolean shouldSkipLogging = true;
    L10:
        if (this.mStatsModality != 0) goto L13;
        Slog.w(TAG, "Unknown field detected: MODALITY_UNKNOWN, will not report metric");
    L13:
        if (this.mStatsAction != 0) goto L16;
        Slog.w(TAG, "Unknown field detected: ACTION_UNKNOWN, will not report metric");
    L16:
        if (this.mStatsClient != 0) goto L18;
        Slog.w(TAG, "Unknown field detected: CLIENT_UNKNOWN");
    L18:
        return shouldSkipLogging;
    L5:
        if (this.mStatsAction == 0) goto L8;
        shouldSkipLogging = false;
        goto L10
    }

    public void logOnAcquired(Context context, OperationContextExt operationContext, int acquiredInfo, int vendorCode, int targetUserId) {
        if (this.mShouldLogMetrics == true) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (this.mStatsModality != 4) goto L8;
        boolean r0 = true;
    L9:
        boolean isFace = r0;
        if (this.mStatsModality != 1) goto L12;
        r2 = true;
    L12:
        boolean isFingerprint = r2;
        if (isFace == true) goto L20;
        if (isFingerprint == true) goto L20;
        if (acquiredInfo != 0) goto L28;
        if (this.mFirstAcquireTimeMs != 0) goto L28;
        this.mFirstAcquireTimeMs = System.currentTimeMillis();
    L28:
        if (shouldSkipLogging() == false) goto L30;
        return;
    L30:
        this.mSink.acquired(operationContext, this.mStatsModality, this.mStatsAction, this.mStatsClient, Utils.isDebugEnabled(context, targetUserId), acquiredInfo, vendorCode, targetUserId);
        return;
    L20:
        if (isFingerprint == true) goto L22;
    L23:
        if (isFace == false) goto L28;
        if (acquiredInfo != 20) goto L28;
    L26:
        this.mFirstAcquireTimeMs = System.currentTimeMillis();
        goto L28
    L22:
        if (acquiredInfo == 7) goto L26;
    L8:
        r0 = false;
        goto L9
    }

    public void logOnError(Context context, OperationContextExt operationContext, int error, int vendorCode, int targetUserId) {
        if (this.mShouldLogMetrics == true) goto L6;
        return;
    L6:
        if (this.mFirstAcquireTimeMs == 0) goto L8;
        long r0 = System.currentTimeMillis() - this.mFirstAcquireTimeMs;
    L9:
        long latency = r0;
        Slog.v(TAG, "Error latency: " + latency);
        if (shouldSkipLogging() == false) goto L12;
        return;
    L12:
        this.mSink.error(operationContext, this.mStatsModality, this.mStatsAction, this.mStatsClient, Utils.isDebugEnabled(context, targetUserId), latency, error, vendorCode, targetUserId);
        return;
    L8:
        r0 = -1;
        goto L9
    }

    public void logOnAuthenticated(Context context, OperationContextExt operationContext, boolean authenticated, boolean requireConfirmation, int targetUserId, boolean isBiometricPrompt) {
        if (this.mShouldLogMetrics == true) goto L6;
        return;
    L6:
        if (this.mAuthenticationStatsCollector == null) goto L9;
        this.mAuthenticationStatsCollector.authenticate(targetUserId, authenticated);
    L9:
        if (authenticated == true) goto L11;
        int authState = 1;
    L16:
        if (this.mFirstAcquireTimeMs == 0) goto L18;
        long latency = System.currentTimeMillis() - this.mFirstAcquireTimeMs;
    L19:
        Slog.v(TAG, "Authentication latency: " + latency);
        if (shouldSkipLogging() == false) goto L22;
        return;
    L22:
        this.mSink.authenticate(operationContext, this.mStatsModality, this.mStatsAction, this.mStatsClient, Utils.isDebugEnabled(context, targetUserId), latency, authState, requireConfirmation, targetUserId, this.mALSProbe);
        return;
    L18:
        latency = -1;
        goto L19
    L11:
        if (isBiometricPrompt == false) goto L14;
        if (requireConfirmation == false) goto L14;
        authState = 2;
    L14:
        authState = 3;
        goto L16
    }

    public void logOnEnrolled(int targetUserId, long latency, boolean enrollSuccessful, int source, int templateId) {
        if (this.mShouldLogMetrics == true) goto L5;
        return;
    L5:
        Slog.v(TAG, "Enroll latency: " + latency);
        if (shouldSkipLogging() == false) goto L8;
        return;
    L8:
        this.mSink.enroll(this.mStatsModality, this.mStatsAction, this.mStatsClient, targetUserId, latency, enrollSuccessful, this.mALSProbe.getMostRecentLux(), source, templateId);
    }

    public void logOnUnEnrolled(int targetUserId, int reason, int templateId) {
        if (this.mShouldLogMetrics == true) goto L6;
        return;
    L6:
        if (shouldSkipLogging() == false) goto L8;
        return;
    L8:
        this.mSink.unenrolled(this.mStatsModality, targetUserId, reason, templateId);
    }

    public void logOnEnumerated(int targetUserId, int result, int[] templateIdsHal, int[] templateIdsFramework) {
        if (this.mShouldLogMetrics == true) goto L6;
        return;
    L6:
        if (shouldSkipLogging() == false) goto L8;
        return;
    L8:
        this.mSink.enumerated(this.mStatsModality, targetUserId, result, templateIdsHal, templateIdsFramework);
    }

    public void logUnknownEnrollmentInHal() {
        if (shouldSkipLogging() == false) goto L5;
        return;
    L5:
        this.mSink.reportUnknownTemplateEnrolledHal(this.mStatsModality);
    }

    public void logUnknownEnrollmentInFramework() {
        if (shouldSkipLogging() == false) goto L5;
        return;
    L5:
        this.mSink.reportUnknownTemplateEnrolledFramework(this.mStatsModality);
    }

    public void logFingerprintsLoe() {
        if (shouldSkipLogging() == false) goto L5;
        return;
    L5:
        this.mSink.reportFingerprintsLoe(this.mStatsModality);
    }

    public CallbackWithProbe<Probe> getAmbientLightProbe(boolean startWithClient) {
        return new CallbackWithProbe(this.mALSProbe, startWithClient);
    }
}
