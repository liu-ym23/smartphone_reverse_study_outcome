package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadNotificationManager implements IDownloadNotificationManagerService {
    private static volatile DownloadNotificationManager instance;
    private IDownloadNotificationManagerService service;

    static {
    }

    private DownloadNotificationManager() {
        this.service = (IDownloadNotificationManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadNotificationManagerService.class), IDownloadNotificationManagerService.class, "com.obric.aiagent.plugin");
    }

    public static DownloadNotificationManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(DownloadNotificationManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DownloadNotificationManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadNotificationManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void hideNotification(int r1) {
        this.service.hideNotification(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void notifyByService(int r1, int r2, Notification r3) {
        this.service.notifyByService(r1, r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancel(int r1) {
        this.service.cancel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        return this.service.getAllNotificationItems();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void addNotification(AbsNotificationItem r1) {
        this.service.addNotification(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem removeNotification(int r1) {
        return this.service.removeNotification(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem getNotificationItem(int r1) {
        return this.service.getNotificationItem(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancelNotification(int r1) {
        this.service.cancelNotification(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void clearNotification() {
        this.service.clearNotification();
    }
}
