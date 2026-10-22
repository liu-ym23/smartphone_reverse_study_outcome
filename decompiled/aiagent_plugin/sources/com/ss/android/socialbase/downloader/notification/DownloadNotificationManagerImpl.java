package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadNotificationManagerImpl {
    private static final String TAG = "DownloadNotificationManagerImpl";
    private static volatile DownloadNotificationManagerImpl instance;
    private final long PROGRESS_NOTIFY_DURATION;
    private final SparseArray<Long> PROGRESS_NOTIFY_LAST_TIME_INFO;
    private final SparseArray<AbsNotificationItem> notificationItemArray;

    static {
    }

    static boolean isCompleteVisibility(int r2) {
        if (r2 != 1) goto L5;
    L9:
        return true;
    L5:
        if (r2 == 3) goto L9;
        return false;
    }

    private DownloadNotificationManagerImpl() {
        this.PROGRESS_NOTIFY_DURATION = 1000;
        this.PROGRESS_NOTIFY_LAST_TIME_INFO = new SparseArray();
        this.notificationItemArray = new SparseArray();
    }

    public static DownloadNotificationManagerImpl getInstance() {
        if (instance != null) goto L15;
        monitor-enter(DownloadNotificationManagerImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DownloadNotificationManagerImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadNotificationManagerImpl.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public void hideNotification(int r4) {
        DownloadInfo r5 = Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getDownloadInfo(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        updateNotificationState(r5);
        cancelCompleteNotification(r5);
    }

    void updateNotificationState(DownloadInfo r3) {
        if (r3.isDownloadOverStatus() == false) goto L6;
        r3.setNotificationVisibility(3);
        Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).updateDownloadInfo(r3);
        return;
    }

    void cancelCompleteNotification(DownloadInfo r2) {
        if (isCompleteAndVisible(r2) == false) goto L6;
        cancelNotification(r2.getId());
        return;
    }

    static boolean isCompleteAndVisible(DownloadInfo r1) {
        if (r1.isDownloadOverStatus() == true) goto L5;
        return false;
    L5:
        if (isCompleteVisibility(r1.getNotificationVisibility()) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public void notifyByService(int r10, int r11, Notification r12) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L37;
        if (r10 == 0) goto L38;
        if (r12 != null) goto L8;
        return;
    L8:
        if (r11 != 4) goto L23;
        SparseArray<Long> r1 = this.PROGRESS_NOTIFY_LAST_TIME_INFO;
        monitor-enter(r1);
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(this.PROGRESS_NOTIFY_LAST_TIME_INFO.get(r10), Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L20
        if (r2 != null) goto L14;
    L17:
        this.PROGRESS_NOTIFY_LAST_TIME_INFO.put(r10, Long.valueOf(r3));     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        goto L23
    L14:
        if (Math.abs(r3 - r2.longValue()) >= 1000) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L23:
        Intent r9 = new Intent(r0, DownloadNotificationService.class);
        r9.setAction(NotificationConstants.ACTION_NOTIFICATION_NOTIFY);     // Catch: Throwable -> L30
        r9.putExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, r11);     // Catch: Throwable -> L30
        r9.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, r10);     // Catch: Throwable -> L30
        r9.putExtra(NotificationConstants.EXTRA_NOTIFICATION, r12);     // Catch: Throwable -> L30
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) <= 0) goto L28;
        DownloadNotificationServiceImpl.getInstance().handleIntent(r9);     // Catch: Throwable -> L30
        return;
    L28:
        ZeusTransformUtils.startService(r0, r9, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r10, "notifyByService", "Error:" + th);
        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_BACKGROUND_NOTIFICATION) == false) goto L39;
        DownloadNotificationServiceImpl.getInstance().handleIntent(r9);
        return;
    L39:
        return;
    L38:
        return;
    }

    public void cancel(int r5) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L19;
        if (r5 == 0) goto L21;
        Intent r1 = new Intent(r4, DownloadNotificationService.class);
        r1.setAction(NotificationConstants.ACTION_NOTIFICATION_CANCEL);     // Catch: Throwable -> L13
        r1.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, r5);     // Catch: Throwable -> L13
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) <= 0) goto L11;
        DownloadNotificationServiceImpl.getInstance().handleIntent(r1);     // Catch: Throwable -> L13
        return;
    L11:
        ZeusTransformUtils.startService(r4, r1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Logger.taskError(TAG, r5, "cancel", "Error:" + th);
        th.printStackTrace();
        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_BACKGROUND_NOTIFICATION) == false) goto L20;
        DownloadNotificationServiceImpl.getInstance().handleIntent(r1);
        return;
    L20:
        return;
    L21:
        return;
    }

    public void addNotification(AbsNotificationItem r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        SparseArray<AbsNotificationItem> r0 = this.notificationItemArray;
        monitor-enter(r0);
        this.notificationItemArray.put(r3.getId(), r3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public AbsNotificationItem removeNotification(int r5) {
        if (r5 != 0) goto L5;
        return null;
    L5:
        SparseArray<AbsNotificationItem> r0 = this.notificationItemArray;
        monitor-enter(r0);
        AbsNotificationItem r1 = (AbsNotificationItem) ZeusTransformUtils.preCheckCast(this.notificationItemArray.get(r5), AbsNotificationItem.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        this.notificationItemArray.remove(r5);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    }

    public AbsNotificationItem getNotificationItem(int r3) {
        if (r3 != 0) goto L5;
        return null;
    L5:
        SparseArray<AbsNotificationItem> r0 = this.notificationItemArray;
        monitor-enter(r0);
        AbsNotificationItem r2 = (AbsNotificationItem) ZeusTransformUtils.preCheckCast(this.notificationItemArray.get(r3), AbsNotificationItem.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        SparseArray<AbsNotificationItem> r0 = this.notificationItemArray;
        monitor-enter(r0);
        SparseArray<AbsNotificationItem> r1 = this.notificationItemArray;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void cancelNotification(int r1) {
        removeNotification(r1);
        if (r1 == 0) goto L6;
        DownloadNotificationManager.getInstance().cancel(r1);
        return;
    }

    public void clearNotification() {
        SparseArray<AbsNotificationItem> r0 = this.notificationItemArray;
        monitor-enter(r0);
        SparseArray<AbsNotificationItem> r1 = this.notificationItemArray.clone();     // Catch: Throwable -> L11
        this.notificationItemArray.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        int r4 = 0;
    L8:
        if (r4 >= r1.size()) goto L10;
        ((AbsNotificationItem) ZeusTransformUtils.preCheckCast(r1.get(r1.keyAt(r4)), AbsNotificationItem.class, "com.obric.aiagent.plugin")).cancel();
        r4 = r4 + 1;
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
