package com.android.server.notification;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.util.Log;
import android.util.Slog;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ReviewNotificationPermissionsReceiver extends BroadcastReceiver {
    static final boolean DEBUG = false;
    private static final long JOB_RESCHEDULE_TIME = 604800000;
    public static final String TAG = "ReviewNotifPermissions";

    public ReviewNotificationPermissionsReceiver() {
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    static IntentFilter getFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("REVIEW_NOTIF_ACTION_REMIND");
        filter.addAction("REVIEW_NOTIF_ACTION_DISMISS");
        filter.addAction("REVIEW_NOTIF_ACTION_CANCELED");
        return filter;
    }

    protected void cancelNotification(Context context) {
        NotificationManager nm = (NotificationManager) context.getSystemService(NotificationManager.class);
        if (nm == null) goto L5;
        nm.cancel(NotificationManagerService.TAG, 71);
        return;
    L5:
        Slog.w(TAG, "could not cancel notification: NotificationManager not found");
    }

    protected void rescheduleNotification(Context context) {
        ReviewNotificationPermissionsJobService.scheduleJob(context, 604800000);
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "Scheduled review permissions notification for on or after: " + LocalDateTime.now(ZoneId.systemDefault()).plus(604800000, ChronoUnit.MILLIS));
        return;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("REVIEW_NOTIF_ACTION_REMIND") == false) goto L6;
        rescheduleNotification(context);
        Settings.Global.putInt(context.getContentResolver(), "review_permissions_notification_state", 1);
        cancelNotification(context);
        return;
    L6:
        if (action.equals("REVIEW_NOTIF_ACTION_DISMISS") == false) goto L9;
        Settings.Global.putInt(context.getContentResolver(), "review_permissions_notification_state", 2);
        cancelNotification(context);
        return;
    L9:
        if (action.equals("REVIEW_NOTIF_ACTION_CANCELED") == false) goto L19;
        int notifState = Settings.Global.getInt(context.getContentResolver(), "review_permissions_notification_state", -1);
        if (notifState != 0) goto L14;
        rescheduleNotification(context);
        Settings.Global.putInt(context.getContentResolver(), "review_permissions_notification_state", 1);
        return;
    L14:
        if (notifState != 3) goto L21;
        Settings.Global.putInt(context.getContentResolver(), "review_permissions_notification_state", 1);
        return;
    L21:
        return;
    }
}
