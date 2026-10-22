package com.android.server.biometrics;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricFrameworkStatsLogger;
import com.android.server.biometrics.sensors.BiometricNotificationUtils;

/* JADX INFO: loaded from: classes.dex */
public class BiometricNotificationLogger extends NotificationListenerService {
    private static final String TAG = "FRRNotificationListener";
    private BiometricFrameworkStatsLogger mLogger;

    BiometricNotificationLogger() {
        this(BiometricFrameworkStatsLogger.getInstance());
    }

    BiometricNotificationLogger(BiometricFrameworkStatsLogger logger) {
        this.mLogger = logger;
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification sbn, NotificationListenerService.RankingMap map) {
        if (sbn != null) goto L4;
        return;
    L4:
        if (sbn.getTag() == null) goto L26;
        String r0 = sbn.getTag();
        switch(r0.hashCode()) {
            case -2131839613: goto L13;
            case 1786899082: goto L10;
            default: goto L15;
        };
    L15:
        byte r1 = -1;
    L16:
        switch(r1) {
            case 0: goto L19;
            case 1: goto L19;
            default: goto L25;
        };
    L25:
        return;
    L19:
        if (sbn.getTag() != BiometricNotificationUtils.FACE_ENROLL_NOTIFICATION_TAG) goto L21;
        int modality = 4;
    L22:
        Slog.d(TAG, "onNotificationPosted, tag=(" + sbn.getTag() + ")");
        this.mLogger.logFrameworkNotification(1, modality);
        return;
    L21:
        modality = 1;
        goto L22
    L10:
        if (r0.equals(BiometricNotificationUtils.FINGERPRINT_ENROLL_NOTIFICATION_TAG) == false) goto L15;
        r1 = 1;
        goto L16
    L13:
        if (r0.equals(BiometricNotificationUtils.FACE_ENROLL_NOTIFICATION_TAG) == false) goto L15;
        r1 = 0;
        goto L16
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification sbn, NotificationListenerService.RankingMap rankingMap, int reason) {
        if (sbn != null) goto L4;
        return;
    L4:
        if (sbn.getTag() == null) goto L32;
        String r0 = sbn.getTag();
        int modality = 1;
        switch(r0.hashCode()) {
            case -2131839613: goto L13;
            case 1786899082: goto L10;
            default: goto L15;
        };
    L15:
        byte r1 = -1;
    L16:
        switch(r1) {
            case 0: goto L18;
            case 1: goto L18;
            default: goto L31;
        };
    L18:
        Slog.d(TAG, "onNotificationRemoved, tag=(" + sbn.getTag() + "), reason=(" + reason + ")");
        if (sbn.getTag() != BiometricNotificationUtils.FACE_ENROLL_NOTIFICATION_TAG) goto L23;
        modality = 4;
    L23:
        switch(reason) {
            case 1: goto L26;
            case 2: goto L25;
            default: goto L24;
        };
    L24:
        Slog.d(TAG, "unhandled reason, ignoring logging");
        return;
    L25:
        this.mLogger.logFrameworkNotification(3, modality);
        return;
    L26:
        this.mLogger.logFrameworkNotification(2, modality);
        return;
    L31:
        return;
    L10:
        if (r0.equals(BiometricNotificationUtils.FINGERPRINT_ENROLL_NOTIFICATION_TAG) == false) goto L15;
        r1 = 1;
        goto L16
    L13:
        if (r0.equals(BiometricNotificationUtils.FACE_ENROLL_NOTIFICATION_TAG) == false) goto L15;
        r1 = 0;
        goto L16
    }
}
