package com.android.server.biometrics.sensors;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.BidiFormatter;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.biometrics.BiometricDanglingReceiver;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BiometricNotificationUtils {
    private static final String ACTION_BIOMETRIC_FRR_DISMISS = "action_biometric_frr_dismiss";
    private static final String BAD_CALIBRATION_NOTIFICATION_TAG = "FingerprintBadCalibration";
    private static final Intent DISMISS_FRR_INTENT = null;
    private static final String FACE_ENROLL_ACTION = "android.settings.FACE_ENROLL";
    private static final String FACE_ENROLL_CHANNEL = "FaceEnrollNotificationChannel";
    public static final String FACE_ENROLL_NOTIFICATION_TAG = "FaceEnroll";
    private static final String FACE_RE_ENROLL_CHANNEL = "FaceReEnrollNotificationChannel";
    private static final String FACE_RE_ENROLL_NOTIFICATION_TAG = "FaceReEnroll";
    private static final String FACE_SETTINGS_ACTION = "android.settings.FACE_SETTINGS";
    private static final String FINGERPRINT_BAD_CALIBRATION_CHANNEL = "FingerprintBadCalibrationNotificationChannel";
    private static final String FINGERPRINT_ENROLL_ACTION = "android.settings.FINGERPRINT_ENROLL";
    private static final String FINGERPRINT_ENROLL_CHANNEL = "FingerprintEnrollNotificationChannel";
    public static final String FINGERPRINT_ENROLL_NOTIFICATION_TAG = "FingerprintEnroll";
    private static final String FINGERPRINT_FRR_CHANNEL = "FingerprintFrrNotificationChannel";
    public static final String FINGERPRINT_FRR_NOTIFICATION_TAG = "FingerprintFrr";
    private static final String FINGERPRINT_RE_ENROLL_CHANNEL = "FingerprintReEnrollNotificationChannel";
    private static final String FINGERPRINT_RE_ENROLL_NOTIFICATION_TAG = "FingerprintReEnroll";
    private static final String FINGERPRINT_SETTINGS_ACTION = "android.settings.FINGERPRINT_SETTINGS";
    private static final String KEY_RE_ENROLL_FACE = "re_enroll_face_unlock";
    public static final int NOTIFICATION_ID = 1;
    private static final long NOTIFICATION_INTERVAL_MS = 86400000;
    private static final String SETTINGS_PACKAGE = "com.android.settings";
    private static final String TAG = "BiometricNotificationUtils";
    private static long sLastAlertTime;

    public BiometricNotificationUtils() {
    }

    static {
        sLastAlertTime = 0;
        DISMISS_FRR_INTENT = new Intent(ACTION_BIOMETRIC_FRR_DISMISS);
    }

    public static void showReEnrollmentNotification(Context context) {
        NotificationManager r0 = (NotificationManager) context.getSystemService(NotificationManager.class);
        String name = context.getString(R.string.fp_power_button_bp_positive_button);
        String title = context.getString(R.string.fp_power_button_bp_title);
        String content = context.getString(R.string.fp_power_button_bp_negative_button);
        Intent intent = new Intent("android.settings.FACE_SETTINGS");
        intent.setPackage(SETTINGS_PACKAGE);
        PendingIntent pendingIntent = PendingIntent.getActivityAsUser(context, 0, intent, 67108864, null, UserHandle.CURRENT);
        showNotificationHelper(context, name, title, content, pendingIntent, FACE_RE_ENROLL_CHANNEL, "sys", FACE_RE_ENROLL_NOTIFICATION_TAG, -1, false);
    }

    public static void showFaceEnrollNotification(Context context) {
        Slog.d(TAG, "Showing Face Enroll Notification");
        String name = context.getString(R.string.error_handwriting_unsupported_password);
        String title = context.getString(R.string.app_category_productivity);
        String content = context.getString(R.string.app_category_maps);
        Intent intent = new Intent(FACE_ENROLL_ACTION);
        intent.setPackage(SETTINGS_PACKAGE);
        intent.putExtra("enroll_reason", 1);
        PendingIntent pendingIntent = PendingIntent.getActivityAsUser(context, 0, intent, 67108864, null, UserHandle.CURRENT);
        showNotificationHelper(context, name, title, content, pendingIntent, FACE_ENROLL_CHANNEL, "recommendation", FACE_ENROLL_NOTIFICATION_TAG, 1, true);
    }

    public static void showFingerprintEnrollNotification(Context context) {
        Slog.d(TAG, "Showing Fingerprint Enroll Notification");
        String name = context.getString(R.string.error_handwriting_unsupported_password);
        String title = context.getString(R.string.app_category_productivity);
        String content = context.getString(R.string.app_category_news);
        Intent intent = new Intent(FINGERPRINT_ENROLL_ACTION);
        intent.setPackage(SETTINGS_PACKAGE);
        intent.putExtra("enroll_reason", 1);
        PendingIntent pendingIntent = PendingIntent.getActivityAsUser(context, 0, intent, 67108864, null, UserHandle.CURRENT);
        showNotificationHelper(context, name, title, content, pendingIntent, "recommendation", FINGERPRINT_ENROLL_CHANNEL, FINGERPRINT_ENROLL_NOTIFICATION_TAG, 1, true);
    }

    public static boolean showCustomizeFpFrrNotification(Context context) {
        String name = context.getString(R.string.error_handwriting_unsupported_password);
        String title = context.getString(R.string.hour_picker_description);
        String content = context.getString(R.string.hour);
        Intent intent = getIntentFromFpFrrComponentNameStringRes(context);
        StringBuilder r0 = new StringBuilder();
        r0.append("Showing Customize Fingerprint Frr Notification result:");
        if (intent == null) goto L5;
        boolean r5 = true;
    L6:
        r0.append(r5);
        Slog.d(TAG, r0.toString());
        if (intent != null) goto L9;
        return false;
    L9:
        PendingIntent pendingIntent = PendingIntent.getActivityAsUser(context, 0, intent, 67108864, null, UserHandle.CURRENT);
        showNotificationHelper(context, name, title, content, pendingIntent, "recommendation", FINGERPRINT_FRR_CHANNEL, FINGERPRINT_FRR_NOTIFICATION_TAG, 1, true);
        return true;
    L5:
        r5 = false;
        goto L6
    }

    private static Intent getIntentFromFpFrrComponentNameStringRes(Context context) {
        String componentNameString = context.getResources().getString(R.string.config_persistentDataPackageName);
        if (TextUtils.isEmpty(componentNameString) == false) goto L5;
        return null;
    L5:
        ComponentName componentName = ComponentName.unflattenFromString(componentNameString);
        if (componentName != null) goto L8;
        return null;
    L8:
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ResolveInfo resolveInfo = packageManager.resolveActivity(intent, 65536);
        if (resolveInfo == null) goto L11;
        return intent;
    L11:
        Slog.d(TAG, "Component for " + componentNameString + " not found");
        return null;
    }

    public static void showFingerprintLoeNotification(Context context) {
        Slog.d(TAG, "Showing fingerprint LOE notification");
        String name = context.getString(R.string.error_handwriting_unsupported_password);
        String title = context.getString(R.string.hardware);
        String content = context.getString(R.string.hours);
        Intent setupIntent = new Intent(BiometricDanglingReceiver.ACTION_FINGERPRINT_RE_ENROLL_LAUNCH);
        PendingIntent setupPendingIntent = PendingIntent.getBroadcastAsUser(context, 0, setupIntent, 67108864, UserHandle.CURRENT);
        String setupText = context.getString(R.string.capability_desc_canRequestTouchExploration);
        Notification.Action setupAction = new Notification.Action.Builder(null, setupText, setupPendingIntent).build();
        Intent notNowIntent = new Intent(BiometricDanglingReceiver.ACTION_FINGERPRINT_RE_ENROLL_DISMISS);
        PendingIntent notNowPendingIntent = PendingIntent.getBroadcastAsUser(context, 0, notNowIntent, 67108864, UserHandle.CURRENT);
        String notNowText = context.getString(R.string.capability_desc_canRequestFilterKeyEvents);
        Notification.Action notNowAction = new Notification.Action.Builder(null, notNowText, notNowPendingIntent).build();
        showNotificationHelper(context, name, title, content, setupPendingIntent, setupAction, notNowAction, "sys", FINGERPRINT_RE_ENROLL_CHANNEL, FINGERPRINT_RE_ENROLL_NOTIFICATION_TAG, -1, false, 32);
    }

    public static void showBadCalibrationNotification(Context context) {
        long currentTime = SystemClock.elapsedRealtime();
        long timeSinceLastAlert = currentTime - sLastAlertTime;
        if (sLastAlertTime != 0) goto L5;
    L8:
        sLastAlertTime = currentTime;
        String name = context.getString(R.string.httpErrorFile);
        String title = context.getString(R.string.httpErrorFileNotFound);
        String content = context.getString(R.string.httpErrorFailedSslHandshake);
        Intent intent = new Intent(FINGERPRINT_SETTINGS_ACTION);
        intent.setPackage(SETTINGS_PACKAGE);
        PendingIntent pendingIntent = PendingIntent.getActivityAsUser(context, 0, intent, 67108864, null, UserHandle.CURRENT);
        showNotificationHelper(context, name, title, content, pendingIntent, "sys", FINGERPRINT_BAD_CALIBRATION_CHANNEL, BAD_CALIBRATION_NOTIFICATION_TAG, -1, false);
        return;
    L5:
        if (timeSinceLastAlert >= 86400000) goto L8;
        Slog.v(TAG, "Skipping calibration notification : " + timeSinceLastAlert);
    }

    public static void showBiometricReEnrollNotification(Context context, List<String> identifiers, boolean allIdentifiersDeleted, int modality) {
        boolean r2 = true;
        if (modality == 1) goto L6;
        r2 = false;
    L6:
        boolean isFingerprint = r2;
        if (isFingerprint == false) goto L9;
        String r4 = FINGERPRINT_RE_ENROLL_NOTIFICATION_TAG;
    L10:
        String reEnrollName = r4;
        if (identifiers.isEmpty() == false) goto L14;
        Slog.v(TAG, "Skipping " + reEnrollName + " notification : empty list");
        return;
    L14:
        Slog.d(TAG, "Showing " + reEnrollName + " notification :[" + identifiers.size() + " identifier(s) deleted, allIdentifiersDeleted=" + allIdentifiersDeleted + "]");
        String name = context.getString(R.string.error_handwriting_unsupported_password);
        if (isFingerprint == false) goto L17;
        int r5 = R.string.hardware;
    L18:
        String title = context.getString(r5);
        if (isFingerprint == false) goto L21;
        String content = getFingerprintDanglingContentString(context, identifiers, allIdentifiersDeleted);
    L23:
        if (isFingerprint == false) goto L25;
        String r9 = BiometricDanglingReceiver.ACTION_FINGERPRINT_RE_ENROLL_LAUNCH;
    L26:
        Intent setupIntent = new Intent(r9);
        PendingIntent setupPendingIntent = PendingIntent.getBroadcastAsUser(context, 0, setupIntent, 67108864, UserHandle.CURRENT);
        String setupText = context.getString(R.string.capability_desc_canRequestTouchExploration);
        Notification.Action setupAction = new Notification.Action.Builder(null, setupText, setupPendingIntent).build();
        if (isFingerprint == false) goto L29;
        String r10 = BiometricDanglingReceiver.ACTION_FINGERPRINT_RE_ENROLL_DISMISS;
    L30:
        Intent notNowIntent = new Intent(r10);
        UserHandle r11 = UserHandle.CURRENT;
        String tag = FINGERPRINT_RE_ENROLL_NOTIFICATION_TAG;
        PendingIntent notNowPendingIntent = PendingIntent.getBroadcastAsUser(context, 0, notNowIntent, 67108864, r11);
        String notNowText = context.getString(R.string.capability_desc_canRequestFilterKeyEvents);
        Notification.Action notNowAction = new Notification.Action.Builder(null, notNowText, notNowPendingIntent).build();
        if (isFingerprint == false) goto L33;
        String channel = FINGERPRINT_RE_ENROLL_CHANNEL;
    L35:
        if (isFingerprint == true) goto L38;
        tag = FACE_RE_ENROLL_NOTIFICATION_TAG;
    L38:
        String notNowText2 = content;
        showNotificationHelper(context, name, title, notNowText2, setupPendingIntent, setupAction, notNowAction, "sys", channel, tag, -1, false, 32);
        return;
    L33:
        channel = FACE_RE_ENROLL_CHANNEL;
        goto L35
    L29:
        r10 = BiometricDanglingReceiver.ACTION_FACE_RE_ENROLL_DISMISS;
        goto L30
    L25:
        r9 = BiometricDanglingReceiver.ACTION_FACE_RE_ENROLL_LAUNCH;
        goto L26
    L21:
        content = context.getString(R.string.font_family_body_1_material);
        goto L23
    L17:
        r5 = R.string.font_family_body_2_material;
        goto L18
    L9:
        r4 = FACE_RE_ENROLL_NOTIFICATION_TAG;
        goto L10
    }

    private static String getFingerprintDanglingContentString(Context context, List<String> fingerprints, boolean allFingerprintDeleted) {
        if (fingerprints.isEmpty() == false) goto L6;
        return null;
    L6:
        int size = fingerprints.size();
        StringBuilder first = new StringBuilder();
        BidiFormatter bidiFormatter = BidiFormatter.getInstance();
        if (size <= 1) goto L23;
        String second = null;
        int i = 0;
    L9:
        if (i >= size) goto L18;
        if (i != (size - 1)) goto L13;
        second = bidiFormatter.unicodeWrap("\"" + fingerprints.get(i) + "\"");
    L16:
        i = i + 1;
        goto L9
    L13:
        first.append(bidiFormatter.unicodeWrap("\""));
        first.append(bidiFormatter.unicodeWrap(fingerprints.get(i)));
        first.append(bidiFormatter.unicodeWrap("\""));
        if (i >= (size - 2)) goto L16;
        first.append(bidiFormatter.unicodeWrap(", "));
        goto L16
    L18:
        if (allFingerprintDeleted == false) goto L20;
        int resId = R.string.guest_name;
    L22:
        return String.format(context.getString(resId), new Object[]{first, second});
    L20:
        resId = R.string.granularity_label_word;
        goto L22
    L23:
        if (allFingerprintDeleted == false) goto L25;
        int resId2 = R.string.gsm_alphabet_default_charset;
    L26:
        first.append(bidiFormatter.unicodeWrap("\""));
        first.append(bidiFormatter.unicodeWrap(fingerprints.get(0)));
        first.append(bidiFormatter.unicodeWrap("\""));
        return String.format(context.getString(resId2), new Object[]{first});
    L25:
        resId2 = R.string.granularity_label_link;
        goto L26
    }

    private static void showNotificationHelper(Context context, String name, String title, String content, PendingIntent pendingIntent, String category, String channelName, String notificationTag, int visibility, boolean listenToDismissEvent) {
        showNotificationHelper(context, name, title, content, pendingIntent, null, null, category, channelName, notificationTag, visibility, listenToDismissEvent, 0);
    }

    private static void showNotificationHelper(Context context, String name, String title, String content, PendingIntent pendingIntent, Notification.Action positiveAction, Notification.Action negativeAction, String category, String channelName, String notificationTag, int visibility, boolean listenToDismissEvent, int flags) {
        Slog.v(TAG, " listenToDismissEvent = " + listenToDismissEvent);
        PendingIntent dismissIntent = PendingIntent.getActivityAsUser(context, 0, DISMISS_FRR_INTENT, 67108864, null, UserHandle.CURRENT);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        NotificationChannel channel = new NotificationChannel(channelName, name, 4);
        Notification.Builder builder = new Notification.Builder(context, channelName).setSmallIcon(R.drawable.jog_tab_right_confirm_red).setContentTitle(title).setContentText(content).setStyle(new Notification.BigTextStyle().bigText(content)).setSubText(name).setOnlyAlertOnce(true).setLocalOnly(true).setAutoCancel(true).setCategory(category).setContentIntent(pendingIntent).setVisibility(visibility);
        if (flags <= 0) goto L5;
        builder.setFlag(flags, true);
    L5:
        if (positiveAction == null) goto L7;
        builder.addAction(positiveAction);
    L7:
        if (negativeAction == null) goto L9;
        builder.addAction(negativeAction);
    L9:
        if (listenToDismissEvent == false) goto L11;
        builder.setDeleteIntent(dismissIntent);
    L11:
        Notification notification = builder.build();
        notificationManager.createNotificationChannel(channel);
        notificationManager.notifyAsUser(notificationTag, 1, notification, UserHandle.CURRENT);
    }

    public static void cancelFaceReEnrollNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        notificationManager.cancelAsUser(FACE_RE_ENROLL_NOTIFICATION_TAG, 1, UserHandle.CURRENT);
    }

    public static void cancelFaceEnrollNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        notificationManager.cancelAsUser(FACE_ENROLL_NOTIFICATION_TAG, 1, UserHandle.CURRENT);
    }

    public static void cancelFingerprintEnrollNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        notificationManager.cancelAsUser(FINGERPRINT_ENROLL_NOTIFICATION_TAG, 1, UserHandle.CURRENT);
    }

    public static void cancelBadCalibrationNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        notificationManager.cancelAsUser(BAD_CALIBRATION_NOTIFICATION_TAG, 1, UserHandle.CURRENT);
    }

    public static void cancelFingerprintReEnrollNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        notificationManager.cancelAsUser(FINGERPRINT_RE_ENROLL_NOTIFICATION_TAG, 1, UserHandle.CURRENT);
    }
}
