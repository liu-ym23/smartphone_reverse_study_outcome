package com.android.server.accessibility.magnification;

import android.R;
import android.app.ActivityOptions;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.StatusBarManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.internal.accessibility.AccessibilityShortcutController;

/* JADX INFO: loaded from: classes.dex */
public class WindowMagnificationPromptController {
    static final String ACTION_DISMISS = "com.android.server.accessibility.magnification.action.DISMISS";
    static final String ACTION_TURN_ON_IN_SETTINGS = "com.android.server.accessibility.magnification.action.TURN_ON_IN_SETTINGS";
    private static final Uri MAGNIFICATION_WINDOW_MODE_PROMPT_URI = null;
    private final ContentObserver mContentObserver;
    private final Context mContext;
    private boolean mNeedToShowNotification;
    BroadcastReceiver mNotificationActionReceiver;
    private final NotificationManager mNotificationManager;
    private final int mUserId;

    private class NotificationActionReceiver extends BroadcastReceiver {
        final /* synthetic */ WindowMagnificationPromptController this$0;

        /* synthetic */ NotificationActionReceiver(WindowMagnificationPromptController r1, WindowMagnificationPromptControllerIA r2) {
            this(r1);
        }

        private NotificationActionReceiver(WindowMagnificationPromptController r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) == false) goto L5;
            return;
        L5:
            WindowMagnificationPromptController.m875$$Nest$fputmNeedToShowNotification(this.this$0, false);
            Settings.Secure.putIntForUser(WindowMagnificationPromptController.m873$$Nest$fgetmContext(this.this$0).getContentResolver(), "accessibility_show_window_magnification_prompt", 0, WindowMagnificationPromptController.m874$$Nest$fgetmUserId(this.this$0));
            if (WindowMagnificationPromptController.ACTION_TURN_ON_IN_SETTINGS.equals(action) == false) goto L9;
            WindowMagnificationPromptController.m877$$Nest$mlaunchMagnificationSettings(this.this$0);
            WindowMagnificationPromptController.m876$$Nest$mdismissNotification(this.this$0);
            return;
        L9:
            if (WindowMagnificationPromptController.ACTION_DISMISS.equals(action) == false) goto L13;
            WindowMagnificationPromptController.m876$$Nest$mdismissNotification(this.this$0);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m873$$Nest$fgetmContext(WindowMagnificationPromptController r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m874$$Nest$fgetmUserId(WindowMagnificationPromptController r0) {
        return r0.mUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNeedToShowNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m875$$Nest$fputmNeedToShowNotification(WindowMagnificationPromptController r0, boolean r1) {
        r0.mNeedToShowNotification = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdismissNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m876$$Nest$mdismissNotification(WindowMagnificationPromptController r0) {
        r0.dismissNotification();
    }

    /* JADX INFO: renamed from: -$$Nest$mlaunchMagnificationSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m877$$Nest$mlaunchMagnificationSettings(WindowMagnificationPromptController r0) {
        r0.launchMagnificationSettings();
    }

    static {
        MAGNIFICATION_WINDOW_MODE_PROMPT_URI = Settings.Secure.getUriFor("accessibility_show_window_magnification_prompt");
    }

    public WindowMagnificationPromptController(Context context, int userId) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        this.mUserId = userId;
        final Handler r1 = null;
        this.mContentObserver = new AnonymousClass1(this, r1);
        context.getContentResolver().registerContentObserver(MAGNIFICATION_WINDOW_MODE_PROMPT_URI, false, this.mContentObserver, this.mUserId);
        this.mNeedToShowNotification = isWindowMagnificationPromptEnabled();
    }

    protected void onPromptSettingsValueChanged() {
        boolean needToShowNotification = isWindowMagnificationPromptEnabled();
        if (this.mNeedToShowNotification != needToShowNotification) goto L5;
        return;
    L5:
        this.mNeedToShowNotification = needToShowNotification;
        if (this.mNeedToShowNotification == true) goto L9;
        unregisterReceiverIfNeeded();
        this.mNotificationManager.cancel(1004);
        return;
    }

    void showNotificationIfNeeded() {
        if (this.mNeedToShowNotification == true) goto L5;
        return;
    L5:
        Notification.Builder notificationBuilder = new Notification.Builder(this.mContext, "ACCESSIBILITY_MAGNIFICATION");
        String message = this.mContext.getString(17042431);
        notificationBuilder.setSmallIcon(R.drawable.ic_perm_group_device_alarms).setContentTitle(this.mContext.getString(17042432)).setContentText(message).setLargeIcon(Icon.createWithResource(this.mContext, R.drawable.ic_perm_group_system_clock)).setTicker(this.mContext.getString(17042432)).setOnlyAlertOnce(true).setStyle(new Notification.BigTextStyle().bigText(message)).setDeleteIntent(createPendingIntent(ACTION_DISMISS)).setContentIntent(createPendingIntent(ACTION_TURN_ON_IN_SETTINGS)).setActions(new Notification.Action[]{buildTurnOnAction()});
        this.mNotificationManager.notify(1004, notificationBuilder.build());
        registerReceiverIfNeeded();
    }

    public void onDestroy() {
        dismissNotification();
        this.mContext.getContentResolver().unregisterContentObserver(this.mContentObserver);
    }

    private boolean isWindowMagnificationPromptEnabled() {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_show_window_magnification_prompt", 0, this.mUserId) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private Notification.Action buildTurnOnAction() {
        return new Notification.Action.Builder(null, this.mContext.getString(17042256), createPendingIntent(ACTION_TURN_ON_IN_SETTINGS)).build();
    }

    private PendingIntent createPendingIntent(String action) {
        Intent intent = new Intent(action);
        intent.setPackage(this.mContext.getPackageName());
        return PendingIntent.getBroadcast(this.mContext, 0, intent, 67108864);
    }

    private void registerReceiverIfNeeded() {
        if (this.mNotificationActionReceiver == null) goto L5;
        return;
    L5:
        this.mNotificationActionReceiver = new NotificationActionReceiver(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_DISMISS);
        intentFilter.addAction(ACTION_TURN_ON_IN_SETTINGS);
        this.mContext.registerReceiver(this.mNotificationActionReceiver, intentFilter, "android.permission.MANAGE_ACCESSIBILITY", null, 2);
    }

    private void launchMagnificationSettings() {
        Intent intent = new Intent("android.settings.ACCESSIBILITY_DETAILS_SETTINGS");
        intent.addFlags(268468224);
        intent.putExtra("android.intent.extra.COMPONENT_NAME", AccessibilityShortcutController.MAGNIFICATION_COMPONENT_NAME.flattenToShortString());
        intent.addFlags(268435456);
        Bundle bundle = ActivityOptions.makeBasic().setLaunchDisplayId(this.mContext.getDisplayId()).toBundle();
        this.mContext.startActivityAsUser(intent, bundle, UserHandle.of(this.mUserId));
        ((StatusBarManager) this.mContext.getSystemService(StatusBarManager.class)).collapsePanels();
    }

    private void dismissNotification() {
        unregisterReceiverIfNeeded();
        this.mNotificationManager.cancel(1004);
    }

    private void unregisterReceiverIfNeeded() {
        if (this.mNotificationActionReceiver != null) goto L5;
        return;
    L5:
        this.mContext.unregisterReceiver(this.mNotificationActionReceiver);
        this.mNotificationActionReceiver = null;
    }
}
