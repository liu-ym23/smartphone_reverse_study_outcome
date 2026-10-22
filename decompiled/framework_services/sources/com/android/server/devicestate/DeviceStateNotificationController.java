package com.android.server.devicestate;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.util.Slog;
import android.util.SparseArray;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class DeviceStateNotificationController extends BroadcastReceiver {
    static final String CHANNEL_ID = "DeviceStateManager";
    static final String INTENT_ACTION_CANCEL_STATE = "com.android.server.devicestate.INTENT_ACTION_CANCEL_STATE";
    static final int NOTIFICATION_ID = 1;
    static final String NOTIFICATION_TAG = "DeviceStateManager";
    private static final String TAG = "DeviceStateNotificationController";
    private final Runnable mCancelStateRunnable;
    private final Context mContext;
    private final Handler mHandler;
    private final NotificationInfoProvider mNotificationInfoProvider;
    private final NotificationManager mNotificationManager;
    private final PackageManager mPackageManager;

    static class NotificationInfo {
        public final String activeNotificationContent;
        public final String activeNotificationTitle;
        public final String name;
        public final String powerSaveModeNotificationContent;
        public final String powerSaveModeNotificationTitle;
        public final String thermalCriticalNotificationContent;
        public final String thermalCriticalNotificationTitle;

        NotificationInfo(String name, String activeNotificationTitle, String activeNotificationContent, String thermalCriticalNotificationTitle, String thermalCriticalNotificationContent, String powerSaveModeNotificationTitle, String powerSaveModeNotificationContent) {
            this.name = name;
            this.activeNotificationTitle = activeNotificationTitle;
            this.activeNotificationContent = activeNotificationContent;
            this.thermalCriticalNotificationTitle = thermalCriticalNotificationTitle;
            this.thermalCriticalNotificationContent = thermalCriticalNotificationContent;
            this.powerSaveModeNotificationTitle = powerSaveModeNotificationTitle;
            this.powerSaveModeNotificationContent = powerSaveModeNotificationContent;
        }

        boolean hasActiveNotification() {
            if (this.activeNotificationTitle != null) goto L5;
        L7:
            return false;
        L5:
            if (this.activeNotificationTitle.length() <= 0) goto L7;
            return true;
        }

        boolean hasThermalCriticalNotification() {
            if (this.thermalCriticalNotificationTitle != null) goto L5;
        L7:
            return false;
        L5:
            if (this.thermalCriticalNotificationTitle.length() <= 0) goto L7;
            return true;
        }

        boolean hasPowerSaveModeNotification() {
            if (this.powerSaveModeNotificationTitle != null) goto L5;
        L7:
            return false;
        L5:
            if (this.powerSaveModeNotificationTitle.length() <= 0) goto L7;
            return true;
        }
    }

    public static class NotificationInfoProvider {
        Locale mCachedLocale;
        private SparseArray<NotificationInfo> mCachedNotificationInfos;
        private final Context mContext;
        private final Object mLock;

        NotificationInfoProvider(Context context) {
            this.mLock = new Object();
            this.mContext = context;
        }

        public SparseArray<NotificationInfo> getNotificationInfos(Locale locale) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (locale.equals(this.mCachedLocale) == true) goto L9;
            refreshNotificationInfos(locale);     // Catch: Throwable -> L7
        L9:
            SparseArray<NotificationInfo> r1 = this.mCachedNotificationInfos;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        }

        Locale getCachedLocale() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Locale r1 = this.mCachedLocale;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void refreshNotificationInfos(Locale locale) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mCachedLocale = locale;     // Catch: Throwable -> L7
            this.mCachedNotificationInfos = loadNotificationInfos();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public SparseArray<NotificationInfo> loadNotificationInfos() {
            SparseArray<NotificationInfo> notificationInfos = new SparseArray();
            int[] stateIdentifiers = this.mContext.getResources().getIntArray(R.array.resolver_target_actions_pin);
            String[] names = this.mContext.getResources().getStringArray(R.array.required_apps_managed_device);
            String[] activeNotificationTitles = this.mContext.getResources().getStringArray(R.array.radioAttributes);
            String[] activeNotificationContents = this.mContext.getResources().getStringArray(R.array.preloaded_drawables);
            String[] thermalCriticalNotificationTitles = this.mContext.getResources().getStringArray(R.array.sim_colors);
            String[] thermalCriticalNotificationContents = this.mContext.getResources().getStringArray(R.array.resolver_target_actions_unpin);
            String[] powerSaveModeNotificationTitles = this.mContext.getResources().getStringArray(R.array.required_apps_managed_user);
            String[] powerSaveModeNotificationContents = this.mContext.getResources().getStringArray(R.array.required_apps_managed_profile);
            if (stateIdentifiers.length != names.length) goto L27;
            if (stateIdentifiers.length != activeNotificationTitles.length) goto L27;
            if (stateIdentifiers.length != activeNotificationContents.length) goto L27;
            if (stateIdentifiers.length != thermalCriticalNotificationTitles.length) goto L27;
            if (stateIdentifiers.length != thermalCriticalNotificationContents.length) goto L27;
            if (stateIdentifiers.length != powerSaveModeNotificationTitles.length) goto L27;
            if (stateIdentifiers.length != powerSaveModeNotificationContents.length) goto L27;
            int i = 0;
        L18:
            if (i >= stateIdentifiers.length) goto L25;
            int identifier = stateIdentifiers[i];
            if (identifier == (-1)) goto L23;
            notificationInfos.put(identifier, new NotificationInfo(names[i], activeNotificationTitles[i], activeNotificationContents[i], thermalCriticalNotificationTitles[i], thermalCriticalNotificationContents[i], powerSaveModeNotificationTitles[i], powerSaveModeNotificationContents[i]));
        L23:
            i = i + 1;
            goto L18
        L25:
            return notificationInfos;
        L27:
            throw new IllegalStateException("The length of state identifiers and notification texts must match!");
        }
    }

    public static /* synthetic */ void $r8$lambda$CuoFR9Cw3hJ6lOWioprSwRSKPSA(DeviceStateNotificationController r0, NotificationChannel r1, Notification.Builder r2) {
        r0.lambda$showNotification$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$X1sMrSa050sskockGAv0PMSfoHw(DeviceStateNotificationController r0) {
        r0.lambda$cancelNotification$0();
    }

    DeviceStateNotificationController(Context context, Handler handler, Runnable cancelStateRunnable) {
        this(context, handler, cancelStateRunnable, new NotificationInfoProvider(context), context.getPackageManager(), (NotificationManager) context.getSystemService(NotificationManager.class));
    }

    DeviceStateNotificationController(Context context, Handler handler, Runnable cancelStateRunnable, NotificationInfoProvider notificationInfoProvider, PackageManager packageManager, NotificationManager notificationManager) {
        this.mContext = context;
        this.mHandler = handler;
        this.mCancelStateRunnable = cancelStateRunnable;
        this.mNotificationInfoProvider = notificationInfoProvider;
        this.mPackageManager = packageManager;
        this.mNotificationManager = notificationManager;
        this.mContext.registerReceiver(this, new IntentFilter(INTENT_ACTION_CANCEL_STATE), "android.permission.CONTROL_DEVICE_STATE", this.mHandler, 4);
    }

    void showStateActiveNotificationIfNeeded(int state, int requestingAppUid) {
        NotificationInfo info = getNotificationInfos().get(state);
        if (info != null) goto L5;
        return;
    L5:
        if (info.hasActiveNotification() == false) goto L14;
        String requesterApplicationLabel = getApplicationLabel(requestingAppUid);
        if (requesterApplicationLabel == null) goto L10;
        Intent intent = new Intent(INTENT_ACTION_CANCEL_STATE).setPackage(this.mContext.getPackageName());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.mContext, 0, intent, 67108864);
        showNotification(info.name, info.activeNotificationTitle, String.format(info.activeNotificationContent, new Object[]{requesterApplicationLabel}), true, R.drawable.input_method_fullscreen_background, pendingIntent, this.mContext.getString(R.string.enable_explore_by_touch_warning_title));
        return;
    L10:
        Slog.e(TAG, "Cannot determine the requesting app name when showing state active notification. uid=" + requestingAppUid + ", state=" + state);
        return;
    }

    void showThermalCriticalNotificationIfNeeded(int state) {
        NotificationInfo info = getNotificationInfos().get(state);
        if (info != null) goto L5;
        return;
    L5:
        if (info.hasThermalCriticalNotification() == false) goto L10;
        showNotification(info.name, info.thermalCriticalNotificationTitle, info.thermalCriticalNotificationContent, false, R.drawable.pointer_wait_vector_23, null, null);
        return;
    }

    void showPowerSaveNotificationIfNeeded(int state) {
        NotificationInfo info = getNotificationInfos().get(state);
        if (info != null) goto L5;
        return;
    L5:
        if (info.hasPowerSaveModeNotification() == false) goto L10;
        Intent intent = new Intent("android.settings.BATTERY_SAVER_SETTINGS");
        PendingIntent pendingIntent = PendingIntent.getActivity(this.mContext, 0, intent, 67108864);
        showNotification(info.name, info.powerSaveModeNotificationTitle, info.powerSaveModeNotificationContent, false, R.drawable.pointer_wait_vector_23, pendingIntent, this.mContext.getString(R.string.enable_explore_by_touch_warning_message));
        return;
    }

    void cancelNotification(int state) {
        if (getNotificationInfos().get(state) != null) goto L5;
        return;
    L5:
        this.mHandler.post(new DeviceStateNotificationController$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$cancelNotification$0() {
        this.mNotificationManager.cancel("DeviceStateManager", 1);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) goto L4;
        return;
    L4:
        if (INTENT_ACTION_CANCEL_STATE.equals(intent.getAction()) == false) goto L8;
        this.mCancelStateRunnable.run();
        return;
    }

    private void showNotification(String name, String title, String content, boolean ongoing, int iconRes, PendingIntent pendingIntent, String actionText) {
        final NotificationChannel channel = new NotificationChannel("DeviceStateManager", name, 4);
        final Notification.Builder builder = new Notification.Builder(this.mContext, "DeviceStateManager").setSmallIcon(iconRes).setContentTitle(title).setContentText(content).setSubText(name).setLocalOnly(true).setOngoing(ongoing).setCategory("sys");
        if (pendingIntent == null) goto L6;
        if (actionText == null) goto L6;
        Notification.Action action = new Notification.Action.Builder(null, actionText, pendingIntent).build();
        builder.addAction(action);
    L6:
        this.mHandler.post(new DeviceStateNotificationController$$ExternalSyntheticLambda0(this, channel, builder));
    }

    private /* synthetic */ void lambda$showNotification$1(NotificationChannel channel, Notification.Builder builder) {
        this.mNotificationManager.createNotificationChannel(channel);
        this.mNotificationManager.notify("DeviceStateManager", 1, builder.build());
    }

    private SparseArray<NotificationInfo> getNotificationInfos() {
        Locale locale = this.mContext.getResources().getConfiguration().getLocales().get(0);
        return this.mNotificationInfoProvider.getNotificationInfos(locale);
    }

    private String getApplicationLabel(int uid) {
        String packageName = this.mPackageManager.getNameForUid(uid);
        ApplicationInfo appInfo = this.mPackageManager.getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(0));     // Catch: PackageManager.NameNotFoundException -> L5
        return appInfo.loadLabel(this.mPackageManager).toString();
    L6:
        return null;
    }
}
