package com.bytedance.android.service.manager.push.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class IPushNotificationServiceImplOfMock implements IPushNotificationService {
    public IPushNotificationServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public Bitmap downloadImage(String r100) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public PendingIntent getNotificationDeleteIntent(long r100) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public PendingIntent getNotificationDeleteIntent(long r100, Bundle r101, JSONObject r102) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public PendingIntent getNotificationDeleteIntent(long r100, JSONObject r101) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public int getNotificationNum(Context r100) {
        return 0;
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public boolean isClickByBanner(long r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public boolean isSupportProxyNotification() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public void setAsyncImageDownloader(AsyncImageDownloader r100) {
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public void showNotification(Context r100, Intent r101, NotificationBody r102) {
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public void tryClearSomeNotification() {
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public boolean tryShowPushNotification(Context r100, Intent r101, NotificationBody r102) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103) {
        return new IPushNotificationImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public IPushNotification buildNotification(Context r100, Intent r101, NotificationBody r102, Notification r103) {
        return new IPushNotificationImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, boolean r104) {
        return new IPushNotificationImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, int r104, String r105) {
        return new IPushNotificationImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, Notification r104, boolean r105) {
        return new IPushNotificationImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public IPushNotification buildNotification(Context r100, Intent r101, NotificationBody r102, Notification r103, int r104, String r105) {
        return new IPushNotificationImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, boolean r104, int r105, String r106) {
        return new IPushNotificationImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.notification.IPushNotificationService
    public IPushNotification buildNotification(Context r100, Intent r101, Notification.Builder r102, NotificationBody r103, Notification r104, boolean r105, int r106, String r107) {
        return new IPushNotificationImplOfMock();
    }
}
