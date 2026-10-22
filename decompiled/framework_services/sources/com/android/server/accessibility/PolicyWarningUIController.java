package com.android.server.accessibility;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.StatusBarManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.accessibility.util.AccessibilityStatsLogUtils;
import com.android.internal.util.ImageUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class PolicyWarningUIController {
    protected static final String ACTION_A11Y_SETTINGS = null;
    protected static final String ACTION_DISMISS_NOTIFICATION = null;
    protected static final String ACTION_SEND_NOTIFICATION = null;
    private static final String EXTRA_TIME_FOR_LOGGING = "start_time_to_log_a11y_tool";
    private static final int SEND_NOTIFICATION_DELAY_HOURS = 24;
    private static final String TAG = null;
    private final AlarmManager mAlarmManager;
    private final Context mContext;
    private final ArraySet<ComponentName> mEnabledA11yServices;
    private final Handler mMainHandler;
    private final NotificationController mNotificationController;

    public static class NotificationController extends BroadcastReceiver {
        private static final char RECORD_SEPARATOR = ':';
        private final Context mContext;
        private int mCurrentUserId;
        private final NotificationManager mNotificationManager;
        private final ArraySet<ComponentName> mNotifiedA11yServices;
        private boolean mSendNotification;
        private final List<ComponentName> mSentA11yServiceNotification;

        /* JADX INFO: renamed from: $r8$lambda$pIvhwpBBgJCo4H-Ws6MtiV-xln0, reason: not valid java name */
        public static /* synthetic */ void m725$r8$lambda$pIvhwpBBgJCo4HWs6MtiVxln0(NotificationController r0, ComponentName r1) {
            r0.lambda$cancelSentNotifications$0(r1);
        }

        public NotificationController(Context context) {
            this.mNotifiedA11yServices = new ArraySet();
            this.mSentA11yServiceNotification = new ArrayList();
            this.mContext = context;
            this.mNotificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            ComponentName componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.COMPONENT_NAME", ComponentName.class);
            if (TextUtils.isEmpty(action) == true) goto L24;
            if (componentName == null) goto L29;
            long durationMills = 0;
            long startTimeMills = intent.getLongExtra("android.intent.extra.TIME", 0);
            if (startTimeMills <= 0) goto L9;
            durationMills = SystemClock.elapsedRealtime() - startTimeMills;
        L9:
            int userId = intent.getIntExtra("android.intent.extra.USER_ID", 0);
            if (PolicyWarningUIController.ACTION_SEND_NOTIFICATION.equals(action) == false) goto L15;
            if (trySendNotification(userId, componentName) == false) goto L25;
            AccessibilityStatsLogUtils.logNonA11yToolServiceWarningReported(componentName.getPackageName(), AccessibilityStatsLogUtils.ACCESSIBILITY_PRIVACY_WARNING_STATUS_SHOWN, durationMills);
            return;
        L25:
            return;
        L15:
            if (PolicyWarningUIController.ACTION_A11Y_SETTINGS.equals(action) == false) goto L21;
            if (tryLaunchSettings(userId, componentName) == false) goto L19;
            AccessibilityStatsLogUtils.logNonA11yToolServiceWarningReported(componentName.getPackageName(), AccessibilityStatsLogUtils.ACCESSIBILITY_PRIVACY_WARNING_STATUS_CLICKED, durationMills);
        L19:
            this.mNotificationManager.cancel(componentName.flattenToShortString(), 1005);
            this.mSentA11yServiceNotification.remove(componentName);
            onNotificationCanceled(userId, componentName);
            return;
        L21:
            if (PolicyWarningUIController.ACTION_DISMISS_NOTIFICATION.equals(action) == false) goto L28;
            this.mSentA11yServiceNotification.remove(componentName);
            onNotificationCanceled(userId, componentName);
            return;
        L28:
            return;
        L29:
            return;
        }

        protected void onSwitchUser(int userId) {
            cancelSentNotifications();
            this.mNotifiedA11yServices.clear();
            this.mCurrentUserId = userId;
            this.mNotifiedA11yServices.addAll(readNotifiedServiceList(userId));
        }

        protected void onServicesDisabled(int userId, ArraySet<ComponentName> disabledServices) {
            if (this.mNotifiedA11yServices.removeAll(disabledServices) == false) goto L6;
            writeNotifiedServiceList(userId, this.mNotifiedA11yServices);
            return;
        }

        private boolean trySendNotification(int userId, ComponentName componentName) {
            if (userId == this.mCurrentUserId) goto L6;
            return false;
        L6:
            if (this.mSendNotification == true) goto L8;
            return false;
        L8:
            List<AccessibilityServiceInfo> enabledServiceInfos = getEnabledServiceInfos();
            int i = 0;
        L10:
            if (i >= enabledServiceInfos.size()) goto L20;
            AccessibilityServiceInfo a11yServiceInfo = enabledServiceInfos.get(i);
            if (componentName.flattenToShortString().equals(a11yServiceInfo.getComponentName().flattenToShortString()) == true) goto L14;
            i = i + 1;
            goto L10
        L14:
            if (a11yServiceInfo.isAccessibilityTool() == true) goto L20;
            if (this.mNotifiedA11yServices.contains(componentName) == true) goto L20;
            CharSequence displayName = a11yServiceInfo.getResolveInfo().serviceInfo.loadLabel(this.mContext.getPackageManager());
            Drawable drawable = a11yServiceInfo.getResolveInfo().loadIcon(this.mContext.getPackageManager());
            int size = this.mContext.getResources().getDimensionPixelSize(R.dimen.app_icon_size);
            sendNotification(userId, componentName, displayName, ImageUtils.buildScaledBitmap(drawable, size, size));
            return true;
        L20:
            return false;
        }

        private boolean tryLaunchSettings(int userId, ComponentName componentName) {
            if (userId == this.mCurrentUserId) goto L6;
            return false;
        L6:
            Intent intent = new Intent("android.settings.ACCESSIBILITY_DETAILS_SETTINGS");
            intent.addFlags(268468224);
            intent.putExtra("android.intent.extra.COMPONENT_NAME", componentName.flattenToShortString());
            intent.putExtra(PolicyWarningUIController.EXTRA_TIME_FOR_LOGGING, SystemClock.elapsedRealtime());
            Bundle bundle = ActivityOptions.makeBasic().setLaunchDisplayId(this.mContext.getDisplayId()).toBundle();
            this.mContext.startActivityAsUser(intent, bundle, UserHandle.of(userId));
            ((StatusBarManager) this.mContext.getSystemService(StatusBarManager.class)).collapsePanels();
            return true;
        }

        protected void onNotificationCanceled(int userId, ComponentName componentName) {
            if (userId == this.mCurrentUserId) goto L6;
            return;
        L6:
            if (this.mNotifiedA11yServices.add(componentName) == false) goto L9;
            writeNotifiedServiceList(userId, this.mNotifiedA11yServices);
            return;
        }

        private void sendNotification(int userId, ComponentName serviceComponentName, CharSequence name, Bitmap bitmap) {
            Notification.Builder notificationBuilder = new Notification.Builder(this.mContext, "ACCESSIBILITY_SECURITY_POLICY");
            notificationBuilder.setSmallIcon(R.drawable.ic_perm_group_device_alarms).setContentTitle(this.mContext.getString(17042333)).setContentText(this.mContext.getString(17042332, new Object[]{name})).setStyle(new Notification.BigTextStyle().bigText(this.mContext.getString(17042332, new Object[]{name}))).setTicker(this.mContext.getString(17042333)).setOnlyAlertOnce(true).setDeleteIntent(PolicyWarningUIController.createPendingIntent(this.mContext, userId, PolicyWarningUIController.ACTION_DISMISS_NOTIFICATION, serviceComponentName)).setContentIntent(PolicyWarningUIController.createPendingIntent(this.mContext, userId, PolicyWarningUIController.ACTION_A11Y_SETTINGS, serviceComponentName));
            if (bitmap == null) goto L5;
            notificationBuilder.setLargeIcon(bitmap);
        L5:
            this.mNotificationManager.notify(serviceComponentName.flattenToShortString(), 1005, notificationBuilder.build());
            this.mSentA11yServiceNotification.add(serviceComponentName);
        }

        private ArraySet<ComponentName> readNotifiedServiceList(int userId) {
            String notifiedServiceSetting = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "notified_non_accessibility_category_services", userId);
            if (TextUtils.isEmpty(notifiedServiceSetting) == true) goto L5;
            TextUtils.StringSplitter componentNameSplitter = new TextUtils.SimpleStringSplitter(RECORD_SEPARATOR);
            componentNameSplitter.setString(notifiedServiceSetting);
            ArraySet<ComponentName> notifiedServices = new ArraySet();
            Iterator<String> it = componentNameSplitter.iterator();
        L8:
            if (it.hasNext() == false) goto L13;
            String componentNameString = it.next();
            ComponentName notifiedService = ComponentName.unflattenFromString(componentNameString);
            if (notifiedService == null) goto L8;
            notifiedServices.add(notifiedService);
            goto L8
        L13:
            return notifiedServices;
        L5:
            return new ArraySet();
        }

        private void writeNotifiedServiceList(int userId, ArraySet<ComponentName> services) {
            StringBuilder notifiedServicesBuilder = new StringBuilder();
            int i = 0;
        L4:
            if (i >= services.size()) goto L8;
            if (i <= 0) goto L7;
            notifiedServicesBuilder.append(RECORD_SEPARATOR);
        L7:
            ComponentName notifiedService = services.valueAt(i);
            notifiedServicesBuilder.append(notifiedService.flattenToShortString());
            i = i + 1;
            goto L4
        L8:
            Settings.Secure.putStringForUser(this.mContext.getContentResolver(), "notified_non_accessibility_category_services", notifiedServicesBuilder.toString(), userId);
        }

        protected List<AccessibilityServiceInfo> getEnabledServiceInfos() {
            AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(this.mContext);
            return accessibilityManager.getEnabledAccessibilityServiceList(-1);
        }

        private void cancelSentNotifications() {
            this.mSentA11yServiceNotification.forEach(new PolicyWarningUIController$NotificationController$$ExternalSyntheticLambda0(this));
            this.mSentA11yServiceNotification.clear();
        }

        private /* synthetic */ void lambda$cancelSentNotifications$0(ComponentName componentName) {
            this.mNotificationManager.cancel(componentName.flattenToShortString(), 1005);
        }

        void setSendingNotification(boolean enable) {
            this.mSendNotification = enable;
        }
    }

    public static /* synthetic */ void $r8$lambda$FLmotYt3XsdyYeosV5FvzhGVtLY(PolicyWarningUIController r0, boolean r1) {
        r0.enableSendingNonA11yToolNotificationInternal(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Gr6qzlAd0Ku36cCnv-sLqB_nbeM, reason: not valid java name */
    public static /* synthetic */ void m723$r8$lambda$Gr6qzlAd0Ku36cCnvsLqB_nbeM(PolicyWarningUIController r0, int r1, Set r2) {
        r0.onSwitchUserInternal(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gsvC_rPkF5Nwo1blVKfiihwggJo(PolicyWarningUIController r0, int r1, ComponentName r2) {
        r0.setAlarm(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$px8okpRhhVh7O5B3p-efky5vkAQ, reason: not valid java name */
    public static /* synthetic */ void m724$r8$lambda$px8okpRhhVh7O5B3pefky5vkAQ(PolicyWarningUIController r0, int r1, ComponentName r2) {
        r0.cancelAlarm(r1, r2);
    }

    static {
        TAG = PolicyWarningUIController.class.getSimpleName();
        ACTION_SEND_NOTIFICATION = TAG + ".ACTION_SEND_NOTIFICATION";
        ACTION_A11Y_SETTINGS = TAG + ".ACTION_A11Y_SETTINGS";
        ACTION_DISMISS_NOTIFICATION = TAG + ".ACTION_DISMISS_NOTIFICATION";
    }

    public PolicyWarningUIController(Handler handler, Context context, NotificationController notificationController) {
        this.mEnabledA11yServices = new ArraySet();
        this.mMainHandler = handler;
        this.mContext = context;
        this.mNotificationController = notificationController;
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_SEND_NOTIFICATION);
        filter.addAction(ACTION_A11Y_SETTINGS);
        filter.addAction(ACTION_DISMISS_NOTIFICATION);
        this.mContext.registerReceiver(this.mNotificationController, filter, "android.permission.MANAGE_ACCESSIBILITY", this.mMainHandler, 2);
    }

    public void onSwitchUser(int userId, Set<ComponentName> enabledServices) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new PolicyWarningUIController$$ExternalSyntheticLambda4(this), Integer.valueOf(userId), enabledServices));
    }

    private void onSwitchUserInternal(int userId, Set<ComponentName> enabledServices) {
        this.mEnabledA11yServices.clear();
        this.mEnabledA11yServices.addAll(enabledServices);
        this.mNotificationController.onSwitchUser(userId);
    }

    public void onEnabledServicesChanged(int userId, Set<ComponentName> enabledServices) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new PolicyWarningUIController$$ExternalSyntheticLambda1(this), Integer.valueOf(userId), enabledServices));
    }

    void onEnabledServicesChangedInternal(int userId, Set<ComponentName> enabledServices) {
        ArraySet<ComponentName> disabledServices = new ArraySet(this.mEnabledA11yServices);
        disabledServices.removeAll(enabledServices);
        this.mEnabledA11yServices.clear();
        this.mEnabledA11yServices.addAll(enabledServices);
        Handler r1 = this.mMainHandler;
        final NotificationController r2 = this.mNotificationController;
        r2.getClass();
        r1.sendMessage(PooledLambda.obtainMessage(new PolicyWarningUIController$$ExternalSyntheticLambda5(r2), Integer.valueOf(userId), disabledServices));
    }

    public void onNonA11yCategoryServiceBound(int userId, ComponentName service) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new PolicyWarningUIController$$ExternalSyntheticLambda2(this), Integer.valueOf(userId), service));
    }

    public void onNonA11yCategoryServiceUnbound(int userId, ComponentName service) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new PolicyWarningUIController$$ExternalSyntheticLambda3(this), Integer.valueOf(userId), service));
    }

    private void setAlarm(int userId, ComponentName service) {
        Calendar cal = Calendar.getInstance();
        cal.add(10, 24);
        this.mAlarmManager.set(0, cal.getTimeInMillis(), createPendingIntent(this.mContext, userId, ACTION_SEND_NOTIFICATION, service));
    }

    private void cancelAlarm(int userId, ComponentName service) {
        this.mAlarmManager.cancel(createPendingIntent(this.mContext, userId, ACTION_SEND_NOTIFICATION, service));
    }

    protected static PendingIntent createPendingIntent(Context context, int userId, String action, ComponentName serviceComponentName) {
        return PendingIntent.getBroadcast(context, 0, createIntent(context, userId, action, serviceComponentName), 67108864);
    }

    protected static Intent createIntent(Context context, int userId, String action, ComponentName serviceComponentName) {
        Intent intent = new Intent(action);
        intent.setPackage(context.getPackageName()).setIdentifier(serviceComponentName.flattenToShortString()).putExtra("android.intent.extra.COMPONENT_NAME", serviceComponentName).putExtra("android.intent.extra.USER_ID", userId).putExtra("android.intent.extra.TIME", SystemClock.elapsedRealtime());
        return intent;
    }

    public void enableSendingNonA11yToolNotification(boolean enable) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new PolicyWarningUIController$$ExternalSyntheticLambda0(this), Boolean.valueOf(enable)));
    }

    private void enableSendingNonA11yToolNotificationInternal(boolean enable) {
        this.mNotificationController.setSendingNotification(enable);
    }
}
