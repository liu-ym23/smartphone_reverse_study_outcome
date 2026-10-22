package com.android.server.biometrics.log;

import android.hardware.biometrics.common.AuthenticateReason;
import android.hardware.biometrics.common.OperationContext;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class BiometricFrameworkStatsLogger {
    private static final String TAG = "BiometricFrameworkStatsLogger";
    private static final BiometricFrameworkStatsLogger sInstance = null;

    public static /* synthetic */ int $r8$lambda$66kbtPMDMvRPXfV6O_t300MEgkw(Integer r0) {
        return lambda$toProtoWakeReasonDetails$1(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$abVN1EGVqWySyl1Pu5PYaB3KO0A(int r0) {
        return lambda$toProtoWakeReasonDetails$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$bkHYB9CplNafjbDRFHoMLLhJOck(BiometricFrameworkStatsLogger r0, OperationContextExt r1, int r2, int r3, int r4, boolean r5, long r6, int r8, boolean r9, int r10, Float r11) {
        r0.lambda$authenticate$0(r1, r2, r3, r4, r5, r6, r8, r9, r10, r11);
    }

    static {
        sInstance = new BiometricFrameworkStatsLogger();
    }

    private BiometricFrameworkStatsLogger() {
    }

    public static BiometricFrameworkStatsLogger getInstance() {
        return sInstance;
    }

    public void acquired(OperationContextExt operationContext, int statsModality, int statsAction, int statsClient, boolean isDebug, int acquiredInfo, int vendorCode, int targetUserId) {
        FrameworkStatsLog.write(87, statsModality, targetUserId, operationContext.isCrypto(), statsAction, statsClient, acquiredInfo, vendorCode, isDebug, -1, operationContext.getId(), sessionType(operationContext.getReason()), operationContext.isAod(), operationContext.isDisplayOn(), operationContext.getDockState(), orientationType(operationContext.getOrientation()), foldType(operationContext.getFoldState()), operationContext.getOrderAndIncrement(), toProtoWakeReason(operationContext));
    }

    public void authenticate(OperationContextExt operationContext, int statsModality, int statsAction, int statsClient, boolean isDebug, long latency, int authState, boolean requireConfirmation, int targetUserId, float ambientLightLux) {
        FrameworkStatsLog.write(88, statsModality, targetUserId, operationContext.isCrypto(), statsClient, requireConfirmation, authState, sanitizeLatency(latency), isDebug, -1, ambientLightLux, operationContext.getId(), sessionType(operationContext.getReason()), operationContext.isAod(), operationContext.isDisplayOn(), operationContext.getDockState(), orientationType(operationContext.getOrientation()), foldType(operationContext.getFoldState()), operationContext.getOrderAndIncrement(), toProtoWakeReason(operationContext), toProtoWakeReasonDetails(operationContext), operationContext.getIsMandatoryBiometrics());
    }

    public void authenticate(final OperationContextExt operationContext, final int statsModality, final int statsAction, final int statsClient, final boolean isDebug, final long latency, final int authState, final boolean requireConfirmation, final int targetUserId, ALSProbe alsProbe) {
        alsProbe.awaitNextLux(new BiometricFrameworkStatsLogger$$ExternalSyntheticLambda0(this, operationContext, statsModality, statsAction, statsClient, isDebug, latency, authState, requireConfirmation, targetUserId), null);
    }

    private /* synthetic */ void lambda$authenticate$0(OperationContextExt operationContext, int statsModality, int statsAction, int statsClient, boolean isDebug, long latency, int authState, boolean requireConfirmation, int targetUserId, Float ambientLightLux) {
        authenticate(operationContext, statsModality, statsAction, statsClient, isDebug, latency, authState, requireConfirmation, targetUserId, ambientLightLux.floatValue());
    }

    public void enroll(int statsModality, int statsAction, int statsClient, int targetUserId, long latency, boolean enrollSuccessful, float ambientLightLux, int source, int templateId) {
        FrameworkStatsLog.write(184, statsModality, targetUserId, sanitizeLatency(latency), enrollSuccessful, -1, ambientLightLux, source, templateId);
    }

    public void unenrolled(int statsModality, int targetUserId, int reason, int templateId) {
        FrameworkStatsLog.write(FrameworkStatsLog.BIOMETRIC_UNENROLLED, statsModality, targetUserId, reason, templateId);
    }

    public void enumerated(int statsModality, int targetUserId, int result, int[] templateIdsHal, int[] templateIdsFramework) {
        FrameworkStatsLog.write(FrameworkStatsLog.BIOMETRIC_ENUMERATED, statsModality, targetUserId, result, templateIdsHal, templateIdsFramework);
    }

    public void error(OperationContextExt operationContext, int statsModality, int statsAction, int statsClient, boolean isDebug, long latency, int error, int vendorCode, int targetUserId) {
        FrameworkStatsLog.write(89, statsModality, targetUserId, operationContext.isCrypto(), statsAction, statsClient, error, vendorCode, isDebug, sanitizeLatency(latency), -1, operationContext.getId(), sessionType(operationContext.getReason()), operationContext.isAod(), operationContext.isDisplayOn(), operationContext.getDockState(), orientationType(operationContext.getOrientation()), foldType(operationContext.getFoldState()), operationContext.getOrderAndIncrement(), toProtoWakeReason(operationContext), toProtoWakeReasonDetails(operationContext), operationContext.getIsMandatoryBiometrics());
    }

    static int[] toProtoWakeReasonDetails(OperationContextExt operationContext) {
        OperationContext ctx = operationContext.toAidlContext();
        return Stream.of(Integer.valueOf(toProtoWakeReasonDetails(ctx.authenticateReason))).mapToInt(new BiometricFrameworkStatsLogger$$ExternalSyntheticLambda1()).filter(new BiometricFrameworkStatsLogger$$ExternalSyntheticLambda2()).toArray();
    }

    private static /* synthetic */ int lambda$toProtoWakeReasonDetails$1(Integer i) {
        return i.intValue();
    }

    private static /* synthetic */ boolean lambda$toProtoWakeReasonDetails$2(int i) {
        if (i == 0) goto L4;
        return true;
    L4:
        return false;
    }

    static int toProtoWakeReason(OperationContextExt operationContext) {
        int reason = operationContext.getWakeReason();
        switch(reason) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 9;
    L8:
        return 8;
    L10:
        return 7;
    L12:
        return 6;
    L14:
        return 5;
    L16:
        return 4;
    L18:
        return 3;
    L20:
        return 2;
    L22:
        return 1;
    }

    private static int toProtoWakeReasonDetails(AuthenticateReason reason) {
        if (reason != null) goto L4;
        return 0;
    L4:
        switch(reason.getTag()) {
            case 1: goto L7;
            default: goto L10;
        };
    L10:
        return 0;
    L7:
        return toProtoWakeReasonDetailsFromFace(reason.getFaceAuthenticateReason());
    }

    private static int toProtoWakeReasonDetailsFromFace(int reason) {
        switch(reason) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            case 10: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 10;
    L7:
        return 9;
    L9:
        return 8;
    L11:
        return 7;
    L13:
        return 6;
    L15:
        return 5;
    L17:
        return 4;
    L19:
        return 3;
    L21:
        return 2;
    L23:
        return 1;
    }

    public void reportUnknownTemplateEnrolledHal(int statsModality) {
        FrameworkStatsLog.write(148, statsModality, 3, -1);
    }

    public void reportUnknownTemplateEnrolledFramework(int statsModality) {
        FrameworkStatsLog.write(148, statsModality, 2, -1);
    }

    public void reportFingerprintsLoe(int statsModality) {
        FrameworkStatsLog.write(148, statsModality, 5, -1);
    }

    public void logFrameworkNotification(int action, int modality) {
        FrameworkStatsLog.write(FrameworkStatsLog.BIOMETRIC_FRR_NOTIFICATION, action, modality);
    }

    private long sanitizeLatency(long latency) {
        if (latency >= 0) goto L6;
        Slog.w(TAG, "found a negative latency : " + latency);
        return -1;
    L6:
        return latency;
    }

    private static int sessionType(byte reason) {
        if (reason != 1) goto L5;
        return 2;
    L5:
        if (reason != 2) goto L7;
        return 1;
    L7:
        return 0;
    }

    private static int orientationType(int rotation) {
        switch(rotation) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 4;
    L7:
        return 3;
    L9:
        return 2;
    L11:
        return 1;
    }

    private static int foldType(int foldType) {
        switch(foldType) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 2;
    L7:
        return 1;
    L9:
        return 3;
    }
}
