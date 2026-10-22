package com.ss.android.socialbase.downloader.service;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadNotificationManagerService {

    public static class DefaultDownloadNotificationManagerService implements IDownloadNotificationManagerService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void addNotification(AbsNotificationItem r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void cancel(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void cancelNotification(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void clearNotification() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public SparseArray<AbsNotificationItem> getAllNotificationItems() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public AbsNotificationItem getNotificationItem(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void hideNotification(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void notifyByService(int r1, int r2, Notification r3) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public AbsNotificationItem removeNotification(int r1) {
            return null;
        }

        public DefaultDownloadNotificationManagerService() {
        }
    }

    void addNotification(AbsNotificationItem r1);

    void cancel(int r1);

    void cancelNotification(int r1);

    void clearNotification();

    SparseArray<AbsNotificationItem> getAllNotificationItems();

    AbsNotificationItem getNotificationItem(int r1);

    void hideNotification(int r1);

    void notifyByService(int r1, int r2, Notification r3);

    AbsNotificationItem removeNotification(int r1);
}
