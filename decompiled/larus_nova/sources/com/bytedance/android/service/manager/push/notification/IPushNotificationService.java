package com.bytedance.android.service.manager.push.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface IPushNotificationService {
    IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103);

    IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, int r104, String r105);

    IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, Notification r104, boolean r105);

    IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, Notification r104, boolean r105, int r106, String r107);

    IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, boolean r104);

    IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, boolean r104, int r105, String r106);

    IPushNotification buildNotification(Context r100, Intent r101, NotificationBody r102, Notification r103);

    IPushNotification buildNotification(Context r100, Intent r101, NotificationBody r102, Notification r103, int r104, String r105);

    Bitmap downloadImage(String r100);

    PendingIntent getNotificationDeleteIntent(long r100);

    PendingIntent getNotificationDeleteIntent(long r100, Bundle r101, JSONObject r102);

    PendingIntent getNotificationDeleteIntent(long r100, JSONObject r101);

    int getNotificationNum(Context r100);

    boolean isClickByBanner(long r100);

    boolean isSupportProxyNotification();

    void setAsyncImageDownloader(AsyncImageDownloader r100);

    void showNotification(Context r100, Intent r101, NotificationBody r102);

    void tryClearSomeNotification();

    boolean tryShowPushNotification(Context r100, Intent r101, NotificationBody r102);
}
