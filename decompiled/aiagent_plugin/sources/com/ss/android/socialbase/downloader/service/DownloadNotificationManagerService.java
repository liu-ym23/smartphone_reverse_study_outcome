package com.ss.android.socialbase.downloader.service;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManagerImpl;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadNotificationManagerService implements IDownloadNotificationManagerService {
    public DownloadNotificationManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void hideNotification(int r1) {
        DownloadNotificationManagerImpl.getInstance().hideNotification(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void notifyByService(int r1, int r2, Notification r3) {
        DownloadNotificationManagerImpl.getInstance().notifyByService(r1, r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancel(int r1) {
        DownloadNotificationManagerImpl.getInstance().cancel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        return DownloadNotificationManagerImpl.getInstance().getAllNotificationItems();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void addNotification(AbsNotificationItem r1) {
        DownloadNotificationManagerImpl.getInstance().addNotification(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem removeNotification(int r1) {
        return DownloadNotificationManagerImpl.getInstance().removeNotification(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem getNotificationItem(int r1) {
        return DownloadNotificationManagerImpl.getInstance().getNotificationItem(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancelNotification(int r1) {
        DownloadNotificationManagerImpl.getInstance().cancelNotification(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void clearNotification() {
        DownloadNotificationManagerImpl.getInstance().clearNotification();
    }
}
