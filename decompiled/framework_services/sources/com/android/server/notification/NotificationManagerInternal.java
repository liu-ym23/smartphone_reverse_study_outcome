package com.android.server.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.backup.BackupRestoreEventLogger;
import android.service.notification.DeviceEffectsApplier;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface NotificationManagerInternal {
    void applyRestore(byte[] r1, int r2, BackupRestoreEventLogger r3);

    boolean areNotificationsEnabledForPackage(String r1, int r2);

    void cancelNotification(String r1, String r2, int r3, int r4, String r5, int r6, int r7);

    void cleanupHistoryFiles();

    void enqueueNotification(String r1, String r2, int r3, int r4, String r5, int r6, Notification r7, int r8);

    void enqueueNotification(String r1, String r2, int r3, int r4, String r5, int r6, Notification r7, int r8, boolean r9);

    byte[] getBackupPayload(int r1, BackupRestoreEventLogger r2);

    NotificationChannel getNotificationChannel(String r1, int r2, String r3);

    NotificationChannelGroup getNotificationChannelGroup(String r1, int r2, String r3);

    int getNumNotificationChannelsForPackage(String r1, int r2, boolean r3);

    boolean isNotificationShown(String r1, String r2, int r3, int r4);

    boolean isPkgAllNotificationSilent(String r1, int r2);

    void onConversationRemoved(String r1, int r2, Set<String> r3);

    void onDisplayRemoveSystemDecorations(int r1);

    void removeBitmaps();

    void removeForegroundServiceFlagFromNotification(String r1, int r2, int r3);

    void removeUserInitiatedJobFlagFromNotification(String r1, int r2, int r3);

    void sendReviewPermissionsNotification();

    void setDeviceEffectsApplier(DeviceEffectsApplier r1);
}
