package com.android.server.wm;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Bundle;
import com.android.internal.util.ImageUtils;
import com.android.server.pm.Settings;

/* JADX INFO: loaded from: classes3.dex */
class AlertWindowNotification {
    private static final String CHANNEL_PREFIX = "com.android.server.wm.AlertWindowNotification - ";
    private static final int NOTIFICATION_ID = 0;
    private static NotificationChannelGroup sChannelGroup;
    private static int sNextRequestCode;
    private final NotificationManager mNotificationManager;
    private String mNotificationTag;
    private final String mPackageName;
    private boolean mPosted;
    private final int mRequestCode;
    private final WindowManagerService mService;

    static {
        sNextRequestCode = 0;
    }

    AlertWindowNotification(WindowManagerService service, String packageName) {
        this.mService = service;
        this.mPackageName = packageName;
        this.mNotificationManager = (NotificationManager) this.mService.mContext.getSystemService("notification");
        this.mNotificationTag = CHANNEL_PREFIX + this.mPackageName;
        int r0 = sNextRequestCode;
        sNextRequestCode = r0 + 1;
        this.mRequestCode = r0;
    }

    void post() {
    }

    void cancel(boolean deleteChannel) {
    }

    private void onCancelNotification(boolean deleteChannel) {
        if (this.mPosted == true) goto L5;
        return;
    L5:
        this.mPosted = false;
        this.mNotificationManager.cancel(this.mNotificationTag, 0);
        if (deleteChannel == false) goto L9;
        this.mNotificationManager.deleteNotificationChannel(this.mNotificationTag);
        return;
    }

    private void onPostNotification() {
        if (this.mPosted == false) goto L5;
        return;
    L5:
        this.mPosted = true;
        Context context = this.mService.mContext;
        PackageManager pm = context.getPackageManager();
        ApplicationInfo aInfo = getApplicationInfo(pm, this.mPackageName);
        if (aInfo == null) goto L8;
        String appName = pm.getApplicationLabel(aInfo).toString();
    L9:
        createNotificationChannel(context, appName);
        String message = context.getString(R.string.android_upgrading_title, new Object[]{appName});
        Bundle extras = new Bundle();
        extras.putStringArray("android.foregroundApps", new String[]{this.mPackageName});
        Notification.Builder builder = new Notification.Builder(context, this.mNotificationTag).setOngoing(true).setContentTitle(context.getString(R.string.anr_activity_application, new Object[]{appName})).setContentText(message).setSmallIcon(R.drawable.btn_browser_zoom_page_overview).setColor(context.getColor(R.color.system_notification_accent_color)).setStyle(new Notification.BigTextStyle().bigText(message)).setLocalOnly(true).addExtras(extras).setContentIntent(getContentIntent(context, this.mPackageName));
        if (aInfo == null) goto L14;
        Drawable drawable = pm.getApplicationIcon(aInfo);
        int size = context.getResources().getDimensionPixelSize(R.dimen.app_icon_size);
        Bitmap bitmap = ImageUtils.buildScaledBitmap(drawable, size, size);
        if (bitmap == null) goto L14;
        builder.setLargeIcon(bitmap);
    L14:
        this.mNotificationManager.notify(this.mNotificationTag, 0, builder.build());
        return;
    L8:
        appName = this.mPackageName;
        goto L9
    }

    private PendingIntent getContentIntent(Context context, String packageName) {
        Intent intent = new Intent("android.settings.MANAGE_APP_OVERLAY_PERMISSION", Uri.fromParts(Settings.ATTR_PACKAGE, packageName, null));
        intent.setFlags(268468224);
        return PendingIntent.getActivity(context, this.mRequestCode, intent, AudioFormat.AAC_ADIF);
    }

    private void createNotificationChannel(Context context, String appName) {
        if (sChannelGroup != null) goto L5;
        sChannelGroup = new NotificationChannelGroup(CHANNEL_PREFIX, this.mService.mContext.getString(R.string.android_upgrading_notification_title));
        this.mNotificationManager.createNotificationChannelGroup(sChannelGroup);
    L5:
        String nameChannel = context.getString(R.string.android_upgrading_starting_apps, new Object[]{appName});
        if (this.mNotificationManager.getNotificationChannel(this.mNotificationTag) == null) goto L8;
        return;
    L8:
        NotificationChannel channel = new NotificationChannel(this.mNotificationTag, nameChannel, 1);
        channel.enableLights(false);
        channel.enableVibration(false);
        channel.setBlockable(true);
        channel.setGroup(sChannelGroup.getId());
        channel.setBypassDnd(true);
        this.mNotificationManager.createNotificationChannel(channel);
    }

    private ApplicationInfo getApplicationInfo(PackageManager pm, String packageName) {
        return pm.getApplicationInfo(packageName, 0);
    L6:
        return null;
    }
}
